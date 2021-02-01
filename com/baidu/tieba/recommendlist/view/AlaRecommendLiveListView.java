package com.baidu.tieba.recommendlist.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.live.adp.widget.listview.BdTypeListView;
/* loaded from: classes11.dex */
public class AlaRecommendLiveListView extends BdTypeListView {
    public AlaRecommendLiveListView(Context context) {
        super(context);
        init();
    }

    public AlaRecommendLiveListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public AlaRecommendLiveListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public final void init() {
        setDivider(null);
        setOverScrollMode(2);
        setSelector(17170445);
        setVerticalScrollBarEnabled(false);
        setFastScrollEnabled(false);
        setScrollbarFadingEnabled(false);
    }
}
