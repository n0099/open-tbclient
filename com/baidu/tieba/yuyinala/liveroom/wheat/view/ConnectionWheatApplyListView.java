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
    private b.a orE;
    private g ouN;
    private d ouU;
    private boolean ovB;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.b ovI;
    private b oys;

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
        this.ovK.setOnClickListener(this);
        this.ovK.setOnTouchListener(new a());
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    protected void dCQ() {
        this.oys = new b(getContext());
        this.ovG.setAdapter((ListAdapter) this.oys);
        this.btg.setRefreshButton(getResources().getString(a.h.yuyin_ala_connection_wheat_load_data_retry), new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ovK) {
            if (!this.ovB) {
                NV(this.ovN);
                return;
            }
            if (this.ouN == null) {
                this.ouN = new g(this.otA);
                this.ouN.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.2
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                        ConnectionWheatApplyListView.this.ouN.dismiss();
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        ConnectionWheatApplyListView.this.eeW();
                        ConnectionWheatApplyListView.this.ouN.dismiss();
                    }
                });
            }
            this.ouN.show();
            this.ouN.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_apply_text));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eeW() {
        if (this.ouU == null) {
            this.ouU = new d(this.otA, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        c.eep().eer().eej();
                        ConnectionWheatApplyListView.this.b(alaCancelApplyOrCancelInviteHttpResponseMessage);
                        o.efe().zO(false);
                        BdToast.makeText(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_success_text)).show();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                public void onFail(int i, String str) {
                }
            });
        }
        this.ouU.gU(getRoomId(), "1");
    }

    private String getRoomId() {
        return c.eep().CZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
        if (alaCancelApplyOrCancelInviteHttpResponseMessage != null && alaCancelApplyOrCancelInviteHttpResponseMessage.getErrno() == 0) {
            zU(false);
        }
    }

    private void NV(final int i) {
        com.baidu.tieba.yuyinala.liveroom.wheat.c.d.eeN().a(getContext(), this.otA.getPageActivity(), new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.4
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
            public void zK(boolean z) {
                if (z) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.c.c.eeM().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.4.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                        public void dfy() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                        public void eeH() {
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().eei();
                            o.efe().zO(true);
                            ConnectionWheatApplyListView.this.zU(false);
                            BdToast.makeText(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.getContext().getString(a.h.yuyin_ala_connection_wheat_apply_success_text)).show();
                        }
                    }).a(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.otA.getPageActivity(), "2", String.valueOf(i));
                }
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public void zU(boolean z) {
        if (z) {
            showLoading();
        }
        if (this.ovI == null) {
            this.ovI = new com.baidu.tieba.yuyinala.liveroom.wheat.model.b(this.otA, new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.5
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.b.a
                public void a(AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage) {
                    ConnectionWheatApplyListView.this.b(alaGetApplyWheatListHttpResponseMessage);
                    ConnectionWheatApplyListView.this.hideLoading();
                    ConnectionWheatApplyListView.this.efv();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.b.a
                public void onFail(int i, String str) {
                    ConnectionWheatApplyListView.this.b((AlaGetApplyWheatListHttpResponseMessage) null);
                    ConnectionWheatApplyListView.this.hideLoading();
                    ConnectionWheatApplyListView.this.efw();
                }
            });
        }
        this.ovI.request();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public int getCount() {
        if (this.oys != null) {
            return this.oys.getCount();
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
        this.ovB = false;
        if (alaGetApplyWheatListHttpResponseMessage.efR()) {
            this.ovL.setVisibility(8);
        } else {
            this.ovL.setVisibility(0);
        }
        if (alaGetApplyWheatListHttpResponseMessage.getCount() > 0) {
            if (alaGetApplyWheatListHttpResponseMessage.getPosition() > 0) {
                this.ovB = true;
                this.ovK.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_text));
            } else {
                this.ovK.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_request_text));
            }
        } else {
            this.ovK.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_request_text));
        }
        setData(alaGetApplyWheatListHttpResponseMessage.efQ());
        if (this.orE != null && this.oys != null) {
            this.orE.NH(this.oys.getCount());
        }
    }

    private void setData(List<e> list) {
        if (this.oys != null) {
            this.oys.setData(list);
        }
    }

    public void setOnItemClickLister(b.a aVar) {
        this.orE = aVar;
        if (this.oys != null) {
            this.oys.setOnItemClickLister(aVar);
        }
    }

    public void Wt(String str) {
        if (this.oys != null) {
            this.oys.Wt(str);
        }
        if (this.orE != null && this.oys != null) {
            this.orE.NH(this.oys.getCount());
        }
    }

    public void onDestroy() {
        if (this.ouU != null) {
            this.ouU.onDestroy();
            this.ouU = null;
        }
        if (this.ovI != null) {
            this.ovI.onDestroy();
            this.ovI = null;
        }
    }
}
