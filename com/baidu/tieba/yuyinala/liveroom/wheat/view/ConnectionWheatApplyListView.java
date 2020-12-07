package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import com.baidu.live.data.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.tieba.yuyinala.liveroom.wheat.a.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.d;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaCancelApplyOrCancelInviteHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaGetApplyWheatListHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.b;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.d;
import java.util.List;
/* loaded from: classes4.dex */
public class ConnectionWheatApplyListView extends BaseConnectionWheatListView {
    private b.a orC;
    private g ouL;
    private d ouS;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.b ovG;
    private boolean ovz;
    private b oyq;

    public ConnectionWheatApplyListView(@NonNull Context context) {
        this(context, null);
    }

    public ConnectionWheatApplyListView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ConnectionWheatApplyListView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    protected void initListener() {
        this.ovI.setOnClickListener(this);
        this.ovI.setOnTouchListener(new a());
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    protected void dCP() {
        this.oyq = new b(getContext());
        this.ovE.setAdapter((ListAdapter) this.oyq);
        this.btg.setRefreshButton(getResources().getString(a.h.yuyin_ala_connection_wheat_load_data_retry), new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ovI) {
            if (!this.ovz) {
                NV(this.ovL);
                return;
            }
            if (this.ouL == null) {
                this.ouL = new g(this.oty);
                this.ouL.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.2
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                        ConnectionWheatApplyListView.this.ouL.dismiss();
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        ConnectionWheatApplyListView.this.eeV();
                        ConnectionWheatApplyListView.this.ouL.dismiss();
                    }
                });
            }
            this.ouL.show();
            this.ouL.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_apply_text));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eeV() {
        if (this.ouS == null) {
            this.ouS = new d(this.oty, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        c.eeo().eeq().eei();
                        ConnectionWheatApplyListView.this.b(alaCancelApplyOrCancelInviteHttpResponseMessage);
                        o.efd().zO(false);
                        BdToast.makeText(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_success_text)).show();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                public void onFail(int i, String str) {
                }
            });
        }
        this.ouS.gU(getRoomId(), "1");
    }

    private String getRoomId() {
        return c.eeo().CZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
        if (alaCancelApplyOrCancelInviteHttpResponseMessage != null && alaCancelApplyOrCancelInviteHttpResponseMessage.getErrno() == 0) {
            zU(false);
        }
    }

    private void NV(final int i) {
        com.baidu.tieba.yuyinala.liveroom.wheat.c.d.eeM().a(getContext(), this.oty.getPageActivity(), new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.4
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
            public void zK(boolean z) {
                if (z) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.c.c.eeL().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.4.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                        public void dfx() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                        public void eeG() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().eeh();
                            o.efd().zO(true);
                            ConnectionWheatApplyListView.this.zU(false);
                            BdToast.makeText(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.getContext().getString(a.h.yuyin_ala_connection_wheat_apply_success_text)).show();
                        }
                    }).a(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.oty.getPageActivity(), "2", String.valueOf(i));
                }
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public void zU(boolean z) {
        if (z) {
            showLoading();
        }
        if (this.ovG == null) {
            this.ovG = new com.baidu.tieba.yuyinala.liveroom.wheat.model.b(this.oty, new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.5
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.b.a
                public void a(AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage) {
                    ConnectionWheatApplyListView.this.b(alaGetApplyWheatListHttpResponseMessage);
                    ConnectionWheatApplyListView.this.hideLoading();
                    ConnectionWheatApplyListView.this.efu();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.b.a
                public void onFail(int i, String str) {
                    ConnectionWheatApplyListView.this.b((AlaGetApplyWheatListHttpResponseMessage) null);
                    ConnectionWheatApplyListView.this.hideLoading();
                    ConnectionWheatApplyListView.this.efv();
                }
            });
        }
        this.ovG.request();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public int getCount() {
        if (this.oyq != null) {
            return this.oyq.getCount();
        }
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public String getNoDataStr() {
        return getContext().getString(a.h.yuyin_ala_connection_wheat_empty_text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage) {
        if (alaGetApplyWheatListHttpResponseMessage == null) {
            setData(null);
            return;
        }
        this.ovz = false;
        if (alaGetApplyWheatListHttpResponseMessage.efQ()) {
            this.ovJ.setVisibility(8);
        } else {
            this.ovJ.setVisibility(0);
        }
        if (alaGetApplyWheatListHttpResponseMessage.getCount() > 0) {
            if (alaGetApplyWheatListHttpResponseMessage.getPosition() > 0) {
                this.ovz = true;
                this.ovI.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_text));
            } else {
                this.ovI.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_request_text));
            }
        } else {
            this.ovI.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_request_text));
        }
        setData(alaGetApplyWheatListHttpResponseMessage.efP());
        if (this.orC != null && this.oyq != null) {
            this.orC.NH(this.oyq.getCount());
        }
    }

    private void setData(List<e> list) {
        if (this.oyq != null) {
            this.oyq.setData(list);
        }
    }

    public void setOnItemClickLister(b.a aVar) {
        this.orC = aVar;
        if (this.oyq != null) {
            this.oyq.setOnItemClickLister(aVar);
        }
    }

    public void Wt(String str) {
        if (this.oyq != null) {
            this.oyq.Wt(str);
        }
        if (this.orC != null && this.oyq != null) {
            this.orC.NH(this.oyq.getCount());
        }
    }

    public void onDestroy() {
        if (this.ouS != null) {
            this.ouS.onDestroy();
            this.ouS = null;
        }
        if (this.ovG != null) {
            this.ovG.onDestroy();
            this.ovG = null;
        }
    }
}
