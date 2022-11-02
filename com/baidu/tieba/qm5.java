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
public interface qm5 {
    int D();

    void G(Context context, String str);

    void I(Context context, String str);

    ng<RelativeLayout> L();

    ng<ImageView> N();

    ng<View> O();

    void Q(Context context, String str);

    void R(Context context, String str, boolean z);

    void V(Context context, String str, String str2);

    ng<TextView> W0();

    void Y(Context context, String str);

    ng<ItemCardView> e0();

    void e1(Context context, String str);

    ListView getListView();

    ng<GifView> w();

    ng<TiebaPlusRecommendCard> w1();

    ng<LinearLayout> z();
}
