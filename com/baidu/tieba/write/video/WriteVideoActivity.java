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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.coreExtra.model.g;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.m;
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
/* loaded from: classes3.dex */
public class WriteVideoActivity extends BaseActivity<WriteVideoActivity> {
    private NewWriteModel fpI;
    private final NewWriteModel.d fpW;
    private DialogInterface.OnCancelListener iyf;
    private c jhK;
    private e.a kYu;
    private String lxy;
    private String mFrom;
    private String mFromForumId;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private VideoTitleData mVideoTitleData;
    private Runnable nJA;
    private Runnable nJB;
    private b nJs;
    private GestureDetector nJt;
    private int nJu;
    private VideoTitleData nJw;
    private e nJx;
    private boolean nJy;
    private a.InterfaceC0852a naR;
    private l naV;
    private int nnn;
    private FrsTabInfoData nno;
    private String nnp;
    private List<VideoTitleData> nnq;
    private final WriteData mMg = new WriteData();
    private Runnable nJv = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String jld = "0";
    private boolean nJz = false;

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            this.naV = (l) runTask.getData();
        }
        this.kYu = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tieba.k.e.a
            public void EQ(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.nJy = true;
                    return;
                }
                aq aqVar = new aq("c12620");
                aqVar.al("obj_locate", 0);
                TiebaStatic.log(aqVar);
            }

            @Override // com.baidu.tieba.k.e.a
            public void onChange(boolean z) {
            }

            @Override // com.baidu.tieba.k.e.a
            public void tk(boolean z) {
                WriteVideoActivity.this.nJy = true;
                aq aqVar = new aq("c12621");
                aqVar.al("obj_locate", 0);
                aqVar.al("obj_param1", z ? 1 : 0);
                TiebaStatic.log(aqVar);
            }
        };
        this.nJA = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (!g.bxo() || WriteVideoActivity.this.nJx == null || WriteVideoActivity.this.nJy) {
                    if (WriteVideoActivity.this.fpI != null) {
                        WriteVideoActivity.this.fpI.dLm();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(WriteVideoActivity.this.nJA, 100L);
            }
        };
        this.fpW = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                WriteVideoActivity.this.closeLoadingDialog();
                if (postWriteCallBackData != null && WriteVideoActivity.this.mMg != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                    if (WriteVideoActivity.this.mMg != null && WriteVideoActivity.this.mMg.getVideoInfo() != null && writeData != null) {
                        if (!z2 && WriteVideoActivity.this.mMg.getVideoInfo().getVideoDuration() > 8) {
                            writeData.setVideoReviewType(1);
                        } else {
                            writeData.setVideoReviewType(2);
                        }
                    }
                    WriteVideoActivity.this.nJs.dUt();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                    if (z) {
                        if (WriteVideoActivity.this.mMg != null && WriteVideoActivity.this.mMg.getVideoInfo() != null) {
                            WriteVideoActivity.this.yB(z3);
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.mMg.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.k(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.nJs.l(postWriteCallBackData);
                    } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(ahVar.getVcode_md5());
                        writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                        writeData.setVcodeExtra(ahVar.buW());
                        if (com.baidu.tbadk.t.a.EE(ahVar.buV())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.buV())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        };
        this.nJB = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.jhK != null) {
                    WriteVideoActivity.this.jhK.setPercent(WriteVideoActivity.this.nJu);
                }
            }
        };
        this.naR = new a.InterfaceC0852a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.14
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0852a
            public void JG(int i) {
                WriteVideoActivity.this.nJu = i;
                com.baidu.adp.lib.f.e.mY().post(WriteVideoActivity.this.nJB);
            }
        };
        this.iyf = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.dGs();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nJs = new b(this);
        setSwipeBackEnabled(false);
        dUh();
        this.nJs.yC(this.nJz);
        if (this.mMg.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.nnp)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.nnp;
                this.nJs.a(this.mMg.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.nJs.a(this.mMg.getVideoInfo(), this.mVideoTitleData, this.nnq);
            }
        }
        if (this.nJs.dUp() != null && !this.nJz) {
            this.nJs.dUp().f(this);
        }
        this.nJs.c(this.nno);
        adjustResizeForSoftInput();
        this.nJt = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.nJs.dUr());
        this.nJs.dUr().requestFocus();
        TiebaStatic.log(new aq("c12307"));
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
        if (this.mMg.getVideoInfo() != null && !StringUtils.isNull(this.mMg.getVideoInfo().getVideoPath())) {
            UQ(this.mMg.getVideoInfo().getVideoPath());
        }
    }

    private void UQ(String str) {
        if (g.bxo()) {
            if (this.naV != null) {
                this.nJx = this.naV.OQ(str);
            }
            if (this.nJx != null) {
                this.nJx.a(this.kYu);
                this.nJx.deb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.f.e.mY().postDelayed(this.nJv, 500L);
        if (this.nJs != null) {
            this.nJs.dPW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.nJs != null) {
            this.nJs.cBc();
        }
    }

    private void dUh() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mMg.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mFromForumId = intent.getStringExtra("forum_id");
            this.lxy = intent.getStringExtra("forum_name");
            this.nnn = intent.getIntExtra("pro_zone", -1);
            this.mFrom = intent.getStringExtra("from");
            this.mMg.setForumId(this.mFromForumId);
            this.mMg.setForumName(this.lxy);
            this.mMg.setProZone(this.nnn);
            this.nnp = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.nnq = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
                this.nno = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
            }
            if (!StringUtils.isNull(this.lxy)) {
                this.nJs.UT(this.lxy + getResources().getString(R.string.forum));
            } else {
                this.nJs.UT(this.lxy);
            }
            this.jld = intent.getStringExtra("KEY_CALL_FROM");
            dUi();
            if (AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
                this.nJz = true;
            }
        }
    }

    private void dUi() {
        if (this.mMg != null && this.nJs != null && this.nJs.getCenterTitleView() != null) {
            TextView centerTitleView = this.nJs.getCenterTitleView();
            if (this.mMg.getProZone() == 1) {
                centerTitleView.setText(R.string.write_zone_profession_title);
            }
        }
    }

    private void dUj() {
        if (StringUtils.isNull(this.mFromForumId) || Long.parseLong(this.mFromForumId) <= 0 || StringUtils.isNull(this.lxy)) {
            this.mMg.setCanNoForum(true);
        } else {
            this.mMg.setCanNoForum(false);
        }
        this.mMg.setForumName(this.lxy);
        this.mMg.setTitle(this.nJs.getContent());
        this.mMg.setContent("");
        this.mMg.setType(0);
        if (this.nJs.dUs() != null) {
            if (this.nJs.dUs().getState() == 0) {
                this.mMg.setPrivacy(false);
            } else {
                this.mMg.setPrivacy(true);
            }
        }
        this.mMg.setToDynamic(this.nJs.isToDynamic());
        if (this.nJs.dUp() != null) {
            this.mMg.setHasLocationData(this.nJs.dUp().cin());
        }
        this.mMg.setIsNoTitle(TextUtils.isEmpty(this.mMg.getTitle()));
    }

    private void dUk() {
        showLoadingDialog();
        com.baidu.tieba.write.b.a.a(this.mMg, new a.InterfaceC0873a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // com.baidu.tieba.write.b.a.InterfaceC0873a
            public void a(BaseUploadData baseUploadData) {
                com.baidu.tieba.write.b.c.b.dTT().a((VideoUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9.1
                    @Override // com.baidu.tieba.write.b.c.b.a
                    public void onSuccess(String str) {
                        WriteVideoActivity.this.yB(com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true));
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

            @Override // com.baidu.tieba.write.b.a.InterfaceC0873a
            public void onError() {
                WriteVideoActivity.this.closeLoadingDialog();
                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.publish_dynamic_error);
            }
        }, this.naR);
    }

    private void bAB() {
        if (AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.mMg.mDynamicVideoData = new VideoUploadData();
            dUk();
            return;
        }
        dGs();
        showLoadingDialog();
        this.nJw = UR(this.mMg != null ? this.mMg.getTitle() : "");
        if (this.fpI == null) {
            this.fpI = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.jld)) {
            this.mMg.setCallFrom(this.jld);
        }
        this.mMg.setPostLatLng(true);
        dUl();
        this.fpI.e(this.mMg);
        this.fpI.b(this.fpW);
        this.fpI.a(this.naR);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.mMg.setLat(this.mLat);
            this.mMg.setLng(this.mLng);
            if (g.bxo() && this.nJx != null && !this.nJy) {
                com.baidu.adp.lib.f.e.mY().postDelayed(this.nJA, 100L);
            } else {
                this.fpI.dLm();
            }
        } else if (ae.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.mk().a(true, new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
                @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.mMg.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.mMg.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!g.bxo() || WriteVideoActivity.this.nJx == null || WriteVideoActivity.this.nJy) {
                        WriteVideoActivity.this.fpI.dLm();
                    } else {
                        com.baidu.adp.lib.f.e.mY().postDelayed(WriteVideoActivity.this.nJA, 100L);
                    }
                }
            });
        } else if (g.bxo() && this.nJx != null && !this.nJy) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.nJA, 100L);
        } else {
            this.fpI.dLm();
        }
    }

    private void dUl() {
        FrsTabItemData selectedTabItemData;
        if (this.mMg != null && this.nJs != null && this.nJs.dUn() != null && (selectedTabItemData = this.nJs.dUn().getSelectedTabItemData()) != null) {
            this.mMg.setTabId(selectedTabItemData.tabId);
            this.mMg.setTabName(selectedTabItemData.name);
            this.mMg.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    private void bp(Context context, String str) {
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
    public void yB(boolean z) {
        File file;
        File file2 = new File(com.baidu.tieba.video.c.nlO);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        if (z && this.mMg.getVideoInfo().getVideoType() == 1) {
            String str = com.baidu.tieba.video.c.nlO + file.getName();
            n.copyFile(new File(this.mMg.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
            bp(BdBaseApplication.getInst(), str);
        }
        dUm();
        n.deleteFileOrDir(new File(com.baidu.tieba.video.c.nlN));
    }

    private void dUm() {
        VideoInfo videoInfo;
        if (this.mMg != null && (videoInfo = this.mMg.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.c.nlN)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true)) {
                        n.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.nlO + file.getName());
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
            if (AntiHelper.bR(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.bm(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString);
            } else {
                com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
            }
        }
    }

    public void showLoadingDialog() {
        this.jhK = new c(getPageContext().getPageActivity());
        this.jhK.setOnCancelListener(this.iyf);
        this.jhK.setCancelable(true);
        this.jhK.setCanceledOnTouchOutside(false);
        com.baidu.adp.lib.f.g.showDialog(this.jhK, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        dGs();
        destroyWaitingDialog();
        this.iyf = null;
        closeLoadingDialog();
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.nJB);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.jhK = null;
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
                if (this.nJs.dUu() != null) {
                    this.nJs.dUu().bk(postWriteCallBackData.getSensitiveWords());
                    if (!y.isEmpty(this.nJs.dUu().dST())) {
                        this.nJs.yD(true);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(PostWriteCallBackData postWriteCallBackData) {
        com.baidu.tbadk.util.ae.a(new ad<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: bJS */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.mMg != null && WriteVideoActivity.this.mMg.getVideoInfo() != null && WriteVideoActivity.this.mMg.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.mMg.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.c.nlN) && (file = new File(WriteVideoActivity.this.mMg.getVideoInfo().getVideoPath())) != null) {
                    n.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.nlO + file.getName());
                }
                n.deleteFileOrDir(new File(com.baidu.tieba.video.c.nlN));
                return null;
            }
        }, new m<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: a */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.nnp)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.lxy)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.nJw;
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
        this.nJs.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nJs != null) {
            this.nJs.cBc();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.nJv);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.nJA);
    }

    protected void dGs() {
        if (this.fpI != null) {
            this.fpI.cancelLoadData();
        }
        if (this.nJs.dUp() != null) {
            this.nJs.dUp().dGs();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.jhK != null && this.jhK.isShowing()) {
                com.baidu.adp.lib.f.g.b(this.jhK, getPageContext());
                return true;
            }
            cCt();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cCt() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ow(R.string.give_up_video_confirm);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.dGs();
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
        aVar.b(getPageContext()).bpc();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nJs.dUq()) {
            if (b.nJE - this.nJs.dUo() < 0) {
                showToast(getResources().getString(R.string.video_content_overflow));
            } else if (this.nJs.dUu() != null && this.nJs.dUu().dSV()) {
                showToast(this.nJs.dUu().dSX());
                this.nJs.yD(true);
            } else {
                dUj();
                bAB();
            }
        } else if (view == this.nJs.getBackButton()) {
            cCt();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.jhK != null) {
            if (this.jhK.isShowing()) {
                com.baidu.adp.lib.f.g.b(this.jhK, getPageContext());
            }
            this.jhK = null;
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
        if (this.nJt.onTouchEvent(motionEvent)) {
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
        this.nJs.yE(z);
    }

    public VideoTitleData UR(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.nnq)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.nnq.size()) {
                        break;
                    } else if (this.nnq.get(i2) == null || !group.equals(this.nnq.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.nnq.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
