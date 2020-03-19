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
import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes13.dex */
public class WriteVideoActivity extends BaseActivity<WriteVideoActivity> {
    private NewWriteModel dyM;
    private final NewWriteModel.d dza;
    private c gMD;
    private DialogInterface.OnCancelListener ggh;
    private String iMe;
    private e.a isE;
    private e jwv;
    private b kSb;
    private GestureDetector kSc;
    private int kSd;
    private VideoTitleData kSf;
    private boolean kSg;
    private Runnable kSh;
    private Runnable kSi;
    private a.InterfaceC0612a kmc;
    private l kmg;
    private int kyb;
    private FrsTabInfoData kyc;
    private String kyd;
    private List<VideoTitleData> kye;
    private String mFromForumId;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private VideoTitleData mVideoTitleData;
    private final WriteData jYy = new WriteData();
    private Runnable kSe = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String gPr = "0";

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            this.kmg = (l) runTask.getData();
        }
        this.isE = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.7
            @Override // com.baidu.tieba.k.e.a
            public void yo(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.kSg = true;
                    return;
                }
                an anVar = new an("c12620");
                anVar.X("obj_locate", 0);
                TiebaStatic.log(anVar);
            }

            @Override // com.baidu.tieba.k.e.a
            public void onChange(boolean z) {
            }

            @Override // com.baidu.tieba.k.e.a
            public void oV(boolean z) {
                WriteVideoActivity.this.kSg = true;
                an anVar = new an("c12621");
                anVar.X("obj_locate", 0);
                anVar.X("obj_param1", z ? 1 : 0);
                TiebaStatic.log(anVar);
            }
        };
        this.kSh = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // java.lang.Runnable
            public void run() {
                if (!f.aMe() || WriteVideoActivity.this.jwv == null || WriteVideoActivity.this.kSg) {
                    if (WriteVideoActivity.this.dyM != null) {
                        WriteVideoActivity.this.dyM.cME();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(WriteVideoActivity.this.kSh, 100L);
            }
        };
        this.dza = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                File file;
                WriteVideoActivity.this.closeLoadingDialog();
                if (postWriteCallBackData != null && WriteVideoActivity.this.jYy != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                    if (WriteVideoActivity.this.jYy != null && WriteVideoActivity.this.jYy.getVideoInfo() != null && writeData != null) {
                        if (!z2 && WriteVideoActivity.this.jYy.getVideoInfo().getVideoDuration() > 8) {
                            writeData.setVideoReviewType(1);
                        } else {
                            writeData.setVideoReviewType(2);
                        }
                    }
                    WriteVideoActivity.this.kSb.cVL();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                    if (z) {
                        if (WriteVideoActivity.this.jYy != null && WriteVideoActivity.this.jYy.getVideoInfo() != null) {
                            File file2 = new File(com.baidu.tieba.video.c.kwE);
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            if (z3 && WriteVideoActivity.this.jYy.getVideoInfo().getVideoType() == 1) {
                                String str = com.baidu.tieba.video.c.kwE + file.getName();
                                m.copyFile(new File(WriteVideoActivity.this.jYy.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
                                WriteVideoActivity.this.bq(BdBaseApplication.getInst(), str);
                            }
                            WriteVideoActivity.this.cVC();
                            m.deleteFileOrDir(new File(com.baidu.tieba.video.c.kwD));
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.jYy.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.i(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.kSb.j(postWriteCallBackData);
                    } else if ((aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (aaVar != null && writeData != null && aaVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(aaVar.getVcode_md5());
                        writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                        writeData.setVcodeExtra(aaVar.aJL());
                        if (com.baidu.tbadk.s.a.wc(aaVar.aJK())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aJK())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        };
        this.kSi = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.gMD != null) {
                    WriteVideoActivity.this.gMD.setPercent(WriteVideoActivity.this.kSd);
                }
            }
        };
        this.kmc = new a.InterfaceC0612a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0612a
            public void CG(int i) {
                WriteVideoActivity.this.kSd = i;
                com.baidu.adp.lib.f.e.gx().post(WriteVideoActivity.this.kSi);
            }
        };
        this.ggh = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.cIn();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kSb = new b(this);
        setSwipeBackEnabled(false);
        cVy();
        if (this.jYy.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.kyd)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.kyd;
                this.kSb.a(this.jYy.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.kSb.a(this.jYy.getVideoInfo(), this.mVideoTitleData, this.kye);
            }
        }
        if (this.kSb.cVH() != null) {
            this.kSb.cVH().d(this);
        }
        this.kSb.b(this.kyc);
        adjustResizeForSoftInput();
        this.kSc = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.kSb.cVJ());
        this.kSb.cVJ().requestFocus();
        TiebaStatic.log(new an("c12307"));
        addGlobalLayoutListener();
        if (ab.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.fK().a(true, new a.InterfaceC0016a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.6
                @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                    }
                }
            });
        }
        if (this.jYy.getVideoInfo() != null && !StringUtils.isNull(this.jYy.getVideoInfo().getVideoPath())) {
            KY(this.jYy.getVideoInfo().getVideoPath());
        }
    }

    private void KY(String str) {
        if (f.aMe()) {
            if (this.kmg != null) {
                this.jwv = this.kmg.Fj(str);
            }
            if (this.jwv != null) {
                this.jwv.a(this.isE);
                this.jwv.cgU();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.f.e.gx().postDelayed(this.kSe, 500L);
        if (this.kSb != null) {
            this.kSb.cRe();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.kSb != null) {
            this.kSb.bGx();
        }
    }

    private void cVy() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.jYy.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mFromForumId = intent.getStringExtra("forum_id");
            this.iMe = intent.getStringExtra("forum_name");
            this.kyb = intent.getIntExtra("pro_zone", -1);
            this.jYy.setForumId(this.mFromForumId);
            this.jYy.setForumName(this.iMe);
            this.jYy.setProZone(this.kyb);
            this.kyd = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.kye = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
                this.kyc = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
            }
            if (!StringUtils.isNull(this.iMe)) {
                this.kSb.Lb(this.iMe + getResources().getString(R.string.forum));
            } else {
                this.kSb.Lb(this.iMe);
            }
            this.gPr = intent.getStringExtra("KEY_CALL_FROM");
            cVz();
        }
    }

    private void cVz() {
        if (this.jYy != null && this.kSb != null && this.kSb.getCenterTitleView() != null) {
            TextView centerTitleView = this.kSb.getCenterTitleView();
            if (this.jYy.getProZone() == 1) {
                centerTitleView.setText(R.string.write_zone_profession_title);
            }
        }
    }

    private void cVA() {
        if (StringUtils.isNull(this.mFromForumId) || Long.parseLong(this.mFromForumId) <= 0 || StringUtils.isNull(this.iMe)) {
            this.jYy.setCanNoForum(true);
        } else {
            this.jYy.setCanNoForum(false);
        }
        this.jYy.setForumName(this.iMe);
        this.jYy.setTitle(this.kSb.getContent());
        this.jYy.setContent("");
        this.jYy.setType(0);
        if (this.kSb.cVK() != null) {
            if (this.kSb.cVK().getState() == 0) {
                this.jYy.setPrivacy(false);
            } else {
                this.jYy.setPrivacy(true);
            }
        }
        this.jYy.setToDynamic(this.kSb.isToDynamic());
        if (this.kSb.cVH() != null) {
            this.jYy.setHasLocationData(this.kSb.cVH().brr());
        }
        this.jYy.setIsNoTitle(TextUtils.isEmpty(this.jYy.getTitle()));
    }

    private void aPt() {
        cIn();
        showLoadingDialog();
        this.kSf = KZ(this.jYy != null ? this.jYy.getTitle() : "");
        if (this.dyM == null) {
            this.dyM = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.gPr)) {
            this.jYy.setCallFrom(this.gPr);
        }
        this.jYy.setPostLatLng(true);
        cVB();
        this.dyM.d(this.jYy);
        this.dyM.b(this.dza);
        this.dyM.a(this.kmc);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.jYy.setLat(this.mLat);
            this.jYy.setLng(this.mLng);
            if (f.aMe() && this.jwv != null && !this.kSg) {
                com.baidu.adp.lib.f.e.gx().postDelayed(this.kSh, 100L);
            } else {
                this.dyM.cME();
            }
        } else if (ab.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.fK().a(true, new a.InterfaceC0016a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
                @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.jYy.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.jYy.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!f.aMe() || WriteVideoActivity.this.jwv == null || WriteVideoActivity.this.kSg) {
                        WriteVideoActivity.this.dyM.cME();
                    } else {
                        com.baidu.adp.lib.f.e.gx().postDelayed(WriteVideoActivity.this.kSh, 100L);
                    }
                }
            });
        } else if (f.aMe() && this.jwv != null && !this.kSg) {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.kSh, 100L);
        } else {
            this.dyM.cME();
        }
    }

    private void cVB() {
        FrsTabItemData selectedTabItemData;
        if (this.jYy != null && this.kSb != null && this.kSb.cVF() != null && (selectedTabItemData = this.kSb.cVF().getSelectedTabItemData()) != null) {
            this.jYy.setTabId(selectedTabItemData.tabId);
            this.jYy.setTabName(selectedTabItemData.name);
            this.jYy.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq(Context context, String str) {
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
    public void cVC() {
        VideoInfo videoInfo;
        if (this.jYy != null && (videoInfo = this.jYy.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.c.kwD)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true)) {
                        m.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.kwE + file.getName());
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
            if (AntiHelper.bb(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.bn(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
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
        this.gMD = new c(getPageContext().getPageActivity());
        this.gMD.setOnCancelListener(this.ggh);
        this.gMD.setCancelable(true);
        this.gMD.setCanceledOnTouchOutside(false);
        g.showDialog(this.gMD, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        cIn();
        destroyWaitingDialog();
        this.ggh = null;
        closeLoadingDialog();
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.kSi);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.gMD = null;
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
                if (this.kSb.cVM() != null) {
                    this.kSb.cVM().aU(postWriteCallBackData.getSensitiveWords());
                    if (!v.isEmpty(this.kSb.cVM().cUx())) {
                        this.kSb.tW(true);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(PostWriteCallBackData postWriteCallBackData) {
        ac.a(new com.baidu.tbadk.util.ab<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: aYM */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.jYy != null && WriteVideoActivity.this.jYy.getVideoInfo() != null && WriteVideoActivity.this.jYy.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.jYy.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.c.kwD) && (file = new File(WriteVideoActivity.this.jYy.getVideoInfo().getVideoPath())) != null) {
                    m.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.kwE + file.getName());
                }
                m.deleteFileOrDir(new File(com.baidu.tieba.video.c.kwD));
                return null;
            }
        }, new com.baidu.tbadk.util.l<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: a */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.kyd)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.iMe)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.kSf;
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
        this.kSb.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kSb != null) {
            this.kSb.bGx();
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.kSe);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.kSh);
    }

    protected void cIn() {
        if (this.dyM != null) {
            this.dyM.cancelLoadData();
        }
        if (this.kSb.cVH() != null) {
            this.kSb.cVH().cIn();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gMD != null && this.gMD.isShowing()) {
                g.b(this.gMD, getPageContext());
                return true;
            }
            cVD();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cVD() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.jW(R.string.give_up_video_confirm);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.cIn();
                TiebaStatic.log("c10800");
                WriteVideoActivity.this.finish();
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).aEG();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kSb.cVI()) {
            if (b.kSk - this.kSb.cVG() < 0) {
                showToast(getResources().getString(R.string.video_content_overflow));
            } else if (this.kSb.cVM() != null && this.kSb.cVM().cUz()) {
                showToast(this.kSb.cVM().cUB());
                this.kSb.tW(true);
            } else {
                cVA();
                aPt();
            }
        } else if (view == this.kSb.getBackButton()) {
            cVD();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.gMD != null) {
            if (this.gMD.isShowing()) {
                g.b(this.gMD, getPageContext());
            }
            this.gMD = null;
        }
    }

    /* loaded from: classes13.dex */
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
        if (this.kSc.onTouchEvent(motionEvent)) {
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
        this.kSb.tX(z);
    }

    public VideoTitleData KZ(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.kye)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.kye.size()) {
                        break;
                    } else if (this.kye.get(i2) == null || !group.equals(this.kye.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.kye.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
