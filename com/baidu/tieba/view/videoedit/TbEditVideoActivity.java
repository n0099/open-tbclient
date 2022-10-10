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
import androidx.constraintlayout.motion.widget.Key;
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
import com.baidu.bdtask.model.response.TaskResponseData;
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
import com.baidu.tbadk.core.atomData.WorkPublishManager;
import com.baidu.tbadk.core.atomData.WorkPublishOpenHelper;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.PostPrefixData;
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
import com.baidu.tieba.c46;
import com.baidu.tieba.cv8;
import com.baidu.tieba.d46;
import com.baidu.tieba.dh;
import com.baidu.tieba.ec6;
import com.baidu.tieba.ej;
import com.baidu.tieba.external.filter.ResponseGetQmFiltersMessage;
import com.baidu.tieba.external.filter.TbFilterValue;
import com.baidu.tieba.external.music.data.MusicData;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
import com.baidu.tieba.f46;
import com.baidu.tieba.fc6;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.g46;
import com.baidu.tieba.gc6;
import com.baidu.tieba.gh;
import com.baidu.tieba.gj;
import com.baidu.tieba.h19;
import com.baidu.tieba.h46;
import com.baidu.tieba.hv4;
import com.baidu.tieba.ic6;
import com.baidu.tieba.ox4;
import com.baidu.tieba.ri5;
import com.baidu.tieba.ru8;
import com.baidu.tieba.sb6;
import com.baidu.tieba.su8;
import com.baidu.tieba.tb6;
import com.baidu.tieba.ue0;
import com.baidu.tieba.vb6;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.tieba.view.widget.RecordPreviewContainer;
import com.baidu.tieba.view.widget.TbGLMediaPreviewView;
import com.baidu.tieba.view.widget.pickcover.PreViewPickCoverView;
import com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout;
import com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout;
import com.baidu.tieba.vu8;
import com.baidu.tieba.wu4;
import com.baidu.tieba.x36;
import com.baidu.tieba.yu4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidubce.auth.NTLMEngineImpl;
import com.google.protobuf.CodedInputStream;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class TbEditVideoActivity extends BaseActivity<TbEditVideoActivity> implements tb6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VideoInfo A;
    public float B;
    public String C;
    public String D;
    public float E;
    public boolean F;
    public boolean G;
    public int H;
    public boolean I;
    public TbMusicData J;
    public TbMusicData K;
    public int L;
    public float M;
    public float N;
    public f46.a O;
    public Runnable P;
    public RecordPreviewContainer.f Q;
    public HttpMessageListener R;
    public ec6.b S;
    public RecordEffectLayout.i T;
    @NonNull
    public final ri5 U;
    public NavigationBar a;
    public TextView b;
    public TextView c;
    public View d;
    public ViewGroup e;
    public ImageView f;
    public ImageView g;
    public TextView h;
    public TextView i;
    public PreViewPickCoverView j;
    public TbGLMediaPreviewView k;
    public LinearLayout l;
    public RelativeLayout m;
    public RecordPreviewContainer n;
    public RelativeLayout o;
    public RelativeLayout p;
    public RelativeLayout q;
    public RelativeLayout r;
    public VideoControllerLayout s;
    public c46 t;
    public gc6 u;
    public fc6 v;
    public f46 w;
    public sb6 x;
    public boolean y;
    public TbMultiMediaData z;

    /* loaded from: classes6.dex */
    public class a implements c46.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        public a(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // com.baidu.tieba.c46.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tieba.c46.a
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.u == null) {
                return;
            }
            this.a.u.a(0.0f);
        }

        @Override // com.baidu.tieba.c46.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a.H != 1) {
                    this.a.t2();
                }
                this.a.U.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements yu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wu4 a;
        public final /* synthetic */ TbEditVideoActivity b;

        public b(TbEditVideoActivity tbEditVideoActivity, wu4 wu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity, wu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tbEditVideoActivity;
            this.a = wu4Var;
        }

        @Override // com.baidu.tieba.yu4.e
        public void n0(yu4 yu4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, yu4Var, i, view2) == null) {
                if (i == 0) {
                    this.b.finish();
                } else {
                    this.a.dismiss();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        public c(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.t != null) {
                    this.a.t.start();
                }
                if (this.a.u != null) {
                    this.a.u.onResume();
                    if (this.a.t != null) {
                        this.a.u.a(((float) this.a.t.getCurrentPlayTime()) / 1000.0f);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        public d(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j.setVisibility(0);
                int height = this.a.a.getHeight();
                int height2 = this.a.j.getHeight();
                int i = ej.i(this.a.getPageContext().getPageActivity());
                float k = ej.k(this.a.getPageContext().getPageActivity()) * this.a.B;
                this.a.M = (i - height) - height2;
                float k2 = (this.a.M * 1.0f) / ej.k(this.a.getPageContext().getPageActivity());
                TbEditVideoActivity tbEditVideoActivity = this.a;
                tbEditVideoActivity.N = height - ((i - tbEditVideoActivity.M) * 0.5f);
                this.a.n.setTranslationY(this.a.N);
                if (this.a.B > k2) {
                    this.a.k.setScaleX(this.a.M / k);
                    this.a.k.setScaleY(this.a.M / k);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        /* loaded from: classes6.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    this.a.a.j.setVisibility(0);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ float a;
            public final /* synthetic */ e b;

            public b(e eVar, float f) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, Float.valueOf(f)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = eVar;
                this.a = f;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    this.b.a.k.setScaleX(floatValue / this.a);
                    this.b.a.k.setScaleY(floatValue / this.a);
                }
            }
        }

        public e(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a.j, Key.TRANSLATION_Y, this.a.j.getHeight(), 0.0f);
                ofFloat.setDuration(250L);
                ofFloat.addListener(new a(this));
                int height = this.a.a.getHeight();
                int height2 = this.a.j.getHeight();
                int i = ej.i(this.a.getPageContext().getPageActivity());
                float k = ej.k(this.a.getPageContext().getPageActivity()) * this.a.B;
                this.a.M = (i - height) - height2;
                float k2 = (this.a.M * 1.0f) / ej.k(this.a.getPageContext().getPageActivity());
                TbEditVideoActivity tbEditVideoActivity = this.a;
                tbEditVideoActivity.N = height - ((i - tbEditVideoActivity.M) * 0.5f);
                ObjectAnimator duration = ObjectAnimator.ofFloat(this.a.n, Key.TRANSLATION_Y, 0.0f, this.a.N).setDuration(250L);
                if (this.a.B > k2) {
                    ValueAnimator ofFloat2 = ValueAnimator.ofFloat(k, this.a.M);
                    ofFloat2.addUpdateListener(new b(this, k));
                    ofFloat2.setDuration(250L);
                    ofFloat2.start();
                }
                ofFloat.start();
                duration.start();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        /* loaded from: classes6.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    this.a.a.j.setVisibility(8);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ float a;
            public final /* synthetic */ f b;

            public b(f fVar, float f) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, Float.valueOf(f)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = fVar;
                this.a = f;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    this.b.a.k.setScaleX(floatValue / this.a);
                    this.b.a.k.setScaleY(floatValue / this.a);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a.j, Key.TRANSLATION_Y, 0.0f, this.a.j.getHeight());
                ofFloat.setDuration(250L);
                ofFloat.addListener(new a(this));
                int height = this.a.a.getHeight();
                int height2 = this.a.j.getHeight();
                int i = ej.i(this.a.getPageContext().getPageActivity());
                float k = ej.k(this.a.getPageContext().getPageActivity()) * this.a.B;
                this.a.M = (i - height) - height2;
                float k2 = (this.a.M * 1.0f) / ej.k(this.a.getPageContext().getPageActivity());
                TbEditVideoActivity tbEditVideoActivity = this.a;
                tbEditVideoActivity.N = height - ((i - tbEditVideoActivity.M) * 0.5f);
                ObjectAnimator duration = ObjectAnimator.ofFloat(this.a.n, Key.TRANSLATION_Y, 0.0f, this.a.N).setDuration(250L);
                if (this.a.B > k2) {
                    ValueAnimator ofFloat2 = ValueAnimator.ofFloat(k, this.a.M);
                    ofFloat2.addUpdateListener(new b(this, k));
                    ofFloat2.setDuration(250L);
                    ofFloat2.reverse();
                }
                ofFloat.start();
                duration.reverse();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        public g(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.s.setMusicName(this.a.K.title, this.a.K.icon);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        public h(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.h.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements RecordPreviewContainer.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        public i(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void a(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) && this.a.H == 1 && this.a.v != null) {
                this.a.v.g();
                String currentFilterName = this.a.s.getCurrentFilterName();
                if (StringUtils.isNull(currentFilterName)) {
                    return;
                }
                this.a.h.removeCallbacks(this.a.P);
                this.a.h.setText(currentFilterName);
                this.a.h.setVisibility(0);
                this.a.h.postDelayed(this.a.P, 800L);
            }
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void b(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent) == null) && this.a.H == 1 && this.a.v != null) {
                this.a.v.e();
                String currentFilterName = this.a.s.getCurrentFilterName();
                if (StringUtils.isNull(currentFilterName)) {
                    return;
                }
                this.a.h.removeCallbacks(this.a.P);
                this.a.h.setText(currentFilterName);
                this.a.h.setVisibility(0);
                this.a.h.postDelayed(this.a.P, 800L);
            }
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void c(MotionEvent motionEvent, float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, Float.valueOf(f), Float.valueOf(f2)}) == null) {
                this.a.u2();
                if (this.a.s == null || !this.a.s.p()) {
                    return;
                }
                this.a.s.m(null, false);
            }
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void d(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
                this.a.u2();
                if (this.a.s == null || !this.a.s.p()) {
                    return;
                }
                this.a.s.m(null, false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(TbEditVideoActivity tbEditVideoActivity, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity, Integer.valueOf(i), Boolean.valueOf(z)};
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
            this.a = tbEditVideoActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ResponseGetQmFiltersMessage)) {
                List<QmFilterItem> filterItems = httpResponsedMessage.getError() == 0 ? ((ResponseGetQmFiltersMessage) httpResponsedMessage).getFilterItems() : null;
                if (this.a.s != null) {
                    if (filterItems == null) {
                        filterItems = new ArrayList<>();
                    }
                    QmFilterItem qmFilterItem = new QmFilterItem();
                    qmFilterItem.id = "-1";
                    qmFilterItem.bgurl = R.drawable.obfuscated_res_0x7f080a3c + "";
                    qmFilterItem.name = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f063a);
                    qmFilterItem.isSelect = true;
                    qmFilterItem.localPath = "origin";
                    filterItems.add(0, qmFilterItem);
                    this.a.s.setFilterData(filterItems);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements ec6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        public k(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // com.baidu.tieba.ec6.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.s != null) {
                    QmFilterItem qmFilterItem = new QmFilterItem();
                    qmFilterItem.id = "-1";
                    qmFilterItem.bgurl = R.drawable.obfuscated_res_0x7f080a3c + "";
                    qmFilterItem.name = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f063a);
                    qmFilterItem.isSelect = true;
                    qmFilterItem.localPath = "origin";
                    this.a.s.z(qmFilterItem);
                    if (this.a.v != null) {
                        this.a.v.a(null);
                    }
                    this.a.s.setDownLoadFilter(null);
                }
                if (StringUtils.isNull(str)) {
                    str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1216);
                }
                this.a.showToast(str);
            }
        }

        @Override // com.baidu.tieba.ec6.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.s == null) {
                return;
            }
            this.a.s.setDownLoadFilter(null);
        }

        @Override // com.baidu.tieba.ec6.b
        public void c(QmFilterItem qmFilterItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qmFilterItem) == null) {
                if (this.a.v != null) {
                    this.a.v.a(qmFilterItem);
                }
                if (this.a.s != null) {
                    this.a.s.setDownLoadFilter(null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements RecordEffectLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        public l(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void a(QmStickerItem qmStickerItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, qmStickerItem) == null) {
            }
        }

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void b(h19 h19Var, Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h19Var, obj) == null) || h19Var == null) {
                return;
            }
            int type = h19Var.getType();
            if (type == 2) {
                if (this.a.v != null && (h19Var.c() instanceof QmFilterItem)) {
                    QmFilterItem qmFilterItem = (QmFilterItem) h19Var.c();
                    String f = this.a.v.f(qmFilterItem.fileUrl);
                    if (StringUtils.isNull(f) && !"-1".equals(qmFilterItem.id)) {
                        if (this.a.s != null) {
                            this.a.s.setDownLoadFilter(qmFilterItem);
                        }
                        this.a.v.c(qmFilterItem);
                    } else {
                        qmFilterItem.localPath = f;
                        this.a.v.a(qmFilterItem);
                        if (this.a.s != null) {
                            this.a.s.setDownLoadFilter(null);
                        }
                    }
                    this.a.y = true;
                }
            } else if (type == 3 && (h19Var.c() instanceof MusicData)) {
                MusicData musicData = (MusicData) h19Var.c();
                TbMusicData tbMusicData = new TbMusicData();
                tbMusicData.id = musicData.id;
                tbMusicData.title = musicData.name;
                tbMusicData.url = musicData.resource;
                tbMusicData.icon = musicData.img;
                tbMusicData.type = dh.e(musicData.type, 1);
                if (MusicData.MUSIC_NORMAL_ID.equals(musicData.id) || MusicData.MUSIC_CLOUD_ID.equals(musicData.id)) {
                    this.a.u.e(this.a.K);
                    this.a.K = tbMusicData;
                    if (!MusicData.MUSIC_CLOUD_ID.equals(musicData.id)) {
                        this.a.s.setMusicName(this.a.K.title, "");
                    }
                } else {
                    this.a.K = tbMusicData;
                    this.a.u.e(this.a.K);
                    this.a.s.setMusicName(this.a.K.title, "");
                }
                if (!MusicData.MUSIC_CLOUD_ID.equals(musicData.id)) {
                    this.a.s.setMusicName(this.a.K.title, "");
                }
                this.a.u.c((MusicData) h19Var.c(), obj);
                if (this.a.t != null) {
                    this.a.u.a(((float) this.a.t.getCurrentPlayTime()) / 1000.0f);
                }
                this.a.y = true;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m a;

            public a(m mVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = mVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.x.c();
                }
            }
        }

        public m(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.H == 3) {
                    boolean z = this.a.z != null && this.a.z.coverSource == 2;
                    if (this.a.x != null) {
                        if (z) {
                            if (!StringUtils.isNull(this.a.D)) {
                                this.a.x.m(this.a.D);
                            } else {
                                this.a.x.l();
                            }
                        } else {
                            this.a.x.i(this.a.E);
                        }
                        this.a.x.q(this.a.z.getCoverStickerList());
                    }
                }
                if (this.a.x == null || !TextUtils.isEmpty(this.a.C)) {
                    return;
                }
                gh.a().postDelayed(new a(this), 300L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        public n(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.v == null || this.a.v.b() == null) {
                return;
            }
            this.a.t.a(this.a.v.b());
        }
    }

    /* loaded from: classes6.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        public o(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TbEditVideoActivity tbEditVideoActivity = this.a;
                tbEditVideoActivity.showToast(tbEditVideoActivity.getString(R.string.obfuscated_res_0x7f0f0539));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        public p(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoFileInfo c;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (c = ru8.c(this.a.z.path)) == null) {
                return;
            }
            this.a.A = new VideoInfo();
            this.a.A.setVideoPath(this.a.z.path);
            this.a.A.setThumbPath(this.a.C);
            this.a.A.setVideoDuration((int) (c.videoDuration / 1000.0f));
            this.a.A.setVideoWidth(c.videoWidth);
            this.a.A.setVideoHeight(c.videoHeight);
            this.a.A.setVideoLength(new File(this.a.z.path).length());
            this.a.A.setVideoSource(this.a.z.videoInfoSource);
            this.a.A.setIsCompressedVideo(true);
            EditVideoData editVideoData = new EditVideoData();
            if (!StringUtils.isNull(this.a.C)) {
                editVideoData.coverPath = this.a.C;
            } else {
                editVideoData.coverPath = cv8.b;
            }
            editVideoData.originPath = this.a.A.getVideoPath();
            this.a.A.setEditVideoData(editVideoData);
            this.a.z.coverSource = this.a.j.getCurrentMode();
            this.a.z.coverPath = this.a.C;
            this.a.z.orignalCoverPath = this.a.D;
            this.a.z.lastCoverPercent = this.a.E;
            this.a.A.setMultiMediaData(this.a.z);
            if (WorkPublishOpenHelper.Companion.e(this.a.getIntent(), this.a.A, this.a.getPageContext().getPageActivity(), false, true)) {
                return;
            }
            WriteActivityConfig newInstance = WriteActivityConfig.newInstance(this.a.getPageContext().getPageActivity());
            newInstance.getIntent().putExtras(this.a.getIntent());
            String stringExtra = newInstance.getIntent().getStringExtra("forum_id");
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = "0";
            }
            newInstance.getIntent().putExtra("forum_id", stringExtra);
            newInstance.getIntent().setFlags(NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
            newInstance.getIntent().setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            newInstance.setType(9).setVideoInfo(this.a.A).send();
            this.a.finish();
        }
    }

    /* loaded from: classes6.dex */
    public static class q implements f46.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<TbEditVideoActivity> a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomResponsedMessage a;

            public a(q qVar, CustomResponsedMessage customResponsedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar, customResponsedMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(this.a);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CustomResponsedMessage a;
            public final /* synthetic */ TbEditVideoActivity b;
            public final /* synthetic */ q c;

            public b(q qVar, CustomResponsedMessage customResponsedMessage, TbEditVideoActivity tbEditVideoActivity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar, customResponsedMessage, tbEditVideoActivity};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = qVar;
                this.a = customResponsedMessage;
                this.b = tbEditVideoActivity;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(this.a);
                    TbEditVideoActivity tbEditVideoActivity = this.b;
                    if (tbEditVideoActivity != null && tbEditVideoActivity.t != null) {
                        this.b.t.e();
                    }
                    this.c.e();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TbEditVideoActivity a;

            public c(q qVar, TbEditVideoActivity tbEditVideoActivity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar, tbEditVideoActivity};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = tbEditVideoActivity;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    TbEditVideoActivity tbEditVideoActivity = this.a;
                    tbEditVideoActivity.hideLoadingView(tbEditVideoActivity.e);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class d implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TbEditVideoActivity a;

            public d(q qVar, TbEditVideoActivity tbEditVideoActivity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar, tbEditVideoActivity};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = tbEditVideoActivity;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.finish();
                }
            }
        }

        public q(TbEditVideoActivity tbEditVideoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(tbEditVideoActivity);
        }

        @Override // com.baidu.tieba.f46.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f();
            }
        }

        @Override // com.baidu.tieba.f46.a
        public void b() {
            TbEditVideoActivity tbEditVideoActivity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tbEditVideoActivity = this.a.get()) == null) {
                return;
            }
            tbEditVideoActivity.showLoadingView(tbEditVideoActivity.e);
        }

        @Override // com.baidu.tieba.f46.a
        public void c(String str) {
            String str2;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                TbEditVideoActivity tbEditVideoActivity = this.a.get();
                if (tbEditVideoActivity != null ? tbEditVideoActivity.F : false) {
                    File file = new File(str);
                    File file2 = new File(cv8.g);
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    String str3 = cv8.g + file.getName();
                    if (!str3.equals(file.getAbsolutePath())) {
                        FileHelper.copyFileByAbsolutelyPath(file.getAbsolutePath(), str3);
                    }
                    new MediaScannerClient(tbEditVideoActivity.getActivity()).saveVideo(str3);
                    try {
                        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                        intent.setData(UtilHelper.getUriFromFile(file, intent, tbEditVideoActivity.getPageContext().getPageActivity()));
                        tbEditVideoActivity.sendBroadcast(intent);
                    } catch (Exception e) {
                        tbEditVideoActivity.F = false;
                        tbEditVideoActivity.r2();
                        tbEditVideoActivity.s2();
                        BdLog.d(e.getMessage());
                    }
                    tbEditVideoActivity.F = false;
                    tbEditVideoActivity.showToast(tbEditVideoActivity.getResources().getString(R.string.obfuscated_res_0x7f0f10ad));
                    tbEditVideoActivity.r2();
                    tbEditVideoActivity.s2();
                } else {
                    gh.a().post(new a(this, new CustomResponsedMessage(2921584, 100)));
                    VideoFileInfo c2 = ru8.c(str);
                    if (c2 == null) {
                        return;
                    }
                    VideoInfo videoInfo = new VideoInfo();
                    TbMultiMediaData tbMultiMediaData = new TbMultiMediaData();
                    if (tbEditVideoActivity != null) {
                        tbMultiMediaData = tbEditVideoActivity.z;
                        str2 = tbEditVideoActivity.C;
                        i = tbMultiMediaData.videoInfoSource;
                        tbMultiMediaData.coverSource = tbEditVideoActivity.j.getCurrentMode();
                        tbMultiMediaData.coverPath = str2;
                        tbMultiMediaData.orignalCoverPath = tbEditVideoActivity.D;
                        tbMultiMediaData.lastCoverPercent = tbEditVideoActivity.E;
                        videoInfo.setMultiMediaData(tbMultiMediaData);
                    } else {
                        str2 = "";
                        i = 2;
                    }
                    videoInfo.setVideoPath(str);
                    videoInfo.setThumbPath(str2);
                    videoInfo.setVideoDuration((int) (c2.videoDuration / 1000.0f));
                    videoInfo.setVideoWidth(c2.videoWidth);
                    videoInfo.setVideoHeight(c2.videoHeight);
                    videoInfo.setVideoLength(new File(str).length());
                    videoInfo.setVideoSource(i);
                    videoInfo.setIsCompressedVideo(true);
                    EditVideoData editVideoData = new EditVideoData();
                    if (StringUtils.isNull(str2)) {
                        editVideoData.coverPath = cv8.b;
                    } else {
                        editVideoData.coverPath = str2;
                    }
                    editVideoData.originPath = tbMultiMediaData.path;
                    editVideoData.finalPath = str;
                    videoInfo.setEditVideoData(editVideoData);
                    if (tbEditVideoActivity != null) {
                        tbEditVideoActivity.A = videoInfo;
                    }
                    gh.a().post(new b(this, new CustomResponsedMessage(2921593, videoInfo), tbEditVideoActivity));
                }
                f();
            }
        }

        public final void e() {
            TbEditVideoActivity tbEditVideoActivity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tbEditVideoActivity = this.a.get()) == null) {
                return;
            }
            tbEditVideoActivity.runOnUiThread(new d(this, tbEditVideoActivity));
        }

        public final void f() {
            TbEditVideoActivity tbEditVideoActivity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (tbEditVideoActivity = this.a.get()) == null) {
                return;
            }
            tbEditVideoActivity.runOnUiThread(new c(this, tbEditVideoActivity));
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
        this.y = false;
        this.F = false;
        this.G = false;
        this.H = 1;
        this.I = false;
        this.M = ej.i(getPageContext().getPageActivity());
        this.N = 0.0f;
        this.O = new q(this);
        this.P = new h(this);
        this.Q = new i(this);
        this.R = new j(this, CmdConfigHttp.CMD_GET_QM_FILTERS, true);
        this.S = new k(this);
        this.T = new l(this);
        this.U = new ri5(new m(this));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tieba.tb6
    public void h0(String str) {
        List<MultiMediaData> j2;
        sb6 sb6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || StringUtils.isNull(str) || str.equals(this.C)) {
            return;
        }
        sb6 sb6Var2 = this.x;
        if (sb6Var2 != null) {
            this.E = sb6Var2.p();
        }
        this.C = str;
        if (this.j.getCurrentMode() == 2 && (sb6Var = this.x) != null) {
            sb6Var.l();
        }
        if (this.I) {
            gh.a().post(new o(this));
            if (this.H != 3) {
                c46 c46Var = this.t;
                if (c46Var != null) {
                    c46Var.start();
                }
                gc6 gc6Var = this.u;
                if (gc6Var != null) {
                    gc6Var.onResume();
                    c46 c46Var2 = this.t;
                    if (c46Var2 != null) {
                        this.u.a(((float) c46Var2.getCurrentPlayTime()) / 1000.0f);
                    }
                }
            }
            this.y = true;
        }
        sb6 sb6Var3 = this.x;
        if (sb6Var3 != null && (j2 = sb6Var3.j()) != null) {
            this.z.setCoverStickerList(j2);
        }
        if (this.H == 3) {
            gh.a().post(new p(this));
        }
    }

    public final void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.y) {
                wu4 wu4Var = new wu4(getPageContext(), new yu4(getPageContext().getPageActivity()));
                wu4Var.i(getResources().getString(R.string.obfuscated_res_0x7f0f0538), new String[]{getResources().getString(R.string.obfuscated_res_0x7f0f0f97)}, new b(this, wu4Var));
                wu4Var.k();
                return;
            }
            finish();
        }
    }

    public final void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b.setVisibility(0);
            this.c.setVisibility(0);
            this.j.post(new d(this));
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            this.i.setVisibility(8);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0611, 0);
        }
    }

    public final void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.setVisibility(8);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            this.i.setVisibility(8);
        }
    }

    public final void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.setVisibility(0);
            this.l.setVisibility(0);
            this.m.setVisibility(0);
            this.i.setVisibility(0);
        }
    }

    public final g46 l2() {
        InterceptResult invokeV;
        gc6 gc6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            g46 g46Var = new g46();
            TbMultiMediaData tbMultiMediaData = this.z;
            float f2 = 0.0f;
            if (tbMultiMediaData != null) {
                g46Var.j(tbMultiMediaData);
                g46Var.n(this.B);
                TbMultiMediaData tbMultiMediaData2 = this.z;
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
                    float f6 = this.B;
                    if (f6 > (f4 * 1.0f) / f5) {
                        i3 = (int) (f5 * f6);
                    } else if (f6 != 0.0f) {
                        i2 = (int) (f4 / f6);
                    }
                    g46Var.m(i2);
                    g46Var.l(i3);
                }
            }
            fc6 fc6Var = this.v;
            if (fc6Var != null && fc6Var.b() != null) {
                QmFilterItem b2 = this.v.b();
                String str = b2.localPath;
                Filter filter = new Filter();
                if (!StringUtils.isNull(str) && !"origin".equals(str)) {
                    f2 = (dh.d(b2.effect, 100.0f) * 1.0f) / 100.0f;
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
                tbFilterValue.mComplex = dh.e(b2.complex, 0);
                tbFilterValue.mRootFilePath = str;
                g46Var.h(tbFilterValue);
            }
            c46 c46Var = this.t;
            if (c46Var != null) {
                g46Var.i(c46Var.getMediaTrackConfig());
            }
            TbMusicData tbMusicData = this.K;
            if (tbMusicData != null && (gc6Var = this.u) != null) {
                tbMusicData.localPath = gc6Var.b();
                g46Var.k(this.K);
            }
            return g46Var;
        }
        return (g46) invokeV.objValue;
    }

    public final void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.H = 1;
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0105, 0);
            this.b.setVisibility(8);
            this.c.setVisibility(8);
            gh.a().post(new f(this));
            this.l.setVisibility(0);
            this.m.setVisibility(0);
            this.i.setVisibility(0);
        }
    }

    public final void n2() {
        TbMusicData tbMusicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            boolean booleanExtra = getIntent().getBooleanExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, false);
            this.k = (TbGLMediaPreviewView) findViewById(R.id.obfuscated_res_0x7f09087f);
            this.j = (PreViewPickCoverView) findViewById(R.id.obfuscated_res_0x7f0919d0);
            vb6 vb6Var = new vb6(getPageContext(), this.k, this.j, this.z, booleanExtra);
            this.x = vb6Var;
            vb6Var.d(this);
            this.I = false;
            d46 d46Var = new d46(getPageContext(), this.k, this.z, this.x, booleanExtra);
            this.t = d46Var;
            d46Var.f(this.B);
            this.t.b(new a(this));
            this.s = (VideoControllerLayout) findViewById(R.id.obfuscated_res_0x7f091bae);
            ic6 ic6Var = new ic6(getPageContext(), this.s);
            this.u = ic6Var;
            this.s.setMusicManager(ic6Var);
            if (this.u != null && (tbMusicData = this.K) != null && !TextUtils.isEmpty(tbMusicData.localPath) && !TextUtils.isEmpty(this.K.id)) {
                TbMusicData tbMusicData2 = this.K;
                if (tbMusicData2.type == 2) {
                    this.s.setEffectLayoutCurrentMusicName(getResources().getString(R.string.obfuscated_res_0x7f0f0b42));
                } else {
                    this.s.setEffectLayoutCurrentMusicName(tbMusicData2.title);
                }
                gc6 gc6Var = this.u;
                TbMusicData tbMusicData3 = this.K;
                gc6Var.f(tbMusicData3.localPath, tbMusicData3.id);
                c46 c46Var = this.t;
                if (c46Var != null) {
                    this.u.a(((float) c46Var.getCurrentPlayTime()) / 1000.0f);
                }
                this.s.setMusicName(this.K.title, "");
            }
            ec6 ec6Var = new ec6(null, this.t, this.s);
            this.v = ec6Var;
            ec6Var.d(this.S);
            this.v.h();
            this.s.setEditManager(this.t);
            this.w = new h46(getPageContext(), this.O);
            q2();
            QmFilterItem videoFilter = this.z.getVideoFilter();
            if (videoFilter != null) {
                this.v.a(videoFilter);
                this.s.setCurrentFilterWithQmFilterItem(videoFilter);
            }
        }
    }

    public final void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.e = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091c84);
            this.a = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091657);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f090874);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f0904bc);
            this.g = (ImageView) findViewById(R.id.obfuscated_res_0x7f0904be);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f09087b);
            this.m = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09087c);
            this.l = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0904b7);
            this.p = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0904bd);
            this.q = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0904bf);
            this.r = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0904b9);
            this.j.setVisibility(4);
            RecordPreviewContainer recordPreviewContainer = (RecordPreviewContainer) findViewById(R.id.obfuscated_res_0x7f09087a);
            this.n = recordPreviewContainer;
            recordPreviewContainer.setOnViewClickListener(this.Q);
            TextView centerTextTitle = this.a.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0e9b));
            this.b = centerTextTitle;
            centerTextTitle.setTextColor(getResources().getColor(R.color.CAM_X0101));
            this.b.setVisibility(8);
            View addSystemImageButton = this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.d = addSystemImageButton;
            ((ImageView) addSystemImageButton.findViewById(R.id.obfuscated_res_0x7f092680)).setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a22));
            TextView addTextButton = this.a.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.obfuscated_res_0x7f0f10a3));
            this.c = addTextButton;
            addTextButton.setTextColor(getResources().getColor(R.color.CAM_X0101));
            this.c.setVisibility(8);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0904bb);
            this.o = relativeLayout;
            int i2 = 0;
            if (this.L == 1) {
                relativeLayout.setVisibility(8);
            } else {
                relativeLayout.setVisibility(0);
            }
            if (this.s.getRecrodButton() != null) {
                this.s.getRecrodButton().setVisibility(8);
            }
            this.s.setEffectChoosedListener(this.T);
            this.d.setOnClickListener(this);
            this.c.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.i.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.o.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.r.setOnClickListener(this);
            hv4 d2 = hv4.d(this.h);
            d2.A(R.string.F_X02);
            d2.y(R.array.S_O_X001);
            hv4 d3 = hv4.d(findViewById(R.id.obfuscated_res_0x7f09087b));
            d3.n(R.string.J_X01);
            d3.f(R.color.CAM_X0302);
            hv4.d(findViewById(R.id.obfuscated_res_0x7f09087e)).y(R.array.S_O_X001);
            hv4.d(findViewById(R.id.obfuscated_res_0x7f0904c1)).y(R.array.S_O_X001);
            hv4.d(findViewById(R.id.obfuscated_res_0x7f0904c2)).y(R.array.S_O_X001);
            hv4.d(findViewById(R.id.obfuscated_res_0x7f0904c0)).y(R.array.S_O_X001);
            hv4.d(findViewById(R.id.obfuscated_res_0x7f0904c3)).y(R.array.S_O_X001);
            TbMultiMediaData tbMultiMediaData = this.z;
            if (tbMultiMediaData != null && tbMultiMediaData.coverSource == 2) {
                this.j.setCurrentMode(2);
            } else {
                this.j.setCurrentMode(1);
            }
            if (this.H == 3) {
                i2();
                this.U.b();
            } else if (WorkPublishManager.isWorkPublishLocate()) {
                int i3 = this.L;
                if (i3 == 1) {
                    i2 = 2;
                } else if (i3 == 2) {
                    i2 = 1;
                }
                TiebaStatic.log(new StatisticItem("c14309").param("obj_source", i2));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        sb6 sb6Var;
        TbMultiMediaData tbMultiMediaData;
        TbMultiMediaData tbMultiMediaData2;
        sb6 sb6Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048586, this, i2, i3, intent) == null) {
            if (intent == null) {
                if (this.j.getCurrentMode() != 2 || i2 != 12002 || (sb6Var2 = this.x) == null || sb6Var2.o()) {
                    return;
                }
                this.j.setCurrentMode(1);
                this.x.l();
            } else if (i2 == 25032) {
                if (i3 != -1) {
                    return;
                }
                String stringExtra = intent.getStringExtra(CloudMusicActivityConfig.MUSIC_ID);
                TbMusicData tbMusicData = (TbMusicData) intent.getSerializableExtra(CloudMusicActivityConfig.MUSIC_DATA);
                if (tbMusicData != null) {
                    this.K = tbMusicData;
                    if (TextUtils.isEmpty(tbMusicData.localPath) || TextUtils.isEmpty(stringExtra)) {
                        return;
                    }
                    String str = tbMusicData.localPath;
                    if (this.u == null || TextUtils.isEmpty(str)) {
                        return;
                    }
                    this.u.f(str, stringExtra);
                    c46 c46Var = this.t;
                    if (c46Var != null) {
                        this.u.a(((float) c46Var.getCurrentPlayTime()) / 1000.0f);
                    }
                    this.s.y(tbMusicData);
                }
            } else if (i2 == 25062) {
                vu8.c(intent, this.k);
                if (i3 == -1 && (tbMultiMediaData = (TbMultiMediaData) intent.getParcelableExtra(TbEditVideoActivityConfig.KEY_EDIT_VIDEO_DATA)) != null && this.t != null && (tbMultiMediaData2 = this.z) != null && (tbMultiMediaData.start != tbMultiMediaData2.start || tbMultiMediaData.end != tbMultiMediaData2.end)) {
                    this.z = tbMultiMediaData;
                    this.t.c(tbMultiMediaData);
                    this.s.post(new n(this));
                    this.y = true;
                }
                k2();
            } else if (i2 == 12002) {
                if (i3 == -1) {
                    String stringExtra2 = intent.getStringExtra(VideoCoverSelectActivityConfig.KEY_VIDEO_COVER_IMAGE_PATH);
                    if (TextUtils.isEmpty(stringExtra2) || (sb6Var = this.x) == null) {
                        return;
                    }
                    sb6Var.m(stringExtra2);
                    this.D = stringExtra2;
                    return;
                }
                sb6 sb6Var3 = this.x;
                if (sb6Var3 == null || sb6Var3.o()) {
                    return;
                }
                this.j.setCurrentMode(1);
                this.x.l();
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        sb6 sb6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.H == 2) {
                if (this.j.getCurrentMode() == 2 && (sb6Var = this.x) != null) {
                    sb6Var.l();
                }
                sb6 sb6Var2 = this.x;
                if (sb6Var2 != null) {
                    sb6Var2.reset();
                }
                gh.a().post(new c(this));
                m2();
                return;
            }
            h2();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        sb6 sb6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            super.onClick(view2);
            if (view2.getId() == R.id.obfuscated_res_0x7f0904bd) {
                u2();
                if (this.s.q()) {
                    this.f.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a3b));
                } else {
                    this.f.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a3d));
                }
                this.s.v();
                if (this.s.t()) {
                    q2();
                    return;
                }
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f0904bf) {
                u2();
                if (this.s.s()) {
                    this.g.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a3e));
                } else {
                    this.g.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a3f));
                }
                this.s.w();
                TbMusicData tbMusicData = this.K;
                if (tbMusicData == null || tbMusicData.type != 2) {
                    return;
                }
                this.s.postDelayed(new g(this), 300L);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0904bb) {
                TbFileVideoActivityConfig tbFileVideoActivityConfig = new TbFileVideoActivityConfig(getPageContext().getPageActivity());
                tbFileVideoActivityConfig.setForResult();
                tbFileVideoActivityConfig.setFrom(2);
                tbFileVideoActivityConfig.setTbMultiMediaData(this.z);
                fc6 fc6Var = this.v;
                if (fc6Var != null && fc6Var.b() != null) {
                    tbFileVideoActivityConfig.setFilter(this.v.b());
                }
                tbFileVideoActivityConfig.setEnterAnimValues(vu8.a(this.k));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbFileVideoActivityConfig));
                j2();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0904b9) {
                sb6 sb6Var2 = this.x;
                if (sb6Var2 != null) {
                    sb6Var2.i(this.E);
                    t2();
                    if (this.j.getCurrentMode() == 2 && !StringUtils.isNull(this.D)) {
                        this.x.m(this.D);
                    } else {
                        this.j.setCurrentMode(1);
                    }
                    this.x.q(this.z.getCoverStickerList());
                    v2();
                }
                ox4.k().u("key_edit_video_pick_cover_tip_show", true);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09087c) {
                if (this.w != null) {
                    this.F = true;
                    t2();
                    this.w.a(l2());
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09087b) {
                if (WorkPublishManager.isWorkPublishLocate()) {
                    int i2 = this.L;
                    TiebaStatic.log(new StatisticItem("c14310").param("obj_source", i2 != 1 ? i2 == 2 ? 1 : 0 : 2));
                }
                if (!ox4.k().h("key_edit_video_pick_cover_tip_show", false)) {
                    x36 x36Var = new x36(getPageContext(), this.r);
                    x36Var.q0(R.drawable.obfuscated_res_0x7f080f8f);
                    x36Var.Q(1);
                    x36Var.r0(true);
                    x36Var.h0(R.color.CAM_X0101);
                    x36Var.o0(R.dimen.T_X08);
                    x36Var.U(R.dimen.T_X08);
                    x36Var.k0(UtilHelper.getDimenPixelSize(R.dimen.tbds26));
                    x36Var.n0(UtilHelper.getDimenPixelSize(R.dimen.tbds26));
                    x36Var.w0(getResources().getString(R.string.obfuscated_res_0x7f0f053a));
                    ox4.k().u("key_edit_video_pick_cover_tip_show", true);
                    return;
                }
                t2();
                this.w.a(l2());
                VideoFileInfo c2 = ru8.c(this.z.path);
                if (c2 == null) {
                    return;
                }
                VideoInfo videoInfo = new VideoInfo();
                this.A = videoInfo;
                videoInfo.setVideoPath(this.z.path);
                this.A.setThumbPath(this.C);
                this.A.setVideoDuration((int) (c2.videoDuration / 1000.0f));
                this.A.setVideoWidth(c2.videoWidth);
                this.A.setVideoHeight(c2.videoHeight);
                this.A.setVideoLength(new File(this.z.path).length());
                this.A.setVideoSource(this.z.videoInfoSource);
                this.A.setIsCompressedVideo(true);
                EditVideoData editVideoData = new EditVideoData();
                if (StringUtils.isNull(this.C)) {
                    editVideoData.coverPath = cv8.b;
                } else {
                    editVideoData.coverPath = this.C;
                }
                editVideoData.originPath = this.A.getVideoPath();
                this.A.setEditVideoData(editVideoData);
                this.z.coverSource = this.j.getCurrentMode();
                TbMultiMediaData tbMultiMediaData = this.z;
                tbMultiMediaData.coverPath = this.C;
                tbMultiMediaData.orignalCoverPath = this.D;
                List<MultiMediaData> j2 = this.x.j();
                if (j2 != null) {
                    this.z.setCoverStickerList(j2);
                }
                this.z.setOrignalVideoPath(this.A.getVideoPath());
                this.z.setVideoFilter(this.v.b());
                this.A.setMultiMediaData(this.z);
                this.G = true;
                if (WorkPublishOpenHelper.Companion.e(getIntent(), this.A, getPageContext().getPageActivity(), true, true)) {
                    return;
                }
                WriteActivityConfig newInstance = WriteActivityConfig.newInstance(getPageContext().getPageActivity());
                newInstance.getIntent().putExtras(getIntent());
                String stringExtra = newInstance.getIntent().getStringExtra("forum_id");
                if (TextUtils.isEmpty(stringExtra)) {
                    stringExtra = "0";
                }
                newInstance.getIntent().putExtra("forum_id", stringExtra);
                newInstance.getIntent().setFlags(NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
                newInstance.getIntent().setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                newInstance.setType(9).setVideoInfo(this.A).setNeedClosePrePage(true).send();
                finish();
            } else if (view2 == this.d) {
                onBackPressed();
            } else if (view2 == this.c) {
                int i3 = this.H;
                if (i3 == 2) {
                    sb6 sb6Var3 = this.x;
                    if (sb6Var3 != null) {
                        this.I = true;
                        sb6Var3.f();
                    }
                    m2();
                } else if (i3 != 3 || (sb6Var = this.x) == null) {
                } else {
                    this.I = true;
                    sb6Var.f();
                }
            } else if (view2.getId() == this.j.getVideoPick().getId()) {
                if (this.j.getCurrentMode() != 1) {
                    this.j.setCurrentMode(1);
                    sb6 sb6Var4 = this.x;
                    if (sb6Var4 != null) {
                        sb6Var4.i(this.E);
                        this.x.l();
                    }
                }
            } else if (view2.getId() == this.j.getImagePick().getId()) {
                if (this.j.getCurrentMode() != 2) {
                    this.j.setCurrentMode(2);
                    sb6 sb6Var5 = this.x;
                    if (sb6Var5 != null) {
                        this.E = sb6Var5.p();
                    }
                    p2();
                }
            } else if (view2.getId() == this.j.getCoverImageView().getId() && this.j.getCurrentMode() == 2) {
                p2();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0054);
            setSwipeBackEnabled(false);
            if (getIntent() != null) {
                this.H = getIntent().getIntExtra(TbEditVideoActivityConfig.KEY_EDIT_PAGE_MODE_TYPE, 1);
                this.z = (TbMultiMediaData) getIntent().getParcelableExtra(TbEditVideoActivityConfig.KEY_EDIT_VIDEO_DATA);
                this.B = getIntent().getFloatExtra(TbEditVideoActivityConfig.KEY_EDIT_VIDEO_RATIO, 0.0f);
                this.L = getIntent().getIntExtra(TbEditVideoActivityConfig.KEY_EDIT_VIDEO_FROM, 0);
                TbMusicData tbMusicData = (TbMusicData) getIntent().getSerializableExtra(TbEditVideoActivityConfig.KEY_EDIT_VIDEO_MUSIC_DATA);
                this.J = tbMusicData;
                this.K = tbMusicData;
                TbMultiMediaData tbMultiMediaData = this.z;
                tbMultiMediaData.videoRatio = this.B;
                this.C = tbMultiMediaData.coverPath;
                this.D = tbMultiMediaData.orignalCoverPath;
                this.E = tbMultiMediaData.lastCoverPercent;
            }
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_QM_FILTERS, TbConfig.SERVER_ADDRESS + TbConfig.GET_QM_FILTERS);
            tbHttpMessageTask.setResponsedClass(ResponseGetQmFiltersMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            n2();
            o2();
            registerListener(this.R);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            c46 c46Var = this.t;
            if (c46Var != null) {
                c46Var.onDestroy();
                if (!this.G) {
                    this.t.e();
                }
            }
            gc6 gc6Var = this.u;
            if (gc6Var != null) {
                gc6Var.releasePlayer();
                this.u.d();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onPause();
            r2();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onResume();
            s2();
        }
    }

    public final void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
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
            albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
            albumFloatActivityConfig.setAlbumThread(0);
            albumFloatActivityConfig.setCanSelectVideo(false);
            albumFloatActivityConfig.setCanSelectGif(false);
            albumFloatActivityConfig.setCanEditImage(false);
            albumFloatActivityConfig.setNeedClipImage(true);
            albumFloatActivityConfig.setImageClipType(this.B > 1.0f ? 2 : 1);
            albumFloatActivityConfig.setAlbumShowCapture(false);
            albumFloatActivityConfig.setAlbumDirectDoneOnlyOne(true);
            sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }
    }

    public final void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_QM_FILTERS);
            httpMessage.addParam("uh", gj.f() + "," + Build.HARDWARE + "," + Build.BOARD + "," + (su8.b(this) ? 1 : 0));
            httpMessage.addParam("ut", gj.g() + "_" + gj.k() + "_" + su8.a() + "_" + Build.BRAND.replace("_", ""));
            StringBuilder sb = new StringBuilder();
            sb.append(ue0.h());
            sb.append("");
            httpMessage.addParam("sdk_version", sb.toString());
            sendMessage(httpMessage);
        }
    }

    public final void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            c46 c46Var = this.t;
            if (c46Var != null) {
                c46Var.onPause();
            }
            gc6 gc6Var = this.u;
            if (gc6Var != null) {
                gc6Var.onPause();
            }
        }
    }

    public final void s2() {
        gc6 gc6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ViewGroup viewGroup = this.e;
            if (viewGroup != null) {
                viewGroup.setSystemUiVisibility(4100);
            }
            c46 c46Var = this.t;
            if (c46Var != null) {
                c46Var.onResume();
            }
            if (this.H == 1 && (gc6Var = this.u) != null) {
                gc6Var.onResume();
                c46 c46Var2 = this.t;
                if (c46Var2 != null) {
                    this.u.a(((float) c46Var2.getCurrentPlayTime()) / 1000.0f);
                }
            }
            fc6 fc6Var = this.v;
            if (fc6Var != null) {
                fc6Var.h();
            }
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
            c46 c46Var = this.t;
            if (c46Var != null) {
                c46Var.pause();
            }
            gc6 gc6Var = this.u;
            if (gc6Var != null) {
                gc6Var.onPause();
            }
        }
    }

    public final void u2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.f.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a3b));
            this.g.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a3e));
        }
    }

    public final void v2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.H = 2;
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0611, 0);
            u2();
            VideoControllerLayout videoControllerLayout = this.s;
            if (videoControllerLayout != null && videoControllerLayout.p()) {
                this.s.m(null, false);
            }
            this.b.setVisibility(0);
            this.c.setVisibility(0);
            gh.a().post(new e(this));
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            this.i.setVisibility(8);
        }
    }
}
