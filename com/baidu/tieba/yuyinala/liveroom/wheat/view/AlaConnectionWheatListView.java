package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.live.adp.widget.listview.BdTypeListView;
/* loaded from: classes10.dex */
public class AlaConnectionWheatListView extends BdTypeListView {
    public AlaConnectionWheatListView(Context context) {
        super(context);
        init();
    }

    public AlaConnectionWheatListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public AlaConnectionWheatListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void init() {
        setDivider(null);
        setOverScrollMode(2);
        setSelector(17170445);
        setVerticalScrollBarEnabled(false);
        setFastScrollEnabled(false);
        setScrollbarFadingEnabled(false);
    }
}
