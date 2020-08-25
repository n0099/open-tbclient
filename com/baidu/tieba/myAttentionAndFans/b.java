package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bc;
import java.util.ArrayList;
/* loaded from: classes17.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> efX = null;
    boolean ghp = false;
    private boolean mHasMore = false;

    public abstract void a(bc bcVar);

    public abstract boolean fB(long j);

    public void resetData() {
        this.efX.clear();
    }

    public void bLC() {
        this.ghp = false;
        if (this.efX != null && this.efX.size() == 0) {
            this.ghp = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
