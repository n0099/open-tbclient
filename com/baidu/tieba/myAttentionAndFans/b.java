package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bc;
import java.util.ArrayList;
/* loaded from: classes23.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> eIM = null;
    boolean gQv = false;
    private boolean mHasMore = false;

    public abstract void a(bc bcVar);

    public abstract boolean gE(long j);

    public void resetData() {
        this.eIM.clear();
    }

    public void bVA() {
        this.gQv = false;
        if (this.eIM != null && this.eIM.size() == 0) {
            this.gQv = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
