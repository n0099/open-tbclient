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
import com.baidu.tieba.yuyinala.liveroom.wheat.c.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaCancelApplyOrCancelInviteHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AlaGetApplyWheatListHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.b;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.d;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.AlaConnectionWheatListView;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends a implements DialogInterface.OnDismissListener, View.OnClickListener {
    private CustomMessageListener aWL;
    public CustomMessageListener bgy;
    private CommonEmptyView btg;
    private CustomMessageListener otS;
    private g ouN;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.d ouU;
    private boolean ovB;
    private AlaConnectionWheatListView ovG;
    private com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a ovH;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.b ovI;
    private TextView ovJ;
    private TextView ovK;
    private LinearLayout ovL;
    private RelativeLayout ovM;
    private int ovN;
    private CustomMessageListener ovO;

    public d(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.aWL = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913054) {
                    d.this.dismiss();
                }
            }
        };
        this.otS = new CustomMessageListener(2501036) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501036) {
                    d.this.dismiss();
                }
            }
        };
        this.ovO = new CustomMessageListener(2501012) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501012) {
                    d.this.zU(false);
                }
            }
        };
        this.bgy = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    d.this.dismiss();
                }
            }
        };
        NR(80);
        zS(true);
        zT(true);
        g(this);
        this.ovN = i;
    }

    protected void initView() {
        this.ovG = (AlaConnectionWheatListView) findViewById(a.f.listView);
        this.ovJ = (TextView) findViewById(a.f.tv_current_rank);
        this.ovK = (TextView) findViewById(a.f.tv_apply_btn);
        this.ovL = (LinearLayout) findViewById(a.f.ll_apply_btn);
        this.ovM = (RelativeLayout) findViewById(a.f.loading_view_container);
        this.btg = (CommonEmptyView) findViewById(a.f.empty_view_2);
        this.ovH = new com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a(this.beD);
        this.ovG.setAdapter((ListAdapter) this.ovH);
        this.ovK.setOnClickListener(this);
        this.ovK.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        showLoading();
        this.ovH.a(new a.InterfaceC0939a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.InterfaceC0939a
            public void a(com.baidu.live.data.e eVar) {
                d.this.dismiss();
                d.this.d(eVar.uk, eVar.mUserName, eVar.mPortrait, eVar.mSex, eVar.mUserName);
            }
        });
    }

    public void zU(boolean z) {
        if (z) {
            showLoading();
        }
        if (this.ovI == null) {
            this.ovI = new com.baidu.tieba.yuyinala.liveroom.wheat.model.b(this.otA, new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.b.a
                public void a(AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage) {
                    d.this.i(alaGetApplyWheatListHttpResponseMessage.efQ(), alaGetApplyWheatListHttpResponseMessage.getCount(), alaGetApplyWheatListHttpResponseMessage.getPosition());
                    d.this.hideLoading();
                    d.this.efv();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.b.a
                public void onFail(int i, String str) {
                    d.this.efw();
                    d.this.hideLoading();
                }
            });
        }
        this.ovI.request();
    }

    public void eff() {
        zU(true);
    }

    public void efv() {
        if (this.ovH != null && this.ovH.getCount() != 0) {
            this.ovG.setVisibility(0);
            this.btg.setVisibility(8);
            this.ovL.setVisibility(0);
            return;
        }
        this.ovG.setVisibility(8);
        this.btg.setVisibility(0);
        this.ovL.setVisibility(0);
        this.btg.reset();
        this.btg.setTitle(a.h.yuyin_ala_connection_wheat_empty_text);
        this.btg.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
        this.btg.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_525252));
    }

    public void efw() {
        this.ovG.setVisibility(8);
        this.btg.setVisibility(0);
        this.ovL.setVisibility(8);
        this.btg.reset();
        this.btg.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_525252));
        this.btg.setRefreshButton(a.h.yuyin_ala_connection_wheat_refresh_load_text, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.zU(true);
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.btg.setTitle(a.h.yuyin_ala_connection_wheat_data_load_fail_text);
            this.btg.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.btg.setTitle(a.h.yuyin_ala_connection_wheat_net_load_fail_text);
            this.btg.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.btg.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_525252));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(List<com.baidu.live.data.e> list, int i, int i2) {
        this.ovB = false;
        if (i > 0) {
            if (i2 > 0) {
                this.ovB = true;
                this.ovK.setText(this.beD.getString(a.h.yuyin_ala_connection_wheat_cancel_text));
                this.ovJ.setText(String.format(this.beD.getString(a.h.yuyin_ala_connection_wheat_apply_current_rank_text), Integer.valueOf(i2)));
            } else {
                this.ovK.setText(this.beD.getString(a.h.yuyin_ala_connection_wheat_request_text));
                this.ovJ.setText(String.format(this.beD.getString(a.h.yuyin_ala_connection_wheat_apply_current_person_wait_text), Integer.valueOf(i)));
            }
        } else {
            this.ovK.setText(this.beD.getString(a.h.yuyin_ala_connection_wheat_request_text));
            this.ovJ.setText(String.format(this.beD.getString(a.h.yuyin_ala_connection_wheat_apply_current_person_wait_text), Integer.valueOf(i)));
        }
        this.ovH.setData(list);
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
        return LayoutInflater.from(this.beD).inflate(a.g.yuyin_layout_dialog_connnection_wheat_apply, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean Ty() {
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean Tz() {
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
        efx();
        MessageManager.getInstance().registerListener(this.otS);
        MessageManager.getInstance().registerListener(this.aWL);
        MessageManager.getInstance().registerListener(this.ovO);
        MessageManager.getInstance().registerListener(this.bgy);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ovK) {
            if (!this.ovB) {
                zV(true);
                com.baidu.tieba.yuyinala.liveroom.wheat.c.c.eeM().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.5
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                    public void dfy() {
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                    public void eeH() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().eei();
                        o.efe().zO(true);
                        d.this.zU(false);
                        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_apply_success_text)).show();
                    }
                }).a(this.otA.getPageActivity(), this.otA.getPageActivity(), "2", String.valueOf(this.ovN));
                return;
            }
            zV(false);
            if (this.ouN == null) {
                this.ouN = new g(this.otA);
                this.ouN.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.6
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                        d.this.ouN.dismiss();
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        d.this.eeW();
                        d.this.ouN.dismiss();
                    }
                });
            }
            this.ouN.show();
            this.ouN.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_cancel_apply_text));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2, String str3, int i, String str4) {
        w Zd = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().Zd();
        if (Zd != null && Zd.aKr != null && Zd.mLiveInfo != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.otA.getPageActivity(), ExtraParamsManager.getDecryptUserId(str), str2, str3, i, 0, null, null, 0L, 0L, 0L, 0, Long.toString(Zd.mLiveInfo.group_id), Long.toString(Zd.mLiveInfo.live_id), false, null, null, str4, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eeW() {
        if (this.ouU == null) {
            this.ouU = new com.baidu.tieba.yuyinala.liveroom.wheat.model.d(this.otA, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.7
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().eer().eej();
                        d.this.b(alaCancelApplyOrCancelInviteHttpResponseMessage);
                        o.efe().zO(false);
                        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_cancel_success_text)).show();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                public void onFail(int i, String str) {
                }
            });
        }
        this.ouU.gU(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().CZ(), "1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
        if (alaCancelApplyOrCancelInviteHttpResponseMessage != null && alaCancelApplyOrCancelInviteHttpResponseMessage.getErrno() == 0) {
            zU(false);
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.ouU != null) {
            this.ouU.onDestroy();
            this.ouU = null;
        }
        if (this.ovI != null) {
            this.ovI.onDestroy();
            this.ovI = null;
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.eeM().onDestroy();
        hideLoading();
        MessageManager.getInstance().unRegisterListener(this.otS);
        MessageManager.getInstance().unRegisterListener(this.aWL);
        MessageManager.getInstance().unRegisterListener(this.ovO);
        MessageManager.getInstance().unRegisterListener(this.bgy);
    }

    public void showLoading() {
        if (this.ovM != null) {
            this.ovM.setVisibility(0);
        }
    }

    public void hideLoading() {
        if (this.ovM != null) {
            this.ovM.setVisibility(8);
        }
    }

    private void efx() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            w Zd = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().Zd();
            if (Zd != null && Zd.aKL != null) {
                jSONObject.put("live_id", Zd.aKL.live_id);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Zd.aKL.croom_id);
            }
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "miclink");
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "miclinktab_show").setContentExt(jSONObject));
    }

    private void zV(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            w Zd = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eep().Zd();
            if (Zd != null && Zd.aKL != null) {
                jSONObject.put("live_id", Zd.aKL.live_id);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Zd.aKL.croom_id);
            }
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "miclink");
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, z ? AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY : "cancel");
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "micapplybtn_clk").setContentExt(jSONObject));
    }
}
