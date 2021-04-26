package com.baidu.wallet.home.storage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.apollon.utils.FileCopyUtils;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.support.Base64;
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
import org.json.JSONException;
/* loaded from: classes5.dex */
public class HomeDataCacheManager {

    /* renamed from: c  reason: collision with root package name */
    public static String f24983c;

    /* renamed from: a  reason: collision with root package name */
    public final String f24984a;

    /* renamed from: b  reason: collision with root package name */
    public final String f24985b;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static HomeDataCacheManager f24986a = new HomeDataCacheManager();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:49:0x008d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r6v4 */
    private String a(Context context, String str) {
        FileReader fileReader;
        IOException e2;
        FileNotFoundException e3;
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        File file = new File(context.getCacheDir() + "/" + ((String) str));
        FileReader fileReader2 = null;
        try {
        } catch (Throwable th) {
            th = th;
        }
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
            } catch (IOException e8) {
                e8.printStackTrace();
            }
        } catch (FileNotFoundException e9) {
            fileReader = null;
            e3 = e9;
        } catch (IOException e10) {
            fileReader = null;
            e2 = e10;
        } catch (Throwable th2) {
            str = 0;
            th = th2;
            if (str != 0) {
                try {
                    str.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            }
            throw th;
        }
        if (fileReader2 != null) {
            fileReader2.close();
        }
        return "";
    }

    public static HomeDataCacheManager getInstance() {
        return a.f24986a;
    }

    public synchronized String getPpKey(Context context) {
        if (TextUtils.isEmpty(f24983c)) {
            f24983c = PayPreferenceManager.getNewPpKey(context);
        }
        return f24983c;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:51:0x00a6 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:98:0x0001 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    public HomeCfgResponse getResponseFromAsset(Context context, String str) {
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        InputStream open;
        InputStreamReader inputStreamReader2;
        HomeCfgDataModel homeCfgDataModel;
        HomeCfgResponse homeCfgResponse = null;
        homeCfgResponse = null;
        homeCfgResponse = null;
        homeCfgResponse = null;
        r0 = null;
        InputStreamReader inputStreamReader3 = null;
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
                } catch (Throwable th2) {
                    th = th2;
                    inputStreamReader3 = inputStreamReader;
                    inputStream = str;
                }
                try {
                    String copyToString = FileCopyUtils.copyToString(inputStreamReader2);
                    if (!TextUtils.isEmpty(copyToString) && (homeCfgDataModel = (HomeCfgDataModel) JsonUtils.fromJson(copyToString, HomeCfgDataModel.class)) != null) {
                        homeCfgResponse = homeCfgDataModel.content;
                    }
                    try {
                        inputStreamReader2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                } catch (FileNotFoundException e6) {
                    str = open;
                    e = e6;
                    inputStreamReader = inputStreamReader2;
                    e.printStackTrace();
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (str != 0) {
                        str.close();
                    }
                    return homeCfgResponse;
                } catch (IOException e8) {
                    str = open;
                    e = e8;
                    inputStreamReader = inputStreamReader2;
                    e.printStackTrace();
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                    }
                    if (str != null) {
                        str.close();
                    }
                    return homeCfgResponse;
                } catch (JSONException e10) {
                    str = open;
                    e = e10;
                    inputStreamReader = inputStreamReader2;
                    e.printStackTrace();
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                    }
                    if (str != null) {
                        str.close();
                    }
                    return homeCfgResponse;
                } catch (Throwable th3) {
                    inputStream = open;
                    th = th3;
                    inputStreamReader3 = inputStreamReader2;
                    if (inputStreamReader3 != null) {
                        try {
                            inputStreamReader3.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e13) {
                            e13.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e14) {
                e = e14;
                str = 0;
                inputStreamReader = null;
            } catch (IOException e15) {
                e = e15;
                str = null;
                inputStreamReader = null;
            } catch (JSONException e16) {
                e = e16;
                str = null;
                inputStreamReader = null;
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
            }
            if (open != null) {
                open.close();
            }
        } catch (IOException e17) {
            e17.printStackTrace();
        }
        return homeCfgResponse;
    }

    public HomeCfgResponse getResponseFromCache(Context context, String str) {
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

    public void saveResponseDataToCache(Context context, HomeCfgResponse homeCfgResponse, String str) {
        if (homeCfgResponse == null || !homeCfgResponse.doCheckValidity()) {
            return;
        }
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

    public synchronized void synPPkey(Context context) {
        f24983c = PayPreferenceManager.getNewPpKey(context);
    }

    public HomeDataCacheManager() {
        this.f24984a = "wallet_home_";
        this.f24985b = StringUtil.NULL_STRING;
    }
}
