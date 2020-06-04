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
    private ImageView gdY;
    private int hFJ;
    private final CustomMessageListener hHz;
    private ForumWriteData hyK;
    private String lCq;
    private SelectMusicModel lCu;
    private b.a lFE;
    private i lGX;
    private b lHN;
    protected h lHf;
    private RecordLayout lID;
    private VideoControllerLayout lIE;
    private RelativeLayout lIF;
    private ImageView lIG;
    private ImageView lIH;
    private ImageView lII;
    private com.baidu.tbadk.core.dialog.a lIJ;
    private PreviewViewContainer lIK;
    private TextView lIL;
    private VideoEffectButtonLayout lIM;
    private TextView lIN;
    private RoundProgressBar lIO;
    private TextView lIP;
    private AnimatorSet lIQ;
    private AnimatorSet lIR;
    private ScaleAnimation lIS;
    private ObjectAnimator lIT;
    private ObjectAnimator lIU;
    private int lIV;
    private boolean lIW;
    private boolean lIX = true;
    private l lIY;
    private StickerItem lIZ;
    protected j lJa;
    private RecordTabLayout lJb;
    private ImageFileInfo lJc;
    private HttpMessageListener lJd;
    private boolean lJe;
    private com.baidu.tieba.k.h lnq;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.lnq = lVar.cyS();
        }
        if (this.lnq != null) {
            this.lnq.cyu();
        }
        this.lFE = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void eO(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.isEmpty(list)) {
                    if (RecordVideoActivity.this.lIE != null) {
                        RecordVideoActivity.this.lIE.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.lIE != null) {
                    RecordVideoActivity.this.lIE.setHasLocalVideo(true);
                    RecordVideoActivity.this.lIX = false;
                }
            }
        };
        this.lJd = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.lIE != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.lIE.setStickerItems(list);
                    }
                }
            }
        };
        this.hHz = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void dkD() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.lHf.lCv);
        videoInfo.setVideoDuration(this.lGX.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.lHf.lCv).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.hyK == null ? "" : this.hyK.forumName;
        String str2 = this.hyK == null ? "" : this.hyK.forumId;
        int i = this.hyK == null ? -1 : this.hyK.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.hyK.writeCallFrom, str, str2, this.lCq, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        editVideoActivityConfig.setFrsTabInfo(this.hyK != null ? this.hyK.frsTabInfo : null);
        editVideoActivityConfig.setFrom(this.hyK.mFrom);
        if (this.lJa != null) {
            this.lJa.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.lnq != null) {
            this.lnq.cyx();
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
        if (this.lGX != null && this.lGX.aXt()) {
            this.lGX.stopRecord();
        }
        if (this.lCu != null) {
            this.lCu.cancelLoadData();
        }
        if (this.lnq != null) {
            this.lnq.Iw("record");
        }
        com.baidu.tbadk.core.util.m.deleteFileOrDir(new File(com.baidu.tieba.video.c.lAO));
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
        this.lIV = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra("forum_write_data") instanceof ForumWriteData) {
            this.hyK = (ForumWriteData) getIntent().getSerializableExtra("forum_write_data");
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.lCq = getIntent().getStringExtra("video_title");
        initUI();
        this.lCu = new SelectMusicModel(getPageContext(), this.lIE);
        this.lCu.diX();
        this.lJa = new j(this);
        this.lJa.b(this.lCu);
        this.lGX.a(this.lJa);
        registerListener(this.lJd);
        registerListener(this.hHz);
        dkE();
    }

    private void dkE() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void djx() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.lFE);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.lID = (RecordLayout) findViewById(R.id.root_layout);
        this.lID.setListener(this);
        this.lGX = new i(this);
        this.lIE = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.lIE.setRecordController(this.lGX);
        this.lIE.setRecordControlListener(this);
        this.lIE.setEffectChoosedListener(this);
        this.lIF = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.gdY = (ImageView) findViewById(R.id.close_page);
        this.gdY.setOnClickListener(this);
        this.lIG = (ImageView) findViewById(R.id.flash_switch);
        this.lIG.setOnClickListener(this);
        this.lIH = (ImageView) findViewById(R.id.camera_switch);
        this.lIH.setOnClickListener(this);
        this.lII = (ImageView) findViewById(R.id.count_down);
        this.lII.setOnClickListener(this);
        this.lIK = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.lHf = new h(this);
        this.lHf.a(this);
        this.lHf.setFaceIdentifyStateListener(this);
        this.lHf.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void dkr() {
                if (RecordVideoActivity.this.lIE.dld()) {
                    RecordVideoActivity.this.lIE.a((m) null);
                }
            }
        });
        this.lIM = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.lIM.setListener(this);
        this.lGX.a(this.lIM);
        this.lIM.setViewChoosed(2, true);
        this.lIL = (TextView) findViewById(R.id.tv_count_down);
        this.lIN = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.lIL.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.lIL.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.lIM.setVisibility(8);
        }
        this.bjL = findViewById(R.id.progress_layout);
        this.lIO = (RoundProgressBar) this.bjL.findViewById(R.id.video_progress);
        this.lIP = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lIP.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.lIP.setLayoutParams(layoutParams);
        this.lJb = (RecordTabLayout) findViewById(R.id.tab_layout);
        this.lJb.bB(1, getString(R.string.tab_photo));
        if (this.lIV != 2 && this.lIV != 3) {
            this.lJb.bB(2, getString(R.string.tab_record));
            this.lJb.setListener(this);
            this.lJb.setCurrentTab(2, false);
            ad(2, false);
        } else {
            this.lJb.setShowIndicator(false);
            this.lJb.setCurrentTab(1, false);
            ad(1, false);
        }
        dkF();
    }

    private void dkF() {
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
        this.lHf.onResume();
        this.lHN = this.lHf.dki();
        if (this.lHN != null) {
            this.lHN.setRecordController(this.lGX);
            this.lIK.setZoomHelper(this.lHN);
        }
        dkG();
        if (this.lIY == null) {
            this.lIY = new l();
            this.lIY.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void fx(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.lIZ, str2);
                    if (RecordVideoActivity.this.lIE != null) {
                        RecordVideoActivity.this.lIE.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void Nu(String str) {
                    if (RecordVideoActivity.this.lIE != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.lIE.b(stickerItem);
                        if (RecordVideoActivity.this.lHf != null) {
                            RecordVideoActivity.this.lHf.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.lIE != null) {
                        RecordVideoActivity.this.lIE.setDownLoadSticker(null);
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
                public void dii() {
                    if (RecordVideoActivity.this.lIE != null) {
                        RecordVideoActivity.this.lIE.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.lIY.dkX();
        if (this.lIE != null && this.lIX) {
            djx();
        }
        if (this.lnq != null) {
            this.lnq.Iv("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.lHf.onPause();
        if (this.lIE != null) {
            if (this.lGX != null && this.lGX.getStatus() == 6) {
                this.lIE.stopRecord();
                dkP();
            }
            if (this.lGX != null && this.lGX.aXt()) {
                this.lIE.stopRecord();
            }
        }
        if (this.lJa != null) {
            this.lJa.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.lGX == null || this.lGX.getStatus() != 7) {
            if (this.lGX != null && this.lGX.getStatus() == 6) {
                if (this.lIE != null) {
                    this.lIE.stopRecord();
                }
                dkP();
            } else if (this.lGX != null && this.lGX.onBackPressed()) {
                finish();
            } else {
                if (this.lIJ == null) {
                    this.lIJ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.lIJ.kF(R.string.video_quit_confirm);
                    this.lIJ.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.lIJ.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.lIJ.gW(true);
                    this.lIJ.b(getPageContext());
                }
                this.lIJ.aST();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.lIP.setVisibility(4);
        if (view == this.gdY) {
            onBackPressed();
        } else if (view == this.lIG) {
            if (this.lGX.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.lHf.dkl();
            dkG();
        } else if (view == this.lIH) {
            if (this.lGX.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.lIH.setOnClickListener(null);
            this.lHf.dkn();
            if (this.lHf.dko() && this.lHf.dkm()) {
                this.lHf.dkl();
            }
            dkG();
            this.lIH.setOnClickListener(this);
        } else if (view == this.lII) {
            dkI();
        }
    }

    private void dkG() {
        if (this.lHf.dko()) {
            this.lIG.setVisibility(8);
        } else {
            this.lIG.setVisibility(0);
        }
        if (this.lHf.dkm()) {
            this.lIG.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.lIG.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout dkH() {
        return this.lIK;
    }

    public void dkI() {
        this.lIP.setVisibility(4);
        if (this.lGX.getStatus() != 6) {
            this.lGX.setStatus(6);
            dkN();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.lIS == null) {
                this.lIS = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.lIS.setDuration(500L);
                this.lIS.setRepeatCount(5);
                this.lIS.setRepeatMode(2);
                this.lIS.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.lIS.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.lGX.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.lIL.setVisibility(0);
                        RecordVideoActivity.this.lIL.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.lIL.setVisibility(8);
                    if (RecordVideoActivity.this.lGX.getStatus() == 6) {
                        RecordVideoActivity.this.lIE.dla();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.lGX.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.lIL.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.lIL.setText("");
                        }
                    }
                }
            });
            this.lIL.setAnimation(this.lIS);
            this.lIS.startNow();
            this.lIE.dkI();
            if (this.lJa != null) {
                this.lJa.dkC();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dkJ() {
        if (this.lGX.getStatus() == 1) {
            this.lIP.setVisibility(4);
            if (this.lGX.getStatus() != 6) {
                this.lIE.dkJ();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dkK() {
        this.lIP.setVisibility(4);
        if (this.lGX.getStatus() != 6) {
            this.lIE.dkK();
            if (this.lIE.dle()) {
                dkE();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dkL() {
        this.lIP.setVisibility(4);
        if (this.lGX.getStatus() != 6) {
            this.lIE.dkL();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dkM() {
        this.lIP.setVisibility(4);
        if (this.lGX.getStatus() != 6) {
            this.lIE.dkM();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dkN() {
        this.lIW = true;
        if (this.lIR != null && this.lIR.isRunning()) {
            this.lIR.cancel();
        }
        if (this.lIQ == null) {
            this.lIQ = new AnimatorSet();
            this.lIQ.playTogether(ObjectAnimator.ofFloat(this.lIF, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.lIM, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.lJb, "alpha", 1.0f, 0.0f));
            this.lIQ.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.lKB) {
                        RecordVideoActivity.this.lIF.setVisibility(8);
                        RecordVideoActivity.this.lIM.setVisibility(8);
                        RecordVideoActivity.this.lJb.setVisibility(8);
                    }
                }
            });
            this.lIQ.setDuration(300L);
        }
        this.lIQ.start();
        this.lIM.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dkC() {
        if (this.hFJ == 2) {
            if (this.lIW) {
                this.lIW = false;
                if (this.lJa != null) {
                    this.lJa.dkC();
                }
            } else {
                return;
            }
        }
        if (this.lIQ != null && this.lIQ.isRunning()) {
            this.lIQ.cancel();
        }
        if (this.lIR == null) {
            this.lIR = new AnimatorSet();
            this.lIR.playTogether(ObjectAnimator.ofFloat(this.lIF, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.lIM, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.lJb, "alpha", 0.0f, 1.0f));
            this.lIR.setDuration(300L);
        }
        this.lIF.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.lIM.setVisibility(0);
        }
        if (this.lGX.getStatus() == 1) {
            this.lJb.setVisibility(0);
        }
        this.lIR.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dkO() {
        if (this.lHf != null) {
            this.lHf.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void A(boolean z, String str) {
                    RecordVideoActivity.this.lGX.setStatus(1);
                    RecordVideoActivity.this.dkC();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.lJc != null && !v.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.lJc)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.lJc);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.lJc = new ImageFileInfo();
                        RecordVideoActivity.this.lJc.setFilePath(str);
                        RecordVideoActivity.this.lJc.setContentUriStr(null);
                        RecordVideoActivity.this.lJc.setTempFile(true);
                        RecordVideoActivity.this.lJc.setAlbumnId(null);
                        RecordVideoActivity.this.lJc.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.lJc);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.hyK, RecordVideoActivity.this.lIV)));
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
    public void dkP() {
        this.lIS.cancel();
        this.lIS.setAnimationListener(null);
        this.lIL.clearAnimation();
        this.lIL.setVisibility(8);
        if (this.lJa != null) {
            this.lJa.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dkQ() {
        dcl();
    }

    private void dcl() {
        if (this.lIT != null) {
            this.lIT.cancel();
        }
        if (this.lIU == null) {
            this.lIU = ObjectAnimator.ofFloat(this.lJb, "alpha", 1.0f, 0.0f);
            this.lIU.setDuration(500L);
            this.lIU.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.lKB) {
                        RecordVideoActivity.this.lJb.setVisibility(8);
                    }
                }
            });
        }
        this.lIU.start();
    }

    private void dck() {
        if (this.lIU != null) {
            this.lIU.cancel();
        }
        if (this.lIT == null) {
            this.lIT = ObjectAnimator.ofFloat(this.lJb, "alpha", 0.0f, 1.0f);
            this.lIT.setDuration(500L);
        }
        this.lJb.setVisibility(0);
        this.lIT.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dkR() {
        this.lIM.reset();
        if (this.lGX.getStatus() == 1) {
            dck();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dkS() {
        if (this.bjL.getVisibility() != 0) {
            this.lIE.dkZ();
            this.lGX.setStatus(8);
            dkC();
            if (this.lHf.lHL != null && this.lHf.lHL.size() > 0) {
                this.bjL.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int lJg = 50;
        final int lJh = 1;
        Handler lJi = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.lIO.E(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.dkW();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void dkW() {
            this.lJi.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            dkW();
            boolean z = RecordVideoActivity.this.lJa == null || TextUtils.isEmpty(RecordVideoActivity.this.lJa.dkB()) || !new File(RecordVideoActivity.this.lJa.dkB()).exists();
            if (RecordVideoActivity.this.lHf.lHL.size() > 1) {
                return com.baidu.tieba.video.meida.h.djO().a(RecordVideoActivity.this.lHf.lHL, RecordVideoActivity.this.lHf.dkf(), z);
            }
            File file = new File(RecordVideoActivity.this.lHf.lHL.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.tbadk.core.util.m.copyFile(file.getPath(), RecordVideoActivity.this.lHf.dkf());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.djO().a(RecordVideoActivity.this.lHf.lHL, RecordVideoActivity.this.lHf.dkf(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.lIE.dlf();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.dkD();
                    RecordVideoActivity.this.Fj(102);
                    RecordVideoActivity.this.bjL.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.dkD();
                RecordVideoActivity.this.Fj(102);
                RecordVideoActivity.this.bjL.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.bjL.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.bj(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.lIO.E(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.lIE == null || v.isEmpty(this.lIE.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.lIE.getChoosedBeautyList()) {
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
        if (this.lIE == null || v.isEmpty(this.lIE.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.lIE.getChoosedFilterList()) {
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
        if (this.lIE == null || v.isEmpty(this.lIE.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.lIE.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dkT() {
        this.lIP.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dkU() {
        this.lIP.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dkV() {
        if (this.lGX.getStatus() == 1) {
            this.lJb.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.lHf != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.lHf.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new an("c12421").ag("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.lIM.setViewChoosed(2, false);
                            return;
                        } else {
                            this.lIM.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.lHf.setFilter((String) eVar.getValue());
                        an anVar = new an("c12496");
                        anVar.dh("obj_id", (String) eVar.getValue());
                        if (this.lGX.getStatus() == 1) {
                            anVar.ag("obj_type", 1);
                        } else {
                            anVar.ag("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.lIM.setViewChoosed(3, false);
                            return;
                        } else {
                            this.lIM.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.lJa.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.lIM.setViewChoosed(0, false);
                            return;
                        } else {
                            this.lIM.setViewChoosed(0, true);
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
            this.lIZ = stickerItem;
            this.lIY.NU(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.lHf != null) {
                    this.lHf.setSticker(null);
                    this.lJe = false;
                }
                if (this.lIE != null) {
                    this.lIE.setDownLoadSticker(null);
                }
                this.lIN.setVisibility(8);
                this.lIM.setViewChoosed(1, false);
                return;
            }
            String NR = this.lIY.NR(stickerItem.resource);
            if (!StringUtils.isNull(NR)) {
                a(stickerItem, NR);
                if (this.lIE != null) {
                    this.lIE.setDownLoadSticker(null);
                }
            } else {
                if (this.lIE != null) {
                    this.lIE.setDownLoadSticker(stickerItem);
                }
                this.lIY.NS(stickerItem.resource);
            }
            this.lIM.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.lHf != null) {
                this.lHf.setSticker(stickerItem);
                this.lJe = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.lIN.setText(stickerItem.desc);
                this.lIN.setVisibility(0);
                this.lIN.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.lIN.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.lIN.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void dd(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.lIE.getLayoutParams();
            layoutParams.height = i4;
            this.lIE.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String NC = com.baidu.tieba.video.editvideo.model.a.diR().NC(stringExtra);
                if (this.lJa != null && !TextUtils.isEmpty(NC)) {
                    this.lJa.fy(NC, stringExtra2);
                    this.lIE.djT();
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
        if (this.lGX.getStatus() == 8) {
            this.lIE.dkY();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void va(boolean z) {
        if (this.lGX != null && (this.lGX.getStatus() == 1 || this.lGX.getStatus() == 3 || this.lGX.getStatus() == 4)) {
            if (!z && this.lJe) {
                this.lIK.dks();
                return;
            } else {
                this.lIK.dkt();
                return;
            }
        }
        this.lIK.dkt();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void ad(int i, boolean z) {
        int i2 = 1;
        if (this.hFJ != i) {
            switch (i) {
                case 1:
                    if (this.lJa != null) {
                        this.lJa.aJz();
                    }
                    this.lHf.setFilter("origin");
                    this.lIM.setViewChoosed(0, false);
                    this.lIM.setViewChoosed(3, false);
                    this.lIE.Fl(1);
                    this.lIM.setViewVisibility(0, 8);
                    this.lIM.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.lIM.setViewVisibility(0, 0);
                    this.lIM.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.hFJ = i;
            this.lIE.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new an().ag("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dkA() {
        if (this.lGX.getStatus() == 1 && !this.lIE.dld()) {
            ad(1, true);
            this.lJb.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dkz() {
        if (this.lGX.getStatus() == 1 && !this.lIE.dld()) {
            ad(2, true);
            this.lJb.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fj(int i) {
        if (this.lnq != null) {
            this.lnq.bk(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bj(int i, String str) {
        if (this.lnq != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.lnq.bj(i, str);
        }
    }
}
