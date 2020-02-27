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
    private NewWriteModel dyl;
    private final NewWriteModel.d dyz;
    private c gLk;
    private DialogInterface.OnCancelListener gfk;
    private String iKp;
    private e.a iqQ;
    private e juI;
    private b kQn;
    private GestureDetector kQo;
    private com.baidu.tieba.write.b.c kQp;
    private int kQq;
    private VideoTitleData kQs;
    private boolean kQt;
    private Runnable kQu;
    private Runnable kQv;
    private a.InterfaceC0611a kkm;
    private l kkq;
    private int kwj;
    private String kwk;
    private List<VideoTitleData> kwl;
    private String mFromForumId;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private VideoTitleData mVideoTitleData;
    private final WriteData jWI = new WriteData();
    private Runnable kQr = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String gNW = "0";

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            this.kkq = (l) runTask.getData();
        }
        this.iqQ = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tieba.k.e.a
            public void yg(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.kQt = true;
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
                WriteVideoActivity.this.kQt = true;
                an anVar = new an("c12621");
                anVar.X("obj_locate", 0);
                anVar.X("obj_param1", z ? 1 : 0);
                TiebaStatic.log(anVar);
            }
        };
        this.kQu = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (!f.aLX() || WriteVideoActivity.this.juI == null || WriteVideoActivity.this.kQt) {
                    if (WriteVideoActivity.this.dyl != null) {
                        WriteVideoActivity.this.dyl.cMh();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(WriteVideoActivity.this.kQu, 100L);
            }
        };
        this.dyz = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                File file;
                WriteVideoActivity.this.closeLoadingDialog();
                if (postWriteCallBackData != null && WriteVideoActivity.this.jWI != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                    if (WriteVideoActivity.this.jWI != null && WriteVideoActivity.this.jWI.getVideoInfo() != null && writeData != null) {
                        if (!z2 && WriteVideoActivity.this.jWI.getVideoInfo().getVideoDuration() > 8) {
                            writeData.setVideoReviewType(1);
                        } else {
                            writeData.setVideoReviewType(2);
                        }
                    }
                    WriteVideoActivity.this.kQn.cVn();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                    if (z) {
                        if (WriteVideoActivity.this.jWI != null && WriteVideoActivity.this.jWI.getVideoInfo() != null) {
                            File file2 = new File(com.baidu.tieba.video.c.kuM);
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            if (z3 && WriteVideoActivity.this.jWI.getVideoInfo().getVideoType() == 1) {
                                String str = com.baidu.tieba.video.c.kuM + file.getName();
                                m.copyFile(new File(WriteVideoActivity.this.jWI.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
                                WriteVideoActivity.this.bq(BdBaseApplication.getInst(), str);
                            }
                            WriteVideoActivity.this.cVe();
                            m.deleteFileOrDir(new File(com.baidu.tieba.video.c.kuL));
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.jWI.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.i(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.kQn.j(postWriteCallBackData);
                    } else if ((aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (aaVar != null && writeData != null && aaVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(aaVar.getVcode_md5());
                        writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                        writeData.setVcodeExtra(aaVar.aJE());
                        if (com.baidu.tbadk.s.a.wa(aaVar.aJD())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aJD())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        };
        this.kQv = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.gLk != null) {
                    WriteVideoActivity.this.gLk.setPercent(WriteVideoActivity.this.kQq);
                }
            }
        };
        this.kkm = new a.InterfaceC0611a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.14
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0611a
            public void Cy(int i) {
                WriteVideoActivity.this.kQq = i;
                com.baidu.adp.lib.f.e.gx().post(WriteVideoActivity.this.kQv);
            }
        };
        this.gfk = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.cHQ();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kQn = new b(this);
        setSwipeBackEnabled(false);
        cVb();
        if (this.jWI.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.kwk)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.kwk;
                this.kQn.a(this.jWI.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.kQn.a(this.jWI.getVideoInfo(), this.mVideoTitleData, this.kwl);
            }
        }
        if (this.kQn.cVj() != null) {
            this.kQn.cVj().d(this);
        }
        adjustResizeForSoftInput();
        this.kQo = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.kQn.cVl());
        this.kQn.cVl().requestFocus();
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
        if (this.jWI.getVideoInfo() != null && !StringUtils.isNull(this.jWI.getVideoInfo().getVideoPath())) {
            KX(this.jWI.getVideoInfo().getVideoPath());
        }
    }

    private void KX(String str) {
        if (f.aLX()) {
            if (this.kkq != null) {
                this.juI = this.kkq.Fi(str);
            }
            if (this.juI != null) {
                this.juI.a(this.iqQ);
                this.juI.cgx();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.f.e.gx().postDelayed(this.kQr, 500L);
        if (this.kQn != null) {
            this.kQn.cQH();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.kQn != null) {
            this.kQn.bGi();
        }
    }

    private void cVb() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.jWI.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mFromForumId = intent.getStringExtra("forum_id");
            this.iKp = intent.getStringExtra("forum_name");
            this.kwj = intent.getIntExtra("pro_zone", -1);
            this.jWI.setForumId(this.mFromForumId);
            this.jWI.setForumName(this.iKp);
            this.jWI.setProZone(this.kwj);
            this.kwk = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.kwl = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (!StringUtils.isNull(this.iKp)) {
                this.kQn.La(this.iKp + getResources().getString(R.string.forum));
            } else {
                this.kQn.La(this.iKp);
            }
            this.gNW = intent.getStringExtra("KEY_CALL_FROM");
            if (EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY.equals(intent.getStringExtra("from_type"))) {
                this.kQn.cVh();
            }
            cVc();
        }
    }

    private void cVc() {
        this.kQp = new com.baidu.tieba.write.b.c(getPageContext().getPageActivity(), this.kQn.getCenterTitleView(), this.jWI.getProZone(), isUseStyleImmersiveSticky() ? StatusBarUtil.getStatusBarOffsetPx(getPageContext().getPageActivity()) : 0);
        this.kQp.a(new c.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // com.baidu.tieba.write.b.c.a
            public void Ei(int i) {
                WriteVideoActivity.this.jWI.setProZone(i);
            }
        });
        this.kQp.byt();
    }

    private void cVd() {
        if (StringUtils.isNull(this.mFromForumId) || Long.parseLong(this.mFromForumId) <= 0 || StringUtils.isNull(this.iKp)) {
            this.jWI.setCanNoForum(true);
        } else {
            this.jWI.setCanNoForum(false);
        }
        this.jWI.setForumName(this.iKp);
        this.jWI.setTitle(this.kQn.getContent());
        this.jWI.setContent("");
        this.jWI.setType(0);
        if (this.kQn.cVm() != null) {
            if (this.kQn.cVm().getState() == 0) {
                this.jWI.setPrivacy(false);
            } else {
                this.jWI.setPrivacy(true);
            }
        }
        this.jWI.setToDynamic(this.kQn.isToDynamic());
        if (this.kQn.cVj() != null) {
            this.jWI.setHasLocationData(this.kQn.cVj().brj());
        }
        this.jWI.setIsNoTitle(TextUtils.isEmpty(this.jWI.getTitle()));
    }

    private void aPm() {
        cHQ();
        showLoadingDialog();
        this.kQs = KY(this.jWI != null ? this.jWI.getTitle() : "");
        if (this.dyl == null) {
            this.dyl = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.gNW)) {
            this.jWI.setCallFrom(this.gNW);
        }
        this.jWI.setPostLatLng(true);
        this.dyl.d(this.jWI);
        this.dyl.b(this.dyz);
        this.dyl.a(this.kkm);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.jWI.setLat(this.mLat);
            this.jWI.setLng(this.mLng);
            if (f.aLX() && this.juI != null && !this.kQt) {
                com.baidu.adp.lib.f.e.gx().postDelayed(this.kQu, 100L);
            } else {
                this.dyl.cMh();
            }
        } else if (ab.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.fK().a(true, new a.InterfaceC0016a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
                @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.jWI.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.jWI.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!f.aLX() || WriteVideoActivity.this.juI == null || WriteVideoActivity.this.kQt) {
                        WriteVideoActivity.this.dyl.cMh();
                    } else {
                        com.baidu.adp.lib.f.e.gx().postDelayed(WriteVideoActivity.this.kQu, 100L);
                    }
                }
            });
        } else if (f.aLX() && this.juI != null && !this.kQt) {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.kQu, 100L);
        } else {
            this.dyl.cMh();
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
    public void cVe() {
        VideoInfo videoInfo;
        if (this.jWI != null && (videoInfo = this.jWI.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.c.kuL)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true)) {
                        m.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.kuM + file.getName());
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
        this.gLk = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        this.gLk.setOnCancelListener(this.gfk);
        this.gLk.setCancelable(true);
        this.gLk.setCanceledOnTouchOutside(false);
        g.showDialog(this.gLk, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        cHQ();
        destroyWaitingDialog();
        this.gfk = null;
        closeLoadingDialog();
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.kQv);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.gLk = null;
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
                if (this.kQn.cVo() != null) {
                    this.kQn.cVo().aU(postWriteCallBackData.getSensitiveWords());
                    if (!v.isEmpty(this.kQn.cVo().cUa())) {
                        this.kQn.tP(true);
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
            /* renamed from: aYF */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.jWI != null && WriteVideoActivity.this.jWI.getVideoInfo() != null && WriteVideoActivity.this.jWI.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.jWI.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.c.kuL) && (file = new File(WriteVideoActivity.this.jWI.getVideoInfo().getVideoPath())) != null) {
                    m.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.kuM + file.getName());
                }
                m.deleteFileOrDir(new File(com.baidu.tieba.video.c.kuL));
                return null;
            }
        }, new com.baidu.tbadk.util.l<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: a */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.kwk)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.iKp)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.kQs;
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
        this.kQn.onChangeSkinType(i);
        if (this.kQp != null) {
            this.kQp.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kQn != null) {
            this.kQn.bGi();
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.kQr);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.kQu);
    }

    protected void cHQ() {
        if (this.dyl != null) {
            this.dyl.cancelLoadData();
        }
        if (this.kQn.cVj() != null) {
            this.kQn.cVj().cHQ();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gLk != null && this.gLk.isShowing()) {
                g.b(this.gLk, getPageContext());
                return true;
            }
            cVf();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cVf() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.jW(R.string.give_up_video_confirm);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.cHQ();
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
        aVar.b(getPageContext()).aEA();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.kQn.cVk()) {
            if (b.kQx - this.kQn.cVi() < 0) {
                showToast(getResources().getString(R.string.video_content_overflow));
            } else if (this.kQn.cVo() != null && this.kQn.cVo().cUc()) {
                showToast(this.kQn.cVo().cUe());
                this.kQn.tP(true);
            } else {
                cVd();
                aPm();
            }
        } else if (view == this.kQn.getBackButton()) {
            cVf();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.gLk != null) {
            if (this.gLk.isShowing()) {
                g.b(this.gLk, getPageContext());
            }
            this.gLk = null;
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
        if (this.kQo.onTouchEvent(motionEvent)) {
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
        this.kQn.tQ(z);
    }

    public VideoTitleData KY(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.kwl)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.kwl.size()) {
                        break;
                    } else if (this.kwl.get(i2) == null || !group.equals(this.kwl.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.kwl.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
