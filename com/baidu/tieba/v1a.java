package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.adapter.CardAppLegoViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class v1a extends om<to6, CardAppLegoViewHolder> implements h1a, m1a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public int b;
    public boolean c;
    public AdvertAppInfo.ILegoAdvert d;
    public String e;
    public Runnable f;
    public CustomMessageListener g;

    @Override // com.baidu.tieba.h1a
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    @Override // com.baidu.tieba.h1a
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements t19 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdvertAppInfo a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public a(v1a v1aVar, AdvertAppInfo advertAppInfo, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v1aVar, advertAppInfo, Integer.valueOf(i), str};
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

        @Override // com.baidu.tieba.t19
        public void a(int i, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIL(1048576, this, i, hashMap) != null) || i == 0) {
                return;
            }
            if (s1a.h(i)) {
                g3a.g(this.a, this.b, hashMap, i);
            } else {
                g3a.n(this.a, this.b, this.c, null, hashMap);
            }
            b29.c(this.a);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v1a a;

        public b(v1a v1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v1aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((CardAppLegoViewHolder) this.a.viewholder).b((int) TimeUnit.SECONDS.toSeconds(1L));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v1a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(v1a v1aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v1aVar, Integer.valueOf(i)};
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
            this.a = v1aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.viewholder == null) {
                return;
            }
            if (!(customResponsedMessage.getData() instanceof Boolean)) {
                ((CardAppLegoViewHolder) this.a.viewholder).stopPlay();
            } else if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                ((CardAppLegoViewHolder) this.a.viewholder).stopPlay();
            } else {
                int d = ((CardAppLegoViewHolder) this.a.viewholder).d();
                if (((CardAppLegoViewHolder) this.a.viewholder).c()) {
                    if (d == -1) {
                        SafeHandler.getInst().removeCallbacks(this.a.f);
                        SafeHandler.getInst().postDelayed(this.a.f, 500L);
                    }
                } else if (d != -1) {
                    ((CardAppLegoViewHolder) this.a.viewholder).stopPlay();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v1a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, str};
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
        this.b = 3;
        this.c = false;
        this.d = null;
        this.e = null;
        this.f = new b(this);
        this.g = new c(this, 2921517);
        this.a = tbPageContext;
        this.e = str;
        if ((tbPageContext.getPageActivity() instanceof BaseFragmentActivity) && TextUtils.equals(str, "CONCERN")) {
            if (bdUniqueId == AdvertAppInfo.D || bdUniqueId == AdvertAppInfo.F) {
                MessageManager.getInstance().registerListener(this.g);
            }
        }
    }

    @Override // com.baidu.tieba.m1a
    public void setIsFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.c = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: B */
    public View getView(int i, View view2, ViewGroup viewGroup, to6 to6Var) {
        InterceptResult invokeCommon;
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, to6Var})) == null) {
            if (to6Var != null && (advertAppInfo = to6Var.a) != null && (iLegoAdvert = advertAppInfo.h) != null) {
                this.d = iLegoAdvert;
                if (C(view2)) {
                    CardAppLegoViewHolder onCreateViewHolder = onCreateViewHolder(viewGroup);
                    this.viewholder = onCreateViewHolder;
                    if (onCreateViewHolder != null) {
                        view2 = onCreateViewHolder.getView();
                    }
                }
                View view3 = view2;
                if (view3 != null) {
                    view3 = onFillViewHolder(i, view3, viewGroup, to6Var, (CardAppLegoViewHolder) view3.getTag());
                    if (k1a.class.isAssignableFrom(view3.getClass())) {
                        ((CardAppLegoViewHolder) this.viewholder).e(((k1a) view3).getVideoOrVrView());
                    }
                }
                return view3;
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final boolean C(View view2) {
        InterceptResult invokeL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            if (view2 == null || view2.getTag() == null || (v = this.viewholder) == 0 || this.d == null || !((CardAppLegoViewHolder) v).getClass().isAssignableFrom(view2.getTag().getClass()) || !view2.getTag().getClass().isAssignableFrom(((CardAppLegoViewHolder) this.viewholder).getClass()) || !(view2.getTag(R.id.tag_first) instanceof AdvertAppInfo.ILegoAdvert)) {
                return true;
            }
            return !this.d.isReusable((AdvertAppInfo.ILegoAdvert) view2.getTag(R.id.tag_first));
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: D */
    public CardAppLegoViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            if (this.d == null || (view2 = (View) u19.h().a(this.a, this.d, 2)) == null) {
                return null;
            }
            view2.setTag(R.id.tag_first, this.d);
            return new CardAppLegoViewHolder((o29) view2);
        }
        return (CardAppLegoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: E */
    public CardAppLegoViewHolder onCreateViewHolder(ViewGroup viewGroup, to6 to6Var) {
        InterceptResult invokeLL;
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, viewGroup, to6Var)) == null) {
            if (to6Var != null && (advertAppInfo = to6Var.a) != null && (iLegoAdvert = advertAppInfo.h) != null) {
                this.d = iLegoAdvert;
                return onCreateViewHolder(viewGroup);
            }
            return null;
        }
        return (CardAppLegoViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: F */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, to6 to6Var, CardAppLegoViewHolder cardAppLegoViewHolder) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, to6Var, cardAppLegoViewHolder})) == null) {
            TbPageContext<?> tbPageContext = this.a;
            if (tbPageContext != null && to6Var != null && to6Var.a != null) {
                if (tbPageContext.getPageActivity() instanceof wi0) {
                    AdvertAppInfo advertAppInfo = to6Var.a;
                    advertAppInfo.s = yi0.b(advertAppInfo.s, (wi0) this.a.getPageActivity(), cardAppLegoViewHolder.itemView);
                }
                AdvertAppInfo.ILegoAdvert iLegoAdvert = to6Var.a.h;
                this.d = iLegoAdvert;
                if (iLegoAdvert != null && view2 != null) {
                    if (this.viewholder == 0) {
                        this.viewholder = cardAppLegoViewHolder;
                    }
                    b15.e(to6Var);
                    BDLayoutMode layoutMode = this.a.getLayoutMode();
                    if (this.b == 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    layoutMode.setNightMode(z);
                    this.a.getLayoutMode().onModeChanged(view2);
                    AdvertAppInfo c2 = to6Var.c();
                    c2.v = 1;
                    o29 o29Var = (o29) view2;
                    this.d.setAdvertAppInfo(c2);
                    o29Var.setFromCDN(this.c);
                    o29Var.update(this.d);
                    int i2 = to6Var.c;
                    String str = to6Var.b;
                    z2a.e(to6Var.c(), o29Var, str, this.e, 1, -1);
                    o29Var.setAfterClickSchemeListener(new a(this, c2, i2, str));
                    if (k1a.class.isAssignableFrom(view2.getClass())) {
                        cardAppLegoViewHolder.e(((k1a) view2).getVideoOrVrView());
                    }
                    return view2;
                }
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.h1a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.g);
        }
    }
}
