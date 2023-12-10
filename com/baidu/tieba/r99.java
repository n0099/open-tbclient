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
import com.baidu.tieba.immessagecenter.arch.utils.SafetyLinearLayoutManager;
import com.baidu.tieba.immessagecenter.arch.view.BaseView;
import com.baidu.tieba.immessagecenter.arch.view.LifecycleRootView;
import com.baidu.tieba.immessagecenter.mention.MessageCenterActivity;
import com.baidu.tieba.immessagecenter.msgtab.ui.adapter.MsgTabNotifyItemAdapter;
import com.baidu.tieba.immessagecenter.msgtab.ui.vm.NotifyTabViewModel;
import com.baidu.tieba.na9;
import com.baidu.tieba.u69;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class r99 extends BaseView<na9, ma9, NotifyTabViewModel> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragment f;
    public BdTypeRecyclerView g;
    public EMTextView h;
    public View i;
    public q99 j;
    public u69 k;
    public final MsgTabNotifyItemAdapter l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r99(BaseFragment frag) {
        super(R.layout.obfuscated_res_0x7f0d0676);
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

    @Override // com.baidu.tieba.j19
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
            u69 u69Var = this.k;
            if (u69Var != null) {
                u69Var.b(i, true);
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

    public static final void V(r99 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.Q();
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g = (BdTypeRecyclerView) j(R.id.obfuscated_res_0x7f0918e8);
            this.h = (EMTextView) j(R.id.obfuscated_res_0x7f0918ba);
            this.i = j(R.id.obfuscated_res_0x7f0919af);
        }
    }

    public final void P() {
        q99 q99Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (q99Var = this.j) != null) {
            BdTypeRecyclerView bdTypeRecyclerView = this.g;
            if (bdTypeRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMsgList");
                bdTypeRecyclerView = null;
            }
            bdTypeRecyclerView.removeHeaderView(q99Var.n());
            q99Var.n().setVisibility(8);
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            u69 u69Var = this.k;
            if (u69Var != null) {
                BdTypeRecyclerView bdTypeRecyclerView = this.g;
                if (bdTypeRecyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMsgList");
                    bdTypeRecyclerView = null;
                }
                bdTypeRecyclerView.removeHeaderView(u69Var.a());
            }
            this.k = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    /* renamed from: R */
    public NotifyTabViewModel u() {
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
    /* renamed from: S */
    public void J(na9 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            if (state instanceof na9.c) {
                if (((na9.c) state).a()) {
                    U();
                } else {
                    Q();
                }
            } else if (state instanceof na9.a) {
                if (((na9.a) state).a()) {
                    T();
                } else {
                    P();
                }
            } else {
                BdTypeRecyclerView bdTypeRecyclerView = null;
                if (state instanceof na9.b) {
                    MsgTabNotifyItemAdapter msgTabNotifyItemAdapter = this.l;
                    BdTypeRecyclerView bdTypeRecyclerView2 = this.g;
                    if (bdTypeRecyclerView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMsgList");
                    } else {
                        bdTypeRecyclerView = bdTypeRecyclerView2;
                    }
                    na9.b bVar = (na9.b) state;
                    msgTabNotifyItemAdapter.q(bdTypeRecyclerView.getHeaderViewsCount(), bVar.a(), bVar.b());
                } else if (state instanceof na9.d) {
                    MsgTabNotifyItemAdapter msgTabNotifyItemAdapter2 = this.l;
                    BdTypeRecyclerView bdTypeRecyclerView3 = this.g;
                    if (bdTypeRecyclerView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMsgList");
                    } else {
                        bdTypeRecyclerView = bdTypeRecyclerView3;
                    }
                    na9.d dVar = (na9.d) state;
                    msgTabNotifyItemAdapter2.q(bdTypeRecyclerView.getHeaderViewsCount(), dVar.a(), dVar.b());
                }
            }
        }
    }

    public final void T() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.j == null) {
                q99 q99Var = new q99(this.f);
                this.j = q99Var;
                if (q99Var != null) {
                    Context context = n().getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
                    BaseView.N(q99Var, context, null, true, false, 8, null);
                }
            }
            q99 q99Var2 = this.j;
            if (q99Var2 != null) {
                if (q99Var2.n().getParent() == null) {
                    z = true;
                } else {
                    z = false;
                }
                BdTypeRecyclerView bdTypeRecyclerView = null;
                if (!z) {
                    q99Var2 = null;
                }
                if (q99Var2 != null) {
                    LifecycleRootView n = q99Var2.n();
                    n.setPadding(n.getPaddingLeft(), UtilHelper.getDimenPixelSize(R.dimen.M_W_X003), n.getPaddingRight(), n.getPaddingBottom());
                    BdTypeRecyclerView bdTypeRecyclerView2 = this.g;
                    if (bdTypeRecyclerView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMsgList");
                        bdTypeRecyclerView2 = null;
                    }
                    bdTypeRecyclerView2.removeHeaderView(q99Var2.n());
                    BdTypeRecyclerView bdTypeRecyclerView3 = this.g;
                    if (bdTypeRecyclerView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMsgList");
                    } else {
                        bdTypeRecyclerView = bdTypeRecyclerView3;
                    }
                    bdTypeRecyclerView.addHeaderView(q99Var2.n());
                    q99Var2.n().setVisibility(0);
                }
            }
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.k == null) {
            u69 u69Var = new u69(this.f.getPageContext(), true);
            u69Var.c(new u69.a() { // from class: com.baidu.tieba.c99
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.u69.a
                public final void onClose() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        r99.V(r99.this);
                    }
                }
            });
            BdTypeRecyclerView bdTypeRecyclerView = this.g;
            if (bdTypeRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMsgList");
                bdTypeRecyclerView = null;
            }
            bdTypeRecyclerView.addHeaderView(u69Var.a(), 0);
            this.k = u69Var;
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void r(Context context) {
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
