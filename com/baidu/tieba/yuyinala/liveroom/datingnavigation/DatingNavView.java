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
    private w aDh;
    private com.baidu.live.ak.a gKF;
    protected Activity mActivity;
    protected LinearLayout nXb;
    protected TextView nXc;
    protected TextView nXd;
    protected TextView nXe;
    protected TextView nXf;
    protected TextView nXg;
    protected TextView nXh;
    protected LinearLayout nXi;
    protected TextView nXj;
    protected MarqueeTextView nXk;
    private int nXl;
    private d nXm;
    private d nXn;
    private LinearLayout nXo;

    public DatingNavView(Activity activity) {
        super(activity);
        this.nXl = 0;
        H(activity);
    }

    protected void H(Activity activity) {
        ViewGroup.LayoutParams layoutParams;
        LayoutInflater.from(activity).inflate(a.g.yuyin_ala_liveroom_dating_nav_layout, this);
        this.mActivity = activity;
        this.nXb = (LinearLayout) findViewById(a.f.ll_rule);
        this.nXc = (TextView) findViewById(a.f.tv_inter);
        this.nXo = (LinearLayout) findViewById(a.f.ll_rule);
        int i = BdUtilHelper.getScreenSize(activity).widthPixels;
        if (this.nXo != null && this.nXo.getLayoutParams() != null && (layoutParams = this.nXo.getLayoutParams()) != null) {
            layoutParams.width = (i - BdUtilHelper.dip2px(activity, 110.0f)) / 4;
        }
        this.nXd = (TextView) findViewById(a.f.tv_choose);
        this.nXe = (TextView) findViewById(a.f.tv_publish);
        this.nXf = (TextView) findViewById(a.f.tv_confession);
        this.nXg = (TextView) findViewById(a.f.tv_end);
        this.nXh = (TextView) findViewById(a.f.tv_next);
        this.nXi = (LinearLayout) findViewById(a.f.tv_operate);
        this.nXj = (TextView) findViewById(a.f.tv_start);
        this.nXk = (MarqueeTextView) findViewById(a.f.tv_progress);
        this.nXk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.dXM();
            }
        });
        this.nXb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.dXM();
            }
        });
        az(activity);
    }

    private void az(Activity activity) {
        this.nXm = new d(activity);
        this.nXn = new d(activity);
        this.nXj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.dXP();
            }
        });
        this.nXg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.dXO();
            }
        });
        this.nXh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (DatingNavView.this.nXl) {
                    case 1:
                        DatingNavView.this.bY(DatingNavView.this.nXl, "确认进入 心动选择 环节？");
                        return;
                    case 2:
                        DatingNavView.this.bY(DatingNavView.this.nXl, "确认进入 结果公布 环节？");
                        return;
                    case 3:
                        DatingNavView.this.bY(DatingNavView.this.nXl, "确认进入 祝福时刻 环节？");
                        return;
                    default:
                        return;
                }
            }
        });
        this.nXm.a(new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.7
            @Override // com.baidu.tieba.yuyinala.liveroom.datingnavigation.d.a
            public void a(DatingStageHttpResponseMessage datingStageHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501032));
                DatingNavView.this.nXj.setEnabled(true);
                DatingNavView.this.nXh.setEnabled(true);
                b dXQ = datingStageHttpResponseMessage.dXQ();
                if (dXQ != null) {
                    try {
                        DatingNavView.this.nXl = Integer.parseInt(dXQ.nXs);
                    } catch (Exception e) {
                        DatingNavView.this.nXl = 0;
                    }
                    DatingNavView.this.setMasterStageView(DatingNavView.this.nXl);
                    switch (DatingNavView.this.nXl) {
                        case 1:
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, DatingNavView.this.aDh.aHZ.croom_id);
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
                    DatingNavView.this.nXl = 0;
                    DatingNavView.this.setMasterStageView(0);
                } else {
                    BdUtilHelper.showToast(DatingNavView.this.getContext(), "进入下一环节失败，请重试");
                }
                DatingNavView.this.nXj.setEnabled(true);
                DatingNavView.this.nXh.setEnabled(true);
            }
        });
        this.nXn.a(new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.8
            @Override // com.baidu.tieba.yuyinala.liveroom.datingnavigation.d.a
            public void a(DatingStageHttpResponseMessage datingStageHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501032));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, DatingNavView.this.aDh.aHZ.croom_id);
                    String str = "";
                    switch (DatingNavView.this.nXl) {
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
                DatingNavView.this.nXl = 0;
                DatingNavView.this.nXg.setEnabled(true);
                DatingNavView.this.setMasterStageView(0);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.datingnavigation.d.a
            public void onFail(int i, String str) {
                DatingNavView.this.nXg.setEnabled(true);
                BdUtilHelper.showToast(DatingNavView.this.getContext(), "约会结束失败，请重试");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXM() {
        if (this.aDh != null && this.aDh.aIa != null && !TextUtils.isEmpty(this.aDh.aIa.aQR)) {
            if (this.gKF == null) {
                this.gKF = new com.baidu.live.ak.a(this.mActivity);
            }
            com.baidu.live.ak.c cVar = new com.baidu.live.ak.c();
            cVar.url = this.aDh.aIa.aQR;
            cVar.bMs = 0.5f;
            this.gKF.a(cVar);
        }
    }

    public void destory() {
        this.nXl = 0;
    }

    public void e(w wVar, boolean z) {
        if (wVar != null && wVar.aIe != null) {
            this.aDh = wVar;
            this.nXl = wVar.aIe.getActivityStage();
            if (g.eat()) {
                setMasterStageView(this.nXl);
            } else {
                j(this.nXl, true, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMasterStageView(int i) {
        MC(i);
        MD(i);
        this.nXi.setVisibility(0);
    }

    private void dXN() {
        this.nXc.setBackgroundDrawable(null);
        this.nXc.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        g.f(this.nXc, false);
        this.nXd.setBackgroundDrawable(null);
        this.nXd.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        g.f(this.nXd, false);
        this.nXe.setBackgroundDrawable(null);
        this.nXe.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        g.f(this.nXe, false);
        this.nXf.setBackgroundDrawable(null);
        this.nXf.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        g.f(this.nXf, false);
    }

    private void MC(int i) {
        switch (i) {
            case 1:
                dXN();
                this.nXc.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.nXc.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                g.f(this.nXc, true);
                this.nXk.setScrollText(g.d(this.aDh, 1));
                return;
            case 2:
                dXN();
                this.nXd.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.nXd.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                g.f(this.nXd, true);
                this.nXk.setScrollText(g.d(this.aDh, 2));
                return;
            case 3:
                dXN();
                this.nXe.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.nXe.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                g.f(this.nXe, true);
                this.nXk.setScrollText(g.d(this.aDh, 3));
                return;
            case 4:
                dXN();
                this.nXf.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.nXf.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                g.f(this.nXf, true);
                this.nXk.setScrollText(g.d(this.aDh, 4));
                return;
            default:
                dXN();
                this.nXk.setScrollText(g.d(this.aDh, 0));
                return;
        }
    }

    public void j(w wVar) {
        if (wVar != null && wVar.aIe != null) {
            this.aDh = wVar;
            if (g.eat()) {
                this.nXl = wVar.aIe.getActivityStage();
                setMasterStageView(this.nXl);
                return;
            }
            int activityStage = wVar.aIe.getActivityStage();
            this.nXi.setVisibility(8);
            if (this.nXl == 0 || activityStage != this.nXl) {
                this.nXl = activityStage;
                j(this.nXl, false, true);
            }
        }
    }

    private void j(int i, boolean z, boolean z2) {
        this.nXi.setVisibility(8);
        switch (i) {
            case 1:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "嘉宾互动中" : "约会开始，进入嘉宾互动环节");
                }
                MC(1);
                if (this.aDh != null) {
                    this.aDh.aIp = "";
                    return;
                }
                return;
            case 2:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "心动选择中" : "进入心动选择环节");
                }
                MC(2);
                return;
            case 3:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "结果公布中" : "进入结果公布环节");
                }
                MC(3);
                if (this.aDh != null) {
                    this.aDh.aIp = "";
                    return;
                }
                return;
            case 4:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "甜蜜告白中" : "进入甜蜜告白环节");
                }
                MC(4);
                if (this.aDh != null) {
                    this.aDh.aIp = "";
                    return;
                }
                return;
            default:
                MC(0);
                if (this.aDh != null) {
                    this.aDh.aIp = "";
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bY(final int i, String str) {
        g.a(this.mActivity, str, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.nXm.h(i + "", "1", g.am(DatingNavView.this.aDh), 0);
                DatingNavView.this.nXh.setEnabled(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXO() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aDh.aHZ.croom_id);
            String str = "";
            switch (this.nXl) {
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
                DatingNavView.this.nXn.h(DatingNavView.this.nXl + "", "2", g.am(DatingNavView.this.aDh), 0);
                DatingNavView.this.nXg.setEnabled(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXP() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aDh.aHZ.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "startdating_clk").setContentExt(jSONObject));
        g.a(this.mActivity, "确定开始约会，进入嘉宾互动环节？", new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.nXm.h("0", "1", g.am(DatingNavView.this.aDh), 0);
                DatingNavView.this.nXj.setEnabled(false);
            }
        });
    }

    private void MD(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
                this.nXj.setVisibility(8);
                this.nXh.setVisibility(0);
                this.nXg.setVisibility(0);
                return;
            case 4:
                this.nXj.setVisibility(8);
                this.nXh.setVisibility(8);
                this.nXg.setVisibility(0);
                return;
            default:
                this.nXj.setVisibility(0);
                this.nXg.setVisibility(8);
                this.nXh.setVisibility(8);
                return;
        }
    }
}
