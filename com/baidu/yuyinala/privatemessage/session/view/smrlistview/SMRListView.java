package com.baidu.yuyinala.privatemessage.session.view.smrlistview;

import android.content.Context;
import android.util.AttributeSet;
/* loaded from: classes11.dex */
public class SMRListView extends SMListView implements a {
    public SMRListView(Context context) {
        super(context);
    }

    public SMRListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SMRListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.a
    public boolean eng() {
        if (getCount() == 0) {
            return true;
        }
        return getFirstVisiblePosition() == 0 && getChildAt(0) != null && getChildAt(0).getTop() >= 0;
    }

    @Override // com.baidu.yuyinala.privatemessage.session.view.smrlistview.a
    public boolean enh() {
        return getLastVisiblePosition() == getCount() + (-1) && getChildAt(getLastVisiblePosition() - getFirstVisiblePosition()) != null && getChildAt(getLastVisiblePosition() - getFirstVisiblePosition()).getBottom() == getMeasuredHeight();
    }
}
