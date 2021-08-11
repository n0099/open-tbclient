package com.baidu.wallet.home.storage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.FileCopyUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.support.Base64;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.WalletHomeBeanConstants;
import com.baidu.wallet.home.beans.HomeCfgBean;
import com.baidu.wallet.home.datamodel.HomeCfgDataModel;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.paysdk.storage.PayPreferenceManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.json.JSONException;
/* loaded from: classes8.dex */
public class HomeDataCacheManager {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static String f60885c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f60886a;

    /* renamed from: b  reason: collision with root package name */
    public final String f60887b;

    /* renamed from: com.baidu.wallet.home.storage.HomeDataCacheManager$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static HomeDataCacheManager f60888a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(835979438, "Lcom/baidu/wallet/home/storage/HomeDataCacheManager$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(835979438, "Lcom/baidu/wallet/home/storage/HomeDataCacheManager$a;");
                    return;
                }
            }
            f60888a = new HomeDataCacheManager(null);
        }
    }

    public /* synthetic */ HomeDataCacheManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:51:0x0091 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.CharSequence, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.Reader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(Context context, String str) {
        InterceptResult invokeLL;
        Throwable th;
        FileReader fileReader;
        IOException e2;
        FileNotFoundException e3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return "";
            }
            File file = new File(context.getCacheDir() + "/" + ((String) str));
            FileReader fileReader2 = null;
            try {
                try {
                    try {
                        if (file.exists() && file.isFile()) {
                            fileReader = new FileReader(file);
                            try {
                                String copyToString = FileCopyUtils.copyToString(fileReader);
                                if (!TextUtils.isEmpty(copyToString)) {
                                    try {
                                        byte[] decode = Base64.decode(copyToString);
                                        if (decode != null) {
                                            String str2 = new String(decode);
                                            try {
                                                fileReader.close();
                                            } catch (IOException e4) {
                                                e4.printStackTrace();
                                            }
                                            return str2;
                                        }
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                fileReader2 = fileReader;
                            } catch (FileNotFoundException e6) {
                                e3 = e6;
                                e3.printStackTrace();
                                if (fileReader != null) {
                                    fileReader.close();
                                }
                                return "";
                            } catch (IOException e7) {
                                e2 = e7;
                                e2.printStackTrace();
                                if (fileReader != null) {
                                    fileReader.close();
                                }
                                return "";
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (str != 0) {
                            try {
                                str.close();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e9) {
                    fileReader = null;
                    e3 = e9;
                } catch (IOException e10) {
                    fileReader = null;
                    e2 = e10;
                } catch (Throwable th3) {
                    str = 0;
                    th = th3;
                    if (str != 0) {
                    }
                    throw th;
                }
                if (fileReader2 != null) {
                    fileReader2.close();
                }
            } catch (IOException e11) {
                e11.printStackTrace();
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static HomeDataCacheManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.f60888a : (HomeDataCacheManager) invokeV.objValue;
    }

    public synchronized String getPpKey(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(f60885c)) {
                    f60885c = PayPreferenceManager.getNewPpKey(context);
                }
                str = f60885c;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:109:0x0005 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:53:0x00aa */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v23, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v26, types: [com.baidu.wallet.home.datamodel.HomeCfgDataModel] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v29, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v36 */
    public HomeCfgResponse getResponseFromAsset(Context context, String str) {
        InterceptResult invokeLL;
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        InputStream open;
        InputStreamReader inputStreamReader2;
        InputStreamReader inputStreamReader3;
        InputStreamReader inputStreamReader4;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str)) != null) {
            return (HomeCfgResponse) invokeLL.objValue;
        }
        HomeCfgResponse homeCfgResponse = null;
        homeCfgResponse = null;
        homeCfgResponse = null;
        homeCfgResponse = null;
        homeCfgResponse = null;
        homeCfgResponse = null;
        homeCfgResponse = null;
        homeCfgResponse = null;
        homeCfgResponse = null;
        r0 = null;
        Reader reader = null;
        try {
            try {
                try {
                    if (HomeCfgBean.PAGE_FINANCE.equals(str)) {
                        open = context.getAssets().open(WalletHomeBeanConstants.CONFIG_CACHE_ASSETS_FOR_FINANCE);
                    } else if (HomeCfgBean.PAGE_CREDIT.equals(str)) {
                        open = context.getAssets().open(WalletHomeBeanConstants.CONFIG_CACHE_ASSETS_FOR_UMONEY);
                    } else {
                        open = context.getAssets().open(WalletHomeBeanConstants.CONFIG_CACHE_DIR);
                    }
                    try {
                        inputStreamReader2 = new InputStreamReader(open);
                    } catch (FileNotFoundException e2) {
                        inputStreamReader = null;
                        str = open;
                        e = e2;
                    } catch (IOException e3) {
                        inputStreamReader = null;
                        str = open;
                        e = e3;
                    } catch (JSONException e4) {
                        inputStreamReader = null;
                        str = open;
                        e = e4;
                    } catch (Throwable th) {
                        inputStream = open;
                        th = th;
                    }
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                try {
                    ?? copyToString = FileCopyUtils.copyToString(inputStreamReader2);
                    boolean isEmpty = TextUtils.isEmpty(copyToString);
                    inputStreamReader3 = copyToString;
                    if (!isEmpty) {
                        ?? r1 = (HomeCfgDataModel) JsonUtils.fromJson(copyToString, HomeCfgDataModel.class);
                        inputStreamReader3 = r1;
                        if (r1 != 0) {
                            homeCfgResponse = r1.content;
                            inputStreamReader3 = r1;
                        }
                    }
                    try {
                        inputStreamReader2.close();
                        inputStreamReader4 = inputStreamReader2;
                    } catch (IOException e6) {
                        e6.printStackTrace();
                        inputStreamReader4 = e6;
                    }
                } catch (FileNotFoundException e7) {
                    str = open;
                    e = e7;
                    inputStreamReader = inputStreamReader2;
                    e.printStackTrace();
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    if (str != null) {
                        str.close();
                        inputStreamReader = inputStreamReader;
                        str = str;
                    }
                    return homeCfgResponse;
                } catch (IOException e9) {
                    str = open;
                    e = e9;
                    inputStreamReader = inputStreamReader2;
                    e.printStackTrace();
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    if (str != null) {
                        str.close();
                        inputStreamReader = inputStreamReader;
                        str = str;
                    }
                    return homeCfgResponse;
                } catch (JSONException e11) {
                    str = open;
                    e = e11;
                    inputStreamReader = inputStreamReader2;
                    e.printStackTrace();
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                    if (str != null) {
                        str.close();
                        inputStreamReader = inputStreamReader;
                        str = str;
                    }
                    return homeCfgResponse;
                } catch (Throwable th2) {
                    inputStream = open;
                    th = th2;
                    reader = inputStreamReader2;
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e13) {
                            e13.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e14) {
                            e14.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e15) {
                e = e15;
                str = null;
                inputStreamReader = null;
            } catch (IOException e16) {
                e = e16;
                str = null;
                inputStreamReader = null;
            } catch (JSONException e17) {
                e = e17;
                str = null;
                inputStreamReader = null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
            if (open != null) {
                open.close();
                inputStreamReader = inputStreamReader3;
                str = inputStreamReader4;
            }
            return homeCfgResponse;
        } catch (Throwable th4) {
            th = th4;
            reader = inputStreamReader;
            inputStream = str;
        }
    }

    public HomeCfgResponse getResponseFromCache(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) {
            synPPkey(context);
            String ppKey = getPpKey(context);
            HomeCfgResponse homeCfgResponse = null;
            if (!TextUtils.isEmpty(ppKey)) {
                String str2 = "wallet_home_" + ppKey + "_" + WalletHomeBeanConstants.CONFIG_CACHE_DIR_NEW;
                if (HomeCfgBean.PAGE_FINANCE.equals(str)) {
                    str2 = "wallet_home_" + ppKey + "_" + WalletHomeBeanConstants.CONFIG_CACHE_DIR_FOR_FINANCE;
                } else if (HomeCfgBean.PAGE_CREDIT.equals(str)) {
                    str2 = "wallet_home_" + ppKey + "_" + WalletHomeBeanConstants.CONFIG_CACHE_DIR_FOR_UMONEY;
                }
                String a2 = a(context, str2);
                if (!TextUtils.isEmpty(a2)) {
                    try {
                        homeCfgResponse = (HomeCfgResponse) JsonUtils.fromJson(a2, HomeCfgResponse.class);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                if (homeCfgResponse != null && homeCfgResponse.doCheckValidity()) {
                    return homeCfgResponse;
                }
            }
            String str3 = "wallet_home_" + StringUtil.NULL_STRING + "_" + WalletHomeBeanConstants.CONFIG_CACHE_DIR_NEW;
            if (HomeCfgBean.PAGE_FINANCE.equals(str)) {
                str3 = "wallet_home_" + StringUtil.NULL_STRING + "_" + WalletHomeBeanConstants.CONFIG_CACHE_DIR_FOR_FINANCE;
            } else if (HomeCfgBean.PAGE_CREDIT.equals(str)) {
                str3 = "wallet_home_" + StringUtil.NULL_STRING + "_" + WalletHomeBeanConstants.CONFIG_CACHE_DIR_FOR_UMONEY;
            }
            String a3 = a(context, str3);
            if (!TextUtils.isEmpty(a3)) {
                try {
                    homeCfgResponse = (HomeCfgResponse) JsonUtils.fromJson(a3, HomeCfgResponse.class);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            return (homeCfgResponse == null || !homeCfgResponse.doCheckValidity()) ? getResponseFromAsset(context, str) : homeCfgResponse;
        }
        return (HomeCfgResponse) invokeLL.objValue;
    }

    public void saveResponseDataToCache(Context context, HomeCfgResponse homeCfgResponse, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048579, this, context, homeCfgResponse, str) == null) && homeCfgResponse != null && homeCfgResponse.doCheckValidity()) {
            String json = JsonUtils.toJson(homeCfgResponse);
            if (TextUtils.isEmpty(json)) {
                return;
            }
            String encodeBytes = Base64.encodeBytes(json.getBytes());
            String ppKey = getPpKey(context);
            if (!homeCfgResponse.isLogin()) {
                ppKey = StringUtil.NULL_STRING;
            } else if (TextUtils.isEmpty(ppKey)) {
                return;
            }
            String str2 = "wallet_home_" + ppKey + "_" + WalletHomeBeanConstants.CONFIG_CACHE_DIR_NEW;
            if (HomeCfgBean.PAGE_FINANCE.equals(str)) {
                str2 = "wallet_home_" + ppKey + "_" + WalletHomeBeanConstants.CONFIG_CACHE_DIR_FOR_FINANCE;
            } else if (HomeCfgBean.PAGE_CREDIT.equals(str)) {
                str2 = "wallet_home_" + ppKey + "_" + WalletHomeBeanConstants.CONFIG_CACHE_DIR_FOR_UMONEY;
            }
            FileCopyUtils.copyToFile(encodeBytes, new File(context.getCacheDir() + "/" + str2));
        }
    }

    public synchronized void synPPkey(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            synchronized (this) {
                f60885c = PayPreferenceManager.getNewPpKey(context);
            }
        }
    }

    public HomeDataCacheManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60886a = "wallet_home_";
        this.f60887b = StringUtil.NULL_STRING;
    }
}
