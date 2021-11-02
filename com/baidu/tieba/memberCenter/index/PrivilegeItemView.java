package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.a.j;
import b.a.e.e.m.b;
import b.a.q0.w0.a;
import b.a.r0.y1.c.k.o;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class PrivilegeItemView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f51493e;

    /* renamed from: f  reason: collision with root package name */
    public View f51494f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f51495g;

    /* renamed from: h  reason: collision with root package name */
    public PrivilegeTextView f51496h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f51497i;
    public o j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivilegeItemView(Context context) {
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
        this.f51493e = context;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f51493e).inflate(R.layout.index_privilege_item, this);
            this.f51494f = inflate;
            this.f51495g = (TbImageView) inflate.findViewById(R.id.privilege_icon);
            this.f51496h = (PrivilegeTextView) this.f51494f.findViewById(R.id.privilege_name);
            this.f51497i = (TextView) this.f51494f.findViewById(R.id.privilege_desc);
        }
    }

    public PrivilegeTextView getPrivilegeName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f51496h : (PrivilegeTextView) invokeV.objValue;
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a.a((TbPageContext) j.a(this.f51493e), this.f51494f);
        }
    }

    public void renderView(o oVar) {
        BitmapDrawable bitmapDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, oVar) == null) || oVar == null) {
            return;
        }
        this.j = oVar;
        this.f51495g.setIsRound(false);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.f51495g.setDefaultBgResource(R.color.img_bg_color);
        } else {
            this.f51495g.setDefaultBgResource(SkinManager.getColor(R.color.CAM_X0204));
        }
        this.f51495g.startLoad(oVar.b(), 10, false);
        this.f51497i.setText(oVar.a());
        this.f51496h.setText(oVar.f());
        if (TbadkCoreApplication.isLogin() && this.j.d() > 0) {
            if (b.g(oVar.g(), 0L) > b.g(b.a.q0.s.e0.b.j().p("member_center_item_red_tip_" + this.j.d() + TbadkCoreApplication.getCurrentAccount(), "0"), 0L)) {
                if (this.j.h() == 1) {
                    bitmapDrawable = (BitmapDrawable) SkinManager.getDrawable(R.drawable.icon_news_down_bar_one);
                    if (bitmapDrawable != null) {
                        bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                    }
                } else if (this.j.h() == 2) {
                    bitmapDrawable = (BitmapDrawable) SkinManager.getDrawable(R.drawable.icon_new_privilege);
                    if (bitmapDrawable != null) {
                        bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                    }
                } else {
                    bitmapDrawable = null;
                }
                if (bitmapDrawable != null) {
                    this.f51496h.setCompoundDrawables(null, null, bitmapDrawable, null);
                    this.f51496h.setCompoundDrawablePadding(10);
                    return;
                }
                return;
            }
            this.f51496h.setCompoundDrawables(null, null, null, null);
            return;
        }
        this.f51496h.setCompoundDrawables(null, null, null, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivilegeItemView(Context context, AttributeSet attributeSet) {
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
        this.f51493e = context;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivilegeItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f51493e = context;
        a();
    }
}
