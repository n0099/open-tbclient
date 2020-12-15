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
    private d.a orP;
    private d oyz;

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
    protected void dCQ() {
        this.oyz = new d(getContext());
        this.ovG.setAdapter((ListAdapter) this.oyz);
    }

    public void eff() {
        zU(false);
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            efv();
        } else {
            efw();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public void zU(boolean z) {
        this.oyz.NI(o.efe().Za().size());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(o.efe().Za());
        arrayList.addAll(o.efe().YZ());
        gA(arrayList);
        if (this.orP != null && this.oyz != null) {
            this.orP.NJ(this.oyz.getCount());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public int getCount() {
        if (this.oyz != null) {
            return this.oyz.getCount();
        }
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public String getNoDataStr() {
        return getContext().getString(a.h.yuyin_ala_connection_wheat_no_user_on_wheat_text);
    }

    private void gA(List<AlaWheatInfoData> list) {
        if (this.oyz != null) {
            this.oyz.setData(list);
        }
    }

    public void setListener(d.a aVar) {
        this.orP = aVar;
        if (this.oyz != null) {
            this.oyz.setListener(aVar);
        }
    }

    public void onDestroy() {
    }
}
