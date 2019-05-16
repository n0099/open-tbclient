package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.as;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> aHF = null;
    boolean hqP = false;
    private boolean mHasMore = false;

    public abstract void a(as asVar);

    public abstract boolean dU(long j);

    public void resetData() {
        this.aHF.clear();
    }

    public void bMy() {
        this.hqP = false;
        if (this.aHF != null && this.aHF.size() == 0) {
            this.hqP = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
