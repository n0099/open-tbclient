package com.baidu.tieba.wallet;

import android.content.Context;
import java.util.Map;
/* loaded from: classes.dex */
public interface ICertification {

    /* loaded from: classes.dex */
    public interface CertificationCallback {
        void onResult(int i, Map<String, Object> map);
    }

    void certification(Context context, Map<String, Object> map, CertificationCallback certificationCallback);
}
