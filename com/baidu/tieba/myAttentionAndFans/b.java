package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ba;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> dQf = null;
    boolean fPX = false;
    private boolean mHasMore = false;

    public abstract void a(ba baVar);

    public abstract boolean fb(long j);

    public void resetData() {
        this.dQf.clear();
    }

    public void byT() {
        this.fPX = false;
        if (this.dQf != null && this.dQf.size() == 0) {
            this.fPX = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
