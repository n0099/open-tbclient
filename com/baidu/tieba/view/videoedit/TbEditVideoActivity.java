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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.DeviceInfoHelper;
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
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.MediaScannerClient;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tbadk.data.TbMusicData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.ay6;
import com.baidu.tieba.cy6;
import com.baidu.tieba.external.filter.ResponseGetQmFiltersMessage;
import com.baidu.tieba.external.filter.TbFilterValue;
import com.baidu.tieba.external.music.data.MusicData;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
import com.baidu.tieba.fa0;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.ioa;
import com.baidu.tieba.jva;
import com.baidu.tieba.lx9;
import com.baidu.tieba.ly6;
import com.baidu.tieba.my6;
import com.baidu.tieba.no6;
import com.baidu.tieba.ny6;
import com.baidu.tieba.pva;
import com.baidu.tieba.py6;
import com.baidu.tieba.pz4;
import com.baidu.tieba.rz4;
import com.baidu.tieba.so6;
import com.baidu.tieba.tna;
import com.baidu.tieba.to6;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.tieba.view.widget.RecordPreviewContainer;
import com.baidu.tieba.view.widget.TbGLMediaPreviewView;
import com.baidu.tieba.view.widget.pickcover.PreViewPickCoverView;
import com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout;
import com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout;
import com.baidu.tieba.vna;
import com.baidu.tieba.xs5;
import com.baidu.tieba.zna;
import com.baidu.tieba.zs5;
import com.baidu.tieba.zx6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.muxer.VideoMuxer;
import com.baidubce.auth.NTLMEngineImpl;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class TbEditVideoActivity extends BaseActivity<TbEditVideoActivity> implements ay6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float A;
    public String B;
    public String C;
    public float D;
    public boolean E;
    public boolean F;
    public int G;
    public boolean H;
    public TbMusicData I;
    public TbMusicData J;
    public int K;
    public float L;
    public float M;
    public VideoMuxer N;
    public s O;
    public Runnable P;
    public CustomMessageListener Q;
    public RecordPreviewContainer.g R;
    public HttpMessageListener S;

    /* renamed from: T  reason: collision with root package name */
    public ly6.b f1175T;
    public RecordEffectLayout.i U;
    @NonNull
    public final xs5 V;
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
    public so6 t;
    public ny6 u;
    public my6 v;
    public zx6 w;
    public boolean x;
    public TbMultiMediaData y;
    public VideoInfo z;

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        /* loaded from: classes8.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    this.a.a.j.setVisibility(0);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ float a;
            public final /* synthetic */ g b;

            public b(g gVar, float f) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, Float.valueOf(f)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = gVar;
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
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a.j, Key.TRANSLATION_Y, this.a.j.getHeight(), 0.0f);
                ofFloat.setDuration(250L);
                ofFloat.addListener(new a(this));
                int height = this.a.a.getHeight();
                int height2 = this.a.j.getHeight();
                int equipmentHeight = BdUtilHelper.getEquipmentHeight(this.a.getPageContext().getPageActivity());
                float equipmentWidth = BdUtilHelper.getEquipmentWidth(this.a.getPageContext().getPageActivity()) * this.a.A;
                this.a.L = (equipmentHeight - height) - height2;
                float equipmentWidth2 = (this.a.L * 1.0f) / BdUtilHelper.getEquipmentWidth(this.a.getPageContext().getPageActivity());
                TbEditVideoActivity tbEditVideoActivity = this.a;
                tbEditVideoActivity.M = height - ((equipmentHeight - tbEditVideoActivity.L) * 0.5f);
                ObjectAnimator duration = ObjectAnimator.ofFloat(this.a.n, Key.TRANSLATION_Y, 0.0f, this.a.M).setDuration(250L);
                if (this.a.A > equipmentWidth2) {
                    ValueAnimator ofFloat2 = ValueAnimator.ofFloat(equipmentWidth, this.a.L);
                    ofFloat2.addUpdateListener(new b(this, equipmentWidth));
                    ofFloat2.setDuration(250L);
                    ofFloat2.start();
                }
                ofFloat.start();
                duration.start();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        /* loaded from: classes8.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    this.a.a.j.setVisibility(8);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ float a;
            public final /* synthetic */ h b;

            public b(h hVar, float f) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, Float.valueOf(f)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = hVar;
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
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a.j, Key.TRANSLATION_Y, 0.0f, this.a.j.getHeight());
                ofFloat.setDuration(250L);
                ofFloat.addListener(new a(this));
                int height = this.a.a.getHeight();
                int height2 = this.a.j.getHeight();
                int equipmentHeight = BdUtilHelper.getEquipmentHeight(this.a.getPageContext().getPageActivity());
                float equipmentWidth = BdUtilHelper.getEquipmentWidth(this.a.getPageContext().getPageActivity()) * this.a.A;
                this.a.L = (equipmentHeight - height) - height2;
                float equipmentWidth2 = (this.a.L * 1.0f) / BdUtilHelper.getEquipmentWidth(this.a.getPageContext().getPageActivity());
                TbEditVideoActivity tbEditVideoActivity = this.a;
                tbEditVideoActivity.M = height - ((equipmentHeight - tbEditVideoActivity.L) * 0.5f);
                ObjectAnimator duration = ObjectAnimator.ofFloat(this.a.n, Key.TRANSLATION_Y, 0.0f, this.a.M).setDuration(250L);
                if (this.a.A > equipmentWidth2) {
                    ValueAnimator ofFloat2 = ValueAnimator.ofFloat(equipmentWidth, this.a.L);
                    ofFloat2.addUpdateListener(new b(this, equipmentWidth));
                    ofFloat2.setDuration(250L);
                    ofFloat2.reverse();
                }
                ofFloat.start();
                duration.reverse();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k a;

            public a(k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = kVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.t.f(this.a.a.n.getWidth(), this.a.a.n.getHeight());
                    this.a.a.t.h();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(TbEditVideoActivity tbEditVideoActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity, Integer.valueOf(i)};
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
            this.a = tbEditVideoActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.n != null) {
                this.a.n.requestLayout();
                this.a.n.post(new a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ p a;

            public a(p pVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = pVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.w.c();
                }
            }
        }

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
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.G == 3) {
                    if (this.a.y != null && this.a.y.coverSource == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (this.a.w != null) {
                        if (z) {
                            if (!StringUtils.isNull(this.a.C)) {
                                this.a.w.m(this.a.C);
                            } else {
                                this.a.w.l();
                            }
                        } else {
                            this.a.w.i(this.a.D);
                        }
                        this.a.w.q(this.a.y.getCoverStickerList());
                    }
                }
                if (this.a.w != null && TextUtils.isEmpty(this.a.B)) {
                    SafeHandler.getInst().postDelayed(new a(this), 300L);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class s implements zs5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<TbEditVideoActivity> a;

        @Override // com.baidu.tieba.zs5.b
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TbEditVideoActivity a;

            public a(s sVar, TbEditVideoActivity tbEditVideoActivity) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar, tbEditVideoActivity};
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

        public s(TbEditVideoActivity tbEditVideoActivity) {
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

        @Override // com.baidu.tieba.zs5.b
        public void b() {
            TbEditVideoActivity tbEditVideoActivity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (tbEditVideoActivity = this.a.get()) != null) {
                tbEditVideoActivity.showLoadingView(tbEditVideoActivity.e);
            }
        }

        @Override // com.baidu.tieba.zs5.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                e();
            }
        }

        public final void e() {
            TbEditVideoActivity tbEditVideoActivity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (tbEditVideoActivity = this.a.get()) != null) {
                tbEditVideoActivity.runOnUiThread(new a(this, tbEditVideoActivity));
            }
        }

        @Override // com.baidu.tieba.zs5.b
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                TbEditVideoActivity tbEditVideoActivity = this.a.get();
                File file = new File(str);
                File file2 = new File(ioa.g);
                if (!file2.exists()) {
                    file2.mkdir();
                }
                String str2 = ioa.g + file.getName();
                if (!str2.equals(file.getAbsolutePath())) {
                    FileHelper.copyFileByAbsolutelyPath(file.getAbsolutePath(), str2);
                }
                new MediaScannerClient(tbEditVideoActivity.getActivity()).saveVideo(str2);
                try {
                    Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                    intent.setData(UtilHelper.getUriFromFile(file, intent, tbEditVideoActivity.getPageContext().getPageActivity()));
                    tbEditVideoActivity.sendBroadcast(intent);
                } catch (Exception e) {
                    tbEditVideoActivity.E = false;
                    tbEditVideoActivity.N1();
                    tbEditVideoActivity.O1();
                    BdLog.d(e.getMessage());
                }
                tbEditVideoActivity.E = false;
                tbEditVideoActivity.showToast(tbEditVideoActivity.getResources().getString(R.string.save_success));
                tbEditVideoActivity.N1();
                tbEditVideoActivity.O1();
                e();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TbEditVideoActivity tbEditVideoActivity = this.a;
                tbEditVideoActivity.showToast(tbEditVideoActivity.getString(R.string.obfuscated_res_0x7f0f0623));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        public b(TbEditVideoActivity tbEditVideoActivity) {
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
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (c = tna.c(this.a.y.path)) == null) {
                return;
            }
            this.a.z = new VideoInfo();
            this.a.z.setVideoPath(this.a.y.path);
            this.a.z.setThumbPath(this.a.B);
            this.a.z.setVideoDuration((int) (c.videoDuration / 1000.0f));
            this.a.z.setVideoWidth(c.videoWidth);
            this.a.z.setVideoHeight(c.videoHeight);
            this.a.z.setVideoLength(new File(this.a.y.path).length());
            this.a.z.setVideoSource(this.a.y.videoInfoSource);
            this.a.z.setIsCompressedVideo(true);
            EditVideoData editVideoData = new EditVideoData();
            if (StringUtils.isNull(this.a.B)) {
                editVideoData.coverPath = ioa.b;
            } else {
                editVideoData.coverPath = this.a.B;
            }
            editVideoData.originPath = this.a.z.getVideoPath();
            this.a.z.setEditVideoData(editVideoData);
            this.a.y.coverSource = this.a.j.getCurrentMode();
            this.a.y.coverPath = this.a.B;
            this.a.y.orignalCoverPath = this.a.C;
            this.a.y.lastCoverPercent = this.a.D;
            this.a.z.setMultiMediaData(this.a.y);
            if (!WorkPublishOpenHelper.Companion.e(this.a.getIntent(), this.a.z, this.a.getPageContext().getPageActivity(), false, true)) {
                WriteActivityConfig newInstance = WriteActivityConfig.newInstance(this.a.getPageContext().getPageActivity());
                newInstance.getIntent().putExtras(this.a.getIntent());
                String stringExtra = newInstance.getIntent().getStringExtra("forum_id");
                if (TextUtils.isEmpty(stringExtra)) {
                    stringExtra = "0";
                }
                newInstance.getIntent().putExtra("forum_id", stringExtra);
                newInstance.getIntent().setFlags(NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
                newInstance.getIntent().setFlags(67108864);
                newInstance.setType(9).setVideoInfo(this.a.z).send();
                this.a.finish();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements so6.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        @Override // com.baidu.tieba.so6.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

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

        @Override // com.baidu.tieba.so6.a
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.u != null) {
                this.a.u.a(0.0f);
            }
        }

        @Override // com.baidu.tieba.so6.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a.G != 1) {
                    this.a.P1();
                }
                this.a.V.a();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements rz4.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pz4 a;
        public final /* synthetic */ TbEditVideoActivity b;

        public d(TbEditVideoActivity tbEditVideoActivity, pz4 pz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity, pz4Var};
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
            this.a = pz4Var;
        }

        @Override // com.baidu.tieba.rz4.f
        public void G0(rz4 rz4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, rz4Var, i, view2) == null) {
                if (i == 0) {
                    this.b.finish();
                } else {
                    this.a.dismiss();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

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

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

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
                this.a.j.setVisibility(0);
                int height = this.a.a.getHeight();
                int height2 = this.a.j.getHeight();
                int equipmentHeight = BdUtilHelper.getEquipmentHeight(this.a.getPageContext().getPageActivity());
                float equipmentWidth = BdUtilHelper.getEquipmentWidth(this.a.getPageContext().getPageActivity()) * this.a.A;
                this.a.L = (equipmentHeight - height) - height2;
                float equipmentWidth2 = (this.a.L * 1.0f) / BdUtilHelper.getEquipmentWidth(this.a.getPageContext().getPageActivity());
                TbEditVideoActivity tbEditVideoActivity = this.a;
                tbEditVideoActivity.M = height - ((equipmentHeight - tbEditVideoActivity.L) * 0.5f);
                this.a.n.setTranslationY(this.a.M);
                if (this.a.A > equipmentWidth2) {
                    this.a.k.setScaleX(this.a.L / equipmentWidth);
                    this.a.k.setScaleY(this.a.L / equipmentWidth);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.s.setMusicName(this.a.J.title, this.a.J.icon);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        public j(TbEditVideoActivity tbEditVideoActivity) {
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

    /* loaded from: classes8.dex */
    public class l implements RecordPreviewContainer.g {
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

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.g
        public void a(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) && this.a.G == 1 && this.a.v != null) {
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

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.g
        public void b(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent) == null) && this.a.G == 1 && this.a.v != null) {
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

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.g
        public void c(MotionEvent motionEvent, float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, Float.valueOf(f), Float.valueOf(f2)}) == null) {
                this.a.Q1();
                if (this.a.s != null && this.a.s.p()) {
                    this.a.s.m(null, false);
                }
            }
        }

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.g
        public void d(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, motionEvent) == null) {
                this.a.Q1();
                if (this.a.s != null && this.a.s.p()) {
                    this.a.s.m(null, false);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(TbEditVideoActivity tbEditVideoActivity, int i, boolean z) {
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
                qmFilterItem.bgurl = R.drawable.obfuscated_res_0x7f080c51 + "";
                qmFilterItem.name = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0750);
                qmFilterItem.isSelect = true;
                qmFilterItem.localPath = "origin";
                list.add(0, qmFilterItem);
                this.a.s.setFilterData(list);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n implements ly6.b {
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

        @Override // com.baidu.tieba.ly6.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.s != null) {
                    QmFilterItem qmFilterItem = new QmFilterItem();
                    qmFilterItem.id = "-1";
                    qmFilterItem.bgurl = R.drawable.obfuscated_res_0x7f080c51 + "";
                    qmFilterItem.name = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0750);
                    qmFilterItem.isSelect = true;
                    qmFilterItem.localPath = "origin";
                    this.a.s.z(qmFilterItem);
                    if (this.a.v != null) {
                        this.a.v.a(null);
                    }
                    this.a.s.setDownLoadFilter(null);
                }
                if (StringUtils.isNull(str)) {
                    str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1493);
                }
                this.a.showToast(str);
            }
        }

        @Override // com.baidu.tieba.ly6.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.s != null) {
                this.a.s.setDownLoadFilter(null);
            }
        }

        @Override // com.baidu.tieba.ly6.b
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

    /* loaded from: classes8.dex */
    public class o implements RecordEffectLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void a(QmStickerItem qmStickerItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, qmStickerItem) == null) {
            }
        }

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

        @Override // com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout.i
        public void b(jva jvaVar, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jvaVar, obj) != null) || jvaVar == null) {
                return;
            }
            int c = jvaVar.c();
            if (c != 2) {
                if (c == 3 && (jvaVar.d() instanceof MusicData)) {
                    MusicData musicData = (MusicData) jvaVar.d();
                    TbMusicData tbMusicData = new TbMusicData();
                    tbMusicData.id = musicData.id;
                    tbMusicData.title = musicData.name;
                    tbMusicData.url = musicData.resource;
                    tbMusicData.icon = musicData.img;
                    tbMusicData.type = JavaTypesHelper.toInt(musicData.type, 1);
                    if (MusicData.MUSIC_NORMAL_ID.equals(musicData.id) || MusicData.MUSIC_CLOUD_ID.equals(musicData.id)) {
                        this.a.u.f(this.a.J);
                        this.a.J = tbMusicData;
                        if (!MusicData.MUSIC_CLOUD_ID.equals(musicData.id)) {
                            this.a.s.setMusicName(this.a.J.title, "");
                        }
                    } else {
                        this.a.J = tbMusicData;
                        this.a.u.f(this.a.J);
                        this.a.s.setMusicName(this.a.J.title, "");
                    }
                    if (!MusicData.MUSIC_CLOUD_ID.equals(musicData.id)) {
                        this.a.s.setMusicName(this.a.J.title, "");
                    }
                    this.a.u.d((MusicData) jvaVar.d(), obj);
                    if (this.a.t != null) {
                        this.a.u.a(((float) this.a.t.getCurrentPlayTime()) / 1000.0f);
                    }
                    this.a.x = true;
                }
            } else if (this.a.v != null && (jvaVar.d() instanceof QmFilterItem)) {
                QmFilterItem qmFilterItem = (QmFilterItem) jvaVar.d();
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
                this.a.x = true;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

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
            this.a = tbEditVideoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.t.f(this.a.n.getWidth(), this.a.n.getHeight());
                this.a.t.g(this.a.A);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        public r(TbEditVideoActivity tbEditVideoActivity) {
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
        this.x = false;
        this.E = false;
        this.F = false;
        this.G = 1;
        this.H = false;
        this.L = BdUtilHelper.getEquipmentHeight(getPageContext().getPageActivity());
        this.M = 0.0f;
        this.O = new s(this);
        this.P = new j(this);
        this.Q = new k(this, 2921414);
        this.R = new l(this);
        this.S = new m(this, CmdConfigHttp.CMD_GET_QM_FILTERS, true);
        this.f1175T = new n(this);
        this.U = new o(this);
        this.V = new xs5(new p(this));
    }

    public final int E1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048601, this, view2) == null) {
            super.showLoadingView(view2);
            if (getLoadingView() != null && getLoadingView().getLoadingTextView() != null) {
                getLoadingView().getLoadingTextView().setVisibility(8);
            }
        }
    }

    public final void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.x) {
                pz4 pz4Var = new pz4(getPageContext(), new rz4(getPageContext().getPageActivity()));
                pz4Var.i(getResources().getString(R.string.obfuscated_res_0x7f0f0622), new String[]{getResources().getString(R.string.obfuscated_res_0x7f0f11ea)}, new d(this, pz4Var));
                pz4Var.l();
                return;
            }
            finish();
        }
    }

    public final void R1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.G = 2;
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0611, 0);
            Q1();
            VideoControllerLayout videoControllerLayout = this.s;
            if (videoControllerLayout != null && videoControllerLayout.p()) {
                this.s.m(null, false);
            }
            this.b.setVisibility(0);
            this.c.setVisibility(0);
            SafeHandler.getInst().post(new g(this));
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            this.i.setVisibility(8);
        }
    }

    public final void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.setVisibility(0);
            this.c.setVisibility(0);
            this.j.post(new f(this));
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            this.i.setVisibility(8);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0611, 0);
        }
    }

    public final void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.G = 1;
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0105, 0);
            this.b.setVisibility(8);
            this.c.setVisibility(8);
            SafeHandler.getInst().post(new h(this));
            this.l.setVisibility(0);
            this.m.setVisibility(0);
            this.i.setVisibility(0);
        }
    }

    public final void O1() {
        ny6 ny6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ViewGroup viewGroup = this.e;
            if (viewGroup != null) {
                viewGroup.setSystemUiVisibility(4100);
            }
            so6 so6Var = this.t;
            if (so6Var != null) {
                so6Var.onResume();
            }
            if (this.G == 1 && (ny6Var = this.u) != null) {
                ny6Var.onResume();
                so6 so6Var2 = this.t;
                if (so6Var2 != null) {
                    this.u.a(((float) so6Var2.getCurrentPlayTime()) / 1000.0f);
                }
            }
            my6 my6Var = this.v;
            if (my6Var != null) {
                my6Var.h();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onBackPressed() {
        zx6 zx6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.G == 2) {
                if (this.j.getCurrentMode() == 2 && (zx6Var = this.w) != null) {
                    zx6Var.l();
                }
                zx6 zx6Var2 = this.w;
                if (zx6Var2 != null) {
                    zx6Var2.reset();
                }
                SafeHandler.getInst().post(new e(this));
                J1();
                return;
            }
            C1();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onDestroy();
            so6 so6Var = this.t;
            if (so6Var != null) {
                so6Var.onDestroy();
                if (!this.F) {
                    this.t.e();
                }
            }
            ny6 ny6Var = this.u;
            if (ny6Var != null) {
                ny6Var.b();
                this.u.e();
            }
            VideoMuxer videoMuxer = this.N;
            if (videoMuxer != null) {
                videoMuxer.interruptProcess();
            }
        }
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.setVisibility(8);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            this.i.setVisibility(8);
        }
    }

    public final void G1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.setVisibility(0);
            this.l.setVisibility(0);
            this.m.setVisibility(0);
            this.i.setVisibility(0);
        }
    }

    public final void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            so6 so6Var = this.t;
            if (so6Var != null) {
                so6Var.onPause();
            }
            ny6 ny6Var = this.u;
            if (ny6Var != null) {
                ny6Var.onPause();
            }
        }
    }

    public final void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            so6 so6Var = this.t;
            if (so6Var != null) {
                so6Var.pause();
            }
            ny6 ny6Var = this.u;
            if (ny6Var != null) {
                ny6Var.onPause();
            }
        }
    }

    public final void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c50));
            this.g.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c53));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.n.post(new q(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onPause();
            N1();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onResume();
            O1();
        }
    }

    public final pva I1() {
        InterceptResult invokeV;
        ny6 ny6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            pva pvaVar = new pva();
            TbMultiMediaData tbMultiMediaData = this.y;
            float f2 = 0.0f;
            if (tbMultiMediaData != null) {
                pvaVar.j(tbMultiMediaData);
                pvaVar.n(this.A);
                TbMultiMediaData tbMultiMediaData2 = this.y;
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
                    float f6 = this.A;
                    if (f6 > (f4 * 1.0f) / f5) {
                        i3 = (int) (f5 * f6);
                    } else if (f6 != 0.0f) {
                        i2 = (int) (f4 / f6);
                    }
                    int E1 = E1(i2);
                    int E12 = E1(i3);
                    pvaVar.m(E1);
                    pvaVar.l(E12);
                }
            }
            my6 my6Var = this.v;
            if (my6Var != null && my6Var.b() != null) {
                QmFilterItem b2 = this.v.b();
                String str = b2.localPath;
                Filter filter = new Filter();
                if (!StringUtils.isNull(str) && !"origin".equals(str)) {
                    f2 = (JavaTypesHelper.toFloat(b2.effect, 100.0f) * 1.0f) / 100.0f;
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
                tbFilterValue.mComplex = JavaTypesHelper.toInt(b2.complex, 0);
                tbFilterValue.mRootFilePath = str;
                pvaVar.h(tbFilterValue);
            }
            so6 so6Var = this.t;
            if (so6Var != null) {
                pvaVar.i(so6Var.getMediaTrackConfig());
            }
            TbMusicData tbMusicData = this.J;
            if (tbMusicData != null && (ny6Var = this.u) != null) {
                tbMusicData.localPath = ny6Var.c();
                pvaVar.k(this.J);
            }
            return pvaVar;
        }
        return (pva) invokeV.objValue;
    }

    public final void K1() {
        TbMusicData tbMusicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            boolean booleanExtra = getIntent().getBooleanExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, false);
            this.k = (TbGLMediaPreviewView) findViewById(R.id.obfuscated_res_0x7f09099c);
            this.j = (PreViewPickCoverView) findViewById(R.id.obfuscated_res_0x7f091cac);
            cy6 cy6Var = new cy6(getPageContext(), this.k, this.j, this.y, booleanExtra);
            this.w = cy6Var;
            cy6Var.d(this);
            this.H = false;
            to6 to6Var = new to6(getPageContext(), this.k, this.y, this.w, booleanExtra);
            this.t = to6Var;
            to6Var.b(new c(this));
            this.s = (VideoControllerLayout) findViewById(R.id.obfuscated_res_0x7f091eb2);
            py6 py6Var = new py6(getPageContext(), this.s);
            this.u = py6Var;
            this.s.setMusicManager(py6Var);
            if (this.u != null && (tbMusicData = this.J) != null && !TextUtils.isEmpty(tbMusicData.localPath) && !TextUtils.isEmpty(this.J.id)) {
                TbMusicData tbMusicData2 = this.J;
                if (tbMusicData2.type == 2) {
                    this.s.setEffectLayoutCurrentMusicName(getResources().getString(R.string.obfuscated_res_0x7f0f0d20));
                } else {
                    this.s.setEffectLayoutCurrentMusicName(tbMusicData2.title);
                }
                ny6 ny6Var = this.u;
                TbMusicData tbMusicData3 = this.J;
                ny6Var.g(tbMusicData3.localPath, tbMusicData3.id);
                so6 so6Var = this.t;
                if (so6Var != null) {
                    this.u.a(((float) so6Var.getCurrentPlayTime()) / 1000.0f);
                }
                this.s.setMusicName(this.J.title, "");
            }
            ly6 ly6Var = new ly6(null, this.t, this.s);
            this.v = ly6Var;
            ly6Var.d(this.f1175T);
            this.v.h();
            this.s.setEditManager(this.t);
            M1();
            QmFilterItem videoFilter = this.y.getVideoFilter();
            if (videoFilter != null) {
                this.v.a(videoFilter);
                this.s.setCurrentFilterWithQmFilterItem(videoFilter);
            }
        }
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_QM_FILTERS);
            if (lx9.b()) {
                httpMessage.addParam(HttpRequest.UH, DeviceInfoHelper.getManufacturer() + "," + Build.HARDWARE + "," + Build.BOARD + "," + (vna.b(this) ? 1 : 0));
                httpMessage.addParam("ut", DeviceInfoHelper.getModel() + "_" + DeviceInfoHelper.getOsVersion() + "_" + vna.a() + "_" + Build.BRAND.replace("_", ""));
            } else {
                httpMessage.addParam(HttpRequest.NEED_DECRYPT, lx9.c());
                String g2 = lx9.g(HttpRequest.UH);
                if (!TextUtils.isEmpty(g2)) {
                    httpMessage.addParam(g2, lx9.a(DeviceInfoHelper.getManufacturer() + "," + Build.HARDWARE + "," + Build.BOARD + "," + (vna.b(this) ? 1 : 0)));
                }
                String g3 = lx9.g("ut");
                if (!TextUtils.isEmpty(g3)) {
                    httpMessage.addParam(g3, lx9.a(DeviceInfoHelper.getModel() + "_" + DeviceInfoHelper.getOsVersion() + "_" + vna.a() + "_" + Build.BRAND.replace("_", "")));
                }
            }
            httpMessage.addParam("sdk_version", fa0.i() + "");
            sendMessage(httpMessage);
        }
    }

    public final void L1() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            WriteData writeData = new WriteData();
            new FrsTabInfoData();
            new PostPrefixData();
            boolean booleanExtra = getIntent().getBooleanExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, false);
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), writeImagesInfo.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra(AlbumActivityConfig.IS_SELECT_DIRECTLY, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", writeData.getForumId());
            albumFloatActivityConfig.getIntent().putExtra("forum_name", writeData.getForumName());
            albumFloatActivityConfig.getIntent().putExtra("from", "write");
            albumFloatActivityConfig.getIntent().putExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, booleanExtra);
            albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
            albumFloatActivityConfig.setAlbumThread(0);
            albumFloatActivityConfig.setCanSelectVideo(false);
            albumFloatActivityConfig.setCanSelectGif(false);
            albumFloatActivityConfig.setCanEditImage(false);
            albumFloatActivityConfig.setNeedClipImage(true);
            if (this.A > 1.0f) {
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

    public final void initView() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.e = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091fc1);
            this.a = (NavigationBar) findViewById(R.id.navigation_bar);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f090991);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f090560);
            this.g = (ImageView) findViewById(R.id.obfuscated_res_0x7f090562);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f090998);
            this.m = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090999);
            this.l = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09055b);
            this.p = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090561);
            this.q = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090563);
            this.r = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09055d);
            this.j.setVisibility(4);
            RecordPreviewContainer recordPreviewContainer = (RecordPreviewContainer) findViewById(R.id.obfuscated_res_0x7f090997);
            this.n = recordPreviewContainer;
            recordPreviewContainer.setOnViewClickListener(this.R);
            TextView centerTextTitle = this.a.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f10d5));
            this.b = centerTextTitle;
            centerTextTitle.setTextColor(getResources().getColor(R.color.CAM_X0101));
            this.b.setVisibility(8);
            View addSystemImageButton = this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.d = addSystemImageButton;
            ((ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button)).setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c37));
            TextView addTextButton = this.a.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.obfuscated_res_0x7f0f1303));
            this.c = addTextButton;
            addTextButton.setTextColor(getResources().getColor(R.color.CAM_X0101));
            this.c.setVisibility(8);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09055f);
            this.o = relativeLayout;
            int i2 = 0;
            if (this.K == 1) {
                relativeLayout.setVisibility(8);
            } else {
                relativeLayout.setVisibility(0);
            }
            if (this.s.getRecrodButton() != null) {
                this.s.getRecrodButton().setVisibility(8);
            }
            this.s.setEffectChoosedListener(this.U);
            this.d.setOnClickListener(this);
            this.c.setOnClickListener(this);
            this.j.setOnClickListener(this);
            this.i.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.o.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.n.h(this.e);
            EMManager.from(this.h).setTextStyle(R.string.F_X02).setTextShadow(R.array.S_O_X001);
            EMManager.from(findViewById(R.id.obfuscated_res_0x7f090998)).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0302);
            EMManager.from(findViewById(R.id.obfuscated_res_0x7f09099b)).setTextShadow(R.array.S_O_X001);
            EMManager.from(findViewById(R.id.obfuscated_res_0x7f090567)).setTextShadow(R.array.S_O_X001);
            EMManager.from(findViewById(R.id.obfuscated_res_0x7f090568)).setTextShadow(R.array.S_O_X001);
            EMManager.from(findViewById(R.id.obfuscated_res_0x7f090566)).setTextShadow(R.array.S_O_X001);
            EMManager.from(findViewById(R.id.obfuscated_res_0x7f090569)).setTextShadow(R.array.S_O_X001);
            TbMultiMediaData tbMultiMediaData = this.y;
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
            if (this.G == 3) {
                D1();
                this.V.b();
            } else if (WorkPublishManager.isWorkPublishLocate()) {
                int i3 = this.K;
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
        zx6 zx6Var;
        TbMultiMediaData tbMultiMediaData;
        TbMultiMediaData tbMultiMediaData2;
        zx6 zx6Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048594, this, i2, i3, intent) == null) {
            if (intent == null) {
                if (this.j.getCurrentMode() == 2 && i2 == 12002 && (zx6Var2 = this.w) != null && !zx6Var2.o()) {
                    this.j.setCurrentMode(1);
                    this.w.l();
                }
            } else if (i2 == 25032) {
                if (i3 != -1) {
                    return;
                }
                String stringExtra = intent.getStringExtra(CloudMusicActivityConfig.MUSIC_ID);
                TbMusicData tbMusicData = (TbMusicData) intent.getSerializableExtra(CloudMusicActivityConfig.MUSIC_DATA);
                if (tbMusicData != null) {
                    this.J = tbMusicData;
                    if (!TextUtils.isEmpty(tbMusicData.localPath) && !TextUtils.isEmpty(stringExtra)) {
                        String str = tbMusicData.localPath;
                        if (this.u != null && !TextUtils.isEmpty(str)) {
                            this.u.g(str, stringExtra);
                            so6 so6Var = this.t;
                            if (so6Var != null) {
                                this.u.a(((float) so6Var.getCurrentPlayTime()) / 1000.0f);
                            }
                            this.s.y(tbMusicData);
                        }
                    }
                }
            } else if (i2 == 25062) {
                zna.c(intent, this.k);
                if (i3 == -1 && (tbMultiMediaData = (TbMultiMediaData) intent.getParcelableExtra(TbEditVideoActivityConfig.KEY_EDIT_VIDEO_DATA)) != null && this.t != null && (tbMultiMediaData2 = this.y) != null && (tbMultiMediaData.start != tbMultiMediaData2.start || tbMultiMediaData.end != tbMultiMediaData2.end)) {
                    this.y = tbMultiMediaData;
                    this.t.c(tbMultiMediaData);
                    this.s.post(new r(this));
                    this.x = true;
                }
                G1();
            } else if (i2 == 12002) {
                if (i3 == -1) {
                    String stringExtra2 = intent.getStringExtra(VideoCoverSelectActivityConfig.KEY_VIDEO_COVER_IMAGE_PATH);
                    if (!TextUtils.isEmpty(stringExtra2) && (zx6Var = this.w) != null) {
                        zx6Var.m(stringExtra2);
                        this.C = stringExtra2;
                        return;
                    }
                    return;
                }
                zx6 zx6Var3 = this.w;
                if (zx6Var3 != null && !zx6Var3.o()) {
                    this.j.setCurrentMode(1);
                    this.w.l();
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        zx6 zx6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view2) == null) {
            super.onClick(view2);
            if (view2.getId() == R.id.obfuscated_res_0x7f090561) {
                Q1();
                if (this.s.q()) {
                    this.f.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c50));
                } else {
                    this.f.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c52));
                }
                this.s.u();
                if (this.s.s()) {
                    M1();
                    return;
                }
                return;
            }
            int i2 = 2;
            if (view2.getId() == R.id.obfuscated_res_0x7f090563) {
                Q1();
                if (this.s.r()) {
                    this.g.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c53));
                } else {
                    this.g.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c54));
                }
                this.s.v();
                TbMusicData tbMusicData = this.J;
                if (tbMusicData != null && tbMusicData.type == 2) {
                    this.s.postDelayed(new i(this), 300L);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09055f) {
                TbFileVideoActivityConfig tbFileVideoActivityConfig = new TbFileVideoActivityConfig(getPageContext().getPageActivity());
                tbFileVideoActivityConfig.setForResult();
                tbFileVideoActivityConfig.setFrom(2);
                tbFileVideoActivityConfig.setTbMultiMediaData(this.y);
                my6 my6Var = this.v;
                if (my6Var != null && my6Var.b() != null) {
                    tbFileVideoActivityConfig.setFilter(this.v.b());
                }
                tbFileVideoActivityConfig.setEnterAnimValues(zna.a(this.k));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbFileVideoActivityConfig));
                F1();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09055d) {
                zx6 zx6Var2 = this.w;
                if (zx6Var2 != null) {
                    zx6Var2.i(this.D);
                    P1();
                    if (this.j.getCurrentMode() == 2 && !StringUtils.isNull(this.C)) {
                        this.w.m(this.C);
                    } else {
                        this.j.setCurrentMode(1);
                    }
                    this.w.q(this.y.getCoverStickerList());
                    R1();
                }
                SharedPrefHelper.getInstance().putBoolean("key_edit_video_pick_cover_tip_show", true);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090999) {
                if (!this.E) {
                    this.E = true;
                    P1();
                    VideoMuxer videoMuxer = this.N;
                    if (videoMuxer != null) {
                        videoMuxer.interruptProcess();
                    }
                    this.N = zs5.d(I1(), this.O);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090998) {
                if (WorkPublishManager.isWorkPublishLocate()) {
                    int i3 = this.K;
                    if (i3 != 1) {
                        if (i3 == 2) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                    }
                    TiebaStatic.log(new StatisticItem("c14310").param("obj_source", i2));
                }
                if (!SharedPrefHelper.getInstance().getBoolean("key_edit_video_pick_cover_tip_show", false)) {
                    no6 no6Var = new no6(getPageContext(), this.r);
                    no6Var.L(R.drawable.pic_sign_tip_right);
                    no6Var.l(1);
                    no6Var.N(true);
                    no6Var.C(R.color.CAM_X0101);
                    no6Var.J(R.dimen.T_X08);
                    no6Var.p(R.dimen.T_X08);
                    no6Var.F(UtilHelper.getDimenPixelSize(R.dimen.tbds26));
                    no6Var.I(UtilHelper.getDimenPixelSize(R.dimen.tbds26));
                    no6Var.S(getResources().getString(R.string.obfuscated_res_0x7f0f0624));
                    SharedPrefHelper.getInstance().putBoolean("key_edit_video_pick_cover_tip_show", true);
                    return;
                }
                P1();
                VideoFileInfo c2 = tna.c(this.y.path);
                if (c2 == null) {
                    return;
                }
                VideoInfo videoInfo = new VideoInfo();
                this.z = videoInfo;
                videoInfo.setVideoPath(this.y.path);
                this.z.setThumbPath(this.B);
                this.z.setVideoDuration((int) (c2.videoDuration / 1000.0f));
                this.z.setVideoWidth(c2.videoWidth);
                this.z.setVideoHeight(c2.videoHeight);
                this.z.setVideoLength(new File(this.y.path).length());
                this.z.setVideoSource(this.y.videoInfoSource);
                this.z.setIsCompressedVideo(true);
                EditVideoData editVideoData = new EditVideoData();
                if (StringUtils.isNull(this.B)) {
                    editVideoData.coverPath = ioa.b;
                } else {
                    editVideoData.coverPath = this.B;
                }
                editVideoData.originPath = this.z.getVideoPath();
                this.z.setEditVideoData(editVideoData);
                this.y.coverSource = this.j.getCurrentMode();
                TbMultiMediaData tbMultiMediaData = this.y;
                tbMultiMediaData.coverPath = this.B;
                tbMultiMediaData.orignalCoverPath = this.C;
                List<MultiMediaData> j2 = this.w.j();
                if (j2 != null) {
                    this.y.setCoverStickerList(j2);
                }
                this.y.setOrignalVideoPath(this.z.getVideoPath());
                this.y.setVideoFilter(this.v.b());
                this.z.setMultiMediaData(this.y);
                this.F = true;
                this.y.lastCoverPercent = this.D;
                MessageManager.getInstance().registerStickyMode(2921584);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921584, I1()));
                if (!WorkPublishOpenHelper.Companion.e(getIntent(), this.z, getPageContext().getPageActivity(), true, true)) {
                    WriteActivityConfig newInstance = WriteActivityConfig.newInstance(getPageContext().getPageActivity());
                    newInstance.getIntent().putExtras(getIntent());
                    String stringExtra = newInstance.getIntent().getStringExtra("forum_id");
                    if (TextUtils.isEmpty(stringExtra)) {
                        stringExtra = "0";
                    }
                    newInstance.getIntent().putExtra("forum_id", stringExtra);
                    newInstance.getIntent().setFlags(NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
                    newInstance.getIntent().setFlags(67108864);
                    newInstance.setType(9).setVideoInfo(this.z).setNeedClosePrePage(true).send();
                    finish();
                }
            } else if (view2 == this.d) {
                onBackPressed();
            } else if (view2 == this.c) {
                int i4 = this.G;
                if (i4 == 2) {
                    zx6 zx6Var3 = this.w;
                    if (zx6Var3 != null) {
                        this.H = true;
                        zx6Var3.f();
                    }
                    J1();
                } else if (i4 == 3 && (zx6Var = this.w) != null) {
                    this.H = true;
                    zx6Var.f();
                }
            } else if (view2.getId() == this.j.getVideoPick().getId()) {
                if (this.j.getCurrentMode() != 1) {
                    this.j.setCurrentMode(1);
                    zx6 zx6Var4 = this.w;
                    if (zx6Var4 != null) {
                        zx6Var4.i(this.D);
                        this.w.l();
                    }
                }
            } else if (view2.getId() == this.j.getImagePick().getId()) {
                if (this.j.getCurrentMode() != 2) {
                    this.j.setCurrentMode(2);
                    zx6 zx6Var5 = this.w;
                    if (zx6Var5 != null) {
                        this.D = zx6Var5.p();
                    }
                    L1();
                }
            } else if (view2.getId() == this.j.getCoverImageView().getId() && this.j.getCurrentMode() == 2) {
                L1();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0058);
            setSwipeBackEnabled(false);
            if (getIntent() != null) {
                this.G = getIntent().getIntExtra(TbEditVideoActivityConfig.KEY_EDIT_PAGE_MODE_TYPE, 1);
                this.y = (TbMultiMediaData) getIntent().getParcelableExtra(TbEditVideoActivityConfig.KEY_EDIT_VIDEO_DATA);
                this.A = getIntent().getFloatExtra(TbEditVideoActivityConfig.KEY_EDIT_VIDEO_RATIO, 0.0f);
                this.K = getIntent().getIntExtra(TbEditVideoActivityConfig.KEY_EDIT_VIDEO_FROM, 0);
                TbMusicData tbMusicData = (TbMusicData) getIntent().getSerializableExtra(TbEditVideoActivityConfig.KEY_EDIT_VIDEO_MUSIC_DATA);
                this.I = tbMusicData;
                this.J = tbMusicData;
                TbMultiMediaData tbMultiMediaData = this.y;
                tbMultiMediaData.videoRatio = this.A;
                this.B = tbMultiMediaData.coverPath;
                this.C = tbMultiMediaData.orignalCoverPath;
                this.D = tbMultiMediaData.lastCoverPercent;
            }
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_QM_FILTERS, TbConfig.SERVER_ADDRESS + TbConfig.GET_QM_FILTERS);
            tbHttpMessageTask.setResponsedClass(ResponseGetQmFiltersMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            K1();
            initView();
            initData();
            registerListener(this.S);
            registerListener(this.Q);
        }
    }

    @Override // com.baidu.tieba.ay6
    public void y(String str) {
        List<MultiMediaData> j2;
        zx6 zx6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, str) == null) && !StringUtils.isNull(str) && !str.equals(this.B)) {
            zx6 zx6Var2 = this.w;
            if (zx6Var2 != null) {
                this.D = zx6Var2.p();
            }
            this.B = str;
            if (this.j.getCurrentMode() == 2 && (zx6Var = this.w) != null) {
                zx6Var.l();
            }
            if (this.H) {
                SafeHandler.getInst().post(new a(this));
                if (this.G != 3) {
                    so6 so6Var = this.t;
                    if (so6Var != null) {
                        so6Var.start();
                    }
                    ny6 ny6Var = this.u;
                    if (ny6Var != null) {
                        ny6Var.onResume();
                        so6 so6Var2 = this.t;
                        if (so6Var2 != null) {
                            this.u.a(((float) so6Var2.getCurrentPlayTime()) / 1000.0f);
                        }
                    }
                }
                this.x = true;
            }
            zx6 zx6Var3 = this.w;
            if (zx6Var3 != null && (j2 = zx6Var3.j()) != null) {
                this.y.setCoverStickerList(j2);
            }
            if (this.G == 3) {
                SafeHandler.getInst().post(new b(this));
            }
        }
    }
}
