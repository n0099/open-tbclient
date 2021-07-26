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
/* loaded from: classes4.dex */
public abstract class FormItemBaseView extends RelativeLayout implements FormCardView.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f20698e;

    /* renamed from: f  reason: collision with root package name */
    public Resources f20699f;

    /* renamed from: g  reason: collision with root package name */
    public int f20700g;

    /* renamed from: h  reason: collision with root package name */
    public int f20701h;

    /* renamed from: i  reason: collision with root package name */
    public int f20702i;
    public int j;
    public int k;
    public int l;
    public int m;
    public float n;
    public float o;
    public float p;
    public int q;
    public int r;
    public int s;
    public View t;
    public String u;
    public Activity v;
    public float w;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
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

        public DrawableType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f20703a;
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
            f20703a = iArr;
            try {
                iArr[DrawableType.ERROR_FRAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20703a[DrawableType.ORDINARY_FRAME.ordinal()] = 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20698e = null;
        this.f20699f = null;
        this.f20700g = 0;
        this.f20701h = 0;
        this.f20702i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0.0f;
        this.o = 0.0f;
        this.p = 0.0f;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = null;
        this.u = "";
        this.w = 1.0f;
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

    public void c(View view, DrawableType drawableType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, drawableType) == null) {
            this.t = view;
            int i2 = a.f20703a[drawableType.ordinal()];
            if (i2 == 1) {
                this.t.setBackgroundResource(R.drawable.form_frame_red);
            } else if (i2 != 2) {
                this.t.setBackgroundDrawable(null);
            } else {
                this.t.setBackgroundResource(R.drawable.form_frame_white);
            }
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.f20698e = context;
            this.v = (Activity) context;
            Resources resources = context.getApplicationContext().getResources();
            this.f20699f = resources;
            this.m = resources.getColor(R.color.form_font_color);
            this.q = this.f20699f.getColor(R.color.form_button_font_color);
            this.r = this.f20699f.getColor(R.color.form_button_grey_bg_color);
            this.s = -1;
            this.l = -1;
            this.f20699f.getDrawable(R.drawable.form_frame_white);
            this.f20699f.getDrawable(R.drawable.form_frame_red);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void f(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f2) == null) {
            this.w = f2;
            this.f20699f.getDimension(R.dimen.form_size90);
            float dimension = this.f20699f.getDimension(R.dimen.form_font_size28);
            float dimension2 = this.f20699f.getDimension(R.dimen.form_font_size20);
            float dimension3 = this.f20699f.getDimension(R.dimen.form_font_size36);
            float f3 = this.w;
            this.f20700g = (int) (((int) this.f20699f.getDimension(R.dimen.form_size20)) * f3);
            this.f20701h = (int) (((int) this.f20699f.getDimension(R.dimen.form_size40)) * f3);
            this.f20702i = (int) (((int) this.f20699f.getDimension(R.dimen.form_size50)) * f3);
            this.j = (int) (((int) this.f20699f.getDimension(R.dimen.form_size80)) * f3);
            this.k = (int) (((int) this.f20699f.getDimension(R.dimen.form_size240)) * f3);
            this.n = (int) (dimension * f3);
            this.o = (int) (dimension2 * f3);
            this.p = (int) (dimension3 * f3);
        }
    }

    public boolean g(FormCard.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) {
            if (bVar != null && bVar.f20619a != -1 && !TextUtils.isEmpty(bVar.f20620b)) {
                setVisibility(0);
                e();
                this.u = bVar.f20621c;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.t : (View) invokeV.objValue;
    }

    public abstract /* synthetic */ String getResult();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.u : (String) invokeV.objValue;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f20698e = null;
        this.f20699f = null;
        this.f20700g = 0;
        this.f20701h = 0;
        this.f20702i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0.0f;
        this.o = 0.0f;
        this.p = 0.0f;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = null;
        this.u = "";
        this.w = 1.0f;
        d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FormItemBaseView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f20698e = null;
        this.f20699f = null;
        this.f20700g = 0;
        this.f20701h = 0;
        this.f20702i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0.0f;
        this.o = 0.0f;
        this.p = 0.0f;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = null;
        this.u = "";
        this.w = 1.0f;
        d(context);
    }
}
