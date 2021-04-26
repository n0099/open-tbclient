package com.baidu.wallet.qrcodescanner;

import android.content.Context;
import com.baidu.wallet.api.IScannerDispatchListener;
import com.baidu.wallet.core.NoProguard;
/* loaded from: classes5.dex */
public class ScanCoderWrapper implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    public IScanCodeListener f27231a;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static ScanCoderWrapper f27232a = new ScanCoderWrapper();
    }

    public static ScanCoderWrapper getInstance() {
        return a.f27232a;
    }

    public void dispatchUrl(Context context, String str, IScannerDispatchListener iScannerDispatchListener) {
        IScanCodeListener iScanCodeListener = this.f27231a;
        if (iScanCodeListener != null) {
            iScanCodeListener.dispatchUrl(context, str, iScannerDispatchListener);
        }
    }

    public void initListener(IScanCodeListener iScanCodeListener) {
        this.f27231a = iScanCodeListener;
    }

    public boolean shouldDispatchUrl(String str) {
        IScanCodeListener iScanCodeListener = this.f27231a;
        if (iScanCodeListener != null) {
            return iScanCodeListener.shouldDispatchUrl(str);
        }
        return false;
    }

    public ScanCoderWrapper() {
    }
}
