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
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
/* loaded from: classes10.dex */
public class h extends a implements DialogInterface.OnDismissListener, View.OnClickListener {
    private TextView akM;
    private TextView bZE;
    public CustomMessageListener bhY;
    private CustomMessageListener cbL;
    private RelativeLayout grh;
    private BdGridView gvH;
    private TextView mTitle;
    private b oHT;
    private com.baidu.tieba.yuyinala.liveroom.wheat.adapter.e oKT;
    private TextView oKU;
    private AlaWheatMoreFunctionData oKV;
    public HttpMessageListener oKW;

    public h(TbPageContext tbPageContext, AlaWheatMoreFunctionData alaWheatMoreFunctionData) {
        super(tbPageContext);
        this.cbL = new CustomMessageListener(2501081) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage == null || customResponsedMessage.getCmd() == 2501081) && h.this.oKT != null) {
                    h.this.oKT.ecH();
                }
            }
        };
        this.oKW = new HttpMessageListener(1031017) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage.getCmd() == 1031017) {
                    h.this.ckD();
                    h.this.Al(httpResponsedMessage.getError() == 0);
                    h.this.dismiss();
                }
            }
        };
        this.bhY = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (h.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    h.this.dismiss();
                }
            }
        };
        this.oKV = alaWheatMoreFunctionData;
        MB(80);
        Ah(true);
        Ai(true);
        g(this);
    }

    protected void initView() {
        this.bZE = (TextView) findViewById(a.f.tv_cancel);
        this.bZE.setOnClickListener(this);
        this.mTitle = (TextView) findViewById(a.f.tv_title);
        this.oKU = (TextView) findViewById(a.f.tv_clear_confirm);
        this.oKU.setOnClickListener(this);
        this.oKU.setClickable(true);
        this.oKU.setTextColor(-57755);
        this.gvH = (BdGridView) findViewById(a.f.wheat_clear_gridview);
        this.gvH.setNumColumns(5);
        this.oKT = new com.baidu.tieba.yuyinala.liveroom.wheat.adapter.e(this.mContext);
        this.gvH.setAdapter((ListAdapter) this.oKT);
        this.oKT.a(new e.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.e.a
            public void I(View view, int i) {
                h.this.oKU.setClickable(!TextUtils.isEmpty(h.this.oKT.ecI()));
                h.this.oKU.setTextColor(!TextUtils.isEmpty(h.this.oKT.ecI()) ? -57755 : -11382190);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.e.a
            public void notifyDataSetChanged() {
                h.this.bbE();
            }
        });
        this.grh = (RelativeLayout) findViewById(a.f.rl_no_data);
        this.akM = (TextView) findViewById(a.f.wheat_clear_desc);
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
    protected boolean Sv() {
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean Sw() {
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
        MessageManager.getInstance().registerListener(this.bhY);
        MessageManager.getInstance().registerListener(this.oKW);
        MessageManager.getInstance().registerListener(this.cbL);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
        if (this.oKT != null) {
            this.oKT.ecH();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.oKU) {
            eeu();
        } else if (view == this.bZE) {
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbE() {
        boolean z = (q.edU().Yq() == null || q.edU().Yq().isEmpty()) && (q.edU().edX() == null || q.edU().edX().isEmpty());
        if (this.grh != null) {
            this.grh.setVisibility(z ? 0 : 8);
        }
        if (this.gvH != null) {
            this.gvH.setVisibility(z ? 8 : 0);
        }
        if (this.akM != null) {
            this.akM.setVisibility(z ? 8 : 0);
        }
        if (this.oKU != null) {
            this.oKU.setVisibility(z ? 4 : 0);
        }
    }

    private void eeu() {
        final com.baidu.live.view.c cVar = new com.baidu.live.view.c(this.oIJ.getPageActivity());
        cVar.setCancelable(false);
        cVar.setCanceledOnTouchOutside(false);
        cVar.dD(false);
        cVar.o(this.oIJ.getString((this.oKT == null || !this.oKT.ecJ()) ? a.h.yuyin_ala_clear_charm_title_items : a.h.yuyin_ala_clear_charm_title_all), "", this.oIJ.getString(a.h.sdk_alert_yes_button), this.oIJ.getString(a.h.sdk_live_cancel));
        cVar.fm(this.oIJ.getResources().getColor(a.c.sdk_black_alpha100));
        cVar.fn(this.oIJ.getResources().getColor(a.c.sdk_black_alpha100));
        cVar.dF(false);
        cVar.dG(false);
        cVar.E(this.oIJ.getResources().getDimension(a.d.sdk_ds12));
        cVar.setTitleTextSize(this.oIJ.getResources().getDimension(a.d.sdk_fontsize34));
        cVar.dE(false);
        cVar.fl(this.oIJ.getResources().getColor(a.c.sdk_common_color_10215));
        cVar.F(this.oIJ.getResources().getDimension(a.d.sdk_fontsize28));
        cVar.a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h.2
            @Override // com.baidu.live.view.c.a
            public void Qd() {
                if (h.this.oKT != null) {
                    if (!h.this.oKT.ecJ()) {
                        h.this.WN(h.this.oKT.ecI());
                    } else {
                        h.this.eev();
                    }
                    h.this.showLoadingDialog(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_clear_charm_loading));
                }
                cVar.dismiss();
            }

            @Override // com.baidu.live.view.c.a
            public void Qe() {
                cVar.dismiss();
            }
        });
        cVar.show();
    }

    public void WN(String str) {
        if (this.oKV != null) {
            HttpMessage httpMessage = new HttpMessage(1031017);
            httpMessage.addParam("live_id", this.oKV.mLiveId);
            httpMessage.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oKV.mCustomRoomId);
            httpMessage.addParam("room_id", this.oKV.mRoomId);
            httpMessage.addParam("uks", str);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void eev() {
        if (this.oKV != null) {
            HttpMessage httpMessage = new HttpMessage(1031017);
            httpMessage.addParam("live_id", this.oKV.mLiveId);
            httpMessage.addParam(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oKV.mCustomRoomId);
            httpMessage.addParam("room_id", this.oKV.mRoomId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void Al(boolean z) {
        this.oIJ.showToast(z ? a.h.yuyin_ala_audio_clear_charm_succ : a.h.yuyin_ala_audio_clear_charm_fail);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingDialog(String str) {
        if (this.oHT == null) {
            this.oHT = new b(this.mContext);
        }
        this.oHT.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.h.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                h.this.oHT = null;
            }
        });
        if (!this.oHT.isShowing()) {
            this.oHT.show();
        }
        this.oHT.setTipString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckD() {
        if (this.oHT != null) {
            this.oHT.dismiss();
            this.oHT = null;
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.oHT != null) {
            this.oHT = null;
        }
        MessageManager.getInstance().unRegisterListener(this.bhY);
        MessageManager.getInstance().unRegisterListener(this.oKW);
        MessageManager.getInstance().unRegisterListener(this.cbL);
    }
}
