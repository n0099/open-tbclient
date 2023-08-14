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
import com.baidu.tieba.view.festivalview.FestivalTipView;
/* loaded from: classes7.dex */
public interface s06 {
    ag<LinearLayout> A();

    int D();

    ag<TiebaPlusRecommendCard> H1();

    void I(Context context, String str);

    void K(Context context, String str);

    ag<RelativeLayout> S();

    ag<FestivalTipView> V();

    ag<ImageView> W();

    ag<View> X();

    void Z(Context context, String str);

    void a0(Context context, String str, boolean z);

    ag<TextView> a1();

    void f0(Context context, String str, String str2);

    ListView getListView();

    void i0(Context context, String str);

    void j1(Context context, String str);

    ag<ItemCardView> o0();

    ag<GifView> y();
}
