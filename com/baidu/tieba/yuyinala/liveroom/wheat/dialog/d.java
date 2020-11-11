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
    private CustomMessageListener aVs;
    public CustomMessageListener bek;
    private CommonEmptyView bpJ;
    private CustomMessageListener odn;
    private boolean oeV;
    private g oeh;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.d oeo;
    private AlaConnectionWheatListView ofa;
    private com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a ofb;
    private com.baidu.tieba.yuyinala.liveroom.wheat.model.b ofc;
    private TextView ofd;
    private TextView ofe;
    private LinearLayout ofg;
    private RelativeLayout ofh;
    private int ofi;
    private CustomMessageListener ofj;

    public d(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        this.aVs = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913054) {
                    d.this.dismiss();
                }
            }
        };
        this.odn = new CustomMessageListener(2501036) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501036) {
                    d.this.dismiss();
                }
            }
        };
        this.ofj = new CustomMessageListener(2501012) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501012) {
                    d.this.zj(false);
                }
            }
        };
        this.bek = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (d.this.isShowing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                    d.this.dismiss();
                }
            }
        };
        Mw(80);
        zh(true);
        zi(true);
        g(this);
        this.ofi = i;
    }

    protected void initView() {
        this.ofa = (AlaConnectionWheatListView) findViewById(a.f.listView);
        this.ofd = (TextView) findViewById(a.f.tv_current_rank);
        this.ofe = (TextView) findViewById(a.f.tv_apply_btn);
        this.ofg = (LinearLayout) findViewById(a.f.ll_apply_btn);
        this.ofh = (RelativeLayout) findViewById(a.f.loading_view_container);
        this.bpJ = (CommonEmptyView) findViewById(a.f.empty_view_2);
        this.ofb = new com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a(this.bNY);
        this.ofa.setAdapter((ListAdapter) this.ofb);
        this.ofe.setOnClickListener(this);
        this.ofe.setOnTouchListener(new com.baidu.tieba.yuyinala.liveroom.wheat.view.a());
        showLoading();
        this.ofb.a(new a.InterfaceC0919a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.adapter.a.InterfaceC0919a
            public void a(com.baidu.live.data.e eVar) {
                d.this.dismiss();
                d.this.c(eVar.uk, eVar.mUserName, eVar.mPortrait, eVar.mSex, eVar.mUserName);
            }
        });
    }

    public void zj(boolean z) {
        if (z) {
            showLoading();
        }
        if (this.ofc == null) {
            this.ofc = new com.baidu.tieba.yuyinala.liveroom.wheat.model.b(this.ocV, new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.3
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.b.a
                public void a(AlaGetApplyWheatListHttpResponseMessage alaGetApplyWheatListHttpResponseMessage) {
                    d.this.i(alaGetApplyWheatListHttpResponseMessage.eal(), alaGetApplyWheatListHttpResponseMessage.getCount(), alaGetApplyWheatListHttpResponseMessage.getPosition());
                    d.this.hideLoading();
                    d.this.dZQ();
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.b.a
                public void onFail(int i, String str) {
                    d.this.dZR();
                    d.this.hideLoading();
                }
            });
        }
        this.ofc.request();
    }

    public void dZB() {
        zj(true);
    }

    public void dZQ() {
        if (this.ofb != null && this.ofb.getCount() != 0) {
            this.ofa.setVisibility(0);
            this.bpJ.setVisibility(8);
            this.ofg.setVisibility(0);
            return;
        }
        this.ofa.setVisibility(8);
        this.bpJ.setVisibility(0);
        this.ofg.setVisibility(0);
        this.bpJ.reset();
        this.bpJ.setTitle(a.h.yuyin_ala_connection_wheat_empty_text);
        this.bpJ.setup(CommonEmptyView.ImgType.NO_DATA, CommonEmptyView.StyleType.DARK);
        this.bpJ.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_525252));
    }

    public void dZR() {
        this.ofa.setVisibility(8);
        this.bpJ.setVisibility(0);
        this.ofg.setVisibility(8);
        this.bpJ.reset();
        this.bpJ.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_525252));
        this.bpJ.setRefreshButton(a.h.yuyin_ala_connection_wheat_refresh_load_text, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.zj(true);
            }
        });
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            this.bpJ.setTitle(a.h.yuyin_ala_connection_wheat_data_load_fail_text);
            this.bpJ.setup(CommonEmptyView.ImgType.SERVER_ERROR, CommonEmptyView.StyleType.DARK);
        } else {
            this.bpJ.setTitle(a.h.yuyin_ala_connection_wheat_net_load_fail_text);
            this.bpJ.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        }
        this.bpJ.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(a.c.sdk_color_525252));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(List<com.baidu.live.data.e> list, int i, int i2) {
        this.oeV = false;
        if (i > 0) {
            if (i2 > 0) {
                this.oeV = true;
                this.ofe.setText(this.bNY.getString(a.h.yuyin_ala_connection_wheat_cancel_text));
                this.ofd.setText(String.format(this.bNY.getString(a.h.yuyin_ala_connection_wheat_apply_current_rank_text), Integer.valueOf(i2)));
            } else {
                this.ofe.setText(this.bNY.getString(a.h.yuyin_ala_connection_wheat_request_text));
                this.ofd.setText(String.format(this.bNY.getString(a.h.yuyin_ala_connection_wheat_apply_current_person_wait_text), Integer.valueOf(i)));
            }
        } else {
            this.ofe.setText(this.bNY.getString(a.h.yuyin_ala_connection_wheat_request_text));
            this.ofd.setText(String.format(this.bNY.getString(a.h.yuyin_ala_connection_wheat_apply_current_person_wait_text), Integer.valueOf(i)));
        }
        this.ofb.setData(list);
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
        return LayoutInflater.from(this.bNY).inflate(a.g.yuyin_layout_dialog_connnection_wheat_apply, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean RJ() {
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected boolean RK() {
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
        dZS();
        MessageManager.getInstance().registerListener(this.odn);
        MessageManager.getInstance().registerListener(this.aVs);
        MessageManager.getInstance().registerListener(this.ofj);
        MessageManager.getInstance().registerListener(this.bek);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.a
    protected void initData() {
        initView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ofe) {
            if (!this.oeV) {
                zk(true);
                com.baidu.tieba.yuyinala.liveroom.wheat.c.c.dZi().a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.5
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                    public void daO() {
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.c.c.a
                    public void dZd() {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN().dYE();
                        o.dZA().zd(true);
                        d.this.zj(false);
                        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_apply_success_text)).show();
                    }
                }).a(this.ocV.getPageActivity(), this.ocV.getPageActivity(), "2", String.valueOf(this.ofi));
                return;
            }
            zk(false);
            if (this.oeh == null) {
                this.oeh = new g(this.ocV);
                this.oeh.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.6
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                        d.this.oeh.dismiss();
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        d.this.dZs();
                        d.this.oeh.dismiss();
                    }
                });
            }
            this.oeh.show();
            this.oeh.setText(TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_cancel_apply_text));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2, String str3, int i, String str4) {
        w Xn = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().Xn();
        if (Xn != null && Xn.aJr != null && Xn.mLiveInfo != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.ocV.getPageActivity(), ExtraParamsManager.getDecryptUserId(str), str2, str3, i, 0, null, null, 0L, 0L, 0L, 0, Long.toString(Xn.mLiveInfo.group_id), Long.toString(Xn.mLiveInfo.live_id), false, null, null, str4, "")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZs() {
        if (this.oeo == null) {
            this.oeo = new com.baidu.tieba.yuyinala.liveroom.wheat.model.d(this.ocV, new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.dialog.d.7
                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                public void a(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
                    if (!alaCancelApplyOrCancelInviteHttpResponseMessage.isError()) {
                        com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().dYN().dYF();
                        d.this.b(alaCancelApplyOrCancelInviteHttpResponseMessage);
                        o.dZA().zd(false);
                        BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_cancel_success_text)).show();
                    }
                }

                @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.d.a
                public void onFail(int i, String str) {
                }
            });
        }
        this.oeo.gP(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().Ca(), "1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AlaCancelApplyOrCancelInviteHttpResponseMessage alaCancelApplyOrCancelInviteHttpResponseMessage) {
        if (alaCancelApplyOrCancelInviteHttpResponseMessage != null && alaCancelApplyOrCancelInviteHttpResponseMessage.getErrno() == 0) {
            zj(false);
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.oeo != null) {
            this.oeo.onDestroy();
            this.oeo = null;
        }
        if (this.ofc != null) {
            this.ofc.onDestroy();
            this.ofc = null;
        }
        com.baidu.tieba.yuyinala.liveroom.wheat.c.c.dZi().onDestroy();
        hideLoading();
        MessageManager.getInstance().unRegisterListener(this.odn);
        MessageManager.getInstance().unRegisterListener(this.aVs);
        MessageManager.getInstance().unRegisterListener(this.ofj);
        MessageManager.getInstance().unRegisterListener(this.bek);
    }

    public void showLoading() {
        if (this.ofh != null) {
            this.ofh.setVisibility(0);
        }
    }

    public void hideLoading() {
        if (this.ofh != null) {
            this.ofh.setVisibility(8);
        }
    }

    private void dZS() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            w Xn = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().Xn();
            if (Xn != null && Xn.aJK != null) {
                jSONObject.put("live_id", Xn.aJK.live_id);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Xn.aJK.croom_id);
            }
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "miclink");
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "miclinktab_show").setContentExt(jSONObject));
    }

    private void zk(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            w Xn = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.dYL().Xn();
            if (Xn != null && Xn.aJK != null) {
                jSONObject.put("live_id", Xn.aJK.live_id);
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, Xn.aJK.croom_id);
            }
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "miclink");
            jSONObject.put(ZeusPerformanceTiming.KEY_BROWSER_STARTUP, z ? AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_APPLY : "cancel");
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "micapplybtn_clk").setContentExt(jSONObject));
    }
}
