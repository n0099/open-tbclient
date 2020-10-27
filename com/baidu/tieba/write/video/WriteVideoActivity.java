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
    private NewWriteModel fjQ;
    private final NewWriteModel.d fke;
    private DialogInterface.OnCancelListener isi;
    private c jbN;
    private e.a kSy;
    private String lrB;
    private String mFrom;
    private String mFromForumId;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private a.InterfaceC0837a mUV;
    private l mUZ;
    private VideoTitleData mVideoTitleData;
    private int nDA;
    private VideoTitleData nDC;
    private e nDD;
    private boolean nDE;
    private Runnable nDG;
    private Runnable nDH;
    private b nDy;
    private GestureDetector nDz;
    private int nhr;
    private FrsTabInfoData nhs;
    private String nht;
    private List<VideoTitleData> nhu;
    private final WriteData mGf = new WriteData();
    private Runnable nDB = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String jff = "0";
    private boolean nDF = false;

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            this.mUZ = (l) runTask.getData();
        }
        this.kSy = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tieba.k.e.a
            public void ED(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.nDE = true;
                    return;
                }
                aq aqVar = new aq("c12620");
                aqVar.aj("obj_locate", 0);
                TiebaStatic.log(aqVar);
            }

            @Override // com.baidu.tieba.k.e.a
            public void onChange(boolean z) {
            }

            @Override // com.baidu.tieba.k.e.a
            public void tb(boolean z) {
                WriteVideoActivity.this.nDE = true;
                aq aqVar = new aq("c12621");
                aqVar.aj("obj_locate", 0);
                aqVar.aj("obj_param1", z ? 1 : 0);
                TiebaStatic.log(aqVar);
            }
        };
        this.nDG = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (!g.buO() || WriteVideoActivity.this.nDD == null || WriteVideoActivity.this.nDE) {
                    if (WriteVideoActivity.this.fjQ != null) {
                        WriteVideoActivity.this.fjQ.dIK();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(WriteVideoActivity.this.nDG, 100L);
            }
        };
        this.fke = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                WriteVideoActivity.this.closeLoadingDialog();
                if (postWriteCallBackData != null && WriteVideoActivity.this.mGf != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                    if (WriteVideoActivity.this.mGf != null && WriteVideoActivity.this.mGf.getVideoInfo() != null && writeData != null) {
                        if (!z2 && WriteVideoActivity.this.mGf.getVideoInfo().getVideoDuration() > 8) {
                            writeData.setVideoReviewType(1);
                        } else {
                            writeData.setVideoReviewType(2);
                        }
                    }
                    WriteVideoActivity.this.nDy.dRT();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                    if (z) {
                        if (WriteVideoActivity.this.mGf != null && WriteVideoActivity.this.mGf.getVideoInfo() != null) {
                            WriteVideoActivity.this.ys(z3);
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.mGf.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.k(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.nDy.l(postWriteCallBackData);
                    } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(ahVar.getVcode_md5());
                        writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                        writeData.setVcodeExtra(ahVar.bsw());
                        if (com.baidu.tbadk.t.a.Eq(ahVar.bsv())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bsv())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        };
        this.nDH = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.jbN != null) {
                    WriteVideoActivity.this.jbN.setPercent(WriteVideoActivity.this.nDA);
                }
            }
        };
        this.mUV = new a.InterfaceC0837a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.14
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0837a
            public void Jt(int i) {
                WriteVideoActivity.this.nDA = i;
                com.baidu.adp.lib.f.e.mY().post(WriteVideoActivity.this.nDH);
            }
        };
        this.isi = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.dDQ();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nDy = new b(this);
        setSwipeBackEnabled(false);
        dRH();
        this.nDy.yt(this.nDF);
        if (this.mGf.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.nht)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.nht;
                this.nDy.a(this.mGf.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.nDy.a(this.mGf.getVideoInfo(), this.mVideoTitleData, this.nhu);
            }
        }
        if (this.nDy.dRP() != null && !this.nDF) {
            this.nDy.dRP().f(this);
        }
        this.nDy.c(this.nhs);
        adjustResizeForSoftInput();
        this.nDz = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.nDy.dRR());
        this.nDy.dRR().requestFocus();
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
        if (this.mGf.getVideoInfo() != null && !StringUtils.isNull(this.mGf.getVideoInfo().getVideoPath())) {
            Uz(this.mGf.getVideoInfo().getVideoPath());
        }
    }

    private void Uz(String str) {
        if (g.buO()) {
            if (this.mUZ != null) {
                this.nDD = this.mUZ.Oz(str);
            }
            if (this.nDD != null) {
                this.nDD.a(this.kSy);
                this.nDD.dbz();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.f.e.mY().postDelayed(this.nDB, 500L);
        if (this.nDy != null) {
            this.nDy.dNu();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.nDy != null) {
            this.nDy.cyB();
        }
    }

    private void dRH() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.mGf.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mFromForumId = intent.getStringExtra("forum_id");
            this.lrB = intent.getStringExtra("forum_name");
            this.nhr = intent.getIntExtra("pro_zone", -1);
            this.mFrom = intent.getStringExtra("from");
            this.mGf.setForumId(this.mFromForumId);
            this.mGf.setForumName(this.lrB);
            this.mGf.setProZone(this.nhr);
            this.nht = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.nhu = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
                this.nhs = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
            }
            if (!StringUtils.isNull(this.lrB)) {
                this.nDy.UC(this.lrB + getResources().getString(R.string.forum));
            } else {
                this.nDy.UC(this.lrB);
            }
            this.jff = intent.getStringExtra("KEY_CALL_FROM");
            dRI();
            if (AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
                this.nDF = true;
            }
        }
    }

    private void dRI() {
        if (this.mGf != null && this.nDy != null && this.nDy.getCenterTitleView() != null) {
            TextView centerTitleView = this.nDy.getCenterTitleView();
            if (this.mGf.getProZone() == 1) {
                centerTitleView.setText(R.string.write_zone_profession_title);
            }
        }
    }

    private void dRJ() {
        if (StringUtils.isNull(this.mFromForumId) || Long.parseLong(this.mFromForumId) <= 0 || StringUtils.isNull(this.lrB)) {
            this.mGf.setCanNoForum(true);
        } else {
            this.mGf.setCanNoForum(false);
        }
        this.mGf.setForumName(this.lrB);
        this.mGf.setTitle(this.nDy.getContent());
        this.mGf.setContent("");
        this.mGf.setType(0);
        if (this.nDy.dRS() != null) {
            if (this.nDy.dRS().getState() == 0) {
                this.mGf.setPrivacy(false);
            } else {
                this.mGf.setPrivacy(true);
            }
        }
        this.mGf.setToDynamic(this.nDy.isToDynamic());
        if (this.nDy.dRP() != null) {
            this.mGf.setHasLocationData(this.nDy.dRP().cfL());
        }
        this.mGf.setIsNoTitle(TextUtils.isEmpty(this.mGf.getTitle()));
    }

    private void dRK() {
        showLoadingDialog();
        com.baidu.tieba.write.b.a.a(this.mGf, new a.InterfaceC0858a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // com.baidu.tieba.write.b.a.InterfaceC0858a
            public void a(BaseUploadData baseUploadData) {
                com.baidu.tieba.write.b.c.b.dRt().a((VideoUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9.1
                    @Override // com.baidu.tieba.write.b.c.b.a
                    public void onSuccess(String str) {
                        WriteVideoActivity.this.ys(com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true));
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

            @Override // com.baidu.tieba.write.b.a.InterfaceC0858a
            public void onError() {
                WriteVideoActivity.this.closeLoadingDialog();
                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.publish_dynamic_error);
            }
        }, this.mUV);
    }

    private void byc() {
        if (AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.mGf.mDynamicVideoData = new VideoUploadData();
            dRK();
            return;
        }
        dDQ();
        showLoadingDialog();
        this.nDC = UA(this.mGf != null ? this.mGf.getTitle() : "");
        if (this.fjQ == null) {
            this.fjQ = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.jff)) {
            this.mGf.setCallFrom(this.jff);
        }
        this.mGf.setPostLatLng(true);
        dRL();
        this.fjQ.e(this.mGf);
        this.fjQ.b(this.fke);
        this.fjQ.a(this.mUV);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.mGf.setLat(this.mLat);
            this.mGf.setLng(this.mLng);
            if (g.buO() && this.nDD != null && !this.nDE) {
                com.baidu.adp.lib.f.e.mY().postDelayed(this.nDG, 100L);
            } else {
                this.fjQ.dIK();
            }
        } else if (ae.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.mk().a(true, new a.InterfaceC0020a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
                @Override // com.baidu.adp.lib.c.a.InterfaceC0020a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.mGf.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.mGf.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!g.buO() || WriteVideoActivity.this.nDD == null || WriteVideoActivity.this.nDE) {
                        WriteVideoActivity.this.fjQ.dIK();
                    } else {
                        com.baidu.adp.lib.f.e.mY().postDelayed(WriteVideoActivity.this.nDG, 100L);
                    }
                }
            });
        } else if (g.buO() && this.nDD != null && !this.nDE) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.nDG, 100L);
        } else {
            this.fjQ.dIK();
        }
    }

    private void dRL() {
        FrsTabItemData selectedTabItemData;
        if (this.mGf != null && this.nDy != null && this.nDy.dRN() != null && (selectedTabItemData = this.nDy.dRN().getSelectedTabItemData()) != null) {
            this.mGf.setTabId(selectedTabItemData.tabId);
            this.mGf.setTabName(selectedTabItemData.name);
            this.mGf.setIsGeneralTab(selectedTabItemData.isGeneralTab);
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
    public void ys(boolean z) {
        File file;
        File file2 = new File(com.baidu.tieba.video.c.nfS);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        if (z && this.mGf.getVideoInfo().getVideoType() == 1) {
            String str = com.baidu.tieba.video.c.nfS + file.getName();
            n.copyFile(new File(this.mGf.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
            bp(BdBaseApplication.getInst(), str);
        }
        dRM();
        n.deleteFileOrDir(new File(com.baidu.tieba.video.c.nfR));
    }

    private void dRM() {
        VideoInfo videoInfo;
        if (this.mGf != null && (videoInfo = this.mGf.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.c.nfR)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true)) {
                        n.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.nfS + file.getName());
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
            if (AntiHelper.bN(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
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
        this.jbN = new c(getPageContext().getPageActivity());
        this.jbN.setOnCancelListener(this.isi);
        this.jbN.setCancelable(true);
        this.jbN.setCanceledOnTouchOutside(false);
        com.baidu.adp.lib.f.g.showDialog(this.jbN, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        dDQ();
        destroyWaitingDialog();
        this.isi = null;
        closeLoadingDialog();
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.nDH);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.jbN = null;
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
                if (this.nDy.dRU() != null) {
                    this.nDy.dRU().bk(postWriteCallBackData.getSensitiveWords());
                    if (!y.isEmpty(this.nDy.dRU().dQr())) {
                        this.nDy.yu(true);
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
            /* renamed from: bHt */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.mGf != null && WriteVideoActivity.this.mGf.getVideoInfo() != null && WriteVideoActivity.this.mGf.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.mGf.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.c.nfR) && (file = new File(WriteVideoActivity.this.mGf.getVideoInfo().getVideoPath())) != null) {
                    n.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.nfS + file.getName());
                }
                n.deleteFileOrDir(new File(com.baidu.tieba.video.c.nfR));
                return null;
            }
        }, new m<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: a */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.nht)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.lrB)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.nDC;
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
        this.nDy.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.nDy != null) {
            this.nDy.cyB();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.nDB);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.nDG);
    }

    protected void dDQ() {
        if (this.fjQ != null) {
            this.fjQ.cancelLoadData();
        }
        if (this.nDy.dRP() != null) {
            this.nDy.dRP().dDQ();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.jbN != null && this.jbN.isShowing()) {
                com.baidu.adp.lib.f.g.b(this.jbN, getPageContext());
                return true;
            }
            czS();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void czS() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.om(R.string.give_up_video_confirm);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.dDQ();
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
        aVar.b(getPageContext()).bmC();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nDy.dRQ()) {
            if (b.nDK - this.nDy.dRO() < 0) {
                showToast(getResources().getString(R.string.video_content_overflow));
            } else if (this.nDy.dRU() != null && this.nDy.dRU().dQt()) {
                showToast(this.nDy.dRU().dQv());
                this.nDy.yu(true);
            } else {
                dRJ();
                byc();
            }
        } else if (view == this.nDy.getBackButton()) {
            czS();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.jbN != null) {
            if (this.jbN.isShowing()) {
                com.baidu.adp.lib.f.g.b(this.jbN, getPageContext());
            }
            this.jbN = null;
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
        if (this.nDz.onTouchEvent(motionEvent)) {
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
        this.nDy.yv(z);
    }

    public VideoTitleData UA(String str) {
        if (!StringUtils.isNull(str) && !y.isEmpty(this.nhu)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.nhu.size()) {
                        break;
                    } else if (this.nhu.get(i2) == null || !group.equals(this.nhu.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.nhu.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
