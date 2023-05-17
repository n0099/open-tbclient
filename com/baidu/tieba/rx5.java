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
public interface rx5 {
    gg<LinearLayout> A();

    int E();

    gg<TiebaPlusRecommendCard> F1();

    void I(Context context, String str);

    void K(Context context, String str);

    gg<RelativeLayout> S();

    gg<FestivalTipView> U();

    gg<ImageView> W();

    gg<View> X();

    void Y(Context context, String str);

    gg<TextView> Y0();

    void Z(Context context, String str, boolean z);

    void e0(Context context, String str, String str2);

    ListView getListView();

    void h1(Context context, String str);

    void j0(Context context, String str);

    gg<ItemCardView> o0();

    gg<GifView> x();
}
