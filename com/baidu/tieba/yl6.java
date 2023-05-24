package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.feed.component.uistate.CardUiStateKt;
import com.baidu.tieba.n27;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import tbclient.ComponentFactory;
import tbclient.FeedContentText;
import tbclient.FeedFeedback;
import tbclient.FeedKV;
import tbclient.LayoutFactory;
import tbclient.SidewayLayout;
import tbclient.SidewayRecomComponent;
/* loaded from: classes8.dex */
public final class yl6 implements e17<LayoutFactory>, i37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, ? extends j37> a;

    public yl6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.e17
    /* renamed from: a */
    public g37<?> b(LayoutFactory layoutFactory) {
        InterceptResult invokeL;
        SidewayLayout sidewayLayout;
        boolean z;
        String str;
        String str2;
        SidewayRecomComponent sidewayRecomComponent;
        Integer num;
        a17 a17Var;
        a17 a17Var2;
        String str3;
        int i;
        String str4;
        String str5;
        String a;
        String a2;
        String a3;
        Integer intOrNull;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, layoutFactory)) == null) {
            k07 k07Var = null;
            if (layoutFactory != null) {
                sidewayLayout = layoutFactory.sideway;
            } else {
                sidewayLayout = null;
            }
            if (sidewayLayout != null) {
                List<ComponentFactory> list = layoutFactory.sideway.components;
                int i2 = 1;
                if (list != null && !list.isEmpty()) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    vz6 vz6Var = new vz6();
                    n27.a aVar = n27.a;
                    List<FeedKV> list2 = layoutFactory.sideway.business_info;
                    Intrinsics.checkNotNullExpressionValue(list2, "originData.sideway.business_info");
                    vz6Var.b(aVar.a(list2));
                    z07 d = d("concern_reco_show", vz6Var);
                    t07 t07Var = new t07();
                    for (ComponentFactory componentFactory : layoutFactory.sideway.components) {
                        if (Intrinsics.areEqual("sideway_recom", componentFactory.component) && (sidewayRecomComponent = componentFactory.sideway_recom) != null && (num = sidewayRecomComponent.type) != null && num.intValue() == i2) {
                            vz6 vz6Var2 = new vz6();
                            n27.a aVar2 = n27.a;
                            List<FeedKV> list3 = componentFactory.sideway_recom.business_info;
                            Intrinsics.checkNotNullExpressionValue(list3, "data.sideway_recom.business_info");
                            vz6Var2.b(aVar2.a(list3));
                            z07 d2 = d("concern_reco_click_head", vz6Var2);
                            z07 d3 = d("concern_reco_follow_btn", vz6Var2);
                            z07 d4 = d("concern_reco_unfollow_btn", vz6Var2);
                            List<g37<?>> list4 = t07Var.a;
                            String str6 = componentFactory.sideway_recom.img_url;
                            Intrinsics.checkNotNullExpressionValue(str6, "data.sideway_recom.img_url");
                            yz6 yz6Var = new yz6(str6, 1, null, null, componentFactory.sideway_recom.corner_url, false);
                            FeedContentText feedContentText = componentFactory.sideway_recom.title;
                            if (feedContentText != null) {
                                a17Var = h17.c(feedContentText);
                            } else {
                                a17Var = null;
                            }
                            FeedContentText feedContentText2 = componentFactory.sideway_recom.desc;
                            if (feedContentText2 != null) {
                                a17Var2 = h17.c(feedContentText2);
                            } else {
                                a17Var2 = null;
                            }
                            SidewayRecomComponent sidewayRecomComponent2 = componentFactory.sideway_recom;
                            String str7 = sidewayRecomComponent2.schema;
                            List<FeedKV> list5 = sidewayRecomComponent2.business_info;
                            if (list5 != null) {
                                str3 = l17.a(list5, "is_like");
                            } else {
                                str3 = null;
                            }
                            boolean areEqual = Intrinsics.areEqual("1", str3);
                            List<FeedKV> list6 = componentFactory.sideway_recom.business_info;
                            if (list6 != null && (a3 = l17.a(list6, "like_status")) != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(a3)) != null) {
                                i = intOrNull.intValue();
                            } else {
                                i = 0;
                            }
                            List<FeedKV> list7 = componentFactory.sideway_recom.business_info;
                            if (list7 == null || (a2 = l17.a(list7, "user_id")) == null) {
                                str4 = "";
                            } else {
                                str4 = a2;
                            }
                            List<FeedKV> list8 = componentFactory.sideway_recom.business_info;
                            if (list8 == null || (a = l17.a(list8, "portrait")) == null) {
                                str5 = "";
                            } else {
                                str5 = a;
                            }
                            list4.add(new h37(new oz6(yz6Var, a17Var, a17Var2, str7, new c57(new v07(areEqual, i, str4, str5, d3, d4), null, CardUiStateKt.b(), null, null, 24, null), d2, null, null, 192, null), "recommend_card_person_attention"));
                            i2 = 1;
                        }
                    }
                    t07Var.b = d;
                    ComponentFactory componentFactory2 = layoutFactory.sideway.title;
                    if (componentFactory2 != null) {
                        str = componentFactory2.base_text;
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        str2 = "";
                    } else {
                        str2 = str;
                    }
                    FeedFeedback feedFeedback = layoutFactory.sideway.feedback;
                    if (feedFeedback != null) {
                        k07Var = v17.a(feedFeedback, new i07());
                    }
                    return new h37(new nz6(str2, R.color.CAM_X0105, t07Var, k07Var, null, 16, null), "sideway_card");
                }
            }
            return null;
        }
        return (g37) invokeL.objValue;
    }

    @Override // com.baidu.tieba.i37
    public void c(Map<String, ? extends j37> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.a = map;
        }
    }

    public final z07 d(String str, vz6 vz6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, vz6Var)) == null) {
            j37 j37Var = this.a.get(str);
            if (j37Var != null) {
                return new z07(j37Var.getKey(), j37Var.a(vz6Var), new HashMap());
            }
            return null;
        }
        return (z07) invokeLL.objValue;
    }
}
