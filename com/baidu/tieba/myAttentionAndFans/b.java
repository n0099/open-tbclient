package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ar;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> alt = null;
    boolean fey = false;
    private boolean mHasMore = false;

    public abstract void a(ar arVar);

    public abstract boolean cI(long j);

    public void resetData() {
        this.alt.clear();
    }

    public void aXn() {
        this.fey = false;
        if (this.alt != null && this.alt.size() == 0) {
            this.fey = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
