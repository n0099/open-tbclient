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
import com.repackage.ax5;
import com.repackage.bv8;
import com.repackage.bx5;
import com.repackage.cx5;
import com.repackage.d86;
import com.repackage.dw8;
import com.repackage.dx5;
import com.repackage.e06;
import com.repackage.e86;
import com.repackage.ed0;
import com.repackage.ex5;
import com.repackage.f86;
import com.repackage.fx5;
import com.repackage.g06;
import com.repackage.gx5;
import com.repackage.h06;
import com.repackage.h86;
import com.repackage.i06;
import com.repackage.j86;
import com.repackage.k86;
import com.repackage.kl7;
import com.repackage.mr4;
import com.repackage.ng;
import com.repackage.np8;
import com.repackage.nu8;
import com.repackage.ol7;
import com.repackage.op8;
import com.repackage.or4;
import com.repackage.qg;
import com.repackage.vr4;
import com.repackage.yt4;
import com.repackage.zw5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class TbCaptureActivity extends BaseActivity<TbCaptureActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HorizontalCenterSelectView A;
    public TextView B;
    public RelativeLayout C;
    public LinearLayout D;
    public RecordPreviewContainer E;
    public kl7 F;
    public h06 G;
    public zw5 H;
    public fx5 I;
    public cx5 J;
    public e86 K;
    public j86 L;
    public e06 M;
    public f86 N;
    public TbMusicData O;
    public ArrayList<String> P;
    public boolean Q;
    public Map<String, Integer> R;
    public List<String> S;
    public int T;
    public int U;
    public VideoControllerLayout V;
    public h06.b W;
    public h06.a X;
    public zw5.c Y;
    public zw5.b Z;
    public ImageView a;
    public zw5.a a0;
    public ImageView b;
    public ex5 b0;
    public TBLottieAnimationView c;
    public bx5 c0;
    public RelativeLayout d;
    public HttpMessageListener d0;
    public View e;
    public HttpMessageListener e0;
    public ImageView f;
    public d86.b f0;
    public ImageView g;
    public k86.b g0;
    public ImageView h;
    public CustomMessageListener h0;
    public ImageView i;
    public ImageView j;
    public ImageView k;
    public ImageView l;
    public ImageView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public RelativeLayout u;
    public RelativeLayout v;
    public RelativeLayout w;
    public RelativeLayout x;
    public RelativeLayout y;
    public RelativeLayout z;

    /* loaded from: classes4.dex */
    public class a implements d86.b {
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

        @Override // com.repackage.d86.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.V != null) {
                    QmFilterItem qmFilterItem = new QmFilterItem();
                    qmFilterItem.id = "-1";
                    qmFilterItem.bgurl = R.drawable.obfuscated_res_0x7f0809f8 + "";
                    qmFilterItem.name = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0618);
                    qmFilterItem.isSelect = true;
                    qmFilterItem.localPath = "origin";
                    this.a.V.z(qmFilterItem);
                    if (this.a.K != null) {
                        this.a.K.a(null);
                    }
                    this.a.V.setDownLoadFilter(null);
                }
                if (StringUtils.isNull(str)) {
                    str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f11b8);
                }
                this.a.showToast(str);
                this.a.F.b(5, str);
            }
        }

        @Override // com.repackage.d86.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.V == null) {
                return;
            }
            this.a.V.setDownLoadFilter(null);
        }

        @Override // com.repackage.d86.b
        public void c(QmFilterItem qmFilterItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qmFilterItem) == null) {
                if (this.a.K != null) {
                    this.a.K.a(qmFilterItem);
                }
                if (this.a.V != null) {
                    this.a.V.setDownLoadFilter(null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements k86.b {
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

        @Override // com.repackage.k86.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.V != null) {
                    QmStickerItem qmStickerItem = new QmStickerItem();
                    qmStickerItem.id = -1;
                    qmStickerItem.isLocalSource = true;
                    qmStickerItem.localPath = "nosticker";
                    this.a.V.A(qmStickerItem);
                    if (this.a.L != null) {
                        this.a.L.b(null);
                    }
                    this.a.V.setDownLoadSticker(qmStickerItem, false);
                }
                if (StringUtils.isNull(str)) {
                    str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f11b8);
                }
                this.a.showToast(str);
                this.a.F.b(5, str);
            }
        }

        @Override // com.repackage.k86.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.V == null) {
                return;
            }
            this.a.V.setDownLoadSticker(null, false);
        }

        @Override // com.repackage.k86.b
        public void c(QmStickerItem qmStickerItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qmStickerItem) == null) {
                if (this.a.L != null) {
                    this.a.L.b(qmStickerItem);
                }
                if (this.a.V != null) {
                    this.a.V.setDownLoadSticker(qmStickerItem, true);
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
    public class d implements or4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mr4 a;
        public final /* synthetic */ TbCaptureActivity b;

        public d(TbCaptureActivity tbCaptureActivity, mr4 mr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity, mr4Var};
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
            this.a = mr4Var;
        }

        @Override // com.repackage.or4.e
        public void N(or4 or4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, or4Var, i, view2) == null) {
                if (i == 0) {
                    this.b.t2();
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
    public class e implements e06.a {
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

        @Override // com.repackage.e06.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TbCaptureActivity tbCaptureActivity = this.a;
                tbCaptureActivity.hideLoadingView(tbCaptureActivity.e);
            }
        }

        @Override // com.repackage.e06.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                TbCaptureActivity tbCaptureActivity = this.a;
                tbCaptureActivity.showLoadingView(tbCaptureActivity.e);
            }
        }

        @Override // com.repackage.e06.a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                VideoFileInfo c = np8.c(str);
                if (c == null) {
                    TbCaptureActivity tbCaptureActivity = this.a;
                    tbCaptureActivity.hideLoadingView(tbCaptureActivity.e);
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
                if (this.a.O != null && this.a.N != null) {
                    this.a.O.localPath = this.a.N.b();
                    tbEditVideoActivityConfig.setMusicData(this.a.O);
                }
                if (this.a.J != null) {
                    tbEditVideoActivityConfig.setVideoRatio(this.a.J.getRatio());
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbEditVideoActivityConfig));
                TbCaptureActivity tbCaptureActivity2 = this.a;
                tbCaptureActivity2.hideLoadingView(tbCaptureActivity2.e);
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, qmStickerItem) == null) || qmStickerItem == null || this.a.L == null) {
                return;
            }
            String a = this.a.L.a(qmStickerItem.fileUrl);
            if (StringUtils.isNull(a) && -1 != qmStickerItem.id) {
                if (this.a.V != null) {
                    this.a.V.setDownLoadSticker(qmStickerItem, false);
                }
                this.a.L.d(qmStickerItem);
                return;
            }
            qmStickerItem.localPath = a;
            this.a.L.b(qmStickerItem);
            if (this.a.V != null) {
                this.a.V.setDownLoadSticker(qmStickerItem, true);
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void b(dw8 dw8Var, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dw8Var, obj) == null) || dw8Var == null) {
                return;
            }
            int type = dw8Var.getType();
            if (type == 2) {
                if (this.a.K != null && (dw8Var.c() instanceof QmFilterItem)) {
                    QmFilterItem qmFilterItem = (QmFilterItem) dw8Var.c();
                    String f = this.a.K.f(qmFilterItem.fileUrl);
                    if (StringUtils.isNull(f) && !"-1".equals(qmFilterItem.id)) {
                        if (this.a.V != null) {
                            this.a.V.setDownLoadFilter(qmFilterItem);
                        }
                        this.a.K.c(qmFilterItem);
                        return;
                    }
                    qmFilterItem.localPath = f;
                    this.a.K.a(qmFilterItem);
                    if (this.a.V != null) {
                        this.a.V.setDownLoadFilter(null);
                    }
                }
            } else if (type == 3 && (dw8Var.c() instanceof MusicData)) {
                MusicData musicData = (MusicData) dw8Var.c();
                TbMusicData tbMusicData = new TbMusicData();
                tbMusicData.id = musicData.id;
                tbMusicData.title = musicData.name;
                tbMusicData.url = musicData.resource;
                tbMusicData.icon = musicData.img;
                tbMusicData.type = ng.e(musicData.type, 1);
                if (MusicData.MUSIC_NORMAL_ID.equals(musicData.id) || MusicData.MUSIC_CLOUD_ID.equals(musicData.id)) {
                    this.a.N.e(this.a.O);
                    this.a.O = tbMusicData;
                    if (!MusicData.MUSIC_CLOUD_ID.equals(musicData.id)) {
                        this.a.V.setMusicName(this.a.O.title, "");
                    }
                } else {
                    this.a.O = tbMusicData;
                    this.a.N.e(this.a.O);
                    this.a.V.setMusicName(this.a.O.title, "");
                }
                this.a.N.c((MusicData) dw8Var.c(), obj);
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
                if (!ListUtils.isEmpty(this.a.P) || this.a.G.c()) {
                    if (this.a.G.c()) {
                        this.a.w.setVisibility(8);
                    } else {
                        this.a.w.setVisibility(0);
                    }
                    this.a.y.setVisibility(0);
                    this.a.y2(0);
                    this.a.A.setVisibility(8);
                    this.a.x.setVisibility(8);
                    return;
                }
                if (z) {
                    this.a.A.setVisibility(8);
                    this.a.w.setVisibility(8);
                    this.a.x.setVisibility(8);
                } else {
                    this.a.A.setVisibility(0);
                    this.a.w.setVisibility(0);
                    this.a.x.setVisibility(0);
                }
                this.a.y.setVisibility(8);
                this.a.y2(8);
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.A.setVisibility(8);
                this.a.w.setVisibility(8);
                this.a.x.setVisibility(8);
                this.a.y.setVisibility(8);
                this.a.y2(8);
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void l() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.G == null) {
                return;
            }
            this.a.G.stopRecord();
            this.a.C.setVisibility(0);
            this.a.D.setVisibility(0);
            this.a.y.setVisibility(0);
            this.a.y2(0);
            this.a.w.setVisibility(0);
            if (this.a.N != null) {
                this.a.N.pause();
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.A.setVisibility(8);
                this.a.w.setVisibility(8);
                this.a.x.setVisibility(8);
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void o() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void q() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.a.H == null) {
                return;
            }
            if (this.a.H.getProgress() < this.a.H.getMaxDuration()) {
                this.a.G.startRecord();
                this.a.C.setVisibility(8);
                this.a.D.setVisibility(8);
                this.a.l2();
                this.a.v2();
                this.a.y.setVisibility(8);
                if (this.a.H.getProgress() < 3.0f) {
                    this.a.y2(8);
                } else {
                    this.a.y2(0);
                }
                this.a.w.setVisibility(8);
                this.a.u2();
                if (this.a.N != null) {
                    this.a.N.a(this.a.H.getProgress());
                }
                this.a.Q = false;
            } else if (this.a.H.getProgress() < this.a.H.getMaxDuration() || this.a.V == null) {
            } else {
                this.a.V.E();
                if (this.a.M != null) {
                    this.a.M.b(this.a.P);
                }
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
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.H == null) {
                return;
            }
            this.a.H.setMaxDuration(((Integer) this.a.R.get((String) this.a.S.get(i))).intValue());
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
                this.a.c.pauseAnimation();
                this.a.d.setVisibility(8);
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
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, motionEvent, i) == null) || this.a.G == null) {
                return;
            }
            nu8.D(this.a.getPageContext()).l(i);
            this.a.u2();
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.e
        public void b(MotionEvent motionEvent, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || this.a.G == null) {
                return;
            }
            nu8.D(this.a.getPageContext()).c(i, i2, i3, i4);
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements h06.b {
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

        @Override // com.repackage.h06.b
        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (this.a.H != null) {
                    this.a.H.pause();
                    if (!StringUtils.isNull(str)) {
                        this.a.P.add(str);
                        if (this.a.Q && ListUtils.getCount(this.a.P) == this.a.H.getSlideNum() && this.a.M != null) {
                            this.a.M.b(this.a.P);
                        }
                    }
                    this.a.A2();
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.repackage.h06.b
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.H != null) {
                    if (ListUtils.isEmpty(this.a.P) && this.a.V != null) {
                        this.a.V.D();
                    }
                    this.a.H.start();
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
                this.a.t.setVisibility(8);
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) || this.b.G == null || this.b.G.c() || this.b.K == null) {
                return;
            }
            this.b.K.g();
            String currentFilterName = this.b.V.getCurrentFilterName();
            if (!StringUtils.isNull(currentFilterName)) {
                this.b.t.removeCallbacks(this.a);
                this.b.t.setText(currentFilterName);
                this.b.t.setVisibility(0);
                this.b.t.postDelayed(this.a, 800L);
            }
            this.b.u2();
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void b(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent) == null) || this.b.G == null || this.b.G.c() || this.b.K == null) {
                return;
            }
            this.b.K.e();
            String currentFilterName = this.b.V.getCurrentFilterName();
            if (!StringUtils.isNull(currentFilterName)) {
                this.b.t.removeCallbacks(this.a);
                this.b.t.setText(currentFilterName);
                this.b.t.setVisibility(0);
                this.b.t.postDelayed(this.a, 800L);
            }
            this.b.u2();
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void c(MotionEvent motionEvent, float f, float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, Float.valueOf(f), Float.valueOf(f2)}) == null) || this.b.G == null || this.b.G.c()) {
                return;
            }
            this.b.G.d();
            this.b.u2();
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void d(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
                this.b.l2();
                this.b.v2();
                if (this.b.V != null && this.b.V.p()) {
                    this.b.V.m(null, false);
                }
                if (this.b.G == null || this.b.G.c() || this.b.E == null) {
                    return;
                }
                this.b.E.i(motionEvent);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements h06.a {
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

        @Override // com.repackage.h06.a
        public void onProgress(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048576, this, j) == null) || this.a.H == null) {
                return;
            }
            this.a.H.setProgress(j);
            if (this.a.H.getProgress() >= 3.0f) {
                this.a.y2(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements zw5.c {
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

        @Override // com.repackage.zw5.c
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.Q = true;
                if (this.a.G != null && !this.a.G.c() && this.a.Q && ListUtils.getCount(this.a.P) == this.a.H.getSlideNum() && this.a.M != null) {
                    this.a.M.b(this.a.P);
                }
                if (this.a.V != null) {
                    this.a.V.E();
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class p implements zw5.b {
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

        @Override // com.repackage.zw5.b
        public float getSpeed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.I != null) {
                    return this.a.I.getSpeed();
                }
                return 1.0f;
            }
            return invokeV.floatValue;
        }
    }

    /* loaded from: classes4.dex */
    public class q implements zw5.a {
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

        @Override // com.repackage.zw5.a
        public boolean a(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
                if (ListUtils.isEmpty(this.a.P)) {
                    return false;
                }
                this.a.P.remove(this.a.P.size() - 1);
                if (this.a.P.size() <= 0) {
                    if (this.a.H != null) {
                        this.a.H.reset();
                    }
                    this.a.y.setVisibility(8);
                    this.a.y2(8);
                    this.a.A.setVisibility(0);
                    this.a.V.F();
                    this.a.w.setVisibility(0);
                    this.a.x.setVisibility(0);
                }
                this.a.A2();
                return true;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class r implements ex5 {
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

        @Override // com.repackage.ex5
        public boolean a(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
                if (this.a.G == null || this.a.G.e() == null) {
                    return false;
                }
                this.a.G.e().a(f);
                if (this.a.I != null) {
                    TbCaptureActivity tbCaptureActivity = this.a;
                    tbCaptureActivity.C2(tbCaptureActivity.I.a() == 0);
                }
                return true;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class s implements bx5 {
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

        @Override // com.repackage.bx5
        public boolean a(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
                if (this.a.G == null || this.a.G.f() == null) {
                    return false;
                }
                this.a.G.f().a(f);
                this.a.B2();
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
                if (this.a.V != null) {
                    if (stickerItems == null) {
                        stickerItems = new ArrayList<>();
                    }
                    for (QmStickerItem qmStickerItem : stickerItems) {
                        if (qmStickerItem != null && this.a.L != null && !StringUtils.isNull(qmStickerItem.fileUrl) && !StringUtils.isNull(this.a.L.a(qmStickerItem.fileUrl))) {
                            qmStickerItem.isLocalSource = true;
                        }
                    }
                    QmStickerItem qmStickerItem2 = new QmStickerItem();
                    qmStickerItem2.id = -1;
                    qmStickerItem2.isSelect = true;
                    qmStickerItem2.isLocalSource = true;
                    qmStickerItem2.localPath = "nosticker";
                    stickerItems.add(0, qmStickerItem2);
                    this.a.V.setStickerItems(stickerItems);
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
                if (this.a.V != null) {
                    if (filterItems == null) {
                        filterItems = new ArrayList<>();
                    }
                    QmFilterItem qmFilterItem = new QmFilterItem();
                    qmFilterItem.id = "-1";
                    qmFilterItem.bgurl = R.drawable.obfuscated_res_0x7f0809f8 + "";
                    qmFilterItem.name = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0618);
                    qmFilterItem.isSelect = true;
                    qmFilterItem.localPath = "origin";
                    filterItems.add(0, qmFilterItem);
                    this.a.V.setFilterData(filterItems);
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
        this.P = new ArrayList<>();
        this.Q = false;
        this.T = R.drawable.obfuscated_res_0x7f0809dd;
        this.U = R.drawable.obfuscated_res_0x7f0809de;
        this.W = new k(this);
        this.X = new n(this);
        this.Y = new o(this);
        this.Z = new p(this);
        this.a0 = new q(this);
        this.b0 = new r(this);
        this.c0 = new s(this);
        this.d0 = new t(this, CmdConfigHttp.CMD_GET_QM_STICKERS, true);
        this.e0 = new u(this, CmdConfigHttp.CMD_GET_QM_FILTERS, true);
        this.f0 = new a(this);
        this.g0 = new b(this);
        this.h0 = new c(this, 2921583);
    }

    public final void A2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!ListUtils.isEmpty(this.P)) {
                this.h.setAlpha(SkinManager.RESOURCE_ALPHA_DISABLE);
                this.v.setAlpha(SkinManager.RESOURCE_ALPHA_DISABLE);
                return;
            }
            this.h.setAlpha(1.0f);
            this.v.setAlpha(1.0f);
        }
    }

    public final void B2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.T = R.drawable.obfuscated_res_0x7f0809dd;
            this.U = R.drawable.obfuscated_res_0x7f0809de;
            cx5 cx5Var = this.J;
            if (cx5Var == null) {
                return;
            }
            if (cx5Var.d() == 1.0f) {
                this.T = R.drawable.obfuscated_res_0x7f0809c5;
                this.U = R.drawable.obfuscated_res_0x7f0809c6;
            } else if (this.J.d() == 1.3333334f) {
                this.T = R.drawable.obfuscated_res_0x7f0809c9;
                this.U = R.drawable.obfuscated_res_0x7f0809ca;
            } else if (this.J.d() == 1.7777778f) {
                this.T = R.drawable.obfuscated_res_0x7f0809cb;
                this.U = R.drawable.obfuscated_res_0x7f0809cc;
            } else if (this.J.d() == 0.5625f) {
                this.T = R.drawable.obfuscated_res_0x7f0809c7;
                this.U = R.drawable.obfuscated_res_0x7f0809c8;
            }
            if (this.J.a() == 0) {
                this.h.setImageDrawable(getResources().getDrawable(this.U));
            } else {
                this.h.setImageDrawable(getResources().getDrawable(this.T));
            }
        }
    }

    public final void C2(boolean z) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            fx5 fx5Var = this.I;
            if (fx5Var == null || !fx5Var.c()) {
                i2 = R.drawable.obfuscated_res_0x7f0809c1;
                i3 = R.drawable.obfuscated_res_0x7f0809c3;
            } else {
                i2 = R.drawable.obfuscated_res_0x7f0809c2;
                i3 = R.drawable.obfuscated_res_0x7f0809c4;
            }
            if (z) {
                this.g.setImageDrawable(getResources().getDrawable(i3));
            } else {
                this.g.setImageDrawable(getResources().getDrawable(i2));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    public final void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            zw5 zw5Var = this.H;
            if (zw5Var != null && zw5Var.getProgress() > 0.0f) {
                mr4 mr4Var = new mr4(getPageContext(), new or4(getPageContext().getPageActivity()));
                mr4Var.j(null, new String[]{getString(R.string.obfuscated_res_0x7f0f037a), getResources().getString(R.string.obfuscated_res_0x7f0f0f40)}, new d(this, mr4Var));
                mr4Var.m();
                return;
            }
            finish();
        }
    }

    public final void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            fx5 fx5Var = this.I;
            if (fx5Var != null) {
                fx5Var.b(8);
            }
            cx5 cx5Var = this.J;
            if (cx5Var != null) {
                cx5Var.b(8);
            }
        }
    }

    public final void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            registerListener(this.d0);
            registerListener(this.e0);
            registerListener(this.h0);
            this.E.setOnPreviewStateChangedListener(new j(this));
            this.E.setOnViewClickListener(new m(this, new l(this)));
        }
    }

    public final void n2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.E = (RecordPreviewContainer) findViewById(R.id.obfuscated_res_0x7f09048c);
            this.G = new i06(getPageContext(), this.E.getSurfaceView(), true, this.W, this.X);
            k86 k86Var = new k86(this.G);
            this.L = k86Var;
            k86Var.c(this.g0);
            this.L.e();
            this.V = (VideoControllerLayout) findViewById(R.id.obfuscated_res_0x7f091a88);
            d86 d86Var = new d86(this.G, null, this.V);
            this.K = d86Var;
            d86Var.d(this.f0);
            this.K.h();
            bv8 recrodButton = this.V.getRecrodButton();
            TextView recordTimeView = this.V.getRecordTimeView();
            this.B = recordTimeView;
            ax5 ax5Var = new ax5(recrodButton, recordTimeView, this.Y, this.Z, this.a0);
            this.H = ax5Var;
            ax5Var.setMinDuration(3);
            this.H.setMaxDuration(15);
            this.V.setDurationManager(this.H);
            this.I = new gx5(getPageContext(), this.b0, null);
            dx5 dx5Var = new dx5(getPageContext(), this.c0);
            this.J = dx5Var;
            dx5Var.c(0);
            this.M = new g06(getPageContext(), new e(this));
            s2();
            r2();
        }
    }

    public final void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_QM_STICKERS, TbConfig.SERVER_ADDRESS + TbConfig.GET_QM_STICKERS);
            tbHttpMessageTask.setResponsedClass(ResponseGetQmStickersMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_QM_FILTERS, TbConfig.SERVER_ADDRESS + TbConfig.GET_QM_FILTERS);
            tbHttpMessageTask2.setResponsedClass(ResponseGetQmFiltersMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask2);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, ol7.class);
            ol7 ol7Var = runTask != null ? (ol7) runTask.getData() : null;
            if (ol7Var != null) {
                this.F = ol7Var.get();
            }
            kl7 kl7Var = this.F;
            if (kl7Var != null) {
                kl7Var.g();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048585, this, i2, i3, intent) == null) && intent != null && i2 == 25032) {
            String stringExtra = intent.getStringExtra(CloudMusicActivityConfig.MUSIC_ID);
            TbMusicData tbMusicData = (TbMusicData) intent.getSerializableExtra(CloudMusicActivityConfig.MUSIC_DATA);
            if (tbMusicData != null) {
                this.O = tbMusicData;
                if (TextUtils.isEmpty(tbMusicData.localPath) || TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                String str = tbMusicData.localPath;
                if (this.N == null || TextUtils.isEmpty(str)) {
                    return;
                }
                this.N.f(str, stringExtra);
                this.V.y(tbMusicData);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            k2();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.H != null) {
                this.b.setImageDrawable(getResources().getDrawable(this.H.b() ? R.drawable.obfuscated_res_0x7f0809f4 : R.drawable.obfuscated_res_0x7f080a02));
                this.r.setText(getResources().getString(this.H.b() ? R.string.obfuscated_res_0x7f0f049e : R.string.obfuscated_res_0x7f0f145d));
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        zw5.c cVar;
        cx5 cx5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            super.onClick(view2);
            if (view2.getId() == R.id.obfuscated_res_0x7f09049c) {
                onBackPressed();
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f09049f) {
                fx5 fx5Var = this.I;
                if (fx5Var != null) {
                    boolean z = fx5Var.a() == 0;
                    l2();
                    x2();
                    this.I.b(z ? 8 : 0);
                    C2(this.I.a() == 0);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09049e) {
                if (!ListUtils.isEmpty(this.P) || (cx5Var = this.J) == null) {
                    return;
                }
                boolean z2 = cx5Var.a() == 0;
                l2();
                x2();
                if (z2) {
                    this.h.setImageDrawable(getResources().getDrawable(this.T));
                    this.J.b(8);
                    return;
                }
                this.h.setImageDrawable(getResources().getDrawable(this.U));
                this.J.b(0);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0904a0) {
                h06 h06Var = this.G;
                if (h06Var != null) {
                    h06Var.d();
                }
                if (yt4.k().h("key_capture_switch_camera_guide_show", false)) {
                    return;
                }
                z2(R.raw.obfuscated_res_0x7f11000a);
                yt4.k().u("key_capture_switch_camera_guide_show", true);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090493) {
                if (!yt4.k().h("key_capture_filter_guide_show", false)) {
                    z2(R.raw.obfuscated_res_0x7f11000b);
                    yt4.k().u("key_capture_filter_guide_show", true);
                }
                w2();
                if (this.V.q()) {
                    this.j.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809f7));
                } else {
                    this.j.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809f9));
                }
                this.V.v();
                if (this.V.t()) {
                    r2();
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090495) {
                if (ListUtils.isEmpty(this.P)) {
                    w2();
                    if (this.V.s()) {
                        this.k.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809fa));
                    } else {
                        this.k.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809fb));
                    }
                    this.V.w();
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090483) {
                w2();
                this.V.x();
                if (this.V.u()) {
                    s2();
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09047f) {
                w2();
                q2();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090480) {
                zw5 zw5Var = this.H;
                if (zw5Var != null) {
                    if (zw5Var.b()) {
                        this.H.a();
                        this.b.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a02));
                        this.r.setText(getResources().getString(R.string.obfuscated_res_0x7f0f145d));
                        return;
                    }
                    this.H.setShowDeleteLastTip(true);
                    this.b.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809f4));
                    this.r.setText(getResources().getString(R.string.obfuscated_res_0x7f0f049e));
                }
            } else if (view2.getId() != R.id.obfuscated_res_0x7f090481 || (cVar = this.Y) == null) {
            } else {
                cVar.a();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d002f);
            setSwipeBackEnabled(false);
            o2();
            n2();
            p2();
            m2();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            h06 h06Var = this.G;
            if (h06Var != null) {
                h06Var.onDestroy();
            }
            f86 f86Var = this.N;
            if (f86Var != null) {
                f86Var.releasePlayer();
                this.N.d();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onPause();
            h06 h06Var = this.G;
            if (h06Var != null) {
                h06Var.onPause();
            }
            f86 f86Var = this.N;
            if (f86Var != null) {
                f86Var.onPause();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onResume();
            View view2 = this.e;
            if (view2 != null) {
                view2.setSystemUiVisibility(4100);
            }
            h06 h06Var = this.G;
            if (h06Var != null) {
                h06Var.onResume();
            }
            f86 f86Var = this.N;
            if (f86Var != null) {
                f86Var.onResume();
            }
            j86 j86Var = this.L;
            if (j86Var != null) {
                j86Var.e();
            }
            e86 e86Var = this.K;
            if (e86Var != null) {
                e86Var.h();
            }
        }
    }

    public final void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.e = findViewById(R.id.obfuscated_res_0x7f091b4c);
            this.C = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09049d);
            this.D = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09048d);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f09049c);
            this.f = imageView;
            imageView.setOnClickListener(this);
            ImageView imageView2 = (ImageView) findViewById(R.id.obfuscated_res_0x7f09049f);
            this.g = imageView2;
            imageView2.setOnClickListener(this);
            ImageView imageView3 = (ImageView) findViewById(R.id.obfuscated_res_0x7f09049e);
            this.h = imageView3;
            imageView3.setOnClickListener(this);
            ImageView imageView4 = (ImageView) findViewById(R.id.obfuscated_res_0x7f0904a0);
            this.i = imageView4;
            imageView4.setOnClickListener(this);
            this.j = (ImageView) findViewById(R.id.obfuscated_res_0x7f090492);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090493);
            this.u = relativeLayout;
            relativeLayout.setOnClickListener(this);
            this.k = (ImageView) findViewById(R.id.obfuscated_res_0x7f090494);
            RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090495);
            this.v = relativeLayout2;
            relativeLayout2.setOnClickListener(this);
            this.l = (ImageView) findViewById(R.id.obfuscated_res_0x7f090482);
            RelativeLayout relativeLayout3 = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090483);
            this.w = relativeLayout3;
            relativeLayout3.setOnClickListener(this);
            this.m = (ImageView) findViewById(R.id.obfuscated_res_0x7f09047e);
            RelativeLayout relativeLayout4 = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09047f);
            this.x = relativeLayout4;
            relativeLayout4.setOnClickListener(this);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f090498);
            this.n = textView;
            vr4.d(textView).y(R.array.S_O_X001);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f090499);
            this.o = textView2;
            vr4.d(textView2).y(R.array.S_O_X001);
            TextView textView3 = (TextView) findViewById(R.id.obfuscated_res_0x7f090487);
            this.p = textView3;
            vr4.d(textView3).y(R.array.S_O_X001);
            TextView textView4 = (TextView) findViewById(R.id.obfuscated_res_0x7f090484);
            this.q = textView4;
            vr4.d(textView4).y(R.array.S_O_X001);
            TextView textView5 = (TextView) findViewById(R.id.obfuscated_res_0x7f090486);
            this.s = textView5;
            vr4.d(textView5).y(R.array.S_O_X001);
            TextView textView6 = (TextView) findViewById(R.id.obfuscated_res_0x7f090485);
            this.r = textView6;
            vr4.d(textView6).y(R.array.S_O_X001);
            TextView textView7 = (TextView) findViewById(R.id.obfuscated_res_0x7f09048a);
            this.t = textView7;
            vr4 d2 = vr4.d(textView7);
            d2.A(R.string.F_X02);
            d2.y(R.array.S_O_X001);
            this.V.setRecordManager(this.G);
            this.V.setEffectChoosedListener(new f(this));
            this.V.setRecordControlListener(new g(this));
            h86 h86Var = new h86(getPageContext(), this.V);
            this.N = h86Var;
            this.V.setMusicManager(h86Var);
            RelativeLayout relativeLayout5 = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090481);
            this.z = relativeLayout5;
            relativeLayout5.setOnClickListener(this);
            this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f0915bd);
            HorizontalCenterSelectView horizontalCenterSelectView = (HorizontalCenterSelectView) findViewById(R.id.obfuscated_res_0x7f091400);
            this.A = horizontalCenterSelectView;
            horizontalCenterSelectView.setItemTextPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X012));
            this.A.setItemTextSize(UtilHelper.getDimenPixelSize(R.dimen.T_X05));
            this.A.setItemTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.CAM_X0101));
            this.S = new ArrayList();
            this.R = new HashMap();
            this.S.add(getString(R.string.obfuscated_res_0x7f0f0624));
            this.R.put(getString(R.string.obfuscated_res_0x7f0f0624), 300);
            this.S.add(getString(R.string.obfuscated_res_0x7f0f1164));
            this.R.put(getString(R.string.obfuscated_res_0x7f0f1164), 60);
            this.S.add(getString(R.string.obfuscated_res_0x7f0f0603));
            this.R.put(getString(R.string.obfuscated_res_0x7f0f0603), 15);
            this.A.setOnItemSelected(new h(this));
            this.A.setData(this.S);
            this.A.setSelectedPosition(this.S.size() - 1);
            RelativeLayout relativeLayout6 = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090480);
            this.y = relativeLayout6;
            relativeLayout6.setOnClickListener(this);
            this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f09040d);
            this.f.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809d2));
            C2(false);
            B2();
            this.i.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809cd));
            this.j.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809f7));
            this.k.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809fa));
            this.l.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809fd));
            this.m.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809f1));
            this.a.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809fc));
            vr4 d3 = vr4.d(this.a);
            d3.n(R.string.J_X01);
            d3.f(R.color.CAM_X0302);
        }
    }

    public final void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
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

    public final void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_QM_FILTERS);
            httpMessage.addParam("uh", Build.MANUFACTURER + "," + Build.HARDWARE + "," + Build.BOARD + "," + (op8.b(this) ? 1 : 0));
            httpMessage.addParam("ut", Build.MODEL + "_" + Build.VERSION.RELEASE + "_" + op8.a() + "_" + Build.BRAND.replace("_", ""));
            StringBuilder sb = new StringBuilder();
            sb.append(ed0.h());
            sb.append("");
            httpMessage.addParam("sdk_version", sb.toString());
            sendMessage(httpMessage);
        }
    }

    public final void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_QM_STICKERS);
            httpMessage.addParam("uh", Build.MANUFACTURER + "," + Build.HARDWARE + "," + Build.BOARD + "," + (op8.b(this) ? 1 : 0));
            httpMessage.addParam("ut", Build.MODEL + "_" + Build.VERSION.RELEASE + "_" + op8.a() + "_" + Build.BRAND.replace("_", ""));
            StringBuilder sb = new StringBuilder();
            sb.append(ed0.h());
            sb.append("");
            httpMessage.addParam("sdk_version", sb.toString());
            httpMessage.addParam(com.xiaomi.mipush.sdk.Constants.PHONE_BRAND, "baiduar");
            sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view2) == null) {
            super.showLoadingView(view2);
            if (getLoadingView() == null || getLoadingView().k() == null) {
                return;
            }
            getLoadingView().k().setVisibility(8);
        }
    }

    public final void t2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            h06 h06Var = this.G;
            if (h06Var != null && h06Var.c()) {
                this.G.stopRecord();
                this.C.setVisibility(0);
                this.D.setVisibility(0);
            }
            l2();
            this.P.clear();
            this.H.reset();
            this.A.setSelectedPosition(this.S.size() - 1);
            this.y.setVisibility(8);
            y2(8);
            this.A.setVisibility(0);
            this.V.F();
            this.w.setVisibility(0);
            this.x.setVisibility(0);
            A2();
            this.I.reset();
            this.J.reset();
            this.K.reset();
            this.L.reset();
            this.N.reset();
            v2();
            hideLoadingView(this.e);
        }
    }

    public final void u2() {
        zw5 zw5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (zw5Var = this.H) == null) {
            return;
        }
        zw5Var.setShowDeleteLastTip(false);
        this.b.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a02));
        this.r.setText(getResources().getString(R.string.obfuscated_res_0x7f0f145d));
    }

    public final void v2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            x2();
            w2();
        }
    }

    public final void w2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.j.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809f7));
            this.k.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0809fa));
        }
    }

    public final void x2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            C2(false);
            B2();
        }
    }

    public final void y2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            zw5 zw5Var = this.H;
            if (zw5Var != null && zw5Var.getProgress() < 3.0f) {
                vr4 d2 = vr4.d(this.a);
                d2.n(R.string.J_X01);
                d2.e(R.string.A_X09);
                d2.f(R.color.CAM_X0302);
            } else {
                vr4 d3 = vr4.d(this.a);
                d3.n(R.string.J_X01);
                d3.e(R.string.A_X01);
                d3.f(R.color.CAM_X0302);
            }
            if (this.z.getVisibility() != i2) {
                this.z.setVisibility(i2);
            }
        }
    }

    public final void z2(@RawRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            if (this.d == null) {
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090489);
                this.d = relativeLayout;
                vr4 d2 = vr4.d(relativeLayout);
                d2.e(R.string.A_X09);
                d2.f(R.color.CAM_X0611);
            }
            if (this.c == null) {
                this.c = (TBLottieAnimationView) findViewById(R.id.obfuscated_res_0x7f090488);
            }
            this.d.setVisibility(0);
            this.c.setAnimation(i2);
            this.c.loop(true);
            this.c.playAnimation();
            qg.a().postDelayed(new i(this), 3000L);
        }
    }
}
