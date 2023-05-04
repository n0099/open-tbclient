package com.baidu.tieba.pb.pb.main.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.cg6;
import com.baidu.tieba.cy8;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorWebViewAdapter;
import com.baidu.tieba.pb.pb.main.view.PbFirstFloorWebView;
import com.baidu.tieba.s09;
import com.baidu.tieba.uv8;
import com.baidu.tieba.vm;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \"2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0003\"#$B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0006\u0010\u0018\u001a\u00020\u0019J@\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0015J\u0006\u0010 \u001a\u00020\u0019J\u0006\u0010!\u001a\u00020\u0019R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/baidu/tieba/pb/pb/main/adapter/PbFirstFloorWebViewAdapter;", "Lcom/baidu/adp/widget/ListView/AbsDelegateAdapter;", "Lcom/baidu/tieba/pb/data/PbFirstFloorWebViewItemData;", "Lcom/baidu/tieba/card/holder/CardViewHolder;", "Lcom/baidu/tieba/pb/pb/main/view/PbFirstFloorWebView;", "pbFragment", "Lcom/baidu/tieba/pb/pb/main/PbFragment;", "mType", "Lcom/baidu/adp/BdUniqueId;", "(Lcom/baidu/tieba/pb/pb/main/PbFragment;Lcom/baidu/adp/BdUniqueId;)V", "currentResultCode", "", "getCurrentResultCode", "()I", "setCurrentResultCode", "(I)V", "mPbFirstFloorWebView", "getMPbFirstFloorWebView", "()Lcom/baidu/tieba/pb/pb/main/view/PbFirstFloorWebView;", "mPbFirstFloorWebView$delegate", "Lkotlin/Lazy;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", MissionEvent.MESSAGE_DESTROY, "", "onFillViewHolder", "Landroid/view/View;", CriusAttrConstants.POSITION, "convertView", "data", "viewHolder", MissionEvent.MESSAGE_PAUSE, "onResume", "Companion", "IPbFirstFloorWebViewChangeImpl", "IWebViewClickListenerImpl", "pb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PbFirstFloorWebViewAdapter extends vm<uv8, CardViewHolder<PbFirstFloorWebView>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final PbFragment a;
    public final Lazy b;
    public int c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(355913039, "Lcom/baidu/tieba/pb/pb/main/adapter/PbFirstFloorWebViewAdapter;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(355913039, "Lcom/baidu/tieba/pb/pb/main/adapter/PbFirstFloorWebViewAdapter;");
        }
    }

    /* loaded from: classes5.dex */
    public static final class a implements cy8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<PbFirstFloorWebViewAdapter> a;

        public a(PbFirstFloorWebViewAdapter adapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            this.a = new WeakReference<>(adapter);
        }

        @Override // com.baidu.tieba.cy8
        public void a(int i, double d) {
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Double.valueOf(d)}) == null) && (pbFirstFloorWebViewAdapter = this.a.get()) != null) {
                pbFirstFloorWebViewAdapter.z(i);
                if (pbFirstFloorWebViewAdapter.a.I5() != null) {
                    if (pbFirstFloorWebViewAdapter.a.v0) {
                        s09.g(pbFirstFloorWebViewAdapter.a.getListView());
                        pbFirstFloorWebViewAdapter.a.v0 = false;
                    }
                    if (i == 2) {
                        pbFirstFloorWebViewAdapter.a.showNetRefreshView(pbFirstFloorWebViewAdapter.a.I5().o1(), "", false);
                    }
                    pbFirstFloorWebViewAdapter.a.I5().z1();
                }
            }
        }

        @Override // com.baidu.tieba.cy8
        public void b() {
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (pbFirstFloorWebViewAdapter = this.a.get()) != null && pbFirstFloorWebViewAdapter.a.I5() != null) {
                pbFirstFloorWebViewAdapter.a.I5().z1();
                pbFirstFloorWebViewAdapter.a.showNetRefreshView(pbFirstFloorWebViewAdapter.a.I5().o1(), "", false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements cg6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(PbFirstFloorWebViewAdapter adapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            new WeakReference(adapter);
        }

        @Override // com.baidu.tieba.cg6
        public void i(View view2, MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, motionEvent) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004021, motionEvent));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFirstFloorWebViewAdapter(PbFragment pbFragment, BdUniqueId mType) {
        super(pbFragment.getPageContext().getPageActivity(), mType);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, mType};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pbFragment, "pbFragment");
        Intrinsics.checkNotNullParameter(mType, "mType");
        this.a = pbFragment;
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<PbFirstFloorWebView>(this) { // from class: com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorWebViewAdapter$mPbFirstFloorWebView$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PbFirstFloorWebViewAdapter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PbFirstFloorWebView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new PbFirstFloorWebView(this.this$0.a.getPageContext(), new PbFirstFloorWebViewAdapter.a(this.this$0), new PbFirstFloorWebViewAdapter.b(this.this$0));
                }
                return (PbFirstFloorWebView) invokeV.objValue;
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vm
    /* renamed from: x */
    public CardViewHolder<PbFirstFloorWebView> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            return new CardViewHolder<>(u());
        }
        return (CardViewHolder) invokeL.objValue;
    }

    public final void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.c = i;
        }
    }

    public final void onDestroy() {
        PbFirstFloorWebView u;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (u = u()) != null) {
            u.C();
        }
    }

    public final void onPause() {
        PbFirstFloorWebView u;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (u = u()) != null) {
            u.D();
        }
    }

    public final void onResume() {
        PbFirstFloorWebView u;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (u = u()) != null) {
            u.E();
        }
    }

    public final int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public final PbFirstFloorWebView u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return (PbFirstFloorWebView) this.b.getValue();
        }
        return (PbFirstFloorWebView) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vm
    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, uv8 uv8Var, CardViewHolder<PbFirstFloorWebView> cardViewHolder) {
        InterceptResult invokeCommon;
        PbFirstFloorWebView a2;
        PbFirstFloorWebView a3;
        PbFirstFloorWebView a4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, uv8Var, cardViewHolder})) == null) {
            if (this.c != 1 && cardViewHolder != null && (a4 = cardViewHolder.a()) != null) {
                a4.i(uv8Var);
            }
            if (cardViewHolder != null && (a3 = cardViewHolder.a()) != null) {
                a3.j(null, TbadkCoreApplication.getInst().getSkinType());
            }
            if (cardViewHolder == null || (a2 = cardViewHolder.a()) == null) {
                return null;
            }
            return a2.h();
        }
        return (View) invokeCommon.objValue;
    }
}
