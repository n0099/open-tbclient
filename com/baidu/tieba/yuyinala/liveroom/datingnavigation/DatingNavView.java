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
/* loaded from: classes11.dex */
public class DatingNavView extends LinearLayout {
    private ab aDd;
    private com.baidu.live.an.a bgE;
    protected Activity mActivity;
    protected LinearLayout ouI;
    protected TextView ouJ;
    protected TextView ouK;
    protected TextView ouL;
    protected TextView ouM;
    protected TextView ouN;
    protected TextView ouO;
    protected LinearLayout ouP;
    protected TextView ouQ;
    protected MarqueeView ouR;
    private int ouS;
    private c ouT;
    private c ouU;
    private LinearLayout ouV;
    private g ouW;
    public CustomMessageListener oux;

    public DatingNavView(Activity activity) {
        super(activity);
        this.ouS = 0;
        this.oux = new CustomMessageListener(2501014) { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501014 && (customResponsedMessage.getData() instanceof com.baidu.live.data.g) && ((com.baidu.live.data.g) customResponsedMessage.getData()).Bm() != 1) {
                    if (DatingNavView.this.ouW != null && DatingNavView.this.ouW.isShowing()) {
                        DatingNavView.this.ouW.dismiss();
                    }
                    if (DatingNavView.this.bgE != null) {
                        DatingNavView.this.bgE.dismiss();
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
        this.ouI = (LinearLayout) findViewById(a.f.ll_rule);
        this.ouJ = (TextView) findViewById(a.f.tv_inter);
        this.ouV = (LinearLayout) findViewById(a.f.ll_rule);
        int i = BdUtilHelper.getScreenSize(activity).widthPixels;
        if (this.ouV != null && this.ouV.getLayoutParams() != null && (layoutParams = this.ouV.getLayoutParams()) != null) {
            layoutParams.width = (i - BdUtilHelper.dip2px(activity, 110.0f)) / 4;
        }
        this.ouK = (TextView) findViewById(a.f.tv_choose);
        this.ouL = (TextView) findViewById(a.f.tv_publish);
        this.ouM = (TextView) findViewById(a.f.tv_confession);
        this.ouN = (TextView) findViewById(a.f.tv_end);
        this.ouO = (TextView) findViewById(a.f.tv_next);
        this.ouP = (LinearLayout) findViewById(a.f.tv_operate);
        this.ouQ = (TextView) findViewById(a.f.tv_start);
        this.ouR = (MarqueeView) findViewById(a.f.tv_progress);
        this.ouR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.ebd();
            }
        });
        this.ouI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.ebd();
            }
        });
        ax(activity);
    }

    private void ax(Activity activity) {
        this.ouT = new c(activity);
        this.ouU = new c(activity);
        this.ouQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.ebg();
            }
        });
        this.ouN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.ebf();
            }
        });
        this.ouO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (DatingNavView.this.ouS) {
                    case 1:
                        DatingNavView.this.ch(DatingNavView.this.ouS, "确认进入 心动选择 环节？");
                        return;
                    case 2:
                        DatingNavView.this.ch(DatingNavView.this.ouS, "确认进入 结果公布 环节？");
                        return;
                    case 3:
                        DatingNavView.this.ch(DatingNavView.this.ouS, "确认进入 祝福时刻 环节？");
                        return;
                    default:
                        return;
                }
            }
        });
        this.ouT.a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.11
            @Override // com.baidu.tieba.yuyinala.liveroom.datingnavigation.c.a
            public void a(DatingStageHttpResponseMessage datingStageHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501032));
                DatingNavView.this.ouQ.setEnabled(true);
                DatingNavView.this.ouO.setEnabled(true);
                a ebh = datingStageHttpResponseMessage.ebh();
                if (ebh != null) {
                    try {
                        DatingNavView.this.ouS = Integer.parseInt(ebh.ova);
                    } catch (Exception e) {
                        DatingNavView.this.ouS = 0;
                    }
                    DatingNavView.this.setMasterStageView(DatingNavView.this.ouS);
                    switch (DatingNavView.this.ouS) {
                        case 1:
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, DatingNavView.this.aDd.aIU.croom_id);
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
                    DatingNavView.this.ouS = 0;
                    DatingNavView.this.setMasterStageView(0);
                } else {
                    BdUtilHelper.showToast(DatingNavView.this.getContext(), "进入下一环节失败，请重试");
                }
                DatingNavView.this.ouQ.setEnabled(true);
                DatingNavView.this.ouO.setEnabled(true);
            }
        });
        this.ouU.a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.12
            @Override // com.baidu.tieba.yuyinala.liveroom.datingnavigation.c.a
            public void a(DatingStageHttpResponseMessage datingStageHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501032));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, DatingNavView.this.aDd.aIU.croom_id);
                    String str = "";
                    switch (DatingNavView.this.ouS) {
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
                DatingNavView.this.ouS = 0;
                DatingNavView.this.ouN.setEnabled(true);
                DatingNavView.this.setMasterStageView(0);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.datingnavigation.c.a
            public void onFail(int i, String str) {
                DatingNavView.this.ouN.setEnabled(true);
                BdUtilHelper.showToast(DatingNavView.this.getContext(), "约会结束失败，请重试");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebd() {
        if (this.aDd != null && this.aDd.aIV != null && !TextUtils.isEmpty(this.aDd.aIV.aTh)) {
            if (this.bgE == null) {
                this.bgE = new com.baidu.live.an.a(this.mActivity);
            }
            com.baidu.live.an.c cVar = new com.baidu.live.an.c();
            cVar.url = this.aDd.aIV.aTh;
            cVar.bWs = 0.5f;
            this.bgE.a(cVar);
        }
    }

    public void f(ab abVar, boolean z) {
        if (abVar != null && abVar.aIY != null) {
            this.aDd = abVar;
            this.ouS = abVar.aIY.getActivityStage();
            if (com.baidu.tieba.yuyinala.liveroom.wheat.e.g.eeO()) {
                setMasterStageView(this.ouS);
            } else {
                j(this.ouS, true, z);
            }
            MessageManager.getInstance().registerListener(this.oux);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMasterStageView(int i) {
        LV(i);
        LW(i);
        this.ouP.setVisibility(0);
    }

    private void ebe() {
        this.ouJ.setBackgroundDrawable(null);
        this.ouJ.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        com.baidu.tieba.yuyinala.liveroom.wheat.e.g.g(this.ouJ, false);
        this.ouK.setBackgroundDrawable(null);
        this.ouK.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        com.baidu.tieba.yuyinala.liveroom.wheat.e.g.g(this.ouK, false);
        this.ouL.setBackgroundDrawable(null);
        this.ouL.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        com.baidu.tieba.yuyinala.liveroom.wheat.e.g.g(this.ouL, false);
        this.ouM.setBackgroundDrawable(null);
        this.ouM.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        com.baidu.tieba.yuyinala.liveroom.wheat.e.g.g(this.ouM, false);
    }

    private void LV(int i) {
        switch (i) {
            case 1:
                ebe();
                this.ouJ.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.ouJ.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                com.baidu.tieba.yuyinala.liveroom.wheat.e.g.g(this.ouJ, true);
                this.ouR.setContent(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.d(this.aDd, 1));
                return;
            case 2:
                ebe();
                this.ouK.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.ouK.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                com.baidu.tieba.yuyinala.liveroom.wheat.e.g.g(this.ouK, true);
                this.ouR.setContent(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.d(this.aDd, 2));
                return;
            case 3:
                ebe();
                this.ouL.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.ouL.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                com.baidu.tieba.yuyinala.liveroom.wheat.e.g.g(this.ouL, true);
                this.ouR.setContent(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.d(this.aDd, 3));
                return;
            case 4:
                ebe();
                this.ouM.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.ouM.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                com.baidu.tieba.yuyinala.liveroom.wheat.e.g.g(this.ouM, true);
                this.ouR.setContent(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.d(this.aDd, 4));
                return;
            default:
                ebe();
                this.ouR.setContent(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.d(this.aDd, 0));
                return;
        }
    }

    public void k(ab abVar) {
        if (abVar != null && abVar.aIY != null) {
            this.aDd = abVar;
            if (com.baidu.tieba.yuyinala.liveroom.wheat.e.g.eeO()) {
                this.ouS = abVar.aIY.getActivityStage();
                setMasterStageView(this.ouS);
                return;
            }
            int activityStage = abVar.aIY.getActivityStage();
            this.ouP.setVisibility(8);
            if (this.ouS == 0 || activityStage != this.ouS) {
                this.ouS = activityStage;
                j(this.ouS, false, true);
            }
        }
    }

    private void j(int i, boolean z, boolean z2) {
        this.ouP.setVisibility(8);
        switch (i) {
            case 1:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "嘉宾互动中" : "约会开始，进入嘉宾互动环节");
                }
                LV(1);
                if (this.aDd != null) {
                    this.aDd.aJm = "";
                    return;
                }
                return;
            case 2:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "心动选择中" : "进入心动选择环节");
                }
                LV(2);
                return;
            case 3:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "结果公布中" : "进入结果公布环节");
                }
                LV(3);
                if (this.aDd != null) {
                    this.aDd.aJm = "";
                    return;
                }
                return;
            case 4:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "甜蜜告白中" : "进入甜蜜告白环节");
                }
                LV(4);
                if (this.aDd != null) {
                    this.aDd.aJm = "";
                    return;
                }
                return;
            default:
                LV(0);
                if (this.aDd != null) {
                    this.aDd.aJm = "";
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(final int i, String str) {
        this.ouW = com.baidu.tieba.yuyinala.liveroom.wheat.e.g.a(this.mActivity, str, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.ouT.m(i + "", "1", com.baidu.tieba.yuyinala.liveroom.wheat.e.g.av(DatingNavView.this.aDd), 0);
                DatingNavView.this.ouO.setEnabled(false);
                DatingNavView.this.ouW = null;
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.ouW = null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebf() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aDd.aIU.croom_id);
            String str = "";
            switch (this.ouS) {
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
        this.ouW = com.baidu.tieba.yuyinala.liveroom.wheat.e.g.a(this.mActivity, "确认结束本轮约会", new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.ouU.m(DatingNavView.this.ouS + "", "2", com.baidu.tieba.yuyinala.liveroom.wheat.e.g.av(DatingNavView.this.aDd), 0);
                DatingNavView.this.ouN.setEnabled(false);
                DatingNavView.this.ouW = null;
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.ouW = null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebg() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aDd.aIU.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "startdating_clk").setContentExt(jSONObject));
        this.ouW = com.baidu.tieba.yuyinala.liveroom.wheat.e.g.a(this.mActivity, "确定开始约会，进入嘉宾互动环节？", new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.ouT.m("0", "1", com.baidu.tieba.yuyinala.liveroom.wheat.e.g.av(DatingNavView.this.aDd), 0);
                DatingNavView.this.ouQ.setEnabled(false);
                DatingNavView.this.ouW = null;
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.ouW = null;
            }
        });
    }

    private void LW(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
                this.ouQ.setVisibility(8);
                this.ouO.setVisibility(0);
                this.ouN.setVisibility(0);
                return;
            case 4:
                this.ouQ.setVisibility(8);
                this.ouO.setVisibility(8);
                this.ouN.setVisibility(0);
                return;
            default:
                this.ouQ.setVisibility(0);
                this.ouN.setVisibility(8);
                this.ouO.setVisibility(8);
                return;
        }
    }
}
