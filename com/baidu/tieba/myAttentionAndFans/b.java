package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.as;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> bbZ = null;
    boolean dRI = false;
    private boolean mHasMore = false;

    public abstract void a(as asVar);

    public abstract boolean dC(long j);

    public void resetData() {
        this.bbZ.clear();
    }

    public void aMz() {
        this.dRI = false;
        if (this.bbZ != null && this.bbZ.size() == 0) {
            this.dRI = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
