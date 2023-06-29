package com.baidu.tieba;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class td0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public Window c;
    public View d;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public a(td0 td0Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {td0Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                View view2 = this.a;
                view2.setPadding(view2.getPaddingLeft(), this.a.getPaddingTop() + td0.b(this.a.getContext()), this.a.getPaddingRight(), this.a.getPaddingBottom());
                this.a.getLayoutParams().height += td0.b(this.a.getContext());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Window a;
        public boolean b;
        public View c;

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
            this.b = false;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new td0(this.a, this.b, true, this.c).d();
            }
            return invokeV.booleanValue;
        }

        /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
            	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
            	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
            */
        public static /* synthetic */ com.baidu.tieba.td0.b a(com.baidu.tieba.td0.b r0, android.app.Activity r1) {
            /*
                r0.d(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.td0.b.a(com.baidu.tieba.td0$b, android.app.Activity):com.baidu.tieba.td0$b");
        }

        public b c(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.b = z;
                return this;
            }
            return (b) invokeZ.objValue;
        }

        public final b d(Activity activity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
                this.a = activity.getWindow();
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    public td0(Window window, boolean z, boolean z2, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {window, Boolean.valueOf(z), Boolean.valueOf(z2), view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = z;
        this.b = z2;
        this.c = window;
        this.d = view2;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.tieba.td0.b.a(com.baidu.tieba.td0$b, android.app.Activity):com.baidu.tieba.td0$b
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
        	... 1 more
        */
    public static com.baidu.tieba.td0.b a(android.app.Activity r4) {
        /*
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.td0.$ic
            if (r0 != 0) goto Ld
        L4:
            com.baidu.tieba.td0$b r0 = new com.baidu.tieba.td0$b
            r0.<init>()
            com.baidu.tieba.td0.b.a(r0, r4)
            return r0
        Ld:
            r1 = r0
            r2 = 65537(0x10001, float:9.1837E-41)
            r3 = 0
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r1.invokeL(r2, r3, r4)
            if (r0 == 0) goto L4
            java.lang.Object r1 = r0.objValue
            com.baidu.tieba.td0$b r1 = (com.baidu.tieba.td0.b) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.td0.a(android.app.Activity):com.baidu.tieba.td0$b");
    }

    public void e(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && view2 != null && this.b && !c()) {
            view2.post(new a(this, view2));
        }
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        int identifier;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (c() || (identifier = context.getResources().getIdentifier("status_bar_height", EMABTest.TYPE_DIMEN, "android")) <= 0) {
                return 0;
            }
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return invokeL.intValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (Build.VERSION.SDK_INT < 19) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (!j() && !h()) {
                return false;
            }
            if (i == 19) {
                g();
            }
            e(this.d);
            return true;
        }
        return invokeV.booleanValue;
    }

    @TargetApi(19)
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            WindowManager.LayoutParams attributes = this.c.getAttributes();
            if (this.b) {
                attributes.flags |= 67108864;
            } else {
                attributes.flags &= -67108865;
            }
            this.c.setAttributes(attributes);
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!f(this.a) && !i(this.a)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            WindowManager.LayoutParams attributes = this.c.getAttributes();
            try {
                Class<?> cls = Class.forName("android.view.WindowManager$LayoutParams");
                int i = cls.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON").getInt(attributes);
                Field declaredField = cls.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                int i2 = declaredField.getInt(attributes);
                if (z) {
                    declaredField.set(attributes, Integer.valueOf(i2 | i));
                } else {
                    declaredField.set(attributes, Integer.valueOf((~i) & i2));
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeZ.booleanValue;
    }

    public final boolean i(boolean z) {
        InterceptResult invokeZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            Class<?> cls = this.c.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                Window window = this.c;
                Object[] objArr = new Object[2];
                if (z) {
                    i = i2;
                } else {
                    i = 0;
                }
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Integer.valueOf(i2);
                method.invoke(window, objArr);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeZ.booleanValue;
    }

    @TargetApi(21)
    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (Build.VERSION.SDK_INT < 23) {
                return false;
            }
            int systemUiVisibility = this.c.getDecorView().getSystemUiVisibility();
            if (this.a) {
                systemUiVisibility |= -2147475456;
            }
            if (this.b) {
                systemUiVisibility |= 1280;
            }
            this.c.getDecorView().setSystemUiVisibility(systemUiVisibility);
            this.c.setStatusBarColor(0);
            return true;
        }
        return invokeV.booleanValue;
    }
}
