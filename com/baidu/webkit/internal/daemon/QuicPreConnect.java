package com.baidu.webkit.internal.daemon;

import android.content.Context;
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
/* loaded from: classes5.dex */
public class QuicPreConnect implements INoProGuard, INetListener {
    public static final String LOG_TAG = "QuicPreConnect";
    public static boolean mDownloading = false;
    public static final String mQuicPreConnectUrl = "https://m.baidu.com/static/searchbox/common/prelink.html?word=";
    public ByteArrayOutputStream mData = null;

    public static String getUrl(Context context) {
        String str = mQuicPreConnectUrl + System.currentTimeMillis();
        Log.w(LOG_TAG, "getUrl=" + str);
        return str;
    }

    public static void tryToQuicPreConnect(Context context) {
        if (WebSettingsGlobalBlink.isSFSwitchEnabled()) {
            Log.i(LOG_TAG, "tryToQuicPreConnect spring_festival_switch return");
        } else if (!WebKitFactory.getNeedDownloadCloudResource()) {
            Log.i(LOG_TAG, "no need tryToQuicPreConnect");
        } else if (ConectivityUtils.getNetType(context).equals("unknown")) {
        } else {
            if (WebSettingsGlobalBlink.getPreconnectABTestEnable() && WebSettingsGlobalBlink.hasQuicAltService("https://m.baidu.com") && WebViewFactory.hasProvider() && WebViewFactory.getProvider().getStatics() != null) {
                String str = mQuicPreConnectUrl + System.currentTimeMillis();
                Log.i(LOG_TAG, "QuicPreconnect tryToQuicPreConnect preconnectUrl Url = " + str);
                WebViewFactory.getProvider().getStatics().preconnectUrl(str, 1);
            } else if (mDownloading) {
            } else {
                mDownloading = true;
                Log.i(LOG_TAG, "tryToQuicPreConnect prelink.html");
                try {
                    BdNet bdNet = new BdNet(context);
                    bdNet.setEventListener(new QuicPreConnect());
                    BdNetTask bdNetTask = new BdNetTask();
                    bdNetTask.setNet(bdNet);
                    bdNetTask.setUrl(getUrl(context));
                    bdNet.start(bdNetTask, false);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadComplete(BdNet bdNet) {
        mDownloading = false;
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i2) {
        mDownloading = false;
        Log.w(LOG_TAG, "onNetDownloadError  " + bdNetTask.getUrl());
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetReceiveData(BdNet bdNet, BdNetTask bdNetTask, byte[] bArr, int i2) {
        if (this.mData == null) {
            this.mData = new ByteArrayOutputStream();
        }
        Log.w(LOG_TAG, "onNetReceiveData " + i2);
        this.mData.write(bArr, 0, i2);
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetReceiveHeaders(BdNet bdNet, BdNetTask bdNetTask) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public boolean onNetRedirect(BdNet bdNet, BdNetTask bdNetTask, int i2) {
        return false;
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetResponseCode(BdNet bdNet, BdNetTask bdNetTask, int i2) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetStateChanged(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetState netState, int i2) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskComplete(BdNet bdNet, BdNetTask bdNetTask) {
        String str;
        if (this.mData != null) {
            str = "onNetDownloadComplete url " + bdNetTask.getUrl();
        } else {
            str = "mData==null";
        }
        Log.w(LOG_TAG, str);
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskStart(BdNet bdNet, BdNetTask bdNetTask) {
        Log.w(LOG_TAG, "onNetTaskStart  " + bdNetTask.getUrl());
        Log.w(LOG_TAG, "getUsingChromiumNet  " + bdNetTask.isUseCorenet());
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetUploadComplete(BdNet bdNet, BdNetTask bdNetTask) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetUploadData(BdNet bdNet, BdNetTask bdNetTask, int i2, int i3) {
    }
}
