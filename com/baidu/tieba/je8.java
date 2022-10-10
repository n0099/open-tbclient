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
/* loaded from: classes4.dex */
public class je8 extends qn<jn8, PbAppLegoViewHolder> implements xd8, sd8 {
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

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ je8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(je8 je8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {je8Var, Integer.valueOf(i)};
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
            this.a = je8Var;
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

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ je8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(je8 je8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {je8Var, Integer.valueOf(i)};
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
            this.a = je8Var;
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

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ je8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(je8 je8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {je8Var, Integer.valueOf(i)};
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
            this.a = je8Var;
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

    /* loaded from: classes4.dex */
    public class d implements ng7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvertAppInfo a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public d(je8 je8Var, AdvertAppInfo advertAppInfo, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {je8Var, advertAppInfo, Integer.valueOf(i), str};
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

        @Override // com.baidu.tieba.ng7
        public void a(int i, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, hashMap) == null) || i == 0) {
                return;
            }
            if (ce8.h(i)) {
                of8.g(this.a, this.b, hashMap, i);
            } else {
                of8.n(this.a, this.b, this.c, null, hashMap);
            }
            vg7.c(this.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public je8(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: A */
    public View getView(int i, View view2, ViewGroup viewGroup, jn8 jn8Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, jn8Var})) == null) {
            if (jn8Var == null || jn8Var.m1() == null) {
                return null;
            }
            if (B(view2, jn8Var)) {
                PbAppLegoViewHolder onCreateViewHolder = onCreateViewHolder(viewGroup, jn8Var);
                this.viewholder = onCreateViewHolder;
                if (onCreateViewHolder != null) {
                    view2 = onCreateViewHolder.getView();
                }
            }
            View view3 = view2;
            if (view3 != null) {
                view3 = onFillViewHolder(i, view3, viewGroup, jn8Var, (PbAppLegoViewHolder) view3.getTag());
                if (vd8.class.isAssignableFrom(view3.getClass())) {
                    ((PbAppLegoViewHolder) this.viewholder).e(((vd8) view3).getVideoOrVrView());
                }
            }
            return view3;
        }
        return (View) invokeCommon.objValue;
    }

    public final boolean B(View view2, jn8 jn8Var) {
        InterceptResult invokeLL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, jn8Var)) == null) {
            if (view2 == null || view2.getTag() == null || (v = this.viewholder) == 0 || !((PbAppLegoViewHolder) v).getClass().isAssignableFrom(view2.getTag().getClass()) || !view2.getTag().getClass().isAssignableFrom(((PbAppLegoViewHolder) this.viewholder).getClass())) {
                return true;
            }
            AdvertAppInfo.ILegoAdvert m1 = jn8Var.m1();
            Object tag = view2.getTag(R.id.obfuscated_res_0x7f092047);
            if (tag instanceof AdvertAppInfo.ILegoAdvert) {
                return !m1.isReusable((AdvertAppInfo.ILegoAdvert) tag);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public PbAppLegoViewHolder C(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            throw new IllegalStateException("onCreateViewHolder(ViewGroup parent) unavailable.");
        }
        return (PbAppLegoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: D */
    public PbAppLegoViewHolder onCreateViewHolder(ViewGroup viewGroup, jn8 jn8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, viewGroup, jn8Var)) == null) {
            View view2 = (View) og7.h().a(this.a.getPageContext(), jn8Var.m1(), 4);
            if (view2 != null) {
                PbAppLegoViewHolder pbAppLegoViewHolder = new PbAppLegoViewHolder((jh7) view2);
                pbAppLegoViewHolder.setIsRecyclable(false);
                return pbAppLegoViewHolder;
            }
            return null;
        }
        return (PbAppLegoViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: E */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, jn8 jn8Var, PbAppLegoViewHolder pbAppLegoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, jn8Var, pbAppLegoViewHolder})) == null) {
            if (this.a == null) {
                return null;
            }
            if (jn8Var.m1() instanceof AdCard) {
                ((AdCard) jn8Var.m1()).isPBBanner = jn8Var.V0;
            }
            pbAppLegoViewHolder.setIsRecyclable(false);
            AdvertAppInfo.ILegoAdvert m1 = jn8Var.m1();
            view2.setTag(R.id.obfuscated_res_0x7f092047, m1);
            this.a.getLayoutMode().l(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.a.getLayoutMode().k(view2);
            dr4.f(jn8Var);
            AdvertAppInfo advertAppInfo = jn8Var.getAdvertAppInfo();
            if (advertAppInfo.i == null) {
                advertAppInfo.i = new dr4();
            }
            dr4 dr4Var = advertAppInfo.i;
            dr4Var.b = jn8Var.a1;
            dr4Var.a = jn8Var.l1();
            advertAppInfo.position = jn8Var.c1;
            advertAppInfo.u = 3;
            int i2 = jn8Var.a1;
            String str = jn8Var.W0;
            advertAppInfo.t = str;
            jh7<?> jh7Var = (jh7) view2;
            jh7Var.setMulDel(this.d);
            m1.setAdvertAppInfo(advertAppInfo);
            jh7Var.setFromCDN(this.b);
            jh7Var.update(m1);
            F(jn8Var, jh7Var, str);
            Context context = this.mContext;
            if (context instanceof di0) {
                advertAppInfo.r = fi0.b(advertAppInfo.r, (di0) context, view2);
            }
            jh7Var.setAfterClickSchemeListener(new d(this, advertAppInfo, i2, str));
            WeakReference<PbAppLegoViewHolder> weakReference = this.h;
            if (weakReference == null || weakReference.get() != pbAppLegoViewHolder) {
                this.h = new WeakReference<>(pbAppLegoViewHolder);
            }
            updateFontSize();
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void F(jn8 jn8Var, jh7<?> jh7Var, String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, jn8Var, jh7Var, str) == null) {
            if (jn8Var.V0) {
                i = jn8Var.d1;
            } else {
                i = jn8Var.d1;
                if (bp5.k().m()) {
                    i++;
                }
            }
            gf8.e(jn8Var.getAdvertAppInfo(), jh7Var, str, null, 3, i);
        }
    }

    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder' to match base method */
    @Override // com.baidu.tieba.qn
    public /* bridge */ /* synthetic */ PbAppLegoViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        C(viewGroup);
        throw null;
    }

    @Override // com.baidu.tieba.sd8
    public void onDestroy() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (v = this.viewholder) == 0) {
            return;
        }
        ((PbAppLegoViewHolder) v).d();
    }

    @Override // com.baidu.tieba.sd8
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

    @Override // com.baidu.tieba.sd8
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

    @Override // com.baidu.tieba.xd8
    public void setIsFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.b = z;
        }
    }

    @Override // com.baidu.tieba.qn
    public void setMulDel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.d = z;
        }
    }

    public void updateFontSize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            WeakReference<PbAppLegoViewHolder> weakReference = this.h;
            PbAppLegoViewHolder pbAppLegoViewHolder = weakReference != null ? weakReference.get() : null;
            if (pbAppLegoViewHolder != null) {
                pbAppLegoViewHolder.f();
            }
        }
    }
}
