package com.baidu.tieba.live.tbean;

import android.content.Intent;
import android.view.View;
/* loaded from: classes7.dex */
public interface IBuyTBeanActivity {
    void closeLoadingDialog();

    void finish();

    void hideNetRefreshView(View view);

    void setNetRefreshViewTopMargin(int i);

    void setResultIntent(int i, Intent intent);

    void showLoadingDialog(String str);

    void showNetRefreshView(View view, String str);

    void showToast(String str);
}
