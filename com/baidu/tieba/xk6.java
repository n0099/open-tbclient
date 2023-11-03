package com.baidu.tieba;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.FollowUserDecorView;
import com.baidu.card.view.ForumEnterLayout;
import com.baidu.card.view.UnfollowedDecorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.bw4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public abstract class xk6<T extends bw4> extends yk6<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> i;
    public BdUniqueId j;
    public T k;
    public ThreadCommentAndPraiseInfoLayout l;
    public ThreadCommentAndPraiseInfoLayout m;
    public NEGFeedBackView n;
    public UnfollowedDecorView o;
    public FollowUserDecorView p;
    public ForumEnterLayout q;
    public boolean r;
    public boolean s;
    public boolean t;
    public View u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xk6(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = null;
        this.o = null;
        this.r = false;
        this.s = false;
        this.t = false;
    }

    public void H(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, viewGroup) == null) {
            K(viewGroup, L(viewGroup));
            M(viewGroup);
            J();
            if (y()) {
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.l;
                if (threadCommentAndPraiseInfoLayout != null) {
                    threadCommentAndPraiseInfoLayout.setVisibility(8);
                }
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = this.m;
                if (threadCommentAndPraiseInfoLayout2 != null) {
                    threadCommentAndPraiseInfoLayout2.setVisibility(8);
                }
                View view2 = this.u;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
            } else {
                I();
            }
            p();
        }
    }

    public void A(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, tbPageContext, i) == null) {
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.l;
            if (threadCommentAndPraiseInfoLayout != null) {
                threadCommentAndPraiseInfoLayout.onChangeSkinType();
            }
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = this.m;
            if (threadCommentAndPraiseInfoLayout2 != null) {
                threadCommentAndPraiseInfoLayout2.onChangeSkinType();
            }
            NEGFeedBackView nEGFeedBackView = this.n;
            if (nEGFeedBackView != null) {
                nEGFeedBackView.onChangeSkinType();
            }
            UnfollowedDecorView unfollowedDecorView = this.o;
            if (unfollowedDecorView != null) {
                unfollowedDecorView.onChangeSkinType();
            }
            ForumEnterLayout forumEnterLayout = this.q;
            if (forumEnterLayout != null) {
                forumEnterLayout.n(tbPageContext, i);
            }
            FollowUserDecorView followUserDecorView = this.p;
            if (followUserDecorView != null) {
                followUserDecorView.onChangeSkinType(i);
            }
        }
    }

    public void B(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) != null) || bdUniqueId == null) {
            return;
        }
        n(bdUniqueId);
        NEGFeedBackView nEGFeedBackView = this.n;
        if (nEGFeedBackView != null) {
            nEGFeedBackView.setUniqueId(bdUniqueId);
        }
        FollowUserDecorView followUserDecorView = this.p;
        if (followUserDecorView != null) {
            followUserDecorView.setPageUniqueId(bdUniqueId);
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.t = z;
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.s = z;
        }
    }

    public void F(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        NEGFeedBackView nEGFeedBackView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, nEGFeedbackEventCallback) == null) && (nEGFeedBackView = this.n) != null) {
            nEGFeedBackView.setEventCallback(nEGFeedbackEventCallback);
        }
    }

    public void G(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.h = i;
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = this.l;
            if (threadCommentAndPraiseInfoLayout != null) {
                threadCommentAndPraiseInfoLayout.S = i;
            }
            ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = this.m;
            if (threadCommentAndPraiseInfoLayout2 != null) {
                threadCommentAndPraiseInfoLayout2.S = i;
            }
        }
    }

    public int r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            return BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), i);
        }
        return invokeI.intValue;
    }

    public void E(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048580, this, view2, i) == null) && view2 != null && (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            if (marginLayoutParams.topMargin != i) {
                marginLayoutParams.topMargin = i;
                view2.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void I() {
        T t;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (t = this.k) != null && t.getThreadData() != null) {
            ThreadData threadData = this.k.getThreadData();
            this.l.setVisibility(8);
            this.m.setData(threadData);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            E(this.l, 0);
            E(this.m, 0);
        }
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.t;
        }
        return invokeV.booleanValue;
    }

    public final void J() {
        T t;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (t = this.k) != null && t.getThreadData() != null && this.q != null) {
            if (this.k.showCardEnterFourm()) {
                this.q.setData(this.k.getThreadData());
            } else if (this.r) {
                this.q.setData(this.k.getThreadData());
            }
        }
    }

    public final void K(ViewGroup viewGroup, boolean z) {
        T t;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048586, this, viewGroup, z) == null) && (t = this.k) != null && t.getThreadData() != null) {
            if (this.p == null) {
                FollowUserDecorView followUserDecorView = new FollowUserDecorView(this.i.getPageActivity());
                this.p = followUserDecorView;
                followUserDecorView.setIsShowIcon(this.s);
                viewGroup.addView(this.p);
            }
            if (z()) {
                this.p.setPageUniqueId(this.j);
                this.p.setSvgIconResId(0);
                int r = r(R.dimen.tbds177);
                int r2 = r(R.dimen.tbds76);
                if (z) {
                    i = R.dimen.tbds126;
                } else {
                    i = R.dimen.tbds44;
                }
                int r3 = r(i);
                int r4 = r(R.dimen.tbds52);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(r, r2);
                layoutParams.topMargin = r4;
                layoutParams.rightMargin = r3;
                layoutParams.gravity = 53;
                this.p.setLayoutParams(layoutParams);
                this.p.setData(this.k.getThreadData());
                return;
            }
            FollowUserDecorView followUserDecorView2 = this.p;
            if (followUserDecorView2 != null) {
                followUserDecorView2.setVisibility(8);
            }
        }
    }

    public final boolean L(ViewGroup viewGroup) {
        InterceptResult invokeL;
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, viewGroup)) == null) {
            T t = this.k;
            if (t == null || t.getThreadData() == null) {
                return false;
            }
            if (this.k.getThreadData() != null && (sparseArray = this.k.feedBackReasonMap) != null && sparseArray.size() > 0) {
                if (this.n == null) {
                    NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(h());
                    this.n = nEGFeedBackView;
                    viewGroup.addView(nEGFeedBackView);
                }
                this.n.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
                int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens3 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens4 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
                layoutParams.rightMargin = dimens3;
                layoutParams.topMargin = dimens4;
                layoutParams.gravity = 53;
                this.n.setPadding(dimens2, dimens2, dimens2, dimens2);
                this.n.setLayoutParams(layoutParams);
                NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
                negativeFeedBackData.setTid(this.k.getThreadData().getTid());
                negativeFeedBackData.setFid(this.k.getThreadData().getFid());
                negativeFeedBackData.setNid(this.k.getThreadData().getNid());
                negativeFeedBackData.setFeedBackReasonMap(this.k.feedBackReasonMap);
                this.n.setVisibility(0);
                this.n.setData(negativeFeedBackData);
                this.n.setFirstRowSingleColumn(true);
                return true;
            }
            NEGFeedBackView nEGFeedBackView2 = this.n;
            if (nEGFeedBackView2 == null) {
                return false;
            }
            nEGFeedBackView2.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void M(ViewGroup viewGroup) {
        T t;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, viewGroup) == null) && (t = this.k) != null && t.getThreadData() != null) {
            if (this.o == null) {
                UnfollowedDecorView unfollowedDecorView = new UnfollowedDecorView(this.i.getPageActivity());
                this.o = unfollowedDecorView;
                viewGroup.addView(unfollowedDecorView);
            }
            if (this.k.getThreadData().isFromConcern && !ThreadCardUtils.isSelf(this.k.getThreadData())) {
                this.o.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds90);
                int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens3 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds14);
                int dimens4 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens, dimens);
                layoutParams.rightMargin = dimens3;
                layoutParams.topMargin = dimens4;
                layoutParams.gravity = 53;
                this.o.setPadding(dimens2, dimens2, dimens2, dimens2);
                this.o.setLayoutParams(layoutParams);
                this.o.setVisibility(0);
                this.o.b(this.k.getThreadData());
                return;
            }
            UnfollowedDecorView unfollowedDecorView2 = this.o;
            if (unfollowedDecorView2 != null) {
                unfollowedDecorView2.setVisibility(8);
            }
        }
    }

    public void x(ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, threadCommentAndPraiseInfoLayout) != null) || threadCommentAndPraiseInfoLayout == null) {
            return;
        }
        threadCommentAndPraiseInfoLayout.setOnClickListener(this);
        threadCommentAndPraiseInfoLayout.setReplyTimeVisible(false);
        threadCommentAndPraiseInfoLayout.setShowPraiseNum(true);
        threadCommentAndPraiseInfoLayout.setCommentNumEnable(true);
        threadCommentAndPraiseInfoLayout.setNeedAddReplyIcon(true);
        threadCommentAndPraiseInfoLayout.setNeedAddPraiseIcon(true);
        if (threadCommentAndPraiseInfoLayout.getCommentContainer() != null) {
            threadCommentAndPraiseInfoLayout.getCommentContainer().setOnClickListener(this);
        }
        threadCommentAndPraiseInfoLayout.setShareVisible(true);
        threadCommentAndPraiseInfoLayout.setFrom(7);
        threadCommentAndPraiseInfoLayout.setShareReportFrom(3);
        threadCommentAndPraiseInfoLayout.hideDisagree();
        hw4 hw4Var = new hw4();
        hw4Var.b = 7;
        hw4Var.h = 1;
        threadCommentAndPraiseInfoLayout.setAgreeStatisticData(hw4Var);
    }

    public final boolean z() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            T t = this.k;
            if (t == null || t.getThreadData() == null || this.k.getThreadData().getAuthor() == null) {
                return false;
            }
            ThreadData threadData = this.k.getThreadData();
            if (ThreadCardUtils.isSelf(threadData)) {
                return false;
            }
            if (!threadData.isBjhDynamicThread() && !threadData.isBJHArticleThreadType() && !threadData.isBJHVideoThreadType()) {
                z = false;
            } else {
                z = true;
            }
            if ((!z || !threadData.isFromHomPage) && (!z || !threadData.isFromVideoTab || threadData.getAuthor().hadConcerned())) {
                if (threadData.getThreadAlaInfo() == null || !mm6.R(threadData)) {
                    return false;
                }
                if (!threadData.isFromHomPage && !threadData.isFromFeedTab) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
