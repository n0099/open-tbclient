package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.aq;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> aRZ = null;
    boolean fxs = false;
    private boolean mHasMore = false;

    public abstract void a(aq aqVar);

    public void resetData() {
        this.aRZ.clear();
    }

    public void aXv() {
        this.fxs = false;
        if (this.aRZ != null && this.aRZ.size() == 0) {
            this.fxs = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
