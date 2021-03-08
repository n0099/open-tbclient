package com.baidu.tieba.myAttentionAndFans;

import android.widget.BaseAdapter;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bg;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public abstract class b extends BaseAdapter {
    protected ArrayList<UserData> eXu = null;
    boolean hmM = false;
    private boolean mHasMore = false;

    public abstract void a(bg bgVar);

    public abstract boolean hm(long j);

    public void resetData() {
        this.eXu.clear();
    }

    public void bYE() {
        this.hmM = false;
        if (this.eXu != null && this.eXu.size() == 0) {
            this.hmM = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }
}
