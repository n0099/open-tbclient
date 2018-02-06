package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.aq;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> aSi = null;
    boolean fxo = false;
    private boolean mHasMore = false;

    public abstract void a(aq aqVar);

    public void resetData() {
        this.aSi.clear();
    }

    public void aXv() {
        this.fxo = false;
        if (this.aSi != null && this.aSi.size() == 0) {
            this.fxo = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
