package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedContentColor;
import tbclient.FeedContentEmoji;
import tbclient.FeedContentIcon;
import tbclient.FeedContentResource;
import tbclient.FeedContentText;
/* loaded from: classes9.dex */
public final class ya7 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948323514, "Lcom/baidu/tieba/ya7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948323514, "Lcom/baidu/tieba/ya7;");
                return;
            }
        }
        a = new a(null);
    }

    /* loaded from: classes9.dex */
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
                switch (i) {
                    case 0:
                    case 1:
                        return "common_text";
                    case 2:
                        return "common_icon";
                    case 3:
                        return "emoji";
                    case 4:
                        return "tie_plus";
                    case 5:
                        return "text_with_bg";
                    case 6:
                        return "text_with_hollow_bg";
                    default:
                        return null;
                }
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

        public final String b(v57 v57Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v57Var)) == null) {
                String str = v57Var.a().get("rich_text_type");
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

        public final b87 c(FeedContentResource content, v57 outerBusinessInfo, n77 logInfo, Map<String, ? extends zb7> statStrategyMap) {
            InterceptResult invokeLLLL;
            String str;
            String str2;
            e67 e67Var;
            e67 e67Var2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, content, outerBusinessInfo, logInfo, statStrategyMap)) == null) {
                Intrinsics.checkNotNullParameter(content, "content");
                Intrinsics.checkNotNullParameter(outerBusinessInfo, "outerBusinessInfo");
                Intrinsics.checkNotNullParameter(logInfo, "logInfo");
                Intrinsics.checkNotNullParameter(statStrategyMap, "statStrategyMap");
                e87 e87Var = null;
                g87 g87Var = new g87("", null, null);
                FeedContentText feedContentText = content.text_info;
                if (feedContentText != null) {
                    FeedContentColor feedContentColor = feedContentText.color;
                    if (feedContentColor != null) {
                        Integer num = feedContentColor.type;
                        Intrinsics.checkNotNullExpressionValue(num, "it.type");
                        e67Var = new e67(num.intValue(), feedContentColor.day, feedContentColor.night);
                    } else {
                        e67Var = null;
                    }
                    FeedContentColor feedContentColor2 = content.text_info.bg_color;
                    if (feedContentColor2 != null) {
                        Integer num2 = feedContentColor2.type;
                        Intrinsics.checkNotNullExpressionValue(num2, "it.type");
                        e67Var2 = new e67(num2.intValue(), feedContentColor2.day, feedContentColor2.night);
                    } else {
                        e67Var2 = null;
                    }
                    String str3 = content.text_info.text;
                    Intrinsics.checkNotNullExpressionValue(str3, "content.text_info.text");
                    g87Var = new g87(str3, e67Var, e67Var2);
                }
                g87 g87Var2 = g87Var;
                i77 i77Var = new i77(null, null, 0, 0, 15, null);
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
                    i77Var = new i77(str4, str5, intValue, num4.intValue());
                }
                i77 i77Var2 = i77Var;
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
                v57 v57Var = new v57();
                v57Var.b(wa7.a.a(content.business_info));
                v57 v57Var2 = new v57();
                v57Var2.a().putAll(outerBusinessInfo.a());
                v57Var2.a().putAll(v57Var.a());
                n77 n77Var = new n77();
                n77Var.b(wa7.a.a(content.log_info));
                String b = b(v57Var2);
                if (Intrinsics.areEqual("rich_text_common_stat", b)) {
                    String str6 = n77Var.a().get("key");
                    if (str6 != null) {
                        e87Var = new e87(str6, new HashMap(), n77Var.a(), null, null, 24, null);
                    }
                } else {
                    zb7 zb7Var = statStrategyMap.get(b);
                    if (zb7Var != null) {
                        e87Var = new e87(zb7Var.getKey(), zb7Var.a(v57Var2), logInfo.a(), null, null, 24, null);
                    }
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.putAll(logInfo.a());
                linkedHashMap.putAll(wa7.a.a(content.log_info));
                Integer num5 = content.type;
                Intrinsics.checkNotNullExpressionValue(num5, "content.type");
                int intValue2 = num5.intValue();
                String str7 = content.schema;
                Intrinsics.checkNotNullExpressionValue(str7, "content.schema");
                return new b87(intValue2, g87Var2, i77Var2, str2, v57Var2, str7, e87Var, linkedHashMap);
            }
            return (b87) invokeLLLL.objValue;
        }
    }
}
