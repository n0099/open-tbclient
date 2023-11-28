package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tieba.feed.data.protobuf.FeedHeadExtensionKt;
import com.baidu.tieba.feed.data.protobuf.FeedPollExtensionKt;
import com.baidu.tieba.feed.data.protobuf.FeedSocialExtensionKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.AbstractComponent;
import tbclient.ComponentFactory;
import tbclient.FeedEntrybarComponent;
import tbclient.FeedFeedback;
import tbclient.FeedHeadComponent;
import tbclient.FeedHeadFigureComponent;
import tbclient.FeedItem;
import tbclient.FeedKV;
import tbclient.FeedLayout;
import tbclient.FeedLinkComponent;
import tbclient.FeedLiveComponent;
import tbclient.FeedOriginComponent;
import tbclient.FeedPicComponent;
import tbclient.FeedPostExpose;
import tbclient.FeedRoomComponent;
import tbclient.FeedSocialComponent;
import tbclient.FeedVideoAdComponent;
import tbclient.FeedVideoComponent;
import tbclient.LayoutFactory;
import tbclient.PollInfo;
import tbclient.ThreadRecommendInfo;
import tbclient.TitleComponent;
import tbclient.Voice;
/* loaded from: classes7.dex */
public abstract class q87 implements w87<LayoutFactory>, tb7, qa7, d77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, ? extends ub7> a;
    public Map<String, String> b;
    public boolean c;
    public final Set<s87> d;

    public Object e(String key, String value) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, key, value)) == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            return null;
        }
        return invokeLL.objValue;
    }

    public abstract nb7<?> h(s57<?> s57Var, n67 n67Var);

    public q87() {
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
        this.b = new HashMap();
        this.d = new LinkedHashSet();
    }

    @Override // com.baidu.tieba.qa7
    public void a(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.b = map;
        }
    }

    @Override // com.baidu.tieba.d77
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.c = z;
        }
    }

    @Override // com.baidu.tieba.tb7
    public void d(Map<String, ? extends ub7> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, map) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.a = map;
        }
    }

    public final Map<String, Object> f(List<FeedKV> list) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (FeedKV feedKV : list) {
                String str = feedKV.key;
                if (str != null && str.length() != 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    String str2 = feedKV.value;
                    if (str2 != null && str2.length() != 0) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (!z3) {
                        String str3 = feedKV.key;
                        Intrinsics.checkNotNullExpressionValue(str3, "info.key");
                        String str4 = feedKV.value;
                        Intrinsics.checkNotNullExpressionValue(str4, "info.value");
                        Object e = e(str3, str4);
                        if (e != null) {
                            String str5 = feedKV.key;
                            Intrinsics.checkNotNullExpressionValue(str5, "info.key");
                            linkedHashMap.put(str5, e);
                        }
                    }
                }
            }
            return linkedHashMap;
        }
        return (Map) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:160:0x0284 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:92:0x01a6 */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r3v49, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r3v50, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r3v53, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r5v4, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r5v5, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r5v6, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:143:0x026d  */
    @Override // com.baidu.tieba.w87
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public nb7<?> b(LayoutFactory originData) {
        InterceptResult invokeL;
        p67 p67Var;
        r57 r57Var;
        ComponentFactory componentFactory;
        String str;
        FeedHeadComponent feedHeadComponent;
        FeedItem feedItem;
        FeedLinkComponent feedLinkComponent;
        FeedLiveComponent feedLiveComponent;
        PollInfo pollInfo;
        FeedRoomComponent feedRoomComponent;
        AbstractComponent abstractComponent;
        String str2;
        FeedEntrybarComponent feedEntrybarComponent;
        FeedPostExpose feedPostExpose;
        FeedPicComponent feedPicComponent;
        List<ThreadRecommendInfo> list;
        ThreadRecommendInfo threadRecommendInfo;
        String str3;
        Voice voice;
        FeedOriginComponent feedOriginComponent;
        FeedSocialComponent feedSocialComponent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, originData)) == null) {
            Intrinsics.checkNotNullParameter(originData, "originData");
            List<nb7<? extends Object>> arrayList = new ArrayList<>();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            n67 n67Var = new n67();
            n67Var.h(this.a);
            FeedLayout feedLayout = originData.feed;
            Intrinsics.checkNotNullExpressionValue(feedLayout, "originData.feed");
            o67.b(n67Var, feedLayout);
            n67Var.g(this.b);
            n67Var.f(this.c);
            i87 i87Var = new i87();
            ThemeCardInUserData b = u97.b(n67Var.a().a().get("theme_card"));
            FeedFeedback feedFeedback = originData.feed.feedback;
            r57 r57Var2 = null;
            if (feedFeedback != null) {
                p67Var = q97.a(feedFeedback, n67Var);
            } else {
                p67Var = null;
            }
            for (ComponentFactory componentFactory2 : originData.feed.components) {
                String str4 = componentFactory2.component;
                if (str4 != null) {
                    switch (str4.hashCode()) {
                        case -1644137503:
                            r57Var = r57Var2;
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_head") && (feedHeadComponent = componentFactory.feed_head) != null) {
                                FeedHeadExtensionKt.h(feedHeadComponent, arrayList, p67Var, FeedHeadExtensionKt.c(originData.feed.business_info), n67Var, u97.a(b));
                                break;
                            }
                            break;
                        case -1644093164:
                            r57Var = r57Var2;
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_item") && (feedItem = componentFactory.feed_item) != null) {
                                d97.c(feedItem, arrayList, n67Var);
                                break;
                            }
                            break;
                        case -1644014085:
                            r57Var = r57Var2;
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_link") && (feedLinkComponent = componentFactory.feed_link) != null) {
                                f97.a(feedLinkComponent, arrayList);
                                break;
                            }
                            break;
                        case -1644013843:
                            r57Var = r57Var2;
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_live") && (feedLiveComponent = componentFactory.feed_live) != null) {
                                g97.a(feedLiveComponent, arrayList, n67Var);
                                break;
                            }
                            break;
                        case -1643889216:
                            r57Var = r57Var2;
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_poll") && (pollInfo = componentFactory.feed_poll) != null) {
                                String str5 = originData.feed.schema;
                                Intrinsics.checkNotNullExpressionValue(str5, "originData.feed.schema");
                                FeedPollExtensionKt.a(pollInfo, arrayList, n67Var, str5);
                                break;
                            }
                            break;
                        case -1643829540:
                            r57Var = r57Var2;
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_room") && (feedRoomComponent = componentFactory.feed_room) != null) {
                                i97.a(feedRoomComponent, arrayList, n67Var);
                                break;
                            }
                            break;
                        case -1461408349:
                            r57Var = r57Var2;
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_abstract") && (abstractComponent = componentFactory.feed_abstract) != null) {
                                a97.b(abstractComponent, arrayList, spannableStringBuilder, n67Var);
                                break;
                            }
                            break;
                        case -1035731907:
                            r57Var = r57Var2;
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_videoad")) {
                                FeedVideoComponent feedVideoComponent = componentFactory.feed_video;
                                if (feedVideoComponent != null) {
                                    str2 = feedVideoComponent.schema;
                                } else {
                                    str2 = r57Var;
                                }
                                if (str2 == 0) {
                                    str2 = "";
                                }
                                i87Var.j(o97.a(str2, n67Var));
                                FeedVideoAdComponent feedVideoAdComponent = componentFactory.feed_videoad;
                                if (feedVideoAdComponent != null) {
                                    n97.b(feedVideoAdComponent, arrayList, i87Var, n67Var);
                                    break;
                                }
                            }
                            break;
                        case -993000478:
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_entrybar") && (feedEntrybarComponent = componentFactory.feed_entrybar) != null) {
                                r57Var = null;
                                c97.a(feedEntrybarComponent, arrayList, o67.e(n67Var, "enter_forum_btn_click", null, 2, null));
                                break;
                            }
                            r57Var = null;
                            break;
                        case -984476251:
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_postexpose") && (feedPostExpose = componentFactory.feed_postexpose) != null) {
                                k97.a(feedPostExpose, arrayList, n67Var);
                            }
                            r57Var = null;
                            break;
                        case -191576215:
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_pic") && (feedPicComponent = componentFactory.feed_pic) != null) {
                                j97.c(feedPicComponent, arrayList, n67Var);
                            }
                            r57Var = null;
                            break;
                        case 301292525:
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_recomtag") && (list = componentFactory.feed_recomtag) != null && (threadRecommendInfo = (ThreadRecommendInfo) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list)) != null) {
                                t97.a(threadRecommendInfo, arrayList, n67Var);
                            }
                            r57Var = null;
                            break;
                        case 582564983:
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_title")) {
                                List<ComponentFactory> list2 = originData.feed.components;
                                Intrinsics.checkNotNullExpressionValue(list2, "originData.feed.components");
                                boolean a = sa7.a(list2);
                                TitleComponent titleComponent = componentFactory.feed_title;
                                if (titleComponent != null) {
                                    m97.b(titleComponent, arrayList, spannableStringBuilder, n67Var, a);
                                }
                            }
                            r57Var = null;
                            break;
                        case 584396442:
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_video")) {
                                FeedVideoComponent feedVideoComponent2 = componentFactory.feed_video;
                                if (feedVideoComponent2 != null) {
                                    str3 = feedVideoComponent2.schema;
                                } else {
                                    str3 = null;
                                }
                                if (str3 == null) {
                                    str3 = "";
                                }
                                i87Var.j(o97.a(str3, n67Var));
                                FeedVideoComponent feedVideoComponent3 = componentFactory.feed_video;
                                if (feedVideoComponent3 != null) {
                                    o97.c(feedVideoComponent3, arrayList, i87Var, n67Var);
                                }
                            }
                            r57Var = null;
                            break;
                        case 584579921:
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_voice") && (voice = componentFactory.feed_voice) != null) {
                                p97.a(voice, arrayList, n67Var);
                            }
                            r57Var = null;
                            break;
                        case 744478951:
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_origin") && (feedOriginComponent = componentFactory.feed_origin) != null) {
                                h97.a(feedOriginComponent, arrayList, n67Var);
                            }
                            r57Var = null;
                            break;
                        case 856047918:
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_social") && (feedSocialComponent = componentFactory.feed_social) != null) {
                                FeedSocialExtensionKt.a(feedSocialComponent, arrayList, n67Var, i87Var);
                            }
                            r57Var = null;
                            break;
                        case 1804018946:
                            if (str4.equals("feed_head_figure")) {
                                FeedHeadFigureComponent feedHeadFigureComponent = componentFactory2.feed_head_figure;
                                if (feedHeadFigureComponent != null) {
                                    componentFactory = componentFactory2;
                                    FeedHeadExtensionKt.i(feedHeadFigureComponent, arrayList, o67.e(n67Var, "virtual_head_show", r57Var2, 2, r57Var2), o67.e(n67Var, "virtual_head_click", r57Var2, 2, r57Var2), p67Var, u97.a(b), o67.f(n67Var, "head_local_stat_info"), n67Var);
                                } else {
                                    componentFactory = componentFactory2;
                                }
                                r57Var = null;
                                break;
                            }
                        default:
                            r57Var = r57Var2;
                            componentFactory = componentFactory2;
                            break;
                    }
                    for (s87 s87Var : this.d) {
                        Intrinsics.checkNotNullExpressionValue(componentFactory, "componentFactory");
                        FeedLayout feedLayout2 = originData.feed;
                        if (feedLayout2 != null) {
                            str = feedLayout2.schema;
                        } else {
                            str = r57Var;
                        }
                        if (str == 0) {
                            str = "";
                        }
                        s87Var.a(componentFactory, arrayList, n67Var, str);
                    }
                    r57Var2 = r57Var;
                }
                r57Var = r57Var2;
                componentFactory = componentFactory2;
                while (r3.hasNext()) {
                }
                r57Var2 = r57Var;
            }
            String schema = originData.feed.schema;
            boolean areEqual = Intrinsics.areEqual(n67Var.a().a().get("is_grey_mode"), "1");
            String str6 = n67Var.a().a().get("thread_id");
            Map<String, Object> f = f(originData.feed.appendix);
            Intrinsics.checkNotNullExpressionValue(schema, "schema");
            return h(new s57<>(arrayList, schema, areEqual, Intrinsics.areEqual(n67Var.a().a().get("can_multi_manage"), "1"), str6, n67Var.a().a().get("user_id"), b, p67Var, f, n67Var, null, null, n61.a, null), n67Var);
        }
        return (nb7) invokeL.objValue;
    }

    public final Set<s87> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.d;
        }
        return (Set) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a = MapsKt__MapsKt.emptyMap();
            this.b = MapsKt__MapsKt.emptyMap();
            this.c = false;
        }
    }
}
