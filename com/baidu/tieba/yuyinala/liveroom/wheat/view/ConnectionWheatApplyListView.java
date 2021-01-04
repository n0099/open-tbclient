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
/* loaded from: classes11.dex */
public class ConnectionWheatApplyListView extends BaseConnectionWheatListView {
    private e oBG;
    private g oBy;
    private boolean oCA;
    private boolean oCp;
    private c oCw;
    private b oFD;
    private b.a oxR;

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
    protected void dCF() {
        this.oFD = new b(getContext());
        this.oCu.setAdapter((ListAdapter) this.oFD);
        this.bxT.setRefreshButton(getResources().getString(a.h.yuyin_ala_connection_wheat_load_data_retry), new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    protected ConnectionWheatButtonView.a getConnectionWheatButtonClickListener() {
        return new ConnectionWheatButtonView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void efB() {
                ConnectionWheatApplyListView.this.NI(ConnectionWheatApplyListView.this.oCy);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void efC() {
                ConnectionWheatApplyListView.this.NI(ConnectionWheatApplyListView.this.oCy < 5 ? ConnectionWheatApplyListView.this.oCy : 1);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatButtonView.a
            public void efD() {
                ConnectionWheatApplyListView.this.NI(ConnectionWheatApplyListView.this.oCy >= 5 ? ConnectionWheatApplyListView.this.oCy : 5);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NI(int i) {
        if (!this.oCp) {
            NN(i);
            return;
        }
        if (this.oBy == null) {
            this.oBy = new g(this.oAf);
            this.oBy.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onCancel() {
                    ConnectionWheatApplyListView.this.oBy.dismiss();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                public void onConfirm() {
                    ConnectionWheatApplyListView.this.eeX();
                    ConnectionWheatApplyListView.this.oBy.dismiss();
                }
            });
        }
        this.oBy.show();
        this.oBy.setText(getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_apply_text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eeX() {
        if (this.oBG == null) {
            this.oBG = new e(this.oAf, new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.4
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().eei();
                        ConnectionWheatApplyListView.this.b(alaCancelApplyOrCancelInviteHttpResponseMessage);
                        o.eff().zQ(false);
                        BdToast.makeText(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.getContext().getString(a.h.yuyin_ala_connection_wheat_cancel_success_text)).show();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.e.a
                public void onFail(int i, String str) {
                }
            });
        }
        this.oBG.gS(getRoomId(), "1");
    }

    private String getRoomId() {
        return com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().Cq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
        if (alaCancelApplyOrCancelInviteHttpResponseMessage != null && alaCancelApplyOrCancelInviteHttpResponseMessage.getErrno() == 0) {
            zV(false);
        }
    }

    private void NN(final int i) {
        d.eeN().a(getContext(), this.oAf.getPageActivity(), new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
            public void zM(boolean z) {
                if (z) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.c.c.eeM().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.5.1
                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                        public void dfk() {
                        }

                        @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                        public void eeH() {
                            ConnectionWheatApplyListView.this.oCA = true;
                            com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().eeh();
                            o.eff().zQ(true);
                            ConnectionWheatApplyListView.this.zV(false);
                            BdToast.makeText(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.getContext().getString(a.h.yuyin_ala_connection_wheat_apply_success_text)).show();
                        }
                    }).a(ConnectionWheatApplyListView.this.getContext(), ConnectionWheatApplyListView.this.oAf.getPageActivity(), "2", String.valueOf(i));
                }
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public void zV(boolean z) {
        if (z) {
            showLoading();
        }
        if (this.oCw == null) {
            this.oCw = new com.baidu.tieba.yuyinala.liveroom.wheat.model.c(this.oAf, new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.6
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                public void a(AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage) {
                    ConnectionWheatApplyListView.this.b(alaGetApplyWheatListHttpResponseMessage);
                    ConnectionWheatApplyListView.this.hideLoading();
                    ConnectionWheatApplyListView.this.efy();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.c.a
                public void onFail(int i, String str) {
                    ConnectionWheatApplyListView.this.b((AlaGetApplyWheatListHttpResponseMessage) null);
                    ConnectionWheatApplyListView.this.hideLoading();
                    ConnectionWheatApplyListView.this.efz();
                }
            });
        }
        this.oCw.request();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseConnectionWheatListView
    public int getCount() {
        if (this.oFD != null) {
            return this.oFD.getCount();
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
        this.oCp = false;
        if (alaGetApplyWheatListHttpResponseMessage.ega()) {
            this.oCz.setVisibility(8);
        } else {
            this.oCz.setVisibility(0);
            this.oCz.aj(alaGetApplyWheatListHttpResponseMessage.getCount(), alaGetApplyWheatListHttpResponseMessage.getPosition(), alaGetApplyWheatListHttpResponseMessage.egb());
        }
        if (alaGetApplyWheatListHttpResponseMessage.getCount() > 0 && alaGetApplyWheatListHttpResponseMessage.getPosition() > 0) {
            i = alaGetApplyWheatListHttpResponseMessage.getPosition() - 1;
            this.oCp = true;
        }
        setData(alaGetApplyWheatListHttpResponseMessage.efZ(), i);
        if (this.oxR != null && this.oFD != null) {
            this.oxR.Nx(this.oFD.getCount());
        }
        if (this.oCA) {
            this.oCA = false;
            this.oCu.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionWheatApplyListView.7
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionWheatApplyListView.this.oCu.smoothScrollToPosition(i);
                }
            });
        }
    }

    private void setData(List<com.baidu.live.data.e> list, int i) {
        if (this.oFD != null) {
            this.oFD.setData(list, i);
        }
    }

    public void setOnItemClickLister(b.a aVar) {
        this.oxR = aVar;
        if (this.oFD != null) {
            this.oFD.setOnItemClickLister(aVar);
        }
    }

    public void Wc(String str) {
        if (this.oFD != null) {
            this.oFD.Wc(str);
        }
        if (this.oxR != null && this.oFD != null) {
            this.oxR.Nx(this.oFD.getCount());
        }
    }

    public void onDestroy() {
        if (this.oBG != null) {
            this.oBG.onDestroy();
            this.oBG = null;
        }
        if (this.oCw != null) {
            this.oCw.onDestroy();
            this.oCw = null;
        }
    }
}
