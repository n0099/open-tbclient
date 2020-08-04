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
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.x;
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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes17.dex */
public class RecordVideoActivity extends BaseActivity implements GLVideoPreviewView.a, RecordLayout.a, RecordTabLayout.a, VideoControllerLayout.a, VideoEffectButtonLayout.a, VideoEffectLayout.a, h.c {
    private View bdK;
    private ImageView gwo;
    private com.baidu.tbadk.core.dialog.a hJl;
    private ForumWriteData hRH;
    private int hYX;
    private final CustomMessageListener iaM;
    private final CustomMessageListener jLW;
    private com.baidu.tieba.k.h lOv;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;
    private String mdr;
    private SelectMusicModel mdv;
    private b.a mgO;
    private b miZ;
    private i mii;
    protected h mir;
    private RecordLayout mjP;
    private VideoControllerLayout mjQ;
    private RelativeLayout mjR;
    private ImageView mjS;
    private ImageView mjT;
    private ImageView mjU;
    private PreviewViewContainer mjV;
    private TextView mjW;
    private VideoEffectButtonLayout mjX;
    private TextView mjY;
    private RoundProgressBar mjZ;
    private TextView mka;
    private AnimatorSet mkb;
    private AnimatorSet mkc;
    private ScaleAnimation mkd;
    private ObjectAnimator mke;
    private ObjectAnimator mkf;
    private int mkg;
    private int mkh;
    private boolean mki;
    private boolean mkj = true;
    private l mkk;
    private StickerItem mkl;
    protected j mkm;
    private RecordTabLayout mkn;
    private ImageFileInfo mko;
    private HttpMessageListener mkp;
    private boolean mkq;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.lOv = lVar.cGE();
        }
        if (this.lOv != null) {
            this.lOv.cGn();
        }
        this.mgO = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void fh(List<com.baidu.tieba.video.localvideo.d> list) {
                if (x.isEmpty(list)) {
                    if (RecordVideoActivity.this.mjQ != null) {
                        RecordVideoActivity.this.mjQ.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.mjQ != null) {
                    RecordVideoActivity.this.mjQ.setHasLocalVideo(true);
                    RecordVideoActivity.this.mkj = false;
                }
            }
        };
        this.mkp = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
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
                    if (RecordVideoActivity.this.mjQ != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.mjQ.setStickerItems(list);
                    }
                }
            }
        };
        this.iaM = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    RecordVideoActivity.this.finish();
                }
            }
        };
        this.jLW = new CustomMessageListener(2001373) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
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
    public void dsd() {
        PostPrefixData postPrefixData;
        AntiData antiData = null;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.mir.mgd);
        videoInfo.setVideoDuration(this.mii.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.mir.mgd).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.hRH == null ? "" : this.hRH.forumName;
        String str2 = this.hRH == null ? "" : this.hRH.forumId;
        int i = this.hRH == null ? -1 : this.hRH.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.hRH.writeCallFrom, str, str2, this.mdr, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        editVideoActivityConfig.setFrsTabInfo(this.hRH != null ? this.hRH.frsTabInfo : null);
        String str3 = "";
        String str4 = "";
        if (getIntent() != null) {
            Serializable serializableExtra = getIntent().getSerializableExtra("anti_data");
            AntiData antiData2 = serializableExtra instanceof AntiData ? (AntiData) serializableExtra : null;
            Serializable serializableExtra2 = getIntent().getSerializableExtra("prefix_data");
            PostPrefixData postPrefixData2 = serializableExtra2 instanceof PostPrefixData ? (PostPrefixData) serializableExtra2 : null;
            antiData = antiData2;
            str3 = getIntent().getStringExtra("forum_first_dir");
            postPrefixData = postPrefixData2;
            str4 = getIntent().getStringExtra("forum_second_dir");
        } else {
            postPrefixData = null;
        }
        editVideoActivityConfig.setExtraData(antiData, postPrefixData, str3, str4);
        editVideoActivityConfig.setFrom(this.hRH.mFrom);
        if (this.mkm != null) {
            this.mkm.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.lOv != null) {
            this.lOv.cGq();
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
        if (this.mii != null && this.mii.bdw()) {
            this.mii.stopRecord();
        }
        if (this.mdv != null) {
            this.mdv.cancelLoadData();
        }
        if (this.lOv != null) {
            this.lOv.JN("record");
        }
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
        this.mkg = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        this.mkh = getIntent().getIntExtra(RecordVideoActivityConfig.SHOW_TYPE, 0);
        if (getIntent().getSerializableExtra("forum_write_data") instanceof ForumWriteData) {
            this.hRH = (ForumWriteData) getIntent().getSerializableExtra("forum_write_data");
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.mdr = getIntent().getStringExtra("video_title");
        initUI();
        this.mdv = new SelectMusicModel(getPageContext(), this.mjQ);
        this.mdv.dqv();
        this.mkm = new j(this);
        this.mkm.b(this.mdv);
        this.mii.a(this.mkm);
        registerListener(this.mkp);
        registerListener(this.iaM);
        registerListener(this.jLW);
        dse();
    }

    private void dse() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void dqX() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.mgO);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.mjP = (RecordLayout) findViewById(R.id.root_layout);
        this.mjP.setListener(this);
        this.mii = new i(this);
        this.mjQ = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.mjQ.setRecordController(this.mii);
        this.mjQ.setRecordControlListener(this);
        this.mjQ.setEffectChoosedListener(this);
        this.mjR = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.gwo = (ImageView) findViewById(R.id.close_page);
        this.gwo.setOnClickListener(this);
        this.mjS = (ImageView) findViewById(R.id.flash_switch);
        this.mjS.setOnClickListener(this);
        this.mjT = (ImageView) findViewById(R.id.camera_switch);
        this.mjT.setOnClickListener(this);
        this.mjU = (ImageView) findViewById(R.id.count_down);
        this.mjU.setOnClickListener(this);
        this.mjV = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.mir = new h(this);
        this.mir.a(this);
        this.mir.setFaceIdentifyStateListener(this);
        this.mir.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
            @Override // com.baidu.tieba.video.record.h.b
            public void drR() {
                if (RecordVideoActivity.this.mjQ.dsD()) {
                    RecordVideoActivity.this.mjQ.a((m) null);
                }
            }
        });
        this.mjX = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.mjX.setListener(this);
        this.mii.a(this.mjX);
        this.mjX.setViewChoosed(2, true);
        this.mjW = (TextView) findViewById(R.id.tv_count_down);
        this.mjY = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.mjW.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.mjW.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.mjX.setVisibility(8);
        }
        this.bdK = findViewById(R.id.progress_layout);
        this.mjZ = (RoundProgressBar) this.bdK.findViewById(R.id.video_progress);
        this.mka = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mka.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.mka.setLayoutParams(layoutParams);
        this.mkn = (RecordTabLayout) findViewById(R.id.tab_layout);
        if (this.mWriteImagesInfo == null || x.isEmpty(this.mWriteImagesInfo.getChosedFiles())) {
            GI(this.mkh);
        } else {
            GI(1);
        }
        dsf();
    }

    private void GI(int i) {
        if (this.mkn != null) {
            if (i == 0) {
                this.mkn.bJ(1, getString(R.string.tab_photo));
                this.mkn.bJ(2, getString(R.string.tab_record));
                this.mkn.setListener(this);
                this.mkn.setCurrentTab(2, false);
                af(2, false);
            } else if (i == 1) {
                this.mkn.bJ(1, getString(R.string.tab_photo));
                this.mkn.setShowIndicator(false);
                this.mkn.setCurrentTab(1, false);
                af(1, false);
            } else {
                this.mkn.bJ(2, getString(R.string.tab_record));
                this.mkn.setShowIndicator(false);
                this.mkn.setCurrentTab(2, false);
                af(2, false);
            }
        }
    }

    private void dsf() {
        if (com.baidu.tbadk.core.util.g.aZY()) {
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
        this.mir.onResume();
        this.miZ = this.mir.drI();
        if (this.miZ != null) {
            this.miZ.setRecordController(this.mii);
            this.mjV.setZoomHelper(this.miZ);
        }
        dsg();
        if (this.mkk == null) {
            this.mkk = new l();
            this.mkk.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                @Override // com.baidu.tieba.video.record.l.a
                public void fG(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.mkl, str2);
                    if (RecordVideoActivity.this.mjQ != null) {
                        RecordVideoActivity.this.mjQ.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void OE(String str) {
                    if (RecordVideoActivity.this.mjQ != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.mjQ.b(stickerItem);
                        if (RecordVideoActivity.this.mir != null) {
                            RecordVideoActivity.this.mir.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.mjQ != null) {
                        RecordVideoActivity.this.mjQ.setDownLoadSticker(null);
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
                    recordVideoActivity.bp(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void dpJ() {
                    if (RecordVideoActivity.this.mjQ != null) {
                        RecordVideoActivity.this.mjQ.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.mkk.dsx();
        if (this.mjQ != null && this.mkj) {
            dqX();
        }
        if (this.lOv != null) {
            this.lOv.JM("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mir.onPause();
        if (this.mjQ != null) {
            if (this.mii != null && this.mii.getStatus() == 6) {
                this.mjQ.stopRecord();
                dsp();
            }
            if (this.mii != null && this.mii.bdw()) {
                this.mjQ.stopRecord();
            }
        }
        if (this.mkm != null) {
            this.mkm.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.mii == null || this.mii.getStatus() != 7) {
            if (this.mii != null && this.mii.getStatus() == 6) {
                if (this.mjQ != null) {
                    this.mjQ.stopRecord();
                }
                dsp();
            } else if (this.mii != null && this.mii.onBackPressed()) {
                finish();
            } else {
                if (this.hJl == null) {
                    this.hJl = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.hJl.ln(R.string.video_quit_confirm);
                    this.hJl.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.hJl.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.hJl.hJ(true);
                    this.hJl.b(getPageContext());
                }
                this.hJl.aYL();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.mka.setVisibility(4);
        if (view == this.gwo) {
            onBackPressed();
        } else if (view == this.mjS) {
            if (this.mii.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.mir.drL();
            dsg();
        } else if (view == this.mjT) {
            if (this.mii.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.mjT.setOnClickListener(null);
            this.mir.drN();
            if (this.mir.drO() && this.mir.drM()) {
                this.mir.drL();
            }
            dsg();
            this.mjT.setOnClickListener(this);
        } else if (view == this.mjU) {
            dsi();
        }
    }

    private void dsg() {
        if (this.mir.drO()) {
            this.mjS.setVisibility(8);
        } else {
            this.mjS.setVisibility(0);
        }
        if (this.mir.drM()) {
            this.mjS.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.mjS.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout dsh() {
        return this.mjV;
    }

    public void dsi() {
        this.mka.setVisibility(4);
        if (this.mii.getStatus() != 6) {
            this.mii.setStatus(6);
            dsn();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.mkd == null) {
                this.mkd = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.mkd.setDuration(500L);
                this.mkd.setRepeatCount(5);
                this.mkd.setRepeatMode(2);
                this.mkd.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.mkd.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.mii.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.mjW.setVisibility(0);
                        RecordVideoActivity.this.mjW.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.mjW.setVisibility(8);
                    if (RecordVideoActivity.this.mii.getStatus() == 6) {
                        RecordVideoActivity.this.mjQ.dsA();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.mii.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.mjW.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.mjW.setText("");
                        }
                    }
                }
            });
            this.mjW.setAnimation(this.mkd);
            this.mkd.startNow();
            this.mjQ.dsi();
            if (this.mkm != null) {
                this.mkm.dsc();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dsj() {
        if (this.mii.getStatus() == 1) {
            this.mka.setVisibility(4);
            if (this.mii.getStatus() != 6) {
                this.mjQ.dsj();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dsk() {
        this.mka.setVisibility(4);
        if (this.mii.getStatus() != 6) {
            this.mjQ.dsk();
            if (this.mjQ.dsE()) {
                dse();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dsl() {
        this.mka.setVisibility(4);
        if (this.mii.getStatus() != 6) {
            this.mjQ.dsl();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dsm() {
        this.mka.setVisibility(4);
        if (this.mii.getStatus() != 6) {
            this.mjQ.dsm();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dsn() {
        this.mki = true;
        if (this.mkc != null && this.mkc.isRunning()) {
            this.mkc.cancel();
        }
        if (this.mkb == null) {
            this.mkb = new AnimatorSet();
            this.mkb.playTogether(ObjectAnimator.ofFloat(this.mjR, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.mjX, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.mkn, "alpha", 1.0f, 0.0f));
            this.mkb.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.mlN) {
                        RecordVideoActivity.this.mjR.setVisibility(8);
                        RecordVideoActivity.this.mjX.setVisibility(8);
                        RecordVideoActivity.this.mkn.setVisibility(8);
                    }
                }
            });
            this.mkb.setDuration(300L);
        }
        this.mkb.start();
        this.mjX.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dsc() {
        if (this.hYX == 2) {
            if (this.mki) {
                this.mki = false;
                if (this.mkm != null) {
                    this.mkm.dsc();
                }
            } else {
                return;
            }
        }
        if (this.mkb != null && this.mkb.isRunning()) {
            this.mkb.cancel();
        }
        if (this.mkc == null) {
            this.mkc = new AnimatorSet();
            this.mkc.playTogether(ObjectAnimator.ofFloat(this.mjR, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.mjX, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.mkn, "alpha", 0.0f, 1.0f));
            this.mkc.setDuration(300L);
        }
        this.mjR.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.mjX.setVisibility(0);
        }
        if (this.mii.getStatus() == 1) {
            this.mkn.setVisibility(0);
        }
        this.mkc.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dso() {
        if (this.mir != null) {
            this.mir.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.14
                @Override // com.baidu.tieba.video.record.g.a
                public void C(boolean z, String str) {
                    RecordVideoActivity.this.mii.setStatus(1);
                    RecordVideoActivity.this.dsc();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.mko != null && !x.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.mko)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.mko);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.mko = new ImageFileInfo();
                        RecordVideoActivity.this.mko.setFilePath(str);
                        RecordVideoActivity.this.mko.setContentUriStr(null);
                        RecordVideoActivity.this.mko.setTempFile(true);
                        RecordVideoActivity.this.mko.setAlbumnId(null);
                        RecordVideoActivity.this.mko.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.mko);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.hRH, RecordVideoActivity.this.mkg)));
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
    public void dsp() {
        this.mkd.cancel();
        this.mkd.setAnimationListener(null);
        this.mjW.clearAnimation();
        this.mjW.setVisibility(8);
        if (this.mkm != null) {
            this.mkm.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dsq() {
        djK();
    }

    private void djK() {
        if (this.mke != null) {
            this.mke.cancel();
        }
        if (this.mkf == null) {
            this.mkf = ObjectAnimator.ofFloat(this.mkn, "alpha", 1.0f, 0.0f);
            this.mkf.setDuration(500L);
            this.mkf.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.mlN) {
                        RecordVideoActivity.this.mkn.setVisibility(8);
                    }
                }
            });
        }
        this.mkf.start();
    }

    private void djJ() {
        if (this.mkf != null) {
            this.mkf.cancel();
        }
        if (this.mke == null) {
            this.mke = ObjectAnimator.ofFloat(this.mkn, "alpha", 0.0f, 1.0f);
            this.mke.setDuration(500L);
        }
        this.mkn.setVisibility(0);
        this.mke.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dsr() {
        this.mjX.reset();
        if (this.mii.getStatus() == 1) {
            djJ();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dss() {
        if (this.bdK.getVisibility() != 0) {
            this.mjQ.dsz();
            this.mii.setStatus(8);
            dsc();
            if (this.mir.miX != null && this.mir.miX.size() > 0) {
                this.bdK.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes17.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        int mProgress;
        final int mks = 50;
        final int mkt = 1;
        Handler mku = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.mjZ.G(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.dsw();
                }
            }
        };

        AnonymousClass3() {
        }

        public void dsw() {
            this.mku.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            dsw();
            boolean z = RecordVideoActivity.this.mkm == null || TextUtils.isEmpty(RecordVideoActivity.this.mkm.dsb()) || !new File(RecordVideoActivity.this.mkm.dsb()).exists();
            if (RecordVideoActivity.this.mir.miX.size() > 1) {
                return com.baidu.tieba.video.meida.h.dro().a(RecordVideoActivity.this.mir.miX, RecordVideoActivity.this.mir.drF(), z);
            }
            File file = new File(RecordVideoActivity.this.mir.miX.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    n.copyFile(file.getPath(), RecordVideoActivity.this.mir.drF());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.dro().a(RecordVideoActivity.this.mir.miX, RecordVideoActivity.this.mir.drF(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.mjQ.dsF();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.dsd();
                    RecordVideoActivity.this.GJ(102);
                    RecordVideoActivity.this.bdK.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.dsd();
                RecordVideoActivity.this.GJ(102);
                RecordVideoActivity.this.bdK.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.bdK.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.bp(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.mjZ.G(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.mjQ == null || x.isEmpty(this.mjQ.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.mjQ.getChoosedBeautyList()) {
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
        if (this.mjQ == null || x.isEmpty(this.mjQ.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.mjQ.getChoosedFilterList()) {
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
        if (this.mjQ == null || x.isEmpty(this.mjQ.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.mjQ.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dst() {
        this.mka.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dsu() {
        this.mka.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dsv() {
        if (this.mii.getStatus() == 1) {
            this.mkn.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.mir != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.mir.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new ap("c12421").ah("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.mjX.setViewChoosed(2, false);
                            return;
                        } else {
                            this.mjX.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.mir.setFilter((String) eVar.getValue());
                        ap apVar = new ap("c12496");
                        apVar.dn("obj_id", (String) eVar.getValue());
                        if (this.mii.getStatus() == 1) {
                            apVar.ah("obj_type", 1);
                        } else {
                            apVar.ah("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.mjX.setViewChoosed(3, false);
                            return;
                        } else {
                            this.mjX.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.mkm.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.mjX.setViewChoosed(0, false);
                            return;
                        } else {
                            this.mjX.setViewChoosed(0, true);
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
            this.mkl = stickerItem;
            this.mkk.Pf(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.mir != null) {
                    this.mir.setSticker(null);
                    this.mkq = false;
                }
                if (this.mjQ != null) {
                    this.mjQ.setDownLoadSticker(null);
                }
                this.mjY.setVisibility(8);
                this.mjX.setViewChoosed(1, false);
                return;
            }
            String Pc = this.mkk.Pc(stickerItem.resource);
            if (!StringUtils.isNull(Pc)) {
                a(stickerItem, Pc);
                if (this.mjQ != null) {
                    this.mjQ.setDownLoadSticker(null);
                }
            } else {
                if (this.mjQ != null) {
                    this.mjQ.setDownLoadSticker(stickerItem);
                }
                this.mkk.Pd(stickerItem.resource);
            }
            this.mjX.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.mir != null) {
                this.mir.setSticker(stickerItem);
                this.mkq = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.mjY.setText(stickerItem.desc);
                this.mjY.setVisibility(0);
                this.mjY.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.mjY.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.mjY.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void dl(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.mjQ.getLayoutParams();
            layoutParams.height = i4;
            this.mjQ.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String OK = com.baidu.tieba.video.editvideo.model.a.dqp().OK(stringExtra);
                if (this.mkm != null && !TextUtils.isEmpty(OK)) {
                    this.mkm.fJ(OK, stringExtra2);
                    this.mjQ.drt();
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
        if (this.mii.getStatus() == 8) {
            this.mjQ.dsy();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void vW(boolean z) {
        if (this.mii != null && (this.mii.getStatus() == 1 || this.mii.getStatus() == 3 || this.mii.getStatus() == 4)) {
            if (!z && this.mkq) {
                this.mjV.drS();
                return;
            } else {
                this.mjV.drT();
                return;
            }
        }
        this.mjV.drT();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void af(int i, boolean z) {
        int i2 = 1;
        if (this.hYX != i) {
            switch (i) {
                case 1:
                    if (this.mkm != null) {
                        this.mkm.aOt();
                    }
                    this.mir.setFilter("origin");
                    this.mjX.setViewChoosed(0, false);
                    this.mjX.setViewChoosed(3, false);
                    this.mjQ.GL(1);
                    this.mjX.setViewVisibility(0, 8);
                    this.mjX.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.mjX.setViewVisibility(0, 0);
                    this.mjX.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.hYX = i;
            this.mjQ.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new ap().ah("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dsa() {
        if (this.mii.getStatus() == 1 && !this.mjQ.dsD()) {
            af(1, true);
            this.mkn.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void drZ() {
        if (this.mii.getStatus() == 1 && !this.mjQ.dsD()) {
            af(2, true);
            this.mkn.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GJ(int i) {
        if (this.lOv != null) {
            this.lOv.bq(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(int i, String str) {
        if (this.lOv != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.lOv.bp(i, str);
        }
    }
}
