package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.aq;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> alt = null;
    boolean fiD = false;
    private boolean mHasMore = false;

    public abstract void a(aq aqVar);

    public abstract boolean cA(long j);

    public void resetData() {
        this.alt.clear();
    }

    public void aWp() {
        this.fiD = false;
        if (this.alt != null && this.alt.size() == 0) {
            this.fiD = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
