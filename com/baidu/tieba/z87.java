package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.feed.component.uistate.CardUiStateKt;
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
/* loaded from: classes9.dex */
public final class z87 implements a97<LayoutFactory>, xb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, ? extends yb7> a;

    public z87() {
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
    @Override // com.baidu.tieba.a97
    /* renamed from: a */
    public rb7<?> b(LayoutFactory layoutFactory) {
        InterceptResult invokeL;
        SidewayLayout sidewayLayout;
        boolean z;
        String str;
        String str2;
        SidewayRecomComponent sidewayRecomComponent;
        Integer num;
        g87 g87Var;
        g87 g87Var2;
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
            t67 t67Var = null;
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
                    v57 v57Var = new v57();
                    v57Var.b(va7.a.a(layoutFactory.sideway.business_info));
                    e87 c = c("concern_reco_show", v57Var);
                    t77 t77Var = new t77();
                    for (ComponentFactory componentFactory : layoutFactory.sideway.components) {
                        if (Intrinsics.areEqual("sideway_recom", componentFactory.component) && (sidewayRecomComponent = componentFactory.sideway_recom) != null && (num = sidewayRecomComponent.type) != null && num.intValue() == i2) {
                            v57 v57Var2 = new v57();
                            v57Var2.b(va7.a.a(componentFactory.sideway_recom.business_info));
                            e87 c2 = c("concern_reco_click_head", v57Var2);
                            e87 c3 = c("concern_reco_follow_btn", v57Var2);
                            e87 c4 = c("concern_reco_unfollow_btn", v57Var2);
                            List<rb7<?>> list2 = t77Var.a;
                            String str6 = componentFactory.sideway_recom.img_url;
                            Intrinsics.checkNotNullExpressionValue(str6, "data.sideway_recom.img_url");
                            z57 z57Var = new z57(str6, 1, null, null, componentFactory.sideway_recom.corner_url, false, null);
                            FeedContentText feedContentText = componentFactory.sideway_recom.title;
                            if (feedContentText != null) {
                                g87Var = f97.c(feedContentText);
                            } else {
                                g87Var = null;
                            }
                            FeedContentText feedContentText2 = componentFactory.sideway_recom.desc;
                            if (feedContentText2 != null) {
                                g87Var2 = f97.c(feedContentText2);
                            } else {
                                g87Var2 = null;
                            }
                            SidewayRecomComponent sidewayRecomComponent2 = componentFactory.sideway_recom;
                            String str7 = sidewayRecomComponent2.schema;
                            List<FeedKV> list3 = sidewayRecomComponent2.business_info;
                            if (list3 != null) {
                                str3 = i97.a(list3, "is_like");
                            } else {
                                str3 = null;
                            }
                            boolean areEqual = Intrinsics.areEqual("1", str3);
                            List<FeedKV> list4 = componentFactory.sideway_recom.business_info;
                            if (list4 != null && (a3 = i97.a(list4, "like_status")) != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(a3)) != null) {
                                i = intOrNull.intValue();
                            } else {
                                i = 0;
                            }
                            List<FeedKV> list5 = componentFactory.sideway_recom.business_info;
                            if (list5 == null || (a2 = i97.a(list5, "user_id")) == null) {
                                str4 = "";
                            } else {
                                str4 = a2;
                            }
                            List<FeedKV> list6 = componentFactory.sideway_recom.business_info;
                            if (list6 == null || (a = i97.a(list6, "portrait")) == null) {
                                str5 = "";
                            } else {
                                str5 = a;
                            }
                            list2.add(new sb7(new i57(z57Var, g87Var, g87Var2, str7, new he7(new v77(areEqual, i, str4, str5, c3, c4), null, CardUiStateKt.b(), null, null, 24, null), c2, null, null, 192, null), "recommend_card_person_attention"));
                            i2 = 1;
                        }
                    }
                    t77Var.b = c;
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
                        t67Var = u97.a(feedFeedback, new r67());
                    }
                    return new sb7(new h57(str2, R.color.CAM_X0105, t77Var, t67Var, null, 16, null), "sideway_card");
                }
            }
            return null;
        }
        return (rb7) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xb7
    public void d(Map<String, ? extends yb7> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, map) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.a = map;
        }
    }

    public final e87 c(String str, v57 v57Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, v57Var)) == null) {
            yb7 yb7Var = this.a.get(str);
            if (yb7Var != null) {
                return new e87(yb7Var.getKey(), yb7Var.a(v57Var), new HashMap(), null, null, 24, null);
            }
            return null;
        }
        return (e87) invokeLL.objValue;
    }
}
