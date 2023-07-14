package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class jz6 {
    public static /* synthetic */ Interceptable $ic;
    public static final a d;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final String b;
    public final xe7 c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947900643, "Lcom/baidu/tieba/jz6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947900643, "Lcom/baidu/tieba/jz6;");
                return;
            }
        }
        d = new a(null);
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
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

        public final String a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                return context.getCacheDir().getAbsolutePath() + "/home_bottom_egg/";
            }
            return (String) invokeL.objValue;
        }

        public final String b(Context context, String videoUrl) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, videoUrl)) == null) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
                return a(context) + fj.c(videoUrl);
            }
            return (String) invokeLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends wy5<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ File a;

        public b(File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = file;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FileHelper.deleteFile(this.a);
            }
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.wy5
        public /* bridge */ /* synthetic */ Unit doInBackground() {
            a();
            return Unit.INSTANCE;
        }
    }

    public jz6(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
        this.b = d.a(context);
        this.c = new xe7();
    }

    public final void a(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
            az5.b(new b(file), null);
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            File file = new File(this.b);
            if (!file.exists()) {
                file.mkdir();
            }
            DownloadData downloadData = new DownloadData();
            downloadData.setUrl(str);
            StringBuilder sb = new StringBuilder();
            sb.append(this.b);
            sb.append("/");
            String c = fj.c(str);
            sb.append(c);
            downloadData.setPath(sb.toString());
            this.c.h(downloadData);
            da5.p().J("key_home_bottom_egg_video_name", c);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(String jsonStr) {
        boolean z;
        boolean z2;
        String str;
        boolean z3;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsonStr) == null) {
            Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
            boolean z4 = true;
            if (jsonStr.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return;
            }
            try {
                jSONObject = new JSONObject(jsonStr);
                if (jSONObject.optInt("is_video") == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } catch (Exception e) {
                e = e;
                z2 = false;
            }
            try {
                str = jSONObject.optString("video_url");
                Intrinsics.checkNotNullExpressionValue(str, "jsonObject.optString(\"video_url\")");
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                str = "";
                if (!z2) {
                }
            }
            if (!z2) {
                if (str.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    if (!new File(this.b + fj.c(str)).exists()) {
                        String oldVideoName = da5.p().w("key_home_bottom_egg_video_name", "");
                        Intrinsics.checkNotNullExpressionValue(oldVideoName, "oldVideoName");
                        if (oldVideoName.length() <= 0) {
                            z4 = false;
                        }
                        if (z4) {
                            File file = new File(this.b + oldVideoName);
                            if (file.exists()) {
                                a(file);
                            }
                        }
                        b(str);
                    }
                }
            }
        }
    }

    public final Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (Context) invokeV.objValue;
    }
}
