package com.baidu.tieba;

import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.video.record.GLVideoPreviewView;
import com.baidu.tieba.video.record.ProgressView;
import com.baidu.tieba.video.record.RecordVideoActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.encoder.TextureMovieEncoder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class lw8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public RecordVideoActivity c;
    public ProgressView d;
    public List<b> e;
    public boolean f;
    public long g;
    public int h;

    /* loaded from: classes4.dex */
    public class a implements ProgressView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lw8 a;

        /* renamed from: com.baidu.tieba.lw8$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0330a implements TextureMovieEncoder.OnEncoderStatusUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ jw8 a;
            public final /* synthetic */ a b;

            /* renamed from: com.baidu.tieba.lw8$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC0331a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0330a a;

                public RunnableC0331a(C0330a c0330a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0330a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = c0330a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b.a.c == null) {
                        return;
                    }
                    this.a.b.a.c.y0();
                }
            }

            public C0330a(a aVar, jw8 jw8Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, jw8Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = jw8Var;
            }

            @Override // com.faceunity.encoder.TextureMovieEncoder.OnEncoderStatusUpdateListener
            public void onStartSuccess() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.faceunity.encoder.TextureMovieEncoder.OnEncoderStatusUpdateListener
            public void onStopSuccess() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    gh.a().post(new RunnableC0331a(this));
                    this.a.setOnEncoderStatusUpdateListener(null);
                }
            }
        }

        public a(lw8 lw8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lw8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lw8Var;
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void a(int i) {
            kw8 kw8Var;
            jw8 q;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.h = i;
                if (i != 100 || this.a.c == null || (kw8Var = this.a.c.k) == null || (q = kw8Var.q()) == null) {
                    return;
                }
                if (q instanceof GLVideoPreviewView) {
                    q.setOnEncoderStatusUpdateListener(new C0330a(this, q));
                    this.a.o();
                    return;
                }
                this.a.o();
                if (this.a.c != null) {
                    this.a.c.y0();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i);
    }

    public lw8(RecordVideoActivity recordVideoActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {recordVideoActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 1;
        this.c = recordVideoActivity;
        if (recordVideoActivity == null) {
            return;
        }
        ImageView imageView = (ImageView) recordVideoActivity.findViewById(R.id.obfuscated_res_0x7f090495);
        ImageView imageView2 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0909e6);
        ProgressView progressView = (ProgressView) this.c.findViewById(R.id.obfuscated_res_0x7f092561);
        this.d = progressView;
        progressView.setListener(new a(this));
        if (!ew8.f(true)) {
            imageView2.setVisibility(4);
        }
        if (ew8.g(recordVideoActivity.getPackageManager())) {
            return;
        }
        imageView.setVisibility(8);
    }

    public void c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            if (this.e == null) {
                this.e = new ArrayList();
            }
            this.e.add(bVar);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ProgressView progressView = this.d;
            if (progressView != null) {
                progressView.setCurrentState(ProgressView.State.DELETE);
            }
            this.b = this.d.getLastProgress();
            kw8 kw8Var = this.c.k;
            if (kw8Var != null) {
                kw8Var.h();
            }
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.h : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : invokeV.intValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a == 6 : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            mw8 mw8Var = this.c.I;
            if (mw8Var != null) {
                return mw8Var.i();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int f = f();
            return f == 2 || f == 7;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.d.b() : invokeV.booleanValue;
    }

    public void l() {
        ProgressView progressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f || (progressView = this.d) == null) {
            return;
        }
        progressView.setCurrentState(ProgressView.State.ROLLBACK);
    }

    public void m(int i) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.a = i;
            if (i == 1) {
                this.d.setVisibility(4);
                this.d.d();
                this.b = 0;
                File file = new File(nu8.f);
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        if (file2.getPath().startsWith("rec_tmp_")) {
                            file2.delete();
                        }
                    }
                }
            }
            List<b> list = this.e;
            if (list != null) {
                for (b bVar : list) {
                    bVar.a(this.a);
                }
            }
        }
    }

    public void n() {
        kw8 kw8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f) {
            return;
        }
        ProgressView progressView = this.d;
        if (progressView != null) {
            progressView.setVisibility(0);
            this.d.setCurrentState(ProgressView.State.START);
        }
        if (!this.f) {
            this.f = true;
            this.g = System.currentTimeMillis();
        }
        RecordVideoActivity recordVideoActivity = this.c;
        if (recordVideoActivity == null || (kw8Var = recordVideoActivity.k) == null) {
            return;
        }
        kw8Var.L();
        mw8 mw8Var = this.c.I;
        if (mw8Var != null) {
            mw8Var.n(this.b);
        }
    }

    public void o() {
        kw8 kw8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.f) {
            ProgressView progressView = this.d;
            if (progressView != null) {
                progressView.setCurrentState(ProgressView.State.PAUSE);
            }
            this.f = false;
            this.b = (int) (this.b + (System.currentTimeMillis() - this.g));
            ProgressView progressView2 = this.d;
            if (progressView2 != null) {
                int lastProgress = progressView2.getLastProgress();
                int i = this.b;
                if (lastProgress != i) {
                    this.d.c(i);
                }
            }
            RecordVideoActivity recordVideoActivity = this.c;
            if (recordVideoActivity == null || (kw8Var = recordVideoActivity.k) == null) {
                return;
            }
            kw8Var.M();
        }
    }
}
