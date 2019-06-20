package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.as;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> aHF = null;
    boolean hqT = false;
    private boolean mHasMore = false;

    public abstract void a(as asVar);

    public abstract boolean dU(long j);

    public void resetData() {
        this.aHF.clear();
    }

    public void bMC() {
        this.hqT = false;
        if (this.aHF != null && this.aHF.size() == 0) {
            this.hqT = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
