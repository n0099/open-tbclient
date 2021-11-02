package com.baidu.tieba.pb.videopb.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import b.a.e.e.p.k;
import b.a.q0.s.q.d2;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.widget.layout.FlowLabelLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class VideoTabPbFloatEnterForumViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f52854a;

    /* renamed from: b  reason: collision with root package name */
    public FlowLabelLayout f52855b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadForumEnterButton f52856c;

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
        this.f52854a = context;
        this.f52855b = (FlowLabelLayout) ((ViewGroup) view).getChildAt(0);
    }

    public void changeSkinType() {
        ThreadForumEnterButton threadForumEnterButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (threadForumEnterButton = this.f52856c) == null) {
            return;
        }
        threadForumEnterButton.onChangeSkinType();
    }

    public void setAfterListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.f52856c.setAfterClickListener(onClickListener);
        }
    }

    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var) == null) || d2Var == null) {
            return;
        }
        this.f52855b.removeAllViews();
        if (k.isEmpty(d2Var.Z())) {
            return;
        }
        ThreadForumEnterButton threadForumEnterButton = new ThreadForumEnterButton(this.f52854a);
        this.f52856c = threadForumEnterButton;
        threadForumEnterButton.isFromVideoTabPbFloat(true);
        this.f52856c.bindData(d2Var);
        this.f52855b.addView(this.f52856c, new ViewGroup.LayoutParams(-2, -2));
    }
}
