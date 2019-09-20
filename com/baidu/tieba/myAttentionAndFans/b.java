package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.as;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> aIL = null;
    boolean hzT = false;
    private boolean mHasMore = false;

    public abstract void a(as asVar);

    public abstract boolean eh(long j);

    public void resetData() {
        this.aIL.clear();
    }

    public void bQm() {
        this.hzT = false;
        if (this.aIL != null && this.aIL.size() == 0) {
            this.hzT = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
