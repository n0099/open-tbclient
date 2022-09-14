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
/* loaded from: classes5.dex */
public class rf5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;
    public a b;
    public b c;

    /* loaded from: classes5.dex */
    public static class a extends e {
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
            this.d = rf5.c(R.string.obfuscated_res_0x7f0f0c72, new Object[0]);
            this.e = rf5.c(R.string.obfuscated_res_0x7f0f0fd8, new Object[0]);
            this.f = false;
            this.g = ej.f(rf5.getContext(), R.dimen.obfuscated_res_0x7f0702bf);
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends e {
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
            this.d = ej.f(rf5.getContext(), R.dimen.obfuscated_res_0x7f070292);
            this.e = rf5.c(R.string.obfuscated_res_0x7f0f0fd8, new Object[0]);
            this.f = rf5.c(R.string.obfuscated_res_0x7f0f0fd9, new Object[0]);
            this.g = rf5.c(R.string.obfuscated_res_0x7f0f048c, new Object[0]);
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends e {
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
            this.a = ej.f(rf5.getContext(), R.dimen.tbds182);
            this.b = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.c = rf5.c(R.string.obfuscated_res_0x7f0f0a56, new Object[0]);
            this.d = rf5.c(R.string.obfuscated_res_0x7f0f0df4, new Object[0]);
            this.e = rf5.c(R.string.obfuscated_res_0x7f0f0a01, new Object[0]);
            this.f = rf5.c(R.string.obfuscated_res_0x7f0f03f3, new Object[0]);
            this.g = false;
        }
    }

    /* loaded from: classes5.dex */
    public static class d extends e {
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
            this.a = rf5.c(R.string.obfuscated_res_0x7f0f0a5c, new Object[0]);
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class e {
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

    public rf5() {
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

    public static String c(int i, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i, objArr)) == null) ? getContext().getString(i, objArr) : (String) invokeIL.objValue;
    }

    public static Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? TbadkCoreApplication.getInst().getApplicationContext() : (Context) invokeV.objValue;
    }
}
