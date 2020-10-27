package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import com.baidu.live.data.m;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.yuyinala.liveroom.wheat.adapter.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.f;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaGetInviteConnectionWheatListHttpResponseMessage;
import java.util.List;
/* loaded from: classes4.dex */
public class ConnectionWheatInviteListView extends BaseConnectionWheatListView {
    private c nZm;
    private f nZn;

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
    protected void dvw() {
        this.nZm = new c(getContext());
        this.nXJ.setAdapter((ListAdapter) this.nZm);
        this.boq.setRefreshButton(getResources().getString(a.i.yuyin_ala_connection_wheat_load_data_retry), new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatInviteListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public void zb(boolean z) {
        if (z) {
            showLoading();
        }
        if (this.nZn == null) {
            this.nZn = new f(this.nVE, new f.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatInviteListView.2
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.f.a
                public void a(AlaGetInviteConnectionWheatListHttpResponseMessage alaGetInviteConnectionWheatListHttpResponseMessage) {
                    ConnectionWheatInviteListView.this.b(alaGetInviteConnectionWheatListHttpResponseMessage);
                    ConnectionWheatInviteListView.this.hideLoading();
                    ConnectionWheatInviteListView.this.dWR();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.f.a
                public void onFail(int i, String str) {
                    ConnectionWheatInviteListView.this.b(null);
                    ConnectionWheatInviteListView.this.hideLoading();
                    ConnectionWheatInviteListView.this.dWS();
                }
            });
        }
        this.nZn.request();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public int getCount() {
        if (this.nZm != null) {
            return this.nZm.getCount();
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
            this.nZg.setVisibility(0);
            this.nZg.setText(String.format(getContext().getString(a.i.yuyin_ala_connection_wheat_online_audience_counts_text), Integer.valueOf(alaGetInviteConnectionWheatListHttpResponseMessage.getCount())));
        } else {
            this.nZg.setVisibility(8);
        }
        setData(alaGetInviteConnectionWheatListHttpResponseMessage.dXd());
    }

    private void setData(List<m> list) {
        if (this.nZm != null) {
            this.nZm.setData(list);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public void setTbPageContext(TbPageContext tbPageContext) {
        this.nVE = tbPageContext;
    }

    public void setOnItemClickLister(c.a aVar) {
        if (this.nZm != null) {
            this.nZm.setOnItemClickLister(aVar);
        }
    }

    public void onDestroy() {
        if (this.nZm != null) {
            this.nZm.clear();
        }
        if (this.nZn != null) {
            this.nZn.onDestroy();
            this.nZn = null;
        }
    }
}
