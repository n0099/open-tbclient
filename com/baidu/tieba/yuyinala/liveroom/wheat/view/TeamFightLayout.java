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
import com.baidu.live.data.ab;
import com.baidu.live.data.dh;
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
import com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView;
import com.baidu.tieba.yuyinala.liveroom.alaaudiopk.c;
import com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.TimeSettingResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.b;
import com.baidu.tieba.yuyinala.liveroom.views.AlaLoadingToastView;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
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
    public int ZA;
    private int activity_stage;
    private AddTimeEndGameView oNV;
    private TBLottieAnimationView oNW;
    private TBLottieAnimationView oNX;
    private TBLottieAnimationView oNY;
    private TBLottieAnimationView oNZ;
    private ImageView oOa;
    private g oOb;
    private AlaLoadingToastView oOc;
    private int oOd;
    private int oOe;
    private int oOf;
    private long oOg;
    private long oOh;
    private AlaChallengeLiveView oOi;
    private String ovu;
    public CustomMessageListener owC;

    public TeamFightLayout(@NonNull Context context) {
        this(context, null);
    }

    public TeamFightLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TeamFightLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oOd = 1;
        this.oOe = 1;
        this.ZA = e.d(94.0f, getContext());
        this.owC = new CustomMessageListener(2501014) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501014 && (customResponsedMessage.getData() instanceof com.baidu.live.data.g) && ((com.baidu.live.data.g) customResponsedMessage.getData()).Bp() != 2 && TeamFightLayout.this.oOb != null && TeamFightLayout.this.oOb.isShowing()) {
                    TeamFightLayout.this.oOb.dismiss();
                }
            }
        };
        if (UtilHelper.getStatusBarHeight() > 0) {
            this.ZA = UtilHelper.getStatusBarHeight() + e.d(68.0f, getContext());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout
    public synchronized void a(final List<AlaWheatInfoData> list, final List<AlaWheatInfoData> list2, final ab abVar) {
        super.a(list, list2, abVar);
        this.mView.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.1
            @Override // java.lang.Runnable
            public void run() {
                TeamFightLayout.this.oLK = list;
                TeamFightLayout.this.oLL = list2;
                if (ListUtils.getCount(TeamFightLayout.this.oMO) == 0 || ListUtils.getCount(TeamFightLayout.this.oMO) != ListUtils.getCount(list) || ListUtils.getCount(TeamFightLayout.this.oMP) == 0 || ListUtils.getCount(TeamFightLayout.this.oMP) != ListUtils.getCount(list2)) {
                    TeamFightLayout.this.efb();
                    TeamFightLayout.this.oMT.removeAllViews();
                    TeamFightLayout.this.oMO.clear();
                    TeamFightLayout.this.oMP.clear();
                    TeamFightLayout.this.aE(abVar);
                    TeamFightLayout.this.efw();
                    TeamFightLayout.this.efv();
                    TeamFightLayout.this.efu();
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
                    TeamFightLayout.this.eft();
                    TeamFightLayout.this.oMT.invalidate();
                    TeamFightLayout.this.oMT.requestLayout();
                }
                TeamFightLayout.this.efs();
                if (!ListUtils.isEmpty(TeamFightLayout.this.oMO)) {
                    for (int i3 = 0; i3 < TeamFightLayout.this.oMO.size(); i3++) {
                        TeamFightLayout.this.oMO.get(i3).setData(TeamFightLayout.this.am(i3, true), i3, true, abVar);
                    }
                }
                if (!ListUtils.isEmpty(TeamFightLayout.this.oMP)) {
                    for (int i4 = 0; i4 < TeamFightLayout.this.oMP.size(); i4++) {
                        TeamFightLayout.this.oMP.get(i4).setData(TeamFightLayout.this.am(i4, false), i4, false, abVar);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efs() {
        com.baidu.tieba.yuyinala.liveroom.data.a eei = q.edU().eei();
        if (eei != null && eei.owJ != null) {
            eei.owJ.ozp = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eft() {
        this.oOc = new AlaLoadingToastView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.oOc.setLayoutParams(layoutParams);
        ViewGroup viewGroup = null;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            viewGroup = (ViewGroup) this.mTbPageContext.getPageActivity().findViewById(a.f.ala_liveroom_view);
        }
        if (viewGroup != null) {
            u.a(viewGroup, this.oOc, 650);
        } else {
            this.oMT.addView(this.oOc);
        }
        this.oOc.setVisibility(8);
        this.oOc.setContent(getContext().getResources().getString(a.h.yuyin_ala_settlement_text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efu() {
        this.oNV = new AddTimeEndGameView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.rightMargin = e.d(10.0f, getContext());
        layoutParams.topMargin = this.ZA + e.d(19.0f, getContext());
        this.oNV.setLayoutParams(layoutParams);
        this.oNV.setListener(new AddTimeEndGameView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.AddTimeEndGameView.a
            public void eeX() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, q.edU().Yt().aKu.croom_id);
                    jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "timeset");
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "startbattle_clk").setContentExt(jSONObject));
                new com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a(TeamFightLayout.this.mTbPageContext.getPageActivity()).ab(q.edU().Yt());
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.AddTimeEndGameView.a
            public void eeY() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, q.edU().Yt().aKu.croom_id);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "overtime_clk").setContentExt(jSONObject));
                TeamFightLayout.this.eeY();
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.AddTimeEndGameView.a
            public void eeZ() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, q.edU().Yt().aKu.croom_id);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "endbattle_clk").setContentExt(jSONObject));
                TeamFightLayout.this.efx();
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.AddTimeEndGameView.a
            public void efa() {
                TeamFightLayout.this.efa();
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.AddTimeEndGameView.a
            public int MG(int i) {
                return TeamFightLayout.this.MG(i);
            }
        });
        this.oMT.addView(this.oNV);
        this.oNV.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efv() {
        int i;
        int i2;
        int i3;
        int i4;
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] >= (this.oMR * 4) + e.d(14.0f, getContext())) {
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
        this.oNW = new TBLottieAnimationView(getContext());
        this.oNW.setImageAssetsFolder("lottie/yuyin_connection_wheat_red_safety_mask/");
        this.oNW.setAnimation("lottie/yuyin_connection_wheat_red_safety_mask.json");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i4);
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = this.ZA + this.oMS + e.d(70.0f, getContext());
        this.oNW.setLayoutParams(layoutParams);
        this.oMT.addView(this.oNW);
        this.oNX = new TBLottieAnimationView(getContext());
        this.oNX.setImageAssetsFolder("lottie/yuyin_connection_wheat_red_advantage/");
        this.oNX.setAnimation("lottie/yuyin_connection_wheat_red_advantage.json");
        this.oNX.setRepeatMode(1);
        this.oNX.setRepeatCount(-1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i4);
        layoutParams2.leftMargin = i2;
        layoutParams2.topMargin = this.ZA + this.oMS + e.d(70.0f, getContext());
        this.oNX.setLayoutParams(layoutParams2);
        this.oMT.addView(this.oNX);
        this.oNY = new TBLottieAnimationView(getContext());
        this.oNY.setImageAssetsFolder("lottie/yuyin_connection_wheat_blue_safety_mask/");
        this.oNY.setAnimation("lottie/yuyin_connection_wheat_blue_safety_mask.json");
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i, i4);
        layoutParams3.topMargin = this.ZA + this.oMS + e.d(70.0f, getContext());
        layoutParams3.leftMargin = (screenFullSize[0] / 2) + i3;
        this.oNY.setLayoutParams(layoutParams3);
        this.oMT.addView(this.oNY);
        this.oNZ = new TBLottieAnimationView(getContext());
        this.oNZ.setImageAssetsFolder("lottie/yuyin_connection_wheat_blue_advantage/");
        this.oNZ.setAnimation("lottie/yuyin_connection_wheat_blue_advantage.json");
        this.oNZ.setRepeatMode(1);
        this.oNZ.setRepeatCount(-1);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(i, i4);
        layoutParams4.leftMargin = (screenFullSize[0] / 2) + i3;
        layoutParams4.topMargin = this.ZA + this.oMS + e.d(70.0f, getContext());
        this.oNZ.setLayoutParams(layoutParams4);
        this.oMT.addView(this.oNZ);
    }

    public void MI(int i) {
        if (i == 0) {
            if (this.oNW != null) {
                this.oNW.setVisibility(0);
                this.oNW.playAnimation();
            }
        } else if (i == 1) {
            if (this.oNX != null) {
                this.oNX.setVisibility(0);
                this.oNX.playAnimation();
            }
        } else if (i == 2) {
            if (this.oNY != null) {
                this.oNY.setVisibility(0);
                this.oNY.playAnimation();
            }
        } else if (i == 3 && this.oNZ != null) {
            this.oNZ.setVisibility(0);
            this.oNZ.playAnimation();
        }
    }

    public void MJ(int i) {
        if (i == 0) {
            if (this.oNW != null) {
                this.oNW.setVisibility(8);
                this.oNW.pauseAnimation();
            }
        } else if (i == 1) {
            if (this.oNX != null) {
                this.oNX.setVisibility(8);
                this.oNX.pauseAnimation();
            }
        } else if (i == 2) {
            if (this.oNY != null) {
                this.oNY.setVisibility(8);
                this.oNY.pauseAnimation();
            }
        } else if (i == 3 && this.oNZ != null) {
            this.oNZ.setVisibility(8);
            this.oNZ.pauseAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(ab abVar) {
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            this.oOi = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.oOi.setId(a.f.ala_liveroom_live_pk_bar);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.ZA + e.d(62.0f, getContext());
            this.oMT.addView(this.oOi, layoutParams);
            q.edU().eei();
        }
    }

    public void b(c cVar) {
        if (this.oOi != null) {
            this.oOi.b(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efw() {
        int i;
        this.oOa = new ImageView(getContext());
        int d = e.d(228.0f, getContext());
        if (this.mTbPageContext == null || this.mTbPageContext.getPageActivity() == null) {
            i = 0;
        } else {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
            if (screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] >= (this.oMR * 4) + e.d(14.0f, getContext())) {
                i = e.d(7.0f, getContext());
                d = (int) ((((screenFullSize[0] - e.d(14.0f, getContext())) * 72) * 1.0d) / 120.0d);
            } else {
                d = (int) (((screenFullSize[0] * 72) * 1.0d) / 120.0d);
                i = 0;
            }
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, d);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.ZA + this.oMS + e.d(70.0f, getContext());
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        this.oOa.setLayoutParams(layoutParams);
        this.oOa.setBackgroundResource(a.e.yuyin_audio_wheat_team_fight_bg);
        this.oMT.addView(this.oOa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] an(int i, boolean z) {
        int[] iArr = new int[2];
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (z) {
            iArr[0] = (screenFullSize[0] / 2) - (this.oMR / 2);
            iArr[1] = this.ZA;
        } else {
            int d = ((this.mTbPageContext == null || this.mTbPageContext.getPageActivity() == null) && screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] >= (this.oMR * 4) + e.d(5.0f, getContext())) ? e.d(5.0f, getContext()) : 0;
            if (i == 0) {
                iArr[0] = (((screenFullSize[0] / 2) - this.oMR) - this.oMR) - d;
                iArr[1] = this.ZA + this.oMS + e.d(75.0f, getContext());
            } else if (i == 1) {
                iArr[0] = ((screenFullSize[0] / 2) - this.oMR) - d;
                iArr[1] = this.ZA + this.oMS + e.d(75.0f, getContext());
            } else if (i == 2) {
                iArr[0] = (((screenFullSize[0] / 2) - this.oMR) - this.oMR) - d;
                iArr[1] = this.ZA + this.oMS + e.d(75.0f, getContext()) + this.oMS;
            } else if (i == 3) {
                iArr[0] = ((screenFullSize[0] / 2) - this.oMR) - d;
                iArr[1] = this.ZA + this.oMS + e.d(75.0f, getContext()) + this.oMS;
            } else if (i == 4) {
                iArr[0] = d + (screenFullSize[0] / 2);
                iArr[1] = this.ZA + this.oMS + e.d(75.0f, getContext());
            } else if (i == 5) {
                iArr[0] = d + (screenFullSize[0] / 2) + this.oMR;
                iArr[1] = this.ZA + this.oMS + e.d(75.0f, getContext());
            } else if (i == 6) {
                iArr[0] = d + (screenFullSize[0] / 2);
                iArr[1] = this.ZA + this.oMS + e.d(75.0f, getContext()) + this.oMS;
            } else if (i == 7) {
                iArr[0] = d + (screenFullSize[0] / 2) + this.oMR;
                iArr[1] = this.ZA + this.oMS + e.d(75.0f, getContext()) + this.oMS;
            } else {
                iArr[1] = 0;
                iArr[0] = 0;
            }
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int[] iArr, boolean z) {
        BaseWheatItemView wheatItemView = new WheatItemView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.oMR, this.oMS);
        layoutParams.leftMargin = iArr[0];
        layoutParams.topMargin = iArr[1];
        wheatItemView.setLayoutParams(layoutParams);
        this.oMT.addView(wheatItemView);
        wheatItemView.setOnItemClickListener(this.oMN);
        if (z) {
            this.oMO.add(wheatItemView);
        } else {
            this.oMP.add(wheatItemView);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        efA();
        MessageManager.getInstance().registerListener(this.owC);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.owC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eeY() {
        b bVar = new b(null, new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.3
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.b.a
            public void a(AddTimeHttpResponseMessage addTimeHttpResponseMessage) {
                BdToast.makeText(TeamFightLayout.this.getContext(), String.format(TeamFightLayout.this.getContext().getString(a.h.yuyin_ala_add_time_toast_text), Integer.valueOf(TeamFightLayout.this.MG(TeamFightLayout.this.activity_stage)))).show();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501082, null));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.b.a
            public void onFail(int i, String str) {
            }
        });
        ab Yt = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().Yt();
        if (Yt != null && Yt.aKv != null) {
            bVar.A(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().edb().getRoomId(), Yt.aKv.mStep, MG(this.activity_stage));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efa() {
        this.oOf = 1;
        this.oOb = new g(this.mTbPageContext);
        this.oOb.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.4
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
            public void onCancel() {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
            public void onConfirm() {
                TeamFightLayout.this.dK(1, 1);
            }
        });
        this.oOb.show();
        this.oOb.setText(getContext().getResources().getString(a.h.yuyin_ala_punish_team_fight_text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efx() {
        this.oOf = 3;
        this.oOb = new g(this.mTbPageContext);
        this.oOb.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
            public void onCancel() {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
            public void onConfirm() {
                TeamFightLayout.this.dK(3, 1);
            }
        });
        this.oOb.show();
        this.oOb.setText(getContext().getResources().getString(a.h.yuyin_ala_end_team_fight_text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dK(final int i, int i2) {
        com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.b bVar = new com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.b(this.mTbPageContext.getPageActivity());
        bVar.A(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.av(q.edU().Yt()), i, i2);
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
        return this.ZA + this.oMS + e.d(298.0f, getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int MG(int i) {
        ab Yt;
        dh dhVar;
        int i2;
        dh dhVar2;
        if (i == 1) {
            ab Yt2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().Yt();
            if (Yt2 == null || (dhVar2 = (dh) ListUtils.getItem(Yt2.aKR, Yt2.aKy.getRoomMode())) == null) {
                i2 = 5;
            } else {
                i2 = dhVar2.aUY;
            }
            return i2;
        } else if (i != 3 || (Yt = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecZ().Yt()) == null || Yt.aKv == null || Yt.aKy == null || (dhVar = (dh) ListUtils.getItem(Yt.aKR, Yt.aKy.getRoomMode())) == null) {
            return 5;
        } else {
            return dhVar.aVd;
        }
    }

    public void setTeamFightProgressData(String str) {
        JSONObject optJSONObject;
        if (this.oNX == null || this.oNZ == null) {
            return;
        }
        if (this.oNW != null || this.oNY != null) {
            if (TextUtils.isEmpty(str)) {
                efA();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                    this.activity_stage = optJSONObject.optInt("activity_stage");
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("pk_value");
                    this.ovu = optJSONObject.optString("pk_winner");
                    if (optJSONObject2 != null) {
                        long parseLong = Long.parseLong(optJSONObject2.optString("a"));
                        long parseLong2 = Long.parseLong(optJSONObject2.optString(com.baidu.pass.biometrics.face.liveness.d.b.f2804a));
                        if (this.activity_stage == 1 && (parseLong != 0 || parseLong2 != 0)) {
                            if (parseLong == parseLong2) {
                                if (!this.oNX.isAnimating() && !this.oNZ.isAnimating()) {
                                    MI(1);
                                }
                            } else if (parseLong > parseLong2) {
                                if (!this.oNX.isAnimating()) {
                                    MI(1);
                                }
                                MJ(3);
                            } else {
                                if (!this.oNZ.isAnimating()) {
                                    MI(3);
                                }
                                MJ(1);
                            }
                            if (parseLong > this.oOg) {
                                MI(0);
                            }
                            if (parseLong2 > this.oOh) {
                                MI(2);
                            }
                            this.oOg = parseLong;
                            this.oOh = parseLong2;
                        } else {
                            this.oOg = 0L;
                            this.oOh = 0L;
                            efA();
                        }
                        efy();
                        efz();
                        if (this.oNV != null) {
                            if (q.edU().iP(q.edU().Ys())) {
                                this.oNV.setVisibility(0);
                                this.oNV.setButtonState(this.activity_stage);
                            } else {
                                this.oNV.setVisibility(8);
                            }
                        }
                        if (this.oOc != null) {
                            this.oOc.setVisibility(this.activity_stage != 2 ? 8 : 0);
                        }
                        if (this.oOb != null && this.oOb.isShowing() && this.oOf != this.activity_stage) {
                            this.oOb.dismiss();
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void efy() {
        if (this.oOd == 0 && this.activity_stage == 1) {
            this.oOd = 1;
            View findViewById = (this.mTbPageContext == null || this.mTbPageContext.getPageActivity() == null) ? null : this.mTbPageContext.getPageActivity().findViewById(a.f.ala_liveroom_view);
            if (findViewById != null) {
                com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eew().b((ViewGroup) findViewById, null);
            }
        } else if (this.activity_stage == 0) {
            this.oOd = 0;
        }
    }

    private void efz() {
        if (this.oOe == 0 && this.activity_stage == 3) {
            this.oOe = 1;
            View findViewById = (this.mTbPageContext == null || this.mTbPageContext.getPageActivity() == null) ? null : this.mTbPageContext.getPageActivity().findViewById(a.f.ala_liveroom_view);
            if (findViewById != null) {
                if ("a".equals(this.ovu)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eew().c((ViewGroup) findViewById, null);
                } else if (com.baidu.pass.biometrics.face.liveness.d.b.f2804a.equals(this.ovu)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eew().d((ViewGroup) findViewById, null);
                }
            }
        } else if (this.activity_stage == 0 || this.activity_stage == 1 || this.activity_stage == 2) {
            this.oOe = 0;
        }
    }

    private void efA() {
        if (this.oNW != null) {
            this.oNW.setVisibility(8);
            this.oNW.pauseAnimation();
        }
        if (this.oNX != null) {
            this.oNX.setVisibility(8);
            this.oNX.pauseAnimation();
        }
        if (this.oNY != null) {
            this.oNY.setVisibility(8);
            this.oNY.pauseAnimation();
        }
        if (this.oNZ != null) {
            this.oNZ.setVisibility(8);
            this.oNZ.pauseAnimation();
        }
    }
}
