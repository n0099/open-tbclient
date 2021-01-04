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
/* loaded from: classes11.dex */
public class TeamFightLayout extends BaseWheatLayout {
    public int Yn;
    private int activity_stage;
    private AddTimeEndGameView oFS;
    private TBLottieAnimationView oFT;
    private TBLottieAnimationView oFU;
    private TBLottieAnimationView oFV;
    private TBLottieAnimationView oFW;
    private ImageView oFX;
    private g oFY;
    private AlaLoadingToastView oFZ;
    private int oGa;
    private int oGb;
    private int oGc;
    private long oGd;
    private long oGe;
    private String onB;
    public CustomMessageListener ooJ;

    public TeamFightLayout(@NonNull Context context) {
        this(context, null);
    }

    public TeamFightLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TeamFightLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oGa = 1;
        this.oGb = 1;
        this.Yn = e.c(94.0f, getContext());
        this.ooJ = new CustomMessageListener(2501014) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501014 && (customResponsedMessage.getData() instanceof com.baidu.live.data.g) && ((com.baidu.live.data.g) customResponsedMessage.getData()).Ex() != 2 && TeamFightLayout.this.oFY != null && TeamFightLayout.this.oFY.isShowing()) {
                    TeamFightLayout.this.oFY.dismiss();
                }
            }
        };
        if (UtilHelper.getStatusBarHeight() > 0) {
            this.Yn = UtilHelper.getStatusBarHeight() + e.c(68.0f, getContext());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout
    public synchronized void a(final List<AlaWheatInfoData> list, final List<AlaWheatInfoData> list2, final x xVar) {
        super.a(list, list2, xVar);
        this.mView.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.1
            @Override // java.lang.Runnable
            public void run() {
                TeamFightLayout.this.oEc = list;
                TeamFightLayout.this.oEd = list2;
                if (ListUtils.getCount(TeamFightLayout.this.oFe) == 0 || ListUtils.getCount(TeamFightLayout.this.oFe) != ListUtils.getCount(list) || ListUtils.getCount(TeamFightLayout.this.oFf) == 0 || ListUtils.getCount(TeamFightLayout.this.oFf) != ListUtils.getCount(list2)) {
                    TeamFightLayout.this.ego();
                    TeamFightLayout.this.oFj.removeAllViews();
                    TeamFightLayout.this.oFe.clear();
                    TeamFightLayout.this.oFf.clear();
                    TeamFightLayout.this.egG();
                    TeamFightLayout.this.egF();
                    TeamFightLayout.this.egE();
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
                    TeamFightLayout.this.egD();
                    TeamFightLayout.this.oFj.invalidate();
                    TeamFightLayout.this.oFj.requestLayout();
                }
                if (!ListUtils.isEmpty(TeamFightLayout.this.oFe)) {
                    for (int i3 = 0; i3 < TeamFightLayout.this.oFe.size(); i3++) {
                        TeamFightLayout.this.oFe.get(i3).setData(TeamFightLayout.this.am(i3, true), i3, true, xVar);
                    }
                }
                if (!ListUtils.isEmpty(TeamFightLayout.this.oFf)) {
                    for (int i4 = 0; i4 < TeamFightLayout.this.oFf.size(); i4++) {
                        TeamFightLayout.this.oFf.get(i4).setData(TeamFightLayout.this.am(i4, false), i4, false, xVar);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egD() {
        this.oFZ = new AlaLoadingToastView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.oFZ.setLayoutParams(layoutParams);
        ViewGroup viewGroup = null;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            viewGroup = (ViewGroup) this.mTbPageContext.getPageActivity().findViewById(a.f.ala_liveroom_view);
        }
        if (viewGroup != null) {
            u.a(viewGroup, this.oFZ, 650);
        } else {
            this.oFj.addView(this.oFZ);
        }
        this.oFZ.setVisibility(8);
        this.oFZ.setContent(getContext().getResources().getString(a.h.yuyin_ala_settlement_text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egE() {
        this.oFS = new AddTimeEndGameView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.rightMargin = e.c(10.0f, getContext());
        layoutParams.topMargin = this.Yn + e.c(19.0f, getContext());
        this.oFS.setLayoutParams(layoutParams);
        this.oFS.setListener(new AddTimeEndGameView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.AddTimeEndGameView.a
            public void egk() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, o.eff().aas().aLl.croom_id);
                    jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "timeset");
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "startbattle_clk").setContentExt(jSONObject));
                new com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a(TeamFightLayout.this.mTbPageContext.getPageActivity()).ac(o.eff().aas());
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.AddTimeEndGameView.a
            public void egl() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, o.eff().aas().aLl.croom_id);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "overtime_clk").setContentExt(jSONObject));
                TeamFightLayout.this.egl();
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.AddTimeEndGameView.a
            public void egm() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, o.eff().aas().aLl.croom_id);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "endbattle_clk").setContentExt(jSONObject));
                TeamFightLayout.this.egH();
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.AddTimeEndGameView.a
            public void egn() {
                TeamFightLayout.this.egn();
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.AddTimeEndGameView.a
            public int NM(int i) {
                return TeamFightLayout.this.NM(i);
            }
        });
        this.oFj.addView(this.oFS);
        this.oFS.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egF() {
        int i;
        int i2;
        int i3;
        int i4;
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] >= (this.oFh * 4) + e.c(14.0f, getContext())) {
            i = (int) ((((screenFullSize[0] - (e.c(7.0f, getContext()) * 2)) * 1.0d) * 1101.0d) / 2400.0d);
            i2 = (int) (e.c(7.0f, getContext()) + (((screenFullSize[0] - (e.c(7.0f, getContext()) * 2)) * 41.0d) / 1200.0d));
            i3 = (int) (((screenFullSize[0] - (e.c(7.0f, getContext()) * 2)) * 11.5d) / 1200.0d);
            i4 = (int) ((((screenFullSize[0] - e.c(14.0f, getContext())) * 72) * 1.0d) / 120.0d);
        } else {
            i = (int) (((screenFullSize[0] * 1.0d) * 1101.0d) / 2400.0d);
            i2 = (int) ((screenFullSize[0] * 41.0d) / 1200.0d);
            i3 = (int) ((screenFullSize[0] * 11.5d) / 1200.0d);
            i4 = (int) (((screenFullSize[0] * 72) * 1.0d) / 120.0d);
        }
        this.oFT = new TBLottieAnimationView(getContext());
        this.oFT.setImageAssetsFolder("lottie/yuyin_connection_wheat_red_safety_mask/");
        this.oFT.setAnimation("lottie/yuyin_connection_wheat_red_safety_mask.json");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i4);
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = this.Yn + this.oFi + e.c(70.0f, getContext());
        this.oFT.setLayoutParams(layoutParams);
        this.oFj.addView(this.oFT);
        this.oFU = new TBLottieAnimationView(getContext());
        this.oFU.setImageAssetsFolder("lottie/yuyin_connection_wheat_red_advantage/");
        this.oFU.setAnimation("lottie/yuyin_connection_wheat_red_advantage.json");
        this.oFU.setRepeatMode(1);
        this.oFU.setRepeatCount(-1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i4);
        layoutParams2.leftMargin = i2;
        layoutParams2.topMargin = this.Yn + this.oFi + e.c(70.0f, getContext());
        this.oFU.setLayoutParams(layoutParams2);
        this.oFj.addView(this.oFU);
        this.oFV = new TBLottieAnimationView(getContext());
        this.oFV.setImageAssetsFolder("lottie/yuyin_connection_wheat_blue_safety_mask/");
        this.oFV.setAnimation("lottie/yuyin_connection_wheat_blue_safety_mask.json");
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i, i4);
        layoutParams3.topMargin = this.Yn + this.oFi + e.c(70.0f, getContext());
        layoutParams3.leftMargin = (screenFullSize[0] / 2) + i3;
        this.oFV.setLayoutParams(layoutParams3);
        this.oFj.addView(this.oFV);
        this.oFW = new TBLottieAnimationView(getContext());
        this.oFW.setImageAssetsFolder("lottie/yuyin_connection_wheat_blue_advantage/");
        this.oFW.setAnimation("lottie/yuyin_connection_wheat_blue_advantage.json");
        this.oFW.setRepeatMode(1);
        this.oFW.setRepeatCount(-1);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(i, i4);
        layoutParams4.leftMargin = (screenFullSize[0] / 2) + i3;
        layoutParams4.topMargin = this.Yn + this.oFi + e.c(70.0f, getContext());
        this.oFW.setLayoutParams(layoutParams4);
        this.oFj.addView(this.oFW);
    }

    public void NO(int i) {
        if (i == 0) {
            if (this.oFT != null) {
                this.oFT.setVisibility(0);
                this.oFT.playAnimation();
            }
        } else if (i == 1) {
            if (this.oFU != null) {
                this.oFU.setVisibility(0);
                this.oFU.playAnimation();
            }
        } else if (i == 2) {
            if (this.oFV != null) {
                this.oFV.setVisibility(0);
                this.oFV.playAnimation();
            }
        } else if (i == 3 && this.oFW != null) {
            this.oFW.setVisibility(0);
            this.oFW.playAnimation();
        }
    }

    public void NP(int i) {
        if (i == 0) {
            if (this.oFT != null) {
                this.oFT.setVisibility(8);
                this.oFT.pauseAnimation();
            }
        } else if (i == 1) {
            if (this.oFU != null) {
                this.oFU.setVisibility(8);
                this.oFU.pauseAnimation();
            }
        } else if (i == 2) {
            if (this.oFV != null) {
                this.oFV.setVisibility(8);
                this.oFV.pauseAnimation();
            }
        } else if (i == 3 && this.oFW != null) {
            this.oFW.setVisibility(8);
            this.oFW.pauseAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egG() {
        int i;
        this.oFX = new ImageView(getContext());
        int c = e.c(228.0f, getContext());
        if (this.mTbPageContext == null || this.mTbPageContext.getPageActivity() == null) {
            i = 0;
        } else {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
            if (screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] >= (this.oFh * 4) + e.c(14.0f, getContext())) {
                i = e.c(7.0f, getContext());
                c = (int) ((((screenFullSize[0] - e.c(14.0f, getContext())) * 72) * 1.0d) / 120.0d);
            } else {
                c = (int) (((screenFullSize[0] * 72) * 1.0d) / 120.0d);
                i = 0;
            }
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, c);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.Yn + this.oFi + e.c(70.0f, getContext());
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        this.oFX.setLayoutParams(layoutParams);
        this.oFX.setBackgroundResource(a.e.yuyin_audio_wheat_team_fight_bg);
        this.oFj.addView(this.oFX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] an(int i, boolean z) {
        int[] iArr = new int[2];
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (z) {
            iArr[0] = (screenFullSize[0] / 2) - (this.oFh / 2);
            iArr[1] = this.Yn;
        } else {
            int c = ((this.mTbPageContext == null || this.mTbPageContext.getPageActivity() == null) && screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] >= (this.oFh * 4) + e.c(5.0f, getContext())) ? e.c(5.0f, getContext()) : 0;
            if (i == 0) {
                iArr[0] = (((screenFullSize[0] / 2) - this.oFh) - this.oFh) - c;
                iArr[1] = this.Yn + this.oFi + e.c(75.0f, getContext());
            } else if (i == 1) {
                iArr[0] = ((screenFullSize[0] / 2) - this.oFh) - c;
                iArr[1] = this.Yn + this.oFi + e.c(75.0f, getContext());
            } else if (i == 2) {
                iArr[0] = (((screenFullSize[0] / 2) - this.oFh) - this.oFh) - c;
                iArr[1] = this.Yn + this.oFi + e.c(75.0f, getContext()) + this.oFi;
            } else if (i == 3) {
                iArr[0] = ((screenFullSize[0] / 2) - this.oFh) - c;
                iArr[1] = this.Yn + this.oFi + e.c(75.0f, getContext()) + this.oFi;
            } else if (i == 4) {
                iArr[0] = c + (screenFullSize[0] / 2);
                iArr[1] = this.Yn + this.oFi + e.c(75.0f, getContext());
            } else if (i == 5) {
                iArr[0] = c + (screenFullSize[0] / 2) + this.oFh;
                iArr[1] = this.Yn + this.oFi + e.c(75.0f, getContext());
            } else if (i == 6) {
                iArr[0] = c + (screenFullSize[0] / 2);
                iArr[1] = this.Yn + this.oFi + e.c(75.0f, getContext()) + this.oFi;
            } else if (i == 7) {
                iArr[0] = c + (screenFullSize[0] / 2) + this.oFh;
                iArr[1] = this.Yn + this.oFi + e.c(75.0f, getContext()) + this.oFi;
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
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.oFh, this.oFi);
        layoutParams.leftMargin = iArr[0];
        layoutParams.topMargin = iArr[1];
        wheatItemView.setLayoutParams(layoutParams);
        this.oFj.addView(wheatItemView);
        wheatItemView.setOnItemClickListener(this.oFd);
        if (z) {
            this.oFe.add(wheatItemView);
        } else {
            this.oFf.add(wheatItemView);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        egK();
        MessageManager.getInstance().registerListener(this.ooJ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.ooJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egl() {
        b bVar = new b(null, new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.3
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.b.a
            public void a(AddTimeHttpResponseMessage addTimeHttpResponseMessage) {
                BdToast.makeText(TeamFightLayout.this.getContext(), String.format(TeamFightLayout.this.getContext().getString(a.h.yuyin_ala_add_time_toast_text), Integer.valueOf(TeamFightLayout.this.NM(TeamFightLayout.this.activity_stage)))).show();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501082, null));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.b.a
            public void onFail(int i, String str) {
            }
        });
        x aas = c.eeo().aas();
        if (aas != null && aas.aLm != null) {
            bVar.A(c.eeo().eeq().getRoomId(), aas.aLm.mStep, NM(this.activity_stage));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egn() {
        this.oGc = 1;
        this.oFY = new g(this.mTbPageContext);
        this.oFY.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.4
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
            public void onCancel() {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
            public void onConfirm() {
                TeamFightLayout.this.dM(1, 1);
            }
        });
        this.oFY.show();
        this.oFY.setText(getContext().getResources().getString(a.h.yuyin_ala_punish_team_fight_text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egH() {
        this.oGc = 3;
        this.oFY = new g(this.mTbPageContext);
        this.oFY.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
            public void onCancel() {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
            public void onConfirm() {
                TeamFightLayout.this.dM(3, 1);
            }
        });
        this.oFY.show();
        this.oFY.setText(getContext().getResources().getString(a.h.yuyin_ala_end_team_fight_text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dM(final int i, int i2) {
        com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.b bVar = new com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.b(this.mTbPageContext.getPageActivity());
        bVar.A(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.av(o.eff().aas()), i, i2);
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
        return this.Yn + this.oFi + e.c(298.0f, getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int NM(int i) {
        x aas;
        db dbVar;
        int i2;
        db dbVar2;
        if (i == 1) {
            x aas2 = c.eeo().aas();
            if (aas2 == null || (dbVar2 = (db) ListUtils.getItem(aas2.aLG, aas2.aLq.getRoomMode())) == null) {
                i2 = 5;
            } else {
                i2 = dbVar2.aVi;
            }
            return i2;
        } else if (i != 3 || (aas = c.eeo().aas()) == null || aas.aLm == null || aas.aLq == null || (dbVar = (db) ListUtils.getItem(aas.aLG, aas.aLq.getRoomMode())) == null) {
            return 5;
        } else {
            return dbVar.aVn;
        }
    }

    public void setTeamFightProgressData(String str) {
        JSONObject optJSONObject;
        if (this.oFU == null || this.oFW == null) {
            return;
        }
        if (this.oFT != null || this.oFV != null) {
            if (TextUtils.isEmpty(str)) {
                egK();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                    this.activity_stage = optJSONObject.optInt("activity_stage");
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("pk_value");
                    this.onB = optJSONObject.optString("pk_winner");
                    if (optJSONObject2 != null) {
                        long parseLong = Long.parseLong(optJSONObject2.optString("a"));
                        long parseLong2 = Long.parseLong(optJSONObject2.optString(com.baidu.pass.biometrics.face.liveness.d.b.f4080a));
                        if (this.activity_stage == 1 && (parseLong != 0 || parseLong2 != 0)) {
                            if (parseLong == parseLong2) {
                                if (!this.oFU.isAnimating() && !this.oFW.isAnimating()) {
                                    NO(1);
                                }
                            } else if (parseLong > parseLong2) {
                                if (!this.oFU.isAnimating()) {
                                    NO(1);
                                }
                                NP(3);
                            } else {
                                if (!this.oFW.isAnimating()) {
                                    NO(3);
                                }
                                NP(1);
                            }
                            if (parseLong > this.oGd) {
                                NO(0);
                            }
                            if (parseLong2 > this.oGe) {
                                NO(2);
                            }
                            this.oGd = parseLong;
                            this.oGe = parseLong2;
                        } else {
                            this.oGd = 0L;
                            this.oGe = 0L;
                            egK();
                        }
                        egI();
                        egJ();
                        if (this.oFS != null) {
                            if (o.eff().jo(o.eff().aar())) {
                                this.oFS.setVisibility(0);
                                this.oFS.setButtonState(this.activity_stage);
                            } else {
                                this.oFS.setVisibility(8);
                            }
                        }
                        if (this.oFZ != null) {
                            this.oFZ.setVisibility(this.activity_stage != 2 ? 8 : 0);
                        }
                        if (this.oFY != null && this.oFY.isShowing() && this.oGc != this.activity_stage) {
                            this.oFY.dismiss();
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void egI() {
        if (this.oGa == 0 && this.activity_stage == 1) {
            this.oGa = 1;
            View findViewById = (this.mTbPageContext == null || this.mTbPageContext.getPageActivity() == null) ? null : this.mTbPageContext.getPageActivity().findViewById(a.f.ala_liveroom_view);
            if (findViewById != null) {
                com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efJ().b((ViewGroup) findViewById, null);
            }
        } else if (this.activity_stage == 0) {
            this.oGa = 0;
        }
    }

    private void egJ() {
        if (this.oGb == 0 && this.activity_stage == 3) {
            this.oGb = 1;
            View findViewById = (this.mTbPageContext == null || this.mTbPageContext.getPageActivity() == null) ? null : this.mTbPageContext.getPageActivity().findViewById(a.f.ala_liveroom_view);
            if (findViewById != null) {
                if ("a".equals(this.onB)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efJ().c((ViewGroup) findViewById, null);
                } else if (com.baidu.pass.biometrics.face.liveness.d.b.f4080a.equals(this.onB)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efJ().d((ViewGroup) findViewById, null);
                }
            }
        } else if (this.activity_stage == 0 || this.activity_stage == 1 || this.activity_stage == 2) {
            this.oGb = 0;
        }
    }

    private void egK() {
        if (this.oFT != null) {
            this.oFT.setVisibility(8);
            this.oFT.pauseAnimation();
        }
        if (this.oFU != null) {
            this.oFU.setVisibility(8);
            this.oFU.pauseAnimation();
        }
        if (this.oFV != null) {
            this.oFV.setVisibility(8);
            this.oFV.pauseAnimation();
        }
        if (this.oFW != null) {
            this.oFW.setVisibility(8);
            this.oFW.pauseAnimation();
        }
    }
}
