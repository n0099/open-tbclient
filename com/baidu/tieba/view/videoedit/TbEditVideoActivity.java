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
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.b1.s0;
import c.a.p0.s.s.i;
import c.a.q0.f0.a.a;
import c.a.q0.f0.b.a;
import c.a.q0.o0.b.a;
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
import com.baidu.tbadk.core.atomData.TbEditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.TbFileVideoActivityConfig;
import com.baidu.tbadk.core.atomData.VideoCoverSelectActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.MediaScannerClient;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
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
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.filter.FilterValue;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import com.google.protobuf.CodedInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class TbEditVideoActivity extends BaseActivity<TbEditVideoActivity> implements c.a.q0.o0.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable hideFilterName;
    @NonNull
    public final s0 imageCoverWaiter;
    public boolean isEdited;
    public RelativeLayout mCaptureCoverContainer;
    public RelativeLayout mCaptureFilterContainer;
    public RelativeLayout mCaptureMusicContainer;
    public c.a.q0.o0.a.a mCoverManager;
    public String mCoverPath;
    public TbMusicData mCurrentMusicData;
    public RelativeLayout mEditEditerContainer;
    public ImageView mEditFilter;
    public c.a.q0.f0.a.a mEditManager;
    public a.InterfaceC0832a mEditMergeCallBack;
    public ImageView mEditMusic;
    public RecordEffectLayout.i mEditOnEffectChoosedListener;
    public RecordPreviewContainer mEditPreviewContainer;
    public RecordPreviewContainer.f mEditPreviewGestureListener;
    public TextView mEditPreviewPublish;
    public LinearLayout mEditRightContainer;
    public RelativeLayout mEditSaveContainer;
    public c.a.q0.o0.b.b mFilterManager;
    public TextView mFilterName;
    public a.b mGetFilterCallback;
    public HttpMessageListener mGetQmFiltersListener;
    public TbMusicData mInitMusicData;
    public float mLastCoverPercent;
    public View mLeft;
    public int mModeType;
    public TbMultiMediaData mMultiMediaData;
    public c.a.q0.o0.c.a mMusicManager;
    public c.a.q0.f0.b.a mMuxerManager;
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

    /* loaded from: classes7.dex */
    public class a implements a.InterfaceC0832a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f58264a;

        /* renamed from: com.baidu.tieba.view.videoedit.TbEditVideoActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1801a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomResponsedMessage f58265e;

            public RunnableC1801a(a aVar, CustomResponsedMessage customResponsedMessage) {
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
                this.f58265e = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(this.f58265e);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomResponsedMessage f58266e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f58267f;

            public b(a aVar, CustomResponsedMessage customResponsedMessage) {
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
                this.f58267f = aVar;
                this.f58266e = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(this.f58266e);
                    this.f58267f.f58264a.finish();
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
            this.f58264a = tbEditVideoActivity;
        }

        @Override // c.a.q0.f0.b.a.InterfaceC0832a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TbEditVideoActivity tbEditVideoActivity = this.f58264a;
                tbEditVideoActivity.hideLoadingView(tbEditVideoActivity.mRootView);
            }
        }

        @Override // c.a.q0.f0.b.a.InterfaceC0832a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                TbEditVideoActivity tbEditVideoActivity = this.f58264a;
                tbEditVideoActivity.showLoadingView(tbEditVideoActivity.mRootView);
            }
        }

        @Override // c.a.q0.f0.b.a.InterfaceC0832a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                if (this.f58264a.onSaving) {
                    File file = new File(str);
                    File file2 = new File(c.a.q0.w3.c.f28199g);
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    String str2 = c.a.q0.w3.c.f28199g + file.getName();
                    if (!str2.equals(file.getAbsolutePath())) {
                        FileHelper.copyFile(file.getAbsolutePath(), str2);
                    }
                    new MediaScannerClient(this.f58264a).saveVideo(str2);
                    try {
                        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                        intent.setData(UtilHelper.getUriFromFile(file, intent, this.f58264a.getPageContext().getPageActivity()));
                        this.f58264a.sendBroadcast(intent);
                    } catch (Exception e2) {
                        this.f58264a.onSaving = false;
                        this.f58264a.onReallyPause();
                        this.f58264a.onReallyResume();
                        BdLog.d(e2.getMessage());
                    }
                    this.f58264a.onSaving = false;
                    TbEditVideoActivity tbEditVideoActivity = this.f58264a;
                    tbEditVideoActivity.showToast(tbEditVideoActivity.getResources().getString(R.string.save_success));
                    this.f58264a.onReallyPause();
                    this.f58264a.onReallyResume();
                } else {
                    c.a.e.e.m.e.a().post(new RunnableC1801a(this, new CustomResponsedMessage(2921584, 100)));
                    VideoFileInfo c2 = c.a.q0.v3.c.c(str);
                    if (c2 == null) {
                        return;
                    }
                    this.f58264a.mVideoInfo = new VideoInfo();
                    this.f58264a.mVideoInfo.setVideoPath(str);
                    this.f58264a.mVideoInfo.setThumbPath(this.f58264a.mCoverPath);
                    this.f58264a.mVideoInfo.setVideoDuration((int) (c2.videoDuration / 1000.0f));
                    this.f58264a.mVideoInfo.setVideoWidth(c2.videoWidth);
                    this.f58264a.mVideoInfo.setVideoHeight(c2.videoHeight);
                    this.f58264a.mVideoInfo.setVideoLength(new File(str).length());
                    this.f58264a.mVideoInfo.setVideoSource(this.f58264a.mMultiMediaData.videoInfoSource);
                    this.f58264a.mVideoInfo.setIsCompressedVideo(true);
                    EditVideoData editVideoData = new EditVideoData();
                    if (!StringUtils.isNull(this.f58264a.mCoverPath)) {
                        editVideoData.coverPath = this.f58264a.mCoverPath;
                    } else {
                        editVideoData.coverPath = c.a.q0.w3.c.f28194b;
                    }
                    editVideoData.originPath = this.f58264a.mMultiMediaData.path;
                    editVideoData.finalPath = str;
                    this.f58264a.mVideoInfo.setEditVideoData(editVideoData);
                    this.f58264a.mMultiMediaData.coverSource = this.f58264a.mPreViewPickCoverView.getCurrentMode();
                    this.f58264a.mMultiMediaData.coverPath = this.f58264a.mCoverPath;
                    this.f58264a.mMultiMediaData.orignalCoverPath = this.f58264a.mOrignalCoverPath;
                    this.f58264a.mMultiMediaData.lastCoverPercent = this.f58264a.mLastCoverPercent;
                    this.f58264a.mVideoInfo.setMultiMediaData(this.f58264a.mMultiMediaData);
                    c.a.e.e.m.e.a().post(new b(this, new CustomResponsedMessage(2921593, this.f58264a.mVideoInfo)));
                }
                TbEditVideoActivity tbEditVideoActivity2 = this.f58264a;
                tbEditVideoActivity2.hideLoadingView(tbEditVideoActivity2.mRootView);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f58268e;

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
            this.f58268e = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoFileInfo c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (c2 = c.a.q0.v3.c.c(this.f58268e.mMultiMediaData.path)) == null) {
                return;
            }
            this.f58268e.mVideoInfo = new VideoInfo();
            this.f58268e.mVideoInfo.setVideoPath(this.f58268e.mMultiMediaData.path);
            this.f58268e.mVideoInfo.setThumbPath(this.f58268e.mCoverPath);
            this.f58268e.mVideoInfo.setVideoDuration((int) (c2.videoDuration / 1000.0f));
            this.f58268e.mVideoInfo.setVideoWidth(c2.videoWidth);
            this.f58268e.mVideoInfo.setVideoHeight(c2.videoHeight);
            this.f58268e.mVideoInfo.setVideoLength(new File(this.f58268e.mMultiMediaData.path).length());
            this.f58268e.mVideoInfo.setVideoSource(this.f58268e.mMultiMediaData.videoInfoSource);
            this.f58268e.mVideoInfo.setIsCompressedVideo(true);
            EditVideoData editVideoData = new EditVideoData();
            if (!StringUtils.isNull(this.f58268e.mCoverPath)) {
                editVideoData.coverPath = this.f58268e.mCoverPath;
            } else {
                editVideoData.coverPath = c.a.q0.w3.c.f28194b;
            }
            editVideoData.originPath = this.f58268e.mVideoInfo.getVideoPath();
            this.f58268e.mVideoInfo.setEditVideoData(editVideoData);
            this.f58268e.mMultiMediaData.coverSource = this.f58268e.mPreViewPickCoverView.getCurrentMode();
            this.f58268e.mMultiMediaData.coverPath = this.f58268e.mCoverPath;
            this.f58268e.mMultiMediaData.orignalCoverPath = this.f58268e.mOrignalCoverPath;
            this.f58268e.mMultiMediaData.lastCoverPercent = this.f58268e.mLastCoverPercent;
            this.f58268e.mVideoInfo.setMultiMediaData(this.f58268e.mMultiMediaData);
            if (c.a.p0.s.m.c.f14071c.e(this.f58268e.getIntent(), this.f58268e.mVideoInfo, this.f58268e.getPageContext().getPageActivity(), false)) {
                return;
            }
            WriteActivityConfig newInstance = WriteActivityConfig.newInstance(this.f58268e.getPageContext().getPageActivity());
            newInstance.getIntent().putExtras(this.f58268e.getIntent());
            String stringExtra = newInstance.getIntent().getStringExtra("forum_id");
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = "0";
            }
            newInstance.getIntent().putExtra("forum_id", stringExtra);
            newInstance.getIntent().setFlags(536870912);
            newInstance.getIntent().setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            newInstance.setType(9).setVideoInfo(this.f58268e.mVideoInfo).send();
            this.f58268e.finish();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f58269e;

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
            this.f58269e = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f58269e.mCoverManager == null) {
                return;
            }
            this.f58269e.mCoverManager.a();
        }
    }

    /* loaded from: classes7.dex */
    public class d implements a.InterfaceC0828a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f58270a;

        public d(TbEditVideoActivity tbEditVideoActivity) {
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
            this.f58270a = tbEditVideoActivity;
        }

        @Override // c.a.q0.f0.a.a.InterfaceC0828a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.q0.f0.a.a.InterfaceC0828a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f58270a.mModeType != 1) {
                    this.f58270a.pauseVideo();
                }
                this.f58270a.imageCoverWaiter.a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f58271e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f58272f;

        public e(TbEditVideoActivity tbEditVideoActivity, PopupDialog popupDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity, popupDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58272f = tbEditVideoActivity;
            this.f58271e = popupDialog;
        }

        @Override // c.a.p0.s.s.i.e
        public void onItemClick(c.a.p0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (i2 == 0) {
                    this.f58272f.finish();
                } else {
                    this.f58271e.dismiss();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f58273e;

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
            this.f58273e = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f58273e.mEditManager != null) {
                    this.f58273e.mEditManager.start();
                }
                if (this.f58273e.mMusicManager != null) {
                    this.f58273e.mMusicManager.onResume();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f58274e;

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
            this.f58274e = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58274e.mPreViewPickCoverView.setVisibility(0);
                int height = this.f58274e.mNavigationBar.getHeight();
                int height2 = this.f58274e.mPreViewPickCoverView.getHeight();
                int i2 = c.a.e.e.p.l.i(this.f58274e.getPageContext().getPageActivity());
                float k = c.a.e.e.p.l.k(this.f58274e.getPageContext().getPageActivity()) * this.f58274e.mRatio;
                this.f58274e.mPreviewHeight = (i2 - height) - height2;
                float k2 = (this.f58274e.mPreviewHeight * 1.0f) / c.a.e.e.p.l.k(this.f58274e.getPageContext().getPageActivity());
                TbEditVideoActivity tbEditVideoActivity = this.f58274e;
                tbEditVideoActivity.mTranslateY = height - ((i2 - tbEditVideoActivity.mPreviewHeight) * 0.5f);
                this.f58274e.mEditPreviewContainer.setTranslationY(this.f58274e.mTranslateY);
                if (this.f58274e.mRatio > k2) {
                    this.f58274e.mPreviewView.setScaleX(this.f58274e.mPreviewHeight / k);
                    this.f58274e.mPreviewView.setScaleY(this.f58274e.mPreviewHeight / k);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f58275e;

        /* loaded from: classes7.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f58276e;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f58276e = hVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    this.f58276e.f58275e.mPreViewPickCoverView.setVisibility(0);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f58277e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f58278f;

            public b(h hVar, float f2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, Float.valueOf(f2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f58278f = hVar;
                this.f58277e = f2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    this.f58278f.f58275e.mPreviewView.setScaleX(floatValue / this.f58277e);
                    this.f58278f.f58275e.mPreviewView.setScaleY(floatValue / this.f58277e);
                }
            }
        }

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
            this.f58275e = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f58275e.mPreViewPickCoverView, "translationY", this.f58275e.mPreViewPickCoverView.getHeight(), 0.0f);
                ofFloat.setDuration(250L);
                ofFloat.addListener(new a(this));
                int height = this.f58275e.mNavigationBar.getHeight();
                int height2 = this.f58275e.mPreViewPickCoverView.getHeight();
                int i2 = c.a.e.e.p.l.i(this.f58275e.getPageContext().getPageActivity());
                float k = c.a.e.e.p.l.k(this.f58275e.getPageContext().getPageActivity()) * this.f58275e.mRatio;
                this.f58275e.mPreviewHeight = (i2 - height) - height2;
                float k2 = (this.f58275e.mPreviewHeight * 1.0f) / c.a.e.e.p.l.k(this.f58275e.getPageContext().getPageActivity());
                TbEditVideoActivity tbEditVideoActivity = this.f58275e;
                tbEditVideoActivity.mTranslateY = height - ((i2 - tbEditVideoActivity.mPreviewHeight) * 0.5f);
                ObjectAnimator duration = ObjectAnimator.ofFloat(this.f58275e.mEditPreviewContainer, "translationY", 0.0f, this.f58275e.mTranslateY).setDuration(250L);
                if (this.f58275e.mRatio > k2) {
                    ValueAnimator ofFloat2 = ValueAnimator.ofFloat(k, this.f58275e.mPreviewHeight);
                    ofFloat2.addUpdateListener(new b(this, k));
                    ofFloat2.setDuration(250L);
                    ofFloat2.start();
                }
                ofFloat.start();
                duration.start();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f58279e;

        /* loaded from: classes7.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i f58280e;

            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f58280e = iVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    this.f58280e.f58279e.mPreViewPickCoverView.setVisibility(8);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f58281e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ i f58282f;

            public b(i iVar, float f2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, Float.valueOf(f2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f58282f = iVar;
                this.f58281e = f2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    this.f58282f.f58279e.mPreviewView.setScaleX(floatValue / this.f58281e);
                    this.f58282f.f58279e.mPreviewView.setScaleY(floatValue / this.f58281e);
                }
            }
        }

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
            this.f58279e = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f58279e.mPreViewPickCoverView, "translationY", 0.0f, this.f58279e.mPreViewPickCoverView.getHeight());
                ofFloat.setDuration(250L);
                ofFloat.addListener(new a(this));
                int height = this.f58279e.mNavigationBar.getHeight();
                int height2 = this.f58279e.mPreViewPickCoverView.getHeight();
                int i2 = c.a.e.e.p.l.i(this.f58279e.getPageContext().getPageActivity());
                float k = c.a.e.e.p.l.k(this.f58279e.getPageContext().getPageActivity()) * this.f58279e.mRatio;
                this.f58279e.mPreviewHeight = (i2 - height) - height2;
                float k2 = (this.f58279e.mPreviewHeight * 1.0f) / c.a.e.e.p.l.k(this.f58279e.getPageContext().getPageActivity());
                TbEditVideoActivity tbEditVideoActivity = this.f58279e;
                tbEditVideoActivity.mTranslateY = height - ((i2 - tbEditVideoActivity.mPreviewHeight) * 0.5f);
                ObjectAnimator duration = ObjectAnimator.ofFloat(this.f58279e.mEditPreviewContainer, "translationY", 0.0f, this.f58279e.mTranslateY).setDuration(250L);
                if (this.f58279e.mRatio > k2) {
                    ValueAnimator ofFloat2 = ValueAnimator.ofFloat(k, this.f58279e.mPreviewHeight);
                    ofFloat2.addUpdateListener(new b(this, k));
                    ofFloat2.setDuration(250L);
                    ofFloat2.reverse();
                }
                ofFloat.start();
                duration.reverse();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f58283e;

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
            this.f58283e = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58283e.mVideoControllerLayout.setMusicName(this.f58283e.mCurrentMusicData.title, this.f58283e.mCurrentMusicData.icon);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f58284e;

        public k(TbEditVideoActivity tbEditVideoActivity) {
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
            this.f58284e = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58284e.mFilterName.setVisibility(8);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements RecordPreviewContainer.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f58285a;

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
            this.f58285a = tbEditVideoActivity;
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void a(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) && this.f58285a.mModeType == 1 && this.f58285a.mFilterManager != null) {
                this.f58285a.mFilterManager.g();
                String currentFilterName = this.f58285a.mVideoControllerLayout.getCurrentFilterName();
                if (StringUtils.isNull(currentFilterName)) {
                    return;
                }
                this.f58285a.mFilterName.removeCallbacks(this.f58285a.hideFilterName);
                this.f58285a.mFilterName.setText(currentFilterName);
                this.f58285a.mFilterName.setVisibility(0);
                this.f58285a.mFilterName.postDelayed(this.f58285a.hideFilterName, 800L);
            }
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void b(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent) == null) && this.f58285a.mModeType == 1 && this.f58285a.mFilterManager != null) {
                this.f58285a.mFilterManager.e();
                String currentFilterName = this.f58285a.mVideoControllerLayout.getCurrentFilterName();
                if (StringUtils.isNull(currentFilterName)) {
                    return;
                }
                this.f58285a.mFilterName.removeCallbacks(this.f58285a.hideFilterName);
                this.f58285a.mFilterName.setText(currentFilterName);
                this.f58285a.mFilterName.setVisibility(0);
                this.f58285a.mFilterName.postDelayed(this.f58285a.hideFilterName, 800L);
            }
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void c(MotionEvent motionEvent, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                this.f58285a.resetEffectIcon();
                if (this.f58285a.mVideoControllerLayout == null || !this.f58285a.mVideoControllerLayout.isEffectLayoutVisible()) {
                    return;
                }
                this.f58285a.mVideoControllerLayout.hideEffectLayout(null, false);
            }
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void d(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
                this.f58285a.resetEffectIcon();
                if (this.f58285a.mVideoControllerLayout == null || !this.f58285a.mVideoControllerLayout.isEffectLayoutVisible()) {
                    return;
                }
                this.f58285a.mVideoControllerLayout.hideEffectLayout(null, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f58286a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(TbEditVideoActivity tbEditVideoActivity, int i2, boolean z) {
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
            this.f58286a = tbEditVideoActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ResponseGetQmFiltersMessage)) {
                List<QmFilterItem> filterItems = httpResponsedMessage.getError() == 0 ? ((ResponseGetQmFiltersMessage) httpResponsedMessage).getFilterItems() : null;
                if (this.f58286a.mVideoControllerLayout != null) {
                    if (filterItems == null) {
                        filterItems = new ArrayList<>();
                    }
                    QmFilterItem qmFilterItem = new QmFilterItem();
                    qmFilterItem.id = "-1";
                    qmFilterItem.bgurl = R.drawable.icon_pure_video_lvjing_on + "";
                    qmFilterItem.name = this.f58286a.getResources().getString(R.string.filter_nature);
                    qmFilterItem.isSelect = true;
                    qmFilterItem.localPath = FilterValue.DEFAULT_FILTER_VALUE;
                    filterItems.add(0, qmFilterItem);
                    this.f58286a.mVideoControllerLayout.setFilterData(filterItems);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f58287a;

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
            this.f58287a = tbEditVideoActivity;
        }

        @Override // c.a.q0.o0.b.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.f58287a.mVideoControllerLayout != null) {
                    QmFilterItem qmFilterItem = new QmFilterItem();
                    qmFilterItem.id = "-1";
                    qmFilterItem.bgurl = R.drawable.icon_pure_video_lvjing_on + "";
                    qmFilterItem.name = this.f58287a.getResources().getString(R.string.filter_nature);
                    qmFilterItem.isSelect = true;
                    qmFilterItem.localPath = FilterValue.DEFAULT_FILTER_VALUE;
                    this.f58287a.mVideoControllerLayout.selectFilter(qmFilterItem);
                    if (this.f58287a.mFilterManager != null) {
                        this.f58287a.mFilterManager.a(null);
                    }
                    this.f58287a.mVideoControllerLayout.setDownLoadFilter(null);
                }
                if (StringUtils.isNull(str)) {
                    str = this.f58287a.getResources().getString(R.string.sticker_download_error);
                }
                this.f58287a.showToast(str);
            }
        }

        @Override // c.a.q0.o0.b.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f58287a.mVideoControllerLayout == null) {
                return;
            }
            this.f58287a.mVideoControllerLayout.setDownLoadFilter(null);
        }

        @Override // c.a.q0.o0.b.a.b
        public void c(QmFilterItem qmFilterItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qmFilterItem) == null) {
                if (this.f58287a.mFilterManager != null) {
                    this.f58287a.mFilterManager.a(qmFilterItem);
                }
                if (this.f58287a.mVideoControllerLayout != null) {
                    this.f58287a.mVideoControllerLayout.setDownLoadFilter(null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements RecordEffectLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f58288a;

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
            this.f58288a = tbEditVideoActivity;
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void a(QmStickerItem qmStickerItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, qmStickerItem) == null) {
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void b(c.a.q0.a4.l.e.c.b bVar, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, obj) == null) || bVar == null) {
                return;
            }
            int c2 = bVar.c();
            if (c2 == 2) {
                if (this.f58288a.mFilterManager != null && (bVar.d() instanceof QmFilterItem)) {
                    QmFilterItem qmFilterItem = (QmFilterItem) bVar.d();
                    String f2 = this.f58288a.mFilterManager.f(qmFilterItem.fileUrl);
                    if (StringUtils.isNull(f2) && !"-1".equals(qmFilterItem.id)) {
                        if (this.f58288a.mVideoControllerLayout != null) {
                            this.f58288a.mVideoControllerLayout.setDownLoadFilter(qmFilterItem);
                        }
                        this.f58288a.mFilterManager.c(qmFilterItem);
                    } else {
                        qmFilterItem.localPath = f2;
                        this.f58288a.mFilterManager.a(qmFilterItem);
                        if (this.f58288a.mVideoControllerLayout != null) {
                            this.f58288a.mVideoControllerLayout.setDownLoadFilter(null);
                        }
                    }
                    this.f58288a.isEdited = true;
                }
            } else if (c2 == 3 && (bVar.d() instanceof MusicData)) {
                MusicData musicData = (MusicData) bVar.d();
                TbMusicData tbMusicData = new TbMusicData();
                tbMusicData.id = musicData.id;
                tbMusicData.title = musicData.name;
                tbMusicData.url = musicData.resource;
                tbMusicData.icon = musicData.img;
                tbMusicData.type = c.a.e.e.m.b.d(musicData.type, 1);
                if (MusicData.MUSIC_NORMAL_ID.equals(musicData.id) || MusicData.MUSIC_CLOUD_ID.equals(musicData.id)) {
                    this.f58288a.mMusicManager.d(this.f58288a.mCurrentMusicData);
                    this.f58288a.mCurrentMusicData = tbMusicData;
                    if (!MusicData.MUSIC_CLOUD_ID.equals(musicData.id)) {
                        this.f58288a.mVideoControllerLayout.setMusicName(this.f58288a.mCurrentMusicData.title, "");
                    }
                } else {
                    this.f58288a.mCurrentMusicData = tbMusicData;
                    this.f58288a.mMusicManager.d(this.f58288a.mCurrentMusicData);
                    this.f58288a.mVideoControllerLayout.setMusicName(this.f58288a.mCurrentMusicData.title, "");
                }
                if (!MusicData.MUSIC_CLOUD_ID.equals(musicData.id)) {
                    this.f58288a.mVideoControllerLayout.setMusicName(this.f58288a.mCurrentMusicData.title, "");
                }
                this.f58288a.mMusicManager.b((MusicData) bVar.d(), obj);
                this.f58288a.isEdited = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f58289e;

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
            this.f58289e = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f58289e.mModeType == 3) {
                boolean z = this.f58289e.mMultiMediaData != null && this.f58289e.mMultiMediaData.coverSource == 2;
                if (this.f58289e.mCoverManager != null) {
                    if (z) {
                        if (!StringUtils.isNull(this.f58289e.mOrignalCoverPath)) {
                            this.f58289e.mCoverManager.k(this.f58289e.mOrignalCoverPath);
                        } else {
                            this.f58289e.mCoverManager.j();
                        }
                    } else {
                        this.f58289e.mCoverManager.g(this.f58289e.mLastCoverPercent);
                    }
                    this.f58289e.mCoverManager.o(this.f58289e.mMultiMediaData.getCoverStickerList());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f58290e;

        public q(TbEditVideoActivity tbEditVideoActivity) {
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
            this.f58290e = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f58290e.mFilterManager == null || this.f58290e.mFilterManager.b() == null) {
                return;
            }
            this.f58290e.mEditManager.a(this.f58290e.mFilterManager.b());
        }
    }

    /* loaded from: classes7.dex */
    public class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbEditVideoActivity f58291e;

        public r(TbEditVideoActivity tbEditVideoActivity) {
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
            this.f58291e = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TbEditVideoActivity tbEditVideoActivity = this.f58291e;
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
        this.mPreviewHeight = c.a.e.e.p.l.i(getPageContext().getPageActivity());
        this.mTranslateY = 0.0f;
        this.mEditMergeCallBack = new a(this);
        this.hideFilterName = new k(this);
        this.mEditPreviewGestureListener = new l(this);
        this.mGetQmFiltersListener = new m(this, CmdConfigHttp.CMD_GET_QM_FILTERS, true);
        this.mGetFilterCallback = new n(this);
        this.mEditOnEffectChoosedListener = new o(this);
        this.imageCoverWaiter = new s0(new p(this));
    }

    private void backDialogShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            if (this.isEdited) {
                PopupDialog popupDialog = new PopupDialog(getPageContext(), new c.a.p0.s.s.i(getPageContext().getPageActivity()));
                popupDialog.setDefaultContentView(getResources().getString(R.string.edit_video_back_dialog_title), new String[]{getResources().getString(R.string.quit)}, new e(this, popupDialog));
                popupDialog.showDialog();
                return;
            }
            finish();
        }
    }

    private void changeToPureCoverMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            this.mTitle.setVisibility(0);
            this.mRight.setVisibility(0);
            this.mPreViewPickCoverView.post(new g(this));
            this.mEditRightContainer.setVisibility(8);
            this.mEditSaveContainer.setVisibility(8);
            this.mEditPreviewPublish.setVisibility(8);
            SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0611, 0);
        }
    }

    private void enterClipMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            this.mNavigationBar.setVisibility(8);
            this.mEditRightContainer.setVisibility(8);
            this.mEditSaveContainer.setVisibility(8);
            this.mEditPreviewPublish.setVisibility(8);
        }
    }

    private void exitClipMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            this.mNavigationBar.setVisibility(0);
            this.mEditRightContainer.setVisibility(0);
            this.mEditSaveContainer.setVisibility(0);
            this.mEditPreviewPublish.setVisibility(0);
        }
    }

    private c.a.q0.f0.b.b getCurrentPublishMuxerData() {
        InterceptResult invokeV;
        c.a.q0.o0.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, this)) == null) {
            c.a.q0.f0.b.b bVar = new c.a.q0.f0.b.b();
            TbMultiMediaData tbMultiMediaData = this.mMultiMediaData;
            float f2 = 0.0f;
            if (tbMultiMediaData != null) {
                bVar.j(tbMultiMediaData);
                bVar.n(this.mRatio);
                TbMultiMediaData tbMultiMediaData2 = this.mMultiMediaData;
                int i2 = tbMultiMediaData2.width;
                int i3 = tbMultiMediaData2.height;
                float f3 = tbMultiMediaData2.angle;
                if (f3 == 90.0f || f3 == 270.0f) {
                    i3 = i2;
                    i2 = i3;
                }
                if (i2 != 0) {
                    float f4 = i3;
                    float f5 = i2;
                    float f6 = this.mRatio;
                    if (f6 > (f4 * 1.0f) / f5) {
                        i3 = (int) (f5 * f6);
                    } else if (f6 != 0.0f) {
                        i2 = (int) (f4 / f6);
                    }
                    bVar.m(i2);
                    bVar.l(i3);
                }
            }
            c.a.q0.o0.b.b bVar2 = this.mFilterManager;
            if (bVar2 != null && bVar2.b() != null) {
                QmFilterItem b2 = this.mFilterManager.b();
                String str = b2.localPath;
                Filter filter = new Filter();
                if (!StringUtils.isNull(str) && !FilterValue.DEFAULT_FILTER_VALUE.equals(str)) {
                    f2 = (c.a.e.e.m.b.c(b2.effect, 100.0f) * 1.0f) / 100.0f;
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
                tbFilterValue.mComplex = c.a.e.e.m.b.d(b2.complex, 0);
                tbFilterValue.mRootFilePath = str;
                bVar.h(tbFilterValue);
            }
            c.a.q0.f0.a.a aVar2 = this.mEditManager;
            if (aVar2 != null) {
                bVar.i(aVar2.getMediaTrackConfig());
            }
            TbMusicData tbMusicData = this.mCurrentMusicData;
            if (tbMusicData != null && (aVar = this.mMusicManager) != null) {
                tbMusicData.localPath = aVar.a();
                bVar.k(this.mCurrentMusicData);
            }
            return bVar;
        }
        return (c.a.q0.f0.b.b) invokeV.objValue;
    }

    private void hideCoverModeAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
            this.mModeType = 1;
            SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0105, 0);
            this.mTitle.setVisibility(8);
            this.mRight.setVisibility(8);
            c.a.e.e.m.e.a().post(new i(this));
            this.mEditRightContainer.setVisibility(0);
            this.mEditSaveContainer.setVisibility(0);
            this.mEditPreviewPublish.setVisibility(0);
        }
    }

    private void initManager() {
        TbMusicData tbMusicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
            boolean booleanExtra = getIntent().getBooleanExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, false);
            this.mPreviewView = (TbGLMediaPreviewView) findViewById(R.id.edit_preview_view);
            this.mPreViewPickCoverView = (PreViewPickCoverView) findViewById(R.id.pick_cover_view);
            c.a.q0.o0.a.d dVar = new c.a.q0.o0.a.d(getPageContext(), this.mPreviewView, this.mPreViewPickCoverView, this.mMultiMediaData, booleanExtra);
            this.mCoverManager = dVar;
            dVar.b(this);
            this.needShowCoverToast = false;
            if (TextUtils.isEmpty(this.mCoverPath)) {
                this.mPreviewView.post(new c(this));
            }
            c.a.q0.f0.a.b bVar = new c.a.q0.f0.a.b(getPageContext(), this.mPreviewView, this.mMultiMediaData, this.mCoverManager, booleanExtra);
            this.mEditManager = bVar;
            bVar.e(this.mRatio);
            this.mEditManager.b(new d(this));
            this.mVideoControllerLayout = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
            c.a.q0.o0.c.c cVar = new c.a.q0.o0.c.c(getPageContext(), this.mVideoControllerLayout);
            this.mMusicManager = cVar;
            this.mVideoControllerLayout.setMusicManager(cVar);
            if (this.mMusicManager != null && (tbMusicData = this.mCurrentMusicData) != null && !TextUtils.isEmpty(tbMusicData.localPath) && !TextUtils.isEmpty(this.mCurrentMusicData.id)) {
                TbMusicData tbMusicData2 = this.mCurrentMusicData;
                if (tbMusicData2.type == 2) {
                    this.mVideoControllerLayout.setEffectLayoutCurrentMusicName(getResources().getString(R.string.music_cloud));
                } else {
                    this.mVideoControllerLayout.setEffectLayoutCurrentMusicName(tbMusicData2.title);
                }
                c.a.q0.o0.c.a aVar = this.mMusicManager;
                TbMusicData tbMusicData3 = this.mCurrentMusicData;
                aVar.e(tbMusicData3.localPath, tbMusicData3.id);
                this.mVideoControllerLayout.setMusicName(this.mCurrentMusicData.title, "");
            }
            c.a.q0.o0.b.a aVar2 = new c.a.q0.o0.b.a(null, this.mEditManager, this.mVideoControllerLayout);
            this.mFilterManager = aVar2;
            aVar2.d(this.mGetFilterCallback);
            this.mFilterManager.h();
            this.mVideoControllerLayout.setEditManager(this.mEditManager);
            this.mMuxerManager = new c.a.q0.f0.b.c(getPageContext(), this.mEditMergeCallBack);
            loadFilter();
            QmFilterItem videoFilter = this.mMultiMediaData.getVideoFilter();
            if (videoFilter != null) {
                this.mFilterManager.a(videoFilter);
                this.mVideoControllerLayout.setCurrentFilterWithQmFilterItem(videoFilter);
            }
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
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
            int i2 = 0;
            if (this.mVideoFrom == 1) {
                relativeLayout.setVisibility(8);
            } else {
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
            c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(this.mFilterName);
            d2.z(R.string.F_X02);
            d2.x(R.array.S_O_X001);
            c.a.p0.s.u.c d3 = c.a.p0.s.u.c.d(findViewById(R.id.edit_preview_publish));
            d3.n(R.string.J_X01);
            d3.f(R.color.CAM_X0302);
            c.a.p0.s.u.c.d(findViewById(R.id.edit_preview_save_text)).x(R.array.S_O_X001);
            c.a.p0.s.u.c.d(findViewById(R.id.capture_right_text_edit)).x(R.array.S_O_X001);
            c.a.p0.s.u.c.d(findViewById(R.id.capture_right_text_filter)).x(R.array.S_O_X001);
            c.a.p0.s.u.c.d(findViewById(R.id.capture_right_text_cover)).x(R.array.S_O_X001);
            c.a.p0.s.u.c.d(findViewById(R.id.capture_right_text_music)).x(R.array.S_O_X001);
            TbMultiMediaData tbMultiMediaData = this.mMultiMediaData;
            if (tbMultiMediaData != null && tbMultiMediaData.coverSource == 2) {
                this.mPreViewPickCoverView.setCurrentMode(2);
            } else {
                this.mPreViewPickCoverView.setCurrentMode(1);
            }
            if (this.mModeType == 3) {
                changeToPureCoverMode();
                this.imageCoverWaiter.b();
            } else if (c.a.p0.s.m.b.c()) {
                int i3 = this.mVideoFrom;
                if (i3 == 1) {
                    i2 = 2;
                } else if (i3 == 2) {
                    i2 = 1;
                }
                TiebaStatic.log(new StatisticItem("c14309").param("obj_source", i2));
            }
        }
    }

    private void jumpToAlbumActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65579, this) == null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            WriteData writeData = new WriteData();
            new FrsTabInfoData();
            new PostPrefixData();
            boolean booleanExtra = getIntent().getBooleanExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, false);
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), writeImagesInfo.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", writeData.getForumId());
            albumFloatActivityConfig.getIntent().putExtra("forum_name", writeData.getForumName());
            albumFloatActivityConfig.getIntent().putExtra("from", AlbumActivityConfig.FROM_WRITE);
            albumFloatActivityConfig.getIntent().putExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, booleanExtra);
            albumFloatActivityConfig.setRequestCode(12002);
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
        if (interceptable == null || interceptable.invokeV(65580, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_QM_FILTERS);
            httpMessage.addParam("uh", Build.MANUFACTURER + "," + Build.HARDWARE + "," + Build.BOARD + "," + (c.a.q0.v3.d.b(this) ? 1 : 0));
            httpMessage.addParam("ut", Build.MODEL + "_" + Build.VERSION.RELEASE + "_" + c.a.q0.v3.d.a() + "_" + Build.BRAND.replace("_", ""));
            StringBuilder sb = new StringBuilder();
            sb.append(c.a.a0.a.b.i());
            sb.append("");
            httpMessage.addParam(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, sb.toString());
            sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onReallyPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65581, this) == null) {
            c.a.q0.f0.a.a aVar = this.mEditManager;
            if (aVar != null) {
                aVar.onPause();
            }
            c.a.q0.o0.c.a aVar2 = this.mMusicManager;
            if (aVar2 != null) {
                aVar2.onPause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onReallyResume() {
        c.a.q0.o0.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65582, this) == null) {
            ViewGroup viewGroup = this.mRootView;
            if (viewGroup != null) {
                viewGroup.setSystemUiVisibility(4100);
            }
            c.a.q0.f0.a.a aVar2 = this.mEditManager;
            if (aVar2 != null) {
                aVar2.onResume();
            }
            if (this.mModeType == 1 && (aVar = this.mMusicManager) != null) {
                aVar.onResume();
            }
            c.a.q0.o0.b.b bVar = this.mFilterManager;
            if (bVar != null) {
                bVar.h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65583, this) == null) {
            c.a.q0.f0.a.a aVar = this.mEditManager;
            if (aVar != null) {
                aVar.pause();
            }
            c.a.q0.o0.c.a aVar2 = this.mMusicManager;
            if (aVar2 != null) {
                aVar2.onPause();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetEffectIcon() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65584, this) == null) {
            this.mEditFilter.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_lvjing40));
            this.mEditMusic.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_music40));
        }
    }

    private void showCoverModeAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65585, this) == null) {
            this.mModeType = 2;
            SkinManager.setBackgroundColor(this.mRootView, R.color.CAM_X0611, 0);
            resetEffectIcon();
            VideoControllerLayout videoControllerLayout = this.mVideoControllerLayout;
            if (videoControllerLayout != null && videoControllerLayout.isEffectLayoutVisible()) {
                this.mVideoControllerLayout.hideEffectLayout(null, false);
            }
            this.mTitle.setVisibility(0);
            this.mRight.setVisibility(0);
            c.a.e.e.m.e.a().post(new h(this));
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
        c.a.q0.o0.a.a aVar;
        TbMultiMediaData tbMultiMediaData;
        TbMultiMediaData tbMultiMediaData2;
        c.a.q0.o0.a.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, intent) == null) {
            if (intent == null) {
                if (this.mPreViewPickCoverView.getCurrentMode() != 2 || i2 != 12002 || (aVar2 = this.mCoverManager) == null || aVar2.m()) {
                    return;
                }
                this.mPreViewPickCoverView.setCurrentMode(1);
                this.mCoverManager.j();
            } else if (i2 == 25032) {
                if (i3 != -1) {
                    return;
                }
                String stringExtra = intent.getStringExtra("music_id");
                TbMusicData tbMusicData = (TbMusicData) intent.getSerializableExtra("music_data");
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
                    this.mVideoControllerLayout.selectCloudMusic(tbMusicData);
                }
            } else if (i2 == 25062) {
                c.a.q0.v3.g.c(intent, this.mPreviewView);
                if (i3 == -1 && (tbMultiMediaData = (TbMultiMediaData) intent.getParcelableExtra(TbEditVideoActivityConfig.KEY_EDIT_VIDEO_DATA)) != null && this.mEditManager != null && (tbMultiMediaData2 = this.mMultiMediaData) != null && (tbMultiMediaData.start != tbMultiMediaData2.start || tbMultiMediaData.end != tbMultiMediaData2.end)) {
                    this.mMultiMediaData = tbMultiMediaData;
                    this.mEditManager.c(tbMultiMediaData);
                    this.mVideoControllerLayout.post(new q(this));
                    this.isEdited = true;
                }
                exitClipMode();
            } else if (i2 == 12002) {
                if (i3 == -1) {
                    String stringExtra2 = intent.getStringExtra(VideoCoverSelectActivityConfig.KEY_VIDEO_COVER_IMAGE_PATH);
                    if (TextUtils.isEmpty(stringExtra2) || (aVar = this.mCoverManager) == null) {
                        return;
                    }
                    aVar.k(stringExtra2);
                    this.mOrignalCoverPath = stringExtra2;
                    return;
                }
                c.a.q0.o0.a.a aVar3 = this.mCoverManager;
                if (aVar3 == null || aVar3.m()) {
                    return;
                }
                this.mPreViewPickCoverView.setCurrentMode(1);
                this.mCoverManager.j();
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        c.a.q0.o0.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.mModeType == 2) {
                if (this.mPreViewPickCoverView.getCurrentMode() == 2 && (aVar = this.mCoverManager) != null) {
                    aVar.j();
                }
                c.a.q0.o0.a.a aVar2 = this.mCoverManager;
                if (aVar2 != null) {
                    aVar2.reset();
                }
                c.a.e.e.m.e.a().post(new f(this));
                hideCoverModeAnim();
                return;
            }
            backDialogShow();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.q0.o0.a.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            super.onClick(view);
            if (view.getId() == R.id.capture_right_filter_container) {
                resetEffectIcon();
                if (this.mVideoControllerLayout.isFilterEffectLayoutVisible()) {
                    this.mEditFilter.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_lvjing40));
                } else {
                    this.mEditFilter.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_lvjing_s44));
                }
                this.mVideoControllerLayout.onClickFilter();
                if (this.mVideoControllerLayout.isNeedLoadFilter()) {
                    loadFilter();
                    return;
                }
                return;
            }
            if (view.getId() == R.id.capture_right_music_container) {
                resetEffectIcon();
                if (this.mVideoControllerLayout.isMusicEffectLayoutVisible()) {
                    this.mEditMusic.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_music40));
                } else {
                    this.mEditMusic.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_music_s44));
                }
                this.mVideoControllerLayout.onClickMusic();
                TbMusicData tbMusicData = this.mCurrentMusicData;
                if (tbMusicData == null || tbMusicData.type != 2) {
                    return;
                }
                this.mVideoControllerLayout.postDelayed(new j(this), 300L);
            } else if (view.getId() == R.id.capture_right_edit_container) {
                TbFileVideoActivityConfig tbFileVideoActivityConfig = new TbFileVideoActivityConfig(getPageContext().getPageActivity());
                tbFileVideoActivityConfig.setForResult();
                tbFileVideoActivityConfig.setFrom(2);
                tbFileVideoActivityConfig.setTbMultiMediaData(this.mMultiMediaData);
                c.a.q0.o0.b.b bVar = this.mFilterManager;
                if (bVar != null && bVar.b() != null) {
                    tbFileVideoActivityConfig.setFilter(this.mFilterManager.b());
                }
                tbFileVideoActivityConfig.setEnterAnimValues(c.a.q0.v3.g.a(this.mPreviewView));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbFileVideoActivityConfig));
                enterClipMode();
            } else if (view.getId() == R.id.capture_right_cover_container) {
                c.a.q0.o0.a.a aVar2 = this.mCoverManager;
                if (aVar2 != null) {
                    aVar2.g(this.mLastCoverPercent);
                    pauseVideo();
                    if (this.mPreViewPickCoverView.getCurrentMode() == 2 && !StringUtils.isNull(this.mOrignalCoverPath)) {
                        this.mCoverManager.k(this.mOrignalCoverPath);
                    } else {
                        this.mPreViewPickCoverView.setCurrentMode(1);
                    }
                    this.mCoverManager.o(this.mMultiMediaData.getCoverStickerList());
                    showCoverModeAnim();
                }
                c.a.p0.s.d0.b.j().t("key_edit_video_pick_cover_tip_show", true);
            } else if (view.getId() == R.id.edit_preview_save_container) {
                if (this.mMuxerManager != null) {
                    this.onSaving = true;
                    pauseVideo();
                    this.mMuxerManager.a(getCurrentPublishMuxerData());
                }
            } else if (view.getId() == R.id.edit_preview_publish) {
                if (c.a.p0.s.m.b.c()) {
                    int i2 = this.mVideoFrom;
                    TiebaStatic.log(new StatisticItem("c14310").param("obj_source", i2 != 1 ? i2 == 2 ? 1 : 0 : 2));
                }
                if (!c.a.p0.s.d0.b.j().g("key_edit_video_pick_cover_tip_show", false)) {
                    c.a.q0.e0.e eVar = new c.a.q0.e0.e(getPageContext(), this.mCaptureCoverContainer);
                    eVar.g0(R.drawable.pic_sign_tip_right);
                    eVar.L(1);
                    eVar.h0(true);
                    eVar.X(R.color.CAM_X0101);
                    eVar.e0(R.dimen.T_X08);
                    eVar.P(R.dimen.T_X08);
                    eVar.a0(UtilHelper.getDimenPixelSize(R.dimen.tbds26));
                    eVar.d0(UtilHelper.getDimenPixelSize(R.dimen.tbds26));
                    eVar.l0(getResources().getString(R.string.edit_video_cover_tips));
                    c.a.p0.s.d0.b.j().t("key_edit_video_pick_cover_tip_show", true);
                    return;
                }
                pauseVideo();
                this.mMuxerManager.a(getCurrentPublishMuxerData());
                VideoFileInfo c2 = c.a.q0.v3.c.c(this.mMultiMediaData.path);
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
                this.mVideoInfo.setVideoSource(this.mMultiMediaData.videoInfoSource);
                this.mVideoInfo.setIsCompressedVideo(true);
                EditVideoData editVideoData = new EditVideoData();
                if (StringUtils.isNull(this.mCoverPath)) {
                    editVideoData.coverPath = c.a.q0.w3.c.f28194b;
                } else {
                    editVideoData.coverPath = this.mCoverPath;
                }
                editVideoData.originPath = this.mVideoInfo.getVideoPath();
                this.mVideoInfo.setEditVideoData(editVideoData);
                this.mMultiMediaData.coverSource = this.mPreViewPickCoverView.getCurrentMode();
                TbMultiMediaData tbMultiMediaData = this.mMultiMediaData;
                tbMultiMediaData.coverPath = this.mCoverPath;
                tbMultiMediaData.orignalCoverPath = this.mOrignalCoverPath;
                List<MultiMediaData> h2 = this.mCoverManager.h();
                if (h2 != null) {
                    this.mMultiMediaData.setCoverStickerList(h2);
                }
                this.mMultiMediaData.setOrignalVideoPath(this.mVideoInfo.getVideoPath());
                this.mMultiMediaData.setVideoFilter(this.mFilterManager.b());
                this.mVideoInfo.setMultiMediaData(this.mMultiMediaData);
                if (c.a.p0.s.m.c.f14071c.e(getIntent(), this.mVideoInfo, getPageContext().getPageActivity(), true)) {
                    return;
                }
                WriteActivityConfig newInstance = WriteActivityConfig.newInstance(getPageContext().getPageActivity());
                newInstance.getIntent().putExtras(getIntent());
                String stringExtra = newInstance.getIntent().getStringExtra("forum_id");
                if (TextUtils.isEmpty(stringExtra)) {
                    stringExtra = "0";
                }
                newInstance.getIntent().putExtra("forum_id", stringExtra);
                newInstance.getIntent().setFlags(536870912);
                newInstance.getIntent().setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                newInstance.setType(9).setVideoInfo(this.mVideoInfo).setNeedClosePrePage(true).send();
                finish();
            } else if (view == this.mLeft) {
                onBackPressed();
            } else if (view == this.mRight) {
                int i3 = this.mModeType;
                if (i3 == 2) {
                    c.a.q0.o0.a.a aVar3 = this.mCoverManager;
                    if (aVar3 != null) {
                        this.needShowCoverToast = true;
                        aVar3.d();
                    }
                    hideCoverModeAnim();
                } else if (i3 != 3 || (aVar = this.mCoverManager) == null) {
                } else {
                    this.needShowCoverToast = true;
                    aVar.d();
                }
            } else if (view.getId() == this.mPreViewPickCoverView.getVideoPick().getId()) {
                if (this.mPreViewPickCoverView.getCurrentMode() != 1) {
                    this.mPreViewPickCoverView.setCurrentMode(1);
                    c.a.q0.o0.a.a aVar4 = this.mCoverManager;
                    if (aVar4 != null) {
                        aVar4.g(this.mLastCoverPercent);
                        this.mCoverManager.j();
                    }
                }
            } else if (view.getId() == this.mPreViewPickCoverView.getImagePick().getId()) {
                if (this.mPreViewPickCoverView.getCurrentMode() != 2) {
                    this.mPreViewPickCoverView.setCurrentMode(2);
                    c.a.q0.o0.a.a aVar5 = this.mCoverManager;
                    if (aVar5 != null) {
                        this.mLastCoverPercent = aVar5.n();
                    }
                    jumpToAlbumActivity();
                }
            } else if (view.getId() == this.mPreViewPickCoverView.getCoverImageView().getId() && this.mPreViewPickCoverView.getCurrentMode() == 2) {
                jumpToAlbumActivity();
            }
        }
    }

    @Override // c.a.q0.o0.a.b
    public void onCoverPathCallBack(String str) {
        List<MultiMediaData> h2;
        c.a.q0.o0.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || StringUtils.isNull(str) || str.equals(this.mCoverPath)) {
            return;
        }
        c.a.q0.o0.a.a aVar2 = this.mCoverManager;
        if (aVar2 != null) {
            this.mLastCoverPercent = aVar2.n();
        }
        this.mCoverPath = str;
        if (this.mPreViewPickCoverView.getCurrentMode() == 2 && (aVar = this.mCoverManager) != null) {
            aVar.j();
        }
        if (this.needShowCoverToast) {
            c.a.e.e.m.e.a().post(new r(this));
            if (this.mModeType != 3) {
                c.a.q0.f0.a.a aVar3 = this.mEditManager;
                if (aVar3 != null) {
                    aVar3.start();
                }
                c.a.q0.o0.c.a aVar4 = this.mMusicManager;
                if (aVar4 != null) {
                    aVar4.onResume();
                }
            }
            this.isEdited = true;
        }
        c.a.q0.o0.a.a aVar5 = this.mCoverManager;
        if (aVar5 != null && (h2 = aVar5.h()) != null) {
            this.mMultiMediaData.setCoverStickerList(h2);
        }
        if (this.mModeType == 3) {
            c.a.e.e.m.e.a().post(new b(this));
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
            c.a.q0.f0.a.a aVar = this.mEditManager;
            if (aVar != null) {
                aVar.onDestroy();
            }
            c.a.q0.o0.c.a aVar2 = this.mMusicManager;
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
            onReallyPause();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            onReallyResume();
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
