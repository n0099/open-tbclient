package com.baidu.tieba.yuyinala.liveroom.datingnavigation;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.yuyinala.liveroom.datingnavigation.d;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class DatingNavView extends LinearLayout {
    private x aGe;
    private com.baidu.live.ap.a hfG;
    protected Activity mActivity;
    public CustomMessageListener ooI;
    protected LinearLayout ooV;
    protected TextView ooW;
    protected TextView ooX;
    protected TextView ooY;
    protected TextView ooZ;
    protected TextView opa;
    protected TextView opb;
    protected LinearLayout opc;
    protected TextView opd;
    protected MarqueeView ope;
    private int opf;
    private d opg;
    private d oph;
    private LinearLayout opi;
    private g opj;

    public DatingNavView(Activity activity) {
        super(activity);
        this.opf = 0;
        this.ooI = new CustomMessageListener(2501014) { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501014 && (customResponsedMessage.getData() instanceof com.baidu.live.data.g) && ((com.baidu.live.data.g) customResponsedMessage.getData()).Ex() != 1) {
                    if (DatingNavView.this.opj != null && DatingNavView.this.opj.isShowing()) {
                        DatingNavView.this.opj.dismiss();
                    }
                    if (DatingNavView.this.hfG != null) {
                        DatingNavView.this.hfG.dismiss();
                    }
                }
            }
        };
        G(activity);
    }

    protected void G(Activity activity) {
        ViewGroup.LayoutParams layoutParams;
        LayoutInflater.from(activity).inflate(a.g.yuyin_ala_liveroom_dating_nav_layout, this);
        this.mActivity = activity;
        this.ooV = (LinearLayout) findViewById(a.f.ll_rule);
        this.ooW = (TextView) findViewById(a.f.tv_inter);
        this.opi = (LinearLayout) findViewById(a.f.ll_rule);
        int i = BdUtilHelper.getScreenSize(activity).widthPixels;
        if (this.opi != null && this.opi.getLayoutParams() != null && (layoutParams = this.opi.getLayoutParams()) != null) {
            layoutParams.width = (i - BdUtilHelper.dip2px(activity, 110.0f)) / 4;
        }
        this.ooX = (TextView) findViewById(a.f.tv_choose);
        this.ooY = (TextView) findViewById(a.f.tv_publish);
        this.ooZ = (TextView) findViewById(a.f.tv_confession);
        this.opa = (TextView) findViewById(a.f.tv_end);
        this.opb = (TextView) findViewById(a.f.tv_next);
        this.opc = (LinearLayout) findViewById(a.f.tv_operate);
        this.opd = (TextView) findViewById(a.f.tv_start);
        this.ope = (MarqueeView) findViewById(a.f.tv_progress);
        this.ope.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.ecB();
            }
        });
        this.ooV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.ecB();
            }
        });
        aE(activity);
    }

    private void aE(Activity activity) {
        this.opg = new d(activity);
        this.oph = new d(activity);
        this.opd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.ecE();
            }
        });
        this.opa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.ecD();
            }
        });
        this.opb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (DatingNavView.this.opf) {
                    case 1:
                        DatingNavView.this.bZ(DatingNavView.this.opf, "确认进入 心动选择 环节？");
                        return;
                    case 2:
                        DatingNavView.this.bZ(DatingNavView.this.opf, "确认进入 结果公布 环节？");
                        return;
                    case 3:
                        DatingNavView.this.bZ(DatingNavView.this.opf, "确认进入 祝福时刻 环节？");
                        return;
                    default:
                        return;
                }
            }
        });
        this.opg.a(new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.11
            @Override // com.baidu.tieba.yuyinala.liveroom.datingnavigation.d.a
            public void a(DatingStageHttpResponseMessage datingStageHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501032));
                DatingNavView.this.opd.setEnabled(true);
                DatingNavView.this.opb.setEnabled(true);
                b ecF = datingStageHttpResponseMessage.ecF();
                if (ecF != null) {
                    try {
                        DatingNavView.this.opf = Integer.parseInt(ecF.opn);
                    } catch (Exception e) {
                        DatingNavView.this.opf = 0;
                    }
                    DatingNavView.this.setMasterStageView(DatingNavView.this.opf);
                    switch (DatingNavView.this.opf) {
                        case 1:
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, DatingNavView.this.aGe.aLl.croom_id);
                            } catch (Exception e2) {
                                BdLog.e(e2);
                            }
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "startdating_suc").setContentExt(jSONObject));
                            BdUtilHelper.showToast(DatingNavView.this.getContext(), "约会开始，进入嘉宾互动环节");
                            return;
                        case 2:
                            BdUtilHelper.showToast(DatingNavView.this.getContext(), "进入心动选择环节");
                            return;
                        case 3:
                            BdUtilHelper.showToast(DatingNavView.this.getContext(), "进入结果公布环节");
                            return;
                        case 4:
                            BdUtilHelper.showToast(DatingNavView.this.getContext(), "进入甜蜜告白环节");
                            return;
                        default:
                            return;
                    }
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.datingnavigation.d.a
            public void onFail(int i, String str) {
                if (i == 110003) {
                    DatingNavView.this.opf = 0;
                    DatingNavView.this.setMasterStageView(0);
                } else {
                    BdUtilHelper.showToast(DatingNavView.this.getContext(), "进入下一环节失败，请重试");
                }
                DatingNavView.this.opd.setEnabled(true);
                DatingNavView.this.opb.setEnabled(true);
            }
        });
        this.oph.a(new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.12
            @Override // com.baidu.tieba.yuyinala.liveroom.datingnavigation.d.a
            public void a(DatingStageHttpResponseMessage datingStageHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501032));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, DatingNavView.this.aGe.aLl.croom_id);
                    String str = "";
                    switch (DatingNavView.this.opf) {
                        case 1:
                            str = "interact";
                            break;
                        case 2:
                            str = "choice";
                            break;
                        case 3:
                            str = "result";
                            break;
                        case 4:
                            str = "confession";
                            break;
                    }
                    jSONObject.put("stage", str);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "enddating_suc").setContentExt(jSONObject));
                DatingNavView.this.opf = 0;
                DatingNavView.this.opa.setEnabled(true);
                DatingNavView.this.setMasterStageView(0);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.datingnavigation.d.a
            public void onFail(int i, String str) {
                DatingNavView.this.opa.setEnabled(true);
                BdUtilHelper.showToast(DatingNavView.this.getContext(), "约会结束失败，请重试");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecB() {
        if (this.aGe != null && this.aGe.aLm != null && !TextUtils.isEmpty(this.aGe.aLm.aUR)) {
            if (this.hfG == null) {
                this.hfG = new com.baidu.live.ap.a(this.mActivity);
            }
            com.baidu.live.ap.c cVar = new com.baidu.live.ap.c();
            cVar.url = this.aGe.aLm.aUR;
            cVar.bXf = 0.5f;
            this.hfG.a(cVar);
        }
    }

    public void destory() {
        this.opf = 0;
        MessageManager.getInstance().unRegisterListener(this.ooI);
    }

    public void f(x xVar, boolean z) {
        if (xVar != null && xVar.aLq != null) {
            this.aGe = xVar;
            this.opf = xVar.aLq.getActivityStage();
            if (com.baidu.tieba.yuyinala.liveroom.wheat.e.g.egk()) {
                setMasterStageView(this.opf);
            } else {
                j(this.opf, true, z);
            }
            MessageManager.getInstance().registerListener(this.ooI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMasterStageView(int i) {
        Ng(i);
        Nh(i);
        this.opc.setVisibility(0);
    }

    private void ecC() {
        this.ooW.setBackgroundDrawable(null);
        this.ooW.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        com.baidu.tieba.yuyinala.liveroom.wheat.e.g.f(this.ooW, false);
        this.ooX.setBackgroundDrawable(null);
        this.ooX.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        com.baidu.tieba.yuyinala.liveroom.wheat.e.g.f(this.ooX, false);
        this.ooY.setBackgroundDrawable(null);
        this.ooY.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        com.baidu.tieba.yuyinala.liveroom.wheat.e.g.f(this.ooY, false);
        this.ooZ.setBackgroundDrawable(null);
        this.ooZ.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        com.baidu.tieba.yuyinala.liveroom.wheat.e.g.f(this.ooZ, false);
    }

    private void Ng(int i) {
        switch (i) {
            case 1:
                ecC();
                this.ooW.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.ooW.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                com.baidu.tieba.yuyinala.liveroom.wheat.e.g.f(this.ooW, true);
                this.ope.setContent(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.d(this.aGe, 1));
                return;
            case 2:
                ecC();
                this.ooX.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.ooX.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                com.baidu.tieba.yuyinala.liveroom.wheat.e.g.f(this.ooX, true);
                this.ope.setContent(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.d(this.aGe, 2));
                return;
            case 3:
                ecC();
                this.ooY.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.ooY.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                com.baidu.tieba.yuyinala.liveroom.wheat.e.g.f(this.ooY, true);
                this.ope.setContent(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.d(this.aGe, 3));
                return;
            case 4:
                ecC();
                this.ooZ.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.ooZ.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                com.baidu.tieba.yuyinala.liveroom.wheat.e.g.f(this.ooZ, true);
                this.ope.setContent(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.d(this.aGe, 4));
                return;
            default:
                ecC();
                this.ope.setContent(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.d(this.aGe, 0));
                return;
        }
    }

    public void k(x xVar) {
        if (xVar != null && xVar.aLq != null) {
            this.aGe = xVar;
            if (com.baidu.tieba.yuyinala.liveroom.wheat.e.g.egk()) {
                this.opf = xVar.aLq.getActivityStage();
                setMasterStageView(this.opf);
                return;
            }
            int activityStage = xVar.aLq.getActivityStage();
            this.opc.setVisibility(8);
            if (this.opf == 0 || activityStage != this.opf) {
                this.opf = activityStage;
                j(this.opf, false, true);
            }
        }
    }

    private void j(int i, boolean z, boolean z2) {
        this.opc.setVisibility(8);
        switch (i) {
            case 1:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "嘉宾互动中" : "约会开始，进入嘉宾互动环节");
                }
                Ng(1);
                if (this.aGe != null) {
                    this.aGe.aLB = "";
                    return;
                }
                return;
            case 2:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "心动选择中" : "进入心动选择环节");
                }
                Ng(2);
                return;
            case 3:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "结果公布中" : "进入结果公布环节");
                }
                Ng(3);
                if (this.aGe != null) {
                    this.aGe.aLB = "";
                    return;
                }
                return;
            case 4:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "甜蜜告白中" : "进入甜蜜告白环节");
                }
                Ng(4);
                if (this.aGe != null) {
                    this.aGe.aLB = "";
                    return;
                }
                return;
            default:
                Ng(0);
                if (this.aGe != null) {
                    this.aGe.aLB = "";
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZ(final int i, String str) {
        this.opj = com.baidu.tieba.yuyinala.liveroom.wheat.e.g.a(this.mActivity, str, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.opg.m(i + "", "1", com.baidu.tieba.yuyinala.liveroom.wheat.e.g.av(DatingNavView.this.aGe), 0);
                DatingNavView.this.opb.setEnabled(false);
                DatingNavView.this.opj = null;
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.opj = null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecD() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aGe.aLl.croom_id);
            String str = "";
            switch (this.opf) {
                case 1:
                    str = "interact";
                    break;
                case 2:
                    str = "choice";
                    break;
                case 3:
                    str = "result";
                    break;
                case 4:
                    str = "confession";
                    break;
            }
            jSONObject.put("stage", str);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "enddating_clk").setContentExt(jSONObject));
        this.opj = com.baidu.tieba.yuyinala.liveroom.wheat.e.g.a(this.mActivity, "确认结束本轮约会", new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.oph.m(DatingNavView.this.opf + "", "2", com.baidu.tieba.yuyinala.liveroom.wheat.e.g.av(DatingNavView.this.aGe), 0);
                DatingNavView.this.opa.setEnabled(false);
                DatingNavView.this.opj = null;
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.opj = null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecE() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aGe.aLl.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "startdating_clk").setContentExt(jSONObject));
        this.opj = com.baidu.tieba.yuyinala.liveroom.wheat.e.g.a(this.mActivity, "确定开始约会，进入嘉宾互动环节？", new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.opg.m("0", "1", com.baidu.tieba.yuyinala.liveroom.wheat.e.g.av(DatingNavView.this.aGe), 0);
                DatingNavView.this.opd.setEnabled(false);
                DatingNavView.this.opj = null;
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.opj = null;
            }
        });
    }

    private void Nh(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
                this.opd.setVisibility(8);
                this.opb.setVisibility(0);
                this.opa.setVisibility(0);
                return;
            case 4:
                this.opd.setVisibility(8);
                this.opb.setVisibility(8);
                this.opa.setVisibility(0);
                return;
            default:
                this.opd.setVisibility(0);
                this.opa.setVisibility(8);
                this.opb.setVisibility(8);
                return;
        }
    }
}
