package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.a.j;
import c.a.e.e.m.b;
import c.a.o0.u0.a;
import c.a.p0.w1.c.k.o;
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
/* loaded from: classes7.dex */
public class PrivilegeItemView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f53964e;

    /* renamed from: f  reason: collision with root package name */
    public View f53965f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f53966g;

    /* renamed from: h  reason: collision with root package name */
    public PrivilegeTextView f53967h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f53968i;

    /* renamed from: j  reason: collision with root package name */
    public o f53969j;

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
        this.f53964e = context;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f53964e).inflate(R.layout.index_privilege_item, this);
            this.f53965f = inflate;
            this.f53966g = (TbImageView) inflate.findViewById(R.id.privilege_icon);
            this.f53967h = (PrivilegeTextView) this.f53965f.findViewById(R.id.privilege_name);
            this.f53968i = (TextView) this.f53965f.findViewById(R.id.privilege_desc);
        }
    }

    public PrivilegeTextView getPrivilegeName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f53967h : (PrivilegeTextView) invokeV.objValue;
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a.a((TbPageContext) j.a(this.f53964e), this.f53965f);
        }
    }

    public void renderView(o oVar) {
        BitmapDrawable bitmapDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, oVar) == null) || oVar == null) {
            return;
        }
        this.f53969j = oVar;
        this.f53966g.setIsRound(false);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            this.f53966g.setDefaultBgResource(R.color.img_bg_color);
        } else {
            this.f53966g.setDefaultBgResource(SkinManager.getColor(R.color.CAM_X0204));
        }
        this.f53966g.startLoad(oVar.b(), 10, false);
        this.f53968i.setText(oVar.a());
        this.f53967h.setText(oVar.f());
        if (TbadkCoreApplication.isLogin() && this.f53969j.d() > 0) {
            if (b.f(oVar.g(), 0L) > b.f(c.a.o0.s.d0.b.j().p("member_center_item_red_tip_" + this.f53969j.d() + TbadkCoreApplication.getCurrentAccount(), "0"), 0L)) {
                if (this.f53969j.h() == 1) {
                    bitmapDrawable = (BitmapDrawable) SkinManager.getDrawable(R.drawable.icon_news_down_bar_one);
                    if (bitmapDrawable != null) {
                        bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                    }
                } else if (this.f53969j.h() == 2) {
                    bitmapDrawable = (BitmapDrawable) SkinManager.getDrawable(R.drawable.icon_new_privilege);
                    if (bitmapDrawable != null) {
                        bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                    }
                } else {
                    bitmapDrawable = null;
                }
                if (bitmapDrawable != null) {
                    this.f53967h.setCompoundDrawables(null, null, bitmapDrawable, null);
                    this.f53967h.setCompoundDrawablePadding(10);
                    return;
                }
                return;
            }
            this.f53967h.setCompoundDrawables(null, null, null, null);
            return;
        }
        this.f53967h.setCompoundDrawables(null, null, null, null);
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
        this.f53964e = context;
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
        this.f53964e = context;
        a();
    }
}
