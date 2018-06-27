package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.ar;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> alT = null;
    boolean fiq = false;
    private boolean mHasMore = false;

    public abstract void a(ar arVar);

    public abstract boolean cE(long j);

    public void resetData() {
        this.alT.clear();
    }

    public void aXU() {
        this.fiq = false;
        if (this.alT != null && this.alT.size() == 0) {
            this.fiq = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
