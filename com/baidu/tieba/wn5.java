package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
/* loaded from: classes6.dex */
public interface wn5 {
    int C();

    void F(Context context, String str);

    void H(Context context, String str);

    og<RelativeLayout> N();

    og<ImageView> P();

    og<View> Q();

    void S(Context context, String str);

    void T(Context context, String str, boolean z);

    og<TextView> V0();

    void X(Context context, String str, String str2);

    void b0(Context context, String str);

    void d1(Context context, String str);

    ListView getListView();

    og<ItemCardView> h0();

    og<GifView> v();

    og<TiebaPlusRecommendCard> w1();

    og<LinearLayout> y();
}
