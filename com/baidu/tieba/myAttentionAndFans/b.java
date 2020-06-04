package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.av;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> dJp = null;
    boolean fEO = false;
    private boolean mHasMore = false;

    public abstract void a(av avVar);

    public abstract boolean eY(long j);

    public void resetData() {
        this.dJp.clear();
    }

    public void bvY() {
        this.fEO = false;
        if (this.dJp != null && this.dJp.size() == 0) {
            this.fEO = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
