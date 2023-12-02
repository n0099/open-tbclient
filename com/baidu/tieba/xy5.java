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
/* loaded from: classes9.dex */
public interface xy5 {
    void D0(Context context, String str, String str2);

    pb<TiebaPlusRecommendCard> F2();

    void J0(Context context, String str);

    pb<GifView> M();

    pb<TextView> N1();

    pb<ItemCardView> P0();

    pb<LinearLayout> Q();

    int V();

    void Y1(Context context, String str);

    void b0(Context context, String str);

    void d0(Context context, String str);

    ListView getListView();

    pb<RelativeLayout> n0();

    pb<FestivalTipView> q0();

    pb<ImageView> r0();

    pb<View> t0();

    void w0(Context context, String str);

    void x0(Context context, String str, boolean z);
}
