package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes7.dex */
public final class ms5 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947983258, "Lcom/baidu/tieba/ms5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947983258, "Lcom/baidu/tieba/ms5;");
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

        public final String a(String str, int i, String str2) {
            InterceptResult invokeLIL;
            boolean z;
            boolean z2;
            int i2;
            String str3;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, str, i, str2)) == null) {
                String str4 = str;
                String str5 = "";
                if (str4 == null || i <= 0) {
                    return "";
                }
                int d = d(str);
                if (d <= i) {
                    return str4;
                }
                int b = uy6.b(str);
                if (b == 0) {
                    String cutChineseAndEnglishWithEmoji = StringHelper.cutChineseAndEnglishWithEmoji(str, i, str2);
                    Intrinsics.checkNotNullExpressionValue(cutChineseAndEnglishWithEmoji, "cutChineseAndEnglishWithEmoji(string, length, end)");
                    return cutChineseAndEnglishWithEmoji;
                }
                Object[] array = new Regex("#\\([a-zA-Z0-9_~！\\-\\u4E00-\\u9FA5]+\\)").split(str4, 0).toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    if (strArr.length == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (i < 2) {
                            if (str2 == null) {
                                return "";
                            }
                            return str2;
                        }
                        return str4;
                    }
                    String[] b2 = b(str4, strArr, b);
                    int length = b2.length;
                    int i4 = 0;
                    int i5 = 0;
                    int i6 = 0;
                    int i7 = 0;
                    while (i4 < length) {
                        String str6 = b2[i4];
                        Intrinsics.checkNotNull(str6);
                        if (StringsKt__StringsJVMKt.startsWith$default(str6, "2", false, 2, null)) {
                            String substring = str6.substring(1);
                            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                            b2[i4] = substring;
                            i7 = -1;
                            i5 += 2;
                            if (i5 > i) {
                                break;
                            }
                        } else {
                            String substring2 = str6.substring(1);
                            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                            b2[i4] = substring2;
                            String str7 = b2[i4];
                            Intrinsics.checkNotNull(str7);
                            int length2 = str7.length();
                            int i8 = 0;
                            while (i8 < length2) {
                                if (ad.isChinese(str7.charAt(i8))) {
                                    i3 = 2;
                                } else {
                                    i3 = 1;
                                }
                                i5 += i3;
                                if (i5 > i) {
                                    break;
                                }
                                i8++;
                            }
                            i7 = i8;
                        }
                        if (i5 > i) {
                            break;
                        }
                        i4++;
                        i6 = i5;
                    }
                    if (i6 + i7 + 1 <= d) {
                        StringBuilder sb = new StringBuilder();
                        for (int i9 = 0; i9 < i4; i9++) {
                            sb.append(b2[i9]);
                        }
                        if (i4 < length && (str3 = b2[i4]) != null) {
                            str5 = str3;
                        }
                        if (str5.length() > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2 && (i2 = i7 + 1) > 0 && i2 <= str5.length()) {
                            String substring3 = str5.substring(0, str5.offsetByCodePoints(0, str5.codePointCount(0, i7)));
                            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                            sb.append(substring3);
                        }
                        if (!Intrinsics.areEqual(str4, sb.toString())) {
                            str4 = sb.toString() + str2;
                        }
                        Intrinsics.checkNotNullExpressionValue(str4, "{\n                val re…          }\n            }");
                    }
                    return str4;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            return (String) invokeLIL.objValue;
        }

        public final String[] b(String str, String[] strArr, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, strArr, i)) == null) {
                String[] strArr2 = new String[strArr.length + i];
                Matcher matcher = uy6.a.matcher(str);
                int i2 = 0;
                int i3 = 0;
                while (matcher.find()) {
                    if (i2 < strArr.length) {
                        strArr2[i3] = '1' + strArr[i2];
                        i3++;
                        i2++;
                    }
                    String group = matcher.group();
                    if (MessageManager.getInstance().findTask(2004608) != null) {
                        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2004608, Boolean.TYPE, group);
                        if (runTask != null && runTask.getData() != null) {
                            Object data = runTask.getData();
                            Intrinsics.checkNotNull(data);
                            if (((Boolean) data).booleanValue()) {
                                strArr2[i3] = '2' + group;
                                i3++;
                            }
                        }
                        strArr2[i3] = '1' + group;
                        i3++;
                    }
                }
                if (i2 < strArr.length) {
                    strArr2[i3] = '1' + strArr[i2];
                }
                return strArr2;
            }
            return (String[]) invokeLLI.objValue;
        }

        public final int c(List<? extends AtSelectData> atInfoList) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, atInfoList)) == null) {
                Intrinsics.checkNotNullParameter(atInfoList, "atInfoList");
                int i = 0;
                if (ListUtils.isEmpty(atInfoList)) {
                    return 0;
                }
                for (AtSelectData atSelectData : atInfoList) {
                    if (atSelectData != null) {
                        i += d('@' + atSelectData.getNameShow() + WebvttCueParser.CHAR_SPACE);
                    }
                }
                return i;
            }
            return invokeL.intValue;
        }

        public final int d(String str) {
            InterceptResult invokeL;
            int chineseAndEnglishLength;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                if (str == null) {
                    return 0;
                }
                Matcher matcher = uy6.a.matcher(str);
                int i = 0;
                while (matcher.find()) {
                    String group = matcher.group();
                    if (MessageManager.getInstance().findTask(2004608) != null) {
                        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2004608, Boolean.TYPE, group);
                        if (runTask != null && runTask.getData() != null) {
                            Object data = runTask.getData();
                            Intrinsics.checkNotNull(data);
                            if (((Boolean) data).booleanValue()) {
                                chineseAndEnglishLength = 2;
                                i += chineseAndEnglishLength;
                            }
                        }
                        chineseAndEnglishLength = StringHelper.getChineseAndEnglishLength(group);
                        i += chineseAndEnglishLength;
                    }
                }
                Object[] array = new Regex("#\\([a-zA-Z0-9_~！\\-\\u4E00-\\u9FA5]+\\)").split(str, 0).toArray(new String[0]);
                if (array != null) {
                    for (String str2 : (String[]) array) {
                        i += StringHelper.getChineseAndEnglishLength(str2);
                    }
                    return i;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            return invokeL.intValue;
        }
    }
}
