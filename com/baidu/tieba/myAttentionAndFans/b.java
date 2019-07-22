package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.as;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> aIn = null;
    boolean hxf = false;
    private boolean mHasMore = false;

    public abstract void a(as asVar);

    public abstract boolean ee(long j);

    public void resetData() {
        this.aIn.clear();
    }

    public void bPk() {
        this.hxf = false;
        if (this.aIn != null && this.aIn.size() == 0) {
            this.hxf = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
