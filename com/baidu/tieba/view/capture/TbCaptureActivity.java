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
import com.baidu.tbadk.core.atomData.TbCaptureActivityConfig;
import com.baidu.tbadk.core.atomData.TbEditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
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
import com.baidu.tieba.ai6;
import com.baidu.tieba.b17;
import com.baidu.tieba.bi6;
import com.baidu.tieba.c17;
import com.baidu.tieba.cg0;
import com.baidu.tieba.ci6;
import com.baidu.tieba.d17;
import com.baidu.tieba.di6;
import com.baidu.tieba.ei6;
import com.baidu.tieba.external.filter.ResponseGetQmFiltersMessage;
import com.baidu.tieba.external.music.data.MusicData;
import com.baidu.tieba.external.sticker.ResponseGetQmStickersMessage;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
import com.baidu.tieba.f17;
import com.baidu.tieba.fi6;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.gi6;
import com.baidu.tieba.gs6;
import com.baidu.tieba.h17;
import com.baidu.tieba.hs6;
import com.baidu.tieba.i17;
import com.baidu.tieba.is6;
import com.baidu.tieba.js6;
import com.baidu.tieba.l55;
import com.baidu.tieba.n55;
import com.baidu.tieba.n95;
import com.baidu.tieba.o6a;
import com.baidu.tieba.o75;
import com.baidu.tieba.ok9;
import com.baidu.tieba.q6a;
import com.baidu.tieba.sx8;
import com.baidu.tieba.tg;
import com.baidu.tieba.vi;
import com.baidu.tieba.view.capture.camera.AspectGLSurfaceView;
import com.baidu.tieba.view.capture.camera.PicGLSurfaceView;
import com.baidu.tieba.view.widget.HorizontalCenterSelectView;
import com.baidu.tieba.view.widget.RecordPreviewContainer;
import com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout;
import com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout;
import com.baidu.tieba.wca;
import com.baidu.tieba.wg;
import com.baidu.tieba.wx8;
import com.baidu.tieba.xba;
import com.baidu.tieba.xi;
import com.baidu.tieba.yda;
import com.baidu.tieba.zh6;
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
    public sx8 F;
    public is6 G;
    public zh6 H;
    public fi6 I;
    public ci6 J;
    public c17 K;
    public h17 L;
    public gs6 M;
    public d17 N;
    public WriteImagesInfo O;
    public ImageFileInfo P;
    public RelativeLayout Q;
    public RelativeLayout R;
    public ImageView S;

    /* renamed from: T  reason: collision with root package name */
    public TextView f1182T;
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
    public boolean c0;
    public RelativeLayout d;
    public int d0;
    public View e;
    public is6.b e0;
    public ImageView f;
    public is6.a f0;
    public ImageView g;
    public zh6.c g0;
    public ImageView h;
    public zh6.b h0;
    public ImageView i;
    public zh6.a i0;
    public ImageView j;
    public ei6 j0;
    public ImageView k;
    public ImageView l;
    public ImageView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public bi6 r0;
    public TextView s;
    public HttpMessageListener s0;
    public TextView t;
    public HttpMessageListener t0;
    public RelativeLayout u;
    public b17.b u0;
    public RelativeLayout v;
    public i17.b v0;
    public RelativeLayout w;
    public CustomMessageListener w0;
    public RelativeLayout x;
    public CustomMessageListener x0;
    public RelativeLayout y;
    public RelativeLayout z;

    /* loaded from: classes8.dex */
    public class n implements VideoControllerLayout.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCaptureActivity a;

        /* loaded from: classes8.dex */
        public class a implements is6.c {
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

            @Override // com.baidu.tieba.is6.c
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
                    WriteMulitImageActivityConfig writeMulitImageActivityConfig = new WriteMulitImageActivityConfig(this.a.a.getPageContext().getPageActivity(), 12012, this.a.a.O, this.a.a.O.size() - 1, (ForumWriteData) this.a.a.getIntent().getSerializableExtra("forum_write_data"), this.a.a.getIntent().getIntExtra("entrance_flag", 0));
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
                        if (this.a.d0 != 1) {
                            this.a.A.setVisibility(0);
                        }
                        this.a.w.setVisibility(0);
                        this.a.x.setVisibility(0);
                    }
                    this.a.y.setVisibility(8);
                    this.a.D2(8);
                    return;
                }
                if (this.a.G.c()) {
                    this.a.w.setVisibility(8);
                } else {
                    this.a.w.setVisibility(0);
                }
                this.a.y.setVisibility(0);
                this.a.D2(0);
                this.a.A.setVisibility(8);
                this.a.x.setVisibility(8);
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
                this.a.D2(8);
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void l() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.G != null) {
                this.a.G.stopRecord();
                this.a.C.setVisibility(0);
                this.a.D.setVisibility(0);
                this.a.y.setVisibility(0);
                this.a.D2(0);
                this.a.w.setVisibility(0);
                if (this.a.N != null) {
                    this.a.N.pause();
                }
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
            if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.a.G == null) {
                return;
            }
            this.a.G.g(new a(this));
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void q() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.a.H == null) {
                return;
            }
            if (this.a.H.getProgress() < this.a.H.getMaxDuration()) {
                this.a.G.startRecord();
                this.a.C.setVisibility(8);
                this.a.D.setVisibility(8);
                this.a.q2();
                this.a.A2();
                this.a.y.setVisibility(8);
                if (this.a.H.getProgress() < 3.0f) {
                    this.a.D2(8);
                } else {
                    this.a.D2(0);
                }
                this.a.w.setVisibility(8);
                this.a.z2();
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
    public class a implements b17.b {
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

        @Override // com.baidu.tieba.b17.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.b0 != null) {
                    QmFilterItem qmFilterItem = new QmFilterItem();
                    qmFilterItem.id = "-1";
                    qmFilterItem.bgurl = R.drawable.obfuscated_res_0x7f080c14 + "";
                    qmFilterItem.name = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0731);
                    qmFilterItem.isSelect = true;
                    qmFilterItem.localPath = "origin";
                    this.a.b0.z(qmFilterItem);
                    if (this.a.K != null) {
                        this.a.K.a(null);
                    }
                    this.a.b0.setDownLoadFilter(null);
                }
                if (StringUtils.isNull(str)) {
                    str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f141d);
                }
                this.a.showToast(str);
                this.a.F.b(5, str);
            }
        }

        @Override // com.baidu.tieba.b17.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.b0 != null) {
                this.a.b0.setDownLoadFilter(null);
            }
        }

        @Override // com.baidu.tieba.b17.b
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
    public class b implements i17.b {
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

        @Override // com.baidu.tieba.i17.b
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
                    str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f141d);
                }
                this.a.showToast(str);
                this.a.F.b(5, str);
            }
        }

        @Override // com.baidu.tieba.i17.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.b0 != null) {
                this.a.b0.setDownLoadSticker(null, false);
            }
        }

        @Override // com.baidu.tieba.i17.b
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.V != null && this.a.V.size() == 0 && this.a.J != null) {
                this.a.J.c(vi.l(this.a.getPageContext().getPageActivity()), vi.j(this.a.getPageContext().getPageActivity()));
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
    public class f implements n55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l55 a;
        public final /* synthetic */ TbCaptureActivity b;

        public f(TbCaptureActivity tbCaptureActivity, l55 l55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity, l55Var};
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
            this.a = l55Var;
        }

        @Override // com.baidu.tieba.n55.f
        public void M0(n55 n55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, n55Var, i, view2) == null) {
                if (i == 0) {
                    this.b.y2();
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
    public class g implements gs6.a {
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

        @Override // com.baidu.tieba.gs6.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TbCaptureActivity tbCaptureActivity = this.a;
                tbCaptureActivity.hideLoadingView(tbCaptureActivity.e);
            }
        }

        @Override // com.baidu.tieba.gs6.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                TbCaptureActivity tbCaptureActivity = this.a;
                tbCaptureActivity.showLoadingView(tbCaptureActivity.e);
            }
        }

        @Override // com.baidu.tieba.gs6.a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                VideoFileInfo c = o6a.c(str);
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
                ForumWriteData forumWriteData = (ForumWriteData) this.a.getIntent().getSerializableExtra("forum_write_data");
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
    public class i implements RecordPreviewContainer.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbCaptureActivity a;

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.e
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

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.e
        public void a(MotionEvent motionEvent, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, motionEvent, i) == null) && this.a.G != null) {
                xba.D(this.a.getPageContext()).l(i);
                this.a.z2();
                this.a.c0 = true;
            }
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.e
        public void b(MotionEvent motionEvent, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && this.a.G != null) {
                xba.D(this.a.getPageContext()).c(i, i2, i3, i4);
                this.a.c0 = true;
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
    public class k implements is6.b {
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

        @Override // com.baidu.tieba.is6.b
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
                    this.a.F2();
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.is6.b
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
    public class l implements RecordPreviewContainer.f {
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

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
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
                this.b.z2();
            }
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
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
                this.b.z2();
            }
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void c(MotionEvent motionEvent, float f, float f2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, Float.valueOf(f), Float.valueOf(f2)}) == null) && this.b.G != null && !this.b.G.c()) {
                this.b.G.d();
                this.b.z2();
            }
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void d(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
                this.b.q2();
                this.b.A2();
                if (this.b.b0 != null && this.b.b0.p()) {
                    this.b.b0.m(null, false);
                }
                if (this.b.G != null && !this.b.G.c() && this.b.E != null) {
                    this.b.E.i(motionEvent);
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
        public void b(yda ydaVar, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ydaVar, obj) != null) || ydaVar == null) {
                return;
            }
            int type = ydaVar.getType();
            if (type != 2) {
                if (type == 3 && (ydaVar.c() instanceof MusicData)) {
                    MusicData musicData = (MusicData) ydaVar.c();
                    TbMusicData tbMusicData = new TbMusicData();
                    tbMusicData.id = musicData.id;
                    tbMusicData.title = musicData.name;
                    tbMusicData.url = musicData.resource;
                    tbMusicData.icon = musicData.img;
                    tbMusicData.type = tg.e(musicData.type, 1);
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
                    this.a.N.d((MusicData) ydaVar.c(), obj);
                }
            } else if (this.a.K != null && (ydaVar.c() instanceof QmFilterItem)) {
                QmFilterItem qmFilterItem = (QmFilterItem) ydaVar.c();
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
    public class o implements is6.a {
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

        @Override // com.baidu.tieba.is6.a
        public void onProgress(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && this.a.H != null) {
                this.a.H.setProgress(j);
                if (this.a.H.getProgress() < 3.0f) {
                    return;
                }
                this.a.D2(0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p implements zh6.c {
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

        @Override // com.baidu.tieba.zh6.c
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
    public class q implements zh6.b {
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

        @Override // com.baidu.tieba.zh6.b
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
    public class r implements zh6.a {
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

        @Override // com.baidu.tieba.zh6.a
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
                    this.a.D2(8);
                    this.a.A.setVisibility(0);
                    this.a.b0.F();
                    this.a.w.setVisibility(0);
                    this.a.x.setVisibility(0);
                }
                this.a.F2();
                return true;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class s implements ei6 {
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

        @Override // com.baidu.tieba.ei6
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
                    tbCaptureActivity.H2(z);
                }
                return true;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class t implements bi6 {
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

        @Override // com.baidu.tieba.bi6
        public boolean a(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
                if (this.a.G != null && this.a.G.f() != null) {
                    this.a.G.f().a(f);
                    this.a.G2();
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
                qmFilterItem.bgurl = R.drawable.obfuscated_res_0x7f080c14 + "";
                qmFilterItem.name = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0731);
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
        this.Z = R.drawable.obfuscated_res_0x7f080bf7;
        this.a0 = R.drawable.obfuscated_res_0x7f080bf8;
        this.c0 = false;
        this.d0 = -1;
        this.e0 = new k(this);
        this.f0 = new o(this);
        this.g0 = new p(this);
        this.h0 = new q(this);
        this.i0 = new r(this);
        this.j0 = new s(this);
        this.r0 = new t(this);
        this.s0 = new u(this, CmdConfigHttp.CMD_GET_QM_STICKERS, true);
        this.t0 = new v(this, CmdConfigHttp.CMD_GET_QM_FILTERS, true);
        this.u0 = new a(this);
        this.v0 = new b(this);
        this.w0 = new c(this, 2921583);
        this.x0 = new d(this, 2921414);
    }

    public final void G2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.Z = R.drawable.obfuscated_res_0x7f080bf7;
            this.a0 = R.drawable.obfuscated_res_0x7f080bf8;
            ci6 ci6Var = this.J;
            if (ci6Var == null) {
                return;
            }
            if (ci6Var.e() == 1.0f) {
                this.Z = R.drawable.obfuscated_res_0x7f080be0;
                this.a0 = R.drawable.obfuscated_res_0x7f080be1;
            } else if (this.J.e() == 1.3333334f) {
                this.Z = R.drawable.obfuscated_res_0x7f080be4;
                this.a0 = R.drawable.obfuscated_res_0x7f080be5;
            } else if (this.J.e() == 1.7777778f) {
                this.Z = R.drawable.obfuscated_res_0x7f080be6;
                this.a0 = R.drawable.obfuscated_res_0x7f080be7;
            } else if (this.J.e() == 0.5625f) {
                this.Z = R.drawable.obfuscated_res_0x7f080be2;
                this.a0 = R.drawable.obfuscated_res_0x7f080be3;
            }
            if (this.J.a() == 0) {
                this.h.setImageDrawable(getResources().getDrawable(this.a0));
            } else {
                this.h.setImageDrawable(getResources().getDrawable(this.Z));
            }
        }
    }

    public final void v2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
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

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view2) == null) {
            super.showLoadingView(view2);
            if (getLoadingView() != null && getLoadingView().k() != null) {
                getLoadingView().k().setVisibility(8);
            }
        }
    }

    public final void A2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            C2();
            B2();
        }
    }

    public final void B2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.j.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c13));
            this.k.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c16));
        }
    }

    public final void C2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            H2(false);
            G2();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.d0 == 1) {
                finish();
            } else {
                p2();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPause();
            is6 is6Var = this.G;
            if (is6Var != null) {
                is6Var.onPause();
            }
            d17 d17Var = this.N;
            if (d17Var != null) {
                d17Var.onPause();
            }
        }
    }

    public final void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            fi6 fi6Var = this.I;
            if (fi6Var != null) {
                fi6Var.b(8);
            }
            ci6 ci6Var = this.J;
            if (ci6Var != null) {
                ci6Var.b(8);
            }
        }
    }

    public final void D2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            zh6 zh6Var = this.H;
            if (zh6Var != null && zh6Var.getProgress() < 3.0f) {
                o75 d2 = o75.d(this.a);
                d2.o(R.string.J_X01);
                d2.e(R.string.A_X09);
                d2.f(R.color.CAM_X0302);
            } else {
                o75 d3 = o75.d(this.a);
                d3.o(R.string.J_X01);
                d3.e(R.string.A_X01);
                d3.f(R.color.CAM_X0302);
            }
            if (this.z.getVisibility() != i2) {
                this.z.setVisibility(i2);
            }
        }
    }

    public final void E2(@RawRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (this.d == null) {
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090549);
                this.d = relativeLayout;
                o75 d2 = o75.d(relativeLayout);
                d2.e(R.string.A_X09);
                d2.f(R.color.CAM_X0611);
            }
            if (this.c == null) {
                this.c = (TBLottieAnimationView) findViewById(R.id.obfuscated_res_0x7f090548);
            }
            this.d.setVisibility(0);
            this.c.setAnimation(i2);
            this.c.loop(true);
            this.c.playAnimation();
            wg.a().postDelayed(new h(this), 3000L);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.H != null) {
                ImageView imageView = this.b;
                Resources resources = getResources();
                if (this.H.b()) {
                    i3 = R.drawable.obfuscated_res_0x7f080c10;
                } else {
                    i3 = R.drawable.obfuscated_res_0x7f080c1e;
                }
                imageView.setImageDrawable(resources.getDrawable(i3));
                TextView textView = this.r;
                Resources resources2 = getResources();
                if (this.H.b()) {
                    i4 = R.string.obfuscated_res_0x7f0f053f;
                } else {
                    i4 = R.string.obfuscated_res_0x7f0f1730;
                }
                textView.setText(resources2.getString(i4));
            }
        }
    }

    public final void F2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
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
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroy();
            is6 is6Var = this.G;
            if (is6Var != null) {
                is6Var.onDestroy();
            }
            d17 d17Var = this.N;
            if (d17Var != null) {
                d17Var.b();
                this.N.e();
            }
            gs6 gs6Var = this.M;
            if (gs6Var != null) {
                gs6Var.a();
            }
            h17 h17Var = this.L;
            if (h17Var != null) {
                h17Var.onDestroy();
            }
            if (this.c0) {
                xba.D(getPageContext()).release();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onResume();
            View view2 = this.e;
            if (view2 != null) {
                view2.setSystemUiVisibility(4100);
            }
            is6 is6Var = this.G;
            if (is6Var != null) {
                is6Var.onResume();
            }
            d17 d17Var = this.N;
            if (d17Var != null) {
                d17Var.onResume();
            }
            h17 h17Var = this.L;
            if (h17Var != null) {
                h17Var.e();
            }
            c17 c17Var = this.K;
            if (c17Var != null) {
                c17Var.h();
            }
        }
    }

    public final void z2() {
        zh6 zh6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && (zh6Var = this.H) != null) {
            zh6Var.setShowDeleteLastTip(false);
            this.b.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c1e));
            this.r.setText(getResources().getString(R.string.obfuscated_res_0x7f0f1730));
        }
    }

    public final void H2(boolean z) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            fi6 fi6Var = this.I;
            if (fi6Var != null && fi6Var.c()) {
                i2 = R.drawable.obfuscated_res_0x7f080bdd;
                i3 = R.drawable.obfuscated_res_0x7f080bdf;
            } else {
                i2 = R.drawable.obfuscated_res_0x7f080bdc;
                i3 = R.drawable.obfuscated_res_0x7f080bde;
            }
            if (z) {
                this.g.setImageDrawable(getResources().getDrawable(i3));
            } else {
                this.g.setImageDrawable(getResources().getDrawable(i2));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0030);
            setSwipeBackEnabled(false);
            u2();
            if (getIntent() != null) {
                this.d0 = getIntent().getIntExtra(TbCaptureActivityConfig.CAPTURE_TYPE, -1);
            }
            t2();
            initView();
            r2();
            initData();
            s2();
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            o75.d(this.n).A(R.array.S_O_X001);
            o75.d(this.o).A(R.array.S_O_X001);
            o75.d(this.p).A(R.array.S_O_X001);
            o75.d(this.f1182T).A(R.array.S_O_X001);
            o75.d(this.q).A(R.array.S_O_X001);
            o75.d(this.s).A(R.array.S_O_X001);
            o75.d(this.r).A(R.array.S_O_X001);
            o75 d2 = o75.d(this.t);
            d2.C(R.string.F_X02);
            d2.A(R.array.S_O_X001);
            this.b0.setRecordManager(this.G);
            this.b0.setMusicManager(this.N);
            this.A.setItemTextPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X012));
            this.A.setItemTextSize(UtilHelper.getDimenPixelSize(R.dimen.T_X05));
            this.A.setItemTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.CAM_X0101));
            this.Y = new ArrayList();
            this.X = new HashMap();
            this.Y.add(getString(R.string.obfuscated_res_0x7f0f073d));
            this.X.put(getString(R.string.obfuscated_res_0x7f0f073d), 300);
            this.Y.add(getString(R.string.obfuscated_res_0x7f0f13bd));
            this.X.put(getString(R.string.obfuscated_res_0x7f0f13bd), 60);
            this.Y.add(getString(R.string.obfuscated_res_0x7f0f071c));
            this.X.put(getString(R.string.obfuscated_res_0x7f0f071c), 15);
            this.A.setOnItemSelected(new e(this));
            this.A.setData(this.Y);
            this.A.setSelectedPosition(this.Y.size() - 1);
            this.f.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080bed));
            H2(false);
            G2();
            this.i.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080be8));
            this.j.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c13));
            this.k.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c16));
            this.l.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c19));
            this.S.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c19));
            this.m.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c0d));
            this.a.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c18));
            o75 d3 = o75.d(this.a);
            d3.o(R.string.J_X01);
            d3.f(R.color.CAM_X0302);
            this.O = (WriteImagesInfo) getIntent().getSerializableExtra("write_image_info");
        }
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.e = findViewById(R.id.obfuscated_res_0x7f091ed0);
            this.C = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09055f);
            this.D = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09054d);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f09055e);
            this.g = (ImageView) findViewById(R.id.obfuscated_res_0x7f090561);
            this.h = (ImageView) findViewById(R.id.obfuscated_res_0x7f090560);
            this.i = (ImageView) findViewById(R.id.obfuscated_res_0x7f090562);
            this.j = (ImageView) findViewById(R.id.obfuscated_res_0x7f090552);
            this.u = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090553);
            this.k = (ImageView) findViewById(R.id.obfuscated_res_0x7f090554);
            this.v = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090555);
            this.R = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090557);
            this.S = (ImageView) findViewById(R.id.obfuscated_res_0x7f090556);
            this.f1182T = (TextView) findViewById(R.id.obfuscated_res_0x7f09055c);
            this.w = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090543);
            this.l = (ImageView) findViewById(R.id.obfuscated_res_0x7f090542);
            this.p = (TextView) findViewById(R.id.obfuscated_res_0x7f090547);
            this.m = (ImageView) findViewById(R.id.obfuscated_res_0x7f09053d);
            this.x = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09053e);
            this.n = (TextView) findViewById(R.id.obfuscated_res_0x7f09055a);
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f09055b);
            this.q = (TextView) findViewById(R.id.obfuscated_res_0x7f090544);
            this.s = (TextView) findViewById(R.id.obfuscated_res_0x7f090546);
            this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f090545);
            this.t = (TextView) findViewById(R.id.obfuscated_res_0x7f09054a);
            this.z = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090541);
            this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f0918c0);
            this.A = (HorizontalCenterSelectView) findViewById(R.id.obfuscated_res_0x7f0916ba);
            this.y = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090540);
            this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f0904b0);
            this.Q = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09053f);
        }
    }

    public final void x2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_QM_STICKERS);
            if (ok9.b()) {
                httpMessage.addParam(HttpRequest.UH, xi.f() + "," + Build.HARDWARE + "," + Build.BOARD + "," + (q6a.b(this) ? 1 : 0));
                httpMessage.addParam("ut", xi.g() + "_" + xi.k() + "_" + q6a.a() + "_" + Build.BRAND.replace("_", ""));
            } else {
                httpMessage.addParam(HttpRequest.NEED_DECRYPT, ok9.c());
                String g2 = ok9.g(HttpRequest.UH);
                if (!TextUtils.isEmpty(g2)) {
                    httpMessage.addParam(g2, ok9.a(xi.f() + "," + Build.HARDWARE + "," + Build.BOARD + "," + (q6a.b(this) ? 1 : 0)));
                }
                String g3 = ok9.g("ut");
                if (!TextUtils.isEmpty(g3)) {
                    httpMessage.addParam(g3, ok9.a(xi.g() + "_" + xi.k() + "_" + q6a.a() + "_" + Build.BRAND.replace("_", "")));
                }
            }
            httpMessage.addParam("sdk_version", cg0.h() + "");
            httpMessage.addParam("brand", "baiduar");
            sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048587, this, i2, i3, intent) == null) {
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
        zh6.c cVar;
        ci6 ci6Var;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            super.onClick(view2);
            if (view2.getId() == R.id.obfuscated_res_0x7f09055e) {
                onBackPressed();
                return;
            }
            int i2 = 8;
            boolean z2 = true;
            if (view2.getId() == R.id.obfuscated_res_0x7f090561) {
                fi6 fi6Var = this.I;
                if (fi6Var != null) {
                    if (fi6Var.a() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    q2();
                    C2();
                    fi6 fi6Var2 = this.I;
                    if (!z) {
                        i2 = 0;
                    }
                    fi6Var2.b(i2);
                    if (this.I.a() != 0) {
                        z2 = false;
                    }
                    H2(z2);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090560) {
                if (ListUtils.isEmpty(this.V) && (ci6Var = this.J) != null) {
                    if (ci6Var.a() != 0) {
                        z2 = false;
                    }
                    q2();
                    C2();
                    if (z2) {
                        this.h.setImageDrawable(getResources().getDrawable(this.Z));
                        this.J.b(8);
                        return;
                    }
                    this.h.setImageDrawable(getResources().getDrawable(this.a0));
                    this.J.b(0);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090562) {
                is6 is6Var = this.G;
                if (is6Var != null) {
                    is6Var.d();
                }
                if (!n95.m().i("key_capture_switch_camera_guide_show", false)) {
                    E2(R.raw.obfuscated_res_0x7f11000a);
                    n95.m().w("key_capture_switch_camera_guide_show", true);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090553) {
                if (!n95.m().i("key_capture_filter_guide_show", false)) {
                    E2(R.raw.obfuscated_res_0x7f11000b);
                    n95.m().w("key_capture_filter_guide_show", true);
                }
                B2();
                if (this.b0.q()) {
                    this.j.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c13));
                } else {
                    this.j.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c15));
                }
                this.b0.v();
                if (this.b0.t()) {
                    w2();
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090555) {
                if (ListUtils.isEmpty(this.V)) {
                    B2();
                    if (this.b0.r()) {
                        this.k.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c16));
                    } else {
                        this.k.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c17));
                    }
                    this.b0.w();
                }
            } else if (view2.getId() != R.id.obfuscated_res_0x7f090543 && view2.getId() != R.id.obfuscated_res_0x7f090557) {
                if (view2.getId() == R.id.obfuscated_res_0x7f09053e) {
                    B2();
                    v2();
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090540) {
                    zh6 zh6Var = this.H;
                    if (zh6Var != null) {
                        if (zh6Var.b()) {
                            this.H.a();
                            this.b.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c1e));
                            this.r.setText(getResources().getString(R.string.obfuscated_res_0x7f0f1730));
                            return;
                        }
                        this.H.setShowDeleteLastTip(true);
                        this.b.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c10));
                        this.r.setText(getResources().getString(R.string.obfuscated_res_0x7f0f053f));
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090541 && (cVar = this.g0) != null) {
                    cVar.onFinished();
                }
            } else {
                B2();
                this.b0.x();
                if (this.b0.u()) {
                    x2();
                }
            }
        }
    }

    public final void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            zh6 zh6Var = this.H;
            if (zh6Var != null && zh6Var.getProgress() > 0.0f) {
                l55 l55Var = new l55(getPageContext(), new n55(getPageContext().getPageActivity()));
                l55Var.i(null, new String[]{getString(R.string.obfuscated_res_0x7f0f03d9), getResources().getString(R.string.obfuscated_res_0x7f0f117f)}, new f(this, l55Var));
                l55Var.l();
                return;
            }
            finish();
        }
    }

    public final void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            int i2 = this.d0;
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

    public final void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
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
            registerListener(this.s0);
            registerListener(this.t0);
            registerListener(this.w0);
            registerListener(this.x0);
            this.E.setOnPreviewStateChangedListener(new i(this));
            this.E.setOnViewClickListener(new l(this, new j(this)));
            this.b0.setEffectChoosedListener(new m(this));
            this.b0.setRecordControlListener(new n(this));
        }
    }

    public final void u2() {
        wx8 wx8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_QM_STICKERS, TbConfig.SERVER_ADDRESS + TbConfig.GET_QM_STICKERS);
            tbHttpMessageTask.setResponsedClass(ResponseGetQmStickersMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_QM_FILTERS, TbConfig.SERVER_ADDRESS + TbConfig.GET_QM_FILTERS);
            tbHttpMessageTask2.setResponsedClass(ResponseGetQmFiltersMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask2);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, wx8.class);
            if (runTask != null) {
                wx8Var = (wx8) runTask.getData();
            } else {
                wx8Var = null;
            }
            if (wx8Var != null) {
                this.F = wx8Var.get();
            }
            sx8 sx8Var = this.F;
            if (sx8Var != null) {
                sx8Var.g();
            }
        }
    }

    public final void y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            is6 is6Var = this.G;
            if (is6Var != null && is6Var.c()) {
                this.G.stopRecord();
                this.C.setVisibility(0);
                this.D.setVisibility(0);
            }
            q2();
            this.V.clear();
            this.H.reset();
            this.A.setSelectedPosition(this.Y.size() - 1);
            this.y.setVisibility(8);
            D2(8);
            if (this.d0 != 1) {
                this.A.setVisibility(0);
            }
            this.b0.F();
            this.w.setVisibility(0);
            this.x.setVisibility(0);
            F2();
            this.I.reset();
            this.J.reset();
            this.K.reset();
            this.L.reset();
            this.N.reset();
            A2();
            hideLoadingView(this.e);
        }
    }

    public final void t2() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            RecordPreviewContainer recordPreviewContainer = (RecordPreviewContainer) findViewById(R.id.obfuscated_res_0x7f09054c);
            this.E = recordPreviewContainer;
            if (this.d0 == 1) {
                recordPreviewContainer.setSurfaceView(new PicGLSurfaceView(this));
                z = false;
            } else {
                recordPreviewContainer.setSurfaceView(new AspectGLSurfaceView(this));
                z = true;
            }
            this.G = new js6(getPageContext(), this.E.getSurfaceView(), z, this.e0, this.f0);
            i17 i17Var = new i17(this.G);
            this.L = i17Var;
            i17Var.c(this.v0);
            this.L.e();
            this.b0 = (VideoControllerLayout) findViewById(R.id.obfuscated_res_0x7f091dd5);
            b17 b17Var = new b17(this.G, null, this.b0);
            this.K = b17Var;
            b17Var.d(this.u0);
            this.K.h();
            wca recrodButton = this.b0.getRecrodButton();
            TextView recordTimeView = this.b0.getRecordTimeView();
            this.B = recordTimeView;
            ai6 ai6Var = new ai6(recrodButton, recordTimeView, this.g0, this.h0, this.i0);
            this.H = ai6Var;
            ai6Var.setMinDuration(3);
            this.H.setMaxDuration(15);
            this.b0.setDurationManager(this.H);
            this.I = new gi6(getPageContext(), this.j0, null);
            int l2 = vi.l(getPageContext().getPageActivity());
            di6 di6Var = new di6(getPageContext(), vi.j(getPageContext().getPageActivity()), l2, this.r0);
            this.J = di6Var;
            di6Var.d(0);
            this.M = new hs6(getPageContext(), new g(this));
            x2();
            w2();
            this.N = new f17(getPageContext(), this.b0);
        }
    }

    public final void w2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_QM_FILTERS);
            if (ok9.b()) {
                httpMessage.addParam(HttpRequest.UH, xi.f() + "," + Build.HARDWARE + "," + Build.BOARD + "," + (q6a.b(this) ? 1 : 0));
                httpMessage.addParam("ut", xi.g() + "_" + xi.k() + "_" + q6a.a() + "_" + Build.BRAND.replace("_", ""));
            } else {
                httpMessage.addParam(HttpRequest.NEED_DECRYPT, ok9.c());
                String g2 = ok9.g(HttpRequest.UH);
                if (!TextUtils.isEmpty(g2)) {
                    httpMessage.addParam(g2, ok9.a(xi.f() + "," + Build.HARDWARE + "," + Build.BOARD + "," + (q6a.b(this) ? 1 : 0)));
                }
                String g3 = ok9.g("ut");
                if (!TextUtils.isEmpty(g3)) {
                    httpMessage.addParam(g3, ok9.a(xi.g() + "_" + xi.k() + "_" + q6a.a() + "_" + Build.BRAND.replace("_", "")));
                }
            }
            httpMessage.addParam("sdk_version", cg0.h() + "");
            sendMessage(httpMessage);
        }
    }
}
