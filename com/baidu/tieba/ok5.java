package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes5.dex */
public final class ok5 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948035152, "Lcom/baidu/tieba/ok5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948035152, "Lcom/baidu/tieba/ok5;");
                return;
            }
        }
        a = new a(null);
    }

    /* loaded from: classes5.dex */
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
                int c = c(str);
                if (c <= i) {
                    return str4;
                }
                int b = lf6.b(str);
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
                    int i4 = 2;
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
                    int i5 = 0;
                    int i6 = 0;
                    int i7 = 0;
                    int i8 = 0;
                    while (i5 < length) {
                        String str6 = b2[i5];
                        Intrinsics.checkNotNull(str6);
                        if (StringsKt__StringsJVMKt.startsWith$default(str6, "2", false, i4, null)) {
                            if (str6 != null) {
                                String substring = str6.substring(1);
                                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                                b2[i5] = substring;
                                i8 = -1;
                                i6 += 2;
                                if (i6 > i) {
                                    break;
                                }
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                            }
                        } else if (str6 != null) {
                            String substring2 = str6.substring(1);
                            Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
                            b2[i5] = substring2;
                            String str7 = b2[i5];
                            Intrinsics.checkNotNull(str7);
                            int length2 = str7.length();
                            i8 = 0;
                            while (i8 < length2) {
                                if (xi.isChinese(str7.charAt(i8))) {
                                    i3 = 2;
                                } else {
                                    i3 = 1;
                                }
                                i6 += i3;
                                if (i6 > i) {
                                    break;
                                }
                                i8++;
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        if (i6 > i) {
                            break;
                        }
                        i5++;
                        i7 = i6;
                        i4 = 2;
                    }
                    if (i7 + i8 + 1 <= c) {
                        StringBuilder sb = new StringBuilder();
                        if (i5 > 0) {
                            int i9 = 0;
                            while (true) {
                                int i10 = i9 + 1;
                                sb.append(b2[i9]);
                                if (i10 >= i5) {
                                    break;
                                }
                                i9 = i10;
                            }
                        }
                        if (i5 < length && (str3 = b2[i5]) != null) {
                            str5 = str3;
                        }
                        if (str5.length() > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2 && (i2 = i8 + 1) > 0 && i2 < str5.length()) {
                            String substring3 = str5.substring(0, str5.offsetByCodePoints(0, str5.codePointCount(0, i2)));
                            Intrinsics.checkNotNullExpressionValue(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            sb.append(substring3);
                        }
                        if (!Intrinsics.areEqual(str4, sb.toString())) {
                            str4 = Intrinsics.stringPlus(sb.toString(), str2);
                        }
                        Intrinsics.checkNotNullExpressionValue(str4, "{\n                val re…          }\n            }");
                    }
                    return str4;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            return (String) invokeLIL.objValue;
        }

        public final String[] b(String str, String[] strArr, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, strArr, i)) == null) {
                String[] strArr2 = new String[strArr.length + i];
                Matcher matcher = lf6.a.matcher(str);
                int i2 = 0;
                int i3 = 0;
                while (matcher.find()) {
                    if (i2 < strArr.length) {
                        strArr2[i3] = Intrinsics.stringPlus("1", strArr[i2]);
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
                                strArr2[i3] = Intrinsics.stringPlus("2", group);
                                i3++;
                            }
                        }
                        strArr2[i3] = Intrinsics.stringPlus("1", group);
                        i3++;
                    }
                }
                if (i2 < strArr.length) {
                    strArr2[i3] = Intrinsics.stringPlus("1", strArr[i2]);
                }
                return strArr2;
            }
            return (String[]) invokeLLI.objValue;
        }

        public final int c(String str) {
            InterceptResult invokeL;
            int chineseAndEnglishLength;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                int i = 0;
                if (str == null) {
                    return 0;
                }
                Matcher matcher = lf6.a.matcher(str);
                int i2 = 0;
                while (matcher.find()) {
                    String group = matcher.group();
                    if (MessageManager.getInstance().findTask(2004608) != null) {
                        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2004608, Boolean.TYPE, group);
                        if (runTask != null && runTask.getData() != null) {
                            Object data = runTask.getData();
                            Intrinsics.checkNotNull(data);
                            if (((Boolean) data).booleanValue()) {
                                chineseAndEnglishLength = 2;
                                i2 += chineseAndEnglishLength;
                            }
                        }
                        chineseAndEnglishLength = StringHelper.getChineseAndEnglishLength(group);
                        i2 += chineseAndEnglishLength;
                    }
                }
                Object[] array = new Regex("#\\([a-zA-Z0-9_~！\\-\\u4E00-\\u9FA5]+\\)").split(str, 0).toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    int length = strArr.length;
                    if (length > 0) {
                        while (true) {
                            int i3 = i + 1;
                            i2 += StringHelper.getChineseAndEnglishLength(strArr[i]);
                            if (i3 >= length) {
                                break;
                            }
                            i = i3;
                        }
                    }
                    return i2;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            return invokeL.intValue;
        }
    }
}
