package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.e.a.j;
import b.a.q0.w0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class DressupItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f51474e;

    /* renamed from: f  reason: collision with root package name */
    public View f51475f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f51476g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f51477h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f51478i;
    public TextView j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DressupItemView(Context context) {
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
        this.f51474e = context;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f51474e).inflate(R.layout.index_dressup_item, this);
            this.f51475f = inflate;
            this.f51476g = (TbImageView) inflate.findViewById(R.id.bg_image);
            TbImageView tbImageView = (TbImageView) this.f51475f.findViewById(R.id.permission_icon);
            this.f51477h = tbImageView;
            tbImageView.setDefaultResource(R.drawable.transparent_bg);
            this.f51477h.setDefaultBgResource(R.drawable.transparent_bg);
            this.f51478i = (TextView) this.f51475f.findViewById(R.id.txt_type);
            this.j = (TextView) this.f51475f.findViewById(R.id.txt_name);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a.a((TbPageContext) j.a(this.f51474e), this.f51475f);
        }
    }

    public void renderView(b.a.r0.y1.c.k.j jVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jVar) == null) || jVar == null) {
            return;
        }
        this.f51476g.startLoad(jVar.b(), 10, false);
        this.f51477h.startLoad(jVar.e(), 10, false);
        this.j.setText(jVar.f());
        this.f51478i.setText(jVar.g());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DressupItemView(Context context, AttributeSet attributeSet) {
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
        this.f51474e = context;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DressupItemView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f51474e = context;
        a();
    }
}
