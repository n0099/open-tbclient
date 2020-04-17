package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.av;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> dvq = null;
    boolean fqE = false;
    private boolean mHasMore = false;

    public abstract void a(av avVar);

    public abstract boolean eX(long j);

    public void resetData() {
        this.dvq.clear();
    }

    public void bqg() {
        this.fqE = false;
        if (this.dvq != null && this.dvq.size() == 0) {
            this.fqE = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
