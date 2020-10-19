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
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.y;
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
/* loaded from: classes23.dex */
public class RecordVideoActivity extends BaseActivity implements GLVideoPreviewView.a, RecordLayout.a, RecordTabLayout.a, VideoControllerLayout.a, VideoEffectButtonLayout.a, VideoEffectLayout.a, h.c {
    private View bnC;
    private final CustomMessageListener fBr;
    private ForumWriteData iBQ;
    private int iJv;
    private final CustomMessageListener iLj;
    private com.baidu.tbadk.core.dialog.a isM;
    private ImageView joo;
    private Context mContext;
    private com.baidu.tieba.k.h mFB;
    private View mStatusBarView;
    private String mUT;
    private SelectMusicModel mUX;
    private WriteImagesInfo mWriteImagesInfo;
    private b.a mYn;
    private i mZG;
    protected h mZO;
    private b naw;
    private ObjectAnimator nbA;
    private ObjectAnimator nbB;
    private int nbC;
    private int nbD;
    private boolean nbE;
    private boolean nbF = true;
    private l nbG;
    private StickerItem nbH;
    protected j nbI;
    private RecordTabLayout nbJ;
    private ImageFileInfo nbK;
    private HttpMessageListener nbL;
    private boolean nbM;
    private RecordLayout nbl;
    private VideoControllerLayout nbm;
    private RelativeLayout nbn;
    private ImageView nbo;
    private ImageView nbp;
    private ImageView nbq;
    private PreviewViewContainer nbr;
    private TextView nbs;
    private VideoEffectButtonLayout nbt;
    private TextView nbu;
    private RoundProgressBar nbv;
    private TextView nbw;
    private AnimatorSet nbx;
    private AnimatorSet nby;
    private ScaleAnimation nbz;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.mFB = lVar.cYJ();
        }
        if (this.mFB != null) {
            this.mFB.cYs();
        }
        this.mYn = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void fB(List<com.baidu.tieba.video.localvideo.d> list) {
                if (y.isEmpty(list)) {
                    if (RecordVideoActivity.this.nbm != null) {
                        RecordVideoActivity.this.nbm.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.nbm != null) {
                    RecordVideoActivity.this.nbm.setHasLocalVideo(true);
                    RecordVideoActivity.this.nbF = false;
                }
            }
        };
        this.nbL = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
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
                    if (RecordVideoActivity.this.nbm != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.nbm.setStickerItems(list);
                    }
                }
            }
        };
        this.iLj = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    RecordVideoActivity.this.finish();
                }
            }
        };
        this.fBr = new CustomMessageListener(2001373) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
    public void dLn() {
        PostPrefixData postPrefixData;
        AntiData antiData = null;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.mZO.mXC);
        videoInfo.setVideoDuration(this.mZG.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.mZO.mXC).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.iBQ == null ? "" : this.iBQ.forumName;
        String str2 = this.iBQ == null ? "" : this.iBQ.forumId;
        int i = this.iBQ == null ? -1 : this.iBQ.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.iBQ.writeCallFrom, str, str2, this.mUT, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        editVideoActivityConfig.setFrsTabInfo(this.iBQ != null ? this.iBQ.frsTabInfo : null);
        editVideoActivityConfig.setForumLevel(this.iBQ != null ? this.iBQ.forumLevel : -1);
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
        editVideoActivityConfig.setFrom(this.iBQ.mFrom);
        if (this.nbI != null) {
            this.nbI.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.mFB != null) {
            this.mFB.cYv();
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
        if (this.mZG != null && this.mZG.bpG()) {
            this.mZG.stopRecord();
        }
        if (this.mUX != null) {
            this.mUX.cancelLoadData();
        }
        if (this.mFB != null) {
            this.mFB.NX("record");
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
        this.nbC = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        this.nbD = getIntent().getIntExtra(RecordVideoActivityConfig.SHOW_TYPE, 0);
        if (getIntent().getSerializableExtra("forum_write_data") instanceof ForumWriteData) {
            this.iBQ = (ForumWriteData) getIntent().getSerializableExtra("forum_write_data");
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.mUT = getIntent().getStringExtra("video_title");
        initUI();
        this.mUX = new SelectMusicModel(getPageContext(), this.nbm);
        this.mUX.dJF();
        this.nbI = new j(this);
        this.nbI.b(this.mUX);
        this.mZG.a(this.nbI);
        registerListener(this.nbL);
        registerListener(this.iLj);
        registerListener(this.fBr);
        dLo();
        if (Build.VERSION.SDK_INT >= 28 && an.bmN() && TbSingleton.getInstance().isCutoutScreen(this)) {
            com.baidu.tieba.v.c.a(1, getWindow().getAttributes(), getWindow());
        }
    }

    private void dLo() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void dKh() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.mYn);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.nbl = (RecordLayout) findViewById(R.id.root_layout);
        this.nbl.setListener(this);
        this.mZG = new i(this);
        this.nbm = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.nbm.setRecordController(this.mZG);
        this.nbm.setRecordControlListener(this);
        this.nbm.setEffectChoosedListener(this);
        this.nbn = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.joo = (ImageView) findViewById(R.id.close_page);
        this.joo.setOnClickListener(this);
        this.nbo = (ImageView) findViewById(R.id.flash_switch);
        this.nbo.setOnClickListener(this);
        this.nbp = (ImageView) findViewById(R.id.camera_switch);
        this.nbp.setOnClickListener(this);
        this.nbq = (ImageView) findViewById(R.id.count_down);
        this.nbq.setOnClickListener(this);
        this.nbr = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.mZO = new h(this);
        this.mZO.a(this);
        this.mZO.setFaceIdentifyStateListener(this);
        this.mZO.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
            @Override // com.baidu.tieba.video.record.h.b
            public void dLb() {
                if (RecordVideoActivity.this.nbm.dLN()) {
                    RecordVideoActivity.this.nbm.a((m) null);
                }
            }
        });
        this.nbt = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.nbt.setListener(this);
        this.mZG.a(this.nbt);
        this.nbt.setViewChoosed(2, true);
        this.nbs = (TextView) findViewById(R.id.tv_count_down);
        this.nbu = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.nbs.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.nbs.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.nbt.setVisibility(8);
        }
        this.bnC = findViewById(R.id.progress_layout);
        this.nbv = (RoundProgressBar) this.bnC.findViewById(R.id.video_progress);
        this.nbw = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nbw.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.nbw.setLayoutParams(layoutParams);
        this.nbJ = (RecordTabLayout) findViewById(R.id.tab_layout);
        if (this.mWriteImagesInfo == null || y.isEmpty(this.mWriteImagesInfo.getChosedFiles())) {
            Ko(this.nbD);
        } else {
            Ko(1);
        }
        dLp();
    }

    private void Ko(int i) {
        if (this.nbJ != null) {
            if (i == 0) {
                this.nbJ.bU(1, getString(R.string.tab_photo));
                this.nbJ.bU(2, getString(R.string.tab_record));
                this.nbJ.setListener(this);
                this.nbJ.setCurrentTab(2, false);
                ak(2, false);
            } else if (i == 1) {
                this.nbJ.bU(1, getString(R.string.tab_photo));
                this.nbJ.setShowIndicator(false);
                this.nbJ.setCurrentTab(1, false);
                ak(1, false);
            } else {
                this.nbJ.bU(2, getString(R.string.tab_record));
                this.nbJ.setShowIndicator(false);
                this.nbJ.setCurrentTab(2, false);
                ak(2, false);
            }
        }
    }

    private void dLp() {
        if (com.baidu.tbadk.core.util.g.blX()) {
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
        this.mZO.onResume();
        this.naw = this.mZO.dKS();
        if (this.naw != null) {
            this.naw.setRecordController(this.mZG);
            this.nbr.setZoomHelper(this.naw);
        }
        dLq();
        if (this.nbG == null) {
            this.nbG = new l();
            this.nbG.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                @Override // com.baidu.tieba.video.record.l.a
                public void gr(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.nbH, str2);
                    if (RecordVideoActivity.this.nbm != null) {
                        RecordVideoActivity.this.nbm.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void SQ(String str) {
                    if (RecordVideoActivity.this.nbm != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.nbm.b(stickerItem);
                        if (RecordVideoActivity.this.mZO != null) {
                            RecordVideoActivity.this.mZO.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.nbm != null) {
                        RecordVideoActivity.this.nbm.setDownLoadSticker(null);
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
                    recordVideoActivity.bA(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void dIT() {
                    if (RecordVideoActivity.this.nbm != null) {
                        RecordVideoActivity.this.nbm.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.nbG.dLH();
        if (this.nbm != null && this.nbF) {
            dKh();
        }
        if (this.mFB != null) {
            this.mFB.NW("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mZO.onPause();
        if (this.nbm != null) {
            if (this.mZG != null && this.mZG.getStatus() == 6) {
                this.nbm.stopRecord();
                dLz();
            }
            if (this.mZG != null && this.mZG.bpG()) {
                this.nbm.stopRecord();
            }
        }
        if (this.nbI != null) {
            this.nbI.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.mZG == null || this.mZG.getStatus() != 7) {
            if (this.mZG != null && this.mZG.getStatus() == 6) {
                if (this.nbm != null) {
                    this.nbm.stopRecord();
                }
                dLz();
            } else if (this.mZG != null && this.mZG.onBackPressed()) {
                finish();
            } else {
                if (this.isM == null) {
                    this.isM = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.isM.ob(R.string.video_quit_confirm);
                    this.isM.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.isM.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.isM.iz(true);
                    this.isM.b(getPageContext());
                }
                this.isM.bkJ();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.nbw.setVisibility(4);
        if (view == this.joo) {
            onBackPressed();
        } else if (view == this.nbo) {
            if (this.mZG.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.mZO.dKV();
            dLq();
        } else if (view == this.nbp) {
            if (this.mZG.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.nbp.setOnClickListener(null);
            this.mZO.dKX();
            if (this.mZO.dKY() && this.mZO.dKW()) {
                this.mZO.dKV();
            }
            dLq();
            this.nbp.setOnClickListener(this);
        } else if (view == this.nbq) {
            dLs();
        }
    }

    private void dLq() {
        if (this.mZO.dKY()) {
            this.nbo.setVisibility(8);
        } else {
            this.nbo.setVisibility(0);
        }
        if (this.mZO.dKW()) {
            this.nbo.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.nbo.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout dLr() {
        return this.nbr;
    }

    public void dLs() {
        this.nbw.setVisibility(4);
        if (this.mZG.getStatus() != 6) {
            this.mZG.setStatus(6);
            dLx();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.nbz == null) {
                this.nbz = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.nbz.setDuration(500L);
                this.nbz.setRepeatCount(5);
                this.nbz.setRepeatMode(2);
                this.nbz.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.nbz.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.mZG.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.nbs.setVisibility(0);
                        RecordVideoActivity.this.nbs.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.nbs.setVisibility(8);
                    if (RecordVideoActivity.this.mZG.getStatus() == 6) {
                        RecordVideoActivity.this.nbm.dLK();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.mZG.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.nbs.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.nbs.setText("");
                        }
                    }
                }
            });
            this.nbs.setAnimation(this.nbz);
            this.nbz.startNow();
            this.nbm.dLs();
            if (this.nbI != null) {
                this.nbI.dLm();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dLt() {
        if (this.mZG.getStatus() == 1) {
            this.nbw.setVisibility(4);
            if (this.mZG.getStatus() != 6) {
                this.nbm.dLt();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dLu() {
        this.nbw.setVisibility(4);
        if (this.mZG.getStatus() != 6) {
            this.nbm.dLu();
            if (this.nbm.dLO()) {
                dLo();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dLv() {
        this.nbw.setVisibility(4);
        if (this.mZG.getStatus() != 6) {
            this.nbm.dLv();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dLw() {
        this.nbw.setVisibility(4);
        if (this.mZG.getStatus() != 6) {
            this.nbm.dLw();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dLx() {
        this.nbE = true;
        if (this.nby != null && this.nby.isRunning()) {
            this.nby.cancel();
        }
        if (this.nbx == null) {
            this.nbx = new AnimatorSet();
            this.nbx.playTogether(ObjectAnimator.ofFloat(this.nbn, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nbt, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nbJ, "alpha", 1.0f, 0.0f));
            this.nbx.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.ndj) {
                        RecordVideoActivity.this.nbn.setVisibility(8);
                        RecordVideoActivity.this.nbt.setVisibility(8);
                        RecordVideoActivity.this.nbJ.setVisibility(8);
                    }
                }
            });
            this.nbx.setDuration(300L);
        }
        this.nbx.start();
        this.nbt.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dLm() {
        if (this.iJv == 2) {
            if (this.nbE) {
                this.nbE = false;
                if (this.nbI != null) {
                    this.nbI.dLm();
                }
            } else {
                return;
            }
        }
        if (this.nbx != null && this.nbx.isRunning()) {
            this.nbx.cancel();
        }
        if (this.nby == null) {
            this.nby = new AnimatorSet();
            this.nby.playTogether(ObjectAnimator.ofFloat(this.nbn, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nbt, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nbJ, "alpha", 0.0f, 1.0f));
            this.nby.setDuration(300L);
        }
        this.nbn.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.nbt.setVisibility(0);
        }
        if (this.mZG.getStatus() == 1) {
            this.nbJ.setVisibility(0);
        }
        this.nby.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dLy() {
        if (this.mZO != null) {
            this.mZO.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.14
                @Override // com.baidu.tieba.video.record.g.a
                public void D(boolean z, String str) {
                    RecordVideoActivity.this.mZG.setStatus(1);
                    RecordVideoActivity.this.dLm();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.nbK != null && !y.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.nbK)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.nbK);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.nbK = new ImageFileInfo();
                        RecordVideoActivity.this.nbK.setFilePath(str);
                        RecordVideoActivity.this.nbK.setContentUriStr(null);
                        RecordVideoActivity.this.nbK.setTempFile(true);
                        RecordVideoActivity.this.nbK.setAlbumnId(null);
                        RecordVideoActivity.this.nbK.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.nbK);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.iBQ, RecordVideoActivity.this.nbC)));
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
    public void dLz() {
        this.nbz.cancel();
        this.nbz.setAnimationListener(null);
        this.nbs.clearAnimation();
        this.nbs.setVisibility(8);
        if (this.nbI != null) {
            this.nbI.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dLA() {
        dCQ();
    }

    private void dCQ() {
        if (this.nbA != null) {
            this.nbA.cancel();
        }
        if (this.nbB == null) {
            this.nbB = ObjectAnimator.ofFloat(this.nbJ, "alpha", 1.0f, 0.0f);
            this.nbB.setDuration(500L);
            this.nbB.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.ndj) {
                        RecordVideoActivity.this.nbJ.setVisibility(8);
                    }
                }
            });
        }
        this.nbB.start();
    }

    private void dCP() {
        if (this.nbB != null) {
            this.nbB.cancel();
        }
        if (this.nbA == null) {
            this.nbA = ObjectAnimator.ofFloat(this.nbJ, "alpha", 0.0f, 1.0f);
            this.nbA.setDuration(500L);
        }
        this.nbJ.setVisibility(0);
        this.nbA.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dLB() {
        this.nbt.reset();
        if (this.mZG.getStatus() == 1) {
            dCP();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dLC() {
        if (this.bnC.getVisibility() != 0) {
            this.nbm.dLJ();
            this.mZG.setStatus(8);
            dLm();
            if (this.mZO.nau != null && this.mZO.nau.size() > 0) {
                this.bnC.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        int mProgress;
        final int nbO = 50;
        final int nbP = 1;
        Handler nbQ = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.nbv.M(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.dLG();
                }
            }
        };

        AnonymousClass3() {
        }

        public void dLG() {
            this.nbQ.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            dLG();
            boolean z = RecordVideoActivity.this.nbI == null || TextUtils.isEmpty(RecordVideoActivity.this.nbI.dLl()) || !new File(RecordVideoActivity.this.nbI.dLl()).exists();
            if (RecordVideoActivity.this.mZO.nau.size() > 1) {
                return com.baidu.tieba.video.meida.h.dKy().a(RecordVideoActivity.this.mZO.nau, RecordVideoActivity.this.mZO.dKP(), z);
            }
            File file = new File(RecordVideoActivity.this.mZO.nau.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    n.copyFile(file.getPath(), RecordVideoActivity.this.mZO.dKP());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.dKy().a(RecordVideoActivity.this.mZO.nau, RecordVideoActivity.this.mZO.dKP(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.nbm.dLP();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.dLn();
                    RecordVideoActivity.this.Kp(102);
                    RecordVideoActivity.this.bnC.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.dLn();
                RecordVideoActivity.this.Kp(102);
                RecordVideoActivity.this.bnC.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.bnC.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.bA(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.nbv.M(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.nbm == null || y.isEmpty(this.nbm.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.nbm.getChoosedBeautyList()) {
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
        if (this.nbm == null || y.isEmpty(this.nbm.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.nbm.getChoosedFilterList()) {
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
        if (this.nbm == null || y.isEmpty(this.nbm.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.nbm.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dLD() {
        this.nbw.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dLE() {
        this.nbw.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dLF() {
        if (this.mZG.getStatus() == 1) {
            this.nbJ.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.mZO != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.mZO.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new aq("c12421").aj("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.nbt.setViewChoosed(2, false);
                            return;
                        } else {
                            this.nbt.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.mZO.setFilter((String) eVar.getValue());
                        aq aqVar = new aq("c12496");
                        aqVar.dK("obj_id", (String) eVar.getValue());
                        if (this.mZG.getStatus() == 1) {
                            aqVar.aj("obj_type", 1);
                        } else {
                            aqVar.aj("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.nbt.setViewChoosed(3, false);
                            return;
                        } else {
                            this.nbt.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.nbI.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.nbt.setViewChoosed(0, false);
                            return;
                        } else {
                            this.nbt.setViewChoosed(0, true);
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
            this.nbH = stickerItem;
            this.nbG.Tr(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.mZO != null) {
                    this.mZO.setSticker(null);
                    this.nbM = false;
                }
                if (this.nbm != null) {
                    this.nbm.setDownLoadSticker(null);
                }
                this.nbu.setVisibility(8);
                this.nbt.setViewChoosed(1, false);
                return;
            }
            String To = this.nbG.To(stickerItem.resource);
            if (!StringUtils.isNull(To)) {
                a(stickerItem, To);
                if (this.nbm != null) {
                    this.nbm.setDownLoadSticker(null);
                }
            } else {
                if (this.nbm != null) {
                    this.nbm.setDownLoadSticker(stickerItem);
                }
                this.nbG.Tp(stickerItem.resource);
            }
            this.nbt.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.mZO != null) {
                this.mZO.setSticker(stickerItem);
                this.nbM = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.nbu.setText(stickerItem.desc);
                this.nbu.setVisibility(0);
                this.nbu.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.nbu.setVisibility(8);
                    }
                }, IMConnection.RETRY_DELAY_TIMES);
                return;
            }
            this.nbu.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void dx(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.nbm.getLayoutParams();
            layoutParams.height = i4;
            this.nbm.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String SW = com.baidu.tieba.video.editvideo.model.a.dJz().SW(stringExtra);
                if (this.nbI != null && !TextUtils.isEmpty(SW)) {
                    this.nbI.gu(SW, stringExtra2);
                    this.nbm.dKD();
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
        if (this.mZG.getStatus() == 8) {
            this.nbm.dLI();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void xD(boolean z) {
        if (this.mZG != null && (this.mZG.getStatus() == 1 || this.mZG.getStatus() == 3 || this.mZG.getStatus() == 4)) {
            if (!z && this.nbM) {
                this.nbr.dLc();
                return;
            } else {
                this.nbr.dLd();
                return;
            }
        }
        this.nbr.dLd();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void ak(int i, boolean z) {
        int i2 = 1;
        if (this.iJv != i) {
            switch (i) {
                case 1:
                    if (this.nbI != null) {
                        this.nbI.bal();
                    }
                    this.mZO.setFilter("origin");
                    this.nbt.setViewChoosed(0, false);
                    this.nbt.setViewChoosed(3, false);
                    this.nbm.Kr(1);
                    this.nbt.setViewVisibility(0, 8);
                    this.nbt.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.nbt.setViewVisibility(0, 0);
                    this.nbt.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.iJv = i;
            this.nbm.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new aq().aj("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dLk() {
        if (this.mZG.getStatus() == 1 && !this.nbm.dLN()) {
            ak(1, true);
            this.nbJ.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dLj() {
        if (this.mZG.getStatus() == 1 && !this.nbm.dLN()) {
            ak(2, true);
            this.nbJ.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kp(int i) {
        if (this.mFB != null) {
            this.mFB.bB(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(int i, String str) {
        if (this.mFB != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.mFB.bA(i, str);
        }
    }
}
