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
    private d.a oDi;
    private d oKU;

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
    protected void dAY() {
        this.oKU = new d(getContext());
        this.oHw.setAdapter((ListAdapter) this.oKU);
    }

    public void edF() {
        Ak(false);
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            edV();
        } else {
            edW();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public void Ak(boolean z) {
        this.oKU.Mm(q.edE().Yn().size());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(q.edE().Yn());
        arrayList.addAll(q.edE().Ym());
        gq(arrayList);
        if (this.oDi != null && this.oKU != null) {
            this.oDi.Mn(this.oKU.getCount());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public int getCount() {
        if (this.oKU != null) {
            return this.oKU.getCount();
        }
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public String getNoDataStr() {
        return getContext().getString(a.h.yuyin_ala_connection_wheat_no_user_on_wheat_text);
    }

    private void gq(List<AlaWheatInfoData> list) {
        if (this.oKU != null) {
            this.oKU.setData(list);
        }
    }

    public void setListener(d.a aVar) {
        this.oDi = aVar;
        if (this.oKU != null) {
            this.oKU.setListener(aVar);
        }
    }

    public void onDestroy() {
    }
}
