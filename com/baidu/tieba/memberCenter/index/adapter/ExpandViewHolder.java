package com.baidu.tieba.memberCenter.index.adapter;

import android.view.View;
import android.widget.TextView;
import c.a.t0.x0.a;
import c.a.u0.h2.c.k.f;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class ExpandViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragmentActivity f46074b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f46075c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f46076d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpandViewHolder(View view, BaseFragmentActivity baseFragmentActivity) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, baseFragmentActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = view;
        this.f46074b = baseFragmentActivity;
        this.f46075c = (TextView) view.findViewById(R.id.expand_text);
        this.f46076d = (TbImageView) this.a.findViewById(R.id.expand_icon);
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a.a(this.f46074b.getPageContext(), this.a);
        }
    }

    public void renderView(Object obj) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) || obj == null) {
            return;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            z2 = fVar.f();
            z = fVar.b();
        } else {
            z = false;
            z2 = false;
        }
        if (z2) {
            this.f46075c.setVisibility(0);
            this.f46076d.setVisibility(0);
            if (z) {
                this.f46075c.setText(R.string.unexpand_text);
                SkinManager.setImageResource(this.f46076d, R.drawable.ic_shop_up);
            } else {
                this.f46075c.setText(R.string.expand);
                SkinManager.setImageResource(this.f46076d, R.drawable.ic_shop_down);
            }
        } else {
            this.f46075c.setVisibility(8);
            this.f46076d.setVisibility(8);
        }
        onChangeSkinType();
    }
}
