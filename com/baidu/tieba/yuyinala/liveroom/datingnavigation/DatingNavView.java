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
    public CustomMessageListener otW;
    protected LinearLayout ouh;
    protected TextView oui;
    protected TextView ouj;
    protected TextView ouk;
    protected TextView oul;
    protected TextView oum;
    protected TextView oun;
    protected LinearLayout ouo;
    protected TextView oup;
    protected MarqueeView ouq;
    private int our;
    private c ous;
    private c ouu;
    private LinearLayout ouv;
    private g ouw;

    public DatingNavView(Activity activity) {
        super(activity);
        this.our = 0;
        this.otW = new CustomMessageListener(2501014) { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501014 && (customResponsedMessage.getData() instanceof com.baidu.live.data.g) && ((com.baidu.live.data.g) customResponsedMessage.getData()).Bm() != 1) {
                    if (DatingNavView.this.ouw != null && DatingNavView.this.ouw.isShowing()) {
                        DatingNavView.this.ouw.dismiss();
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
        this.ouh = (LinearLayout) findViewById(a.f.ll_rule);
        this.oui = (TextView) findViewById(a.f.tv_inter);
        this.ouv = (LinearLayout) findViewById(a.f.ll_rule);
        int i = BdUtilHelper.getScreenSize(activity).widthPixels;
        if (this.ouv != null && this.ouv.getLayoutParams() != null && (layoutParams = this.ouv.getLayoutParams()) != null) {
            layoutParams.width = (i - BdUtilHelper.dip2px(activity, 110.0f)) / 4;
        }
        this.ouj = (TextView) findViewById(a.f.tv_choose);
        this.ouk = (TextView) findViewById(a.f.tv_publish);
        this.oul = (TextView) findViewById(a.f.tv_confession);
        this.oum = (TextView) findViewById(a.f.tv_end);
        this.oun = (TextView) findViewById(a.f.tv_next);
        this.ouo = (LinearLayout) findViewById(a.f.tv_operate);
        this.oup = (TextView) findViewById(a.f.tv_start);
        this.ouq = (MarqueeView) findViewById(a.f.tv_progress);
        this.ouq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.eaV();
            }
        });
        this.ouh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.eaV();
            }
        });
        ax(activity);
    }

    private void ax(Activity activity) {
        this.ous = new c(activity);
        this.ouu = new c(activity);
        this.oup.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.eaY();
            }
        });
        this.oum.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.eaX();
            }
        });
        this.oun.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (DatingNavView.this.our) {
                    case 1:
                        DatingNavView.this.ch(DatingNavView.this.our, "确认进入 心动选择 环节？");
                        return;
                    case 2:
                        DatingNavView.this.ch(DatingNavView.this.our, "确认进入 结果公布 环节？");
                        return;
                    case 3:
                        DatingNavView.this.ch(DatingNavView.this.our, "确认进入 祝福时刻 环节？");
                        return;
                    default:
                        return;
                }
            }
        });
        this.ous.a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.11
            @Override // com.baidu.tieba.yuyinala.liveroom.datingnavigation.c.a
            public void a(DatingStageHttpResponseMessage datingStageHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501032));
                DatingNavView.this.oup.setEnabled(true);
                DatingNavView.this.oun.setEnabled(true);
                a eaZ = datingStageHttpResponseMessage.eaZ();
                if (eaZ != null) {
                    try {
                        DatingNavView.this.our = Integer.parseInt(eaZ.ouA);
                    } catch (Exception e) {
                        DatingNavView.this.our = 0;
                    }
                    DatingNavView.this.setMasterStageView(DatingNavView.this.our);
                    switch (DatingNavView.this.our) {
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
                    DatingNavView.this.our = 0;
                    DatingNavView.this.setMasterStageView(0);
                } else {
                    BdUtilHelper.showToast(DatingNavView.this.getContext(), "进入下一环节失败，请重试");
                }
                DatingNavView.this.oup.setEnabled(true);
                DatingNavView.this.oun.setEnabled(true);
            }
        });
        this.ouu.a(new c.a() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.12
            @Override // com.baidu.tieba.yuyinala.liveroom.datingnavigation.c.a
            public void a(DatingStageHttpResponseMessage datingStageHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501032));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, DatingNavView.this.aDd.aIU.croom_id);
                    String str = "";
                    switch (DatingNavView.this.our) {
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
                DatingNavView.this.our = 0;
                DatingNavView.this.oum.setEnabled(true);
                DatingNavView.this.setMasterStageView(0);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.datingnavigation.c.a
            public void onFail(int i, String str) {
                DatingNavView.this.oum.setEnabled(true);
                BdUtilHelper.showToast(DatingNavView.this.getContext(), "约会结束失败，请重试");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaV() {
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
            this.our = abVar.aIY.getActivityStage();
            if (com.baidu.tieba.yuyinala.liveroom.wheat.e.g.eeG()) {
                setMasterStageView(this.our);
            } else {
                j(this.our, true, z);
            }
            MessageManager.getInstance().registerListener(this.otW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMasterStageView(int i) {
        LU(i);
        LV(i);
        this.ouo.setVisibility(0);
    }

    private void eaW() {
        this.oui.setBackgroundDrawable(null);
        this.oui.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        com.baidu.tieba.yuyinala.liveroom.wheat.e.g.g(this.oui, false);
        this.ouj.setBackgroundDrawable(null);
        this.ouj.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        com.baidu.tieba.yuyinala.liveroom.wheat.e.g.g(this.ouj, false);
        this.ouk.setBackgroundDrawable(null);
        this.ouk.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        com.baidu.tieba.yuyinala.liveroom.wheat.e.g.g(this.ouk, false);
        this.oul.setBackgroundDrawable(null);
        this.oul.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        com.baidu.tieba.yuyinala.liveroom.wheat.e.g.g(this.oul, false);
    }

    private void LU(int i) {
        switch (i) {
            case 1:
                eaW();
                this.oui.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.oui.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                com.baidu.tieba.yuyinala.liveroom.wheat.e.g.g(this.oui, true);
                this.ouq.setContent(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.d(this.aDd, 1));
                return;
            case 2:
                eaW();
                this.ouj.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.ouj.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                com.baidu.tieba.yuyinala.liveroom.wheat.e.g.g(this.ouj, true);
                this.ouq.setContent(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.d(this.aDd, 2));
                return;
            case 3:
                eaW();
                this.ouk.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.ouk.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                com.baidu.tieba.yuyinala.liveroom.wheat.e.g.g(this.ouk, true);
                this.ouq.setContent(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.d(this.aDd, 3));
                return;
            case 4:
                eaW();
                this.oul.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.oul.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                com.baidu.tieba.yuyinala.liveroom.wheat.e.g.g(this.oul, true);
                this.ouq.setContent(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.d(this.aDd, 4));
                return;
            default:
                eaW();
                this.ouq.setContent(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.d(this.aDd, 0));
                return;
        }
    }

    public void k(ab abVar) {
        if (abVar != null && abVar.aIY != null) {
            this.aDd = abVar;
            if (com.baidu.tieba.yuyinala.liveroom.wheat.e.g.eeG()) {
                this.our = abVar.aIY.getActivityStage();
                setMasterStageView(this.our);
                return;
            }
            int activityStage = abVar.aIY.getActivityStage();
            this.ouo.setVisibility(8);
            if (this.our == 0 || activityStage != this.our) {
                this.our = activityStage;
                j(this.our, false, true);
            }
        }
    }

    private void j(int i, boolean z, boolean z2) {
        this.ouo.setVisibility(8);
        switch (i) {
            case 1:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "嘉宾互动中" : "约会开始，进入嘉宾互动环节");
                }
                LU(1);
                if (this.aDd != null) {
                    this.aDd.aJm = "";
                    return;
                }
                return;
            case 2:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "心动选择中" : "进入心动选择环节");
                }
                LU(2);
                return;
            case 3:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "结果公布中" : "进入结果公布环节");
                }
                LU(3);
                if (this.aDd != null) {
                    this.aDd.aJm = "";
                    return;
                }
                return;
            case 4:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "甜蜜告白中" : "进入甜蜜告白环节");
                }
                LU(4);
                if (this.aDd != null) {
                    this.aDd.aJm = "";
                    return;
                }
                return;
            default:
                LU(0);
                if (this.aDd != null) {
                    this.aDd.aJm = "";
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(final int i, String str) {
        this.ouw = com.baidu.tieba.yuyinala.liveroom.wheat.e.g.a(this.mActivity, str, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.ous.m(i + "", "1", com.baidu.tieba.yuyinala.liveroom.wheat.e.g.av(DatingNavView.this.aDd), 0);
                DatingNavView.this.oun.setEnabled(false);
                DatingNavView.this.ouw = null;
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.ouw = null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaX() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aDd.aIU.croom_id);
            String str = "";
            switch (this.our) {
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
        this.ouw = com.baidu.tieba.yuyinala.liveroom.wheat.e.g.a(this.mActivity, "确认结束本轮约会", new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.ouu.m(DatingNavView.this.our + "", "2", com.baidu.tieba.yuyinala.liveroom.wheat.e.g.av(DatingNavView.this.aDd), 0);
                DatingNavView.this.oum.setEnabled(false);
                DatingNavView.this.ouw = null;
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.ouw = null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaY() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aDd.aIU.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "startdating_clk").setContentExt(jSONObject));
        this.ouw = com.baidu.tieba.yuyinala.liveroom.wheat.e.g.a(this.mActivity, "确定开始约会，进入嘉宾互动环节？", new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.ous.m("0", "1", com.baidu.tieba.yuyinala.liveroom.wheat.e.g.av(DatingNavView.this.aDd), 0);
                DatingNavView.this.oup.setEnabled(false);
                DatingNavView.this.ouw = null;
            }
        }, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.ouw = null;
            }
        });
    }

    private void LV(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
                this.oup.setVisibility(8);
                this.oun.setVisibility(0);
                this.oum.setVisibility(0);
                return;
            case 4:
                this.oup.setVisibility(8);
                this.oun.setVisibility(8);
                this.oum.setVisibility(0);
                return;
            default:
                this.oup.setVisibility(0);
                this.oum.setVisibility(8);
                this.oun.setVisibility(8);
                return;
        }
    }
}
