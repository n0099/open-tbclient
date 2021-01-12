package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.db;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.dialog.BdToast;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.live.utils.u;
import com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.TimeSettingResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.b;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLoadingToastView;
import com.baidu.tieba.yuyinala.liveroom.wheat.a.c;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.o;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.e.e;
import com.baidu.tieba.yuyinala.liveroom.wheat.message.AddTimeHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.wheat.model.b;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.AddTimeEndGameView;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class TeamFightLayout extends BaseWheatLayout {
    public int Yl;
    private int activity_stage;
    private AddTimeEndGameView oBm;
    private TBLottieAnimationView oBn;
    private TBLottieAnimationView oBo;
    private TBLottieAnimationView oBp;
    private TBLottieAnimationView oBq;
    private ImageView oBr;
    private g oBs;
    private AlaLoadingToastView oBt;
    private int oBu;
    private int oBv;
    private int oBw;
    private long oBx;
    private long oBy;
    private String oiU;
    public CustomMessageListener okc;

    public TeamFightLayout(@NonNull Context context) {
        this(context, null);
    }

    public TeamFightLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TeamFightLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oBu = 1;
        this.oBv = 1;
        this.Yl = e.d(94.0f, getContext());
        this.okc = new CustomMessageListener(2501014) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501014 && (customResponsedMessage.getData() instanceof com.baidu.live.data.g) && ((com.baidu.live.data.g) customResponsedMessage.getData()).AC() != 2 && TeamFightLayout.this.oBs != null && TeamFightLayout.this.oBs.isShowing()) {
                    TeamFightLayout.this.oBs.dismiss();
                }
            }
        };
        if (UtilHelper.getStatusBarHeight() > 0) {
            this.Yl = UtilHelper.getStatusBarHeight() + e.d(68.0f, getContext());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout
    public synchronized void a(final List<AlaWheatInfoData> list, final List<AlaWheatInfoData> list2, final x xVar) {
        super.a(list, list2, xVar);
        this.mView.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.1
            @Override // java.lang.Runnable
            public void run() {
                TeamFightLayout.this.ozw = list;
                TeamFightLayout.this.ozx = list2;
                if (ListUtils.getCount(TeamFightLayout.this.oAy) == 0 || ListUtils.getCount(TeamFightLayout.this.oAy) != ListUtils.getCount(list) || ListUtils.getCount(TeamFightLayout.this.oAz) == 0 || ListUtils.getCount(TeamFightLayout.this.oAz) != ListUtils.getCount(list2)) {
                    TeamFightLayout.this.ecx();
                    TeamFightLayout.this.oAD.removeAllViews();
                    TeamFightLayout.this.oAy.clear();
                    TeamFightLayout.this.oAz.clear();
                    TeamFightLayout.this.ecP();
                    TeamFightLayout.this.ecO();
                    TeamFightLayout.this.ecN();
                    if (!ListUtils.isEmpty(list)) {
                        for (int i = 0; i < list.size(); i++) {
                            TeamFightLayout.this.a(TeamFightLayout.this.an(0, true), true);
                        }
                    }
                    if (!ListUtils.isEmpty(list2)) {
                        for (int i2 = 0; i2 < ListUtils.getCount(list2); i2++) {
                            TeamFightLayout.this.a(TeamFightLayout.this.an(i2, false), false);
                        }
                    }
                    TeamFightLayout.this.ecM();
                    TeamFightLayout.this.oAD.invalidate();
                    TeamFightLayout.this.oAD.requestLayout();
                }
                if (!ListUtils.isEmpty(TeamFightLayout.this.oAy)) {
                    for (int i3 = 0; i3 < TeamFightLayout.this.oAy.size(); i3++) {
                        TeamFightLayout.this.oAy.get(i3).setData(TeamFightLayout.this.am(i3, true), i3, true, xVar);
                    }
                }
                if (!ListUtils.isEmpty(TeamFightLayout.this.oAz)) {
                    for (int i4 = 0; i4 < TeamFightLayout.this.oAz.size(); i4++) {
                        TeamFightLayout.this.oAz.get(i4).setData(TeamFightLayout.this.am(i4, false), i4, false, xVar);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecM() {
        this.oBt = new AlaLoadingToastView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.oBt.setLayoutParams(layoutParams);
        ViewGroup viewGroup = null;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            viewGroup = (ViewGroup) this.mTbPageContext.getPageActivity().findViewById(a.f.ala_liveroom_view);
        }
        if (viewGroup != null) {
            u.a(viewGroup, this.oBt, 650);
        } else {
            this.oAD.addView(this.oBt);
        }
        this.oBt.setVisibility(8);
        this.oBt.setContent(getContext().getResources().getString(a.h.yuyin_ala_settlement_text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecN() {
        this.oBm = new AddTimeEndGameView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.rightMargin = e.d(10.0f, getContext());
        layoutParams.topMargin = this.Yl + e.d(19.0f, getContext());
        this.oBm.setLayoutParams(layoutParams);
        this.oBm.setListener(new AddTimeEndGameView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.AddTimeEndGameView.a
            public void ect() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, o.ebo().WA().aGy.croom_id);
                    jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "timeset");
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "startbattle_clk").setContentExt(jSONObject));
                new com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a(TeamFightLayout.this.mTbPageContext.getPageActivity()).ac(o.ebo().WA());
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.AddTimeEndGameView.a
            public void ecu() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, o.ebo().WA().aGy.croom_id);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "overtime_clk").setContentExt(jSONObject));
                TeamFightLayout.this.ecu();
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.AddTimeEndGameView.a
            public void ecv() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, o.ebo().WA().aGy.croom_id);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "endbattle_clk").setContentExt(jSONObject));
                TeamFightLayout.this.ecQ();
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.AddTimeEndGameView.a
            public void ecw() {
                TeamFightLayout.this.ecw();
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.AddTimeEndGameView.a
            public int Mf(int i) {
                return TeamFightLayout.this.Mf(i);
            }
        });
        this.oAD.addView(this.oBm);
        this.oBm.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecO() {
        int i;
        int i2;
        int i3;
        int i4;
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] >= (this.oAB * 4) + e.d(14.0f, getContext())) {
            i = (int) ((((screenFullSize[0] - (e.d(7.0f, getContext()) * 2)) * 1.0d) * 1101.0d) / 2400.0d);
            i2 = (int) (e.d(7.0f, getContext()) + (((screenFullSize[0] - (e.d(7.0f, getContext()) * 2)) * 41.0d) / 1200.0d));
            i3 = (int) (((screenFullSize[0] - (e.d(7.0f, getContext()) * 2)) * 11.5d) / 1200.0d);
            i4 = (int) ((((screenFullSize[0] - e.d(14.0f, getContext())) * 72) * 1.0d) / 120.0d);
        } else {
            i = (int) (((screenFullSize[0] * 1.0d) * 1101.0d) / 2400.0d);
            i2 = (int) ((screenFullSize[0] * 41.0d) / 1200.0d);
            i3 = (int) ((screenFullSize[0] * 11.5d) / 1200.0d);
            i4 = (int) (((screenFullSize[0] * 72) * 1.0d) / 120.0d);
        }
        this.oBn = new TBLottieAnimationView(getContext());
        this.oBn.setImageAssetsFolder("lottie/yuyin_connection_wheat_red_safety_mask/");
        this.oBn.setAnimation("lottie/yuyin_connection_wheat_red_safety_mask.json");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i4);
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = this.Yl + this.oAC + e.d(70.0f, getContext());
        this.oBn.setLayoutParams(layoutParams);
        this.oAD.addView(this.oBn);
        this.oBo = new TBLottieAnimationView(getContext());
        this.oBo.setImageAssetsFolder("lottie/yuyin_connection_wheat_red_advantage/");
        this.oBo.setAnimation("lottie/yuyin_connection_wheat_red_advantage.json");
        this.oBo.setRepeatMode(1);
        this.oBo.setRepeatCount(-1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i4);
        layoutParams2.leftMargin = i2;
        layoutParams2.topMargin = this.Yl + this.oAC + e.d(70.0f, getContext());
        this.oBo.setLayoutParams(layoutParams2);
        this.oAD.addView(this.oBo);
        this.oBp = new TBLottieAnimationView(getContext());
        this.oBp.setImageAssetsFolder("lottie/yuyin_connection_wheat_blue_safety_mask/");
        this.oBp.setAnimation("lottie/yuyin_connection_wheat_blue_safety_mask.json");
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i, i4);
        layoutParams3.topMargin = this.Yl + this.oAC + e.d(70.0f, getContext());
        layoutParams3.leftMargin = (screenFullSize[0] / 2) + i3;
        this.oBp.setLayoutParams(layoutParams3);
        this.oAD.addView(this.oBp);
        this.oBq = new TBLottieAnimationView(getContext());
        this.oBq.setImageAssetsFolder("lottie/yuyin_connection_wheat_blue_advantage/");
        this.oBq.setAnimation("lottie/yuyin_connection_wheat_blue_advantage.json");
        this.oBq.setRepeatMode(1);
        this.oBq.setRepeatCount(-1);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(i, i4);
        layoutParams4.leftMargin = (screenFullSize[0] / 2) + i3;
        layoutParams4.topMargin = this.Yl + this.oAC + e.d(70.0f, getContext());
        this.oBq.setLayoutParams(layoutParams4);
        this.oAD.addView(this.oBq);
    }

    public void Mh(int i) {
        if (i == 0) {
            if (this.oBn != null) {
                this.oBn.setVisibility(0);
                this.oBn.playAnimation();
            }
        } else if (i == 1) {
            if (this.oBo != null) {
                this.oBo.setVisibility(0);
                this.oBo.playAnimation();
            }
        } else if (i == 2) {
            if (this.oBp != null) {
                this.oBp.setVisibility(0);
                this.oBp.playAnimation();
            }
        } else if (i == 3 && this.oBq != null) {
            this.oBq.setVisibility(0);
            this.oBq.playAnimation();
        }
    }

    public void Mi(int i) {
        if (i == 0) {
            if (this.oBn != null) {
                this.oBn.setVisibility(8);
                this.oBn.pauseAnimation();
            }
        } else if (i == 1) {
            if (this.oBo != null) {
                this.oBo.setVisibility(8);
                this.oBo.pauseAnimation();
            }
        } else if (i == 2) {
            if (this.oBp != null) {
                this.oBp.setVisibility(8);
                this.oBp.pauseAnimation();
            }
        } else if (i == 3 && this.oBq != null) {
            this.oBq.setVisibility(8);
            this.oBq.pauseAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecP() {
        int i;
        this.oBr = new ImageView(getContext());
        int d = e.d(228.0f, getContext());
        if (this.mTbPageContext == null || this.mTbPageContext.getPageActivity() == null) {
            i = 0;
        } else {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
            if (screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] >= (this.oAB * 4) + e.d(14.0f, getContext())) {
                i = e.d(7.0f, getContext());
                d = (int) ((((screenFullSize[0] - e.d(14.0f, getContext())) * 72) * 1.0d) / 120.0d);
            } else {
                d = (int) (((screenFullSize[0] * 72) * 1.0d) / 120.0d);
                i = 0;
            }
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, d);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.Yl + this.oAC + e.d(70.0f, getContext());
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        this.oBr.setLayoutParams(layoutParams);
        this.oBr.setBackgroundResource(a.e.yuyin_audio_wheat_team_fight_bg);
        this.oAD.addView(this.oBr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] an(int i, boolean z) {
        int[] iArr = new int[2];
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (z) {
            iArr[0] = (screenFullSize[0] / 2) - (this.oAB / 2);
            iArr[1] = this.Yl;
        } else {
            int d = ((this.mTbPageContext == null || this.mTbPageContext.getPageActivity() == null) && screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] >= (this.oAB * 4) + e.d(5.0f, getContext())) ? e.d(5.0f, getContext()) : 0;
            if (i == 0) {
                iArr[0] = (((screenFullSize[0] / 2) - this.oAB) - this.oAB) - d;
                iArr[1] = this.Yl + this.oAC + e.d(75.0f, getContext());
            } else if (i == 1) {
                iArr[0] = ((screenFullSize[0] / 2) - this.oAB) - d;
                iArr[1] = this.Yl + this.oAC + e.d(75.0f, getContext());
            } else if (i == 2) {
                iArr[0] = (((screenFullSize[0] / 2) - this.oAB) - this.oAB) - d;
                iArr[1] = this.Yl + this.oAC + e.d(75.0f, getContext()) + this.oAC;
            } else if (i == 3) {
                iArr[0] = ((screenFullSize[0] / 2) - this.oAB) - d;
                iArr[1] = this.Yl + this.oAC + e.d(75.0f, getContext()) + this.oAC;
            } else if (i == 4) {
                iArr[0] = d + (screenFullSize[0] / 2);
                iArr[1] = this.Yl + this.oAC + e.d(75.0f, getContext());
            } else if (i == 5) {
                iArr[0] = d + (screenFullSize[0] / 2) + this.oAB;
                iArr[1] = this.Yl + this.oAC + e.d(75.0f, getContext());
            } else if (i == 6) {
                iArr[0] = d + (screenFullSize[0] / 2);
                iArr[1] = this.Yl + this.oAC + e.d(75.0f, getContext()) + this.oAC;
            } else if (i == 7) {
                iArr[0] = d + (screenFullSize[0] / 2) + this.oAB;
                iArr[1] = this.Yl + this.oAC + e.d(75.0f, getContext()) + this.oAC;
            } else {
                iArr[1] = 0;
                iArr[0] = 0;
            }
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int[] iArr, boolean z) {
        WheatItemView wheatItemView = new WheatItemView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.oAB, this.oAC);
        layoutParams.leftMargin = iArr[0];
        layoutParams.topMargin = iArr[1];
        wheatItemView.setLayoutParams(layoutParams);
        this.oAD.addView(wheatItemView);
        wheatItemView.setOnItemClickListener(this.oAx);
        if (z) {
            this.oAy.add(wheatItemView);
        } else {
            this.oAz.add(wheatItemView);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ecT();
        MessageManager.getInstance().registerListener(this.okc);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.okc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecu() {
        b bVar = new b(null, new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.3
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.b.a
            public void a(AddTimeHttpResponseMessage addTimeHttpResponseMessage) {
                BdToast.makeText(TeamFightLayout.this.getContext(), String.format(TeamFightLayout.this.getContext().getString(a.h.yuyin_ala_add_time_toast_text), Integer.valueOf(TeamFightLayout.this.Mf(TeamFightLayout.this.activity_stage)))).show();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501082, null));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.b.a
            public void onFail(int i, String str) {
            }
        });
        x WA = c.eax().WA();
        if (WA != null && WA.aGz != null) {
            bVar.A(c.eax().eaz().getRoomId(), WA.aGz.mStep, Mf(this.activity_stage));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecw() {
        this.oBw = 1;
        this.oBs = new g(this.mTbPageContext);
        this.oBs.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.4
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
            public void onCancel() {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
            public void onConfirm() {
                TeamFightLayout.this.dM(1, 1);
            }
        });
        this.oBs.show();
        this.oBs.setText(getContext().getResources().getString(a.h.yuyin_ala_punish_team_fight_text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecQ() {
        this.oBw = 3;
        this.oBs = new g(this.mTbPageContext);
        this.oBs.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
            public void onCancel() {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
            public void onConfirm() {
                TeamFightLayout.this.dM(3, 1);
            }
        });
        this.oBs.show();
        this.oBs.setText(getContext().getResources().getString(a.h.yuyin_ala_end_team_fight_text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dM(final int i, int i2) {
        com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.b bVar = new com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.b(this.mTbPageContext.getPageActivity());
        bVar.A(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.av(o.ebo().WA()), i, i2);
        bVar.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.6
            @Override // com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.b.a
            public void a(TimeSettingResponseMessage timeSettingResponseMessage) {
                if (i == 1) {
                    BdToast.makeText(TeamFightLayout.this.getContext(), TeamFightLayout.this.getContext().getResources().getString(a.h.yuyin_ala_end_team_fighting_text)).show();
                } else if (i == 3) {
                    BdToast.makeText(TeamFightLayout.this.getContext(), TeamFightLayout.this.getContext().getResources().getString(a.h.yuyin_ala_end_punishing_text)).show();
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.b.a
            public void onFail(int i3, String str) {
                BdToast.makeText(TeamFightLayout.this.getContext(), TeamFightLayout.this.getContext().getResources().getString(a.h.yuyin_ala_end_error_text));
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout
    public int getWheatHeight() {
        return this.Yl + this.oAC + e.d(298.0f, getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Mf(int i) {
        x WA;
        db dbVar;
        int i2;
        db dbVar2;
        if (i == 1) {
            x WA2 = c.eax().WA();
            if (WA2 == null || (dbVar2 = (db) ListUtils.getItem(WA2.aGT, WA2.aGD.getRoomMode())) == null) {
                i2 = 5;
            } else {
                i2 = dbVar2.aQv;
            }
            return i2;
        } else if (i != 3 || (WA = c.eax().WA()) == null || WA.aGz == null || WA.aGD == null || (dbVar = (db) ListUtils.getItem(WA.aGT, WA.aGD.getRoomMode())) == null) {
            return 5;
        } else {
            return dbVar.aQA;
        }
    }

    public void setTeamFightProgressData(String str) {
        JSONObject optJSONObject;
        if (this.oBo == null || this.oBq == null) {
            return;
        }
        if (this.oBn != null || this.oBp != null) {
            if (TextUtils.isEmpty(str)) {
                ecT();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                    this.activity_stage = optJSONObject.optInt("activity_stage");
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("pk_value");
                    this.oiU = optJSONObject.optString("pk_winner");
                    if (optJSONObject2 != null) {
                        long parseLong = Long.parseLong(optJSONObject2.optString("a"));
                        long parseLong2 = Long.parseLong(optJSONObject2.optString(com.baidu.pass.biometrics.face.liveness.d.b.f4043a));
                        if (this.activity_stage == 1 && (parseLong != 0 || parseLong2 != 0)) {
                            if (parseLong == parseLong2) {
                                if (!this.oBo.isAnimating() && !this.oBq.isAnimating()) {
                                    Mh(1);
                                }
                            } else if (parseLong > parseLong2) {
                                if (!this.oBo.isAnimating()) {
                                    Mh(1);
                                }
                                Mi(3);
                            } else {
                                if (!this.oBq.isAnimating()) {
                                    Mh(3);
                                }
                                Mi(1);
                            }
                            if (parseLong > this.oBx) {
                                Mh(0);
                            }
                            if (parseLong2 > this.oBy) {
                                Mh(2);
                            }
                            this.oBx = parseLong;
                            this.oBy = parseLong2;
                        } else {
                            this.oBx = 0L;
                            this.oBy = 0L;
                            ecT();
                        }
                        ecR();
                        ecS();
                        if (this.oBm != null) {
                            if (o.ebo().id(o.ebo().Wz())) {
                                this.oBm.setVisibility(0);
                                this.oBm.setButtonState(this.activity_stage);
                            } else {
                                this.oBm.setVisibility(8);
                            }
                        }
                        if (this.oBt != null) {
                            this.oBt.setVisibility(this.activity_stage != 2 ? 8 : 0);
                        }
                        if (this.oBs != null && this.oBs.isShowing() && this.oBw != this.activity_stage) {
                            this.oBs.dismiss();
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void ecR() {
        if (this.oBu == 0 && this.activity_stage == 1) {
            this.oBu = 1;
            View findViewById = (this.mTbPageContext == null || this.mTbPageContext.getPageActivity() == null) ? null : this.mTbPageContext.getPageActivity().findViewById(a.f.ala_liveroom_view);
            if (findViewById != null) {
                com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.ebS().b((ViewGroup) findViewById, null);
            }
        } else if (this.activity_stage == 0) {
            this.oBu = 0;
        }
    }

    private void ecS() {
        if (this.oBv == 0 && this.activity_stage == 3) {
            this.oBv = 1;
            View findViewById = (this.mTbPageContext == null || this.mTbPageContext.getPageActivity() == null) ? null : this.mTbPageContext.getPageActivity().findViewById(a.f.ala_liveroom_view);
            if (findViewById != null) {
                if ("a".equals(this.oiU)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.ebS().c((ViewGroup) findViewById, null);
                } else if (com.baidu.pass.biometrics.face.liveness.d.b.f4043a.equals(this.oiU)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.ebS().d((ViewGroup) findViewById, null);
                }
            }
        } else if (this.activity_stage == 0 || this.activity_stage == 1 || this.activity_stage == 2) {
            this.oBv = 0;
        }
    }

    private void ecT() {
        if (this.oBn != null) {
            this.oBn.setVisibility(8);
            this.oBn.pauseAnimation();
        }
        if (this.oBo != null) {
            this.oBo.setVisibility(8);
            this.oBo.pauseAnimation();
        }
        if (this.oBp != null) {
            this.oBp.setVisibility(8);
            this.oBp.pauseAnimation();
        }
        if (this.oBq != null) {
            this.oBq.setVisibility(8);
            this.oBq.pauseAnimation();
        }
    }
}
