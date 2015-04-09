package com.baidu.tieba.pb.chosen.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
/* loaded from: classes.dex */
public class PullToRefreshScrollView extends b<ScrollView> {
    private final c bHm;

    public PullToRefreshScrollView(Context context) {
        super(context);
        this.bHm = new e(this);
        setOnRefreshListener(this.bHm);
    }

    public PullToRefreshScrollView(Context context, int i) {
        super(context, i);
        this.bHm = new e(this);
        setOnRefreshListener(this.bHm);
    }

    public PullToRefreshScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bHm = new e(this);
        setOnRefreshListener(this.bHm);
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
    protected boolean YU() {
        return ((ScrollView) this.bHa).getScrollY() == 0;
    }

    @Override // com.baidu.tieba.pb.chosen.widget.b
    protected boolean YV() {
        ScrollView refreshableView = getRefreshableView();
        return (refreshableView.getScrollY() + refreshableView.getHeight()) - refreshableView.getChildAt(0).getHeight() == 0;
    }
}
