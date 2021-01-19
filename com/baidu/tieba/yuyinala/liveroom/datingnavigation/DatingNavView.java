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
/* loaded from: classes10.dex */
public class DatingNavView extends LinearLayout {
    private x aBr;
    private com.baidu.live.ap.a hba;
    protected Activity mActivity;
    private int okA;
    private d okB;
    private d okC;
    private LinearLayout okD;
    private g okE;
    public CustomMessageListener okd;
    protected LinearLayout okq;
    protected TextView okr;
    protected TextView oks;
    protected TextView okt;
    protected TextView oku;
    protected TextView okv;
    protected TextView okw;
    protected LinearLayout okx;
    protected TextView oky;
    protected MarqueeView okz;

    public DatingNavView(Activity activity) {
        super(activity);
        this.okA = 0;
        this.okd = new CustomMessageListener(2501014) { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501014 && (customResponsedMessage.getData() instanceof com.baidu.live.data.g) && ((com.baidu.live.data.g) customResponsedMessage.getData()).AC() != 1) {
                    if (DatingNavView.this.okE != null && DatingNavView.this.okE.isShowing()) {
                        DatingNavView.this.okE.dismiss();
                    }
                    if (DatingNavView.this.hba != null) {
                        DatingNavView.this.hba.dismiss();
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
        this.okq = (LinearLayout) findViewById(a.f.ll_rule);
        this.okr = (TextView) findViewById(a.f.tv_inter);
        this.okD = (LinearLayout) findViewById(a.f.ll_rule);
        int i = BdUtilHelper.getScreenSize(activity).widthPixels;
        if (this.okD != null && this.okD.getLayoutParams() != null && (layoutParams = this.okD.getLayoutParams()) != null) {
            layoutParams.width = (i - BdUtilHelper.dip2px(activity, 110.0f)) / 4;
        }
        this.oks = (TextView) findViewById(a.f.tv_choose);
        this.okt = (TextView) findViewById(a.f.tv_publish);
        this.oku = (TextView) findViewById(a.f.tv_confession);
        this.okv = (TextView) findViewById(a.f.tv_end);
        this.okw = (TextView) findViewById(a.f.tv_next);
        this.okx = (LinearLayout) findViewById(a.f.tv_operate);
        this.oky = (TextView) findViewById(a.f.tv_start);
        this.okz = (MarqueeView) findViewById(a.f.tv_progress);
        this.okz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.dYJ();
            }
        });
        this.okq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.dYJ();
            }
        });
        aE(activity);
    }

    private void aE(Activity activity) {
        this.okB = new d(activity);
        this.okC = new d(activity);
        this.oky.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.dYM();
            }
        });
        this.okv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.dYL();
            }
        });
        this.okw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (DatingNavView.this.okA) {
                    case 1:
                        DatingNavView.this.ca(DatingNavView.this.okA, "确认进入 心动选择 环节？");
                        return;
                    case 2:
                        DatingNavView.this.ca(DatingNavView.this.okA, "确认进入 结果公布 环节？");
                        return;
                    case 3:
                        DatingNavView.this.ca(DatingNavView.this.okA, "确认进入 祝福时刻 环节？");
                        return;
                    default:
                        return;
                }
            }
        });
        this.okB.a(new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.11
            @Override // com.baidu.tieba.yuyinala.liveroom.datingnavigation.d.a
            public void a(DatingStageHttpResponseMessage datingStageHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501032));
                DatingNavView.this.oky.setEnabled(true);
                DatingNavView.this.okw.setEnabled(true);
                b dYN = datingStageHttpResponseMessage.dYN();
                if (dYN != null) {
                    try {
                        DatingNavView.this.okA = Integer.parseInt(dYN.okI);
                    } catch (Exception e) {
                        DatingNavView.this.okA = 0;
                    }
                    DatingNavView.this.setMasterStageView(DatingNavView.this.okA);
                    switch (DatingNavView.this.okA) {
                        case 1:
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, DatingNavView.this.aBr.aGy.croom_id);
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
                    DatingNavView.this.okA = 0;
                    DatingNavView.this.setMasterStageView(0);
                } else {
                    BdUtilHelper.showToast(DatingNavView.this.getContext(), "进入下一环节失败，请重试");
                }
                DatingNavView.this.oky.setEnabled(true);
                DatingNavView.this.okw.setEnabled(true);
            }
        });
        this.okC.a(new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.12
            @Override // com.baidu.tieba.yuyinala.liveroom.datingnavigation.d.a
            public void a(DatingStageHttpResponseMessage datingStageHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501032));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, DatingNavView.this.aBr.aGy.croom_id);
                    String str = "";
                    switch (DatingNavView.this.okA) {
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
                DatingNavView.this.okA = 0;
                DatingNavView.this.okv.setEnabled(true);
                DatingNavView.this.setMasterStageView(0);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.datingnavigation.d.a
            public void onFail(int i, String str) {
                DatingNavView.this.okv.setEnabled(true);
                BdUtilHelper.showToast(DatingNavView.this.getContext(), "约会结束失败，请重试");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYJ() {
        if (this.aBr != null && this.aBr.aGz != null && !TextUtils.isEmpty(this.aBr.aGz.aQe)) {
            if (this.hba == null) {
                this.hba = new com.baidu.live.ap.a(this.mActivity);
            }
            com.baidu.live.ap.c cVar = new com.baidu.live.ap.c();
            cVar.url = this.aBr.aGz.aQe;
            cVar.bSt = 0.5f;
            this.hba.a(cVar);
        }
    }

    public void destory() {
        this.okA = 0;
        MessageManager.getInstance().unRegisterListener(this.okd);
    }

    public void f(x xVar, boolean z) {
        if (xVar != null && xVar.aGD != null) {
            this.aBr = xVar;
            this.okA = xVar.aGD.getActivityStage();
            if (com.baidu.tieba.yuyinala.liveroom.wheat.e.g.ecs()) {
                setMasterStageView(this.okA);
            } else {
                j(this.okA, true, z);
            }
            MessageManager.getInstance().registerListener(this.okd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMasterStageView(int i) {
        Lz(i);
        LA(i);
        this.okx.setVisibility(0);
    }

    private void dYK() {
        this.okr.setBackgroundDrawable(null);
        this.okr.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        com.baidu.tieba.yuyinala.liveroom.wheat.e.g.f(this.okr, false);
        this.oks.setBackgroundDrawable(null);
        this.oks.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        com.baidu.tieba.yuyinala.liveroom.wheat.e.g.f(this.oks, false);
        this.okt.setBackgroundDrawable(null);
        this.okt.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        com.baidu.tieba.yuyinala.liveroom.wheat.e.g.f(this.okt, false);
        this.oku.setBackgroundDrawable(null);
        this.oku.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        com.baidu.tieba.yuyinala.liveroom.wheat.e.g.f(this.oku, false);
    }

    private void Lz(int i) {
        switch (i) {
            case 1:
                dYK();
                this.okr.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.okr.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                com.baidu.tieba.yuyinala.liveroom.wheat.e.g.f(this.okr, true);
                this.okz.setContent(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.d(this.aBr, 1));
                return;
            case 2:
                dYK();
                this.oks.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.oks.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                com.baidu.tieba.yuyinala.liveroom.wheat.e.g.f(this.oks, true);
                this.okz.setContent(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.d(this.aBr, 2));
                return;
            case 3:
                dYK();
                this.okt.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.okt.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                com.baidu.tieba.yuyinala.liveroom.wheat.e.g.f(this.okt, true);
                this.okz.setContent(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.d(this.aBr, 3));
                return;
            case 4:
                dYK();
                this.oku.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.oku.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                com.baidu.tieba.yuyinala.liveroom.wheat.e.g.f(this.oku, true);
                this.okz.setContent(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.d(this.aBr, 4));
                return;
            default:
                dYK();
                this.okz.setContent(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.d(this.aBr, 0));
                return;
        }
    }

    public void k(x xVar) {
        if (xVar != null && xVar.aGD != null) {
            this.aBr = xVar;
            if (com.baidu.tieba.yuyinala.liveroom.wheat.e.g.ecs()) {
                this.okA = xVar.aGD.getActivityStage();
                setMasterStageView(this.okA);
                return;
            }
            int activityStage = xVar.aGD.getActivityStage();
            this.okx.setVisibility(8);
            if (this.okA == 0 || activityStage != this.okA) {
                this.okA = activityStage;
                j(this.okA, false, true);
            }
        }
    }

    private void j(int i, boolean z, boolean z2) {
        this.okx.setVisibility(8);
        switch (i) {
            case 1:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "嘉宾互动中" : "约会开始，进入嘉宾互动环节");
                }
                Lz(1);
                if (this.aBr != null) {
                    this.aBr.aGO = "";
                    return;
                }
                return;
            case 2:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "心动选择中" : "进入心动选择环节");
                }
                Lz(2);
                return;
            case 3:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "结果公布中" : "进入结果公布环节");
                }
                Lz(3);
                if (this.aBr != null) {
                    this.aBr.aGO = "";
                    return;
                }
                return;
            case 4:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "甜蜜告白中" : "进入甜蜜告白环节");
                }
                Lz(4);
                if (this.aBr != null) {
                    this.aBr.aGO = "";
                    return;
                }
                return;
            default:
                Lz(0);
                if (this.aBr != null) {
                    this.aBr.aGO = "";
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca(final int i, String str) {
        this.okE = com.baidu.tieba.yuyinala.liveroom.wheat.e.g.a(this.mActivity, str, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.okB.m(i + "", "1", com.baidu.tieba.yuyinala.liveroom.wheat.e.g.av(DatingNavView.this.aBr), 0);
                DatingNavView.this.okw.setEnabled(false);
                DatingNavView.this.okE = null;
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.okE = null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYL() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aBr.aGy.croom_id);
            String str = "";
            switch (this.okA) {
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
        this.okE = com.baidu.tieba.yuyinala.liveroom.wheat.e.g.a(this.mActivity, "确认结束本轮约会", new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.okC.m(DatingNavView.this.okA + "", "2", com.baidu.tieba.yuyinala.liveroom.wheat.e.g.av(DatingNavView.this.aBr), 0);
                DatingNavView.this.okv.setEnabled(false);
                DatingNavView.this.okE = null;
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.okE = null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dYM() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aBr.aGy.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "startdating_clk").setContentExt(jSONObject));
        this.okE = com.baidu.tieba.yuyinala.liveroom.wheat.e.g.a(this.mActivity, "确定开始约会，进入嘉宾互动环节？", new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.okB.m("0", "1", com.baidu.tieba.yuyinala.liveroom.wheat.e.g.av(DatingNavView.this.aBr), 0);
                DatingNavView.this.oky.setEnabled(false);
                DatingNavView.this.okE = null;
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.okE = null;
            }
        });
    }

    private void LA(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
                this.oky.setVisibility(8);
                this.okw.setVisibility(0);
                this.okv.setVisibility(0);
                return;
            case 4:
                this.oky.setVisibility(8);
                this.okw.setVisibility(8);
                this.okv.setVisibility(0);
                return;
            default:
                this.oky.setVisibility(0);
                this.okv.setVisibility(8);
                this.okw.setVisibility(8);
                return;
        }
    }
}
