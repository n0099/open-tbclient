package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class DressupItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f18515e;

    /* renamed from: f  reason: collision with root package name */
    public View f18516f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f18517g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f18518h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f18519i;
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
        this.f18515e = context;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f18515e).inflate(R.layout.index_dressup_item, this);
            this.f18516f = inflate;
            this.f18517g = (TbImageView) inflate.findViewById(R.id.bg_image);
            TbImageView tbImageView = (TbImageView) this.f18516f.findViewById(R.id.permission_icon);
            this.f18518h = tbImageView;
            tbImageView.setDefaultResource(R.drawable.transparent_bg);
            this.f18518h.setDefaultBgResource(R.drawable.transparent_bg);
            this.f18519i = (TextView) this.f18516f.findViewById(R.id.txt_type);
            this.j = (TextView) this.f18516f.findViewById(R.id.txt_name);
        }
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
        this.f18515e = context;
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
        this.f18515e = context;
        a();
    }
}
