package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.tieba.yuyinala.liveroom.wheat.adapter.b;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.d;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaCancelApplyOrCancelInviteHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaGetApplyWheatListHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.e;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView;
import java.util.List;
/* loaded from: classes10.dex */
public class ConnectionWheatApplyListView extends BaseConnectionWheatListView {
    private b oAY;
    private b.a otl;
    private g owT;
    private boolean oxK;
    private c oxR;
    private boolean oxV;
    private e oxb;

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
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    protected void dyO() {
        this.oAY = new b(getContext());
        this.oxP.setAdapter((ListAdapter) this.oAY);
        this.btf.setRefreshButton(getResources().getString(a.h.yuyin_ala_connection_wheat_load_data_retry), new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    protected ConnectionWheatButtonView.a getConnectionWheatButtonClickListener() {
        return new ConnectionWheatButtonView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void ebK() {
                ConnectionWheatApplyListView.this.Mb(ConnectionWheatApplyListView.this.oxT);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void ebL() {
                ConnectionWheatApplyListView.this.Mb(ConnectionWheatApplyListView.this.oxT < 5 ? ConnectionWheatApplyListView.this.oxT : 1);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void ebM() {
                ConnectionWheatApplyListView.this.Mb(ConnectionWheatApplyListView.this.oxT >= 5 ? ConnectionWheatApplyListView.this.oxT : 5);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mb(int i) {
        if (!this.oxK) {
            Mg(i);
            return;
        }
        if (this.owT == null) {
            this.owT = new g(this.ovA);
            this.owT.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onCancel() {
                    ConnectionWheatApplyListView.this.owT.dismiss();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onConfirm() {
                    ConnectionWheatApplyListView.this.ebg();
                    ConnectionWheatApplyListView.this.owT.dismiss();
                }
            });
        }
        this.owT.show();
        this.owT.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_apply_text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebg() {
        if (this.oxb == null) {
            this.oxb = new e(this.ovA, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.4
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz().ear();
                        ConnectionWheatApplyListView.this.b(alaCancelApplyOrCancelInviteHttpResponseMessage);
                        o.ebo().zM(false);
                        BdToast.makeText(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_success_text)).show();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void onFail(int i, String str) {
                }
            });
        }
        this.oxb.gR(getRoomId(), "1");
    }

    private String getRoomId() {
        return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().yv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
        if (alaCancelApplyOrCancelInviteHttpResponseMessage != null && alaCancelApplyOrCancelInviteHttpResponseMessage.getErrno() == 0) {
            zR(false);
        }
    }

    private void Mg(final int i) {
        d.eaW().a(getContext(), this.ovA.getPageActivity(), new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
            public void zI(boolean z) {
                if (z) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.c.c.eaV().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.5.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                        public void dbt() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                        public void eaQ() {
                            ConnectionWheatApplyListView.this.oxV = true;
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eax().eaz().eaq();
                            o.ebo().zM(true);
                            ConnectionWheatApplyListView.this.zR(false);
                            BdToast.makeText(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.getContext().getString(a.h.yuyin_ala_connection_wheat_apply_success_text)).show();
                        }
                    }).a(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.ovA.getPageActivity(), "2", String.valueOf(i));
                }
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public void zR(boolean z) {
        if (z) {
            showLoading();
        }
        if (this.oxR == null) {
            this.oxR = new com.baidu.tieba.yuyinala.liveroom.wheat.model.c(this.ovA, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.6
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                public void a(AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage) {
                    ConnectionWheatApplyListView.this.b(alaGetApplyWheatListHttpResponseMessage);
                    ConnectionWheatApplyListView.this.hideLoading();
                    ConnectionWheatApplyListView.this.ebH();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                public void onFail(int i, String str) {
                    ConnectionWheatApplyListView.this.b((AlaGetApplyWheatListHttpResponseMessage) null);
                    ConnectionWheatApplyListView.this.hideLoading();
                    ConnectionWheatApplyListView.this.ebI();
                }
            });
        }
        this.oxR.request();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public int getCount() {
        if (this.oAY != null) {
            return this.oAY.getCount();
        }
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public String getNoDataStr() {
        return getContext().getString(a.h.yuyin_ala_connection_wheat_empty_text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage) {
        final int i = -1;
        if (alaGetApplyWheatListHttpResponseMessage == null) {
            setData(null, -1);
            return;
        }
        this.oxK = false;
        if (alaGetApplyWheatListHttpResponseMessage.ecj()) {
            this.oxU.setVisibility(8);
        } else {
            this.oxU.setVisibility(0);
            this.oxU.aj(alaGetApplyWheatListHttpResponseMessage.getCount(), alaGetApplyWheatListHttpResponseMessage.getPosition(), alaGetApplyWheatListHttpResponseMessage.eck());
        }
        if (alaGetApplyWheatListHttpResponseMessage.getCount() > 0 && alaGetApplyWheatListHttpResponseMessage.getPosition() > 0) {
            i = alaGetApplyWheatListHttpResponseMessage.getPosition() - 1;
            this.oxK = true;
        }
        setData(alaGetApplyWheatListHttpResponseMessage.eci(), i);
        if (this.otl != null && this.oAY != null) {
            this.otl.LQ(this.oAY.getCount());
        }
        if (this.oxV) {
            this.oxV = false;
            this.oxP.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.7
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionWheatApplyListView.this.oxP.smoothScrollToPosition(i);
                }
            });
        }
    }

    private void setData(List<com.baidu.live.data.e> list, int i) {
        if (this.oAY != null) {
            this.oAY.setData(list, i);
        }
    }

    public void setOnItemClickLister(b.a aVar) {
        this.otl = aVar;
        if (this.oAY != null) {
            this.oAY.setOnItemClickLister(aVar);
        }
    }

    public void UU(String str) {
        if (this.oAY != null) {
            this.oAY.UU(str);
        }
        if (this.otl != null && this.oAY != null) {
            this.otl.LQ(this.oAY.getCount());
        }
    }

    public void onDestroy() {
        if (this.oxb != null) {
            this.oxb.onDestroy();
            this.oxb = null;
        }
        if (this.oxR != null) {
            this.oxR.onDestroy();
            this.oxR = null;
        }
    }
}
