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
    private w aFN;
    private com.baidu.live.ao.a gTT;
    protected Activity mActivity;
    protected LinearLayout omb;
    protected TextView omc;
    protected TextView omd;
    protected TextView ome;
    protected TextView omf;
    protected TextView omg;
    protected TextView omh;
    protected LinearLayout omi;
    protected TextView omj;
    protected MarqueeTextView omk;
    private int oml;
    private d omm;
    private d omn;
    private LinearLayout omo;

    public DatingNavView(Activity activity) {
        super(activity);
        this.oml = 0;
        H(activity);
    }

    protected void H(Activity activity) {
        ViewGroup.LayoutParams layoutParams;
        LayoutInflater.from(activity).inflate(a.g.yuyin_ala_liveroom_dating_nav_layout, this);
        this.mActivity = activity;
        this.omb = (LinearLayout) findViewById(a.f.ll_rule);
        this.omc = (TextView) findViewById(a.f.tv_inter);
        this.omo = (LinearLayout) findViewById(a.f.ll_rule);
        int i = BdUtilHelper.getScreenSize(activity).widthPixels;
        if (this.omo != null && this.omo.getLayoutParams() != null && (layoutParams = this.omo.getLayoutParams()) != null) {
            layoutParams.width = (i - BdUtilHelper.dip2px(activity, 110.0f)) / 4;
        }
        this.omd = (TextView) findViewById(a.f.tv_choose);
        this.ome = (TextView) findViewById(a.f.tv_publish);
        this.omf = (TextView) findViewById(a.f.tv_confession);
        this.omg = (TextView) findViewById(a.f.tv_end);
        this.omh = (TextView) findViewById(a.f.tv_next);
        this.omi = (LinearLayout) findViewById(a.f.tv_operate);
        this.omj = (TextView) findViewById(a.f.tv_start);
        this.omk = (MarqueeTextView) findViewById(a.f.tv_progress);
        this.omk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.edr();
            }
        });
        this.omb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.edr();
            }
        });
        aA(activity);
    }

    private void aA(Activity activity) {
        this.omm = new d(activity);
        this.omn = new d(activity);
        this.omj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.edu();
            }
        });
        this.omg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.edt();
            }
        });
        this.omh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (DatingNavView.this.oml) {
                    case 1:
                        DatingNavView.this.bZ(DatingNavView.this.oml, "确认进入 心动选择 环节？");
                        return;
                    case 2:
                        DatingNavView.this.bZ(DatingNavView.this.oml, "确认进入 结果公布 环节？");
                        return;
                    case 3:
                        DatingNavView.this.bZ(DatingNavView.this.oml, "确认进入 祝福时刻 环节？");
                        return;
                    default:
                        return;
                }
            }
        });
        this.omm.a(new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.7
            @Override // com.baidu.tieba.yuyinala.liveroom.datingnavigation.d.a
            public void a(DatingStageHttpResponseMessage datingStageHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501032));
                DatingNavView.this.omj.setEnabled(true);
                DatingNavView.this.omh.setEnabled(true);
                b edv = datingStageHttpResponseMessage.edv();
                if (edv != null) {
                    try {
                        DatingNavView.this.oml = Integer.parseInt(edv.oms);
                    } catch (Exception e) {
                        DatingNavView.this.oml = 0;
                    }
                    DatingNavView.this.setMasterStageView(DatingNavView.this.oml);
                    switch (DatingNavView.this.oml) {
                        case 1:
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, DatingNavView.this.aFN.aKL.croom_id);
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
                    DatingNavView.this.oml = 0;
                    DatingNavView.this.setMasterStageView(0);
                } else {
                    BdUtilHelper.showToast(DatingNavView.this.getContext(), "进入下一环节失败，请重试");
                }
                DatingNavView.this.omj.setEnabled(true);
                DatingNavView.this.omh.setEnabled(true);
            }
        });
        this.omn.a(new d.a() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.8
            @Override // com.baidu.tieba.yuyinala.liveroom.datingnavigation.d.a
            public void a(DatingStageHttpResponseMessage datingStageHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501032));
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, DatingNavView.this.aFN.aKL.croom_id);
                    String str = "";
                    switch (DatingNavView.this.oml) {
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
                DatingNavView.this.oml = 0;
                DatingNavView.this.omg.setEnabled(true);
                DatingNavView.this.setMasterStageView(0);
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.datingnavigation.d.a
            public void onFail(int i, String str) {
                DatingNavView.this.omg.setEnabled(true);
                BdUtilHelper.showToast(DatingNavView.this.getContext(), "约会结束失败，请重试");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edr() {
        if (this.aFN != null && this.aFN.aKM != null && !TextUtils.isEmpty(this.aFN.aKM.aTT)) {
            if (this.gTT == null) {
                this.gTT = new com.baidu.live.ao.a(this.mActivity);
            }
            com.baidu.live.ao.c cVar = new com.baidu.live.ao.c();
            cVar.url = this.aFN.aKM.aTT;
            cVar.bRy = 0.5f;
            this.gTT.a(cVar);
        }
    }

    public void destory() {
        this.oml = 0;
    }

    public void e(w wVar, boolean z) {
        if (wVar != null && wVar.aKQ != null) {
            this.aFN = wVar;
            this.oml = wVar.aKQ.getActivityStage();
            if (g.efZ()) {
                setMasterStageView(this.oml);
            } else {
                j(this.oml, true, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMasterStageView(int i) {
        Nu(i);
        Nv(i);
        this.omi.setVisibility(0);
    }

    private void eds() {
        this.omc.setBackgroundDrawable(null);
        this.omc.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        g.f(this.omc, false);
        this.omd.setBackgroundDrawable(null);
        this.omd.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        g.f(this.omd, false);
        this.ome.setBackgroundDrawable(null);
        this.ome.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        g.f(this.ome, false);
        this.omf.setBackgroundDrawable(null);
        this.omf.setTextColor(getResources().getColor(a.c.sdk_white_alpha80));
        g.f(this.omf, false);
    }

    private void Nu(int i) {
        switch (i) {
            case 1:
                eds();
                this.omc.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.omc.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                g.f(this.omc, true);
                this.omk.setScrollText(g.d(this.aFN, 1));
                return;
            case 2:
                eds();
                this.omd.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.omd.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                g.f(this.omd, true);
                this.omk.setScrollText(g.d(this.aFN, 2));
                return;
            case 3:
                eds();
                this.ome.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.ome.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                g.f(this.ome, true);
                this.omk.setScrollText(g.d(this.aFN, 3));
                return;
            case 4:
                eds();
                this.omf.setBackgroundResource(a.e.shape_yuin_dating_nav_select_bg);
                this.omf.setTextColor(getResources().getColor(a.c.sdk_color_FF51B3_alpha20));
                g.f(this.omf, true);
                this.omk.setScrollText(g.d(this.aFN, 4));
                return;
            default:
                eds();
                this.omk.setScrollText(g.d(this.aFN, 0));
                return;
        }
    }

    public void j(w wVar) {
        if (wVar != null && wVar.aKQ != null) {
            this.aFN = wVar;
            if (g.efZ()) {
                this.oml = wVar.aKQ.getActivityStage();
                setMasterStageView(this.oml);
                return;
            }
            int activityStage = wVar.aKQ.getActivityStage();
            this.omi.setVisibility(8);
            if (this.oml == 0 || activityStage != this.oml) {
                this.oml = activityStage;
                j(this.oml, false, true);
            }
        }
    }

    private void j(int i, boolean z, boolean z2) {
        this.omi.setVisibility(8);
        switch (i) {
            case 1:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "嘉宾互动中" : "约会开始，进入嘉宾互动环节");
                }
                Nu(1);
                if (this.aFN != null) {
                    this.aFN.aLb = "";
                    return;
                }
                return;
            case 2:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "心动选择中" : "进入心动选择环节");
                }
                Nu(2);
                return;
            case 3:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "结果公布中" : "进入结果公布环节");
                }
                Nu(3);
                if (this.aFN != null) {
                    this.aFN.aLb = "";
                    return;
                }
                return;
            case 4:
                if (z2) {
                    BdUtilHelper.showToast(getContext(), z ? "甜蜜告白中" : "进入甜蜜告白环节");
                }
                Nu(4);
                if (this.aFN != null) {
                    this.aFN.aLb = "";
                    return;
                }
                return;
            default:
                Nu(0);
                if (this.aFN != null) {
                    this.aFN.aLb = "";
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZ(final int i, String str) {
        g.a(this.mActivity, str, new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.omm.h(i + "", "1", g.ar(DatingNavView.this.aFN), 0);
                DatingNavView.this.omh.setEnabled(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aFN.aKL.croom_id);
            String str = "";
            switch (this.oml) {
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
                DatingNavView.this.omn.h(DatingNavView.this.oml + "", "2", g.ar(DatingNavView.this.aFN), 0);
                DatingNavView.this.omg.setEnabled(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edu() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.aFN.aKL.croom_id);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "startdating_clk").setContentExt(jSONObject));
        g.a(this.mActivity, "确定开始约会，进入嘉宾互动环节？", new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.datingnavigation.DatingNavView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DatingNavView.this.omm.h("0", "1", g.ar(DatingNavView.this.aFN), 0);
                DatingNavView.this.omj.setEnabled(false);
            }
        });
    }

    private void Nv(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
                this.omj.setVisibility(8);
                this.omh.setVisibility(0);
                this.omg.setVisibility(0);
                return;
            case 4:
                this.omj.setVisibility(8);
                this.omh.setVisibility(8);
                this.omg.setVisibility(0);
                return;
            default:
                this.omj.setVisibility(0);
                this.omg.setVisibility(8);
                this.omh.setVisibility(8);
                return;
        }
    }
}
