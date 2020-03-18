package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.av;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> cWf = null;
    boolean eMm = false;
    private boolean mHasMore = false;

    public abstract void a(av avVar);

    public abstract boolean en(long j);

    public void resetData() {
        this.cWf.clear();
    }

    public void bgP() {
        this.eMm = false;
        if (this.cWf != null && this.cWf.size() == 0) {
            this.eMm = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
