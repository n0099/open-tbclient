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
public interface my5 {
    ob<TextView> C1();

    void E0(Context context, String str);

    ob<ItemCardView> K0();

    ob<GifView> L();

    void M1(Context context, String str);

    ob<LinearLayout> P();

    int T();

    void Z(Context context, String str);

    void b0(Context context, String str);

    ListView getListView();

    ob<RelativeLayout> k0();

    ob<FestivalTipView> n0();

    ob<ImageView> p0();

    ob<View> q0();

    void s0(Context context, String str);

    void t0(Context context, String str, boolean z);

    ob<TiebaPlusRecommendCard> t2();

    void z0(Context context, String str, String str2);
}
