package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.adapter.PbAppLegoViewHolder;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class ux9 extends lm<qba, PbAppLegoViewHolder> implements hx9, cx9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;
    public boolean b;
    public boolean c;
    public boolean d;
    public CustomMessageListener e;
    public CustomMessageListener f;
    public CustomMessageListener g;
    public WeakReference<PbAppLegoViewHolder> h;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ux9 ux9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.viewholder != null && this.a.c) {
                int d = ((PbAppLegoViewHolder) this.a.viewholder).d();
                if (((PbAppLegoViewHolder) this.a.viewholder).c()) {
                    if (d == -1) {
                        ((PbAppLegoViewHolder) this.a.viewholder).b((int) TimeUnit.SECONDS.toSeconds(1L));
                    }
                } else if (d != -1) {
                    ((PbAppLegoViewHolder) this.a.viewholder).stopPlay();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ux9 ux9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.updateFontSize();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ux9 ux9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.viewholder != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 2) {
                ((PbAppLegoViewHolder) this.a.viewholder).stopPlay();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements qx8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvertAppInfo a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public d(ux9 ux9Var, AdvertAppInfo advertAppInfo, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux9Var, advertAppInfo, Integer.valueOf(i), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = advertAppInfo;
            this.b = i;
            this.c = str;
        }

        @Override // com.baidu.tieba.qx8
        public void a(int i, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIL(1048576, this, i, hashMap) != null) || i == 0) {
                return;
            }
            if (nx9.h(i)) {
                bz9.g(this.a, this.b, hashMap, i);
            } else {
                bz9.n(this.a, this.b, this.c, null, hashMap);
            }
            yx8.c(this.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ux9(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = true;
        this.e = new a(this, 2004013);
        this.f = new b(this, 2004018);
        this.g = new c(this, 2004020);
        this.h = null;
        this.a = baseFragmentActivity;
        baseFragmentActivity.registerListener(this.e);
        this.a.registerListener(this.g);
        this.a.registerListener(this.f);
    }

    public PbAppLegoViewHolder E(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            throw new IllegalStateException("onCreateViewHolder(ViewGroup parent) unavailable.");
        }
        return (PbAppLegoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder' to match base method */
    @Override // com.baidu.tieba.lm
    public /* bridge */ /* synthetic */ PbAppLegoViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        E(viewGroup);
        throw null;
    }

    @Override // com.baidu.tieba.hx9
    public void setIsFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.b = z;
        }
    }

    @Override // com.baidu.tieba.lm
    public void setMulDel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.d = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm
    /* renamed from: C */
    public View getView(int i, View view2, ViewGroup viewGroup, qba qbaVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, qbaVar})) == null) {
            if (qbaVar != null && qbaVar.C1() != null) {
                if (D(view2, qbaVar)) {
                    PbAppLegoViewHolder onCreateViewHolder = onCreateViewHolder(viewGroup, qbaVar);
                    this.viewholder = onCreateViewHolder;
                    if (onCreateViewHolder != null) {
                        view2 = onCreateViewHolder.getView();
                    }
                }
                View view3 = view2;
                if (view3 != null) {
                    view3 = onFillViewHolder(i, view3, viewGroup, qbaVar, (PbAppLegoViewHolder) view3.getTag());
                    if (fx9.class.isAssignableFrom(view3.getClass())) {
                        ((PbAppLegoViewHolder) this.viewholder).f(((fx9) view3).getVideoOrVrView());
                    }
                }
                return view3;
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final boolean D(View view2, qba qbaVar) {
        InterceptResult invokeLL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, qbaVar)) == null) {
            if (view2 == null || view2.getTag() == null || (v = this.viewholder) == 0 || !((PbAppLegoViewHolder) v).getClass().isAssignableFrom(view2.getTag().getClass()) || !view2.getTag().getClass().isAssignableFrom(((PbAppLegoViewHolder) this.viewholder).getClass())) {
                return true;
            }
            AdvertAppInfo.ILegoAdvert C1 = qbaVar.C1();
            Object tag = view2.getTag(R.id.tag_first);
            if (tag instanceof AdvertAppInfo.ILegoAdvert) {
                return !C1.isReusable((AdvertAppInfo.ILegoAdvert) tag);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm
    /* renamed from: F */
    public PbAppLegoViewHolder onCreateViewHolder(ViewGroup viewGroup, qba qbaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, viewGroup, qbaVar)) == null) {
            View view2 = (View) rx8.h().a(this.a.getPageContext(), qbaVar.C1(), 4);
            if (view2 != null) {
                PbAppLegoViewHolder pbAppLegoViewHolder = new PbAppLegoViewHolder((ly8) view2);
                pbAppLegoViewHolder.setIsRecyclable(false);
                return pbAppLegoViewHolder;
            }
            return null;
        }
        return (PbAppLegoViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lm
    /* renamed from: G */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, qba qbaVar, PbAppLegoViewHolder pbAppLegoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, qbaVar, pbAppLegoViewHolder})) == null) {
            if (this.a == null) {
                return null;
            }
            if (qbaVar.C1() instanceof AdCard) {
                ((AdCard) qbaVar.C1()).isPBBanner = qbaVar.g1;
            }
            boolean z = false;
            pbAppLegoViewHolder.setIsRecyclable(false);
            AdvertAppInfo.ILegoAdvert C1 = qbaVar.C1();
            view2.setTag(R.id.tag_first, C1);
            BDLayoutMode layoutMode = this.a.getLayoutMode();
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                z = true;
            }
            layoutMode.setNightMode(z);
            this.a.getLayoutMode().onModeChanged(view2);
            v05.g(qbaVar);
            AdvertAppInfo advertAppInfo = qbaVar.getAdvertAppInfo();
            if (advertAppInfo.i == null) {
                advertAppInfo.i = new v05();
            }
            v05 v05Var = advertAppInfo.i;
            v05Var.b = qbaVar.l1;
            v05Var.a = qbaVar.B1();
            advertAppInfo.position = qbaVar.n1;
            advertAppInfo.v = 3;
            int i2 = qbaVar.l1;
            String str = qbaVar.h1;
            advertAppInfo.u = str;
            ly8<?> ly8Var = (ly8) view2;
            ly8Var.setMulDel(this.d);
            C1.setAdvertAppInfo(advertAppInfo);
            ly8Var.setFromCDN(this.b);
            ly8Var.update(C1);
            H(qbaVar, ly8Var, str);
            Context context = this.mContext;
            if (context instanceof ti0) {
                advertAppInfo.s = vi0.b(advertAppInfo.s, (ti0) context, view2);
            }
            ly8Var.setAfterClickSchemeListener(new d(this, advertAppInfo, i2, str));
            WeakReference<PbAppLegoViewHolder> weakReference = this.h;
            if (weakReference == null || weakReference.get() != pbAppLegoViewHolder) {
                this.h = new WeakReference<>(pbAppLegoViewHolder);
            }
            updateFontSize();
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void H(qba qbaVar, ly8<?> ly8Var, String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, qbaVar, ly8Var, str) == null) {
            if (qbaVar.g1) {
                i = qbaVar.o1;
            } else {
                i = qbaVar.o1;
                if (k46.k().m()) {
                    i++;
                }
            }
            uy9.e(qbaVar.getAdvertAppInfo(), ly8Var, str, null, 3, i);
        }
    }

    @Override // com.baidu.tieba.cx9
    public void onDestroy() {
        V v;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (v = this.viewholder) != 0) {
            ((PbAppLegoViewHolder) v).e();
        }
    }

    @Override // com.baidu.tieba.cx9
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            V v = this.viewholder;
            if (v != 0) {
                ((PbAppLegoViewHolder) v).stopPlay();
            }
            this.c = false;
        }
    }

    public void updateFontSize() {
        PbAppLegoViewHolder pbAppLegoViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            WeakReference<PbAppLegoViewHolder> weakReference = this.h;
            if (weakReference != null) {
                pbAppLegoViewHolder = weakReference.get();
            } else {
                pbAppLegoViewHolder = null;
            }
            if (pbAppLegoViewHolder != null) {
                pbAppLegoViewHolder.g();
            }
        }
    }

    @Override // com.baidu.tieba.cx9
    public void onResume() {
        V v;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (v = this.viewholder) != 0 && ((PbAppLegoViewHolder) v).c()) {
            if (((PbAppLegoViewHolder) this.viewholder).d() == -1) {
                ((PbAppLegoViewHolder) this.viewholder).b((int) TimeUnit.SECONDS.toSeconds(1L));
            }
            this.c = true;
        }
    }
}
