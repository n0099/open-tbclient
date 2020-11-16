package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bd;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> eHj = null;
    boolean gQc = false;
    private boolean mHasMore = false;

    public abstract void a(bd bdVar);

    public abstract boolean gH(long j);

    public void resetData() {
        this.eHj.clear();
    }

    public void bUT() {
        this.gQc = false;
        if (this.eHj != null && this.eHj.size() == 0) {
            this.gQc = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
