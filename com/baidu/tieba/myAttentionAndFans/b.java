package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bc;
import java.util.ArrayList;
/* loaded from: classes23.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> eCX = null;
    boolean gKJ = false;
    private boolean mHasMore = false;

    public abstract void a(bc bcVar);

    public abstract boolean gi(long j);

    public void resetData() {
        this.eCX.clear();
    }

    public void bTb() {
        this.gKJ = false;
        if (this.eCX != null && this.eCX.size() == 0) {
            this.gKJ = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
