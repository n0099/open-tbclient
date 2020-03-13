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
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
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
import com.baidu.tieba.compatible.StatusBarUtil;
import com.baidu.tieba.k.e;
import com.baidu.tieba.k.l;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.VideoTitleData;
import com.baidu.tieba.write.b.c;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes13.dex */
public class WriteVideoActivity extends BaseActivity<WriteVideoActivity> {
    private final NewWriteModel.d dyN;
    private NewWriteModel dyz;
    private c gLy;
    private DialogInterface.OnCancelListener gfz;
    private String iKD;
    private e.a ire;
    private e juW;
    private b kQB;
    private GestureDetector kQC;
    private com.baidu.tieba.write.b.c kQD;
    private int kQE;
    private VideoTitleData kQG;
    private boolean kQH;
    private Runnable kQI;
    private Runnable kQJ;
    private a.InterfaceC0611a kkA;
    private l kkE;
    private int kwx;
    private String kwy;
    private List<VideoTitleData> kwz;
    private String mFromForumId;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private VideoTitleData mVideoTitleData;
    private final WriteData jWW = new WriteData();
    private Runnable kQF = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String gOk = "0";

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            this.kkE = (l) runTask.getData();
        }
        this.ire = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tieba.k.e.a
            public void yg(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.kQH = true;
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
            public void oP(boolean z) {
                WriteVideoActivity.this.kQH = true;
                an anVar = new an("c12621");
                anVar.X("obj_locate", 0);
                anVar.X("obj_param1", z ? 1 : 0);
                TiebaStatic.log(anVar);
            }
        };
        this.kQI = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (!f.aMa() || WriteVideoActivity.this.juW == null || WriteVideoActivity.this.kQH) {
                    if (WriteVideoActivity.this.dyz != null) {
                        WriteVideoActivity.this.dyz.cMk();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(WriteVideoActivity.this.kQI, 100L);
            }
        };
        this.dyN = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                File file;
                WriteVideoActivity.this.closeLoadingDialog();
                if (postWriteCallBackData != null && WriteVideoActivity.this.jWW != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                    if (WriteVideoActivity.this.jWW != null && WriteVideoActivity.this.jWW.getVideoInfo() != null && writeData != null) {
                        if (!z2 && WriteVideoActivity.this.jWW.getVideoInfo().getVideoDuration() > 8) {
                            writeData.setVideoReviewType(1);
                        } else {
                            writeData.setVideoReviewType(2);
                        }
                    }
                    WriteVideoActivity.this.kQB.cVq();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                    if (z) {
                        if (WriteVideoActivity.this.jWW != null && WriteVideoActivity.this.jWW.getVideoInfo() != null) {
                            File file2 = new File(com.baidu.tieba.video.c.kva);
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            if (z3 && WriteVideoActivity.this.jWW.getVideoInfo().getVideoType() == 1) {
                                String str = com.baidu.tieba.video.c.kva + file.getName();
                                m.copyFile(new File(WriteVideoActivity.this.jWW.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
                                WriteVideoActivity.this.bq(BdBaseApplication.getInst(), str);
                            }
                            WriteVideoActivity.this.cVh();
                            m.deleteFileOrDir(new File(com.baidu.tieba.video.c.kuZ));
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.jWW.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.i(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.kQB.j(postWriteCallBackData);
                    } else if ((aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (aaVar != null && writeData != null && aaVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(aaVar.getVcode_md5());
                        writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                        writeData.setVcodeExtra(aaVar.aJH());
                        if (com.baidu.tbadk.s.a.wb(aaVar.aJG())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aJG())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        };
        this.kQJ = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.gLy != null) {
                    WriteVideoActivity.this.gLy.setPercent(WriteVideoActivity.this.kQE);
                }
            }
        };
        this.kkA = new a.InterfaceC0611a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.14
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0611a
            public void Cy(int i) {
                WriteVideoActivity.this.kQE = i;
                com.baidu.adp.lib.f.e.gx().post(WriteVideoActivity.this.kQJ);
            }
        };
        this.gfz = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.cHT();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kQB = new b(this);
        setSwipeBackEnabled(false);
        cVe();
        if (this.jWW.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.kwy)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.kwy;
                this.kQB.a(this.jWW.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.kQB.a(this.jWW.getVideoInfo(), this.mVideoTitleData, this.kwz);
            }
        }
        if (this.kQB.cVm() != null) {
            this.kQB.cVm().d(this);
        }
        adjustResizeForSoftInput();
        this.kQC = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.kQB.cVo());
        this.kQB.cVo().requestFocus();
        TiebaStatic.log(new an("c12307"));
        addGlobalLayoutListener();
        if (ab.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.fK().a(true, new a.InterfaceC0016a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.7
                @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                    }
                }
            });
        }
        if (this.jWW.getVideoInfo() != null && !StringUtils.isNull(this.jWW.getVideoInfo().getVideoPath())) {
            KY(this.jWW.getVideoInfo().getVideoPath());
        }
    }

    private void KY(String str) {
        if (f.aMa()) {
            if (this.kkE != null) {
                this.juW = this.kkE.Fj(str);
            }
            if (this.juW != null) {
                this.juW.a(this.ire);
                this.juW.cgA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.f.e.gx().postDelayed(this.kQF, 500L);
        if (this.kQB != null) {
            this.kQB.cQK();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.kQB != null) {
            this.kQB.bGl();
        }
    }

    private void cVe() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.jWW.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mFromForumId = intent.getStringExtra("forum_id");
            this.iKD = intent.getStringExtra("forum_name");
            this.kwx = intent.getIntExtra("pro_zone", -1);
            this.jWW.setForumId(this.mFromForumId);
            this.jWW.setForumName(this.iKD);
            this.jWW.setProZone(this.kwx);
            this.kwy = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.kwz = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (!StringUtils.isNull(this.iKD)) {
                this.kQB.Lb(this.iKD + getResources().getString(R.string.forum));
            } else {
                this.kQB.Lb(this.iKD);
            }
            this.gOk = intent.getStringExtra("KEY_CALL_FROM");
            if (EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY.equals(intent.getStringExtra("from_type"))) {
                this.kQB.cVk();
            }
            cVf();
        }
    }

    private void cVf() {
        this.kQD = new com.baidu.tieba.write.b.c(getPageContext().getPageActivity(), this.kQB.getCenterTitleView(), this.jWW.getProZone(), isUseStyleImmersiveSticky() ? StatusBarUtil.getStatusBarOffsetPx(getPageContext().getPageActivity()) : 0);
        this.kQD.a(new c.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // com.baidu.tieba.write.b.c.a
            public void Ei(int i) {
                WriteVideoActivity.this.jWW.setProZone(i);
            }
        });
        this.kQD.byw();
    }

    private void cVg() {
        if (StringUtils.isNull(this.mFromForumId) || Long.parseLong(this.mFromForumId) <= 0 || StringUtils.isNull(this.iKD)) {
            this.jWW.setCanNoForum(true);
        } else {
            this.jWW.setCanNoForum(false);
        }
        this.jWW.setForumName(this.iKD);
        this.jWW.setTitle(this.kQB.getContent());
        this.jWW.setContent("");
        this.jWW.setType(0);
        if (this.kQB.cVp() != null) {
            if (this.kQB.cVp().getState() == 0) {
                this.jWW.setPrivacy(false);
            } else {
                this.jWW.setPrivacy(true);
            }
        }
        this.jWW.setToDynamic(this.kQB.isToDynamic());
        if (this.kQB.cVm() != null) {
            this.jWW.setHasLocationData(this.kQB.cVm().brm());
        }
        this.jWW.setIsNoTitle(TextUtils.isEmpty(this.jWW.getTitle()));
    }

    private void aPp() {
        cHT();
        showLoadingDialog();
        this.kQG = KZ(this.jWW != null ? this.jWW.getTitle() : "");
        if (this.dyz == null) {
            this.dyz = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.gOk)) {
            this.jWW.setCallFrom(this.gOk);
        }
        this.jWW.setPostLatLng(true);
        this.dyz.d(this.jWW);
        this.dyz.b(this.dyN);
        this.dyz.a(this.kkA);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.jWW.setLat(this.mLat);
            this.jWW.setLng(this.mLng);
            if (f.aMa() && this.juW != null && !this.kQH) {
                com.baidu.adp.lib.f.e.gx().postDelayed(this.kQI, 100L);
            } else {
                this.dyz.cMk();
            }
        } else if (ab.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.fK().a(true, new a.InterfaceC0016a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
                @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.jWW.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.jWW.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!f.aMa() || WriteVideoActivity.this.juW == null || WriteVideoActivity.this.kQH) {
                        WriteVideoActivity.this.dyz.cMk();
                    } else {
                        com.baidu.adp.lib.f.e.gx().postDelayed(WriteVideoActivity.this.kQI, 100L);
                    }
                }
            });
        } else if (f.aMa() && this.juW != null && !this.kQH) {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.kQI, 100L);
        } else {
            this.dyz.cMk();
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
    public void cVh() {
        VideoInfo videoInfo;
        if (this.jWW != null && (videoInfo = this.jWW.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.c.kuZ)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true)) {
                        m.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.kva + file.getName());
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
        this.gLy = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        this.gLy.setOnCancelListener(this.gfz);
        this.gLy.setCancelable(true);
        this.gLy.setCanceledOnTouchOutside(false);
        g.showDialog(this.gLy, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        cHT();
        destroyWaitingDialog();
        this.gfz = null;
        closeLoadingDialog();
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.kQJ);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.gLy = null;
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
                if (this.kQB.cVr() != null) {
                    this.kQB.cVr().aU(postWriteCallBackData.getSensitiveWords());
                    if (!v.isEmpty(this.kQB.cVr().cUd())) {
                        this.kQB.tP(true);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(PostWriteCallBackData postWriteCallBackData) {
        ac.a(new com.baidu.tbadk.util.ab<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: aYI */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.jWW != null && WriteVideoActivity.this.jWW.getVideoInfo() != null && WriteVideoActivity.this.jWW.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.jWW.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.c.kuZ) && (file = new File(WriteVideoActivity.this.jWW.getVideoInfo().getVideoPath())) != null) {
                    m.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.kva + file.getName());
                }
                m.deleteFileOrDir(new File(com.baidu.tieba.video.c.kuZ));
                return null;
            }
        }, new com.baidu.tbadk.util.l<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: a */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.kwy)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.iKD)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.kQG;
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
        this.kQB.onChangeSkinType(i);
        if (this.kQD != null) {
            this.kQD.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kQB != null) {
            this.kQB.bGl();
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.kQF);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.kQI);
    }

    protected void cHT() {
        if (this.dyz != null) {
            this.dyz.cancelLoadData();
        }
        if (this.kQB.cVm() != null) {
            this.kQB.cVm().cHT();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gLy != null && this.gLy.isShowing()) {
                g.b(this.gLy, getPageContext());
                return true;
            }
            cVi();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cVi() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.jW(R.string.give_up_video_confirm);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.cHT();
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
        aVar.b(getPageContext()).aEC();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kQB.cVn()) {
            if (b.kQL - this.kQB.cVl() < 0) {
                showToast(getResources().getString(R.string.video_content_overflow));
            } else if (this.kQB.cVr() != null && this.kQB.cVr().cUf()) {
                showToast(this.kQB.cVr().cUh());
                this.kQB.tP(true);
            } else {
                cVg();
                aPp();
            }
        } else if (view == this.kQB.getBackButton()) {
            cVi();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.gLy != null) {
            if (this.gLy.isShowing()) {
                g.b(this.gLy, getPageContext());
            }
            this.gLy = null;
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
        if (this.kQC.onTouchEvent(motionEvent)) {
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
        this.kQB.tQ(z);
    }

    public VideoTitleData KZ(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.kwz)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.kwz.size()) {
                        break;
                    } else if (this.kwz.get(i2) == null || !group.equals(this.kwz.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.kwz.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
