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
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
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
    private int dJY;
    private final CustomMessageListener dLp;
    private ImageView efa;
    private b.a hBG;
    private j hDA;
    protected i hDJ;
    private b hEu;
    private TextView hFA;
    private AnimatorSet hFB;
    private AnimatorSet hFC;
    private ScaleAnimation hFD;
    private ObjectAnimator hFE;
    private ObjectAnimator hFF;
    private int hFG;
    private ForumWriteData hFH;
    private boolean hFI;
    private boolean hFJ = true;
    private m hFK;
    private StickerItem hFL;
    protected k hFM;
    private RecordTabLayout hFN;
    private ImageFileInfo hFO;
    private HttpMessageListener hFP;
    private boolean hFQ;
    private RecordLayout hFn;
    private VideoControllerLayout hFo;
    private RelativeLayout hFp;
    private ImageView hFq;
    private ImageView hFr;
    private ImageView hFs;
    private com.baidu.tbadk.core.dialog.a hFt;
    private PreviewViewContainer hFu;
    private TextView hFv;
    private VideoEffectButtonLayout hFw;
    private TextView hFx;
    private View hFy;
    private RoundProgressBar hFz;
    private com.baidu.tieba.i.h hjJ;
    private String hyi;
    private SelectMusicModel hym;
    private Context mContext;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.hjJ = kVar.aVn();
        }
        if (this.hjJ != null) {
            this.hjJ.aUU();
        }
        this.hBG = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void dV(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.G(list)) {
                    if (RecordVideoActivity.this.hFo != null) {
                        RecordVideoActivity.this.hFo.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.hFo != null) {
                    RecordVideoActivity.this.hFo.setHasLocalVideo(true);
                    RecordVideoActivity.this.hFJ = false;
                }
            }
        };
        this.hFP = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.hFo != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.hFo.setStickerItems(list);
                    }
                }
            }
        };
        this.dLp = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void bJB() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hDJ.hyo);
        videoInfo.setVideoDuration(this.hDA.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.hDJ.hyo).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.hFH.writeCallFrom, this.hFH == null ? "" : this.hFH.forumName, this.hFH == null ? "" : this.hFH.forumId, this.hyi, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        if (this.hFM != null) {
            this.hFM.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.hDA.TV();
        this.hDJ.bIX();
        if (this.hjJ != null) {
            this.hjJ.aUX();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hDA != null && this.hDA.isRecording()) {
            this.hDA.stopRecord();
        }
        if (this.hym != null) {
            this.hym.cancelLoadData();
        }
        if (this.hjJ != null) {
            this.hjJ.pi("record");
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
        this.hFG = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.hFH = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.hyi = getIntent().getStringExtra("video_title");
        initUI();
        this.hym = new SelectMusicModel(getPageContext(), this.hFo);
        this.hym.bHC();
        this.hFM = new k(this);
        this.hFM.b(this.hym);
        this.hDA.a(this.hFM);
        bJC();
        registerListener(this.hFP);
        registerListener(this.dLp);
    }

    private void bJC() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam("pn", 1);
        httpMessage.addParam(LegoListActivityConfig.RN, 999);
        sendMessage(httpMessage);
    }

    private void bIf() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.hBG);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.hFn = (RecordLayout) findViewById(d.g.root_layout);
        this.hFn.setListener(this);
        this.hDA = new j(this);
        this.hFo = (VideoControllerLayout) findViewById(d.g.record_controller_layout);
        this.hFo.setRecordController(this.hDA);
        this.hFo.setRecordControlListener(this);
        this.hFo.setEffectChoosedListener(this);
        this.hFp = (RelativeLayout) findViewById(d.g.top_control_layout);
        this.efa = (ImageView) findViewById(d.g.close_page);
        this.efa.setOnClickListener(this);
        this.hFq = (ImageView) findViewById(d.g.flash_switch);
        this.hFq.setOnClickListener(this);
        this.hFr = (ImageView) findViewById(d.g.camera_switch);
        this.hFr.setOnClickListener(this);
        this.hFs = (ImageView) findViewById(d.g.count_down);
        this.hFs.setOnClickListener(this);
        this.hFu = (PreviewViewContainer) findViewById(d.g.video_surface_container);
        this.hDJ = new i(this);
        this.hDJ.a(this);
        this.hDJ.setFaceIdentifyStateListener(this);
        this.hDJ.a(new i.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.i.b
            public void bJn() {
                if (RecordVideoActivity.this.hFo.bKa()) {
                    RecordVideoActivity.this.hFo.a((o) null);
                }
            }
        });
        this.hFw = (VideoEffectButtonLayout) findViewById(d.g.layout_effect_button);
        this.hFw.setListener(this);
        this.hDA.a(this.hFw);
        this.hFw.Q(2, true);
        this.hFv = (TextView) findViewById(d.g.tv_count_down);
        this.hFx = (TextView) findViewById(d.g.gesture_guide_tv);
        int aq = ((com.baidu.adp.lib.util.l.aq(this.mContext) - com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds336)) / 2) - com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds150);
        if (this.hFv.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.hFv.getLayoutParams()).topMargin = aq;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.hFw.setVisibility(8);
        }
        this.hFy = findViewById(d.g.progress_layout);
        this.hFz = (RoundProgressBar) this.hFy.findViewById(d.g.video_progress);
        this.hFA = (TextView) findViewById(d.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hFA.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.ao(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds38);
        this.hFA.setLayoutParams(layoutParams);
        this.hFN = (RecordTabLayout) findViewById(d.g.tab_layout);
        this.hFN.ak(1, getString(d.j.tab_photo));
        if (this.hFG != 2 && this.hFG != 3) {
            this.hFN.ak(2, getString(d.j.tab_record));
            this.hFN.setListener(this);
            this.hFN.C(2, false);
            P(2, false);
            return;
        }
        this.hFN.setShowIndicator(false);
        this.hFN.C(1, false);
        P(1, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.hDJ.onResume();
        this.hEu = this.hDJ.bJd();
        if (this.hEu != null) {
            this.hEu.setRecordController(this.hDA);
            this.hFu.setZoomHelper(this.hEu);
        }
        bJD();
        if (this.hFK == null) {
            this.hFK = new m();
            this.hFK.a(new m.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.m.a
                public void co(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.hFL, str2);
                    if (RecordVideoActivity.this.hFo != null) {
                        RecordVideoActivity.this.hFo.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.m.a
                public void tX(String str) {
                    if (RecordVideoActivity.this.hFo != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.hFo.b(stickerItem);
                        if (RecordVideoActivity.this.hDJ != null) {
                            RecordVideoActivity.this.hDJ.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.hFo != null) {
                        RecordVideoActivity.this.hFo.setDownLoadSticker(null);
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
                    recordVideoActivity.P(5, str);
                }

                @Override // com.baidu.tieba.video.record.m.a
                public void bGJ() {
                    if (RecordVideoActivity.this.hFo != null) {
                        RecordVideoActivity.this.hFo.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.hFK.bJV();
        if (this.hFo != null && this.hFJ) {
            bIf();
        }
        if (this.hFM != null) {
            this.hFM.onResume();
        }
        if (this.hjJ != null) {
            this.hjJ.ph("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hDJ.onPause();
        if (this.hFo != null) {
            if (this.hDA != null && this.hDA.getStatus() == 6) {
                this.hFo.stopRecord();
                bJM();
            }
            if (this.hDA != null && this.hDA.isRecording()) {
                this.hFo.stopRecord();
            }
        }
        if (this.hFM != null) {
            this.hFM.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hDA == null || this.hDA.getStatus() != 7) {
            if (this.hDA != null && this.hDA.getStatus() == 6) {
                if (this.hFo != null) {
                    this.hFo.stopRecord();
                }
                bJM();
            } else if (this.hDA.onBackPressed()) {
                finish();
            } else {
                if (this.hFt == null) {
                    this.hFt = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.hFt.fd(d.j.video_quit_confirm);
                    this.hFt.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.hFt.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.hFt.aV(true);
                    this.hFt.b(getPageContext());
                }
                this.hFt.AI();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.hFA.setVisibility(4);
        if (view == this.efa) {
            onBackPressed();
        } else if (view == this.hFq) {
            if (this.hDA.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.hDJ.bJh();
            bJD();
        } else if (view == this.hFr) {
            if (this.hDA.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.hFr.setOnClickListener(null);
            this.hDJ.bJj();
            if (this.hDJ.bJk() && this.hDJ.bJi()) {
                this.hDJ.bJh();
            }
            bJD();
            this.hFr.setOnClickListener(this);
        } else if (view == this.hFs) {
            bJF();
        }
    }

    private void bJD() {
        if (this.hDJ.bJk()) {
            this.hFq.setVisibility(8);
        } else {
            this.hFq.setVisibility(0);
        }
        if (this.hDJ.bJi()) {
            this.hFq.setImageResource(d.f.icon_video_flashon_n);
        } else {
            this.hFq.setImageResource(d.f.icon_video_flashoff_n);
        }
    }

    public FrameLayout bJE() {
        return this.hFu;
    }

    public void bJF() {
        this.hFA.setVisibility(4);
        if (this.hDA.getStatus() != 6) {
            this.hDA.setStatus(6);
            bJK();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.hFD == null) {
                this.hFD = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.hFD.setDuration(500L);
                this.hFD.setRepeatCount(5);
                this.hFD.setRepeatMode(2);
                this.hFD.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.hFD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.hDA.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.hFv.setVisibility(0);
                        RecordVideoActivity.this.hFv.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.hFv.setVisibility(8);
                    if (RecordVideoActivity.this.hDA.getStatus() == 6) {
                        RecordVideoActivity.this.hFo.bJX();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.hDA.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.hFv.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.hFv.setText("");
                        }
                    }
                }
            });
            this.hFv.setAnimation(this.hFD);
            this.hFD.startNow();
            this.hFo.bJF();
            if (this.hFM != null) {
                this.hFM.bJz();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJG() {
        if (this.hDA.getStatus() == 1) {
            this.hFA.setVisibility(4);
            if (this.hDA.getStatus() != 6) {
                this.hFo.bJG();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJH() {
        this.hFA.setVisibility(4);
        if (this.hDA.getStatus() != 6) {
            this.hFo.bJH();
            if (this.hFo.bKb()) {
                bJC();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJI() {
        this.hFA.setVisibility(4);
        if (this.hDA.getStatus() != 6) {
            this.hFo.bJI();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJJ() {
        this.hFA.setVisibility(4);
        if (this.hDA.getStatus() != 6) {
            this.hFo.bJJ();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bJK() {
        this.hFI = true;
        if (this.hFC != null && this.hFC.isRunning()) {
            this.hFC.cancel();
        }
        if (this.hFB == null) {
            this.hFB = new AnimatorSet();
            this.hFB.playTogether(ObjectAnimator.ofFloat(this.hFp, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hFw, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hFN, "alpha", 1.0f, 0.0f));
            this.hFB.addListener(new o() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hHq) {
                        RecordVideoActivity.this.hFp.setVisibility(8);
                        RecordVideoActivity.this.hFw.setVisibility(8);
                        RecordVideoActivity.this.hFN.setVisibility(8);
                    }
                }
            });
            this.hFB.setDuration(300L);
        }
        this.hFB.start();
        this.hFw.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bJz() {
        if (this.dJY == 2) {
            if (this.hFI) {
                this.hFI = false;
                if (this.hFM != null) {
                    this.hFM.bJz();
                }
            } else {
                return;
            }
        }
        if (this.hFB != null && this.hFB.isRunning()) {
            this.hFB.cancel();
        }
        if (this.hFC == null) {
            this.hFC = new AnimatorSet();
            this.hFC.playTogether(ObjectAnimator.ofFloat(this.hFp, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hFw, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hFN, "alpha", 0.0f, 1.0f));
            this.hFC.setDuration(300L);
        }
        this.hFp.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.hFw.setVisibility(0);
        }
        if (this.hDA.getStatus() == 1) {
            this.hFN.setVisibility(0);
        }
        this.hFC.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bJL() {
        if (this.hDJ != null) {
            this.hDJ.a(new h.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.h.a
                public void r(boolean z, String str) {
                    RecordVideoActivity.this.hDA.setStatus(1);
                    RecordVideoActivity.this.bJz();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.hFO != null && !v.G(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.hFO)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.hFO);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.hFO = new ImageFileInfo();
                        RecordVideoActivity.this.hFO.setFilePath(str);
                        RecordVideoActivity.this.hFO.setTempFile(true);
                        RecordVideoActivity.this.hFO.setAlbumnId(null);
                        RecordVideoActivity.this.hFO.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.hFO);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.hFH, RecordVideoActivity.this.hFG)));
                            return;
                        }
                        Intent intent = new Intent();
                        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, RecordVideoActivity.this.mWriteImagesInfo.toJsonString());
                        RecordVideoActivity.this.setResult(-1, intent);
                        RecordVideoActivity.this.finish();
                        ActivityPendingTransitionFactory.closeAnimation(RecordVideoActivity.this.getPageContext(), 0);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bJM() {
        this.hFD.cancel();
        this.hFD.setAnimationListener(null);
        this.hFv.clearAnimation();
        this.hFv.setVisibility(8);
        if (this.hFM != null) {
            this.hFM.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bJN() {
        bzA();
    }

    private void bzA() {
        if (this.hFE != null) {
            this.hFE.cancel();
        }
        if (this.hFF == null) {
            this.hFF = ObjectAnimator.ofFloat(this.hFN, "alpha", 1.0f, 0.0f);
            this.hFF.setDuration(500L);
            this.hFF.addListener(new o() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hHq) {
                        RecordVideoActivity.this.hFN.setVisibility(8);
                    }
                }
            });
        }
        this.hFF.start();
    }

    private void bzz() {
        if (this.hFF != null) {
            this.hFF.cancel();
        }
        if (this.hFE == null) {
            this.hFE = ObjectAnimator.ofFloat(this.hFN, "alpha", 0.0f, 1.0f);
            this.hFE.setDuration(500L);
        }
        this.hFN.setVisibility(0);
        this.hFE.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bJO() {
        this.hFw.reset();
        if (this.hDA.getStatus() == 1) {
            bzz();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bJA() {
        if (this.hFy.getVisibility() != 0) {
            this.hFo.bJW();
            this.hDA.setStatus(8);
            bJz();
            if (this.hDJ.hEs != null && this.hDJ.hEs.size() > 0) {
                this.hFy.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int hFS = 50;
        final int hFT = 1;
        Handler hFU = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.hFz.aD(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.bJT();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void bJT() {
            this.hFU.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            bJT();
            boolean z = RecordVideoActivity.this.hFM == null || TextUtils.isEmpty(RecordVideoActivity.this.hFM.bJy()) || !new File(RecordVideoActivity.this.hFM.bJy()).exists();
            if (RecordVideoActivity.this.hDJ.hEs.size() > 1) {
                return com.baidu.tieba.video.meida.h.bIy().b(RecordVideoActivity.this.hDJ.hEs, RecordVideoActivity.this.hDJ.bJa(), z);
            }
            File file = new File(RecordVideoActivity.this.hDJ.hEs.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                file.renameTo(new File(RecordVideoActivity.this.hDJ.bJa()));
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.bIy().b(RecordVideoActivity.this.hDJ.hEs, RecordVideoActivity.this.hDJ.bJa(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.hFo.bKc();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.bJB();
                    RecordVideoActivity.this.yv(102);
                    RecordVideoActivity.this.hFy.setVisibility(8);
                    RecordVideoActivity.this.hFM.bJA();
                    return;
                }
                RecordVideoActivity.this.bJB();
                RecordVideoActivity.this.yv(102);
                RecordVideoActivity.this.hFy.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(d.j.mix_fail));
                RecordVideoActivity.this.hFy.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.P(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.hFz.aD(0.0f);
            RecordVideoActivity.this.hFM.bJA();
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.hFo == null || v.G(this.hFo.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.hFo.getChoosedBeautyList()) {
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
        if (this.hFo == null || v.G(this.hFo.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.hFo.getChoosedFilterList()) {
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
        if (this.hFo == null || v.G(this.hFo.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.hFo.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bJP() {
        this.hFA.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bJQ() {
        this.hFA.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bJR() {
        if (this.hDA.getStatus() == 1) {
            this.hFN.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.hDJ != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.hDJ.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new ak("c12421").s("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.hFw.Q(2, false);
                            return;
                        } else {
                            this.hFw.Q(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.hDJ.setFilter((String) eVar.getValue());
                        ak akVar = new ak("c12496");
                        akVar.ab("obj_id", (String) eVar.getValue());
                        if (this.hDA.getStatus() == 1) {
                            akVar.s("obj_type", 1);
                        } else {
                            akVar.s("obj_type", 2);
                        }
                        if (eVar.getValue().equals("nature")) {
                            this.hFw.Q(3, false);
                            return;
                        } else {
                            this.hFw.Q(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.hFM.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.hFw.Q(0, false);
                            return;
                        } else {
                            this.hFw.Q(0, true);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void bJS() {
        if (this.hDJ != null && this.hFw != null && this.hFM != null) {
            this.hDJ.setBeautyLevel(com.baidu.tieba.video.a.ya(2));
            this.hFw.Q(2, true);
            this.hDJ.setFilter("nature");
            this.hFw.Q(3, false);
            this.hFM.a(new MusicData("-100", 1, getResources().getString(d.j.music_normal)), (Object) null);
            this.hFw.Q(0, false);
            if (this.hFo != null) {
                this.hFo.bJS();
            }
            if (this.hDJ != null) {
                this.hDJ.setSticker(null);
                this.hFQ = false;
            }
            if (this.hFo != null) {
                this.hFo.setDownLoadSticker(null);
            }
            this.hFx.setVisibility(8);
            this.hFw.Q(1, false);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(StickerItem stickerItem) {
        if (stickerItem != null) {
            this.hFL = stickerItem;
            this.hFK.ux(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.hDJ != null) {
                    this.hDJ.setSticker(null);
                    this.hFQ = false;
                }
                if (this.hFo != null) {
                    this.hFo.setDownLoadSticker(null);
                }
                this.hFx.setVisibility(8);
                this.hFw.Q(1, false);
                return;
            }
            String uv = this.hFK.uv(stickerItem.resource);
            if (!StringUtils.isNull(uv)) {
                a(stickerItem, uv);
                if (this.hFo != null) {
                    this.hFo.setDownLoadSticker(null);
                }
            } else {
                if (this.hFo != null) {
                    this.hFo.setDownLoadSticker(stickerItem);
                }
                this.hFK.uw(stickerItem.resource);
            }
            this.hFw.Q(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.hDJ != null) {
                this.hDJ.setSticker(stickerItem);
                this.hFQ = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.hFx.setText(stickerItem.desc);
                this.hFx.setVisibility(0);
                this.hFx.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.hFx.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.hFx.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.i.c
    public void dc(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.o(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.hFo.getLayoutParams();
            layoutParams.height = i4;
            this.hFo.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String ug = com.baidu.tieba.video.editvideo.model.a.bHw().ug(stringExtra);
                if (this.hFM != null && !TextUtils.isEmpty(ug)) {
                    this.hFM.cp(ug, stringExtra2);
                    this.hFo.bIP();
                }
            }
        } else if (i == 12012) {
            if (i2 == -1) {
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
        } else if (i == 25036 && i2 == -1) {
            bJS();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (this.hDA.getStatus() == 8) {
            this.hFo.yx(1);
        }
    }

    @Override // com.baidu.tieba.video.record.g.a
    public void oe(boolean z) {
        if (this.hDA != null && (this.hDA.getStatus() == 1 || this.hDA.getStatus() == 3 || this.hDA.getStatus() == 4)) {
            if (!z && this.hFQ) {
                this.hFu.bJo();
                return;
            } else {
                this.hFu.bJp();
                return;
            }
        }
        this.hFu.bJp();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void P(int i, boolean z) {
        int i2 = 1;
        if (this.dJY != i) {
            switch (i) {
                case 1:
                    if (this.hFM != null) {
                        this.hFM.bqK();
                    }
                    this.hDJ.setFilter("nature");
                    this.hFw.Q(0, false);
                    this.hFw.Q(3, false);
                    this.hFo.yx(1);
                    this.hFw.setViewVisibility(0, 8);
                    this.hFw.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.hFw.setViewVisibility(0, 0);
                    this.hFw.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.dJY = i;
            this.hFo.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new ak().s("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bJx() {
        if (this.hDA.getStatus() == 1 && !this.hFo.bKa()) {
            P(1, true);
            this.hFN.C(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bJw() {
        if (this.hDA.getStatus() == 1 && !this.hFo.bKa()) {
            P(2, true);
            this.hFN.C(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yv(int i) {
        if (this.hjJ != null) {
            this.hjJ.Q(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(int i, String str) {
        if (this.hjJ != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.hjJ.P(i, str);
        }
    }
}
