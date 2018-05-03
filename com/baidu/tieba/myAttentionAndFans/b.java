package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ar;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> adv = null;
    boolean eRZ = false;
    private boolean mHasMore = false;

    public abstract void a(ar arVar);

    public abstract boolean cC(long j);

    public void resetData() {
        this.adv.clear();
    }

    public void aSq() {
        this.eRZ = false;
        if (this.adv != null && this.adv.size() == 0) {
            this.eRZ = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
