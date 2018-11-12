package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.aq;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> mData = null;
    boolean fyW = false;
    private boolean mHasMore = false;

    public abstract void a(aq aqVar);

    public abstract boolean cG(long j);

    public void resetData() {
        this.mData.clear();
    }

    public void bbj() {
        this.fyW = false;
        if (this.mData != null && this.mData.size() == 0) {
            this.fyW = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
