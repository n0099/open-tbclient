package com.baidu.tieba.pb.videopb.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.widget.layout.FlowLabelLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import d.a.p0.s.q.b2;
/* loaded from: classes4.dex */
public class VideoTabPbFloatEnterForumViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f19973a;

    /* renamed from: b  reason: collision with root package name */
    public FlowLabelLayout f19974b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadForumEnterButton f19975c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoTabPbFloatEnterForumViewHolder(Context context, View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view};
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
        this.f19973a = context;
        this.f19974b = (FlowLabelLayout) ((ViewGroup) view).getChildAt(0);
    }

    public void b() {
        ThreadForumEnterButton threadForumEnterButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (threadForumEnterButton = this.f19975c) == null) {
            return;
        }
        threadForumEnterButton.e();
    }

    public void c(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.f19975c.setAfterClickListener(onClickListener);
        }
    }

    public void setData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2Var) == null) || b2Var == null) {
            return;
        }
        this.f19974b.removeAllViews();
        if (k.isEmpty(b2Var.X())) {
            return;
        }
        ThreadForumEnterButton threadForumEnterButton = new ThreadForumEnterButton(this.f19973a);
        this.f19975c = threadForumEnterButton;
        threadForumEnterButton.d(true);
        this.f19975c.a(b2Var);
        this.f19974b.addView(this.f19975c, new ViewGroup.LayoutParams(-2, -2));
    }
}
