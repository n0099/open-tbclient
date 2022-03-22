package com.baidu.tieba.pb.videopb.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.d.f.p.m;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.view.ThreadForumEnterButton;
import com.baidu.tbadk.widget.layout.FlowLabelLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class VideoTabPbFloatEnterForumViewHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public FlowLabelLayout f35229b;

    /* renamed from: c  reason: collision with root package name */
    public ThreadForumEnterButton f35230c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoTabPbFloatEnterForumViewHolder(Context context, View view) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view};
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
        this.f35229b = (FlowLabelLayout) ((ViewGroup) view).getChildAt(0);
    }

    public void c() {
        ThreadForumEnterButton threadForumEnterButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (threadForumEnterButton = this.f35230c) == null) {
            return;
        }
        threadForumEnterButton.e();
    }

    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.f35230c.setAfterClickListener(onClickListener);
        }
    }

    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) || threadData == null) {
            return;
        }
        this.f35229b.removeAllViews();
        if (m.isEmpty(threadData.getForum_name())) {
            return;
        }
        ThreadForumEnterButton threadForumEnterButton = new ThreadForumEnterButton(this.a);
        this.f35230c = threadForumEnterButton;
        threadForumEnterButton.d(true);
        this.f35230c.a(threadData);
        this.f35229b.addView(this.f35230c, new ViewGroup.LayoutParams(-2, -2));
    }
}
