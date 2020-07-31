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
    private c ieR;
    private e.a jSL;
    private String kry;
    private a.InterfaceC0754a lRc;
    private l lRg;
    private String mFrom;
    private String mFromForumId;
    private InputMethodManager mInputManager;
    public String mLat;
    public String mLng;
    private VideoTitleData mVideoTitleData;
    private int mdn;
    private FrsTabInfoData mdo;
    private String mdp;
    private List<VideoTitleData> mdq;
    private b myY;
    private GestureDetector myZ;
    private int mza;
    private VideoTitleData mzc;
    private e mzd;
    private boolean mze;
    private Runnable mzg;
    private Runnable mzh;
    private final WriteData lCz = new WriteData();
    private Runnable mzb = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.1
        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(MotuVideoConfig.ACTION_FINISH_VIDEO_ALL_ACTIVITY);
            intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
            WriteVideoActivity.this.getPageContext().getPageActivity().sendBroadcast(intent);
        }
    };
    private String iik = "0";
    private boolean mzf = false;

    public WriteVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, l.class);
        if (runTask != null) {
            this.lRg = (l) runTask.getData();
        }
        this.jSL = new e.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.8
            @Override // com.baidu.tieba.k.e.a
            public void AK(int i) {
                if (i != 1) {
                    WriteVideoActivity.this.mze = true;
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
                WriteVideoActivity.this.mze = true;
                ap apVar = new ap("c12621");
                apVar.ah("obj_locate", 0);
                apVar.ah("obj_param1", z ? 1 : 0);
                TiebaStatic.log(apVar);
            }
        };
        this.mzg = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (!f.bgF() || WriteVideoActivity.this.mzd == null || WriteVideoActivity.this.mze) {
                    if (WriteVideoActivity.this.eBQ != null) {
                        WriteVideoActivity.this.eBQ.dmw();
                        return;
                    }
                    return;
                }
                com.baidu.adp.lib.f.e.lt().postDelayed(WriteVideoActivity.this.mzg, 100L);
            }
        };
        this.eCe = new NewWriteModel.d() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.12
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
                WriteVideoActivity.this.closeLoadingDialog();
                if (postWriteCallBackData != null && WriteVideoActivity.this.lCz != null) {
                    boolean z2 = com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(MotuVideoConfig.IS_SINGLE_GOD_USER, false);
                    if (WriteVideoActivity.this.lCz != null && WriteVideoActivity.this.lCz.getVideoInfo() != null && writeData != null) {
                        if (!z2 && WriteVideoActivity.this.lCz.getVideoInfo().getVideoDuration() > 8) {
                            writeData.setVideoReviewType(1);
                        } else {
                            writeData.setVideoReviewType(2);
                        }
                    }
                    WriteVideoActivity.this.myY.dvz();
                    boolean z3 = com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true);
                    if (z) {
                        if (WriteVideoActivity.this.lCz != null && WriteVideoActivity.this.lCz.getVideoInfo() != null) {
                            WriteVideoActivity.this.wu(z3);
                            postWriteCallBackData.mVideoMd5 = WriteVideoActivity.this.lCz.getVideoInfo().getVideoMd5();
                        }
                        WriteVideoActivity.this.i(postWriteCallBackData);
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                        WriteVideoActivity.this.showToast(postWriteCallBackData.getErrorString());
                        WriteVideoActivity.this.myY.j(postWriteCallBackData);
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
        this.mzh = new Runnable() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (WriteVideoActivity.this.ieR != null) {
                    WriteVideoActivity.this.ieR.setPercent(WriteVideoActivity.this.mza);
                }
            }
        };
        this.lRc = new a.InterfaceC0754a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.14
            @Override // com.baidu.tieba.tbadkCore.c.a.InterfaceC0754a
            public void Fv(int i) {
                WriteVideoActivity.this.mza = i;
                com.baidu.adp.lib.f.e.lt().post(WriteVideoActivity.this.mzh);
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
        this.myY = new b(this);
        setSwipeBackEnabled(false);
        dvn();
        this.myY.wv(this.mzf);
        if (this.lCz.getVideoInfo() != null) {
            if (!StringUtils.isNull(this.mdp)) {
                VideoTitleData videoTitleData = new VideoTitleData();
                videoTitleData.name = this.mdp;
                this.myY.a(this.lCz.getVideoInfo(), videoTitleData, (List<VideoTitleData>) null);
            } else {
                this.myY.a(this.lCz.getVideoInfo(), this.mVideoTitleData, this.mdq);
            }
        }
        if (this.myY.dvv() != null && !this.mzf) {
            this.myY.dvv().f(this);
        }
        this.myY.b(this.mdo);
        adjustResizeForSoftInput();
        this.myZ = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ShowSoftKeyPadDelay(this.myY.dvx());
        this.myY.dvx().requestFocus();
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
        if (this.lCz.getVideoInfo() != null && !StringUtils.isNull(this.lCz.getVideoInfo().getVideoPath())) {
            PO(this.lCz.getVideoInfo().getVideoPath());
        }
    }

    private void PO(String str) {
        if (f.bgF()) {
            if (this.lRg != null) {
                this.mzd = this.lRg.JR(str);
            }
            if (this.mzd != null) {
                this.mzd.a(this.jSL);
                this.mzd.cGm();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.baidu.adp.lib.f.e.lt().postDelayed(this.mzb, 500L);
        if (this.myY != null) {
            this.myY.drb();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.myY != null) {
            this.myY.cef();
        }
    }

    private void dvn() {
        Intent intent = getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.lCz.setVideoInfo((VideoInfo) serializableExtra);
            }
            this.mFromForumId = intent.getStringExtra("forum_id");
            this.kry = intent.getStringExtra("forum_name");
            this.mdn = intent.getIntExtra("pro_zone", -1);
            this.mFrom = intent.getStringExtra("from");
            this.lCz.setForumId(this.mFromForumId);
            this.lCz.setForumName(this.kry);
            this.lCz.setProZone(this.mdn);
            this.mdp = intent.getStringExtra("video_title");
            if (intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE) instanceof VideoTitleData) {
                this.mVideoTitleData = (VideoTitleData) intent.getSerializableExtra(WriteVideoActivityConfig.FORUM_VIDEO_TITLE);
            }
            if (intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE) instanceof List) {
                this.mdq = (List) intent.getSerializableExtra(WriteVideoActivityConfig.ALL_VIDEO_TITLE);
            }
            if (getIntent().getSerializableExtra("tab_list") instanceof FrsTabInfoData) {
                this.mdo = (FrsTabInfoData) getIntent().getSerializableExtra("tab_list");
            }
            if (!StringUtils.isNull(this.kry)) {
                this.myY.PR(this.kry + getResources().getString(R.string.forum));
            } else {
                this.myY.PR(this.kry);
            }
            this.iik = intent.getStringExtra("KEY_CALL_FROM");
            dvo();
            if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
                this.mzf = true;
            }
        }
    }

    private void dvo() {
        if (this.lCz != null && this.myY != null && this.myY.getCenterTitleView() != null) {
            TextView centerTitleView = this.myY.getCenterTitleView();
            if (this.lCz.getProZone() == 1) {
                centerTitleView.setText(R.string.write_zone_profession_title);
            }
        }
    }

    private void dvp() {
        if (StringUtils.isNull(this.mFromForumId) || Long.parseLong(this.mFromForumId) <= 0 || StringUtils.isNull(this.kry)) {
            this.lCz.setCanNoForum(true);
        } else {
            this.lCz.setCanNoForum(false);
        }
        this.lCz.setForumName(this.kry);
        this.lCz.setTitle(this.myY.getContent());
        this.lCz.setContent("");
        this.lCz.setType(0);
        if (this.myY.dvy() != null) {
            if (this.myY.dvy().getState() == 0) {
                this.lCz.setPrivacy(false);
            } else {
                this.lCz.setPrivacy(true);
            }
        }
        this.lCz.setToDynamic(this.myY.isToDynamic());
        if (this.myY.dvv() != null) {
            this.lCz.setHasLocationData(this.myY.dvv().bNz());
        }
        this.lCz.setIsNoTitle(TextUtils.isEmpty(this.lCz.getTitle()));
    }

    private void dvq() {
        showLoadingDialog();
        com.baidu.tieba.write.b.a.a(this.lCz, new a.InterfaceC0775a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9
            @Override // com.baidu.tieba.write.b.a.InterfaceC0775a
            public void a(BaseUploadData baseUploadData) {
                com.baidu.tieba.write.b.c.b.dvc().a((VideoUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.9.1
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
        }, this.lRc);
    }

    private void bjI() {
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.lCz.mDynamicVideoData = new VideoUploadData();
            dvq();
            return;
        }
        dhD();
        showLoadingDialog();
        this.mzc = PP(this.lCz != null ? this.lCz.getTitle() : "");
        if (this.eBQ == null) {
            this.eBQ = new NewWriteModel(this);
        }
        if (!TextUtils.isEmpty(this.iik)) {
            this.lCz.setCallFrom(this.iik);
        }
        this.lCz.setPostLatLng(true);
        dvr();
        this.eBQ.d(this.lCz);
        this.eBQ.b(this.eCe);
        this.eBQ.a(this.lRc);
        if (!TextUtils.isEmpty(this.mLat) && !TextUtils.isEmpty(this.mLng)) {
            this.lCz.setLat(this.mLat);
            this.lCz.setLng(this.mLng);
            if (f.bgF() && this.mzd != null && !this.mze) {
                com.baidu.adp.lib.f.e.lt().postDelayed(this.mzg, 100L);
            } else {
                this.eBQ.dmw();
            }
        } else if (com.baidu.tbadk.core.util.ad.checkLocationForBaiduLocation(getPageContext().getPageActivity())) {
            com.baidu.adp.lib.c.a.kG().a(true, new a.InterfaceC0021a() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.10
                @Override // com.baidu.adp.lib.c.a.InterfaceC0021a
                public void onLocationGeted(int i, String str, Address address) {
                    if (i == 0 && address != null) {
                        WriteVideoActivity.this.mLat = String.valueOf(address.getLatitude());
                        WriteVideoActivity.this.mLng = String.valueOf(address.getLongitude());
                        WriteVideoActivity.this.lCz.setLat(WriteVideoActivity.this.mLat);
                        WriteVideoActivity.this.lCz.setLng(WriteVideoActivity.this.mLng);
                    }
                    if (!f.bgF() || WriteVideoActivity.this.mzd == null || WriteVideoActivity.this.mze) {
                        WriteVideoActivity.this.eBQ.dmw();
                    } else {
                        com.baidu.adp.lib.f.e.lt().postDelayed(WriteVideoActivity.this.mzg, 100L);
                    }
                }
            });
        } else if (f.bgF() && this.mzd != null && !this.mze) {
            com.baidu.adp.lib.f.e.lt().postDelayed(this.mzg, 100L);
        } else {
            this.eBQ.dmw();
        }
    }

    private void dvr() {
        FrsTabItemData selectedTabItemData;
        if (this.lCz != null && this.myY != null && this.myY.dvt() != null && (selectedTabItemData = this.myY.dvt().getSelectedTabItemData()) != null) {
            this.lCz.setTabId(selectedTabItemData.tabId);
            this.lCz.setTabName(selectedTabItemData.name);
            this.lCz.setIsGeneralTab(selectedTabItemData.isGeneralTab);
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
        File file2 = new File(com.baidu.tieba.video.c.mbO);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        if (z && this.lCz.getVideoInfo().getVideoType() == 1) {
            String str = com.baidu.tieba.video.c.mbO + file.getName();
            n.copyFile(new File(this.lCz.getVideoInfo().getVideoPath()).getAbsolutePath(), str);
            aZ(BdBaseApplication.getInst(), str);
        }
        dvs();
        n.deleteFileOrDir(new File(com.baidu.tieba.video.c.mbN));
    }

    private void dvs() {
        VideoInfo videoInfo;
        if (this.lCz != null && (videoInfo = this.lCz.getVideoInfo()) != null && videoInfo.getVideoType() == 2) {
            if ((videoInfo.isCompressedVideo() || videoInfo.getMusicListInfo() != null) && videoInfo.getVideoPath() != null && videoInfo.getVideoPath().contains(com.baidu.tieba.video.c.mbN)) {
                File file = new File(videoInfo.getVideoPath());
                if (file.exists() && file.isFile()) {
                    if (com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.WRITE_VIDEO_ACTIVITY_SAVE_VIDEO, true)) {
                        n.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.mbO + file.getName());
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
        this.ieR = new c(getPageContext().getPageActivity());
        this.ieR.setOnCancelListener(this.hwp);
        this.ieR.setCancelable(true);
        this.ieR.setCanceledOnTouchOutside(false);
        g.showDialog(this.ieR, getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        dhD();
        destroyWaitingDialog();
        this.hwp = null;
        closeLoadingDialog();
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.mzh);
        super.finish();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void destroyWaitingDialog() {
        this.ieR = null;
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
                if (this.myY.dvA() != null) {
                    this.myY.dvA().aZ(postWriteCallBackData.getSensitiveWords());
                    if (!x.isEmpty(this.myY.dvA().dtY())) {
                        this.myY.ww(true);
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
                if (WriteVideoActivity.this.lCz != null && WriteVideoActivity.this.lCz.getVideoInfo() != null && WriteVideoActivity.this.lCz.getVideoInfo().getVideoPath() != null && WriteVideoActivity.this.lCz.getVideoInfo().getVideoPath().contains(com.baidu.tieba.video.c.mbN) && (file = new File(WriteVideoActivity.this.lCz.getVideoInfo().getVideoPath())) != null) {
                    n.copyFile(file.getAbsolutePath(), com.baidu.tieba.video.c.mbO + file.getName());
                }
                n.deleteFileOrDir(new File(com.baidu.tieba.video.c.mbN));
                return null;
            }
        }, new com.baidu.tbadk.util.l<Void>() { // from class: com.baidu.tieba.write.video.WriteVideoActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: a */
            public void onReturnDataInUI(Void r1) {
            }
        });
        if (!StringUtils.isNull(this.mdp)) {
            postWriteCallBackData.mFrom = 3;
        } else if (!StringUtils.isNull(this.kry)) {
            postWriteCallBackData.mFrom = 2;
        } else {
            postWriteCallBackData.mFrom = 1;
        }
        postWriteCallBackData.mVideoTitleData = this.mzc;
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
        this.myY.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.myY != null) {
            this.myY.cef();
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.mzb);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.mzg);
    }

    protected void dhD() {
        if (this.eBQ != null) {
            this.eBQ.cancelLoadData();
        }
        if (this.myY.dvv() != null) {
            this.myY.dvv().dhD();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.ieR != null && this.ieR.isShowing()) {
                g.b(this.ieR, getPageContext());
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
        if (view == this.myY.dvw()) {
            if (b.mzk - this.myY.dvu() < 0) {
                showToast(getResources().getString(R.string.video_content_overflow));
            } else if (this.myY.dvA() != null && this.myY.dvA().dua()) {
                showToast(this.myY.dvA().duc());
                this.myY.ww(true);
            } else {
                dvp();
                bjI();
            }
        } else if (view == this.myY.getBackButton()) {
            cfv();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.ieR != null) {
            if (this.ieR.isShowing()) {
                g.b(this.ieR, getPageContext());
            }
            this.ieR = null;
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
        if (this.myZ.onTouchEvent(motionEvent)) {
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
        this.myY.wx(z);
    }

    public VideoTitleData PP(String str) {
        if (!StringUtils.isNull(str) && !x.isEmpty(this.mdq)) {
            Matcher matcher = Pattern.compile("#(.+)#.*").matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.mdq.size()) {
                        break;
                    } else if (this.mdq.get(i2) == null || !group.equals(this.mdq.get(i2).name)) {
                        i = i2 + 1;
                    } else {
                        return this.mdq.get(i2);
                    }
                }
            }
        }
        return null;
    }
}
