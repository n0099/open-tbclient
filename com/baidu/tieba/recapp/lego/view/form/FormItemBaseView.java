package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
/* loaded from: classes7.dex */
public abstract class FormItemBaseView extends RelativeLayout implements FormCardView.d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String defaultContent = "NEGLIGIBLE";
    public transient /* synthetic */ FieldHolder $fh;
    public Activity mActivity;
    public int mButtonBgColor;
    public int mButtonFontColor;
    public int mButtonGreyBgColor;
    public Context mContext;
    public Drawable mErrorFrameDrawale;
    public int mFontColor;
    public float mFontSize;
    public float mFontSize26;
    public float mFontSize36;
    public int mFrameColor;
    public Drawable mFrameDrawale;
    public View mFrameView;
    public int mHintFontColor;
    public Resources mResources;
    public float mScaleRatio;
    public int mSize20;
    public int mSize240;
    public int mSize40;
    public int mSize50;
    public int mSize80;
    public int mSize90;
    public String mTag;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f56493a;
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
            f56493a = iArr;
            try {
                iArr[DrawableType.ERROR_FRAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f56493a[DrawableType.ORDINARY_FRAME.ordinal()] = 2;
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
        this.mContext = null;
        this.mResources = null;
        this.mFrameDrawale = null;
        this.mErrorFrameDrawale = null;
        this.mSize20 = 0;
        this.mSize40 = 0;
        this.mSize50 = 0;
        this.mSize80 = 0;
        this.mSize90 = 0;
        this.mSize240 = 0;
        this.mFontColor = 0;
        this.mHintFontColor = 0;
        this.mFontSize = 0.0f;
        this.mFontSize26 = 0.0f;
        this.mFontSize36 = 0.0f;
        this.mButtonFontColor = 0;
        this.mButtonBgColor = 0;
        this.mButtonGreyBgColor = 0;
        this.mFrameColor = 0;
        this.mFrameView = null;
        this.mTag = "";
        this.mActivity = null;
        this.mScaleRatio = 1.0f;
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.mContext = context;
            this.mActivity = (Activity) context;
            Resources resources = context.getApplicationContext().getResources();
            this.mResources = resources;
            this.mHintFontColor = resources.getColor(R.color.form_font_color);
            this.mButtonFontColor = this.mResources.getColor(R.color.form_button_font_color);
            this.mButtonGreyBgColor = this.mResources.getColor(R.color.form_button_grey_bg_color);
            this.mButtonBgColor = -1;
            this.mFrameColor = -1;
            this.mFontColor = -1;
            this.mFrameDrawale = this.mResources.getDrawable(R.drawable.form_frame_white);
            this.mErrorFrameDrawale = this.mResources.getDrawable(R.drawable.form_frame_red);
        }
    }

    public int compoundHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return -2;
        }
        return invokeV.intValue;
    }

    public void drawBackgroundFrame(View view, DrawableType drawableType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, drawableType) == null) {
            this.mFrameView = view;
            int i2 = a.f56493a[drawableType.ordinal()];
            if (i2 == 1) {
                this.mFrameView.setBackgroundResource(R.drawable.form_frame_red);
            } else if (i2 != 2) {
                this.mFrameView.setBackgroundDrawable(null);
            } else {
                this.mFrameView.setBackgroundResource(R.drawable.form_frame_white);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.d
    public FormItemBaseView getFormView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (FormItemBaseView) invokeV.objValue;
    }

    public View getFrameView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mFrameView : (View) invokeV.objValue;
    }

    public abstract /* synthetic */ String getResult();

    public abstract /* synthetic */ boolean isPrepareToCommit();

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public void scaleMargin(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f2) == null) {
            this.mScaleRatio = f2;
            float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
            float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
            float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
            float f3 = this.mScaleRatio;
            this.mSize20 = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * f3);
            this.mSize40 = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * f3);
            this.mSize50 = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * f3);
            this.mSize80 = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * f3);
            this.mSize90 = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * f3);
            this.mSize240 = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * f3);
            this.mFontSize = (int) (dimension * f3);
            this.mFontSize26 = (int) (dimension2 * f3);
            this.mFontSize36 = (int) (dimension3 * f3);
        }
    }

    public boolean updateView(FormCard.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bVar)) == null) {
            if (bVar != null && bVar.f56384a != -1 && !TextUtils.isEmpty(bVar.f56385b)) {
                setVisibility(0);
                reset();
                this.mTag = bVar.f56386c;
                return true;
            }
            setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mTag : (String) invokeV.objValue;
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
        this.mContext = null;
        this.mResources = null;
        this.mFrameDrawale = null;
        this.mErrorFrameDrawale = null;
        this.mSize20 = 0;
        this.mSize40 = 0;
        this.mSize50 = 0;
        this.mSize80 = 0;
        this.mSize90 = 0;
        this.mSize240 = 0;
        this.mFontColor = 0;
        this.mHintFontColor = 0;
        this.mFontSize = 0.0f;
        this.mFontSize26 = 0.0f;
        this.mFontSize36 = 0.0f;
        this.mButtonFontColor = 0;
        this.mButtonBgColor = 0;
        this.mButtonGreyBgColor = 0;
        this.mFrameColor = 0;
        this.mFrameView = null;
        this.mTag = "";
        this.mActivity = null;
        this.mScaleRatio = 1.0f;
        a(context);
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
        this.mContext = null;
        this.mResources = null;
        this.mFrameDrawale = null;
        this.mErrorFrameDrawale = null;
        this.mSize20 = 0;
        this.mSize40 = 0;
        this.mSize50 = 0;
        this.mSize80 = 0;
        this.mSize90 = 0;
        this.mSize240 = 0;
        this.mFontColor = 0;
        this.mHintFontColor = 0;
        this.mFontSize = 0.0f;
        this.mFontSize26 = 0.0f;
        this.mFontSize36 = 0.0f;
        this.mButtonFontColor = 0;
        this.mButtonBgColor = 0;
        this.mButtonGreyBgColor = 0;
        this.mFrameColor = 0;
        this.mFrameView = null;
        this.mTag = "";
        this.mActivity = null;
        this.mScaleRatio = 1.0f;
        a(context);
    }
}
