package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.av;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> cRE = null;
    boolean eGy = false;
    private boolean mHasMore = false;

    public abstract void a(av avVar);

    public abstract boolean eh(long j);

    public void resetData() {
        this.cRE.clear();
    }

    public void bec() {
        this.eGy = false;
        if (this.cRE != null && this.cRE.size() == 0) {
            this.eGy = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
