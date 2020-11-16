package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.sdk.a;
import com.baidu.tieba.yuyinala.liveroom.wheat.adapter.d;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ConnectionWheatManagerListView extends BaseConnectionWheatListView {
    private d.a ocN;
    private d ojw;

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
    protected void dxy() {
        this.ojw = new d(getContext());
        this.ogE.setAdapter((ListAdapter) this.ojw);
    }

    public void dZA() {
        zq(false);
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            dZP();
        } else {
            dZQ();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public void zq(boolean z) {
        this.ojw.MQ(o.dZz().WB().size());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(o.dZz().WB());
        arrayList.addAll(o.dZz().WA());
        gm(arrayList);
        if (this.ocN != null && this.ojw != null) {
            this.ocN.MR(this.ojw.getCount());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public int getCount() {
        if (this.ojw != null) {
            return this.ojw.getCount();
        }
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public String getNoDataStr() {
        return getContext().getString(a.h.yuyin_ala_connection_wheat_no_user_on_wheat_text);
    }

    private void gm(List<AlaWheatInfoData> list) {
        if (this.ojw != null) {
            this.ojw.setData(list);
        }
    }

    public void setListener(d.a aVar) {
        this.ocN = aVar;
        if (this.ojw != null) {
            this.ojw.setListener(aVar);
        }
    }

    public void onDestroy() {
    }
}
