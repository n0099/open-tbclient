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
public interface qo5 {
    pg<TiebaPlusRecommendCard> B1();

    int C();

    void F(Context context, String str);

    void H(Context context, String str);

    pg<RelativeLayout> N();

    pg<FestivalTipView> P();

    pg<ImageView> Q();

    pg<View> R();

    void T(Context context, String str);

    void U(Context context, String str, boolean z);

    pg<TextView> W0();

    void Y(Context context, String str, String str2);

    void c0(Context context, String str);

    void e1(Context context, String str);

    ListView getListView();

    pg<ItemCardView> i0();

    pg<GifView> v();

    pg<LinearLayout> y();
}
