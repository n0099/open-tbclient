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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.coreExtra.model.g;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.l.e;
import com.baidu.tieba.l.l;
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
/* loaded from: classes3.dex */
public class WriteVideoActivity extends BaseActivity<WriteVideoActivity> {
    private final NewWriteModel.d fwI;
    private NewWriteModel fwu;
    private DialogInterface.OnCancelListener iJO;
    private c jwa;
    private String lLE;
    private e.a lmh;
    private String mFrom;
    private String mFromForumId;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private VideoTitleData mVideoTitleData;
    private FrsTabInfoData nCA;
    private String nCB;
    private List<VideoTitleData> nCC;
    private int nCz;
    private b nZb;
    private GestureDetector nZc;
    private int nZd;
    private VideoTitleData nZf;
    private e nZg;
    private boolean nZh;
    private Runnable nZj;
    private Runnable nZk;
    private a.InterfaceC0869a npX;
    private l nqb;
    private final WriteData nbe = new WriteData();
    private Runnable nZe = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String jzs = "0";
    private boolean nZi = false;

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            this.nqb = (l) runTask.getData();
        }
        this.lmh = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tieba.l.e.a
            public void Gd(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.nZh = true;
                    return;
                }
                ar arVar = new ar("c12620");
                arVar.al("obj_locate", 0);
                TiebaStatic.log(arVar);
            }

            @Override // com.baidu.tieba.l.e.a
            public void onChange(boolean z) {
            }

            @Override // com.baidu.tieba.l.e.a
            public void tP(boolean z) {
                WriteVideoActivity.this.nZh = true;
                ar arVar = new ar("c12621");
                arVar.al("obj_locate", 0);
                arVar.al("obj_param1", z ? 1 : 0);
                TiebaStatic.log(arVar);
            }
        };
        this.nZj = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (!g.bAe() || WriteVideoActivity.this.nZg == null || WriteVideoActivity.this.nZh) {
                    if (WriteVideoActivity.this.fwu != null) {
                        WriteVideoActivity.this.fwu.dQE();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(WriteVideoActivity.this.nZj, 100L);
            }
        };
        this.fwI = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                WriteVideoActivity.this.closeLoadingDialog();
                if (postWriteCallBackData != null && WriteVideoActivity.this.nbe != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                    if (WriteVideoActivity.this.nbe != null && WriteVideoActivity.this.nbe.getVideoInfo() != null && writeData != null) {
                        if (!z2 && WriteVideoActivity.this.nbe.getVideoInfo().getVideoDuration() > 8) {
                            writeData.setVideoReviewType(1);
                        } else {
                            writeData.setVideoReviewType(2);
                        }
                    }
                    WriteVideoActivity.this.nZb.dZN();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                    if (z) {
                        if (WriteVideoActivity.this.nbe != null && WriteVideoActivity.this.nbe.getVideoInfo() != null) {
                            WriteVideoActivity.this.zn(z3);
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.nbe.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.k(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.nZb.l(postWriteCallBackData);
                    } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(ahVar.getVcode_md5());
                        writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                        writeData.setVcodeExtra(ahVar.bxM());
                        if (com.baidu.tbadk.t.a.ES(ahVar.bxL())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bxL())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        };
        this.nZk = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.jwa != null) {
                    WriteVideoActivity.this.jwa.setPercent(WriteVideoActivity.this.nZd);
                }
            }
        };
        this.npX = new a.InterfaceC0869a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.14
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0869a
            public void KY(int i) {
                WriteVideoActivity.this.nZd = i;
                com.baidu.adp.lib.f.e.mY().post(WriteVideoActivity.this.nZk);
            }
        };
        this.iJO = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.dLy();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nZb = new b(this);
        setSwipeBackEnabled(false);
        dZB();
        this.nZb.zo(this.nZi);
        if (this.nbe.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.nCB)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.nCB;
                this.nZb.a(this.nbe.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.nZb.a(this.nbe.getVideoInfo(), this.mVideoTitleData, this.nCC);
            }
        }
        if (this.nZb.dZJ() != null && !this.nZi) {
            this.nZb.dZJ().f(this);
        }
        this.nZb.c(this.nCA);
        adjustResizeForSoftInput();
        this.nZc = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.nZb.dZL());
        this.nZb.dZL().requestFocus();
        TiebaStatic.log(new ar("c12307"));
        addGlobalLayoutListener();
        if (ae.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.mk().a(true, new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.7
                @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                    }
                }
            });
        }
        if (this.nbe.getVideoInfo() != null && !StringUtils.isNull(this.nbe.getVideoInfo().getVideoPath())) {
            VQ(this.nbe.getVideoInfo().getVideoPath());
        }
    }

    private void VQ(String str) {
        if (g.bAe()) {
            if (this.nqb != null) {
                this.nZg = this.nqb.Pt(str);
            }
            if (this.nZg != null) {
                this.nZg.a(this.lmh);
                this.nZg.diK();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.f.e.mY().postDelayed(this.nZe, 500L);
        if (this.nZb != null) {
            this.nZb.dVq();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.nZb != null) {
            this.nZb.cEW();
        }
    }

    private void dZB() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.nbe.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mFromForumId = intent.getStringExtra("forum_id");
            this.lLE = intent.getStringExtra("forum_name");
            this.nCz = intent.getIntExtra("pro_zone", -1);
            this.mFrom = intent.getStringExtra("from");
            this.nbe.setForumId(this.mFromForumId);
            this.nbe.setForumName(this.lLE);
            this.nbe.setProZone(this.nCz);
            this.nCB = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.nCC = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
                this.nCA = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
            }
            if (!StringUtils.isNull(this.lLE)) {
                this.nZb.VT(this.lLE + getResources().getString(R.string.forum));
            } else {
                this.nZb.VT(this.lLE);
            }
            this.jzs = intent.getStringExtra("KEY_CALL_FROM");
            dZC();
            if (AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
                this.nZi = true;
            }
        }
    }

    private void dZC() {
        if (this.nbe != null && this.nZb != null && this.nZb.getCenterTitleView() != null) {
            TextView centerTitleView = this.nZb.getCenterTitleView();
            if (this.nbe.getProZone() == 1) {
                centerTitleView.setText(R.string.write_zone_profession_title);
            }
        }
    }

    private void dZD() {
        if (StringUtils.isNull(this.mFromForumId) || Long.parseLong(this.mFromForumId) <= 0 || StringUtils.isNull(this.lLE)) {
            this.nbe.setCanNoForum(true);
        } else {
            this.nbe.setCanNoForum(false);
        }
        this.nbe.setForumName(this.lLE);
        this.nbe.setTitle(this.nZb.getContent());
        this.nbe.setContent("");
        this.nbe.setType(0);
        if (this.nZb.dZM() != null) {
            if (this.nZb.dZM().getState() == 0) {
                this.nbe.setPrivacy(false);
            } else {
                this.nbe.setPrivacy(true);
            }
        }
        this.nbe.setToDynamic(this.nZb.isToDynamic());
        if (this.nZb.dZJ() != null) {
            this.nbe.setHasLocationData(this.nZb.dZJ().clC());
        }
        this.nbe.setIsNoTitle(TextUtils.isEmpty(this.nbe.getTitle()));
    }

    private void dZE() {
        showLoadingDialog();
        com.baidu.tieba.write.b.a.a(this.nbe, new a.InterfaceC0892a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // com.baidu.tieba.write.b.a.InterfaceC0892a
            public void a(BaseUploadData baseUploadData) {
                com.baidu.tieba.write.b.c.b.dZn().a((VideoUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9.1
                    @Override // com.baidu.tieba.write.b.c.b.a
                    public void onSuccess(String str) {
                        WriteVideoActivity.this.zn(com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true));
                        WriteVideoActivity.this.closeLoadingDialog();
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData();
                        postWriteCallBackData.setDyamicCallback(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS, postWriteCallBackData));
                        WriteVideoActivity.this.finish();
                        if (postWriteCallBackData.mFrom != 2 || postWriteCallBackData.getIconStampData() == null) {
                            com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.publish_dynamic_success);
                        }
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

            @Override // com.baidu.tieba.write.b.a.InterfaceC0892a
            public void onError() {
                WriteVideoActivity.this.closeLoadingDialog();
                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.publish_dynamic_error);
            }
        }, this.npX);
    }

    private void bDr() {
        if (AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.nbe.mDynamicVideoData = new VideoUploadData();
            dZE();
            return;
        }
        dLy();
        showLoadingDialog();
        this.nZf = VR(this.nbe != null ? this.nbe.getTitle() : "");
        if (this.fwu == null) {
            this.fwu = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.jzs)) {
            this.nbe.setCallFrom(this.jzs);
        }
        this.nbe.setPostLatLng(true);
        dZF();
        this.fwu.e(this.nbe);
        this.fwu.b(this.fwI);
        this.fwu.a(this.npX);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.nbe.setLat(this.mLat);
            this.nbe.setLng(this.mLng);
            if (g.bAe() && this.nZg != null && !this.nZh) {
                com.baidu.adp.lib.f.e.mY().postDelayed(this.nZj, 100L);
            } else {
                this.fwu.dQE();
            }
        } else if (ae.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.mk().a(true, new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
                @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.nbe.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.nbe.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!g.bAe() || WriteVideoActivity.this.nZg == null || WriteVideoActivity.this.nZh) {
                        WriteVideoActivity.this.fwu.dQE();
                    } else {
                        com.baidu.adp.lib.f.e.mY().postDelayed(WriteVideoActivity.this.nZj, 100L);
                    }
                }
            });
        } else if (g.bAe() && this.nZg != null && !this.nZh) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.nZj, 100L);
        } else {
            this.fwu.dQE();
        }
    }

    private void dZF() {
        FrsTabItemData selectedTabItemData;
        if (this.nbe != null && this.nZb != null && this.nZb.dZH() != null && (selectedTabItemData = this.nZb.dZH().getSelectedTabItemData()) != null) {
            this.nbe.setTabId(selectedTabItemData.tabId);
            this.nbe.setTabName(selectedTabItemData.name);
            this.nbe.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    private void bq(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    new z(context).saveVideo(str);
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
    public void zn(boolean z) {
        File file;
        File file2 = new File(com.baidu.tieba.video.c.nBa);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        if (z && this.nbe.getVideoInfo().getVideoType() == 1) {
            String str = com.baidu.tieba.video.c.nBa + file.getName();
            n.copyFile(new File(this.nbe.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
            bq(BdBaseApplication.getInst(), str);
        }
        dZG();
        n.deleteFileOrDir(new File(com.baidu.tieba.video.c.nAZ));
    }

    private void dZG() {
        VideoInfo videoInfo;
        if (this.nbe != null && (videoInfo = this.nbe.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.c.nAZ)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true)) {
                        n.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.nBa + file.getName());
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
            if (AntiHelper.bP(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.bn(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString);
            } else {
                com.baidu.tieba.tbadkCore.writeModel.c.h(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    public void showLoadingDialog() {
        this.jwa = new c(getPageContext().getPageActivity());
        this.jwa.setOnCancelListener(this.iJO);
        this.jwa.setCancelable(true);
        this.jwa.setCanceledOnTouchOutside(false);
        com.baidu.adp.lib.f.g.showDialog(this.jwa, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        dLy();
        destroyWaitingDialog();
        this.iJO = null;
        closeLoadingDialog();
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.nZk);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.jwa = null;
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
                    k(postWriteCallBackData2);
                }
            } else if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                showToast(postWriteCallBackData.getErrorString());
                if (this.nZb.dZO() != null) {
                    this.nZb.dZO().bn(postWriteCallBackData.getSensitiveWords());
                    if (!y.isEmpty(this.nZb.dZO().dYn())) {
                        this.nZb.zp(true);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PostWriteCallBackData postWriteCallBackData) {
        ad.a(new ac<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: bMU */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.nbe != null && WriteVideoActivity.this.nbe.getVideoInfo() != null && WriteVideoActivity.this.nbe.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.nbe.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.c.nAZ) && (file = new File(WriteVideoActivity.this.nbe.getVideoInfo().getVideoPath())) != null) {
                    n.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.nBa + file.getName());
                }
                n.deleteFileOrDir(new File(com.baidu.tieba.video.c.nAZ));
                return null;
            }
        }, new m<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: a */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.nCB)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.lLE)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.nZf;
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
        this.nZb.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nZb != null) {
            this.nZb.cEW();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.nZe);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.nZj);
    }

    protected void dLy() {
        if (this.fwu != null) {
            this.fwu.cancelLoadData();
        }
        if (this.nZb.dZJ() != null) {
            this.nZb.dZJ().dLy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.jwa != null && this.jwa.isShowing()) {
                com.baidu.adp.lib.f.g.b(this.jwa, getPageContext());
                return true;
            }
            cGr();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cGr() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.oQ(R.string.give_up_video_confirm);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.dLy();
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
        aVar.b(getPageContext()).brv();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nZb.dZK()) {
            if (b.nZn - this.nZb.dZI() < 0) {
                showToast(getResources().getString(R.string.video_content_overflow));
            } else if (this.nZb.dZO() != null && this.nZb.dZO().dYp()) {
                showToast(this.nZb.dZO().dYr());
                this.nZb.zp(true);
            } else {
                dZD();
                bDr();
            }
        } else if (view == this.nZb.getBackButton()) {
            cGr();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.jwa != null) {
            if (this.jwa.isShowing()) {
                com.baidu.adp.lib.f.g.b(this.jwa, getPageContext());
            }
            this.jwa = null;
        }
    }

    /* loaded from: classes3.dex */
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
        if (this.nZc.onTouchEvent(motionEvent)) {
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
        this.nZb.zq(z);
    }

    public VideoTitleData VR(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.nCC)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.nCC.size()) {
                        break;
                    } else if (this.nCC.get(i2) == null || !group.equals(this.nCC.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.nCC.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
