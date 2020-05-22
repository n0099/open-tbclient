package com.baidu.tieba.write.video;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.c.a;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.MotuVideoConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.coreExtra.model.f;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.k.e;
import com.baidu.tieba.k.l;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.write.b.a;
import com.baidu.tieba.write.b.c.b;
import com.baidu.tieba.write.upload.BaseUploadData;
import com.baidu.tieba.write.upload.VideoUploadData;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class WriteVideoActivity extends BaseActivity<WriteVideoActivity> {
    private NewWriteModel emH;
    private final NewWriteModel.d emV;
    private c hKQ;
    private DialogInterface.OnCancelListener heh;
    private String jNH;
    private e.a jrQ;
    private e kyl;
    private int lBf;
    private FrsTabInfoData lBg;
    private String lBh;
    private List<VideoTitleData> lBi;
    private b lVr;
    private GestureDetector lVs;
    private int lVt;
    private VideoTitleData lVv;
    private boolean lVw;
    private Runnable lVy;
    private Runnable lVz;
    private a.InterfaceC0727a loU;
    private l loY;
    private String mFrom;
    private String mFromForumId;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private VideoTitleData mVideoTitleData;
    private final WriteData lab = new WriteData();
    private Runnable lVu = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String hOj = "0";
    private boolean lVx = false;

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            this.loY = (l) runTask.getData();
        }
        this.jrQ = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tieba.k.e.a
            public void zx(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.lVw = true;
                    return;
                }
                an anVar = new an("c12620");
                anVar.ag("obj_locate", 0);
                TiebaStatic.log(anVar);
            }

            @Override // com.baidu.tieba.k.e.a
            public void onChange(boolean z) {
            }

            @Override // com.baidu.tieba.k.e.a
            public void qw(boolean z) {
                WriteVideoActivity.this.lVw = true;
                an anVar = new an("c12621");
                anVar.ag("obj_locate", 0);
                anVar.ag("obj_param1", z ? 1 : 0);
                TiebaStatic.log(anVar);
            }
        };
        this.lVy = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (!f.baJ() || WriteVideoActivity.this.kyl == null || WriteVideoActivity.this.lVw) {
                    if (WriteVideoActivity.this.emH != null) {
                        WriteVideoActivity.this.emH.deN();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.f.e.ld().postDelayed(WriteVideoActivity.this.lVy, 100L);
            }
        };
        this.emV = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                File file;
                WriteVideoActivity.this.closeLoadingDialog();
                if (postWriteCallBackData != null && WriteVideoActivity.this.lab != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                    if (WriteVideoActivity.this.lab != null && WriteVideoActivity.this.lab.getVideoInfo() != null && writeData != null) {
                        if (!z2 && WriteVideoActivity.this.lab.getVideoInfo().getVideoDuration() > 8) {
                            writeData.setVideoReviewType(1);
                        } else {
                            writeData.setVideoReviewType(2);
                        }
                    }
                    WriteVideoActivity.this.lVr.dnI();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                    if (z) {
                        if (WriteVideoActivity.this.lab != null && WriteVideoActivity.this.lab.getVideoInfo() != null) {
                            File file2 = new File(com.baidu.tieba.video.c.lzG);
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            if (z3 && WriteVideoActivity.this.lab.getVideoInfo().getVideoType() == 1) {
                                String str = com.baidu.tieba.video.c.lzG + file.getName();
                                m.copyFile(new File(WriteVideoActivity.this.lab.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
                                WriteVideoActivity.this.ba(BdBaseApplication.getInst(), str);
                            }
                            WriteVideoActivity.this.dnA();
                            m.deleteFileOrDir(new File(com.baidu.tieba.video.c.lzF));
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.lab.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.i(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.lVr.j(postWriteCallBackData);
                    } else if ((aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (aaVar != null && writeData != null && aaVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(aaVar.getVcode_md5());
                        writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                        writeData.setVcodeExtra(aaVar.aYm());
                        if (com.baidu.tbadk.s.a.yX(aaVar.aYl())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aYl())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        };
        this.lVz = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.hKQ != null) {
                    WriteVideoActivity.this.hKQ.setPercent(WriteVideoActivity.this.lVt);
                }
            }
        };
        this.loU = new a.InterfaceC0727a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.14
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0727a
            public void DV(int i) {
                WriteVideoActivity.this.lVt = i;
                com.baidu.adp.lib.f.e.ld().post(WriteVideoActivity.this.lVz);
            }
        };
        this.heh = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.cZN();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lVr = new b(this);
        setSwipeBackEnabled(false);
        dnv();
        this.lVr.vv(this.lVx);
        if (this.lab.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.lBh)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.lBh;
                this.lVr.a(this.lab.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.lVr.a(this.lab.getVideoInfo(), this.mVideoTitleData, this.lBi);
            }
        }
        if (this.lVr.dnE() != null && !this.lVx) {
            this.lVr.dnE().d(this);
        }
        this.lVr.b(this.lBg);
        adjustResizeForSoftInput();
        this.lVs = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.lVr.dnG());
        this.lVr.dnG().requestFocus();
        TiebaStatic.log(new an("c12307"));
        addGlobalLayoutListener();
        if (ab.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.kq().a(true, new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.7
                @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                    }
                }
            });
        }
        if (this.lab.getVideoInfo() != null && !StringUtils.isNull(this.lab.getVideoInfo().getVideoPath())) {
            Ou(this.lab.getVideoInfo().getVideoPath());
        }
    }

    private void Ou(String str) {
        if (f.baJ()) {
            if (this.loY != null) {
                this.kyl = this.loY.IC(str);
            }
            if (this.kyl != null) {
                this.kyl.a(this.jrQ);
                this.kyl.cyc();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.f.e.ld().postDelayed(this.lVu, 500L);
        if (this.lVr != null) {
            this.lVr.djn();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.lVr != null) {
            this.lVr.bXt();
        }
    }

    private void dnv() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.lab.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mFromForumId = intent.getStringExtra("forum_id");
            this.jNH = intent.getStringExtra("forum_name");
            this.lBf = intent.getIntExtra("pro_zone", -1);
            this.mFrom = intent.getStringExtra("from");
            this.lab.setForumId(this.mFromForumId);
            this.lab.setForumName(this.jNH);
            this.lab.setProZone(this.lBf);
            this.lBh = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.lBi = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
                this.lBg = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
            }
            if (!StringUtils.isNull(this.jNH)) {
                this.lVr.Ox(this.jNH + getResources().getString(R.string.forum));
            } else {
                this.lVr.Ox(this.jNH);
            }
            this.hOj = intent.getStringExtra("KEY_CALL_FROM");
            dnw();
            if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
                this.lVx = true;
            }
        }
    }

    private void dnw() {
        if (this.lab != null && this.lVr != null && this.lVr.getCenterTitleView() != null) {
            TextView centerTitleView = this.lVr.getCenterTitleView();
            if (this.lab.getProZone() == 1) {
                centerTitleView.setText(R.string.write_zone_profession_title);
            }
        }
    }

    private void dnx() {
        if (StringUtils.isNull(this.mFromForumId) || Long.parseLong(this.mFromForumId) <= 0 || StringUtils.isNull(this.jNH)) {
            this.lab.setCanNoForum(true);
        } else {
            this.lab.setCanNoForum(false);
        }
        this.lab.setForumName(this.jNH);
        this.lab.setTitle(this.lVr.getContent());
        this.lab.setContent("");
        this.lab.setType(0);
        if (this.lVr.dnH() != null) {
            if (this.lVr.dnH().getState() == 0) {
                this.lab.setPrivacy(false);
            } else {
                this.lab.setPrivacy(true);
            }
        }
        this.lab.setToDynamic(this.lVr.isToDynamic());
        if (this.lVr.dnE() != null) {
            this.lab.setHasLocationData(this.lVr.dnE().bHm());
        }
        this.lab.setIsNoTitle(TextUtils.isEmpty(this.lab.getTitle()));
    }

    private void dny() {
        showLoadingDialog();
        com.baidu.tieba.write.b.a.a(this.lab, new a.InterfaceC0748a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // com.baidu.tieba.write.b.a.InterfaceC0748a
            public void a(BaseUploadData baseUploadData) {
                com.baidu.tieba.write.b.c.b.dnj().a((VideoUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9.1
                    @Override // com.baidu.tieba.write.b.c.b.a
                    public void onSuccess(String str) {
                        WriteVideoActivity.this.closeLoadingDialog();
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData();
                        postWriteCallBackData.setDyamicCallback(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS, postWriteCallBackData));
                        WriteVideoActivity.this.finish();
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), (int) R.string.publish_dynamic_success);
                    }

                    @Override // com.baidu.tieba.write.b.c.b.a
                    public void onFail(String str) {
                        WriteVideoActivity.this.closeLoadingDialog();
                        if (TextUtils.isEmpty(str)) {
                            str = TbadkCoreApplication.getInst().getString(R.string.publish_dynamic_error);
                        }
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), str);
                    }
                });
            }

            @Override // com.baidu.tieba.write.b.a.InterfaceC0748a
            public void onError() {
                WriteVideoActivity.this.closeLoadingDialog();
                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), (int) R.string.publish_dynamic_error);
            }
        }, this.loU);
    }

    private void bdR() {
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.lab.mDynamicVideoData = new VideoUploadData();
            dny();
            return;
        }
        cZN();
        showLoadingDialog();
        this.lVv = Ov(this.lab != null ? this.lab.getTitle() : "");
        if (this.emH == null) {
            this.emH = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.hOj)) {
            this.lab.setCallFrom(this.hOj);
        }
        this.lab.setPostLatLng(true);
        dnz();
        this.emH.d(this.lab);
        this.emH.b(this.emV);
        this.emH.a(this.loU);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.lab.setLat(this.mLat);
            this.lab.setLng(this.mLng);
            if (f.baJ() && this.kyl != null && !this.lVw) {
                com.baidu.adp.lib.f.e.ld().postDelayed(this.lVy, 100L);
            } else {
                this.emH.deN();
            }
        } else if (ab.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.kq().a(true, new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
                @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.lab.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.lab.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!f.baJ() || WriteVideoActivity.this.kyl == null || WriteVideoActivity.this.lVw) {
                        WriteVideoActivity.this.emH.deN();
                    } else {
                        com.baidu.adp.lib.f.e.ld().postDelayed(WriteVideoActivity.this.lVy, 100L);
                    }
                }
            });
        } else if (f.baJ() && this.kyl != null && !this.lVw) {
            com.baidu.adp.lib.f.e.ld().postDelayed(this.lVy, 100L);
        } else {
            this.emH.deN();
        }
    }

    private void dnz() {
        FrsTabItemData selectedTabItemData;
        if (this.lab != null && this.lVr != null && this.lVr.dnC() != null && (selectedTabItemData = this.lVr.dnC().getSelectedTabItemData()) != null) {
            this.lab.setTabId(selectedTabItemData.tabId);
            this.lab.setTabName(selectedTabItemData.name);
            this.lab.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    new w(context).saveVideo(str);
                    Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                    intent.setData(Uri.fromFile(new File(str)));
                    context.sendBroadcast(intent);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnA() {
        VideoInfo videoInfo;
        if (this.lab != null && (videoInfo = this.lab.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.c.lzF)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true)) {
                        m.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.lzG + file.getName());
                    } else {
                        file.delete();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            postWriteCallBackData.getErrorString();
            if (AntiHelper.bv(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aX(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString);
            } else {
                com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    public void showLoadingDialog() {
        this.hKQ = new c(getPageContext().getPageActivity());
        this.hKQ.setOnCancelListener(this.heh);
        this.hKQ.setCancelable(true);
        this.hKQ.setCanceledOnTouchOutside(false);
        g.showDialog(this.hKQ, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        cZN();
        destroyWaitingDialog();
        this.heh = null;
        closeLoadingDialog();
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.lVz);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.hKQ = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        PostWriteCallBackData postWriteCallBackData;
        super.onActivityResult(i, i2, intent);
        if (i == 12006) {
            if (i2 == -1) {
                PostWriteCallBackData postWriteCallBackData2 = null;
                if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) {
                    postWriteCallBackData2 = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                }
                if (postWriteCallBackData2 != null) {
                    i(postWriteCallBackData2);
                }
            } else if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                showToast(postWriteCallBackData.getErrorString());
                if (this.lVr.dnJ() != null) {
                    this.lVr.dnJ().aX(postWriteCallBackData.getSensitiveWords());
                    if (!v.isEmpty(this.lVr.dnJ().dmg())) {
                        this.lVr.vw(true);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(PostWriteCallBackData postWriteCallBackData) {
        ad.a(new ac<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: bmZ */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.lab != null && WriteVideoActivity.this.lab.getVideoInfo() != null && WriteVideoActivity.this.lab.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.lab.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.c.lzF) && (file = new File(WriteVideoActivity.this.lab.getVideoInfo().getVideoPath())) != null) {
                    m.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.lzG + file.getName());
                }
                m.deleteFileOrDir(new File(com.baidu.tieba.video.c.lzF));
                return null;
            }
        }, new com.baidu.tbadk.util.l<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: a */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.lBh)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.jNH)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.lVv;
        if (postWriteCallBackData.mFrom == 3 && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.buildVideoFakeOnWallUrl())) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FINISH_THIS_PAGE));
            com.baidu.tbadk.browser.a.startWebActivity(this, (String) null, postWriteCallBackData.buildVideoFakeOnWallUrl());
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS, postWriteCallBackData));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.lVr.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lVr != null) {
            this.lVr.bXt();
        }
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.lVu);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.lVy);
    }

    protected void cZN() {
        if (this.emH != null) {
            this.emH.cancelLoadData();
        }
        if (this.lVr.dnE() != null) {
            this.lVr.dnE().cZN();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hKQ != null && this.hKQ.isShowing()) {
                g.b(this.hKQ, getPageContext());
                return true;
            }
            dnB();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void dnB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.kD(R.string.give_up_video_confirm);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.cZN();
                TiebaStatic.log("c10800");
                WriteVideoActivity.this.finish();
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).aST();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lVr.dnF()) {
            if (b.lVC - this.lVr.dnD() < 0) {
                showToast(getResources().getString(R.string.video_content_overflow));
            } else if (this.lVr.dnJ() != null && this.lVr.dnJ().dmi()) {
                showToast(this.lVr.dnJ().dmk());
                this.lVr.vw(true);
            } else {
                dnx();
                bdR();
            }
        } else if (view == this.lVr.getBackButton()) {
            dnB();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.hKQ != null) {
            if (this.hKQ.isShowing()) {
                g.b(this.hKQ, getPageContext());
            }
            this.hKQ = null;
        }
    }

    /* loaded from: classes2.dex */
    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            com.baidu.adp.lib.util.l.hideSoftKeyPad(WriteVideoActivity.this.getActivity(), WriteVideoActivity.this.getCurrentFocus());
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.lVs.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.lVr.vx(z);
    }

    public VideoTitleData Ov(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.lBi)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.lBi.size()) {
                        break;
                    } else if (this.lBi.get(i2) == null || !group.equals(this.lBi.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.lBi.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
