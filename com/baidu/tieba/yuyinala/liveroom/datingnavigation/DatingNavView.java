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
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.yuyinala.liveroom.datingnavigation.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class DatingNavView extends LinearLayout {
    private ab aED;
    private com.baidu.live.an.a bif;
    protected Activity mActivity;
    public CustomMessageListener owC;
    protected LinearLayout owN;
    protected TextView owO;
    protected TextView owP;
    protected TextView owQ;
    protected TextView owR;
    protected TextView owS;
    protected TextView owT;
    protected LinearLayout owU;
    protected TextView owV;
    protected MarqueeView owW;
    private int owX;
    private c owY;
    private c owZ;
    private LinearLayout oxa;
    private g oxb;

    public DatingNavView(Activity activity) {
        super(activity);
        this.owX = 0;
        this.owC = new CustomMessageListener(2501014) { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501014 && (customResponsedMessage.getData() instanceof com.baidu.live.data.g) && ((com.baidu.live.data.g) customResponsedMessage.getData()).Bp() != 1) {
                    if (DatingNavView.this.oxb != null && DatingNavView.this.oxb.isShowing()) {
                        DatingNavView.this.oxb.dismiss();
                    }
                    if (DatingNavView.this.bif != null) {
                        DatingNavView.this.bif.dismiss();
                    }
                }
            }
        };
        A(activity);
    }

    protected void A(Activity activity) {
        ViewGroup.LayoutParams layoutParams;
        LayoutInflater.from(activity).inflate(a.g.yuyin_ala_liveroom_dating_nav_layout, this);
        this.mActivity = activity;
        this.owN = (LinearLayout) findViewById(a.f.ll_rule);
        this.owO = (TextView) findViewById(a.f.tv_inter);
        this.oxa = (LinearLayout) findViewById(a.f.ll_rule);
        int i = BdUtilHelper.getScreenSize(activity).widthPixels;
        if (this.oxa != null && this.oxa.getLayoutParams() != null && (layoutParams = this.oxa.getLayoutParams()) != null) {
            layoutParams.width = (i - BdUtilHelper.dip2px(activity, 110.0f)) / 4;
        }
        this.owP = (TextView) findViewById(a.f.tv_choose);
        this.owQ = (TextView) findViewById(a.f.tv_publish);
        this.owR = (TextView) findViewById(a.f.tv_confession);
        this.owS = (TextView) findViewById(a.f.tv_end);
        this.owT = (TextView) findViewById(a.f.tv_next);
        this.owU = (LinearLayout) findViewById(a.f.tv_operate);
        this.owV = (TextView) findViewById(a.f.tv_start);
        this.owW = (MarqueeView) findViewById(a.f.tv_progress);
        this.owW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.ebl();
            }
        });
        this.owN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.ebl();
            }
        });
        ay(activity);
    }

    private void ay(Activity activity) {
        this.owY = new c(activity);
        this.owZ = new c(activity);
        this.owV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.ebo();
            }
        });
        this.owS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.ebn();
            }
        });
        this.owT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (DatingNavView.this.owX) {
                    case 1:
                        DatingNavView.this.ch(DatingNavView.this.owX, "确认进入 心动选择 环节？");
                        return;
                    case 2:
                        DatingNavView.this.ch(DatingNavView.this.owX, "确认进入 结果公布 环节？");
                        return;
                    case 3:
                        DatingNavView.this.ch(DatingNavView.this.owX, "确认进入 祝福时刻 环节？");
                        return;
                    default:
                        return;
                }
            }
        });
        this.owY.a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.11
            @Override // com.baidu.tieba.yuyinala.liveroom.datingnavigation.c.a
            public void a(DatingStageHttpResponseMessage datingStageHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501032));
                DatingNavView.this.owV.setEnabled(true);
                DatingNavView.this.owT.setEnabled(true);
                a ebp = datingStageHttpResponseMessage.ebp();
                if (ebp != null) {
                    try {
                        DatingNavView.this.owX = Integer.parseInt(ebp.oxf);
                    } catch (Exception e) {
                        DatingNavView.this.owX = 0;
                    }
                    DatingNavView.this.setMasterStageView(DatingNavView.this.owX);
                    switch (DatingNavView.this.owX) {
                        case 1:
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, DatingNavView.this.aED.aKu.croom_id);
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

            @Override // com.baidu.tieba.yuyinala.liveroom.datingnavigation.c.a
            public void onFail(int i, String str) {
                if (i == 110003) {
                    DatingNavView.this.owX = 0;
                    DatingNavView.this.setMasterStageView(0);
                } else {
                    BdUtilHelper.showToast(DatingNavView.this.getContext(), "进入下一环节失败，请重试");
                }
                DatingNavView.this.owV.setEnabled(true);
                DatingNavView.this.owT.setEnabled(true);
            }
        });
        this.owZ.a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.12
            @Override // com.baidu.tieba.yuyinala.liveroom.datingnavigation.c.a
            public void a(DatingStageHttpResponseMessage datingStageHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501032));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, DatingNavView.this.aED.aKu.croom_id);
                    String str = "";
                    switch (DatingNavView.this.owX) {
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
                DatingNavView.this.owX = 0;
                DatingNavView.this.owS.setEnabled(true);
                DatingNavView.this.setMasterStageView(0);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.datingnavigation.c.a
            public void onFail(int i, String str) {
                DatingNavView.this.owS.setEnabled(true);
                BdUtilHelper.showToast(DatingNavView.this.getContext(), "约会结束失败，请重试");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebl() {
        if (this.aED != null && this.aED.aKv != null && !TextUtils.isEmpty(this.aED.aKv.aUH)) {
            if (this.bif == null) {
                this.bif = new com.baidu.live.an.a(this.mActivity);
            }
            com.baidu.live.an.c cVar = new com.baidu.live.an.c();
            cVar.url = this.aED.aKv.aUH;
            cVar.bXS = 0.5f;
            this.bif.a(cVar);
        }
    }

    public void f(ab abVar, boolean z) {
        if (abVar != null && abVar.aKy != null) {
            this.aED = abVar;
            this.owX = abVar.aKy.getActivityStage();
            if (com.baidu.tieba.yuyinala.liveroom.wheat.e.g.eeW()) {
                setMasterStageView(this.owX);
            } else {
                j(this.owX, true, z);
            }
            MessageManager.getInstance().registerListener(this.owC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMasterStageView(int i) {
        LZ(i);
        Ma(i);
        this.owU.setVisibility(0);
    }

    private void ebm() {
        this.owO.setBackgroundDrawable(null);
        this.owO.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        com.baidu.tieba.yuyinala.liveroom.wheat.e.g.g(this.owO, false);
        this.owP.setBackgroundDrawable(null);
        this.owP.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        com.baidu.tieba.yuyinala.liveroom.wheat.e.g.g(this.owP, false);
        this.owQ.setBackgroundDrawable(null);
        this.owQ.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        com.baidu.tieba.yuyinala.liveroom.wheat.e.g.g(this.owQ, false);
        this.owR.setBackgroundDrawable(null);
        this.owR.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        com.baidu.tieba.yuyinala.liveroom.wheat.e.g.g(this.owR, false);
    }

    private void LZ(int i) {
        switch (i) {
            case 1:
                ebm();
                this.owO.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.owO.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                com.baidu.tieba.yuyinala.liveroom.wheat.e.g.g(this.owO, true);
                this.owW.setContent(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.d(this.aED, 1));
                return;
            case 2:
                ebm();
                this.owP.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.owP.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                com.baidu.tieba.yuyinala.liveroom.wheat.e.g.g(this.owP, true);
                this.owW.setContent(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.d(this.aED, 2));
                return;
            case 3:
                ebm();
                this.owQ.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.owQ.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                com.baidu.tieba.yuyinala.liveroom.wheat.e.g.g(this.owQ, true);
                this.owW.setContent(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.d(this.aED, 3));
                return;
            case 4:
                ebm();
                this.owR.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.owR.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                com.baidu.tieba.yuyinala.liveroom.wheat.e.g.g(this.owR, true);
                this.owW.setContent(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.d(this.aED, 4));
                return;
            default:
                ebm();
                this.owW.setContent(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.d(this.aED, 0));
                return;
        }
    }

    public void k(ab abVar) {
        if (abVar != null && abVar.aKy != null) {
            this.aED = abVar;
            if (com.baidu.tieba.yuyinala.liveroom.wheat.e.g.eeW()) {
                this.owX = abVar.aKy.getActivityStage();
                setMasterStageView(this.owX);
                return;
            }
            int activityStage = abVar.aKy.getActivityStage();
            this.owU.setVisibility(8);
            if (this.owX == 0 || activityStage != this.owX) {
                this.owX = activityStage;
                j(this.owX, false, true);
            }
        }
    }

    private void j(int i, boolean z, boolean z2) {
        this.owU.setVisibility(8);
        switch (i) {
            case 1:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "嘉宾互动中" : "约会开始，进入嘉宾互动环节");
                }
                LZ(1);
                if (this.aED != null) {
                    this.aED.aKM = "";
                    return;
                }
                return;
            case 2:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "心动选择中" : "进入心动选择环节");
                }
                LZ(2);
                return;
            case 3:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "结果公布中" : "进入结果公布环节");
                }
                LZ(3);
                if (this.aED != null) {
                    this.aED.aKM = "";
                    return;
                }
                return;
            case 4:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "甜蜜告白中" : "进入甜蜜告白环节");
                }
                LZ(4);
                if (this.aED != null) {
                    this.aED.aKM = "";
                    return;
                }
                return;
            default:
                LZ(0);
                if (this.aED != null) {
                    this.aED.aKM = "";
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(final int i, String str) {
        this.oxb = com.baidu.tieba.yuyinala.liveroom.wheat.e.g.a(this.mActivity, str, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.owY.m(i + "", "1", com.baidu.tieba.yuyinala.liveroom.wheat.e.g.av(DatingNavView.this.aED), 0);
                DatingNavView.this.owT.setEnabled(false);
                DatingNavView.this.oxb = null;
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.oxb = null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebn() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aED.aKu.croom_id);
            String str = "";
            switch (this.owX) {
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
        this.oxb = com.baidu.tieba.yuyinala.liveroom.wheat.e.g.a(this.mActivity, "确认结束本轮约会", new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.owZ.m(DatingNavView.this.owX + "", "2", com.baidu.tieba.yuyinala.liveroom.wheat.e.g.av(DatingNavView.this.aED), 0);
                DatingNavView.this.owS.setEnabled(false);
                DatingNavView.this.oxb = null;
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.oxb = null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aED.aKu.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "startdating_clk").setContentExt(jSONObject));
        this.oxb = com.baidu.tieba.yuyinala.liveroom.wheat.e.g.a(this.mActivity, "确定开始约会，进入嘉宾互动环节？", new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.owY.m("0", "1", com.baidu.tieba.yuyinala.liveroom.wheat.e.g.av(DatingNavView.this.aED), 0);
                DatingNavView.this.owV.setEnabled(false);
                DatingNavView.this.oxb = null;
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.oxb = null;
            }
        });
    }

    private void Ma(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
                this.owV.setVisibility(8);
                this.owT.setVisibility(0);
                this.owS.setVisibility(0);
                return;
            case 4:
                this.owV.setVisibility(8);
                this.owT.setVisibility(8);
                this.owS.setVisibility(0);
                return;
            default:
                this.owV.setVisibility(0);
                this.owS.setVisibility(8);
                this.owT.setVisibility(8);
                return;
        }
    }
}
