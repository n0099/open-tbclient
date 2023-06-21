package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.feed.component.uistate.CardUiStateKt;
import com.baidu.tieba.v77;
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
/* loaded from: classes7.dex */
public final class qq6 implements m67<LayoutFactory>, q87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, ? extends r87> a;

    public qq6() {
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
    @Override // com.baidu.tieba.m67
    /* renamed from: a */
    public o87<?> b(LayoutFactory layoutFactory) {
        InterceptResult invokeL;
        SidewayLayout sidewayLayout;
        boolean z;
        String str;
        String str2;
        SidewayRecomComponent sidewayRecomComponent;
        Integer num;
        i67 i67Var;
        i67 i67Var2;
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
            s57 s57Var = null;
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
                    d57 d57Var = new d57();
                    v77.a aVar = v77.a;
                    List<FeedKV> list2 = layoutFactory.sideway.business_info;
                    Intrinsics.checkNotNullExpressionValue(list2, "originData.sideway.business_info");
                    d57Var.b(aVar.a(list2));
                    h67 d = d("concern_reco_show", d57Var);
                    b67 b67Var = new b67();
                    for (ComponentFactory componentFactory : layoutFactory.sideway.components) {
                        if (Intrinsics.areEqual("sideway_recom", componentFactory.component) && (sidewayRecomComponent = componentFactory.sideway_recom) != null && (num = sidewayRecomComponent.type) != null && num.intValue() == i2) {
                            d57 d57Var2 = new d57();
                            v77.a aVar2 = v77.a;
                            List<FeedKV> list3 = componentFactory.sideway_recom.business_info;
                            Intrinsics.checkNotNullExpressionValue(list3, "data.sideway_recom.business_info");
                            d57Var2.b(aVar2.a(list3));
                            h67 d2 = d("concern_reco_click_head", d57Var2);
                            h67 d3 = d("concern_reco_follow_btn", d57Var2);
                            h67 d4 = d("concern_reco_unfollow_btn", d57Var2);
                            List<o87<?>> list4 = b67Var.a;
                            String str6 = componentFactory.sideway_recom.img_url;
                            Intrinsics.checkNotNullExpressionValue(str6, "data.sideway_recom.img_url");
                            g57 g57Var = new g57(str6, 1, null, null, componentFactory.sideway_recom.corner_url, false);
                            FeedContentText feedContentText = componentFactory.sideway_recom.title;
                            if (feedContentText != null) {
                                i67Var = p67.c(feedContentText);
                            } else {
                                i67Var = null;
                            }
                            FeedContentText feedContentText2 = componentFactory.sideway_recom.desc;
                            if (feedContentText2 != null) {
                                i67Var2 = p67.c(feedContentText2);
                            } else {
                                i67Var2 = null;
                            }
                            SidewayRecomComponent sidewayRecomComponent2 = componentFactory.sideway_recom;
                            String str7 = sidewayRecomComponent2.schema;
                            List<FeedKV> list5 = sidewayRecomComponent2.business_info;
                            if (list5 != null) {
                                str3 = t67.a(list5, "is_like");
                            } else {
                                str3 = null;
                            }
                            boolean areEqual = Intrinsics.areEqual("1", str3);
                            List<FeedKV> list6 = componentFactory.sideway_recom.business_info;
                            if (list6 != null && (a3 = t67.a(list6, "like_status")) != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(a3)) != null) {
                                i = intOrNull.intValue();
                            } else {
                                i = 0;
                            }
                            List<FeedKV> list7 = componentFactory.sideway_recom.business_info;
                            if (list7 == null || (a2 = t67.a(list7, "user_id")) == null) {
                                str4 = "";
                            } else {
                                str4 = a2;
                            }
                            List<FeedKV> list8 = componentFactory.sideway_recom.business_info;
                            if (list8 == null || (a = t67.a(list8, "portrait")) == null) {
                                str5 = "";
                            } else {
                                str5 = a;
                            }
                            list4.add(new p87(new w47(g57Var, i67Var, i67Var2, str7, new ka7(new d67(areEqual, i, str4, str5, d3, d4), null, CardUiStateKt.b(), null, null, 24, null), d2, null, null, 192, null), "recommend_card_person_attention"));
                            i2 = 1;
                        }
                    }
                    b67Var.b = d;
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
                        s57Var = d77.a(feedFeedback, new q57());
                    }
                    return new p87(new v47(str2, R.color.CAM_X0105, b67Var, s57Var, null, 16, null), "sideway_card");
                }
            }
            return null;
        }
        return (o87) invokeL.objValue;
    }

    @Override // com.baidu.tieba.q87
    public void c(Map<String, ? extends r87> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.a = map;
        }
    }

    public final h67 d(String str, d57 d57Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, d57Var)) == null) {
            r87 r87Var = this.a.get(str);
            if (r87Var != null) {
                return new h67(r87Var.getKey(), r87Var.a(d57Var), new HashMap());
            }
            return null;
        }
        return (h67) invokeLL.objValue;
    }
}
