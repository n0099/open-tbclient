package com.baidu.tieba.tbean.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class UserDefineConfirmBottomView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f49411e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f49412f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f49413g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f49414h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f49415i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f49416j;

    /* renamed from: k  reason: collision with root package name */
    public View.OnClickListener f49417k;
    public String l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserDefineConfirmBottomView(Context context) {
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
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.f49411e = context;
            LayoutInflater.from(context).inflate(R.layout.user_define_confirm_bottom_view, (ViewGroup) this, true);
            setOrientation(1);
            this.f49412f = (RelativeLayout) findViewById(R.id.confirm_btn_root);
            this.f49413g = (LinearLayout) findViewById(R.id.big_tbean_root);
            this.f49414h = (TextView) findViewById(R.id.big_tbean_toast_tv);
            this.f49415i = (TextView) findViewById(R.id.big_tbean_jump_tv);
            this.f49416j = (TextView) findViewById(R.id.user_define_confirm_tv);
            this.f49412f.setOnClickListener(null);
        }
    }

    public void onChangeSKinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                SkinManager.setBackgroundColor(this.f49413g, R.color.CAM_X0110);
            } else {
                SkinManager.setBackgroundColor(this.f49413g, R.color.common_color_10333);
            }
            SkinManager.setViewTextColor(this.f49414h, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.f49415i, R.color.CAM_X0106);
            SkinManager.setBackgroundColor(this.f49412f, R.color.CAM_X0201);
        }
    }

    public void setBigTbeanToastText(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            String format = String.format(this.f49411e.getString(R.string.big_tbean_toast), StringHelper.numberUniform(i2));
            this.l = format;
            this.f49414h.setText(format);
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f49417k = onClickListener;
            this.f49415i.setOnClickListener(onClickListener);
            this.f49416j.setOnClickListener(this.f49417k);
        }
    }

    public void setPayEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                this.f49414h.setText(this.l);
                this.f49414h.setGravity(3);
                showBitTBeanToastView(true);
                this.f49416j.setEnabled(true);
                this.f49413g.setVisibility(0);
                this.f49415i.setVisibility(0);
                return;
            }
            this.f49414h.setText(R.string.user_define_max_money);
            this.f49414h.setGravity(17);
            this.f49416j.setEnabled(false);
            showBitTBeanToastView(false);
            this.f49413g.setVisibility(0);
            this.f49415i.setVisibility(8);
        }
    }

    public void showBitTBeanToastView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                this.f49413g.setVisibility(0);
            } else {
                this.f49413g.setVisibility(4);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserDefineConfirmBottomView(Context context, @Nullable AttributeSet attributeSet) {
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
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserDefineConfirmBottomView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserDefineConfirmBottomView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        a(context);
    }
}
