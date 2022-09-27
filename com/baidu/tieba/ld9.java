package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ng9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.utils.FileUtils;
import com.google.android.material.badge.BadgeDrawable;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class ld9 extends kd9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int h;
    public int i;
    public int j;
    public fd9 k;
    public long l;
    public boolean m;
    public boolean n;
    public gd9 o;
    public boolean p;
    public boolean q;
    public hd9 r;

    /* loaded from: classes4.dex */
    public class a implements ng9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ ld9 b;

        public a(ld9 ld9Var, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ld9Var, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ld9Var;
            this.a = sb;
        }

        @Override // com.baidu.tieba.ng9.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.b) {
                    this.b.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.ng9.a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(",createMuteAudio ffmpegerror:");
                sb.append(i);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(i2);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(obj != null ? obj.toString() : "");
                String sb2 = sb.toString();
                this.a.append(sb2);
                qg9.j("FFmpegChain", sb2);
                synchronized (this.b) {
                    this.b.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.tieba.ng9.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                if (i != 1001 || i2 < 0) {
                    return false;
                }
                qg9.j("FFmpegChain", " createMuteAudio 进度i1 = " + i2);
                ld9 ld9Var = this.b;
                ld9Var.i((int) (((float) ld9Var.i) + (((((float) i2) * 1.0f) / 100.0f) * 10.0f)));
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ng9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ ld9 b;

        public b(ld9 ld9Var, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ld9Var, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ld9Var;
            this.a = sb;
        }

        @Override // com.baidu.tieba.ng9.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.b) {
                    this.b.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.ng9.a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(",concatAudio ffmpegerror:");
                sb.append(i);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(i2);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(obj != null ? obj.toString() : "");
                String sb2 = sb.toString();
                this.a.append(sb2);
                qg9.j("FFmpegChain", sb2);
                synchronized (this.b) {
                    this.b.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.tieba.ng9.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                qg9.j("FFmpegChain", " concatMuteAudio 进度i1 = " + i2);
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ng9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ fd9 b;
        public final /* synthetic */ ld9 c;

        public c(ld9 ld9Var, StringBuilder sb, fd9 fd9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ld9Var, sb, fd9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ld9Var;
            this.a = sb;
            this.b = fd9Var;
        }

        @Override // com.baidu.tieba.ng9.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.c) {
                    this.c.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.ng9.a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(",dealAudioPlayData ffmpegerror:");
                sb.append(i);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(i2);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(obj != null ? obj.toString() : "");
                String sb2 = sb.toString();
                this.a.append(sb2);
                fd9 fd9Var = this.b;
                if (fd9Var != null && fd9Var.a() != null) {
                    this.a.append(",audioformat:");
                    this.a.append(this.b.a().f());
                    this.a.append(",audiopath:");
                    this.a.append(this.b.a().h());
                }
                qg9.j("FFmpegChain", sb2);
                synchronized (this.c) {
                    this.c.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.tieba.ng9.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                if (i != 1001 || i2 < 0) {
                    return false;
                }
                qg9.j("FFmpegChain", " dealAudioPlayData 进度i1 = " + i2);
                ld9 ld9Var = this.c;
                ld9Var.i(ld9Var.i + ((int) ((((((float) (this.c.j + (-1))) + ((((float) i2) * 1.0f) / 100.0f)) * 1.0f) / ((float) this.c.h)) * 60.0f)));
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ng9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ ld9 b;

        public d(ld9 ld9Var, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ld9Var, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ld9Var;
            this.a = sb;
        }

        @Override // com.baidu.tieba.ng9.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.b) {
                    this.b.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.ng9.a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("concatAudio ffmpegerror:");
                sb.append(i);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(i2);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(obj != null ? obj.toString() : "");
                String sb2 = sb.toString();
                this.a.append(sb2);
                qg9.j("FFmpegChain", sb2);
                synchronized (this.b) {
                    this.b.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.tieba.ng9.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                if (i != 1001 || i2 < 0) {
                    return false;
                }
                qg9.j("FFmpegChain", " concatAudio 进度i1 = " + i2);
                ld9 ld9Var = this.b;
                ld9Var.i((int) (((float) ld9Var.i) + (((((float) i2) * 1.0f) / 100.0f) * 10.0f)));
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements ng9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ ld9 b;

        public e(ld9 ld9Var, StringBuilder sb) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ld9Var, sb};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ld9Var;
            this.a = sb;
        }

        @Override // com.baidu.tieba.ng9.a
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.b) {
                    this.b.notifyAll();
                }
            }
        }

        @Override // com.baidu.tieba.ng9.a
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, obj)) == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("mixAudio ffmpegerror:");
                sb.append(i);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(i2);
                sb.append(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                sb.append(obj != null ? obj.toString() : "");
                String sb2 = sb.toString();
                this.a.append(sb2);
                qg9.j("FFmpegChain", sb2);
                synchronized (this.b) {
                    this.b.notifyAll();
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.tieba.ng9.a
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, obj)) == null) {
                if (i != 1001 || i2 < 0) {
                    return false;
                }
                qg9.j("FFmpegChain", " mixAudio 进度i1 = " + i2);
                ld9 ld9Var = this.b;
                ld9Var.i((int) (((float) ld9Var.i) + (((((float) i2) * 1.0f) / 100.0f) * 20.0f)));
                return false;
            }
            return invokeIIL.booleanValue;
        }
    }

    public ld9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void A() {
        String str;
        String a2;
        gd9 gd9Var;
        fd9 fd9Var;
        gd9 gd9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            fd9 fd9Var2 = this.k;
            boolean z = fd9Var2 != null && fd9Var2.c();
            if (!z && ((gd9Var2 = this.o) == null || !FileUtils.isExists(gd9Var2.h()))) {
                g("nosource to create mute audio");
                return;
            }
            if (z && (gd9Var = this.o) != null && (fd9Var = this.k) != null && !gd9Var.equals(fd9Var.a())) {
                z = false;
            }
            StringBuilder sb = new StringBuilder();
            str = "";
            if (!z) {
                try {
                } catch (Throwable th) {
                    sb.append(th.getMessage());
                }
                if (this.o == null) {
                    return;
                }
                str = a(this.o.h(), "_mute.aac");
                ff9.l(this.o.h(), str, -1, -1, 0.0f, -1, 0.0f, -1.0f, false, new a(this, sb));
                try {
                    synchronized (this) {
                        wait();
                    }
                } catch (InterruptedException e2) {
                    sb.append(e2.getMessage());
                }
                if (FileUtils.isExists(a2) && TextUtils.isEmpty(sb.toString())) {
                    qg9.j("FFmpegChain", "createconcatMuteAudio 生成成功");
                    this.k = new fd9(new AudioPlayData(a2, 0, -1, 1.0f));
                    return;
                }
                g(sb.toString());
            }
            fd9 fd9Var3 = this.k;
            str = fd9Var3 != null ? fd9Var3.a().h() : "";
            i(this.i + 10);
            if (FileUtils.isExists(str) && TextUtils.isEmpty(sb.toString())) {
                qg9.j("FFmpegChain", "createMuteAudio 生成成功");
                fd9 fd9Var4 = new fd9(new AudioPlayData(str, 0, -1, 1.0f));
                this.k = fd9Var4;
                if (fd9Var4.a() == null || this.k.a().e() <= 0) {
                    return;
                }
                long e3 = this.k.a().e();
                long j = this.l;
                if (e3 >= j) {
                    return;
                }
                int e4 = (int) ((j / this.k.a().e()) + 1);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < e4; i++) {
                    arrayList.add(str);
                }
                a2 = a(str, "_concat.aac");
                ff9.b(arrayList, a2, this.g, new b(this, sb), false, true);
                try {
                } catch (InterruptedException e5) {
                    sb.append(e5.getMessage());
                }
                synchronized (this) {
                    wait();
                    if (FileUtils.isExists(a2)) {
                        qg9.j("FFmpegChain", "createconcatMuteAudio 生成成功");
                        this.k = new fd9(new AudioPlayData(a2, 0, -1, 1.0f));
                        return;
                    }
                }
            }
            g(sb.toString());
        }
    }

    public final void B(hd9 hd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hd9Var) == null) {
            if (hd9Var == null || vg9.e(hd9Var.c())) {
                g("concatAudio tempDataForOutPut data error");
                return;
            }
            List<jd9> c2 = hd9Var.c();
            StringBuilder sb = new StringBuilder();
            for (jd9 jd9Var : c2) {
                if (!vg9.e(jd9Var.a())) {
                    ArrayList arrayList = new ArrayList();
                    for (fd9 fd9Var : jd9Var.a()) {
                        if (fd9Var.b() != null) {
                            arrayList.add(fd9Var.b().audioPath);
                        }
                    }
                    if (!vg9.e(arrayList)) {
                        String str = this.g;
                        if (TextUtils.isEmpty(str)) {
                            str = FileUtils.getParentDir((String) arrayList.get(0));
                        }
                        String str2 = str + System.currentTimeMillis() + "_trackconcat.aac";
                        ff9.b(arrayList, str2, this.g, new d(this, sb), false, true);
                        try {
                            synchronized (this) {
                                wait();
                            }
                        } catch (InterruptedException e2) {
                            sb.append(e2.getMessage());
                        }
                        if (FileUtils.isExists(str2) && TextUtils.isEmpty(sb.toString())) {
                            qg9.j("FFmpegChain", "concatAudio 生成成功");
                            fd9 fd9Var2 = new fd9(new AudioPlayData(str2, 0, -1, 1.0f));
                            jd9Var.a().clear();
                            jd9Var.a().add(fd9Var2);
                        } else {
                            g(sb.toString());
                        }
                    }
                }
            }
        }
    }

    public final void C(hd9 hd9Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hd9Var) == null) {
            if (hd9Var == null || vg9.b(hd9Var.c()) < 2) {
                str = "mixAudio tempDataForOutPut data error";
            } else {
                List<jd9> c2 = hd9Var.c();
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                for (jd9 jd9Var : c2) {
                    if (jd9Var != null && !vg9.e(jd9Var.a())) {
                        fd9 fd9Var = jd9Var.a().get(0);
                        if (fd9Var.b() != null) {
                            arrayList.add(fd9Var.b().audioPath);
                        }
                    }
                }
                if (arrayList.size() >= 2) {
                    String str2 = this.g;
                    if (TextUtils.isEmpty(str2)) {
                        str2 = FileUtils.getParentDir((String) arrayList.get(0));
                    }
                    String str3 = str2 + System.currentTimeMillis() + "_mix.aac";
                    ff9.k(arrayList, str3, -1, new e(this, sb));
                    try {
                        synchronized (this) {
                            wait();
                        }
                    } catch (InterruptedException e2) {
                        sb.append(e2.getMessage());
                    }
                    if (!FileUtils.isExists(str3) || !TextUtils.isEmpty(sb.toString())) {
                        g(sb.toString());
                        return;
                    }
                    qg9.j("FFmpegChain", "mixAudio 生成成功");
                    fd9 fd9Var2 = new fd9(new AudioPlayData(str3, 0, -1, 1.0f));
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(fd9Var2);
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(new jd9(arrayList2));
                    this.r = new hd9(arrayList3);
                    return;
                }
                str = "mixAudio inputList data error";
            }
            g(str);
        }
    }

    @Override // com.baidu.tieba.kd9
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f = true;
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.baidu.tieba.kd9
    public void d(hd9 hd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hd9Var) == null) {
            if (hd9Var == null || vg9.e(hd9Var.c())) {
                g("input data error: null or length=0");
                return;
            }
            this.m = false;
            this.n = false;
            this.p = false;
            this.q = false;
            if (!j(hd9Var)) {
                l(hd9Var);
                return;
            }
            String a2 = hd9Var.a();
            this.g = a2;
            if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                new File(this.g).mkdir();
            }
            this.e = false;
            this.f = false;
            this.k = hd9Var.b();
            x(hd9Var);
            y(hd9Var);
            this.i = 0;
            if (this.m && !this.f && !this.e) {
                A();
            }
            if (this.n && !this.f && !this.e) {
                this.i = 10;
                i(10);
                z(hd9Var);
            }
            if (this.p && !this.f && !this.e) {
                this.i = 70;
                i(70);
                B(this.r);
            }
            if (this.q && !this.f && !this.e) {
                this.i = 80;
                i(80);
                C(this.r);
            }
            if (this.e || this.f) {
                return;
            }
            l(this.r);
        }
    }

    @Override // com.baidu.tieba.kd9
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public final void q(fd9 fd9Var, int i) {
        int i2;
        fd9 fd9Var2;
        StringBuilder sb;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, fd9Var, i) == null) || this.e || this.f) {
            return;
        }
        AudioPlayData b2 = fd9Var.b();
        if (b2 == null) {
            sb = new StringBuilder();
            str = "dealAudioPlayData audioPlayData = null,trackIndx:";
        } else if (this.o != null) {
            if (!fd9Var.c() && (fd9Var2 = this.k) != null && fd9Var2.b() != null) {
                b2.audioPath = this.k.b().audioPath;
                fd9Var.d(this.k.a());
            }
            StringBuilder sb2 = new StringBuilder();
            String str2 = b2.audioPath;
            String a2 = a(str2, System.currentTimeMillis() + "_ffmpeg.aac");
            try {
                boolean z = fd9Var.a() != null && "audio/mp4a-latm".equals(fd9Var.a().f());
                String str3 = b2.audioPath;
                int g = this.o.g();
                int d2 = this.o.d();
                float f = b2.volume;
                int c2 = this.o.c();
                float f2 = (b2.start * 1.0f) / 1000.0f;
                float f3 = ((b2.end - b2.start) * 1.0f) / 1000.0f;
                i2 = 0;
                try {
                    ff9.l(str3, a2, g, d2, f, c2, f2, f3, !z, new c(this, sb2, fd9Var));
                    try {
                        synchronized (this) {
                            wait();
                        }
                    } catch (InterruptedException e2) {
                        sb2.append(e2.getMessage());
                    }
                } catch (Throwable th) {
                    th = th;
                    sb2.append(th.getMessage());
                    if (FileUtils.isExists(a2)) {
                    }
                    g(sb2.toString());
                    return;
                }
            } catch (Throwable th2) {
                th = th2;
                i2 = 0;
            }
            if (FileUtils.isExists(a2) || !TextUtils.isEmpty(sb2.toString())) {
                g(sb2.toString());
                return;
            }
            qg9.j("FFmpegChain", "dealAudioPlayData 生成成功");
            r(this.r, new fd9(new AudioPlayData(a2, i2, -1, 1.0f)), i);
            return;
        } else {
            sb = new StringBuilder();
            str = "dealAudioPlayData mTargetInfo = null ,trackIndx:";
        }
        sb.append(str);
        sb.append(i);
        g(sb.toString());
    }

    public final void r(hd9 hd9Var, fd9 fd9Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048583, this, hd9Var, fd9Var, i) == null) || hd9Var == null || hd9Var.c() == null || hd9Var.c().get(i) == null) {
            return;
        }
        hd9Var.c().get(i).a().add(fd9Var);
    }

    public final void s(jd9 jd9Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, jd9Var, i) == null) || jd9Var == null || vg9.e(jd9Var.a()) || this.f || this.e) {
            return;
        }
        for (int i2 = 0; !this.e && !this.f && i2 < jd9Var.a().size(); i2++) {
            fd9 fd9Var = jd9Var.a().get(i2);
            this.j++;
            if (v(fd9Var)) {
                q(fd9Var, i);
            } else {
                r(this.r, fd9Var, i);
                i(this.i + ((int) (((this.j * 1.0f) / this.h) * 60.0f)));
            }
        }
    }

    public final boolean t(fd9 fd9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, fd9Var)) == null) {
            if (fd9Var == null || fd9Var.b() == null || !FileUtils.isExists(fd9Var.b().audioPath)) {
                return false;
            }
            if (fd9Var.b().start <= 0 && fd9Var.b().end <= 0 && fd9Var.b().volume == 1.0f) {
                return (fd9Var.a() == null || "audio/mp4a-latm".equals(fd9Var.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean v(fd9 fd9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, fd9Var)) == null) {
            if (fd9Var == null) {
                return false;
            }
            return t(fd9Var) || fd9Var.a() == null || fd9Var.a().k(this.o) != 0;
        }
        return invokeL.booleanValue;
    }

    public final void x(hd9 hd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, hd9Var) == null) {
            List<jd9> c2 = hd9Var.c();
            HashMap hashMap = new HashMap();
            if (c2.size() > 1) {
                this.q = true;
            }
            int i = 0;
            for (int i2 = 0; i2 < c2.size(); i2++) {
                if (!vg9.e(c2.get(i2).a())) {
                    this.h += vg9.b(c2.get(i2).a());
                    List<fd9> a2 = c2.get(i2).a();
                    if (!vg9.e(a2)) {
                        if (a2.size() > 1) {
                            this.p = true;
                        }
                        for (fd9 fd9Var : a2) {
                            if (fd9Var != null && fd9Var.b() != null && !fd9Var.c()) {
                                long j = fd9Var.b().end - fd9Var.b().start;
                                if (j > this.l) {
                                    this.l = j;
                                }
                                this.m = true;
                                this.n = true;
                            }
                            if (t(fd9Var)) {
                                this.n = true;
                            }
                            if (fd9Var != null && fd9Var.a() != null) {
                                Integer num = (Integer) hashMap.get(fd9Var.a());
                                if (num == null) {
                                    num = 0;
                                }
                                hashMap.put(fd9Var.a(), Integer.valueOf(num.intValue() + 1));
                            }
                        }
                    }
                }
            }
            if (hashMap.size() > 1) {
                this.n = true;
            }
            for (gd9 gd9Var : hashMap.keySet()) {
                if (((Integer) hashMap.get(gd9Var)).intValue() > i && "audio/mp4a-latm".equals(gd9Var.f())) {
                    this.o = gd9Var;
                    i = ((Integer) hashMap.get(gd9Var)).intValue();
                }
            }
            if (this.o == null) {
                this.o = gd9.b();
            }
        }
    }

    public final void y(hd9 hd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, hd9Var) == null) {
            if (this.n) {
                if (hd9Var == null || vg9.e(hd9Var.c())) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < hd9Var.c().size(); i++) {
                    arrayList.add(new jd9(new ArrayList()));
                }
                hd9Var = new hd9(arrayList);
            }
            this.r = hd9Var;
        }
    }

    public final void z(hd9 hd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, hd9Var) == null) {
            List<jd9> c2 = hd9Var.c();
            int size = c2.size();
            for (int i = 0; i < size; i++) {
                s(c2.get(i), i);
            }
        }
    }
}
