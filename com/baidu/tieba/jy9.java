package com.baidu.tieba;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigImgPbActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.WebviewHelper;
import com.baidu.tieba.pb.PbPageRequestMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.codec.language.bm.ResourceConstants;
/* loaded from: classes6.dex */
public class jy9 {
    public static /* synthetic */ Interceptable $ic;
    public static String A;
    public static boolean B;
    public static boolean C;
    public static PbActivityConfig D;
    public static NetMessageListener E;
    public static String a;
    public static String b;
    public static String c;
    public static int d;
    public static String e;
    public static String f;
    public static String g;
    public static boolean h;
    public static TbHttpMessageTask i;
    public static final BdUniDispatchSchemeController.OnSchemeParsedCallback j;
    public static int k;
    public static int l;
    public static String m;
    public static String n;
    public static boolean o;
    public static boolean p;
    public static boolean q;
    public static int r;
    public static String s;
    public static String t;
    public static boolean u;
    public static boolean v;
    public static long w;
    public static String x;
    public static String y;
    public static String z;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements BdUniDispatchSchemeController.OnSchemeParsedCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // com.baidu.tbadk.BdToken.BdUniDispatchSchemeController.OnSchemeParsedCallback
        public void onCallBack(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, hashMap) != null) || hashMap == null) {
                return;
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_TID) instanceof String) {
                String unused = jy9.a = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_TID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_NID) instanceof String) {
                String unused2 = jy9.b = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_NID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TID) instanceof String) {
                String unused3 = jy9.c = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TYPE) instanceof String) {
                int unused4 = jy9.d = JavaTypesHelper.toInt((String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TYPE), 0);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_VID) instanceof String) {
                String unused5 = jy9.e = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_VID);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && (responsedMessage.getOrginalMessage().getSelf() instanceof PbPageRequestMessage)) {
                PbPageRequestMessage pbPageRequestMessage = (PbPageRequestMessage) responsedMessage.getOrginalMessage().getSelf();
                pbPageRequestMessage.isFromPbOptimize();
                pbPageRequestMessage.get_kz();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947899775, "Lcom/baidu/tieba/jy9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947899775, "Lcom/baidu/tieba/jy9;");
                return;
            }
        }
        j = new a();
        E = new b(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
    }

    public static void l(String[] strArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, null, strArr) == null) && j(strArr) == 0) {
            i(D.getIntent());
            k();
        }
    }

    public static String f() {
        InterceptResult invokeV;
        String g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            String str = a;
            if (str != null && !str.equals("0")) {
                g2 = a;
            } else {
                g2 = g();
            }
            if (p) {
                g2 = g2 + "_host";
            }
            int i2 = r;
            if (i2 == 1) {
                g2 = g2 + "_rev";
            } else if (i2 == 2) {
                g2 = g2 + "_hot";
            }
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                return g2 + TbadkCoreApplication.getCurrentAccount();
            }
            return g2;
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            String str = "";
            if (b != null) {
                str = "" + b;
            }
            if (c != null) {
                str = str + c;
            }
            String str2 = str + d;
            if (e != null) {
                return str2 + e;
            }
            return str2;
        }
        return (String) invokeV.objValue;
    }

    public static HashMap<String, Object> h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            if (str.startsWith(ResourceConstants.CMT)) {
                str = str.substring(2);
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            String[] split = str.split("[&]");
            if (split.length == 0) {
                return null;
            }
            for (String str2 : split) {
                String[] split2 = str2.split("[=]");
                if (split2.length > 1) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static void m(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65549, null, pbPageRequestMessage) != null) || TextUtils.isEmpty(x) || vha.m().b() == null) {
            return;
        }
        pbPageRequestMessage.setRefreshCount(vha.m().b().d(x, true) + 1);
        pbPageRequestMessage.setLoadCount(vha.m().b().e(x, true));
    }

    public static void i(Intent intent) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, intent) == null) {
            a = intent.getStringExtra("thread_id");
            b = intent.getStringExtra("key_ori_ugc_nid");
            c = intent.getStringExtra("key_ori_ugc_tid");
            boolean z2 = false;
            d = intent.getIntExtra("key_ori_ugc_type", 0);
            e = intent.getStringExtra("key_ori_ugc_vid");
            intent.getBooleanExtra("key_jump_to_comment_area", false);
            intent.getBooleanExtra("is_jump_from_video_middle", false);
            f = intent.getStringExtra("key_official_bar_message_id");
            Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
            if (uri != null) {
                str = uri.toString();
            } else {
                str = null;
            }
            g = str;
            h = false;
            if (BdUniDispatchSchemeController.isUniScheme(uri)) {
                h = true;
                BdUniDispatchSchemeController.getInstance().parsePbScheme(uri, j);
            } else if (StringUtils.isNull(a)) {
                h = true;
                if (uri != null) {
                    str2 = uri.toString();
                } else {
                    str2 = "";
                }
                if (!StringUtils.isNull(str2) && str2.startsWith("tbpb://")) {
                    if (uri == null) {
                        return;
                    }
                    String decode = Uri.decode(uri.getEncodedPath());
                    if (StringUtils.isNull(decode) || h(decode) == null) {
                        return;
                    }
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SCHEMA_UPLOAD);
                    httpMessage.addParam("call_url", str2);
                    MessageManager.getInstance().sendMessage(httpMessage);
                }
                if (uri != null) {
                    if (StringUtils.isNull(a)) {
                        a = uri.getQueryParameter("thread_id");
                    }
                    if (StringUtils.isNull(b)) {
                        b = uri.getQueryParameter("key_ori_ugc_nid");
                    }
                    if (StringUtils.isNull(c)) {
                        c = uri.getQueryParameter("key_ori_ugc_tid");
                    }
                    if (d == 0) {
                        d = JavaTypesHelper.toInt(uri.getQueryParameter("key_ori_ugc_type"), 0);
                    }
                    if (StringUtils.isNull(e)) {
                        e = uri.getQueryParameter("key_ori_ugc_vid");
                    }
                }
            }
            String str3 = "0";
            if (rd.isEmpty(a)) {
                a = "0";
            }
            int intExtra = intent.getIntExtra("key_start_from", 0);
            k = intExtra;
            if (intExtra == 0) {
                k = l;
            }
            m = intent.getStringExtra("post_id");
            n = intent.getStringExtra("forum_id");
            o = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            p = intent.getBooleanExtra("host_only", false);
            q = intent.getBooleanExtra("squence", true);
            int intExtra2 = intent.getIntExtra("sort_type", -1);
            r = intExtra2;
            if (intExtra2 < 0) {
                intExtra2 = SharedPrefHelper.getInstance().getInt("key_pb_current_sort_type", 2);
            }
            r = intExtra2;
            if (intExtra2 != 2) {
                str3 = m;
            }
            m = str3;
            s = intent.getStringExtra("st_type");
            t = intent.getStringExtra("locate");
            u = intent.getBooleanExtra("from_mark", false);
            v = intent.getBooleanExtra("is_pv", false);
            w = intent.getLongExtra("msg_id", 0L);
            x = intent.getStringExtra("from_forum_name");
            y = intent.getStringExtra("op_type");
            z = intent.getStringExtra("op_url");
            A = intent.getStringExtra("op_stat");
            B = intent.getBooleanExtra("from_smart_frs", false);
            if (intent.getIntExtra("request_code", -1) == 18003) {
                z2 = true;
            }
            C = z2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x0169, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L113;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int j(String[] strArr) {
        InterceptResult invokeL;
        String matchStringFromURL;
        boolean z2;
        String str;
        boolean z3;
        boolean z4;
        boolean z5;
        String str2;
        PbActivityConfig createNormalCfg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, strArr)) == null) {
            if (strArr != null && strArr.length != 0 && strArr[0] != null) {
                Pattern compile = Pattern.compile(UrlSchemaHelper.PB_URL);
                String lowerCase = strArr[0].toLowerCase();
                Matcher matcher = compile.matcher(lowerCase);
                String str3 = "push";
                if (!Pattern.compile("http[s]?://tieba\\.baidu\\.com/p/([\\d]+)\\?pid=([\\d]+)&tid=([\\d]+)&threadtype=([\\d]+)&jump_type=(.*)&jump_tieba_native=1").matcher(lowerCase).find() && !lowerCase.contains(UrlSchemaHelper.SCHEMA_TYPE_BAIJIAHAO_PB)) {
                    String str4 = "allthread";
                    String str5 = "";
                    if (matcher.find()) {
                        matchStringFromURL = matcher.group(1);
                        Uri parse = Uri.parse(lowerCase);
                        str5 = parse.getQueryParameter("pid");
                        z3 = JavaTypesHelper.toBoolean(parse.getQueryParameter("is_video"), false);
                        z5 = JavaTypesHelper.toBoolean(parse.getQueryParameter("is_official_video"), false);
                        str = parse.getQueryParameter("broadcast_id");
                        if (lowerCase != null) {
                            String[] split = lowerCase.split("&");
                            for (int i2 = 0; i2 < split.length; i2++) {
                                if (split[i2] != null) {
                                    if (split[i2].startsWith("thread_type=")) {
                                        split[i2].substring(12);
                                    } else if (split[i2].startsWith("playstatkey=")) {
                                        str3 = split[i2].substring(12);
                                    }
                                }
                            }
                            z2 = JavaTypesHelper.toBoolean(WebviewHelper.getMatchStringFromURL(lowerCase, "is_from_push="), false);
                        } else {
                            z2 = false;
                        }
                        if (lowerCase != null && lowerCase.contains("?")) {
                            String[] split2 = lowerCase.substring(lowerCase.indexOf("?") + 1, lowerCase.length()).split("&");
                            int length = split2.length;
                            int i3 = 0;
                            while (true) {
                                if (i3 >= length) {
                                    break;
                                }
                                String str6 = split2[i3];
                                if (str6.startsWith("playstatkey=")) {
                                    str3 = str6.substring(12);
                                    break;
                                }
                                i3++;
                            }
                        }
                        if (lowerCase != null) {
                            String matchStringFromURL2 = WebviewHelper.getMatchStringFromURL(lowerCase, "sttype=");
                            if (!StringUtils.isNull(matchStringFromURL2)) {
                                str4 = matchStringFromURL2;
                            }
                        }
                        z4 = true;
                    } else {
                        if (lowerCase != null && (lowerCase.startsWith(TbConfig.HTTP_PREFIX) || lowerCase.startsWith(TbConfig.HTTPS_PREFIX))) {
                            if (lowerCase.startsWith(TbConfig.HTTP_PREFIX)) {
                                str2 = lowerCase.substring(TbConfig.HTTP_PREFIX.length());
                            } else if (lowerCase.startsWith(TbConfig.HTTPS_PREFIX)) {
                                str2 = lowerCase.substring(TbConfig.HTTPS_PREFIX.length());
                            } else {
                                str2 = null;
                            }
                            if (str2 != null) {
                                String[] split3 = str2.split("&");
                                int i4 = 0;
                                while (true) {
                                    if (i4 < split3.length) {
                                        if (split3[i4] != null && split3[i4].startsWith("kz=")) {
                                            matchStringFromURL = split3[i4].substring(3);
                                            break;
                                        }
                                        i4++;
                                    } else {
                                        matchStringFromURL = null;
                                        break;
                                    }
                                }
                                if (!TextUtils.isEmpty(matchStringFromURL) && matchStringFromURL.contains("&")) {
                                    matchStringFromURL = matchStringFromURL.split("&")[0];
                                }
                            }
                            matchStringFromURL = null;
                        } else {
                            if (!TextUtils.isEmpty(lowerCase) && lowerCase.startsWith(UrlSchemaHelper.SCHEMA_TYPE_PB)) {
                                String substring = lowerCase.substring(3);
                                if (strArr.length > 1) {
                                    str4 = strArr[1];
                                    matchStringFromURL = substring;
                                } else {
                                    matchStringFromURL = substring;
                                }
                            } else if (!TextUtils.isEmpty(lowerCase) && lowerCase.startsWith("com.baidu.tieba://?kz=")) {
                                matchStringFromURL = lowerCase.substring(22);
                            } else if (!TextUtils.isEmpty(lowerCase) && lowerCase.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && lowerCase.contains("kz=")) {
                                matchStringFromURL = WebviewHelper.getMatchStringFromURL(lowerCase, "kz=");
                            } else {
                                return 3;
                            }
                            z2 = false;
                            str = null;
                            z3 = false;
                            str4 = null;
                            z4 = true;
                            z5 = false;
                        }
                        z2 = false;
                        str = null;
                        z3 = false;
                        z4 = true;
                        z5 = false;
                    }
                    if (!StringUtils.isNull(matchStringFromURL, z4) && !z3 && !z5) {
                        if (StringUtils.isNull(str5)) {
                            createNormalCfg = new PbActivityConfig(TbadkCoreApplication.getInst()).createNormalCfg(matchStringFromURL, null, str4);
                        } else {
                            createNormalCfg = new PbActivityConfig(TbadkCoreApplication.getInst()).createNormalCfg(matchStringFromURL, str5, str4);
                        }
                        if (!TextUtils.isEmpty(lowerCase) && lowerCase.contains(BigImgPbActivityConfig.OPEN_COMMON) && "1".equals(WebviewHelper.getMatchStringFromURL(lowerCase, BigImgPbActivityConfig.OPEN_COMMON))) {
                            createNormalCfg.setUserName(WebviewHelper.getMatchStringFromURL(lowerCase, BigImgPbActivityConfig.BIG_PB_USER_NAME));
                        }
                        createNormalCfg.setVideo_source(str3);
                        createNormalCfg.setStartFrom(25);
                        if (z2) {
                            createNormalCfg.setFromPushNotify();
                            createNormalCfg.setStartFrom(7);
                        }
                        if (lowerCase != null && lowerCase.contains(UrlSchemaHelper.FROM_YUN_PUSH)) {
                            createNormalCfg.setStartFrom(7);
                        }
                        if (!StringUtils.isNull(str)) {
                            createNormalCfg.setOfficialBarMessageId(str);
                        }
                        if (lowerCase != null && lowerCase.contains("fr=collect")) {
                            createNormalCfg.setJumpToCommentArea(true);
                        }
                        D = createNormalCfg;
                        return 0;
                    }
                    return 3;
                }
                return 3;
            }
            return 3;
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x012e A[Catch: Exception -> 0x0241, TryCatch #0 {Exception -> 0x0241, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:96:0x0228, B:97:0x022d, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:106:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0132 A[Catch: Exception -> 0x0241, TryCatch #0 {Exception -> 0x0241, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:96:0x0228, B:97:0x022d, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:106:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013c A[Catch: Exception -> 0x0241, TryCatch #0 {Exception -> 0x0241, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:96:0x0228, B:97:0x022d, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:106:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0172 A[Catch: Exception -> 0x0241, TryCatch #0 {Exception -> 0x0241, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:96:0x0228, B:97:0x022d, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:106:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x017a A[Catch: Exception -> 0x0241, TryCatch #0 {Exception -> 0x0241, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:96:0x0228, B:97:0x022d, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:106:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0189 A[Catch: Exception -> 0x0241, TryCatch #0 {Exception -> 0x0241, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:96:0x0228, B:97:0x022d, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:106:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x018d A[Catch: Exception -> 0x0241, TryCatch #0 {Exception -> 0x0241, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:96:0x0228, B:97:0x022d, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:106:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0194 A[Catch: Exception -> 0x0241, TryCatch #0 {Exception -> 0x0241, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:96:0x0228, B:97:0x022d, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:106:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01c1 A[Catch: Exception -> 0x0241, TryCatch #0 {Exception -> 0x0241, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:96:0x0228, B:97:0x022d, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:106:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d1 A[Catch: Exception -> 0x0241, TryCatch #0 {Exception -> 0x0241, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:96:0x0228, B:97:0x022d, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:106:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0228 A[Catch: Exception -> 0x0241, TryCatch #0 {Exception -> 0x0241, blocks: (B:9:0x0029, B:11:0x002d, B:14:0x0037, B:18:0x009f, B:20:0x00af, B:21:0x00b2, B:23:0x00bf, B:24:0x00c2, B:26:0x00c6, B:27:0x00cb, B:29:0x00cf, B:30:0x00d4, B:32:0x00d8, B:33:0x00e7, B:35:0x00eb, B:36:0x00ee, B:38:0x00f2, B:39:0x010a, B:41:0x0111, B:44:0x0116, B:46:0x011d, B:48:0x0124, B:54:0x012e, B:56:0x0138, B:58:0x013c, B:59:0x0141, B:63:0x0167, B:65:0x0172, B:67:0x017f, B:69:0x0189, B:71:0x0190, B:73:0x0194, B:75:0x0199, B:78:0x019e, B:80:0x01a5, B:82:0x01c1, B:83:0x01ca, B:85:0x01d1, B:87:0x01db, B:94:0x01f2, B:96:0x0228, B:97:0x022d, B:90:0x01e6, B:79:0x01a2, B:70:0x018d, B:66:0x017a, B:55:0x0132, B:45:0x011a), top: B:106:0x0029 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void k() {
        int i2;
        boolean z2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
            pbPageRequestMessage.setUpdateType(3);
            pbPageRequestMessage.setIsReqAd(1);
            pbPageRequestMessage.setLastids(qd5.l);
            if (p || u) {
                C = false;
            }
            try {
                if (a != null && a.length() != 0) {
                    pbPageRequestMessage.set_kz(JavaTypesHelper.toLong(a, 0L));
                    pbPageRequestMessage.setFloorSortType(1);
                    pbPageRequestMessage.setFloor_rn(4);
                    pbPageRequestMessage.set_rn(15);
                    pbPageRequestMessage.set_with_floor(1);
                    pbPageRequestMessage.set_scr_w(Integer.valueOf(BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
                    pbPageRequestMessage.set_scr_h(Integer.valueOf(BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
                    pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
                    if (TbImageHelper.getInstance().isShowBigImage()) {
                        i2 = 2;
                    } else {
                        i2 = 1;
                    }
                    pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
                    pbPageRequestMessage.setSchemeUrl(g);
                    if (!q) {
                        pbPageRequestMessage.set_r(1);
                    }
                    pbPageRequestMessage.set_r(Integer.valueOf(r));
                    if (p) {
                        pbPageRequestMessage.set_lz(1);
                    }
                    if (s != null) {
                        pbPageRequestMessage.set_st_type(s);
                    }
                    if (t != null) {
                        pbPageRequestMessage.setLocate(t);
                    }
                    if (v) {
                        pbPageRequestMessage.set_message_id(Integer.valueOf((int) w));
                        pbPageRequestMessage.set_message_click("1");
                    }
                    if (C) {
                        pbPageRequestMessage.set_banner(1);
                    }
                    if (y != null) {
                        pbPageRequestMessage.setOpType(y);
                        pbPageRequestMessage.setOpUrl(z);
                        pbPageRequestMessage.setOpStat(JavaTypesHelper.toInt(A, 0));
                        pbPageRequestMessage.setOpMessageID(w);
                    }
                    pbPageRequestMessage.setNeedIsTopAndIsGood(0);
                    if (!u && !p) {
                        pbPageRequestMessage.set_banner(1);
                        pbPageRequestMessage.set_back(0);
                        if (r != 0 && r != 2) {
                            z2 = false;
                            if (!z2) {
                                pbPageRequestMessage.set_pn(1);
                            } else {
                                pbPageRequestMessage.set_last(1);
                                pbPageRequestMessage.set_pn(1);
                            }
                            if (u) {
                                pbPageRequestMessage.set_st_type("store_thread");
                            }
                            m(pbPageRequestMessage);
                            pbPageRequestMessage.setIsFromMark(Boolean.valueOf(u));
                            pbPageRequestMessage.setCacheKey(f());
                            pbPageRequestMessage.setObjParam1(String.valueOf(k));
                            pbPageRequestMessage.setIsSubPostDataReverse(false);
                            if (!B) {
                                i3 = 1;
                            } else {
                                i3 = 0;
                            }
                            pbPageRequestMessage.setFromSmartFrs(i3);
                            if (!UtilHelper.isUgcThreadType(d)) {
                                pbPageRequestMessage.setForumId(String.valueOf(0));
                            } else {
                                pbPageRequestMessage.setForumId(n);
                            }
                            pbPageRequestMessage.setNeedRepostRecommendForum(o);
                            if (k != 7) {
                                pbPageRequestMessage.setFrom_push(1);
                            } else {
                                pbPageRequestMessage.setFrom_push(0);
                            }
                            if (k != 7 && k != 5 && !h) {
                                pbPageRequestMessage.setSourceType(2);
                                pbPageRequestMessage.setOriUgcNid(b);
                                pbPageRequestMessage.setOriUgcTid(c);
                                pbPageRequestMessage.setOriUgcType(d);
                                pbPageRequestMessage.setOriUgcVid(e);
                                if (!StringUtils.isNull(f)) {
                                    pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(f));
                                }
                                int i4 = -1;
                                if (pbPageRequestMessage.getPn() != null) {
                                    if (pbPageRequestMessage.getR().intValue() == 1) {
                                        if (pbPageRequestMessage.getPn().intValue() == 1) {
                                            pbPageRequestMessage.setAfterAdThreadCount(i4);
                                            pbPageRequestMessage.setImmersionVideoCommentSource(0);
                                            pbPageRequestMessage.setReqFoldComment(false);
                                            pbPageRequestMessage.setTag(z30.d);
                                            pbPageRequestMessage.getHttpMessage().addHeader("thread_id", a);
                                            pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                                            pbPageRequestMessage.setFromPbOptimize(true);
                                            int i5 = PbPageRequestMessage.requestTimes;
                                            PbPageRequestMessage.requestTimes = i5 + 1;
                                            pbPageRequestMessage.setRequestTimes(i5);
                                            if (!UbsABTestHelper.isPbReplyOptimize()) {
                                                pbPageRequestMessage.setLastPid(-1L);
                                            }
                                            MessageManager.getInstance().registerListener(E);
                                            z30.e(pbPageRequestMessage.getHttpMessage(), i);
                                        }
                                    } else if (pbPageRequestMessage.getPn().intValue() == 1) {
                                        pbPageRequestMessage.setAfterAdThreadCount(i4);
                                        pbPageRequestMessage.setImmersionVideoCommentSource(0);
                                        pbPageRequestMessage.setReqFoldComment(false);
                                        pbPageRequestMessage.setTag(z30.d);
                                        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", a);
                                        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                                        pbPageRequestMessage.setFromPbOptimize(true);
                                        int i52 = PbPageRequestMessage.requestTimes;
                                        PbPageRequestMessage.requestTimes = i52 + 1;
                                        pbPageRequestMessage.setRequestTimes(i52);
                                        if (!UbsABTestHelper.isPbReplyOptimize()) {
                                        }
                                        MessageManager.getInstance().registerListener(E);
                                        z30.e(pbPageRequestMessage.getHttpMessage(), i);
                                    }
                                }
                                i4 = 0;
                                pbPageRequestMessage.setAfterAdThreadCount(i4);
                                pbPageRequestMessage.setImmersionVideoCommentSource(0);
                                pbPageRequestMessage.setReqFoldComment(false);
                                pbPageRequestMessage.setTag(z30.d);
                                pbPageRequestMessage.getHttpMessage().addHeader("thread_id", a);
                                pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                                pbPageRequestMessage.setFromPbOptimize(true);
                                int i522 = PbPageRequestMessage.requestTimes;
                                PbPageRequestMessage.requestTimes = i522 + 1;
                                pbPageRequestMessage.setRequestTimes(i522);
                                if (!UbsABTestHelper.isPbReplyOptimize()) {
                                }
                                MessageManager.getInstance().registerListener(E);
                                z30.e(pbPageRequestMessage.getHttpMessage(), i);
                            }
                            pbPageRequestMessage.setSourceType(1);
                            pbPageRequestMessage.setOriUgcNid(b);
                            pbPageRequestMessage.setOriUgcTid(c);
                            pbPageRequestMessage.setOriUgcType(d);
                            pbPageRequestMessage.setOriUgcVid(e);
                            if (!StringUtils.isNull(f)) {
                            }
                            int i42 = -1;
                            if (pbPageRequestMessage.getPn() != null) {
                            }
                            i42 = 0;
                            pbPageRequestMessage.setAfterAdThreadCount(i42);
                            pbPageRequestMessage.setImmersionVideoCommentSource(0);
                            pbPageRequestMessage.setReqFoldComment(false);
                            pbPageRequestMessage.setTag(z30.d);
                            pbPageRequestMessage.getHttpMessage().addHeader("thread_id", a);
                            pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                            pbPageRequestMessage.setFromPbOptimize(true);
                            int i5222 = PbPageRequestMessage.requestTimes;
                            PbPageRequestMessage.requestTimes = i5222 + 1;
                            pbPageRequestMessage.setRequestTimes(i5222);
                            if (!UbsABTestHelper.isPbReplyOptimize()) {
                            }
                            MessageManager.getInstance().registerListener(E);
                            z30.e(pbPageRequestMessage.getHttpMessage(), i);
                        }
                        z2 = true;
                        if (!z2) {
                        }
                        if (u) {
                        }
                        m(pbPageRequestMessage);
                        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(u));
                        pbPageRequestMessage.setCacheKey(f());
                        pbPageRequestMessage.setObjParam1(String.valueOf(k));
                        pbPageRequestMessage.setIsSubPostDataReverse(false);
                        if (!B) {
                        }
                        pbPageRequestMessage.setFromSmartFrs(i3);
                        if (!UtilHelper.isUgcThreadType(d)) {
                        }
                        pbPageRequestMessage.setNeedRepostRecommendForum(o);
                        if (k != 7) {
                        }
                        if (k != 7) {
                            pbPageRequestMessage.setSourceType(2);
                            pbPageRequestMessage.setOriUgcNid(b);
                            pbPageRequestMessage.setOriUgcTid(c);
                            pbPageRequestMessage.setOriUgcType(d);
                            pbPageRequestMessage.setOriUgcVid(e);
                            if (!StringUtils.isNull(f)) {
                            }
                            int i422 = -1;
                            if (pbPageRequestMessage.getPn() != null) {
                            }
                            i422 = 0;
                            pbPageRequestMessage.setAfterAdThreadCount(i422);
                            pbPageRequestMessage.setImmersionVideoCommentSource(0);
                            pbPageRequestMessage.setReqFoldComment(false);
                            pbPageRequestMessage.setTag(z30.d);
                            pbPageRequestMessage.getHttpMessage().addHeader("thread_id", a);
                            pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                            pbPageRequestMessage.setFromPbOptimize(true);
                            int i52222 = PbPageRequestMessage.requestTimes;
                            PbPageRequestMessage.requestTimes = i52222 + 1;
                            pbPageRequestMessage.setRequestTimes(i52222);
                            if (!UbsABTestHelper.isPbReplyOptimize()) {
                            }
                            MessageManager.getInstance().registerListener(E);
                            z30.e(pbPageRequestMessage.getHttpMessage(), i);
                        }
                        pbPageRequestMessage.setSourceType(1);
                        pbPageRequestMessage.setOriUgcNid(b);
                        pbPageRequestMessage.setOriUgcTid(c);
                        pbPageRequestMessage.setOriUgcType(d);
                        pbPageRequestMessage.setOriUgcVid(e);
                        if (!StringUtils.isNull(f)) {
                        }
                        int i4222 = -1;
                        if (pbPageRequestMessage.getPn() != null) {
                        }
                        i4222 = 0;
                        pbPageRequestMessage.setAfterAdThreadCount(i4222);
                        pbPageRequestMessage.setImmersionVideoCommentSource(0);
                        pbPageRequestMessage.setReqFoldComment(false);
                        pbPageRequestMessage.setTag(z30.d);
                        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", a);
                        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                        pbPageRequestMessage.setFromPbOptimize(true);
                        int i522222 = PbPageRequestMessage.requestTimes;
                        PbPageRequestMessage.requestTimes = i522222 + 1;
                        pbPageRequestMessage.setRequestTimes(i522222);
                        if (!UbsABTestHelper.isPbReplyOptimize()) {
                        }
                        MessageManager.getInstance().registerListener(E);
                        z30.e(pbPageRequestMessage.getHttpMessage(), i);
                    }
                    pbPageRequestMessage.set_banner(0);
                    pbPageRequestMessage.set_back(0);
                    if (r != 0) {
                        z2 = false;
                        if (!z2) {
                        }
                        if (u) {
                        }
                        m(pbPageRequestMessage);
                        pbPageRequestMessage.setIsFromMark(Boolean.valueOf(u));
                        pbPageRequestMessage.setCacheKey(f());
                        pbPageRequestMessage.setObjParam1(String.valueOf(k));
                        pbPageRequestMessage.setIsSubPostDataReverse(false);
                        if (!B) {
                        }
                        pbPageRequestMessage.setFromSmartFrs(i3);
                        if (!UtilHelper.isUgcThreadType(d)) {
                        }
                        pbPageRequestMessage.setNeedRepostRecommendForum(o);
                        if (k != 7) {
                        }
                        if (k != 7) {
                        }
                        pbPageRequestMessage.setSourceType(1);
                        pbPageRequestMessage.setOriUgcNid(b);
                        pbPageRequestMessage.setOriUgcTid(c);
                        pbPageRequestMessage.setOriUgcType(d);
                        pbPageRequestMessage.setOriUgcVid(e);
                        if (!StringUtils.isNull(f)) {
                        }
                        int i42222 = -1;
                        if (pbPageRequestMessage.getPn() != null) {
                        }
                        i42222 = 0;
                        pbPageRequestMessage.setAfterAdThreadCount(i42222);
                        pbPageRequestMessage.setImmersionVideoCommentSource(0);
                        pbPageRequestMessage.setReqFoldComment(false);
                        pbPageRequestMessage.setTag(z30.d);
                        pbPageRequestMessage.getHttpMessage().addHeader("thread_id", a);
                        pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                        pbPageRequestMessage.setFromPbOptimize(true);
                        int i5222222 = PbPageRequestMessage.requestTimes;
                        PbPageRequestMessage.requestTimes = i5222222 + 1;
                        pbPageRequestMessage.setRequestTimes(i5222222);
                        if (!UbsABTestHelper.isPbReplyOptimize()) {
                        }
                        MessageManager.getInstance().registerListener(E);
                        z30.e(pbPageRequestMessage.getHttpMessage(), i);
                    }
                    z2 = true;
                    if (!z2) {
                    }
                    if (u) {
                    }
                    m(pbPageRequestMessage);
                    pbPageRequestMessage.setIsFromMark(Boolean.valueOf(u));
                    pbPageRequestMessage.setCacheKey(f());
                    pbPageRequestMessage.setObjParam1(String.valueOf(k));
                    pbPageRequestMessage.setIsSubPostDataReverse(false);
                    if (!B) {
                    }
                    pbPageRequestMessage.setFromSmartFrs(i3);
                    if (!UtilHelper.isUgcThreadType(d)) {
                    }
                    pbPageRequestMessage.setNeedRepostRecommendForum(o);
                    if (k != 7) {
                    }
                    if (k != 7) {
                    }
                    pbPageRequestMessage.setSourceType(1);
                    pbPageRequestMessage.setOriUgcNid(b);
                    pbPageRequestMessage.setOriUgcTid(c);
                    pbPageRequestMessage.setOriUgcType(d);
                    pbPageRequestMessage.setOriUgcVid(e);
                    if (!StringUtils.isNull(f)) {
                    }
                    int i422222 = -1;
                    if (pbPageRequestMessage.getPn() != null) {
                    }
                    i422222 = 0;
                    pbPageRequestMessage.setAfterAdThreadCount(i422222);
                    pbPageRequestMessage.setImmersionVideoCommentSource(0);
                    pbPageRequestMessage.setReqFoldComment(false);
                    pbPageRequestMessage.setTag(z30.d);
                    pbPageRequestMessage.getHttpMessage().addHeader("thread_id", a);
                    pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                    pbPageRequestMessage.setFromPbOptimize(true);
                    int i52222222 = PbPageRequestMessage.requestTimes;
                    PbPageRequestMessage.requestTimes = i52222222 + 1;
                    pbPageRequestMessage.setRequestTimes(i52222222);
                    if (!UbsABTestHelper.isPbReplyOptimize()) {
                    }
                    MessageManager.getInstance().registerListener(E);
                    z30.e(pbPageRequestMessage.getHttpMessage(), i);
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }
}
