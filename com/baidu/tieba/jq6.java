package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.feed.component.uistate.CardUiStateKt;
import com.baidu.tieba.o77;
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
/* loaded from: classes6.dex */
public final class jq6 implements f67<LayoutFactory>, j87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, ? extends k87> a;

    public jq6() {
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
    @Override // com.baidu.tieba.f67
    /* renamed from: a */
    public h87<?> b(LayoutFactory layoutFactory) {
        InterceptResult invokeL;
        SidewayLayout sidewayLayout;
        boolean z;
        String str;
        String str2;
        SidewayRecomComponent sidewayRecomComponent;
        Integer num;
        b67 b67Var;
        b67 b67Var2;
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
            l57 l57Var = null;
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
                    w47 w47Var = new w47();
                    o77.a aVar = o77.a;
                    List<FeedKV> list2 = layoutFactory.sideway.business_info;
                    Intrinsics.checkNotNullExpressionValue(list2, "originData.sideway.business_info");
                    w47Var.b(aVar.a(list2));
                    a67 d = d("concern_reco_show", w47Var);
                    u57 u57Var = new u57();
                    for (ComponentFactory componentFactory : layoutFactory.sideway.components) {
                        if (Intrinsics.areEqual("sideway_recom", componentFactory.component) && (sidewayRecomComponent = componentFactory.sideway_recom) != null && (num = sidewayRecomComponent.type) != null && num.intValue() == i2) {
                            w47 w47Var2 = new w47();
                            o77.a aVar2 = o77.a;
                            List<FeedKV> list3 = componentFactory.sideway_recom.business_info;
                            Intrinsics.checkNotNullExpressionValue(list3, "data.sideway_recom.business_info");
                            w47Var2.b(aVar2.a(list3));
                            a67 d2 = d("concern_reco_click_head", w47Var2);
                            a67 d3 = d("concern_reco_follow_btn", w47Var2);
                            a67 d4 = d("concern_reco_unfollow_btn", w47Var2);
                            List<h87<?>> list4 = u57Var.a;
                            String str6 = componentFactory.sideway_recom.img_url;
                            Intrinsics.checkNotNullExpressionValue(str6, "data.sideway_recom.img_url");
                            z47 z47Var = new z47(str6, 1, null, null, componentFactory.sideway_recom.corner_url, false);
                            FeedContentText feedContentText = componentFactory.sideway_recom.title;
                            if (feedContentText != null) {
                                b67Var = i67.c(feedContentText);
                            } else {
                                b67Var = null;
                            }
                            FeedContentText feedContentText2 = componentFactory.sideway_recom.desc;
                            if (feedContentText2 != null) {
                                b67Var2 = i67.c(feedContentText2);
                            } else {
                                b67Var2 = null;
                            }
                            SidewayRecomComponent sidewayRecomComponent2 = componentFactory.sideway_recom;
                            String str7 = sidewayRecomComponent2.schema;
                            List<FeedKV> list5 = sidewayRecomComponent2.business_info;
                            if (list5 != null) {
                                str3 = m67.a(list5, "is_like");
                            } else {
                                str3 = null;
                            }
                            boolean areEqual = Intrinsics.areEqual("1", str3);
                            List<FeedKV> list6 = componentFactory.sideway_recom.business_info;
                            if (list6 != null && (a3 = m67.a(list6, "like_status")) != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(a3)) != null) {
                                i = intOrNull.intValue();
                            } else {
                                i = 0;
                            }
                            List<FeedKV> list7 = componentFactory.sideway_recom.business_info;
                            if (list7 == null || (a2 = m67.a(list7, "user_id")) == null) {
                                str4 = "";
                            } else {
                                str4 = a2;
                            }
                            List<FeedKV> list8 = componentFactory.sideway_recom.business_info;
                            if (list8 == null || (a = m67.a(list8, "portrait")) == null) {
                                str5 = "";
                            } else {
                                str5 = a;
                            }
                            list4.add(new i87(new p47(z47Var, b67Var, b67Var2, str7, new da7(new w57(areEqual, i, str4, str5, d3, d4), null, CardUiStateKt.b(), null, null, 24, null), d2, null, null, 192, null), "recommend_card_person_attention"));
                            i2 = 1;
                        }
                    }
                    u57Var.b = d;
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
                        l57Var = w67.a(feedFeedback, new j57());
                    }
                    return new i87(new o47(str2, R.color.CAM_X0105, u57Var, l57Var, null, 16, null), "sideway_card");
                }
            }
            return null;
        }
        return (h87) invokeL.objValue;
    }

    @Override // com.baidu.tieba.j87
    public void c(Map<String, ? extends k87> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.a = map;
        }
    }

    public final a67 d(String str, w47 w47Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, w47Var)) == null) {
            k87 k87Var = this.a.get(str);
            if (k87Var != null) {
                return new a67(k87Var.getKey(), k87Var.a(w47Var), new HashMap());
            }
            return null;
        }
        return (a67) invokeLL.objValue;
    }
}
