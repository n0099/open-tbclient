package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.cq8;
import com.baidu.tieba.immessagecenter.arch.utils.SafetyLinearLayoutManager;
import com.baidu.tieba.immessagecenter.arch.view.BaseView;
import com.baidu.tieba.immessagecenter.arch.view.LifecycleRootView;
import com.baidu.tieba.immessagecenter.mention.MessageCenterActivity;
import com.baidu.tieba.immessagecenter.msgtab.ui.adapter.MsgTabNotifyItemAdapter;
import com.baidu.tieba.immessagecenter.msgtab.ui.vm.NotifyTabViewModel;
import com.baidu.tieba.tt8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class xs8 extends BaseView<tt8, st8, NotifyTabViewModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragment f;
    public BdTypeRecyclerView g;
    public EMTextView h;
    public View i;
    public ws8 j;
    public cq8 k;
    public final MsgTabNotifyItemAdapter l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xs8(BaseFragment frag) {
        super(R.layout.obfuscated_res_0x7f0d0648);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frag};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(frag, "frag");
        this.f = frag;
        this.l = new MsgTabNotifyItemAdapter(this.f);
    }

    @Override // com.baidu.tieba.xk8
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            View view2 = this.i;
            BdTypeRecyclerView bdTypeRecyclerView = null;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavBarView");
                view2 = null;
            }
            EMManager.from(view2).setBackGroundColor(R.color.CAM_X0201);
            EMTextView eMTextView = this.h;
            if (eMTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitle");
                eMTextView = null;
            }
            EMManager.from(eMTextView).setTextSize(R.dimen.T_X04).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0105);
            cq8 cq8Var = this.k;
            if (cq8Var != null) {
                cq8Var.g(i, true);
            }
            BdTypeRecyclerView bdTypeRecyclerView2 = this.g;
            if (bdTypeRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMsgList");
            } else {
                bdTypeRecyclerView = bdTypeRecyclerView2;
            }
            EMManager.from(bdTypeRecyclerView).setBackGroundColor(R.color.CAM_X0201);
        }
    }

    public static final void U(xs8 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.P();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g = (BdTypeRecyclerView) k(R.id.obfuscated_res_0x7f091833);
            this.h = (EMTextView) k(R.id.obfuscated_res_0x7f091805);
            this.i = k(R.id.obfuscated_res_0x7f0918f5);
        }
    }

    public final void O() {
        ws8 ws8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (ws8Var = this.j) != null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.g;
            if (bdTypeRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMsgList");
                bdTypeRecyclerView = null;
            }
            bdTypeRecyclerView.removeHeaderView(ws8Var.n());
            ws8Var.n().setVisibility(8);
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            cq8 cq8Var = this.k;
            if (cq8Var != null) {
                BdTypeRecyclerView bdTypeRecyclerView = this.g;
                if (bdTypeRecyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMsgList");
                    bdTypeRecyclerView = null;
                }
                bdTypeRecyclerView.removeHeaderView(cq8Var.f());
            }
            this.k = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    /* renamed from: Q */
    public NotifyTabViewModel s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ViewModel viewModel = new ViewModelProvider(this.f).get(NotifyTabViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(frag).…TabViewModel::class.java)");
            return (NotifyTabViewModel) viewModel;
        }
        return (NotifyTabViewModel) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    /* renamed from: R */
    public void I(tt8 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            if (state instanceof tt8.c) {
                if (((tt8.c) state).a()) {
                    T();
                } else {
                    P();
                }
            } else if (state instanceof tt8.a) {
                if (((tt8.a) state).a()) {
                    S();
                } else {
                    O();
                }
            } else {
                BdTypeRecyclerView bdTypeRecyclerView = null;
                if (state instanceof tt8.b) {
                    MsgTabNotifyItemAdapter msgTabNotifyItemAdapter = this.l;
                    BdTypeRecyclerView bdTypeRecyclerView2 = this.g;
                    if (bdTypeRecyclerView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMsgList");
                    } else {
                        bdTypeRecyclerView = bdTypeRecyclerView2;
                    }
                    tt8.b bVar = (tt8.b) state;
                    msgTabNotifyItemAdapter.p(bdTypeRecyclerView.getHeaderViewsCount(), bVar.a(), bVar.b());
                } else if (state instanceof tt8.d) {
                    MsgTabNotifyItemAdapter msgTabNotifyItemAdapter2 = this.l;
                    BdTypeRecyclerView bdTypeRecyclerView3 = this.g;
                    if (bdTypeRecyclerView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMsgList");
                    } else {
                        bdTypeRecyclerView = bdTypeRecyclerView3;
                    }
                    tt8.d dVar = (tt8.d) state;
                    msgTabNotifyItemAdapter2.p(bdTypeRecyclerView.getHeaderViewsCount(), dVar.a(), dVar.b());
                }
            }
        }
    }

    public final void S() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.j == null) {
                ws8 ws8Var = new ws8(this.f);
                this.j = ws8Var;
                if (ws8Var != null) {
                    Context context = n().getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
                    BaseView.M(ws8Var, context, null, true, false, 8, null);
                }
            }
            ws8 ws8Var2 = this.j;
            if (ws8Var2 != null) {
                if (ws8Var2.n().getParent() == null) {
                    z = true;
                } else {
                    z = false;
                }
                BdTypeRecyclerView bdTypeRecyclerView = null;
                if (!z) {
                    ws8Var2 = null;
                }
                if (ws8Var2 != null) {
                    LifecycleRootView n = ws8Var2.n();
                    n.setPadding(n.getPaddingLeft(), UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), n.getPaddingRight(), n.getPaddingBottom());
                    BdTypeRecyclerView bdTypeRecyclerView2 = this.g;
                    if (bdTypeRecyclerView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMsgList");
                        bdTypeRecyclerView2 = null;
                    }
                    bdTypeRecyclerView2.removeHeaderView(ws8Var2.n());
                    BdTypeRecyclerView bdTypeRecyclerView3 = this.g;
                    if (bdTypeRecyclerView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMsgList");
                    } else {
                        bdTypeRecyclerView = bdTypeRecyclerView3;
                    }
                    bdTypeRecyclerView.addHeaderView(ws8Var2.n());
                    ws8Var2.n().setVisibility(0);
                }
            }
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.k == null) {
            cq8 cq8Var = new cq8(this.f.getPageContext(), true);
            cq8Var.h(new cq8.b() { // from class: com.baidu.tieba.ls8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.cq8.b
                public final void onClose() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        xs8.U(xs8.this);
                    }
                }
            });
            BdTypeRecyclerView bdTypeRecyclerView = this.g;
            if (bdTypeRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMsgList");
                bdTypeRecyclerView = null;
            }
            bdTypeRecyclerView.addHeaderView(cq8Var.f(), 0);
            this.k = cq8Var;
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            BdTypeRecyclerView bdTypeRecyclerView = this.g;
            BdTypeRecyclerView bdTypeRecyclerView2 = null;
            if (bdTypeRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMsgList");
                bdTypeRecyclerView = null;
            }
            bdTypeRecyclerView.setLayoutManager(new SafetyLinearLayoutManager(context, 1, false));
            bdTypeRecyclerView.setAdapter(this.l);
            if (this.f.getActivity() instanceof MessageCenterActivity) {
                View view2 = this.i;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNavBarView");
                    view2 = null;
                }
                view2.setVisibility(8);
                BdTypeRecyclerView bdTypeRecyclerView3 = this.g;
                if (bdTypeRecyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMsgList");
                } else {
                    bdTypeRecyclerView2 = bdTypeRecyclerView3;
                }
                EMManager.from(bdTypeRecyclerView2).setBackGroundColor(R.color.CAM_X0201);
                return;
            }
            View view3 = this.i;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavBarView");
                view3 = null;
            }
            EMManager.from(view3).setBackGroundColor(R.color.CAM_X0201);
            EMTextView eMTextView = this.h;
            if (eMTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitle");
                eMTextView = null;
            }
            eMTextView.setText(context.getString(R.string.msg_notify));
            EMTextView eMTextView2 = this.h;
            if (eMTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            } else {
                bdTypeRecyclerView2 = eMTextView2;
            }
            EMManager.from(bdTypeRecyclerView2).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X04).setTextStyle(R.string.F_X02);
        }
    }
}
