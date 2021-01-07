package com.baidu.tieba.yuyinala.liveroom.wheat.dialog;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.AlaWheatMoreFunctionData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.BdGridView;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.view.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.adapter.e;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
/* loaded from: classes11.dex */
public class h extends a implements DialogInterface.OnDismissListener, View.OnClickListener {
    private TextView akw;
    private TextView bYR;
    public CustomMessageListener bih;
    private CustomMessageListener caU;
    private RelativeLayout gri;
    private BdGridView gvH;
    private TextView mTitle;
    private b oAC;
    private com.baidu.tieba.yuyinala.liveroom.wheat.adapter.e oDl;
    private TextView oDm;
    private AlaWheatMoreFunctionData oDn;
    public HttpMessageListener oDo;

    public h(TbPageContext tbPageContext, AlaWheatMoreFunctionData alaWheatMoreFunctionData) {
        super(tbPageContext);
        this.caU = new CustomMessageListener(2501081) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage == null || customResponsedMessage.getCmd() == 2501081) && h.this.oDl != null) {
                    h.this.oDl.edW();
                }
            }
        };
        this.oDo = new HttpMessageListener(1031017) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage.getCmd() == 1031017) {
                    h.this.cnj();
                    h.this.zX(httpResponsedMessage.getError() == 0);
                    h.this.dismiss();
                }
            }
        };
        this.bih = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (h.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    h.this.dismiss();
                }
            }
        };
        this.oDn = alaWheatMoreFunctionData;
        NH(80);
        zT(true);
        zU(true);
        g(this);
    }

    protected void initView() {
        this.bYR = (TextView) findViewById(a.f.tv_cancel);
        this.bYR.setOnClickListener(this);
        this.mTitle = (TextView) findViewById(a.f.tv_title);
        this.oDm = (TextView) findViewById(a.f.tv_clear_confirm);
        this.oDm.setOnClickListener(this);
        this.oDm.setClickable(true);
        this.oDm.setTextColor(-57755);
        this.gvH = (BdGridView) findViewById(a.f.wheat_clear_gridview);
        this.gvH.setNumColumns(5);
        this.oDl = new com.baidu.tieba.yuyinala.liveroom.wheat.adapter.e(this.mContext);
        this.gvH.setAdapter((ListAdapter) this.oDl);
        this.oDl.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.e.a
            public void I(View view, int i) {
                h.this.oDm.setClickable(!TextUtils.isEmpty(h.this.oDl.edX()));
                h.this.oDm.setTextColor(!TextUtils.isEmpty(h.this.oDl.edX()) ? -57755 : -11382190);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.e.a
            public void notifyDataSetChanged() {
                h.this.bfj();
            }
        });
        this.gri = (RelativeLayout) findViewById(a.f.rl_no_data);
        this.akw = (TextView) findViewById(a.f.wheat_clear_desc);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected View getView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.yuyin_layout_dialog_wheat_clear, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean UD() {
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean UE() {
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected int getDialogMargin() {
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    public void show() {
        try {
            super.show();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        MessageManager.getInstance().registerListener(this.bih);
        MessageManager.getInstance().registerListener(this.oDo);
        MessageManager.getInstance().registerListener(this.caU);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
        if (this.oDl != null) {
            this.oDl.edW();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oDm) {
            efI();
        } else if (view == this.bYR) {
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfj() {
        boolean z = (o.efg().aaq() == null || o.efg().aaq().isEmpty()) && (o.efg().efj() == null || o.efg().efj().isEmpty());
        if (this.gri != null) {
            this.gri.setVisibility(z ? 0 : 8);
        }
        if (this.gvH != null) {
            this.gvH.setVisibility(z ? 8 : 0);
        }
        if (this.akw != null) {
            this.akw.setVisibility(z ? 8 : 0);
        }
        if (this.oDm != null) {
            this.oDm.setVisibility(z ? 4 : 0);
        }
    }

    private void efI() {
        final com.baidu.live.view.c cVar = new com.baidu.live.view.c(this.oAe.getPageActivity());
        cVar.setCancelable(false);
        cVar.setCanceledOnTouchOutside(false);
        cVar.dz(false);
        cVar.o(this.oAe.getString((this.oDl == null || !this.oDl.edY()) ? a.h.yuyin_ala_clear_charm_title_items : a.h.yuyin_ala_clear_charm_title_all), "", this.oAe.getString(a.h.sdk_alert_yes_button), this.oAe.getString(a.h.sdk_live_cancel));
        cVar.gO(this.oAe.getResources().getColor(a.c.sdk_black_alpha100));
        cVar.gP(this.oAe.getResources().getColor(a.c.sdk_black_alpha100));
        cVar.dB(false);
        cVar.dC(false);
        cVar.A(this.oAe.getResources().getDimension(a.d.sdk_ds12));
        cVar.setTitleTextSize(this.oAe.getResources().getDimension(a.d.sdk_fontsize34));
        cVar.dA(false);
        cVar.gN(this.oAe.getResources().getColor(a.c.sdk_common_color_10215));
        cVar.B(this.oAe.getResources().getDimension(a.d.sdk_fontsize28));
        cVar.a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h.2
            @Override // com.baidu.live.view.c.a
            public void Sw() {
                if (h.this.oDl != null) {
                    if (!h.this.oDl.edY()) {
                        h.this.WC(h.this.oDl.edX());
                    } else {
                        h.this.efJ();
                    }
                    h.this.showLoadingDialog(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_clear_charm_loading));
                }
                cVar.dismiss();
            }

            @Override // com.baidu.live.view.c.a
            public void Sx() {
                cVar.dismiss();
            }
        });
        cVar.show();
    }

    public void WC(String str) {
        if (this.oDn != null) {
            HttpMessage httpMessage = new HttpMessage(1031017);
            httpMessage.addParam("live_id", this.oDn.mLiveId);
            httpMessage.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oDn.mCustomRoomId);
            httpMessage.addParam("room_id", this.oDn.mRoomId);
            httpMessage.addParam("uks", str);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void efJ() {
        if (this.oDn != null) {
            HttpMessage httpMessage = new HttpMessage(1031017);
            httpMessage.addParam("live_id", this.oDn.mLiveId);
            httpMessage.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oDn.mCustomRoomId);
            httpMessage.addParam("room_id", this.oDn.mRoomId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void zX(boolean z) {
        this.oAe.showToast(z ? a.h.yuyin_ala_audio_clear_charm_succ : a.h.yuyin_ala_audio_clear_charm_fail);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog(String str) {
        if (this.oAC == null) {
            this.oAC = new b(this.mContext);
        }
        this.oAC.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                h.this.oAC = null;
            }
        });
        if (!this.oAC.isShowing()) {
            this.oAC.show();
        }
        this.oAC.setTipString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnj() {
        if (this.oAC != null) {
            this.oAC.dismiss();
            this.oAC = null;
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.oAC != null) {
            this.oAC = null;
        }
        MessageManager.getInstance().unRegisterListener(this.bih);
        MessageManager.getInstance().unRegisterListener(this.oDo);
        MessageManager.getInstance().unRegisterListener(this.caU);
    }
}
