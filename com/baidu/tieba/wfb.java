package com.baidu.tieba;

import android.graphics.BitmapFactory;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;
import okio.Okio;
/* loaded from: classes8.dex */
public final class wfb {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948270070, "Lcom/baidu/tieba/wfb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948270070, "Lcom/baidu/tieba/wfb;");
                return;
            }
        }
        a = new a(null);
    }

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: com.baidu.tieba.wfb$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C0513a extends BdAsyncTask<Void, Void, Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ Function1<BdImage, Unit> b;
            public final /* synthetic */ int c;
            public final /* synthetic */ int d;

            public C0513a(String str, Function1<? super BdImage, Unit> function1, int i, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, function1, Integer.valueOf(i), Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
                this.b = function1;
                this.c = i;
                this.d = i2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Boolean doInBackground(Void... params) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, params)) == null) {
                    Intrinsics.checkNotNullParameter(params, "params");
                    File file = new File(this.a);
                    if (!file.exists()) {
                        this.b.invoke(null);
                        return Boolean.FALSE;
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    int i = 1;
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(this.a, options);
                    options.inPreferredConfig = TbConfig.BitmapConfig;
                    while (true) {
                        int i2 = i * 2;
                        if (options.outWidth / i2 <= this.c && options.outHeight / i2 <= this.d) {
                            break;
                        }
                        i = i2;
                    }
                    options.inJustDecodeBounds = false;
                    options.inSampleSize = i;
                    BufferedSource buffer = Okio.buffer(Okio.source(file));
                    this.b.invoke(new BdImage(BitmapFactory.decodeStream(buffer.inputStream(), null, options)));
                    try {
                        buffer.close();
                    } catch (Exception unused) {
                    }
                    return Boolean.TRUE;
                }
                return (Boolean) invokeL.objValue;
            }
        }

        public a() {
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

        public static /* synthetic */ void b(a aVar, String str, int i, int i2, Function1 function1, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                i = 160;
            }
            if ((i3 & 4) != 0) {
                i2 = 160;
            }
            aVar.a(str, i, i2, function1);
        }

        public final void a(String localPath, int i, int i2, Function1<? super BdImage, Unit> callback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{localPath, Integer.valueOf(i), Integer.valueOf(i2), callback}) == null) {
                Intrinsics.checkNotNullParameter(localPath, "localPath");
                Intrinsics.checkNotNullParameter(callback, "callback");
                new C0513a(localPath, callback, i, i2).execute(new Void[0]);
            }
        }
    }
}
