package com.baidu.tieba.video.record;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.SapiSafeFacade;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.tieba.video.localvideo.b;
import com.baidu.tieba.video.record.RecordLayout;
import com.baidu.tieba.video.record.RecordTabLayout;
import com.baidu.tieba.video.record.VideoControllerLayout;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import com.baidu.tieba.video.record.g;
import com.baidu.tieba.video.record.h;
import com.baidu.tieba.video.record.i;
import com.baidu.tieba.video.record.m;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class RecordVideoActivity extends BaseActivity implements RecordLayout.a, RecordTabLayout.a, VideoControllerLayout.a, VideoEffectButtonLayout.a, VideoEffectLayout.a, g.a, i.c {
    private final CustomMessageListener cXY;
    private ImageView drL;
    private com.baidu.tieba.i.h gAg;
    private String gOt;
    private SelectMusicModel gOx;
    private com.baidu.tieba.video.f gRG;
    private String gRH;
    private b.a gRO;
    private Handler gRP;
    private j gTI;
    protected i gTR;
    private b gUD;
    private PreviewViewContainer gVA;
    private TextView gVB;
    private VideoEffectButtonLayout gVC;
    private TextView gVD;
    private View gVE;
    private RoundProgressBar gVF;
    private TextView gVG;
    private AnimatorSet gVH;
    private AnimatorSet gVI;
    private ScaleAnimation gVJ;
    private ObjectAnimator gVK;
    private ObjectAnimator gVL;
    private int gVM;
    private ForumWriteData gVN;
    private boolean gVO;
    private m gVQ;
    private StickerItem gVR;
    protected k gVS;
    private RecordTabLayout gVT;
    private ImageFileInfo gVU;
    private HttpMessageListener gVV;
    private boolean gVW;
    private RecordLayout gVt;
    private VideoControllerLayout gVu;
    private RelativeLayout gVv;
    private ImageView gVw;
    private ImageView gVx;
    private ImageView gVy;
    private com.baidu.tbadk.core.dialog.a gVz;
    private int glX;
    private Context mContext;
    private WriteImagesInfo mWriteImagesInfo;
    private boolean gVP = true;
    private boolean gRK = false;
    private boolean gRI = false;
    private boolean gRJ = false;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.gAg = kVar.aOb();
        }
        if (this.gAg != null) {
            this.gAg.aNJ();
        }
        this.gRP = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                RecordVideoActivity.this.gRP.removeMessages(5);
                switch (message.what) {
                    case 1:
                        removeMessages(1);
                        RecordVideoActivity.this.gRP.sendMessageDelayed(RecordVideoActivity.this.gRP.obtainMessage(5), 60000L);
                        return;
                    case 2:
                        if (!RecordVideoActivity.this.gRK) {
                            RecordVideoActivity.this.gRH = null;
                            RecordVideoActivity.this.bDs();
                            RecordVideoActivity.this.vt(SapiSafeFacade.SAPIWEBVIEW_FINISH);
                        }
                        RecordVideoActivity.this.gRJ = false;
                        RecordVideoActivity.this.gVE.setVisibility(8);
                        return;
                    case 3:
                        RecordVideoActivity.this.gRJ = true;
                        if (!StringUtils.isNull(RecordVideoActivity.this.gRH)) {
                            File file = new File(RecordVideoActivity.this.gRH);
                            RecordVideoActivity.this.gRH = RecordVideoActivity.this.gRH.replace("_tiebaconverting.mp4", ".mp4");
                            file.renameTo(new File(RecordVideoActivity.this.gRH));
                        }
                        RecordVideoActivity.this.gVE.setVisibility(8);
                        if (!RecordVideoActivity.this.gRI) {
                            RecordVideoActivity.this.bDs();
                            RecordVideoActivity.this.vt(101);
                            return;
                        }
                        return;
                    case 4:
                        RecordVideoActivity.this.gRJ = false;
                        RecordVideoActivity.this.gVE.setVisibility(8);
                        RecordVideoActivity.this.vt(SapiSafeFacade.SAPIWEBVIEW_AUTHORIZATION);
                        return;
                    case 5:
                        com.baidu.tieba.video.f bBY = RecordVideoActivity.this.bBY();
                        if (bBY != null && bBY.isConvertRunning()) {
                            RecordVideoActivity.this.bCb();
                            RecordVideoActivity.this.bDs();
                            RecordVideoActivity.this.vt(105);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.gRO = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void dQ(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.w(list)) {
                    if (RecordVideoActivity.this.gVu != null) {
                        RecordVideoActivity.this.gVu.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.gVu != null) {
                    RecordVideoActivity.this.gVu.setHasLocalVideo(true);
                    RecordVideoActivity.this.gVP = false;
                }
            }
        };
        this.gVV = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                List<StickerItem> list;
                if (httpResponsedMessage instanceof ResponseGetStickersMessage) {
                    ResponseGetStickersMessage responseGetStickersMessage = (ResponseGetStickersMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() != 0) {
                        list = null;
                    } else {
                        list = responseGetStickersMessage.getStickerItems();
                    }
                    if (RecordVideoActivity.this.gVu != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.gVu.setStickerItems(list);
                    }
                }
            }
        };
        this.cXY = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    RecordVideoActivity.this.finish();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.video.f bBY() {
        if (this.gRG == null) {
            this.gRG = new com.baidu.tieba.video.f(this);
            this.gRG.a(new com.baidu.tieba.video.c() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
                @Override // com.baidu.tieba.video.c
                public void bAB() {
                }

                @Override // com.baidu.tieba.video.c
                public void vc(int i) {
                    RecordVideoActivity.this.gRP.sendEmptyMessage(2);
                }

                @Override // com.baidu.tieba.video.c
                public void onConvertSuccess() {
                    RecordVideoActivity.this.gRP.sendEmptyMessage(3);
                }

                @Override // com.baidu.tieba.video.c
                public void onConvertFailed() {
                    RecordVideoActivity.this.gRP.sendEmptyMessage(2);
                }

                @Override // com.baidu.tieba.video.c
                public void onConvertProgress(int i) {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.arg1 = i;
                    RecordVideoActivity.this.gRP.sendMessage(obtain);
                }

                @Override // com.baidu.tieba.video.c
                public void onConvertAborted() {
                    RecordVideoActivity.this.gRP.sendEmptyMessage(4);
                }
            });
        }
        return this.gRG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCb() {
        bBY().abortConvert();
        this.gRK = true;
        if (this.gRH != null) {
            File file = new File(this.gRH);
            if (file.exists()) {
                file.delete();
            }
        }
        this.gVE.setVisibility(8);
        this.gRH = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDs() {
        if (TextUtils.isEmpty(this.gRH)) {
            this.gRH = this.gTR.gOz;
        }
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.gRH);
        videoInfo.setVideoDuration(this.gTI.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.gRH).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.gVN == null ? "" : this.gVN.forumName, this.gVN == null ? "" : this.gVN.forumId, this.gOt, videoInfo);
        if (this.gVS != null) {
            this.gVS.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.gRH = null;
        this.gRJ = false;
        this.gRK = false;
        this.gTI.Mw();
        this.gTR.bCR();
        if (this.gAg != null) {
            this.gAg.aNM();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.gRI = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gRI = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gRG != null) {
            this.gRG.destroy();
        }
        if (this.gRP != null) {
            this.gRP.removeMessages(5);
        }
        if (this.gTI != null && this.gTI.isRecording()) {
            this.gTI.stopRecord();
        }
        if (this.gOx != null) {
            this.gOx.cancelLoadData();
        }
        if (this.gAg != null) {
            this.gAg.oY("record");
        }
    }

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_STICKERS, TbConfig.SERVER_ADDRESS + TbConfig.GET_STICKERS);
        tbHttpMessageTask.setResponsedClass(ResponseGetStickersMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        TiebaStatic.log("c12293");
        this.mContext = getPageContext().getPageActivity();
        setIsAddSwipeBackLayout(false);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        super.onCreate(bundle);
        setContentView(d.h.record_activity);
        this.gVM = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.gVN = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.gOt = getIntent().getStringExtra("video_title");
        initUI();
        this.gOx = new SelectMusicModel(getPageContext(), this.gVu);
        this.gOx.bBy();
        this.gVS = new k(this);
        this.gVS.b(this.gOx);
        this.gTI.a(this.gVS);
        bDt();
        registerListener(this.gVV);
        registerListener(this.cXY);
    }

    private void bDt() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam("pn", 1);
        httpMessage.addParam(LegoListActivityConfig.RN, 999);
        sendMessage(httpMessage);
    }

    private void bCc() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.gRO);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.gVt = (RecordLayout) findViewById(d.g.root_layout);
        this.gVt.setListener(this);
        this.gTI = new j(this);
        this.gVu = (VideoControllerLayout) findViewById(d.g.record_controller_layout);
        this.gVu.setRecordController(this.gTI);
        this.gVu.setRecordControlListener(this);
        this.gVu.setEffectChoosedListener(this);
        this.gVv = (RelativeLayout) findViewById(d.g.top_control_layout);
        this.drL = (ImageView) findViewById(d.g.close_page);
        this.drL.setOnClickListener(this);
        this.gVw = (ImageView) findViewById(d.g.flash_switch);
        this.gVw.setOnClickListener(this);
        this.gVx = (ImageView) findViewById(d.g.camera_switch);
        this.gVx.setOnClickListener(this);
        this.gVy = (ImageView) findViewById(d.g.count_down);
        this.gVy.setOnClickListener(this);
        this.gVA = (PreviewViewContainer) findViewById(d.g.video_surface_container);
        this.gTR = new i(this);
        this.gTR.a(this);
        this.gTR.setFaceIdentifyStateListener(this);
        this.gTR.a(new i.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
            @Override // com.baidu.tieba.video.record.i.b
            public void bDh() {
                if (RecordVideoActivity.this.gVu.bDP()) {
                    RecordVideoActivity.this.gVu.a((o) null);
                }
            }
        });
        this.gVC = (VideoEffectButtonLayout) findViewById(d.g.layout_effect_button);
        this.gVC.setListener(this);
        this.gTI.a(this.gVC);
        this.gVC.F(2, true);
        this.gVB = (TextView) findViewById(d.g.tv_count_down);
        this.gVD = (TextView) findViewById(d.g.gesture_guide_tv);
        int ae = ((com.baidu.adp.lib.util.l.ae(this.mContext) - com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds336)) / 2) - com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds150);
        if (this.gVB.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.gVB.getLayoutParams()).topMargin = ae;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.gVC.setVisibility(8);
        }
        this.gVE = findViewById(d.g.progress_layout);
        this.gVF = (RoundProgressBar) this.gVE.findViewById(d.g.video_progress);
        this.gVG = (TextView) findViewById(d.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gVG.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.ac(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds38);
        this.gVG.setLayoutParams(layoutParams);
        this.gVT = (RecordTabLayout) findViewById(d.g.tab_layout);
        this.gVT.al(1, getString(d.j.tab_photo));
        if (this.gVM != 2 && this.gVM != 3) {
            this.gVT.al(2, getString(d.j.tab_record));
            this.gVT.setListener(this);
            this.gVT.q(2, false);
            E(2, false);
            return;
        }
        this.gVT.setShowIndicator(false);
        this.gVT.q(1, false);
        E(1, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gTR.onResume();
        this.gUD = this.gTR.bCX();
        this.gUD.setRecordController(this.gTI);
        this.gVA.setZoomHelper(this.gUD);
        if (this.gVQ == null) {
            this.gVQ = new m();
            this.gVQ.a(new m.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m.a
                public void cm(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.gVR, str2);
                    if (RecordVideoActivity.this.gVu != null) {
                        RecordVideoActivity.this.gVu.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.m.a
                public void tR(String str) {
                    if (RecordVideoActivity.this.gVu != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.gVu.b(stickerItem);
                        if (RecordVideoActivity.this.gTR != null) {
                            RecordVideoActivity.this.gTR.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.gVu != null) {
                        RecordVideoActivity.this.gVu.setDownLoadSticker(null);
                    }
                    if (StringUtils.isNull(str)) {
                        RecordVideoActivity.this.showToast(d.j.sticker_download_error);
                    } else {
                        RecordVideoActivity.this.showToast(str);
                    }
                    RecordVideoActivity recordVideoActivity = RecordVideoActivity.this;
                    if (StringUtils.isNull(str)) {
                        str = RecordVideoActivity.this.getResources().getString(d.j.sticker_download_error);
                    }
                    recordVideoActivity.Q(5, str);
                }

                @Override // com.baidu.tieba.video.record.m.a
                public void bAF() {
                    if (RecordVideoActivity.this.gVu != null) {
                        RecordVideoActivity.this.gVu.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.gVQ.bDK();
        if (this.gVu != null && this.gVP) {
            bCc();
        }
        if (this.gRJ && !TextUtils.isEmpty(this.gRH) && new File(this.gRH).exists()) {
            bDs();
            vt(101);
        }
        if (this.gVS != null) {
            this.gVS.onResume();
        }
        if (this.gAg != null) {
            this.gAg.oX("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gTR.onPause();
        if (this.gVu != null) {
            if (this.gTI != null && this.gTI.getStatus() == 6) {
                this.gVu.stopRecord();
                bDD();
            }
            if (this.gTI != null && this.gTI.isRecording()) {
                this.gVu.stopRecord();
            }
        }
        if (this.gVS != null) {
            this.gVS.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gTI == null || this.gTI.getStatus() != 7) {
            if (this.gTI != null && this.gTI.getStatus() == 6) {
                if (this.gVu != null) {
                    this.gVu.stopRecord();
                }
                bDD();
            } else if (this.gTI.onBackPressed()) {
                finish();
            } else {
                if (this.gVz == null) {
                    this.gVz = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.gVz.cd(d.j.video_quit_confirm);
                    this.gVz.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.gVz.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.14
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.gVz.ao(true);
                    this.gVz.b(getPageContext());
                }
                this.gVz.tk();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.gVG.setVisibility(4);
        if (view == this.drL) {
            onBackPressed();
        } else if (view == this.gVw) {
            if (this.gTI.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            if (!this.gTR.bDe()) {
                bDu();
            }
        } else if (view == this.gVx) {
            if (this.gTI.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            if (this.gTR.bDc()) {
                bDu();
            }
            this.gVx.setOnClickListener(null);
            this.gTR.bDd();
            this.gVx.setOnClickListener(this);
        } else if (view == this.gVy) {
            bDw();
        }
    }

    private void bDu() {
        this.gTR.bDb();
        if (this.gTR.bDc()) {
            this.gVw.setImageResource(d.f.icon_video_flashon_n);
        } else {
            this.gVw.setImageResource(d.f.icon_video_flashoff_n);
        }
    }

    public FrameLayout bDv() {
        return this.gVA;
    }

    public void bDw() {
        this.gVG.setVisibility(4);
        if (this.gTI.getStatus() != 6) {
            this.gTI.setStatus(6);
            bDB();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.gVJ == null) {
                this.gVJ = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.gVJ.setDuration(500L);
                this.gVJ.setRepeatCount(5);
                this.gVJ.setRepeatMode(2);
                this.gVJ.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.gVJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.15
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.gTI.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.gVB.setVisibility(0);
                        RecordVideoActivity.this.gVB.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.gVB.setVisibility(8);
                    if (RecordVideoActivity.this.gTI.getStatus() == 6) {
                        RecordVideoActivity.this.gVu.bDM();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.gTI.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.gVB.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.gVB.setText("");
                        }
                    }
                }
            });
            this.gVB.setAnimation(this.gVJ);
            this.gVJ.startNow();
            this.gVu.bDw();
            if (this.gVS != null) {
                this.gVS.bDq();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDx() {
        if (this.gTI.getStatus() == 1) {
            this.gVG.setVisibility(4);
            if (this.gTI.getStatus() != 6) {
                this.gVu.bDx();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDy() {
        this.gVG.setVisibility(4);
        if (this.gTI.getStatus() != 6) {
            this.gVu.bDy();
            if (this.gVu.bDQ()) {
                bDt();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDz() {
        this.gVG.setVisibility(4);
        if (this.gTI.getStatus() != 6) {
            this.gVu.bDz();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDA() {
        this.gVG.setVisibility(4);
        if (this.gTI.getStatus() != 6) {
            this.gVu.bDA();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDB() {
        this.gVO = true;
        if (this.gVI != null && this.gVI.isRunning()) {
            this.gVI.cancel();
        }
        if (this.gVH == null) {
            this.gVH = new AnimatorSet();
            this.gVH.playTogether(ObjectAnimator.ofFloat(this.gVv, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gVC, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gVT, "alpha", 1.0f, 0.0f));
            this.gVH.addListener(new o() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gXu) {
                        RecordVideoActivity.this.gVv.setVisibility(8);
                        RecordVideoActivity.this.gVC.setVisibility(8);
                        RecordVideoActivity.this.gVT.setVisibility(8);
                    }
                }
            });
            this.gVH.setDuration(300L);
        }
        this.gVH.start();
        this.gVC.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDq() {
        if (this.glX == 2) {
            if (this.gVO) {
                this.gVO = false;
                if (this.gVS != null) {
                    this.gVS.bDq();
                }
            } else {
                return;
            }
        }
        if (this.gVH != null && this.gVH.isRunning()) {
            this.gVH.cancel();
        }
        if (this.gVI == null) {
            this.gVI = new AnimatorSet();
            this.gVI.playTogether(ObjectAnimator.ofFloat(this.gVv, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gVC, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gVT, "alpha", 0.0f, 1.0f));
            this.gVI.setDuration(300L);
        }
        this.gVv.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.gVC.setVisibility(0);
        }
        if (this.gTI.getStatus() == 1) {
            this.gVT.setVisibility(0);
        }
        this.gVI.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDC() {
        if (this.gTR != null) {
            this.gTR.a(new h.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3
                @Override // com.baidu.tieba.video.record.h.a
                public void s(boolean z, String str) {
                    RecordVideoActivity.this.gTI.setStatus(1);
                    RecordVideoActivity.this.bDq();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.gVU != null && !v.w(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.gVU)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.gVU);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.gVU = new ImageFileInfo();
                        RecordVideoActivity.this.gVU.setFilePath(str);
                        RecordVideoActivity.this.gVU.setTempFile(true);
                        RecordVideoActivity.this.gVU.setAlbumnId(null);
                        RecordVideoActivity.this.gVU.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.gVU);
                        RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), 12012, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.gVN, RecordVideoActivity.this.gVM)));
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDD() {
        this.gVJ.cancel();
        this.gVJ.setAnimationListener(null);
        this.gVB.clearAnimation();
        this.gVB.setVisibility(8);
        if (this.gVS != null) {
            this.gVS.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDE() {
        brn();
    }

    private void brn() {
        if (this.gVK != null) {
            this.gVK.cancel();
        }
        if (this.gVL == null) {
            this.gVL = ObjectAnimator.ofFloat(this.gVT, "alpha", 1.0f, 0.0f);
            this.gVL.setDuration(500L);
            this.gVL.addListener(new o() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gXu) {
                        RecordVideoActivity.this.gVT.setVisibility(8);
                    }
                }
            });
        }
        this.gVL.start();
    }

    private void brm() {
        if (this.gVL != null) {
            this.gVL.cancel();
        }
        if (this.gVK == null) {
            this.gVK = ObjectAnimator.ofFloat(this.gVT, "alpha", 0.0f, 1.0f);
            this.gVK.setDuration(500L);
        }
        this.gVT.setVisibility(0);
        this.gVK.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDF() {
        this.gVC.reset();
        if (this.gTI.getStatus() == 1) {
            brm();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDr() {
        if (this.gVE.getVisibility() != 0) {
            this.gVu.bDL();
            this.gTI.setStatus(8);
            bDq();
            if (this.gTR.gUB != null && this.gTR.gUB.size() > 0) {
                this.gVE.setVisibility(0);
                new AnonymousClass5().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$5  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass5 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int gVY = 50;
        final int gVZ = 1;
        Handler gWa = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass5.this.mProgress = (AnonymousClass5.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.gVF.ap(AnonymousClass5.this.mProgress);
                    AnonymousClass5.this.bDJ();
                }
            }
        };
        int mProgress;

        AnonymousClass5() {
        }

        public void bDJ() {
            this.gWa.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            bDJ();
            boolean z = RecordVideoActivity.this.gVS == null || TextUtils.isEmpty(RecordVideoActivity.this.gVS.bDp()) || !new File(RecordVideoActivity.this.gVS.bDp()).exists();
            if (RecordVideoActivity.this.gTR.gUB.size() > 1) {
                return com.baidu.tieba.video.meida.h.bCv().a(RecordVideoActivity.this.gTR.gUB, RecordVideoActivity.this.gTR.bCU(), z);
            }
            File file = new File(RecordVideoActivity.this.gTR.gUB.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                file.renameTo(new File(RecordVideoActivity.this.gTR.bCU()));
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.bCv().a(RecordVideoActivity.this.gTR.gUB, RecordVideoActivity.this.gTR.bCU(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.gVu.bDR();
            if (iVar != null && iVar.result == 0) {
                if (XiaoyingUtil.isXiaoyingInstalled() && !XiaoyingUtil.isXiaoyingForbidden()) {
                    if (RecordVideoActivity.this.gTI.getVideoDuration() < 8000) {
                        com.baidu.tieba.video.f bBY = RecordVideoActivity.this.bBY();
                        if (!bBY.isConvertRunning()) {
                            File file = new File(com.baidu.tieba.video.d.gMY, "tieba_" + com.baidu.tieba.video.localvideo.e.tP(RecordVideoActivity.this.gTR.gOz) + "_tiebaconverting.mp4");
                            RecordVideoActivity.this.gRH = file.getAbsolutePath();
                            bBY.setConvertType(2);
                            bBY.cl(RecordVideoActivity.this.gTR.gOz, RecordVideoActivity.this.gRH);
                            RecordVideoActivity.this.gRK = false;
                            RecordVideoActivity.this.gRJ = false;
                        } else {
                            return;
                        }
                    } else {
                        RecordVideoActivity.this.gRH = RecordVideoActivity.this.gTR.gOz;
                        RecordVideoActivity.this.bDs();
                        RecordVideoActivity.this.vt(SapiSafeFacade.SAPIWEBVIEW_BACK);
                        RecordVideoActivity.this.gVE.setVisibility(8);
                    }
                } else {
                    RecordVideoActivity.this.gRH = RecordVideoActivity.this.gTR.gOz;
                    RecordVideoActivity.this.bDs();
                    RecordVideoActivity.this.vt(SapiSafeFacade.SAPIWEBVIEW_BACK);
                    RecordVideoActivity.this.gVE.setVisibility(8);
                    RecordVideoActivity.this.gVS.bDr();
                    return;
                }
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(d.j.mix_fail));
                RecordVideoActivity.this.gVE.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.Q(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.gVF.ap(0.0f);
            RecordVideoActivity.this.gVS.bDr();
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.gVu == null || v.w(this.gVu.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.gVu.getChoosedBeautyList()) {
            if (eVar != null) {
                String name = eVar.getName();
                if (!TextUtils.isEmpty(name)) {
                    if (name.equals("Normal")) {
                        name = "0";
                    }
                    arrayList.add(name);
                }
            }
        }
        return arrayList;
    }

    public List<String> getChoosedFilterList() {
        ArrayList arrayList = new ArrayList();
        if (this.gVu == null || v.w(this.gVu.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.gVu.getChoosedFilterList()) {
            if (eVar != null) {
                String str = (String) eVar.getValue();
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    public List<String> getChoosedStickerList() {
        ArrayList arrayList = new ArrayList();
        if (this.gVu == null || v.w(this.gVu.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.gVu.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDG() {
        this.gVG.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDH() {
        this.gVG.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDI() {
        if (this.gTI.getStatus() == 1) {
            this.gVT.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.gTR != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.gTR.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new ak("c12421").r("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.gVC.F(2, false);
                            return;
                        } else {
                            this.gVC.F(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.gTR.setFilter((String) eVar.getValue());
                        ak akVar = new ak("c12496");
                        akVar.ac("obj_id", (String) eVar.getValue());
                        if (this.gTI.getStatus() == 1) {
                            akVar.r("obj_type", 1);
                        } else {
                            akVar.r("obj_type", 2);
                        }
                        if (eVar.getValue().equals("nature")) {
                            this.gVC.F(3, false);
                            return;
                        } else {
                            this.gVC.F(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.gVS.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.gVC.F(0, false);
                            return;
                        } else {
                            this.gVC.F(0, true);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(StickerItem stickerItem) {
        if (stickerItem != null) {
            this.gVR = stickerItem;
            this.gVQ.ur(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.gTR != null) {
                    this.gTR.setSticker(null);
                    this.gVW = false;
                }
                if (this.gVu != null) {
                    this.gVu.setDownLoadSticker(null);
                }
                this.gVD.setVisibility(8);
                this.gVC.F(1, false);
                return;
            }
            String up = this.gVQ.up(stickerItem.resource);
            if (!StringUtils.isNull(up)) {
                a(stickerItem, up);
                if (this.gVu != null) {
                    this.gVu.setDownLoadSticker(null);
                }
            } else {
                if (this.gVu != null) {
                    this.gVu.setDownLoadSticker(stickerItem);
                }
                this.gVQ.uq(stickerItem.resource);
            }
            this.gVC.F(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.gTR != null) {
                this.gTR.setSticker(stickerItem);
                this.gVW = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.gVD.setText(stickerItem.desc);
                this.gVD.setVisibility(0);
                this.gVD.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.gVD.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.gVD.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.i.c
    public void ce(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.o(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.gVu.getLayoutParams();
            layoutParams.height = i4;
            this.gVu.setLayoutParams(layoutParams);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String ua = com.baidu.tieba.video.editvideo.model.a.bBs().ua(stringExtra);
                if (this.gVS != null && !TextUtils.isEmpty(ua)) {
                    this.gVS.cn(ua, stringExtra2);
                    this.gVu.bCK();
                }
            }
        } else if (i == 12012 && i2 == -1) {
            Intent intent2 = new Intent();
            if (intent != null) {
                intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT));
                if (!StringUtils.isNull(intent.getStringExtra("file_name"))) {
                    intent2.putExtra("file_name", intent.getStringExtra("file_name"));
                }
            }
            setResult(-1, intent2);
            finish();
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (this.gTI.getStatus() == 8) {
            this.gVu.vv(1);
        }
    }

    @Override // com.baidu.tieba.video.record.g.a
    public void nI(boolean z) {
        if (this.gTI != null && (this.gTI.getStatus() == 1 || this.gTI.getStatus() == 3 || this.gTI.getStatus() == 4)) {
            if (!z && this.gVW) {
                this.gVA.bDi();
                return;
            } else {
                this.gVA.bDj();
                return;
            }
        }
        this.gVA.bDj();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void E(int i, boolean z) {
        int i2 = 1;
        if (this.glX != i) {
            switch (i) {
                case 1:
                    if (this.gVS != null) {
                        this.gVS.bjf();
                    }
                    this.gTR.setFilter("nature");
                    this.gVC.F(0, false);
                    this.gVC.F(3, false);
                    this.gVu.vv(1);
                    this.gVC.setViewVisibility(0, 8);
                    this.gVC.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.gVC.setViewVisibility(0, 0);
                    this.gVC.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.glX = i;
            this.gVu.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new ak().r("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bDo() {
        if (this.gTI.getStatus() == 1 && !this.gVu.bDP()) {
            E(1, true);
            this.gVT.q(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bDn() {
        if (this.gTI.getStatus() == 1 && !this.gVu.bDP()) {
            E(2, true);
            this.gVT.q(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vt(int i) {
        if (this.gAg != null) {
            this.gAg.R(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(int i, String str) {
        if (this.gAg != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.gAg.Q(i, str);
        }
    }
}
