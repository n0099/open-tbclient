package com.baidu.tieba.pb.pb.main.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.am6;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.em6;
import com.baidu.tieba.jn;
import com.baidu.tieba.p49;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorWebViewAdapter;
import com.baidu.tieba.pb.pb.main.view.PbFirstFloorWebView;
import com.baidu.tieba.s99;
import com.baidu.tieba.z69;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 +2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0003+,-B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u0006\u0010!\u001a\u00020\"J@\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u000b2\b\u0010&\u001a\u0004\u0018\u00010$2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010'\u001a\u0004\u0018\u00010\u00022\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0015J\u0006\u0010)\u001a\u00020\"J\u0006\u0010*\u001a\u00020\"R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/baidu/tieba/pb/pb/main/adapter/PbFirstFloorWebViewAdapter;", "Lcom/baidu/adp/widget/ListView/AbsDelegateAdapter;", "Lcom/baidu/tieba/pb/data/PbFirstFloorWebViewItemData;", "Lcom/baidu/tieba/card/holder/CardViewHolder;", "Lcom/baidu/tieba/pb/pb/main/view/PbFirstFloorWebView;", "pbFragment", "Lcom/baidu/tieba/pb/pb/main/PbFragment;", "mType", "Lcom/baidu/adp/BdUniqueId;", "(Lcom/baidu/tieba/pb/pb/main/PbFragment;Lcom/baidu/adp/BdUniqueId;)V", "currentResultCode", "", "getCurrentResultCode", "()I", "setCurrentResultCode", "(I)V", "isRegisteredListener", "", "()Z", "setRegisteredListener", "(Z)V", "mPbFirstFloorWebView", "getMPbFirstFloorWebView", "()Lcom/baidu/tieba/pb/pb/main/view/PbFirstFloorWebView;", "mPbFirstFloorWebView$delegate", "Lkotlin/Lazy;", "mPopupReplyPostPanelListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mReplyPostNotificationH5Listener", "mWritePostNotificationH5SuccessListener", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", MissionEvent.MESSAGE_DESTROY, "", "onFillViewHolder", "Landroid/view/View;", CriusAttrConstants.POSITION, "convertView", "data", "viewHolder", MissionEvent.MESSAGE_PAUSE, "onResume", "Companion", "IPbFirstFloorWebViewChangeImpl", "IWebViewClickListenerImpl", "pb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class PbFirstFloorWebViewAdapter extends jn<p49, CardViewHolder<PbFirstFloorWebView>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final PbFragment a;
    public final Lazy b;
    public int c;
    public boolean d;
    public final CustomMessageListener e;
    public final CustomMessageListener f;
    public final CustomMessageListener g;

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

    /* loaded from: classes7.dex */
    public static final class a implements z69 {
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

        @Override // com.baidu.tieba.z69
        public void a(int i, double d) {
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Double.valueOf(d)}) == null) && (pbFirstFloorWebViewAdapter = this.a.get()) != null) {
                pbFirstFloorWebViewAdapter.A(i);
                if (pbFirstFloorWebViewAdapter.a.L5() != null) {
                    if (pbFirstFloorWebViewAdapter.a.w0) {
                        s99.g(pbFirstFloorWebViewAdapter.a.getListView());
                        pbFirstFloorWebViewAdapter.a.w0 = false;
                    }
                    if (i == 2) {
                        pbFirstFloorWebViewAdapter.a.showNetRefreshView(pbFirstFloorWebViewAdapter.a.L5().p1(), "", false);
                    }
                    pbFirstFloorWebViewAdapter.a.L5().A1();
                }
            }
        }

        @Override // com.baidu.tieba.z69
        public void b() {
            PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (pbFirstFloorWebViewAdapter = this.a.get()) != null && pbFirstFloorWebViewAdapter.a.L5() != null) {
                pbFirstFloorWebViewAdapter.a.L5().A1();
                pbFirstFloorWebViewAdapter.a.showNetRefreshView(pbFirstFloorWebViewAdapter.a.L5().p1(), "", false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements em6 {
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

        @Override // com.baidu.tieba.em6
        public void g(View view2, MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, motionEvent) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004021, motionEvent));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFirstFloorWebViewAdapter a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter) {
            super(2921804);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFirstFloorWebViewAdapter};
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
            this.a = pbFirstFloorWebViewAdapter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.a.L5().p2();
                PbModel Q = this.a.a.Q();
                if (Q != null) {
                    Q.isReplyResultNotificationH5 = true;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFirstFloorWebViewAdapter a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter) {
            super(2921805);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFirstFloorWebViewAdapter};
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
            this.a = pbFirstFloorWebViewAdapter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    int intValue = ((Integer) data).intValue();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("resultCode", Integer.valueOf(intValue));
                    am6.a().d(this.a.x().s(), "replyPostResult", linkedHashMap);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFirstFloorWebViewAdapter a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PbFirstFloorWebViewAdapter pbFirstFloorWebViewAdapter) {
            super(2921786);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFirstFloorWebViewAdapter};
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
            this.a = pbFirstFloorWebViewAdapter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                am6.a().d(this.a.x().s(), "writePostSuccess", new HashMap<>());
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
        this.e = new e(this);
        this.f = new c(this);
        this.g = new d(this);
    }

    public final void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.c = i;
        }
    }

    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            PbFirstFloorWebView x = x();
            if (x != null) {
                x.C();
            }
            MessageManager.getInstance().unRegisterListener(this.e);
            MessageManager.getInstance().unRegisterListener(this.f);
            MessageManager.getInstance().unRegisterListener(this.g);
            this.d = false;
        }
    }

    public final void onPause() {
        PbFirstFloorWebView x;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (x = x()) != null) {
            x.D();
        }
    }

    public final void onResume() {
        PbFirstFloorWebView x;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (x = x()) != null) {
            x.E();
        }
    }

    public final int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public final PbFirstFloorWebView x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return (PbFirstFloorWebView) this.b.getValue();
        }
        return (PbFirstFloorWebView) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: y */
    public CardViewHolder<PbFirstFloorWebView> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            if (!this.d) {
                MessageManager.getInstance().registerListener(this.e);
                MessageManager.getInstance().registerListener(this.f);
                MessageManager.getInstance().registerListener(this.g);
                this.d = true;
            }
            return new CardViewHolder<>(x());
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: z */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, p49 p49Var, CardViewHolder<PbFirstFloorWebView> cardViewHolder) {
        InterceptResult invokeCommon;
        PbFirstFloorWebView a2;
        PbFirstFloorWebView a3;
        PbFirstFloorWebView a4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, p49Var, cardViewHolder})) == null) {
            if (this.c != 1 && cardViewHolder != null && (a4 = cardViewHolder.a()) != null) {
                a4.i(p49Var);
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
