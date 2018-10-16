package com.baidu.webkit.internal.daemon;

import android.content.Context;
import com.baidu.webkit.internal.ABTestConstants;
import com.baidu.webkit.internal.CfgFileUtils;
import com.baidu.webkit.internal.ConectivityUtils;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import com.baidu.webkit.net.BdNet;
import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.net.INetListener;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebKitFactory;
import com.baidu.webkit.sdk.WebViewFactory;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class MLModel implements INoProGuard, INetListener {
    private static final String LOG_TAG = "MLModel";
    private static final String ML_MODEL_URL = "https://browserkernel.baidu.com/ml_model/";
    private static final String MODEL_NAME_DITING = "diting20";
    private static final String MODEL_NAME_FAKE_BAIDU = "fakeBaidu25";
    private static final String MODEL_NAME_HISTORY_HIJACK = "evilPage15";
    private static final String MODEL_NAME_MAGIC_FILTER = "magicFilter10";
    private static final String MODEL_NAME_MAGIC_FILTER_3_0 = "magicFilter30";
    private static final String MODEL_NAME_STOP_WORDS = "stopwords";
    private static List<String> mModelList;
    private static Map<String, Boolean> mModelMap;
    private static boolean sMagicFilterABTestEnable = false;
    private Context mContext;
    private String mModelName;
    private ByteArrayOutputStream mStream = null;
    private String mLastModified = null;
    private String mModel = null;
    private boolean mGetMF30Model = false;

    static {
        mModelList = null;
        mModelMap = null;
        HashMap hashMap = new HashMap();
        mModelMap = hashMap;
        hashMap.put(MODEL_NAME_MAGIC_FILTER, Boolean.FALSE);
        mModelMap.put(MODEL_NAME_FAKE_BAIDU, Boolean.FALSE);
        mModelMap.put(MODEL_NAME_HISTORY_HIJACK, Boolean.FALSE);
        mModelMap.put(MODEL_NAME_DITING, Boolean.FALSE);
        mModelMap.put(MODEL_NAME_MAGIC_FILTER_3_0, Boolean.FALSE);
        mModelMap.put(MODEL_NAME_STOP_WORDS, Boolean.FALSE);
        mModelList = new ArrayList(mModelMap.keySet());
    }

    public MLModel(Context context, String str) {
        this.mContext = null;
        this.mModelName = null;
        this.mContext = context;
        this.mModelName = str;
    }

    public static String bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    private void getMF30Model(Context context, String str, String str2) {
        if (!ConectivityUtils.getNetType(context).equals("4g") && !ConectivityUtils.getNetType(context).equals("wifi")) {
            Log.w("MLModel", "Connection state != NET_TYPE_WIFI or NET_TYPE_4G");
            return;
        }
        BdNet bdNet = new BdNet(context);
        MLModel mLModel = new MLModel(context, str);
        mLModel.setMF30Model(true);
        bdNet.setEventListener(mLModel);
        BdNetTask bdNetTask = new BdNetTask();
        bdNetTask.setNet(bdNet);
        bdNetTask.setUrl(str2);
        bdNet.start(bdNetTask, false);
    }

    public static boolean getMagicFilter30Enable() {
        String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("magic_filter30");
        if (GetCloudSettingsValue == null) {
            Log.w("MLModel", "cloud settings is not ready, return ...");
            return false;
        } else if (GetCloudSettingsValue.equals(ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE) || !sMagicFilterABTestEnable) {
            Log.w("MLModel", "cloud settings disable!");
            return false;
        } else {
            return true;
        }
    }

    public static String getModelUrl(String str) {
        String mLModelUrl = WebSettingsGlobalBlink.getMLModelUrl();
        if (mLModelUrl == null || mLModelUrl.length() <= 0) {
            mLModelUrl = ML_MODEL_URL;
        }
        return str.equals(MODEL_NAME_MAGIC_FILTER_3_0) ? mLModelUrl + str + ".conf_v1" : mLModelUrl + str + ".pb";
    }

    public static byte[] hexStringToBytes(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (charToByte(charArray[i2 + 1]) | (charToByte(charArray[i2]) << 4));
        }
        return bArr;
    }

    public static void makeMF30InitedAsync() {
        try {
            ZeusThreadPoolUtil.execute(new a());
        } catch (Exception e) {
            com.a.a.a.a.a.a.a.a(e);
        }
    }

    public static void setMagicFilterABTestEnable(int i) {
        boolean z = i == 2 || i == 3;
        if (sMagicFilterABTestEnable == z) {
            return;
        }
        sMagicFilterABTestEnable = z;
        Log.w("MLModel", "setMagicFilterABTestEnable: " + z);
        if (sMagicFilterABTestEnable) {
            tryToUpdate(WebViewFactory.getContext());
        }
    }

    public static void tryToUpdate(Context context) {
        String GetCloudSettingsValue;
        if (ConectivityUtils.getNetType(context).equals("unknown")) {
            return;
        }
        if (!WebKitFactory.getNeedDownloadCloudResource()) {
            Log.i("MLModel", "no need to download mlmodels");
            return;
        }
        for (int i = 0; i < mModelList.size(); i++) {
            try {
                String str = mModelList.get(i);
                if (mModelMap.get(str).booleanValue()) {
                    Log.w("MLModel", str + "has been download");
                } else if (str.equals(MODEL_NAME_FAKE_BAIDU) && (GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue("enable_fake_baidu_check")) != null && GetCloudSettingsValue.equals(ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE)) {
                    Log.w("MLModel", "fake baidu disable");
                } else {
                    String modelUrl = getModelUrl(str);
                    Log.w("MLModel", "model url: " + modelUrl);
                    BdNet bdNet = new BdNet(context);
                    bdNet.setEventListener(new MLModel(context, str));
                    BdNetTask bdNetTask = new BdNetTask();
                    String str2 = CfgFileUtils.get(str + CfgFileUtils.KEY_ML_MODEL_TIME, (String) null);
                    if (str2 != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("If-Modified-Since", str2);
                        bdNetTask.setHeaders(hashMap);
                    }
                    bdNetTask.setNet(bdNet);
                    bdNetTask.setUrl(modelUrl);
                    bdNet.start(bdNetTask, false);
                }
            } catch (Exception e) {
                com.a.a.a.a.a.a.a.a(e);
                return;
            }
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadComplete(BdNet bdNet) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i) {
        Log.w("MLModel", "onNetDownloadError  " + bdNetTask.getUrl());
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetReceiveData(BdNet bdNet, BdNetTask bdNetTask, byte[] bArr, int i) {
        if (this.mStream == null) {
            this.mStream = new ByteArrayOutputStream();
        }
        this.mStream.write(bArr, 0, i);
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetReceiveHeaders(BdNet bdNet, BdNetTask bdNetTask) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public boolean onNetRedirect(BdNet bdNet, BdNetTask bdNetTask, int i) {
        return false;
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetResponseCode(BdNet bdNet, BdNetTask bdNetTask, int i) {
        Log.w("MLModel", "onNetResponseCode  " + i + " url " + bdNetTask.getUrl());
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetStateChanged(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetState netState, int i) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskComplete(BdNet bdNet, BdNetTask bdNetTask) {
        try {
            if (200 == bdNetTask.getConnection().getResponseCode() && bdNetTask.getConnection().getHeaderFields().containsKey("Last-Modified")) {
                this.mLastModified = bdNetTask.getConnection().getHeaderField("Last-Modified");
            }
        } catch (Exception e) {
            com.a.a.a.a.a.a.a.a(e);
        }
        Log.w("MLModel", "onNetDownloadComplete url " + bdNetTask.getUrl());
        this.mModel = CfgFileUtils.get(this.mModelName + "MLModel", (String) null);
        if (this.mGetMF30Model) {
            if (this.mStream == null) {
                CfgFileUtils.set(this.mModelName + CfgFileUtils.KEY_ML_MODEL_TIME, (String) null);
                return;
            }
            WebSettingsGlobalBlink.setMLModel(this.mModelName, this.mStream.toByteArray());
            try {
                this.mModel = bytesToHexString(this.mStream.toByteArray());
                CfgFileUtils.set(this.mModelName + "MLModel", this.mModel);
                CfgFileUtils.set(this.mModelName + CfgFileUtils.KEY_ML_MODEL_TIME, this.mLastModified);
                return;
            } catch (Exception e2) {
                com.a.a.a.a.a.a.a.a(e2);
                return;
            }
        }
        if (this.mStream != null) {
            Log.w("MLModel", "MLModel download success +++++++++++++++++++");
            if (!this.mModelName.equals(MODEL_NAME_MAGIC_FILTER_3_0)) {
                WebSettingsGlobalBlink.setMLModel(this.mModelName, this.mStream.toByteArray());
                try {
                    this.mModel = bytesToHexString(this.mStream.toByteArray());
                    CfgFileUtils.set(this.mModelName + "MLModel", this.mModel);
                    CfgFileUtils.set(this.mModelName + CfgFileUtils.KEY_ML_MODEL_TIME, this.mLastModified);
                } catch (Exception e3) {
                    com.a.a.a.a.a.a.a.a(e3);
                }
            } else if (!getMagicFilter30Enable()) {
                this.mStream = null;
                return;
            } else {
                try {
                    String trim = new String(this.mStream.toByteArray(), "UTF-8").trim();
                    Log.w("MLModel", "CDN Url : " + trim);
                    this.mStream = null;
                    getMF30Model(this.mContext, this.mModelName, trim);
                } catch (UnsupportedEncodingException e4) {
                    com.a.a.a.a.a.a.a.a(e4);
                }
            }
        } else {
            Log.w("MLModel", "mStream == null");
        }
        if (this.mModel != null && this.mStream == null) {
            WebSettingsGlobalBlink.setMLModel(this.mModelName, hexStringToBytes(this.mModel));
        }
        this.mStream = null;
        mModelMap.put(this.mModelName, Boolean.TRUE);
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskStart(BdNet bdNet, BdNetTask bdNetTask) {
        Log.w("MLModel", "onNetTaskStart  " + bdNetTask.getUrl());
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetUploadComplete(BdNet bdNet, BdNetTask bdNetTask) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetUploadData(BdNet bdNet, BdNetTask bdNetTask, int i, int i2) {
    }

    public void setMF30Model(boolean z) {
        this.mGetMF30Model = z;
    }
}
