package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.as;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> aFI = null;
    boolean gZK = false;
    private boolean mHasMore = false;

    public abstract void a(as asVar);

    public abstract boolean dx(long j);

    public void resetData() {
        this.aFI.clear();
    }

    public void bEQ() {
        this.gZK = false;
        if (this.aFI != null && this.aFI.size() == 0) {
            this.gZK = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
