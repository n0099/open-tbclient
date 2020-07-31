package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bb;
import java.util.ArrayList;
/* loaded from: classes17.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> dWx = null;
    boolean fVq = false;
    private boolean mHasMore = false;

    public abstract void a(bb bbVar);

    public abstract boolean fp(long j);

    public void resetData() {
        this.dWx.clear();
    }

    public void bCi() {
        this.fVq = false;
        if (this.dWx != null && this.dWx.size() == 0) {
            this.fVq = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
