package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormCardView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class FormItemBaseView extends RelativeLayout implements FormCardView.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public Resources b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public float j;
    public float k;
    public float l;
    public int m;
    public int n;
    public int o;
    public View p;
    public String q;
    public Activity r;
    public float s;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class DrawableType {
        public static final /* synthetic */ DrawableType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DrawableType ERROR_FRAME;
        public static final DrawableType ORDINARY_FRAME;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-436599477, "Lcom/baidu/tieba/recapp/lego/view/form/FormItemBaseView$DrawableType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-436599477, "Lcom/baidu/tieba/recapp/lego/view/form/FormItemBaseView$DrawableType;");
                    return;
                }
            }
            ERROR_FRAME = new DrawableType("ERROR_FRAME", 0);
            DrawableType drawableType = new DrawableType("ORDINARY_FRAME", 1);
            ORDINARY_FRAME = drawableType;
            $VALUES = new DrawableType[]{ERROR_FRAME, drawableType};
        }

        public DrawableType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static DrawableType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DrawableType) Enum.valueOf(DrawableType.class, str) : (DrawableType) invokeL.objValue;
        }

        public static DrawableType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DrawableType[]) $VALUES.clone() : (DrawableType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2024028626, "Lcom/baidu/tieba/recapp/lego/view/form/FormItemBaseView$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2024028626, "Lcom/baidu/tieba/recapp/lego/view/form/FormItemBaseView$a;");
                    return;
                }
            }
            int[] iArr = new int[DrawableType.values().length];
            a = iArr;
            try {
                iArr[DrawableType.ERROR_FRAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[DrawableType.ORDINARY_FRAME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FormItemBaseView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = null;
        this.q = "";
        this.s = 1.0f;
        d(context);
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return -2;
        }
        return invokeV.intValue;
    }

    public void c(View view2, DrawableType drawableType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, drawableType) == null) {
            this.p = view2;
            int i = a.a[drawableType.ordinal()];
            if (i == 1) {
                this.p.setBackgroundResource(R.drawable.obfuscated_res_0x7f08057d);
            } else if (i != 2) {
                this.p.setBackgroundDrawable(null);
            } else {
                this.p.setBackgroundResource(R.drawable.obfuscated_res_0x7f08057e);
            }
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.a = context;
            this.r = (Activity) context;
            Resources resources = context.getApplicationContext().getResources();
            this.b = resources;
            this.i = resources.getColor(R.color.obfuscated_res_0x7f06071e);
            this.m = this.b.getColor(R.color.obfuscated_res_0x7f06071b);
            this.n = this.b.getColor(R.color.obfuscated_res_0x7f06071c);
            this.o = -1;
            this.h = -1;
            this.b.getDrawable(R.drawable.obfuscated_res_0x7f08057e);
            this.b.getDrawable(R.drawable.obfuscated_res_0x7f08057d);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void f(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f) == null) {
            this.s = f;
            this.b.getDimension(R.dimen.obfuscated_res_0x7f070340);
            float dimension = this.b.getDimension(R.dimen.obfuscated_res_0x7f070339);
            float dimension2 = this.b.getDimension(R.dimen.obfuscated_res_0x7f070338);
            float dimension3 = this.b.getDimension(R.dimen.obfuscated_res_0x7f07033a);
            float f2 = this.s;
            this.c = (int) (((int) this.b.getDimension(R.dimen.obfuscated_res_0x7f07033b)) * f2);
            this.d = (int) (((int) this.b.getDimension(R.dimen.obfuscated_res_0x7f07033d)) * f2);
            this.e = (int) (((int) this.b.getDimension(R.dimen.obfuscated_res_0x7f07033e)) * f2);
            this.f = (int) (((int) this.b.getDimension(R.dimen.obfuscated_res_0x7f07033f)) * f2);
            this.g = (int) (((int) this.b.getDimension(R.dimen.obfuscated_res_0x7f07033c)) * f2);
            this.j = (int) (dimension * f2);
            this.k = (int) (dimension2 * f2);
            this.l = (int) (dimension3 * f2);
        }
    }

    public boolean g(FormCard.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) {
            if (bVar != null && bVar.a != -1 && !TextUtils.isEmpty(bVar.b)) {
                setVisibility(0);
                e();
                this.q = bVar.c;
                return true;
            }
            setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.d
    public FormItemBaseView getFormView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (FormItemBaseView) invokeV.objValue;
    }

    public View getFrameView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.p : (View) invokeV.objValue;
    }

    public abstract /* synthetic */ String getResult();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.q : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = null;
        this.q = "";
        this.s = 1.0f;
        d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = null;
        this.q = "";
        this.s = 1.0f;
        d(context);
    }
}
