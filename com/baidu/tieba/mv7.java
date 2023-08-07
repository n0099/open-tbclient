package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.funad.adapter.FunAdNativeNewAdapter;
import com.baidu.tieba.funad.adapter.FunAdNativeViewHolder;
import com.baidu.tieba.funad.view.FunAbsAdView;
import com.baidu.tieba.funad.view.FunAdNativeCommentView;
import com.baidu.tieba.funad.view.FunAdNativeFrsView;
import com.baidu.tieba.funad.view.FunAdNativePbView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class mv7 implements fv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oba a;
        public final /* synthetic */ FunAdNativeViewHolder b;
        public final /* synthetic */ BdUniqueId c;
        public final /* synthetic */ String d;
        public final /* synthetic */ View.OnClickListener e;
        public final /* synthetic */ mv7 f;

        public a(mv7 mv7Var, oba obaVar, FunAdNativeViewHolder funAdNativeViewHolder, BdUniqueId bdUniqueId, String str, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mv7Var, obaVar, funAdNativeViewHolder, bdUniqueId, str, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = mv7Var;
            this.a = obaVar;
            this.b = funAdNativeViewHolder;
            this.c = bdUniqueId;
            this.d = str;
            this.e = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.p(true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016331, "delFunAd"));
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_FEEDBACK).param("obj_source", 6).param("obj_type", this.b.f()).param("resource_id", this.f.i(this.c, this.d)).param("obj_locate", 0);
                if ("a006".equals(this.b.f())) {
                    param.param(TiebaStatic.Params.OBJ_TO, this.b.d());
                    param.param(TiebaStatic.Params.OBJ_PARAM2, this.b.c());
                }
                TiebaStatic.log(param);
                View.OnClickListener onClickListener = this.e;
                if (onClickListener != null) {
                    onClickListener.onClick(view2);
                }
            }
        }
    }

    public mv7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.fv7
    public lm<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.G) {
                FunAdNativeNewAdapter funAdNativeNewAdapter = new FunAdNativeNewAdapter(baseFragmentActivity, bdUniqueId);
                funAdNativeNewAdapter.setSid(iv7.e().d("pb_banner"));
                funAdNativeNewAdapter.setPageType("pb");
                funAdNativeNewAdapter.setSceneKey("pb_banner");
                return funAdNativeNewAdapter;
            } else if (bdUniqueId == AdvertAppInfo.J) {
                FunAdNativeNewAdapter funAdNativeNewAdapter2 = new FunAdNativeNewAdapter(baseFragmentActivity, bdUniqueId);
                funAdNativeNewAdapter2.setSid(cv7.f());
                funAdNativeNewAdapter2.setPageType("pb");
                return funAdNativeNewAdapter2;
            } else if (bdUniqueId != AdvertAppInfo.H) {
                return null;
            } else {
                return new nv7(baseFragmentActivity, bdUniqueId);
            }
        }
        return (lm) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.fv7
    public View b(@NonNull Context context, @NonNull BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bdUniqueId)) == null) {
            if (bdUniqueId == AdvertAppInfo.H) {
                return new View(context);
            }
            if (bdUniqueId == AdvertAppInfo.J) {
                return new FunAdNativeCommentView(context);
            }
            if (bdUniqueId == AdvertAppInfo.I) {
                return new FunAdNativeFrsView(context);
            }
            return new FunAdNativePbView(context);
        }
        return (View) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.fv7
    public lm<?, ?> c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.I) {
                FunAdNativeNewAdapter funAdNativeNewAdapter = new FunAdNativeNewAdapter(baseFragmentActivity, bdUniqueId);
                funAdNativeNewAdapter.setSid(cv7.g());
                funAdNativeNewAdapter.setPageType("personalize");
                return funAdNativeNewAdapter;
            } else if (bdUniqueId != AdvertAppInfo.H) {
                return null;
            } else {
                return new nv7(baseFragmentActivity, bdUniqueId);
            }
        }
        return (lm) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.fv7
    public lm<?, ?> d(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.I) {
                FunAdNativeNewAdapter funAdNativeNewAdapter = new FunAdNativeNewAdapter(baseFragmentActivity, bdUniqueId);
                funAdNativeNewAdapter.setSid(iv7.e().d("frs_feed"));
                funAdNativeNewAdapter.setPageType("frs");
                funAdNativeNewAdapter.setSceneKey("frs_feed");
                return funAdNativeNewAdapter;
            } else if (bdUniqueId != AdvertAppInfo.H) {
                return null;
            } else {
                return new nv7(baseFragmentActivity, bdUniqueId);
            }
        }
        return (lm) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.fv7
    public void e(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && (view2 instanceof FunAbsAdView)) {
            ((FunAbsAdView) view2).h();
        }
    }

    @Override // com.baidu.tieba.fv7
    public void f(@NonNull View view2, @Nullable oba obaVar, @NonNull BdUniqueId bdUniqueId, String str, String str2, String str3, String str4, int i, View.OnClickListener onClickListener) {
        Activity activity;
        FunAdNativeViewHolder funAdNativeViewHolder;
        String str5;
        FunAdNativeViewHolder funAdNativeViewHolder2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{view2, obaVar, bdUniqueId, str, str2, str3, str4, Integer.valueOf(i), onClickListener}) == null) {
            Context context = view2.getContext();
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                if (context instanceof ks6) {
                    ks6 ks6Var = (ks6) context;
                    if (ks6Var.getPageContext() != null && ks6Var.getPageContext().getPageActivity() != null) {
                        activity = ks6Var.getPageContext().getPageActivity();
                    }
                }
                activity = null;
            }
            Activity activity2 = activity;
            if (obaVar != null && !obaVar.i() && activity2 != null) {
                j(view2, 0);
                FunAbsAdView funAbsAdView = (FunAbsAdView) view2;
                Object tag = funAbsAdView.getTag(R.id.obfuscated_res_0x7f090db9);
                if (tag instanceof FunAdNativeViewHolder) {
                    funAdNativeViewHolder = (FunAdNativeViewHolder) tag;
                } else {
                    funAdNativeViewHolder = new FunAdNativeViewHolder(funAbsAdView, activity2, bdUniqueId);
                    funAbsAdView.setTag(R.id.obfuscated_res_0x7f090db9, funAdNativeViewHolder);
                }
                String str6 = str;
                FunAdNativeViewHolder funAdNativeViewHolder3 = funAdNativeViewHolder;
                funAdNativeViewHolder3.m(str6);
                funAdNativeViewHolder3.l(str3);
                if (!"personalize".equals(str2) && !AdvertAppInfo.J.equals(bdUniqueId)) {
                    str6 = iv7.e().d(str3);
                }
                String str7 = str6;
                String str8 = "1";
                if (bdUniqueId == AdvertAppInfo.I) {
                    if ("frs".equals(str2)) {
                        if (!UbsABTestHelper.isFrsFunAdSdkTest()) {
                            str8 = "0";
                        }
                        cv7.m().J(activity2, str7, cv7.b(str2, str8), String.valueOf(obaVar.d()), tu5.f());
                    } else if ("personalize".equals(str2)) {
                        if (!UbsABTestHelper.isPersonalizeFunAdABTest()) {
                            str8 = "0";
                        }
                        cv7.m().I(activity2, str7, cv7.b(str2, str8));
                    }
                } else if (bdUniqueId == AdvertAppInfo.J) {
                    cv7 m = cv7.m();
                    if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
                        str8 = "0";
                    }
                    m.K(activity2, str7, cv7.b(str2, str8), obaVar.g(), obaVar.d());
                }
                if (funAbsAdView.getFeedBackView() != null) {
                    str5 = str7;
                    funAdNativeViewHolder2 = funAdNativeViewHolder3;
                    a aVar = new a(this, obaVar, funAdNativeViewHolder3, bdUniqueId, str2, onClickListener);
                    funAbsAdView.getFeedBackView().setOnClickListener(aVar);
                    funAbsAdView.setFeedBackListener(aVar);
                } else {
                    str5 = str7;
                    funAdNativeViewHolder2 = funAdNativeViewHolder3;
                }
                funAdNativeViewHolder2.e().h();
                funAdNativeViewHolder2.k(str2);
                funAdNativeViewHolder2.e().setCurpage(str2);
                funAdNativeViewHolder2.m(str5);
                funAdNativeViewHolder2.n(obaVar, i);
                return;
            }
            j(view2, 8);
        }
    }

    @Override // com.baidu.tieba.fv7
    public lm<?, ?> g(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, baseFragmentActivity, bdUniqueId, str)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.I) {
                FunAdNativeNewAdapter funAdNativeNewAdapter = new FunAdNativeNewAdapter(baseFragmentActivity, bdUniqueId);
                funAdNativeNewAdapter.setSid(iv7.e().d("frs_feed"));
                funAdNativeNewAdapter.setPageType("frs");
                funAdNativeNewAdapter.setPageTab(str);
                funAdNativeNewAdapter.setSceneKey("frs_feed");
                return funAdNativeNewAdapter;
            } else if (bdUniqueId != AdvertAppInfo.H) {
                return null;
            } else {
                return new nv7(baseFragmentActivity, bdUniqueId);
            }
        }
        return (lm) invokeLLL.objValue;
    }

    public final String i(@NonNull BdUniqueId bdUniqueId, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, bdUniqueId, str)) == null) {
            if ("pb".equals(str)) {
                if (bdUniqueId == AdvertAppInfo.J) {
                    return "2";
                }
                return "1";
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public final void j(@NonNull View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, i) == null) {
            if (view2 instanceof FunAbsAdView) {
                ((FunAbsAdView) view2).d(i);
            }
            view2.setVisibility(i);
        }
    }
}
