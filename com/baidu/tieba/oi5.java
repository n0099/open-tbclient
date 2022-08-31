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
/* loaded from: classes5.dex */
public interface oi5 {
    int C();

    void F(Context context, String str);

    void H(Context context, String str);

    gg<RelativeLayout> L();

    gg<ImageView> N();

    gg<View> O();

    void Q(Context context, String str);

    void R(Context context, String str, boolean z);

    void V(Context context, String str, String str2);

    void Y(Context context, String str);

    gg<TextView> Y0();

    gg<ItemCardView> e0();

    void g1(Context context, String str);

    ListView getListView();

    gg<GifView> v();

    gg<LinearLayout> y();

    gg<TiebaPlusRecommendCard> y1();
}
