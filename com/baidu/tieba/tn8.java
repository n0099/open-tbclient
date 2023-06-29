package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.immessagecenter.arch.utils.SafetyLinearLayoutManager;
import com.baidu.tieba.immessagecenter.arch.view.BaseView;
import com.baidu.tieba.immessagecenter.mention.MessageCenterActivity;
import com.baidu.tieba.immessagecenter.msgtab.ui.adapter.MsgTabNotifyItemAdapter;
import com.baidu.tieba.immessagecenter.msgtab.ui.vm.NotifyTabViewModel;
import com.baidu.tieba.sl8;
import com.baidu.tieba.so8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class tn8 extends BaseView<so8, ro8, NotifyTabViewModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragment e;
    public BdTypeRecyclerView f;
    public EMTextView g;
    public View h;
    public sn8 i;
    public sl8 j;
    public final MsgTabNotifyItemAdapter k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tn8(BaseFragment frag) {
        super(R.layout.obfuscated_res_0x7f0d062e);
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
        this.e = frag;
        this.k = new MsgTabNotifyItemAdapter(this.e);
    }

    public static final void S(tn8 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.M();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = (BdTypeRecyclerView) g(R.id.obfuscated_res_0x7f0917cb);
            this.g = (EMTextView) g(R.id.obfuscated_res_0x7f0917aa);
            this.h = g(R.id.obfuscated_res_0x7f091879);
        }
    }

    public final void J() {
        sn8 sn8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (sn8Var = this.i) != null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.f;
            if (bdTypeRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMsgList");
                bdTypeRecyclerView = null;
            }
            bdTypeRecyclerView.removeHeaderView(sn8Var.l());
            sn8Var.l().setVisibility(8);
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            sl8 sl8Var = this.j;
            if (sl8Var != null) {
                BdTypeRecyclerView bdTypeRecyclerView = this.f;
                if (bdTypeRecyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMsgList");
                    bdTypeRecyclerView = null;
                }
                bdTypeRecyclerView.removeHeaderView(sl8Var.f());
            }
            this.j = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    /* renamed from: N */
    public NotifyTabViewModel q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ViewModel viewModel = new ViewModelProvider(this.e).get(NotifyTabViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(frag).…TabViewModel::class.java)");
            return (NotifyTabViewModel) viewModel;
        }
        return (NotifyTabViewModel) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    /* renamed from: O */
    public void D(so8 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            if (state instanceof so8.c) {
                if (((so8.c) state).a()) {
                    R();
                } else {
                    M();
                }
            } else if (state instanceof so8.a) {
                if (((so8.a) state).a()) {
                    Q();
                } else {
                    J();
                }
            } else {
                BdTypeRecyclerView bdTypeRecyclerView = null;
                if (state instanceof so8.b) {
                    MsgTabNotifyItemAdapter msgTabNotifyItemAdapter = this.k;
                    BdTypeRecyclerView bdTypeRecyclerView2 = this.f;
                    if (bdTypeRecyclerView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMsgList");
                    } else {
                        bdTypeRecyclerView = bdTypeRecyclerView2;
                    }
                    so8.b bVar = (so8.b) state;
                    msgTabNotifyItemAdapter.o(bdTypeRecyclerView.getHeaderViewsCount(), bVar.a(), bVar.b());
                } else if (state instanceof so8.d) {
                    MsgTabNotifyItemAdapter msgTabNotifyItemAdapter2 = this.k;
                    BdTypeRecyclerView bdTypeRecyclerView3 = this.f;
                    if (bdTypeRecyclerView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMsgList");
                    } else {
                        bdTypeRecyclerView = bdTypeRecyclerView3;
                    }
                    so8.d dVar = (so8.d) state;
                    msgTabNotifyItemAdapter2.o(bdTypeRecyclerView.getHeaderViewsCount(), dVar.a(), dVar.b());
                }
            }
        }
    }

    @Override // com.baidu.tieba.sd8
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            View view2 = this.h;
            BdTypeRecyclerView bdTypeRecyclerView = null;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavBarView");
                view2 = null;
            }
            s75 d = s75.d(view2);
            d.o(R.string.J_X19);
            d.f(R.color.CAM_X0201);
            EMTextView eMTextView = this.g;
            if (eMTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitle");
                eMTextView = null;
            }
            s75 d2 = s75.d(eMTextView);
            d2.C(R.dimen.T_X04);
            d2.D(R.string.F_X02);
            d2.x(R.color.CAM_X0105);
            sl8 sl8Var = this.j;
            if (sl8Var != null) {
                sl8Var.g(i, true);
            }
            BdTypeRecyclerView bdTypeRecyclerView2 = this.f;
            if (bdTypeRecyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMsgList");
            } else {
                bdTypeRecyclerView = bdTypeRecyclerView2;
            }
            s75.d(bdTypeRecyclerView).f(R.color.CAM_X0201);
        }
    }

    public final void Q() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.i == null) {
                sn8 sn8Var = new sn8(this.e);
                this.i = sn8Var;
                if (sn8Var != null) {
                    Context context = l().getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
                    BaseView.H(sn8Var, context, null, true, false, 8, null);
                }
            }
            sn8 sn8Var2 = this.i;
            if (sn8Var2 != null) {
                if (sn8Var2.l().getParent() == null) {
                    z = true;
                } else {
                    z = false;
                }
                BdTypeRecyclerView bdTypeRecyclerView = null;
                if (!z) {
                    sn8Var2 = null;
                }
                if (sn8Var2 != null) {
                    BdTypeRecyclerView bdTypeRecyclerView2 = this.f;
                    if (bdTypeRecyclerView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMsgList");
                        bdTypeRecyclerView2 = null;
                    }
                    bdTypeRecyclerView2.removeHeaderView(sn8Var2.l());
                    BdTypeRecyclerView bdTypeRecyclerView3 = this.f;
                    if (bdTypeRecyclerView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMsgList");
                    } else {
                        bdTypeRecyclerView = bdTypeRecyclerView3;
                    }
                    bdTypeRecyclerView.addHeaderView(sn8Var2.l());
                    sn8Var2.l().setVisibility(0);
                }
            }
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.j == null) {
            sl8 sl8Var = new sl8(this.e.getPageContext(), true);
            sl8Var.h(new sl8.b() { // from class: com.baidu.tieba.nn8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.sl8.b
                public final void onClose() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        tn8.S(tn8.this);
                    }
                }
            });
            View f = sl8Var.f();
            f.setPadding(f.getPaddingLeft(), f.getPaddingTop(), f.getPaddingRight(), UtilHelper.getDimenPixelSize(R.dimen.M_W_X003));
            BdTypeRecyclerView bdTypeRecyclerView = this.f;
            if (bdTypeRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMsgList");
                bdTypeRecyclerView = null;
            }
            bdTypeRecyclerView.addHeaderView(sl8Var.f(), 0);
            this.j = sl8Var;
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            BdTypeRecyclerView bdTypeRecyclerView = this.f;
            BdTypeRecyclerView bdTypeRecyclerView2 = null;
            if (bdTypeRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMsgList");
                bdTypeRecyclerView = null;
            }
            bdTypeRecyclerView.setLayoutManager(new SafetyLinearLayoutManager(context, 1, false));
            bdTypeRecyclerView.setAdapter(this.k);
            if (this.e.getActivity() instanceof MessageCenterActivity) {
                View view2 = this.h;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNavBarView");
                    view2 = null;
                }
                view2.setVisibility(8);
                BdTypeRecyclerView bdTypeRecyclerView3 = this.f;
                if (bdTypeRecyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMsgList");
                } else {
                    bdTypeRecyclerView2 = bdTypeRecyclerView3;
                }
                s75 d = s75.d(bdTypeRecyclerView2);
                d.o(R.string.J_X19);
                d.f(R.color.CAM_X0201);
                return;
            }
            View view3 = this.h;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNavBarView");
                view3 = null;
            }
            s75 d2 = s75.d(view3);
            d2.o(R.string.J_X19);
            d2.f(R.color.CAM_X0201);
            EMTextView eMTextView = this.g;
            if (eMTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitle");
                eMTextView = null;
            }
            eMTextView.setText(context.getString(R.string.msg_notify));
            EMTextView eMTextView2 = this.g;
            if (eMTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            } else {
                bdTypeRecyclerView2 = eMTextView2;
            }
            s75 d3 = s75.d(bdTypeRecyclerView2);
            d3.x(R.color.CAM_X0105);
            d3.C(R.dimen.T_X04);
            d3.D(R.string.F_X02);
        }
    }
}
