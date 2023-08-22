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
/* loaded from: classes6.dex */
public interface k16 {
    ag<LinearLayout> B();

    int F();

    void K(Context context, String str);

    void N(Context context, String str);

    ag<TiebaPlusRecommendCard> T1();

    ag<RelativeLayout> X();

    ag<FestivalTipView> a0();

    ag<ImageView> b0();

    ag<View> c0();

    void e0(Context context, String str);

    void g0(Context context, String str, boolean z);

    ListView getListView();

    ag<TextView> i1();

    void l0(Context context, String str, String str2);

    void o0(Context context, String str);

    void t1(Context context, String str);

    ag<ItemCardView> u0();

    ag<GifView> z();
}
