package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.a.j;
import c.a.s0.x0.a;
import c.a.t0.g2.c.k.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class DailyPrivilegeItemView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f45890e;

    /* renamed from: f  reason: collision with root package name */
    public View f45891f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f45892g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f45893h;

    /* renamed from: i  reason: collision with root package name */
    public PrivilegeTextView f45894i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f45895j;

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
        this.f45890e = context;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f45890e).inflate(R.layout.index_daily_item, this);
            this.f45891f = inflate;
            this.f45892g = (TbImageView) inflate.findViewById(R.id.privilege_icon);
            TbImageView tbImageView = (TbImageView) this.f45891f.findViewById(R.id.privilege_tag_icon);
            this.f45893h = tbImageView;
            tbImageView.setDefaultResource(R.drawable.transparent_bg);
            this.f45893h.setDefaultBgResource(R.drawable.transparent_bg);
            this.f45894i = (PrivilegeTextView) this.f45891f.findViewById(R.id.privilege_title);
            this.f45895j = (TextView) this.f45891f.findViewById(R.id.privilege_desc);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a.a((TbPageContext) j.a(this.f45890e), this.f45891f);
        }
    }

    public void renderView(h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hVar) == null) || hVar == null) {
            return;
        }
        this.f45892g.setIsRound(false);
        this.f45892g.setDefaultBgResource(SkinManager.getColor(R.color.CAM_X0204));
        this.f45892g.startLoad(hVar.a(), 10, false);
        this.f45895j.setText(hVar.d());
        this.f45894i.setText(hVar.b());
        this.f45893h.startLoad(hVar.c(), 10, false);
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
        this.f45890e = context;
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
        this.f45890e = context;
        a();
    }
}
