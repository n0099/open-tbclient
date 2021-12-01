package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.a.j;
import c.a.q0.w0.a;
import c.a.r0.e2.c.k.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class DailyPrivilegeItemView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f46914e;

    /* renamed from: f  reason: collision with root package name */
    public View f46915f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f46916g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f46917h;

    /* renamed from: i  reason: collision with root package name */
    public PrivilegeTextView f46918i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f46919j;

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
        this.f46914e = context;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f46914e).inflate(R.layout.index_daily_item, this);
            this.f46915f = inflate;
            this.f46916g = (TbImageView) inflate.findViewById(R.id.privilege_icon);
            TbImageView tbImageView = (TbImageView) this.f46915f.findViewById(R.id.privilege_tag_icon);
            this.f46917h = tbImageView;
            tbImageView.setDefaultResource(R.drawable.transparent_bg);
            this.f46917h.setDefaultBgResource(R.drawable.transparent_bg);
            this.f46918i = (PrivilegeTextView) this.f46915f.findViewById(R.id.privilege_title);
            this.f46919j = (TextView) this.f46915f.findViewById(R.id.privilege_desc);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a.a((TbPageContext) j.a(this.f46914e), this.f46915f);
        }
    }

    public void renderView(h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hVar) == null) || hVar == null) {
            return;
        }
        this.f46916g.setIsRound(false);
        this.f46916g.setDefaultBgResource(SkinManager.getColor(R.color.CAM_X0204));
        this.f46916g.startLoad(hVar.a(), 10, false);
        this.f46919j.setText(hVar.d());
        this.f46918i.setText(hVar.b());
        this.f46917h.startLoad(hVar.c(), 10, false);
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
        this.f46914e = context;
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
        this.f46914e = context;
        a();
    }
}
