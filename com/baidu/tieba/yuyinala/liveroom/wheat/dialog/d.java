package com.baidu.tieba.yuyinala.liveroom.wheat.dialog;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a;
import com.baidu.tieba.yuyinala.liveroom.wheat.b.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.b.n;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.b;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.d;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaCancelApplyOrCancelInviteHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaGetApplyWheatListHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.AlaConnectionWheatListView;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends a implements DialogInterface.OnDismissListener, View.OnClickListener {
    private CustomMessageListener aUa;
    public CustomMessageListener bcQ;
    private CommonEmptyView boq;
    private CustomMessageListener nWA;
    private g nWI;
    private com.baidu.tieba.yuyinala.liveroom.wheat.c.d nWP;
    private boolean nXE;
    private AlaConnectionWheatListView nXJ;
    private com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a nXK;
    private com.baidu.tieba.yuyinala.liveroom.wheat.c.b nXL;
    private TextView nXM;
    private TextView nXN;
    private LinearLayout nXO;
    private RelativeLayout nXP;
    private CustomMessageListener nXQ;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.aUa = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913054) {
                    d.this.dismiss();
                }
            }
        };
        this.nWA = new CustomMessageListener(2501036) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501036) {
                    d.this.dismiss();
                }
            }
        };
        this.nXQ = new CustomMessageListener(2501012) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501012) {
                    d.this.zb(false);
                }
            }
        };
        this.bcQ = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    d.this.dismiss();
                }
            }
        };
        Mf(80);
        yZ(true);
        za(true);
        g(this);
    }

    protected void initView() {
        this.nXJ = (AlaConnectionWheatListView) findViewById(a.g.listView);
        this.nXM = (TextView) findViewById(a.g.tv_current_rank);
        this.nXN = (TextView) findViewById(a.g.tv_apply_btn);
        this.nXO = (LinearLayout) findViewById(a.g.ll_apply_btn);
        this.nXP = (RelativeLayout) findViewById(a.g.loading_view_container);
        this.boq = (CommonEmptyView) findViewById(a.g.empty_view_2);
        this.nXK = new com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a(this.bIs);
        this.nXJ.setAdapter((ListAdapter) this.nXK);
        this.nXN.setOnClickListener(this);
        this.nXN.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        showLoading();
        this.nXK.a(new a.InterfaceC0903a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.InterfaceC0903a
            public void a(com.baidu.live.data.e eVar) {
                d.this.dismiss();
                d.this.c(eVar.uk, eVar.mUserName, eVar.mPortrait, eVar.mSex, eVar.mUserName);
            }
        });
    }

    public void zb(boolean z) {
        if (z) {
            showLoading();
        }
        if (this.nXL == null) {
            this.nXL = new com.baidu.tieba.yuyinala.liveroom.wheat.c.b(this.nVE, new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.b.a
                public void a(AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage) {
                    d.this.i(alaGetApplyWheatListHttpResponseMessage.dXb(), alaGetApplyWheatListHttpResponseMessage.getCount(), alaGetApplyWheatListHttpResponseMessage.getPosition());
                    d.this.hideLoading();
                    d.this.dWR();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.b.a
                public void onFail(int i, String str) {
                    d.this.dWS();
                    d.this.hideLoading();
                }
            });
        }
        this.nXL.request();
    }

    public void dWC() {
        zb(true);
    }

    public void dWR() {
        if (this.nXK != null && this.nXK.getCount() != 0) {
            this.nXJ.setVisibility(0);
            this.boq.setVisibility(8);
            this.nXO.setVisibility(0);
            return;
        }
        this.nXJ.setVisibility(8);
        this.boq.setVisibility(0);
        this.nXO.setVisibility(0);
        this.boq.reset();
        this.boq.setTitle(a.i.yuyin_ala_connection_wheat_empty_text);
        this.boq.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
        this.boq.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_color_525252));
    }

    public void dWS() {
        this.nXJ.setVisibility(8);
        this.boq.setVisibility(0);
        this.nXO.setVisibility(8);
        this.boq.reset();
        this.boq.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_color_525252));
        this.boq.setRefreshButton(a.i.yuyin_ala_connection_wheat_refresh_load_text, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.zb(true);
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.boq.setTitle(a.i.yuyin_ala_connection_wheat_data_load_fail_text);
            this.boq.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.boq.setTitle(a.i.yuyin_ala_connection_wheat_net_load_fail_text);
            this.boq.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.boq.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.d.sdk_color_525252));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(List<com.baidu.live.data.e> list, int i, int i2) {
        this.nXE = false;
        if (i > 0) {
            if (i2 > 0) {
                this.nXE = true;
                this.nXN.setText(this.bIs.getString(a.i.yuyin_ala_connection_wheat_cancel_text));
                this.nXM.setText(String.format(this.bIs.getString(a.i.yuyin_ala_connection_wheat_apply_current_rank_text), Integer.valueOf(i2)));
            } else {
                this.nXN.setText(this.bIs.getString(a.i.yuyin_ala_connection_wheat_request_text));
                this.nXM.setText(String.format(this.bIs.getString(a.i.yuyin_ala_connection_wheat_apply_current_person_wait_text), Integer.valueOf(i)));
            }
        } else {
            this.nXN.setText(this.bIs.getString(a.i.yuyin_ala_connection_wheat_request_text));
            this.nXM.setText(String.format(this.bIs.getString(a.i.yuyin_ala_connection_wheat_apply_current_person_wait_text), Integer.valueOf(i)));
        }
        this.nXK.setData(list);
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
        return LayoutInflater.from(this.bIs).inflate(a.h.yuyin_layout_dialog_connnection_wheat_apply, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean QG() {
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean QH() {
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
        dWT();
        MessageManager.getInstance().registerListener(this.nWA);
        MessageManager.getInstance().registerListener(this.aUa);
        MessageManager.getInstance().registerListener(this.nXQ);
        MessageManager.getInstance().registerListener(this.bcQ);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.nXN) {
            if (!this.nXE) {
                zc(true);
                com.baidu.tieba.yuyinala.liveroom.wheat.b.c.dWj().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.5
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.c.a
                    public void cYn() {
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.b.c.a
                    public void dWk() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX().dVO();
                        n.dWB().yW(true);
                        d.this.zb(false);
                        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_apply_success_text)).show();
                    }
                }).a(this.nVE.getPageActivity(), this.nVE.getPageActivity(), "2");
                return;
            }
            zc(false);
            if (this.nWI == null) {
                this.nWI = new g(this.nVE);
                this.nWI.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.6
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                        d.this.nWI.dismiss();
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        d.this.dWt();
                        d.this.nWI.dismiss();
                    }
                });
            }
            this.nWI.show();
            this.nWI.setText(TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_cancel_apply_text));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2, String str3, int i, String str4) {
        w UO = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().UO();
        if (UO != null && UO.aIA != null && UO.mLiveInfo != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.nVE.getPageActivity(), ExtraParamsManager.getDecryptUserId(str), str2, str3, i, 0, null, null, 0L, 0L, 0L, 0, Long.toString(UO.mLiveInfo.group_id), Long.toString(UO.mLiveInfo.live_id), false, null, null, str4, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWt() {
        if (this.nWP == null) {
            this.nWP = new com.baidu.tieba.yuyinala.liveroom.wheat.c.d(this.nVE, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.7
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dVX().dVP();
                        d.this.b(alaCancelApplyOrCancelInviteHttpResponseMessage);
                        n.dWB().yW(false);
                        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_cancel_success_text)).show();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.d.a
                public void onFail(int i, String str) {
                }
            });
        }
        this.nWP.gN(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().dWa(), "1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
        if (alaCancelApplyOrCancelInviteHttpResponseMessage != null && alaCancelApplyOrCancelInviteHttpResponseMessage.getErrno() == 0) {
            zb(false);
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.nWP != null) {
            this.nWP.onDestroy();
            this.nWP = null;
        }
        if (this.nXL != null) {
            this.nXL.onDestroy();
            this.nXL = null;
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.b.c.dWj().onDestroy();
        hideLoading();
        MessageManager.getInstance().unRegisterListener(this.nWA);
        MessageManager.getInstance().unRegisterListener(this.aUa);
        MessageManager.getInstance().unRegisterListener(this.nXQ);
        MessageManager.getInstance().unRegisterListener(this.bcQ);
    }

    public void showLoading() {
        if (this.nXP != null) {
            this.nXP.setVisibility(0);
        }
    }

    public void hideLoading() {
        if (this.nXP != null) {
            this.nXP.setVisibility(8);
        }
    }

    private void dWT() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            w UO = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().UO();
            if (UO != null && UO.aIS != null) {
                jSONObject.put("live_id", UO.aIS.live_id);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, UO.aIS.croom_id);
            }
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "miclink");
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "miclinktab_show").setContentExt(jSONObject));
    }

    private void zc(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            w UO = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dVV().UO();
            if (UO != null && UO.aIS != null) {
                jSONObject.put("live_id", UO.aIS.live_id);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, UO.aIS.croom_id);
            }
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "miclink");
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, z ? AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY : "cancel");
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "micapplybtn_clk").setContentExt(jSONObject));
    }
}
