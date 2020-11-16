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
    private CustomMessageListener aTH;
    public CustomMessageListener bcy;
    private CommonEmptyView bnY;
    private CustomMessageListener oeQ;
    private g ofL;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.d ofS;
    private AlaConnectionWheatListView ogE;
    private com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a ogF;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.b ogG;
    private TextView ogH;
    private TextView ogI;
    private LinearLayout ogJ;
    private RelativeLayout ogK;
    private int ogL;
    private CustomMessageListener ogM;
    private boolean ogz;

    public d(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.aTH = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913054) {
                    d.this.dismiss();
                }
            }
        };
        this.oeQ = new CustomMessageListener(2501036) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501036) {
                    d.this.dismiss();
                }
            }
        };
        this.ogM = new CustomMessageListener(2501012) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501012) {
                    d.this.zq(false);
                }
            }
        };
        this.bcy = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    d.this.dismiss();
                }
            }
        };
        MZ(80);
        zo(true);
        zp(true);
        g(this);
        this.ogL = i;
    }

    protected void initView() {
        this.ogE = (AlaConnectionWheatListView) findViewById(a.f.listView);
        this.ogH = (TextView) findViewById(a.f.tv_current_rank);
        this.ogI = (TextView) findViewById(a.f.tv_apply_btn);
        this.ogJ = (LinearLayout) findViewById(a.f.ll_apply_btn);
        this.ogK = (RelativeLayout) findViewById(a.f.loading_view_container);
        this.bnY = (CommonEmptyView) findViewById(a.f.empty_view_2);
        this.ogF = new com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a(this.bMo);
        this.ogE.setAdapter((ListAdapter) this.ogF);
        this.ogI.setOnClickListener(this);
        this.ogI.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        showLoading();
        this.ogF.a(new a.InterfaceC0922a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.InterfaceC0922a
            public void a(com.baidu.live.data.e eVar) {
                d.this.dismiss();
                d.this.c(eVar.uk, eVar.mUserName, eVar.mPortrait, eVar.mSex, eVar.mUserName);
            }
        });
    }

    public void zq(boolean z) {
        if (z) {
            showLoading();
        }
        if (this.ogG == null) {
            this.ogG = new com.baidu.tieba.yuyinala.liveroom.wheat.model.b(this.oey, new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.b.a
                public void a(AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage) {
                    d.this.i(alaGetApplyWheatListHttpResponseMessage.eak(), alaGetApplyWheatListHttpResponseMessage.getCount(), alaGetApplyWheatListHttpResponseMessage.getPosition());
                    d.this.hideLoading();
                    d.this.dZP();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.b.a
                public void onFail(int i, String str) {
                    d.this.dZQ();
                    d.this.hideLoading();
                }
            });
        }
        this.ogG.request();
    }

    public void dZA() {
        zq(true);
    }

    public void dZP() {
        if (this.ogF != null && this.ogF.getCount() != 0) {
            this.ogE.setVisibility(0);
            this.bnY.setVisibility(8);
            this.ogJ.setVisibility(0);
            return;
        }
        this.ogE.setVisibility(8);
        this.bnY.setVisibility(0);
        this.ogJ.setVisibility(0);
        this.bnY.reset();
        this.bnY.setTitle(a.h.yuyin_ala_connection_wheat_empty_text);
        this.bnY.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
        this.bnY.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_525252));
    }

    public void dZQ() {
        this.ogE.setVisibility(8);
        this.bnY.setVisibility(0);
        this.ogJ.setVisibility(8);
        this.bnY.reset();
        this.bnY.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_525252));
        this.bnY.setRefreshButton(a.h.yuyin_ala_connection_wheat_refresh_load_text, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.zq(true);
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bnY.setTitle(a.h.yuyin_ala_connection_wheat_data_load_fail_text);
            this.bnY.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.bnY.setTitle(a.h.yuyin_ala_connection_wheat_net_load_fail_text);
            this.bnY.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.bnY.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_525252));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(List<com.baidu.live.data.e> list, int i, int i2) {
        this.ogz = false;
        if (i > 0) {
            if (i2 > 0) {
                this.ogz = true;
                this.ogI.setText(this.bMo.getString(a.h.yuyin_ala_connection_wheat_cancel_text));
                this.ogH.setText(String.format(this.bMo.getString(a.h.yuyin_ala_connection_wheat_apply_current_rank_text), Integer.valueOf(i2)));
            } else {
                this.ogI.setText(this.bMo.getString(a.h.yuyin_ala_connection_wheat_request_text));
                this.ogH.setText(String.format(this.bMo.getString(a.h.yuyin_ala_connection_wheat_apply_current_person_wait_text), Integer.valueOf(i)));
            }
        } else {
            this.ogI.setText(this.bMo.getString(a.h.yuyin_ala_connection_wheat_request_text));
            this.ogH.setText(String.format(this.bMo.getString(a.h.yuyin_ala_connection_wheat_apply_current_person_wait_text), Integer.valueOf(i)));
        }
        this.ogF.setData(list);
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
        return LayoutInflater.from(this.bMo).inflate(a.g.yuyin_layout_dialog_connnection_wheat_apply, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean Ra() {
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean Rb() {
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
        dZR();
        MessageManager.getInstance().registerListener(this.oeQ);
        MessageManager.getInstance().registerListener(this.aTH);
        MessageManager.getInstance().registerListener(this.ogM);
        MessageManager.getInstance().registerListener(this.bcy);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ogI) {
            if (!this.ogz) {
                zr(true);
                com.baidu.tieba.yuyinala.liveroom.wheat.c.c.dZh().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.5
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                    public void dal() {
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                    public void dZc() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM().dYD();
                        o.dZz().zk(true);
                        d.this.zq(false);
                        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_apply_success_text)).show();
                    }
                }).a(this.oey.getPageActivity(), this.oey.getPageActivity(), "2", String.valueOf(this.ogL));
                return;
            }
            zr(false);
            if (this.ofL == null) {
                this.ofL = new g(this.oey);
                this.ofL.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.6
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                        d.this.ofL.dismiss();
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        d.this.dZr();
                        d.this.ofL.dismiss();
                    }
                });
            }
            this.ofL.show();
            this.ofL.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_cancel_apply_text));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2, String str3, int i, String str4) {
        w WE = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().WE();
        if (WE != null && WE.aHG != null && WE.mLiveInfo != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.oey.getPageActivity(), ExtraParamsManager.getDecryptUserId(str), str2, str3, i, 0, null, null, 0L, 0L, 0L, 0, Long.toString(WE.mLiveInfo.group_id), Long.toString(WE.mLiveInfo.live_id), false, null, null, str4, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZr() {
        if (this.ofS == null) {
            this.ofS = new com.baidu.tieba.yuyinala.liveroom.wheat.model.d(this.oey, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.7
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().dYM().dYE();
                        d.this.b(alaCancelApplyOrCancelInviteHttpResponseMessage);
                        o.dZz().zk(false);
                        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_cancel_success_text)).show();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                public void onFail(int i, String str) {
                }
            });
        }
        this.ofS.gP(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().Br(), "1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
        if (alaCancelApplyOrCancelInviteHttpResponseMessage != null && alaCancelApplyOrCancelInviteHttpResponseMessage.getErrno() == 0) {
            zq(false);
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.ofS != null) {
            this.ofS.onDestroy();
            this.ofS = null;
        }
        if (this.ogG != null) {
            this.ogG.onDestroy();
            this.ogG = null;
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.dZh().onDestroy();
        hideLoading();
        MessageManager.getInstance().unRegisterListener(this.oeQ);
        MessageManager.getInstance().unRegisterListener(this.aTH);
        MessageManager.getInstance().unRegisterListener(this.ogM);
        MessageManager.getInstance().unRegisterListener(this.bcy);
    }

    public void showLoading() {
        if (this.ogK != null) {
            this.ogK.setVisibility(0);
        }
    }

    public void hideLoading() {
        if (this.ogK != null) {
            this.ogK.setVisibility(8);
        }
    }

    private void dZR() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            w WE = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().WE();
            if (WE != null && WE.aHZ != null) {
                jSONObject.put("live_id", WE.aHZ.live_id);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, WE.aHZ.croom_id);
            }
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "miclink");
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "miclinktab_show").setContentExt(jSONObject));
    }

    private void zr(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            w WE = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYK().WE();
            if (WE != null && WE.aHZ != null) {
                jSONObject.put("live_id", WE.aHZ.live_id);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, WE.aHZ.croom_id);
            }
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "miclink");
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, z ? AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY : "cancel");
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "micapplybtn_clk").setContentExt(jSONObject));
    }
}
