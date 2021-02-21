package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.sdk.a;
import com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class ConnectionWheatManagerListView extends BaseConnectionWheatListView {
    private d.a oDI;
    private d oLu;

    public ConnectionWheatManagerListView(@NonNull Context context) {
        this(context, null);
    }

    public ConnectionWheatManagerListView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ConnectionWheatManagerListView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    protected void initListener() {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    protected void dBf() {
        this.oLu = new d(getContext());
        this.oHW.setAdapter((ListAdapter) this.oLu);
    }

    public void edN() {
        Ak(false);
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            eed();
        } else {
            eee();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public void Ak(boolean z) {
        this.oLu.Mn(q.edM().Yn().size());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(q.edM().Yn());
        arrayList.addAll(q.edM().Ym());
        gq(arrayList);
        if (this.oDI != null && this.oLu != null) {
            this.oDI.Mo(this.oLu.getCount());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public int getCount() {
        if (this.oLu != null) {
            return this.oLu.getCount();
        }
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public String getNoDataStr() {
        return getContext().getString(a.h.yuyin_ala_connection_wheat_no_user_on_wheat_text);
    }

    private void gq(List<AlaWheatInfoData> list) {
        if (this.oLu != null) {
            this.oLu.setData(list);
        }
    }

    public void setListener(d.a aVar) {
        this.oDI = aVar;
        if (this.oLu != null) {
            this.oLu.setListener(aVar);
        }
    }

    public void onDestroy() {
    }
}
