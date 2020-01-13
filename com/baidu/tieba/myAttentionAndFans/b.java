package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.av;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> cRO = null;
    boolean eHI = false;
    private boolean mHasMore = false;

    public abstract void a(av avVar);

    public abstract boolean em(long j);

    public void resetData() {
        this.cRO.clear();
    }

    public void bex() {
        this.eHI = false;
        if (this.cRO != null && this.cRO.size() == 0) {
            this.eHI = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
