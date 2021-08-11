package com.baidu.wallet.paysdk.presenter;

import android.os.Bundle;
import java.io.Serializable;
/* loaded from: classes8.dex */
public interface BasePresenter extends Serializable {
    void onCreate(Bundle bundle);

    void onDestroy();

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle bundle);
}
