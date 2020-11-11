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
    private View bqI;
    private TextView bvz;
    private final CustomMessageListener fPC;
    private com.baidu.tbadk.core.dialog.a iLf;
    private ForumWriteData iUj;
    private ImageView jGL;
    private int jbO;
    private final CustomMessageListener jdC;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;
    private com.baidu.tieba.k.h mYk;
    private String nnp;
    private SelectMusicModel nnt;
    private b.a nqK;
    private b nsT;
    private i nsd;
    protected h nsl;
    private RecordLayout ntI;
    private VideoControllerLayout ntJ;
    private RelativeLayout ntK;
    private ImageView ntL;
    private ImageView ntM;
    private ImageView ntN;
    private PreviewViewContainer ntO;
    private VideoEffectButtonLayout ntP;
    private TextView ntQ;
    private RoundProgressBar ntR;
    private TextView ntS;
    private AnimatorSet ntT;
    private AnimatorSet ntU;
    private ScaleAnimation ntV;
    private ObjectAnimator ntW;
    private ObjectAnimator ntX;
    private int ntY;
    private int ntZ;
    private boolean nua;
    private boolean nub = true;
    private l nuc;
    private StickerItem nud;
    protected j nue;
    private RecordTabLayout nuf;
    private ImageFileInfo nug;
    private HttpMessageListener nuh;
    private boolean nui;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.mYk = lVar.det();
        }
        if (this.mYk != null) {
            this.mYk.dec();
        }
        this.nqK = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void fS(List<com.baidu.tieba.video.localvideo.d> list) {
                if (y.isEmpty(list)) {
                    if (RecordVideoActivity.this.ntJ != null) {
                        RecordVideoActivity.this.ntJ.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.ntJ != null) {
                    RecordVideoActivity.this.ntJ.setHasLocalVideo(true);
                    RecordVideoActivity.this.nub = false;
                }
            }
        };
        this.nuh = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
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
                    if (RecordVideoActivity.this.ntJ != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.ntJ.setStickerItems(list);
                    }
                }
            }
        };
        this.jdC = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    RecordVideoActivity.this.finish();
                }
            }
        };
        this.fPC = new CustomMessageListener(2001373) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
    public void dQX() {
        PostPrefixData postPrefixData;
        AntiData antiData = null;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.nsl.npZ);
        videoInfo.setVideoDuration(this.nsd.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.nsl.npZ).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.iUj == null ? "" : this.iUj.forumName;
        String str2 = this.iUj == null ? "" : this.iUj.forumId;
        int i = this.iUj == null ? -1 : this.iUj.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.iUj.writeCallFrom, str, str2, this.nnp, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        editVideoActivityConfig.setFrsTabInfo(this.iUj != null ? this.iUj.frsTabInfo : null);
        editVideoActivityConfig.setForumLevel(this.iUj != null ? this.iUj.forumLevel : -1);
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
        editVideoActivityConfig.setFrom(this.iUj.mFrom);
        if (this.nue != null) {
            this.nue.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.mYk != null) {
            this.mYk.def();
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
        if (this.nsd != null && this.nsd.btZ()) {
            this.nsd.stopRecord();
        }
        if (this.nnt != null) {
            this.nnt.cancelLoadData();
        }
        if (this.mYk != null) {
            this.mYk.OM("record");
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
        this.ntY = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        this.ntZ = getIntent().getIntExtra(RecordVideoActivityConfig.SHOW_TYPE, 0);
        if (getIntent().getSerializableExtra("forum_write_data") instanceof ForumWriteData) {
            this.iUj = (ForumWriteData) getIntent().getSerializableExtra("forum_write_data");
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.nnp = getIntent().getStringExtra("video_title");
        initUI();
        this.nnt = new SelectMusicModel(getPageContext(), this.ntJ);
        this.nnt.dPp();
        this.nue = new j(this);
        this.nue.b(this.nnt);
        this.nsd.a(this.nue);
        registerListener(this.nuh);
        registerListener(this.jdC);
        registerListener(this.fPC);
        dQY();
        if (Build.VERSION.SDK_INT >= 28 && an.brg() && TbSingleton.getInstance().isCutoutScreen(this)) {
            com.baidu.tieba.v.c.a(1, getWindow().getAttributes(), getWindow());
        }
    }

    private void dQY() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void dPR() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.nqK);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.ntI = (RecordLayout) findViewById(R.id.root_layout);
        this.ntI.setListener(this);
        this.nsd = new i(this);
        this.ntJ = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.ntJ.setRecordController(this.nsd);
        this.ntJ.setRecordControlListener(this);
        this.ntJ.setEffectChoosedListener(this);
        this.ntK = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.jGL = (ImageView) findViewById(R.id.close_page);
        this.jGL.setOnClickListener(this);
        this.ntL = (ImageView) findViewById(R.id.flash_switch);
        this.ntL.setOnClickListener(this);
        this.ntM = (ImageView) findViewById(R.id.camera_switch);
        this.ntM.setOnClickListener(this);
        this.ntN = (ImageView) findViewById(R.id.count_down);
        this.ntN.setOnClickListener(this);
        this.ntO = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.nsl = new h(this);
        this.nsl.a(this);
        this.nsl.setFaceIdentifyStateListener(this);
        this.nsl.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
            @Override // com.baidu.tieba.video.record.h.b
            public void dQL() {
                if (RecordVideoActivity.this.ntJ.dRx()) {
                    RecordVideoActivity.this.ntJ.a((m) null);
                }
            }
        });
        this.ntP = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.ntP.setListener(this);
        this.nsd.a(this.ntP);
        this.ntP.setViewChoosed(2, true);
        this.bvz = (TextView) findViewById(R.id.tv_count_down);
        this.ntQ = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.bvz.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.bvz.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.ntP.setVisibility(8);
        }
        this.bqI = findViewById(R.id.progress_layout);
        this.ntR = (RoundProgressBar) this.bqI.findViewById(R.id.video_progress);
        this.ntS = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ntS.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.ntS.setLayoutParams(layoutParams);
        this.nuf = (RecordTabLayout) findViewById(R.id.tab_layout);
        if (this.mWriteImagesInfo == null || y.isEmpty(this.mWriteImagesInfo.getChosedFiles())) {
            KT(this.ntZ);
        } else {
            KT(1);
        }
        dQZ();
    }

    private void KT(int i) {
        if (this.nuf != null) {
            if (i == 0) {
                this.nuf.bZ(1, getString(R.string.tab_photo));
                this.nuf.bZ(2, getString(R.string.tab_record));
                this.nuf.setListener(this);
                this.nuf.setCurrentTab(2, false);
                ak(2, false);
            } else if (i == 1) {
                this.nuf.bZ(1, getString(R.string.tab_photo));
                this.nuf.setShowIndicator(false);
                this.nuf.setCurrentTab(1, false);
                ak(1, false);
            } else {
                this.nuf.bZ(2, getString(R.string.tab_record));
                this.nuf.setShowIndicator(false);
                this.nuf.setCurrentTab(2, false);
                ak(2, false);
            }
        }
    }

    private void dQZ() {
        if (com.baidu.tbadk.core.util.g.bqq()) {
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
        this.nsl.onResume();
        this.nsT = this.nsl.dQC();
        if (this.nsT != null) {
            this.nsT.setRecordController(this.nsd);
            this.ntO.setZoomHelper(this.nsT);
        }
        dRa();
        if (this.nuc == null) {
            this.nuc = new l();
            this.nuc.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                @Override // com.baidu.tieba.video.record.l.a
                public void gw(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.nud, str2);
                    if (RecordVideoActivity.this.ntJ != null) {
                        RecordVideoActivity.this.ntJ.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void TG(String str) {
                    if (RecordVideoActivity.this.ntJ != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.ntJ.b(stickerItem);
                        if (RecordVideoActivity.this.nsl != null) {
                            RecordVideoActivity.this.nsl.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.ntJ != null) {
                        RecordVideoActivity.this.ntJ.setDownLoadSticker(null);
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
                    recordVideoActivity.bF(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void dOD() {
                    if (RecordVideoActivity.this.ntJ != null) {
                        RecordVideoActivity.this.ntJ.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.nuc.dRr();
        if (this.ntJ != null && this.nub) {
            dPR();
        }
        if (this.mYk != null) {
            this.mYk.OL("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.nsl.onPause();
        if (this.ntJ != null) {
            if (this.nsd != null && this.nsd.getStatus() == 6) {
                this.ntJ.stopRecord();
                dRj();
            }
            if (this.nsd != null && this.nsd.btZ()) {
                this.ntJ.stopRecord();
            }
        }
        if (this.nue != null) {
            this.nue.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.nsd == null || this.nsd.getStatus() != 7) {
            if (this.nsd != null && this.nsd.getStatus() == 6) {
                if (this.ntJ != null) {
                    this.ntJ.stopRecord();
                }
                dRj();
            } else if (this.nsd != null && this.nsd.onBackPressed()) {
                finish();
            } else {
                if (this.iLf == null) {
                    this.iLf = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.iLf.ow(R.string.video_quit_confirm);
                    this.iLf.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.iLf.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.iLf.iV(true);
                    this.iLf.b(getPageContext());
                }
                this.iLf.bpc();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.ntS.setVisibility(4);
        if (view == this.jGL) {
            onBackPressed();
        } else if (view == this.ntL) {
            if (this.nsd.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.nsl.dQF();
            dRa();
        } else if (view == this.ntM) {
            if (this.nsd.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.ntM.setOnClickListener(null);
            this.nsl.dQH();
            if (this.nsl.dQI() && this.nsl.dQG()) {
                this.nsl.dQF();
            }
            dRa();
            this.ntM.setOnClickListener(this);
        } else if (view == this.ntN) {
            dRc();
        }
    }

    private void dRa() {
        if (this.nsl.dQI()) {
            this.ntL.setVisibility(8);
        } else {
            this.ntL.setVisibility(0);
        }
        if (this.nsl.dQG()) {
            this.ntL.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.ntL.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout dRb() {
        return this.ntO;
    }

    public void dRc() {
        this.ntS.setVisibility(4);
        if (this.nsd.getStatus() != 6) {
            this.nsd.setStatus(6);
            dRh();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.ntV == null) {
                this.ntV = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.ntV.setDuration(500L);
                this.ntV.setRepeatCount(5);
                this.ntV.setRepeatMode(2);
                this.ntV.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.ntV.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.nsd.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.bvz.setVisibility(0);
                        RecordVideoActivity.this.bvz.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.bvz.setVisibility(8);
                    if (RecordVideoActivity.this.nsd.getStatus() == 6) {
                        RecordVideoActivity.this.ntJ.dRu();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.nsd.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.bvz.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.bvz.setText("");
                        }
                    }
                }
            });
            this.bvz.setAnimation(this.ntV);
            this.ntV.startNow();
            this.ntJ.dRc();
            if (this.nue != null) {
                this.nue.dQW();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dRd() {
        if (this.nsd.getStatus() == 1) {
            this.ntS.setVisibility(4);
            if (this.nsd.getStatus() != 6) {
                this.ntJ.dRd();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dRe() {
        this.ntS.setVisibility(4);
        if (this.nsd.getStatus() != 6) {
            this.ntJ.dRe();
            if (this.ntJ.dRy()) {
                dQY();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dRf() {
        this.ntS.setVisibility(4);
        if (this.nsd.getStatus() != 6) {
            this.ntJ.dRf();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dRg() {
        this.ntS.setVisibility(4);
        if (this.nsd.getStatus() != 6) {
            this.ntJ.dRg();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dRh() {
        this.nua = true;
        if (this.ntU != null && this.ntU.isRunning()) {
            this.ntU.cancel();
        }
        if (this.ntT == null) {
            this.ntT = new AnimatorSet();
            this.ntT.playTogether(ObjectAnimator.ofFloat(this.ntK, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.ntP, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nuf, "alpha", 1.0f, 0.0f));
            this.ntT.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nvG) {
                        RecordVideoActivity.this.ntK.setVisibility(8);
                        RecordVideoActivity.this.ntP.setVisibility(8);
                        RecordVideoActivity.this.nuf.setVisibility(8);
                    }
                }
            });
            this.ntT.setDuration(300L);
        }
        this.ntT.start();
        this.ntP.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dQW() {
        if (this.jbO == 2) {
            if (this.nua) {
                this.nua = false;
                if (this.nue != null) {
                    this.nue.dQW();
                }
            } else {
                return;
            }
        }
        if (this.ntT != null && this.ntT.isRunning()) {
            this.ntT.cancel();
        }
        if (this.ntU == null) {
            this.ntU = new AnimatorSet();
            this.ntU.playTogether(ObjectAnimator.ofFloat(this.ntK, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.ntP, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nuf, "alpha", 0.0f, 1.0f));
            this.ntU.setDuration(300L);
        }
        this.ntK.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.ntP.setVisibility(0);
        }
        if (this.nsd.getStatus() == 1) {
            this.nuf.setVisibility(0);
        }
        this.ntU.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dRi() {
        if (this.nsl != null) {
            this.nsl.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.14
                @Override // com.baidu.tieba.video.record.g.a
                public void F(boolean z, String str) {
                    RecordVideoActivity.this.nsd.setStatus(1);
                    RecordVideoActivity.this.dQW();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.nug != null && !y.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.nug)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.nug);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.nug = new ImageFileInfo();
                        RecordVideoActivity.this.nug.setFilePath(str);
                        RecordVideoActivity.this.nug.setContentUriStr(null);
                        RecordVideoActivity.this.nug.setTempFile(true);
                        RecordVideoActivity.this.nug.setAlbumnId(null);
                        RecordVideoActivity.this.nug.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.nug);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.iUj, RecordVideoActivity.this.ntY)));
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
    public void dRj() {
        this.ntV.cancel();
        this.ntV.setAnimationListener(null);
        this.bvz.clearAnimation();
        this.bvz.setVisibility(8);
        if (this.nue != null) {
            this.nue.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dRk() {
        dIA();
    }

    private void dIA() {
        if (this.ntW != null) {
            this.ntW.cancel();
        }
        if (this.ntX == null) {
            this.ntX = ObjectAnimator.ofFloat(this.nuf, "alpha", 1.0f, 0.0f);
            this.ntX.setDuration(500L);
            this.ntX.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nvG) {
                        RecordVideoActivity.this.nuf.setVisibility(8);
                    }
                }
            });
        }
        this.ntX.start();
    }

    private void dIz() {
        if (this.ntX != null) {
            this.ntX.cancel();
        }
        if (this.ntW == null) {
            this.ntW = ObjectAnimator.ofFloat(this.nuf, "alpha", 0.0f, 1.0f);
            this.ntW.setDuration(500L);
        }
        this.nuf.setVisibility(0);
        this.ntW.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dRl() {
        this.ntP.reset();
        if (this.nsd.getStatus() == 1) {
            dIz();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dRm() {
        if (this.bqI.getVisibility() != 0) {
            this.ntJ.dRt();
            this.nsd.setStatus(8);
            dQW();
            if (this.nsl.nsR != null && this.nsl.nsR.size() > 0) {
                this.bqI.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        int mProgress;
        final int nuk = 50;
        final int nul = 1;
        Handler nun = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.ntR.Q(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.dRq();
                }
            }
        };

        AnonymousClass3() {
        }

        public void dRq() {
            this.nun.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            dRq();
            boolean z = RecordVideoActivity.this.nue == null || TextUtils.isEmpty(RecordVideoActivity.this.nue.dQV()) || !new File(RecordVideoActivity.this.nue.dQV()).exists();
            if (RecordVideoActivity.this.nsl.nsR.size() > 1) {
                return com.baidu.tieba.video.meida.h.dQi().a(RecordVideoActivity.this.nsl.nsR, RecordVideoActivity.this.nsl.dQz(), z);
            }
            File file = new File(RecordVideoActivity.this.nsl.nsR.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    n.copyFile(file.getPath(), RecordVideoActivity.this.nsl.dQz());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.dQi().a(RecordVideoActivity.this.nsl.nsR, RecordVideoActivity.this.nsl.dQz(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.ntJ.dRz();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.dQX();
                    RecordVideoActivity.this.KU(102);
                    RecordVideoActivity.this.bqI.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.dQX();
                RecordVideoActivity.this.KU(102);
                RecordVideoActivity.this.bqI.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.bqI.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.bF(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.ntR.Q(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.ntJ == null || y.isEmpty(this.ntJ.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.ntJ.getChoosedBeautyList()) {
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
        if (this.ntJ == null || y.isEmpty(this.ntJ.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.ntJ.getChoosedFilterList()) {
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
        if (this.ntJ == null || y.isEmpty(this.ntJ.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.ntJ.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dRn() {
        this.ntS.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dRo() {
        this.ntS.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dRp() {
        if (this.nsd.getStatus() == 1) {
            this.nuf.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.nsl != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.nsl.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new aq("c12421").al("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.ntP.setViewChoosed(2, false);
                            return;
                        } else {
                            this.ntP.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.nsl.setFilter((String) eVar.getValue());
                        aq aqVar = new aq("c12496");
                        aqVar.dR("obj_id", (String) eVar.getValue());
                        if (this.nsd.getStatus() == 1) {
                            aqVar.al("obj_type", 1);
                        } else {
                            aqVar.al("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.ntP.setViewChoosed(3, false);
                            return;
                        } else {
                            this.ntP.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.nue.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.ntP.setViewChoosed(0, false);
                            return;
                        } else {
                            this.ntP.setViewChoosed(0, true);
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
            this.nud = stickerItem;
            this.nuc.Uh(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.nsl != null) {
                    this.nsl.setSticker(null);
                    this.nui = false;
                }
                if (this.ntJ != null) {
                    this.ntJ.setDownLoadSticker(null);
                }
                this.ntQ.setVisibility(8);
                this.ntP.setViewChoosed(1, false);
                return;
            }
            String Ue = this.nuc.Ue(stickerItem.resource);
            if (!StringUtils.isNull(Ue)) {
                a(stickerItem, Ue);
                if (this.ntJ != null) {
                    this.ntJ.setDownLoadSticker(null);
                }
            } else {
                if (this.ntJ != null) {
                    this.ntJ.setDownLoadSticker(stickerItem);
                }
                this.nuc.Uf(stickerItem.resource);
            }
            this.ntP.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.nsl != null) {
                this.nsl.setSticker(stickerItem);
                this.nui = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.ntQ.setText(stickerItem.desc);
                this.ntQ.setVisibility(0);
                this.ntQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.ntQ.setVisibility(8);
                    }
                }, IMConnection.RETRY_DELAY_TIMES);
                return;
            }
            this.ntQ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void dB(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.ntJ.getLayoutParams();
            layoutParams.height = i4;
            this.ntJ.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String TM = com.baidu.tieba.video.editvideo.model.a.dPj().TM(stringExtra);
                if (this.nue != null && !TextUtils.isEmpty(TM)) {
                    this.nue.gz(TM, stringExtra2);
                    this.ntJ.dQn();
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
        if (this.nsd.getStatus() == 8) {
            this.ntJ.dRs();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void yd(boolean z) {
        if (this.nsd != null && (this.nsd.getStatus() == 1 || this.nsd.getStatus() == 3 || this.nsd.getStatus() == 4)) {
            if (!z && this.nui) {
                this.ntO.dQM();
                return;
            } else {
                this.ntO.dQN();
                return;
            }
        }
        this.ntO.dQN();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void ak(int i, boolean z) {
        int i2 = 1;
        if (this.jbO != i) {
            switch (i) {
                case 1:
                    if (this.nue != null) {
                        this.nue.beE();
                    }
                    this.nsl.setFilter("origin");
                    this.ntP.setViewChoosed(0, false);
                    this.ntP.setViewChoosed(3, false);
                    this.ntJ.KW(1);
                    this.ntP.setViewVisibility(0, 8);
                    this.ntP.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.ntP.setViewVisibility(0, 0);
                    this.ntP.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.jbO = i;
            this.ntJ.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new aq().al("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dQU() {
        if (this.nsd.getStatus() == 1 && !this.ntJ.dRx()) {
            ak(1, true);
            this.nuf.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dQT() {
        if (this.nsd.getStatus() == 1 && !this.ntJ.dRx()) {
            ak(2, true);
            this.nuf.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KU(int i) {
        if (this.mYk != null) {
            this.mYk.bG(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(int i, String str) {
        if (this.mYk != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.mYk.bF(i, str);
        }
    }
}
