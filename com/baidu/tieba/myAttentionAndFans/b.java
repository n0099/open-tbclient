package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bc;
import java.util.ArrayList;
/* loaded from: classes23.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> euy = null;
    boolean gyV = false;
    private boolean mHasMore = false;

    public abstract void a(bc bcVar);

    public abstract boolean gh(long j);

    public void resetData() {
        this.euy.clear();
    }

    public void bQe() {
        this.gyV = false;
        if (this.euy != null && this.euy.size() == 0) {
            this.gyV = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
