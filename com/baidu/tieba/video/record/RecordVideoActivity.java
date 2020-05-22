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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.dialog.a;
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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class RecordVideoActivity extends BaseActivity implements GLVideoPreviewView.a, RecordLayout.a, RecordTabLayout.a, VideoControllerLayout.a, VideoEffectButtonLayout.a, VideoEffectLayout.a, h.c {
    private View bjL;
    private ImageView gdN;
    private int hEW;
    private final CustomMessageListener hGM;
    private String lBh;
    private SelectMusicModel lBl;
    private b.a lEv;
    private i lFO;
    protected h lFW;
    private b lGE;
    private com.baidu.tbadk.core.dialog.a lHA;
    private PreviewViewContainer lHB;
    private TextView lHC;
    private VideoEffectButtonLayout lHD;
    private TextView lHE;
    private RoundProgressBar lHF;
    private TextView lHG;
    private AnimatorSet lHH;
    private AnimatorSet lHI;
    private ScaleAnimation lHJ;
    private ObjectAnimator lHK;
    private ObjectAnimator lHL;
    private int lHM;
    private ForumWriteData lHN;
    private boolean lHO;
    private boolean lHP = true;
    private l lHQ;
    private StickerItem lHR;
    protected j lHS;
    private RecordTabLayout lHT;
    private ImageFileInfo lHU;
    private HttpMessageListener lHV;
    private boolean lHW;
    private RecordLayout lHu;
    private VideoControllerLayout lHv;
    private RelativeLayout lHw;
    private ImageView lHx;
    private ImageView lHy;
    private ImageView lHz;
    private com.baidu.tieba.k.h lmg;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.lmg = lVar.cyB();
        }
        if (this.lmg != null) {
            this.lmg.cyd();
        }
        this.lEv = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void eM(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.isEmpty(list)) {
                    if (RecordVideoActivity.this.lHv != null) {
                        RecordVideoActivity.this.lHv.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.lHv != null) {
                    RecordVideoActivity.this.lHv.setHasLocalVideo(true);
                    RecordVideoActivity.this.lHP = false;
                }
            }
        };
        this.lHV = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.lHv != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.lHv.setStickerItems(list);
                    }
                }
            }
        };
        this.hGM = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(PostWriteCallBackData.GENERAL_TAB_ID, ((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId());
                    RecordVideoActivity.this.setResult(-1, intent);
                    RecordVideoActivity.this.finish();
                }
            }
        };
    }

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003368, TbConfig.SERVER_ADDRESS + TbConfig.GET_STICKERS);
        tbHttpMessageTask.setResponsedClass(ResponseGetStickersMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dko() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.lFW.lBm);
        videoInfo.setVideoDuration(this.lFO.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.lFW.lBm).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.lHN == null ? "" : this.lHN.forumName;
        String str2 = this.lHN == null ? "" : this.lHN.forumId;
        int i = this.lHN == null ? -1 : this.lHN.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.lHN.writeCallFrom, str, str2, this.lBh, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        editVideoActivityConfig.setFrsTabInfo(this.lHN != null ? this.lHN.frsTabInfo : null);
        editVideoActivityConfig.setFrom(this.lHN.mFrom);
        if (this.lHS != null) {
            this.lHS.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.lmg != null) {
            this.lmg.cyg();
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
        if (this.lFO != null && this.lFO.aXs()) {
            this.lFO.stopRecord();
        }
        if (this.lBl != null) {
            this.lBl.cancelLoadData();
        }
        if (this.lmg != null) {
            this.lmg.Iv("record");
        }
        com.baidu.tbadk.core.util.m.deleteFileOrDir(new File(com.baidu.tieba.video.c.lzF));
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
        this.lHM = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.lHN = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.lBh = getIntent().getStringExtra("video_title");
        initUI();
        this.lBl = new SelectMusicModel(getPageContext(), this.lHv);
        this.lBl.diI();
        this.lHS = new j(this);
        this.lHS.b(this.lBl);
        this.lFO.a(this.lHS);
        registerListener(this.lHV);
        registerListener(this.hGM);
        dkp();
    }

    private void dkp() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void dji() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.lEv);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.lHu = (RecordLayout) findViewById(R.id.root_layout);
        this.lHu.setListener(this);
        this.lFO = new i(this);
        this.lHv = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.lHv.setRecordController(this.lFO);
        this.lHv.setRecordControlListener(this);
        this.lHv.setEffectChoosedListener(this);
        this.lHw = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.gdN = (ImageView) findViewById(R.id.close_page);
        this.gdN.setOnClickListener(this);
        this.lHx = (ImageView) findViewById(R.id.flash_switch);
        this.lHx.setOnClickListener(this);
        this.lHy = (ImageView) findViewById(R.id.camera_switch);
        this.lHy.setOnClickListener(this);
        this.lHz = (ImageView) findViewById(R.id.count_down);
        this.lHz.setOnClickListener(this);
        this.lHB = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.lFW = new h(this);
        this.lFW.a(this);
        this.lFW.setFaceIdentifyStateListener(this);
        this.lFW.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void dkc() {
                if (RecordVideoActivity.this.lHv.dkO()) {
                    RecordVideoActivity.this.lHv.a((m) null);
                }
            }
        });
        this.lHD = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.lHD.setListener(this);
        this.lFO.a(this.lHD);
        this.lHD.setViewChoosed(2, true);
        this.lHC = (TextView) findViewById(R.id.tv_count_down);
        this.lHE = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.lHC.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.lHC.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.lHD.setVisibility(8);
        }
        this.bjL = findViewById(R.id.progress_layout);
        this.lHF = (RoundProgressBar) this.bjL.findViewById(R.id.video_progress);
        this.lHG = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lHG.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.lHG.setLayoutParams(layoutParams);
        this.lHT = (RecordTabLayout) findViewById(R.id.tab_layout);
        this.lHT.bB(1, getString(R.string.tab_photo));
        if (this.lHM != 2 && this.lHM != 3) {
            this.lHT.bB(2, getString(R.string.tab_record));
            this.lHT.setListener(this);
            this.lHT.setCurrentTab(2, false);
            ad(2, false);
        } else {
            this.lHT.setShowIndicator(false);
            this.lHT.setCurrentTab(1, false);
            ad(1, false);
        }
        dkq();
    }

    private void dkq() {
        if (com.baidu.tbadk.core.util.g.aUg()) {
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
        this.lFW.onResume();
        this.lGE = this.lFW.djT();
        if (this.lGE != null) {
            this.lGE.setRecordController(this.lFO);
            this.lHB.setZoomHelper(this.lGE);
        }
        dkr();
        if (this.lHQ == null) {
            this.lHQ = new l();
            this.lHQ.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void fx(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.lHR, str2);
                    if (RecordVideoActivity.this.lHv != null) {
                        RecordVideoActivity.this.lHv.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void Nt(String str) {
                    if (RecordVideoActivity.this.lHv != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.lHv.b(stickerItem);
                        if (RecordVideoActivity.this.lFW != null) {
                            RecordVideoActivity.this.lFW.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.lHv != null) {
                        RecordVideoActivity.this.lHv.setDownLoadSticker(null);
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
                    recordVideoActivity.bj(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void dhT() {
                    if (RecordVideoActivity.this.lHv != null) {
                        RecordVideoActivity.this.lHv.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.lHQ.dkI();
        if (this.lHv != null && this.lHP) {
            dji();
        }
        if (this.lmg != null) {
            this.lmg.Iu("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.lFW.onPause();
        if (this.lHv != null) {
            if (this.lFO != null && this.lFO.getStatus() == 6) {
                this.lHv.stopRecord();
                dkA();
            }
            if (this.lFO != null && this.lFO.aXs()) {
                this.lHv.stopRecord();
            }
        }
        if (this.lHS != null) {
            this.lHS.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.lFO == null || this.lFO.getStatus() != 7) {
            if (this.lFO != null && this.lFO.getStatus() == 6) {
                if (this.lHv != null) {
                    this.lHv.stopRecord();
                }
                dkA();
            } else if (this.lFO != null && this.lFO.onBackPressed()) {
                finish();
            } else {
                if (this.lHA == null) {
                    this.lHA = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.lHA.kD(R.string.video_quit_confirm);
                    this.lHA.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.lHA.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.lHA.gW(true);
                    this.lHA.b(getPageContext());
                }
                this.lHA.aST();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.lHG.setVisibility(4);
        if (view == this.gdN) {
            onBackPressed();
        } else if (view == this.lHx) {
            if (this.lFO.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.lFW.djW();
            dkr();
        } else if (view == this.lHy) {
            if (this.lFO.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.lHy.setOnClickListener(null);
            this.lFW.djY();
            if (this.lFW.djZ() && this.lFW.djX()) {
                this.lFW.djW();
            }
            dkr();
            this.lHy.setOnClickListener(this);
        } else if (view == this.lHz) {
            dkt();
        }
    }

    private void dkr() {
        if (this.lFW.djZ()) {
            this.lHx.setVisibility(8);
        } else {
            this.lHx.setVisibility(0);
        }
        if (this.lFW.djX()) {
            this.lHx.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.lHx.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout dks() {
        return this.lHB;
    }

    public void dkt() {
        this.lHG.setVisibility(4);
        if (this.lFO.getStatus() != 6) {
            this.lFO.setStatus(6);
            dky();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.lHJ == null) {
                this.lHJ = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.lHJ.setDuration(500L);
                this.lHJ.setRepeatCount(5);
                this.lHJ.setRepeatMode(2);
                this.lHJ.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.lHJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.lFO.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.lHC.setVisibility(0);
                        RecordVideoActivity.this.lHC.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.lHC.setVisibility(8);
                    if (RecordVideoActivity.this.lFO.getStatus() == 6) {
                        RecordVideoActivity.this.lHv.dkL();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.lFO.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.lHC.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.lHC.setText("");
                        }
                    }
                }
            });
            this.lHC.setAnimation(this.lHJ);
            this.lHJ.startNow();
            this.lHv.dkt();
            if (this.lHS != null) {
                this.lHS.dkn();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dku() {
        if (this.lFO.getStatus() == 1) {
            this.lHG.setVisibility(4);
            if (this.lFO.getStatus() != 6) {
                this.lHv.dku();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dkv() {
        this.lHG.setVisibility(4);
        if (this.lFO.getStatus() != 6) {
            this.lHv.dkv();
            if (this.lHv.dkP()) {
                dkp();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dkw() {
        this.lHG.setVisibility(4);
        if (this.lFO.getStatus() != 6) {
            this.lHv.dkw();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dkx() {
        this.lHG.setVisibility(4);
        if (this.lFO.getStatus() != 6) {
            this.lHv.dkx();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dky() {
        this.lHO = true;
        if (this.lHI != null && this.lHI.isRunning()) {
            this.lHI.cancel();
        }
        if (this.lHH == null) {
            this.lHH = new AnimatorSet();
            this.lHH.playTogether(ObjectAnimator.ofFloat(this.lHw, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.lHD, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.lHT, "alpha", 1.0f, 0.0f));
            this.lHH.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.lJt) {
                        RecordVideoActivity.this.lHw.setVisibility(8);
                        RecordVideoActivity.this.lHD.setVisibility(8);
                        RecordVideoActivity.this.lHT.setVisibility(8);
                    }
                }
            });
            this.lHH.setDuration(300L);
        }
        this.lHH.start();
        this.lHD.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dkn() {
        if (this.hEW == 2) {
            if (this.lHO) {
                this.lHO = false;
                if (this.lHS != null) {
                    this.lHS.dkn();
                }
            } else {
                return;
            }
        }
        if (this.lHH != null && this.lHH.isRunning()) {
            this.lHH.cancel();
        }
        if (this.lHI == null) {
            this.lHI = new AnimatorSet();
            this.lHI.playTogether(ObjectAnimator.ofFloat(this.lHw, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.lHD, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.lHT, "alpha", 0.0f, 1.0f));
            this.lHI.setDuration(300L);
        }
        this.lHw.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.lHD.setVisibility(0);
        }
        if (this.lFO.getStatus() == 1) {
            this.lHT.setVisibility(0);
        }
        this.lHI.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dkz() {
        if (this.lFW != null) {
            this.lFW.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void A(boolean z, String str) {
                    RecordVideoActivity.this.lFO.setStatus(1);
                    RecordVideoActivity.this.dkn();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.lHU != null && !v.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.lHU)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.lHU);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.lHU = new ImageFileInfo();
                        RecordVideoActivity.this.lHU.setFilePath(str);
                        RecordVideoActivity.this.lHU.setContentUriStr(null);
                        RecordVideoActivity.this.lHU.setTempFile(true);
                        RecordVideoActivity.this.lHU.setAlbumnId(null);
                        RecordVideoActivity.this.lHU.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.lHU);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.lHN, RecordVideoActivity.this.lHM)));
                            return;
                        }
                        Intent intent = new Intent();
                        intent.putExtra("album_result", RecordVideoActivity.this.mWriteImagesInfo.toJsonString());
                        RecordVideoActivity.this.setResult(-1, intent);
                        RecordVideoActivity.this.finish();
                        ActivityPendingTransitionFactory.closeAnimation(RecordVideoActivity.this.getPageContext(), 0);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dkA() {
        this.lHJ.cancel();
        this.lHJ.setAnimationListener(null);
        this.lHC.clearAnimation();
        this.lHC.setVisibility(8);
        if (this.lHS != null) {
            this.lHS.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dkB() {
        dbW();
    }

    private void dbW() {
        if (this.lHK != null) {
            this.lHK.cancel();
        }
        if (this.lHL == null) {
            this.lHL = ObjectAnimator.ofFloat(this.lHT, "alpha", 1.0f, 0.0f);
            this.lHL.setDuration(500L);
            this.lHL.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.lJt) {
                        RecordVideoActivity.this.lHT.setVisibility(8);
                    }
                }
            });
        }
        this.lHL.start();
    }

    private void dbV() {
        if (this.lHL != null) {
            this.lHL.cancel();
        }
        if (this.lHK == null) {
            this.lHK = ObjectAnimator.ofFloat(this.lHT, "alpha", 0.0f, 1.0f);
            this.lHK.setDuration(500L);
        }
        this.lHT.setVisibility(0);
        this.lHK.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dkC() {
        this.lHD.reset();
        if (this.lFO.getStatus() == 1) {
            dbV();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dkD() {
        if (this.bjL.getVisibility() != 0) {
            this.lHv.dkK();
            this.lFO.setStatus(8);
            dkn();
            if (this.lFW.lGC != null && this.lFW.lGC.size() > 0) {
                this.bjL.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int lHY = 50;
        final int lHZ = 1;
        Handler lIa = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.lHF.E(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.dkH();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void dkH() {
            this.lIa.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            dkH();
            boolean z = RecordVideoActivity.this.lHS == null || TextUtils.isEmpty(RecordVideoActivity.this.lHS.dkm()) || !new File(RecordVideoActivity.this.lHS.dkm()).exists();
            if (RecordVideoActivity.this.lFW.lGC.size() > 1) {
                return com.baidu.tieba.video.meida.h.djz().a(RecordVideoActivity.this.lFW.lGC, RecordVideoActivity.this.lFW.djQ(), z);
            }
            File file = new File(RecordVideoActivity.this.lFW.lGC.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.tbadk.core.util.m.copyFile(file.getPath(), RecordVideoActivity.this.lFW.djQ());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.djz().a(RecordVideoActivity.this.lFW.lGC, RecordVideoActivity.this.lFW.djQ(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.lHv.dkQ();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.dko();
                    RecordVideoActivity.this.Fh(102);
                    RecordVideoActivity.this.bjL.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.dko();
                RecordVideoActivity.this.Fh(102);
                RecordVideoActivity.this.bjL.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.bjL.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.bj(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.lHF.E(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.lHv == null || v.isEmpty(this.lHv.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.lHv.getChoosedBeautyList()) {
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
        if (this.lHv == null || v.isEmpty(this.lHv.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.lHv.getChoosedFilterList()) {
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
        if (this.lHv == null || v.isEmpty(this.lHv.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.lHv.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dkE() {
        this.lHG.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dkF() {
        this.lHG.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dkG() {
        if (this.lFO.getStatus() == 1) {
            this.lHT.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.lFW != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.lFW.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new an("c12421").ag("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.lHD.setViewChoosed(2, false);
                            return;
                        } else {
                            this.lHD.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.lFW.setFilter((String) eVar.getValue());
                        an anVar = new an("c12496");
                        anVar.dh("obj_id", (String) eVar.getValue());
                        if (this.lFO.getStatus() == 1) {
                            anVar.ag("obj_type", 1);
                        } else {
                            anVar.ag("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.lHD.setViewChoosed(3, false);
                            return;
                        } else {
                            this.lHD.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.lHS.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.lHD.setViewChoosed(0, false);
                            return;
                        } else {
                            this.lHD.setViewChoosed(0, true);
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
            this.lHR = stickerItem;
            this.lHQ.NT(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.lFW != null) {
                    this.lFW.setSticker(null);
                    this.lHW = false;
                }
                if (this.lHv != null) {
                    this.lHv.setDownLoadSticker(null);
                }
                this.lHE.setVisibility(8);
                this.lHD.setViewChoosed(1, false);
                return;
            }
            String NQ = this.lHQ.NQ(stickerItem.resource);
            if (!StringUtils.isNull(NQ)) {
                a(stickerItem, NQ);
                if (this.lHv != null) {
                    this.lHv.setDownLoadSticker(null);
                }
            } else {
                if (this.lHv != null) {
                    this.lHv.setDownLoadSticker(stickerItem);
                }
                this.lHQ.NR(stickerItem.resource);
            }
            this.lHD.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.lFW != null) {
                this.lFW.setSticker(stickerItem);
                this.lHW = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.lHE.setText(stickerItem.desc);
                this.lHE.setVisibility(0);
                this.lHE.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.lHE.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.lHE.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void dd(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.lHv.getLayoutParams();
            layoutParams.height = i4;
            this.lHv.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String NB = com.baidu.tieba.video.editvideo.model.a.diC().NB(stringExtra);
                if (this.lHS != null && !TextUtils.isEmpty(NB)) {
                    this.lHS.fy(NB, stringExtra2);
                    this.lHv.djE();
                }
            }
        } else if (i == 12012 && i2 == -1) {
            Intent intent2 = new Intent();
            if (intent != null) {
                intent2.putExtra("album_result", intent.getStringExtra("album_result"));
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
        if (this.lFO.getStatus() == 8) {
            this.lHv.dkJ();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void va(boolean z) {
        if (this.lFO != null && (this.lFO.getStatus() == 1 || this.lFO.getStatus() == 3 || this.lFO.getStatus() == 4)) {
            if (!z && this.lHW) {
                this.lHB.dkd();
                return;
            } else {
                this.lHB.dke();
                return;
            }
        }
        this.lHB.dke();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void ad(int i, boolean z) {
        int i2 = 1;
        if (this.hEW != i) {
            switch (i) {
                case 1:
                    if (this.lHS != null) {
                        this.lHS.aJz();
                    }
                    this.lFW.setFilter("origin");
                    this.lHD.setViewChoosed(0, false);
                    this.lHD.setViewChoosed(3, false);
                    this.lHv.Fj(1);
                    this.lHD.setViewVisibility(0, 8);
                    this.lHD.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.lHD.setViewVisibility(0, 0);
                    this.lHD.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.hEW = i;
            this.lHv.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new an().ag("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dkl() {
        if (this.lFO.getStatus() == 1 && !this.lHv.dkO()) {
            ad(1, true);
            this.lHT.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dkk() {
        if (this.lFO.getStatus() == 1 && !this.lHv.dkO()) {
            ad(2, true);
            this.lHT.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fh(int i) {
        if (this.lmg != null) {
            this.lmg.bk(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(int i, String str) {
        if (this.lmg != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.lmg.bj(i, str);
        }
    }
}
