package com.baidu.wallet.qrcodescanner;

import android.content.Context;
import com.baidu.wallet.api.IScannerDispatchListener;
import com.baidu.wallet.core.NoProguard;
/* loaded from: classes5.dex */
public class ScanCoderWrapper implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    public IScanCodeListener f26731a;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static ScanCoderWrapper f26732a = new ScanCoderWrapper();
    }

    public static ScanCoderWrapper getInstance() {
        return a.f26732a;
    }

    public void dispatchUrl(Context context, String str, IScannerDispatchListener iScannerDispatchListener) {
        IScanCodeListener iScanCodeListener = this.f26731a;
        if (iScanCodeListener != null) {
            iScanCodeListener.dispatchUrl(context, str, iScannerDispatchListener);
        }
    }

    public void initListener(IScanCodeListener iScanCodeListener) {
        this.f26731a = iScanCodeListener;
    }

    public boolean shouldDispatchUrl(String str) {
        IScanCodeListener iScanCodeListener = this.f26731a;
        if (iScanCodeListener != null) {
            return iScanCodeListener.shouldDispatchUrl(str);
        }
        return false;
    }

    public ScanCoderWrapper() {
    }
}
