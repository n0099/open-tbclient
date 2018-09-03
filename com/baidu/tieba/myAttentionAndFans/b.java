package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.aq;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> als = null;
    boolean fiw = false;
    private boolean mHasMore = false;

    public abstract void a(aq aqVar);

    public abstract boolean cA(long j);

    public void resetData() {
        this.als.clear();
    }

    public void aWl() {
        this.fiw = false;
        if (this.als != null && this.als.size() == 0) {
            this.fiw = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
