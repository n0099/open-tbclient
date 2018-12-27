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
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.searchbox.ng.ai.apps.media.chooser.action.ChooseVideoAction;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.e;
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
    private ImageView eAf;
    private int ebC;
    private final CustomMessageListener edl;
    private SelectMusicModel hEC;
    private String hEy;
    private b.a hHT;
    private i hJn;
    protected h hJv;
    private RecordLayout hKZ;
    private b hKh;
    private ImageFileInfo hLA;
    private HttpMessageListener hLB;
    private boolean hLC;
    private VideoControllerLayout hLa;
    private RelativeLayout hLb;
    private ImageView hLc;
    private ImageView hLd;
    private ImageView hLe;
    private com.baidu.tbadk.core.dialog.a hLf;
    private PreviewViewContainer hLg;
    private TextView hLh;
    private VideoEffectButtonLayout hLi;
    private TextView hLj;
    private View hLk;
    private RoundProgressBar hLl;
    private TextView hLm;
    private AnimatorSet hLn;
    private AnimatorSet hLo;
    private ScaleAnimation hLp;
    private ObjectAnimator hLq;
    private ObjectAnimator hLr;
    private int hLs;
    private ForumWriteData hLt;
    private boolean hLu;
    private boolean hLv = true;
    private l hLw;
    private StickerItem hLx;
    protected j hLy;
    private RecordTabLayout hLz;
    private com.baidu.tieba.j.h hpD;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.hpD = lVar.bdz();
        }
        if (this.hpD != null) {
            this.hpD.bdd();
        }
        this.hHT = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void ea(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.I(list)) {
                    if (RecordVideoActivity.this.hLa != null) {
                        RecordVideoActivity.this.hLa.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.hLa != null) {
                    RecordVideoActivity.this.hLa.setHasLocalVideo(true);
                    RecordVideoActivity.this.hLv = false;
                }
            }
        };
        this.hLB = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.hLa != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.hLa.setStickerItems(list);
                    }
                }
            }
        };
        this.edl = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void bLq() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hJv.hEE);
        videoInfo.setVideoDuration(this.hJn.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.hJv.hEE).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.hLt.writeCallFrom, this.hLt == null ? "" : this.hLt.forumName, this.hLt == null ? "" : this.hLt.forumId, this.hEy, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        if (this.hLy != null) {
            this.hLy.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        if (this.hpD != null) {
            this.hpD.bdg();
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
        if (this.hJn != null && this.hJn.FS()) {
            this.hJn.stopRecord();
        }
        if (this.hEC != null) {
            this.hEC.cancelLoadData();
        }
        if (this.hpD != null) {
            this.hpD.se("record");
        }
        com.baidu.tbadk.core.util.l.y(new File(com.baidu.tieba.video.c.hCT));
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
        setContentView(e.h.record_activity);
        this.hLs = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.hLt = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.hEy = getIntent().getStringExtra("video_title");
        initUI();
        this.hEC = new SelectMusicModel(getPageContext(), this.hLa);
        this.hEC.bJH();
        this.hLy = new j(this);
        this.hLy.b(this.hEC);
        this.hJn.a(this.hLy);
        registerListener(this.hLB);
        registerListener(this.edl);
        bLr();
    }

    private void bLr() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", ErrDef.Feature.OVERFLOW);
        sendMessage(httpMessage);
    }

    private void bKj() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.hHT);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.hKZ = (RecordLayout) findViewById(e.g.root_layout);
        this.hKZ.setListener(this);
        this.hJn = new i(this);
        this.hLa = (VideoControllerLayout) findViewById(e.g.record_controller_layout);
        this.hLa.setRecordController(this.hJn);
        this.hLa.setRecordControlListener(this);
        this.hLa.setEffectChoosedListener(this);
        this.hLb = (RelativeLayout) findViewById(e.g.top_control_layout);
        this.eAf = (ImageView) findViewById(e.g.close_page);
        this.eAf.setOnClickListener(this);
        this.hLc = (ImageView) findViewById(e.g.flash_switch);
        this.hLc.setOnClickListener(this);
        this.hLd = (ImageView) findViewById(e.g.camera_switch);
        this.hLd.setOnClickListener(this);
        this.hLe = (ImageView) findViewById(e.g.count_down);
        this.hLe.setOnClickListener(this);
        this.hLg = (PreviewViewContainer) findViewById(e.g.video_surface_container);
        this.hJv = new h(this);
        this.hJv.a(this);
        this.hJv.setFaceIdentifyStateListener(this);
        this.hJv.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void bLe() {
                if (RecordVideoActivity.this.hLa.bLQ()) {
                    RecordVideoActivity.this.hLa.a((m) null);
                }
            }
        });
        this.hLi = (VideoEffectButtonLayout) findViewById(e.g.layout_effect_button);
        this.hLi.setListener(this);
        this.hJn.a(this.hLi);
        this.hLi.setViewChoosed(2, true);
        this.hLh = (TextView) findViewById(e.g.tv_count_down);
        this.hLj = (TextView) findViewById(e.g.gesture_guide_tv);
        int aQ = ((com.baidu.adp.lib.util.l.aQ(this.mContext) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds336)) / 2) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds150);
        if (this.hLh.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.hLh.getLayoutParams()).topMargin = aQ;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.hLi.setVisibility(8);
        }
        this.hLk = findViewById(e.g.progress_layout);
        this.hLl = (RoundProgressBar) this.hLk.findViewById(e.g.video_progress);
        this.hLm = (TextView) findViewById(e.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hLm.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.aO(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds38);
        this.hLm.setLayoutParams(layoutParams);
        this.hLz = (RecordTabLayout) findViewById(e.g.tab_layout);
        this.hLz.ap(1, getString(e.j.tab_photo));
        if (this.hLs != 2 && this.hLs != 3) {
            this.hLz.ap(2, getString(e.j.tab_record));
            this.hLz.setListener(this);
            this.hLz.setCurrentTab(2, false);
            G(2, false);
        } else {
            this.hLz.setShowIndicator(false);
            this.hLz.setCurrentTab(1, false);
            G(1, false);
        }
        bLs();
    }

    private void bLs() {
        if (com.baidu.tbadk.core.util.g.CE()) {
            this.mStatusBarView = findViewById(e.g.statusbar_view);
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
        this.hJv.onResume();
        this.hKh = this.hJv.bKV();
        if (this.hKh != null) {
            this.hKh.setRecordController(this.hJn);
            this.hLg.setZoomHelper(this.hKh);
        }
        bLt();
        if (this.hLw == null) {
            this.hLw = new l();
            this.hLw.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void cR(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.hLx, str2);
                    if (RecordVideoActivity.this.hLa != null) {
                        RecordVideoActivity.this.hLa.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void wC(String str) {
                    if (RecordVideoActivity.this.hLa != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.hLa.b(stickerItem);
                        if (RecordVideoActivity.this.hJv != null) {
                            RecordVideoActivity.this.hJv.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.hLa != null) {
                        RecordVideoActivity.this.hLa.setDownLoadSticker(null);
                    }
                    if (StringUtils.isNull(str)) {
                        RecordVideoActivity.this.showToast(e.j.sticker_download_error);
                    } else {
                        RecordVideoActivity.this.showToast(str);
                    }
                    RecordVideoActivity recordVideoActivity = RecordVideoActivity.this;
                    if (StringUtils.isNull(str)) {
                        str = RecordVideoActivity.this.getResources().getString(e.j.sticker_download_error);
                    }
                    recordVideoActivity.Y(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void bIP() {
                    if (RecordVideoActivity.this.hLa != null) {
                        RecordVideoActivity.this.hLa.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.hLw.bLK();
        if (this.hLa != null && this.hLv) {
            bKj();
        }
        if (this.hpD != null) {
            this.hpD.sd(ChooseVideoAction.KEY_SOURCE_ALBUM);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hJv.onPause();
        if (this.hLa != null) {
            if (this.hJn != null && this.hJn.getStatus() == 6) {
                this.hLa.stopRecord();
                bLC();
            }
            if (this.hJn != null && this.hJn.FS()) {
                this.hLa.stopRecord();
            }
        }
        if (this.hLy != null) {
            this.hLy.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hJn == null || this.hJn.getStatus() != 7) {
            if (this.hJn != null && this.hJn.getStatus() == 6) {
                if (this.hLa != null) {
                    this.hLa.stopRecord();
                }
                bLC();
            } else if (this.hJn.onBackPressed()) {
                finish();
            } else {
                if (this.hLf == null) {
                    this.hLf = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.hLf.db(e.j.video_quit_confirm);
                    this.hLf.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.hLf.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.hLf.bf(true);
                    this.hLf.b(getPageContext());
                }
                this.hLf.BF();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.hLm.setVisibility(4);
        if (view == this.eAf) {
            onBackPressed();
        } else if (view == this.hLc) {
            if (this.hJn.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.hJv.bKY();
            bLt();
        } else if (view == this.hLd) {
            if (this.hJn.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.hLd.setOnClickListener(null);
            this.hJv.bLa();
            if (this.hJv.bLb() && this.hJv.bKZ()) {
                this.hJv.bKY();
            }
            bLt();
            this.hLd.setOnClickListener(this);
        } else if (view == this.hLe) {
            bLv();
        }
    }

    private void bLt() {
        if (this.hJv.bLb()) {
            this.hLc.setVisibility(8);
        } else {
            this.hLc.setVisibility(0);
        }
        if (this.hJv.bKZ()) {
            this.hLc.setImageResource(e.f.icon_video_flashon_n);
        } else {
            this.hLc.setImageResource(e.f.icon_video_flashoff_n);
        }
    }

    public FrameLayout bLu() {
        return this.hLg;
    }

    public void bLv() {
        this.hLm.setVisibility(4);
        if (this.hJn.getStatus() != 6) {
            this.hJn.setStatus(6);
            bLA();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.hLp == null) {
                this.hLp = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.hLp.setDuration(500L);
                this.hLp.setRepeatCount(5);
                this.hLp.setRepeatMode(2);
                this.hLp.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.hLp.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.hJn.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.hLh.setVisibility(0);
                        RecordVideoActivity.this.hLh.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.hLh.setVisibility(8);
                    if (RecordVideoActivity.this.hJn.getStatus() == 6) {
                        RecordVideoActivity.this.hLa.bLN();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.hJn.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.hLh.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.hLh.setText("");
                        }
                    }
                }
            });
            this.hLh.setAnimation(this.hLp);
            this.hLp.startNow();
            this.hLa.bLv();
            if (this.hLy != null) {
                this.hLy.bLp();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bLw() {
        if (this.hJn.getStatus() == 1) {
            this.hLm.setVisibility(4);
            if (this.hJn.getStatus() != 6) {
                this.hLa.bLw();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bLx() {
        this.hLm.setVisibility(4);
        if (this.hJn.getStatus() != 6) {
            this.hLa.bLx();
            if (this.hLa.bLR()) {
                bLr();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bLy() {
        this.hLm.setVisibility(4);
        if (this.hJn.getStatus() != 6) {
            this.hLa.bLy();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bLz() {
        this.hLm.setVisibility(4);
        if (this.hJn.getStatus() != 6) {
            this.hLa.bLz();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bLA() {
        this.hLu = true;
        if (this.hLo != null && this.hLo.isRunning()) {
            this.hLo.cancel();
        }
        if (this.hLn == null) {
            this.hLn = new AnimatorSet();
            this.hLn.playTogether(ObjectAnimator.ofFloat(this.hLb, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hLi, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hLz, "alpha", 1.0f, 0.0f));
            this.hLn.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hNb) {
                        RecordVideoActivity.this.hLb.setVisibility(8);
                        RecordVideoActivity.this.hLi.setVisibility(8);
                        RecordVideoActivity.this.hLz.setVisibility(8);
                    }
                }
            });
            this.hLn.setDuration(300L);
        }
        this.hLn.start();
        this.hLi.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bLp() {
        if (this.ebC == 2) {
            if (this.hLu) {
                this.hLu = false;
                if (this.hLy != null) {
                    this.hLy.bLp();
                }
            } else {
                return;
            }
        }
        if (this.hLn != null && this.hLn.isRunning()) {
            this.hLn.cancel();
        }
        if (this.hLo == null) {
            this.hLo = new AnimatorSet();
            this.hLo.playTogether(ObjectAnimator.ofFloat(this.hLb, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hLi, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hLz, "alpha", 0.0f, 1.0f));
            this.hLo.setDuration(300L);
        }
        this.hLb.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.hLi.setVisibility(0);
        }
        if (this.hJn.getStatus() == 1) {
            this.hLz.setVisibility(0);
        }
        this.hLo.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bLB() {
        if (this.hJv != null) {
            this.hJv.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void u(boolean z, String str) {
                    RecordVideoActivity.this.hJn.setStatus(1);
                    RecordVideoActivity.this.bLp();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.hLA != null && !v.I(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.hLA)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.hLA);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.hLA = new ImageFileInfo();
                        RecordVideoActivity.this.hLA.setFilePath(str);
                        RecordVideoActivity.this.hLA.setTempFile(true);
                        RecordVideoActivity.this.hLA.setAlbumnId(null);
                        RecordVideoActivity.this.hLA.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.hLA);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.hLt, RecordVideoActivity.this.hLs)));
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
    public void bLC() {
        this.hLp.cancel();
        this.hLp.setAnimationListener(null);
        this.hLh.clearAnimation();
        this.hLh.setVisibility(8);
        if (this.hLy != null) {
            this.hLy.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bLD() {
        bBv();
    }

    private void bBv() {
        if (this.hLq != null) {
            this.hLq.cancel();
        }
        if (this.hLr == null) {
            this.hLr = ObjectAnimator.ofFloat(this.hLz, "alpha", 1.0f, 0.0f);
            this.hLr.setDuration(500L);
            this.hLr.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hNb) {
                        RecordVideoActivity.this.hLz.setVisibility(8);
                    }
                }
            });
        }
        this.hLr.start();
    }

    private void bBu() {
        if (this.hLr != null) {
            this.hLr.cancel();
        }
        if (this.hLq == null) {
            this.hLq = ObjectAnimator.ofFloat(this.hLz, "alpha", 0.0f, 1.0f);
            this.hLq.setDuration(500L);
        }
        this.hLz.setVisibility(0);
        this.hLq.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bLE() {
        this.hLi.reset();
        if (this.hJn.getStatus() == 1) {
            bBu();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bLF() {
        if (this.hLk.getVisibility() != 0) {
            this.hLa.bLM();
            this.hJn.setStatus(8);
            bLp();
            if (this.hJv.hKf != null && this.hJv.hKf.size() > 0) {
                this.hLk.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int hLE = 50;
        final int hLF = 1;
        Handler hLG = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.hLl.aC(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.bLJ();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void bLJ() {
            this.hLG.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            bLJ();
            boolean z = RecordVideoActivity.this.hLy == null || TextUtils.isEmpty(RecordVideoActivity.this.hLy.bLo()) || !new File(RecordVideoActivity.this.hLy.bLo()).exists();
            if (RecordVideoActivity.this.hJv.hKf.size() > 1) {
                return com.baidu.tieba.video.meida.h.bKB().c(RecordVideoActivity.this.hJv.hKf, RecordVideoActivity.this.hJv.bKS(), z);
            }
            File file = new File(RecordVideoActivity.this.hJv.hKf.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.adp.lib.util.f.b(file, new File(RecordVideoActivity.this.hJv.bKS()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.bKB().c(RecordVideoActivity.this.hJv.hKf, RecordVideoActivity.this.hJv.bKS(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.hLa.bLS();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.bLq();
                    RecordVideoActivity.this.wS(102);
                    RecordVideoActivity.this.hLk.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.bLq();
                RecordVideoActivity.this.wS(102);
                RecordVideoActivity.this.hLk.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(e.j.mix_fail));
                RecordVideoActivity.this.hLk.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.Y(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.hLl.aC(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.hLa == null || v.I(this.hLa.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.hLa.getChoosedBeautyList()) {
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
        if (this.hLa == null || v.I(this.hLa.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.hLa.getChoosedFilterList()) {
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
        if (this.hLa == null || v.I(this.hLa.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.hLa.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bLG() {
        this.hLm.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bLH() {
        this.hLm.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bLI() {
        if (this.hJn.getStatus() == 1) {
            this.hLz.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.hJv != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.hJv.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new am("c12421").x(VideoPlayActivityConfig.OBJ_ID, ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.hLi.setViewChoosed(2, false);
                            return;
                        } else {
                            this.hLi.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.hJv.setFilter((String) eVar.getValue());
                        am amVar = new am("c12496");
                        amVar.aA(VideoPlayActivityConfig.OBJ_ID, (String) eVar.getValue());
                        if (this.hJn.getStatus() == 1) {
                            amVar.x("obj_type", 1);
                        } else {
                            amVar.x("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.hLi.setViewChoosed(3, false);
                            return;
                        } else {
                            this.hLi.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.hLy.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.hLi.setViewChoosed(0, false);
                            return;
                        } else {
                            this.hLi.setViewChoosed(0, true);
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
            this.hLx = stickerItem;
            this.hLw.xc(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.hJv != null) {
                    this.hJv.setSticker(null);
                    this.hLC = false;
                }
                if (this.hLa != null) {
                    this.hLa.setDownLoadSticker(null);
                }
                this.hLj.setVisibility(8);
                this.hLi.setViewChoosed(1, false);
                return;
            }
            String wZ = this.hLw.wZ(stickerItem.resource);
            if (!StringUtils.isNull(wZ)) {
                a(stickerItem, wZ);
                if (this.hLa != null) {
                    this.hLa.setDownLoadSticker(null);
                }
            } else {
                if (this.hLa != null) {
                    this.hLa.setDownLoadSticker(stickerItem);
                }
                this.hLw.xa(stickerItem.resource);
            }
            this.hLi.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.hJv != null) {
                this.hJv.setSticker(stickerItem);
                this.hLC = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.hLj.setText(stickerItem.desc);
                this.hLj.setVisibility(0);
                this.hLj.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.hLj.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.hLj.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void bZ(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(e.C0210e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.s(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.hLa.getLayoutParams();
            layoutParams.height = i4;
            this.hLa.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String wK = com.baidu.tieba.video.editvideo.model.a.bJB().wK(stringExtra);
                if (this.hLy != null && !TextUtils.isEmpty(wK)) {
                    this.hLy.cS(wK, stringExtra2);
                    this.hLa.bKG();
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
        if (this.hJn.getStatus() == 8) {
            this.hLa.bLL();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void oh(boolean z) {
        if (this.hJn != null && (this.hJn.getStatus() == 1 || this.hJn.getStatus() == 3 || this.hJn.getStatus() == 4)) {
            if (!z && this.hLC) {
                this.hLg.alK();
                return;
            } else {
                this.hLg.alL();
                return;
            }
        }
        this.hLg.alL();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void G(int i, boolean z) {
        int i2 = 1;
        if (this.ebC != i) {
            switch (i) {
                case 1:
                    if (this.hLy != null) {
                        this.hLy.UL();
                    }
                    this.hJv.setFilter("origin");
                    this.hLi.setViewChoosed(0, false);
                    this.hLi.setViewChoosed(3, false);
                    this.hLa.wU(1);
                    this.hLi.setViewVisibility(0, 8);
                    this.hLi.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.hLi.setViewVisibility(0, 0);
                    this.hLi.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.ebC = i;
            this.hLa.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new am().x("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bLn() {
        if (this.hJn.getStatus() == 1 && !this.hLa.bLQ()) {
            G(1, true);
            this.hLz.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bLm() {
        if (this.hJn.getStatus() == 1 && !this.hLa.bLQ()) {
            G(2, true);
            this.hLz.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wS(int i) {
        if (this.hpD != null) {
            this.hpD.Z(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(int i, String str) {
        if (this.hpD != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.hpD.Y(i, str);
        }
    }
}
