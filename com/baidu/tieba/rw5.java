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
public interface rw5 {
    ya<ItemCardView> C0();

    ya<GifView> H();

    ya<LinearLayout> L();

    int P();

    void U(Context context, String str);

    void W(Context context, String str);

    ya<TiebaPlusRecommendCard> b2();

    ya<RelativeLayout> f0();

    ListView getListView();

    ya<FestivalTipView> i0();

    ya<ImageView> j0();

    ya<View> k0();

    void m0(Context context, String str);

    void n0(Context context, String str, boolean z);

    ya<TextView> p1();

    void s0(Context context, String str, String str2);

    void w0(Context context, String str);

    void x1(Context context, String str);
}
