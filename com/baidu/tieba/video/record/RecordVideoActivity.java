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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.nps.pm.provider.BundleOpProvider;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dq4;
import com.repackage.hj7;
import com.repackage.ho8;
import com.repackage.hq8;
import com.repackage.iq8;
import com.repackage.li;
import com.repackage.lj7;
import com.repackage.mq8;
import com.repackage.op8;
import com.repackage.oq8;
import com.repackage.qq8;
import com.repackage.rq8;
import com.repackage.so8;
import com.repackage.sq8;
import com.repackage.tq8;
import com.repackage.vq8;
import com.repackage.wq8;
import com.repackage.xp8;
import com.repackage.yp8;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class RecordVideoActivity extends BaseActivity implements VideoEffectButtonLayout.a, VideoControllerLayout.f, VideoEffectLayout.h, rq8.l, RecordTabLayout.c, RecordLayout.a, GLVideoPreviewView.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TAB_PHOTO = 1;
    public static final int TAB_RECORD = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public int bottomTabShowType;
    public CustomMessageListener mAfterJumpWriteActivityListener;
    public dq4 mAlertDialog;
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
    public boolean mIsNeedToLoadLocalVideo;
    public boolean mIsProcessFaceIdentifyFail;
    public boolean mIsRecordingState;
    public TextView mMinTimeTips;
    public tq8 mMusicController;
    public SelectMusicModel mMusicModel;
    public xp8.a mOnLocalVideoLoadedListener;
    public hj7 mPostMonitorManager;
    public rq8 mPreviewController;
    public View mProgressView;
    public sq8 mRecordController;
    public RecordLayout mRootLayout;
    public RoundProgressBar mRoundProgressBar;
    public ObjectAnimator mShowTabAnimator;
    public AnimatorSet mStartRecodingAnimatorSet;
    public View mStatusBarView;
    public vq8 mStickerManager;
    public AnimatorSet mStopRecodingAnimatorSet;
    public PreviewViewContainer mSurfaceContainer;
    public RecordTabLayout mTabLayout;
    public ImageFileInfo mTakePhoto;
    public RelativeLayout mTopControllerLayout;
    public TextView mTvCountDown;
    public String mVideoTitle;
    public WriteImagesInfo mWriteImagesInfo;
    public mq8 mZoomHelper;

    /* loaded from: classes4.dex */
    public class a implements qq8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordVideoActivity a;

        public a(RecordVideoActivity recordVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recordVideoActivity;
        }

        @Override // com.repackage.qq8.a
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                this.a.mRecordController.m(1);
                this.a.onStopRecord();
                if (z) {
                    if (this.a.mWriteImagesInfo != null) {
                        if (this.a.mTakePhoto != null && !ListUtils.isEmpty(this.a.mWriteImagesInfo.getChosedFiles()) && this.a.mWriteImagesInfo.getChosedFiles().contains(this.a.mTakePhoto)) {
                            this.a.mWriteImagesInfo.getChosedFiles().remove(this.a.mTakePhoto);
                        }
                    } else {
                        this.a.mWriteImagesInfo = new WriteImagesInfo();
                    }
                    this.a.mTakePhoto = new ImageFileInfo();
                    this.a.mTakePhoto.setFilePath(str);
                    this.a.mTakePhoto.setContentUriStr(null);
                    this.a.mTakePhoto.setTempFile(true);
                    this.a.mTakePhoto.setAlbumnId(null);
                    this.a.mTakePhoto.setIsFromCamera(true);
                    this.a.mWriteImagesInfo.addChooseFile(this.a.mTakePhoto);
                    if (this.a.getIntent().getIntExtra("from_type", 0) == 2) {
                        Intent intent = new Intent();
                        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.a.mWriteImagesInfo.toJsonString());
                        this.a.setResult(-1, intent);
                        this.a.finish();
                        ActivityPendingTransitionFactory.closeAnimation(this.a.getPageContext(), 0);
                        return;
                    }
                    WriteMulitImageActivityConfig writeMulitImageActivityConfig = new WriteMulitImageActivityConfig(this.a.getPageContext().getPageActivity(), 12012, this.a.mWriteImagesInfo, this.a.mWriteImagesInfo.size() - 1, this.a.mForumWriteData, this.a.mEntranceFlag);
                    writeMulitImageActivityConfig.getIntent().putExtras(this.a.getIntent());
                    this.a.sendMessage(new CustomMessage(2002001, writeMulitImageActivityConfig));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends wq8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordVideoActivity b;

        public b(RecordVideoActivity recordVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = recordVideoActivity;
        }

        @Override // com.repackage.wq8, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.a) {
                return;
            }
            this.b.mTabLayout.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends BdAsyncTask<Void, Void, iq8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public Handler b;
        public final /* synthetic */ RecordVideoActivity c;

        /* loaded from: classes4.dex */
        public class a extends Handler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, Looper looper) {
                super(looper);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, looper};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((Looper) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c cVar;
                int i;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1 && (i = (cVar = this.a).a) >= 0) {
                    cVar.a = (i + 5) % 100;
                    cVar.c.mRoundProgressBar.b(this.a.a);
                    this.a.d();
                }
            }
        }

        public c(RecordVideoActivity recordVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = recordVideoActivity;
            this.b = new a(this, Looper.getMainLooper());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public iq8 doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                d();
                tq8 tq8Var = this.c.mMusicController;
                boolean z = tq8Var == null || TextUtils.isEmpty(tq8Var.h()) || !new File(this.c.mMusicController.h()).exists();
                if (this.c.mPreviewController.q.size() > 1) {
                    hq8 e = hq8.e();
                    rq8 rq8Var = this.c.mPreviewController;
                    return e.i(rq8Var.q, rq8Var.g(), z);
                }
                File file = new File(this.c.mPreviewController.q.get(0));
                if (file.exists()) {
                    if (z) {
                        try {
                            FileHelper.copyFileByAbsolutelyPath(file.getPath(), this.c.mPreviewController.g());
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        return new iq8(0, "");
                    }
                    hq8 e3 = hq8.e();
                    rq8 rq8Var2 = this.c.mPreviewController;
                    return e3.i(rq8Var2.q, rq8Var2.g(), z);
                }
                return null;
            }
            return (iq8) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(iq8 iq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iq8Var) == null) {
                this.a = -1;
                this.c.mHandler.removeMessages(1);
                this.c.mControllerLayout.w();
                if (iq8Var != null && iq8Var.a == 0) {
                    this.c.goToEditVideo();
                    this.c.recordCompress(102);
                    this.c.mProgressView.setVisibility(8);
                    return;
                }
                RecordVideoActivity recordVideoActivity = this.c;
                li.O(recordVideoActivity, recordVideoActivity.getString(R.string.obfuscated_res_0x7f0f0ad9));
                this.c.mProgressView.setVisibility(8);
                if (iq8Var != null) {
                    this.c.recordVideoRecord(iq8Var.a, iq8Var.b);
                }
                this.c.mRoundProgressBar.b(0.0f);
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a < 0) {
                return;
            }
            this.b.sendEmptyMessageDelayed(1, 50L);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordVideoActivity a;

        public d(RecordVideoActivity recordVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recordVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.mGestureGuideView.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordVideoActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(RecordVideoActivity recordVideoActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recordVideoActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordVideoActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(RecordVideoActivity recordVideoActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recordVideoActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordVideoActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(RecordVideoActivity recordVideoActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recordVideoActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements xp8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordVideoActivity a;

        public h(RecordVideoActivity recordVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recordVideoActivity;
        }

        @Override // com.repackage.xp8.a
        public void a(List<yp8> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                if (ListUtils.isEmpty(list)) {
                    if (this.a.mControllerLayout != null) {
                        this.a.mControllerLayout.setHasLocalVideo(false);
                    }
                } else if (this.a.mControllerLayout != null) {
                    this.a.mControllerLayout.setHasLocalVideo(true);
                    this.a.mIsNeedToLoadLocalVideo = false;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordVideoActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(RecordVideoActivity recordVideoActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recordVideoActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ResponseGetStickersMessage)) {
                List<StickerItem> stickerItems = httpResponsedMessage.getError() == 0 ? ((ResponseGetStickersMessage) httpResponsedMessage).getStickerItems() : null;
                if (this.a.mControllerLayout != null) {
                    StickerItem stickerItem = new StickerItem();
                    stickerItem.id = -1;
                    stickerItem.isSelect = true;
                    stickerItem.name = "nosticker";
                    if (stickerItems == null) {
                        stickerItems = new ArrayList<>();
                    }
                    stickerItems.add(0, stickerItem);
                    this.a.mControllerLayout.setStickerItems(stickerItems);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements rq8.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordVideoActivity a;

        public j(RecordVideoActivity recordVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recordVideoActivity;
        }

        @Override // com.repackage.rq8.k
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.mControllerLayout.r()) {
                this.a.mControllerLayout.n(null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements vq8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordVideoActivity a;

        public k(RecordVideoActivity recordVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recordVideoActivity;
        }

        @Override // com.repackage.vq8.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.mControllerLayout != null) {
                    StickerItem stickerItem = new StickerItem();
                    stickerItem.id = -1;
                    this.a.mControllerLayout.z(stickerItem);
                    rq8 rq8Var = this.a.mPreviewController;
                    if (rq8Var != null) {
                        rq8Var.H(null);
                    }
                }
                if (this.a.mControllerLayout != null) {
                    this.a.mControllerLayout.setDownLoadSticker(null);
                }
                if (StringUtils.isNull(str)) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f1203);
                } else {
                    this.a.showToast(str);
                }
                RecordVideoActivity recordVideoActivity = this.a;
                if (StringUtils.isNull(str)) {
                    str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1203);
                }
                recordVideoActivity.recordVideoRecord(5, str);
            }
        }

        @Override // com.repackage.vq8.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.mControllerLayout == null) {
                return;
            }
            this.a.mControllerLayout.setDownLoadSticker(null);
        }

        @Override // com.repackage.vq8.b
        public void c(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                RecordVideoActivity recordVideoActivity = this.a;
                recordVideoActivity.setSticker(recordVideoActivity.mCurrentSticker, str2);
                if (this.a.mControllerLayout != null) {
                    this.a.mControllerLayout.setDownLoadSticker(null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordVideoActivity a;

        public l(RecordVideoActivity recordVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recordVideoActivity;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
                this.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordVideoActivity a;

        public m(RecordVideoActivity recordVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recordVideoActivity;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtomicInteger a;
        public final /* synthetic */ RecordVideoActivity b;

        public n(RecordVideoActivity recordVideoActivity, AtomicInteger atomicInteger) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity, atomicInteger};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = recordVideoActivity;
            this.a = atomicInteger;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.b.mTvCountDown.setVisibility(8);
                if (this.b.mRecordController.f() == 6) {
                    this.b.mControllerLayout.u();
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) && this.b.mRecordController.f() == 6) {
                if (this.a.decrementAndGet() > 1) {
                    this.b.mTvCountDown.setText(String.valueOf(this.a.get() / 2));
                } else {
                    this.b.mTvCountDown.setText("");
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) && this.b.mRecordController.f() == 6) {
                this.a.set(7);
                this.b.mTvCountDown.setVisibility(0);
                this.b.mTvCountDown.setText(String.valueOf(this.a.get() / 2));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o extends wq8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordVideoActivity b;

        public o(RecordVideoActivity recordVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = recordVideoActivity;
        }

        @Override // com.repackage.wq8, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.a) {
                return;
            }
            this.b.mTopControllerLayout.setVisibility(8);
            this.b.mEffectButtonLayout.setVisibility(8);
            this.b.mTabLayout.setVisibility(8);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(441813758, "Lcom/baidu/tieba/video/record/RecordVideoActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(441813758, "Lcom/baidu/tieba/video/record/RecordVideoActivity;");
                return;
            }
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_STICKERS, TbConfig.SERVER_ADDRESS + TbConfig.GET_STICKERS);
        tbHttpMessageTask.setResponsedClass(ResponseGetStickersMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public RecordVideoActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsNeedToLoadLocalVideo = true;
        this.mAfterJumpWriteActivityListener = new g(this, 2921583);
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, lj7.class);
        lj7 lj7Var = runTask != null ? (lj7) runTask.getData() : null;
        if (lj7Var != null) {
            this.mPostMonitorManager = lj7Var.get();
        }
        hj7 hj7Var = this.mPostMonitorManager;
        if (hj7Var != null) {
            hj7Var.g();
        }
        this.mOnLocalVideoLoadedListener = new h(this);
        this.mGetStickersListener = new i(this, CmdConfigHttp.CMD_GET_STICKERS);
        this.mGuideVideoWriteListener = new e(this, 2001374);
        this.mCloseListener = new f(this, 2001373);
    }

    private void addTabByType(int i2) {
        RecordTabLayout recordTabLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65559, this, i2) == null) || (recordTabLayout = this.mTabLayout) == null) {
            return;
        }
        if (i2 == 0) {
            recordTabLayout.d(1, getString(R.string.obfuscated_res_0x7f0f1361));
            this.mTabLayout.d(2, getString(R.string.obfuscated_res_0x7f0f1362));
            this.mTabLayout.setListener(this);
            this.mTabLayout.setCurrentTab(2, false);
            onTabChoosed(2, false);
        } else if (i2 == 1) {
            recordTabLayout.d(1, getString(R.string.obfuscated_res_0x7f0f1361));
            this.mTabLayout.setShowIndicator(false);
            this.mTabLayout.setCurrentTab(1, false);
            onTabChoosed(1, false);
        } else {
            recordTabLayout.d(2, getString(R.string.obfuscated_res_0x7f0f1362));
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.setVideoPath(this.mPreviewController.r);
            videoInfo.setVideoDuration(this.mRecordController.g() / 1000);
            videoInfo.setVideoWidth(720);
            videoInfo.setVideoHeight(960);
            videoInfo.setVideoLength(new File(this.mPreviewController.r).length());
            videoInfo.setVideoSource(1);
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
            tq8 tq8Var = this.mMusicController;
            if (tq8Var != null) {
                tq8Var.g(editVideoActivityConfig);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
            hj7 hj7Var = this.mPostMonitorManager;
            if (hj7Var != null) {
                hj7Var.d();
            }
        }
    }

    private void hideTab() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            ObjectAnimator objectAnimator = this.mShowTabAnimator;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            if (this.mHideTabAnimator == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mTabLayout, AnimationProperty.OPACITY, 1.0f, 0.0f);
                this.mHideTabAnimator = ofFloat;
                ofFloat.setDuration(500L);
                this.mHideTabAnimator.addListener(new b(this));
            }
            this.mHideTabAnimator.start();
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            RecordLayout recordLayout = (RecordLayout) findViewById(R.id.obfuscated_res_0x7f091ad3);
            this.mRootLayout = recordLayout;
            recordLayout.setListener(this);
            this.mRecordController = new sq8(this);
            VideoControllerLayout videoControllerLayout = (VideoControllerLayout) findViewById(R.id.obfuscated_res_0x7f091a0f);
            this.mControllerLayout = videoControllerLayout;
            videoControllerLayout.setRecordController(this.mRecordController);
            this.mControllerLayout.setRecordControlListener(this);
            this.mControllerLayout.setEffectChoosedListener(this);
            this.mTopControllerLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f092097);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090652);
            this.mClose = imageView;
            imageView.setOnClickListener(this);
            ImageView imageView2 = (ImageView) findViewById(R.id.obfuscated_res_0x7f0909a9);
            this.mFlashSwitch = imageView2;
            imageView2.setOnClickListener(this);
            ImageView imageView3 = (ImageView) findViewById(R.id.obfuscated_res_0x7f090489);
            this.mCameraSwitch = imageView3;
            imageView3.setOnClickListener(this);
            ImageView imageView4 = (ImageView) findViewById(R.id.obfuscated_res_0x7f0906e2);
            this.mCountDown = imageView4;
            imageView4.setOnClickListener(this);
            this.mSurfaceContainer = (PreviewViewContainer) findViewById(R.id.obfuscated_res_0x7f09234b);
            rq8 rq8Var = new rq8(this);
            this.mPreviewController = rq8Var;
            rq8Var.I(this);
            this.mPreviewController.D(this);
            this.mPreviewController.F(new j(this));
            VideoEffectButtonLayout videoEffectButtonLayout = (VideoEffectButtonLayout) findViewById(R.id.obfuscated_res_0x7f09119e);
            this.mEffectButtonLayout = videoEffectButtonLayout;
            videoEffectButtonLayout.setListener(this);
            this.mRecordController.c(this.mEffectButtonLayout);
            this.mEffectButtonLayout.setViewChoosed(2, true);
            this.mTvCountDown = (TextView) findViewById(R.id.obfuscated_res_0x7f09217e);
            this.mGestureGuideView = (TextView) findViewById(R.id.obfuscated_res_0x7f090c49);
            int i2 = ((li.i(this.mContext) - li.f(this.mContext, R.dimen.obfuscated_res_0x7f0702a7)) / 2) - li.f(this.mContext, R.dimen.obfuscated_res_0x7f070250);
            if (this.mTvCountDown.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.mTvCountDown.getLayoutParams()).topMargin = i2;
            }
            if (Build.VERSION.SDK_INT < 18) {
                this.mEffectButtonLayout.setVisibility(8);
            }
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091931);
            this.mProgressView = findViewById;
            this.mRoundProgressBar = (RoundProgressBar) findViewById.findViewById(R.id.obfuscated_res_0x7f092341);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0913ee);
            this.mMinTimeTips = textView;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.leftMargin = ((int) (li.k(this.mContext) * 0.2d)) - li.f(this.mContext, R.dimen.obfuscated_res_0x7f07021d);
            this.mMinTimeTips.setLayoutParams(layoutParams);
            this.mTabLayout = (RecordTabLayout) findViewById(R.id.obfuscated_res_0x7f091e31);
            WriteImagesInfo writeImagesInfo = this.mWriteImagesInfo;
            if (writeImagesInfo != null && !ListUtils.isEmpty(writeImagesInfo.getChosedFiles())) {
                addTabByType(1);
            } else {
                addTabByType(this.bottomTabShowType);
            }
            suitAllConcaveScreen();
        }
    }

    private void loadLocalVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            xp8 xp8Var = new xp8(this);
            xp8Var.d(this.mOnLocalVideoLoadedListener);
            xp8Var.execute(new Void[0]);
        }
    }

    private void loadStickers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
            httpMessage.addParam(Config.PACKAGE_NAME, 1);
            httpMessage.addParam("rn", 999);
            sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordCompress(int i2) {
        hj7 hj7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65565, this, i2) == null) || (hj7Var = this.mPostMonitorManager) == null) {
            return;
        }
        hj7Var.i(i2, BundleOpProvider.METHOD_BUNDLE_RECORD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordVideoRecord(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65566, this, i2, str) == null) || this.mPostMonitorManager == null) {
            return;
        }
        if (StringUtils.isNull(str)) {
            str = "";
        }
        this.mPostMonitorManager.b(i2, str);
    }

    private void refreshFlashBtnUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            if (this.mPreviewController.m()) {
                this.mFlashSwitch.setVisibility(8);
            } else {
                this.mFlashSwitch.setVisibility(0);
            }
            if (this.mPreviewController.l()) {
                this.mFlashSwitch.setImageResource(R.drawable.obfuscated_res_0x7f080ae4);
            } else {
                this.mFlashSwitch.setImageResource(R.drawable.obfuscated_res_0x7f080ae3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSticker(StickerItem stickerItem, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65568, this, stickerItem, str) == null) || stickerItem == null || StringUtils.isNull(str)) {
            return;
        }
        stickerItem.localPath = str;
        rq8 rq8Var = this.mPreviewController;
        if (rq8Var != null) {
            rq8Var.H(stickerItem);
            this.mIsProcessFaceIdentifyFail = true;
        }
        if (!StringUtils.isNull(stickerItem.desc)) {
            this.mGestureGuideView.setText(stickerItem.desc);
            this.mGestureGuideView.setVisibility(0);
            this.mGestureGuideView.postDelayed(new d(this), 3000L);
            return;
        }
        this.mGestureGuideView.setVisibility(8);
    }

    private void showTab() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            ObjectAnimator objectAnimator = this.mHideTabAnimator;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            if (this.mShowTabAnimator == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mTabLayout, AnimationProperty.OPACITY, 0.0f, 1.0f);
                this.mShowTabAnimator = ofFloat;
                ofFloat.setDuration(500L);
            }
            this.mTabLayout.setVisibility(0);
            this.mShowTabAnimator.start();
        }
    }

    private void suitAllConcaveScreen() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65570, this) == null) && DeviceInfoUtil.isfullScreen()) {
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091d9e);
            this.mStatusBarView = findViewById;
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
    }

    private void suitOppoConcaveScreen() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65571, this) == null) && UtilHelper.isOppoConcaveScreen()) {
            if (this.mTopControllerLayout.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.mTopControllerLayout.getLayoutParams()).topMargin = 80;
            }
            ProgressView progressView = (ProgressView) findViewById(R.id.obfuscated_res_0x7f092342);
            if (progressView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) progressView.getLayoutParams()).topMargin = 80;
            }
        }
    }

    public List<String> getChoosedBeautyList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ArrayList arrayList = new ArrayList();
            VideoControllerLayout videoControllerLayout = this.mControllerLayout;
            if (videoControllerLayout != null && !ListUtils.isEmpty(videoControllerLayout.getChoosedBeautyList())) {
                for (oq8 oq8Var : this.mControllerLayout.getChoosedBeautyList()) {
                    if (oq8Var != null) {
                        String b2 = oq8Var.b();
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
        return (List) invokeV.objValue;
    }

    public List<String> getChoosedFilterList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            VideoControllerLayout videoControllerLayout = this.mControllerLayout;
            if (videoControllerLayout != null && !ListUtils.isEmpty(videoControllerLayout.getChoosedFilterList())) {
                for (oq8 oq8Var : this.mControllerLayout.getChoosedFilterList()) {
                    if (oq8Var != null) {
                        String str = (String) oq8Var.c();
                        if (!TextUtils.isEmpty(str)) {
                            arrayList.add(str);
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public List<String> getChoosedStickerList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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
        return (List) invokeV.objValue;
    }

    public FrameLayout getSurfaceContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mSurfaceContainer : (FrameLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void hideMinVideoTips() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mMinTimeTips.setVisibility(4);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, intent) == null) {
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
            String stringExtra = intent.getStringExtra(CloudMusicActivityConfig.MUSIC_RESOURCE);
            String stringExtra2 = intent.getStringExtra(CloudMusicActivityConfig.MUSIC_ID);
            if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
                return;
            }
            String f2 = op8.g().f(stringExtra);
            if (this.mMusicController == null || TextUtils.isEmpty(f2)) {
                return;
            }
            this.mMusicController.j(f2, stringExtra2);
            this.mControllerLayout.y();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            sq8 sq8Var = this.mRecordController;
            if (sq8Var == null || sq8Var.f() != 7) {
                sq8 sq8Var2 = this.mRecordController;
                if (sq8Var2 != null && sq8Var2.f() == 6) {
                    VideoControllerLayout videoControllerLayout = this.mControllerLayout;
                    if (videoControllerLayout != null) {
                        videoControllerLayout.D();
                    }
                    onCancelCountDowning();
                    return;
                }
                sq8 sq8Var3 = this.mRecordController;
                if (sq8Var3 != null && sq8Var3.k()) {
                    finish();
                    return;
                }
                if (this.mAlertDialog == null) {
                    dq4 dq4Var = new dq4(getPageContext().getPageActivity());
                    this.mAlertDialog = dq4Var;
                    dq4Var.setMessageId(R.string.obfuscated_res_0x7f0f1532);
                    this.mAlertDialog.setPositiveButton(R.string.obfuscated_res_0x7f0f04ea, new l(this));
                    this.mAlertDialog.setNegativeButton(R.string.obfuscated_res_0x7f0f04e5, new m(this));
                    this.mAlertDialog.setCancelable(true);
                    this.mAlertDialog.create(getPageContext());
                }
                this.mAlertDialog.show();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void onCancelCountDowning() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mCountDowningAnimaton.cancel();
            this.mCountDowningAnimaton.setAnimationListener(null);
            this.mTvCountDown.clearAnimation();
            this.mTvCountDown.setVisibility(8);
            tq8 tq8Var = this.mMusicController;
            if (tq8Var != null) {
                tq8Var.m();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            this.mMinTimeTips.setVisibility(4);
            if (view2 == this.mClose) {
                onBackPressed();
            } else if (view2 == this.mFlashSwitch) {
                if (this.mRecordController.f() == 1) {
                    TiebaStatic.log("c12294");
                } else {
                    TiebaStatic.log("c12301");
                }
                this.mPreviewController.i();
                refreshFlashBtnUI();
            } else if (view2 == this.mCameraSwitch) {
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
            } else if (view2 == this.mCountDown) {
                onClickCountDown();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickBeauty() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.mMinTimeTips.setVisibility(4);
            if (this.mRecordController.f() == 6) {
                return;
            }
            this.mControllerLayout.onClickBeauty();
        }
    }

    public void onClickCountDown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
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
            this.mCountDowningAnimaton.setAnimationListener(new n(this, atomicInteger));
            this.mTvCountDown.setAnimation(this.mCountDowningAnimaton);
            this.mCountDowningAnimaton.startNow();
            this.mControllerLayout.t();
            tq8 tq8Var = this.mMusicController;
            if (tq8Var != null) {
                tq8Var.o();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickFilter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.mMinTimeTips.setVisibility(4);
            if (this.mRecordController.f() == 6) {
                return;
            }
            this.mControllerLayout.onClickFilter();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickMusic() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.mRecordController.f() == 1) {
            this.mMinTimeTips.setVisibility(4);
            if (this.mRecordController.f() == 6) {
                return;
            }
            this.mControllerLayout.onClickMusic();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void onClickSticker() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.mMinTimeTips.setVisibility(4);
            if (this.mRecordController.f() == 6) {
                return;
            }
            this.mControllerLayout.onClickSticker();
            if (this.mControllerLayout.s()) {
                loadStickers();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            TiebaStatic.log("c12293");
            this.mContext = getPageContext().getPageActivity();
            setIsAddSwipeBackLayout(false);
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0712);
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
            selectMusicModel.z();
            tq8 tq8Var = new tq8(this);
            this.mMusicController = tq8Var;
            tq8Var.t(this.mMusicModel);
            this.mRecordController.c(this.mMusicController);
            registerListener(this.mGetStickersListener);
            registerListener(this.mGuideVideoWriteListener);
            registerListener(this.mCloseListener);
            registerListener(this.mAfterJumpWriteActivityListener);
            loadStickers();
            if (Build.VERSION.SDK_INT >= 28 && RomTypeUtil.isOPPO() && TbSingleton.getInstance().isCutoutScreen(this)) {
                ho8.b(1, getWindow().getAttributes(), getWindow());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            sq8 sq8Var = this.mRecordController;
            if (sq8Var != null && sq8Var.j()) {
                this.mRecordController.o();
            }
            SelectMusicModel selectMusicModel = this.mMusicModel;
            if (selectMusicModel != null) {
                selectMusicModel.cancelLoadData();
            }
            hj7 hj7Var = this.mPostMonitorManager;
            if (hj7Var != null) {
                hj7Var.k(BundleOpProvider.METHOD_BUNDLE_RECORD);
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.h
    public void onEffectChoosed(oq8 oq8Var, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, oq8Var, obj) == null) || this.mPreviewController == null || oq8Var == null) {
            return;
        }
        int type = oq8Var.getType();
        if (type == 1) {
            if (oq8Var.c() instanceof so8) {
                this.mPreviewController.B((so8) oq8Var.c());
                TiebaStatic.log(new StatisticItem("c12421").param("obj_id", ((so8) oq8Var.c()).a));
                if (((so8) oq8Var.c()).a == 0) {
                    this.mEffectButtonLayout.setViewChoosed(2, false);
                } else {
                    this.mEffectButtonLayout.setViewChoosed(2, true);
                }
            }
        } else if (type != 2) {
            if (type == 3 && (oq8Var.c() instanceof MusicData)) {
                this.mMusicController.k((MusicData) oq8Var.c(), obj);
                if (((MusicData) oq8Var.c()).editMusicType == 1) {
                    this.mEffectButtonLayout.setViewChoosed(0, false);
                } else {
                    this.mEffectButtonLayout.setViewChoosed(0, true);
                }
            }
        } else if (oq8Var.c() instanceof String) {
            this.mPreviewController.E((String) oq8Var.c());
            StatisticItem statisticItem = new StatisticItem("c12496");
            statisticItem.param("obj_id", (String) oq8Var.c());
            if (this.mRecordController.f() == 1) {
                statisticItem.param("obj_type", 1);
            } else {
                statisticItem.param("obj_type", 2);
            }
            if (oq8Var.c().equals("origin")) {
                this.mEffectButtonLayout.setViewChoosed(3, false);
            } else {
                this.mEffectButtonLayout.setViewChoosed(3, true);
            }
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.b
    public void onFaceIdentifyState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            sq8 sq8Var = this.mRecordController;
            if (sq8Var != null && (sq8Var.f() == 1 || this.mRecordController.f() == 3 || this.mRecordController.f() == 4)) {
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
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void onHideEffectLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.mEffectButtonLayout.c();
            if (this.mRecordController.f() == 1) {
                showTab();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onPause();
            this.mPreviewController.u();
            if (this.mControllerLayout != null) {
                sq8 sq8Var = this.mRecordController;
                if (sq8Var != null && sq8Var.f() == 6) {
                    this.mControllerLayout.D();
                    onCancelCountDowning();
                }
                sq8 sq8Var2 = this.mRecordController;
                if (sq8Var2 != null && sq8Var2.j()) {
                    this.mControllerLayout.D();
                }
            }
            tq8 tq8Var = this.mMusicController;
            if (tq8Var != null) {
                tq8Var.l();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void onRecordDone() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || this.mProgressView.getVisibility() == 0) {
            return;
        }
        this.mControllerLayout.E();
        this.mRecordController.m(8);
        onStopRecord();
        List<String> list = this.mPreviewController.q;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mProgressView.setVisibility(0);
        new c(this).execute(new Void[0]);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void onRecordShort() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.mMinTimeTips.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onRestart();
            if (this.mRecordController.f() == 8) {
                this.mControllerLayout.F();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onResume();
            this.mPreviewController.v();
            mq8 k2 = this.mPreviewController.k();
            this.mZoomHelper = k2;
            if (k2 != null) {
                k2.c(this.mRecordController);
                this.mSurfaceContainer.setZoomHelper(this.mZoomHelper);
            }
            refreshFlashBtnUI();
            if (this.mStickerManager == null) {
                vq8 vq8Var = new vq8();
                this.mStickerManager = vq8Var;
                vq8Var.k(new k(this));
            }
            this.mStickerManager.e();
            if (this.mControllerLayout != null && this.mIsNeedToLoadLocalVideo) {
                loadLocalVideo();
            }
            hj7 hj7Var = this.mPostMonitorManager;
            if (hj7Var != null) {
                hj7Var.e("album");
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void onShowEffectLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            hideTab();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onStart();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void onStartRecord() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.mIsRecordingState = true;
            AnimatorSet animatorSet = this.mStopRecodingAnimatorSet;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.mStopRecodingAnimatorSet.cancel();
            }
            if (this.mStartRecodingAnimatorSet == null) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.mStartRecodingAnimatorSet = animatorSet2;
                animatorSet2.playTogether(ObjectAnimator.ofFloat(this.mTopControllerLayout, AnimationProperty.OPACITY, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.mEffectButtonLayout, AnimationProperty.OPACITY, 1.0f, 0.0f), ObjectAnimator.ofFloat(this.mTabLayout, AnimationProperty.OPACITY, 1.0f, 0.0f));
                this.mStartRecodingAnimatorSet.addListener(new o(this));
                this.mStartRecodingAnimatorSet.setDuration(300L);
            }
            this.mStartRecodingAnimatorSet.start();
            this.mEffectButtonLayout.c();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void onStatusChange() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && this.mRecordController.f() == 1) {
            this.mTabLayout.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.h
    public void onStickerChoosed(StickerItem stickerItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, stickerItem) == null) || stickerItem == null) {
            return;
        }
        this.mCurrentSticker = stickerItem;
        this.mStickerManager.j(stickerItem.resource);
        if (stickerItem.id == -1) {
            rq8 rq8Var = this.mPreviewController;
            if (rq8Var != null) {
                rq8Var.H(null);
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onStop();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.f
    public void onStopRecord() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            if (this.mCurrentTab == 2) {
                if (!this.mIsRecordingState) {
                    return;
                }
                this.mIsRecordingState = false;
                tq8 tq8Var = this.mMusicController;
                if (tq8Var != null) {
                    tq8Var.o();
                }
            }
            AnimatorSet animatorSet = this.mStartRecodingAnimatorSet;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.mStartRecodingAnimatorSet.cancel();
            }
            if (this.mStopRecodingAnimatorSet == null) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.mStopRecodingAnimatorSet = animatorSet2;
                animatorSet2.playTogether(ObjectAnimator.ofFloat(this.mTopControllerLayout, AnimationProperty.OPACITY, 0.0f, 1.0f), ObjectAnimator.ofFloat(this.mEffectButtonLayout, AnimationProperty.OPACITY, 0.0f, 1.0f), ObjectAnimator.ofFloat(this.mTabLayout, AnimationProperty.OPACITY, 0.0f, 1.0f));
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
    }

    @Override // com.repackage.rq8.l
    public void onSurfaceViewLayoutChange(int i2, int i3) {
        int dimensionPixelOffset;
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048607, this, i2, i3) == null) || (dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f0702a7)) <= 0 || i3 <= 0 || (i4 = (li.r(this).heightPixels - i3) - dimensionPixelOffset) <= 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.mControllerLayout.getLayoutParams();
        layoutParams.height = dimensionPixelOffset + i4;
        this.mControllerLayout.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.video.record.RecordTabLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onTabChoosed(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.mCurrentTab == i2) {
            return;
        }
        int i3 = 2;
        if (i2 == 1) {
            tq8 tq8Var = this.mMusicController;
            if (tq8Var != null) {
                tq8Var.r();
            }
            this.mPreviewController.E("origin");
            this.mEffectButtonLayout.setViewChoosed(0, false);
            this.mEffectButtonLayout.setViewChoosed(3, false);
            this.mControllerLayout.k(1);
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
        rq8 rq8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (rq8Var = this.mPreviewController) == null) {
            return;
        }
        rq8Var.N(new a(this));
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void onTouchToLeft() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && this.mRecordController.f() == 1 && !this.mControllerLayout.r()) {
            onTabChoosed(2, true);
            this.mTabLayout.setCurrentTab(2, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void onTouchToRight() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && this.mRecordController.f() == 1 && !this.mControllerLayout.r()) {
            onTabChoosed(1, true);
            this.mTabLayout.setCurrentTab(1, true);
        }
    }
}
