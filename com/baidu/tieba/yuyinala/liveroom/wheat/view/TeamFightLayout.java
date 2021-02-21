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
/* loaded from: classes11.dex */
public class TeamFightLayout extends BaseWheatLayout {
    public int Yh;
    private int activity_stage;
    private AddTimeEndGameView oLQ;
    private TBLottieAnimationView oLR;
    private TBLottieAnimationView oLS;
    private TBLottieAnimationView oLT;
    private TBLottieAnimationView oLU;
    private ImageView oLV;
    private g oLW;
    private AlaLoadingToastView oLX;
    private int oLY;
    private int oLZ;
    private int oMa;
    private long oMb;
    private long oMc;
    private AlaChallengeLiveView oMd;
    private String oto;
    public CustomMessageListener oux;

    public TeamFightLayout(@NonNull Context context) {
        this(context, null);
    }

    public TeamFightLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TeamFightLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oLY = 1;
        this.oLZ = 1;
        this.Yh = e.d(94.0f, getContext());
        this.oux = new CustomMessageListener(2501014) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501014 && (customResponsedMessage.getData() instanceof com.baidu.live.data.g) && ((com.baidu.live.data.g) customResponsedMessage.getData()).Bm() != 2 && TeamFightLayout.this.oLW != null && TeamFightLayout.this.oLW.isShowing()) {
                    TeamFightLayout.this.oLW.dismiss();
                }
            }
        };
        if (UtilHelper.getStatusBarHeight() > 0) {
            this.Yh = UtilHelper.getStatusBarHeight() + e.d(68.0f, getContext());
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout
    public synchronized void a(final List<AlaWheatInfoData> list, final List<AlaWheatInfoData> list2, final ab abVar) {
        super.a(list, list2, abVar);
        this.mView.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.1
            @Override // java.lang.Runnable
            public void run() {
                TeamFightLayout.this.oJF = list;
                TeamFightLayout.this.oJG = list2;
                if (ListUtils.getCount(TeamFightLayout.this.oKJ) == 0 || ListUtils.getCount(TeamFightLayout.this.oKJ) != ListUtils.getCount(list) || ListUtils.getCount(TeamFightLayout.this.oKK) == 0 || ListUtils.getCount(TeamFightLayout.this.oKK) != ListUtils.getCount(list2)) {
                    TeamFightLayout.this.eeT();
                    TeamFightLayout.this.oKO.removeAllViews();
                    TeamFightLayout.this.oKJ.clear();
                    TeamFightLayout.this.oKK.clear();
                    TeamFightLayout.this.aE(abVar);
                    TeamFightLayout.this.efo();
                    TeamFightLayout.this.efn();
                    TeamFightLayout.this.efm();
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
                    TeamFightLayout.this.efl();
                    TeamFightLayout.this.oKO.invalidate();
                    TeamFightLayout.this.oKO.requestLayout();
                }
                TeamFightLayout.this.efk();
                if (!ListUtils.isEmpty(TeamFightLayout.this.oKJ)) {
                    for (int i3 = 0; i3 < TeamFightLayout.this.oKJ.size(); i3++) {
                        TeamFightLayout.this.oKJ.get(i3).setData(TeamFightLayout.this.am(i3, true), i3, true, abVar);
                    }
                }
                if (!ListUtils.isEmpty(TeamFightLayout.this.oKK)) {
                    for (int i4 = 0; i4 < TeamFightLayout.this.oKK.size(); i4++) {
                        TeamFightLayout.this.oKK.get(i4).setData(TeamFightLayout.this.am(i4, false), i4, false, abVar);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efk() {
        com.baidu.tieba.yuyinala.liveroom.data.a eea = q.edM().eea();
        if (eea != null && eea.ouE != null) {
            eea.ouE.oxk = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efl() {
        this.oLX = new AlaLoadingToastView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.oLX.setLayoutParams(layoutParams);
        ViewGroup viewGroup = null;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            viewGroup = (ViewGroup) this.mTbPageContext.getPageActivity().findViewById(a.f.ala_liveroom_view);
        }
        if (viewGroup != null) {
            u.a(viewGroup, this.oLX, 650);
        } else {
            this.oKO.addView(this.oLX);
        }
        this.oLX.setVisibility(8);
        this.oLX.setContent(getContext().getResources().getString(a.h.yuyin_ala_settlement_text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efm() {
        this.oLQ = new AddTimeEndGameView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.rightMargin = e.d(10.0f, getContext());
        layoutParams.topMargin = this.Yh + e.d(19.0f, getContext());
        this.oLQ.setLayoutParams(layoutParams);
        this.oLQ.setListener(new AddTimeEndGameView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.AddTimeEndGameView.a
            public void eeP() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, q.edM().Yq().aIU.croom_id);
                    jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "timeset");
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "startbattle_clk").setContentExt(jSONObject));
                new com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a(TeamFightLayout.this.mTbPageContext.getPageActivity()).ab(q.edM().Yq());
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.AddTimeEndGameView.a
            public void eeQ() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, q.edM().Yq().aIU.croom_id);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "overtime_clk").setContentExt(jSONObject));
                TeamFightLayout.this.eeQ();
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.AddTimeEndGameView.a
            public void eeR() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, q.edM().Yq().aIU.croom_id);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "endbattle_clk").setContentExt(jSONObject));
                TeamFightLayout.this.efp();
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.AddTimeEndGameView.a
            public void eeS() {
                TeamFightLayout.this.eeS();
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.AddTimeEndGameView.a
            public int MC(int i) {
                return TeamFightLayout.this.MC(i);
            }
        });
        this.oKO.addView(this.oLQ);
        this.oLQ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efn() {
        int i;
        int i2;
        int i3;
        int i4;
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] >= (this.oKM * 4) + e.d(14.0f, getContext())) {
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
        this.oLR = new TBLottieAnimationView(getContext());
        this.oLR.setImageAssetsFolder("lottie/yuyin_connection_wheat_red_safety_mask/");
        this.oLR.setAnimation("lottie/yuyin_connection_wheat_red_safety_mask.json");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i4);
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = this.Yh + this.oKN + e.d(70.0f, getContext());
        this.oLR.setLayoutParams(layoutParams);
        this.oKO.addView(this.oLR);
        this.oLS = new TBLottieAnimationView(getContext());
        this.oLS.setImageAssetsFolder("lottie/yuyin_connection_wheat_red_advantage/");
        this.oLS.setAnimation("lottie/yuyin_connection_wheat_red_advantage.json");
        this.oLS.setRepeatMode(1);
        this.oLS.setRepeatCount(-1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i4);
        layoutParams2.leftMargin = i2;
        layoutParams2.topMargin = this.Yh + this.oKN + e.d(70.0f, getContext());
        this.oLS.setLayoutParams(layoutParams2);
        this.oKO.addView(this.oLS);
        this.oLT = new TBLottieAnimationView(getContext());
        this.oLT.setImageAssetsFolder("lottie/yuyin_connection_wheat_blue_safety_mask/");
        this.oLT.setAnimation("lottie/yuyin_connection_wheat_blue_safety_mask.json");
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i, i4);
        layoutParams3.topMargin = this.Yh + this.oKN + e.d(70.0f, getContext());
        layoutParams3.leftMargin = (screenFullSize[0] / 2) + i3;
        this.oLT.setLayoutParams(layoutParams3);
        this.oKO.addView(this.oLT);
        this.oLU = new TBLottieAnimationView(getContext());
        this.oLU.setImageAssetsFolder("lottie/yuyin_connection_wheat_blue_advantage/");
        this.oLU.setAnimation("lottie/yuyin_connection_wheat_blue_advantage.json");
        this.oLU.setRepeatMode(1);
        this.oLU.setRepeatCount(-1);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(i, i4);
        layoutParams4.leftMargin = (screenFullSize[0] / 2) + i3;
        layoutParams4.topMargin = this.Yh + this.oKN + e.d(70.0f, getContext());
        this.oLU.setLayoutParams(layoutParams4);
        this.oKO.addView(this.oLU);
    }

    public void ME(int i) {
        if (i == 0) {
            if (this.oLR != null) {
                this.oLR.setVisibility(0);
                this.oLR.playAnimation();
            }
        } else if (i == 1) {
            if (this.oLS != null) {
                this.oLS.setVisibility(0);
                this.oLS.playAnimation();
            }
        } else if (i == 2) {
            if (this.oLT != null) {
                this.oLT.setVisibility(0);
                this.oLT.playAnimation();
            }
        } else if (i == 3 && this.oLU != null) {
            this.oLU.setVisibility(0);
            this.oLU.playAnimation();
        }
    }

    public void MF(int i) {
        if (i == 0) {
            if (this.oLR != null) {
                this.oLR.setVisibility(8);
                this.oLR.pauseAnimation();
            }
        } else if (i == 1) {
            if (this.oLS != null) {
                this.oLS.setVisibility(8);
                this.oLS.pauseAnimation();
            }
        } else if (i == 2) {
            if (this.oLT != null) {
                this.oLT.setVisibility(8);
                this.oLT.pauseAnimation();
            }
        } else if (i == 3 && this.oLU != null) {
            this.oLU.setVisibility(8);
            this.oLU.pauseAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(ab abVar) {
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            this.oMd = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.oMd.setId(a.f.ala_liveroom_live_pk_bar);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.Yh + e.d(62.0f, getContext());
            this.oKO.addView(this.oMd, layoutParams);
            q.edM().eea();
        }
    }

    public void b(c cVar) {
        if (this.oMd != null) {
            this.oMd.b(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efo() {
        int i;
        this.oLV = new ImageView(getContext());
        int d = e.d(228.0f, getContext());
        if (this.mTbPageContext == null || this.mTbPageContext.getPageActivity() == null) {
            i = 0;
        } else {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
            if (screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] >= (this.oKM * 4) + e.d(14.0f, getContext())) {
                i = e.d(7.0f, getContext());
                d = (int) ((((screenFullSize[0] - e.d(14.0f, getContext())) * 72) * 1.0d) / 120.0d);
            } else {
                d = (int) (((screenFullSize[0] * 72) * 1.0d) / 120.0d);
                i = 0;
            }
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, d);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.Yh + this.oKN + e.d(70.0f, getContext());
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        this.oLV.setLayoutParams(layoutParams);
        this.oLV.setBackgroundResource(a.e.yuyin_audio_wheat_team_fight_bg);
        this.oKO.addView(this.oLV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] an(int i, boolean z) {
        int[] iArr = new int[2];
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (z) {
            iArr[0] = (screenFullSize[0] / 2) - (this.oKM / 2);
            iArr[1] = this.Yh;
        } else {
            int d = ((this.mTbPageContext == null || this.mTbPageContext.getPageActivity() == null) && screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] >= (this.oKM * 4) + e.d(5.0f, getContext())) ? e.d(5.0f, getContext()) : 0;
            if (i == 0) {
                iArr[0] = (((screenFullSize[0] / 2) - this.oKM) - this.oKM) - d;
                iArr[1] = this.Yh + this.oKN + e.d(75.0f, getContext());
            } else if (i == 1) {
                iArr[0] = ((screenFullSize[0] / 2) - this.oKM) - d;
                iArr[1] = this.Yh + this.oKN + e.d(75.0f, getContext());
            } else if (i == 2) {
                iArr[0] = (((screenFullSize[0] / 2) - this.oKM) - this.oKM) - d;
                iArr[1] = this.Yh + this.oKN + e.d(75.0f, getContext()) + this.oKN;
            } else if (i == 3) {
                iArr[0] = ((screenFullSize[0] / 2) - this.oKM) - d;
                iArr[1] = this.Yh + this.oKN + e.d(75.0f, getContext()) + this.oKN;
            } else if (i == 4) {
                iArr[0] = d + (screenFullSize[0] / 2);
                iArr[1] = this.Yh + this.oKN + e.d(75.0f, getContext());
            } else if (i == 5) {
                iArr[0] = d + (screenFullSize[0] / 2) + this.oKM;
                iArr[1] = this.Yh + this.oKN + e.d(75.0f, getContext());
            } else if (i == 6) {
                iArr[0] = d + (screenFullSize[0] / 2);
                iArr[1] = this.Yh + this.oKN + e.d(75.0f, getContext()) + this.oKN;
            } else if (i == 7) {
                iArr[0] = d + (screenFullSize[0] / 2) + this.oKM;
                iArr[1] = this.Yh + this.oKN + e.d(75.0f, getContext()) + this.oKN;
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
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.oKM, this.oKN);
        layoutParams.leftMargin = iArr[0];
        layoutParams.topMargin = iArr[1];
        wheatItemView.setLayoutParams(layoutParams);
        this.oKO.addView(wheatItemView);
        wheatItemView.setOnItemClickListener(this.oKI);
        if (z) {
            this.oKJ.add(wheatItemView);
        } else {
            this.oKK.add(wheatItemView);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        efs();
        MessageManager.getInstance().registerListener(this.oux);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.oux);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eeQ() {
        b bVar = new b(null, new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.3
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.b.a
            public void a(AddTimeHttpResponseMessage addTimeHttpResponseMessage) {
                BdToast.makeText(TeamFightLayout.this.getContext(), String.format(TeamFightLayout.this.getContext().getString(a.h.yuyin_ala_add_time_toast_text), Integer.valueOf(TeamFightLayout.this.MC(TeamFightLayout.this.activity_stage)))).show();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501082, null));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.b.a
            public void onFail(int i, String str) {
            }
        });
        ab Yq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().Yq();
        if (Yq != null && Yq.aIV != null) {
            bVar.A(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().ecT().getRoomId(), Yq.aIV.mStep, MC(this.activity_stage));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eeS() {
        this.oMa = 1;
        this.oLW = new g(this.mTbPageContext);
        this.oLW.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.4
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
            public void onCancel() {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
            public void onConfirm() {
                TeamFightLayout.this.dK(1, 1);
            }
        });
        this.oLW.show();
        this.oLW.setText(getContext().getResources().getString(a.h.yuyin_ala_punish_team_fight_text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efp() {
        this.oMa = 3;
        this.oLW = new g(this.mTbPageContext);
        this.oLW.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
            public void onCancel() {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
            public void onConfirm() {
                TeamFightLayout.this.dK(3, 1);
            }
        });
        this.oLW.show();
        this.oLW.setText(getContext().getResources().getString(a.h.yuyin_ala_end_team_fight_text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dK(final int i, int i2) {
        com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.b bVar = new com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.b(this.mTbPageContext.getPageActivity());
        bVar.A(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.av(q.edM().Yq()), i, i2);
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
        return this.Yh + this.oKN + e.d(298.0f, getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int MC(int i) {
        ab Yq;
        dh dhVar;
        int i2;
        dh dhVar2;
        if (i == 1) {
            ab Yq2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().Yq();
            if (Yq2 == null || (dhVar2 = (dh) ListUtils.getItem(Yq2.aJr, Yq2.aIY.getRoomMode())) == null) {
                i2 = 5;
            } else {
                i2 = dhVar2.aTy;
            }
            return i2;
        } else if (i != 3 || (Yq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecR().Yq()) == null || Yq.aIV == null || Yq.aIY == null || (dhVar = (dh) ListUtils.getItem(Yq.aJr, Yq.aIY.getRoomMode())) == null) {
            return 5;
        } else {
            return dhVar.aTD;
        }
    }

    public void setTeamFightProgressData(String str) {
        JSONObject optJSONObject;
        if (this.oLS == null || this.oLU == null) {
            return;
        }
        if (this.oLR != null || this.oLT != null) {
            if (TextUtils.isEmpty(str)) {
                efs();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                    this.activity_stage = optJSONObject.optInt("activity_stage");
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("pk_value");
                    this.oto = optJSONObject.optString("pk_winner");
                    if (optJSONObject2 != null) {
                        long parseLong = Long.parseLong(optJSONObject2.optString("a"));
                        long parseLong2 = Long.parseLong(optJSONObject2.optString(com.baidu.pass.biometrics.face.liveness.d.b.f4046a));
                        if (this.activity_stage == 1 && (parseLong != 0 || parseLong2 != 0)) {
                            if (parseLong == parseLong2) {
                                if (!this.oLS.isAnimating() && !this.oLU.isAnimating()) {
                                    ME(1);
                                }
                            } else if (parseLong > parseLong2) {
                                if (!this.oLS.isAnimating()) {
                                    ME(1);
                                }
                                MF(3);
                            } else {
                                if (!this.oLU.isAnimating()) {
                                    ME(3);
                                }
                                MF(1);
                            }
                            if (parseLong > this.oMb) {
                                ME(0);
                            }
                            if (parseLong2 > this.oMc) {
                                ME(2);
                            }
                            this.oMb = parseLong;
                            this.oMc = parseLong2;
                        } else {
                            this.oMb = 0L;
                            this.oMc = 0L;
                            efs();
                        }
                        efq();
                        efr();
                        if (this.oLQ != null) {
                            if (q.edM().iJ(q.edM().Yp())) {
                                this.oLQ.setVisibility(0);
                                this.oLQ.setButtonState(this.activity_stage);
                            } else {
                                this.oLQ.setVisibility(8);
                            }
                        }
                        if (this.oLX != null) {
                            this.oLX.setVisibility(this.activity_stage != 2 ? 8 : 0);
                        }
                        if (this.oLW != null && this.oLW.isShowing() && this.oMa != this.activity_stage) {
                            this.oLW.dismiss();
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void efq() {
        if (this.oLY == 0 && this.activity_stage == 1) {
            this.oLY = 1;
            View findViewById = (this.mTbPageContext == null || this.mTbPageContext.getPageActivity() == null) ? null : this.mTbPageContext.getPageActivity().findViewById(a.f.ala_liveroom_view);
            if (findViewById != null) {
                com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eeo().b((ViewGroup) findViewById, null);
            }
        } else if (this.activity_stage == 0) {
            this.oLY = 0;
        }
    }

    private void efr() {
        if (this.oLZ == 0 && this.activity_stage == 3) {
            this.oLZ = 1;
            View findViewById = (this.mTbPageContext == null || this.mTbPageContext.getPageActivity() == null) ? null : this.mTbPageContext.getPageActivity().findViewById(a.f.ala_liveroom_view);
            if (findViewById != null) {
                if ("a".equals(this.oto)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eeo().c((ViewGroup) findViewById, null);
                } else if (com.baidu.pass.biometrics.face.liveness.d.b.f4046a.equals(this.oto)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eeo().d((ViewGroup) findViewById, null);
                }
            }
        } else if (this.activity_stage == 0 || this.activity_stage == 1 || this.activity_stage == 2) {
            this.oLZ = 0;
        }
    }

    private void efs() {
        if (this.oLR != null) {
            this.oLR.setVisibility(8);
            this.oLR.pauseAnimation();
        }
        if (this.oLS != null) {
            this.oLS.setVisibility(8);
            this.oLS.pauseAnimation();
        }
        if (this.oLT != null) {
            this.oLT.setVisibility(8);
            this.oLT.pauseAnimation();
        }
        if (this.oLU != null) {
            this.oLU.setVisibility(8);
            this.oLU.pauseAnimation();
        }
    }
}
