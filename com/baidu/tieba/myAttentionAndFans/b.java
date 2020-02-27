package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.av;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> cVQ = null;
    boolean eLC = false;
    private boolean mHasMore = false;

    public abstract void a(av avVar);

    public abstract boolean em(long j);

    public void resetData() {
        this.cVQ.clear();
    }

    public void bgH() {
        this.eLC = false;
        if (this.cVQ != null && this.cVQ.size() == 0) {
            this.eLC = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
