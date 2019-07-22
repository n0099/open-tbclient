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
import com.baidu.mobstat.Config;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.tieba.video.localvideo.b;
import com.baidu.tieba.video.record.GLVideoPreviewView;
import com.baidu.tieba.video.record.RecordLayout;
import com.baidu.tieba.video.record.RecordTabLayout;
import com.baidu.tieba.video.record.VideoControllerLayout;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import com.baidu.tieba.video.record.g;
import com.baidu.tieba.video.record.h;
import com.baidu.tieba.video.record.l;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class RecordVideoActivity extends BaseActivity implements GLVideoPreviewView.a, RecordLayout.a, RecordTabLayout.a, VideoControllerLayout.a, VideoEffectButtonLayout.a, VideoEffectLayout.a, h.c {
    private int fKV;
    private final CustomMessageListener fMH;
    private ImageView glb;
    private b jAH;
    private VideoControllerLayout jBA;
    private RelativeLayout jBB;
    private ImageView jBC;
    private ImageView jBD;
    private ImageView jBE;
    private com.baidu.tbadk.core.dialog.a jBF;
    private PreviewViewContainer jBG;
    private TextView jBH;
    private VideoEffectButtonLayout jBI;
    private TextView jBJ;
    private View jBK;
    private RoundProgressBar jBL;
    private TextView jBM;
    private AnimatorSet jBN;
    private AnimatorSet jBO;
    private ScaleAnimation jBP;
    private ObjectAnimator jBQ;
    private ObjectAnimator jBR;
    private int jBS;
    private ForumWriteData jBT;
    private boolean jBU;
    private boolean jBV = true;
    private l jBW;
    private StickerItem jBX;
    protected j jBY;
    private RecordTabLayout jBZ;
    private RecordLayout jBz;
    private ImageFileInfo jCa;
    private HttpMessageListener jCb;
    private boolean jCc;
    private com.baidu.tieba.j.h jgo;
    private String jvf;
    private SelectMusicModel jvj;
    private b.a jyv;
    private i jzP;
    protected h jzX;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.jgo = lVar.bOW();
        }
        if (this.jgo != null) {
            this.jgo.bOA();
        }
        this.jyv = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void er(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.aa(list)) {
                    if (RecordVideoActivity.this.jBA != null) {
                        RecordVideoActivity.this.jBA.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.jBA != null) {
                    RecordVideoActivity.this.jBA.setHasLocalVideo(true);
                    RecordVideoActivity.this.jBV = false;
                }
            }
        };
        this.jCb = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.jBA != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.jBA.setStickerItems(list);
                    }
                }
            }
        };
        this.fMH = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    RecordVideoActivity.this.finish();
                }
            }
        };
    }

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_STICKERS, TbConfig.SERVER_ADDRESS + TbConfig.GET_STICKERS);
        tbHttpMessageTask.setResponsedClass(ResponseGetStickersMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwr() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.jzX.jvl);
        videoInfo.setVideoDuration(this.jzP.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.jzX.jvl).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.jBT == null ? "" : this.jBT.forumName;
        String str2 = this.jBT == null ? "" : this.jBT.forumId;
        int i = this.jBT == null ? -1 : this.jBT.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.jBT.writeCallFrom, str, str2, this.jvf, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        editVideoActivityConfig.setProZone(i);
        if (this.jBY != null) {
            this.jBY.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        if (this.jgo != null) {
            this.jgo.bOD();
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
        if (this.jzP != null && this.jzP.alA()) {
            this.jzP.stopRecord();
        }
        if (this.jvj != null) {
            this.jvj.cancelLoadData();
        }
        if (this.jgo != null) {
            this.jgo.AZ("record");
        }
        com.baidu.tbadk.core.util.m.A(new File(com.baidu.tieba.video.c.jtz));
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
        setContentView(R.layout.record_activity);
        this.jBS = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.jBT = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.jvf = getIntent().getStringExtra("video_title");
        initUI();
        this.jvj = new SelectMusicModel(getPageContext(), this.jBA);
        this.jvj.cuF();
        this.jBY = new j(this);
        this.jBY.b(this.jvj);
        this.jzP.a(this.jBY);
        registerListener(this.jCb);
        registerListener(this.fMH);
        cws();
    }

    private void cws() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void cvi() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.jyv);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.jBz = (RecordLayout) findViewById(R.id.root_layout);
        this.jBz.setListener(this);
        this.jzP = new i(this);
        this.jBA = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.jBA.setRecordController(this.jzP);
        this.jBA.setRecordControlListener(this);
        this.jBA.setEffectChoosedListener(this);
        this.jBB = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.glb = (ImageView) findViewById(R.id.close_page);
        this.glb.setOnClickListener(this);
        this.jBC = (ImageView) findViewById(R.id.flash_switch);
        this.jBC.setOnClickListener(this);
        this.jBD = (ImageView) findViewById(R.id.camera_switch);
        this.jBD.setOnClickListener(this);
        this.jBE = (ImageView) findViewById(R.id.count_down);
        this.jBE.setOnClickListener(this);
        this.jBG = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.jzX = new h(this);
        this.jzX.a(this);
        this.jzX.setFaceIdentifyStateListener(this);
        this.jzX.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void cwf() {
                if (RecordVideoActivity.this.jBA.cwR()) {
                    RecordVideoActivity.this.jBA.a((m) null);
                }
            }
        });
        this.jBI = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.jBI.setListener(this);
        this.jzP.a(this.jBI);
        this.jBI.setViewChoosed(2, true);
        this.jBH = (TextView) findViewById(R.id.tv_count_down);
        this.jBJ = (TextView) findViewById(R.id.gesture_guide_tv);
        int ah = ((com.baidu.adp.lib.util.l.ah(this.mContext) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds150);
        if (this.jBH.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.jBH.getLayoutParams()).topMargin = ah;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.jBI.setVisibility(8);
        }
        this.jBK = findViewById(R.id.progress_layout);
        this.jBL = (RoundProgressBar) this.jBK.findViewById(R.id.video_progress);
        this.jBM = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jBM.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.af(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds38);
        this.jBM.setLayoutParams(layoutParams);
        this.jBZ = (RecordTabLayout) findViewById(R.id.tab_layout);
        this.jBZ.aM(1, getString(R.string.tab_photo));
        if (this.jBS != 2 && this.jBS != 3) {
            this.jBZ.aM(2, getString(R.string.tab_record));
            this.jBZ.setListener(this);
            this.jBZ.setCurrentTab(2, false);
            T(2, false);
        } else {
            this.jBZ.setShowIndicator(false);
            this.jBZ.setCurrentTab(1, false);
            T(1, false);
        }
        cwt();
    }

    private void cwt() {
        if (com.baidu.tbadk.core.util.g.ahX()) {
            this.mStatusBarView = findViewById(R.id.statusbar_view);
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.jzX.onResume();
        this.jAH = this.jzX.cvW();
        if (this.jAH != null) {
            this.jAH.setRecordController(this.jzP);
            this.jBG.setZoomHelper(this.jAH);
        }
        cwu();
        if (this.jBW == null) {
            this.jBW = new l();
            this.jBW.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void es(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.jBX, str2);
                    if (RecordVideoActivity.this.jBA != null) {
                        RecordVideoActivity.this.jBA.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void FE(String str) {
                    if (RecordVideoActivity.this.jBA != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.jBA.b(stickerItem);
                        if (RecordVideoActivity.this.jzX != null) {
                            RecordVideoActivity.this.jzX.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.jBA != null) {
                        RecordVideoActivity.this.jBA.setDownLoadSticker(null);
                    }
                    if (StringUtils.isNull(str)) {
                        RecordVideoActivity.this.showToast(R.string.sticker_download_error);
                    } else {
                        RecordVideoActivity.this.showToast(str);
                    }
                    RecordVideoActivity recordVideoActivity = RecordVideoActivity.this;
                    if (StringUtils.isNull(str)) {
                        str = RecordVideoActivity.this.getResources().getString(R.string.sticker_download_error);
                    }
                    recordVideoActivity.av(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void ctN() {
                    if (RecordVideoActivity.this.jBA != null) {
                        RecordVideoActivity.this.jBA.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.jBW.cwL();
        if (this.jBA != null && this.jBV) {
            cvi();
        }
        if (this.jgo != null) {
            this.jgo.AY("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.jzX.onPause();
        if (this.jBA != null) {
            if (this.jzP != null && this.jzP.getStatus() == 6) {
                this.jBA.stopRecord();
                cwD();
            }
            if (this.jzP != null && this.jzP.alA()) {
                this.jBA.stopRecord();
            }
        }
        if (this.jBY != null) {
            this.jBY.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.jzP == null || this.jzP.getStatus() != 7) {
            if (this.jzP != null && this.jzP.getStatus() == 6) {
                if (this.jBA != null) {
                    this.jBA.stopRecord();
                }
                cwD();
            } else if (this.jzP.onBackPressed()) {
                finish();
            } else {
                if (this.jBF == null) {
                    this.jBF = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.jBF.hu(R.string.video_quit_confirm);
                    this.jBF.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.jBF.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.jBF.dQ(true);
                    this.jBF.b(getPageContext());
                }
                this.jBF.agI();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.jBM.setVisibility(4);
        if (view == this.glb) {
            onBackPressed();
        } else if (view == this.jBC) {
            if (this.jzP.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.jzX.cvZ();
            cwu();
        } else if (view == this.jBD) {
            if (this.jzP.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.jBD.setOnClickListener(null);
            this.jzX.cwb();
            if (this.jzX.cwc() && this.jzX.cwa()) {
                this.jzX.cvZ();
            }
            cwu();
            this.jBD.setOnClickListener(this);
        } else if (view == this.jBE) {
            cww();
        }
    }

    private void cwu() {
        if (this.jzX.cwc()) {
            this.jBC.setVisibility(8);
        } else {
            this.jBC.setVisibility(0);
        }
        if (this.jzX.cwa()) {
            this.jBC.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.jBC.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout cwv() {
        return this.jBG;
    }

    public void cww() {
        this.jBM.setVisibility(4);
        if (this.jzP.getStatus() != 6) {
            this.jzP.setStatus(6);
            cwB();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.jBP == null) {
                this.jBP = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.jBP.setDuration(500L);
                this.jBP.setRepeatCount(5);
                this.jBP.setRepeatMode(2);
                this.jBP.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.jBP.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.jzP.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.jBH.setVisibility(0);
                        RecordVideoActivity.this.jBH.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.jBH.setVisibility(8);
                    if (RecordVideoActivity.this.jzP.getStatus() == 6) {
                        RecordVideoActivity.this.jBA.cwO();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.jzP.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.jBH.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.jBH.setText("");
                        }
                    }
                }
            });
            this.jBH.setAnimation(this.jBP);
            this.jBP.startNow();
            this.jBA.cww();
            if (this.jBY != null) {
                this.jBY.cwq();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cwx() {
        if (this.jzP.getStatus() == 1) {
            this.jBM.setVisibility(4);
            if (this.jzP.getStatus() != 6) {
                this.jBA.cwx();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cwy() {
        this.jBM.setVisibility(4);
        if (this.jzP.getStatus() != 6) {
            this.jBA.cwy();
            if (this.jBA.cwS()) {
                cws();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cwz() {
        this.jBM.setVisibility(4);
        if (this.jzP.getStatus() != 6) {
            this.jBA.cwz();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cwA() {
        this.jBM.setVisibility(4);
        if (this.jzP.getStatus() != 6) {
            this.jBA.cwA();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cwB() {
        this.jBU = true;
        if (this.jBO != null && this.jBO.isRunning()) {
            this.jBO.cancel();
        }
        if (this.jBN == null) {
            this.jBN = new AnimatorSet();
            this.jBN.playTogether(ObjectAnimator.ofFloat(this.jBB, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jBI, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jBZ, "alpha", 1.0f, 0.0f));
            this.jBN.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jDA) {
                        RecordVideoActivity.this.jBB.setVisibility(8);
                        RecordVideoActivity.this.jBI.setVisibility(8);
                        RecordVideoActivity.this.jBZ.setVisibility(8);
                    }
                }
            });
            this.jBN.setDuration(300L);
        }
        this.jBN.start();
        this.jBI.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cwq() {
        if (this.fKV == 2) {
            if (this.jBU) {
                this.jBU = false;
                if (this.jBY != null) {
                    this.jBY.cwq();
                }
            } else {
                return;
            }
        }
        if (this.jBN != null && this.jBN.isRunning()) {
            this.jBN.cancel();
        }
        if (this.jBO == null) {
            this.jBO = new AnimatorSet();
            this.jBO.playTogether(ObjectAnimator.ofFloat(this.jBB, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jBI, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jBZ, "alpha", 0.0f, 1.0f));
            this.jBO.setDuration(300L);
        }
        this.jBB.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.jBI.setVisibility(0);
        }
        if (this.jzP.getStatus() == 1) {
            this.jBZ.setVisibility(0);
        }
        this.jBO.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cwC() {
        if (this.jzX != null) {
            this.jzX.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void z(boolean z, String str) {
                    RecordVideoActivity.this.jzP.setStatus(1);
                    RecordVideoActivity.this.cwq();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.jCa != null && !v.aa(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.jCa)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.jCa);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.jCa = new ImageFileInfo();
                        RecordVideoActivity.this.jCa.setFilePath(str);
                        RecordVideoActivity.this.jCa.setTempFile(true);
                        RecordVideoActivity.this.jCa.setAlbumnId(null);
                        RecordVideoActivity.this.jCa.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.jCa);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), 12012, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.jBT, RecordVideoActivity.this.jBS)));
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
    public void cwD() {
        this.jBP.cancel();
        this.jBP.setAnimationListener(null);
        this.jBH.clearAnimation();
        this.jBH.setVisibility(8);
        if (this.jBY != null) {
            this.jBY.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cwE() {
        cnQ();
    }

    private void cnQ() {
        if (this.jBQ != null) {
            this.jBQ.cancel();
        }
        if (this.jBR == null) {
            this.jBR = ObjectAnimator.ofFloat(this.jBZ, "alpha", 1.0f, 0.0f);
            this.jBR.setDuration(500L);
            this.jBR.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jDA) {
                        RecordVideoActivity.this.jBZ.setVisibility(8);
                    }
                }
            });
        }
        this.jBR.start();
    }

    private void cnP() {
        if (this.jBR != null) {
            this.jBR.cancel();
        }
        if (this.jBQ == null) {
            this.jBQ = ObjectAnimator.ofFloat(this.jBZ, "alpha", 0.0f, 1.0f);
            this.jBQ.setDuration(500L);
        }
        this.jBZ.setVisibility(0);
        this.jBQ.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cwF() {
        this.jBI.reset();
        if (this.jzP.getStatus() == 1) {
            cnP();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cwG() {
        if (this.jBK.getVisibility() != 0) {
            this.jBA.cwN();
            this.jzP.setStatus(8);
            cwq();
            if (this.jzX.jAF != null && this.jzX.jAF.size() > 0) {
                this.jBK.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int jCe = 50;
        final int jCf = 1;
        Handler jCg = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.jBL.aU(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.cwK();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void cwK() {
            this.jCg.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            cwK();
            boolean z = RecordVideoActivity.this.jBY == null || TextUtils.isEmpty(RecordVideoActivity.this.jBY.cwp()) || !new File(RecordVideoActivity.this.jBY.cwp()).exists();
            if (RecordVideoActivity.this.jzX.jAF.size() > 1) {
                return com.baidu.tieba.video.meida.h.cvC().a(RecordVideoActivity.this.jzX.jAF, RecordVideoActivity.this.jzX.cvT(), z);
            }
            File file = new File(RecordVideoActivity.this.jzX.jAF.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.adp.lib.util.f.c(file, new File(RecordVideoActivity.this.jzX.cvT()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.cvC().a(RecordVideoActivity.this.jzX.jAF, RecordVideoActivity.this.jzX.cvT(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.jBA.cwT();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.cwr();
                    RecordVideoActivity.this.Cs(102);
                    RecordVideoActivity.this.jBK.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.cwr();
                RecordVideoActivity.this.Cs(102);
                RecordVideoActivity.this.jBK.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.jBK.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.av(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.jBL.aU(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.jBA == null || v.aa(this.jBA.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.jBA.getChoosedBeautyList()) {
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
        if (this.jBA == null || v.aa(this.jBA.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.jBA.getChoosedFilterList()) {
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
        if (this.jBA == null || v.aa(this.jBA.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.jBA.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cwH() {
        this.jBM.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cwI() {
        this.jBM.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cwJ() {
        if (this.jzP.getStatus() == 1) {
            this.jBZ.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.jzX != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.jzX.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new an("c12421").P(VideoPlayActivityConfig.OBJ_ID, ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.jBI.setViewChoosed(2, false);
                            return;
                        } else {
                            this.jBI.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.jzX.setFilter((String) eVar.getValue());
                        an anVar = new an("c12496");
                        anVar.bT(VideoPlayActivityConfig.OBJ_ID, (String) eVar.getValue());
                        if (this.jzP.getStatus() == 1) {
                            anVar.P("obj_type", 1);
                        } else {
                            anVar.P("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.jBI.setViewChoosed(3, false);
                            return;
                        } else {
                            this.jBI.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.jBY.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.jBI.setViewChoosed(0, false);
                            return;
                        } else {
                            this.jBI.setViewChoosed(0, true);
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
            this.jBX = stickerItem;
            this.jBW.Gf(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.jzX != null) {
                    this.jzX.setSticker(null);
                    this.jCc = false;
                }
                if (this.jBA != null) {
                    this.jBA.setDownLoadSticker(null);
                }
                this.jBJ.setVisibility(8);
                this.jBI.setViewChoosed(1, false);
                return;
            }
            String Gc = this.jBW.Gc(stickerItem.resource);
            if (!StringUtils.isNull(Gc)) {
                a(stickerItem, Gc);
                if (this.jBA != null) {
                    this.jBA.setDownLoadSticker(null);
                }
            } else {
                if (this.jBA != null) {
                    this.jBA.setDownLoadSticker(stickerItem);
                }
                this.jBW.Gd(stickerItem.resource);
            }
            this.jBI.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.jzX != null) {
                this.jzX.setSticker(stickerItem);
                this.jCc = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.jBJ.setText(stickerItem.desc);
                this.jBJ.setVisibility(0);
                this.jBJ.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.jBJ.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.jBJ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void cI(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.v(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.jBA.getLayoutParams();
            layoutParams.height = i4;
            this.jBA.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String FM = com.baidu.tieba.video.editvideo.model.a.cuz().FM(stringExtra);
                if (this.jBY != null && !TextUtils.isEmpty(FM)) {
                    this.jBY.et(FM, stringExtra2);
                    this.jBA.cvH();
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
        if (this.jzP.getStatus() == 8) {
            this.jBA.cwM();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void rL(boolean z) {
        if (this.jzP != null && (this.jzP.getStatus() == 1 || this.jzP.getStatus() == 3 || this.jzP.getStatus() == 4)) {
            if (!z && this.jCc) {
                this.jBG.aUW();
                return;
            } else {
                this.jBG.aUX();
                return;
            }
        }
        this.jBG.aUX();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void T(int i, boolean z) {
        int i2 = 1;
        if (this.fKV != i) {
            switch (i) {
                case 1:
                    if (this.jBY != null) {
                        this.jBY.aBA();
                    }
                    this.jzX.setFilter("origin");
                    this.jBI.setViewChoosed(0, false);
                    this.jBI.setViewChoosed(3, false);
                    this.jBA.Cu(1);
                    this.jBI.setViewVisibility(0, 8);
                    this.jBI.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.jBI.setViewVisibility(0, 0);
                    this.jBI.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.fKV = i;
            this.jBA.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new an().P("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void cwo() {
        if (this.jzP.getStatus() == 1 && !this.jBA.cwR()) {
            T(1, true);
            this.jBZ.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void cwn() {
        if (this.jzP.getStatus() == 1 && !this.jBA.cwR()) {
            T(2, true);
            this.jBZ.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cs(int i) {
        if (this.jgo != null) {
            this.jgo.aw(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(int i, String str) {
        if (this.jgo != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.jgo.av(i, str);
        }
    }
}
