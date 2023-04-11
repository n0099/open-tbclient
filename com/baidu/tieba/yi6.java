package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.feed.component.uistate.CardUiStateKt;
import com.baidu.tieba.iz6;
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
public final class yi6 implements zx6<LayoutFactory>, d07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, ? extends e07> a;

    public yi6() {
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
    @Override // com.baidu.tieba.zx6
    /* renamed from: a */
    public b07<?> b(LayoutFactory layoutFactory) {
        InterceptResult invokeL;
        SidewayLayout sidewayLayout;
        boolean z;
        String str;
        String str2;
        SidewayRecomComponent sidewayRecomComponent;
        Integer num;
        vx6 vx6Var;
        vx6 vx6Var2;
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
            fx6 fx6Var = null;
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
                    qw6 qw6Var = new qw6();
                    iz6.a aVar = iz6.a;
                    List<FeedKV> list2 = layoutFactory.sideway.business_info;
                    Intrinsics.checkNotNullExpressionValue(list2, "originData.sideway.business_info");
                    qw6Var.b(aVar.a(list2));
                    ux6 d = d("concern_reco_show", qw6Var);
                    ox6 ox6Var = new ox6();
                    for (ComponentFactory componentFactory : layoutFactory.sideway.components) {
                        if (Intrinsics.areEqual("sideway_recom", componentFactory.component) && (sidewayRecomComponent = componentFactory.sideway_recom) != null && (num = sidewayRecomComponent.type) != null && num.intValue() == i2) {
                            qw6 qw6Var2 = new qw6();
                            iz6.a aVar2 = iz6.a;
                            List<FeedKV> list3 = componentFactory.sideway_recom.business_info;
                            Intrinsics.checkNotNullExpressionValue(list3, "data.sideway_recom.business_info");
                            qw6Var2.b(aVar2.a(list3));
                            ux6 d2 = d("concern_reco_click_head", qw6Var2);
                            ux6 d3 = d("concern_reco_follow_btn", qw6Var2);
                            ux6 d4 = d("concern_reco_unfollow_btn", qw6Var2);
                            List<b07<?>> list4 = ox6Var.a;
                            String str6 = componentFactory.sideway_recom.img_url;
                            Intrinsics.checkNotNullExpressionValue(str6, "data.sideway_recom.img_url");
                            tw6 tw6Var = new tw6(str6, 1, null, null, componentFactory.sideway_recom.corner_url, false);
                            FeedContentText feedContentText = componentFactory.sideway_recom.title;
                            if (feedContentText != null) {
                                vx6Var = cy6.c(feedContentText);
                            } else {
                                vx6Var = null;
                            }
                            FeedContentText feedContentText2 = componentFactory.sideway_recom.desc;
                            if (feedContentText2 != null) {
                                vx6Var2 = cy6.c(feedContentText2);
                            } else {
                                vx6Var2 = null;
                            }
                            SidewayRecomComponent sidewayRecomComponent2 = componentFactory.sideway_recom;
                            String str7 = sidewayRecomComponent2.schema;
                            List<FeedKV> list5 = sidewayRecomComponent2.business_info;
                            if (list5 != null) {
                                str3 = gy6.a(list5, "is_like");
                            } else {
                                str3 = null;
                            }
                            boolean areEqual = Intrinsics.areEqual("1", str3);
                            List<FeedKV> list6 = componentFactory.sideway_recom.business_info;
                            if (list6 != null && (a3 = gy6.a(list6, "like_status")) != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(a3)) != null) {
                                i = intOrNull.intValue();
                            } else {
                                i = 0;
                            }
                            List<FeedKV> list7 = componentFactory.sideway_recom.business_info;
                            if (list7 == null || (a2 = gy6.a(list7, "user_id")) == null) {
                                str4 = "";
                            } else {
                                str4 = a2;
                            }
                            List<FeedKV> list8 = componentFactory.sideway_recom.business_info;
                            if (list8 == null || (a = gy6.a(list8, "portrait")) == null) {
                                str5 = "";
                            } else {
                                str5 = a;
                            }
                            list4.add(new c07(new jw6(tw6Var, vx6Var, vx6Var2, str7, new x17(new qx6(areEqual, i, str4, str5, d3, d4), null, CardUiStateKt.b(), null, null, 24, null), d2, null, null, 192, null), "recommend_card_person_attention"));
                            i2 = 1;
                        }
                    }
                    ox6Var.b = d;
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
                        fx6Var = qy6.a(feedFeedback, new dx6());
                    }
                    return new c07(new iw6(str2, R.color.CAM_X0105, ox6Var, fx6Var, null, 16, null), "sideway_card");
                }
            }
            return null;
        }
        return (b07) invokeL.objValue;
    }

    @Override // com.baidu.tieba.d07
    public void c(Map<String, ? extends e07> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.a = map;
        }
    }

    public final ux6 d(String str, qw6 qw6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, qw6Var)) == null) {
            e07 e07Var = this.a.get(str);
            if (e07Var != null) {
                return new ux6(e07Var.getKey(), e07Var.a(qw6Var), new HashMap());
            }
            return null;
        }
        return (ux6) invokeLL.objValue;
    }
}
