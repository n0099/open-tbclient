package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.InsertGalleryAsyncTask;
import com.baidu.tieba.k19;
import com.baidu.tieba.m19;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.muxer.VideoMuxer;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class p19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public TbPageContext b;
    public l19 c;
    public o19 d;
    public int e;
    public m19 f;
    public InsertGalleryAsyncTask g;
    public VideoMuxer h;
    public m19.b i;

    /* loaded from: classes5.dex */
    public class a implements m19.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p19 a;

        /* renamed from: com.baidu.tieba.p19$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0377a extends k19.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a b;

            public C0377a(a aVar) {
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
                this.b = aVar;
            }

            @Override // com.baidu.tieba.jf9
            public void b(int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                    return;
                }
                this.b.a.o(3, i);
            }

            @Override // com.baidu.tieba.jf9
            public void e(String str) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && this.b.a.c != null) {
                    this.b.a.c.onError(-1, str);
                }
            }

            @Override // com.baidu.tieba.k19.d
            public void g(String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                    this.b.a.o(3, 100);
                    if (this.b.a.c == null) {
                        return;
                    }
                    l19 l19Var = this.b.a.c;
                    String e = this.b.a.d.e();
                    l19Var.M0(str, str2, e, this.b.a.d.d() + "");
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.c != null) {
                    this.a.a.c.onFinish();
                }
            }
        }

        public a(p19 p19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p19Var;
        }

        @Override // com.baidu.tieba.m19.b
        public void a(boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
                if (!z) {
                    if (this.a.c != null) {
                        this.a.c.onError(-1, this.a.b.getString(R.string.obfuscated_res_0x7f0f125b));
                        ah.a().postDelayed(new b(this), 2000L);
                        return;
                    }
                    return;
                }
                this.a.a = str;
                this.a.o(2, 100);
                this.a.h = k19.p(TbadkCoreApplication.getInst().getCurrentPageContext(TbadkCoreApplication.getInst()), this.a.a, this.a.d.c(), new C0377a(this));
            }
        }

        @Override // com.baidu.tieba.m19.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
                this.a.o(2, (i * 100) / i2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends InsertGalleryAsyncTask.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ p19 b;

        public b(p19 p19Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p19Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p19Var;
            this.a = str;
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                this.b.c.onError(i, str);
            }
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.b.o(1, 100);
                this.b.n(this.a, str);
                p19 p19Var = this.b;
                p19Var.l(p19Var.d.f());
            }
        }
    }

    public p19(@NonNull TbPageContext tbPageContext, l19 l19Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, l19Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new a(this);
        this.b = tbPageContext;
        this.c = l19Var;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            InsertGalleryAsyncTask insertGalleryAsyncTask = this.g;
            if (insertGalleryAsyncTask != null) {
                insertGalleryAsyncTask.cancel();
            }
            m19 m19Var = this.f;
            if (m19Var != null) {
                m19Var.cancel();
            }
            VideoMuxer videoMuxer = this.h;
            if (videoMuxer != null) {
                videoMuxer.interruptProcess();
            }
        }
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/anniver";
        }
        return (String) invokeV.objValue;
    }

    public void k(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) || this.c == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.c.onError(-1, this.b.getString(R.string.obfuscated_res_0x7f0f1251));
            return;
        }
        if (!str.startsWith("http")) {
            str2 = TbConfig.getPhotoSmallAddress() + str;
        } else {
            str2 = str;
        }
        InsertGalleryAsyncTask insertGalleryAsyncTask = new InsertGalleryAsyncTask(this.b.getPageActivity(), str2, new b(this, str));
        this.g = insertGalleryAsyncTask;
        insertGalleryAsyncTask.setFrom(3);
        this.g.setCareHeaderContentLength(false);
        this.g.setRenameGif(true);
        this.g.execute(new String[0]);
    }

    public void l(String str) {
        l19 l19Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (TextUtils.isEmpty(str) && (l19Var = this.c) != null) {
                l19Var.onError(-1, this.b.getString(R.string.obfuscated_res_0x7f0f1257));
                return;
            }
            m19 m19Var = new m19(j(), str, this.i);
            this.f = m19Var;
            m19Var.execute(new Void[0]);
        }
    }

    public void m(o19 o19Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, o19Var) == null) {
            this.d = o19Var;
            Iterator<n19> it = o19Var.c().iterator();
            while (true) {
                if (it.hasNext()) {
                    n19 next = it.next();
                    if (next != null && next.b == 2) {
                        str = next.a;
                        break;
                    }
                } else {
                    str = null;
                    break;
                }
            }
            if (!TextUtils.isEmpty(str)) {
                k(str);
            } else {
                l(this.d.f());
            }
        }
    }

    public final void n(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            for (int i = 0; i < this.d.c().size(); i++) {
                n19 n19Var = this.d.c().get(i);
                if (n19Var != null && n19Var.b == 2 && str.equals(n19Var.a)) {
                    n19Var.a = str2;
                    this.d.c().set(i, n19Var);
                    return;
                }
            }
        }
    }

    public final synchronized void o(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
            synchronized (this) {
                try {
                    if (i == 1) {
                        this.e = (int) (i2 * 0.1d);
                    } else if (i == 2) {
                        this.e = ((int) (i2 * 0.4d)) + 10;
                    } else if (i == 3) {
                        this.e = ((int) (i2 * 0.5d)) + 50;
                    }
                    if (this.c != null) {
                        this.c.c(this.e);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
