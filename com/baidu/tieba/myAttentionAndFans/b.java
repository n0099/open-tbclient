package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.av;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> dvu = null;
    boolean fqJ = false;
    private boolean mHasMore = false;

    public abstract void a(av avVar);

    public abstract boolean eX(long j);

    public void resetData() {
        this.dvu.clear();
    }

    public void bqe() {
        this.fqJ = false;
        if (this.dvu != null && this.dvu.size() == 0) {
            this.fqJ = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
