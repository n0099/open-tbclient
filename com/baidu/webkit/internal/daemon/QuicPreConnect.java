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
/* loaded from: classes12.dex */
public class QuicPreConnect implements INoProGuard, INetListener {
    private static final String LOG_TAG = "QuicPreConnect";
    private static boolean mDownloading = false;
    private static final String mQuicPreConnectUrl = "https://m.baidu.com/static/searchbox/common/prelink.html?word=";
    private ByteArrayOutputStream mData = null;

    private static String getUrl(Context context) {
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
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadComplete(BdNet bdNet) {
        mDownloading = false;
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetDownloadError(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetError netError, int i) {
        mDownloading = false;
        Log.w(LOG_TAG, "onNetDownloadError  " + bdNetTask.getUrl());
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetReceiveData(BdNet bdNet, BdNetTask bdNetTask, byte[] bArr, int i) {
        if (this.mData == null) {
            this.mData = new ByteArrayOutputStream();
        }
        Log.w(LOG_TAG, "onNetReceiveData " + i);
        this.mData.write(bArr, 0, i);
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
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetStateChanged(BdNet bdNet, BdNetTask bdNetTask, BdNet.NetState netState, int i) {
    }

    @Override // com.baidu.webkit.net.INetListener
    public void onNetTaskComplete(BdNet bdNet, BdNetTask bdNetTask) {
        if (this.mData != null) {
            Log.w(LOG_TAG, "onNetDownloadComplete url " + bdNetTask.getUrl());
        } else {
            Log.w(LOG_TAG, "mData==null");
        }
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
    public void onNetUploadData(BdNet bdNet, BdNetTask bdNetTask, int i, int i2) {
    }
}
