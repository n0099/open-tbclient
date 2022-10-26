package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class kg5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;
    public a b;
    public b c;

    /* loaded from: classes4.dex */
    public class a extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public boolean b;
        public int c;
        public String d;
        public String e;
        public boolean f;
        public int g;
        public View.OnClickListener h;

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
                    return;
                }
            }
            this.b = true;
            this.c = R.drawable.new_pic_emotion_05;
            this.d = kg5.c(R.string.obfuscated_res_0x7f0f0c83, new Object[0]);
            this.e = kg5.c(R.string.obfuscated_res_0x7f0f0feb, new Object[0]);
            this.f = false;
            this.g = fj.f(kg5.getContext(), R.dimen.obfuscated_res_0x7f0702bf);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public boolean b;
        public int c;
        public int d;
        public String e;
        public String f;
        public String g;
        public View.OnClickListener h;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = true;
            this.c = R.drawable.new_pic_emotion_08;
            this.d = fj.f(kg5.getContext(), R.dimen.obfuscated_res_0x7f070292);
            this.e = kg5.c(R.string.obfuscated_res_0x7f0f0feb, new Object[0]);
            this.f = kg5.c(R.string.obfuscated_res_0x7f0f0fec, new Object[0]);
            this.g = kg5.c(R.string.obfuscated_res_0x7f0f0494, new Object[0]);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public String c;
        public String d;
        public String e;
        public String f;
        public boolean g;
        public View.OnClickListener h;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fj.f(kg5.getContext(), R.dimen.tbds182);
            this.b = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.c = kg5.c(R.string.obfuscated_res_0x7f0f0a63, new Object[0]);
            this.d = kg5.c(R.string.obfuscated_res_0x7f0f0e05, new Object[0]);
            this.e = kg5.c(R.string.obfuscated_res_0x7f0f0a0e, new Object[0]);
            this.f = kg5.c(R.string.obfuscated_res_0x7f0f03fa, new Object[0]);
            this.g = false;
        }
    }

    /* loaded from: classes4.dex */
    public class d extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kg5.c(R.string.obfuscated_res_0x7f0f0a69, new Object[0]);
        }
    }

    /* loaded from: classes4.dex */
    public abstract class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
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
    }

    public kg5() {
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

    public static Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return TbadkCoreApplication.getInst().getApplicationContext();
        }
        return (Context) invokeV.objValue;
    }

    public static String c(int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i, objArr)) == null) {
            return getContext().getString(i, objArr);
        }
        return (String) invokeIL.objValue;
    }
}
