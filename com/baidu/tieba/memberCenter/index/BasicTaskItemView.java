package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.a.j;
import c.a.s0.x0.a;
import c.a.t0.f2.c.k.o;
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
public class BasicTaskItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f47611e;

    /* renamed from: f  reason: collision with root package name */
    public View f47612f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f47613g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f47614h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f47615i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f47616j;

    /* renamed from: k  reason: collision with root package name */
    public View f47617k;
    public View l;
    public View.OnClickListener m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasicTaskItemView(Context context) {
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
        this.f47611e = context;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f47611e).inflate(R.layout.index_task_item, this);
            this.f47612f = inflate;
            this.l = inflate.findViewById(R.id.ly_desc);
            this.f47613g = (TbImageView) this.f47612f.findViewById(R.id.task_icon);
            this.f47614h = (TextView) this.f47612f.findViewById(R.id.txt_title);
            this.f47615i = (TextView) this.f47612f.findViewById(R.id.txt_desc);
            TextView textView = (TextView) this.f47612f.findViewById(R.id.txt_status);
            this.f47616j = textView;
            textView.setOnClickListener(this.m);
            this.l.setOnClickListener(this.m);
            this.f47617k = this.f47612f.findViewById(R.id.divider_line);
        }
    }

    public void hideDivideLine() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f47617k.setVisibility(8);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a.a((TbPageContext) j.a(this.f47611e), this.f47612f);
        }
    }

    public void renderView(o oVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, oVar) == null) || oVar == null) {
            return;
        }
        this.l.setTag(oVar);
        this.f47616j.setTag(oVar);
        this.f47613g.startLoad(oVar.b(), 10, false);
        this.f47614h.setText(oVar.f());
        this.f47615i.setText(oVar.a());
        if (oVar.c()) {
            this.f47616j.setText(this.f47611e.getString(R.string.index_task_finish), TextView.BufferType.EDITABLE);
            this.f47616j.setTextColor(SkinManager.getColor(R.color.CAM_X0110));
            this.f47616j.setBackgroundDrawable(null);
            return;
        }
        this.f47616j.setText(this.f47611e.getString(R.string.default_get_gift), TextView.BufferType.EDITABLE);
        this.f47616j.setTextColor(SkinManager.getColor(R.color.member_center_task_btn_textcolor));
        this.f47616j.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.item_blue_btn_selector));
    }

    public void setOnCommenClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasicTaskItemView(Context context, View.OnClickListener onClickListener) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, onClickListener};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f47611e = context;
        this.m = onClickListener;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasicTaskItemView(Context context, AttributeSet attributeSet) {
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
        this.f47611e = context;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasicTaskItemView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f47611e = context;
        a();
    }
}
