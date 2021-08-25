package com.baidu.tieba.write;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.p0.s.u.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class WritePrefixItemLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f58526e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f58527f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58528g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f58529h;

    /* renamed from: i  reason: collision with root package name */
    public View f58530i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WritePrefixItemLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(this.f58526e).inflate(R.layout.prefix_item, this);
            setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            setOrientation(1);
            this.f58527f = (TextView) findViewById(R.id.prefix_text);
            this.f58528g = (TextView) findViewById(R.id.prefix_no_tip);
            this.f58529h = (ImageView) findViewById(R.id.prefix_checked);
            this.f58530i = findViewById(R.id.prefix_item_divider);
            this.f58527f.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            c.d(this.f58528g).u(R.color.CAM_X0109);
            this.f58529h.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_set_list_ok16, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            SkinManager.setBackgroundColor(this.f58530i, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this, R.drawable.addresslist_item_bg);
        }
    }

    public void setDividerStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || z) {
            return;
        }
        ((LinearLayout.LayoutParams) this.f58530i.getLayoutParams()).setMargins(l.g(this.f58526e, R.dimen.ds30), 0, l.g(this.f58526e, R.dimen.ds30), 0);
    }

    public void setPrefixText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f58527f.setText(str);
        }
    }

    public void setPrefixTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f58527f.setTextColor(i2);
        }
    }

    public void showCheckImg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (z) {
                this.f58529h.setVisibility(0);
            } else {
                this.f58529h.setVisibility(8);
            }
        }
    }

    public void showPrefixTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f58528g.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WritePrefixItemLayout(Context context, AttributeSet attributeSet) {
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
        this.f58526e = context;
        a();
    }
}
