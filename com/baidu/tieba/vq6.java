package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a87;
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
/* loaded from: classes8.dex */
public final class vq6 implements r67<LayoutFactory>, v87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, ? extends w87> a;

    public vq6() {
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
    @Override // com.baidu.tieba.r67
    /* renamed from: a */
    public t87<?> b(LayoutFactory layoutFactory) {
        InterceptResult invokeL;
        SidewayLayout sidewayLayout;
        boolean z;
        String str;
        String str2;
        SidewayRecomComponent sidewayRecomComponent;
        Integer num;
        n67 n67Var;
        n67 n67Var2;
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
            x57 x57Var = null;
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
                    i57 i57Var = new i57();
                    a87.a aVar = a87.a;
                    List<FeedKV> list2 = layoutFactory.sideway.business_info;
                    Intrinsics.checkNotNullExpressionValue(list2, "originData.sideway.business_info");
                    i57Var.b(aVar.a(list2));
                    m67 d = d("concern_reco_show", i57Var);
                    g67 g67Var = new g67();
                    for (ComponentFactory componentFactory : layoutFactory.sideway.components) {
                        if (Intrinsics.areEqual("sideway_recom", componentFactory.component) && (sidewayRecomComponent = componentFactory.sideway_recom) != null && (num = sidewayRecomComponent.type) != null && num.intValue() == i2) {
                            i57 i57Var2 = new i57();
                            a87.a aVar2 = a87.a;
                            List<FeedKV> list3 = componentFactory.sideway_recom.business_info;
                            Intrinsics.checkNotNullExpressionValue(list3, "data.sideway_recom.business_info");
                            i57Var2.b(aVar2.a(list3));
                            m67 d2 = d("concern_reco_click_head", i57Var2);
                            m67 d3 = d("concern_reco_follow_btn", i57Var2);
                            m67 d4 = d("concern_reco_unfollow_btn", i57Var2);
                            List<t87<?>> list4 = g67Var.a;
                            String str6 = componentFactory.sideway_recom.img_url;
                            Intrinsics.checkNotNullExpressionValue(str6, "data.sideway_recom.img_url");
                            l57 l57Var = new l57(str6, 1, null, null, componentFactory.sideway_recom.corner_url, false);
                            FeedContentText feedContentText = componentFactory.sideway_recom.title;
                            if (feedContentText != null) {
                                n67Var = u67.c(feedContentText);
                            } else {
                                n67Var = null;
                            }
                            FeedContentText feedContentText2 = componentFactory.sideway_recom.desc;
                            if (feedContentText2 != null) {
                                n67Var2 = u67.c(feedContentText2);
                            } else {
                                n67Var2 = null;
                            }
                            SidewayRecomComponent sidewayRecomComponent2 = componentFactory.sideway_recom;
                            String str7 = sidewayRecomComponent2.schema;
                            List<FeedKV> list5 = sidewayRecomComponent2.business_info;
                            if (list5 != null) {
                                str3 = y67.a(list5, "is_like");
                            } else {
                                str3 = null;
                            }
                            boolean areEqual = Intrinsics.areEqual("1", str3);
                            List<FeedKV> list6 = componentFactory.sideway_recom.business_info;
                            if (list6 != null && (a3 = y67.a(list6, "like_status")) != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(a3)) != null) {
                                i = intOrNull.intValue();
                            } else {
                                i = 0;
                            }
                            List<FeedKV> list7 = componentFactory.sideway_recom.business_info;
                            if (list7 == null || (a2 = y67.a(list7, "user_id")) == null) {
                                str4 = "";
                            } else {
                                str4 = a2;
                            }
                            List<FeedKV> list8 = componentFactory.sideway_recom.business_info;
                            if (list8 == null || (a = y67.a(list8, "portrait")) == null) {
                                str5 = "";
                            } else {
                                str5 = a;
                            }
                            list4.add(new u87(new b57(l57Var, n67Var, n67Var2, str7, new pa7(new i67(areEqual, i, str4, str5, d3, d4), null, CardUiStateKt.b(), null, null, 24, null), d2, null, null, 192, null), "recommend_card_person_attention"));
                            i2 = 1;
                        }
                    }
                    g67Var.b = d;
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
                        x57Var = i77.a(feedFeedback, new v57());
                    }
                    return new u87(new a57(str2, R.color.CAM_X0105, g67Var, x57Var, null, 16, null), "sideway_card");
                }
            }
            return null;
        }
        return (t87) invokeL.objValue;
    }

    @Override // com.baidu.tieba.v87
    public void c(Map<String, ? extends w87> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.a = map;
        }
    }

    public final m67 d(String str, i57 i57Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, i57Var)) == null) {
            w87 w87Var = this.a.get(str);
            if (w87Var != null) {
                return new m67(w87Var.getKey(), w87Var.a(i57Var), new HashMap());
            }
            return null;
        }
        return (m67) invokeLL.objValue;
    }
}
