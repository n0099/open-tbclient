package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes7.dex */
public class rm9 extends in<iy9, PbAppLegoViewHolder> implements em9, zl9 {
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

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rm9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(rm9 rm9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rm9Var, Integer.valueOf(i)};
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
            this.a = rm9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.viewholder != null && this.a.c) {
                int c = ((PbAppLegoViewHolder) this.a.viewholder).c();
                if (((PbAppLegoViewHolder) this.a.viewholder).b()) {
                    if (c == -1) {
                        ((PbAppLegoViewHolder) this.a.viewholder).a((int) TimeUnit.SECONDS.toSeconds(1L));
                    }
                } else if (c != -1) {
                    ((PbAppLegoViewHolder) this.a.viewholder).stopPlay();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rm9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(rm9 rm9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rm9Var, Integer.valueOf(i)};
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
            this.a = rm9Var;
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

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rm9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(rm9 rm9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rm9Var, Integer.valueOf(i)};
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
            this.a = rm9Var;
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

    /* loaded from: classes7.dex */
    public class d implements lo8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvertAppInfo a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public d(rm9 rm9Var, AdvertAppInfo advertAppInfo, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rm9Var, advertAppInfo, Integer.valueOf(i), str};
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

        @Override // com.baidu.tieba.lo8
        public void a(int i, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIL(1048576, this, i, hashMap) != null) || i == 0) {
                return;
            }
            if (km9.h(i)) {
                xn9.g(this.a, this.b, hashMap, i);
            } else {
                xn9.n(this.a, this.b, this.c, null, hashMap);
            }
            to8.c(this.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rm9(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
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
    @Override // com.baidu.tieba.in
    public /* bridge */ /* synthetic */ PbAppLegoViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        E(viewGroup);
        throw null;
    }

    @Override // com.baidu.tieba.em9
    public void setIsFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.b = z;
        }
    }

    @Override // com.baidu.tieba.in
    public void setMulDel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.d = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in
    /* renamed from: C */
    public View getView(int i, View view2, ViewGroup viewGroup, iy9 iy9Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, iy9Var})) == null) {
            if (iy9Var != null && iy9Var.v1() != null) {
                if (D(view2, iy9Var)) {
                    PbAppLegoViewHolder onCreateViewHolder = onCreateViewHolder(viewGroup, iy9Var);
                    this.viewholder = onCreateViewHolder;
                    if (onCreateViewHolder != null) {
                        view2 = onCreateViewHolder.getView();
                    }
                }
                View view3 = view2;
                if (view3 != null) {
                    view3 = onFillViewHolder(i, view3, viewGroup, iy9Var, (PbAppLegoViewHolder) view3.getTag());
                    if (cm9.class.isAssignableFrom(view3.getClass())) {
                        ((PbAppLegoViewHolder) this.viewholder).e(((cm9) view3).getVideoOrVrView());
                    }
                }
                return view3;
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final boolean D(View view2, iy9 iy9Var) {
        InterceptResult invokeLL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, iy9Var)) == null) {
            if (view2 == null || view2.getTag() == null || (v = this.viewholder) == 0 || !((PbAppLegoViewHolder) v).getClass().isAssignableFrom(view2.getTag().getClass()) || !view2.getTag().getClass().isAssignableFrom(((PbAppLegoViewHolder) this.viewholder).getClass())) {
                return true;
            }
            AdvertAppInfo.ILegoAdvert v1 = iy9Var.v1();
            Object tag = view2.getTag(R.id.tag_first);
            if (tag instanceof AdvertAppInfo.ILegoAdvert) {
                return !v1.isReusable((AdvertAppInfo.ILegoAdvert) tag);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in
    /* renamed from: F */
    public PbAppLegoViewHolder onCreateViewHolder(ViewGroup viewGroup, iy9 iy9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, viewGroup, iy9Var)) == null) {
            View view2 = (View) mo8.h().a(this.a.getPageContext(), iy9Var.v1(), 4);
            if (view2 != null) {
                PbAppLegoViewHolder pbAppLegoViewHolder = new PbAppLegoViewHolder((hp8) view2);
                pbAppLegoViewHolder.setIsRecyclable(false);
                return pbAppLegoViewHolder;
            }
            return null;
        }
        return (PbAppLegoViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in
    /* renamed from: G */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, iy9 iy9Var, PbAppLegoViewHolder pbAppLegoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, iy9Var, pbAppLegoViewHolder})) == null) {
            if (this.a == null) {
                return null;
            }
            if (iy9Var.v1() instanceof AdCard) {
                ((AdCard) iy9Var.v1()).isPBBanner = iy9Var.c1;
            }
            boolean z = false;
            pbAppLegoViewHolder.setIsRecyclable(false);
            AdvertAppInfo.ILegoAdvert v1 = iy9Var.v1();
            view2.setTag(R.id.tag_first, v1);
            d05 layoutMode = this.a.getLayoutMode();
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                z = true;
            }
            layoutMode.l(z);
            this.a.getLayoutMode().k(view2);
            m15.f(iy9Var);
            AdvertAppInfo advertAppInfo = iy9Var.getAdvertAppInfo();
            if (advertAppInfo.i == null) {
                advertAppInfo.i = new m15();
            }
            m15 m15Var = advertAppInfo.i;
            m15Var.b = iy9Var.h1;
            m15Var.a = iy9Var.u1();
            advertAppInfo.position = iy9Var.j1;
            advertAppInfo.u = 3;
            int i2 = iy9Var.h1;
            String str = iy9Var.d1;
            advertAppInfo.t = str;
            hp8<?> hp8Var = (hp8) view2;
            hp8Var.setMulDel(this.d);
            v1.setAdvertAppInfo(advertAppInfo);
            hp8Var.setFromCDN(this.b);
            hp8Var.update(v1);
            H(iy9Var, hp8Var, str);
            Context context = this.mContext;
            if (context instanceof oj0) {
                advertAppInfo.r = qj0.b(advertAppInfo.r, (oj0) context, view2);
            }
            hp8Var.setAfterClickSchemeListener(new d(this, advertAppInfo, i2, str));
            WeakReference<PbAppLegoViewHolder> weakReference = this.h;
            if (weakReference == null || weakReference.get() != pbAppLegoViewHolder) {
                this.h = new WeakReference<>(pbAppLegoViewHolder);
            }
            updateFontSize();
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void H(iy9 iy9Var, hp8<?> hp8Var, String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, iy9Var, hp8Var, str) == null) {
            if (iy9Var.c1) {
                i = iy9Var.k1;
            } else {
                i = iy9Var.k1;
                if (o56.k().m()) {
                    i++;
                }
            }
            pn9.e(iy9Var.getAdvertAppInfo(), hp8Var, str, null, 3, i);
        }
    }

    @Override // com.baidu.tieba.zl9
    public void onDestroy() {
        V v;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (v = this.viewholder) != 0) {
            ((PbAppLegoViewHolder) v).d();
        }
    }

    @Override // com.baidu.tieba.zl9
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
                pbAppLegoViewHolder.f();
            }
        }
    }

    @Override // com.baidu.tieba.zl9
    public void onResume() {
        V v;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (v = this.viewholder) != 0 && ((PbAppLegoViewHolder) v).b()) {
            if (((PbAppLegoViewHolder) this.viewholder).c() == -1) {
                ((PbAppLegoViewHolder) this.viewholder).a((int) TimeUnit.SECONDS.toSeconds(1L));
            }
            this.c = true;
        }
    }
}
