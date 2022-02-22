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
import c.a.u0.o3.b;
import c.a.u0.o3.d;
import c.a.u0.o3.e;
import c.a.u0.o3.f;
import c.a.u0.o3.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class SettingTextImageView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f48007e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f48008f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f48009g;

    /* renamed from: h  reason: collision with root package name */
    public HeadImageView f48010h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f48011i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingTextImageView(Context context, AttributeSet attributeSet) {
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
        this.f48007e = context;
        b();
        a(attributeSet);
        switchSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void a(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, attributeSet) == null) {
            TypedArray obtainStyledAttributes = this.f48007e.obtainStyledAttributes(attributeSet, i.TbSettingView);
            String string = obtainStyledAttributes.getString(i.TbSettingView_settingText);
            int color = obtainStyledAttributes.getColor(i.TbSettingView_settingTextColor, -1);
            obtainStyledAttributes.recycle();
            if (string != null) {
                this.f48009g.setText(string);
            }
            if (color > -1) {
                this.f48009g.setTextColor(color);
            }
            this.f48008f.setClickable(false);
            this.f48008f.setFocusable(false);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(this.f48007e).inflate(f.setting_text_image_view, (ViewGroup) this, true);
            this.f48008f = (LinearLayout) findViewById(e.container);
            this.f48009g = (TextView) findViewById(e.text);
            this.f48010h = (HeadImageView) findViewById(e.icon);
            this.f48011i = (ImageView) findViewById(e.arrow);
        }
    }

    public void displayImage() {
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (headImageView = this.f48010h) == null) {
            return;
        }
        headImageView.setVisibility(0);
    }

    public void hideImage() {
        HeadImageView headImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (headImageView = this.f48010h) == null) {
            return;
        }
        headImageView.setVisibility(8);
    }

    public void recycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void setIcon(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, str, z) == null) {
            if (z) {
                this.f48010h.startLoad(str, 26, false);
            } else {
                this.f48010h.startLoad(str, 12, false);
            }
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f48009g.setText(str);
        }
    }

    public void switchSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(b.CAM_X0205));
            SkinManager.setViewTextColor(this.f48009g, b.CAM_X0105, 1);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f48011i, d.icon_pure_list_arrow16_right_svg, b.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            this.f48010h.invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingTextImageView(Context context) {
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
        this.f48007e = context;
        b();
        switchSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
