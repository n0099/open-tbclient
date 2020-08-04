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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ad;
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
    private NewWriteModel eBQ;
    private final NewWriteModel.d eCe;
    private DialogInterface.OnCancelListener hwp;
    private c ieT;
    private e.a jSN;
    private String krA;
    private a.InterfaceC0754a lRe;
    private l lRi;
    private String mFrom;
    private String mFromForumId;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private VideoTitleData mVideoTitleData;
    private int mdp;
    private FrsTabInfoData mdq;
    private String mdr;
    private List<VideoTitleData> mds;
    private b mza;
    private GestureDetector mzb;
    private int mzc;
    private VideoTitleData mze;
    private e mzf;
    private boolean mzg;
    private Runnable mzi;
    private Runnable mzj;
    private final WriteData lCB = new WriteData();
    private Runnable mzd = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String iim = "0";
    private boolean mzh = false;

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            this.lRi = (l) runTask.getData();
        }
        this.jSN = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tieba.k.e.a
            public void AK(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.mzg = true;
                    return;
                }
                ap apVar = new ap("c12620");
                apVar.ah("obj_locate", 0);
                TiebaStatic.log(apVar);
            }

            @Override // com.baidu.tieba.k.e.a
            public void onChange(boolean z) {
            }

            @Override // com.baidu.tieba.k.e.a
            public void rn(boolean z) {
                WriteVideoActivity.this.mzg = true;
                ap apVar = new ap("c12621");
                apVar.ah("obj_locate", 0);
                apVar.ah("obj_param1", z ? 1 : 0);
                TiebaStatic.log(apVar);
            }
        };
        this.mzi = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (!f.bgF() || WriteVideoActivity.this.mzf == null || WriteVideoActivity.this.mzg) {
                    if (WriteVideoActivity.this.eBQ != null) {
                        WriteVideoActivity.this.eBQ.dmx();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.f.e.lt().postDelayed(WriteVideoActivity.this.mzi, 100L);
            }
        };
        this.eCe = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
                WriteVideoActivity.this.closeLoadingDialog();
                if (postWriteCallBackData != null && WriteVideoActivity.this.lCB != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                    if (WriteVideoActivity.this.lCB != null && WriteVideoActivity.this.lCB.getVideoInfo() != null && writeData != null) {
                        if (!z2 && WriteVideoActivity.this.lCB.getVideoInfo().getVideoDuration() > 8) {
                            writeData.setVideoReviewType(1);
                        } else {
                            writeData.setVideoReviewType(2);
                        }
                    }
                    WriteVideoActivity.this.mza.dvA();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                    if (z) {
                        if (WriteVideoActivity.this.lCB != null && WriteVideoActivity.this.lCB.getVideoInfo() != null) {
                            WriteVideoActivity.this.wu(z3);
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.lCB.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.i(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.mza.j(postWriteCallBackData);
                    } else if ((adVar == null || writeData == null || adVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                        WriteVideoActivity.this.c(false, postWriteCallBackData);
                    } else if (adVar != null && writeData != null && adVar.getVcode_pic_url() != null) {
                        writeData.setVcodeMD5(adVar.getVcode_md5());
                        writeData.setVcodeUrl(adVar.getVcode_pic_url());
                        writeData.setVcodeExtra(adVar.bep());
                        if (com.baidu.tbadk.t.a.Ay(adVar.beo())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NewVcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, adVar.beo())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VcodeActivityConfig(WriteVideoActivity.this.getPageContext().getPageActivity(), writeData, RequestResponseCode.REQUEST_VCODE)));
                        }
                    } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(WriteVideoActivity.this.getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                    }
                }
            }
        };
        this.mzj = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.ieT != null) {
                    WriteVideoActivity.this.ieT.setPercent(WriteVideoActivity.this.mzc);
                }
            }
        };
        this.lRe = new a.InterfaceC0754a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.14
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0754a
            public void Fv(int i) {
                WriteVideoActivity.this.mzc = i;
                com.baidu.adp.lib.f.e.lt().post(WriteVideoActivity.this.mzj);
            }
        };
        this.hwp = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteVideoActivity.this.destroyWaitingDialog();
                WriteVideoActivity.this.dhD();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mza = new b(this);
        setSwipeBackEnabled(false);
        dvo();
        this.mza.wv(this.mzh);
        if (this.lCB.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.mdr)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.mdr;
                this.mza.a(this.lCB.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.mza.a(this.lCB.getVideoInfo(), this.mVideoTitleData, this.mds);
            }
        }
        if (this.mza.dvw() != null && !this.mzh) {
            this.mza.dvw().f(this);
        }
        this.mza.b(this.mdq);
        adjustResizeForSoftInput();
        this.mzb = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.mza.dvy());
        this.mza.dvy().requestFocus();
        TiebaStatic.log(new ap("c12307"));
        addGlobalLayoutListener();
        if (com.baidu.tbadk.core.util.ad.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.kG().a(true, new a.InterfaceC0021a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.7
                @Override // com.baidu.adp.lib.c.a.InterfaceC0021a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                    }
                }
            });
        }
        if (this.lCB.getVideoInfo() != null && !StringUtils.isNull(this.lCB.getVideoInfo().getVideoPath())) {
            PO(this.lCB.getVideoInfo().getVideoPath());
        }
    }

    private void PO(String str) {
        if (f.bgF()) {
            if (this.lRi != null) {
                this.mzf = this.lRi.JR(str);
            }
            if (this.mzf != null) {
                this.mzf.a(this.jSN);
                this.mzf.cGm();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.f.e.lt().postDelayed(this.mzd, 500L);
        if (this.mza != null) {
            this.mza.drc();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mza != null) {
            this.mza.cef();
        }
    }

    private void dvo() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.lCB.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mFromForumId = intent.getStringExtra("forum_id");
            this.krA = intent.getStringExtra("forum_name");
            this.mdp = intent.getIntExtra("pro_zone", -1);
            this.mFrom = intent.getStringExtra("from");
            this.lCB.setForumId(this.mFromForumId);
            this.lCB.setForumName(this.krA);
            this.lCB.setProZone(this.mdp);
            this.mdr = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.mds = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
                this.mdq = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
            }
            if (!StringUtils.isNull(this.krA)) {
                this.mza.PR(this.krA + getResources().getString(R.string.forum));
            } else {
                this.mza.PR(this.krA);
            }
            this.iim = intent.getStringExtra("KEY_CALL_FROM");
            dvp();
            if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
                this.mzh = true;
            }
        }
    }

    private void dvp() {
        if (this.lCB != null && this.mza != null && this.mza.getCenterTitleView() != null) {
            TextView centerTitleView = this.mza.getCenterTitleView();
            if (this.lCB.getProZone() == 1) {
                centerTitleView.setText(R.string.write_zone_profession_title);
            }
        }
    }

    private void dvq() {
        if (StringUtils.isNull(this.mFromForumId) || Long.parseLong(this.mFromForumId) <= 0 || StringUtils.isNull(this.krA)) {
            this.lCB.setCanNoForum(true);
        } else {
            this.lCB.setCanNoForum(false);
        }
        this.lCB.setForumName(this.krA);
        this.lCB.setTitle(this.mza.getContent());
        this.lCB.setContent("");
        this.lCB.setType(0);
        if (this.mza.dvz() != null) {
            if (this.mza.dvz().getState() == 0) {
                this.lCB.setPrivacy(false);
            } else {
                this.lCB.setPrivacy(true);
            }
        }
        this.lCB.setToDynamic(this.mza.isToDynamic());
        if (this.mza.dvw() != null) {
            this.lCB.setHasLocationData(this.mza.dvw().bNz());
        }
        this.lCB.setIsNoTitle(TextUtils.isEmpty(this.lCB.getTitle()));
    }

    private void dvr() {
        showLoadingDialog();
        com.baidu.tieba.write.b.a.a(this.lCB, new a.InterfaceC0775a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // com.baidu.tieba.write.b.a.InterfaceC0775a
            public void a(BaseUploadData baseUploadData) {
                com.baidu.tieba.write.b.c.b.dvd().a((VideoUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9.1
                    @Override // com.baidu.tieba.write.b.c.b.a
                    public void onSuccess(String str) {
                        WriteVideoActivity.this.wu(com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true));
                        WriteVideoActivity.this.closeLoadingDialog();
                        PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData();
                        postWriteCallBackData.setDyamicCallback(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS, postWriteCallBackData));
                        WriteVideoActivity.this.finish();
                        com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.publish_dynamic_success);
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

            @Override // com.baidu.tieba.write.b.a.InterfaceC0775a
            public void onError() {
                WriteVideoActivity.this.closeLoadingDialog();
                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst(), R.string.publish_dynamic_error);
            }
        }, this.lRe);
    }

    private void bjI() {
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.lCB.mDynamicVideoData = new VideoUploadData();
            dvr();
            return;
        }
        dhD();
        showLoadingDialog();
        this.mze = PP(this.lCB != null ? this.lCB.getTitle() : "");
        if (this.eBQ == null) {
            this.eBQ = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.iim)) {
            this.lCB.setCallFrom(this.iim);
        }
        this.lCB.setPostLatLng(true);
        dvs();
        this.eBQ.d(this.lCB);
        this.eBQ.b(this.eCe);
        this.eBQ.a(this.lRe);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.lCB.setLat(this.mLat);
            this.lCB.setLng(this.mLng);
            if (f.bgF() && this.mzf != null && !this.mzg) {
                com.baidu.adp.lib.f.e.lt().postDelayed(this.mzi, 100L);
            } else {
                this.eBQ.dmx();
            }
        } else if (com.baidu.tbadk.core.util.ad.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.kG().a(true, new a.InterfaceC0021a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
                @Override // com.baidu.adp.lib.c.a.InterfaceC0021a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.lCB.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.lCB.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!f.bgF() || WriteVideoActivity.this.mzf == null || WriteVideoActivity.this.mzg) {
                        WriteVideoActivity.this.eBQ.dmx();
                    } else {
                        com.baidu.adp.lib.f.e.lt().postDelayed(WriteVideoActivity.this.mzi, 100L);
                    }
                }
            });
        } else if (f.bgF() && this.mzf != null && !this.mzg) {
            com.baidu.adp.lib.f.e.lt().postDelayed(this.mzi, 100L);
        } else {
            this.eBQ.dmx();
        }
    }

    private void dvs() {
        FrsTabItemData selectedTabItemData;
        if (this.lCB != null && this.mza != null && this.mza.dvu() != null && (selectedTabItemData = this.mza.dvu().getSelectedTabItemData()) != null) {
            this.lCB.setTabId(selectedTabItemData.tabId);
            this.lCB.setTabName(selectedTabItemData.name);
            this.lCB.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    private void aZ(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    new y(context).saveVideo(str);
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
    public void wu(boolean z) {
        File file;
        File file2 = new File(com.baidu.tieba.video.c.mbQ);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        if (z && this.lCB.getVideoInfo().getVideoType() == 1) {
            String str = com.baidu.tieba.video.c.mbQ + file.getName();
            n.copyFile(new File(this.lCB.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
            aZ(BdBaseApplication.getInst(), str);
        }
        dvt();
        n.deleteFileOrDir(new File(com.baidu.tieba.video.c.mbP));
    }

    private void dvt() {
        VideoInfo videoInfo;
        if (this.lCB != null && (videoInfo = this.lCB.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.c.mbP)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true)) {
                        n.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.mbQ + file.getName());
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
            if (AntiHelper.bB(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                AntiHelper.aW(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
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
        this.ieT = new c(getPageContext().getPageActivity());
        this.ieT.setOnCancelListener(this.hwp);
        this.ieT.setCancelable(true);
        this.ieT.setCanceledOnTouchOutside(false);
        g.showDialog(this.ieT, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        dhD();
        destroyWaitingDialog();
        this.hwp = null;
        closeLoadingDialog();
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.mzj);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.ieT = null;
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
                if (this.mza.dvB() != null) {
                    this.mza.dvB().aZ(postWriteCallBackData.getSensitiveWords());
                    if (!x.isEmpty(this.mza.dvB().dtZ())) {
                        this.mza.ww(true);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(PostWriteCallBackData postWriteCallBackData) {
        com.baidu.tbadk.util.ad.a(new ac<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: bsE */
            public Void doInBackground() {
                File file;
                if (WriteVideoActivity.this.lCB != null && WriteVideoActivity.this.lCB.getVideoInfo() != null && WriteVideoActivity.this.lCB.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.lCB.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.c.mbP) && (file = new File(WriteVideoActivity.this.lCB.getVideoInfo().getVideoPath())) != null) {
                    n.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.mbQ + file.getName());
                }
                n.deleteFileOrDir(new File(com.baidu.tieba.video.c.mbP));
                return null;
            }
        }, new com.baidu.tbadk.util.l<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: a */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.mdr)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.krA)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.mze;
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
        this.mza.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mza != null) {
            this.mza.cef();
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.mzd);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.mzi);
    }

    protected void dhD() {
        if (this.eBQ != null) {
            this.eBQ.cancelLoadData();
        }
        if (this.mza.dvw() != null) {
            this.mza.dvw().dhD();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.ieT != null && this.ieT.isShowing()) {
                g.b(this.ieT, getPageContext());
                return true;
            }
            cfv();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cfv() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.ln(R.string.give_up_video_confirm);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                WriteVideoActivity.this.dhD();
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
        aVar.b(getPageContext()).aYL();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mza.dvx()) {
            if (b.mzm - this.mza.dvv() < 0) {
                showToast(getResources().getString(R.string.video_content_overflow));
            } else if (this.mza.dvB() != null && this.mza.dvB().dub()) {
                showToast(this.mza.dvB().dud());
                this.mza.ww(true);
            } else {
                dvq();
                bjI();
            }
        } else if (view == this.mza.getBackButton()) {
            cfv();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.ieT != null) {
            if (this.ieT.isShowing()) {
                g.b(this.ieT, getPageContext());
            }
            this.ieT = null;
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
        if (this.mzb.onTouchEvent(motionEvent)) {
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
        this.mza.wx(z);
    }

    public VideoTitleData PP(String str) {
        if (!StringUtils.isNull(str) && !x.isEmpty(this.mds)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.mds.size()) {
                        break;
                    } else if (this.mds.get(i2) == null || !group.equals(this.mds.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.mds.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
