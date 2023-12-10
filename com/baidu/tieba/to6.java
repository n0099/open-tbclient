package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.data.PollOptionData;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tieba.j37;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class to6 implements j37.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public to6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static final void l(ViewGroup view2, e57 state, View view3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, view2, state, view3) == null) {
            Intrinsics.checkNotNullParameter(view2, "$view");
            Intrinsics.checkNotNullParameter(state, "$state");
            za7.c(((VoteView) view2).getContext(), state.d().g());
        }
    }

    @Override // com.baidu.tieba.j37.s
    public void b(ViewGroup view2) {
        VoteView voteView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            if (view2 instanceof VoteView) {
                voteView = (VoteView) view2;
            } else {
                voteView = null;
            }
            if (voteView == null) {
                return;
            }
            voteView.D(TbadkApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.j37.k
    public void c(final ViewGroup view2, final e57 state) {
        VoteView voteView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, state) == null) {
            Intrinsics.checkNotNullParameter(view2, "view");
            Intrinsics.checkNotNullParameter(state, "state");
            o87 d = state.d();
            PollData pollData = new PollData();
            pollData.setIsPolled(d.m());
            pollData.setTotalNum(d.c());
            pollData.setOptionsCount(d.e());
            pollData.setEndTime(d.a());
            pollData.setIsMulti(d.l());
            pollData.setLastTime(d.d());
            pollData.setTitle(d.i());
            pollData.setEndTime(d.a());
            pollData.setTotalPoll(d.j());
            pollData.setPolledValue(d.f());
            ArrayList arrayList = new ArrayList();
            for (p87 p87Var : d.k()) {
                PollOptionData pollOptionData = new PollOptionData();
                pollOptionData.setId(p87Var.a());
                pollOptionData.setNum(p87Var.b());
                pollOptionData.setText(p87Var.c());
                arrayList.add(pollOptionData);
            }
            pollData.setOptions(arrayList);
            if (view2 instanceof VoteView) {
                voteView = (VoteView) view2;
            } else {
                voteView = null;
            }
            if (voteView == null) {
                return;
            }
            voteView.setData(pollData, state.d().h(), state.d().b());
            voteView.setupLiveThreadVoteInfo(state.e());
            voteView.setOnItemClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.go6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                        to6.l(view2, state, view3);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.j37.k
    public ViewGroup create(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            VoteView voteView = new VoteView(context);
            if (context instanceof TbPageContextSupport) {
                voteView.setPageContext(((TbPageContextSupport) context).getPageContext());
            }
            if (context instanceof ur6) {
                voteView.setPageContext(((ur6) context).getPageContext());
            }
            return voteView;
        }
        return (ViewGroup) invokeL.objValue;
    }
}
