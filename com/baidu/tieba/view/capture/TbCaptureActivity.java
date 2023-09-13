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
import com.baidu.tieba.a1a;
import com.baidu.tieba.aj6;
import com.baidu.tieba.b47;
import com.baidu.tieba.bj6;
import com.baidu.tieba.bwa;
import com.baidu.tieba.c47;
import com.baidu.tieba.external.filter.ResponseGetQmFiltersMessage;
import com.baidu.tieba.external.music.data.MusicData;
import com.baidu.tieba.external.sticker.ResponseGetQmStickersMessage;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.g55;
import com.baidu.tieba.hc9;
import com.baidu.tieba.i55;
import com.baidu.tieba.jf0;
import com.baidu.tieba.lc9;
import com.baidu.tieba.nxa;
import com.baidu.tieba.pya;
import com.baidu.tieba.qqa;
import com.baidu.tieba.ru6;
import com.baidu.tieba.su6;
import com.baidu.tieba.tu6;
import com.baidu.tieba.ui6;
import com.baidu.tieba.uqa;
import com.baidu.tieba.uu6;
import com.baidu.tieba.v37;
import com.baidu.tieba.vi6;
import com.baidu.tieba.view.capture.camera.AspectGLSurfaceView;
import com.baidu.tieba.view.capture.camera.PicGLSurfaceView;
import com.baidu.tieba.view.widget.HorizontalCenterSelectView;
import com.baidu.tieba.view.widget.RecordPreviewContainer;
import com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout;
import com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout;
import com.baidu.tieba.w37;
import com.baidu.tieba.wi6;
import com.baidu.tieba.wqa;
import com.baidu.tieba.x37;
import com.baidu.tieba.xi6;
import com.baidu.tieba.yi6;
import com.baidu.tieba.z37;
import com.baidu.tieba.zi6;
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
    public hc9 F;
    public tu6 G;
    public ui6 H;
    public aj6 I;
    public xi6 J;
    public w37 K;
    public b47 L;
    public ru6 M;
    public x37 N;
    public WriteImagesInfo O;
    public ImageFileInfo P;
    public RelativeLayout Q;
    public RelativeLayout R;
    public ImageView S;

    /* renamed from: T  reason: collision with root package name */
    public TextView f1173T;
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
    public tu6.b d0;
    public View e;
    public tu6.a e0;
    public ImageView f;
    public ui6.c f0;
    public ImageView g;
    public ui6.b g0;
    public ImageView h;
    public ui6.a h0;
    public ImageView i;
    public zi6 i0;
    public ImageView j;
    public wi6 j0;
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
    public v37.b t0;
    public RelativeLayout u;
    public c47.b u0;
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
        public class a implements tu6.c {
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

            @Override // com.baidu.tieba.tu6.c
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
                    WriteMulitImageActivityConfig writeMulitImageActivityConfig = new WriteMulitImageActivityConfig(this.a.a.getPageContext().getPageActivity(), CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, this.a.a.O, this.a.a.O.size() - 1, (ForumWriteData) this.a.a.getIntent().getSerializableExtra("forum_write_data"), this.a.a.getIntent().getIntExtra("entrance_flag", 0));
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
                    this.a.w2(8);
                    return;
                }
                if (this.a.G.c()) {
                    this.a.w.setVisibility(8);
                } else {
                    this.a.w.setVisibility(0);
                }
                this.a.y.setVisibility(0);
                this.a.w2(0);
                this.a.A.setVisibility(8);
                this.a.x.setVisibility(8);
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.A.setVisibility(8);
                this.a.w.setVisibility(8);
                this.a.x.setVisibility(8);
                this.a.y.setVisibility(8);
                this.a.w2(8);
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void i() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.G != null) {
                this.a.G.stopRecord();
                this.a.C.setVisibility(0);
                this.a.D.setVisibility(0);
                this.a.y.setVisibility(0);
                this.a.w2(0);
                this.a.w.setVisibility(0);
                if (this.a.N != null) {
                    this.a.N.pause();
                }
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.A.setVisibility(8);
                this.a.w.setVisibility(8);
                this.a.x.setVisibility(8);
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void m() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.a.G == null) {
                return;
            }
            this.a.G.g(new a(this));
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void o() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.a.H == null) {
                return;
            }
            if (this.a.H.getProgress() < this.a.H.getMaxDuration()) {
                this.a.G.startRecord();
                this.a.C.setVisibility(8);
                this.a.D.setVisibility(8);
                this.a.j2();
                this.a.t2();
                this.a.y.setVisibility(8);
                if (this.a.H.getProgress() < 3.0f) {
                    this.a.w2(8);
                } else {
                    this.a.w2(0);
                }
                this.a.w.setVisibility(8);
                this.a.s2();
                if (this.a.N != null) {
                    this.a.N.a(this.a.H.getProgress());
                }
                this.a.W = false;
            } else if (this.a.H.getProgress() >= this.a.H.getMaxDuration() && this.a.b0 != null) {
                this.a.b0.F();
                if (this.a.M != null) {
                    this.a.M.b(this.a.V);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements v37.b {
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

        @Override // com.baidu.tieba.v37.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.b0 != null) {
                    QmFilterItem qmFilterItem = new QmFilterItem();
                    qmFilterItem.id = "-1";
                    qmFilterItem.bgurl = R.drawable.obfuscated_res_0x7f080c50 + "";
                    qmFilterItem.name = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f074a);
                    qmFilterItem.isSelect = true;
                    qmFilterItem.localPath = "origin";
                    this.a.b0.A(qmFilterItem);
                    if (this.a.K != null) {
                        this.a.K.a(null);
                    }
                    this.a.b0.setDownLoadFilter(null);
                }
                if (StringUtils.isNull(str)) {
                    str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f147f);
                }
                this.a.showToast(str);
                this.a.F.b(5, str);
            }
        }

        @Override // com.baidu.tieba.v37.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.b0 != null) {
                this.a.b0.setDownLoadFilter(null);
            }
        }

        @Override // com.baidu.tieba.v37.b
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
    public class b implements c47.b {
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

        @Override // com.baidu.tieba.c47.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.b0 != null) {
                    QmStickerItem qmStickerItem = new QmStickerItem();
                    qmStickerItem.id = -1;
                    qmStickerItem.isLocalSource = true;
                    qmStickerItem.localPath = "nosticker";
                    this.a.b0.B(qmStickerItem);
                    if (this.a.L != null) {
                        this.a.L.b(null);
                    }
                    this.a.b0.setDownLoadSticker(qmStickerItem, false);
                }
                if (StringUtils.isNull(str)) {
                    str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f147f);
                }
                this.a.showToast(str);
                this.a.F.b(5, str);
            }
        }

        @Override // com.baidu.tieba.c47.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.b0 != null) {
                this.a.b0.setDownLoadSticker(null, false);
            }
        }

        @Override // com.baidu.tieba.c47.b
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
    public class f implements i55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g55 a;
        public final /* synthetic */ TbCaptureActivity b;

        public f(TbCaptureActivity tbCaptureActivity, g55 g55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity, g55Var};
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
            this.a = g55Var;
        }

        @Override // com.baidu.tieba.i55.f
        public void G0(i55 i55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, i55Var, i, view2) == null) {
                if (i == 0) {
                    this.b.r2();
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
    public class g implements ru6.a {
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

        @Override // com.baidu.tieba.ru6.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TbCaptureActivity tbCaptureActivity = this.a;
                tbCaptureActivity.hideLoadingView(tbCaptureActivity.e);
            }
        }

        @Override // com.baidu.tieba.ru6.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                TbCaptureActivity tbCaptureActivity = this.a;
                tbCaptureActivity.showLoadingView(tbCaptureActivity.e);
            }
        }

        @Override // com.baidu.tieba.ru6.a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                VideoFileInfo c = uqa.c(str);
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
                bwa.D(this.a.getPageContext()).l(i);
                this.a.s2();
            }
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void b(MotionEvent motionEvent, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && this.a.G != null) {
                bwa.D(this.a.getPageContext()).c(i, i2, i3, i4);
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
    public class k implements tu6.b {
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

        @Override // com.baidu.tieba.tu6.b
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
                    this.a.y2();
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.tu6.b
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.H != null) {
                    if (ListUtils.isEmpty(this.a.V) && this.a.b0 != null) {
                        this.a.b0.E();
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
                this.b.s2();
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
                this.b.s2();
            }
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.g
        public void c(MotionEvent motionEvent, float f, float f2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, Float.valueOf(f), Float.valueOf(f2)}) == null) && this.b.G != null && !this.b.G.c()) {
                this.b.G.d();
                this.b.s2();
            }
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.g
        public void d(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
                this.b.j2();
                this.b.t2();
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
        public void b(pya pyaVar, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pyaVar, obj) != null) || pyaVar == null) {
                return;
            }
            int type = pyaVar.getType();
            if (type != 2) {
                if (type == 3 && (pyaVar.c() instanceof MusicData)) {
                    MusicData musicData = (MusicData) pyaVar.c();
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
                    this.a.N.d((MusicData) pyaVar.c(), obj);
                }
            } else if (this.a.K != null && (pyaVar.c() instanceof QmFilterItem)) {
                QmFilterItem qmFilterItem = (QmFilterItem) pyaVar.c();
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
    public class o implements tu6.a {
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

        @Override // com.baidu.tieba.tu6.a
        public void onProgress(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && this.a.H != null) {
                this.a.H.setProgress(j);
                if (this.a.H.getProgress() < 3.0f) {
                    return;
                }
                this.a.w2(0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p implements ui6.c {
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

        @Override // com.baidu.tieba.ui6.c
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
                this.a.b0.F();
            }
            return true;
        }
    }

    /* loaded from: classes8.dex */
    public class q implements ui6.b {
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

        @Override // com.baidu.tieba.ui6.b
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
    public class r implements ui6.a {
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

        @Override // com.baidu.tieba.ui6.a
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
                    this.a.w2(8);
                    this.a.A.setVisibility(0);
                    this.a.b0.G();
                    this.a.w.setVisibility(0);
                    this.a.x.setVisibility(0);
                    this.a.J.reset();
                }
                this.a.y2();
                return true;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class s implements zi6 {
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

        @Override // com.baidu.tieba.zi6
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
                    tbCaptureActivity.A2(z);
                }
                return true;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class t implements wi6 {
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

        @Override // com.baidu.tieba.wi6
        public boolean a(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
                if (this.a.G != null && this.a.G.f() != null) {
                    this.a.G.f().a(f);
                    this.a.z2();
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
                qmFilterItem.bgurl = R.drawable.obfuscated_res_0x7f080c50 + "";
                qmFilterItem.name = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f074a);
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
        this.Z = R.drawable.obfuscated_res_0x7f080c33;
        this.a0 = R.drawable.obfuscated_res_0x7f080c34;
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

    public final void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
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

    public final void z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.Z = R.drawable.obfuscated_res_0x7f080c33;
            this.a0 = R.drawable.obfuscated_res_0x7f080c34;
            xi6 xi6Var = this.J;
            if (xi6Var == null) {
                return;
            }
            if (xi6Var.d() == 1.0f) {
                this.Z = R.drawable.obfuscated_res_0x7f080c1c;
                this.a0 = R.drawable.obfuscated_res_0x7f080c1d;
            } else if (this.J.d() == 1.3333334f) {
                this.Z = R.drawable.obfuscated_res_0x7f080c20;
                this.a0 = R.drawable.obfuscated_res_0x7f080c21;
            } else if (this.J.d() == 1.7777778f) {
                this.Z = R.drawable.obfuscated_res_0x7f080c22;
                this.a0 = R.drawable.obfuscated_res_0x7f080c23;
            } else if (this.J.d() == 0.5625f) {
                this.Z = R.drawable.obfuscated_res_0x7f080c1e;
                this.a0 = R.drawable.obfuscated_res_0x7f080c1f;
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
        if (interceptable == null || interceptable.invokeL(1048599, this, view2) == null) {
            super.showLoadingView(view2);
            if (getLoadingView() != null && getLoadingView().getLoadingTextView() != null) {
                getLoadingView().getLoadingTextView().setVisibility(8);
            }
        }
    }

    public final void A2(boolean z) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            aj6 aj6Var = this.I;
            if (aj6Var != null && aj6Var.c()) {
                i2 = R.drawable.obfuscated_res_0x7f080c19;
                i3 = R.drawable.obfuscated_res_0x7f080c1b;
            } else {
                i2 = R.drawable.obfuscated_res_0x7f080c18;
                i3 = R.drawable.obfuscated_res_0x7f080c1a;
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
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    public final void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            aj6 aj6Var = this.I;
            if (aj6Var != null) {
                aj6Var.b(8);
            }
            xi6 xi6Var = this.J;
            if (xi6Var != null) {
                xi6Var.b(8);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.c0 == 1) {
                finish();
            } else {
                i2();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPause();
            tu6 tu6Var = this.G;
            if (tu6Var != null) {
                tu6Var.onPause();
            }
            x37 x37Var = this.N;
            if (x37Var != null) {
                x37Var.onPause();
            }
        }
    }

    public final void t2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            v2();
            u2();
        }
    }

    public final void u2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.j.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c4f));
            this.k.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c52));
        }
    }

    public final void v2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            A2(false);
            z2();
        }
    }

    public final void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ui6 ui6Var = this.H;
            if (ui6Var != null && ui6Var.getProgress() > 0.0f) {
                g55 g55Var = new g55(getPageContext(), new i55(getPageContext().getPageActivity()));
                g55Var.i(null, new String[]{getString(R.string.obfuscated_res_0x7f0f03e0), getResources().getString(R.string.obfuscated_res_0x7f0f11d9)}, new f(this, g55Var));
                g55Var.l();
                return;
            }
            finish();
        }
    }

    public final void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroy();
            tu6 tu6Var = this.G;
            if (tu6Var != null) {
                tu6Var.onDestroy();
            }
            x37 x37Var = this.N;
            if (x37Var != null) {
                x37Var.b();
                this.N.e();
            }
            ru6 ru6Var = this.M;
            if (ru6Var != null) {
                ru6Var.a();
            }
            b47 b47Var = this.L;
            if (b47Var != null) {
                b47Var.onDestroy();
            }
            if (bwa.getContext() == getPageContext()) {
                bwa.D(getPageContext()).release();
            }
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            EMManager.from(this.n).setTextShadow(R.array.S_O_X001);
            EMManager.from(this.o).setTextShadow(R.array.S_O_X001);
            EMManager.from(this.p).setTextShadow(R.array.S_O_X001);
            EMManager.from(this.f1173T).setTextShadow(R.array.S_O_X001);
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
            this.Y.add(getString(R.string.obfuscated_res_0x7f0f0756));
            this.X.put(getString(R.string.obfuscated_res_0x7f0f0756), 300);
            this.Y.add(getString(R.string.obfuscated_res_0x7f0f141e));
            this.X.put(getString(R.string.obfuscated_res_0x7f0f141e), 60);
            this.Y.add(getString(R.string.obfuscated_res_0x7f0f0735));
            this.X.put(getString(R.string.obfuscated_res_0x7f0f0735), 15);
            this.A.setOnItemSelected(new e(this));
            this.A.setData(this.Y);
            this.A.setSelectedPosition(this.Y.size() - 1);
            this.f.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c29));
            A2(false);
            z2();
            this.i.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c24));
            this.j.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c4f));
            this.k.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c52));
            this.l.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c55));
            this.S.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c55));
            this.m.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c49));
            this.a.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c54));
            EMManager.from(this.a).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0302);
            this.O = (WriteImagesInfo) getIntent().getSerializableExtra("write_image_info");
        }
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.e = findViewById(R.id.obfuscated_res_0x7f091fec);
            this.C = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090574);
            this.D = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090562);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f090573);
            this.g = (ImageView) findViewById(R.id.obfuscated_res_0x7f090576);
            this.h = (ImageView) findViewById(R.id.obfuscated_res_0x7f090575);
            this.i = (ImageView) findViewById(R.id.obfuscated_res_0x7f090577);
            this.j = (ImageView) findViewById(R.id.obfuscated_res_0x7f090567);
            this.u = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090568);
            this.k = (ImageView) findViewById(R.id.obfuscated_res_0x7f090569);
            this.v = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09056a);
            this.R = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09056c);
            this.S = (ImageView) findViewById(R.id.obfuscated_res_0x7f09056b);
            this.f1173T = (TextView) findViewById(R.id.obfuscated_res_0x7f090571);
            this.w = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090558);
            this.l = (ImageView) findViewById(R.id.obfuscated_res_0x7f090557);
            this.p = (TextView) findViewById(R.id.obfuscated_res_0x7f09055c);
            this.m = (ImageView) findViewById(R.id.obfuscated_res_0x7f090552);
            this.x = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090553);
            this.n = (TextView) findViewById(R.id.obfuscated_res_0x7f09056f);
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f090570);
            this.q = (TextView) findViewById(R.id.obfuscated_res_0x7f090559);
            this.s = (TextView) findViewById(R.id.obfuscated_res_0x7f09055b);
            this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f09055a);
            this.t = (TextView) findViewById(R.id.obfuscated_res_0x7f09055f);
            this.z = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090556);
            this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f091979);
            this.A = (HorizontalCenterSelectView) findViewById(R.id.obfuscated_res_0x7f091716);
            this.y = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090555);
            this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f0904c9);
            this.Q = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090554);
        }
    }

    public final void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_QM_STICKERS);
            if (a1a.b()) {
                httpMessage.addParam(HttpRequest.UH, DeviceInfoHelper.getManufacturer() + "," + Build.HARDWARE + "," + Build.BOARD + "," + (wqa.b(this) ? 1 : 0));
                httpMessage.addParam("ut", DeviceInfoHelper.getModel() + "_" + DeviceInfoHelper.getOsVersion() + "_" + wqa.a() + "_" + Build.BRAND.replace("_", ""));
            } else {
                httpMessage.addParam(HttpRequest.NEED_DECRYPT, a1a.c());
                String g2 = a1a.g(HttpRequest.UH);
                if (!TextUtils.isEmpty(g2)) {
                    httpMessage.addParam(g2, a1a.a(DeviceInfoHelper.getManufacturer() + "," + Build.HARDWARE + "," + Build.BOARD + "," + (wqa.b(this) ? 1 : 0)));
                }
                String g3 = a1a.g("ut");
                if (!TextUtils.isEmpty(g3)) {
                    httpMessage.addParam(g3, a1a.a(DeviceInfoHelper.getModel() + "_" + DeviceInfoHelper.getOsVersion() + "_" + wqa.a() + "_" + Build.BRAND.replace("_", "")));
                }
            }
            httpMessage.addParam("sdk_version", jf0.h() + "");
            httpMessage.addParam("brand", "baiduar");
            sendMessage(httpMessage);
        }
    }

    public final void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
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

    public final void n2() {
        lc9 lc9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_QM_STICKERS, TbConfig.SERVER_ADDRESS + TbConfig.GET_QM_STICKERS);
            tbHttpMessageTask.setResponsedClass(ResponseGetQmStickersMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_QM_FILTERS, TbConfig.SERVER_ADDRESS + TbConfig.GET_QM_FILTERS);
            tbHttpMessageTask2.setResponsedClass(ResponseGetQmFiltersMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask2);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, lc9.class);
            if (runTask != null) {
                lc9Var = (lc9) runTask.getData();
            } else {
                lc9Var = null;
            }
            if (lc9Var != null) {
                this.F = lc9Var.get();
            }
            hc9 hc9Var = this.F;
            if (hc9Var != null) {
                hc9Var.g();
            }
        }
    }

    public final void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            tu6 tu6Var = this.G;
            if (tu6Var != null && tu6Var.c()) {
                this.G.stopRecord();
                this.C.setVisibility(0);
                this.D.setVisibility(0);
            }
            j2();
            this.V.clear();
            this.H.reset();
            this.A.setSelectedPosition(this.Y.size() - 1);
            this.y.setVisibility(8);
            w2(8);
            if (this.c0 != 1) {
                this.A.setVisibility(0);
            }
            this.w.setVisibility(0);
            this.x.setVisibility(0);
            y2();
            this.I.reset();
            this.J.reset();
            this.K.reset();
            this.L.reset();
            this.N.reset();
            VideoControllerLayout videoControllerLayout = this.b0;
            if (videoControllerLayout != null) {
                videoControllerLayout.G();
                this.b0.y();
            }
            t2();
            hideLoadingView(this.e);
        }
    }

    public final void m2() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            RecordPreviewContainer recordPreviewContainer = (RecordPreviewContainer) findViewById(R.id.obfuscated_res_0x7f090561);
            this.E = recordPreviewContainer;
            if (this.c0 == 1) {
                recordPreviewContainer.setSurfaceView(new PicGLSurfaceView(this));
                z = false;
            } else {
                recordPreviewContainer.setSurfaceView(new AspectGLSurfaceView(this));
                z = true;
            }
            this.G = new uu6(getPageContext(), this.E.getSurfaceView(), z, this.d0, this.e0);
            c47 c47Var = new c47(this.G);
            this.L = c47Var;
            c47Var.c(this.u0);
            this.L.e();
            this.b0 = (VideoControllerLayout) findViewById(R.id.obfuscated_res_0x7f091ec6);
            v37 v37Var = new v37(this.G, null, this.b0);
            this.K = v37Var;
            v37Var.d(this.t0);
            this.K.h();
            nxa recrodButton = this.b0.getRecrodButton();
            TextView recordTimeView = this.b0.getRecordTimeView();
            this.B = recordTimeView;
            vi6 vi6Var = new vi6(recrodButton, recordTimeView, this.f0, this.g0, this.h0);
            this.H = vi6Var;
            vi6Var.setMinDuration(3);
            this.H.setMaxDuration(15);
            this.b0.setDurationManager(this.H);
            this.I = new bj6(getPageContext(), this.i0, null);
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(getPageContext().getPageActivity());
            yi6 yi6Var = new yi6(getPageContext(), BdUtilHelper.getEquipmentHeight(getPageContext().getPageActivity()), equipmentWidth, this.j0);
            this.J = yi6Var;
            yi6Var.c(0);
            this.M = new su6(getPageContext(), new g(this));
            q2();
            p2();
            this.N = new z37(getPageContext(), this.b0);
        }
    }

    public final void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_QM_FILTERS);
            if (a1a.b()) {
                httpMessage.addParam(HttpRequest.UH, DeviceInfoHelper.getManufacturer() + "," + Build.HARDWARE + "," + Build.BOARD + "," + (wqa.b(this) ? 1 : 0));
                httpMessage.addParam("ut", DeviceInfoHelper.getModel() + "_" + DeviceInfoHelper.getOsVersion() + "_" + wqa.a() + "_" + Build.BRAND.replace("_", ""));
            } else {
                httpMessage.addParam(HttpRequest.NEED_DECRYPT, a1a.c());
                String g2 = a1a.g(HttpRequest.UH);
                if (!TextUtils.isEmpty(g2)) {
                    httpMessage.addParam(g2, a1a.a(DeviceInfoHelper.getManufacturer() + "," + Build.HARDWARE + "," + Build.BOARD + "," + (wqa.b(this) ? 1 : 0)));
                }
                String g3 = a1a.g("ut");
                if (!TextUtils.isEmpty(g3)) {
                    httpMessage.addParam(g3, a1a.a(DeviceInfoHelper.getModel() + "_" + DeviceInfoHelper.getOsVersion() + "_" + wqa.a() + "_" + Build.BRAND.replace("_", "")));
                }
            }
            httpMessage.addParam("sdk_version", jf0.h() + "");
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
                            this.b0.z(tbMusicData);
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
                    i3 = R.drawable.obfuscated_res_0x7f080c4c;
                } else {
                    i3 = R.drawable.obfuscated_res_0x7f080c5a;
                }
                imageView.setImageDrawable(resources.getDrawable(i3));
                TextView textView = this.r;
                Resources resources2 = getResources();
                if (this.H.b()) {
                    i4 = R.string.obfuscated_res_0x7f0f054b;
                } else {
                    i4 = R.string.obfuscated_res_0x7f0f1797;
                }
                textView.setText(resources2.getString(i4));
            }
        }
    }

    public final void w2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            ui6 ui6Var = this.H;
            if (ui6Var != null && ui6Var.getProgress() < 3.0f) {
                EMManager.from(this.a).setCorner(R.string.J_X01).setAlpha(R.string.A_X09).setBackGroundColor(R.color.CAM_X0302);
            } else {
                EMManager.from(this.a).setCorner(R.string.J_X01).setAlpha(R.string.A_X01).setBackGroundColor(R.color.CAM_X0302);
            }
            if (this.z.getVisibility() != i2) {
                this.z.setVisibility(i2);
            }
        }
    }

    public final void x2(@RawRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            if (this.d == null) {
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09055e);
                this.d = relativeLayout;
                EMManager.from(relativeLayout).setAlpha(R.string.A_X09).setBackGroundColor(R.color.CAM_X0611);
            }
            if (this.c == null) {
                this.c = (TBLottieAnimationView) findViewById(R.id.obfuscated_res_0x7f09055d);
            }
            this.d.setVisibility(0);
            this.c.setAnimation(i2);
            this.c.loop(true);
            this.c.playAnimation();
            SafeHandler.getInst().postDelayed(new h(this), 3000L);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        ui6.c cVar;
        xi6 xi6Var;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            super.onClick(view2);
            if (view2.getId() == R.id.obfuscated_res_0x7f090573) {
                onBackPressed();
                return;
            }
            int i2 = 8;
            boolean z2 = true;
            if (view2.getId() == R.id.obfuscated_res_0x7f090576) {
                aj6 aj6Var = this.I;
                if (aj6Var != null) {
                    if (aj6Var.a() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    j2();
                    v2();
                    aj6 aj6Var2 = this.I;
                    if (!z) {
                        i2 = 0;
                    }
                    aj6Var2.b(i2);
                    if (this.I.a() != 0) {
                        z2 = false;
                    }
                    A2(z2);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090575) {
                if (ListUtils.isEmpty(this.V) && (xi6Var = this.J) != null) {
                    if (xi6Var.a() != 0) {
                        z2 = false;
                    }
                    j2();
                    v2();
                    if (z2) {
                        this.h.setImageDrawable(getResources().getDrawable(this.Z));
                        this.J.b(8);
                        return;
                    }
                    this.h.setImageDrawable(getResources().getDrawable(this.a0));
                    this.J.b(0);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090577) {
                tu6 tu6Var = this.G;
                if (tu6Var != null) {
                    tu6Var.d();
                }
                if (!SharedPrefHelper.getInstance().getBoolean("key_capture_switch_camera_guide_show", false)) {
                    x2(R.raw.obfuscated_res_0x7f11000a);
                    SharedPrefHelper.getInstance().putBoolean("key_capture_switch_camera_guide_show", true);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090568) {
                if (!SharedPrefHelper.getInstance().getBoolean("key_capture_filter_guide_show", false)) {
                    x2(R.raw.obfuscated_res_0x7f11000b);
                    SharedPrefHelper.getInstance().putBoolean("key_capture_filter_guide_show", true);
                }
                u2();
                if (this.b0.q()) {
                    this.j.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c4f));
                } else {
                    this.j.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c51));
                }
                this.b0.v();
                if (this.b0.s()) {
                    p2();
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09056a) {
                if (ListUtils.isEmpty(this.V)) {
                    u2();
                    if (this.b0.r()) {
                        this.k.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c52));
                    } else {
                        this.k.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c53));
                    }
                    this.b0.w();
                }
            } else if (view2.getId() != R.id.obfuscated_res_0x7f090558 && view2.getId() != R.id.obfuscated_res_0x7f09056c) {
                if (view2.getId() == R.id.obfuscated_res_0x7f090553) {
                    u2();
                    o2();
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090555) {
                    ui6 ui6Var = this.H;
                    if (ui6Var != null) {
                        if (ui6Var.b()) {
                            this.H.a();
                            this.b.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c5a));
                            this.r.setText(getResources().getString(R.string.obfuscated_res_0x7f0f1797));
                            return;
                        }
                        this.H.setShowDeleteLastTip(true);
                        this.b.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c4c));
                        this.r.setText(getResources().getString(R.string.obfuscated_res_0x7f0f054b));
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090556 && (cVar = this.f0) != null) {
                    cVar.onFinished();
                }
            } else {
                u2();
                this.b0.x();
                if (this.b0.u()) {
                    q2();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0030);
            if (Build.VERSION.SDK_INT >= 28 && RomTypeUtil.isOPPO() && TbSingleton.getInstance().isCutoutScreen(this)) {
                qqa.b(1, getWindow().getAttributes(), getWindow());
            }
            setSwipeBackEnabled(false);
            n2();
            if (getIntent() != null) {
                this.c0 = getIntent().getIntExtra(TbCaptureActivityConfig.CAPTURE_TYPE, -1);
            }
            m2();
            initView();
            k2();
            initData();
            l2();
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
            tu6 tu6Var = this.G;
            if (tu6Var != null) {
                tu6Var.onResume();
            }
            x37 x37Var = this.N;
            if (x37Var != null) {
                x37Var.onResume();
            }
            b47 b47Var = this.L;
            if (b47Var != null) {
                b47Var.e();
            }
            w37 w37Var = this.K;
            if (w37Var != null) {
                w37Var.h();
            }
        }
    }

    public final void s2() {
        ui6 ui6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (ui6Var = this.H) != null) {
            ui6Var.setShowDeleteLastTip(false);
            this.b.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c5a));
            this.r.setText(getResources().getString(R.string.obfuscated_res_0x7f0f1797));
        }
    }

    public final void y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (!ListUtils.isEmpty(this.V)) {
                this.h.setAlpha(SkinManager.RESOURCE_ALPHA_DISABLE);
                this.v.setAlpha(SkinManager.RESOURCE_ALPHA_DISABLE);
                return;
            }
            this.h.setAlpha(1.0f);
            this.v.setAlpha(1.0f);
        }
    }
}
