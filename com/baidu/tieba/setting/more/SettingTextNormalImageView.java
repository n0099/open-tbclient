package com.baidu.tieba.setting.more;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class SettingTextNormalImageView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f20819e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f20820f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f20821g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f20822h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f20823i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingTextNormalImageView(Context context, AttributeSet attributeSet) {
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
        this.f20819e = context;
        b();
        a(attributeSet);
        c(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void a(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, attributeSet) == null) {
            TypedArray obtainStyledAttributes = this.f20819e.obtainStyledAttributes(attributeSet, R$styleable.TbSettingView);
            String string = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingText);
            int color = obtainStyledAttributes.getColor(R$styleable.TbSettingView_settingTextColor, -1);
            obtainStyledAttributes.recycle();
            if (string != null) {
                this.f20821g.setText(string);
            }
            if (color > -1) {
                this.f20821g.setTextColor(color);
            }
            this.f20820f.setClickable(false);
            this.f20820f.setFocusable(false);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(this.f20819e).inflate(R.layout.setting_text_normal_image_view, (ViewGroup) this, true);
            this.f20820f = (LinearLayout) findViewById(R.id.container);
            this.f20821g = (TextView) findViewById(R.id.text);
            this.f20822h = (TbImageView) findViewById(R.id.icon);
            this.f20823i = (ImageView) findViewById(R.id.arrow);
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            SkinManager.setViewTextColor(this.f20821g, R.color.CAM_X0105, 1);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f20823i, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
            this.f20822h.invalidate();
        }
    }

    public void setLocalIcon(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f20822h.s();
            this.f20822h.setConrers(0);
            this.f20822h.setImageResource(i2);
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f20821g.setText(str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingTextNormalImageView(Context context) {
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
        this.f20819e = context;
        b();
        c(TbadkCoreApplication.getInst().getSkinType());
    }
}
