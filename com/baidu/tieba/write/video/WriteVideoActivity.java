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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ad;
import com.baidu.tbadk.coreExtra.model.f;
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
import com.baidu.tieba.video.d;
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
    private final NewWriteModel.d evL;
    private NewWriteModel evx;
    private c hYP;
    private DialogInterface.OnCancelListener hqD;
    private e.a jKn;
    private e kTo;
    private String kiB;
    private a.InterfaceC0744a lJO;
    private l lJS;
    private int lVU;
    private FrsTabInfoData lVV;
    private String lVW;
    private List<VideoTitleData> lVX;
    private String mFrom;
    private String mFromForumId;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private VideoTitleData mVideoTitleData;
    private b mqW;
    private GestureDetector mqX;
    private int mqY;
    private VideoTitleData mra;
    private boolean mrb;
    private Runnable mrd;
    private Runnable mre;
    private final WriteData lvi = new WriteData();
    private Runnable mqZ = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String ici = "0";
    private boolean mrc = false;

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            this.lJS = (l) runTask.getData();
        }
        this.jKn = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tieba.k.e.a
            public void Al(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.mrb = true;
                    return;
                }
                ao aoVar = new ao("c12620");
                aoVar.ag("obj_locate", 0);
                TiebaStatic.log(aoVar);
            }

            @Override // com.baidu.tieba.k.e.a
            public void onChange(boolean z) {
            }

            @Override // com.baidu.tieba.k.e.a
            public void qG(boolean z) {
                WriteVideoActivity.this.mrb = true;
                ao aoVar = new ao("c12621");
                aoVar.ag("obj_locate", 0);
                aoVar.ag("obj_param1", z ? 1 : 0);
                TiebaStatic.log(aoVar);
            }
        };
        this.mrd = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (!f.bcM() || WriteVideoActivity.this.kTo == null || WriteVideoActivity.this.mrb) {
                    if (WriteVideoActivity.this.evx != null) {
                        WriteVideoActivity.this.evx.djn();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.f.e.lt().postDelayed(WriteVideoActivity.this.mrd, 100L);
            }
        };
        this.evL = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
                File file;
                WriteVideoActivity.this.closeLoadingDialog();
                if (postWriteCallBackData != null && WriteVideoActivity.this.lvi != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                    if (WriteVideoActivity.this.lvi != null && WriteVideoActivity.this.lvi.getVideoInfo() != null && writeData != null) {
                        if (!z2 && WriteVideoActivity.this.lvi.getVideoInfo().getVideoDuration() > 8) {
                            writeData.setVideoReviewType(1);
                        } else {
                            writeData.setVideoReviewType(2);
                        }
                    }
                    WriteVideoActivity.this.mqW.dsj();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                    if (z) {
                        if (WriteVideoActivity.this.lvi != null && WriteVideoActivity.this.lvi.getVideoInfo() != null) {
                            File file2 = new File(d.lUv);
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            if (z3 && WriteVideoActivity.this.lvi.getVideoInfo().getVideoType() == 1) {
                                String str = d.lUv + file.getName();
                                n.copyFile(new File(WriteVideoActivity.this.lvi.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
                                WriteVideoActivity.this.ba(BdBaseApplication.getInst(), str);
                            }
                            WriteVideoActivity.this.dsc();
                            n.deleteFileOrDir(new File(d.lUu));
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.lvi.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.i(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.mqW.j(postWriteCallBackData);
                    } else if ((adVar == null || writeData == null || adVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (adVar != null && writeData != null && adVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(adVar.getVcode_md5());
                        writeData.setVcodeUrl(adVar.getVcode_pic_url());
                        writeData.setVcodeExtra(adVar.bas());
                        if (com.baidu.tbadk.t.a.zq(adVar.bar())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, adVar.bar())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        };
        this.mre = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.hYP != null) {
                    WriteVideoActivity.this.hYP.setPercent(WriteVideoActivity.this.mqY);
                }
            }
        };
        this.lJO = new a.InterfaceC0744a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.14
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0744a
            public void EZ(int i) {
                WriteVideoActivity.this.mqY = i;
                com.baidu.adp.lib.f.e.lt().post(WriteVideoActivity.this.mre);
            }
        };
        this.hqD = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.det();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mqW = new b(this);
        setSwipeBackEnabled(false);
        drX();
        this.mqW.vQ(this.mrc);
        if (this.lvi.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.lVW)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.lVW;
                this.mqW.a(this.lvi.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.mqW.a(this.lvi.getVideoInfo(), this.mVideoTitleData, this.lVX);
            }
        }
        if (this.mqW.dsf() != null && !this.mrc) {
            this.mqW.dsf().d(this);
        }
        this.mqW.b(this.lVV);
        adjustResizeForSoftInput();
        this.mqX = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.mqW.dsh());
        this.mqW.dsh().requestFocus();
        TiebaStatic.log(new ao("c12307"));
        addGlobalLayoutListener();
        if (ac.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.kG().a(true, new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.7
                @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                    }
                }
            });
        }
        if (this.lvi.getVideoInfo() != null && !StringUtils.isNull(this.lvi.getVideoInfo().getVideoPath())) {
            Pc(this.lvi.getVideoInfo().getVideoPath());
        }
    }

    private void Pc(String str) {
        if (f.bcM()) {
            if (this.lJS != null) {
                this.kTo = this.lJS.Jf(str);
            }
            if (this.kTo != null) {
                this.kTo.a(this.jKn);
                this.kTo.cCq();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.f.e.lt().postDelayed(this.mqZ, 500L);
        if (this.mqW != null) {
            this.mqW.dnO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mqW != null) {
            this.mqW.caG();
        }
    }

    private void drX() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.lvi.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mFromForumId = intent.getStringExtra("forum_id");
            this.kiB = intent.getStringExtra("forum_name");
            this.lVU = intent.getIntExtra("pro_zone", -1);
            this.mFrom = intent.getStringExtra("from");
            this.lvi.setForumId(this.mFromForumId);
            this.lvi.setForumName(this.kiB);
            this.lvi.setProZone(this.lVU);
            this.lVW = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.lVX = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
                this.lVV = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
            }
            if (!StringUtils.isNull(this.kiB)) {
                this.mqW.Pf(this.kiB + getResources().getString(R.string.forum));
            } else {
                this.mqW.Pf(this.kiB);
            }
            this.ici = intent.getStringExtra("KEY_CALL_FROM");
            drY();
            if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
                this.mrc = true;
            }
        }
    }

    private void drY() {
        if (this.lvi != null && this.mqW != null && this.mqW.getCenterTitleView() != null) {
            TextView centerTitleView = this.mqW.getCenterTitleView();
            if (this.lvi.getProZone() == 1) {
                centerTitleView.setText(R.string.write_zone_profession_title);
            }
        }
    }

    private void drZ() {
        if (StringUtils.isNull(this.mFromForumId) || Long.parseLong(this.mFromForumId) <= 0 || StringUtils.isNull(this.kiB)) {
            this.lvi.setCanNoForum(true);
        } else {
            this.lvi.setCanNoForum(false);
        }
        this.lvi.setForumName(this.kiB);
        this.lvi.setTitle(this.mqW.getContent());
        this.lvi.setContent("");
        this.lvi.setType(0);
        if (this.mqW.dsi() != null) {
            if (this.mqW.dsi().getState() == 0) {
                this.lvi.setPrivacy(false);
            } else {
                this.lvi.setPrivacy(true);
            }
        }
        this.lvi.setToDynamic(this.mqW.isToDynamic());
        if (this.mqW.dsf() != null) {
            this.lvi.setHasLocationData(this.mqW.dsf().bKs());
        }
        this.lvi.setIsNoTitle(TextUtils.isEmpty(this.lvi.getTitle()));
    }

    private void dsa() {
        showLoadingDialog();
        com.baidu.tieba.write.b.a.a(this.lvi, new a.InterfaceC0764a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // com.baidu.tieba.write.b.a.InterfaceC0764a
            public void a(BaseUploadData baseUploadData) {
                com.baidu.tieba.write.b.c.b.drM().a((VideoUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9.1
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

            @Override // com.baidu.tieba.write.b.a.InterfaceC0764a
            public void onError() {
                WriteVideoActivity.this.closeLoadingDialog();
                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), (int) R.string.publish_dynamic_error);
            }
        }, this.lJO);
    }

    private void bfX() {
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.lvi.mDynamicVideoData = new VideoUploadData();
            dsa();
            return;
        }
        det();
        showLoadingDialog();
        this.mra = Pd(this.lvi != null ? this.lvi.getTitle() : "");
        if (this.evx == null) {
            this.evx = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.ici)) {
            this.lvi.setCallFrom(this.ici);
        }
        this.lvi.setPostLatLng(true);
        dsb();
        this.evx.d(this.lvi);
        this.evx.b(this.evL);
        this.evx.a(this.lJO);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.lvi.setLat(this.mLat);
            this.lvi.setLng(this.mLng);
            if (f.bcM() && this.kTo != null && !this.mrb) {
                com.baidu.adp.lib.f.e.lt().postDelayed(this.mrd, 100L);
            } else {
                this.evx.djn();
            }
        } else if (ac.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.kG().a(true, new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
                @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.lvi.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.lvi.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!f.bcM() || WriteVideoActivity.this.kTo == null || WriteVideoActivity.this.mrb) {
                        WriteVideoActivity.this.evx.djn();
                    } else {
                        com.baidu.adp.lib.f.e.lt().postDelayed(WriteVideoActivity.this.mrd, 100L);
                    }
                }
            });
        } else if (f.bcM() && this.kTo != null && !this.mrb) {
            com.baidu.adp.lib.f.e.lt().postDelayed(this.mrd, 100L);
        } else {
            this.evx.djn();
        }
    }

    private void dsb() {
        FrsTabItemData selectedTabItemData;
        if (this.lvi != null && this.mqW != null && this.mqW.dsd() != null && (selectedTabItemData = this.mqW.dsd().getSelectedTabItemData()) != null) {
            this.lvi.setTabId(selectedTabItemData.tabId);
            this.lvi.setTabName(selectedTabItemData.name);
            this.lvi.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    new x(context).saveVideo(str);
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
    public void dsc() {
        VideoInfo videoInfo;
        if (this.lvi != null && (videoInfo = this.lvi.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(d.lUu)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true)) {
                        n.copyFile(file.getAbsolutePath(), d.lUv + file.getName());
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
            if (AntiHelper.bA(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
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
        this.hYP = new c(getPageContext().getPageActivity());
        this.hYP.setOnCancelListener(this.hqD);
        this.hYP.setCancelable(true);
        this.hYP.setCanceledOnTouchOutside(false);
        g.showDialog(this.hYP, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        det();
        destroyWaitingDialog();
        this.hqD = null;
        closeLoadingDialog();
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.mre);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.hYP = null;
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
                if (this.mqW.dsk() != null) {
                    this.mqW.dsk().aY(postWriteCallBackData.getSensitiveWords());
                    if (!w.isEmpty(this.mqW.dsk().dqI())) {
                        this.mqW.vR(true);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(PostWriteCallBackData postWriteCallBackData) {
        com.baidu.tbadk.util.ad.a(new com.baidu.tbadk.util.ac<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: bpB */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.lvi != null && WriteVideoActivity.this.lvi.getVideoInfo() != null && WriteVideoActivity.this.lvi.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.lvi.getVideoInfo().getVideoPath().contains(d.lUu) && (file = new File(WriteVideoActivity.this.lvi.getVideoInfo().getVideoPath())) != null) {
                    n.copyFile(file.getAbsolutePath(), d.lUv + file.getName());
                }
                n.deleteFileOrDir(new File(d.lUu));
                return null;
            }
        }, new com.baidu.tbadk.util.l<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: a */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.lVW)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.kiB)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.mra;
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
        this.mqW.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mqW != null) {
            this.mqW.caG();
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.mqZ);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.mrd);
    }

    protected void det() {
        if (this.evx != null) {
            this.evx.cancelLoadData();
        }
        if (this.mqW.dsf() != null) {
            this.mqW.dsf().det();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hYP != null && this.hYP.isShowing()) {
                g.b(this.hYP, getPageContext());
                return true;
            }
            cbW();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cbW() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.kT(R.string.give_up_video_confirm);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.det();
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
        aVar.b(getPageContext()).aUN();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mqW.dsg()) {
            if (b.mrh - this.mqW.dse() < 0) {
                showToast(getResources().getString(R.string.video_content_overflow));
            } else if (this.mqW.dsk() != null && this.mqW.dsk().dqK()) {
                showToast(this.mqW.dsk().dqM());
                this.mqW.vR(true);
            } else {
                drZ();
                bfX();
            }
        } else if (view == this.mqW.getBackButton()) {
            cbW();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.hYP != null) {
            if (this.hYP.isShowing()) {
                g.b(this.hYP, getPageContext());
            }
            this.hYP = null;
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
        if (this.mqX.onTouchEvent(motionEvent)) {
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
        this.mqW.vS(z);
    }

    public VideoTitleData Pd(String str) {
        if (!StringUtils.isNull(str) && !w.isEmpty(this.lVX)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.lVX.size()) {
                        break;
                    } else if (this.lVX.get(i2) == null || !group.equals(this.lVX.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.lVX.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
