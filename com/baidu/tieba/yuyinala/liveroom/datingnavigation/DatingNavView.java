package com.baidu.tieba.yuyinala.liveroom.datingnavigation;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.yuyinala.liveroom.datingnavigation.d;
import com.baidu.tieba.yuyinala.liveroom.wheat.e.g;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class DatingNavView extends LinearLayout {
    private w aES;
    private com.baidu.live.ak.a gKY;
    protected Activity mActivity;
    protected TextView nVA;
    protected TextView nVB;
    protected TextView nVC;
    protected TextView nVD;
    protected TextView nVE;
    protected LinearLayout nVF;
    protected TextView nVG;
    protected MarqueeTextView nVH;
    private int nVI;
    private d nVJ;
    private d nVK;
    private LinearLayout nVL;
    protected LinearLayout nVy;
    protected TextView nVz;

    public DatingNavView(Activity activity) {
        super(activity);
        this.nVI = 0;
        I(activity);
    }

    protected void I(Activity activity) {
        ViewGroup.LayoutParams layoutParams;
        LayoutInflater.from(activity).inflate(a.g.yuyin_ala_liveroom_dating_nav_layout, this);
        this.mActivity = activity;
        this.nVy = (LinearLayout) findViewById(a.f.ll_rule);
        this.nVz = (TextView) findViewById(a.f.tv_inter);
        this.nVL = (LinearLayout) findViewById(a.f.ll_rule);
        int i = BdUtilHelper.getScreenSize(activity).widthPixels;
        if (this.nVL != null && this.nVL.getLayoutParams() != null && (layoutParams = this.nVL.getLayoutParams()) != null) {
            layoutParams.width = (i - BdUtilHelper.dip2px(activity, 110.0f)) / 4;
        }
        this.nVA = (TextView) findViewById(a.f.tv_choose);
        this.nVB = (TextView) findViewById(a.f.tv_publish);
        this.nVC = (TextView) findViewById(a.f.tv_confession);
        this.nVD = (TextView) findViewById(a.f.tv_end);
        this.nVE = (TextView) findViewById(a.f.tv_next);
        this.nVF = (LinearLayout) findViewById(a.f.tv_operate);
        this.nVG = (TextView) findViewById(a.f.tv_start);
        this.nVH = (MarqueeTextView) findViewById(a.f.tv_progress);
        this.nVH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.dXN();
            }
        });
        this.nVy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.dXN();
            }
        });
        aA(activity);
    }

    private void aA(Activity activity) {
        this.nVJ = new d(activity);
        this.nVK = new d(activity);
        this.nVG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.dXQ();
            }
        });
        this.nVD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.dXP();
            }
        });
        this.nVE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (DatingNavView.this.nVI) {
                    case 1:
                        DatingNavView.this.ca(DatingNavView.this.nVI, "确认进入 心动选择 环节？");
                        return;
                    case 2:
                        DatingNavView.this.ca(DatingNavView.this.nVI, "确认进入 结果公布 环节？");
                        return;
                    case 3:
                        DatingNavView.this.ca(DatingNavView.this.nVI, "确认进入 祝福时刻 环节？");
                        return;
                    default:
                        return;
                }
            }
        });
        this.nVJ.a(new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.7
            @Override // com.baidu.tieba.yuyinala.liveroom.datingnavigation.d.a
            public void a(DatingStageHttpResponseMessage datingStageHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501032));
                DatingNavView.this.nVG.setEnabled(true);
                DatingNavView.this.nVE.setEnabled(true);
                b dXR = datingStageHttpResponseMessage.dXR();
                if (dXR != null) {
                    try {
                        DatingNavView.this.nVI = Integer.parseInt(dXR.nVP);
                    } catch (Exception e) {
                        DatingNavView.this.nVI = 0;
                    }
                    DatingNavView.this.setMasterStageView(DatingNavView.this.nVI);
                    switch (DatingNavView.this.nVI) {
                        case 1:
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, DatingNavView.this.aES.aJK.croom_id);
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
                    DatingNavView.this.nVI = 0;
                    DatingNavView.this.setMasterStageView(0);
                } else {
                    BdUtilHelper.showToast(DatingNavView.this.getContext(), "进入下一环节失败，请重试");
                }
                DatingNavView.this.nVG.setEnabled(true);
                DatingNavView.this.nVE.setEnabled(true);
            }
        });
        this.nVK.a(new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.8
            @Override // com.baidu.tieba.yuyinala.liveroom.datingnavigation.d.a
            public void a(DatingStageHttpResponseMessage datingStageHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501032));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, DatingNavView.this.aES.aJK.croom_id);
                    String str = "";
                    switch (DatingNavView.this.nVI) {
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
                DatingNavView.this.nVI = 0;
                DatingNavView.this.nVD.setEnabled(true);
                DatingNavView.this.setMasterStageView(0);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.datingnavigation.d.a
            public void onFail(int i, String str) {
                DatingNavView.this.nVD.setEnabled(true);
                BdUtilHelper.showToast(DatingNavView.this.getContext(), "约会结束失败，请重试");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXN() {
        if (this.aES != null && this.aES.aJL != null && !TextUtils.isEmpty(this.aES.aJL.aSC)) {
            if (this.gKY == null) {
                this.gKY = new com.baidu.live.ak.a(this.mActivity);
            }
            com.baidu.live.ak.c cVar = new com.baidu.live.ak.c();
            cVar.url = this.aES.aJL.aSC;
            cVar.bOc = 0.5f;
            this.gKY.a(cVar);
        }
    }

    public void destory() {
        this.nVI = 0;
    }

    public void e(w wVar, boolean z) {
        if (wVar != null && wVar.aJP != null) {
            this.aES = wVar;
            this.nVI = wVar.aJP.getActivityStage();
            if (g.eau()) {
                setMasterStageView(this.nVI);
            } else {
                j(this.nVI, true, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMasterStageView(int i) {
        LZ(i);
        Ma(i);
        this.nVF.setVisibility(0);
    }

    private void dXO() {
        this.nVz.setBackgroundDrawable(null);
        this.nVz.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        g.f(this.nVz, false);
        this.nVA.setBackgroundDrawable(null);
        this.nVA.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        g.f(this.nVA, false);
        this.nVB.setBackgroundDrawable(null);
        this.nVB.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        g.f(this.nVB, false);
        this.nVC.setBackgroundDrawable(null);
        this.nVC.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        g.f(this.nVC, false);
    }

    private void LZ(int i) {
        switch (i) {
            case 1:
                dXO();
                this.nVz.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.nVz.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                g.f(this.nVz, true);
                this.nVH.setScrollText(g.d(this.aES, 1));
                return;
            case 2:
                dXO();
                this.nVA.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.nVA.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                g.f(this.nVA, true);
                this.nVH.setScrollText(g.d(this.aES, 2));
                return;
            case 3:
                dXO();
                this.nVB.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.nVB.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                g.f(this.nVB, true);
                this.nVH.setScrollText(g.d(this.aES, 3));
                return;
            case 4:
                dXO();
                this.nVC.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.nVC.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                g.f(this.nVC, true);
                this.nVH.setScrollText(g.d(this.aES, 4));
                return;
            default:
                dXO();
                this.nVH.setScrollText(g.d(this.aES, 0));
                return;
        }
    }

    public void j(w wVar) {
        if (wVar != null && wVar.aJP != null) {
            this.aES = wVar;
            if (g.eau()) {
                this.nVI = wVar.aJP.getActivityStage();
                setMasterStageView(this.nVI);
                return;
            }
            int activityStage = wVar.aJP.getActivityStage();
            this.nVF.setVisibility(8);
            if (this.nVI == 0 || activityStage != this.nVI) {
                this.nVI = activityStage;
                j(this.nVI, false, true);
            }
        }
    }

    private void j(int i, boolean z, boolean z2) {
        this.nVF.setVisibility(8);
        switch (i) {
            case 1:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "嘉宾互动中" : "约会开始，进入嘉宾互动环节");
                }
                LZ(1);
                if (this.aES != null) {
                    this.aES.aKa = "";
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
                if (this.aES != null) {
                    this.aES.aKa = "";
                    return;
                }
                return;
            case 4:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "甜蜜告白中" : "进入甜蜜告白环节");
                }
                LZ(4);
                if (this.aES != null) {
                    this.aES.aKa = "";
                    return;
                }
                return;
            default:
                LZ(0);
                if (this.aES != null) {
                    this.aES.aKa = "";
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ca(final int i, String str) {
        g.a(this.mActivity, str, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.nVJ.h(i + "", "1", g.am(DatingNavView.this.aES), 0);
                DatingNavView.this.nVE.setEnabled(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXP() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aES.aJK.croom_id);
            String str = "";
            switch (this.nVI) {
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
        g.a(this.mActivity, "确认结束本轮约会", new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.nVK.h(DatingNavView.this.nVI + "", "2", g.am(DatingNavView.this.aES), 0);
                DatingNavView.this.nVD.setEnabled(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aES.aJK.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "startdating_clk").setContentExt(jSONObject));
        g.a(this.mActivity, "确定开始约会，进入嘉宾互动环节？", new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.nVJ.h("0", "1", g.am(DatingNavView.this.aES), 0);
                DatingNavView.this.nVG.setEnabled(false);
            }
        });
    }

    private void Ma(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
                this.nVG.setVisibility(8);
                this.nVE.setVisibility(0);
                this.nVD.setVisibility(0);
                return;
            case 4:
                this.nVG.setVisibility(8);
                this.nVE.setVisibility(8);
                this.nVD.setVisibility(0);
                return;
            default:
                this.nVG.setVisibility(0);
                this.nVD.setVisibility(8);
                this.nVE.setVisibility(8);
                return;
        }
    }
}
