package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.aq;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> aRX = null;
    boolean fxc = false;
    private boolean mHasMore = false;

    public abstract void a(aq aqVar);

    public void resetData() {
        this.aRX.clear();
    }

    public void aXu() {
        this.fxc = false;
        if (this.aRX != null && this.aRX.size() == 0) {
            this.fxc = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
