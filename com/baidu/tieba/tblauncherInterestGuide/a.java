package com.baidu.tieba.tblauncherInterestGuide;

import android.view.View;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
/* loaded from: classes4.dex */
public interface a {
    void Ai(int i);

    void Aj(int i);

    void a(InterestFrsData.Tag tag);

    View getRootView();

    void hide();

    void setOnClickListener(View.OnClickListener onClickListener);

    void show();
}
