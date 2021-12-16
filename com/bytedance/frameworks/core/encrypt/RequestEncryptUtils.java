package com.bytedance.frameworks.core.encrypt;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class RequestEncryptUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    public static final String KEY_DEVICE_BRAND = "device_brand";
    public static final String KEY_DEVICE_ID = "device_id";
    public static final String KEY_DEVICE_TYPE = "device_type";
    public static final String KEY_OPENUDID = "openudid";
    public static final String KEY_SS_ENCRYPT = "ss_encrypt";
    public static final String KEY_SS_QUERIES = "ss_queries";
    public static final String KEY_SS_QUERIES_HEADER = "X-SS-QUERIES";
    public static final String KEY_UUID = "uuid";
    public static final String NAME_VALUE_SEPARATOR = "=";
    public static final String PARAMETER_SEPARATOR = "&";
    public static final String TAG = "RequestEncryptUtils";
    public static boolean sDebug;
    public static IEncryptConfig sEncryptConfig;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public interface IEncryptConfig {
        boolean isSsQueriesHeaderOpen();

        boolean isSsQueriesOpen();

        boolean isSsQueriesPlaintextOpen();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-292838338, "Lcom/bytedance/frameworks/core/encrypt/RequestEncryptUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-292838338, "Lcom/bytedance/frameworks/core/encrypt/RequestEncryptUtils;");
        }
    }

    public RequestEncryptUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Uri createUri(String str, String str2, int i2, String str3, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, str2, Integer.valueOf(i2), str3, str4, str5})) == null) {
            StringBuilder sb = new StringBuilder();
            if (str2 != null) {
                if (str != null) {
                    sb.append(str);
                    sb.append("://");
                }
                sb.append(str2);
                if (i2 > 0) {
                    sb.append(':');
                    sb.append(i2);
                }
            }
            if (str3 == null || !str3.startsWith("/")) {
                sb.append('/');
            }
            if (str3 != null) {
                sb.append(str3);
            }
            if (str4 != null) {
                sb.append('?');
                sb.append(str4);
            }
            if (str5 != null) {
                sb.append('#');
                sb.append(str5);
            }
            return Uri.parse(sb.toString());
        }
        return (Uri) invokeCommon.objValue;
    }

    public static String encode(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (str2 == null) {
                str2 = "ISO-8859-1";
            }
            try {
                return URLEncoder.encode(str, str2);
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalArgumentException(e2);
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String format(List<Pair<String, List<String>>> list, boolean z, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{list, Boolean.valueOf(z), str})) == null) {
            StringBuilder sb = new StringBuilder();
            for (Pair<String, List<String>> pair : list) {
                Object obj = pair.first;
                String str2 = (String) obj;
                if (z) {
                    str2 = encode((String) obj, str);
                }
                List<String> list2 = (List) pair.second;
                if (list2 != null && list2.size() > 0) {
                    for (String str3 : list2) {
                        if (z) {
                            str3 = str3 != null ? encode(str3, str) : "";
                        }
                        if (sb.length() > 0) {
                            sb.append("&");
                        }
                        sb.append(str2);
                        sb.append("=");
                        sb.append(str3);
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static void parseQueries(Uri uri, Map<String, List<String>> map) throws IOException {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, uri, map) == null) {
            if (uri == null) {
                throw new IOException("parseUrl url is null !!!");
            }
            if (map != null) {
                try {
                    String encodedQuery = uri.getEncodedQuery();
                    if (encodedQuery != null) {
                        for (String str : encodedQuery.split("&")) {
                            int indexOf = str.indexOf("=");
                            if (indexOf >= 0) {
                                String decode = URLDecoder.decode(str.substring(0, indexOf), "UTF-8");
                                List<String> list = map.get(decode);
                                if (list == null) {
                                    list = new LinkedList<>();
                                }
                                list.add(URLDecoder.decode(str.substring(indexOf + 1), "UTF-8"));
                                map.put(decode, list);
                            } else {
                                String decode2 = URLDecoder.decode(str, "UTF-8");
                                List<String> list2 = map.get(decode2);
                                if (list2 == null) {
                                    list2 = new LinkedList<>();
                                }
                                list2.add("");
                                map.put(decode2, list2);
                            }
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    throw new IOException("parseUrl url is null !!!");
                }
            }
        }
    }

    public static void setDebug(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65542, null, z) == null) {
            sDebug = z;
        }
    }

    public static void setEncryptConfig(IEncryptConfig iEncryptConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, iEncryptConfig) == null) {
            sEncryptConfig = iEncryptConfig;
        }
    }

    public static boolean tryAddQuery(Map<String, List<String>> map, List<Pair<String, List<String>>> list, String str) throws UnsupportedEncodingException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, map, list, str)) == null) {
            if (TextUtils.isEmpty(str) || list == null || !map.containsKey(str)) {
                return false;
            }
            list.add(new Pair<>(str, map.get(str)));
            if (sEncryptConfig.isSsQueriesPlaintextOpen()) {
                return true;
            }
            map.remove(str);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static String tryEncryptRequest(String str, List<Pair<String, String>> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, list)) == null) {
            if (TextUtils.isEmpty(str) || sEncryptConfig == null || sDebug) {
                return str;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            try {
                Uri parse = Uri.parse(str);
                parseQueries(parse, linkedHashMap);
                LinkedList linkedList = new LinkedList();
                tryAddQuery(linkedHashMap, linkedList, "device_id");
                tryAddQuery(linkedHashMap, linkedList, "device_type");
                tryAddQuery(linkedHashMap, linkedList, KEY_DEVICE_BRAND);
                tryAddQuery(linkedHashMap, linkedList, "uuid");
                tryAddQuery(linkedHashMap, linkedList, KEY_OPENUDID);
                String format = format(linkedList, false, "UTF-8");
                if (TextUtils.isEmpty(format)) {
                    return str;
                }
                byte[] bytes = format.getBytes();
                byte[] encrypt = EncryptorUtil.encrypt(bytes, bytes.length);
                if (encrypt == null) {
                    return str;
                }
                String encodeToString = Base64.encodeToString(encrypt, 2);
                LinkedList linkedList2 = new LinkedList();
                if (sEncryptConfig.isSsQueriesOpen()) {
                    LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(encodeToString);
                    linkedList2.add(new Pair(KEY_SS_QUERIES, linkedList3));
                }
                if (sEncryptConfig.isSsQueriesHeaderOpen() && list != null) {
                    list.add(new Pair<>(KEY_SS_QUERIES_HEADER, encode(encodeToString, "UTF-8")));
                }
                if (!linkedHashMap.isEmpty()) {
                    for (Map.Entry entry : linkedHashMap.entrySet()) {
                        if (entry != null) {
                            linkedList2.add(new Pair(entry.getKey(), entry.getValue()));
                        }
                    }
                }
                return createUri(parse.getScheme(), parse.getHost(), parse.getPort(), parse.getPath(), format(linkedList2, true, "UTF-8"), parse.getFragment()).toString();
            } catch (Throwable th) {
                th.printStackTrace();
                return str;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static byte[] tryEncryptRequestBody(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, bArr)) == null) {
            if (bArr == null || bArr.length == 0 || sDebug) {
                return bArr;
            }
            try {
                return EncryptorUtil.encrypt(bArr, bArr.length);
            } catch (Throwable th) {
                th.printStackTrace();
                return bArr;
            }
        }
        return (byte[]) invokeL.objValue;
    }
}
