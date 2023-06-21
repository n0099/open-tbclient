package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tbclient.AbstractComponent;
import tbclient.ComponentFactory;
import tbclient.FeedEntrybarComponent;
import tbclient.FeedFeedback;
import tbclient.FeedHeadComponent;
import tbclient.FeedHeadFigureComponent;
import tbclient.FeedItem;
import tbclient.FeedLayout;
import tbclient.FeedLinkComponent;
import tbclient.FeedLiveComponent;
import tbclient.FeedOriginComponent;
import tbclient.FeedPicComponent;
import tbclient.FeedSocialComponent;
import tbclient.FeedVideoComponent;
import tbclient.LayoutFactory;
import tbclient.TitleComponent;
import tbclient.Voice;
/* loaded from: classes6.dex */
public abstract class l67 implements m67<LayoutFactory>, q87, u77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, ? extends r87> a;
    public Map<String, String> b;

    public abstract o87<?> e(e57<?> e57Var, q57 q57Var);

    public l67() {
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
    }

    @Override // com.baidu.tieba.u77
    public void a(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.b = map;
        }
    }

    @Override // com.baidu.tieba.q87
    public void c(Map<String, ? extends r87> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.a = map;
        }
    }

    public final boolean f(List<ComponentFactory> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
            for (ComponentFactory componentFactory : list) {
                if (componentFactory.feed_live != null) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean g(List<ComponentFactory> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, list)) == null) {
            for (ComponentFactory componentFactory : list) {
                if (componentFactory.feed_video != null) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.m67
    /* renamed from: d */
    public o87<?> b(LayoutFactory originData) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, originData)) == null) {
            Intrinsics.checkNotNullParameter(originData, "originData");
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            q57 q57Var = new q57();
            q57Var.f(this.a);
            FeedLayout feedLayout = originData.feed;
            Intrinsics.checkNotNullExpressionValue(feedLayout, "originData.feed");
            r57.a(q57Var, feedLayout);
            q57Var.e(this.b);
            k67 k67Var = new k67();
            for (ComponentFactory componentFactory : originData.feed.components) {
                String str2 = componentFactory.component;
                if (str2 != null) {
                    s57 s57Var = null;
                    s57 s57Var2 = null;
                    String str3 = null;
                    switch (str2.hashCode()) {
                        case -1644137503:
                            if (str2.equals("feed_head")) {
                                List<ComponentFactory> list = originData.feed.components;
                                Intrinsics.checkNotNullExpressionValue(list, "originData.feed.components");
                                if (f(list)) {
                                    str = "live_head_click";
                                } else {
                                    str = "user_info_click";
                                }
                                FeedHeadComponent feedHeadComponent = componentFactory.feed_head;
                                if (feedHeadComponent != null) {
                                    h67 b = r57.b(q57Var, str);
                                    h67 b2 = r57.b(q57Var, "user_info_click2");
                                    FeedFeedback feedFeedback = originData.feed.feedback;
                                    if (feedFeedback != null) {
                                        s57Var = d77.a(feedFeedback, q57Var);
                                    }
                                    r67.e(feedHeadComponent, arrayList, b, b2, s57Var, r67.a(originData.feed.business_info));
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case -1644093164:
                            if (str2.equals("feed_item")) {
                                FeedItem feedItem = componentFactory.feed_item;
                                if (feedItem != null) {
                                    s67.c(feedItem, arrayList, q57Var);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case -1644014085:
                            if (str2.equals("feed_link")) {
                                FeedLinkComponent feedLinkComponent = componentFactory.feed_link;
                                if (feedLinkComponent != null) {
                                    u67.a(feedLinkComponent, arrayList);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case -1644013843:
                            if (str2.equals("feed_live")) {
                                FeedLiveComponent feedLiveComponent = componentFactory.feed_live;
                                if (feedLiveComponent != null) {
                                    v67.a(feedLiveComponent, arrayList, q57Var);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case -1461408349:
                            if (str2.equals("feed_abstract")) {
                                AbstractComponent abstractComponent = componentFactory.feed_abstract;
                                if (abstractComponent != null) {
                                    o67.b(abstractComponent, arrayList, spannableStringBuilder, q57Var);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case -993000478:
                            if (str2.equals("feed_entrybar")) {
                                FeedEntrybarComponent feedEntrybarComponent = componentFactory.feed_entrybar;
                                if (feedEntrybarComponent != null) {
                                    q67.a(feedEntrybarComponent, arrayList, r57.b(q57Var, "enter_forum_btn_click"));
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case -191576215:
                            if (str2.equals("feed_pic")) {
                                FeedPicComponent feedPicComponent = componentFactory.feed_pic;
                                if (feedPicComponent != null) {
                                    x67.b(feedPicComponent, arrayList, q57Var);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case 582564983:
                            if (str2.equals("feed_title")) {
                                List<ComponentFactory> list2 = originData.feed.components;
                                Intrinsics.checkNotNullExpressionValue(list2, "originData.feed.components");
                                boolean g = g(list2);
                                TitleComponent titleComponent = componentFactory.feed_title;
                                if (titleComponent != null) {
                                    a77.a(titleComponent, arrayList, spannableStringBuilder, q57Var, g);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case 584396442:
                            if (str2.equals("feed_video")) {
                                FeedVideoComponent feedVideoComponent = componentFactory.feed_video;
                                if (feedVideoComponent != null) {
                                    str3 = feedVideoComponent.schema;
                                }
                                if (str3 == null) {
                                    str3 = "";
                                }
                                k67Var.g(b77.a(str3, q57Var));
                                FeedVideoComponent feedVideoComponent2 = componentFactory.feed_video;
                                if (feedVideoComponent2 != null) {
                                    b77.c(feedVideoComponent2, arrayList, k67Var, q57Var);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case 584579921:
                            if (str2.equals("feed_voice")) {
                                Voice voice = componentFactory.feed_voice;
                                if (voice != null) {
                                    c77.a(voice, arrayList);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case 744478951:
                            if (str2.equals("feed_origin")) {
                                FeedOriginComponent feedOriginComponent = componentFactory.feed_origin;
                                if (feedOriginComponent != null) {
                                    w67.a(feedOriginComponent, arrayList, q57Var);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case 856047918:
                            if (str2.equals("feed_social")) {
                                FeedSocialComponent feedSocialComponent = componentFactory.feed_social;
                                if (feedSocialComponent != null) {
                                    z67.a(feedSocialComponent, arrayList, q57Var, k67Var);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        case 1804018946:
                            if (str2.equals("feed_head_figure")) {
                                FeedHeadFigureComponent feedHeadFigureComponent = componentFactory.feed_head_figure;
                                if (feedHeadFigureComponent != null) {
                                    h67 b3 = r57.b(q57Var, "virtual_head_show");
                                    h67 b4 = r57.b(q57Var, "virtual_head_click");
                                    FeedFeedback feedFeedback2 = originData.feed.feedback;
                                    if (feedFeedback2 != null) {
                                        s57Var2 = d77.a(feedFeedback2, q57Var);
                                    }
                                    r67.f(feedHeadFigureComponent, arrayList, b3, b4, s57Var2);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                continue;
                            }
                    }
                }
            }
            String str4 = originData.feed.schema;
            Intrinsics.checkNotNullExpressionValue(str4, "originData.feed.schema");
            return e(new e57<>(arrayList, str4, Intrinsics.areEqual(q57Var.a().a().get("is_grey_mode"), "1"), q57Var.b().a().get("thread_id"), q57Var.a().a().get("user_id"), null, 32, null), q57Var);
        }
        return (o87) invokeL.objValue;
    }
}
