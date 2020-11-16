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
    private NewWriteModel foP;
    private final NewWriteModel.d fpd;
    private DialogInterface.OnCancelListener iyU;
    private c jiw;
    private e.a kYM;
    private String lxP;
    private String mFrom;
    private String mFromForumId;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private VideoTitleData mVideoTitleData;
    private b nKT;
    private GestureDetector nKU;
    private int nKV;
    private VideoTitleData nKX;
    private e nKY;
    private boolean nKZ;
    private Runnable nLb;
    private Runnable nLc;
    private a.InterfaceC0854a nbS;
    private l nbW;
    private int nov;
    private FrsTabInfoData nox;
    private String noy;
    private List<VideoTitleData> noz;
    private final WriteData mMZ = new WriteData();
    private Runnable nKW = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String jlN = "0";
    private boolean nLa = false;

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            this.nbW = (l) runTask.getData();
        }
        this.kYM = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tieba.l.e.a
            public void Fo(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.nKZ = true;
                    return;
                }
                ar arVar = new ar("c12620");
                arVar.ak("obj_locate", 0);
                TiebaStatic.log(arVar);
            }

            @Override // com.baidu.tieba.l.e.a
            public void onChange(boolean z) {
            }

            @Override // com.baidu.tieba.l.e.a
            public void tn(boolean z) {
                WriteVideoActivity.this.nKZ = true;
                ar arVar = new ar("c12621");
                arVar.ak("obj_locate", 0);
                arVar.ak("obj_param1", z ? 1 : 0);
                TiebaStatic.log(arVar);
            }
        };
        this.nLb = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (!g.bwE() || WriteVideoActivity.this.nKY == null || WriteVideoActivity.this.nKZ) {
                    if (WriteVideoActivity.this.foP != null) {
                        WriteVideoActivity.this.foP.dLl();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(WriteVideoActivity.this.nLb, 100L);
            }
        };
        this.fpd = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                WriteVideoActivity.this.closeLoadingDialog();
                if (postWriteCallBackData != null && WriteVideoActivity.this.mMZ != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                    if (WriteVideoActivity.this.mMZ != null && WriteVideoActivity.this.mMZ.getVideoInfo() != null && writeData != null) {
                        if (!z2 && WriteVideoActivity.this.mMZ.getVideoInfo().getVideoDuration() > 8) {
                            writeData.setVideoReviewType(1);
                        } else {
                            writeData.setVideoReviewType(2);
                        }
                    }
                    WriteVideoActivity.this.nKT.dUs();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                    if (z) {
                        if (WriteVideoActivity.this.mMZ != null && WriteVideoActivity.this.mMZ.getVideoInfo() != null) {
                            WriteVideoActivity.this.yI(z3);
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.mMZ.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.k(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.nKT.l(postWriteCallBackData);
                    } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(ahVar.getVcode_md5());
                        writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                        writeData.setVcodeExtra(ahVar.bum());
                        if (com.baidu.tbadk.t.a.Ef(ahVar.bul())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bul())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        };
        this.nLc = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.jiw != null) {
                    WriteVideoActivity.this.jiw.setPercent(WriteVideoActivity.this.nKV);
                }
            }
        };
        this.nbS = new a.InterfaceC0854a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.14
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0854a
            public void Ki(int i) {
                WriteVideoActivity.this.nKV = i;
                com.baidu.adp.lib.f.e.mY().post(WriteVideoActivity.this.nLc);
            }
        };
        this.iyU = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.dGj();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nKT = new b(this);
        setSwipeBackEnabled(false);
        dUg();
        this.nKT.yJ(this.nLa);
        if (this.mMZ.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.noy)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.noy;
                this.nKT.a(this.mMZ.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.nKT.a(this.mMZ.getVideoInfo(), this.mVideoTitleData, this.noz);
            }
        }
        if (this.nKT.dUo() != null && !this.nLa) {
            this.nKT.dUo().f(this);
        }
        this.nKT.c(this.nox);
        adjustResizeForSoftInput();
        this.nKU = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.nKT.dUq());
        this.nKT.dUq().requestFocus();
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
        if (this.mMZ.getVideoInfo() != null && !StringUtils.isNull(this.mMZ.getVideoInfo().getVideoPath())) {
            UB(this.mMZ.getVideoInfo().getVideoPath());
        }
    }

    private void UB(String str) {
        if (g.bwE()) {
            if (this.nbW != null) {
                this.nKY = this.nbW.Om(str);
            }
            if (this.nKY != null) {
                this.nKY.a(this.kYM);
                this.nKY.ddy();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.f.e.mY().postDelayed(this.nKW, 500L);
        if (this.nKT != null) {
            this.nKT.dPV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.nKT != null) {
            this.nKT.cAF();
        }
    }

    private void dUg() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mMZ.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mFromForumId = intent.getStringExtra("forum_id");
            this.lxP = intent.getStringExtra("forum_name");
            this.nov = intent.getIntExtra("pro_zone", -1);
            this.mFrom = intent.getStringExtra("from");
            this.mMZ.setForumId(this.mFromForumId);
            this.mMZ.setForumName(this.lxP);
            this.mMZ.setProZone(this.nov);
            this.noy = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.noz = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
                this.nox = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
            }
            if (!StringUtils.isNull(this.lxP)) {
                this.nKT.UE(this.lxP + getResources().getString(R.string.forum));
            } else {
                this.nKT.UE(this.lxP);
            }
            this.jlN = intent.getStringExtra("KEY_CALL_FROM");
            dUh();
            if (AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
                this.nLa = true;
            }
        }
    }

    private void dUh() {
        if (this.mMZ != null && this.nKT != null && this.nKT.getCenterTitleView() != null) {
            TextView centerTitleView = this.nKT.getCenterTitleView();
            if (this.mMZ.getProZone() == 1) {
                centerTitleView.setText(R.string.write_zone_profession_title);
            }
        }
    }

    private void dUi() {
        if (StringUtils.isNull(this.mFromForumId) || Long.parseLong(this.mFromForumId) <= 0 || StringUtils.isNull(this.lxP)) {
            this.mMZ.setCanNoForum(true);
        } else {
            this.mMZ.setCanNoForum(false);
        }
        this.mMZ.setForumName(this.lxP);
        this.mMZ.setTitle(this.nKT.getContent());
        this.mMZ.setContent("");
        this.mMZ.setType(0);
        if (this.nKT.dUr() != null) {
            if (this.nKT.dUr().getState() == 0) {
                this.mMZ.setPrivacy(false);
            } else {
                this.mMZ.setPrivacy(true);
            }
        }
        this.mMZ.setToDynamic(this.nKT.isToDynamic());
        if (this.nKT.dUo() != null) {
            this.mMZ.setHasLocationData(this.nKT.dUo().chG());
        }
        this.mMZ.setIsNoTitle(TextUtils.isEmpty(this.mMZ.getTitle()));
    }

    private void dUj() {
        showLoadingDialog();
        com.baidu.tieba.write.b.a.a(this.mMZ, new a.InterfaceC0876a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // com.baidu.tieba.write.b.a.InterfaceC0876a
            public void a(BaseUploadData baseUploadData) {
                com.baidu.tieba.write.b.c.b.dTS().a((VideoUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9.1
                    @Override // com.baidu.tieba.write.b.c.b.a
                    public void onSuccess(String str) {
                        WriteVideoActivity.this.yI(com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true));
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

            @Override // com.baidu.tieba.write.b.a.InterfaceC0876a
            public void onError() {
                WriteVideoActivity.this.closeLoadingDialog();
                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.publish_dynamic_error);
            }
        }, this.nbS);
    }

    private void bzR() {
        if (AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.mMZ.mDynamicVideoData = new VideoUploadData();
            dUj();
            return;
        }
        dGj();
        showLoadingDialog();
        this.nKX = UC(this.mMZ != null ? this.mMZ.getTitle() : "");
        if (this.foP == null) {
            this.foP = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.jlN)) {
            this.mMZ.setCallFrom(this.jlN);
        }
        this.mMZ.setPostLatLng(true);
        dUk();
        this.foP.e(this.mMZ);
        this.foP.b(this.fpd);
        this.foP.a(this.nbS);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.mMZ.setLat(this.mLat);
            this.mMZ.setLng(this.mLng);
            if (g.bwE() && this.nKY != null && !this.nKZ) {
                com.baidu.adp.lib.f.e.mY().postDelayed(this.nLb, 100L);
            } else {
                this.foP.dLl();
            }
        } else if (ae.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.mk().a(true, new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
                @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.mMZ.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.mMZ.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!g.bwE() || WriteVideoActivity.this.nKY == null || WriteVideoActivity.this.nKZ) {
                        WriteVideoActivity.this.foP.dLl();
                    } else {
                        com.baidu.adp.lib.f.e.mY().postDelayed(WriteVideoActivity.this.nLb, 100L);
                    }
                }
            });
        } else if (g.bwE() && this.nKY != null && !this.nKZ) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.nLb, 100L);
        } else {
            this.foP.dLl();
        }
    }

    private void dUk() {
        FrsTabItemData selectedTabItemData;
        if (this.mMZ != null && this.nKT != null && this.nKT.dUm() != null && (selectedTabItemData = this.nKT.dUm().getSelectedTabItemData()) != null) {
            this.mMZ.setTabId(selectedTabItemData.tabId);
            this.mMZ.setTabName(selectedTabItemData.name);
            this.mMZ.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    private void bm(Context context, String str) {
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
    public void yI(boolean z) {
        File file;
        File file2 = new File(com.baidu.tieba.video.c.nmV);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        if (z && this.mMZ.getVideoInfo().getVideoType() == 1) {
            String str = com.baidu.tieba.video.c.nmV + file.getName();
            n.copyFile(new File(this.mMZ.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
            bm(BdBaseApplication.getInst(), str);
        }
        dUl();
        n.deleteFileOrDir(new File(com.baidu.tieba.video.c.nmU));
    }

    private void dUl() {
        VideoInfo videoInfo;
        if (this.mMZ != null && (videoInfo = this.mMZ.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.c.nmU)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true)) {
                        n.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.nmV + file.getName());
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
                AntiHelper.bj(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
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
        this.jiw = new c(getPageContext().getPageActivity());
        this.jiw.setOnCancelListener(this.iyU);
        this.jiw.setCancelable(true);
        this.jiw.setCanceledOnTouchOutside(false);
        com.baidu.adp.lib.f.g.showDialog(this.jiw, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        dGj();
        destroyWaitingDialog();
        this.iyU = null;
        closeLoadingDialog();
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.nLc);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.jiw = null;
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
                if (this.nKT.dUt() != null) {
                    this.nKT.dUt().bl(postWriteCallBackData.getSensitiveWords());
                    if (!y.isEmpty(this.nKT.dUt().dSS())) {
                        this.nKT.yK(true);
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
            /* renamed from: bJl */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.mMZ != null && WriteVideoActivity.this.mMZ.getVideoInfo() != null && WriteVideoActivity.this.mMZ.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.mMZ.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.c.nmU) && (file = new File(WriteVideoActivity.this.mMZ.getVideoInfo().getVideoPath())) != null) {
                    n.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.nmV + file.getName());
                }
                n.deleteFileOrDir(new File(com.baidu.tieba.video.c.nmU));
                return null;
            }
        }, new m<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: a */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.noy)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.lxP)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.nKX;
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
        this.nKT.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nKT != null) {
            this.nKT.cAF();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.nKW);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.nLb);
    }

    protected void dGj() {
        if (this.foP != null) {
            this.foP.cancelLoadData();
        }
        if (this.nKT.dUo() != null) {
            this.nKT.dUo().dGj();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.jiw != null && this.jiw.isShowing()) {
                com.baidu.adp.lib.f.g.b(this.jiw, getPageContext());
                return true;
            }
            cBX();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cBX() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.os(R.string.give_up_video_confirm);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.dGj();
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
        aVar.b(getPageContext()).bog();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nKT.dUp()) {
            if (b.nLf - this.nKT.dUn() < 0) {
                showToast(getResources().getString(R.string.video_content_overflow));
            } else if (this.nKT.dUt() != null && this.nKT.dUt().dSU()) {
                showToast(this.nKT.dUt().dSW());
                this.nKT.yK(true);
            } else {
                dUi();
                bzR();
            }
        } else if (view == this.nKT.getBackButton()) {
            cBX();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.jiw != null) {
            if (this.jiw.isShowing()) {
                com.baidu.adp.lib.f.g.b(this.jiw, getPageContext());
            }
            this.jiw = null;
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
        if (this.nKU.onTouchEvent(motionEvent)) {
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
        this.nKT.yL(z);
    }

    public VideoTitleData UC(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.noz)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.noz.size()) {
                        break;
                    } else if (this.noz.get(i2) == null || !group.equals(this.noz.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.noz.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
