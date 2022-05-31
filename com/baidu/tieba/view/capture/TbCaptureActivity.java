package com.baidu.tieba.view.capture;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RawRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.TbEditVideoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tbadk.data.TbMusicData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.external.filter.ResponseGetQmFiltersMessage;
import com.baidu.tieba.external.music.data.MusicData;
import com.baidu.tieba.external.sticker.ResponseGetQmStickersMessage;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.view.widget.HorizontalCenterSelectView;
import com.baidu.tieba.view.widget.RecordPreviewContainer;
import com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout;
import com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dv5;
import com.repackage.ev5;
import com.repackage.fv5;
import com.repackage.g66;
import com.repackage.gv5;
import com.repackage.gy5;
import com.repackage.h66;
import com.repackage.hj7;
import com.repackage.hv5;
import com.repackage.i66;
import com.repackage.it8;
import com.repackage.iv5;
import com.repackage.iy5;
import com.repackage.jg;
import com.repackage.jo8;
import com.repackage.jv5;
import com.repackage.jy5;
import com.repackage.k66;
import com.repackage.ko8;
import com.repackage.kv5;
import com.repackage.ky5;
import com.repackage.lj7;
import com.repackage.m66;
import com.repackage.mg;
import com.repackage.mq4;
import com.repackage.n66;
import com.repackage.oq4;
import com.repackage.vc0;
import com.repackage.wq4;
import com.repackage.wt8;
import com.repackage.ys4;
import com.repackage.yu8;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class TbCaptureActivity extends BaseActivity<TbCaptureActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isRecordFinished;
    public CustomMessageListener mAfterJumpWriteActivityListener;
    public ImageView mCaptureAlbum;
    public RelativeLayout mCaptureAlbumContainer;
    public TextView mCaptureAlbumText;
    public ImageView mCaptureClose;
    public ImageView mCaptureDelete;
    public RelativeLayout mCaptureDeleteContainer;
    public TextView mCaptureDeleteText;
    public ImageView mCaptureFilter;
    public RelativeLayout mCaptureFilterContainer;
    public TextView mCaptureFilterText;
    public TBLottieAnimationView mCaptureGuide;
    public RelativeLayout mCaptureGuideContainer;
    public ImageView mCaptureMusic;
    public RelativeLayout mCaptureMusicContainer;
    public TextView mCaptureMusicText;
    public ImageView mCaptureNext;
    public RelativeLayout mCaptureNextContainer;
    public TextView mCaptureNextText;
    public ImageView mCaptureRatio;
    public LinearLayout mCaptureRightContainer;
    public ImageView mCaptureSpeed;
    public ImageView mCaptureSticker;
    public RelativeLayout mCaptureStickerContainer;
    public TextView mCaptureStickerText;
    public ImageView mCaptureSwitch;
    public RelativeLayout mCaptureTopContainer;
    public TbMusicData mCurrentMusicData;
    public dv5.a mDeleteLastCallBack;
    public g66.b mDownloadFilterCallback;
    public n66.b mDownloadStickerCallback;
    public List<String> mDurationData;
    public dv5 mDurationManager;
    public Map<String, Integer> mDurationMap;
    public h66 mFilterManager;
    public TextView mFilterName;
    public HttpMessageListener mGetQmFiltersListener;
    public HttpMessageListener mGetQmStickersListener;
    public HorizontalCenterSelectView mMaxDuration;
    public gy5 mMuxerManager;
    public dv5.b mNeedSpeedCallBack;
    public dv5.c mOnFinishedCallBack;
    public jy5.a mOnProgressCallBack;
    public jy5.b mOnRecordStopSuccessCallBack;
    public hj7 mPostMonitorManager;
    public fv5 mRatioChangedCallBack;
    public int mRatioDrawableId;
    public gv5 mRatioManager;
    public int mRatioSelectedDrawableId;
    public jy5 mRecordManager;
    public i66 mRecordMusicManager;
    public RecordPreviewContainer mRecordPreviewContainer;
    public TextView mRecordTimeView;
    public View mRootView;
    public iv5 mSpeedChangedCallBack;
    public jv5 mSpeedManager;
    public m66 mStickerManager;
    public VideoControllerLayout mVideoControllerLayout;
    public ArrayList<String> mVideoPartList;

    /* loaded from: classes4.dex */
    public class a implements g66.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCaptureActivity a;

        public a(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCaptureActivity;
        }

        @Override // com.repackage.g66.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.mVideoControllerLayout != null) {
                    QmFilterItem qmFilterItem = new QmFilterItem();
                    qmFilterItem.id = "-1";
                    qmFilterItem.bgurl = R.drawable.obfuscated_res_0x7f080a04 + "";
                    qmFilterItem.name = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f061e);
                    qmFilterItem.isSelect = true;
                    qmFilterItem.localPath = "origin";
                    this.a.mVideoControllerLayout.A(qmFilterItem);
                    if (this.a.mFilterManager != null) {
                        this.a.mFilterManager.a(null);
                    }
                    this.a.mVideoControllerLayout.setDownLoadFilter(null);
                }
                if (StringUtils.isNull(str)) {
                    str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1203);
                }
                this.a.showToast(str);
                this.a.mPostMonitorManager.b(5, str);
            }
        }

        @Override // com.repackage.g66.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.mVideoControllerLayout == null) {
                return;
            }
            this.a.mVideoControllerLayout.setDownLoadFilter(null);
        }

        @Override // com.repackage.g66.b
        public void c(QmFilterItem qmFilterItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qmFilterItem) == null) {
                if (this.a.mFilterManager != null) {
                    this.a.mFilterManager.a(qmFilterItem);
                }
                if (this.a.mVideoControllerLayout != null) {
                    this.a.mVideoControllerLayout.setDownLoadFilter(null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements n66.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCaptureActivity a;

        public b(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCaptureActivity;
        }

        @Override // com.repackage.n66.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.mVideoControllerLayout != null) {
                    QmStickerItem qmStickerItem = new QmStickerItem();
                    qmStickerItem.id = -1;
                    qmStickerItem.isLocalSource = true;
                    qmStickerItem.localPath = "nosticker";
                    this.a.mVideoControllerLayout.B(qmStickerItem);
                    if (this.a.mStickerManager != null) {
                        this.a.mStickerManager.b(null);
                    }
                    this.a.mVideoControllerLayout.setDownLoadSticker(qmStickerItem, false);
                }
                if (StringUtils.isNull(str)) {
                    str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1203);
                }
                this.a.showToast(str);
                this.a.mPostMonitorManager.b(5, str);
            }
        }

        @Override // com.repackage.n66.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.mVideoControllerLayout == null) {
                return;
            }
            this.a.mVideoControllerLayout.setDownLoadSticker(null, false);
        }

        @Override // com.repackage.n66.b
        public void c(QmStickerItem qmStickerItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qmStickerItem) == null) {
                if (this.a.mStickerManager != null) {
                    this.a.mStickerManager.b(qmStickerItem);
                }
                if (this.a.mVideoControllerLayout != null) {
                    this.a.mVideoControllerLayout.setDownLoadSticker(qmStickerItem, true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCaptureActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(TbCaptureActivity tbCaptureActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity, Integer.valueOf(i)};
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
            this.a = tbCaptureActivity;
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
    public class d implements oq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mq4 a;
        public final /* synthetic */ TbCaptureActivity b;

        public d(TbCaptureActivity tbCaptureActivity, mq4 mq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity, mq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tbCaptureActivity;
            this.a = mq4Var;
        }

        @Override // com.repackage.oq4.e
        public void onItemClick(oq4 oq4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, oq4Var, i, view2) == null) {
                if (i == 0) {
                    this.b.resetCapturePage();
                    this.a.dismiss();
                } else if (i == 1) {
                    this.b.finish();
                } else {
                    this.a.dismiss();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements gy5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCaptureActivity a;

        public e(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCaptureActivity;
        }

        @Override // com.repackage.gy5.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TbCaptureActivity tbCaptureActivity = this.a;
                tbCaptureActivity.hideLoadingView(tbCaptureActivity.mRootView);
            }
        }

        @Override // com.repackage.gy5.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                TbCaptureActivity tbCaptureActivity = this.a;
                tbCaptureActivity.showLoadingView(tbCaptureActivity.mRootView);
            }
        }

        @Override // com.repackage.gy5.a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                VideoFileInfo c = jo8.c(str);
                if (c == null) {
                    TbCaptureActivity tbCaptureActivity = this.a;
                    tbCaptureActivity.hideLoadingView(tbCaptureActivity.mRootView);
                    return;
                }
                TbMultiMediaData tbMultiMediaData = new TbMultiMediaData();
                tbMultiMediaData.path = str;
                tbMultiMediaData.width = c.videoWidth;
                tbMultiMediaData.height = c.videoHeight;
                tbMultiMediaData.type = 1;
                tbMultiMediaData.start = 0L;
                int i = c.videoDuration;
                tbMultiMediaData.end = i;
                tbMultiMediaData.originalDuration = i;
                tbMultiMediaData.scaleType = "center_crop";
                tbMultiMediaData.videoInfoSource = 1;
                TbEditVideoActivityConfig tbEditVideoActivityConfig = new TbEditVideoActivityConfig(this.a.getActivity());
                tbEditVideoActivityConfig.getIntent().putExtras(this.a.getIntent());
                tbEditVideoActivityConfig.setMultiMediaData(tbMultiMediaData);
                tbEditVideoActivityConfig.setVideoFrom(2);
                if (this.a.mCurrentMusicData != null && this.a.mRecordMusicManager != null) {
                    this.a.mCurrentMusicData.localPath = this.a.mRecordMusicManager.b();
                    tbEditVideoActivityConfig.setMusicData(this.a.mCurrentMusicData);
                }
                if (this.a.mRatioManager != null) {
                    tbEditVideoActivityConfig.setVideoRatio(this.a.mRatioManager.getRatio());
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbEditVideoActivityConfig));
                TbCaptureActivity tbCaptureActivity2 = this.a;
                tbCaptureActivity2.hideLoadingView(tbCaptureActivity2.mRootView);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements RecordEffectLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCaptureActivity a;

        public f(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCaptureActivity;
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void a(QmStickerItem qmStickerItem) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, qmStickerItem) == null) || qmStickerItem == null || this.a.mStickerManager == null) {
                return;
            }
            String a = this.a.mStickerManager.a(qmStickerItem.fileUrl);
            if (StringUtils.isNull(a) && -1 != qmStickerItem.id) {
                if (this.a.mVideoControllerLayout != null) {
                    this.a.mVideoControllerLayout.setDownLoadSticker(qmStickerItem, false);
                }
                this.a.mStickerManager.d(qmStickerItem);
                return;
            }
            qmStickerItem.localPath = a;
            this.a.mStickerManager.b(qmStickerItem);
            if (this.a.mVideoControllerLayout != null) {
                this.a.mVideoControllerLayout.setDownLoadSticker(qmStickerItem, true);
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void b(yu8 yu8Var, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yu8Var, obj) == null) || yu8Var == null) {
                return;
            }
            int type = yu8Var.getType();
            if (type == 2) {
                if (this.a.mFilterManager != null && (yu8Var.c() instanceof QmFilterItem)) {
                    QmFilterItem qmFilterItem = (QmFilterItem) yu8Var.c();
                    String f = this.a.mFilterManager.f(qmFilterItem.fileUrl);
                    if (StringUtils.isNull(f) && !"-1".equals(qmFilterItem.id)) {
                        if (this.a.mVideoControllerLayout != null) {
                            this.a.mVideoControllerLayout.setDownLoadFilter(qmFilterItem);
                        }
                        this.a.mFilterManager.c(qmFilterItem);
                        return;
                    }
                    qmFilterItem.localPath = f;
                    this.a.mFilterManager.a(qmFilterItem);
                    if (this.a.mVideoControllerLayout != null) {
                        this.a.mVideoControllerLayout.setDownLoadFilter(null);
                    }
                }
            } else if (type == 3 && (yu8Var.c() instanceof MusicData)) {
                MusicData musicData = (MusicData) yu8Var.c();
                TbMusicData tbMusicData = new TbMusicData();
                tbMusicData.id = musicData.id;
                tbMusicData.title = musicData.name;
                tbMusicData.url = musicData.resource;
                tbMusicData.icon = musicData.img;
                tbMusicData.type = jg.e(musicData.type, 1);
                if (MusicData.MUSIC_NORMAL_ID.equals(musicData.id) || MusicData.MUSIC_CLOUD_ID.equals(musicData.id)) {
                    this.a.mRecordMusicManager.e(this.a.mCurrentMusicData);
                    this.a.mCurrentMusicData = tbMusicData;
                    if (!MusicData.MUSIC_CLOUD_ID.equals(musicData.id)) {
                        this.a.mVideoControllerLayout.setMusicName(this.a.mCurrentMusicData.title, "");
                    }
                } else {
                    this.a.mCurrentMusicData = tbMusicData;
                    this.a.mRecordMusicManager.e(this.a.mCurrentMusicData);
                    this.a.mVideoControllerLayout.setMusicName(this.a.mCurrentMusicData.title, "");
                }
                this.a.mRecordMusicManager.c((MusicData) yu8Var.c(), obj);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements VideoControllerLayout.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCaptureActivity a;

        public g(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCaptureActivity;
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!ListUtils.isEmpty(this.a.mVideoPartList) || this.a.mRecordManager.c()) {
                    if (this.a.mRecordManager.c()) {
                        this.a.mCaptureStickerContainer.setVisibility(8);
                    } else {
                        this.a.mCaptureStickerContainer.setVisibility(0);
                    }
                    this.a.mCaptureDeleteContainer.setVisibility(0);
                    this.a.setNextVisibility(0);
                    this.a.mMaxDuration.setVisibility(8);
                    this.a.mCaptureAlbumContainer.setVisibility(8);
                    return;
                }
                if (z) {
                    this.a.mMaxDuration.setVisibility(8);
                    this.a.mCaptureStickerContainer.setVisibility(8);
                    this.a.mCaptureAlbumContainer.setVisibility(8);
                } else {
                    this.a.mMaxDuration.setVisibility(0);
                    this.a.mCaptureStickerContainer.setVisibility(0);
                    this.a.mCaptureAlbumContainer.setVisibility(0);
                }
                this.a.mCaptureDeleteContainer.setVisibility(8);
                this.a.setNextVisibility(8);
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void hideMinVideoTips() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.mMaxDuration.setVisibility(8);
                this.a.mCaptureStickerContainer.setVisibility(8);
                this.a.mCaptureAlbumContainer.setVisibility(8);
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void onShowEffectLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.mMaxDuration.setVisibility(8);
                this.a.mCaptureStickerContainer.setVisibility(8);
                this.a.mCaptureAlbumContainer.setVisibility(8);
                this.a.mCaptureDeleteContainer.setVisibility(8);
                this.a.setNextVisibility(8);
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void onStartRecord() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.a.mDurationManager == null) {
                return;
            }
            if (this.a.mDurationManager.getProgress() < this.a.mDurationManager.getMaxDuration()) {
                this.a.mRecordManager.startRecord();
                this.a.mCaptureTopContainer.setVisibility(8);
                this.a.mCaptureRightContainer.setVisibility(8);
                this.a.hideTopMenus();
                this.a.resetEffectIcon();
                this.a.mCaptureDeleteContainer.setVisibility(8);
                if (this.a.mDurationManager.getProgress() < 3.0f) {
                    this.a.setNextVisibility(8);
                } else {
                    this.a.setNextVisibility(0);
                }
                this.a.mCaptureStickerContainer.setVisibility(8);
                this.a.resetDeleteStatus();
                if (this.a.mRecordMusicManager != null) {
                    this.a.mRecordMusicManager.a(this.a.mDurationManager.getProgress());
                }
                this.a.isRecordFinished = false;
            } else if (this.a.mDurationManager.getProgress() < this.a.mDurationManager.getMaxDuration() || this.a.mVideoControllerLayout == null) {
            } else {
                this.a.mVideoControllerLayout.F();
                if (this.a.mMuxerManager != null) {
                    this.a.mMuxerManager.b(this.a.mVideoPartList);
                }
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void onStopRecord() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.a.mRecordManager == null) {
                return;
            }
            this.a.mRecordManager.stopRecord();
            this.a.mCaptureTopContainer.setVisibility(0);
            this.a.mCaptureRightContainer.setVisibility(0);
            this.a.mCaptureDeleteContainer.setVisibility(0);
            this.a.setNextVisibility(0);
            this.a.mCaptureStickerContainer.setVisibility(0);
            if (this.a.mRecordMusicManager != null) {
                this.a.mRecordMusicManager.pause();
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void onTakePhoto() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements HorizontalCenterSelectView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCaptureActivity a;

        public h(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCaptureActivity;
        }

        @Override // com.baidu.tieba.view.widget.HorizontalCenterSelectView.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.mDurationManager == null) {
                return;
            }
            this.a.mDurationManager.setMaxDuration(((Integer) this.a.mDurationMap.get((String) this.a.mDurationData.get(i))).intValue());
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCaptureActivity a;

        public i(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCaptureActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.mCaptureGuide.pauseAnimation();
                this.a.mCaptureGuideContainer.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements RecordPreviewContainer.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCaptureActivity a;

        public j(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCaptureActivity;
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.e
        public void a(MotionEvent motionEvent, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, motionEvent, i) == null) || this.a.mRecordManager == null) {
                return;
            }
            it8.D(this.a.getPageContext()).l(i);
            this.a.resetDeleteStatus();
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.e
        public void b(MotionEvent motionEvent, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || this.a.mRecordManager == null) {
                return;
            }
            it8.D(this.a.getPageContext()).c(i, i2, i3, i4);
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements jy5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCaptureActivity a;

        public k(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCaptureActivity;
        }

        @Override // com.repackage.jy5.b
        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (this.a.mDurationManager != null) {
                    this.a.mDurationManager.pause();
                    if (!StringUtils.isNull(str)) {
                        this.a.mVideoPartList.add(str);
                        if (this.a.isRecordFinished && ListUtils.getCount(this.a.mVideoPartList) == this.a.mDurationManager.getSlideNum() && this.a.mMuxerManager != null) {
                            this.a.mMuxerManager.b(this.a.mVideoPartList);
                        }
                    }
                    this.a.updateButtonDisableByRecord();
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.repackage.jy5.b
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.mDurationManager != null) {
                    if (ListUtils.isEmpty(this.a.mVideoPartList) && this.a.mVideoControllerLayout != null) {
                        this.a.mVideoControllerLayout.E();
                    }
                    this.a.mDurationManager.start();
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCaptureActivity a;

        public l(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCaptureActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.mFilterName.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements RecordPreviewContainer.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Runnable a;
        public final /* synthetic */ TbCaptureActivity b;

        public m(TbCaptureActivity tbCaptureActivity, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tbCaptureActivity;
            this.a = runnable;
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void a(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) || this.b.mRecordManager == null || this.b.mRecordManager.c() || this.b.mFilterManager == null) {
                return;
            }
            this.b.mFilterManager.g();
            String currentFilterName = this.b.mVideoControllerLayout.getCurrentFilterName();
            if (!StringUtils.isNull(currentFilterName)) {
                this.b.mFilterName.removeCallbacks(this.a);
                this.b.mFilterName.setText(currentFilterName);
                this.b.mFilterName.setVisibility(0);
                this.b.mFilterName.postDelayed(this.a, 800L);
            }
            this.b.resetDeleteStatus();
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void b(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent) == null) || this.b.mRecordManager == null || this.b.mRecordManager.c() || this.b.mFilterManager == null) {
                return;
            }
            this.b.mFilterManager.e();
            String currentFilterName = this.b.mVideoControllerLayout.getCurrentFilterName();
            if (!StringUtils.isNull(currentFilterName)) {
                this.b.mFilterName.removeCallbacks(this.a);
                this.b.mFilterName.setText(currentFilterName);
                this.b.mFilterName.setVisibility(0);
                this.b.mFilterName.postDelayed(this.a, 800L);
            }
            this.b.resetDeleteStatus();
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void c(MotionEvent motionEvent, float f, float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, Float.valueOf(f), Float.valueOf(f2)}) == null) || this.b.mRecordManager == null || this.b.mRecordManager.c()) {
                return;
            }
            this.b.mRecordManager.d();
            this.b.resetDeleteStatus();
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void d(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
                this.b.hideTopMenus();
                this.b.resetEffectIcon();
                if (this.b.mVideoControllerLayout != null && this.b.mVideoControllerLayout.q()) {
                    this.b.mVideoControllerLayout.n(null, false);
                }
                if (this.b.mRecordManager == null || this.b.mRecordManager.c() || this.b.mRecordPreviewContainer == null) {
                    return;
                }
                this.b.mRecordPreviewContainer.i(motionEvent);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements jy5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCaptureActivity a;

        public n(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCaptureActivity;
        }

        @Override // com.repackage.jy5.a
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048576, this, j) == null) || this.a.mDurationManager == null) {
                return;
            }
            this.a.mDurationManager.setProgress(j);
            if (this.a.mDurationManager.getProgress() >= 3.0f) {
                this.a.setNextVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements dv5.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCaptureActivity a;

        public o(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCaptureActivity;
        }

        @Override // com.repackage.dv5.c
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.isRecordFinished = true;
                if (this.a.mRecordManager != null && !this.a.mRecordManager.c() && this.a.isRecordFinished && ListUtils.getCount(this.a.mVideoPartList) == this.a.mDurationManager.getSlideNum() && this.a.mMuxerManager != null) {
                    this.a.mMuxerManager.b(this.a.mVideoPartList);
                }
                if (this.a.mVideoControllerLayout != null) {
                    this.a.mVideoControllerLayout.F();
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class p implements dv5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCaptureActivity a;

        public p(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCaptureActivity;
        }

        @Override // com.repackage.dv5.b
        public float a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.mSpeedManager != null) {
                    return this.a.mSpeedManager.a();
                }
                return 1.0f;
            }
            return invokeV.floatValue;
        }
    }

    /* loaded from: classes4.dex */
    public class q implements dv5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCaptureActivity a;

        public q(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCaptureActivity;
        }

        @Override // com.repackage.dv5.a
        public boolean a(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
                if (ListUtils.isEmpty(this.a.mVideoPartList)) {
                    return false;
                }
                this.a.mVideoPartList.remove(this.a.mVideoPartList.size() - 1);
                if (this.a.mVideoPartList.size() <= 0) {
                    if (this.a.mDurationManager != null) {
                        this.a.mDurationManager.reset();
                    }
                    this.a.mCaptureDeleteContainer.setVisibility(8);
                    this.a.setNextVisibility(8);
                    this.a.mMaxDuration.setVisibility(0);
                    this.a.mVideoControllerLayout.G();
                    this.a.mCaptureStickerContainer.setVisibility(0);
                    this.a.mCaptureAlbumContainer.setVisibility(0);
                }
                this.a.updateButtonDisableByRecord();
                return true;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class r implements iv5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCaptureActivity a;

        public r(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCaptureActivity;
        }

        @Override // com.repackage.iv5
        public boolean a(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
                if (this.a.mRecordManager == null || this.a.mRecordManager.e() == null) {
                    return false;
                }
                this.a.mRecordManager.e().a(f);
                if (this.a.mSpeedManager != null) {
                    TbCaptureActivity tbCaptureActivity = this.a;
                    tbCaptureActivity.updateSpeedButtonStyle(tbCaptureActivity.mSpeedManager.b() == 0);
                }
                return true;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class s implements fv5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCaptureActivity a;

        public s(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCaptureActivity;
        }

        @Override // com.repackage.fv5
        public boolean a(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
                if (this.a.mRecordManager == null || this.a.mRecordManager.f() == null) {
                    return false;
                }
                this.a.mRecordManager.f().a(f);
                this.a.updateRatioButtonResId();
                return true;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class t extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCaptureActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(TbCaptureActivity tbCaptureActivity, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCaptureActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ResponseGetQmStickersMessage)) {
                List<QmStickerItem> stickerItems = httpResponsedMessage.getError() == 0 ? ((ResponseGetQmStickersMessage) httpResponsedMessage).getStickerItems() : null;
                if (this.a.mVideoControllerLayout != null) {
                    if (stickerItems == null) {
                        stickerItems = new ArrayList<>();
                    }
                    for (QmStickerItem qmStickerItem : stickerItems) {
                        if (qmStickerItem != null && this.a.mStickerManager != null && !StringUtils.isNull(qmStickerItem.fileUrl) && !StringUtils.isNull(this.a.mStickerManager.a(qmStickerItem.fileUrl))) {
                            qmStickerItem.isLocalSource = true;
                        }
                    }
                    QmStickerItem qmStickerItem2 = new QmStickerItem();
                    qmStickerItem2.id = -1;
                    qmStickerItem2.isSelect = true;
                    qmStickerItem2.isLocalSource = true;
                    qmStickerItem2.localPath = "nosticker";
                    stickerItems.add(0, qmStickerItem2);
                    this.a.mVideoControllerLayout.setStickerItems(stickerItems);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCaptureActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(TbCaptureActivity tbCaptureActivity, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbCaptureActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ResponseGetQmFiltersMessage)) {
                List<QmFilterItem> filterItems = httpResponsedMessage.getError() == 0 ? ((ResponseGetQmFiltersMessage) httpResponsedMessage).getFilterItems() : null;
                if (this.a.mVideoControllerLayout != null) {
                    if (filterItems == null) {
                        filterItems = new ArrayList<>();
                    }
                    QmFilterItem qmFilterItem = new QmFilterItem();
                    qmFilterItem.id = "-1";
                    qmFilterItem.bgurl = R.drawable.obfuscated_res_0x7f080a04 + "";
                    qmFilterItem.name = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f061e);
                    qmFilterItem.isSelect = true;
                    qmFilterItem.localPath = "origin";
                    filterItems.add(0, qmFilterItem);
                    this.a.mVideoControllerLayout.setFilterData(filterItems);
                }
            }
        }
    }

    public TbCaptureActivity() {
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
        this.mVideoPartList = new ArrayList<>();
        this.isRecordFinished = false;
        this.mRatioDrawableId = R.drawable.obfuscated_res_0x7f0809e9;
        this.mRatioSelectedDrawableId = R.drawable.obfuscated_res_0x7f0809ea;
        this.mOnRecordStopSuccessCallBack = new k(this);
        this.mOnProgressCallBack = new n(this);
        this.mOnFinishedCallBack = new o(this);
        this.mNeedSpeedCallBack = new p(this);
        this.mDeleteLastCallBack = new q(this);
        this.mSpeedChangedCallBack = new r(this);
        this.mRatioChangedCallBack = new s(this);
        this.mGetQmStickersListener = new t(this, CmdConfigHttp.CMD_GET_QM_STICKERS, true);
        this.mGetQmFiltersListener = new u(this, CmdConfigHttp.CMD_GET_QM_FILTERS, true);
        this.mDownloadFilterCallback = new a(this);
        this.mDownloadStickerCallback = new b(this);
        this.mAfterJumpWriteActivityListener = new c(this, 2921583);
    }

    private void backDialogShow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            dv5 dv5Var = this.mDurationManager;
            if (dv5Var != null && dv5Var.getProgress() > 0.0f) {
                mq4 mq4Var = new mq4(getPageContext(), new oq4(getPageContext().getPageActivity()));
                mq4Var.j(null, new String[]{getString(R.string.obfuscated_res_0x7f0f0385), getResources().getString(R.string.obfuscated_res_0x7f0f0f51)}, new d(this, mq4Var));
                mq4Var.m();
                return;
            }
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTopMenus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            jv5 jv5Var = this.mSpeedManager;
            if (jv5Var != null) {
                jv5Var.c(8);
            }
            gv5 gv5Var = this.mRatioManager;
            if (gv5Var != null) {
                gv5Var.c(8);
            }
        }
    }

    private void initListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65575, this) == null) {
            registerListener(this.mGetQmStickersListener);
            registerListener(this.mGetQmFiltersListener);
            registerListener(this.mAfterJumpWriteActivityListener);
            this.mRecordPreviewContainer.setOnPreviewStateChangedListener(new j(this));
            this.mRecordPreviewContainer.setOnViewClickListener(new m(this, new l(this)));
        }
    }

    private void initManager() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
            this.mRecordPreviewContainer = (RecordPreviewContainer) findViewById(R.id.obfuscated_res_0x7f0904aa);
            this.mRecordManager = new ky5(getPageContext(), this.mRecordPreviewContainer.getSurfaceView(), true, this.mOnRecordStopSuccessCallBack, this.mOnProgressCallBack);
            n66 n66Var = new n66(this.mRecordManager);
            this.mStickerManager = n66Var;
            n66Var.c(this.mDownloadStickerCallback);
            this.mStickerManager.e();
            this.mVideoControllerLayout = (VideoControllerLayout) findViewById(R.id.obfuscated_res_0x7f091a0f);
            g66 g66Var = new g66(this.mRecordManager, null, this.mVideoControllerLayout);
            this.mFilterManager = g66Var;
            g66Var.d(this.mDownloadFilterCallback);
            this.mFilterManager.h();
            wt8 recrodButton = this.mVideoControllerLayout.getRecrodButton();
            TextView recordTimeView = this.mVideoControllerLayout.getRecordTimeView();
            this.mRecordTimeView = recordTimeView;
            ev5 ev5Var = new ev5(recrodButton, recordTimeView, this.mOnFinishedCallBack, this.mNeedSpeedCallBack, this.mDeleteLastCallBack);
            this.mDurationManager = ev5Var;
            ev5Var.setMinDuration(3);
            this.mDurationManager.setMaxDuration(15);
            this.mVideoControllerLayout.setDurationManager(this.mDurationManager);
            this.mSpeedManager = new kv5(getPageContext(), this.mSpeedChangedCallBack, null);
            hv5 hv5Var = new hv5(getPageContext(), this.mRatioChangedCallBack);
            this.mRatioManager = hv5Var;
            hv5Var.d(0);
            this.mMuxerManager = new iy5(getPageContext(), new e(this));
            loadStickers();
            loadFilter();
        }
    }

    private void initTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_QM_STICKERS, TbConfig.SERVER_ADDRESS + TbConfig.GET_QM_STICKERS);
            tbHttpMessageTask.setResponsedClass(ResponseGetQmStickersMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_QM_FILTERS, TbConfig.SERVER_ADDRESS + TbConfig.GET_QM_FILTERS);
            tbHttpMessageTask2.setResponsedClass(ResponseGetQmFiltersMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask2);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, lj7.class);
            lj7 lj7Var = runTask != null ? (lj7) runTask.getData() : null;
            if (lj7Var != null) {
                this.mPostMonitorManager = lj7Var.get();
            }
            hj7 hj7Var = this.mPostMonitorManager;
            if (hj7Var != null) {
                hj7Var.g();
            }
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            this.mRootView = findViewById(R.id.obfuscated_res_0x7f091adb);
            this.mCaptureTopContainer = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0904bb);
            this.mCaptureRightContainer = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0904ab);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f0904ba);
            this.mCaptureClose = imageView;
            imageView.setOnClickListener(this);
            ImageView imageView2 = (ImageView) findViewById(R.id.obfuscated_res_0x7f0904bd);
            this.mCaptureSpeed = imageView2;
            imageView2.setOnClickListener(this);
            ImageView imageView3 = (ImageView) findViewById(R.id.obfuscated_res_0x7f0904bc);
            this.mCaptureRatio = imageView3;
            imageView3.setOnClickListener(this);
            ImageView imageView4 = (ImageView) findViewById(R.id.obfuscated_res_0x7f0904be);
            this.mCaptureSwitch = imageView4;
            imageView4.setOnClickListener(this);
            this.mCaptureFilter = (ImageView) findViewById(R.id.obfuscated_res_0x7f0904b0);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0904b1);
            this.mCaptureFilterContainer = relativeLayout;
            relativeLayout.setOnClickListener(this);
            this.mCaptureMusic = (ImageView) findViewById(R.id.obfuscated_res_0x7f0904b2);
            RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0904b3);
            this.mCaptureMusicContainer = relativeLayout2;
            relativeLayout2.setOnClickListener(this);
            this.mCaptureSticker = (ImageView) findViewById(R.id.obfuscated_res_0x7f0904a0);
            RelativeLayout relativeLayout3 = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0904a1);
            this.mCaptureStickerContainer = relativeLayout3;
            relativeLayout3.setOnClickListener(this);
            this.mCaptureAlbum = (ImageView) findViewById(R.id.obfuscated_res_0x7f09049c);
            RelativeLayout relativeLayout4 = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09049d);
            this.mCaptureAlbumContainer = relativeLayout4;
            relativeLayout4.setOnClickListener(this);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0904b6);
            this.mCaptureFilterText = textView;
            wq4.d(textView).y(R.array.S_O_X001);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f0904b7);
            this.mCaptureMusicText = textView2;
            wq4.d(textView2).y(R.array.S_O_X001);
            TextView textView3 = (TextView) findViewById(R.id.obfuscated_res_0x7f0904a5);
            this.mCaptureStickerText = textView3;
            wq4.d(textView3).y(R.array.S_O_X001);
            TextView textView4 = (TextView) findViewById(R.id.obfuscated_res_0x7f0904a2);
            this.mCaptureAlbumText = textView4;
            wq4.d(textView4).y(R.array.S_O_X001);
            TextView textView5 = (TextView) findViewById(R.id.obfuscated_res_0x7f0904a4);
            this.mCaptureNextText = textView5;
            wq4.d(textView5).y(R.array.S_O_X001);
            TextView textView6 = (TextView) findViewById(R.id.obfuscated_res_0x7f0904a3);
            this.mCaptureDeleteText = textView6;
            wq4.d(textView6).y(R.array.S_O_X001);
            TextView textView7 = (TextView) findViewById(R.id.obfuscated_res_0x7f0904a8);
            this.mFilterName = textView7;
            wq4 d2 = wq4.d(textView7);
            d2.A(R.string.F_X02);
            d2.y(R.array.S_O_X001);
            this.mVideoControllerLayout.setRecordManager(this.mRecordManager);
            this.mVideoControllerLayout.setEffectChoosedListener(new f(this));
            this.mVideoControllerLayout.setRecordControlListener(new g(this));
            k66 k66Var = new k66(getPageContext(), this.mVideoControllerLayout);
            this.mRecordMusicManager = k66Var;
            this.mVideoControllerLayout.setMusicManager(k66Var);
            RelativeLayout relativeLayout5 = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09049f);
            this.mCaptureNextContainer = relativeLayout5;
            relativeLayout5.setOnClickListener(this);
            this.mCaptureNext = (ImageView) findViewById(R.id.obfuscated_res_0x7f091547);
            HorizontalCenterSelectView horizontalCenterSelectView = (HorizontalCenterSelectView) findViewById(R.id.obfuscated_res_0x7f091387);
            this.mMaxDuration = horizontalCenterSelectView;
            horizontalCenterSelectView.setItemTextPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X012));
            this.mMaxDuration.setItemTextSize(UtilHelper.getDimenPixelSize(R.dimen.T_X05));
            this.mMaxDuration.setItemTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.CAM_X0101));
            this.mDurationData = new ArrayList();
            this.mDurationMap = new HashMap();
            this.mDurationData.add(getString(R.string.obfuscated_res_0x7f0f062a));
            this.mDurationMap.put(getString(R.string.obfuscated_res_0x7f0f062a), 300);
            this.mDurationData.add(getString(R.string.obfuscated_res_0x7f0f11b1));
            this.mDurationMap.put(getString(R.string.obfuscated_res_0x7f0f11b1), 60);
            this.mDurationData.add(getString(R.string.obfuscated_res_0x7f0f0609));
            this.mDurationMap.put(getString(R.string.obfuscated_res_0x7f0f0609), 15);
            this.mMaxDuration.setOnItemSelected(new h(this));
            this.mMaxDuration.setData(this.mDurationData);
            this.mMaxDuration.setSelectedPosition(this.mDurationData.size() - 1);
            RelativeLayout relativeLayout6 = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09049e);
            this.mCaptureDeleteContainer = relativeLayout6;
            relativeLayout6.setOnClickListener(this);
            this.mCaptureDelete = (ImageView) findViewById(R.id.obfuscated_res_0x7f090411);
            this.mCaptureClose.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809de));
            updateSpeedButtonStyle(false);
            updateRatioButtonResId();
            this.mCaptureSwitch.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809d9));
            this.mCaptureFilter.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a03));
            this.mCaptureMusic.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a06));
            this.mCaptureSticker.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a09));
            this.mCaptureAlbum.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809fd));
            this.mCaptureNext.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a08));
            wq4 d3 = wq4.d(this.mCaptureNext);
            d3.n(R.string.J_X01);
            d3.f(R.color.CAM_X0302);
        }
    }

    private void jumpToAlbumActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65579, this) == null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            WriteData writeData = new WriteData();
            FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
            PostPrefixData postPrefixData = new PostPrefixData();
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), writeImagesInfo.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", writeData.getForumId());
            albumFloatActivityConfig.getIntent().putExtra("forum_name", writeData.getForumName());
            albumFloatActivityConfig.getIntent().putExtra("from", AlbumActivityConfig.FROM_WRITE);
            albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
            albumFloatActivityConfig.setAlbumThread(0);
            albumFloatActivityConfig.setCanSelectVideo(true);
            albumFloatActivityConfig.setCanSelectOnlyVideo(true);
            albumFloatActivityConfig.setCanEditImage(false);
            albumFloatActivityConfig.setFromWrite(4);
            albumFloatActivityConfig.setCallFrom("1");
            albumFloatActivityConfig.setStatisticFrom(writeData.getStatisticFrom());
            albumFloatActivityConfig.setProfessionZone(writeData.getProZone());
            albumFloatActivityConfig.setFrsTabInfo(frsTabInfoData);
            AntiData antiData = new AntiData();
            antiData.voice_message = "";
            antiData.setIfVoice(true);
            albumFloatActivityConfig.setExtraData(antiData, postPrefixData, writeData.getFirstDir(), writeData.getSecondDir());
            albumFloatActivityConfig.setAlbumShowCapture(false);
            sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }
    }

    private void loadFilter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65580, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_QM_FILTERS);
            httpMessage.addParam("uh", Build.MANUFACTURER + "," + Build.HARDWARE + "," + Build.BOARD + "," + (ko8.b(this) ? 1 : 0));
            httpMessage.addParam("ut", Build.MODEL + "_" + Build.VERSION.RELEASE + "_" + ko8.a() + "_" + Build.BRAND.replace("_", ""));
            StringBuilder sb = new StringBuilder();
            sb.append(vc0.h());
            sb.append("");
            httpMessage.addParam("sdk_version", sb.toString());
            sendMessage(httpMessage);
        }
    }

    private void loadStickers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65581, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_QM_STICKERS);
            httpMessage.addParam("uh", Build.MANUFACTURER + "," + Build.HARDWARE + "," + Build.BOARD + "," + (ko8.b(this) ? 1 : 0));
            httpMessage.addParam("ut", Build.MODEL + "_" + Build.VERSION.RELEASE + "_" + ko8.a() + "_" + Build.BRAND.replace("_", ""));
            StringBuilder sb = new StringBuilder();
            sb.append(vc0.h());
            sb.append("");
            httpMessage.addParam("sdk_version", sb.toString());
            httpMessage.addParam(com.xiaomi.mipush.sdk.Constants.PHONE_BRAND, "baiduar");
            sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetCapturePage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65582, this) == null) {
            jy5 jy5Var = this.mRecordManager;
            if (jy5Var != null && jy5Var.c()) {
                this.mRecordManager.stopRecord();
                this.mCaptureTopContainer.setVisibility(0);
                this.mCaptureRightContainer.setVisibility(0);
            }
            hideTopMenus();
            this.mVideoPartList.clear();
            this.mDurationManager.reset();
            this.mMaxDuration.setSelectedPosition(this.mDurationData.size() - 1);
            this.mCaptureDeleteContainer.setVisibility(8);
            setNextVisibility(8);
            this.mMaxDuration.setVisibility(0);
            this.mVideoControllerLayout.G();
            this.mCaptureStickerContainer.setVisibility(0);
            this.mCaptureAlbumContainer.setVisibility(0);
            updateButtonDisableByRecord();
            this.mSpeedManager.reset();
            this.mRatioManager.reset();
            this.mFilterManager.reset();
            this.mStickerManager.reset();
            this.mRecordMusicManager.reset();
            resetEffectIcon();
            hideLoadingView(this.mRootView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetDeleteStatus() {
        dv5 dv5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65583, this) == null) || (dv5Var = this.mDurationManager) == null) {
            return;
        }
        dv5Var.setShowDeleteLastTip(false);
        this.mCaptureDelete.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a0e));
        this.mCaptureDeleteText.setText(getResources().getString(R.string.obfuscated_res_0x7f0f14a7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetEffectIcon() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65584, this) == null) {
            resetTopIcon();
            resetRightIcon();
        }
    }

    private void resetRightIcon() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65585, this) == null) {
            this.mCaptureFilter.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a03));
            this.mCaptureMusic.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a06));
        }
    }

    private void resetTopIcon() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65586, this) == null) {
            updateSpeedButtonStyle(false);
            updateRatioButtonResId();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNextVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65587, this, i2) == null) {
            dv5 dv5Var = this.mDurationManager;
            if (dv5Var != null && dv5Var.getProgress() < 3.0f) {
                wq4 d2 = wq4.d(this.mCaptureNext);
                d2.n(R.string.J_X01);
                d2.e(R.string.A_X09);
                d2.f(R.color.CAM_X0302);
            } else {
                wq4 d3 = wq4.d(this.mCaptureNext);
                d3.n(R.string.J_X01);
                d3.e(R.string.A_X01);
                d3.f(R.color.CAM_X0302);
            }
            if (this.mCaptureNextContainer.getVisibility() != i2) {
                this.mCaptureNextContainer.setVisibility(i2);
            }
        }
    }

    private void showGuideView(@RawRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65588, this, i2) == null) {
            if (this.mCaptureGuideContainer == null) {
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0904a7);
                this.mCaptureGuideContainer = relativeLayout;
                wq4 d2 = wq4.d(relativeLayout);
                d2.e(R.string.A_X09);
                d2.f(R.color.CAM_X0611);
            }
            if (this.mCaptureGuide == null) {
                this.mCaptureGuide = (TBLottieAnimationView) findViewById(R.id.obfuscated_res_0x7f0904a6);
            }
            this.mCaptureGuideContainer.setVisibility(0);
            this.mCaptureGuide.setAnimation(i2);
            this.mCaptureGuide.loop(true);
            this.mCaptureGuide.playAnimation();
            mg.a().postDelayed(new i(this), 3000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateButtonDisableByRecord() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65589, this) == null) {
            if (!ListUtils.isEmpty(this.mVideoPartList)) {
                this.mCaptureRatio.setAlpha(SkinManager.RESOURCE_ALPHA_DISABLE);
                this.mCaptureMusicContainer.setAlpha(SkinManager.RESOURCE_ALPHA_DISABLE);
                return;
            }
            this.mCaptureRatio.setAlpha(1.0f);
            this.mCaptureMusicContainer.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRatioButtonResId() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65590, this) == null) {
            this.mRatioDrawableId = R.drawable.obfuscated_res_0x7f0809e9;
            this.mRatioSelectedDrawableId = R.drawable.obfuscated_res_0x7f0809ea;
            gv5 gv5Var = this.mRatioManager;
            if (gv5Var == null) {
                return;
            }
            if (gv5Var.e() == 1.0f) {
                this.mRatioDrawableId = R.drawable.obfuscated_res_0x7f0809d1;
                this.mRatioSelectedDrawableId = R.drawable.obfuscated_res_0x7f0809d2;
            } else if (this.mRatioManager.e() == 1.3333334f) {
                this.mRatioDrawableId = R.drawable.obfuscated_res_0x7f0809d5;
                this.mRatioSelectedDrawableId = R.drawable.obfuscated_res_0x7f0809d6;
            } else if (this.mRatioManager.e() == 1.7777778f) {
                this.mRatioDrawableId = R.drawable.obfuscated_res_0x7f0809d7;
                this.mRatioSelectedDrawableId = R.drawable.obfuscated_res_0x7f0809d8;
            } else if (this.mRatioManager.e() == 0.5625f) {
                this.mRatioDrawableId = R.drawable.obfuscated_res_0x7f0809d3;
                this.mRatioSelectedDrawableId = R.drawable.obfuscated_res_0x7f0809d4;
            }
            if (this.mRatioManager.b() == 0) {
                this.mCaptureRatio.setImageDrawable(getResources().getDrawable(this.mRatioSelectedDrawableId));
            } else {
                this.mCaptureRatio.setImageDrawable(getResources().getDrawable(this.mRatioDrawableId));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpeedButtonStyle(boolean z) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65591, this, z) == null) {
            jv5 jv5Var = this.mSpeedManager;
            if (jv5Var == null || !jv5Var.d()) {
                i2 = R.drawable.obfuscated_res_0x7f0809cd;
                i3 = R.drawable.obfuscated_res_0x7f0809cf;
            } else {
                i2 = R.drawable.obfuscated_res_0x7f0809ce;
                i3 = R.drawable.obfuscated_res_0x7f0809d0;
            }
            if (z) {
                this.mCaptureSpeed.setImageDrawable(getResources().getDrawable(i3));
            } else {
                this.mCaptureSpeed.setImageDrawable(getResources().getDrawable(i2));
            }
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
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, intent) == null) && intent != null && i2 == 25032) {
            String stringExtra = intent.getStringExtra(CloudMusicActivityConfig.MUSIC_ID);
            TbMusicData tbMusicData = (TbMusicData) intent.getSerializableExtra(CloudMusicActivityConfig.MUSIC_DATA);
            if (tbMusicData != null) {
                this.mCurrentMusicData = tbMusicData;
                if (TextUtils.isEmpty(tbMusicData.localPath) || TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                String str = tbMusicData.localPath;
                if (this.mRecordMusicManager == null || TextUtils.isEmpty(str)) {
                    return;
                }
                this.mRecordMusicManager.f(str, stringExtra);
                this.mVideoControllerLayout.z(tbMusicData);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            backDialogShow();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.mDurationManager != null) {
                this.mCaptureDelete.setImageDrawable(getResources().getDrawable(this.mDurationManager.b() ? R.drawable.obfuscated_res_0x7f080a00 : R.drawable.obfuscated_res_0x7f080a0e));
                this.mCaptureDeleteText.setText(getResources().getString(this.mDurationManager.b() ? R.string.obfuscated_res_0x7f0f04a4 : R.string.obfuscated_res_0x7f0f14a7));
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        dv5.c cVar;
        gv5 gv5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            super.onClick(view2);
            if (view2.getId() == R.id.obfuscated_res_0x7f0904ba) {
                onBackPressed();
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f0904bd) {
                jv5 jv5Var = this.mSpeedManager;
                if (jv5Var != null) {
                    boolean z = jv5Var.b() == 0;
                    hideTopMenus();
                    resetTopIcon();
                    this.mSpeedManager.c(z ? 8 : 0);
                    updateSpeedButtonStyle(this.mSpeedManager.b() == 0);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0904bc) {
                if (!ListUtils.isEmpty(this.mVideoPartList) || (gv5Var = this.mRatioManager) == null) {
                    return;
                }
                boolean z2 = gv5Var.b() == 0;
                hideTopMenus();
                resetTopIcon();
                if (z2) {
                    this.mCaptureRatio.setImageDrawable(getResources().getDrawable(this.mRatioDrawableId));
                    this.mRatioManager.c(8);
                    return;
                }
                this.mCaptureRatio.setImageDrawable(getResources().getDrawable(this.mRatioSelectedDrawableId));
                this.mRatioManager.c(0);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0904be) {
                jy5 jy5Var = this.mRecordManager;
                if (jy5Var != null) {
                    jy5Var.d();
                }
                if (ys4.k().h("key_capture_switch_camera_guide_show", false)) {
                    return;
                }
                showGuideView(R.raw.obfuscated_res_0x7f11000a);
                ys4.k().u("key_capture_switch_camera_guide_show", true);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0904b1) {
                if (!ys4.k().h("key_capture_filter_guide_show", false)) {
                    showGuideView(R.raw.obfuscated_res_0x7f11000b);
                    ys4.k().u("key_capture_filter_guide_show", true);
                }
                resetRightIcon();
                if (this.mVideoControllerLayout.r()) {
                    this.mCaptureFilter.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a03));
                } else {
                    this.mCaptureFilter.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a05));
                }
                this.mVideoControllerLayout.v();
                if (this.mVideoControllerLayout.t()) {
                    loadFilter();
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0904b3) {
                if (ListUtils.isEmpty(this.mVideoPartList)) {
                    resetRightIcon();
                    if (this.mVideoControllerLayout.s()) {
                        this.mCaptureMusic.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a06));
                    } else {
                        this.mCaptureMusic.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a07));
                    }
                    this.mVideoControllerLayout.w();
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0904a1) {
                resetRightIcon();
                this.mVideoControllerLayout.y();
                if (this.mVideoControllerLayout.u()) {
                    loadStickers();
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09049d) {
                resetRightIcon();
                jumpToAlbumActivity();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09049e) {
                dv5 dv5Var = this.mDurationManager;
                if (dv5Var != null) {
                    if (dv5Var.b()) {
                        this.mDurationManager.a();
                        this.mCaptureDelete.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a0e));
                        this.mCaptureDeleteText.setText(getResources().getString(R.string.obfuscated_res_0x7f0f14a7));
                        return;
                    }
                    this.mDurationManager.setShowDeleteLastTip(true);
                    this.mCaptureDelete.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a00));
                    this.mCaptureDeleteText.setText(getResources().getString(R.string.obfuscated_res_0x7f0f04a4));
                }
            } else if (view2.getId() != R.id.obfuscated_res_0x7f09049f || (cVar = this.mOnFinishedCallBack) == null) {
            } else {
                cVar.a();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d002f);
            setSwipeBackEnabled(false);
            initTask();
            initManager();
            initView();
            initListener();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            jy5 jy5Var = this.mRecordManager;
            if (jy5Var != null) {
                jy5Var.onDestroy();
            }
            i66 i66Var = this.mRecordMusicManager;
            if (i66Var != null) {
                i66Var.releasePlayer();
                this.mRecordMusicManager.d();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPause();
            jy5 jy5Var = this.mRecordManager;
            if (jy5Var != null) {
                jy5Var.onPause();
            }
            i66 i66Var = this.mRecordMusicManager;
            if (i66Var != null) {
                i66Var.onPause();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            View view2 = this.mRootView;
            if (view2 != null) {
                view2.setSystemUiVisibility(4100);
            }
            jy5 jy5Var = this.mRecordManager;
            if (jy5Var != null) {
                jy5Var.onResume();
            }
            i66 i66Var = this.mRecordMusicManager;
            if (i66Var != null) {
                i66Var.onResume();
            }
            m66 m66Var = this.mStickerManager;
            if (m66Var != null) {
                m66Var.e();
            }
            h66 h66Var = this.mFilterManager;
            if (h66Var != null) {
                h66Var.h();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            super.showLoadingView(view2);
            if (getLoadingView() == null || getLoadingView().k() == null) {
                return;
            }
            getLoadingView().k().setVisibility(8);
        }
    }
}
