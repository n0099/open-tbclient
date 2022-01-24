package com.baidu.wallet.qrcodescanner;

import android.content.Context;
import com.baidu.wallet.api.IScannerDispatchListener;
/* loaded from: classes2.dex */
public interface IScanCodeListener {
    void dispatchUrl(Context context, String str, IScannerDispatchListener iScannerDispatchListener);

    void onResult(int i2, String str);

    boolean shouldDispatchUrl(String str);
}
