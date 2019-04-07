package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.as;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> aFL = null;
    boolean gZx = false;
    private boolean mHasMore = false;

    public abstract void a(as asVar);

    public abstract boolean dx(long j);

    public void resetData() {
        this.aFL.clear();
    }

    public void bEN() {
        this.gZx = false;
        if (this.aFL != null && this.aFL.size() == 0) {
            this.gZx = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
