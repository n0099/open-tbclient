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
/* loaded from: classes8.dex */
public interface z16 {
    lg<LinearLayout> A();

    int E();

    lg<TiebaPlusRecommendCard> G1();

    void I(Context context, String str);

    void K(Context context, String str);

    lg<RelativeLayout> S();

    lg<FestivalTipView> U();

    lg<ImageView> W();

    lg<View> X();

    void Y(Context context, String str);

    void Z(Context context, String str, boolean z);

    lg<TextView> Z0();

    void e0(Context context, String str, String str2);

    ListView getListView();

    void i1(Context context, String str);

    void j0(Context context, String str);

    lg<ItemCardView> o0();

    lg<GifView> x();
}
