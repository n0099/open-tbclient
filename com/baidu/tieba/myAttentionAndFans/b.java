package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bg;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> eVV = null;
    boolean hld = false;
    private boolean mHasMore = false;

    public abstract void a(bg bgVar);

    public abstract boolean hm(long j);

    public void resetData() {
        this.eVV.clear();
    }

    public void bYy() {
        this.hld = false;
        if (this.eVV != null && this.eVV.size() == 0) {
            this.hld = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
