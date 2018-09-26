package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.aq;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> anX = null;
    boolean fpT = false;
    private boolean mHasMore = false;

    public abstract void a(aq aqVar);

    public abstract boolean cE(long j);

    public void resetData() {
        this.anX.clear();
    }

    public void aYy() {
        this.fpT = false;
        if (this.anX != null && this.anX.size() == 0) {
            this.fpT = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
