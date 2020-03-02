package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.av;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> cVR = null;
    boolean eLD = false;
    private boolean mHasMore = false;

    public abstract void a(av avVar);

    public abstract boolean em(long j);

    public void resetData() {
        this.cVR.clear();
    }

    public void bgJ() {
        this.eLD = false;
        if (this.cVR != null && this.cVR.size() == 0) {
            this.eLD = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
