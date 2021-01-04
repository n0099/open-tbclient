package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.data.n;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaGetInviteConnectionWheatListHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.g;
import java.util.List;
/* loaded from: classes11.dex */
public class ConnectionWheatInviteListView extends BaseConnectionWheatListView {
    private c oFM;
    private g oFN;

    public ConnectionWheatInviteListView(@NonNull Context context) {
        this(context, null);
    }

    public ConnectionWheatInviteListView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ConnectionWheatInviteListView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    protected void initListener() {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    protected void dCF() {
        this.oFM = new c(getContext());
        this.oCu.setAdapter((ListAdapter) this.oFM);
        this.bxT.setRefreshButton(getResources().getString(a.h.yuyin_ala_connection_wheat_load_data_retry), new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatInviteListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public void zV(boolean z) {
        if (z) {
            showLoading();
        }
        if (this.oFN == null) {
            this.oFN = new g(this.oAf, new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatInviteListView.2
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.g.a
                public void a(AlaGetInviteConnectionWheatListHttpResponseMessage alaGetInviteConnectionWheatListHttpResponseMessage) {
                    ConnectionWheatInviteListView.this.b(alaGetInviteConnectionWheatListHttpResponseMessage);
                    ConnectionWheatInviteListView.this.hideLoading();
                    ConnectionWheatInviteListView.this.efy();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.g.a
                public void onFail(int i, String str) {
                    ConnectionWheatInviteListView.this.b(null);
                    ConnectionWheatInviteListView.this.hideLoading();
                    ConnectionWheatInviteListView.this.efz();
                }
            });
        }
        this.oFN.request();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public int getCount() {
        if (this.oFM != null) {
            return this.oFM.getCount();
        }
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public String getNoDataStr() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaGetInviteConnectionWheatListHttpResponseMessage alaGetInviteConnectionWheatListHttpResponseMessage) {
        if (alaGetInviteConnectionWheatListHttpResponseMessage == null) {
            setData(null);
            return;
        }
        if (alaGetInviteConnectionWheatListHttpResponseMessage.getCount() > 0) {
            this.oFa.setVisibility(0);
            this.oFa.setText(String.format(getContext().getString(a.h.yuyin_ala_connection_wheat_online_audience_counts_text), Integer.valueOf(alaGetInviteConnectionWheatListHttpResponseMessage.getCount())));
        } else {
            this.oFa.setVisibility(8);
        }
        setData(alaGetInviteConnectionWheatListHttpResponseMessage.egc());
    }

    private void setData(List<n> list) {
        if (this.oFM != null) {
            this.oFM.setData(list);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public void setTbPageContext(TbPageContext tbPageContext) {
        this.oAf = tbPageContext;
    }

    public void setOnItemClickLister(c.a aVar) {
        if (this.oFM != null) {
            this.oFM.setOnItemClickLister(aVar);
        }
    }

    public void onDestroy() {
        if (this.oFM != null) {
            this.oFM.clear();
        }
        if (this.oFN != null) {
            this.oFN.onDestroy();
            this.oFN = null;
        }
    }
}
