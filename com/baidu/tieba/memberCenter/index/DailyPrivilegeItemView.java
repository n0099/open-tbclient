package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.a.j;
import c.a.q0.w0.a;
import c.a.r0.h2.c.k.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class DailyPrivilegeItemView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f44440e;

    /* renamed from: f  reason: collision with root package name */
    public View f44441f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f44442g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f44443h;

    /* renamed from: i  reason: collision with root package name */
    public PrivilegeTextView f44444i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f44445j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailyPrivilegeItemView(Context context) {
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
        this.f44440e = context;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f44440e).inflate(R.layout.index_daily_item, this);
            this.f44441f = inflate;
            this.f44442g = (TbImageView) inflate.findViewById(R.id.privilege_icon);
            TbImageView tbImageView = (TbImageView) this.f44441f.findViewById(R.id.privilege_tag_icon);
            this.f44443h = tbImageView;
            tbImageView.setDefaultResource(R.drawable.transparent_bg);
            this.f44443h.setDefaultBgResource(R.drawable.transparent_bg);
            this.f44444i = (PrivilegeTextView) this.f44441f.findViewById(R.id.privilege_title);
            this.f44445j = (TextView) this.f44441f.findViewById(R.id.privilege_desc);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a.a((TbPageContext) j.a(this.f44440e), this.f44441f);
        }
    }

    public void renderView(h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hVar) == null) || hVar == null) {
            return;
        }
        this.f44442g.setIsRound(false);
        this.f44442g.setDefaultBgResource(SkinManager.getColor(R.color.CAM_X0204));
        this.f44442g.startLoad(hVar.a(), 10, false);
        this.f44445j.setText(hVar.d());
        this.f44444i.setText(hVar.b());
        this.f44443h.startLoad(hVar.c(), 10, false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailyPrivilegeItemView(Context context, AttributeSet attributeSet) {
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
        this.f44440e = context;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailyPrivilegeItemView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f44440e = context;
        a();
    }
}
