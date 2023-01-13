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
import com.baidu.tieba.ai6;
import com.baidu.tieba.b59;
import com.baidu.tieba.bh;
import com.baidu.tieba.bj;
import com.baidu.tieba.ci6;
import com.baidu.tieba.cx4;
import com.baidu.tieba.cz4;
import com.baidu.tieba.external.filter.ResponseGetQmFiltersMessage;
import com.baidu.tieba.external.filter.TbFilterValue;
import com.baidu.tieba.external.music.data.MusicData;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
import com.baidu.tieba.f59;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.fw4;
import com.baidu.tieba.hw4;
import com.baidu.tieba.li6;
import com.baidu.tieba.mi6;
import com.baidu.tieba.ni6;
import com.baidu.tieba.o59;
import com.baidu.tieba.pa6;
import com.baidu.tieba.pi6;
import com.baidu.tieba.ql5;
import com.baidu.tieba.ta6;
import com.baidu.tieba.ua6;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.tieba.view.widget.RecordPreviewContainer;
import com.baidu.tieba.view.widget.TbGLMediaPreviewView;
import com.baidu.tieba.view.widget.pickcover.PreViewPickCoverView;
import com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout;
import com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout;
import com.baidu.tieba.wa6;
import com.baidu.tieba.xa6;
import com.baidu.tieba.y49;
import com.baidu.tieba.ya6;
import com.baidu.tieba.yb9;
import com.baidu.tieba.yg;
import com.baidu.tieba.ze0;
import com.baidu.tieba.zh6;
import com.baidu.tieba.zi;
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
public class TbEditVideoActivity extends BaseActivity<TbEditVideoActivity> implements ai6 {
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
    public wa6.a O;
    public Runnable P;
    public RecordPreviewContainer.f Q;
    public HttpMessageListener R;
    public li6.b S;
    public RecordEffectLayout.i T;
    @NonNull
    public final ql5 U;
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
    public ta6 t;
    public ni6 u;
    public mi6 v;
    public wa6 w;
    public zh6 x;
    public boolean y;
    public TbMultiMediaData z;

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
                int j = zi.j(this.a.getPageContext().getPageActivity());
                float l = zi.l(this.a.getPageContext().getPageActivity()) * this.a.B;
                this.a.M = (j - height) - height2;
                float l2 = (this.a.M * 1.0f) / zi.l(this.a.getPageContext().getPageActivity());
                TbEditVideoActivity tbEditVideoActivity = this.a;
                tbEditVideoActivity.N = height - ((j - tbEditVideoActivity.M) * 0.5f);
                ObjectAnimator duration = ObjectAnimator.ofFloat(this.a.n, Key.TRANSLATION_Y, 0.0f, this.a.N).setDuration(250L);
                if (this.a.B > l2) {
                    ValueAnimator ofFloat2 = ValueAnimator.ofFloat(l, this.a.M);
                    ofFloat2.addUpdateListener(new b(this, l));
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
                int j = zi.j(this.a.getPageContext().getPageActivity());
                float l = zi.l(this.a.getPageContext().getPageActivity()) * this.a.B;
                this.a.M = (j - height) - height2;
                float l2 = (this.a.M * 1.0f) / zi.l(this.a.getPageContext().getPageActivity());
                TbEditVideoActivity tbEditVideoActivity = this.a;
                tbEditVideoActivity.N = height - ((j - tbEditVideoActivity.M) * 0.5f);
                ObjectAnimator duration = ObjectAnimator.ofFloat(this.a.n, Key.TRANSLATION_Y, 0.0f, this.a.N).setDuration(250L);
                if (this.a.B > l2) {
                    ValueAnimator ofFloat2 = ValueAnimator.ofFloat(l, this.a.M);
                    ofFloat2.addUpdateListener(new b(this, l));
                    ofFloat2.setDuration(250L);
                    ofFloat2.reverse();
                }
                ofFloat.start();
                duration.reverse();
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
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.H == 3) {
                    if (this.a.z != null && this.a.z.coverSource == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
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
                if (this.a.x != null && TextUtils.isEmpty(this.a.C)) {
                    bh.a().postDelayed(new a(this), 300L);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class q implements wa6.a {
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

        @Override // com.baidu.tieba.wa6.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f();
            }
        }

        @Override // com.baidu.tieba.wa6.a
        public void b() {
            TbEditVideoActivity tbEditVideoActivity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (tbEditVideoActivity = this.a.get()) != null) {
                tbEditVideoActivity.showLoadingView(tbEditVideoActivity.e);
            }
        }

        public final void e() {
            TbEditVideoActivity tbEditVideoActivity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (tbEditVideoActivity = this.a.get()) != null) {
                tbEditVideoActivity.runOnUiThread(new d(this, tbEditVideoActivity));
            }
        }

        public final void f() {
            TbEditVideoActivity tbEditVideoActivity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (tbEditVideoActivity = this.a.get()) != null) {
                tbEditVideoActivity.runOnUiThread(new c(this, tbEditVideoActivity));
            }
        }

        @Override // com.baidu.tieba.wa6.a
        public void c(String str) {
            boolean z;
            String str2;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                TbEditVideoActivity tbEditVideoActivity = this.a.get();
                if (tbEditVideoActivity != null) {
                    z = tbEditVideoActivity.F;
                } else {
                    z = false;
                }
                if (z) {
                    File file = new File(str);
                    File file2 = new File(o59.g);
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    String str3 = o59.g + file.getName();
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
                        tbEditVideoActivity.q2();
                        tbEditVideoActivity.r2();
                        BdLog.d(e.getMessage());
                    }
                    tbEditVideoActivity.F = false;
                    tbEditVideoActivity.showToast(tbEditVideoActivity.getResources().getString(R.string.save_success));
                    tbEditVideoActivity.q2();
                    tbEditVideoActivity.r2();
                } else {
                    bh.a().post(new a(this, new CustomResponsedMessage(2921584, 100)));
                    VideoFileInfo c2 = y49.c(str);
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
                        editVideoData.coverPath = o59.b;
                    } else {
                        editVideoData.coverPath = str2;
                    }
                    editVideoData.originPath = tbMultiMediaData.path;
                    editVideoData.finalPath = str;
                    videoInfo.setEditVideoData(editVideoData);
                    if (tbEditVideoActivity != null) {
                        tbEditVideoActivity.A = videoInfo;
                    }
                    bh.a().post(new b(this, new CustomResponsedMessage(2921593, videoInfo), tbEditVideoActivity));
                }
                f();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements ta6.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        @Override // com.baidu.tieba.ta6.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

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

        @Override // com.baidu.tieba.ta6.a
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.u != null) {
                this.a.u.a(0.0f);
            }
        }

        @Override // com.baidu.tieba.ta6.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a.H != 1) {
                    this.a.s2();
                }
                this.a.U.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements hw4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw4 a;
        public final /* synthetic */ TbEditVideoActivity b;

        public b(TbEditVideoActivity tbEditVideoActivity, fw4 fw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity, fw4Var};
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
            this.a = fw4Var;
        }

        @Override // com.baidu.tieba.hw4.f
        public void o0(hw4 hw4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, hw4Var, i, view2) == null) {
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
                int j = zi.j(this.a.getPageContext().getPageActivity());
                float l = zi.l(this.a.getPageContext().getPageActivity()) * this.a.B;
                this.a.M = (j - height) - height2;
                float l2 = (this.a.M * 1.0f) / zi.l(this.a.getPageContext().getPageActivity());
                TbEditVideoActivity tbEditVideoActivity = this.a;
                tbEditVideoActivity.N = height - ((j - tbEditVideoActivity.M) * 0.5f);
                this.a.n.setTranslationY(this.a.N);
                if (this.a.B > l2) {
                    this.a.k.setScaleX(this.a.M / l);
                    this.a.k.setScaleY(this.a.M / l);
                }
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
                if (!StringUtils.isNull(currentFilterName)) {
                    this.a.h.removeCallbacks(this.a.P);
                    this.a.h.setText(currentFilterName);
                    this.a.h.setVisibility(0);
                    this.a.h.postDelayed(this.a.P, 800L);
                }
            }
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void b(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent) == null) && this.a.H == 1 && this.a.v != null) {
                this.a.v.e();
                String currentFilterName = this.a.s.getCurrentFilterName();
                if (!StringUtils.isNull(currentFilterName)) {
                    this.a.h.removeCallbacks(this.a.P);
                    this.a.h.setText(currentFilterName);
                    this.a.h.setVisibility(0);
                    this.a.h.postDelayed(this.a.P, 800L);
                }
            }
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void c(MotionEvent motionEvent, float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, Float.valueOf(f), Float.valueOf(f2)}) == null) {
                this.a.t2();
                if (this.a.s != null && this.a.s.p()) {
                    this.a.s.m(null, false);
                }
            }
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
        public void d(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
                this.a.t2();
                if (this.a.s != null && this.a.s.p()) {
                    this.a.s.m(null, false);
                }
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || !(httpResponsedMessage instanceof ResponseGetQmFiltersMessage)) {
                return;
            }
            List<QmFilterItem> list = null;
            ResponseGetQmFiltersMessage responseGetQmFiltersMessage = (ResponseGetQmFiltersMessage) httpResponsedMessage;
            if (httpResponsedMessage.getError() == 0) {
                list = responseGetQmFiltersMessage.getFilterItems();
            }
            if (this.a.s != null) {
                if (list == null) {
                    list = new ArrayList<>();
                }
                QmFilterItem qmFilterItem = new QmFilterItem();
                qmFilterItem.id = "-1";
                qmFilterItem.bgurl = R.drawable.obfuscated_res_0x7f080a92 + "";
                qmFilterItem.name = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0656);
                qmFilterItem.isSelect = true;
                qmFilterItem.localPath = "origin";
                list.add(0, qmFilterItem);
                this.a.s.setFilterData(list);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements li6.b {
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

        @Override // com.baidu.tieba.li6.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.s != null) {
                    QmFilterItem qmFilterItem = new QmFilterItem();
                    qmFilterItem.id = "-1";
                    qmFilterItem.bgurl = R.drawable.obfuscated_res_0x7f080a92 + "";
                    qmFilterItem.name = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0656);
                    qmFilterItem.isSelect = true;
                    qmFilterItem.localPath = "origin";
                    this.a.s.z(qmFilterItem);
                    if (this.a.v != null) {
                        this.a.v.a(null);
                    }
                    this.a.s.setDownLoadFilter(null);
                }
                if (StringUtils.isNull(str)) {
                    str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f129e);
                }
                this.a.showToast(str);
            }
        }

        @Override // com.baidu.tieba.li6.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.s != null) {
                this.a.s.setDownLoadFilter(null);
            }
        }

        @Override // com.baidu.tieba.li6.b
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

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void a(QmStickerItem qmStickerItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, qmStickerItem) == null) {
            }
        }

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
        public void b(yb9 yb9Var, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yb9Var, obj) != null) || yb9Var == null) {
                return;
            }
            int type = yb9Var.getType();
            if (type != 2) {
                if (type == 3 && (yb9Var.c() instanceof MusicData)) {
                    MusicData musicData = (MusicData) yb9Var.c();
                    TbMusicData tbMusicData = new TbMusicData();
                    tbMusicData.id = musicData.id;
                    tbMusicData.title = musicData.name;
                    tbMusicData.url = musicData.resource;
                    tbMusicData.icon = musicData.img;
                    tbMusicData.type = yg.e(musicData.type, 1);
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
                    this.a.u.c((MusicData) yb9Var.c(), obj);
                    if (this.a.t != null) {
                        this.a.u.a(((float) this.a.t.getCurrentPlayTime()) / 1000.0f);
                    }
                    this.a.y = true;
                }
            } else if (this.a.v != null && (yb9Var.c() instanceof QmFilterItem)) {
                QmFilterItem qmFilterItem = (QmFilterItem) yb9Var.c();
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.v != null && this.a.v.b() != null) {
                this.a.t.a(this.a.v.b());
            }
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
                tbEditVideoActivity.showToast(tbEditVideoActivity.getString(R.string.obfuscated_res_0x7f0f0554));
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
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (c = y49.c(this.a.z.path)) == null) {
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
            if (StringUtils.isNull(this.a.C)) {
                editVideoData.coverPath = o59.b;
            } else {
                editVideoData.coverPath = this.a.C;
            }
            editVideoData.originPath = this.a.A.getVideoPath();
            this.a.A.setEditVideoData(editVideoData);
            this.a.z.coverSource = this.a.j.getCurrentMode();
            this.a.z.coverPath = this.a.C;
            this.a.z.orignalCoverPath = this.a.D;
            this.a.z.lastCoverPercent = this.a.E;
            this.a.A.setMultiMediaData(this.a.z);
            if (!WorkPublishOpenHelper.Companion.e(this.a.getIntent(), this.a.A, this.a.getPageContext().getPageActivity(), false, true)) {
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
        this.M = zi.j(getPageContext().getPageActivity());
        this.N = 0.0f;
        this.O = new q(this);
        this.P = new h(this);
        this.Q = new i(this);
        this.R = new j(this, CmdConfigHttp.CMD_GET_QM_FILTERS, true);
        this.S = new k(this);
        this.T = new l(this);
        this.U = new ql5(new m(this));
    }

    public final int h2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 % 2 == 1) {
                return i2 - 1;
            }
            return i2;
        }
        return invokeI.intValue;
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

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    public final void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.setVisibility(8);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            this.i.setVisibility(8);
        }
    }

    public final void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.setVisibility(0);
            this.l.setVisibility(0);
            this.m.setVisibility(0);
            this.i.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPause();
            q2();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onResume();
            r2();
        }
    }

    public final void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ta6 ta6Var = this.t;
            if (ta6Var != null) {
                ta6Var.onPause();
            }
            ni6 ni6Var = this.u;
            if (ni6Var != null) {
                ni6Var.onPause();
            }
        }
    }

    public final void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            ta6 ta6Var = this.t;
            if (ta6Var != null) {
                ta6Var.pause();
            }
            ni6 ni6Var = this.u;
            if (ni6Var != null) {
                ni6Var.onPause();
            }
        }
    }

    public final void t2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.f.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a91));
            this.g.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a94));
        }
    }

    @Override // com.baidu.tieba.ai6
    public void e0(String str) {
        List<MultiMediaData> j2;
        zh6 zh6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && !StringUtils.isNull(str) && !str.equals(this.C)) {
            zh6 zh6Var2 = this.x;
            if (zh6Var2 != null) {
                this.E = zh6Var2.p();
            }
            this.C = str;
            if (this.j.getCurrentMode() == 2 && (zh6Var = this.x) != null) {
                zh6Var.l();
            }
            if (this.I) {
                bh.a().post(new o(this));
                if (this.H != 3) {
                    ta6 ta6Var = this.t;
                    if (ta6Var != null) {
                        ta6Var.start();
                    }
                    ni6 ni6Var = this.u;
                    if (ni6Var != null) {
                        ni6Var.onResume();
                        ta6 ta6Var2 = this.t;
                        if (ta6Var2 != null) {
                            this.u.a(((float) ta6Var2.getCurrentPlayTime()) / 1000.0f);
                        }
                    }
                }
                this.y = true;
            }
            zh6 zh6Var3 = this.x;
            if (zh6Var3 != null && (j2 = zh6Var3.j()) != null) {
                this.z.setCoverStickerList(j2);
            }
            if (this.H == 3) {
                bh.a().post(new p(this));
            }
        }
    }

    public final void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.y) {
                fw4 fw4Var = new fw4(getPageContext(), new hw4(getPageContext().getPageActivity()));
                fw4Var.i(getResources().getString(R.string.obfuscated_res_0x7f0f0553), new String[]{getResources().getString(R.string.obfuscated_res_0x7f0f1011)}, new b(this, fw4Var));
                fw4Var.k();
                return;
            }
            finish();
        }
    }

    public final void u2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.H = 2;
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0611, 0);
            t2();
            VideoControllerLayout videoControllerLayout = this.s;
            if (videoControllerLayout != null && videoControllerLayout.p()) {
                this.s.m(null, false);
            }
            this.b.setVisibility(0);
            this.c.setVisibility(0);
            bh.a().post(new e(this));
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            this.i.setVisibility(8);
        }
    }

    public final void g2() {
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

    public final void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.H = 1;
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0105, 0);
            this.b.setVisibility(8);
            this.c.setVisibility(8);
            bh.a().post(new f(this));
            this.l.setVisibility(0);
            this.m.setVisibility(0);
            this.i.setVisibility(0);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        zh6 zh6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.H == 2) {
                if (this.j.getCurrentMode() == 2 && (zh6Var = this.x) != null) {
                    zh6Var.l();
                }
                zh6 zh6Var2 = this.x;
                if (zh6Var2 != null) {
                    zh6Var2.reset();
                }
                bh.a().post(new c(this));
                l2();
                return;
            }
            f2();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroy();
            ta6 ta6Var = this.t;
            if (ta6Var != null) {
                ta6Var.onDestroy();
                if (!this.G) {
                    this.t.e();
                }
            }
            ni6 ni6Var = this.u;
            if (ni6Var != null) {
                ni6Var.releasePlayer();
                this.u.d();
            }
            wa6 wa6Var = this.w;
            if (wa6Var instanceof ya6) {
                ya6 ya6Var = (ya6) wa6Var;
            }
        }
    }

    public final void r2() {
        ni6 ni6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ViewGroup viewGroup = this.e;
            if (viewGroup != null) {
                viewGroup.setSystemUiVisibility(4100);
            }
            ta6 ta6Var = this.t;
            if (ta6Var != null) {
                ta6Var.onResume();
            }
            if (this.H == 1 && (ni6Var = this.u) != null) {
                ni6Var.onResume();
                ta6 ta6Var2 = this.t;
                if (ta6Var2 != null) {
                    this.u.a(((float) ta6Var2.getCurrentPlayTime()) / 1000.0f);
                }
            }
            mi6 mi6Var = this.v;
            if (mi6Var != null) {
                mi6Var.h();
            }
        }
    }

    public final xa6 k2() {
        InterceptResult invokeV;
        ni6 ni6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            xa6 xa6Var = new xa6();
            TbMultiMediaData tbMultiMediaData = this.z;
            float f2 = 0.0f;
            if (tbMultiMediaData != null) {
                xa6Var.j(tbMultiMediaData);
                xa6Var.n(this.B);
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
                    int h2 = h2(i2);
                    int h22 = h2(i3);
                    xa6Var.m(h2);
                    xa6Var.l(h22);
                }
            }
            mi6 mi6Var = this.v;
            if (mi6Var != null && mi6Var.b() != null) {
                QmFilterItem b2 = this.v.b();
                String str = b2.localPath;
                Filter filter = new Filter();
                if (!StringUtils.isNull(str) && !"origin".equals(str)) {
                    f2 = (yg.d(b2.effect, 100.0f) * 1.0f) / 100.0f;
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
                tbFilterValue.mComplex = yg.e(b2.complex, 0);
                tbFilterValue.mRootFilePath = str;
                xa6Var.h(tbFilterValue);
            }
            ta6 ta6Var = this.t;
            if (ta6Var != null) {
                xa6Var.i(ta6Var.getMediaTrackConfig());
            }
            TbMusicData tbMusicData = this.K;
            if (tbMusicData != null && (ni6Var = this.u) != null) {
                tbMusicData.localPath = ni6Var.b();
                xa6Var.k(this.K);
            }
            return xa6Var;
        }
        return (xa6) invokeV.objValue;
    }

    public final void m2() {
        TbMusicData tbMusicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            boolean booleanExtra = getIntent().getBooleanExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, false);
            this.k = (TbGLMediaPreviewView) findViewById(R.id.obfuscated_res_0x7f0908b5);
            this.j = (PreViewPickCoverView) findViewById(R.id.obfuscated_res_0x7f091a92);
            ci6 ci6Var = new ci6(getPageContext(), this.k, this.j, this.z, booleanExtra);
            this.x = ci6Var;
            ci6Var.d(this);
            this.I = false;
            ua6 ua6Var = new ua6(getPageContext(), this.k, this.z, this.x, booleanExtra);
            this.t = ua6Var;
            ua6Var.f(this.B);
            this.t.b(new a(this));
            this.s = (VideoControllerLayout) findViewById(R.id.obfuscated_res_0x7f091c75);
            pi6 pi6Var = new pi6(getPageContext(), this.s);
            this.u = pi6Var;
            this.s.setMusicManager(pi6Var);
            if (this.u != null && (tbMusicData = this.K) != null && !TextUtils.isEmpty(tbMusicData.localPath) && !TextUtils.isEmpty(this.K.id)) {
                TbMusicData tbMusicData2 = this.K;
                if (tbMusicData2.type == 2) {
                    this.s.setEffectLayoutCurrentMusicName(getResources().getString(R.string.obfuscated_res_0x7f0f0bb0));
                } else {
                    this.s.setEffectLayoutCurrentMusicName(tbMusicData2.title);
                }
                ni6 ni6Var = this.u;
                TbMusicData tbMusicData3 = this.K;
                ni6Var.f(tbMusicData3.localPath, tbMusicData3.id);
                ta6 ta6Var = this.t;
                if (ta6Var != null) {
                    this.u.a(((float) ta6Var.getCurrentPlayTime()) / 1000.0f);
                }
                this.s.setMusicName(this.K.title, "");
            }
            li6 li6Var = new li6(null, this.t, this.s);
            this.v = li6Var;
            li6Var.d(this.S);
            this.v.h();
            this.s.setEditManager(this.t);
            this.w = new ya6(getPageContext(), this.O);
            p2();
            QmFilterItem videoFilter = this.z.getVideoFilter();
            if (videoFilter != null) {
                this.v.a(videoFilter);
                this.s.setCurrentFilterWithQmFilterItem(videoFilter);
            }
        }
    }

    public final void n2() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.e = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091d60);
            this.a = (NavigationBar) findViewById(R.id.navigation_bar);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f0908aa);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f0904d1);
            this.g = (ImageView) findViewById(R.id.obfuscated_res_0x7f0904d3);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f0908b1);
            this.m = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0908b2);
            this.l = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0904cc);
            this.p = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0904d2);
            this.q = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0904d4);
            this.r = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0904ce);
            this.j.setVisibility(4);
            RecordPreviewContainer recordPreviewContainer = (RecordPreviewContainer) findViewById(R.id.obfuscated_res_0x7f0908b0);
            this.n = recordPreviewContainer;
            recordPreviewContainer.setOnViewClickListener(this.Q);
            TextView centerTextTitle = this.a.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0f14));
            this.b = centerTextTitle;
            centerTextTitle.setTextColor(getResources().getColor(R.color.CAM_X0101));
            this.b.setVisibility(8);
            View addSystemImageButton = this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.d = addSystemImageButton;
            ((ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button)).setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a78));
            TextView addTextButton = this.a.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.obfuscated_res_0x7f0f111f));
            this.c = addTextButton;
            addTextButton.setTextColor(getResources().getColor(R.color.CAM_X0101));
            this.c.setVisibility(8);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0904d0);
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
            cx4 d2 = cx4.d(this.h);
            d2.A(R.string.F_X02);
            d2.y(R.array.S_O_X001);
            cx4 d3 = cx4.d(findViewById(R.id.obfuscated_res_0x7f0908b1));
            d3.n(R.string.J_X01);
            d3.f(R.color.CAM_X0302);
            cx4.d(findViewById(R.id.obfuscated_res_0x7f0908b4)).y(R.array.S_O_X001);
            cx4.d(findViewById(R.id.obfuscated_res_0x7f0904d6)).y(R.array.S_O_X001);
            cx4.d(findViewById(R.id.obfuscated_res_0x7f0904d7)).y(R.array.S_O_X001);
            cx4.d(findViewById(R.id.obfuscated_res_0x7f0904d5)).y(R.array.S_O_X001);
            cx4.d(findViewById(R.id.obfuscated_res_0x7f0904d8)).y(R.array.S_O_X001);
            TbMultiMediaData tbMultiMediaData = this.z;
            if (tbMultiMediaData != null && tbMultiMediaData.coverSource == 2) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.j.setCurrentMode(2);
            } else {
                this.j.setCurrentMode(1);
            }
            if (this.H == 3) {
                g2();
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

    public final void o2() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
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
            if (this.B > 1.0f) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            albumFloatActivityConfig.setImageClipType(i2);
            albumFloatActivityConfig.setAlbumShowCapture(false);
            albumFloatActivityConfig.setAlbumDirectDoneOnlyOne(true);
            sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }
    }

    public final void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_QM_FILTERS);
            httpMessage.addParam("uh", bj.f() + "," + Build.HARDWARE + "," + Build.BOARD + "," + (b59.b(this) ? 1 : 0));
            httpMessage.addParam("ut", bj.g() + "_" + bj.k() + "_" + b59.a() + "_" + Build.BRAND.replace("_", ""));
            StringBuilder sb = new StringBuilder();
            sb.append(ze0.h());
            sb.append("");
            httpMessage.addParam("sdk_version", sb.toString());
            sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        zh6 zh6Var;
        TbMultiMediaData tbMultiMediaData;
        TbMultiMediaData tbMultiMediaData2;
        zh6 zh6Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048588, this, i2, i3, intent) == null) {
            if (intent == null) {
                if (this.j.getCurrentMode() == 2 && i2 == 12002 && (zh6Var2 = this.x) != null && !zh6Var2.o()) {
                    this.j.setCurrentMode(1);
                    this.x.l();
                }
            } else if (i2 == 25032) {
                if (i3 != -1) {
                    return;
                }
                String stringExtra = intent.getStringExtra(CloudMusicActivityConfig.MUSIC_ID);
                TbMusicData tbMusicData = (TbMusicData) intent.getSerializableExtra(CloudMusicActivityConfig.MUSIC_DATA);
                if (tbMusicData != null) {
                    this.K = tbMusicData;
                    if (!TextUtils.isEmpty(tbMusicData.localPath) && !TextUtils.isEmpty(stringExtra)) {
                        String str = tbMusicData.localPath;
                        if (this.u != null && !TextUtils.isEmpty(str)) {
                            this.u.f(str, stringExtra);
                            ta6 ta6Var = this.t;
                            if (ta6Var != null) {
                                this.u.a(((float) ta6Var.getCurrentPlayTime()) / 1000.0f);
                            }
                            this.s.y(tbMusicData);
                        }
                    }
                }
            } else if (i2 == 25062) {
                f59.c(intent, this.k);
                if (i3 == -1 && (tbMultiMediaData = (TbMultiMediaData) intent.getParcelableExtra(TbEditVideoActivityConfig.KEY_EDIT_VIDEO_DATA)) != null && this.t != null && (tbMultiMediaData2 = this.z) != null && (tbMultiMediaData.start != tbMultiMediaData2.start || tbMultiMediaData.end != tbMultiMediaData2.end)) {
                    this.z = tbMultiMediaData;
                    this.t.c(tbMultiMediaData);
                    this.s.post(new n(this));
                    this.y = true;
                }
                j2();
            } else if (i2 == 12002) {
                if (i3 == -1) {
                    String stringExtra2 = intent.getStringExtra(VideoCoverSelectActivityConfig.KEY_VIDEO_COVER_IMAGE_PATH);
                    if (!TextUtils.isEmpty(stringExtra2) && (zh6Var = this.x) != null) {
                        zh6Var.m(stringExtra2);
                        this.D = stringExtra2;
                        return;
                    }
                    return;
                }
                zh6 zh6Var3 = this.x;
                if (zh6Var3 != null && !zh6Var3.o()) {
                    this.j.setCurrentMode(1);
                    this.x.l();
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        zh6 zh6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            super.onClick(view2);
            if (view2.getId() == R.id.obfuscated_res_0x7f0904d2) {
                t2();
                if (this.s.q()) {
                    this.f.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a91));
                } else {
                    this.f.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a93));
                }
                this.s.v();
                if (this.s.t()) {
                    p2();
                    return;
                }
                return;
            }
            int i2 = 2;
            if (view2.getId() == R.id.obfuscated_res_0x7f0904d4) {
                t2();
                if (this.s.s()) {
                    this.g.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a94));
                } else {
                    this.g.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080a95));
                }
                this.s.w();
                TbMusicData tbMusicData = this.K;
                if (tbMusicData != null && tbMusicData.type == 2) {
                    this.s.postDelayed(new g(this), 300L);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0904d0) {
                TbFileVideoActivityConfig tbFileVideoActivityConfig = new TbFileVideoActivityConfig(getPageContext().getPageActivity());
                tbFileVideoActivityConfig.setForResult();
                tbFileVideoActivityConfig.setFrom(2);
                tbFileVideoActivityConfig.setTbMultiMediaData(this.z);
                mi6 mi6Var = this.v;
                if (mi6Var != null && mi6Var.b() != null) {
                    tbFileVideoActivityConfig.setFilter(this.v.b());
                }
                tbFileVideoActivityConfig.setEnterAnimValues(f59.a(this.k));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbFileVideoActivityConfig));
                i2();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0904ce) {
                zh6 zh6Var2 = this.x;
                if (zh6Var2 != null) {
                    zh6Var2.i(this.E);
                    s2();
                    if (this.j.getCurrentMode() == 2 && !StringUtils.isNull(this.D)) {
                        this.x.m(this.D);
                    } else {
                        this.j.setCurrentMode(1);
                    }
                    this.x.q(this.z.getCoverStickerList());
                    u2();
                }
                cz4.l().v("key_edit_video_pick_cover_tip_show", true);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0908b2) {
                if (this.w != null) {
                    this.F = true;
                    s2();
                    this.w.a(k2());
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0908b1) {
                if (WorkPublishManager.isWorkPublishLocate()) {
                    int i3 = this.L;
                    if (i3 != 1) {
                        if (i3 == 2) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                    }
                    TiebaStatic.log(new StatisticItem("c14310").param("obj_source", i2));
                }
                if (!cz4.l().i("key_edit_video_pick_cover_tip_show", false)) {
                    pa6 pa6Var = new pa6(getPageContext(), this.r);
                    pa6Var.L(R.drawable.pic_sign_tip_right);
                    pa6Var.l(1);
                    pa6Var.N(true);
                    pa6Var.C(R.color.CAM_X0101);
                    pa6Var.J(R.dimen.T_X08);
                    pa6Var.p(R.dimen.T_X08);
                    pa6Var.F(UtilHelper.getDimenPixelSize(R.dimen.tbds26));
                    pa6Var.I(UtilHelper.getDimenPixelSize(R.dimen.tbds26));
                    pa6Var.S(getResources().getString(R.string.obfuscated_res_0x7f0f0555));
                    cz4.l().v("key_edit_video_pick_cover_tip_show", true);
                    return;
                }
                s2();
                this.w.a(k2());
                VideoFileInfo c2 = y49.c(this.z.path);
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
                    editVideoData.coverPath = o59.b;
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
                if (!WorkPublishOpenHelper.Companion.e(getIntent(), this.A, getPageContext().getPageActivity(), true, true)) {
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
                }
            } else if (view2 == this.d) {
                onBackPressed();
            } else if (view2 == this.c) {
                int i4 = this.H;
                if (i4 == 2) {
                    zh6 zh6Var3 = this.x;
                    if (zh6Var3 != null) {
                        this.I = true;
                        zh6Var3.f();
                    }
                    l2();
                } else if (i4 == 3 && (zh6Var = this.x) != null) {
                    this.I = true;
                    zh6Var.f();
                }
            } else if (view2.getId() == this.j.getVideoPick().getId()) {
                if (this.j.getCurrentMode() != 1) {
                    this.j.setCurrentMode(1);
                    zh6 zh6Var4 = this.x;
                    if (zh6Var4 != null) {
                        zh6Var4.i(this.E);
                        this.x.l();
                    }
                }
            } else if (view2.getId() == this.j.getImagePick().getId()) {
                if (this.j.getCurrentMode() != 2) {
                    this.j.setCurrentMode(2);
                    zh6 zh6Var5 = this.x;
                    if (zh6Var5 != null) {
                        this.E = zh6Var5.p();
                    }
                    o2();
                }
            } else if (view2.getId() == this.j.getCoverImageView().getId() && this.j.getCurrentMode() == 2) {
                o2();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0053);
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
            m2();
            n2();
            registerListener(this.R);
        }
    }
}
