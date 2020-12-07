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
    private CustomMessageListener otQ;
    private g ouL;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.d ouS;
    private AlaConnectionWheatListView ovE;
    private com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a ovF;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.b ovG;
    private TextView ovH;
    private TextView ovI;
    private LinearLayout ovJ;
    private RelativeLayout ovK;
    private int ovL;
    private CustomMessageListener ovM;
    private boolean ovz;

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
        this.otQ = new CustomMessageListener(2501036) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501036) {
                    d.this.dismiss();
                }
            }
        };
        this.ovM = new CustomMessageListener(2501012) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.10
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
        this.ovL = i;
    }

    protected void initView() {
        this.ovE = (AlaConnectionWheatListView) findViewById(a.f.listView);
        this.ovH = (TextView) findViewById(a.f.tv_current_rank);
        this.ovI = (TextView) findViewById(a.f.tv_apply_btn);
        this.ovJ = (LinearLayout) findViewById(a.f.ll_apply_btn);
        this.ovK = (RelativeLayout) findViewById(a.f.loading_view_container);
        this.btg = (CommonEmptyView) findViewById(a.f.empty_view_2);
        this.ovF = new com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a(this.beD);
        this.ovE.setAdapter((ListAdapter) this.ovF);
        this.ovI.setOnClickListener(this);
        this.ovI.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        showLoading();
        this.ovF.a(new a.InterfaceC0939a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.1
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
        if (this.ovG == null) {
            this.ovG = new com.baidu.tieba.yuyinala.liveroom.wheat.model.b(this.oty, new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.b.a
                public void a(AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage) {
                    d.this.i(alaGetApplyWheatListHttpResponseMessage.efP(), alaGetApplyWheatListHttpResponseMessage.getCount(), alaGetApplyWheatListHttpResponseMessage.getPosition());
                    d.this.hideLoading();
                    d.this.efu();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.b.a
                public void onFail(int i, String str) {
                    d.this.efv();
                    d.this.hideLoading();
                }
            });
        }
        this.ovG.request();
    }

    public void efe() {
        zU(true);
    }

    public void efu() {
        if (this.ovF != null && this.ovF.getCount() != 0) {
            this.ovE.setVisibility(0);
            this.btg.setVisibility(8);
            this.ovJ.setVisibility(0);
            return;
        }
        this.ovE.setVisibility(8);
        this.btg.setVisibility(0);
        this.ovJ.setVisibility(0);
        this.btg.reset();
        this.btg.setTitle(a.h.yuyin_ala_connection_wheat_empty_text);
        this.btg.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
        this.btg.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_525252));
    }

    public void efv() {
        this.ovE.setVisibility(8);
        this.btg.setVisibility(0);
        this.ovJ.setVisibility(8);
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
        this.ovz = false;
        if (i > 0) {
            if (i2 > 0) {
                this.ovz = true;
                this.ovI.setText(this.beD.getString(a.h.yuyin_ala_connection_wheat_cancel_text));
                this.ovH.setText(String.format(this.beD.getString(a.h.yuyin_ala_connection_wheat_apply_current_rank_text), Integer.valueOf(i2)));
            } else {
                this.ovI.setText(this.beD.getString(a.h.yuyin_ala_connection_wheat_request_text));
                this.ovH.setText(String.format(this.beD.getString(a.h.yuyin_ala_connection_wheat_apply_current_person_wait_text), Integer.valueOf(i)));
            }
        } else {
            this.ovI.setText(this.beD.getString(a.h.yuyin_ala_connection_wheat_request_text));
            this.ovH.setText(String.format(this.beD.getString(a.h.yuyin_ala_connection_wheat_apply_current_person_wait_text), Integer.valueOf(i)));
        }
        this.ovF.setData(list);
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
        efw();
        MessageManager.getInstance().registerListener(this.otQ);
        MessageManager.getInstance().registerListener(this.aWL);
        MessageManager.getInstance().registerListener(this.ovM);
        MessageManager.getInstance().registerListener(this.bgy);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ovI) {
            if (!this.ovz) {
                zV(true);
                com.baidu.tieba.yuyinala.liveroom.wheat.c.c.eeL().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.5
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                    public void dfx() {
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                    public void eeG() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().eeh();
                        o.efd().zO(true);
                        d.this.zU(false);
                        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_apply_success_text)).show();
                    }
                }).a(this.oty.getPageActivity(), this.oty.getPageActivity(), "2", String.valueOf(this.ovL));
                return;
            }
            zV(false);
            if (this.ouL == null) {
                this.ouL = new g(this.oty);
                this.ouL.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.6
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                        d.this.ouL.dismiss();
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        d.this.eeV();
                        d.this.ouL.dismiss();
                    }
                });
            }
            this.ouL.show();
            this.ouL.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_cancel_apply_text));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2, String str3, int i, String str4) {
        w Zd = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().Zd();
        if (Zd != null && Zd.aKr != null && Zd.mLiveInfo != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.oty.getPageActivity(), ExtraParamsManager.getDecryptUserId(str), str2, str3, i, 0, null, null, 0L, 0L, 0L, 0, Long.toString(Zd.mLiveInfo.group_id), Long.toString(Zd.mLiveInfo.live_id), false, null, null, str4, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eeV() {
        if (this.ouS == null) {
            this.ouS = new com.baidu.tieba.yuyinala.liveroom.wheat.model.d(this.oty, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.7
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().eeq().eei();
                        d.this.b(alaCancelApplyOrCancelInviteHttpResponseMessage);
                        o.efd().zO(false);
                        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_cancel_success_text)).show();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                public void onFail(int i, String str) {
                }
            });
        }
        this.ouS.gU(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().CZ(), "1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
        if (alaCancelApplyOrCancelInviteHttpResponseMessage != null && alaCancelApplyOrCancelInviteHttpResponseMessage.getErrno() == 0) {
            zU(false);
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.ouS != null) {
            this.ouS.onDestroy();
            this.ouS = null;
        }
        if (this.ovG != null) {
            this.ovG.onDestroy();
            this.ovG = null;
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.eeL().onDestroy();
        hideLoading();
        MessageManager.getInstance().unRegisterListener(this.otQ);
        MessageManager.getInstance().unRegisterListener(this.aWL);
        MessageManager.getInstance().unRegisterListener(this.ovM);
        MessageManager.getInstance().unRegisterListener(this.bgy);
    }

    public void showLoading() {
        if (this.ovK != null) {
            this.ovK.setVisibility(0);
        }
    }

    public void hideLoading() {
        if (this.ovK != null) {
            this.ovK.setVisibility(8);
        }
    }

    private void efw() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            w Zd = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().Zd();
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
            w Zd = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.eeo().Zd();
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
