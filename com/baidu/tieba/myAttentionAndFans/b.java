package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bc;
import java.util.ArrayList;
/* loaded from: classes17.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> egb = null;
    boolean ght = false;
    private boolean mHasMore = false;

    public abstract void a(bc bcVar);

    public abstract boolean fB(long j);

    public void resetData() {
        this.egb.clear();
    }

    public void bLD() {
        this.ght = false;
        if (this.egb != null && this.egb.size() == 0) {
            this.ght = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
