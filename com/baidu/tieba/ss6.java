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
/* loaded from: classes8.dex */
public final class ss6 implements ea7<LayoutFactory>, sc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, ? extends tc7> a;

    public ss6() {
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
    @Override // com.baidu.tieba.ea7
    /* renamed from: a */
    public pc7<?> b(LayoutFactory layoutFactory) {
        InterceptResult invokeL;
        SidewayLayout sidewayLayout;
        boolean z;
        String str;
        String str2;
        SidewayRecomComponent sidewayRecomComponent;
        Integer num;
        y97 y97Var;
        y97 y97Var2;
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
            w87 w87Var = null;
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
                    f87 f87Var = new f87();
                    f87Var.b(ub7.a.a(layoutFactory.sideway.business_info));
                    w97 c = c("concern_reco_show", f87Var);
                    o97 o97Var = new o97();
                    for (ComponentFactory componentFactory : layoutFactory.sideway.components) {
                        if (Intrinsics.areEqual("sideway_recom", componentFactory.component) && (sidewayRecomComponent = componentFactory.sideway_recom) != null && (num = sidewayRecomComponent.type) != null && num.intValue() == i2) {
                            f87 f87Var2 = new f87();
                            f87Var2.b(ub7.a.a(componentFactory.sideway_recom.business_info));
                            w97 c2 = c("concern_reco_click_head", f87Var2);
                            w97 c3 = c("concern_reco_follow_btn", f87Var2);
                            w97 c4 = c("concern_reco_unfollow_btn", f87Var2);
                            List<pc7<?>> list2 = o97Var.a;
                            String str6 = componentFactory.sideway_recom.img_url;
                            Intrinsics.checkNotNullExpressionValue(str6, "data.sideway_recom.img_url");
                            i87 i87Var = new i87(str6, 1, null, null, componentFactory.sideway_recom.corner_url, false, null);
                            FeedContentText feedContentText = componentFactory.sideway_recom.title;
                            if (feedContentText != null) {
                                y97Var = ja7.c(feedContentText);
                            } else {
                                y97Var = null;
                            }
                            FeedContentText feedContentText2 = componentFactory.sideway_recom.desc;
                            if (feedContentText2 != null) {
                                y97Var2 = ja7.c(feedContentText2);
                            } else {
                                y97Var2 = null;
                            }
                            SidewayRecomComponent sidewayRecomComponent2 = componentFactory.sideway_recom;
                            String str7 = sidewayRecomComponent2.schema;
                            List<FeedKV> list3 = sidewayRecomComponent2.business_info;
                            if (list3 != null) {
                                str3 = ma7.a(list3, "is_like");
                            } else {
                                str3 = null;
                            }
                            boolean areEqual = Intrinsics.areEqual("1", str3);
                            List<FeedKV> list4 = componentFactory.sideway_recom.business_info;
                            if (list4 != null && (a3 = ma7.a(list4, "like_status")) != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(a3)) != null) {
                                i = intOrNull.intValue();
                            } else {
                                i = 0;
                            }
                            List<FeedKV> list5 = componentFactory.sideway_recom.business_info;
                            if (list5 == null || (a2 = ma7.a(list5, "user_id")) == null) {
                                str4 = "";
                            } else {
                                str4 = a2;
                            }
                            List<FeedKV> list6 = componentFactory.sideway_recom.business_info;
                            if (list6 == null || (a = ma7.a(list6, "portrait")) == null) {
                                str5 = "";
                            } else {
                                str5 = a;
                            }
                            list2.add(new qc7(new x77(i87Var, y97Var, y97Var2, str7, new ze7(new q97(areEqual, i, str4, str5, c3, c4), null, CardUiStateKt.b(), null, null, 24, null), c2, null, null, 192, null), "recommend_card_person_attention"));
                            i2 = 1;
                        }
                    }
                    o97Var.b = c;
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
                        w87Var = za7.a(feedFeedback, new u87());
                    }
                    return new qc7(new w77(str2, R.color.CAM_X0105, o97Var, w87Var, null, 16, null), "sideway_card");
                }
            }
            return null;
        }
        return (pc7) invokeL.objValue;
    }

    @Override // com.baidu.tieba.sc7
    public void d(Map<String, ? extends tc7> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, map) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.a = map;
        }
    }

    public final w97 c(String str, f87 f87Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, f87Var)) == null) {
            tc7 tc7Var = this.a.get(str);
            if (tc7Var != null) {
                return new w97(tc7Var.getKey(), tc7Var.a(f87Var), new HashMap(), null, null, 24, null);
            }
            return null;
        }
        return (w97) invokeLL.objValue;
    }
}
