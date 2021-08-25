package com.baidu.tieba.pb.videopb.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.e.e.p.k;
import c.a.p0.s.q.c2;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.widget.layout.FlowLabelLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class VideoTabPbFloatEnterForumViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f55492a;

    /* renamed from: b  reason: collision with root package name */
    public FlowLabelLayout f55493b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadForumEnterButton f55494c;

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
        this.f55492a = context;
        this.f55493b = (FlowLabelLayout) ((ViewGroup) view).getChildAt(0);
    }

    public void changeSkinType() {
        ThreadForumEnterButton threadForumEnterButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (threadForumEnterButton = this.f55494c) == null) {
            return;
        }
        threadForumEnterButton.onChangeSkinType();
    }

    public void setAfterListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.f55494c.setAfterClickListener(onClickListener);
        }
    }

    public void setData(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c2Var) == null) || c2Var == null) {
            return;
        }
        this.f55493b.removeAllViews();
        if (k.isEmpty(c2Var.Z())) {
            return;
        }
        ThreadForumEnterButton threadForumEnterButton = new ThreadForumEnterButton(this.f55492a);
        this.f55494c = threadForumEnterButton;
        threadForumEnterButton.isFromVideoTabPbFloat(true);
        this.f55494c.bindData(c2Var);
        this.f55493b.addView(this.f55494c, new ViewGroup.LayoutParams(-2, -2));
    }
}
