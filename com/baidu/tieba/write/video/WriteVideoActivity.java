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
    private final NewWriteModel.d dyA;
    private NewWriteModel dym;
    private c gLm;
    private DialogInterface.OnCancelListener gfm;
    private String iKr;
    private e.a iqS;
    private e juK;
    private b kQp;
    private GestureDetector kQq;
    private com.baidu.tieba.write.b.c kQr;
    private int kQs;
    private VideoTitleData kQu;
    private boolean kQv;
    private Runnable kQw;
    private Runnable kQx;
    private a.InterfaceC0611a kko;
    private l kks;
    private int kwl;
    private String kwm;
    private List<VideoTitleData> kwn;
    private String mFromForumId;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private VideoTitleData mVideoTitleData;
    private final WriteData jWK = new WriteData();
    private Runnable kQt = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String gNY = "0";

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            this.kks = (l) runTask.getData();
        }
        this.iqS = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tieba.k.e.a
            public void yg(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.kQv = true;
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
                WriteVideoActivity.this.kQv = true;
                an anVar = new an("c12621");
                anVar.X("obj_locate", 0);
                anVar.X("obj_param1", z ? 1 : 0);
                TiebaStatic.log(anVar);
            }
        };
        this.kQw = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (!f.aLZ() || WriteVideoActivity.this.juK == null || WriteVideoActivity.this.kQv) {
                    if (WriteVideoActivity.this.dym != null) {
                        WriteVideoActivity.this.dym.cMj();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(WriteVideoActivity.this.kQw, 100L);
            }
        };
        this.dyA = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                File file;
                WriteVideoActivity.this.closeLoadingDialog();
                if (postWriteCallBackData != null && WriteVideoActivity.this.jWK != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                    if (WriteVideoActivity.this.jWK != null && WriteVideoActivity.this.jWK.getVideoInfo() != null && writeData != null) {
                        if (!z2 && WriteVideoActivity.this.jWK.getVideoInfo().getVideoDuration() > 8) {
                            writeData.setVideoReviewType(1);
                        } else {
                            writeData.setVideoReviewType(2);
                        }
                    }
                    WriteVideoActivity.this.kQp.cVp();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                    if (z) {
                        if (WriteVideoActivity.this.jWK != null && WriteVideoActivity.this.jWK.getVideoInfo() != null) {
                            File file2 = new File(com.baidu.tieba.video.c.kuO);
                            if (!file2.exists()) {
                                file2.mkdirs();
                            }
                            if (z3 && WriteVideoActivity.this.jWK.getVideoInfo().getVideoType() == 1) {
                                String str = com.baidu.tieba.video.c.kuO + file.getName();
                                m.copyFile(new File(WriteVideoActivity.this.jWK.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
                                WriteVideoActivity.this.bq(BdBaseApplication.getInst(), str);
                            }
                            WriteVideoActivity.this.cVg();
                            m.deleteFileOrDir(new File(com.baidu.tieba.video.c.kuN));
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.jWK.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.i(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.kQp.j(postWriteCallBackData);
                    } else if ((aaVar == null || writeData == null || aaVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (aaVar != null && writeData != null && aaVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(aaVar.getVcode_md5());
                        writeData.setVcodeUrl(aaVar.getVcode_pic_url());
                        writeData.setVcodeExtra(aaVar.aJG());
                        if (com.baidu.tbadk.s.a.wa(aaVar.aJF())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, aaVar.aJF())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        };
        this.kQx = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.gLm != null) {
                    WriteVideoActivity.this.gLm.setPercent(WriteVideoActivity.this.kQs);
                }
            }
        };
        this.kko = new a.InterfaceC0611a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.14
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0611a
            public void Cy(int i) {
                WriteVideoActivity.this.kQs = i;
                com.baidu.adp.lib.f.e.gx().post(WriteVideoActivity.this.kQx);
            }
        };
        this.gfm = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.cHS();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kQp = new b(this);
        setSwipeBackEnabled(false);
        cVd();
        if (this.jWK.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.kwm)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.kwm;
                this.kQp.a(this.jWK.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.kQp.a(this.jWK.getVideoInfo(), this.mVideoTitleData, this.kwn);
            }
        }
        if (this.kQp.cVl() != null) {
            this.kQp.cVl().d(this);
        }
        adjustResizeForSoftInput();
        this.kQq = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.kQp.cVn());
        this.kQp.cVn().requestFocus();
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
        if (this.jWK.getVideoInfo() != null && !StringUtils.isNull(this.jWK.getVideoInfo().getVideoPath())) {
            KX(this.jWK.getVideoInfo().getVideoPath());
        }
    }

    private void KX(String str) {
        if (f.aLZ()) {
            if (this.kks != null) {
                this.juK = this.kks.Fi(str);
            }
            if (this.juK != null) {
                this.juK.a(this.iqS);
                this.juK.cgz();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.f.e.gx().postDelayed(this.kQt, 500L);
        if (this.kQp != null) {
            this.kQp.cQJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.kQp != null) {
            this.kQp.bGk();
        }
    }

    private void cVd() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.jWK.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mFromForumId = intent.getStringExtra("forum_id");
            this.iKr = intent.getStringExtra("forum_name");
            this.kwl = intent.getIntExtra("pro_zone", -1);
            this.jWK.setForumId(this.mFromForumId);
            this.jWK.setForumName(this.iKr);
            this.jWK.setProZone(this.kwl);
            this.kwm = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.kwn = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (!StringUtils.isNull(this.iKr)) {
                this.kQp.La(this.iKr + getResources().getString(R.string.forum));
            } else {
                this.kQp.La(this.iKr);
            }
            this.gNY = intent.getStringExtra("KEY_CALL_FROM");
            if (EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY.equals(intent.getStringExtra("from_type"))) {
                this.kQp.cVj();
            }
            cVe();
        }
    }

    private void cVe() {
        this.kQr = new com.baidu.tieba.write.b.c(getPageContext().getPageActivity(), this.kQp.getCenterTitleView(), this.jWK.getProZone(), isUseStyleImmersiveSticky() ? StatusBarUtil.getStatusBarOffsetPx(getPageContext().getPageActivity()) : 0);
        this.kQr.a(new c.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // com.baidu.tieba.write.b.c.a
            public void Ei(int i) {
                WriteVideoActivity.this.jWK.setProZone(i);
            }
        });
        this.kQr.byv();
    }

    private void cVf() {
        if (StringUtils.isNull(this.mFromForumId) || Long.parseLong(this.mFromForumId) <= 0 || StringUtils.isNull(this.iKr)) {
            this.jWK.setCanNoForum(true);
        } else {
            this.jWK.setCanNoForum(false);
        }
        this.jWK.setForumName(this.iKr);
        this.jWK.setTitle(this.kQp.getContent());
        this.jWK.setContent("");
        this.jWK.setType(0);
        if (this.kQp.cVo() != null) {
            if (this.kQp.cVo().getState() == 0) {
                this.jWK.setPrivacy(false);
            } else {
                this.jWK.setPrivacy(true);
            }
        }
        this.jWK.setToDynamic(this.kQp.isToDynamic());
        if (this.kQp.cVl() != null) {
            this.jWK.setHasLocationData(this.kQp.cVl().brl());
        }
        this.jWK.setIsNoTitle(TextUtils.isEmpty(this.jWK.getTitle()));
    }

    private void aPo() {
        cHS();
        showLoadingDialog();
        this.kQu = KY(this.jWK != null ? this.jWK.getTitle() : "");
        if (this.dym == null) {
            this.dym = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.gNY)) {
            this.jWK.setCallFrom(this.gNY);
        }
        this.jWK.setPostLatLng(true);
        this.dym.d(this.jWK);
        this.dym.b(this.dyA);
        this.dym.a(this.kko);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.jWK.setLat(this.mLat);
            this.jWK.setLng(this.mLng);
            if (f.aLZ() && this.juK != null && !this.kQv) {
                com.baidu.adp.lib.f.e.gx().postDelayed(this.kQw, 100L);
            } else {
                this.dym.cMj();
            }
        } else if (ab.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.fK().a(true, new a.InterfaceC0016a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
                @Override // com.baidu.adp.lib.c.a.InterfaceC0016a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.jWK.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.jWK.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!f.aLZ() || WriteVideoActivity.this.juK == null || WriteVideoActivity.this.kQv) {
                        WriteVideoActivity.this.dym.cMj();
                    } else {
                        com.baidu.adp.lib.f.e.gx().postDelayed(WriteVideoActivity.this.kQw, 100L);
                    }
                }
            });
        } else if (f.aLZ() && this.juK != null && !this.kQv) {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.kQw, 100L);
        } else {
            this.dym.cMj();
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
    public void cVg() {
        VideoInfo videoInfo;
        if (this.jWK != null && (videoInfo = this.jWK.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.c.kuN)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true)) {
                        m.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.kuO + file.getName());
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
        this.gLm = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        this.gLm.setOnCancelListener(this.gfm);
        this.gLm.setCancelable(true);
        this.gLm.setCanceledOnTouchOutside(false);
        g.showDialog(this.gLm, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        cHS();
        destroyWaitingDialog();
        this.gfm = null;
        closeLoadingDialog();
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.kQx);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.gLm = null;
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
                if (this.kQp.cVq() != null) {
                    this.kQp.cVq().aU(postWriteCallBackData.getSensitiveWords());
                    if (!v.isEmpty(this.kQp.cVq().cUc())) {
                        this.kQp.tP(true);
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
            /* renamed from: aYH */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.jWK != null && WriteVideoActivity.this.jWK.getVideoInfo() != null && WriteVideoActivity.this.jWK.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.jWK.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.c.kuN) && (file = new File(WriteVideoActivity.this.jWK.getVideoInfo().getVideoPath())) != null) {
                    m.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.kuO + file.getName());
                }
                m.deleteFileOrDir(new File(com.baidu.tieba.video.c.kuN));
                return null;
            }
        }, new com.baidu.tbadk.util.l<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: a */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.kwm)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.iKr)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.kQu;
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
        this.kQp.onChangeSkinType(i);
        if (this.kQr != null) {
            this.kQr.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kQp != null) {
            this.kQp.bGk();
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.kQt);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.kQw);
    }

    protected void cHS() {
        if (this.dym != null) {
            this.dym.cancelLoadData();
        }
        if (this.kQp.cVl() != null) {
            this.kQp.cVl().cHS();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gLm != null && this.gLm.isShowing()) {
                g.b(this.gLm, getPageContext());
                return true;
            }
            cVh();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cVh() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.jW(R.string.give_up_video_confirm);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.cHS();
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
        if (view == this.kQp.cVm()) {
            if (b.kQz - this.kQp.cVk() < 0) {
                showToast(getResources().getString(R.string.video_content_overflow));
            } else if (this.kQp.cVq() != null && this.kQp.cVq().cUe()) {
                showToast(this.kQp.cVq().cUg());
                this.kQp.tP(true);
            } else {
                cVf();
                aPo();
            }
        } else if (view == this.kQp.getBackButton()) {
            cVh();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.gLm != null) {
            if (this.gLm.isShowing()) {
                g.b(this.gLm, getPageContext());
            }
            this.gLm = null;
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
        if (this.kQq.onTouchEvent(motionEvent)) {
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
        this.kQp.tQ(z);
    }

    public VideoTitleData KY(String str) {
        if (!StringUtils.isNull(str) && !v.isEmpty(this.kwn)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.kwn.size()) {
                        break;
                    } else if (this.kwn.get(i2) == null || !group.equals(this.kwn.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.kwn.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
