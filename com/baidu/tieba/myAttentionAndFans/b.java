package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.as;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> bbH = null;
    boolean dQR = false;
    private boolean mHasMore = false;

    public abstract void a(as asVar);

    public abstract boolean dB(long j);

    public void resetData() {
        this.bbH.clear();
    }

    public void aMx() {
        this.dQR = false;
        if (this.bbH != null && this.bbH.size() == 0) {
            this.dQR = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
