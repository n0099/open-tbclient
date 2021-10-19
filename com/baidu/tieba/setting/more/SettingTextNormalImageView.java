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
/* loaded from: classes7.dex */
public class SettingTextNormalImageView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f56788e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f56789f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56790g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f56791h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f56792i;

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
        this.f56788e = context;
        b();
        a(attributeSet);
        switchSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void a(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, attributeSet) == null) {
            TypedArray obtainStyledAttributes = this.f56788e.obtainStyledAttributes(attributeSet, R$styleable.TbSettingView);
            String string = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingText);
            int color = obtainStyledAttributes.getColor(R$styleable.TbSettingView_settingTextColor, -1);
            obtainStyledAttributes.recycle();
            if (string != null) {
                this.f56790g.setText(string);
            }
            if (color > -1) {
                this.f56790g.setTextColor(color);
            }
            this.f56789f.setClickable(false);
            this.f56789f.setFocusable(false);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(this.f56788e).inflate(R.layout.setting_text_normal_image_view, (ViewGroup) this, true);
            this.f56789f = (LinearLayout) findViewById(R.id.container);
            this.f56790g = (TextView) findViewById(R.id.text);
            this.f56791h = (TbImageView) findViewById(R.id.icon);
            this.f56792i = (ImageView) findViewById(R.id.arrow);
        }
    }

    public void setLocalIcon(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f56791h.clearCornerFlag();
            this.f56791h.setConrers(0);
            this.f56791h.setImageResource(i2);
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f56790g.setText(str);
        }
    }

    public void switchSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            SkinManager.setViewTextColor(this.f56790g, R.color.CAM_X0105, 1);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f56792i, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
            this.f56791h.invalidate();
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
        this.f56788e = context;
        b();
        switchSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
