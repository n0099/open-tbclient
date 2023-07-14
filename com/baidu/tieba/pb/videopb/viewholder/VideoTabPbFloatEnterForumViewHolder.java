package com.baidu.tieba.pb.videopb.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.widget.layout.FlowLabelLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class VideoTabPbFloatEnterForumViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public FlowLabelLayout b;
    public ThreadForumEnterButton c;
    public View d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoTabPbFloatEnterForumViewHolder(Context context, View view2) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = (FlowLabelLayout) ((ViewGroup) view2).getChildAt(0);
        this.d = view2.findViewById(R.id.obfuscated_res_0x7f090b60);
    }

    public void b() {
        ThreadForumEnterButton threadForumEnterButton;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (threadForumEnterButton = this.c) != null) {
            threadForumEnterButton.e();
        }
    }

    public void c(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.c.setAfterClickListener(onClickListener);
        }
    }

    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) != null) || threadData == null) {
            return;
        }
        this.b.removeAllViews();
        if (!xi.isEmpty(threadData.getForum_name())) {
            ThreadForumEnterButton threadForumEnterButton = new ThreadForumEnterButton(this.a);
            this.c = threadForumEnterButton;
            threadForumEnterButton.d(true);
            this.c.a(threadData);
            this.b.addView(this.c, new ViewGroup.LayoutParams(-2, -2));
        }
    }
}
