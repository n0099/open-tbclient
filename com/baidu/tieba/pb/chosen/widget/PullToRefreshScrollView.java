package com.baidu.tieba.pb.chosen.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
/* loaded from: classes.dex */
public class PullToRefreshScrollView extends b<ScrollView> {
    private final c bGZ;

    public PullToRefreshScrollView(Context context) {
        super(context);
        this.bGZ = new e(this);
        setOnRefreshListener(this.bGZ);
    }

    public PullToRefreshScrollView(Context context, int i) {
        super(context, i);
        this.bGZ = new e(this);
        setOnRefreshListener(this.bGZ);
    }

    public PullToRefreshScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bGZ = new e(this);
        setOnRefreshListener(this.bGZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.chosen.widget.b
    /* renamed from: d */
    public ScrollView c(Context context, AttributeSet attributeSet) {
        ScrollView scrollView = new ScrollView(context, attributeSet);
        scrollView.setFadingEdgeLength(0);
        setFadingEdgeLength(0);
        return scrollView;
    }

    @Override // com.baidu.tieba.pb.chosen.widget.b
    protected boolean YI() {
        return ((ScrollView) this.bGN).getScrollY() == 0;
    }

    @Override // com.baidu.tieba.pb.chosen.widget.b
    protected boolean YJ() {
        ScrollView refreshableView = getRefreshableView();
        return (refreshableView.getScrollY() + refreshableView.getHeight()) - refreshableView.getChildAt(0).getHeight() == 0;
    }
}
