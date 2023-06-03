package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.TbMultiMediaData;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tieba.core.edit.TbMediaTrackConfig;
import com.baidu.tieba.di6;
import com.baidu.tieba.qr6;
import com.baidu.tieba.view.widget.TbGLMediaPreviewView;
import com.baidu.tieba.view.widget.mediaedit.MultiMediaEditLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaData;
import com.baidu.ugc.editvideo.record.processor.adapter.MultiMediaDataSourceViewAdapter;
import com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaPreparedListener;
import com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol;
import com.baidu.ugc.editvideo.record.source.multimedia.IVlogEditManager;
import com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener;
import com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaTimelineUpdateListener;
import com.baidu.ugc.editvideo.record.source.multimedia.VlogEditManager;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import com.google.gson.Gson;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class sr6 implements qr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public VlogEditManager b;
    public MultiMediaDataSourceViewAdapter c;
    public TbGLMediaPreviewView d;
    public NavigationBar e;
    public FrameLayout f;
    public MultiMediaEditLayout g;
    public int h;
    public float i;
    public long j;
    public long k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;
    public List<MultiMediaData> p;
    public List<vca> q;
    public di6 r;
    public ai6 s;
    public boolean t;
    public ci6 u;
    public di6.a v;
    public zh6 w;

    /* loaded from: classes7.dex */
    public class h implements IMultiMediaPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sr6 a;

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            /* loaded from: classes7.dex */
            public class a extends AnimatorListenerAdapter {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b a;

                public a(b bVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = bVar;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                        this.a.a.a.g.setVisibility(0);
                    }
                }
            }

            public b(h hVar) {
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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a.a.g, Key.TRANSLATION_Y, this.a.a.g.getHeight(), 0.0f);
                    ofFloat.setDuration(250L);
                    ofFloat.addListener(new a(this));
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a.a.d.getLayoutParams();
                    layoutParams.removeRule(3);
                    layoutParams.removeRule(2);
                    this.a.a.l = (vi.j(this.a.a.a.getPageActivity()) - this.a.a.f.getHeight()) - this.a.a.e.getHeight();
                    sr6 sr6Var = this.a.a;
                    sr6Var.m = vi.l(sr6Var.a.getPageActivity());
                    if (this.a.a.i > 1.0f) {
                        layoutParams.width = Math.min((int) (this.a.a.l / this.a.a.i), this.a.a.m);
                    } else if (this.a.a.i > 0.0f) {
                        layoutParams.width = this.a.a.m;
                    }
                    layoutParams.height = (int) (layoutParams.width * this.a.a.i);
                    this.a.a.d.requestLayout();
                    p6a.h(this.a.a.a.getPageActivity().getIntent(), this.a.a.d);
                    ofFloat.start();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class a implements Runnable {
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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || ListUtils.isEmpty(this.a.a.q)) {
                    return;
                }
                this.a.a.g.y(-1, this.a.a.b.getCurrentIndex());
            }
        }

        public h(sr6 sr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sr6Var;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IMultiMediaPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null) {
                this.a.b.pause();
                this.a.g.post(new a(this));
                if (this.a.h == 2 && !this.a.n) {
                    this.a.n = true;
                    this.a.d.post(new b(this));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements ci6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sr6 a;

        /* renamed from: com.baidu.tieba.sr6$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0457a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0457a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.a.a.S();
            }
        }

        public a(sr6 sr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sr6Var;
        }

        @Override // com.baidu.tieba.ci6
        public boolean a(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
                boolean z = false;
                for (int i = 0; i < this.a.p.size(); i++) {
                    MultiMediaData multiMediaData = (MultiMediaData) this.a.p.get(i);
                    if (multiMediaData != null && multiMediaData.mSpeed != f) {
                        multiMediaData.mSpeed = f;
                        this.a.o = true;
                    }
                }
                wg.a().postDelayed(new RunnableC0457a(this), 100L);
                this.a.g.setLocalAlbumInfoData(this.a.b, this.a.p, false);
                if (this.a.r != null) {
                    MultiMediaEditLayout multiMediaEditLayout = this.a.g;
                    boolean c = this.a.r.c();
                    if (this.a.r.a() == 0) {
                        z = true;
                    }
                    multiMediaEditLayout.A(c, z);
                }
                return true;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements tca {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sr6 a;

        @Override // com.baidu.tieba.tca
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tieba.tca
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            }
        }

        @Override // com.baidu.tieba.tca
        public void d(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.tca
        public void f(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.tca
        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            }
        }

        @Override // com.baidu.tieba.tca
        public void j(int i, vca vcaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048585, this, i, vcaVar) == null) {
            }
        }

        @Override // com.baidu.tieba.tca
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            }
        }

        /* loaded from: classes7.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ g b;

            public a(g gVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = gVar;
                this.a = i;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeL(1048576, this, valueAnimator) != null) || this.b.a.b == null) {
                    return;
                }
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.b.a.b.setAngle(this.a, floatValue);
                ((MultiMediaData) this.b.a.p.get(this.a)).angle = floatValue;
                if (this.b.a.d != null && !this.b.a.b.isPlaying()) {
                    this.b.a.d.requestRender();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public b(g gVar) {
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

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeL(1048576, this, valueAnimator) != null) || this.a.a.b == null) {
                    return;
                }
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                for (int i = 0; i < this.a.a.p.size(); i++) {
                    this.a.a.b.setAngle(i, floatValue);
                    ((MultiMediaData) this.a.a.p.get(i)).angle = floatValue;
                    if (this.a.a.d != null && !this.a.a.b.isPlaying()) {
                        this.a.a.d.requestRender();
                    }
                }
            }
        }

        public g(sr6 sr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sr6Var;
        }

        @Override // com.baidu.tieba.tca
        public void c(double d) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d)}) == null) && this.a.b != null) {
                this.a.b.seek((long) d);
            }
        }

        @Override // com.baidu.tieba.tca
        public void l(double d) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Double.valueOf(d)}) == null) && this.a.b != null) {
                this.a.b.seek((long) d);
            }
        }

        @Override // com.baidu.tieba.tca
        public void e(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) && this.a.b != null && !ListUtils.isEmpty(this.a.p)) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(i, i2);
                ofFloat.addUpdateListener(new b(this));
                ofFloat.setDuration(300L);
                ofFloat.start();
                this.a.M();
                this.a.o = true;
            }
        }

        @Override // com.baidu.tieba.tca
        public void g(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIII(1048582, this, i, i2, i3) == null) && this.a.b != null) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(i2, i3);
                ofFloat.addUpdateListener(new a(this, i));
                ofFloat.setDuration(300L);
                ofFloat.start();
            }
        }

        @Override // com.baidu.tieba.tca
        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.a.o = true;
                if ((this.a.k - this.a.j) - 100 < 3000 && !l95.m().i("key_file_video_clip_less_3_tip_show", false)) {
                    this.a.T(R.string.obfuscated_res_0x7f0f0722);
                    l95.m().w("key_file_video_clip_less_3_tip_show", true);
                }
            }
        }

        @Override // com.baidu.tieba.tca
        public void k() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || this.a.s == null) {
                return;
            }
            int a2 = this.a.s.a();
            this.a.N();
            boolean z = false;
            if (a2 != 0) {
                this.a.s.b(0);
            }
            if (this.a.g != null) {
                MultiMediaEditLayout multiMediaEditLayout = this.a.g;
                if (this.a.s.a() == 0) {
                    z = true;
                }
                multiMediaEditLayout.z(z);
            }
        }

        @Override // com.baidu.tieba.tca
        public void m() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || this.a.r == null) {
                return;
            }
            int a2 = this.a.r.a();
            this.a.N();
            boolean z = false;
            if (a2 != 0) {
                this.a.r.b(0);
            }
            if (this.a.g != null) {
                MultiMediaEditLayout multiMediaEditLayout = this.a.g;
                boolean c = this.a.r.c();
                if (this.a.r.a() == 0) {
                    z = true;
                }
                multiMediaEditLayout.A(c, z);
            }
        }

        @Override // com.baidu.tieba.tca
        public void n(long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && this.a.b != null) {
                this.a.b.seek(j);
            }
        }

        @Override // com.baidu.tieba.tca
        public void o(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                if (this.a.b != null) {
                    this.a.b.seek(j);
                }
                this.a.j = j;
                this.a.k = j2;
                if (this.a.o && (this.a.k - this.a.j) - 100 < 3000 && !l95.m().i("key_file_video_clip_less_3_tip_show", false)) {
                    this.a.T(R.string.obfuscated_res_0x7f0f0722);
                    l95.m().w("key_file_video_clip_less_3_tip_show", true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements MultiMediaStateEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sr6 a;

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener
        public void onIndexChanged(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener
        public void onPlayEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener
        public void onRepeatIndexEnd(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener
        public void onRepeatIndexLoop(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            }
        }

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j a;

            public a(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || ListUtils.isEmpty(this.a.a.q)) {
                    return;
                }
                this.a.a.g.y(-1, this.a.a.b.getCurrentIndex());
            }
        }

        public j(sr6 sr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sr6Var;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaStateEventListener
        public void onLoop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.g.post(new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements FilenameFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(sr6 sr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, str)) == null) {
                return str.endsWith(".png");
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends IVLogPlayControlProtocol.OnPlayStateListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qr6.a a;

        public c(sr6 sr6Var, qr6.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr6Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListenerAdapter, com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.onPause();
                this.a.a();
            }
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListenerAdapter, com.baidu.ugc.editvideo.record.source.multimedia.IVLogPlayControlProtocol.OnPlayStateListener
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.onStart();
                this.a.c();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements di6.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sr6 a;

        public d(sr6 sr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sr6Var;
        }

        @Override // com.baidu.tieba.di6.a
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (i == 3) {
                    if (ListUtils.getCount(this.a.p) < 1 || ((float) (this.a.k - this.a.j)) * ((MultiMediaData) this.a.p.get(0)).getCurrentSpeed() < 6000.0f) {
                        BdToast b = BdToast.b(this.a.a.getPageActivity(), String.format(this.a.a.getString(R.string.obfuscated_res_0x7f0f071d), 6));
                        b.g(BdToast.ToastIcon.FAILURE);
                        b.o();
                        return false;
                    }
                } else if (i == 4 && (ListUtils.getCount(this.a.p) < 1 || ((float) (this.a.k - this.a.j)) * ((MultiMediaData) this.a.p.get(0)).getCurrentSpeed() < 9000.0f)) {
                    BdToast b2 = BdToast.b(this.a.a.getPageActivity(), String.format(this.a.a.getString(R.string.obfuscated_res_0x7f0f071d), 9));
                    b2.g(BdToast.ToastIcon.FAILURE);
                    b2.o();
                    return false;
                }
                return true;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e implements zh6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sr6 a;

        public e(sr6 sr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sr6Var;
        }

        @Override // com.baidu.tieba.zh6
        public boolean a(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
                boolean z = true;
                if (this.a.i != f) {
                    this.a.i = f;
                    this.a.M();
                    this.a.o = true;
                    if (this.a.s != null) {
                        MultiMediaEditLayout multiMediaEditLayout = this.a.g;
                        if (this.a.s.a() != 0) {
                            z = false;
                        }
                        multiMediaEditLayout.z(z);
                    }
                    return false;
                }
                return true;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sr6 a;

        public f(sr6 sr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sr6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.d != null) {
                this.a.b.setVideoRatio(this.a.i);
                if (this.a.b != null && !this.a.b.isPlaying()) {
                    this.a.d.requestRender();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements MultiMediaTimelineUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sr6 a;

        public i(sr6 sr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sr6Var;
        }

        @Override // com.baidu.ugc.editvideo.record.source.multimedia.MultiMediaTimelineUpdateListener
        public void onTimelineUpdate(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                if (this.a.g.s()) {
                    j -= this.a.g.getSingleMediaStartDuration();
                    if (this.a.g.getSingleClipTo() - j <= 150) {
                        this.a.b.seek(this.a.g.getSingleClipFrom() + this.a.g.getSingleMediaStartDuration());
                    }
                } else if (this.a.g.getAllClipTo() - j <= 100) {
                    this.a.b.seek(this.a.g.getAllClipFrom());
                }
                this.a.g.B(j);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements xqa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sr6 a;

        @Override // com.baidu.tieba.xqa
        public esa c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (esa) invokeV.objValue;
        }

        @Override // com.baidu.tieba.xqa
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "tieba_unknown" : (String) invokeV.objValue;
        }

        public k(sr6 sr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sr6Var;
        }

        @Override // com.baidu.tieba.xqa
        public IMediaPlayer a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new sca(this.a.a.getPageActivity());
            }
            return (IMediaPlayer) invokeV.objValue;
        }

        @Override // com.baidu.tieba.xqa
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.t) {
                    return z6a.c;
                }
                return z6a.d;
            }
            return (String) invokeV.objValue;
        }
    }

    public sr6(TbPageContext tbPageContext, TbGLMediaPreviewView tbGLMediaPreviewView, MultiMediaEditLayout multiMediaEditLayout, TbMultiMediaData tbMultiMediaData, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, tbGLMediaPreviewView, multiMediaEditLayout, tbMultiMediaData, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = false;
        this.t = false;
        this.u = new a(this);
        this.v = new d(this);
        this.w = new e(this);
        this.a = tbPageContext;
        this.r = new ei6(tbPageContext, this.u, this.v);
        this.d = tbGLMediaPreviewView;
        this.g = multiMediaEditLayout;
        this.h = i2;
        this.t = z;
        ArrayList arrayList = new ArrayList();
        this.p = arrayList;
        arrayList.add(tbMultiMediaData);
        if (!ListUtils.isEmpty(this.p) && this.p.get(0).height > 0 && this.p.get(0).width > 0) {
            this.i = (this.p.get(0).height * 1.0f) / this.p.get(0).width;
            bi6 bi6Var = new bi6(this.a, this.p.get(0).height, this.p.get(0).width, this.w);
            this.s = bi6Var;
            bi6Var.d(0);
        }
        if (tbMultiMediaData != null) {
            this.j = tbMultiMediaData.start;
            tbMultiMediaData.start = 0L;
            this.k = tbMultiMediaData.end;
            tbMultiMediaData.end = tbMultiMediaData.originalDuration;
        }
        O();
    }

    @Override // com.baidu.tieba.qr6
    public void b(qr6.a aVar) {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) && (vlogEditManager = this.b) != null) {
            vlogEditManager.setOnPlayStateListener(null);
            this.b.setOnPlayStateListener(new c(this, aVar));
        }
    }

    @Override // com.baidu.tieba.qr6
    public void f(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeF(1048589, this, f2) != null) || this.i == f2) {
            return;
        }
        this.i = f2;
        M();
        VlogEditManager vlogEditManager = this.b;
        if (vlogEditManager != null && !vlogEditManager.isPlaying()) {
            VlogEditManager vlogEditManager2 = this.b;
            vlogEditManager2.seek(vlogEditManager2.getCurrentPlayTime());
        }
    }

    @Override // com.baidu.tieba.qr6
    public void h(boolean z) {
        MultiMediaEditLayout multiMediaEditLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048595, this, z) == null) && (multiMediaEditLayout = this.g) != null) {
            multiMediaEditLayout.setOnlyClip(z);
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f.post(new f(this));
        }
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!h6a.a()) {
                this.a.getPageActivity().finish();
                return false;
            }
            P();
            R();
            Q();
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            wqa.c().h(TbadkCoreApplication.getInst());
            wqa.c().j(FileHelper.getCacheDir());
            wqa.c().k(new k(this));
        }
    }

    @Override // com.baidu.tieba.qr6
    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.k;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.qr6
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            wqa.c().k(null);
        }
    }

    @Override // com.baidu.tieba.qr6
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.qr6
    public long getCurrentPlayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            VlogEditManager vlogEditManager = this.b;
            if (vlogEditManager != null) {
                return vlogEditManager.getCurrentPlayTime();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.qr6
    public long getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.j;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.qr6
    public TbMediaTrackConfig getMediaTrackConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.b != null) {
                return (TbMediaTrackConfig) new Gson().fromJson(this.b.exportConfigJson(MediaTrackConfig.AE_IMPORT_DRAFT), (Class<Object>) TbMediaTrackConfig.class);
            }
            return null;
        }
        return (TbMediaTrackConfig) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qr6
    public float getRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.i;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.tieba.qr6
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            VlogEditManager vlogEditManager = this.b;
            if (vlogEditManager != null) {
                return vlogEditManager.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.qr6
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            VlogEditManager vlogEditManager = this.b;
            if (vlogEditManager != null) {
                vlogEditManager.onDestroy();
            }
            TbGLMediaPreviewView tbGLMediaPreviewView = this.d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onDestroy();
            }
            MultiMediaEditLayout multiMediaEditLayout = this.g;
            if (multiMediaEditLayout != null) {
                multiMediaEditLayout.t();
            }
        }
    }

    @Override // com.baidu.tieba.qr6
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            VlogEditManager vlogEditManager = this.b;
            if (vlogEditManager != null) {
                vlogEditManager.onPause();
            }
            TbGLMediaPreviewView tbGLMediaPreviewView = this.d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onPause();
            }
        }
    }

    @Override // com.baidu.tieba.qr6
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            TbGLMediaPreviewView tbGLMediaPreviewView = this.d;
            if (tbGLMediaPreviewView != null) {
                tbGLMediaPreviewView.onResume();
            }
            VlogEditManager vlogEditManager = this.b;
            if (vlogEditManager != null) {
                vlogEditManager.onResume();
            }
        }
    }

    @Override // com.baidu.tieba.qr6
    public void pause() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (vlogEditManager = this.b) != null) {
            vlogEditManager.pause();
        }
    }

    @Override // com.baidu.tieba.qr6
    public void start() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (vlogEditManager = this.b) != null) {
            vlogEditManager.start();
            this.o = true;
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            di6 di6Var = this.r;
            if (di6Var != null) {
                di6Var.b(8);
                MultiMediaEditLayout multiMediaEditLayout = this.g;
                if (multiMediaEditLayout != null) {
                    multiMediaEditLayout.A(this.r.c(), false);
                }
            }
            ai6 ai6Var = this.s;
            if (ai6Var != null) {
                ai6Var.b(8);
                MultiMediaEditLayout multiMediaEditLayout2 = this.g;
                if (multiMediaEditLayout2 != null) {
                    multiMediaEditLayout2.z(false);
                }
            }
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.d.setZOrderMediaOverlay(true);
            this.d.setMultiMediaDataSourceViewAdapter(this.c, true);
            this.e = (NavigationBar) this.a.getPageActivity().findViewById(R.id.navigation_bar);
            this.f = (FrameLayout) this.a.getPageActivity().findViewById(R.id.obfuscated_res_0x7f092512);
            this.g.setPageContext(this.a);
            this.g.setOnlyOneVideo();
            this.g.setLocalAlbumInfoData(this.b, this.p);
            this.g.setMultiVideoClipLayoutRange((int) this.j, (int) this.k);
            this.g.setIMultiMediaEditView(new g(this));
        }
    }

    public final void S() {
        VlogEditManager vlogEditManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (vlogEditManager = this.b) != null && this.g != null) {
            boolean isPlaying = vlogEditManager.isPlaying();
            this.b.reset();
            this.b.setMultiMediaData(this.p);
            if (this.g.s()) {
                int i2 = 0;
                MediaTrack mediaTrack = (MediaTrack) ListUtils.getItem(this.b.getUpdateMediaTracks(), 0);
                int currentMediaPosition = this.g.getCurrentMediaPosition();
                if (mediaTrack != null) {
                    List<MediaSegment> list = mediaTrack.mediaSegments;
                    if (!ListUtils.isEmpty(list)) {
                        int i3 = 0;
                        while (i2 < currentMediaPosition) {
                            i3 = (int) (i3 + (list.get(i2).end - list.get(i2).start));
                            i2++;
                        }
                        i2 = i3;
                    }
                }
                int i4 = i2 + 100;
                this.g.setSingleMediaStartDuration(i4);
                this.b.seek(i4 + this.g.getSingleClipFrom());
            } else {
                this.b.seek(this.g.getAllClipFrom());
            }
            if (isPlaying) {
                this.b.start();
            } else {
                this.b.pause();
            }
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MultiMediaDataSourceViewAdapter multiMediaDataSourceViewAdapter = new MultiMediaDataSourceViewAdapter();
            this.c = multiMediaDataSourceViewAdapter;
            VlogEditManager vlogEditManager = new VlogEditManager(multiMediaDataSourceViewAdapter);
            this.b = vlogEditManager;
            vlogEditManager.setMultiMediaData(this.p);
            this.b.setLooping(true);
            this.b.setPreparedListener(new h(this));
            this.b.setMultiMediaTimelineUpdateListener(new i(this), true);
            this.b.setMultiMediaStateEventListener(new j(this));
        }
    }

    public final void T(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i2) == null) && i2 > 0) {
            mr6 mr6Var = new mr6(this.a, this.g);
            mr6Var.L(R.drawable.bg_tip_blue_up_right);
            mr6Var.l(4);
            mr6Var.N(true);
            mr6Var.Q(-UtilHelper.getDimenPixelSize(R.dimen.tbds78));
            mr6Var.R(UtilHelper.getDimenPixelSize(R.dimen.tbds19));
            mr6Var.C(R.color.CAM_X0101);
            mr6Var.J(R.dimen.T_X08);
            mr6Var.p(R.dimen.T_X08);
            mr6Var.F(UtilHelper.getDimenPixelSize(R.dimen.tbds26));
            mr6Var.I(UtilHelper.getDimenPixelSize(R.dimen.tbds44));
            mr6Var.S(this.a.getPageActivity().getResources().getString(i2));
        }
    }

    @Override // com.baidu.tieba.qr6
    public boolean a(QmFilterItem qmFilterItem) {
        InterceptResult invokeL;
        float f2;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qmFilterItem)) == null) {
            String str = IVlogEditManager.FILTER_ORIGINAL;
            if (qmFilterItem != null && !StringUtils.isNull(qmFilterItem.localPath) && !"origin".equals(qmFilterItem.localPath)) {
                f2 = tg.d(qmFilterItem.effect, 100.0f) / 100.0f;
                File file = new File(qmFilterItem.localPath);
                if (file.isDirectory() && (listFiles = file.listFiles(new b(this))) != null && listFiles.length > 0) {
                    str = listFiles[0].getAbsolutePath();
                }
            } else {
                f2 = 0.0f;
            }
            VlogEditManager vlogEditManager = this.b;
            if (vlogEditManager != null) {
                try {
                    vlogEditManager.setFilter(f2, str);
                    return true;
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.qr6
    public void c(TbMultiMediaData tbMultiMediaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, tbMultiMediaData) != null) || tbMultiMediaData == null) {
            return;
        }
        this.p.clear();
        this.p.add(tbMultiMediaData);
        S();
        MultiMediaEditLayout multiMediaEditLayout = this.g;
        if (multiMediaEditLayout != null) {
            multiMediaEditLayout.u();
        }
        ai6 ai6Var = this.s;
        if (ai6Var != null) {
            ai6Var.reset();
        }
        di6 di6Var = this.r;
        if (di6Var != null) {
            di6Var.reset();
        }
    }
}
