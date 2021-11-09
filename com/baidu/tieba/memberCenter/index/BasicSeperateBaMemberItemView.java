package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.r0.y1.c.k.o;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class BasicSeperateBaMemberItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f51446e;

    /* renamed from: f  reason: collision with root package name */
    public View f51447f;

    /* renamed from: g  reason: collision with root package name */
    public View f51448g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f51449h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f51450i;
    public TextView j;
    public TbImageView k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasicSeperateBaMemberItemView(Context context) {
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
        this.f51446e = context;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f51446e).inflate(R.layout.index_seperate_ba_item, this);
            this.f51447f = inflate;
            this.f51448g = inflate.findViewById(R.id.ly_desc);
            this.f51449h = (TbImageView) this.f51447f.findViewById(R.id.task_icon);
            this.f51450i = (TextView) this.f51447f.findViewById(R.id.txt_title);
            this.j = (TextView) this.f51447f.findViewById(R.id.txt_desc);
            this.k = (TbImageView) this.f51447f.findViewById(R.id.privilege_spread_icon);
        }
    }

    public void renderView(o oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oVar) == null) || oVar == null) {
            return;
        }
        this.f51448g.setTag(oVar);
        this.f51449h.startLoad(oVar.b(), 10, false);
        this.f51450i.setText(oVar.f());
        if (StringUtils.isNull(oVar.e())) {
            this.k.setVisibility(4);
        } else {
            this.k.setVisibility(0);
        }
        this.j.setText(oVar.a());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasicSeperateBaMemberItemView(Context context, AttributeSet attributeSet) {
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
        this.f51446e = context;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasicSeperateBaMemberItemView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f51446e = context;
        a();
    }
}
