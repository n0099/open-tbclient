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
import c.a.p0.s.s.i;
import c.a.q0.f0.b.a;
import c.a.q0.f0.c.a;
import c.a.q0.o0.b.a;
import c.a.q0.o0.d.b;
import c.a.q0.y.a.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.TbEditVideoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.dialog.PopupDialog;
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
import com.baidu.ugc.editvideo.filter.FilterValue;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
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
    public a.InterfaceC1350a mDeleteLastCallBack;
    public a.b mDownloadFilterCallback;
    public b.InterfaceC1062b mDownloadStickerCallback;
    public List<String> mDurationData;
    public c.a.q0.y.a.a mDurationManager;
    public Map<String, Integer> mDurationMap;
    public c.a.q0.o0.b.b mFilterManager;
    public TextView mFilterName;
    public HttpMessageListener mGetQmFiltersListener;
    public HttpMessageListener mGetQmStickersListener;
    public HorizontalCenterSelectView mMaxDuration;
    public c.a.q0.f0.b.a mMuxerManager;
    public a.b mNeedSpeedCallBack;
    public a.c mOnFinishedCallBack;
    public a.InterfaceC0834a mOnProgressCallBack;
    public a.b mOnRecordStopSuccessCallBack;
    public c.a.q0.y1.g mPostMonitorManager;
    public c.a.q0.y.b.a mRatioChangedCallBack;
    public int mRatioDrawableId;
    public c.a.q0.y.b.b mRatioManager;
    public int mRatioSelectedDrawableId;
    public c.a.q0.f0.c.a mRecordManager;
    public c.a.q0.o0.c.a mRecordMusicManager;
    public RecordPreviewContainer mRecordPreviewContainer;
    public TextView mRecordTimeView;
    public View mRootView;
    public c.a.q0.y.c.a mSpeedChangedCallBack;
    public c.a.q0.y.c.b mSpeedManager;
    public c.a.q0.o0.d.a mStickerManager;
    public VideoControllerLayout mVideoControllerLayout;
    public ArrayList<String> mVideoPartList;

    /* loaded from: classes7.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbCaptureActivity f58190a;

        public a(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58190a = tbCaptureActivity;
        }

        @Override // c.a.q0.o0.b.a.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.f58190a.mVideoControllerLayout != null) {
                    QmFilterItem qmFilterItem = new QmFilterItem();
                    qmFilterItem.id = "-1";
                    qmFilterItem.bgurl = R.drawable.icon_pure_video_lvjing_on + "";
                    qmFilterItem.name = this.f58190a.getResources().getString(R.string.filter_nature);
                    qmFilterItem.isSelect = true;
                    qmFilterItem.localPath = FilterValue.DEFAULT_FILTER_VALUE;
                    this.f58190a.mVideoControllerLayout.selectFilter(qmFilterItem);
                    if (this.f58190a.mFilterManager != null) {
                        this.f58190a.mFilterManager.a(null);
                    }
                    this.f58190a.mVideoControllerLayout.setDownLoadFilter(null);
                }
                if (StringUtils.isNull(str)) {
                    str = this.f58190a.getResources().getString(R.string.sticker_download_error);
                }
                this.f58190a.showToast(str);
                this.f58190a.mPostMonitorManager.b(5, str);
            }
        }

        @Override // c.a.q0.o0.b.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f58190a.mVideoControllerLayout == null) {
                return;
            }
            this.f58190a.mVideoControllerLayout.setDownLoadFilter(null);
        }

        @Override // c.a.q0.o0.b.a.b
        public void c(QmFilterItem qmFilterItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qmFilterItem) == null) {
                if (this.f58190a.mFilterManager != null) {
                    this.f58190a.mFilterManager.a(qmFilterItem);
                }
                if (this.f58190a.mVideoControllerLayout != null) {
                    this.f58190a.mVideoControllerLayout.setDownLoadFilter(null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements b.InterfaceC1062b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbCaptureActivity f58191a;

        public b(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58191a = tbCaptureActivity;
        }

        @Override // c.a.q0.o0.d.b.InterfaceC1062b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.f58191a.mVideoControllerLayout != null) {
                    QmStickerItem qmStickerItem = new QmStickerItem();
                    qmStickerItem.id = -1;
                    qmStickerItem.isLocalSource = true;
                    qmStickerItem.localPath = "nosticker";
                    this.f58191a.mVideoControllerLayout.selectSticker(qmStickerItem);
                    if (this.f58191a.mStickerManager != null) {
                        this.f58191a.mStickerManager.b(null);
                    }
                    this.f58191a.mVideoControllerLayout.setDownLoadSticker(qmStickerItem, false);
                }
                if (StringUtils.isNull(str)) {
                    str = this.f58191a.getResources().getString(R.string.sticker_download_error);
                }
                this.f58191a.showToast(str);
                this.f58191a.mPostMonitorManager.b(5, str);
            }
        }

        @Override // c.a.q0.o0.d.b.InterfaceC1062b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f58191a.mVideoControllerLayout == null) {
                return;
            }
            this.f58191a.mVideoControllerLayout.setDownLoadSticker(null, false);
        }

        @Override // c.a.q0.o0.d.b.InterfaceC1062b
        public void c(QmStickerItem qmStickerItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qmStickerItem) == null) {
                if (this.f58191a.mStickerManager != null) {
                    this.f58191a.mStickerManager.b(qmStickerItem);
                }
                if (this.f58191a.mVideoControllerLayout != null) {
                    this.f58191a.mVideoControllerLayout.setDownLoadSticker(qmStickerItem, true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbCaptureActivity f58192a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(TbCaptureActivity tbCaptureActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58192a = tbCaptureActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f58192a.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PopupDialog f58193e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TbCaptureActivity f58194f;

        public d(TbCaptureActivity tbCaptureActivity, PopupDialog popupDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity, popupDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58194f = tbCaptureActivity;
            this.f58193e = popupDialog;
        }

        @Override // c.a.p0.s.s.i.e
        public void onItemClick(c.a.p0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (i2 == 0) {
                    this.f58194f.resetCapturePage();
                    this.f58193e.dismiss();
                } else if (i2 == 1) {
                    this.f58194f.finish();
                } else {
                    this.f58193e.dismiss();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements a.InterfaceC0832a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbCaptureActivity f58195a;

        public e(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58195a = tbCaptureActivity;
        }

        @Override // c.a.q0.f0.b.a.InterfaceC0832a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TbCaptureActivity tbCaptureActivity = this.f58195a;
                tbCaptureActivity.hideLoadingView(tbCaptureActivity.mRootView);
            }
        }

        @Override // c.a.q0.f0.b.a.InterfaceC0832a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                TbCaptureActivity tbCaptureActivity = this.f58195a;
                tbCaptureActivity.showLoadingView(tbCaptureActivity.mRootView);
            }
        }

        @Override // c.a.q0.f0.b.a.InterfaceC0832a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                VideoFileInfo c2 = c.a.q0.v3.c.c(str);
                if (c2 == null) {
                    TbCaptureActivity tbCaptureActivity = this.f58195a;
                    tbCaptureActivity.hideLoadingView(tbCaptureActivity.mRootView);
                    return;
                }
                TbMultiMediaData tbMultiMediaData = new TbMultiMediaData();
                tbMultiMediaData.path = str;
                tbMultiMediaData.width = c2.videoWidth;
                tbMultiMediaData.height = c2.videoHeight;
                tbMultiMediaData.type = 1;
                tbMultiMediaData.start = 0L;
                int i2 = c2.videoDuration;
                tbMultiMediaData.end = i2;
                tbMultiMediaData.originalDuration = i2;
                tbMultiMediaData.scaleType = "center_crop";
                tbMultiMediaData.videoInfoSource = 1;
                TbEditVideoActivityConfig tbEditVideoActivityConfig = new TbEditVideoActivityConfig(this.f58195a.getActivity());
                tbEditVideoActivityConfig.getIntent().putExtras(this.f58195a.getIntent());
                tbEditVideoActivityConfig.setMultiMediaData(tbMultiMediaData);
                tbEditVideoActivityConfig.setVideoFrom(2);
                if (this.f58195a.mCurrentMusicData != null && this.f58195a.mRecordMusicManager != null) {
                    this.f58195a.mCurrentMusicData.localPath = this.f58195a.mRecordMusicManager.a();
                    tbEditVideoActivityConfig.setMusicData(this.f58195a.mCurrentMusicData);
                }
                if (this.f58195a.mRatioManager != null) {
                    tbEditVideoActivityConfig.setVideoRatio(this.f58195a.mRatioManager.getRatio());
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbEditVideoActivityConfig));
                TbCaptureActivity tbCaptureActivity2 = this.f58195a;
                tbCaptureActivity2.hideLoadingView(tbCaptureActivity2.mRootView);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements RecordEffectLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbCaptureActivity f58196a;

        public f(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58196a = tbCaptureActivity;
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void a(QmStickerItem qmStickerItem) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, qmStickerItem) == null) || qmStickerItem == null || this.f58196a.mStickerManager == null) {
                return;
            }
            String a2 = this.f58196a.mStickerManager.a(qmStickerItem.fileUrl);
            if (StringUtils.isNull(a2) && -1 != qmStickerItem.id) {
                if (this.f58196a.mVideoControllerLayout != null) {
                    this.f58196a.mVideoControllerLayout.setDownLoadSticker(qmStickerItem, false);
                }
                this.f58196a.mStickerManager.d(qmStickerItem);
                return;
            }
            qmStickerItem.localPath = a2;
            this.f58196a.mStickerManager.b(qmStickerItem);
            if (this.f58196a.mVideoControllerLayout != null) {
                this.f58196a.mVideoControllerLayout.setDownLoadSticker(qmStickerItem, true);
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
                if (this.f58196a.mFilterManager != null && (bVar.d() instanceof QmFilterItem)) {
                    QmFilterItem qmFilterItem = (QmFilterItem) bVar.d();
                    String f2 = this.f58196a.mFilterManager.f(qmFilterItem.fileUrl);
                    if (StringUtils.isNull(f2) && !"-1".equals(qmFilterItem.id)) {
                        if (this.f58196a.mVideoControllerLayout != null) {
                            this.f58196a.mVideoControllerLayout.setDownLoadFilter(qmFilterItem);
                        }
                        this.f58196a.mFilterManager.c(qmFilterItem);
                        return;
                    }
                    qmFilterItem.localPath = f2;
                    this.f58196a.mFilterManager.a(qmFilterItem);
                    if (this.f58196a.mVideoControllerLayout != null) {
                        this.f58196a.mVideoControllerLayout.setDownLoadFilter(null);
                    }
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
                    this.f58196a.mRecordMusicManager.d(this.f58196a.mCurrentMusicData);
                    this.f58196a.mCurrentMusicData = tbMusicData;
                    if (!MusicData.MUSIC_CLOUD_ID.equals(musicData.id)) {
                        this.f58196a.mVideoControllerLayout.setMusicName(this.f58196a.mCurrentMusicData.title, "");
                    }
                } else {
                    this.f58196a.mCurrentMusicData = tbMusicData;
                    this.f58196a.mRecordMusicManager.d(this.f58196a.mCurrentMusicData);
                    this.f58196a.mVideoControllerLayout.setMusicName(this.f58196a.mCurrentMusicData.title, "");
                }
                this.f58196a.mRecordMusicManager.b((MusicData) bVar.d(), obj);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements VideoControllerLayout.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbCaptureActivity f58197a;

        public g(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58197a = tbCaptureActivity;
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!ListUtils.isEmpty(this.f58197a.mVideoPartList) || this.f58197a.mRecordManager.c()) {
                    if (this.f58197a.mRecordManager.c()) {
                        this.f58197a.mCaptureStickerContainer.setVisibility(8);
                    } else {
                        this.f58197a.mCaptureStickerContainer.setVisibility(0);
                    }
                    this.f58197a.mCaptureDeleteContainer.setVisibility(0);
                    this.f58197a.setNextVisibility(0);
                    this.f58197a.mMaxDuration.setVisibility(8);
                    this.f58197a.mCaptureAlbumContainer.setVisibility(8);
                    return;
                }
                if (z) {
                    this.f58197a.mMaxDuration.setVisibility(8);
                    this.f58197a.mCaptureStickerContainer.setVisibility(8);
                    this.f58197a.mCaptureAlbumContainer.setVisibility(8);
                } else {
                    this.f58197a.mMaxDuration.setVisibility(0);
                    this.f58197a.mCaptureStickerContainer.setVisibility(0);
                    this.f58197a.mCaptureAlbumContainer.setVisibility(0);
                }
                this.f58197a.mCaptureDeleteContainer.setVisibility(8);
                this.f58197a.setNextVisibility(8);
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void hideMinVideoTips() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f58197a.mMaxDuration.setVisibility(8);
                this.f58197a.mCaptureStickerContainer.setVisibility(8);
                this.f58197a.mCaptureAlbumContainer.setVisibility(8);
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void onShowEffectLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f58197a.mMaxDuration.setVisibility(8);
                this.f58197a.mCaptureStickerContainer.setVisibility(8);
                this.f58197a.mCaptureAlbumContainer.setVisibility(8);
                this.f58197a.mCaptureDeleteContainer.setVisibility(8);
                this.f58197a.setNextVisibility(8);
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void onStartRecord() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f58197a.mDurationManager == null) {
                return;
            }
            if (this.f58197a.mDurationManager.getProgress() < this.f58197a.mDurationManager.getMaxDuration()) {
                this.f58197a.mRecordManager.e();
                this.f58197a.mCaptureTopContainer.setVisibility(8);
                this.f58197a.mCaptureRightContainer.setVisibility(8);
                this.f58197a.hideTopMenus();
                this.f58197a.resetEffectIcon();
                this.f58197a.mCaptureDeleteContainer.setVisibility(8);
                if (this.f58197a.mDurationManager.getProgress() < 3.0f) {
                    this.f58197a.setNextVisibility(8);
                } else {
                    this.f58197a.setNextVisibility(0);
                }
                this.f58197a.mCaptureStickerContainer.setVisibility(8);
                this.f58197a.resetDeleteStatus();
                if (this.f58197a.mRecordMusicManager != null) {
                    this.f58197a.mRecordMusicManager.f(this.f58197a.mDurationManager.getProgress());
                }
                this.f58197a.isRecordFinished = false;
            } else if (this.f58197a.mDurationManager.getProgress() < this.f58197a.mDurationManager.getMaxDuration() || this.f58197a.mVideoControllerLayout == null) {
            } else {
                this.f58197a.mVideoControllerLayout.stopRecord();
                if (this.f58197a.mMuxerManager != null) {
                    this.f58197a.mMuxerManager.b(this.f58197a.mVideoPartList);
                }
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void onStopRecord() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f58197a.mRecordManager == null) {
                return;
            }
            this.f58197a.mRecordManager.stopRecord();
            this.f58197a.mCaptureTopContainer.setVisibility(0);
            this.f58197a.mCaptureRightContainer.setVisibility(0);
            this.f58197a.mCaptureDeleteContainer.setVisibility(0);
            this.f58197a.setNextVisibility(0);
            this.f58197a.mCaptureStickerContainer.setVisibility(0);
            if (this.f58197a.mRecordMusicManager != null) {
                this.f58197a.mRecordMusicManager.onStopRecord();
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void onTakePhoto() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements HorizontalCenterSelectView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbCaptureActivity f58198a;

        public h(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58198a = tbCaptureActivity;
        }

        @Override // com.baidu.tieba.view.widget.HorizontalCenterSelectView.d
        public void onSelected(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f58198a.mDurationManager == null) {
                return;
            }
            this.f58198a.mDurationManager.setMaxDuration(((Integer) this.f58198a.mDurationMap.get((String) this.f58198a.mDurationData.get(i2))).intValue());
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbCaptureActivity f58199e;

        public i(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58199e = tbCaptureActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58199e.mCaptureGuide.pauseAnimation();
                this.f58199e.mCaptureGuideContainer.setVisibility(8);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements RecordPreviewContainer.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbCaptureActivity f58200a;

        public j(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58200a = tbCaptureActivity;
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.e
        public void a(MotionEvent motionEvent, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, motionEvent, i2) == null) || this.f58200a.mRecordManager == null) {
                return;
            }
            c.a.q0.a4.j.a.e.D(this.f58200a.getPageContext()).l(i2);
            this.f58200a.resetDeleteStatus();
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.e
        public void b(MotionEvent motionEvent, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || this.f58200a.mRecordManager == null) {
                return;
            }
            c.a.q0.a4.j.a.e.D(this.f58200a.getPageContext()).c(i2, i3, i4, i5);
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbCaptureActivity f58201a;

        public k(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58201a = tbCaptureActivity;
        }

        @Override // c.a.q0.f0.c.a.b
        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (this.f58201a.mDurationManager != null) {
                    this.f58201a.mDurationManager.pause();
                    if (!StringUtils.isNull(str)) {
                        this.f58201a.mVideoPartList.add(str);
                        if (this.f58201a.isRecordFinished && ListUtils.getCount(this.f58201a.mVideoPartList) == this.f58201a.mDurationManager.getSlideNum() && this.f58201a.mMuxerManager != null) {
                            this.f58201a.mMuxerManager.b(this.f58201a.mVideoPartList);
                        }
                    }
                    this.f58201a.updateButtonDisableByRecord();
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // c.a.q0.f0.c.a.b
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f58201a.mDurationManager != null) {
                    if (ListUtils.isEmpty(this.f58201a.mVideoPartList) && this.f58201a.mVideoControllerLayout != null) {
                        this.f58201a.mVideoControllerLayout.startRecordAnimator();
                    }
                    this.f58201a.mDurationManager.start();
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbCaptureActivity f58202e;

        public l(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58202e = tbCaptureActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58202e.mFilterName.setVisibility(8);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements RecordPreviewContainer.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Runnable f58203a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TbCaptureActivity f58204b;

        public m(TbCaptureActivity tbCaptureActivity, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58204b = tbCaptureActivity;
            this.f58203a = runnable;
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void a(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) || this.f58204b.mRecordManager == null || this.f58204b.mRecordManager.c() || this.f58204b.mFilterManager == null) {
                return;
            }
            this.f58204b.mFilterManager.g();
            String currentFilterName = this.f58204b.mVideoControllerLayout.getCurrentFilterName();
            if (!StringUtils.isNull(currentFilterName)) {
                this.f58204b.mFilterName.removeCallbacks(this.f58203a);
                this.f58204b.mFilterName.setText(currentFilterName);
                this.f58204b.mFilterName.setVisibility(0);
                this.f58204b.mFilterName.postDelayed(this.f58203a, 800L);
            }
            this.f58204b.resetDeleteStatus();
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void b(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent) == null) || this.f58204b.mRecordManager == null || this.f58204b.mRecordManager.c() || this.f58204b.mFilterManager == null) {
                return;
            }
            this.f58204b.mFilterManager.e();
            String currentFilterName = this.f58204b.mVideoControllerLayout.getCurrentFilterName();
            if (!StringUtils.isNull(currentFilterName)) {
                this.f58204b.mFilterName.removeCallbacks(this.f58203a);
                this.f58204b.mFilterName.setText(currentFilterName);
                this.f58204b.mFilterName.setVisibility(0);
                this.f58204b.mFilterName.postDelayed(this.f58203a, 800L);
            }
            this.f58204b.resetDeleteStatus();
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void c(MotionEvent motionEvent, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, Float.valueOf(f2), Float.valueOf(f3)}) == null) || this.f58204b.mRecordManager == null || this.f58204b.mRecordManager.c()) {
                return;
            }
            this.f58204b.mRecordManager.d();
            this.f58204b.resetDeleteStatus();
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void d(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
                this.f58204b.hideTopMenus();
                this.f58204b.resetEffectIcon();
                if (this.f58204b.mVideoControllerLayout != null && this.f58204b.mVideoControllerLayout.isEffectLayoutVisible()) {
                    this.f58204b.mVideoControllerLayout.hideEffectLayout(null, false);
                }
                if (this.f58204b.mRecordManager == null || this.f58204b.mRecordManager.c() || this.f58204b.mRecordPreviewContainer == null) {
                    return;
                }
                this.f58204b.mRecordPreviewContainer.handleTouchFocus(motionEvent);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements a.InterfaceC0834a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbCaptureActivity f58205a;

        public n(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58205a = tbCaptureActivity;
        }

        @Override // c.a.q0.f0.c.a.InterfaceC0834a
        public void b(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) || this.f58205a.mDurationManager == null) {
                return;
            }
            this.f58205a.mDurationManager.setProgress(j2);
            if (this.f58205a.mDurationManager.getProgress() >= 3.0f) {
                this.f58205a.setNextVisibility(0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbCaptureActivity f58206a;

        public o(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58206a = tbCaptureActivity;
        }

        @Override // c.a.q0.y.a.a.c
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f58206a.isRecordFinished = true;
                if (this.f58206a.mRecordManager != null && !this.f58206a.mRecordManager.c() && this.f58206a.isRecordFinished && ListUtils.getCount(this.f58206a.mVideoPartList) == this.f58206a.mDurationManager.getSlideNum() && this.f58206a.mMuxerManager != null) {
                    this.f58206a.mMuxerManager.b(this.f58206a.mVideoPartList);
                }
                if (this.f58206a.mVideoControllerLayout != null) {
                    this.f58206a.mVideoControllerLayout.stopRecord();
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class p implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbCaptureActivity f58207a;

        public p(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58207a = tbCaptureActivity;
        }

        @Override // c.a.q0.y.a.a.b
        public float a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f58207a.mSpeedManager != null) {
                    return this.f58207a.mSpeedManager.a();
                }
                return 1.0f;
            }
            return invokeV.floatValue;
        }
    }

    /* loaded from: classes7.dex */
    public class q implements a.InterfaceC1350a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbCaptureActivity f58208a;

        public q(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58208a = tbCaptureActivity;
        }

        @Override // c.a.q0.y.a.a.InterfaceC1350a
        public boolean a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                if (ListUtils.isEmpty(this.f58208a.mVideoPartList)) {
                    return false;
                }
                this.f58208a.mVideoPartList.remove(this.f58208a.mVideoPartList.size() - 1);
                if (this.f58208a.mVideoPartList.size() <= 0) {
                    if (this.f58208a.mDurationManager != null) {
                        this.f58208a.mDurationManager.reset();
                    }
                    this.f58208a.mCaptureDeleteContainer.setVisibility(8);
                    this.f58208a.setNextVisibility(8);
                    this.f58208a.mMaxDuration.setVisibility(0);
                    this.f58208a.mVideoControllerLayout.stopRecordAnimator();
                    this.f58208a.mCaptureStickerContainer.setVisibility(0);
                    this.f58208a.mCaptureAlbumContainer.setVisibility(0);
                }
                this.f58208a.updateButtonDisableByRecord();
                return true;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class r implements c.a.q0.y.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbCaptureActivity f58209a;

        public r(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58209a = tbCaptureActivity;
        }

        @Override // c.a.q0.y.c.a
        public boolean a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                if (this.f58209a.mRecordManager == null || this.f58209a.mRecordManager.f() == null) {
                    return false;
                }
                this.f58209a.mRecordManager.f().a(f2);
                if (this.f58209a.mSpeedManager != null) {
                    TbCaptureActivity tbCaptureActivity = this.f58209a;
                    tbCaptureActivity.updateSpeedButtonStyle(tbCaptureActivity.mSpeedManager.b() == 0);
                }
                return true;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class s implements c.a.q0.y.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbCaptureActivity f58210a;

        public s(TbCaptureActivity tbCaptureActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58210a = tbCaptureActivity;
        }

        @Override // c.a.q0.y.b.a
        public boolean a(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                if (this.f58210a.mRecordManager == null || this.f58210a.mRecordManager.g() == null) {
                    return false;
                }
                this.f58210a.mRecordManager.g().a(f2);
                this.f58210a.updateRatioButtonResId();
                return true;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class t extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbCaptureActivity f58211a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(TbCaptureActivity tbCaptureActivity, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity, Integer.valueOf(i2), Boolean.valueOf(z)};
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
            this.f58211a = tbCaptureActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ResponseGetQmStickersMessage)) {
                List<QmStickerItem> stickerItems = httpResponsedMessage.getError() == 0 ? ((ResponseGetQmStickersMessage) httpResponsedMessage).getStickerItems() : null;
                if (this.f58211a.mVideoControllerLayout != null) {
                    if (stickerItems == null) {
                        stickerItems = new ArrayList<>();
                    }
                    for (QmStickerItem qmStickerItem : stickerItems) {
                        if (qmStickerItem != null && this.f58211a.mStickerManager != null && !StringUtils.isNull(qmStickerItem.fileUrl) && !StringUtils.isNull(this.f58211a.mStickerManager.a(qmStickerItem.fileUrl))) {
                            qmStickerItem.isLocalSource = true;
                        }
                    }
                    QmStickerItem qmStickerItem2 = new QmStickerItem();
                    qmStickerItem2.id = -1;
                    qmStickerItem2.isSelect = true;
                    qmStickerItem2.isLocalSource = true;
                    qmStickerItem2.localPath = "nosticker";
                    stickerItems.add(0, qmStickerItem2);
                    this.f58211a.mVideoControllerLayout.setStickerItems(stickerItems);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbCaptureActivity f58212a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(TbCaptureActivity tbCaptureActivity, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity, Integer.valueOf(i2), Boolean.valueOf(z)};
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
            this.f58212a = tbCaptureActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ResponseGetQmFiltersMessage)) {
                List<QmFilterItem> filterItems = httpResponsedMessage.getError() == 0 ? ((ResponseGetQmFiltersMessage) httpResponsedMessage).getFilterItems() : null;
                if (this.f58212a.mVideoControllerLayout != null) {
                    if (filterItems == null) {
                        filterItems = new ArrayList<>();
                    }
                    QmFilterItem qmFilterItem = new QmFilterItem();
                    qmFilterItem.id = "-1";
                    qmFilterItem.bgurl = R.drawable.icon_pure_video_lvjing_on + "";
                    qmFilterItem.name = this.f58212a.getResources().getString(R.string.filter_nature);
                    qmFilterItem.isSelect = true;
                    qmFilterItem.localPath = FilterValue.DEFAULT_FILTER_VALUE;
                    filterItems.add(0, qmFilterItem);
                    this.f58212a.mVideoControllerLayout.setFilterData(filterItems);
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
        this.mRatioDrawableId = R.drawable.icon_pure_topbar_pingmubili44;
        this.mRatioSelectedDrawableId = R.drawable.icon_pure_topbar_pingmubili_s44;
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
            c.a.q0.y.a.a aVar = this.mDurationManager;
            if (aVar != null && aVar.getProgress() > 0.0f) {
                PopupDialog popupDialog = new PopupDialog(getPageContext(), new c.a.p0.s.s.i(getPageContext().getPageActivity()));
                popupDialog.setDefaultContentView(null, new String[]{getString(R.string.capture_record_2), getResources().getString(R.string.quit)}, new d(this, popupDialog));
                popupDialog.showDialog();
                return;
            }
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTopMenus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            c.a.q0.y.c.b bVar = this.mSpeedManager;
            if (bVar != null) {
                bVar.c(8);
            }
            c.a.q0.y.b.b bVar2 = this.mRatioManager;
            if (bVar2 != null) {
                bVar2.c(8);
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
            this.mRecordPreviewContainer = (RecordPreviewContainer) findViewById(R.id.capture_record_preview_container);
            this.mRecordManager = new c.a.q0.f0.c.b(getPageContext(), this.mRecordPreviewContainer.getSurfaceView(), true, this.mOnRecordStopSuccessCallBack, this.mOnProgressCallBack);
            c.a.q0.o0.d.b bVar = new c.a.q0.o0.d.b(this.mRecordManager);
            this.mStickerManager = bVar;
            bVar.c(this.mDownloadStickerCallback);
            this.mStickerManager.e();
            this.mVideoControllerLayout = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
            c.a.q0.o0.b.a aVar = new c.a.q0.o0.b.a(this.mRecordManager, null, this.mVideoControllerLayout);
            this.mFilterManager = aVar;
            aVar.d(this.mDownloadFilterCallback);
            this.mFilterManager.h();
            c.a.q0.a4.l.a recrodButton = this.mVideoControllerLayout.getRecrodButton();
            TextView recordTimeView = this.mVideoControllerLayout.getRecordTimeView();
            this.mRecordTimeView = recordTimeView;
            c.a.q0.y.a.b bVar2 = new c.a.q0.y.a.b(recrodButton, recordTimeView, this.mOnFinishedCallBack, this.mNeedSpeedCallBack, this.mDeleteLastCallBack);
            this.mDurationManager = bVar2;
            bVar2.setMinDuration(3);
            this.mDurationManager.setMaxDuration(15);
            this.mVideoControllerLayout.setDurationManager(this.mDurationManager);
            this.mSpeedManager = new c.a.q0.y.c.c(getPageContext(), this.mSpeedChangedCallBack, null);
            c.a.q0.y.b.c cVar = new c.a.q0.y.b.c(getPageContext(), this.mRatioChangedCallBack);
            this.mRatioManager = cVar;
            cVar.d(0);
            this.mMuxerManager = new c.a.q0.f0.b.c(getPageContext(), new e(this));
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
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, c.a.q0.y1.k.class);
            c.a.q0.y1.k kVar = runTask != null ? (c.a.q0.y1.k) runTask.getData() : null;
            if (kVar != null) {
                this.mPostMonitorManager = kVar.get();
            }
            c.a.q0.y1.g gVar = this.mPostMonitorManager;
            if (gVar != null) {
                gVar.g();
            }
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            this.mRootView = findViewById(R.id.root_view);
            this.mCaptureTopContainer = (RelativeLayout) findViewById(R.id.capture_top_container);
            this.mCaptureRightContainer = (LinearLayout) findViewById(R.id.capture_right_container);
            ImageView imageView = (ImageView) findViewById(R.id.capture_top_close);
            this.mCaptureClose = imageView;
            imageView.setOnClickListener(this);
            ImageView imageView2 = (ImageView) findViewById(R.id.capture_top_speed);
            this.mCaptureSpeed = imageView2;
            imageView2.setOnClickListener(this);
            ImageView imageView3 = (ImageView) findViewById(R.id.capture_top_ratio);
            this.mCaptureRatio = imageView3;
            imageView3.setOnClickListener(this);
            ImageView imageView4 = (ImageView) findViewById(R.id.capture_top_switch);
            this.mCaptureSwitch = imageView4;
            imageView4.setOnClickListener(this);
            this.mCaptureFilter = (ImageView) findViewById(R.id.capture_right_filter);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.capture_right_filter_container);
            this.mCaptureFilterContainer = relativeLayout;
            relativeLayout.setOnClickListener(this);
            this.mCaptureMusic = (ImageView) findViewById(R.id.capture_right_music);
            RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.capture_right_music_container);
            this.mCaptureMusicContainer = relativeLayout2;
            relativeLayout2.setOnClickListener(this);
            this.mCaptureSticker = (ImageView) findViewById(R.id.capture_bottom_sticker);
            RelativeLayout relativeLayout3 = (RelativeLayout) findViewById(R.id.capture_bottom_sticker_container);
            this.mCaptureStickerContainer = relativeLayout3;
            relativeLayout3.setOnClickListener(this);
            this.mCaptureAlbum = (ImageView) findViewById(R.id.capture_bottom_album);
            RelativeLayout relativeLayout4 = (RelativeLayout) findViewById(R.id.capture_bottom_album_container);
            this.mCaptureAlbumContainer = relativeLayout4;
            relativeLayout4.setOnClickListener(this);
            TextView textView = (TextView) findViewById(R.id.capture_right_text_filter);
            this.mCaptureFilterText = textView;
            c.a.p0.s.u.c.d(textView).x(R.array.S_O_X001);
            TextView textView2 = (TextView) findViewById(R.id.capture_right_text_music);
            this.mCaptureMusicText = textView2;
            c.a.p0.s.u.c.d(textView2).x(R.array.S_O_X001);
            TextView textView3 = (TextView) findViewById(R.id.capture_bottom_text_sticker);
            this.mCaptureStickerText = textView3;
            c.a.p0.s.u.c.d(textView3).x(R.array.S_O_X001);
            TextView textView4 = (TextView) findViewById(R.id.capture_bottom_text_album);
            this.mCaptureAlbumText = textView4;
            c.a.p0.s.u.c.d(textView4).x(R.array.S_O_X001);
            TextView textView5 = (TextView) findViewById(R.id.capture_bottom_text_next);
            this.mCaptureNextText = textView5;
            c.a.p0.s.u.c.d(textView5).x(R.array.S_O_X001);
            TextView textView6 = (TextView) findViewById(R.id.capture_bottom_text_delete);
            this.mCaptureDeleteText = textView6;
            c.a.p0.s.u.c.d(textView6).x(R.array.S_O_X001);
            TextView textView7 = (TextView) findViewById(R.id.capture_left_current_filter_name);
            this.mFilterName = textView7;
            c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(textView7);
            d2.z(R.string.F_X02);
            d2.x(R.array.S_O_X001);
            this.mVideoControllerLayout.setRecordManager(this.mRecordManager);
            this.mVideoControllerLayout.setEffectChoosedListener(new f(this));
            this.mVideoControllerLayout.setRecordControlListener(new g(this));
            c.a.q0.o0.c.c cVar = new c.a.q0.o0.c.c(getPageContext(), this.mVideoControllerLayout);
            this.mRecordMusicManager = cVar;
            this.mVideoControllerLayout.setMusicManager(cVar);
            RelativeLayout relativeLayout5 = (RelativeLayout) findViewById(R.id.capture_bottom_next_container);
            this.mCaptureNextContainer = relativeLayout5;
            relativeLayout5.setOnClickListener(this);
            this.mCaptureNext = (ImageView) findViewById(R.id.next_btn);
            HorizontalCenterSelectView horizontalCenterSelectView = (HorizontalCenterSelectView) findViewById(R.id.max_duration);
            this.mMaxDuration = horizontalCenterSelectView;
            horizontalCenterSelectView.setItemTextPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X012));
            this.mMaxDuration.setItemTextSize(UtilHelper.getDimenPixelSize(R.dimen.T_X05));
            this.mMaxDuration.setItemTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.CAM_X0101));
            this.mDurationData = new ArrayList();
            this.mDurationMap = new HashMap();
            this.mDurationData.add(getString(R.string.five_min));
            this.mDurationMap.put(getString(R.string.five_min), 300);
            this.mDurationData.add(getString(R.string.sixty_sec));
            this.mDurationMap.put(getString(R.string.sixty_sec), 60);
            this.mDurationData.add(getString(R.string.fifteen_sec));
            this.mDurationMap.put(getString(R.string.fifteen_sec), 15);
            this.mMaxDuration.setOnItemSelected(new h(this));
            this.mMaxDuration.setData(this.mDurationData);
            this.mMaxDuration.setSelectedPosition(this.mDurationData.size() - 1);
            RelativeLayout relativeLayout6 = (RelativeLayout) findViewById(R.id.capture_bottom_delete_container);
            this.mCaptureDeleteContainer = relativeLayout6;
            relativeLayout6.setOnClickListener(this);
            this.mCaptureDelete = (ImageView) findViewById(R.id.btn_delete);
            this.mCaptureClose.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_topbar_close_white44));
            updateSpeedButtonStyle(false);
            updateRatioButtonResId();
            this.mCaptureSwitch.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_topbar_changecamera44));
            this.mCaptureFilter.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_lvjing40));
            this.mCaptureMusic.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_music40));
            this.mCaptureSticker.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_paster30));
            this.mCaptureAlbum.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_album30));
            this.mCaptureNext.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_next16));
            c.a.p0.s.u.c d3 = c.a.p0.s.u.c.d(this.mCaptureNext);
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
            albumFloatActivityConfig.setRequestCode(12002);
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
            httpMessage.addParam("uh", Build.MANUFACTURER + "," + Build.HARDWARE + "," + Build.BOARD + "," + (c.a.q0.v3.d.b(this) ? 1 : 0));
            httpMessage.addParam("ut", Build.MODEL + "_" + Build.VERSION.RELEASE + "_" + c.a.q0.v3.d.a() + "_" + Build.BRAND.replace("_", ""));
            StringBuilder sb = new StringBuilder();
            sb.append(c.a.a0.a.b.i());
            sb.append("");
            httpMessage.addParam(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, sb.toString());
            sendMessage(httpMessage);
        }
    }

    private void loadStickers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65581, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_QM_STICKERS);
            httpMessage.addParam("uh", Build.MANUFACTURER + "," + Build.HARDWARE + "," + Build.BOARD + "," + (c.a.q0.v3.d.b(this) ? 1 : 0));
            httpMessage.addParam("ut", Build.MODEL + "_" + Build.VERSION.RELEASE + "_" + c.a.q0.v3.d.a() + "_" + Build.BRAND.replace("_", ""));
            StringBuilder sb = new StringBuilder();
            sb.append(c.a.a0.a.b.i());
            sb.append("");
            httpMessage.addParam(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, sb.toString());
            httpMessage.addParam("brand", "baiduar");
            sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetCapturePage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65582, this) == null) {
            c.a.q0.f0.c.a aVar = this.mRecordManager;
            if (aVar != null && aVar.c()) {
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
            this.mVideoControllerLayout.stopRecordAnimator();
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
        c.a.q0.y.a.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65583, this) == null) || (aVar = this.mDurationManager) == null) {
            return;
        }
        aVar.setShowDeleteLastTip(false);
        this.mCaptureDelete.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_recall30));
        this.mCaptureDeleteText.setText(getResources().getString(R.string.undo));
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
            this.mCaptureFilter.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_lvjing40));
            this.mCaptureMusic.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_music40));
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
            c.a.q0.y.a.a aVar = this.mDurationManager;
            if (aVar != null && aVar.getProgress() < 3.0f) {
                c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(this.mCaptureNext);
                d2.n(R.string.J_X01);
                d2.e(R.string.A_X09);
                d2.f(R.color.CAM_X0302);
            } else {
                c.a.p0.s.u.c d3 = c.a.p0.s.u.c.d(this.mCaptureNext);
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
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.capture_guide_view_container);
                this.mCaptureGuideContainer = relativeLayout;
                c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(relativeLayout);
                d2.e(R.string.A_X09);
                d2.f(R.color.CAM_X0611);
            }
            if (this.mCaptureGuide == null) {
                this.mCaptureGuide = (TBLottieAnimationView) findViewById(R.id.capture_guide_view);
            }
            this.mCaptureGuideContainer.setVisibility(0);
            this.mCaptureGuide.setAnimation(i2);
            this.mCaptureGuide.loop(true);
            this.mCaptureGuide.playAnimation();
            c.a.e.e.m.e.a().postDelayed(new i(this), 3000L);
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
            this.mRatioDrawableId = R.drawable.icon_pure_topbar_pingmubili44;
            this.mRatioSelectedDrawableId = R.drawable.icon_pure_topbar_pingmubili_s44;
            c.a.q0.y.b.b bVar = this.mRatioManager;
            if (bVar == null) {
                return;
            }
            if (bVar.e() == 1.0f) {
                this.mRatioDrawableId = R.drawable.icon_pure_topbar_bili11_n44;
                this.mRatioSelectedDrawableId = R.drawable.icon_pure_topbar_bili11_s44;
            } else if (this.mRatioManager.e() == 1.3333334f) {
                this.mRatioDrawableId = R.drawable.icon_pure_topbar_bili34_n44;
                this.mRatioSelectedDrawableId = R.drawable.icon_pure_topbar_bili34_s44;
            } else if (this.mRatioManager.e() == 1.7777778f) {
                this.mRatioDrawableId = R.drawable.icon_pure_topbar_bili916_n44;
                this.mRatioSelectedDrawableId = R.drawable.icon_pure_topbar_bili916_s44;
            } else if (this.mRatioManager.e() == 0.5625f) {
                this.mRatioDrawableId = R.drawable.icon_pure_topbar_bili169_n44;
                this.mRatioSelectedDrawableId = R.drawable.icon_pure_topbar_bili169_s44;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65591, this, z) == null) {
            int i2 = R.drawable.icon_pure_topbar_biansu_off44;
            int i3 = R.drawable.icon_pure_topbar_biansuoff_s44;
            c.a.q0.y.c.b bVar = this.mSpeedManager;
            if (bVar != null && bVar.d()) {
                i2 = R.drawable.icon_pure_topbar_biansu_on44;
                i3 = R.drawable.icon_pure_topbar_biansuon_s44;
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
            String stringExtra = intent.getStringExtra("music_id");
            TbMusicData tbMusicData = (TbMusicData) intent.getSerializableExtra("music_data");
            if (tbMusicData != null) {
                this.mCurrentMusicData = tbMusicData;
                if (TextUtils.isEmpty(tbMusicData.localPath) || TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                String str = tbMusicData.localPath;
                if (this.mRecordMusicManager == null || TextUtils.isEmpty(str)) {
                    return;
                }
                this.mRecordMusicManager.e(str, stringExtra);
                this.mVideoControllerLayout.selectCloudMusic(tbMusicData);
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
                this.mCaptureDelete.setImageDrawable(getResources().getDrawable(this.mDurationManager.isShowingDeleteLastTip() ? R.drawable.icon_pure_video_delete30 : R.drawable.icon_pure_video_recall30));
                this.mCaptureDeleteText.setText(getResources().getString(this.mDurationManager.isShowingDeleteLastTip() ? R.string.delete : R.string.undo));
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        a.c cVar;
        c.a.q0.y.b.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            super.onClick(view);
            if (view.getId() == R.id.capture_top_close) {
                onBackPressed();
                return;
            }
            if (view.getId() == R.id.capture_top_speed) {
                c.a.q0.y.c.b bVar2 = this.mSpeedManager;
                if (bVar2 != null) {
                    boolean z = bVar2.b() == 0;
                    hideTopMenus();
                    resetTopIcon();
                    this.mSpeedManager.c(z ? 8 : 0);
                    updateSpeedButtonStyle(this.mSpeedManager.b() == 0);
                }
            } else if (view.getId() == R.id.capture_top_ratio) {
                if (!ListUtils.isEmpty(this.mVideoPartList) || (bVar = this.mRatioManager) == null) {
                    return;
                }
                boolean z2 = bVar.b() == 0;
                hideTopMenus();
                resetTopIcon();
                if (z2) {
                    this.mCaptureRatio.setImageDrawable(getResources().getDrawable(this.mRatioDrawableId));
                    this.mRatioManager.c(8);
                    return;
                }
                this.mCaptureRatio.setImageDrawable(getResources().getDrawable(this.mRatioSelectedDrawableId));
                this.mRatioManager.c(0);
            } else if (view.getId() == R.id.capture_top_switch) {
                c.a.q0.f0.c.a aVar = this.mRecordManager;
                if (aVar != null) {
                    aVar.d();
                }
                if (c.a.p0.s.d0.b.j().g("key_capture_switch_camera_guide_show", false)) {
                    return;
                }
                showGuideView(R.raw.capture_switch_camera);
                c.a.p0.s.d0.b.j().t("key_capture_switch_camera_guide_show", true);
            } else if (view.getId() == R.id.capture_right_filter_container) {
                if (!c.a.p0.s.d0.b.j().g("key_capture_filter_guide_show", false)) {
                    showGuideView(R.raw.capture_switch_filter);
                    c.a.p0.s.d0.b.j().t("key_capture_filter_guide_show", true);
                }
                resetRightIcon();
                if (this.mVideoControllerLayout.isFilterEffectLayoutVisible()) {
                    this.mCaptureFilter.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_lvjing40));
                } else {
                    this.mCaptureFilter.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_lvjing_s44));
                }
                this.mVideoControllerLayout.onClickFilter();
                if (this.mVideoControllerLayout.isNeedLoadFilter()) {
                    loadFilter();
                }
            } else if (view.getId() == R.id.capture_right_music_container) {
                if (ListUtils.isEmpty(this.mVideoPartList)) {
                    resetRightIcon();
                    if (this.mVideoControllerLayout.isMusicEffectLayoutVisible()) {
                        this.mCaptureMusic.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_music40));
                    } else {
                        this.mCaptureMusic.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_music_s44));
                    }
                    this.mVideoControllerLayout.onClickMusic();
                }
            } else if (view.getId() == R.id.capture_bottom_sticker_container) {
                resetRightIcon();
                this.mVideoControllerLayout.onClickSticker();
                if (this.mVideoControllerLayout.isNeedLoadSticker()) {
                    loadStickers();
                }
            } else if (view.getId() == R.id.capture_bottom_album_container) {
                resetRightIcon();
                jumpToAlbumActivity();
            } else if (view.getId() == R.id.capture_bottom_delete_container) {
                c.a.q0.y.a.a aVar2 = this.mDurationManager;
                if (aVar2 != null) {
                    if (aVar2.isShowingDeleteLastTip()) {
                        this.mDurationManager.deleteLast();
                        this.mCaptureDelete.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_recall30));
                        this.mCaptureDeleteText.setText(getResources().getString(R.string.undo));
                        return;
                    }
                    this.mDurationManager.setShowDeleteLastTip(true);
                    this.mCaptureDelete.setImageDrawable(getResources().getDrawable(R.drawable.icon_pure_video_delete30));
                    this.mCaptureDeleteText.setText(getResources().getString(R.string.delete));
                }
            } else if (view.getId() != R.id.capture_bottom_next_container || (cVar = this.mOnFinishedCallBack) == null) {
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
            setContentView(R.layout.activity_capture);
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
            c.a.q0.f0.c.a aVar = this.mRecordManager;
            if (aVar != null) {
                aVar.onDestroy();
            }
            c.a.q0.o0.c.a aVar2 = this.mRecordMusicManager;
            if (aVar2 != null) {
                aVar2.releasePlayer();
                this.mRecordMusicManager.c();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onPause();
            c.a.q0.f0.c.a aVar = this.mRecordManager;
            if (aVar != null) {
                aVar.onPause();
            }
            c.a.q0.o0.c.a aVar2 = this.mRecordMusicManager;
            if (aVar2 != null) {
                aVar2.onPause();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            View view = this.mRootView;
            if (view != null) {
                view.setSystemUiVisibility(4100);
            }
            c.a.q0.f0.c.a aVar = this.mRecordManager;
            if (aVar != null) {
                aVar.onResume();
            }
            c.a.q0.o0.c.a aVar2 = this.mRecordMusicManager;
            if (aVar2 != null) {
                aVar2.onResume();
            }
            c.a.q0.o0.d.a aVar3 = this.mStickerManager;
            if (aVar3 != null) {
                aVar3.e();
            }
            c.a.q0.o0.b.b bVar = this.mFilterManager;
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
