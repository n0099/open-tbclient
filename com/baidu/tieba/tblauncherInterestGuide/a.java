package com.baidu.tieba.tblauncherInterestGuide;

import android.view.View;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
/* loaded from: classes9.dex */
public interface a {
    void CP(int i);

    void CQ(int i);

    void a(InterestFrsData.Tag tag);

    View getRootView();

    void hide();

    void setOnClickListener(View.OnClickListener onClickListener);

    void show();
}
