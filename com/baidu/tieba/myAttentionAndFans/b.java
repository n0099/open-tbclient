package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bc;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> eiq = null;
    boolean gkC = false;
    private boolean mHasMore = false;

    public abstract void a(bc bcVar);

    public abstract boolean fP(long j);

    public void resetData() {
        this.eiq.clear();
    }

    public void bMN() {
        this.gkC = false;
        if (this.eiq != null && this.eiq.size() == 0) {
            this.gkC = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
