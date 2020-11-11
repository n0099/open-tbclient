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
    private d.a obi;
    private d ohT;

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
    protected void dxY() {
        this.ohT = new d(getContext());
        this.ofa.setAdapter((ListAdapter) this.ohT);
    }

    public void dZB() {
        zj(false);
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            dZQ();
        } else {
            dZR();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public void zj(boolean z) {
        this.ohT.Mn(o.dZA().Xk().size());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(o.dZA().Xk());
        arrayList.addAll(o.dZA().Xj());
        gm(arrayList);
        if (this.obi != null && this.ohT != null) {
            this.obi.Mo(this.ohT.getCount());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public int getCount() {
        if (this.ohT != null) {
            return this.ohT.getCount();
        }
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public String getNoDataStr() {
        return getContext().getString(a.h.yuyin_ala_connection_wheat_no_user_on_wheat_text);
    }

    private void gm(List<AlaWheatInfoData> list) {
        if (this.ohT != null) {
            this.ohT.setData(list);
        }
    }

    public void setListener(d.a aVar) {
        this.obi = aVar;
        if (this.ohT != null) {
            this.ohT.setListener(aVar);
        }
    }

    public void onDestroy() {
    }
}
