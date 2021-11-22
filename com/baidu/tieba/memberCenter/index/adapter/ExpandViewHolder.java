package com.baidu.tieba.memberCenter.index.adapter;

import android.view.View;
import android.widget.TextView;
import b.a.q0.v0.a;
import b.a.r0.y1.c.k.f;
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
/* loaded from: classes9.dex */
public class ExpandViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f52430a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragmentActivity f52431b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f52432c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f52433d;

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
        this.f52430a = view;
        this.f52431b = baseFragmentActivity;
        this.f52432c = (TextView) view.findViewById(R.id.expand_text);
        this.f52433d = (TbImageView) this.f52430a.findViewById(R.id.expand_icon);
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a.a(this.f52431b.getPageContext(), this.f52430a);
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
            this.f52432c.setVisibility(0);
            this.f52433d.setVisibility(0);
            if (z) {
                this.f52432c.setText(R.string.unexpand_text);
                SkinManager.setImageResource(this.f52433d, R.drawable.ic_shop_up);
            } else {
                this.f52432c.setText(R.string.expand);
                SkinManager.setImageResource(this.f52433d, R.drawable.ic_shop_down);
            }
        } else {
            this.f52432c.setVisibility(8);
            this.f52433d.setVisibility(8);
        }
        onChangeSkinType();
    }
}
