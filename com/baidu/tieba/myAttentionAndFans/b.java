package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.av;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> cVS = null;
    boolean eLQ = false;
    private boolean mHasMore = false;

    public abstract void a(av avVar);

    public abstract boolean em(long j);

    public void resetData() {
        this.cVS.clear();
    }

    public void bgK() {
        this.eLQ = false;
        if (this.cVS != null && this.cVS.size() == 0) {
            this.eLQ = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
