package com.baidu.tieba.view.videoedit;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.arface.bean.Filter;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.TbEditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.TbFileVideoActivityConfig;
import com.baidu.tbadk.core.atomData.VideoCoverSelectActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.MediaScannerClient;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tbadk.data.TbMusicData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.external.filter.ResponseGetQmFiltersMessage;
import com.baidu.tieba.external.filter.TbFilterValue;
import com.baidu.tieba.external.music.data.MusicData;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.tieba.view.widget.RecordPreviewContainer;
import com.baidu.tieba.view.widget.TbGLMediaPreviewView;
import com.baidu.tieba.view.widget.pickcover.PreViewPickCoverView;
import com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout;
import com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.filter.FilterValue;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import com.google.protobuf.CodedInputStream;
import com.kwai.video.player.PlayerPostEvent;
import d.a.r0.r.s.l;
import d.a.s0.f0.b.a;
import d.a.s0.n0.b.a;
import d.a.y0.t.u;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class TbEditVideoActivity extends BaseActivity<TbEditVideoActivity> implements d.a.s0.n0.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable hideFilterName;
    public boolean isEdited;
    public RelativeLayout mCaptureCoverContainer;
    public RelativeLayout mCaptureFilterContainer;
    public RelativeLayout mCaptureMusicContainer;
    public d.a.s0.n0.a.a mCoverManager;
    public String mCoverPath;
    public TbMusicData mCurrentMusicData;
    public RelativeLayout mEditEditerContainer;
    public ImageView mEditFilter;
    public d.a.s0.f0.a.a mEditManager;
    public a.InterfaceC1418a mEditMergeCallBack;
    public ImageView mEditMusic;
    public RecordEffectLayout.i mEditOnEffectChoosedListener;
    public RecordPreviewContainer mEditPreviewContainer;
    public RecordPreviewContainer.f mEditPreviewGestureListener;
    public TextView mEditPreviewPublish;
    public LinearLayout mEditRightContainer;
    public RelativeLayout mEditSaveContainer;
    public d.a.s0.n0.b.b mFilterManager;
    public TextView mFilterName;
    public a.b mGetFilterCallback;
    public HttpMessageListener mGetQmFiltersListener;
    public TbMusicData mInitMusicData;
    public float mLastCoverPercent;
    public View mLeft;
    public int mModeType;
    public TbMultiMediaData mMultiMediaData;
    public d.a.s0.n0.c.a mMusicManager;
    public d.a.s0.f0.b.a mMuxerManager;
    public NavigationBar mNavigationBar;
    public String mOrignalCoverPath;
    public PreViewPickCoverView mPreViewPickCoverView;
    public float mPreviewHeight;
    public TbGLMediaPreviewView mPreviewView;
    public float mRatio;
    public TextView mRight;
    public ViewGroup mRootView;
    public TextView mTitle;
    public float mTranslateY;
    public VideoControllerLayout mVideoControllerLayout;
    public int mVideoFrom;
    public VideoInfo mVideoInfo;
    public boolean needShowCoverToast;
    public boolean onSaving;

    /* loaded from: classes5.dex */
    public class a implements a.InterfaceC1418a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f22244a;

        /* renamed from: com.baidu.tieba.view.videoedit.TbEditVideoActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0242a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomResponsedMessage f22245e;

            public RunnableC0242a(a aVar, CustomResponsedMessage customResponsedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, customResponsedMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f22245e = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(this.f22245e);
                }
            }
        }

        public a(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22244a = tbEditVideoActivity;
        }

        @Override // d.a.s0.f0.b.a.InterfaceC1418a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TbEditVideoActivity tbEditVideoActivity = this.f22244a;
                tbEditVideoActivity.hideLoadingView(tbEditVideoActivity.mRootView);
            }
        }

        @Override // d.a.s0.f0.b.a.InterfaceC1418a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                TbEditVideoActivity tbEditVideoActivity = this.f22244a;
                tbEditVideoActivity.showLoadingView(tbEditVideoActivity.mRootView);
            }
        }

        @Override // d.a.s0.f0.b.a.InterfaceC1418a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (this.f22244a.onSaving) {
                    File file = new File(str);
                    File file2 = new File(d.a.s0.v3.c.f68592e);
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    String str2 = d.a.s0.v3.c.f68592e + file.getName();
                    if (!str2.equals(file.getAbsolutePath())) {
                        FileHelper.copyFile(file.getAbsolutePath(), str2);
                    }
                    new MediaScannerClient(this.f22244a).saveVideo(str2);
                    try {
                        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                        intent.setData(UtilHelper.getUriFromFile(file, intent, this.f22244a.getPageContext().getPageActivity()));
                        this.f22244a.sendBroadcast(intent);
                    } catch (Exception e2) {
                        this.f22244a.onSaving = false;
                        this.f22244a.onPause();
                        this.f22244a.onResume();
                        BdLog.d(e2.getMessage());
                    }
                    this.f22244a.onSaving = false;
                    TbEditVideoActivity tbEditVideoActivity = this.f22244a;
                    tbEditVideoActivity.showToast(tbEditVideoActivity.getResources().getString(R.string.save_success));
                    this.f22244a.onPause();
                    this.f22244a.onResume();
                } else {
                    u.a().post(new RunnableC0242a(this, new CustomResponsedMessage(2921584, 100)));
                    VideoFileInfo c2 = d.a.s0.u3.c.c(str);
                    if (c2 == null) {
                        return;
                    }
                    this.f22244a.mVideoInfo = new VideoInfo();
                    this.f22244a.mVideoInfo.setVideoPath(str);
                    this.f22244a.mVideoInfo.setThumbPath(this.f22244a.mCoverPath);
                    this.f22244a.mVideoInfo.setVideoDuration((int) (c2.videoDuration / 1000.0f));
                    this.f22244a.mVideoInfo.setVideoWidth(c2.videoWidth);
                    this.f22244a.mVideoInfo.setVideoHeight(c2.videoHeight);
                    this.f22244a.mVideoInfo.setVideoLength(new File(str).length());
                    this.f22244a.mVideoInfo.setVideoType(2);
                    this.f22244a.mVideoInfo.setIsCompressedVideo(true);
                    EditVideoData editVideoData = new EditVideoData();
                    if (!StringUtils.isNull(this.f22244a.mCoverPath)) {
                        editVideoData.coverPath = this.f22244a.mCoverPath;
                    } else {
                        editVideoData.coverPath = d.a.s0.v3.c.f68589b;
                    }
                    editVideoData.originPath = this.f22244a.mMultiMediaData.path;
                    editVideoData.finalPath = str;
                    this.f22244a.mVideoInfo.setEditVideoData(editVideoData);
                    this.f22244a.mMultiMediaData.coverSource = this.f22244a.mPreViewPickCoverView.getCurrentMode();
                    this.f22244a.mMultiMediaData.coverPath = this.f22244a.mCoverPath;
                    this.f22244a.mMultiMediaData.orignalCoverPath = this.f22244a.mOrignalCoverPath;
                    this.f22244a.mMultiMediaData.lastCoverPercent = this.f22244a.mLastCoverPercent;
                    this.f22244a.mVideoInfo.setMultiMediaData(this.f22244a.mMultiMediaData);
                    WriteActivityConfig newInstance = WriteActivityConfig.newInstance(this.f22244a.getPageContext().getPageActivity());
                    newInstance.getIntent().putExtras(this.f22244a.getIntent());
                    newInstance.getIntent().setFlags(536870912);
                    newInstance.getIntent().setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                    newInstance.setType(9).setVideoInfo(this.f22244a.mVideoInfo).setNeedClosePrePage(true).send();
                    this.f22244a.finish();
                }
                TbEditVideoActivity tbEditVideoActivity2 = this.f22244a;
                tbEditVideoActivity2.hideLoadingView(tbEditVideoActivity2.mRootView);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f22246e;

        public b(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22246e = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoFileInfo c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (c2 = d.a.s0.u3.c.c(this.f22246e.mMultiMediaData.path)) == null) {
                return;
            }
            this.f22246e.mVideoInfo = new VideoInfo();
            this.f22246e.mVideoInfo.setVideoPath(this.f22246e.mMultiMediaData.path);
            this.f22246e.mVideoInfo.setThumbPath(this.f22246e.mCoverPath);
            this.f22246e.mVideoInfo.setVideoDuration((int) (c2.videoDuration / 1000.0f));
            this.f22246e.mVideoInfo.setVideoWidth(c2.videoWidth);
            this.f22246e.mVideoInfo.setVideoHeight(c2.videoHeight);
            this.f22246e.mVideoInfo.setVideoLength(new File(this.f22246e.mMultiMediaData.path).length());
            this.f22246e.mVideoInfo.setVideoType(2);
            this.f22246e.mVideoInfo.setIsCompressedVideo(true);
            EditVideoData editVideoData = new EditVideoData();
            if (!StringUtils.isNull(this.f22246e.mCoverPath)) {
                editVideoData.coverPath = this.f22246e.mCoverPath;
            } else {
                editVideoData.coverPath = d.a.s0.v3.c.f68589b;
            }
            editVideoData.originPath = this.f22246e.mVideoInfo.getVideoPath();
            this.f22246e.mVideoInfo.setEditVideoData(editVideoData);
            this.f22246e.mMultiMediaData.coverSource = this.f22246e.mPreViewPickCoverView.getCurrentMode();
            this.f22246e.mMultiMediaData.coverPath = this.f22246e.mCoverPath;
            this.f22246e.mMultiMediaData.orignalCoverPath = this.f22246e.mOrignalCoverPath;
            this.f22246e.mMultiMediaData.lastCoverPercent = this.f22246e.mLastCoverPercent;
            this.f22246e.mVideoInfo.setMultiMediaData(this.f22246e.mMultiMediaData);
            WriteActivityConfig newInstance = WriteActivityConfig.newInstance(this.f22246e.getPageContext().getPageActivity());
            newInstance.getIntent().putExtras(this.f22246e.getIntent());
            newInstance.getIntent().setFlags(536870912);
            newInstance.getIntent().setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            newInstance.setType(9).setVideoInfo(this.f22246e.mVideoInfo).send();
            this.f22246e.finish();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f22247e;

        public c(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22247e = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22247e.mCoverManager == null) {
                return;
            }
            this.f22247e.mCoverManager.c();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.r.s.j f22248e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f22249f;

        public d(TbEditVideoActivity tbEditVideoActivity, d.a.r0.r.s.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22249f = tbEditVideoActivity;
            this.f22248e = jVar;
        }

        @Override // d.a.r0.r.s.l.e
        public void onItemClick(d.a.r0.r.s.l lVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) {
                if (i2 == 0) {
                    this.f22249f.finish();
                } else {
                    this.f22248e.dismiss();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f22250e;

        public e(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22250e = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22250e.mPreViewPickCoverView.setVisibility(0);
                int height = this.f22250e.mNavigationBar.getHeight();
                int height2 = this.f22250e.mPreViewPickCoverView.getHeight();
                int i2 = d.a.c.e.p.l.i(this.f22250e.getPageContext().getPageActivity());
                float k = d.a.c.e.p.l.k(this.f22250e.getPageContext().getPageActivity()) * this.f22250e.mRatio;
                this.f22250e.mPreviewHeight = (i2 - height) - height2;
                float k2 = (this.f22250e.mPreviewHeight * 1.0f) / d.a.c.e.p.l.k(this.f22250e.getPageContext().getPageActivity());
                TbEditVideoActivity tbEditVideoActivity = this.f22250e;
                tbEditVideoActivity.mTranslateY = height - ((i2 - tbEditVideoActivity.mPreviewHeight) * 0.5f);
                this.f22250e.mEditPreviewContainer.setTranslationY(this.f22250e.mTranslateY);
                if (this.f22250e.mRatio > k2) {
                    this.f22250e.mPreviewView.setScaleX(this.f22250e.mPreviewHeight / k);
                    this.f22250e.mPreviewView.setScaleY(this.f22250e.mPreviewHeight / k);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f22251e;

        /* loaded from: classes5.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f22252e;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f22252e = fVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    this.f22252e.f22251e.mPreViewPickCoverView.setVisibility(0);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f22253e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f22254f;

            public b(f fVar, float f2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, Float.valueOf(f2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f22254f = fVar;
                this.f22253e = f2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    this.f22254f.f22251e.mPreviewView.setScaleX(floatValue / this.f22253e);
                    this.f22254f.f22251e.mPreviewView.setScaleY(floatValue / this.f22253e);
                }
            }
        }

        public f(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22251e = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f22251e.mPreViewPickCoverView, "translationY", this.f22251e.mPreViewPickCoverView.getHeight(), 0.0f);
                ofFloat.setDuration(250L);
                ofFloat.addListener(new a(this));
                int height = this.f22251e.mNavigationBar.getHeight();
                int height2 = this.f22251e.mPreViewPickCoverView.getHeight();
                int i2 = d.a.c.e.p.l.i(this.f22251e.getPageContext().getPageActivity());
                float k = d.a.c.e.p.l.k(this.f22251e.getPageContext().getPageActivity()) * this.f22251e.mRatio;
                this.f22251e.mPreviewHeight = (i2 - height) - height2;
                float k2 = (this.f22251e.mPreviewHeight * 1.0f) / d.a.c.e.p.l.k(this.f22251e.getPageContext().getPageActivity());
                TbEditVideoActivity tbEditVideoActivity = this.f22251e;
                tbEditVideoActivity.mTranslateY = height - ((i2 - tbEditVideoActivity.mPreviewHeight) * 0.5f);
                ObjectAnimator duration = ObjectAnimator.ofFloat(this.f22251e.mEditPreviewContainer, "translationY", 0.0f, this.f22251e.mTranslateY).setDuration(250L);
                if (this.f22251e.mRatio > k2) {
                    ValueAnimator ofFloat2 = ValueAnimator.ofFloat(k, this.f22251e.mPreviewHeight);
                    ofFloat2.addUpdateListener(new b(this, k));
                    ofFloat2.setDuration(250L);
                    ofFloat2.start();
                }
                ofFloat.start();
                duration.start();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f22255e;

        /* loaded from: classes5.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ g f22256e;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f22256e = gVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    this.f22256e.f22255e.mPreViewPickCoverView.setVisibility(8);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f22257e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ g f22258f;

            public b(g gVar, float f2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, Float.valueOf(f2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f22258f = gVar;
                this.f22257e = f2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    this.f22258f.f22255e.mPreviewView.setScaleX(floatValue / this.f22257e);
                    this.f22258f.f22255e.mPreviewView.setScaleY(floatValue / this.f22257e);
                }
            }
        }

        public g(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22255e = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f22255e.mPreViewPickCoverView, "translationY", 0.0f, this.f22255e.mPreViewPickCoverView.getHeight());
                ofFloat.setDuration(250L);
                ofFloat.addListener(new a(this));
                int height = this.f22255e.mNavigationBar.getHeight();
                int height2 = this.f22255e.mPreViewPickCoverView.getHeight();
                int i2 = d.a.c.e.p.l.i(this.f22255e.getPageContext().getPageActivity());
                float k = d.a.c.e.p.l.k(this.f22255e.getPageContext().getPageActivity()) * this.f22255e.mRatio;
                this.f22255e.mPreviewHeight = (i2 - height) - height2;
                float k2 = (this.f22255e.mPreviewHeight * 1.0f) / d.a.c.e.p.l.k(this.f22255e.getPageContext().getPageActivity());
                TbEditVideoActivity tbEditVideoActivity = this.f22255e;
                tbEditVideoActivity.mTranslateY = height - ((i2 - tbEditVideoActivity.mPreviewHeight) * 0.5f);
                ObjectAnimator duration = ObjectAnimator.ofFloat(this.f22255e.mEditPreviewContainer, "translationY", 0.0f, this.f22255e.mTranslateY).setDuration(250L);
                if (this.f22255e.mRatio > k2) {
                    ValueAnimator ofFloat2 = ValueAnimator.ofFloat(k, this.f22255e.mPreviewHeight);
                    ofFloat2.addUpdateListener(new b(this, k));
                    ofFloat2.setDuration(250L);
                    ofFloat2.reverse();
                }
                ofFloat.start();
                duration.reverse();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f22259e;

        public h(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22259e = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22259e.mVideoControllerLayout.setMusicName(this.f22259e.mCurrentMusicData.title, this.f22259e.mCurrentMusicData.icon);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f22260e;

        public i(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22260e = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22260e.mFilterName.setVisibility(8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements RecordPreviewContainer.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f22261a;

        public j(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22261a = tbEditVideoActivity;
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void a(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) && this.f22261a.mModeType == 1 && this.f22261a.mFilterManager != null) {
                this.f22261a.mFilterManager.g();
                String currentFilterName = this.f22261a.mVideoControllerLayout.getCurrentFilterName();
                if (StringUtils.isNull(currentFilterName)) {
                    return;
                }
                this.f22261a.mFilterName.removeCallbacks(this.f22261a.hideFilterName);
                this.f22261a.mFilterName.setText(currentFilterName);
                this.f22261a.mFilterName.setVisibility(0);
                this.f22261a.mFilterName.postDelayed(this.f22261a.hideFilterName, 800L);
            }
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void b(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent) == null) && this.f22261a.mModeType == 1 && this.f22261a.mFilterManager != null) {
                this.f22261a.mFilterManager.e();
                String currentFilterName = this.f22261a.mVideoControllerLayout.getCurrentFilterName();
                if (StringUtils.isNull(currentFilterName)) {
                    return;
                }
                this.f22261a.mFilterName.removeCallbacks(this.f22261a.hideFilterName);
                this.f22261a.mFilterName.setText(currentFilterName);
                this.f22261a.mFilterName.setVisibility(0);
                this.f22261a.mFilterName.postDelayed(this.f22261a.hideFilterName, 800L);
            }
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void c(MotionEvent motionEvent, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.f22261a.resetEffectIcon();
                if (this.f22261a.mVideoControllerLayout == null || !this.f22261a.mVideoControllerLayout.p()) {
                    return;
                }
                this.f22261a.mVideoControllerLayout.m(null, false);
            }
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void d(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
                this.f22261a.resetEffectIcon();
                if (this.f22261a.mVideoControllerLayout == null || !this.f22261a.mVideoControllerLayout.p()) {
                    return;
                }
                this.f22261a.mVideoControllerLayout.m(null, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f22262a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(TbEditVideoActivity tbEditVideoActivity, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22262a = tbEditVideoActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ResponseGetQmFiltersMessage)) {
                List<QmFilterItem> filterItems = httpResponsedMessage.getError() == 0 ? ((ResponseGetQmFiltersMessage) httpResponsedMessage).getFilterItems() : null;
                if (this.f22262a.mVideoControllerLayout != null) {
                    if (filterItems == null) {
                        filterItems = new ArrayList<>();
                    }
                    QmFilterItem qmFilterItem = new QmFilterItem();
                    qmFilterItem.id = "-1";
                    qmFilterItem.bgurl = R.drawable.icon_pure_video_lvjing_on + "";
                    qmFilterItem.name = this.f22262a.getResources().getString(R.string.filter_nature);
                    qmFilterItem.isSelect = true;
                    qmFilterItem.localPath = FilterValue.DEFAULT_FILTER_VALUE;
                    filterItems.add(0, qmFilterItem);
                    this.f22262a.mVideoControllerLayout.setFilterData(filterItems);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f22263a;

        public l(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22263a = tbEditVideoActivity;
        }

        @Override // d.a.s0.n0.b.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.f22263a.mVideoControllerLayout != null) {
                    QmFilterItem qmFilterItem = new QmFilterItem();
                    qmFilterItem.id = "-1";
                    qmFilterItem.bgurl = R.drawable.icon_pure_video_lvjing_on + "";
                    qmFilterItem.name = this.f22263a.getResources().getString(R.string.filter_nature);
                    qmFilterItem.isSelect = true;
                    qmFilterItem.localPath = FilterValue.DEFAULT_FILTER_VALUE;
                    this.f22263a.mVideoControllerLayout.y(qmFilterItem);
                    if (this.f22263a.mFilterManager != null) {
                        this.f22263a.mFilterManager.a(null);
                    }
                    this.f22263a.mVideoControllerLayout.setDownLoadFilter(null);
                }
                if (StringUtils.isNull(str)) {
                    str = this.f22263a.getResources().getString(R.string.sticker_download_error);
                }
                this.f22263a.showToast(str);
            }
        }

        @Override // d.a.s0.n0.b.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f22263a.mVideoControllerLayout == null) {
                return;
            }
            this.f22263a.mVideoControllerLayout.setDownLoadFilter(null);
        }

        @Override // d.a.s0.n0.b.a.b
        public void c(QmFilterItem qmFilterItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qmFilterItem) == null) {
                if (this.f22263a.mFilterManager != null) {
                    this.f22263a.mFilterManager.a(qmFilterItem);
                }
                if (this.f22263a.mVideoControllerLayout != null) {
                    this.f22263a.mVideoControllerLayout.setDownLoadFilter(null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements RecordEffectLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f22264a;

        public m(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22264a = tbEditVideoActivity;
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void a(QmStickerItem qmStickerItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, qmStickerItem) == null) {
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void b(d.a.s0.z3.m.e.c.b bVar, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, obj) == null) || bVar == null) {
                return;
            }
            int c2 = bVar.c();
            if (c2 == 2) {
                if (this.f22264a.mFilterManager != null && (bVar.d() instanceof QmFilterItem)) {
                    QmFilterItem qmFilterItem = (QmFilterItem) bVar.d();
                    String f2 = this.f22264a.mFilterManager.f(qmFilterItem.fileUrl);
                    if (StringUtils.isNull(f2) && !"-1".equals(qmFilterItem.id)) {
                        if (this.f22264a.mVideoControllerLayout != null) {
                            this.f22264a.mVideoControllerLayout.setDownLoadFilter(qmFilterItem);
                        }
                        this.f22264a.mFilterManager.c(qmFilterItem);
                    } else {
                        qmFilterItem.localPath = f2;
                        this.f22264a.mFilterManager.a(qmFilterItem);
                        if (this.f22264a.mVideoControllerLayout != null) {
                            this.f22264a.mVideoControllerLayout.setDownLoadFilter(null);
                        }
                    }
                    this.f22264a.isEdited = true;
                }
            } else if (c2 == 3 && (bVar.d() instanceof MusicData)) {
                MusicData musicData = (MusicData) bVar.d();
                TbMusicData tbMusicData = new TbMusicData();
                tbMusicData.id = musicData.id;
                tbMusicData.title = musicData.name;
                tbMusicData.url = musicData.resource;
                tbMusicData.icon = musicData.img;
                tbMusicData.type = d.a.c.e.m.b.d(musicData.type, 1);
                if (MusicData.MUSIC_NORMAL_ID.equals(musicData.id) || MusicData.MUSIC_CLOUD_ID.equals(musicData.id)) {
                    this.f22264a.mMusicManager.d(this.f22264a.mCurrentMusicData);
                    this.f22264a.mCurrentMusicData = tbMusicData;
                    if (!MusicData.MUSIC_CLOUD_ID.equals(musicData.id)) {
                        this.f22264a.mVideoControllerLayout.setMusicName(this.f22264a.mCurrentMusicData.title, "");
                    }
                } else {
                    this.f22264a.mCurrentMusicData = tbMusicData;
                    this.f22264a.mMusicManager.d(this.f22264a.mCurrentMusicData);
                    this.f22264a.mVideoControllerLayout.setMusicName(this.f22264a.mCurrentMusicData.title, "");
                }
                if (!MusicData.MUSIC_CLOUD_ID.equals(musicData.id)) {
                    this.f22264a.mVideoControllerLayout.setMusicName(this.f22264a.mCurrentMusicData.title, "");
                }
                this.f22264a.mMusicManager.b((MusicData) bVar.d(), obj);
                this.f22264a.isEdited = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f22265e;

        public n(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22265e = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22265e.mModeType == 1) {
                return;
            }
            this.f22265e.pauseVideo();
        }
    }

    /* loaded from: classes5.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f22266e;

        public o(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22266e = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f22266e.mFilterManager == null || this.f22266e.mFilterManager.b() == null) {
                return;
            }
            this.f22266e.mEditManager.a(this.f22266e.mFilterManager.b());
        }
    }

    /* loaded from: classes5.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f22267e;

        public p(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22267e = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TbEditVideoActivity tbEditVideoActivity = this.f22267e;
                tbEditVideoActivity.showToast(tbEditVideoActivity.getString(R.string.edit_video_cover_save_success));
            }
        }
    }

    public TbEditVideoActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isEdited = false;
        this.onSaving = false;
        this.mModeType = 1;
        this.needShowCoverToast = false;
        this.mPreviewHeight = d.a.c.e.p.l.i(getPageContext().getPageActivity());
        this.mTranslateY = 0.0f;
        this.mEditMergeCallBack = new a(this);
        this.hideFilterName = new i(this);
        this.mEditPreviewGestureListener = new j(this);
        this.mGetQmFiltersListener = new k(this, CmdConfigHttp.CMD_GET_QM_FILTERS, true);
        this.mGetFilterCallback = new l(this);
        this.mEditOnEffectChoosedListener = new m(this);
    }

    private void backDialogShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            if (this.isEdited) {
                d.a.r0.r.s.j jVar = new d.a.r0.r.s.j(getPageContext(), new d.a.r0.r.s.l(getPageContext().getPageActivity()));
                jVar.i(getResources().getString(R.string.edit_video_back_dialog_title), new String[]{getResources().getString(R.string.quit)}, new d(this, jVar));
                jVar.l();
                return;
            }
            finish();
        }
    }

    private void changeToPureCoverMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            d.a.s0.n0.a.a aVar = this.mCoverManager;
            if (aVar != null) {
                aVar.i(this.mLastCoverPercent);
            }
            this.mTitle.setVisibility(0);
            this.mRight.setVisibility(0);
            this.mPreViewPickCoverView.post(new e(this));
            this.mEditRightContainer.setVisibility(8);
            this.mEditSaveContainer.setVisibility(8);
            this.mEditPreviewPublish.setVisibility(8);
            SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0611, 0);
        }
    }

    private void enterClipMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            this.mNavigationBar.setVisibility(8);
            this.mEditRightContainer.setVisibility(8);
            this.mEditSaveContainer.setVisibility(8);
            this.mEditPreviewPublish.setVisibility(8);
        }
    }

    private void exitClipMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            this.mNavigationBar.setVisibility(0);
            this.mEditRightContainer.setVisibility(0);
            this.mEditSaveContainer.setVisibility(0);
            this.mEditPreviewPublish.setVisibility(0);
        }
    }

    private d.a.s0.f0.b.b getCurrentPublishMuxerData() {
        InterceptResult invokeV;
        d.a.s0.n0.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, this)) == null) {
            d.a.s0.f0.b.b bVar = new d.a.s0.f0.b.b();
            TbMultiMediaData tbMultiMediaData = this.mMultiMediaData;
            if (tbMultiMediaData != null) {
                bVar.j(tbMultiMediaData);
                bVar.n(this.mRatio);
            }
            d.a.s0.n0.b.b bVar2 = this.mFilterManager;
            if (bVar2 != null && bVar2.b() != null) {
                QmFilterItem b2 = this.mFilterManager.b();
                float f2 = 0.0f;
                String str = b2.localPath;
                Filter filter = new Filter();
                if (!StringUtils.isNull(str) && !FilterValue.DEFAULT_FILTER_VALUE.equals(str)) {
                    f2 = (d.a.c.e.m.b.c(b2.effect, 100.0f) * 1.0f) / 100.0f;
                    filter.setDataType(1);
                    filter.setLevel(f2);
                    filter.setFile(new File(b2.localPath));
                }
                TbFilterValue tbFilterValue = new TbFilterValue();
                tbFilterValue.setId(b2.id);
                tbFilterValue.setLevel(f2);
                tbFilterValue.setName(b2.name);
                tbFilterValue.setFilterType(2);
                tbFilterValue.setFilterPath(str);
                tbFilterValue.mFilter = filter;
                tbFilterValue.mComplex = d.a.c.e.m.b.d(b2.complex, 0);
                tbFilterValue.mRootFilePath = str;
                bVar.h(tbFilterValue);
            }
            d.a.s0.f0.a.a aVar2 = this.mEditManager;
            if (aVar2 != null) {
                bVar.i(aVar2.getMediaTrackConfig());
            }
            TbMusicData tbMusicData = this.mCurrentMusicData;
            if (tbMusicData != null && (aVar = this.mMusicManager) != null) {
                tbMusicData.localPath = aVar.a();
                bVar.k(this.mCurrentMusicData);
            }
            bVar.m(this.mPreviewView.getWidth());
            bVar.l(this.mPreviewView.getHeight());
            return bVar;
        }
        return (d.a.s0.f0.b.b) invokeV.objValue;
    }

    private void hideCoverModeAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            this.mModeType = 1;
            SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0105, 0);
            this.mTitle.setVisibility(8);
            this.mRight.setVisibility(8);
            d.a.c.e.m.e.a().post(new g(this));
            this.mEditRightContainer.setVisibility(0);
            this.mEditSaveContainer.setVisibility(0);
            this.mEditPreviewPublish.setVisibility(0);
        }
    }

    private void initManager() {
        TbMusicData tbMusicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            this.mPreviewView = (TbGLMediaPreviewView) findViewById(R.id.edit_preview_view);
            this.mPreViewPickCoverView = (PreViewPickCoverView) findViewById(R.id.pick_cover_view);
            d.a.s0.n0.a.d dVar = new d.a.s0.n0.a.d(getPageContext(), this.mPreviewView, this.mPreViewPickCoverView, this.mMultiMediaData);
            this.mCoverManager = dVar;
            dVar.d(this);
            this.needShowCoverToast = false;
            if (TextUtils.isEmpty(this.mCoverPath)) {
                this.mPreviewView.post(new c(this));
            }
            d.a.s0.f0.a.b bVar = new d.a.s0.f0.a.b(getPageContext(), this.mPreviewView, this.mMultiMediaData, this.mCoverManager);
            this.mEditManager = bVar;
            bVar.d(this.mRatio);
            this.mVideoControllerLayout = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
            d.a.s0.n0.c.c cVar = new d.a.s0.n0.c.c(getPageContext(), this.mVideoControllerLayout);
            this.mMusicManager = cVar;
            this.mVideoControllerLayout.setMusicManager(cVar);
            if (this.mMusicManager != null && (tbMusicData = this.mCurrentMusicData) != null && !TextUtils.isEmpty(tbMusicData.localPath) && !TextUtils.isEmpty(this.mCurrentMusicData.id)) {
                TbMusicData tbMusicData2 = this.mCurrentMusicData;
                if (tbMusicData2.type == 2) {
                    this.mVideoControllerLayout.setEffectLayoutCurrentMusicName(getResources().getString(R.string.music_cloud));
                } else {
                    this.mVideoControllerLayout.setEffectLayoutCurrentMusicName(tbMusicData2.title);
                }
                d.a.s0.n0.c.a aVar = this.mMusicManager;
                TbMusicData tbMusicData3 = this.mCurrentMusicData;
                aVar.e(tbMusicData3.localPath, tbMusicData3.id);
                this.mVideoControllerLayout.setMusicName(this.mCurrentMusicData.title, "");
            }
            d.a.s0.n0.b.a aVar2 = new d.a.s0.n0.b.a(null, this.mEditManager, this.mVideoControllerLayout);
            this.mFilterManager = aVar2;
            aVar2.d(this.mGetFilterCallback);
            this.mFilterManager.h();
            this.mVideoControllerLayout.setEditManager(this.mEditManager);
            this.mMuxerManager = new d.a.s0.f0.b.c(getPageContext(), this.mEditMergeCallBack);
            loadFilter();
        }
    }

    private void initView() {
        d.a.s0.n0.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65575, this) == null) {
            this.mRootView = (ViewGroup) findViewById(R.id.root_view);
            this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.mFilterName = (TextView) findViewById(R.id.edit_left_current_filter_name);
            this.mEditFilter = (ImageView) findViewById(R.id.capture_right_filter);
            this.mEditMusic = (ImageView) findViewById(R.id.capture_right_music);
            this.mEditPreviewPublish = (TextView) findViewById(R.id.edit_preview_publish);
            this.mEditSaveContainer = (RelativeLayout) findViewById(R.id.edit_preview_save_container);
            this.mEditRightContainer = (LinearLayout) findViewById(R.id.capture_right_container);
            this.mCaptureFilterContainer = (RelativeLayout) findViewById(R.id.capture_right_filter_container);
            this.mCaptureMusicContainer = (RelativeLayout) findViewById(R.id.capture_right_music_container);
            this.mCaptureCoverContainer = (RelativeLayout) findViewById(R.id.capture_right_cover_container);
            this.mPreViewPickCoverView.setVisibility(4);
            RecordPreviewContainer recordPreviewContainer = (RecordPreviewContainer) findViewById(R.id.edit_preview_container);
            this.mEditPreviewContainer = recordPreviewContainer;
            recordPreviewContainer.setOnViewClickListener(this.mEditPreviewGestureListener);
            TextView centerTextTitle = this.mNavigationBar.setCenterTextTitle(getString(R.string.pick_cover_activity_title));
            this.mTitle = centerTextTitle;
            centerTextTitle.setTextColor(getResources().getColor(R.color.CAM_X0101));
            this.mTitle.setVisibility(8);
            View addSystemImageButton = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mLeft = addSystemImageButton;
            ((ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button)).setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_topbar_return44));
            TextView addTextButton = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.save));
            this.mRight = addTextButton;
            addTextButton.setTextColor(getResources().getColor(R.color.CAM_X0101));
            this.mRight.setVisibility(8);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.capture_right_edit_container);
            this.mEditEditerContainer = relativeLayout;
            int i2 = this.mVideoFrom;
            boolean z = false;
            if (i2 == 1) {
                relativeLayout.setVisibility(8);
            } else if (i2 == 2) {
                relativeLayout.setVisibility(0);
            }
            if (this.mVideoControllerLayout.getRecrodButton() != null) {
                this.mVideoControllerLayout.getRecrodButton().setVisibility(8);
            }
            this.mVideoControllerLayout.setEffectChoosedListener(this.mEditOnEffectChoosedListener);
            this.mLeft.setOnClickListener(this);
            this.mRight.setOnClickListener(this);
            this.mPreViewPickCoverView.setOnClickListener(this);
            this.mEditPreviewPublish.setOnClickListener(this);
            this.mEditSaveContainer.setOnClickListener(this);
            this.mEditEditerContainer.setOnClickListener(this);
            this.mCaptureFilterContainer.setOnClickListener(this);
            this.mCaptureMusicContainer.setOnClickListener(this);
            this.mCaptureCoverContainer.setOnClickListener(this);
            d.a.r0.r.u.c d2 = d.a.r0.r.u.c.d(this.mFilterName);
            d2.y(R.string.F_X02);
            d2.w(R.array.S_O_X001);
            d.a.r0.r.u.c d3 = d.a.r0.r.u.c.d(findViewById(R.id.edit_preview_publish));
            d3.n(R.string.J_X01);
            d3.f(R.color.CAM_X0302);
            d.a.r0.r.u.c.d(findViewById(R.id.edit_preview_save_text)).w(R.array.S_O_X001);
            TbMultiMediaData tbMultiMediaData = this.mMultiMediaData;
            if (tbMultiMediaData != null && tbMultiMediaData.coverSource == 2) {
                z = true;
            }
            if (z) {
                this.mPreViewPickCoverView.setCurrentMode(2);
            }
            if (this.mModeType == 3) {
                if (z && !StringUtils.isNull(this.mOrignalCoverPath) && (aVar = this.mCoverManager) != null) {
                    aVar.l(this.mOrignalCoverPath);
                }
                changeToPureCoverMode();
            }
        }
    }

    private void jumpToAlbumActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            WriteData writeData = new WriteData();
            new FrsTabInfoData();
            new PostPrefixData();
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), writeImagesInfo.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", writeData.getForumId());
            albumFloatActivityConfig.getIntent().putExtra("forum_name", writeData.getForumName());
            albumFloatActivityConfig.getIntent().putExtra("from", AlbumActivityConfig.FROM_WRITE);
            albumFloatActivityConfig.setRequestCode(PlayerPostEvent.MEDIA_REP_CHANGE_END);
            albumFloatActivityConfig.setAlbumThread(0);
            albumFloatActivityConfig.setCanSelectVideo(false);
            albumFloatActivityConfig.setCanSelectGif(false);
            albumFloatActivityConfig.setCanEditImage(false);
            albumFloatActivityConfig.setNeedClipImage(true);
            albumFloatActivityConfig.setImageClipType(this.mRatio > 1.0f ? 2 : 1);
            albumFloatActivityConfig.setAlbumShowCapture(false);
            albumFloatActivityConfig.setAlbumDirectDoneOnlyOne(true);
            sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }
    }

    private void loadFilter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_QM_FILTERS);
            httpMessage.addParam("uh", Build.MANUFACTURER + "," + Build.HARDWARE + "," + Build.BOARD + "," + (d.a.s0.u3.d.b(this) ? 1 : 0));
            httpMessage.addParam("ut", Build.MODEL + "_" + Build.VERSION.RELEASE + "_" + d.a.s0.u3.d.a() + "_" + Build.BRAND.replace("_", ""));
            StringBuilder sb = new StringBuilder();
            sb.append(d.a.c0.a.b.i());
            sb.append("");
            httpMessage.addParam(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, sb.toString());
            sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            d.a.s0.f0.a.a aVar = this.mEditManager;
            if (aVar != null) {
                aVar.pause();
            }
            d.a.s0.n0.c.a aVar2 = this.mMusicManager;
            if (aVar2 != null) {
                aVar2.onPause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetEffectIcon() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65579, this) == null) {
            this.mEditFilter.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_lvjing40));
            this.mEditMusic.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_music40));
        }
    }

    private void showCoverModeAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65580, this) == null) {
            this.mModeType = 2;
            SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0611, 0);
            resetEffectIcon();
            VideoControllerLayout videoControllerLayout = this.mVideoControllerLayout;
            if (videoControllerLayout != null && videoControllerLayout.p()) {
                this.mVideoControllerLayout.m(null, false);
            }
            this.mTitle.setVisibility(0);
            this.mRight.setVisibility(0);
            d.a.c.e.m.e.a().post(new f(this));
            this.mEditRightContainer.setVisibility(8);
            this.mEditSaveContainer.setVisibility(8);
            this.mEditPreviewPublish.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        d.a.s0.n0.a.a aVar;
        TbMultiMediaData tbMultiMediaData;
        TbMultiMediaData tbMultiMediaData2;
        d.a.s0.n0.a.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, intent) == null) {
            if (intent == null) {
                if (this.mPreViewPickCoverView.getCurrentMode() != 2 || i2 != 12002 || (aVar2 = this.mCoverManager) == null || aVar2.n()) {
                    return;
                }
                this.mPreViewPickCoverView.setCurrentMode(1);
                this.mCoverManager.k();
            } else if (i2 == 25032) {
                if (i3 != -1) {
                    return;
                }
                String stringExtra = intent.getStringExtra(CloudMusicActivityConfig.MUSIC_ID);
                TbMusicData tbMusicData = (TbMusicData) intent.getSerializableExtra(CloudMusicActivityConfig.MUSIC_DATA);
                if (tbMusicData != null) {
                    this.mCurrentMusicData = tbMusicData;
                    if (TextUtils.isEmpty(tbMusicData.localPath) || TextUtils.isEmpty(stringExtra)) {
                        return;
                    }
                    String str = tbMusicData.localPath;
                    if (this.mMusicManager == null || TextUtils.isEmpty(str)) {
                        return;
                    }
                    this.mMusicManager.e(str, stringExtra);
                    this.mVideoControllerLayout.x(tbMusicData);
                }
            } else if (i2 != 25062) {
                if (i2 == 12002 && i3 == -1) {
                    String stringExtra2 = intent.getStringExtra(VideoCoverSelectActivityConfig.KEY_VIDEO_COVER_IMAGE_PATH);
                    if (TextUtils.isEmpty(stringExtra2) || (aVar = this.mCoverManager) == null) {
                        return;
                    }
                    aVar.l(stringExtra2);
                    this.mOrignalCoverPath = stringExtra2;
                }
            } else {
                d.a.s0.u3.g.d(intent, this.mPreviewView);
                if (i3 == -1 && (tbMultiMediaData = (TbMultiMediaData) intent.getParcelableExtra(TbEditVideoActivityConfig.KEY_EDIT_VIDEO_DATA)) != null && this.mEditManager != null && (tbMultiMediaData2 = this.mMultiMediaData) != null && (tbMultiMediaData.start != tbMultiMediaData2.start || tbMultiMediaData.end != tbMultiMediaData2.end)) {
                    this.mMultiMediaData = tbMultiMediaData;
                    this.mEditManager.b(tbMultiMediaData);
                    this.mVideoControllerLayout.post(new o(this));
                    this.isEdited = true;
                }
                exitClipMode();
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        d.a.s0.n0.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.mModeType == 2) {
                if (this.mPreViewPickCoverView.getCurrentMode() == 2 && (aVar = this.mCoverManager) != null) {
                    aVar.k();
                }
                d.a.s0.n0.a.a aVar2 = this.mCoverManager;
                if (aVar2 != null) {
                    aVar2.reset();
                }
                d.a.s0.f0.a.a aVar3 = this.mEditManager;
                if (aVar3 != null) {
                    aVar3.start();
                }
                d.a.s0.n0.c.a aVar4 = this.mMusicManager;
                if (aVar4 != null) {
                    aVar4.onResume();
                }
                hideCoverModeAnim();
                return;
            }
            backDialogShow();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.s0.n0.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            super.onClick(view);
            if (view.getId() == R.id.capture_right_filter_container) {
                resetEffectIcon();
                if (this.mVideoControllerLayout.q()) {
                    this.mEditFilter.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_lvjing40));
                } else {
                    this.mEditFilter.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_lvjing_s44));
                }
                this.mVideoControllerLayout.u();
                if (this.mVideoControllerLayout.s()) {
                    loadFilter();
                }
            } else if (view.getId() == R.id.capture_right_music_container) {
                resetEffectIcon();
                if (this.mVideoControllerLayout.r()) {
                    this.mEditMusic.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_music40));
                } else {
                    this.mEditMusic.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_music_s44));
                }
                this.mVideoControllerLayout.v();
                TbMusicData tbMusicData = this.mCurrentMusicData;
                if (tbMusicData == null || tbMusicData.type != 2) {
                    return;
                }
                this.mVideoControllerLayout.postDelayed(new h(this), 300L);
            } else if (view.getId() == R.id.capture_right_edit_container) {
                TbFileVideoActivityConfig tbFileVideoActivityConfig = new TbFileVideoActivityConfig(getPageContext().getPageActivity());
                tbFileVideoActivityConfig.setForResult();
                tbFileVideoActivityConfig.setFrom(2);
                tbFileVideoActivityConfig.setTbMultiMediaData(this.mMultiMediaData);
                d.a.s0.n0.b.b bVar = this.mFilterManager;
                if (bVar != null && bVar.b() != null) {
                    tbFileVideoActivityConfig.setFilter(this.mFilterManager.b());
                }
                tbFileVideoActivityConfig.setEnterAnimValues(d.a.s0.u3.g.a(this.mPreviewView));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbFileVideoActivityConfig));
                enterClipMode();
            } else if (view.getId() == R.id.capture_right_cover_container) {
                d.a.s0.n0.a.a aVar2 = this.mCoverManager;
                if (aVar2 != null) {
                    aVar2.i(this.mLastCoverPercent);
                    pauseVideo();
                    if (this.mPreViewPickCoverView.getCurrentMode() == 2 && !StringUtils.isNull(this.mOrignalCoverPath)) {
                        this.mCoverManager.l(this.mOrignalCoverPath);
                    } else {
                        this.mPreViewPickCoverView.setCurrentMode(1);
                    }
                    showCoverModeAnim();
                }
                d.a.r0.r.d0.b.j().t("key_edit_video_pick_cover_tip_show", true);
            } else if (view.getId() == R.id.edit_preview_save_container) {
                if (this.mMuxerManager != null) {
                    this.onSaving = true;
                    pauseVideo();
                    this.mMuxerManager.a(getCurrentPublishMuxerData());
                }
            } else if (view.getId() == R.id.edit_preview_publish) {
                if (!d.a.r0.r.d0.b.j().g("key_edit_video_pick_cover_tip_show", false)) {
                    d.a.s0.e0.e eVar = new d.a.s0.e0.e(getPageContext(), this.mCaptureCoverContainer);
                    eVar.g0(R.drawable.pic_sign_tip_right);
                    eVar.L(1);
                    eVar.h0(true);
                    eVar.X(R.color.CAM_X0101);
                    eVar.e0(R.dimen.T_X08);
                    eVar.P(R.dimen.T_X08);
                    eVar.a0(UtilHelper.getDimenPixelSize(R.dimen.tbds26));
                    eVar.d0(UtilHelper.getDimenPixelSize(R.dimen.tbds26));
                    eVar.l0(getResources().getString(R.string.edit_video_cover_tips));
                    d.a.r0.r.d0.b.j().t("key_edit_video_pick_cover_tip_show", true);
                    return;
                }
                pauseVideo();
                this.mMuxerManager.a(getCurrentPublishMuxerData());
                VideoFileInfo c2 = d.a.s0.u3.c.c(this.mMultiMediaData.path);
                if (c2 == null) {
                    return;
                }
                VideoInfo videoInfo = new VideoInfo();
                this.mVideoInfo = videoInfo;
                videoInfo.setVideoPath(this.mMultiMediaData.path);
                this.mVideoInfo.setThumbPath(this.mCoverPath);
                this.mVideoInfo.setVideoDuration((int) (c2.videoDuration / 1000.0f));
                this.mVideoInfo.setVideoWidth(c2.videoWidth);
                this.mVideoInfo.setVideoHeight(c2.videoHeight);
                this.mVideoInfo.setVideoLength(new File(this.mMultiMediaData.path).length());
                this.mVideoInfo.setVideoType(2);
                this.mVideoInfo.setIsCompressedVideo(true);
                EditVideoData editVideoData = new EditVideoData();
                if (StringUtils.isNull(this.mCoverPath)) {
                    editVideoData.coverPath = d.a.s0.v3.c.f68589b;
                } else {
                    editVideoData.coverPath = this.mCoverPath;
                }
                editVideoData.originPath = this.mVideoInfo.getVideoPath();
                this.mVideoInfo.setEditVideoData(editVideoData);
                this.mMultiMediaData.coverSource = this.mPreViewPickCoverView.getCurrentMode();
                TbMultiMediaData tbMultiMediaData = this.mMultiMediaData;
                tbMultiMediaData.coverPath = this.mCoverPath;
                tbMultiMediaData.orignalCoverPath = this.mOrignalCoverPath;
                this.mVideoInfo.setMultiMediaData(tbMultiMediaData);
                WriteActivityConfig newInstance = WriteActivityConfig.newInstance(getPageContext().getPageActivity());
                newInstance.getIntent().putExtras(getIntent());
                newInstance.getIntent().setFlags(536870912);
                newInstance.getIntent().setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                newInstance.setType(9).setVideoInfo(this.mVideoInfo).setNeedClosePrePage(true).send();
                finish();
            } else if (view == this.mLeft) {
                onBackPressed();
            } else if (view == this.mRight) {
                int i2 = this.mModeType;
                if (i2 == 2) {
                    d.a.s0.n0.a.a aVar3 = this.mCoverManager;
                    if (aVar3 != null) {
                        this.needShowCoverToast = true;
                        aVar3.f();
                    }
                    hideCoverModeAnim();
                } else if (i2 != 3 || (aVar = this.mCoverManager) == null) {
                } else {
                    this.needShowCoverToast = true;
                    aVar.f();
                }
            } else if (view.getId() == this.mPreViewPickCoverView.getVideoPick().getId()) {
                if (this.mPreViewPickCoverView.getCurrentMode() != 1) {
                    this.mPreViewPickCoverView.setCurrentMode(1);
                    d.a.s0.n0.a.a aVar4 = this.mCoverManager;
                    if (aVar4 != null) {
                        aVar4.k();
                    }
                }
            } else if (view.getId() == this.mPreViewPickCoverView.getImagePick().getId()) {
                if (this.mPreViewPickCoverView.getCurrentMode() != 2) {
                    this.mPreViewPickCoverView.setCurrentMode(2);
                    jumpToAlbumActivity();
                }
            } else if (view.getId() == this.mPreViewPickCoverView.getCoverImageView().getId() && this.mPreViewPickCoverView.getCurrentMode() == 2) {
                jumpToAlbumActivity();
            }
        }
    }

    @Override // d.a.s0.n0.a.b
    public void onCoverPathCallBack(String str) {
        d.a.s0.n0.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || StringUtils.isNull(str) || str.equals(this.mCoverPath)) {
            return;
        }
        d.a.s0.n0.a.a aVar2 = this.mCoverManager;
        if (aVar2 != null) {
            this.mLastCoverPercent = aVar2.o();
        }
        this.mCoverPath = str;
        if (this.mPreViewPickCoverView.getCurrentMode() == 2 && (aVar = this.mCoverManager) != null) {
            aVar.k();
        }
        if (this.needShowCoverToast) {
            d.a.c.e.m.e.a().post(new p(this));
            if (this.mModeType != 3) {
                d.a.s0.f0.a.a aVar3 = this.mEditManager;
                if (aVar3 != null) {
                    aVar3.start();
                }
                d.a.s0.n0.c.a aVar4 = this.mMusicManager;
                if (aVar4 != null) {
                    aVar4.onResume();
                }
            }
            this.isEdited = true;
        }
        if (this.mModeType == 3) {
            d.a.c.e.m.e.a().post(new b(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.activity_tb_edit_video);
            setSwipeBackEnabled(false);
            if (getIntent() != null) {
                this.mModeType = getIntent().getIntExtra(TbEditVideoActivityConfig.KEY_EDIT_PAGE_MODE_TYPE, 1);
                this.mMultiMediaData = (TbMultiMediaData) getIntent().getParcelableExtra(TbEditVideoActivityConfig.KEY_EDIT_VIDEO_DATA);
                this.mRatio = getIntent().getFloatExtra(TbEditVideoActivityConfig.KEY_EDIT_VIDEO_RATIO, 0.0f);
                this.mVideoFrom = getIntent().getIntExtra(TbEditVideoActivityConfig.KEY_EDIT_VIDEO_FROM, 0);
                TbMusicData tbMusicData = (TbMusicData) getIntent().getSerializableExtra(TbEditVideoActivityConfig.KEY_EDIT_VIDEO_MUSIC_DATA);
                this.mInitMusicData = tbMusicData;
                this.mCurrentMusicData = tbMusicData;
                TbMultiMediaData tbMultiMediaData = this.mMultiMediaData;
                tbMultiMediaData.videoRatio = this.mRatio;
                this.mCoverPath = tbMultiMediaData.coverPath;
                this.mOrignalCoverPath = tbMultiMediaData.orignalCoverPath;
                this.mLastCoverPercent = tbMultiMediaData.lastCoverPercent;
            }
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_QM_FILTERS, TbConfig.SERVER_ADDRESS + TbConfig.GET_QM_FILTERS);
            tbHttpMessageTask.setResponsedClass(ResponseGetQmFiltersMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            initManager();
            initView();
            registerListener(this.mGetQmFiltersListener);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            d.a.s0.f0.a.a aVar = this.mEditManager;
            if (aVar != null) {
                aVar.onDestroy();
            }
            d.a.s0.n0.c.a aVar2 = this.mMusicManager;
            if (aVar2 != null) {
                aVar2.releasePlayer();
                this.mMusicManager.c();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPause();
            d.a.s0.f0.a.a aVar = this.mEditManager;
            if (aVar != null) {
                aVar.onPause();
            }
            d.a.s0.n0.c.a aVar2 = this.mMusicManager;
            if (aVar2 != null) {
                aVar2.onPause();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        d.a.s0.n0.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            ViewGroup viewGroup = this.mRootView;
            if (viewGroup != null) {
                viewGroup.setSystemUiVisibility(4100);
            }
            d.a.s0.f0.a.a aVar2 = this.mEditManager;
            if (aVar2 != null) {
                aVar2.onResume();
            }
            if (this.mModeType == 1 && (aVar = this.mMusicManager) != null) {
                aVar.onResume();
            }
            d.a.c.e.m.e.a().postDelayed(new n(this), 150L);
            d.a.s0.n0.b.b bVar = this.mFilterManager;
            if (bVar != null) {
                bVar.h();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            super.showLoadingView(view);
            if (getLoadingView() == null || getLoadingView().j() == null) {
                return;
            }
            getLoadingView().j().setVisibility(8);
        }
    }
}
