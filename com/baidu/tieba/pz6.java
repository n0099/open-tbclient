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
public abstract class pz6 implements qz6<LayoutFactory>, u17, y07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, ? extends v17> a;
    public Map<String, String> b;

    public abstract s17<?> e(iy6<?> iy6Var, uy6 uy6Var);

    public pz6() {
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

    @Override // com.baidu.tieba.y07
    public void a(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.b = map;
        }
    }

    @Override // com.baidu.tieba.u17
    public void c(Map<String, ? extends v17> map) {
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
    @Override // com.baidu.tieba.qz6
    /* renamed from: d */
    public s17<?> b(LayoutFactory originData) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, originData)) == null) {
            Intrinsics.checkNotNullParameter(originData, "originData");
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            uy6 uy6Var = new uy6();
            uy6Var.f(this.a);
            FeedLayout feedLayout = originData.feed;
            Intrinsics.checkNotNullExpressionValue(feedLayout, "originData.feed");
            vy6.a(uy6Var, feedLayout);
            uy6Var.e(this.b);
            oz6 oz6Var = new oz6();
            for (ComponentFactory componentFactory : originData.feed.components) {
                String str2 = componentFactory.component;
                if (str2 != null) {
                    wy6 wy6Var = null;
                    wy6 wy6Var2 = null;
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
                                    lz6 b = vy6.b(uy6Var, str);
                                    lz6 b2 = vy6.b(uy6Var, "user_info_click2");
                                    FeedFeedback feedFeedback = originData.feed.feedback;
                                    if (feedFeedback != null) {
                                        wy6Var = h07.a(feedFeedback, uy6Var);
                                    }
                                    vz6.e(feedHeadComponent, arrayList, b, b2, wy6Var, vz6.a(originData.feed.business_info));
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
                                    wz6.c(feedItem, arrayList, uy6Var);
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
                                    yz6.a(feedLinkComponent, arrayList);
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
                                    zz6.a(feedLiveComponent, arrayList, uy6Var);
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
                                    sz6.b(abstractComponent, arrayList, spannableStringBuilder, uy6Var);
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
                                    uz6.a(feedEntrybarComponent, arrayList, vy6.b(uy6Var, "enter_forum_btn_click"));
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
                                    b07.b(feedPicComponent, arrayList, uy6Var);
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
                                    e07.a(titleComponent, arrayList, spannableStringBuilder, uy6Var, g);
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
                                oz6Var.g(f07.a(str3, uy6Var));
                                FeedVideoComponent feedVideoComponent2 = componentFactory.feed_video;
                                if (feedVideoComponent2 != null) {
                                    f07.c(feedVideoComponent2, arrayList, oz6Var, uy6Var);
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
                                    g07.a(voice, arrayList);
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
                                    a07.a(feedOriginComponent, arrayList, uy6Var);
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
                                    d07.a(feedSocialComponent, arrayList, uy6Var, oz6Var);
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
                                    lz6 b3 = vy6.b(uy6Var, "virtual_head_show");
                                    lz6 b4 = vy6.b(uy6Var, "virtual_head_click");
                                    FeedFeedback feedFeedback2 = originData.feed.feedback;
                                    if (feedFeedback2 != null) {
                                        wy6Var2 = h07.a(feedFeedback2, uy6Var);
                                    }
                                    vz6.f(feedHeadFigureComponent, arrayList, b3, b4, wy6Var2);
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
            return e(new iy6<>(arrayList, str4, Intrinsics.areEqual(uy6Var.a().a().get("is_grey_mode"), "1"), uy6Var.b().a().get("thread_id"), uy6Var.a().a().get("user_id"), null, 32, null), uy6Var);
        }
        return (s17) invokeL.objValue;
    }
}
