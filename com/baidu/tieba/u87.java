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
/* loaded from: classes8.dex */
public abstract class u87 implements a97<LayoutFactory>, yb7, va7, h77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, ? extends zb7> a;
    public Map<String, String> b;
    public boolean c;
    public final Set<w87> d;

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

    public abstract sb7<?> h(w57<?> w57Var, r67 r67Var);

    public u87() {
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

    @Override // com.baidu.tieba.va7
    public void a(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.b = map;
        }
    }

    @Override // com.baidu.tieba.h77
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.c = z;
        }
    }

    @Override // com.baidu.tieba.yb7
    public void d(Map<String, ? extends zb7> map) {
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
    @Override // com.baidu.tieba.a97
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public sb7<?> b(LayoutFactory originData) {
        InterceptResult invokeL;
        t67 t67Var;
        v57 v57Var;
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
            List<sb7<? extends Object>> arrayList = new ArrayList<>();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            r67 r67Var = new r67();
            r67Var.h(this.a);
            FeedLayout feedLayout = originData.feed;
            Intrinsics.checkNotNullExpressionValue(feedLayout, "originData.feed");
            s67.b(r67Var, feedLayout);
            r67Var.g(this.b);
            r67Var.f(this.c);
            m87 m87Var = new m87();
            ThemeCardInUserData b = y97.b(r67Var.a().a().get("theme_card"));
            FeedFeedback feedFeedback = originData.feed.feedback;
            v57 v57Var2 = null;
            if (feedFeedback != null) {
                t67Var = u97.a(feedFeedback, r67Var);
            } else {
                t67Var = null;
            }
            for (ComponentFactory componentFactory2 : originData.feed.components) {
                String str4 = componentFactory2.component;
                if (str4 != null) {
                    switch (str4.hashCode()) {
                        case -1644137503:
                            v57Var = v57Var2;
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_head") && (feedHeadComponent = componentFactory.feed_head) != null) {
                                FeedHeadExtensionKt.h(feedHeadComponent, arrayList, t67Var, FeedHeadExtensionKt.c(originData.feed.business_info), r67Var, y97.a(b));
                                break;
                            }
                            break;
                        case -1644093164:
                            v57Var = v57Var2;
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_item") && (feedItem = componentFactory.feed_item) != null) {
                                h97.c(feedItem, arrayList, r67Var);
                                break;
                            }
                            break;
                        case -1644014085:
                            v57Var = v57Var2;
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_link") && (feedLinkComponent = componentFactory.feed_link) != null) {
                                j97.a(feedLinkComponent, arrayList);
                                break;
                            }
                            break;
                        case -1644013843:
                            v57Var = v57Var2;
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_live") && (feedLiveComponent = componentFactory.feed_live) != null) {
                                k97.a(feedLiveComponent, arrayList, r67Var);
                                break;
                            }
                            break;
                        case -1643889216:
                            v57Var = v57Var2;
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_poll") && (pollInfo = componentFactory.feed_poll) != null) {
                                String str5 = originData.feed.schema;
                                Intrinsics.checkNotNullExpressionValue(str5, "originData.feed.schema");
                                FeedPollExtensionKt.a(pollInfo, arrayList, r67Var, str5);
                                break;
                            }
                            break;
                        case -1643829540:
                            v57Var = v57Var2;
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_room") && (feedRoomComponent = componentFactory.feed_room) != null) {
                                m97.a(feedRoomComponent, arrayList, r67Var);
                                break;
                            }
                            break;
                        case -1461408349:
                            v57Var = v57Var2;
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_abstract") && (abstractComponent = componentFactory.feed_abstract) != null) {
                                e97.b(abstractComponent, arrayList, spannableStringBuilder, r67Var);
                                break;
                            }
                            break;
                        case -1035731907:
                            v57Var = v57Var2;
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_videoad")) {
                                FeedVideoComponent feedVideoComponent = componentFactory.feed_video;
                                if (feedVideoComponent != null) {
                                    str2 = feedVideoComponent.schema;
                                } else {
                                    str2 = v57Var;
                                }
                                if (str2 == 0) {
                                    str2 = "";
                                }
                                m87Var.j(s97.a(str2, r67Var));
                                FeedVideoAdComponent feedVideoAdComponent = componentFactory.feed_videoad;
                                if (feedVideoAdComponent != null) {
                                    r97.b(feedVideoAdComponent, arrayList, m87Var, r67Var);
                                    break;
                                }
                            }
                            break;
                        case -993000478:
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_entrybar") && (feedEntrybarComponent = componentFactory.feed_entrybar) != null) {
                                v57Var = null;
                                g97.a(feedEntrybarComponent, arrayList, s67.e(r67Var, "enter_forum_btn_click", null, 2, null));
                                break;
                            }
                            v57Var = null;
                            break;
                        case -984476251:
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_postexpose") && (feedPostExpose = componentFactory.feed_postexpose) != null) {
                                o97.a(feedPostExpose, arrayList, r67Var);
                            }
                            v57Var = null;
                            break;
                        case -191576215:
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_pic") && (feedPicComponent = componentFactory.feed_pic) != null) {
                                n97.c(feedPicComponent, arrayList, r67Var);
                            }
                            v57Var = null;
                            break;
                        case 301292525:
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_recomtag") && (list = componentFactory.feed_recomtag) != null && (threadRecommendInfo = (ThreadRecommendInfo) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list)) != null) {
                                x97.a(threadRecommendInfo, arrayList, r67Var);
                            }
                            v57Var = null;
                            break;
                        case 582564983:
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_title")) {
                                List<ComponentFactory> list2 = originData.feed.components;
                                Intrinsics.checkNotNullExpressionValue(list2, "originData.feed.components");
                                boolean a = xa7.a(list2);
                                TitleComponent titleComponent = componentFactory.feed_title;
                                if (titleComponent != null) {
                                    q97.b(titleComponent, arrayList, spannableStringBuilder, r67Var, a);
                                }
                            }
                            v57Var = null;
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
                                m87Var.j(s97.a(str3, r67Var));
                                FeedVideoComponent feedVideoComponent3 = componentFactory.feed_video;
                                if (feedVideoComponent3 != null) {
                                    s97.c(feedVideoComponent3, arrayList, m87Var, r67Var);
                                }
                            }
                            v57Var = null;
                            break;
                        case 584579921:
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_voice") && (voice = componentFactory.feed_voice) != null) {
                                t97.a(voice, arrayList, r67Var);
                            }
                            v57Var = null;
                            break;
                        case 744478951:
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_origin") && (feedOriginComponent = componentFactory.feed_origin) != null) {
                                l97.a(feedOriginComponent, arrayList, r67Var);
                            }
                            v57Var = null;
                            break;
                        case 856047918:
                            componentFactory = componentFactory2;
                            if (str4.equals("feed_social") && (feedSocialComponent = componentFactory.feed_social) != null) {
                                FeedSocialExtensionKt.a(feedSocialComponent, arrayList, r67Var, m87Var);
                            }
                            v57Var = null;
                            break;
                        case 1804018946:
                            if (str4.equals("feed_head_figure")) {
                                FeedHeadFigureComponent feedHeadFigureComponent = componentFactory2.feed_head_figure;
                                if (feedHeadFigureComponent != null) {
                                    componentFactory = componentFactory2;
                                    FeedHeadExtensionKt.i(feedHeadFigureComponent, arrayList, s67.e(r67Var, "virtual_head_show", v57Var2, 2, v57Var2), s67.e(r67Var, "virtual_head_click", v57Var2, 2, v57Var2), t67Var, y97.a(b), s67.f(r67Var, "head_local_stat_info"), r67Var);
                                } else {
                                    componentFactory = componentFactory2;
                                }
                                v57Var = null;
                                break;
                            }
                        default:
                            v57Var = v57Var2;
                            componentFactory = componentFactory2;
                            break;
                    }
                    for (w87 w87Var : this.d) {
                        Intrinsics.checkNotNullExpressionValue(componentFactory, "componentFactory");
                        FeedLayout feedLayout2 = originData.feed;
                        if (feedLayout2 != null) {
                            str = feedLayout2.schema;
                        } else {
                            str = v57Var;
                        }
                        if (str == 0) {
                            str = "";
                        }
                        w87Var.a(componentFactory, arrayList, r67Var, str);
                    }
                    v57Var2 = v57Var;
                }
                v57Var = v57Var2;
                componentFactory = componentFactory2;
                while (r3.hasNext()) {
                }
                v57Var2 = v57Var;
            }
            String schema = originData.feed.schema;
            boolean areEqual = Intrinsics.areEqual(r67Var.a().a().get("is_grey_mode"), "1");
            String str6 = r67Var.a().a().get("thread_id");
            Map<String, Object> f = f(originData.feed.appendix);
            Intrinsics.checkNotNullExpressionValue(schema, "schema");
            return h(new w57<>(arrayList, schema, areEqual, Intrinsics.areEqual(r67Var.a().a().get("can_multi_manage"), "1"), str6, r67Var.a().a().get("user_id"), b, t67Var, f, r67Var, null, null, p61.a, null), r67Var);
        }
        return (sb7) invokeL.objValue;
    }

    public final Set<w87> i() {
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
