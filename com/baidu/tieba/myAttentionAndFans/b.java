package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.be;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> eYq = null;
    boolean hlg = false;
    private boolean mHasMore = false;

    public abstract void a(be beVar);

    public abstract boolean hh(long j);

    public void resetData() {
        this.eYq.clear();
    }

    public void cbi() {
        this.hlg = false;
        if (this.eYq != null && this.eYq.size() == 0) {
            this.hlg = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
