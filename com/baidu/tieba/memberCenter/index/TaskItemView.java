package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class TaskItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f18541e;

    /* renamed from: f  reason: collision with root package name */
    public View f18542f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f18543g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18544h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f18545i;
    public TextView j;
    public View k;
    public View l;
    public View.OnClickListener m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18541e = context;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f18541e).inflate(R.layout.index_task_item, this);
            this.f18542f = inflate;
            this.l = inflate.findViewById(R.id.ly_desc);
            this.f18543g = (TbImageView) this.f18542f.findViewById(R.id.task_icon);
            this.f18544h = (TextView) this.f18542f.findViewById(R.id.txt_title);
            this.f18545i = (TextView) this.f18542f.findViewById(R.id.txt_desc);
            TextView textView = (TextView) this.f18542f.findViewById(R.id.txt_status);
            this.j = textView;
            textView.setOnClickListener(this.m);
            this.l.setOnClickListener(this.m);
            this.k = this.f18542f.findViewById(R.id.divider_line);
        }
    }

    public void setOnCommenClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.m = onClickListener;
            this.j.setOnClickListener(onClickListener);
            this.l.setOnClickListener(this.m);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f18541e = context;
        a();
    }
}
