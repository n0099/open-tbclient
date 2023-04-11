package com.baidu.tieba;

import android.view.View;
import android.webkit.WebView;
import com.baidu.tieba.mainentrance.HotSearchInfoData;
import tbclient.SearchSug.DataRes;
/* loaded from: classes6.dex */
public interface qh8 {
    void a(String str, boolean z, int i);

    void b();

    WebView c();

    void d(HotSearchInfoData hotSearchInfoData);

    View e();

    void f(DataRes dataRes, String str);

    void onChangeSkinType(int i);

    void onDestroy();

    void onPause();

    void onResume();
}
