package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.be;
import java.util.ArrayList;
/* loaded from: classes23.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> eOt = null;
    boolean gZp = false;
    private boolean mHasMore = false;

    public abstract void a(be beVar);

    public abstract boolean hm(long j);

    public void resetData() {
        this.eOt.clear();
    }

    public void bYC() {
        this.gZp = false;
        if (this.eOt != null && this.eOt.size() == 0) {
            this.gZp = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
