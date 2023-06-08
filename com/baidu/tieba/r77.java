package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.q77;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedContentColor;
import tbclient.FeedContentEmoji;
import tbclient.FeedContentIcon;
import tbclient.FeedContentResource;
import tbclient.FeedContentText;
import tbclient.FeedKV;
/* loaded from: classes7.dex */
public final class r77 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948074615, "Lcom/baidu/tieba/r77;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948074615, "Lcom/baidu/tieba/r77;");
                return;
            }
        }
        a = new a(null);
    }

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (i == 0 || i == 1) {
                    return "common_text";
                }
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return null;
                            }
                            return "text_with_bg";
                        }
                        return "tie_plus";
                    }
                    return "emoji";
                }
                return "common_icon";
            }
            return (String) invokeI.objValue;
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final String b(y47 y47Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y47Var)) == null) {
                String str = y47Var.a().get("rich_text_type");
                if (str != null) {
                    int hashCode = str.hashCode();
                    if (hashCode != 3123) {
                        if (hashCode != 3242771) {
                            if (hashCode != 110546223) {
                                if (hashCode == 1386396779 && str.equals("video_topic")) {
                                    return "rich_text_video_topic_click";
                                }
                            } else if (str.equals("topic")) {
                                return "rich_text_topic_click";
                            }
                        } else if (str.equals("item")) {
                            return "rich_text_item_click";
                        }
                    } else if (str.equals("at")) {
                        return "rich_text_at_click";
                    }
                }
                return "rich_text_common_stat";
            }
            return (String) invokeL.objValue;
        }

        public final a67 c(FeedContentResource content, y47 outerBusinessInfo, u57 logInfo, Map<String, ? extends m87> statStrategyMap) {
            InterceptResult invokeLLLL;
            String str;
            String str2;
            f57 f57Var;
            f57 f57Var2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, content, outerBusinessInfo, logInfo, statStrategyMap)) == null) {
                Intrinsics.checkNotNullParameter(content, "content");
                Intrinsics.checkNotNullParameter(outerBusinessInfo, "outerBusinessInfo");
                Intrinsics.checkNotNullParameter(logInfo, "logInfo");
                Intrinsics.checkNotNullParameter(statStrategyMap, "statStrategyMap");
                c67 c67Var = null;
                d67 d67Var = new d67("", null, null);
                FeedContentText feedContentText = content.text_info;
                if (feedContentText != null) {
                    FeedContentColor feedContentColor = feedContentText.color;
                    if (feedContentColor != null) {
                        Integer num = feedContentColor.type;
                        Intrinsics.checkNotNullExpressionValue(num, "it.type");
                        f57Var = new f57(num.intValue(), feedContentColor.day, feedContentColor.night);
                    } else {
                        f57Var = null;
                    }
                    FeedContentColor feedContentColor2 = content.text_info.bg_color;
                    if (feedContentColor2 != null) {
                        Integer num2 = feedContentColor2.type;
                        Intrinsics.checkNotNullExpressionValue(num2, "it.type");
                        f57Var2 = new f57(num2.intValue(), feedContentColor2.day, feedContentColor2.night);
                    } else {
                        f57Var2 = null;
                    }
                    String str3 = content.text_info.text;
                    Intrinsics.checkNotNullExpressionValue(str3, "content.text_info.text");
                    d67Var = new d67(str3, f57Var, f57Var2);
                }
                d67 d67Var2 = d67Var;
                p57 p57Var = new p57(null, null, 0, 0, 15, null);
                FeedContentIcon feedContentIcon = content.icon_info;
                if (feedContentIcon != null) {
                    String str4 = feedContentIcon.day_url;
                    Intrinsics.checkNotNullExpressionValue(str4, "iconInfo.day_url");
                    String str5 = feedContentIcon.night_url;
                    Intrinsics.checkNotNullExpressionValue(str5, "iconInfo.night_url");
                    Integer num3 = feedContentIcon.width;
                    Intrinsics.checkNotNullExpressionValue(num3, "iconInfo.width");
                    int intValue = num3.intValue();
                    Integer num4 = feedContentIcon.height;
                    Intrinsics.checkNotNullExpressionValue(num4, "iconInfo.height");
                    p57Var = new p57(str4, str5, intValue, num4.intValue());
                }
                p57 p57Var2 = p57Var;
                FeedContentEmoji feedContentEmoji = content.emoji_info;
                if (feedContentEmoji != null) {
                    str = feedContentEmoji.name;
                } else {
                    str = null;
                }
                if (str == null) {
                    str2 = "";
                } else {
                    str2 = str;
                }
                y47 y47Var = new y47();
                q77.a aVar = q77.a;
                List<FeedKV> list = content.business_info;
                Intrinsics.checkNotNullExpressionValue(list, "content.business_info");
                y47Var.b(aVar.a(list));
                y47 y47Var2 = new y47();
                y47Var2.a().putAll(y47Var.a());
                y47Var2.a().putAll(outerBusinessInfo.a());
                u57 u57Var = new u57();
                q77.a aVar2 = q77.a;
                List<FeedKV> list2 = content.log_info;
                Intrinsics.checkNotNullExpressionValue(list2, "content.log_info");
                u57Var.b(aVar2.a(list2));
                String b = b(y47Var2);
                if (Intrinsics.areEqual("rich_text_common_stat", b)) {
                    String str6 = u57Var.a().get("key");
                    if (str6 != null) {
                        c67Var = new c67(str6, new HashMap(), u57Var.a());
                    }
                } else {
                    m87 m87Var = statStrategyMap.get(b);
                    if (m87Var != null) {
                        c67Var = new c67(m87Var.getKey(), m87Var.a(y47Var2), logInfo.a());
                    }
                }
                Integer num5 = content.type;
                Intrinsics.checkNotNullExpressionValue(num5, "content.type");
                int intValue2 = num5.intValue();
                String str7 = content.schema;
                Intrinsics.checkNotNullExpressionValue(str7, "content.schema");
                return new a67(intValue2, d67Var2, p57Var2, str2, y47Var2, str7, c67Var);
            }
            return (a67) invokeLLLL.objValue;
        }
    }
}
