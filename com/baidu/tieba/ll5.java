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
/* loaded from: classes4.dex */
public interface ll5 {
    int D();

    void G(Context context, String str);

    void I(Context context, String str);

    ug<RelativeLayout> L();

    ug<ImageView> N();

    ug<View> O();

    void Q(Context context, String str);

    void R(Context context, String str, boolean z);

    void V(Context context, String str, String str2);

    void Y(Context context, String str);

    ug<TextView> Y0();

    ug<ItemCardView> e0();

    void g1(Context context, String str);

    ListView getListView();

    ug<GifView> w();

    ug<TiebaPlusRecommendCard> y1();

    ug<LinearLayout> z();
}
