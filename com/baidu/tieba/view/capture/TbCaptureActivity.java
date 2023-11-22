package com.baidu.tieba.view.capture;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.DeviceInfoHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.CloudMusicActivityConfig;
import com.baidu.tbadk.core.atomData.TbCaptureActivityConfig;
import com.baidu.tbadk.core.atomData.TbEditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tbadk.data.TbMusicData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.ar6;
import com.baidu.tieba.c07;
import com.baidu.tieba.d07;
import com.baidu.tieba.df6;
import com.baidu.tieba.e07;
import com.baidu.tieba.ef6;
import com.baidu.tieba.external.filter.ResponseGetQmFiltersMessage;
import com.baidu.tieba.external.music.data.MusicData;
import com.baidu.tieba.external.sticker.ResponseGetQmStickersMessage;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
import com.baidu.tieba.ff6;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.g07;
import com.baidu.tieba.gf6;
import com.baidu.tieba.h05;
import com.baidu.tieba.hf6;
import com.baidu.tieba.i07;
import com.baidu.tieba.if6;
import com.baidu.tieba.j05;
import com.baidu.tieba.j07;
import com.baidu.tieba.j7b;
import com.baidu.tieba.jf6;
import com.baidu.tieba.kf6;
import com.baidu.tieba.l8b;
import com.baidu.tieba.ll9;
import com.baidu.tieba.n5b;
import com.baidu.tieba.pl9;
import com.baidu.tieba.r0b;
import com.baidu.tieba.raa;
import com.baidu.tieba.v0b;
import com.baidu.tieba.view.capture.camera.AspectGLSurfaceView;
import com.baidu.tieba.view.capture.camera.PicGLSurfaceView;
import com.baidu.tieba.view.widget.HorizontalCenterSelectView;
import com.baidu.tieba.view.widget.RecordPreviewContainer;
import com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout;
import com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout;
import com.baidu.tieba.wa0;
import com.baidu.tieba.x0b;
import com.baidu.tieba.xq6;
import com.baidu.tieba.yq6;
import com.baidu.tieba.zq6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class TbCaptureActivity extends BaseActivity<TbCaptureActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HorizontalCenterSelectView A;
    public TextView B;
    public RelativeLayout C;
    public LinearLayout D;
    public RecordPreviewContainer E;
    public ll9 F;
    public zq6 G;
    public df6 H;
    public jf6 I;
    public gf6 J;
    public d07 K;
    public i07 L;
    public xq6 M;
    public e07 N;
    public WriteImagesInfo O;
    public ImageFileInfo P;
    public RelativeLayout Q;
    public RelativeLayout R;
    public ImageView S;

    /* renamed from: T  reason: collision with root package name */
    public TextView f1172T;
    public TbMusicData U;
    public ArrayList<String> V;
    public boolean W;
    public Map<String, Integer> X;
    public List<String> Y;
    public int Z;
    public ImageView a;
    public int a0;
    public ImageView b;
    public VideoControllerLayout b0;
    public TBLottieAnimationView c;
    public int c0;
    public RelativeLayout d;
    public zq6.b d0;
    public View e;
    public zq6.a e0;
    public ImageView f;
    public df6.c f0;
    public ImageView g;
    public df6.b g0;
    public ImageView h;
    public df6.a h0;
    public ImageView i;
    public if6 i0;
    public ImageView j;
    public ff6 j0;
    public ImageView k;
    public ImageView l;
    public ImageView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public HttpMessageListener r0;
    public TextView s;
    public HttpMessageListener s0;
    public TextView t;
    public c07.b t0;
    public RelativeLayout u;
    public j07.b u0;
    public RelativeLayout v;
    public CustomMessageListener v0;
    public RelativeLayout w;
    public CustomMessageListener w0;
    public RelativeLayout x;
    public RelativeLayout y;
    public RelativeLayout z;

    /* loaded from: classes8.dex */
    public class n implements VideoControllerLayout.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCaptureActivity a;

        /* loaded from: classes8.dex */
        public class a implements zq6.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n a;

            public a(n nVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = nVar;
            }

            @Override // com.baidu.tieba.zq6.c
            public void a(boolean z, @Nullable String str) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) && z) {
                    if (this.a.a.O == null) {
                        this.a.a.O = new WriteImagesInfo();
                    } else if (this.a.a.P != null && !ListUtils.isEmpty(this.a.a.O.getChosedFiles()) && this.a.a.O.getChosedFiles().contains(this.a.a.P)) {
                        this.a.a.O.getChosedFiles().remove(this.a.a.P);
                    }
                    this.a.a.P = new ImageFileInfo();
                    this.a.a.P.setFilePath(str);
                    this.a.a.P.setContentUriStr(null);
                    this.a.a.P.setTempFile(true);
                    this.a.a.P.setAlbumnId(null);
                    this.a.a.P.setIsFromCamera(true);
                    this.a.a.O.addChooseFile(this.a.a.P);
                    if (this.a.a.getIntent().getIntExtra("from_type", 0) == 2) {
                        Intent intent = new Intent();
                        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, this.a.a.O.toJsonString());
                        this.a.a.setResult(-1, intent);
                        this.a.a.finish();
                        ActivityPendingTransitionFactory.closeAnimation(this.a.a.getPageContext(), 0);
                        return;
                    }
                    WriteMulitImageActivityConfig writeMulitImageActivityConfig = new WriteMulitImageActivityConfig(this.a.a.getPageContext().getPageActivity(), CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, this.a.a.O, this.a.a.O.size() - 1, (ForumWriteData) this.a.a.getIntent().getSerializableExtra(TbCaptureActivityConfig.FORUM_WRITE_DATA), this.a.a.getIntent().getIntExtra(TbCaptureActivityConfig.ENTRANCE_FLAG, 0));
                    writeMulitImageActivityConfig.getIntent().putExtras(this.a.a.getIntent());
                    this.a.a.sendMessage(new CustomMessage(2002001, writeMulitImageActivityConfig));
                }
            }
        }

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

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (ListUtils.isEmpty(this.a.V) && !this.a.G.c()) {
                    if (z) {
                        this.a.A.setVisibility(8);
                        this.a.w.setVisibility(8);
                        this.a.x.setVisibility(8);
                    } else {
                        if (this.a.c0 != 1) {
                            this.a.A.setVisibility(0);
                        }
                        this.a.w.setVisibility(0);
                        this.a.x.setVisibility(0);
                    }
                    this.a.y.setVisibility(8);
                    this.a.Z1(8);
                    return;
                }
                if (this.a.G.c()) {
                    this.a.w.setVisibility(8);
                } else {
                    this.a.w.setVisibility(0);
                }
                this.a.y.setVisibility(0);
                this.a.Z1(0);
                this.a.A.setVisibility(8);
                this.a.x.setVisibility(8);
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.A.setVisibility(8);
                this.a.w.setVisibility(8);
                this.a.x.setVisibility(8);
                this.a.y.setVisibility(8);
                this.a.Z1(8);
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void c() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.G != null) {
                this.a.G.stopRecord();
                this.a.C.setVisibility(0);
                this.a.D.setVisibility(0);
                this.a.y.setVisibility(0);
                this.a.Z1(0);
                this.a.w.setVisibility(0);
                if (this.a.N != null) {
                    this.a.N.pause();
                }
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.A.setVisibility(8);
                this.a.w.setVisibility(8);
                this.a.x.setVisibility(8);
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void e() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.a.G == null) {
                return;
            }
            this.a.G.g(new a(this));
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void f() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.a.H == null) {
                return;
            }
            if (this.a.H.getProgress() < this.a.H.getMaxDuration()) {
                this.a.G.startRecord();
                this.a.C.setVisibility(8);
                this.a.D.setVisibility(8);
                this.a.K1();
                this.a.V1();
                this.a.y.setVisibility(8);
                if (this.a.H.getProgress() < 3.0f) {
                    this.a.Z1(8);
                } else {
                    this.a.Z1(0);
                }
                this.a.w.setVisibility(8);
                this.a.U1();
                if (this.a.N != null) {
                    this.a.N.a(this.a.H.getProgress());
                }
                this.a.W = false;
            } else if (this.a.H.getProgress() >= this.a.H.getMaxDuration() && this.a.b0 != null) {
                this.a.b0.E();
                if (this.a.M != null) {
                    this.a.M.b(this.a.V);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements c07.b {
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

        @Override // com.baidu.tieba.c07.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.b0 != null) {
                    QmFilterItem qmFilterItem = new QmFilterItem();
                    qmFilterItem.id = "-1";
                    qmFilterItem.bgurl = R.drawable.obfuscated_res_0x7f080c64 + "";
                    qmFilterItem.name = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0752);
                    qmFilterItem.isSelect = true;
                    qmFilterItem.localPath = "origin";
                    this.a.b0.z(qmFilterItem);
                    if (this.a.K != null) {
                        this.a.K.a(null);
                    }
                    this.a.b0.setDownLoadFilter(null);
                }
                if (StringUtils.isNull(str)) {
                    str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f14aa);
                }
                this.a.showToast(str);
                this.a.F.b(5, str);
            }
        }

        @Override // com.baidu.tieba.c07.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.b0 != null) {
                this.a.b0.setDownLoadFilter(null);
            }
        }

        @Override // com.baidu.tieba.c07.b
        public void c(QmFilterItem qmFilterItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qmFilterItem) == null) {
                if (this.a.K != null) {
                    this.a.K.a(qmFilterItem);
                }
                if (this.a.b0 != null) {
                    this.a.b0.setDownLoadFilter(null);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements j07.b {
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

        @Override // com.baidu.tieba.j07.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.b0 != null) {
                    QmStickerItem qmStickerItem = new QmStickerItem();
                    qmStickerItem.id = -1;
                    qmStickerItem.isLocalSource = true;
                    qmStickerItem.localPath = "nosticker";
                    this.a.b0.A(qmStickerItem);
                    if (this.a.L != null) {
                        this.a.L.b(null);
                    }
                    this.a.b0.setDownLoadSticker(qmStickerItem, false);
                }
                if (StringUtils.isNull(str)) {
                    str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f14aa);
                }
                this.a.showToast(str);
                this.a.F.b(5, str);
            }
        }

        @Override // com.baidu.tieba.j07.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.b0 != null) {
                this.a.b0.setDownLoadSticker(null, false);
            }
        }

        @Override // com.baidu.tieba.j07.b
        public void c(QmStickerItem qmStickerItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qmStickerItem) == null) {
                if (this.a.L != null) {
                    this.a.L.b(qmStickerItem);
                }
                if (this.a.b0 != null) {
                    this.a.b0.setDownLoadSticker(qmStickerItem, true);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCaptureActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(TbCaptureActivity tbCaptureActivity, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.E != null) {
                this.a.E.requestLayout();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements HorizontalCenterSelectView.d {
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

        @Override // com.baidu.tieba.view.widget.HorizontalCenterSelectView.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && this.a.H != null) {
                this.a.H.setMaxDuration(((Integer) this.a.X.get((String) this.a.Y.get(i))).intValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements j05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h05 a;
        public final /* synthetic */ TbCaptureActivity b;

        public f(TbCaptureActivity tbCaptureActivity, h05 h05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity, h05Var};
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
            this.a = h05Var;
        }

        @Override // com.baidu.tieba.j05.f
        public void F0(j05 j05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, j05Var, i, view2) == null) {
                if (i == 0) {
                    this.b.T1();
                    this.a.dismiss();
                } else if (i == 1) {
                    this.b.finish();
                } else {
                    this.a.dismiss();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements xq6.a {
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

        @Override // com.baidu.tieba.xq6.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TbCaptureActivity tbCaptureActivity = this.a;
                tbCaptureActivity.hideLoadingView(tbCaptureActivity.e);
            }
        }

        @Override // com.baidu.tieba.xq6.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                TbCaptureActivity tbCaptureActivity = this.a;
                tbCaptureActivity.showLoadingView(tbCaptureActivity.e);
            }
        }

        @Override // com.baidu.tieba.xq6.a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                VideoFileInfo c = v0b.c(str);
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
                ForumWriteData forumWriteData = (ForumWriteData) this.a.getIntent().getSerializableExtra(TbCaptureActivityConfig.FORUM_WRITE_DATA);
                if (forumWriteData != null) {
                    if (StringUtils.isNotNull(forumWriteData.forumId)) {
                        tbEditVideoActivityConfig.getIntent().putExtra("forum_id", forumWriteData.forumId);
                    }
                    if (StringUtils.isNotNull(forumWriteData.forumName)) {
                        tbEditVideoActivityConfig.getIntent().putExtra("forum_name", forumWriteData.forumName);
                    }
                }
                tbEditVideoActivityConfig.getIntent().putExtras(this.a.getIntent());
                tbEditVideoActivityConfig.setMultiMediaData(tbMultiMediaData);
                tbEditVideoActivityConfig.setVideoFrom(2);
                if (this.a.U != null && this.a.N != null) {
                    this.a.U.localPath = this.a.N.c();
                    tbEditVideoActivityConfig.setMusicData(this.a.U);
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

    /* loaded from: classes8.dex */
    public class h implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.pauseAnimation();
                this.a.d.setVisibility(8);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements RecordPreviewContainer.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCaptureActivity a;

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

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

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void a(MotionEvent motionEvent, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, motionEvent, i) == null) && this.a.G != null) {
                n5b.E(this.a.getPageContext()).l(i);
                this.a.U1();
            }
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void b(MotionEvent motionEvent, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && this.a.G != null) {
                n5b.E(this.a.getPageContext()).c(i, i2, i3, i4);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.t.setVisibility(8);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements zq6.b {
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

        @Override // com.baidu.tieba.zq6.b
        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (this.a.H != null) {
                    this.a.H.pause();
                    if (!StringUtils.isNull(str)) {
                        this.a.V.add(str);
                        if (this.a.W && ListUtils.getCount(this.a.V) == this.a.H.getSlideNum() && this.a.M != null) {
                            this.a.M.b(this.a.V);
                        }
                    }
                    this.a.b2();
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.zq6.b
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.H != null) {
                    if (ListUtils.isEmpty(this.a.V) && this.a.b0 != null) {
                        this.a.b0.D();
                    }
                    this.a.H.start();
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class l implements RecordPreviewContainer.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Runnable a;
        public final /* synthetic */ TbCaptureActivity b;

        public l(TbCaptureActivity tbCaptureActivity, Runnable runnable) {
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

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.g
        public void a(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) && this.b.G != null && !this.b.G.c() && this.b.K != null) {
                this.b.K.g();
                String currentFilterName = this.b.b0.getCurrentFilterName();
                if (!StringUtils.isNull(currentFilterName)) {
                    this.b.t.removeCallbacks(this.a);
                    this.b.t.setText(currentFilterName);
                    this.b.t.setVisibility(0);
                    this.b.t.postDelayed(this.a, 800L);
                }
                this.b.U1();
            }
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.g
        public void b(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent) == null) && this.b.G != null && !this.b.G.c() && this.b.K != null) {
                this.b.K.e();
                String currentFilterName = this.b.b0.getCurrentFilterName();
                if (!StringUtils.isNull(currentFilterName)) {
                    this.b.t.removeCallbacks(this.a);
                    this.b.t.setText(currentFilterName);
                    this.b.t.setVisibility(0);
                    this.b.t.postDelayed(this.a, 800L);
                }
                this.b.U1();
            }
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.g
        public void c(MotionEvent motionEvent, float f, float f2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, Float.valueOf(f), Float.valueOf(f2)}) == null) && this.b.G != null && !this.b.G.c()) {
                this.b.G.d();
                this.b.U1();
            }
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.g
        public void d(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
                this.b.K1();
                this.b.V1();
                if (this.b.b0 != null && this.b.b0.p()) {
                    this.b.b0.m(null, false);
                }
                if (this.b.G != null && !this.b.G.c() && this.b.E != null) {
                    this.b.E.k(motionEvent);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m implements RecordEffectLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCaptureActivity a;

        public m(TbCaptureActivity tbCaptureActivity) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, qmStickerItem) == null) && qmStickerItem != null && this.a.L != null) {
                String a = this.a.L.a(qmStickerItem.fileUrl);
                if (StringUtils.isNull(a) && -1 != qmStickerItem.id) {
                    if (this.a.b0 != null) {
                        this.a.b0.setDownLoadSticker(qmStickerItem, false);
                    }
                    this.a.L.d(qmStickerItem);
                    return;
                }
                qmStickerItem.localPath = a;
                this.a.L.b(qmStickerItem);
                if (this.a.b0 != null) {
                    this.a.b0.setDownLoadSticker(qmStickerItem, true);
                }
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void b(l8b l8bVar, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l8bVar, obj) != null) || l8bVar == null) {
                return;
            }
            int c = l8bVar.c();
            if (c != 2) {
                if (c == 3 && (l8bVar.d() instanceof MusicData)) {
                    MusicData musicData = (MusicData) l8bVar.d();
                    TbMusicData tbMusicData = new TbMusicData();
                    tbMusicData.id = musicData.id;
                    tbMusicData.title = musicData.name;
                    tbMusicData.url = musicData.resource;
                    tbMusicData.icon = musicData.img;
                    tbMusicData.type = JavaTypesHelper.toInt(musicData.type, 1);
                    if (!MusicData.MUSIC_NORMAL_ID.equals(musicData.id) && !MusicData.MUSIC_CLOUD_ID.equals(musicData.id)) {
                        this.a.U = tbMusicData;
                        this.a.N.f(this.a.U);
                        this.a.b0.setMusicName(this.a.U.title, "");
                    } else {
                        this.a.N.f(this.a.U);
                        this.a.U = tbMusicData;
                        if (!MusicData.MUSIC_CLOUD_ID.equals(musicData.id)) {
                            this.a.b0.setMusicName(this.a.U.title, "");
                        }
                    }
                    this.a.N.d((MusicData) l8bVar.d(), obj);
                }
            } else if (this.a.K != null && (l8bVar.d() instanceof QmFilterItem)) {
                QmFilterItem qmFilterItem = (QmFilterItem) l8bVar.d();
                String f = this.a.K.f(qmFilterItem.fileUrl);
                if (StringUtils.isNull(f) && !"-1".equals(qmFilterItem.id)) {
                    if (this.a.b0 != null) {
                        this.a.b0.setDownLoadFilter(qmFilterItem);
                    }
                    this.a.K.c(qmFilterItem);
                    return;
                }
                qmFilterItem.localPath = f;
                this.a.K.a(qmFilterItem);
                if (this.a.b0 != null) {
                    this.a.b0.setDownLoadFilter(null);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o implements zq6.a {
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

        @Override // com.baidu.tieba.zq6.a
        public void onProgress(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && this.a.H != null) {
                this.a.H.setProgress(j);
                if (this.a.H.getProgress() < 3.0f) {
                    return;
                }
                this.a.Z1(0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p implements df6.c {
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

        @Override // com.baidu.tieba.df6.c
        public boolean onFinished() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return invokeV.booleanValue;
            }
            this.a.W = true;
            if (this.a.G != null && !this.a.G.c() && this.a.W && ListUtils.getCount(this.a.V) == this.a.H.getSlideNum() && this.a.M != null) {
                this.a.M.b(this.a.V);
            }
            if (this.a.b0 != null) {
                this.a.b0.E();
            }
            return true;
        }
    }

    /* loaded from: classes8.dex */
    public class q implements df6.b {
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

        @Override // com.baidu.tieba.df6.b
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

    /* loaded from: classes8.dex */
    public class r implements df6.a {
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

        @Override // com.baidu.tieba.df6.a
        public boolean a(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
                if (ListUtils.isEmpty(this.a.V)) {
                    return false;
                }
                this.a.V.remove(this.a.V.size() - 1);
                if (this.a.V.size() <= 0) {
                    if (this.a.H != null) {
                        this.a.H.reset();
                    }
                    this.a.y.setVisibility(8);
                    this.a.Z1(8);
                    this.a.A.setVisibility(0);
                    this.a.b0.F();
                    this.a.w.setVisibility(0);
                    this.a.x.setVisibility(0);
                    this.a.J.reset();
                }
                this.a.b2();
                return true;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class s implements if6 {
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

        @Override // com.baidu.tieba.if6
        public boolean a(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
                boolean z = false;
                if (this.a.G == null || this.a.G.e() == null) {
                    return false;
                }
                this.a.G.e().a(f);
                if (this.a.I != null) {
                    TbCaptureActivity tbCaptureActivity = this.a;
                    if (tbCaptureActivity.I.a() == 0) {
                        z = true;
                    }
                    tbCaptureActivity.d2(z);
                }
                return true;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class t implements ff6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCaptureActivity a;

        public t(TbCaptureActivity tbCaptureActivity) {
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

        @Override // com.baidu.tieba.ff6
        public boolean a(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
                if (this.a.G != null && this.a.G.f() != null) {
                    this.a.G.f().a(f);
                    this.a.c2();
                    return true;
                }
                return false;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || !(httpResponsedMessage instanceof ResponseGetQmStickersMessage)) {
                return;
            }
            List<QmStickerItem> list = null;
            ResponseGetQmStickersMessage responseGetQmStickersMessage = (ResponseGetQmStickersMessage) httpResponsedMessage;
            if (httpResponsedMessage.getError() == 0) {
                list = responseGetQmStickersMessage.getStickerItems();
            }
            if (this.a.b0 != null) {
                if (list == null) {
                    list = new ArrayList<>();
                }
                for (QmStickerItem qmStickerItem : list) {
                    if (qmStickerItem != null && this.a.L != null && !StringUtils.isNull(qmStickerItem.fileUrl) && !StringUtils.isNull(this.a.L.a(qmStickerItem.fileUrl))) {
                        qmStickerItem.isLocalSource = true;
                    }
                }
                QmStickerItem qmStickerItem2 = new QmStickerItem();
                qmStickerItem2.id = -1;
                qmStickerItem2.isSelect = true;
                qmStickerItem2.isLocalSource = true;
                qmStickerItem2.localPath = "nosticker";
                list.add(0, qmStickerItem2);
                this.a.b0.setStickerItems(list);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class v extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCaptureActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(TbCaptureActivity tbCaptureActivity, int i, boolean z) {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || !(httpResponsedMessage instanceof ResponseGetQmFiltersMessage)) {
                return;
            }
            List<QmFilterItem> list = null;
            ResponseGetQmFiltersMessage responseGetQmFiltersMessage = (ResponseGetQmFiltersMessage) httpResponsedMessage;
            if (httpResponsedMessage.getError() == 0) {
                list = responseGetQmFiltersMessage.getFilterItems();
            }
            if (this.a.b0 != null) {
                if (list == null) {
                    list = new ArrayList<>();
                }
                QmFilterItem qmFilterItem = new QmFilterItem();
                qmFilterItem.id = "-1";
                qmFilterItem.bgurl = R.drawable.obfuscated_res_0x7f080c64 + "";
                qmFilterItem.name = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0752);
                qmFilterItem.isSelect = true;
                qmFilterItem.localPath = "origin";
                list.add(0, qmFilterItem);
                this.a.b0.setFilterData(list);
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
        this.V = new ArrayList<>();
        this.W = false;
        this.Z = R.drawable.obfuscated_res_0x7f080c47;
        this.a0 = R.drawable.obfuscated_res_0x7f080c48;
        this.c0 = -1;
        this.d0 = new k(this);
        this.e0 = new o(this);
        this.f0 = new p(this);
        this.g0 = new q(this);
        this.h0 = new r(this);
        this.i0 = new s(this);
        this.j0 = new t(this);
        this.r0 = new u(this, CmdConfigHttp.CMD_GET_QM_STICKERS, true);
        this.s0 = new v(this, CmdConfigHttp.CMD_GET_QM_FILTERS, true);
        this.t0 = new a(this);
        this.u0 = new b(this);
        this.v0 = new c(this, 2921583);
        this.w0 = new d(this, 2921414);
    }

    public final void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            WriteData writeData = new WriteData();
            FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
            PostPrefixData postPrefixData = new PostPrefixData();
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), writeImagesInfo.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", writeData.getForumId());
            albumFloatActivityConfig.getIntent().putExtra("forum_name", writeData.getForumName());
            albumFloatActivityConfig.getIntent().putExtra("from", "write");
            albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
            albumFloatActivityConfig.setAlbumThread(0);
            albumFloatActivityConfig.setCanSelectVideo(true);
            albumFloatActivityConfig.setCanSelectOnlyVideo(true);
            albumFloatActivityConfig.setCanEditImage(false);
            albumFloatActivityConfig.setFromWrite(4);
            albumFloatActivityConfig.setCallFrom("1");
            albumFloatActivityConfig.setStatisticFrom(writeData.getStatisticFrom());
            albumFloatActivityConfig.setFrsTabInfo(frsTabInfoData);
            AntiData antiData = new AntiData();
            antiData.voice_message = "";
            antiData.setIfVoice(true);
            albumFloatActivityConfig.setExtraData(antiData, postPrefixData, writeData.getFirstDir(), writeData.getSecondDir());
            albumFloatActivityConfig.setAlbumShowCapture(false);
            sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }
    }

    public final void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.Z = R.drawable.obfuscated_res_0x7f080c47;
            this.a0 = R.drawable.obfuscated_res_0x7f080c48;
            gf6 gf6Var = this.J;
            if (gf6Var == null) {
                return;
            }
            if (gf6Var.d() == 1.0f) {
                this.Z = R.drawable.obfuscated_res_0x7f080c30;
                this.a0 = R.drawable.obfuscated_res_0x7f080c31;
            } else if (this.J.d() == 1.3333334f) {
                this.Z = R.drawable.obfuscated_res_0x7f080c34;
                this.a0 = R.drawable.obfuscated_res_0x7f080c35;
            } else if (this.J.d() == 1.7777778f) {
                this.Z = R.drawable.obfuscated_res_0x7f080c36;
                this.a0 = R.drawable.obfuscated_res_0x7f080c37;
            } else if (this.J.d() == 0.5625f) {
                this.Z = R.drawable.obfuscated_res_0x7f080c32;
                this.a0 = R.drawable.obfuscated_res_0x7f080c33;
            }
            if (this.J.a() == 0) {
                this.h.setImageDrawable(getResources().getDrawable(this.a0));
            } else {
                this.h.setImageDrawable(getResources().getDrawable(this.Z));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, view2) == null) {
            super.showLoadingView(view2);
            if (getLoadingView() != null && getLoadingView().getLoadingTextView() != null) {
                getLoadingView().getLoadingTextView().setVisibility(8);
            }
        }
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            df6 df6Var = this.H;
            if (df6Var != null && df6Var.getProgress() > 0.0f) {
                h05 h05Var = new h05(getPageContext(), new j05(getPageContext().getPageActivity()));
                h05Var.i(null, new String[]{getString(R.string.obfuscated_res_0x7f0f03e3), getResources().getString(R.string.obfuscated_res_0x7f0f11fe)}, new f(this, h05Var));
                h05Var.l();
                return;
            }
            finish();
        }
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = this.c0;
            if (i2 == 1) {
                this.A.setVisibility(8);
                this.v.setVisibility(8);
                this.g.setVisibility(8);
                this.h.setVisibility(8);
                this.Q.setVisibility(8);
                this.b0.setCurrentType(1);
                this.R.setVisibility(0);
                this.w.setVisibility(8);
            } else if (i2 == 0) {
                this.b0.setCurrentType(2);
                this.R.setVisibility(8);
                this.w.setVisibility(0);
            } else {
                this.b0.setCurrentType(0);
                this.R.setVisibility(8);
                this.w.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onDestroy();
            zq6 zq6Var = this.G;
            if (zq6Var != null) {
                zq6Var.onDestroy();
            }
            e07 e07Var = this.N;
            if (e07Var != null) {
                e07Var.b();
                this.N.e();
            }
            xq6 xq6Var = this.M;
            if (xq6Var != null) {
                xq6Var.a();
            }
            i07 i07Var = this.L;
            if (i07Var != null) {
                i07Var.onDestroy();
            }
            if (n5b.D() == getPageContext()) {
                n5b.E(getPageContext()).release();
            }
        }
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            jf6 jf6Var = this.I;
            if (jf6Var != null) {
                jf6Var.b(8);
            }
            gf6 gf6Var = this.J;
            if (gf6Var != null) {
                gf6Var.b(8);
            }
        }
    }

    public final void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            X1();
            W1();
        }
    }

    public final void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.j.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c63));
            this.k.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c66));
        }
    }

    public final void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            d2(false);
            c2();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.c0 == 1) {
                finish();
            } else {
                I1();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onPause();
            zq6 zq6Var = this.G;
            if (zq6Var != null) {
                zq6Var.onPause();
            }
            e07 e07Var = this.N;
            if (e07Var != null) {
                e07Var.onPause();
            }
        }
    }

    public final void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f.setOnClickListener(this);
            this.g.setOnClickListener(this);
            this.h.setOnClickListener(this);
            this.i.setOnClickListener(this);
            this.v.setOnClickListener(this);
            this.u.setOnClickListener(this);
            this.w.setOnClickListener(this);
            this.x.setOnClickListener(this);
            this.z.setOnClickListener(this);
            this.y.setOnClickListener(this);
            this.R.setOnClickListener(this);
            registerListener(this.r0);
            registerListener(this.s0);
            registerListener(this.v0);
            registerListener(this.w0);
            this.E.setOnPreviewStateChangedListener(new i(this));
            j jVar = new j(this);
            this.E.h(this.e);
            this.E.setOnViewClickListener(new l(this, jVar));
            this.b0.setEffectChoosedListener(new m(this));
            this.b0.setRecordControlListener(new n(this));
        }
    }

    public final void P1() {
        pl9 pl9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_QM_STICKERS, TbConfig.SERVER_ADDRESS + TbConfig.GET_QM_STICKERS);
            tbHttpMessageTask.setResponsedClass(ResponseGetQmStickersMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_QM_FILTERS, TbConfig.SERVER_ADDRESS + TbConfig.GET_QM_FILTERS);
            tbHttpMessageTask2.setResponsedClass(ResponseGetQmFiltersMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask2);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, pl9.class);
            if (runTask != null) {
                pl9Var = (pl9) runTask.getData();
            } else {
                pl9Var = null;
            }
            if (pl9Var != null) {
                this.F = pl9Var.get();
            }
            ll9 ll9Var = this.F;
            if (ll9Var != null) {
                ll9Var.g();
            }
        }
    }

    public final void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            zq6 zq6Var = this.G;
            if (zq6Var != null && zq6Var.c()) {
                this.G.stopRecord();
                this.C.setVisibility(0);
                this.D.setVisibility(0);
            }
            K1();
            this.V.clear();
            this.H.reset();
            this.A.setSelectedPosition(this.Y.size() - 1);
            this.y.setVisibility(8);
            Z1(8);
            if (this.c0 != 1) {
                this.A.setVisibility(0);
            }
            this.w.setVisibility(0);
            this.x.setVisibility(0);
            b2();
            this.I.reset();
            this.J.reset();
            this.K.reset();
            this.L.reset();
            this.N.reset();
            VideoControllerLayout videoControllerLayout = this.b0;
            if (videoControllerLayout != null) {
                videoControllerLayout.F();
                this.b0.x();
            }
            V1();
            hideLoadingView(this.e);
        }
    }

    public final void O1() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            RecordPreviewContainer recordPreviewContainer = (RecordPreviewContainer) findViewById(R.id.obfuscated_res_0x7f090578);
            this.E = recordPreviewContainer;
            if (this.c0 == 1) {
                recordPreviewContainer.setSurfaceView(new PicGLSurfaceView(this));
                z = false;
            } else {
                recordPreviewContainer.setSurfaceView(new AspectGLSurfaceView(this));
                z = true;
            }
            this.G = new ar6(getPageContext(), this.E.getSurfaceView(), z, this.d0, this.e0);
            j07 j07Var = new j07(this.G);
            this.L = j07Var;
            j07Var.c(this.u0);
            this.L.e();
            this.b0 = (VideoControllerLayout) findViewById(R.id.obfuscated_res_0x7f091ef9);
            c07 c07Var = new c07(this.G, null, this.b0);
            this.K = c07Var;
            c07Var.d(this.t0);
            this.K.h();
            j7b recrodButton = this.b0.getRecrodButton();
            TextView recordTimeView = this.b0.getRecordTimeView();
            this.B = recordTimeView;
            ef6 ef6Var = new ef6(recrodButton, recordTimeView, this.f0, this.g0, this.h0);
            this.H = ef6Var;
            ef6Var.setMinDuration(3);
            this.H.setMaxDuration(15);
            this.b0.setDurationManager(this.H);
            this.I = new kf6(getPageContext(), this.i0, null);
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(getPageContext().getPageActivity());
            hf6 hf6Var = new hf6(getPageContext(), BdUtilHelper.getEquipmentHeight(getPageContext().getPageActivity()), equipmentWidth, this.j0);
            this.J = hf6Var;
            hf6Var.c(0);
            this.M = new yq6(getPageContext(), new g(this));
            S1();
            R1();
            this.N = new g07(getPageContext(), this.b0);
        }
    }

    public final void R1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_QM_FILTERS);
            if (raa.b()) {
                httpMessage.addParam(HttpRequest.UH, DeviceInfoHelper.getManufacturer() + "," + Build.HARDWARE + "," + Build.BOARD + "," + (x0b.b(this) ? 1 : 0));
                httpMessage.addParam("ut", DeviceInfoHelper.getModel() + "_" + DeviceInfoHelper.getOsVersion() + "_" + x0b.a() + "_" + Build.BRAND.replace("_", ""));
            } else {
                httpMessage.addParam(HttpRequest.NEED_DECRYPT, raa.c());
                String g2 = raa.g(HttpRequest.UH);
                if (!TextUtils.isEmpty(g2)) {
                    httpMessage.addParam(g2, raa.a(DeviceInfoHelper.getManufacturer() + "," + Build.HARDWARE + "," + Build.BOARD + "," + (x0b.b(this) ? 1 : 0)));
                }
                String g3 = raa.g("ut");
                if (!TextUtils.isEmpty(g3)) {
                    httpMessage.addParam(g3, raa.a(DeviceInfoHelper.getModel() + "_" + DeviceInfoHelper.getOsVersion() + "_" + x0b.a() + "_" + Build.BRAND.replace("_", "")));
                }
            }
            httpMessage.addParam("sdk_version", wa0.i() + "");
            sendMessage(httpMessage);
        }
    }

    public final void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_QM_STICKERS);
            if (raa.b()) {
                httpMessage.addParam(HttpRequest.UH, DeviceInfoHelper.getManufacturer() + "," + Build.HARDWARE + "," + Build.BOARD + "," + (x0b.b(this) ? 1 : 0));
                httpMessage.addParam("ut", DeviceInfoHelper.getModel() + "_" + DeviceInfoHelper.getOsVersion() + "_" + x0b.a() + "_" + Build.BRAND.replace("_", ""));
            } else {
                httpMessage.addParam(HttpRequest.NEED_DECRYPT, raa.c());
                String g2 = raa.g(HttpRequest.UH);
                if (!TextUtils.isEmpty(g2)) {
                    httpMessage.addParam(g2, raa.a(DeviceInfoHelper.getManufacturer() + "," + Build.HARDWARE + "," + Build.BOARD + "," + (x0b.b(this) ? 1 : 0)));
                }
                String g3 = raa.g("ut");
                if (!TextUtils.isEmpty(g3)) {
                    httpMessage.addParam(g3, raa.a(DeviceInfoHelper.getModel() + "_" + DeviceInfoHelper.getOsVersion() + "_" + x0b.a() + "_" + Build.BRAND.replace("_", "")));
                }
            }
            httpMessage.addParam("sdk_version", wa0.i() + "");
            httpMessage.addParam("brand", "baiduar");
            sendMessage(httpMessage);
        }
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.e = findViewById(R.id.obfuscated_res_0x7f09200a);
            this.C = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09058b);
            this.D = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090579);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f09058a);
            this.g = (ImageView) findViewById(R.id.obfuscated_res_0x7f09058d);
            this.h = (ImageView) findViewById(R.id.obfuscated_res_0x7f09058c);
            this.i = (ImageView) findViewById(R.id.obfuscated_res_0x7f09058e);
            this.j = (ImageView) findViewById(R.id.obfuscated_res_0x7f09057e);
            this.u = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09057f);
            this.k = (ImageView) findViewById(R.id.obfuscated_res_0x7f090580);
            this.v = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090581);
            this.R = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090583);
            this.S = (ImageView) findViewById(R.id.obfuscated_res_0x7f090582);
            this.f1172T = (TextView) findViewById(R.id.obfuscated_res_0x7f090588);
            this.w = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09056f);
            this.l = (ImageView) findViewById(R.id.obfuscated_res_0x7f09056e);
            this.p = (TextView) findViewById(R.id.obfuscated_res_0x7f090573);
            this.m = (ImageView) findViewById(R.id.obfuscated_res_0x7f090569);
            this.x = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09056a);
            this.n = (TextView) findViewById(R.id.obfuscated_res_0x7f090586);
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f090587);
            this.q = (TextView) findViewById(R.id.obfuscated_res_0x7f090570);
            this.s = (TextView) findViewById(R.id.obfuscated_res_0x7f090572);
            this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f090571);
            this.t = (TextView) findViewById(R.id.obfuscated_res_0x7f090576);
            this.z = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09056d);
            this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f0919d5);
            this.A = (HorizontalCenterSelectView) findViewById(R.id.obfuscated_res_0x7f09175b);
            this.y = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09056c);
            this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f0904df);
            this.Q = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09056b);
        }
    }

    public final void U1() {
        df6 df6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (df6Var = this.H) != null) {
            df6Var.setShowDeleteLastTip(false);
            this.b.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c6e));
            this.r.setText(getResources().getString(R.string.obfuscated_res_0x7f0f178f));
        }
    }

    public final void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (!ListUtils.isEmpty(this.V)) {
                this.h.setAlpha(SkinManager.RESOURCE_ALPHA_DISABLE);
                this.v.setAlpha(SkinManager.RESOURCE_ALPHA_DISABLE);
                return;
            }
            this.h.setAlpha(1.0f);
            this.v.setAlpha(1.0f);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onResume();
            View view2 = this.e;
            if (view2 != null) {
                view2.setSystemUiVisibility(4100);
            }
            zq6 zq6Var = this.G;
            if (zq6Var != null) {
                zq6Var.onResume();
            }
            e07 e07Var = this.N;
            if (e07Var != null) {
                e07Var.onResume();
            }
            i07 i07Var = this.L;
            if (i07Var != null) {
                i07Var.e();
            }
            d07 d07Var = this.K;
            if (d07Var != null) {
                d07Var.h();
            }
        }
    }

    public final void Z1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            df6 df6Var = this.H;
            if (df6Var != null && df6Var.getProgress() < 3.0f) {
                EMManager.from(this.a).setCorner(R.string.J_X01).setAlpha(R.string.A_X09).setBackGroundColor(R.color.CAM_X0302);
            } else {
                EMManager.from(this.a).setCorner(R.string.J_X01).setAlpha(R.string.A_X01).setBackGroundColor(R.color.CAM_X0302);
            }
            if (this.z.getVisibility() != i2) {
                this.z.setVisibility(i2);
            }
        }
    }

    public final void a2(@RawRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            if (this.d == null) {
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090575);
                this.d = relativeLayout;
                EMManager.from(relativeLayout).setAlpha(R.string.A_X09).setBackGroundColor(R.color.CAM_X0611);
            }
            if (this.c == null) {
                this.c = (TBLottieAnimationView) findViewById(R.id.obfuscated_res_0x7f090574);
            }
            this.d.setVisibility(0);
            this.c.setAnimation(i2);
            this.c.loop(true);
            this.c.playAnimation();
            SafeHandler.getInst().postDelayed(new h(this), 3000L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.H != null) {
                ImageView imageView = this.b;
                Resources resources = getResources();
                if (this.H.b()) {
                    i3 = R.drawable.obfuscated_res_0x7f080c60;
                } else {
                    i3 = R.drawable.obfuscated_res_0x7f080c6e;
                }
                imageView.setImageDrawable(resources.getDrawable(i3));
                TextView textView = this.r;
                Resources resources2 = getResources();
                if (this.H.b()) {
                    i4 = R.string.obfuscated_res_0x7f0f0553;
                } else {
                    i4 = R.string.obfuscated_res_0x7f0f178f;
                }
                textView.setText(resources2.getString(i4));
            }
        }
    }

    public final void d2(boolean z) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            jf6 jf6Var = this.I;
            if (jf6Var != null && jf6Var.c()) {
                i2 = R.drawable.obfuscated_res_0x7f080c2d;
                i3 = R.drawable.obfuscated_res_0x7f080c2f;
            } else {
                i2 = R.drawable.obfuscated_res_0x7f080c2c;
                i3 = R.drawable.obfuscated_res_0x7f080c2e;
            }
            if (z) {
                this.g.setImageDrawable(getResources().getDrawable(i3));
            } else {
                this.g.setImageDrawable(getResources().getDrawable(i2));
            }
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            EMManager.from(this.n).setTextShadow(R.array.S_O_X001);
            EMManager.from(this.o).setTextShadow(R.array.S_O_X001);
            EMManager.from(this.p).setTextShadow(R.array.S_O_X001);
            EMManager.from(this.f1172T).setTextShadow(R.array.S_O_X001);
            EMManager.from(this.q).setTextShadow(R.array.S_O_X001);
            EMManager.from(this.s).setTextShadow(R.array.S_O_X001);
            EMManager.from(this.r).setTextShadow(R.array.S_O_X001);
            EMManager.from(this.t).setTextStyle(R.string.F_X02).setTextShadow(R.array.S_O_X001);
            this.b0.setRecordManager(this.G);
            this.b0.setMusicManager(this.N);
            this.A.setItemTextPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X012));
            this.A.setItemTextSize(UtilHelper.getDimenPixelSize(R.dimen.T_X05));
            this.A.setItemTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.CAM_X0101));
            this.Y = new ArrayList();
            this.X = new HashMap();
            this.Y.add(getString(R.string.obfuscated_res_0x7f0f075e));
            this.X.put(getString(R.string.obfuscated_res_0x7f0f075e), 300);
            this.Y.add(getString(R.string.obfuscated_res_0x7f0f1446));
            this.X.put(getString(R.string.obfuscated_res_0x7f0f1446), 60);
            this.Y.add(getString(R.string.obfuscated_res_0x7f0f073d));
            this.X.put(getString(R.string.obfuscated_res_0x7f0f073d), 15);
            this.A.setOnItemSelected(new e(this));
            this.A.setData(this.Y);
            this.A.setSelectedPosition(this.Y.size() - 1);
            this.f.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c3d));
            d2(false);
            c2();
            this.i.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c38));
            this.j.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c63));
            this.k.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c66));
            this.l.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c69));
            this.S.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c69));
            this.m.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c5d));
            this.a.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c68));
            EMManager.from(this.a).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0302);
            this.O = (WriteImagesInfo) getIntent().getSerializableExtra(TbCaptureActivityConfig.WRITE_IMAGE_INFO);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048598, this, i2, i3, intent) == null) {
            if (intent != null && i2 == 25032) {
                String stringExtra = intent.getStringExtra(CloudMusicActivityConfig.MUSIC_ID);
                TbMusicData tbMusicData = (TbMusicData) intent.getSerializableExtra(CloudMusicActivityConfig.MUSIC_DATA);
                if (tbMusicData != null) {
                    this.U = tbMusicData;
                    if (!TextUtils.isEmpty(tbMusicData.localPath) && !TextUtils.isEmpty(stringExtra)) {
                        String str = tbMusicData.localPath;
                        if (this.N != null && !TextUtils.isEmpty(str)) {
                            this.N.g(str, stringExtra);
                            this.b0.y(tbMusicData);
                        }
                    }
                }
            } else if (i2 == 12012 && i3 == -1) {
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
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        df6.c cVar;
        gf6 gf6Var;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view2) == null) {
            super.onClick(view2);
            if (view2.getId() == R.id.obfuscated_res_0x7f09058a) {
                onBackPressed();
                return;
            }
            int i2 = 8;
            boolean z2 = true;
            if (view2.getId() == R.id.obfuscated_res_0x7f09058d) {
                jf6 jf6Var = this.I;
                if (jf6Var != null) {
                    if (jf6Var.a() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    K1();
                    X1();
                    jf6 jf6Var2 = this.I;
                    if (!z) {
                        i2 = 0;
                    }
                    jf6Var2.b(i2);
                    if (this.I.a() != 0) {
                        z2 = false;
                    }
                    d2(z2);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09058c) {
                if (ListUtils.isEmpty(this.V) && (gf6Var = this.J) != null) {
                    if (gf6Var.a() != 0) {
                        z2 = false;
                    }
                    K1();
                    X1();
                    if (z2) {
                        this.h.setImageDrawable(getResources().getDrawable(this.Z));
                        this.J.b(8);
                        return;
                    }
                    this.h.setImageDrawable(getResources().getDrawable(this.a0));
                    this.J.b(0);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09058e) {
                zq6 zq6Var = this.G;
                if (zq6Var != null) {
                    zq6Var.d();
                }
                if (!SharedPrefHelper.getInstance().getBoolean("key_capture_switch_camera_guide_show", false)) {
                    a2(R.raw.obfuscated_res_0x7f11000b);
                    SharedPrefHelper.getInstance().putBoolean("key_capture_switch_camera_guide_show", true);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09057f) {
                if (!SharedPrefHelper.getInstance().getBoolean("key_capture_filter_guide_show", false)) {
                    a2(R.raw.obfuscated_res_0x7f11000c);
                    SharedPrefHelper.getInstance().putBoolean("key_capture_filter_guide_show", true);
                }
                W1();
                if (this.b0.q()) {
                    this.j.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c63));
                } else {
                    this.j.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c65));
                }
                this.b0.u();
                if (this.b0.s()) {
                    R1();
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090581) {
                if (ListUtils.isEmpty(this.V)) {
                    W1();
                    if (this.b0.r()) {
                        this.k.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c66));
                    } else {
                        this.k.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c67));
                    }
                    this.b0.v();
                }
            } else if (view2.getId() != R.id.obfuscated_res_0x7f09056f && view2.getId() != R.id.obfuscated_res_0x7f090583) {
                if (view2.getId() == R.id.obfuscated_res_0x7f09056a) {
                    W1();
                    Q1();
                } else if (view2.getId() == R.id.obfuscated_res_0x7f09056c) {
                    df6 df6Var = this.H;
                    if (df6Var != null) {
                        if (df6Var.b()) {
                            this.H.a();
                            this.b.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c6e));
                            this.r.setText(getResources().getString(R.string.obfuscated_res_0x7f0f178f));
                            return;
                        }
                        this.H.setShowDeleteLastTip(true);
                        this.b.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c60));
                        this.r.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0553));
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f09056d && (cVar = this.f0) != null) {
                    cVar.onFinished();
                }
            } else {
                W1();
                this.b0.w();
                if (this.b0.t()) {
                    S1();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0030);
            if (Build.VERSION.SDK_INT >= 28 && RomTypeUtil.isOPPO() && TbSingleton.getInstance().isCutoutScreen(this)) {
                r0b.b(1, getWindow().getAttributes(), getWindow());
            }
            setSwipeBackEnabled(false);
            P1();
            if (getIntent() != null) {
                this.c0 = getIntent().getIntExtra(TbCaptureActivityConfig.CAPTURE_TYPE, -1);
            }
            O1();
            initView();
            L1();
            initData();
            N1();
        }
    }
}
