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
import com.baidu.tieba.au6;
import com.baidu.tieba.ay9;
import com.baidu.tieba.b5a;
import com.baidu.tieba.cu6;
import com.baidu.tieba.d15;
import com.baidu.tieba.de0;
import com.baidu.tieba.external.filter.ResponseGetQmFiltersMessage;
import com.baidu.tieba.external.filter.TbFilterValue;
import com.baidu.tieba.external.music.data.MusicData;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
import com.baidu.tieba.f15;
import com.baidu.tieba.f55;
import com.baidu.tieba.fc9;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.g35;
import com.baidu.tieba.gg;
import com.baidu.tieba.h5a;
import com.baidu.tieba.ii;
import com.baidu.tieba.jg;
import com.baidu.tieba.ki;
import com.baidu.tieba.ky9;
import com.baidu.tieba.lu6;
import com.baidu.tieba.mu6;
import com.baidu.tieba.nu6;
import com.baidu.tieba.ol6;
import com.baidu.tieba.os5;
import com.baidu.tieba.pu6;
import com.baidu.tieba.rs5;
import com.baidu.tieba.sl6;
import com.baidu.tieba.tl6;
import com.baidu.tieba.ux9;
import com.baidu.tieba.video.EditVideoData;
import com.baidu.tieba.view.widget.RecordPreviewContainer;
import com.baidu.tieba.view.widget.TbGLMediaPreviewView;
import com.baidu.tieba.view.widget.pickcover.PreViewPickCoverView;
import com.baidu.tieba.view.widget.recordeffect.RecordEffectLayout;
import com.baidu.tieba.view.widget.recordeffect.VideoControllerLayout;
import com.baidu.tieba.wx9;
import com.baidu.tieba.zt6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.muxer.VideoMuxer;
import com.baidubce.auth.NTLMEngineImpl;
import com.google.protobuf.CodedInputStream;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class TbEditVideoActivity extends BaseActivity<TbEditVideoActivity> implements au6 {
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
    public q O;
    public Runnable P;
    public RecordPreviewContainer.f Q;
    public HttpMessageListener R;
    public lu6.b S;
    public RecordEffectLayout.i T;
    @NonNull
    public final os5 U;
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
    public sl6 t;
    public nu6 u;
    public mu6 v;
    public zt6 w;
    public boolean x;
    public TbMultiMediaData y;
    public VideoInfo z;

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
                int j = ii.j(this.a.getPageContext().getPageActivity());
                float l = ii.l(this.a.getPageContext().getPageActivity()) * this.a.A;
                this.a.L = (j - height) - height2;
                float l2 = (this.a.L * 1.0f) / ii.l(this.a.getPageContext().getPageActivity());
                TbEditVideoActivity tbEditVideoActivity = this.a;
                tbEditVideoActivity.M = height - ((j - tbEditVideoActivity.L) * 0.5f);
                ObjectAnimator duration = ObjectAnimator.ofFloat(this.a.n, Key.TRANSLATION_Y, 0.0f, this.a.M).setDuration(250L);
                if (this.a.A > l2) {
                    ValueAnimator ofFloat2 = ValueAnimator.ofFloat(l, this.a.L);
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
                int j = ii.j(this.a.getPageContext().getPageActivity());
                float l = ii.l(this.a.getPageContext().getPageActivity()) * this.a.A;
                this.a.L = (j - height) - height2;
                float l2 = (this.a.L * 1.0f) / ii.l(this.a.getPageContext().getPageActivity());
                TbEditVideoActivity tbEditVideoActivity = this.a;
                tbEditVideoActivity.M = height - ((j - tbEditVideoActivity.L) * 0.5f);
                ObjectAnimator duration = ObjectAnimator.ofFloat(this.a.n, Key.TRANSLATION_Y, 0.0f, this.a.M).setDuration(250L);
                if (this.a.A > l2) {
                    ValueAnimator ofFloat2 = ValueAnimator.ofFloat(l, this.a.L);
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
                    this.a.a.w.c();
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
                    jg.a().postDelayed(new a(this), 300L);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class q implements rs5.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<TbEditVideoActivity> a;

        @Override // com.baidu.tieba.rs5.b
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TbEditVideoActivity a;

            public a(q qVar, TbEditVideoActivity tbEditVideoActivity) {
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

        @Override // com.baidu.tieba.rs5.b
        public void b() {
            TbEditVideoActivity tbEditVideoActivity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (tbEditVideoActivity = this.a.get()) != null) {
                tbEditVideoActivity.showLoadingView(tbEditVideoActivity.e);
            }
        }

        @Override // com.baidu.tieba.rs5.b
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

        @Override // com.baidu.tieba.rs5.b
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                TbEditVideoActivity tbEditVideoActivity = this.a.get();
                File file = new File(str);
                File file2 = new File(ky9.g);
                if (!file2.exists()) {
                    file2.mkdir();
                }
                String str2 = ky9.g + file.getName();
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
                    tbEditVideoActivity.q2();
                    tbEditVideoActivity.r2();
                    BdLog.d(e.getMessage());
                }
                tbEditVideoActivity.E = false;
                tbEditVideoActivity.showToast(tbEditVideoActivity.getResources().getString(R.string.save_success));
                tbEditVideoActivity.q2();
                tbEditVideoActivity.r2();
                e();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements sl6.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbEditVideoActivity a;

        @Override // com.baidu.tieba.sl6.a
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

        @Override // com.baidu.tieba.sl6.a
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.u != null) {
                this.a.u.a(0.0f);
            }
        }

        @Override // com.baidu.tieba.sl6.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a.G != 1) {
                    this.a.s2();
                }
                this.a.U.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements f15.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d15 a;
        public final /* synthetic */ TbEditVideoActivity b;

        public b(TbEditVideoActivity tbEditVideoActivity, d15 d15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbEditVideoActivity, d15Var};
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
            this.a = d15Var;
        }

        @Override // com.baidu.tieba.f15.f
        public void N0(f15 f15Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, f15Var, i, view2) == null) {
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
                int j = ii.j(this.a.getPageContext().getPageActivity());
                float l = ii.l(this.a.getPageContext().getPageActivity()) * this.a.A;
                this.a.L = (j - height) - height2;
                float l2 = (this.a.L * 1.0f) / ii.l(this.a.getPageContext().getPageActivity());
                TbEditVideoActivity tbEditVideoActivity = this.a;
                tbEditVideoActivity.M = height - ((j - tbEditVideoActivity.L) * 0.5f);
                this.a.n.setTranslationY(this.a.M);
                if (this.a.A > l2) {
                    this.a.k.setScaleX(this.a.L / l);
                    this.a.k.setScaleY(this.a.L / l);
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
                this.a.s.setMusicName(this.a.J.title, this.a.J.icon);
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

        @Override // com.baidu.tieba.view.widget.RecordPreviewContainer.f
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
                qmFilterItem.bgurl = R.drawable.obfuscated_res_0x7f080ac9 + "";
                qmFilterItem.name = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f068d);
                qmFilterItem.isSelect = true;
                qmFilterItem.localPath = "origin";
                list.add(0, qmFilterItem);
                this.a.s.setFilterData(list);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements lu6.b {
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

        @Override // com.baidu.tieba.lu6.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.s != null) {
                    QmFilterItem qmFilterItem = new QmFilterItem();
                    qmFilterItem.id = "-1";
                    qmFilterItem.bgurl = R.drawable.obfuscated_res_0x7f080ac9 + "";
                    qmFilterItem.name = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f068d);
                    qmFilterItem.isSelect = true;
                    qmFilterItem.localPath = "origin";
                    this.a.s.z(qmFilterItem);
                    if (this.a.v != null) {
                        this.a.v.a(null);
                    }
                    this.a.s.setDownLoadFilter(null);
                }
                if (StringUtils.isNull(str)) {
                    str = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f12fa);
                }
                this.a.showToast(str);
            }
        }

        @Override // com.baidu.tieba.lu6.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.s != null) {
                this.a.s.setDownLoadFilter(null);
            }
        }

        @Override // com.baidu.tieba.lu6.b
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
        public void b(b5a b5aVar, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b5aVar, obj) != null) || b5aVar == null) {
                return;
            }
            int type = b5aVar.getType();
            if (type != 2) {
                if (type == 3 && (b5aVar.c() instanceof MusicData)) {
                    MusicData musicData = (MusicData) b5aVar.c();
                    TbMusicData tbMusicData = new TbMusicData();
                    tbMusicData.id = musicData.id;
                    tbMusicData.title = musicData.name;
                    tbMusicData.url = musicData.resource;
                    tbMusicData.icon = musicData.img;
                    tbMusicData.type = gg.e(musicData.type, 1);
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
                    this.a.u.d((MusicData) b5aVar.c(), obj);
                    if (this.a.t != null) {
                        this.a.u.a(((float) this.a.t.getCurrentPlayTime()) / 1000.0f);
                    }
                    this.a.x = true;
                }
            } else if (this.a.v != null && (b5aVar.c() instanceof QmFilterItem)) {
                QmFilterItem qmFilterItem = (QmFilterItem) b5aVar.c();
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
                tbEditVideoActivity.showToast(tbEditVideoActivity.getString(R.string.obfuscated_res_0x7f0f0575));
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
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (c = ux9.c(this.a.y.path)) == null) {
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
                editVideoData.coverPath = ky9.b;
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
                newInstance.getIntent().setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                newInstance.setType(9).setVideoInfo(this.a.z).send();
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
        this.x = false;
        this.E = false;
        this.F = false;
        this.G = 1;
        this.H = false;
        this.L = ii.j(getPageContext().getPageActivity());
        this.M = 0.0f;
        this.O = new q(this);
        this.P = new h(this);
        this.Q = new i(this);
        this.R = new j(this, CmdConfigHttp.CMD_GET_QM_FILTERS, true);
        this.S = new k(this);
        this.T = new l(this);
        this.U = new os5(new m(this));
    }

    public final int i2(int i2) {
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

    @Override // com.baidu.tieba.au6
    public void b0(String str) {
        List<MultiMediaData> j2;
        zt6 zt6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !StringUtils.isNull(str) && !str.equals(this.B)) {
            zt6 zt6Var2 = this.w;
            if (zt6Var2 != null) {
                this.D = zt6Var2.p();
            }
            this.B = str;
            if (this.j.getCurrentMode() == 2 && (zt6Var = this.w) != null) {
                zt6Var.l();
            }
            if (this.H) {
                jg.a().post(new o(this));
                if (this.G != 3) {
                    sl6 sl6Var = this.t;
                    if (sl6Var != null) {
                        sl6Var.start();
                    }
                    nu6 nu6Var = this.u;
                    if (nu6Var != null) {
                        nu6Var.onResume();
                        sl6 sl6Var2 = this.t;
                        if (sl6Var2 != null) {
                            this.u.a(((float) sl6Var2.getCurrentPlayTime()) / 1000.0f);
                        }
                    }
                }
                this.x = true;
            }
            zt6 zt6Var3 = this.w;
            if (zt6Var3 != null && (j2 = zt6Var3.j()) != null) {
                this.y.setCoverStickerList(j2);
            }
            if (this.G == 3) {
                jg.a().post(new p(this));
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
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.setVisibility(8);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            this.i.setVisibility(8);
        }
    }

    public final void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
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
            sl6 sl6Var = this.t;
            if (sl6Var != null) {
                sl6Var.onPause();
            }
            nu6 nu6Var = this.u;
            if (nu6Var != null) {
                nu6Var.onPause();
            }
        }
    }

    public final void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            sl6 sl6Var = this.t;
            if (sl6Var != null) {
                sl6Var.pause();
            }
            nu6 nu6Var = this.u;
            if (nu6Var != null) {
                nu6Var.onPause();
            }
        }
    }

    public final void t2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.f.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080ac8));
            this.g.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080acb));
        }
    }

    public final void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.x) {
                d15 d15Var = new d15(getPageContext(), new f15(getPageContext().getPageActivity()));
                d15Var.i(getResources().getString(R.string.obfuscated_res_0x7f0f0574), new String[]{getResources().getString(R.string.obfuscated_res_0x7f0f106b)}, new b(this, d15Var));
                d15Var.k();
                return;
            }
            finish();
        }
    }

    public final void u2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.G = 2;
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0611, 0);
            t2();
            VideoControllerLayout videoControllerLayout = this.s;
            if (videoControllerLayout != null && videoControllerLayout.p()) {
                this.s.m(null, false);
            }
            this.b.setVisibility(0);
            this.c.setVisibility(0);
            jg.a().post(new e(this));
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            this.i.setVisibility(8);
        }
    }

    public final void h2() {
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

    public final void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.G = 1;
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0105, 0);
            this.b.setVisibility(8);
            this.c.setVisibility(8);
            jg.a().post(new f(this));
            this.l.setVisibility(0);
            this.m.setVisibility(0);
            this.i.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onBackPressed() {
        zt6 zt6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.G == 2) {
                if (this.j.getCurrentMode() == 2 && (zt6Var = this.w) != null) {
                    zt6Var.l();
                }
                zt6 zt6Var2 = this.w;
                if (zt6Var2 != null) {
                    zt6Var2.reset();
                }
                jg.a().post(new c(this));
                m2();
                return;
            }
            g2();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroy();
            sl6 sl6Var = this.t;
            if (sl6Var != null) {
                sl6Var.onDestroy();
                if (!this.F) {
                    this.t.e();
                }
            }
            nu6 nu6Var = this.u;
            if (nu6Var != null) {
                nu6Var.b();
                this.u.e();
            }
            VideoMuxer videoMuxer = this.N;
            if (videoMuxer != null) {
                videoMuxer.interruptProcess();
            }
        }
    }

    public final void r2() {
        nu6 nu6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            ViewGroup viewGroup = this.e;
            if (viewGroup != null) {
                viewGroup.setSystemUiVisibility(4100);
            }
            sl6 sl6Var = this.t;
            if (sl6Var != null) {
                sl6Var.onResume();
            }
            if (this.G == 1 && (nu6Var = this.u) != null) {
                nu6Var.onResume();
                sl6 sl6Var2 = this.t;
                if (sl6Var2 != null) {
                    this.u.a(((float) sl6Var2.getCurrentPlayTime()) / 1000.0f);
                }
            }
            mu6 mu6Var = this.v;
            if (mu6Var != null) {
                mu6Var.h();
            }
        }
    }

    public final void initView() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.e = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091e46);
            this.a = (NavigationBar) findViewById(R.id.navigation_bar);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f090932);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f090533);
            this.g = (ImageView) findViewById(R.id.obfuscated_res_0x7f090535);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f090939);
            this.m = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09093a);
            this.l = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09052e);
            this.p = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090534);
            this.q = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090536);
            this.r = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090530);
            this.j.setVisibility(4);
            RecordPreviewContainer recordPreviewContainer = (RecordPreviewContainer) findViewById(R.id.obfuscated_res_0x7f090938);
            this.n = recordPreviewContainer;
            recordPreviewContainer.setOnViewClickListener(this.Q);
            TextView centerTextTitle = this.a.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0f76));
            this.b = centerTextTitle;
            centerTextTitle.setTextColor(getResources().getColor(R.color.CAM_X0101));
            this.b.setVisibility(8);
            View addSystemImageButton = this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.d = addSystemImageButton;
            ((ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button)).setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080aaf));
            TextView addTextButton = this.a.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(R.string.obfuscated_res_0x7f0f117a));
            this.c = addTextButton;
            addTextButton.setTextColor(getResources().getColor(R.color.CAM_X0101));
            this.c.setVisibility(8);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090532);
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
            g35 d2 = g35.d(this.h);
            d2.C(R.string.F_X02);
            d2.A(R.array.S_O_X001);
            g35 d3 = g35.d(findViewById(R.id.obfuscated_res_0x7f090939));
            d3.o(R.string.J_X01);
            d3.f(R.color.CAM_X0302);
            g35.d(findViewById(R.id.obfuscated_res_0x7f09093c)).A(R.array.S_O_X001);
            g35.d(findViewById(R.id.obfuscated_res_0x7f090538)).A(R.array.S_O_X001);
            g35.d(findViewById(R.id.obfuscated_res_0x7f090539)).A(R.array.S_O_X001);
            g35.d(findViewById(R.id.obfuscated_res_0x7f090537)).A(R.array.S_O_X001);
            g35.d(findViewById(R.id.obfuscated_res_0x7f09053a)).A(R.array.S_O_X001);
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
                h2();
                this.U.b();
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

    public final h5a l2() {
        InterceptResult invokeV;
        nu6 nu6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            h5a h5aVar = new h5a();
            TbMultiMediaData tbMultiMediaData = this.y;
            float f2 = 0.0f;
            if (tbMultiMediaData != null) {
                h5aVar.j(tbMultiMediaData);
                h5aVar.n(this.A);
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
                    int i22 = i2(i2);
                    int i23 = i2(i3);
                    h5aVar.m(i22);
                    h5aVar.l(i23);
                }
            }
            mu6 mu6Var = this.v;
            if (mu6Var != null && mu6Var.b() != null) {
                QmFilterItem b2 = this.v.b();
                String str = b2.localPath;
                Filter filter = new Filter();
                if (!StringUtils.isNull(str) && !"origin".equals(str)) {
                    f2 = (gg.d(b2.effect, 100.0f) * 1.0f) / 100.0f;
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
                tbFilterValue.mComplex = gg.e(b2.complex, 0);
                tbFilterValue.mRootFilePath = str;
                h5aVar.h(tbFilterValue);
            }
            sl6 sl6Var = this.t;
            if (sl6Var != null) {
                h5aVar.i(sl6Var.getMediaTrackConfig());
            }
            TbMusicData tbMusicData = this.J;
            if (tbMusicData != null && (nu6Var = this.u) != null) {
                tbMusicData.localPath = nu6Var.c();
                h5aVar.k(this.J);
            }
            return h5aVar;
        }
        return (h5a) invokeV.objValue;
    }

    public final void n2() {
        TbMusicData tbMusicData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            boolean booleanExtra = getIntent().getBooleanExtra(AlbumActivityConfig.KEY_DIRECT_TO_WORK_PUBLISH_PAGE, false);
            this.k = (TbGLMediaPreviewView) findViewById(R.id.obfuscated_res_0x7f09093f);
            this.j = (PreViewPickCoverView) findViewById(R.id.obfuscated_res_0x7f091b67);
            cu6 cu6Var = new cu6(getPageContext(), this.k, this.j, this.y, booleanExtra);
            this.w = cu6Var;
            cu6Var.d(this);
            this.H = false;
            tl6 tl6Var = new tl6(getPageContext(), this.k, this.y, this.w, booleanExtra);
            this.t = tl6Var;
            tl6Var.f(this.A);
            this.t.b(new a(this));
            this.s = (VideoControllerLayout) findViewById(R.id.obfuscated_res_0x7f091d53);
            pu6 pu6Var = new pu6(getPageContext(), this.s);
            this.u = pu6Var;
            this.s.setMusicManager(pu6Var);
            if (this.u != null && (tbMusicData = this.J) != null && !TextUtils.isEmpty(tbMusicData.localPath) && !TextUtils.isEmpty(this.J.id)) {
                TbMusicData tbMusicData2 = this.J;
                if (tbMusicData2.type == 2) {
                    this.s.setEffectLayoutCurrentMusicName(getResources().getString(R.string.obfuscated_res_0x7f0f0c06));
                } else {
                    this.s.setEffectLayoutCurrentMusicName(tbMusicData2.title);
                }
                nu6 nu6Var = this.u;
                TbMusicData tbMusicData3 = this.J;
                nu6Var.g(tbMusicData3.localPath, tbMusicData3.id);
                sl6 sl6Var = this.t;
                if (sl6Var != null) {
                    this.u.a(((float) sl6Var.getCurrentPlayTime()) / 1000.0f);
                }
                this.s.setMusicName(this.J.title, "");
            }
            lu6 lu6Var = new lu6(null, this.t, this.s);
            this.v = lu6Var;
            lu6Var.d(this.S);
            this.v.h();
            this.s.setEditManager(this.t);
            p2();
            QmFilterItem videoFilter = this.y.getVideoFilter();
            if (videoFilter != null) {
                this.v.a(videoFilter);
                this.s.setCurrentFilterWithQmFilterItem(videoFilter);
            }
        }
    }

    public final void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_QM_FILTERS);
            if (fc9.b()) {
                httpMessage.addParam(HttpRequest.UH, ki.f() + "," + Build.HARDWARE + "," + Build.BOARD + "," + (wx9.b(this) ? 1 : 0));
                httpMessage.addParam("ut", ki.g() + "_" + ki.k() + "_" + wx9.a() + "_" + Build.BRAND.replace("_", ""));
            } else {
                httpMessage.addParam(HttpRequest.NEED_DECRYPT, fc9.c());
                String g2 = fc9.g(HttpRequest.UH);
                if (!TextUtils.isEmpty(g2)) {
                    httpMessage.addParam(g2, fc9.a(ki.f() + "," + Build.HARDWARE + "," + Build.BOARD + "," + (wx9.b(this) ? 1 : 0)));
                }
                String g3 = fc9.g("ut");
                if (!TextUtils.isEmpty(g3)) {
                    httpMessage.addParam(g3, fc9.a(ki.g() + "_" + ki.k() + "_" + wx9.a() + "_" + Build.BRAND.replace("_", "")));
                }
            }
            httpMessage.addParam("sdk_version", de0.h() + "");
            sendMessage(httpMessage);
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        zt6 zt6Var;
        TbMultiMediaData tbMultiMediaData;
        TbMultiMediaData tbMultiMediaData2;
        zt6 zt6Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048588, this, i2, i3, intent) == null) {
            if (intent == null) {
                if (this.j.getCurrentMode() == 2 && i2 == 12002 && (zt6Var2 = this.w) != null && !zt6Var2.o()) {
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
                            sl6 sl6Var = this.t;
                            if (sl6Var != null) {
                                this.u.a(((float) sl6Var.getCurrentPlayTime()) / 1000.0f);
                            }
                            this.s.y(tbMusicData);
                        }
                    }
                }
            } else if (i2 == 25062) {
                ay9.c(intent, this.k);
                if (i3 == -1 && (tbMultiMediaData = (TbMultiMediaData) intent.getParcelableExtra(TbEditVideoActivityConfig.KEY_EDIT_VIDEO_DATA)) != null && this.t != null && (tbMultiMediaData2 = this.y) != null && (tbMultiMediaData.start != tbMultiMediaData2.start || tbMultiMediaData.end != tbMultiMediaData2.end)) {
                    this.y = tbMultiMediaData;
                    this.t.c(tbMultiMediaData);
                    this.s.post(new n(this));
                    this.x = true;
                }
                k2();
            } else if (i2 == 12002) {
                if (i3 == -1) {
                    String stringExtra2 = intent.getStringExtra(VideoCoverSelectActivityConfig.KEY_VIDEO_COVER_IMAGE_PATH);
                    if (!TextUtils.isEmpty(stringExtra2) && (zt6Var = this.w) != null) {
                        zt6Var.m(stringExtra2);
                        this.C = stringExtra2;
                        return;
                    }
                    return;
                }
                zt6 zt6Var3 = this.w;
                if (zt6Var3 != null && !zt6Var3.o()) {
                    this.j.setCurrentMode(1);
                    this.w.l();
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        zt6 zt6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            super.onClick(view2);
            if (view2.getId() == R.id.obfuscated_res_0x7f090534) {
                t2();
                if (this.s.q()) {
                    this.f.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080ac8));
                } else {
                    this.f.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080aca));
                }
                this.s.v();
                if (this.s.t()) {
                    p2();
                    return;
                }
                return;
            }
            int i2 = 2;
            if (view2.getId() == R.id.obfuscated_res_0x7f090536) {
                t2();
                if (this.s.r()) {
                    this.g.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080acb));
                } else {
                    this.g.setImageDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080acc));
                }
                this.s.w();
                TbMusicData tbMusicData = this.J;
                if (tbMusicData != null && tbMusicData.type == 2) {
                    this.s.postDelayed(new g(this), 300L);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090532) {
                TbFileVideoActivityConfig tbFileVideoActivityConfig = new TbFileVideoActivityConfig(getPageContext().getPageActivity());
                tbFileVideoActivityConfig.setForResult();
                tbFileVideoActivityConfig.setFrom(2);
                tbFileVideoActivityConfig.setTbMultiMediaData(this.y);
                mu6 mu6Var = this.v;
                if (mu6Var != null && mu6Var.b() != null) {
                    tbFileVideoActivityConfig.setFilter(this.v.b());
                }
                tbFileVideoActivityConfig.setEnterAnimValues(ay9.a(this.k));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921582, tbFileVideoActivityConfig));
                j2();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090530) {
                zt6 zt6Var2 = this.w;
                if (zt6Var2 != null) {
                    zt6Var2.i(this.D);
                    s2();
                    if (this.j.getCurrentMode() == 2 && !StringUtils.isNull(this.C)) {
                        this.w.m(this.C);
                    } else {
                        this.j.setCurrentMode(1);
                    }
                    this.w.q(this.y.getCoverStickerList());
                    u2();
                }
                f55.m().w("key_edit_video_pick_cover_tip_show", true);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09093a) {
                if (!this.E) {
                    this.E = true;
                    s2();
                    VideoMuxer videoMuxer = this.N;
                    if (videoMuxer != null) {
                        videoMuxer.interruptProcess();
                    }
                    this.N = rs5.d(l2(), this.O);
                }
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090939) {
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
                if (!f55.m().i("key_edit_video_pick_cover_tip_show", false)) {
                    ol6 ol6Var = new ol6(getPageContext(), this.r);
                    ol6Var.L(R.drawable.pic_sign_tip_right);
                    ol6Var.l(1);
                    ol6Var.N(true);
                    ol6Var.C(R.color.CAM_X0101);
                    ol6Var.J(R.dimen.T_X08);
                    ol6Var.p(R.dimen.T_X08);
                    ol6Var.F(UtilHelper.getDimenPixelSize(R.dimen.tbds26));
                    ol6Var.I(UtilHelper.getDimenPixelSize(R.dimen.tbds26));
                    ol6Var.S(getResources().getString(R.string.obfuscated_res_0x7f0f0576));
                    f55.m().w("key_edit_video_pick_cover_tip_show", true);
                    return;
                }
                s2();
                VideoFileInfo c2 = ux9.c(this.y.path);
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
                    editVideoData.coverPath = ky9.b;
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
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921584, l2()));
                if (!WorkPublishOpenHelper.Companion.e(getIntent(), this.z, getPageContext().getPageActivity(), true, true)) {
                    WriteActivityConfig newInstance = WriteActivityConfig.newInstance(getPageContext().getPageActivity());
                    newInstance.getIntent().putExtras(getIntent());
                    String stringExtra = newInstance.getIntent().getStringExtra("forum_id");
                    if (TextUtils.isEmpty(stringExtra)) {
                        stringExtra = "0";
                    }
                    newInstance.getIntent().putExtra("forum_id", stringExtra);
                    newInstance.getIntent().setFlags(NTLMEngineImpl.FLAG_REQUEST_128BIT_KEY_EXCH);
                    newInstance.getIntent().setFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
                    newInstance.setType(9).setVideoInfo(this.z).setNeedClosePrePage(true).send();
                    finish();
                }
            } else if (view2 == this.d) {
                onBackPressed();
            } else if (view2 == this.c) {
                int i4 = this.G;
                if (i4 == 2) {
                    zt6 zt6Var3 = this.w;
                    if (zt6Var3 != null) {
                        this.H = true;
                        zt6Var3.f();
                    }
                    m2();
                } else if (i4 == 3 && (zt6Var = this.w) != null) {
                    this.H = true;
                    zt6Var.f();
                }
            } else if (view2.getId() == this.j.getVideoPick().getId()) {
                if (this.j.getCurrentMode() != 1) {
                    this.j.setCurrentMode(1);
                    zt6 zt6Var4 = this.w;
                    if (zt6Var4 != null) {
                        zt6Var4.i(this.D);
                        this.w.l();
                    }
                }
            } else if (view2.getId() == this.j.getImagePick().getId()) {
                if (this.j.getCurrentMode() != 2) {
                    this.j.setCurrentMode(2);
                    zt6 zt6Var5 = this.w;
                    if (zt6Var5 != null) {
                        this.D = zt6Var5.p();
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
            setContentView(R.layout.obfuscated_res_0x7f0d0056);
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
            n2();
            initView();
            registerListener(this.R);
        }
    }
}
