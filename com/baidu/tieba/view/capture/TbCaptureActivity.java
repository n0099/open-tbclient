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
import com.baidu.tieba.bx4;
import com.baidu.tieba.cu8;
import com.baidu.tieba.cz8;
import com.baidu.tieba.dh;
import com.baidu.tieba.du8;
import com.baidu.tieba.external.filter.ResponseGetQmFiltersMessage;
import com.baidu.tieba.external.music.data.MusicData;
import com.baidu.tieba.external.sticker.ResponseGetQmStickersMessage;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.gh;
import com.baidu.tieba.gj;
import com.baidu.tieba.he0;
import com.baidu.tieba.ju4;
import com.baidu.tieba.l06;
import com.baidu.tieba.lu4;
import com.baidu.tieba.m06;
import com.baidu.tieba.n06;
import com.baidu.tieba.o06;
import com.baidu.tieba.p06;
import com.baidu.tieba.q06;
import com.baidu.tieba.qz8;
import com.baidu.tieba.r06;
import com.baidu.tieba.rb6;
import com.baidu.tieba.s06;
import com.baidu.tieba.s09;
import com.baidu.tieba.s36;
import com.baidu.tieba.sb6;
import com.baidu.tieba.tb6;
import com.baidu.tieba.u36;
import com.baidu.tieba.uo7;
import com.baidu.tieba.uu4;
import com.baidu.tieba.v36;
import com.baidu.tieba.vb6;
import com.baidu.tieba.view.widget.HorizontalCenterSelectView;
import com.baidu.tieba.view.widget.RecordPreviewContainer;
import com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout;
import com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout;
import com.baidu.tieba.w36;
import com.baidu.tieba.xb6;
import com.baidu.tieba.yb6;
import com.baidu.tieba.yo7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class TbCaptureActivity extends BaseActivity<TbCaptureActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HorizontalCenterSelectView A;
    public TextView B;
    public RelativeLayout C;
    public LinearLayout D;
    public RecordPreviewContainer E;
    public uo7 F;
    public v36 G;
    public l06 H;
    public r06 I;
    public o06 J;
    public sb6 K;
    public xb6 L;
    public s36 M;
    public tb6 N;
    public TbMusicData O;
    public ArrayList<String> P;
    public boolean Q;
    public Map<String, Integer> R;
    public List<String> S;
    public int T;
    public int U;
    public VideoControllerLayout V;
    public v36.b W;
    public v36.a X;
    public l06.c Y;
    public l06.b Z;
    public ImageView a;
    public l06.a a0;
    public ImageView b;
    public q06 b0;
    public TBLottieAnimationView c;
    public n06 c0;
    public RelativeLayout d;
    public HttpMessageListener d0;
    public View e;
    public HttpMessageListener e0;
    public ImageView f;
    public rb6.b f0;
    public ImageView g;
    public yb6.b g0;
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

    /* loaded from: classes6.dex */
    public class a implements rb6.b {
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

        @Override // com.baidu.tieba.rb6.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.V != null) {
                    QmFilterItem qmFilterItem = new QmFilterItem();
                    qmFilterItem.id = "-1";
                    qmFilterItem.bgurl = R.drawable.obfuscated_res_0x7f080a39 + "";
                    qmFilterItem.name = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f063a);
                    qmFilterItem.isSelect = true;
                    qmFilterItem.localPath = "origin";
                    this.a.V.z(qmFilterItem);
                    if (this.a.K != null) {
                        this.a.K.a(null);
                    }
                    this.a.V.setDownLoadFilter(null);
                }
                if (StringUtils.isNull(str)) {
                    str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1215);
                }
                this.a.showToast(str);
                this.a.F.b(5, str);
            }
        }

        @Override // com.baidu.tieba.rb6.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.V == null) {
                return;
            }
            this.a.V.setDownLoadFilter(null);
        }

        @Override // com.baidu.tieba.rb6.b
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

    /* loaded from: classes6.dex */
    public class b implements yb6.b {
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

        @Override // com.baidu.tieba.yb6.b
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
                    str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1215);
                }
                this.a.showToast(str);
                this.a.F.b(5, str);
            }
        }

        @Override // com.baidu.tieba.yb6.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.V == null) {
                return;
            }
            this.a.V.setDownLoadSticker(null, false);
        }

        @Override // com.baidu.tieba.yb6.b
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class d implements lu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ju4 a;
        public final /* synthetic */ TbCaptureActivity b;

        public d(TbCaptureActivity tbCaptureActivity, ju4 ju4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbCaptureActivity, ju4Var};
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
            this.a = ju4Var;
        }

        @Override // com.baidu.tieba.lu4.e
        public void n0(lu4 lu4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lu4Var, i, view2) == null) {
                if (i == 0) {
                    this.b.s2();
                    this.a.dismiss();
                } else if (i == 1) {
                    this.b.finish();
                } else {
                    this.a.dismiss();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements s36.a {
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

        @Override // com.baidu.tieba.s36.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TbCaptureActivity tbCaptureActivity = this.a;
                tbCaptureActivity.hideLoadingView(tbCaptureActivity.e);
            }
        }

        @Override // com.baidu.tieba.s36.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                TbCaptureActivity tbCaptureActivity = this.a;
                tbCaptureActivity.showLoadingView(tbCaptureActivity.e);
            }
        }

        @Override // com.baidu.tieba.s36.a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                VideoFileInfo c = cu8.c(str);
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

    /* loaded from: classes6.dex */
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
        public void b(s09 s09Var, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s09Var, obj) == null) || s09Var == null) {
                return;
            }
            int type = s09Var.getType();
            if (type == 2) {
                if (this.a.K != null && (s09Var.c() instanceof QmFilterItem)) {
                    QmFilterItem qmFilterItem = (QmFilterItem) s09Var.c();
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
            } else if (type == 3 && (s09Var.c() instanceof MusicData)) {
                MusicData musicData = (MusicData) s09Var.c();
                TbMusicData tbMusicData = new TbMusicData();
                tbMusicData.id = musicData.id;
                tbMusicData.title = musicData.name;
                tbMusicData.url = musicData.resource;
                tbMusicData.icon = musicData.img;
                tbMusicData.type = dh.e(musicData.type, 1);
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
                this.a.N.c((MusicData) s09Var.c(), obj);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                    this.a.x2(0);
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
                this.a.x2(8);
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.A.setVisibility(8);
                this.a.w.setVisibility(8);
                this.a.x.setVisibility(8);
                this.a.y.setVisibility(8);
                this.a.x2(8);
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void m() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.G == null) {
                return;
            }
            this.a.G.stopRecord();
            this.a.C.setVisibility(0);
            this.a.D.setVisibility(0);
            this.a.y.setVisibility(0);
            this.a.x2(0);
            this.a.w.setVisibility(0);
            if (this.a.N != null) {
                this.a.N.pause();
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void o() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.A.setVisibility(8);
                this.a.w.setVisibility(8);
                this.a.x.setVisibility(8);
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void p() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout.e
        public void r() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.a.H == null) {
                return;
            }
            if (this.a.H.getProgress() < this.a.H.getMaxDuration()) {
                this.a.G.startRecord();
                this.a.C.setVisibility(8);
                this.a.D.setVisibility(8);
                this.a.k2();
                this.a.u2();
                this.a.y.setVisibility(8);
                if (this.a.H.getProgress() < 3.0f) {
                    this.a.x2(8);
                } else {
                    this.a.x2(0);
                }
                this.a.w.setVisibility(8);
                this.a.t2();
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
            cz8.D(this.a.getPageContext()).l(i);
            this.a.t2();
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.e
        public void b(MotionEvent motionEvent, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || this.a.G == null) {
                return;
            }
            cz8.D(this.a.getPageContext()).c(i, i2, i3, i4);
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements v36.b {
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

        @Override // com.baidu.tieba.v36.b
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
                    this.a.z2();
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.v36.b
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
            this.b.t2();
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
            this.b.t2();
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void c(MotionEvent motionEvent, float f, float f2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, Float.valueOf(f), Float.valueOf(f2)}) == null) || this.b.G == null || this.b.G.c()) {
                return;
            }
            this.b.G.d();
            this.b.t2();
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void d(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
                this.b.k2();
                this.b.u2();
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

    /* loaded from: classes6.dex */
    public class n implements v36.a {
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

        @Override // com.baidu.tieba.v36.a
        public void onProgress(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048576, this, j) == null) || this.a.H == null) {
                return;
            }
            this.a.H.setProgress(j);
            if (this.a.H.getProgress() >= 3.0f) {
                this.a.x2(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements l06.c {
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

        @Override // com.baidu.tieba.l06.c
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

    /* loaded from: classes6.dex */
    public class p implements l06.b {
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

        @Override // com.baidu.tieba.l06.b
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

    /* loaded from: classes6.dex */
    public class q implements l06.a {
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

        @Override // com.baidu.tieba.l06.a
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
                    this.a.x2(8);
                    this.a.A.setVisibility(0);
                    this.a.V.F();
                    this.a.w.setVisibility(0);
                    this.a.x.setVisibility(0);
                }
                this.a.z2();
                return true;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class r implements q06 {
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

        @Override // com.baidu.tieba.q06
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
                    tbCaptureActivity.B2(tbCaptureActivity.I.a() == 0);
                }
                return true;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class s implements n06 {
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

        @Override // com.baidu.tieba.n06
        public boolean a(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
                if (this.a.G == null || this.a.G.f() == null) {
                    return false;
                }
                this.a.G.f().a(f);
                this.a.A2();
                return true;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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
                    qmFilterItem.bgurl = R.drawable.obfuscated_res_0x7f080a39 + "";
                    qmFilterItem.name = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f063a);
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
        this.T = R.drawable.obfuscated_res_0x7f080a1c;
        this.U = R.drawable.obfuscated_res_0x7f080a1d;
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
            this.T = R.drawable.obfuscated_res_0x7f080a1c;
            this.U = R.drawable.obfuscated_res_0x7f080a1d;
            o06 o06Var = this.J;
            if (o06Var == null) {
                return;
            }
            if (o06Var.d() == 1.0f) {
                this.T = R.drawable.obfuscated_res_0x7f080a04;
                this.U = R.drawable.obfuscated_res_0x7f080a05;
            } else if (this.J.d() == 1.3333334f) {
                this.T = R.drawable.obfuscated_res_0x7f080a08;
                this.U = R.drawable.obfuscated_res_0x7f080a09;
            } else if (this.J.d() == 1.7777778f) {
                this.T = R.drawable.obfuscated_res_0x7f080a0a;
                this.U = R.drawable.obfuscated_res_0x7f080a0b;
            } else if (this.J.d() == 0.5625f) {
                this.T = R.drawable.obfuscated_res_0x7f080a06;
                this.U = R.drawable.obfuscated_res_0x7f080a07;
            }
            if (this.J.a() == 0) {
                this.h.setImageDrawable(getResources().getDrawable(this.U));
            } else {
                this.h.setImageDrawable(getResources().getDrawable(this.T));
            }
        }
    }

    public final void B2(boolean z) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            r06 r06Var = this.I;
            if (r06Var == null || !r06Var.c()) {
                i2 = R.drawable.obfuscated_res_0x7f080a00;
                i3 = R.drawable.obfuscated_res_0x7f080a02;
            } else {
                i2 = R.drawable.obfuscated_res_0x7f080a01;
                i3 = R.drawable.obfuscated_res_0x7f080a03;
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
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    public final void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            l06 l06Var = this.H;
            if (l06Var != null && l06Var.getProgress() > 0.0f) {
                ju4 ju4Var = new ju4(getPageContext(), new lu4(getPageContext().getPageActivity()));
                ju4Var.i(null, new String[]{getString(R.string.obfuscated_res_0x7f0f0385), getResources().getString(R.string.obfuscated_res_0x7f0f0f96)}, new d(this, ju4Var));
                ju4Var.k();
                return;
            }
            finish();
        }
    }

    public final void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            r06 r06Var = this.I;
            if (r06Var != null) {
                r06Var.b(8);
            }
            o06 o06Var = this.J;
            if (o06Var != null) {
                o06Var.b(8);
            }
        }
    }

    public final void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            registerListener(this.d0);
            registerListener(this.e0);
            registerListener(this.h0);
            this.E.setOnPreviewStateChangedListener(new j(this));
            this.E.setOnViewClickListener(new m(this, new l(this)));
        }
    }

    public final void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.E = (RecordPreviewContainer) findViewById(R.id.obfuscated_res_0x7f0904b6);
            this.G = new w36(getPageContext(), this.E.getSurfaceView(), true, this.W, this.X);
            yb6 yb6Var = new yb6(this.G);
            this.L = yb6Var;
            yb6Var.c(this.g0);
            this.L.e();
            this.V = (VideoControllerLayout) findViewById(R.id.obfuscated_res_0x7f091bab);
            rb6 rb6Var = new rb6(this.G, null, this.V);
            this.K = rb6Var;
            rb6Var.d(this.f0);
            this.K.h();
            qz8 recrodButton = this.V.getRecrodButton();
            TextView recordTimeView = this.V.getRecordTimeView();
            this.B = recordTimeView;
            m06 m06Var = new m06(recrodButton, recordTimeView, this.Y, this.Z, this.a0);
            this.H = m06Var;
            m06Var.setMinDuration(3);
            this.H.setMaxDuration(15);
            this.V.setDurationManager(this.H);
            this.I = new s06(getPageContext(), this.b0, null);
            p06 p06Var = new p06(getPageContext(), this.c0);
            this.J = p06Var;
            p06Var.c(0);
            this.M = new u36(getPageContext(), new e(this));
            r2();
            q2();
        }
    }

    public final void n2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_QM_STICKERS, TbConfig.SERVER_ADDRESS + TbConfig.GET_QM_STICKERS);
            tbHttpMessageTask.setResponsedClass(ResponseGetQmStickersMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_QM_FILTERS, TbConfig.SERVER_ADDRESS + TbConfig.GET_QM_FILTERS);
            tbHttpMessageTask2.setResponsedClass(ResponseGetQmFiltersMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask2);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, yo7.class);
            yo7 yo7Var = runTask != null ? (yo7) runTask.getData() : null;
            if (yo7Var != null) {
                this.F = yo7Var.get();
            }
            uo7 uo7Var = this.F;
            if (uo7Var != null) {
                uo7Var.g();
            }
        }
    }

    public final void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.e = findViewById(R.id.obfuscated_res_0x7f091c81);
            this.C = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0904c7);
            this.D = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0904b7);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f0904c6);
            this.f = imageView;
            imageView.setOnClickListener(this);
            ImageView imageView2 = (ImageView) findViewById(R.id.obfuscated_res_0x7f0904c9);
            this.g = imageView2;
            imageView2.setOnClickListener(this);
            ImageView imageView3 = (ImageView) findViewById(R.id.obfuscated_res_0x7f0904c8);
            this.h = imageView3;
            imageView3.setOnClickListener(this);
            ImageView imageView4 = (ImageView) findViewById(R.id.obfuscated_res_0x7f0904ca);
            this.i = imageView4;
            imageView4.setOnClickListener(this);
            this.j = (ImageView) findViewById(R.id.obfuscated_res_0x7f0904bc);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0904bd);
            this.u = relativeLayout;
            relativeLayout.setOnClickListener(this);
            this.k = (ImageView) findViewById(R.id.obfuscated_res_0x7f0904be);
            RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0904bf);
            this.v = relativeLayout2;
            relativeLayout2.setOnClickListener(this);
            this.l = (ImageView) findViewById(R.id.obfuscated_res_0x7f0904ac);
            RelativeLayout relativeLayout3 = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0904ad);
            this.w = relativeLayout3;
            relativeLayout3.setOnClickListener(this);
            this.m = (ImageView) findViewById(R.id.obfuscated_res_0x7f0904a8);
            RelativeLayout relativeLayout4 = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0904a9);
            this.x = relativeLayout4;
            relativeLayout4.setOnClickListener(this);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0904c2);
            this.n = textView;
            uu4.d(textView).y(R.array.S_O_X001);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f0904c3);
            this.o = textView2;
            uu4.d(textView2).y(R.array.S_O_X001);
            TextView textView3 = (TextView) findViewById(R.id.obfuscated_res_0x7f0904b1);
            this.p = textView3;
            uu4.d(textView3).y(R.array.S_O_X001);
            TextView textView4 = (TextView) findViewById(R.id.obfuscated_res_0x7f0904ae);
            this.q = textView4;
            uu4.d(textView4).y(R.array.S_O_X001);
            TextView textView5 = (TextView) findViewById(R.id.obfuscated_res_0x7f0904b0);
            this.s = textView5;
            uu4.d(textView5).y(R.array.S_O_X001);
            TextView textView6 = (TextView) findViewById(R.id.obfuscated_res_0x7f0904af);
            this.r = textView6;
            uu4.d(textView6).y(R.array.S_O_X001);
            TextView textView7 = (TextView) findViewById(R.id.obfuscated_res_0x7f0904b4);
            this.t = textView7;
            uu4 d2 = uu4.d(textView7);
            d2.A(R.string.F_X02);
            d2.y(R.array.S_O_X001);
            this.V.setRecordManager(this.G);
            this.V.setEffectChoosedListener(new f(this));
            this.V.setRecordControlListener(new g(this));
            vb6 vb6Var = new vb6(getPageContext(), this.V);
            this.N = vb6Var;
            this.V.setMusicManager(vb6Var);
            RelativeLayout relativeLayout5 = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0904ab);
            this.z = relativeLayout5;
            relativeLayout5.setOnClickListener(this);
            this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f0916b7);
            HorizontalCenterSelectView horizontalCenterSelectView = (HorizontalCenterSelectView) findViewById(R.id.obfuscated_res_0x7f0914ce);
            this.A = horizontalCenterSelectView;
            horizontalCenterSelectView.setItemTextPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X012));
            this.A.setItemTextSize(UtilHelper.getDimenPixelSize(R.dimen.T_X05));
            this.A.setItemTextColor(getPageContext().getPageActivity().getResources().getColor(R.color.CAM_X0101));
            this.S = new ArrayList();
            this.R = new HashMap();
            this.S.add(getString(R.string.obfuscated_res_0x7f0f0646));
            this.R.put(getString(R.string.obfuscated_res_0x7f0f0646), 300);
            this.S.add(getString(R.string.obfuscated_res_0x7f0f11c0));
            this.R.put(getString(R.string.obfuscated_res_0x7f0f11c0), 60);
            this.S.add(getString(R.string.obfuscated_res_0x7f0f0625));
            this.R.put(getString(R.string.obfuscated_res_0x7f0f0625), 15);
            this.A.setOnItemSelected(new h(this));
            this.A.setData(this.S);
            this.A.setSelectedPosition(this.S.size() - 1);
            RelativeLayout relativeLayout6 = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0904aa);
            this.y = relativeLayout6;
            relativeLayout6.setOnClickListener(this);
            this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f090433);
            this.f.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a11));
            B2(false);
            A2();
            this.i.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a0c));
            this.j.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a38));
            this.k.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a3b));
            this.l.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a3e));
            this.m.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a32));
            this.a.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a3d));
            uu4 d3 = uu4.d(this.a);
            d3.n(R.string.J_X01);
            d3.f(R.color.CAM_X0302);
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
            j2();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.H != null) {
                this.b.setImageDrawable(getResources().getDrawable(this.H.b() ? R.drawable.obfuscated_res_0x7f080a35 : R.drawable.obfuscated_res_0x7f080a43));
                this.r.setText(getResources().getString(this.H.b() ? R.string.obfuscated_res_0x7f0f04b0 : R.string.obfuscated_res_0x7f0f14c0));
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        l06.c cVar;
        o06 o06Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            super.onClick(view2);
            if (view2.getId() == R.id.obfuscated_res_0x7f0904c6) {
                onBackPressed();
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f0904c9) {
                r06 r06Var = this.I;
                if (r06Var != null) {
                    boolean z = r06Var.a() == 0;
                    k2();
                    w2();
                    this.I.b(z ? 8 : 0);
                    B2(this.I.a() == 0);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0904c8) {
                if (!ListUtils.isEmpty(this.P) || (o06Var = this.J) == null) {
                    return;
                }
                boolean z2 = o06Var.a() == 0;
                k2();
                w2();
                if (z2) {
                    this.h.setImageDrawable(getResources().getDrawable(this.T));
                    this.J.b(8);
                    return;
                }
                this.h.setImageDrawable(getResources().getDrawable(this.U));
                this.J.b(0);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0904ca) {
                v36 v36Var = this.G;
                if (v36Var != null) {
                    v36Var.d();
                }
                if (bx4.k().h("key_capture_switch_camera_guide_show", false)) {
                    return;
                }
                y2(R.raw.obfuscated_res_0x7f11000a);
                bx4.k().u("key_capture_switch_camera_guide_show", true);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0904bd) {
                if (!bx4.k().h("key_capture_filter_guide_show", false)) {
                    y2(R.raw.obfuscated_res_0x7f11000b);
                    bx4.k().u("key_capture_filter_guide_show", true);
                }
                v2();
                if (this.V.q()) {
                    this.j.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a38));
                } else {
                    this.j.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a3a));
                }
                this.V.v();
                if (this.V.t()) {
                    q2();
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0904bf) {
                if (ListUtils.isEmpty(this.P)) {
                    v2();
                    if (this.V.s()) {
                        this.k.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a3b));
                    } else {
                        this.k.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a3c));
                    }
                    this.V.w();
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0904ad) {
                v2();
                this.V.x();
                if (this.V.u()) {
                    r2();
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0904a9) {
                v2();
                p2();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0904aa) {
                l06 l06Var = this.H;
                if (l06Var != null) {
                    if (l06Var.b()) {
                        this.H.a();
                        this.b.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a43));
                        this.r.setText(getResources().getString(R.string.obfuscated_res_0x7f0f14c0));
                        return;
                    }
                    this.H.setShowDeleteLastTip(true);
                    this.b.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a35));
                    this.r.setText(getResources().getString(R.string.obfuscated_res_0x7f0f04b0));
                }
            } else if (view2.getId() != R.id.obfuscated_res_0x7f0904ab || (cVar = this.Y) == null) {
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
            n2();
            m2();
            o2();
            l2();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            v36 v36Var = this.G;
            if (v36Var != null) {
                v36Var.onDestroy();
            }
            tb6 tb6Var = this.N;
            if (tb6Var != null) {
                tb6Var.releasePlayer();
                this.N.d();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onPause();
            v36 v36Var = this.G;
            if (v36Var != null) {
                v36Var.onPause();
            }
            tb6 tb6Var = this.N;
            if (tb6Var != null) {
                tb6Var.onPause();
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
            v36 v36Var = this.G;
            if (v36Var != null) {
                v36Var.onResume();
            }
            tb6 tb6Var = this.N;
            if (tb6Var != null) {
                tb6Var.onResume();
            }
            xb6 xb6Var = this.L;
            if (xb6Var != null) {
                xb6Var.e();
            }
            sb6 sb6Var = this.K;
            if (sb6Var != null) {
                sb6Var.h();
            }
        }
    }

    public final void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
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

    public final void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_QM_FILTERS);
            httpMessage.addParam("uh", gj.f() + "," + Build.HARDWARE + "," + Build.BOARD + "," + (du8.b(this) ? 1 : 0));
            httpMessage.addParam("ut", gj.g() + "_" + gj.k() + "_" + du8.a() + "_" + Build.BRAND.replace("_", ""));
            StringBuilder sb = new StringBuilder();
            sb.append(he0.h());
            sb.append("");
            httpMessage.addParam("sdk_version", sb.toString());
            sendMessage(httpMessage);
        }
    }

    public final void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_QM_STICKERS);
            httpMessage.addParam("uh", gj.f() + "," + Build.HARDWARE + "," + Build.BOARD + "," + (du8.b(this) ? 1 : 0));
            httpMessage.addParam("ut", gj.g() + "_" + gj.k() + "_" + du8.a() + "_" + Build.BRAND.replace("_", ""));
            StringBuilder sb = new StringBuilder();
            sb.append(he0.h());
            sb.append("");
            httpMessage.addParam("sdk_version", sb.toString());
            httpMessage.addParam(com.xiaomi.mipush.sdk.Constants.PHONE_BRAND, "baiduar");
            sendMessage(httpMessage);
        }
    }

    public final void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            v36 v36Var = this.G;
            if (v36Var != null && v36Var.c()) {
                this.G.stopRecord();
                this.C.setVisibility(0);
                this.D.setVisibility(0);
            }
            k2();
            this.P.clear();
            this.H.reset();
            this.A.setSelectedPosition(this.S.size() - 1);
            this.y.setVisibility(8);
            x2(8);
            this.A.setVisibility(0);
            this.V.F();
            this.w.setVisibility(0);
            this.x.setVisibility(0);
            z2();
            this.I.reset();
            this.J.reset();
            this.K.reset();
            this.L.reset();
            this.N.reset();
            u2();
            hideLoadingView(this.e);
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
        l06 l06Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (l06Var = this.H) == null) {
            return;
        }
        l06Var.setShowDeleteLastTip(false);
        this.b.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a43));
        this.r.setText(getResources().getString(R.string.obfuscated_res_0x7f0f14c0));
    }

    public final void u2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            w2();
            v2();
        }
    }

    public final void v2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.j.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a38));
            this.k.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a3b));
        }
    }

    public final void w2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            B2(false);
            A2();
        }
    }

    public final void x2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            l06 l06Var = this.H;
            if (l06Var != null && l06Var.getProgress() < 3.0f) {
                uu4 d2 = uu4.d(this.a);
                d2.n(R.string.J_X01);
                d2.e(R.string.A_X09);
                d2.f(R.color.CAM_X0302);
            } else {
                uu4 d3 = uu4.d(this.a);
                d3.n(R.string.J_X01);
                d3.e(R.string.A_X01);
                d3.f(R.color.CAM_X0302);
            }
            if (this.z.getVisibility() != i2) {
                this.z.setVisibility(i2);
            }
        }
    }

    public final void y2(@RawRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            if (this.d == null) {
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0904b3);
                this.d = relativeLayout;
                uu4 d2 = uu4.d(relativeLayout);
                d2.e(R.string.A_X09);
                d2.f(R.color.CAM_X0611);
            }
            if (this.c == null) {
                this.c = (TBLottieAnimationView) findViewById(R.id.obfuscated_res_0x7f0904b2);
            }
            this.d.setVisibility(0);
            this.c.setAnimation(i2);
            this.c.loop(true);
            this.c.playAnimation();
            gh.a().postDelayed(new i(this), 3000L);
        }
    }

    public final void z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (!ListUtils.isEmpty(this.P)) {
                this.h.setAlpha(SkinManager.RESOURCE_ALPHA_DISABLE);
                this.v.setAlpha(SkinManager.RESOURCE_ALPHA_DISABLE);
                return;
            }
            this.h.setAlpha(1.0f);
            this.v.setAlpha(1.0f);
        }
    }
}
