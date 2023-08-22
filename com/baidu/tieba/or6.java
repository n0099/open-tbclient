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
/* loaded from: classes7.dex */
public final class or6 implements z87<LayoutFactory>, mb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, ? extends nb7> a;

    public or6() {
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
    @Override // com.baidu.tieba.z87
    /* renamed from: a */
    public jb7<?> b(LayoutFactory layoutFactory) {
        InterceptResult invokeL;
        SidewayLayout sidewayLayout;
        boolean z;
        String str;
        String str2;
        SidewayRecomComponent sidewayRecomComponent;
        Integer num;
        t87 t87Var;
        t87 t87Var2;
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
            r77 r77Var = null;
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
                    a77 a77Var = new a77();
                    a77Var.b(oa7.a.a(layoutFactory.sideway.business_info));
                    r87 c = c("concern_reco_show", a77Var);
                    j87 j87Var = new j87();
                    for (ComponentFactory componentFactory : layoutFactory.sideway.components) {
                        if (Intrinsics.areEqual("sideway_recom", componentFactory.component) && (sidewayRecomComponent = componentFactory.sideway_recom) != null && (num = sidewayRecomComponent.type) != null && num.intValue() == i2) {
                            a77 a77Var2 = new a77();
                            a77Var2.b(oa7.a.a(componentFactory.sideway_recom.business_info));
                            r87 c2 = c("concern_reco_click_head", a77Var2);
                            r87 c3 = c("concern_reco_follow_btn", a77Var2);
                            r87 c4 = c("concern_reco_unfollow_btn", a77Var2);
                            List<jb7<?>> list2 = j87Var.a;
                            String str6 = componentFactory.sideway_recom.img_url;
                            Intrinsics.checkNotNullExpressionValue(str6, "data.sideway_recom.img_url");
                            d77 d77Var = new d77(str6, 1, null, null, componentFactory.sideway_recom.corner_url, false, null);
                            FeedContentText feedContentText = componentFactory.sideway_recom.title;
                            if (feedContentText != null) {
                                t87Var = e97.c(feedContentText);
                            } else {
                                t87Var = null;
                            }
                            FeedContentText feedContentText2 = componentFactory.sideway_recom.desc;
                            if (feedContentText2 != null) {
                                t87Var2 = e97.c(feedContentText2);
                            } else {
                                t87Var2 = null;
                            }
                            SidewayRecomComponent sidewayRecomComponent2 = componentFactory.sideway_recom;
                            String str7 = sidewayRecomComponent2.schema;
                            List<FeedKV> list3 = sidewayRecomComponent2.business_info;
                            if (list3 != null) {
                                str3 = h97.a(list3, "is_like");
                            } else {
                                str3 = null;
                            }
                            boolean areEqual = Intrinsics.areEqual("1", str3);
                            List<FeedKV> list4 = componentFactory.sideway_recom.business_info;
                            if (list4 != null && (a3 = h97.a(list4, "like_status")) != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(a3)) != null) {
                                i = intOrNull.intValue();
                            } else {
                                i = 0;
                            }
                            List<FeedKV> list5 = componentFactory.sideway_recom.business_info;
                            if (list5 == null || (a2 = h97.a(list5, "user_id")) == null) {
                                str4 = "";
                            } else {
                                str4 = a2;
                            }
                            List<FeedKV> list6 = componentFactory.sideway_recom.business_info;
                            if (list6 == null || (a = h97.a(list6, "portrait")) == null) {
                                str5 = "";
                            } else {
                                str5 = a;
                            }
                            list2.add(new kb7(new s67(d77Var, t87Var, t87Var2, str7, new sd7(new l87(areEqual, i, str4, str5, c3, c4), null, CardUiStateKt.b(), null, null, 24, null), c2, null, null, 192, null), "recommend_card_person_attention"));
                            i2 = 1;
                        }
                    }
                    j87Var.b = c;
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
                        r77Var = t97.a(feedFeedback, new p77());
                    }
                    return new kb7(new r67(str2, R.color.CAM_X0105, j87Var, r77Var, null, 16, null), "sideway_card");
                }
            }
            return null;
        }
        return (jb7) invokeL.objValue;
    }

    @Override // com.baidu.tieba.mb7
    public void d(Map<String, ? extends nb7> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, map) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.a = map;
        }
    }

    public final r87 c(String str, a77 a77Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, a77Var)) == null) {
            nb7 nb7Var = this.a.get(str);
            if (nb7Var != null) {
                return new r87(nb7Var.getKey(), nb7Var.a(a77Var), new HashMap(), null, null, 24, null);
            }
            return null;
        }
        return (r87) invokeLL.objValue;
    }
}
