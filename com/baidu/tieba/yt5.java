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
public interface yt5 {
    xf<LinearLayout> A();

    xf<TiebaPlusRecommendCard> D1();

    int E();

    void H(Context context, String str);

    void J(Context context, String str);

    xf<RelativeLayout> R();

    xf<FestivalTipView> T();

    xf<ImageView> V();

    xf<View> W();

    void X(Context context, String str);

    void Y(Context context, String str, boolean z);

    xf<TextView> Y0();

    void e0(Context context, String str, String str2);

    void g1(Context context, String str);

    ListView getListView();

    void i0(Context context, String str);

    xf<ItemCardView> n0();

    xf<GifView> x();
}
