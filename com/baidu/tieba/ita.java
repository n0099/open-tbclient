package com.baidu.tieba;

import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
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
/* loaded from: classes6.dex */
public class ita {
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

    /* loaded from: classes6.dex */
    public interface b {
        void a(int i);
    }

    /* loaded from: classes6.dex */
    public class a implements ProgressView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ita a;

        /* renamed from: com.baidu.tieba.ita$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0349a implements TextureMovieEncoder.OnEncoderStatusUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gta a;
            public final /* synthetic */ a b;

            @Override // com.faceunity.encoder.TextureMovieEncoder.OnEncoderStatusUpdateListener
            public void onStartSuccess() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                }
            }

            /* renamed from: com.baidu.tieba.ita$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0350a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0349a a;

                public RunnableC0350a(C0349a c0349a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0349a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = c0349a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b.a.c != null) {
                        this.a.b.a.c.n0();
                    }
                }
            }

            public C0349a(a aVar, gta gtaVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, gtaVar};
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
                this.a = gtaVar;
            }

            @Override // com.faceunity.encoder.TextureMovieEncoder.OnEncoderStatusUpdateListener
            public void onStopSuccess() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    SafeHandler.getInst().post(new RunnableC0350a(this));
                    this.a.setOnEncoderStatusUpdateListener(null);
                }
            }
        }

        public a(ita itaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = itaVar;
        }

        @Override // com.baidu.tieba.video.record.ProgressView.a
        public void a(int i) {
            hta htaVar;
            gta q;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.h = i;
                if (i != 100 || this.a.c == null || (htaVar = this.a.c.k) == null || (q = htaVar.q()) == null) {
                    return;
                }
                if (q instanceof GLVideoPreviewView) {
                    q.setOnEncoderStatusUpdateListener(new C0349a(this, q));
                    this.a.o();
                    return;
                }
                this.a.o();
                if (this.a.c != null) {
                    this.a.c.n0();
                }
            }
        }
    }

    public ita(RecordVideoActivity recordVideoActivity) {
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
        ImageView imageView = (ImageView) recordVideoActivity.findViewById(R.id.obfuscated_res_0x7f09053f);
        ImageView imageView2 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f090b4e);
        ProgressView progressView = (ProgressView) this.c.findViewById(R.id.obfuscated_res_0x7f092952);
        this.d = progressView;
        progressView.setListener(new a(this));
        if (!bta.f(true)) {
            imageView2.setVisibility(4);
        }
        if (!bta.g(recordVideoActivity.getPackageManager())) {
            imageView.setVisibility(8);
        }
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
                File file = new File(kra.f);
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
            hta htaVar = this.c.k;
            if (htaVar != null) {
                htaVar.h();
            }
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == 6) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            jta jtaVar = this.c.I;
            if (jtaVar != null) {
                return jtaVar.i();
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
            if (f != 2 && f != 7) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.d.b()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        ProgressView progressView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && !this.f && (progressView = this.d) != null) {
            progressView.setCurrentState(ProgressView.State.ROLLBACK);
        }
    }

    public void n() {
        hta htaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || this.f) {
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
        if (recordVideoActivity != null && (htaVar = recordVideoActivity.k) != null) {
            htaVar.L();
            jta jtaVar = this.c.I;
            if (jtaVar != null) {
                jtaVar.n(this.b);
            }
        }
    }

    public void o() {
        hta htaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || !this.f) {
            return;
        }
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
        if (recordVideoActivity != null && (htaVar = recordVideoActivity.k) != null) {
            htaVar.M();
        }
    }
}
