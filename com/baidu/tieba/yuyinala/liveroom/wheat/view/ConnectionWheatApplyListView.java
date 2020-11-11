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
    private b.a oaX;
    private boolean oeV;
    private g oeh;
    private d oeo;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.b ofc;
    private b ohM;

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
        this.ofe.setOnClickListener(this);
        this.ofe.setOnTouchListener(new a());
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    protected void dxY() {
        this.ohM = new b(getContext());
        this.ofa.setAdapter((ListAdapter) this.ohM);
        this.bpJ.setRefreshButton(getResources().getString(a.h.yuyin_ala_connection_wheat_load_data_retry), new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ofe) {
            if (!this.oeV) {
                MA(this.ofi);
                return;
            }
            if (this.oeh == null) {
                this.oeh = new g(this.ocV);
                this.oeh.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.2
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                        ConnectionWheatApplyListView.this.oeh.dismiss();
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        ConnectionWheatApplyListView.this.dZs();
                        ConnectionWheatApplyListView.this.oeh.dismiss();
                    }
                });
            }
            this.oeh.show();
            this.oeh.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_apply_text));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZs() {
        if (this.oeo == null) {
            this.oeo = new d(this.ocV, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        c.dYL().dYN().dYF();
                        ConnectionWheatApplyListView.this.b(alaCancelApplyOrCancelInviteHttpResponseMessage);
                        o.dZA().zd(false);
                        BdToast.makeText(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_success_text)).show();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                public void onFail(int i, String str) {
                }
            });
        }
        this.oeo.gP(getRoomId(), "1");
    }

    private String getRoomId() {
        return c.dYL().Ca();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
        if (alaCancelApplyOrCancelInviteHttpResponseMessage != null && alaCancelApplyOrCancelInviteHttpResponseMessage.getErrno() == 0) {
            zj(false);
        }
    }

    private void MA(final int i) {
        com.baidu.tieba.yuyinala.liveroom.wheat.c.d.dZj().a(getContext(), this.ocV.getPageActivity(), new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.4
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
            public void yZ(boolean z) {
                if (z) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.c.c.dZi().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.4.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                        public void daO() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                        public void dZd() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN().dYE();
                            o.dZA().zd(true);
                            ConnectionWheatApplyListView.this.zj(false);
                            BdToast.makeText(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.getContext().getString(a.h.yuyin_ala_connection_wheat_apply_success_text)).show();
                        }
                    }).a(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.ocV.getPageActivity(), "2", String.valueOf(i));
                }
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public void zj(boolean z) {
        if (z) {
            showLoading();
        }
        if (this.ofc == null) {
            this.ofc = new com.baidu.tieba.yuyinala.liveroom.wheat.model.b(this.ocV, new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.5
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.b.a
                public void a(AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage) {
                    ConnectionWheatApplyListView.this.b(alaGetApplyWheatListHttpResponseMessage);
                    ConnectionWheatApplyListView.this.hideLoading();
                    ConnectionWheatApplyListView.this.dZQ();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.b.a
                public void onFail(int i, String str) {
                    ConnectionWheatApplyListView.this.b((AlaGetApplyWheatListHttpResponseMessage) null);
                    ConnectionWheatApplyListView.this.hideLoading();
                    ConnectionWheatApplyListView.this.dZR();
                }
            });
        }
        this.ofc.request();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public int getCount() {
        if (this.ohM != null) {
            return this.ohM.getCount();
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
        this.oeV = false;
        if (alaGetApplyWheatListHttpResponseMessage.eam()) {
            this.ofg.setVisibility(8);
        } else {
            this.ofg.setVisibility(0);
        }
        if (alaGetApplyWheatListHttpResponseMessage.getCount() > 0) {
            if (alaGetApplyWheatListHttpResponseMessage.getPosition() > 0) {
                this.oeV = true;
                this.ofe.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_text));
            } else {
                this.ofe.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_request_text));
            }
        } else {
            this.ofe.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_request_text));
        }
        setData(alaGetApplyWheatListHttpResponseMessage.eal());
        if (this.oaX != null && this.ohM != null) {
            this.oaX.Mm(this.ohM.getCount());
        }
    }

    private void setData(List<e> list) {
        if (this.ohM != null) {
            this.ohM.setData(list);
        }
    }

    public void setOnItemClickLister(b.a aVar) {
        this.oaX = aVar;
        if (this.ohM != null) {
            this.ohM.setOnItemClickLister(aVar);
        }
    }

    public void Vt(String str) {
        if (this.ohM != null) {
            this.ohM.Vt(str);
        }
        if (this.oaX != null && this.ohM != null) {
            this.oaX.Mm(this.ohM.getCount());
        }
    }

    public void onDestroy() {
        if (this.oeo != null) {
            this.oeo.onDestroy();
            this.oeo = null;
        }
        if (this.ofc != null) {
            this.ofc.onDestroy();
            this.ofc = null;
        }
    }
}
