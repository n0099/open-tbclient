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
import com.baidu.nps.pm.provider.BundleOpProvider;
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
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
import com.baidu.tieba.video.record.GLVideoPreviewView;
import com.baidu.tieba.video.record.RecordLayout;
import com.baidu.tieba.video.record.RecordTabLayout;
import com.baidu.tieba.video.record.VideoControllerLayout;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import d.a.i0.r.s.a;
import d.a.j0.q3.k.a;
import d.a.j0.q3.m.g;
import d.a.j0.q3.m.h;
import d.a.j0.q3.m.l;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class RecordVideoActivity extends BaseActivity implements VideoEffectButtonLayout.a, VideoControllerLayout.f, VideoEffectLayout.h, h.l, RecordTabLayout.c, RecordLayout.a, GLVideoPreviewView.b {
    public static final int TAB_PHOTO = 1;
    public static final int TAB_RECORD = 2;
    public int bottomTabShowType;
    public d.a.i0.r.s.a mAlertDialog;
    public ImageView mCameraSwitch;
    public ImageView mClose;
    public final CustomMessageListener mCloseListener;
    public Context mContext;
    public VideoControllerLayout mControllerLayout;
    public ImageView mCountDown;
    public ScaleAnimation mCountDowningAnimaton;
    public StickerItem mCurrentSticker;
    public int mCurrentTab;
    public VideoEffectButtonLayout mEffectButtonLayout;
    public int mEntranceFlag;
    public ImageView mFlashSwitch;
    public ForumWriteData mForumWriteData;
    public TextView mGestureGuideView;
    public HttpMessageListener mGetStickersListener;
    public final CustomMessageListener mGuideVideoWriteListener;
    public ObjectAnimator mHideTabAnimator;
    public boolean mIsNeedToLoadLocalVideo = true;
    public boolean mIsProcessFaceIdentifyFail;
    public boolean mIsRecordingState;
    public TextView mMinTimeTips;
    public d.a.j0.q3.m.j mMusicController;
    public SelectMusicModel mMusicModel;
    public a.InterfaceC1493a mOnLocalVideoLoadedListener;
    public d.a.j0.t1.g mPostMonitorManager;
    public d.a.j0.q3.m.h mPreviewController;
    public View mProgressView;
    public d.a.j0.q3.m.i mRecordController;
    public RecordLayout mRootLayout;
    public RoundProgressBar mRoundProgressBar;
    public ObjectAnimator mShowTabAnimator;
    public AnimatorSet mStartRecodingAnimatorSet;
    public View mStatusBarView;
    public d.a.j0.q3.m.l mStickerManager;
    public AnimatorSet mStopRecodingAnimatorSet;
    public PreviewViewContainer mSurfaceContainer;
    public RecordTabLayout mTabLayout;
    public ImageFileInfo mTakePhoto;
    public RelativeLayout mTopControllerLayout;
    public TextView mTvCountDown;
    public String mVideoTitle;
    public WriteImagesInfo mWriteImagesInfo;
    public d.a.j0.q3.m.b mZoomHelper;

    /* loaded from: classes5.dex */
    public class a extends d.a.j0.q3.m.m {
        public a() {
        }

        @Override // d.a.j0.q3.m.m, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f59435e) {
                return;
            }
            RecordVideoActivity.this.mTabLayout.setVisibility(8);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Void, Void, d.a.j0.q3.l.i> {

        /* renamed from: a  reason: collision with root package name */
        public int f22167a;

        /* renamed from: b  reason: collision with root package name */
        public Handler f22168b = new a(Looper.getMainLooper());

        /* loaded from: classes5.dex */
        public class a extends Handler {
            public a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                b bVar;
                int i2;
                if (message.what != 1 || (i2 = (bVar = b.this).f22167a) < 0) {
                    return;
                }
                bVar.f22167a = (i2 + 5) % 100;
                RecordVideoActivity.this.mRoundProgressBar.b(b.this.f22167a);
                b.this.d();
            }
        }

        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public d.a.j0.q3.l.i doInBackground(Void... voidArr) {
            d();
            d.a.j0.q3.m.j jVar = RecordVideoActivity.this.mMusicController;
            boolean z = jVar == null || TextUtils.isEmpty(jVar.h()) || !new File(RecordVideoActivity.this.mMusicController.h()).exists();
            if (RecordVideoActivity.this.mPreviewController.q.size() > 1) {
                d.a.j0.q3.l.h e2 = d.a.j0.q3.l.h.e();
                d.a.j0.q3.m.h hVar = RecordVideoActivity.this.mPreviewController;
                return e2.i(hVar.q, hVar.g(), z);
            }
            File file = new File(RecordVideoActivity.this.mPreviewController.q.get(0));
            if (file.exists()) {
                if (z) {
                    try {
                        FileHelper.copyFile(file.getPath(), RecordVideoActivity.this.mPreviewController.g());
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    return new d.a.j0.q3.l.i(0, "");
                }
                d.a.j0.q3.l.h e4 = d.a.j0.q3.l.h.e();
                d.a.j0.q3.m.h hVar2 = RecordVideoActivity.this.mPreviewController;
                return e4.i(hVar2.q, hVar2.g(), z);
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(d.a.j0.q3.l.i iVar) {
            this.f22167a = -1;
            RecordVideoActivity.this.mHandler.removeMessages(1);
            RecordVideoActivity.this.mControllerLayout.u();
            if (iVar != null && iVar.f59340a == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.goToEditVideo();
                    RecordVideoActivity.this.recordCompress(102);
                    RecordVideoActivity.this.mProgressView.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.goToEditVideo();
                RecordVideoActivity.this.recordCompress(102);
                RecordVideoActivity.this.mProgressView.setVisibility(8);
            } else {
                RecordVideoActivity recordVideoActivity = RecordVideoActivity.this;
                d.a.c.e.p.l.M(recordVideoActivity, recordVideoActivity.getString(R.string.mix_fail));
                RecordVideoActivity.this.mProgressView.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.recordVideoRecord(iVar.f59340a, iVar.f59341b);
                }
            }
            RecordVideoActivity.this.mRoundProgressBar.b(0.0f);
        }

        public void d() {
            if (this.f22167a >= 0) {
                this.f22168b.sendEmptyMessageDelayed(1, 50L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecordVideoActivity.this.mGestureGuideView.setVisibility(8);
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                RecordVideoActivity.this.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            RecordVideoActivity.this.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements a.InterfaceC1493a {
        public f() {
        }

        @Override // d.a.j0.q3.k.a.InterfaceC1493a
        public void a(List<d.a.j0.q3.k.b> list) {
            if (ListUtils.isEmpty(list)) {
                if (RecordVideoActivity.this.mControllerLayout != null) {
                    RecordVideoActivity.this.mControllerLayout.setHasLocalVideo(false);
                }
            } else if (RecordVideoActivity.this.mControllerLayout != null) {
                RecordVideoActivity.this.mControllerLayout.setHasLocalVideo(true);
                RecordVideoActivity.this.mIsNeedToLoadLocalVideo = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends HttpMessageListener {
        public g(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof ResponseGetStickersMessage) {
                List<StickerItem> stickerItems = httpResponsedMessage.getError() == 0 ? ((ResponseGetStickersMessage) httpResponsedMessage).getStickerItems() : null;
                if (RecordVideoActivity.this.mControllerLayout != null) {
                    StickerItem stickerItem = new StickerItem();
                    stickerItem.id = -1;
                    stickerItem.isSelect = true;
                    stickerItem.name = "nosticker";
                    if (stickerItems == null) {
                        stickerItems = new ArrayList<>();
                    }
                    stickerItems.add(0, stickerItem);
                    RecordVideoActivity.this.mControllerLayout.setStickerItems(stickerItems);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements h.k {
        public h() {
        }

        @Override // d.a.j0.q3.m.h.k
        public void a() {
            if (RecordVideoActivity.this.mControllerLayout.p()) {
                RecordVideoActivity.this.mControllerLayout.m(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements l.b {
        public i() {
        }

        @Override // d.a.j0.q3.m.l.b
        public void a(String str) {
            if (RecordVideoActivity.this.mControllerLayout != null) {
                StickerItem stickerItem = new StickerItem();
                stickerItem.id = -1;
                RecordVideoActivity.this.mControllerLayout.w(stickerItem);
                d.a.j0.q3.m.h hVar = RecordVideoActivity.this.mPreviewController;
                if (hVar != null) {
                    hVar.H(null);
                }
            }
            if (RecordVideoActivity.this.mControllerLayout != null) {
                RecordVideoActivity.this.mControllerLayout.setDownLoadSticker(null);
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
            recordVideoActivity.recordVideoRecord(5, str);
        }

        @Override // d.a.j0.q3.m.l.b
        public void b() {
            if (RecordVideoActivity.this.mControllerLayout != null) {
                RecordVideoActivity.this.mControllerLayout.setDownLoadSticker(null);
            }
        }

        @Override // d.a.j0.q3.m.l.b
        public void c(String str, String str2) {
            RecordVideoActivity recordVideoActivity = RecordVideoActivity.this;
            recordVideoActivity.setSticker(recordVideoActivity.mCurrentSticker, str2);
            if (RecordVideoActivity.this.mControllerLayout != null) {
                RecordVideoActivity.this.mControllerLayout.setDownLoadSticker(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements a.e {
        public j() {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            aVar.dismiss();
            RecordVideoActivity.this.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class k implements a.e {
        public k() {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f22180a;

        public l(AtomicInteger atomicInteger) {
            this.f22180a = atomicInteger;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            RecordVideoActivity.this.mTvCountDown.setVisibility(8);
            if (RecordVideoActivity.this.mRecordController.f() == 6) {
                RecordVideoActivity.this.mControllerLayout.s();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            if (RecordVideoActivity.this.mRecordController.f() != 6) {
                return;
            }
            if (this.f22180a.decrementAndGet() > 1) {
                RecordVideoActivity.this.mTvCountDown.setText(String.valueOf(this.f22180a.get() / 2));
            } else {
                RecordVideoActivity.this.mTvCountDown.setText("");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (RecordVideoActivity.this.mRecordController.f() != 6) {
                return;
            }
            this.f22180a.set(7);
            RecordVideoActivity.this.mTvCountDown.setVisibility(0);
            RecordVideoActivity.this.mTvCountDown.setText(String.valueOf(this.f22180a.get() / 2));
        }
    }

    /* loaded from: classes5.dex */
    public class m extends d.a.j0.q3.m.m {
        public m() {
        }

        @Override // d.a.j0.q3.m.m, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f59435e) {
                return;
            }
            RecordVideoActivity.this.mTopControllerLayout.setVisibility(8);
            RecordVideoActivity.this.mEffectButtonLayout.setVisibility(8);
            RecordVideoActivity.this.mTabLayout.setVisibility(8);
        }
    }

    /* loaded from: classes5.dex */
    public class n implements g.a {
        public n() {
        }

        @Override // d.a.j0.q3.m.g.a
        public void a(boolean z, String str) {
            RecordVideoActivity.this.mRecordController.m(1);
            RecordVideoActivity.this.onStopRecord();
            if (z) {
                if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                    if (RecordVideoActivity.this.mTakePhoto != null && !ListUtils.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.mTakePhoto)) {
                        RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.mTakePhoto);
                    }
                } else {
                    RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                }
                RecordVideoActivity.this.mTakePhoto = new ImageFileInfo();
                RecordVideoActivity.this.mTakePhoto.setFilePath(str);
                RecordVideoActivity.this.mTakePhoto.setContentUriStr(null);
                RecordVideoActivity.this.mTakePhoto.setTempFile(true);
                RecordVideoActivity.this.mTakePhoto.setAlbumnId(null);
                RecordVideoActivity.this.mTakePhoto.setIsFromCamera(true);
                RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.mTakePhoto);
                if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                    RecordVideoActivity.this.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), 12012, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.mForumWriteData, RecordVideoActivity.this.mEntranceFlag)));
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, RecordVideoActivity.this.mWriteImagesInfo.toJsonString());
                RecordVideoActivity.this.setResult(-1, intent);
                RecordVideoActivity.this.finish();
                ActivityPendingTransitionFactory.closeAnimation(RecordVideoActivity.this.getPageContext(), 0);
            }
        }
    }

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_STICKERS, TbConfig.SERVER_ADDRESS + TbConfig.GET_STICKERS);
        tbHttpMessageTask.setResponsedClass(ResponseGetStickersMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, d.a.j0.t1.k.class);
        d.a.j0.t1.k kVar = runTask != null ? (d.a.j0.t1.k) runTask.getData() : null;
        if (kVar != null) {
            this.mPostMonitorManager = kVar.get();
        }
        d.a.j0.t1.g gVar = this.mPostMonitorManager;
        if (gVar != null) {
            gVar.g();
        }
        this.mOnLocalVideoLoadedListener = new f();
        this.mGetStickersListener = new g(CmdConfigHttp.CMD_GET_STICKERS);
        this.mGuideVideoWriteListener = new d(2001374);
        this.mCloseListener = new e(2001373);
    }

    private void addTabByType(int i2) {
        RecordTabLayout recordTabLayout = this.mTabLayout;
        if (recordTabLayout == null) {
            return;
        }
        if (i2 == 0) {
            recordTabLayout.d(1, getString(R.string.tab_photo));
            this.mTabLayout.d(2, getString(R.string.tab_record));
            this.mTabLayout.setListener(this);
            this.mTabLayout.setCurrentTab(2, false);
            onTabChoosed(2, false);
        } else if (i2 == 1) {
            recordTabLayout.d(1, getString(R.string.tab_photo));
            this.mTabLayout.setShowIndicator(false);
            this.mTabLayout.setCurrentTab(1, false);
            onTabChoosed(1, false);
        } else {
            recordTabLayout.d(2, getString(R.string.tab_record));
            this.mTabLayout.setShowIndicator(false);
            this.mTabLayout.setCurrentTab(2, false);
            onTabChoosed(2, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [com.baidu.tbadk.core.data.PostPrefixData] */
    public void goToEditVideo() {
        PostPrefixData postPrefixData;
        String str;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.mPreviewController.r);
        videoInfo.setVideoDuration(this.mRecordController.g() / 1000);
        videoInfo.setVideoWidth(PeerConnectionClient.HD_VIDEO_HEIGHT);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.mPreviewController.r).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        ForumWriteData forumWriteData = this.mForumWriteData;
        String str2 = "";
        String str3 = forumWriteData == null ? "" : forumWriteData.forumName;
        ForumWriteData forumWriteData2 = this.mForumWriteData;
        String str4 = forumWriteData2 == null ? "" : forumWriteData2.forumId;
        ForumWriteData forumWriteData3 = this.mForumWriteData;
        int i2 = forumWriteData3 == null ? -1 : forumWriteData3.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.mForumWriteData.writeCallFrom, str3, str4, this.mVideoTitle, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        editVideoActivityConfig.setProZone(i2);
        editVideoActivityConfig.setStatisticFrom(this.mForumWriteData.statisticFrom);
        ForumWriteData forumWriteData4 = this.mForumWriteData;
        editVideoActivityConfig.setFrsTabInfo(forumWriteData4 != null ? forumWriteData4.frsTabInfo : null);
        ForumWriteData forumWriteData5 = this.mForumWriteData;
        editVideoActivityConfig.setForumLevel(forumWriteData5 != null ? forumWriteData5.forumLevel : -1);
        if (getIntent() != null) {
            Serializable serializableExtra = getIntent().getSerializableExtra("anti_data");
            AntiData antiData = serializableExtra instanceof AntiData ? (AntiData) serializableExtra : null;
            Serializable serializableExtra2 = getIntent().getSerializableExtra("prefix_data");
            r1 = serializableExtra2 instanceof PostPrefixData ? (PostPrefixData) serializableExtra2 : null;
            str2 = getIntent().getStringExtra(IntentConfig.FORUM_FIRST_DIR);
            str = getIntent().getStringExtra(IntentConfig.FORUM_SECOND_DIR);
            AntiData antiData2 = r1;
            r1 = antiData;
            postPrefixData = antiData2;
        } else {
            postPrefixData = null;
            str = "";
        }
        editVideoActivityConfig.setExtraData(r1, postPrefixData, str2, str);
        editVideoActivityConfig.setFrom(this.mForumWriteData.mFrom);
        d.a.j0.q3.m.j jVar = this.mMusicController;
        if (jVar != null) {
            jVar.g(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        d.a.j0.t1.g gVar = this.mPostMonitorManager;
        if (gVar != null) {
            gVar.d();
        }
    }

    private void hideTab() {
        ObjectAnimator objectAnimator = this.mShowTabAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        if (this.mHideTabAnimator == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mTabLayout, "alpha", 1.0f, 0.0f);
            this.mHideTabAnimator = ofFloat;
            ofFloat.setDuration(500L);
            this.mHideTabAnimator.addListener(new a());
        }
        this.mHideTabAnimator.start();
    }

    private void initUI() {
        RecordLayout recordLayout = (RecordLayout) findViewById(R.id.root_layout);
        this.mRootLayout = recordLayout;
        recordLayout.setListener(this);
        this.mRecordController = new d.a.j0.q3.m.i(this);
        VideoControllerLayout videoControllerLayout = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.mControllerLayout = videoControllerLayout;
        videoControllerLayout.setRecordController(this.mRecordController);
        this.mControllerLayout.setRecordControlListener(this);
        this.mControllerLayout.setEffectChoosedListener(this);
        this.mTopControllerLayout = (RelativeLayout) findViewById(R.id.top_control_layout);
        ImageView imageView = (ImageView) findViewById(R.id.close_page);
        this.mClose = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) findViewById(R.id.flash_switch);
        this.mFlashSwitch = imageView2;
        imageView2.setOnClickListener(this);
        ImageView imageView3 = (ImageView) findViewById(R.id.camera_switch);
        this.mCameraSwitch = imageView3;
        imageView3.setOnClickListener(this);
        ImageView imageView4 = (ImageView) findViewById(R.id.count_down);
        this.mCountDown = imageView4;
        imageView4.setOnClickListener(this);
        this.mSurfaceContainer = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        d.a.j0.q3.m.h hVar = new d.a.j0.q3.m.h(this);
        this.mPreviewController = hVar;
        hVar.I(this);
        this.mPreviewController.D(this);
        this.mPreviewController.F(new h());
        VideoEffectButtonLayout videoEffectButtonLayout = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.mEffectButtonLayout = videoEffectButtonLayout;
        videoEffectButtonLayout.setListener(this);
        this.mRecordController.c(this.mEffectButtonLayout);
        this.mEffectButtonLayout.setViewChoosed(2, true);
        this.mTvCountDown = (TextView) findViewById(R.id.tv_count_down);
        this.mGestureGuideView = (TextView) findViewById(R.id.gesture_guide_tv);
        int i2 = ((d.a.c.e.p.l.i(this.mContext) - d.a.c.e.p.l.g(this.mContext, R.dimen.ds336)) / 2) - d.a.c.e.p.l.g(this.mContext, R.dimen.ds150);
        if (this.mTvCountDown.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.mTvCountDown.getLayoutParams()).topMargin = i2;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.mEffectButtonLayout.setVisibility(8);
        }
        View findViewById = findViewById(R.id.progress_layout);
        this.mProgressView = findViewById;
        this.mRoundProgressBar = (RoundProgressBar) findViewById.findViewById(R.id.video_progress);
        TextView textView = (TextView) findViewById(R.id.min_time_tips);
        this.mMinTimeTips = textView;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.leftMargin = ((int) (d.a.c.e.p.l.k(this.mContext) * 0.2d)) - d.a.c.e.p.l.g(this.mContext, R.dimen.ds38);
        this.mMinTimeTips.setLayoutParams(layoutParams);
        this.mTabLayout = (RecordTabLayout) findViewById(R.id.tab_layout);
        WriteImagesInfo writeImagesInfo = this.mWriteImagesInfo;
        if (writeImagesInfo != null && !ListUtils.isEmpty(writeImagesInfo.getChosedFiles())) {
            addTabByType(1);
        } else {
            addTabByType(this.bottomTabShowType);
        }
        suitAllConcaveScreen();
    }

    private void loadLocalVideo() {
        d.a.j0.q3.k.a aVar = new d.a.j0.q3.k.a(this);
        aVar.d(this.mOnLocalVideoLoadedListener);
        aVar.execute(new Void[0]);
    }

    private void loadStickers() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordCompress(int i2) {
        d.a.j0.t1.g gVar = this.mPostMonitorManager;
        if (gVar != null) {
            gVar.i(i2, BundleOpProvider.METHOD_BUNDLE_RECORD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordVideoRecord(int i2, String str) {
        if (this.mPostMonitorManager != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.mPostMonitorManager.b(i2, str);
        }
    }

    private void refreshFlashBtnUI() {
        if (this.mPreviewController.m()) {
            this.mFlashSwitch.setVisibility(8);
        } else {
            this.mFlashSwitch.setVisibility(0);
        }
        if (this.mPreviewController.l()) {
            this.mFlashSwitch.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.mFlashSwitch.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSticker(StickerItem stickerItem, String str) {
        if (stickerItem == null || StringUtils.isNull(str)) {
            return;
        }
        stickerItem.localPath = str;
        d.a.j0.q3.m.h hVar = this.mPreviewController;
        if (hVar != null) {
            hVar.H(stickerItem);
            this.mIsProcessFaceIdentifyFail = true;
        }
        if (!StringUtils.isNull(stickerItem.desc)) {
            this.mGestureGuideView.setText(stickerItem.desc);
            this.mGestureGuideView.setVisibility(0);
            this.mGestureGuideView.postDelayed(new c(), 3000L);
            return;
        }
        this.mGestureGuideView.setVisibility(8);
    }

    private void showTab() {
        ObjectAnimator objectAnimator = this.mHideTabAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        if (this.mShowTabAnimator == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mTabLayout, "alpha", 0.0f, 1.0f);
            this.mShowTabAnimator = ofFloat;
            ofFloat.setDuration(500L);
        }
        this.mTabLayout.setVisibility(0);
        this.mShowTabAnimator.start();
    }

    private void suitAllConcaveScreen() {
        if (DeviceInfoUtil.isfullScreen()) {
            View findViewById = findViewById(R.id.statusbar_view);
            this.mStatusBarView = findViewById;
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
    }

    private void suitOppoConcaveScreen() {
        if (UtilHelper.isOppoConcaveScreen()) {
            if (this.mTopControllerLayout.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.mTopControllerLayout.getLayoutParams()).topMargin = 80;
            }
            ProgressView progressView = (ProgressView) findViewById(R.id.video_progress_view);
            if (progressView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) progressView.getLayoutParams()).topMargin = 80;
            }
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        VideoControllerLayout videoControllerLayout = this.mControllerLayout;
        if (videoControllerLayout != null && !ListUtils.isEmpty(videoControllerLayout.getChoosedBeautyList())) {
            for (d.a.j0.q3.m.e eVar : this.mControllerLayout.getChoosedBeautyList()) {
                if (eVar != null) {
                    String b2 = eVar.b();
                    if (!TextUtils.isEmpty(b2)) {
                        if (b2.equals("Normal")) {
                            b2 = "0";
                        }
                        arrayList.add(b2);
                    }
                }
            }
        }
        return arrayList;
    }

    public List<String> getChoosedFilterList() {
        ArrayList arrayList = new ArrayList();
        VideoControllerLayout videoControllerLayout = this.mControllerLayout;
        if (videoControllerLayout != null && !ListUtils.isEmpty(videoControllerLayout.getChoosedFilterList())) {
            for (d.a.j0.q3.m.e eVar : this.mControllerLayout.getChoosedFilterList()) {
                if (eVar != null) {
                    String str = (String) eVar.d();
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(str);
                    }
                }
            }
        }
        return arrayList;
    }

    public List<String> getChoosedStickerList() {
        ArrayList arrayList = new ArrayList();
        VideoControllerLayout videoControllerLayout = this.mControllerLayout;
        if (videoControllerLayout != null && !ListUtils.isEmpty(videoControllerLayout.getChoosedStickerList())) {
            for (StickerItem stickerItem : this.mControllerLayout.getChoosedStickerList()) {
                if (stickerItem != null) {
                    arrayList.add(String.valueOf(stickerItem.id));
                }
            }
        }
        return arrayList;
    }

    public FrameLayout getSurfaceContainer() {
        return this.mSurfaceContainer;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void hideMinVideoTips() {
        this.mMinTimeTips.setVisibility(4);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (intent == null || i2 != 25032) {
            if (i2 == 12012 && i3 == -1) {
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
                return;
            }
            return;
        }
        String stringExtra = intent.getStringExtra("music_resource");
        String stringExtra2 = intent.getStringExtra("music_id");
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
            return;
        }
        String g2 = d.a.j0.q3.j.f.a.h().g(stringExtra);
        if (this.mMusicController == null || TextUtils.isEmpty(g2)) {
            return;
        }
        this.mMusicController.j(g2, stringExtra2);
        this.mControllerLayout.v();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        d.a.j0.q3.m.i iVar = this.mRecordController;
        if (iVar == null || iVar.f() != 7) {
            d.a.j0.q3.m.i iVar2 = this.mRecordController;
            if (iVar2 != null && iVar2.f() == 6) {
                VideoControllerLayout videoControllerLayout = this.mControllerLayout;
                if (videoControllerLayout != null) {
                    videoControllerLayout.A();
                }
                onCancelCountDowning();
                return;
            }
            d.a.j0.q3.m.i iVar3 = this.mRecordController;
            if (iVar3 != null && iVar3.k()) {
                finish();
                return;
            }
            if (this.mAlertDialog == null) {
                d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(getPageContext().getPageActivity());
                this.mAlertDialog = aVar;
                aVar.setMessageId(R.string.video_quit_confirm);
                this.mAlertDialog.setPositiveButton(R.string.dialog_ok, new j());
                this.mAlertDialog.setNegativeButton(R.string.dialog_cancel, new k());
                this.mAlertDialog.setCancelable(true);
                this.mAlertDialog.create(getPageContext());
            }
            this.mAlertDialog.show();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void onCancelCountDowning() {
        this.mCountDowningAnimaton.cancel();
        this.mCountDowningAnimaton.setAnimationListener(null);
        this.mTvCountDown.clearAnimation();
        this.mTvCountDown.setVisibility(8);
        d.a.j0.q3.m.j jVar = this.mMusicController;
        if (jVar != null) {
            jVar.m();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.mMinTimeTips.setVisibility(4);
        if (view == this.mClose) {
            onBackPressed();
        } else if (view == this.mFlashSwitch) {
            if (this.mRecordController.f() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.mPreviewController.i();
            refreshFlashBtnUI();
        } else if (view == this.mCameraSwitch) {
            if (this.mRecordController.f() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.mCameraSwitch.setOnClickListener(null);
            this.mPreviewController.f();
            if (this.mPreviewController.m() && this.mPreviewController.l()) {
                this.mPreviewController.i();
            }
            refreshFlashBtnUI();
            this.mCameraSwitch.setOnClickListener(this);
        } else if (view == this.mCountDown) {
            onClickCountDown();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickBeauty() {
        this.mMinTimeTips.setVisibility(4);
        if (this.mRecordController.f() == 6) {
            return;
        }
        this.mControllerLayout.onClickBeauty();
    }

    public void onClickCountDown() {
        this.mMinTimeTips.setVisibility(4);
        if (this.mRecordController.f() == 6) {
            return;
        }
        this.mRecordController.m(6);
        onStartRecord();
        AtomicInteger atomicInteger = new AtomicInteger();
        if (this.mCountDowningAnimaton == null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.mCountDowningAnimaton = scaleAnimation;
            scaleAnimation.setDuration(500L);
            this.mCountDowningAnimaton.setRepeatCount(5);
            this.mCountDowningAnimaton.setRepeatMode(2);
            this.mCountDowningAnimaton.setInterpolator(new DecelerateInterpolator(2.0f));
        }
        this.mCountDowningAnimaton.setAnimationListener(new l(atomicInteger));
        this.mTvCountDown.setAnimation(this.mCountDowningAnimaton);
        this.mCountDowningAnimaton.startNow();
        this.mControllerLayout.r();
        d.a.j0.q3.m.j jVar = this.mMusicController;
        if (jVar != null) {
            jVar.o();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickFilter() {
        this.mMinTimeTips.setVisibility(4);
        if (this.mRecordController.f() == 6) {
            return;
        }
        this.mControllerLayout.onClickFilter();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickMusic() {
        if (this.mRecordController.f() != 1) {
            return;
        }
        this.mMinTimeTips.setVisibility(4);
        if (this.mRecordController.f() == 6) {
            return;
        }
        this.mControllerLayout.onClickMusic();
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickSticker() {
        this.mMinTimeTips.setVisibility(4);
        if (this.mRecordController.f() == 6) {
            return;
        }
        this.mControllerLayout.onClickSticker();
        if (this.mControllerLayout.q()) {
            loadStickers();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        TiebaStatic.log("c12293");
        this.mContext = getPageContext().getPageActivity();
        setIsAddSwipeBackLayout(false);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        super.onCreate(bundle);
        setContentView(R.layout.record_activity);
        this.mEntranceFlag = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        this.bottomTabShowType = getIntent().getIntExtra(RecordVideoActivityConfig.SHOW_TYPE, 0);
        if (getIntent().getSerializableExtra("forum_write_data") instanceof ForumWriteData) {
            this.mForumWriteData = (ForumWriteData) getIntent().getSerializableExtra("forum_write_data");
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.mVideoTitle = getIntent().getStringExtra("video_title");
        initUI();
        SelectMusicModel selectMusicModel = new SelectMusicModel(getPageContext(), this.mControllerLayout);
        this.mMusicModel = selectMusicModel;
        selectMusicModel.t();
        d.a.j0.q3.m.j jVar = new d.a.j0.q3.m.j(this);
        this.mMusicController = jVar;
        jVar.t(this.mMusicModel);
        this.mRecordController.c(this.mMusicController);
        registerListener(this.mGetStickersListener);
        registerListener(this.mGuideVideoWriteListener);
        registerListener(this.mCloseListener);
        loadStickers();
        if (Build.VERSION.SDK_INT >= 28 && RomTypeUtil.isOPPO() && TbSingleton.getInstance().isCutoutScreen(this)) {
            d.a.j0.p3.c.b(1, getWindow().getAttributes(), getWindow());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.a.j0.q3.m.i iVar = this.mRecordController;
        if (iVar != null && iVar.j()) {
            this.mRecordController.o();
        }
        SelectMusicModel selectMusicModel = this.mMusicModel;
        if (selectMusicModel != null) {
            selectMusicModel.cancelLoadData();
        }
        d.a.j0.t1.g gVar = this.mPostMonitorManager;
        if (gVar != null) {
            gVar.k(BundleOpProvider.METHOD_BUNDLE_RECORD);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.h
    public void onEffectChoosed(d.a.j0.q3.m.e eVar, Object obj) {
        if (this.mPreviewController == null || eVar == null) {
            return;
        }
        int c2 = eVar.c();
        if (c2 == 1) {
            if (eVar.d() instanceof d.a.j0.q3.a) {
                this.mPreviewController.B((d.a.j0.q3.a) eVar.d());
                TiebaStatic.log(new StatisticItem("c12421").param("obj_id", ((d.a.j0.q3.a) eVar.d()).f59093a));
                if (((d.a.j0.q3.a) eVar.d()).f59093a == 0) {
                    this.mEffectButtonLayout.setViewChoosed(2, false);
                } else {
                    this.mEffectButtonLayout.setViewChoosed(2, true);
                }
            }
        } else if (c2 != 2) {
            if (c2 == 3 && (eVar.d() instanceof MusicData)) {
                this.mMusicController.k((MusicData) eVar.d(), obj);
                if (((MusicData) eVar.d()).editMusicType == 1) {
                    this.mEffectButtonLayout.setViewChoosed(0, false);
                } else {
                    this.mEffectButtonLayout.setViewChoosed(0, true);
                }
            }
        } else if (eVar.d() instanceof String) {
            this.mPreviewController.E((String) eVar.d());
            StatisticItem statisticItem = new StatisticItem("c12496");
            statisticItem.param("obj_id", (String) eVar.d());
            if (this.mRecordController.f() == 1) {
                statisticItem.param("obj_type", 1);
            } else {
                statisticItem.param("obj_type", 2);
            }
            if (eVar.d().equals("origin")) {
                this.mEffectButtonLayout.setViewChoosed(3, false);
            } else {
                this.mEffectButtonLayout.setViewChoosed(3, true);
            }
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.b
    public void onFaceIdentifyState(boolean z) {
        d.a.j0.q3.m.i iVar = this.mRecordController;
        if (iVar != null && (iVar.f() == 1 || this.mRecordController.f() == 3 || this.mRecordController.f() == 4)) {
            if (!z && this.mIsProcessFaceIdentifyFail) {
                this.mSurfaceContainer.b();
                return;
            } else {
                this.mSurfaceContainer.a();
                return;
            }
        }
        this.mSurfaceContainer.a();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void onHideEffectLayout() {
        this.mEffectButtonLayout.c();
        if (this.mRecordController.f() == 1) {
            showTab();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mPreviewController.u();
        if (this.mControllerLayout != null) {
            d.a.j0.q3.m.i iVar = this.mRecordController;
            if (iVar != null && iVar.f() == 6) {
                this.mControllerLayout.A();
                onCancelCountDowning();
            }
            d.a.j0.q3.m.i iVar2 = this.mRecordController;
            if (iVar2 != null && iVar2.j()) {
                this.mControllerLayout.A();
            }
        }
        d.a.j0.q3.m.j jVar = this.mMusicController;
        if (jVar != null) {
            jVar.l();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void onRecordDone() {
        if (this.mProgressView.getVisibility() == 0) {
            return;
        }
        this.mControllerLayout.B();
        this.mRecordController.m(8);
        onStopRecord();
        List<String> list = this.mPreviewController.q;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mProgressView.setVisibility(0);
        new b().execute(new Void[0]);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void onRecordShort() {
        this.mMinTimeTips.setVisibility(0);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
        if (this.mRecordController.f() == 8) {
            this.mControllerLayout.F();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mPreviewController.v();
        d.a.j0.q3.m.b k2 = this.mPreviewController.k();
        this.mZoomHelper = k2;
        if (k2 != null) {
            k2.c(this.mRecordController);
            this.mSurfaceContainer.setZoomHelper(this.mZoomHelper);
        }
        refreshFlashBtnUI();
        if (this.mStickerManager == null) {
            d.a.j0.q3.m.l lVar = new d.a.j0.q3.m.l();
            this.mStickerManager = lVar;
            lVar.k(new i());
        }
        this.mStickerManager.e();
        if (this.mControllerLayout != null && this.mIsNeedToLoadLocalVideo) {
            loadLocalVideo();
        }
        d.a.j0.t1.g gVar = this.mPostMonitorManager;
        if (gVar != null) {
            gVar.e("album");
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void onShowEffectLayout() {
        hideTab();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void onStartRecord() {
        this.mIsRecordingState = true;
        AnimatorSet animatorSet = this.mStopRecodingAnimatorSet;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.mStopRecodingAnimatorSet.cancel();
        }
        if (this.mStartRecodingAnimatorSet == null) {
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.mStartRecodingAnimatorSet = animatorSet2;
            animatorSet2.playTogether(ObjectAnimator.ofFloat(this.mTopControllerLayout, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.mEffectButtonLayout, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.mTabLayout, "alpha", 1.0f, 0.0f));
            this.mStartRecodingAnimatorSet.addListener(new m());
            this.mStartRecodingAnimatorSet.setDuration(300L);
        }
        this.mStartRecodingAnimatorSet.start();
        this.mEffectButtonLayout.c();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void onStatusChange() {
        if (this.mRecordController.f() == 1) {
            this.mTabLayout.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.h
    public void onStickerChoosed(StickerItem stickerItem) {
        if (stickerItem != null) {
            this.mCurrentSticker = stickerItem;
            this.mStickerManager.j(stickerItem.resource);
            if (stickerItem.id == -1) {
                d.a.j0.q3.m.h hVar = this.mPreviewController;
                if (hVar != null) {
                    hVar.H(null);
                    this.mIsProcessFaceIdentifyFail = false;
                }
                VideoControllerLayout videoControllerLayout = this.mControllerLayout;
                if (videoControllerLayout != null) {
                    videoControllerLayout.setDownLoadSticker(null);
                }
                this.mGestureGuideView.setVisibility(8);
                this.mEffectButtonLayout.setViewChoosed(1, false);
                return;
            }
            String g2 = this.mStickerManager.g(stickerItem.resource);
            if (!StringUtils.isNull(g2)) {
                setSticker(stickerItem, g2);
                VideoControllerLayout videoControllerLayout2 = this.mControllerLayout;
                if (videoControllerLayout2 != null) {
                    videoControllerLayout2.setDownLoadSticker(null);
                }
            } else {
                VideoControllerLayout videoControllerLayout3 = this.mControllerLayout;
                if (videoControllerLayout3 != null) {
                    videoControllerLayout3.setDownLoadSticker(stickerItem);
                }
                this.mStickerManager.f(stickerItem.resource);
            }
            this.mEffectButtonLayout.setViewChoosed(1, true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void onStopRecord() {
        if (this.mCurrentTab == 2) {
            if (!this.mIsRecordingState) {
                return;
            }
            this.mIsRecordingState = false;
            d.a.j0.q3.m.j jVar = this.mMusicController;
            if (jVar != null) {
                jVar.o();
            }
        }
        AnimatorSet animatorSet = this.mStartRecodingAnimatorSet;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.mStartRecodingAnimatorSet.cancel();
        }
        if (this.mStopRecodingAnimatorSet == null) {
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.mStopRecodingAnimatorSet = animatorSet2;
            animatorSet2.playTogether(ObjectAnimator.ofFloat(this.mTopControllerLayout, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.mEffectButtonLayout, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.mTabLayout, "alpha", 0.0f, 1.0f));
            this.mStopRecodingAnimatorSet.setDuration(300L);
        }
        this.mTopControllerLayout.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.mEffectButtonLayout.setVisibility(0);
        }
        if (this.mRecordController.f() == 1) {
            this.mTabLayout.setVisibility(0);
        }
        this.mStopRecodingAnimatorSet.start();
    }

    @Override // d.a.j0.q3.m.h.l
    public void onSurfaceViewLayoutChange(int i2, int i3) {
        int i4;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset <= 0 || i3 <= 0 || (i4 = (d.a.c.e.p.l.q(this).heightPixels - i3) - dimensionPixelOffset) <= 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.mControllerLayout.getLayoutParams();
        layoutParams.height = dimensionPixelOffset + i4;
        this.mControllerLayout.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.video.record.RecordTabLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onTabChoosed(int i2, boolean z) {
        if (this.mCurrentTab == i2) {
            return;
        }
        int i3 = 2;
        if (i2 == 1) {
            d.a.j0.q3.m.j jVar = this.mMusicController;
            if (jVar != null) {
                jVar.r();
            }
            this.mPreviewController.E("origin");
            this.mEffectButtonLayout.setViewChoosed(0, false);
            this.mEffectButtonLayout.setViewChoosed(3, false);
            this.mControllerLayout.j(1);
            this.mEffectButtonLayout.setViewVisibility(0, 8);
            this.mEffectButtonLayout.setViewVisibility(3, 8);
        } else if (i2 == 2) {
            this.mEffectButtonLayout.setViewVisibility(0, 0);
            this.mEffectButtonLayout.setViewVisibility(3, 0);
            this.mCurrentTab = i2;
            this.mControllerLayout.setCurrentTab(i2);
            if (z) {
                return;
            }
            TiebaStatic.log(new StatisticItem().param("obj_type", i3));
            return;
        }
        i3 = 1;
        this.mCurrentTab = i2;
        this.mControllerLayout.setCurrentTab(i2);
        if (z) {
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void onTakePhoto() {
        d.a.j0.q3.m.h hVar = this.mPreviewController;
        if (hVar == null) {
            return;
        }
        hVar.N(new n());
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void onTouchToLeft() {
        if (this.mRecordController.f() != 1 || this.mControllerLayout.p()) {
            return;
        }
        onTabChoosed(2, true);
        this.mTabLayout.setCurrentTab(2, true);
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void onTouchToRight() {
        if (this.mRecordController.f() != 1 || this.mControllerLayout.p()) {
            return;
        }
        onTabChoosed(1, true);
        this.mTabLayout.setCurrentTab(1, true);
    }
}
