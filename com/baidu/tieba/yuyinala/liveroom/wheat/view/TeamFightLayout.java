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
    private int oLA;
    private long oLB;
    private long oLC;
    private AlaChallengeLiveView oLD;
    private AddTimeEndGameView oLq;
    private TBLottieAnimationView oLr;
    private TBLottieAnimationView oLs;
    private TBLottieAnimationView oLt;
    private TBLottieAnimationView oLu;
    private ImageView oLv;
    private g oLw;
    private AlaLoadingToastView oLx;
    private int oLy;
    private int oLz;
    private String osO;
    public CustomMessageListener otW;

    public TeamFightLayout(@NonNull Context context) {
        this(context, null);
    }

    public TeamFightLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TeamFightLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oLy = 1;
        this.oLz = 1;
        this.Yh = e.d(94.0f, getContext());
        this.otW = new CustomMessageListener(2501014) { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501014 && (customResponsedMessage.getData() instanceof com.baidu.live.data.g) && ((com.baidu.live.data.g) customResponsedMessage.getData()).Bm() != 2 && TeamFightLayout.this.oLw != null && TeamFightLayout.this.oLw.isShowing()) {
                    TeamFightLayout.this.oLw.dismiss();
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
                TeamFightLayout.this.oJf = list;
                TeamFightLayout.this.oJg = list2;
                if (ListUtils.getCount(TeamFightLayout.this.oKj) == 0 || ListUtils.getCount(TeamFightLayout.this.oKj) != ListUtils.getCount(list) || ListUtils.getCount(TeamFightLayout.this.oKk) == 0 || ListUtils.getCount(TeamFightLayout.this.oKk) != ListUtils.getCount(list2)) {
                    TeamFightLayout.this.eeL();
                    TeamFightLayout.this.oKo.removeAllViews();
                    TeamFightLayout.this.oKj.clear();
                    TeamFightLayout.this.oKk.clear();
                    TeamFightLayout.this.aE(abVar);
                    TeamFightLayout.this.efg();
                    TeamFightLayout.this.eff();
                    TeamFightLayout.this.efe();
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
                    TeamFightLayout.this.efd();
                    TeamFightLayout.this.oKo.invalidate();
                    TeamFightLayout.this.oKo.requestLayout();
                }
                TeamFightLayout.this.efc();
                if (!ListUtils.isEmpty(TeamFightLayout.this.oKj)) {
                    for (int i3 = 0; i3 < TeamFightLayout.this.oKj.size(); i3++) {
                        TeamFightLayout.this.oKj.get(i3).setData(TeamFightLayout.this.am(i3, true), i3, true, abVar);
                    }
                }
                if (!ListUtils.isEmpty(TeamFightLayout.this.oKk)) {
                    for (int i4 = 0; i4 < TeamFightLayout.this.oKk.size(); i4++) {
                        TeamFightLayout.this.oKk.get(i4).setData(TeamFightLayout.this.am(i4, false), i4, false, abVar);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efc() {
        com.baidu.tieba.yuyinala.liveroom.data.a edS = q.edE().edS();
        if (edS != null && edS.oud != null) {
            edS.oud.owK = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efd() {
        this.oLx = new AlaLoadingToastView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.oLx.setLayoutParams(layoutParams);
        ViewGroup viewGroup = null;
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            viewGroup = (ViewGroup) this.mTbPageContext.getPageActivity().findViewById(a.f.ala_liveroom_view);
        }
        if (viewGroup != null) {
            u.a(viewGroup, this.oLx, 650);
        } else {
            this.oKo.addView(this.oLx);
        }
        this.oLx.setVisibility(8);
        this.oLx.setContent(getContext().getResources().getString(a.h.yuyin_ala_settlement_text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efe() {
        this.oLq = new AddTimeEndGameView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.rightMargin = e.d(10.0f, getContext());
        layoutParams.topMargin = this.Yh + e.d(19.0f, getContext());
        this.oLq.setLayoutParams(layoutParams);
        this.oLq.setListener(new AddTimeEndGameView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.2
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.AddTimeEndGameView.a
            public void eeH() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, q.edE().Yq().aIU.croom_id);
                    jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "timeset");
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "startbattle_clk").setContentExt(jSONObject));
                new com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.a(TeamFightLayout.this.mTbPageContext.getPageActivity()).ab(q.edE().Yq());
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.AddTimeEndGameView.a
            public void eeI() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, q.edE().Yq().aIU.croom_id);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "overtime_clk").setContentExt(jSONObject));
                TeamFightLayout.this.eeI();
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.AddTimeEndGameView.a
            public void eeJ() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, q.edE().Yq().aIU.croom_id);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "endbattle_clk").setContentExt(jSONObject));
                TeamFightLayout.this.efh();
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.AddTimeEndGameView.a
            public void eeK() {
                TeamFightLayout.this.eeK();
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.AddTimeEndGameView.a
            public int MB(int i) {
                return TeamFightLayout.this.MB(i);
            }
        });
        this.oKo.addView(this.oLq);
        this.oLq.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eff() {
        int i;
        int i2;
        int i3;
        int i4;
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] >= (this.oKm * 4) + e.d(14.0f, getContext())) {
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
        this.oLr = new TBLottieAnimationView(getContext());
        this.oLr.setImageAssetsFolder("lottie/yuyin_connection_wheat_red_safety_mask/");
        this.oLr.setAnimation("lottie/yuyin_connection_wheat_red_safety_mask.json");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i4);
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = this.Yh + this.oKn + e.d(70.0f, getContext());
        this.oLr.setLayoutParams(layoutParams);
        this.oKo.addView(this.oLr);
        this.oLs = new TBLottieAnimationView(getContext());
        this.oLs.setImageAssetsFolder("lottie/yuyin_connection_wheat_red_advantage/");
        this.oLs.setAnimation("lottie/yuyin_connection_wheat_red_advantage.json");
        this.oLs.setRepeatMode(1);
        this.oLs.setRepeatCount(-1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i4);
        layoutParams2.leftMargin = i2;
        layoutParams2.topMargin = this.Yh + this.oKn + e.d(70.0f, getContext());
        this.oLs.setLayoutParams(layoutParams2);
        this.oKo.addView(this.oLs);
        this.oLt = new TBLottieAnimationView(getContext());
        this.oLt.setImageAssetsFolder("lottie/yuyin_connection_wheat_blue_safety_mask/");
        this.oLt.setAnimation("lottie/yuyin_connection_wheat_blue_safety_mask.json");
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i, i4);
        layoutParams3.topMargin = this.Yh + this.oKn + e.d(70.0f, getContext());
        layoutParams3.leftMargin = (screenFullSize[0] / 2) + i3;
        this.oLt.setLayoutParams(layoutParams3);
        this.oKo.addView(this.oLt);
        this.oLu = new TBLottieAnimationView(getContext());
        this.oLu.setImageAssetsFolder("lottie/yuyin_connection_wheat_blue_advantage/");
        this.oLu.setAnimation("lottie/yuyin_connection_wheat_blue_advantage.json");
        this.oLu.setRepeatMode(1);
        this.oLu.setRepeatCount(-1);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(i, i4);
        layoutParams4.leftMargin = (screenFullSize[0] / 2) + i3;
        layoutParams4.topMargin = this.Yh + this.oKn + e.d(70.0f, getContext());
        this.oLu.setLayoutParams(layoutParams4);
        this.oKo.addView(this.oLu);
    }

    public void MD(int i) {
        if (i == 0) {
            if (this.oLr != null) {
                this.oLr.setVisibility(0);
                this.oLr.playAnimation();
            }
        } else if (i == 1) {
            if (this.oLs != null) {
                this.oLs.setVisibility(0);
                this.oLs.playAnimation();
            }
        } else if (i == 2) {
            if (this.oLt != null) {
                this.oLt.setVisibility(0);
                this.oLt.playAnimation();
            }
        } else if (i == 3 && this.oLu != null) {
            this.oLu.setVisibility(0);
            this.oLu.playAnimation();
        }
    }

    public void ME(int i) {
        if (i == 0) {
            if (this.oLr != null) {
                this.oLr.setVisibility(8);
                this.oLr.pauseAnimation();
            }
        } else if (i == 1) {
            if (this.oLs != null) {
                this.oLs.setVisibility(8);
                this.oLs.pauseAnimation();
            }
        } else if (i == 2) {
            if (this.oLt != null) {
                this.oLt.setVisibility(8);
                this.oLt.pauseAnimation();
            }
        } else if (i == 3 && this.oLu != null) {
            this.oLu.setVisibility(8);
            this.oLu.pauseAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(ab abVar) {
        if (this.mTbPageContext != null && this.mTbPageContext.getPageActivity() != null) {
            this.oLD = new AlaChallengeLiveView(this.mTbPageContext.getPageActivity());
            this.oLD.setId(a.f.ala_liveroom_live_pk_bar);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.Yh + e.d(62.0f, getContext());
            this.oKo.addView(this.oLD, layoutParams);
            q.edE().edS();
        }
    }

    public void b(c cVar) {
        if (this.oLD != null) {
            this.oLD.b(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efg() {
        int i;
        this.oLv = new ImageView(getContext());
        int d = e.d(228.0f, getContext());
        if (this.mTbPageContext == null || this.mTbPageContext.getPageActivity() == null) {
            i = 0;
        } else {
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
            if (screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] >= (this.oKm * 4) + e.d(14.0f, getContext())) {
                i = e.d(7.0f, getContext());
                d = (int) ((((screenFullSize[0] - e.d(14.0f, getContext())) * 72) * 1.0d) / 120.0d);
            } else {
                d = (int) (((screenFullSize[0] * 72) * 1.0d) / 120.0d);
                i = 0;
            }
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, d);
        layoutParams.addRule(14);
        layoutParams.topMargin = this.Yh + this.oKn + e.d(70.0f, getContext());
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        this.oLv.setLayoutParams(layoutParams);
        this.oLv.setBackgroundResource(a.e.yuyin_audio_wheat_team_fight_bg);
        this.oKo.addView(this.oLv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] an(int i, boolean z) {
        int[] iArr = new int[2];
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (z) {
            iArr[0] = (screenFullSize[0] / 2) - (this.oKm / 2);
            iArr[1] = this.Yh;
        } else {
            int d = ((this.mTbPageContext == null || this.mTbPageContext.getPageActivity() == null) && screenFullSize.length > 0 && screenFullSize[0] > 0 && screenFullSize[0] >= (this.oKm * 4) + e.d(5.0f, getContext())) ? e.d(5.0f, getContext()) : 0;
            if (i == 0) {
                iArr[0] = (((screenFullSize[0] / 2) - this.oKm) - this.oKm) - d;
                iArr[1] = this.Yh + this.oKn + e.d(75.0f, getContext());
            } else if (i == 1) {
                iArr[0] = ((screenFullSize[0] / 2) - this.oKm) - d;
                iArr[1] = this.Yh + this.oKn + e.d(75.0f, getContext());
            } else if (i == 2) {
                iArr[0] = (((screenFullSize[0] / 2) - this.oKm) - this.oKm) - d;
                iArr[1] = this.Yh + this.oKn + e.d(75.0f, getContext()) + this.oKn;
            } else if (i == 3) {
                iArr[0] = ((screenFullSize[0] / 2) - this.oKm) - d;
                iArr[1] = this.Yh + this.oKn + e.d(75.0f, getContext()) + this.oKn;
            } else if (i == 4) {
                iArr[0] = d + (screenFullSize[0] / 2);
                iArr[1] = this.Yh + this.oKn + e.d(75.0f, getContext());
            } else if (i == 5) {
                iArr[0] = d + (screenFullSize[0] / 2) + this.oKm;
                iArr[1] = this.Yh + this.oKn + e.d(75.0f, getContext());
            } else if (i == 6) {
                iArr[0] = d + (screenFullSize[0] / 2);
                iArr[1] = this.Yh + this.oKn + e.d(75.0f, getContext()) + this.oKn;
            } else if (i == 7) {
                iArr[0] = d + (screenFullSize[0] / 2) + this.oKm;
                iArr[1] = this.Yh + this.oKn + e.d(75.0f, getContext()) + this.oKn;
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
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.oKm, this.oKn);
        layoutParams.leftMargin = iArr[0];
        layoutParams.topMargin = iArr[1];
        wheatItemView.setLayoutParams(layoutParams);
        this.oKo.addView(wheatItemView);
        wheatItemView.setOnItemClickListener(this.oKi);
        if (z) {
            this.oKj.add(wheatItemView);
        } else {
            this.oKk.add(wheatItemView);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        efk();
        MessageManager.getInstance().registerListener(this.otW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.otW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eeI() {
        b bVar = new b(null, new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.3
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.b.a
            public void a(AddTimeHttpResponseMessage addTimeHttpResponseMessage) {
                BdToast.makeText(TeamFightLayout.this.getContext(), String.format(TeamFightLayout.this.getContext().getString(a.h.yuyin_ala_add_time_toast_text), Integer.valueOf(TeamFightLayout.this.MB(TeamFightLayout.this.activity_stage)))).show();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501082, null));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.model.b.a
            public void onFail(int i, String str) {
            }
        });
        ab Yq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().Yq();
        if (Yq != null && Yq.aIV != null) {
            bVar.A(com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().ecL().getRoomId(), Yq.aIV.mStep, MB(this.activity_stage));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eeK() {
        this.oLA = 1;
        this.oLw = new g(this.mTbPageContext);
        this.oLw.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.4
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
            public void onCancel() {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
            public void onConfirm() {
                TeamFightLayout.this.dJ(1, 1);
            }
        });
        this.oLw.show();
        this.oLw.setText(getContext().getResources().getString(a.h.yuyin_ala_punish_team_fight_text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void efh() {
        this.oLA = 3;
        this.oLw = new g(this.mTbPageContext);
        this.oLw.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.TeamFightLayout.5
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
            public void onCancel() {
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
            public void onConfirm() {
                TeamFightLayout.this.dJ(3, 1);
            }
        });
        this.oLw.show();
        this.oLw.setText(getContext().getResources().getString(a.h.yuyin_ala_end_team_fight_text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJ(final int i, int i2) {
        com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.b bVar = new com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.b(this.mTbPageContext.getPageActivity());
        bVar.A(com.baidu.tieba.yuyinala.liveroom.wheat.e.g.av(q.edE().Yq()), i, i2);
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
        return this.Yh + this.oKn + e.d(298.0f, getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int MB(int i) {
        ab Yq;
        dh dhVar;
        int i2;
        dh dhVar2;
        if (i == 1) {
            ab Yq2 = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().Yq();
            if (Yq2 == null || (dhVar2 = (dh) ListUtils.getItem(Yq2.aJr, Yq2.aIY.getRoomMode())) == null) {
                i2 = 5;
            } else {
                i2 = dhVar2.aTy;
            }
            return i2;
        } else if (i != 3 || (Yq = com.baidu.tieba.yuyinala.liveroom.wheat.a.c.ecJ().Yq()) == null || Yq.aIV == null || Yq.aIY == null || (dhVar = (dh) ListUtils.getItem(Yq.aJr, Yq.aIY.getRoomMode())) == null) {
            return 5;
        } else {
            return dhVar.aTD;
        }
    }

    public void setTeamFightProgressData(String str) {
        JSONObject optJSONObject;
        if (this.oLs == null || this.oLu == null) {
            return;
        }
        if (this.oLr != null || this.oLt != null) {
            if (TextUtils.isEmpty(str)) {
                efk();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                    this.activity_stage = optJSONObject.optInt("activity_stage");
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("pk_value");
                    this.osO = optJSONObject.optString("pk_winner");
                    if (optJSONObject2 != null) {
                        long parseLong = Long.parseLong(optJSONObject2.optString("a"));
                        long parseLong2 = Long.parseLong(optJSONObject2.optString(com.baidu.pass.biometrics.face.liveness.d.b.f4046a));
                        if (this.activity_stage == 1 && (parseLong != 0 || parseLong2 != 0)) {
                            if (parseLong == parseLong2) {
                                if (!this.oLs.isAnimating() && !this.oLu.isAnimating()) {
                                    MD(1);
                                }
                            } else if (parseLong > parseLong2) {
                                if (!this.oLs.isAnimating()) {
                                    MD(1);
                                }
                                ME(3);
                            } else {
                                if (!this.oLu.isAnimating()) {
                                    MD(3);
                                }
                                ME(1);
                            }
                            if (parseLong > this.oLB) {
                                MD(0);
                            }
                            if (parseLong2 > this.oLC) {
                                MD(2);
                            }
                            this.oLB = parseLong;
                            this.oLC = parseLong2;
                        } else {
                            this.oLB = 0L;
                            this.oLC = 0L;
                            efk();
                        }
                        efi();
                        efj();
                        if (this.oLq != null) {
                            if (q.edE().iJ(q.edE().Yp())) {
                                this.oLq.setVisibility(0);
                                this.oLq.setButtonState(this.activity_stage);
                            } else {
                                this.oLq.setVisibility(8);
                            }
                        }
                        if (this.oLx != null) {
                            this.oLx.setVisibility(this.activity_stage != 2 ? 8 : 0);
                        }
                        if (this.oLw != null && this.oLw.isShowing() && this.oLA != this.activity_stage) {
                            this.oLw.dismiss();
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void efi() {
        if (this.oLy == 0 && this.activity_stage == 1) {
            this.oLy = 1;
            View findViewById = (this.mTbPageContext == null || this.mTbPageContext.getPageActivity() == null) ? null : this.mTbPageContext.getPageActivity().findViewById(a.f.ala_liveroom_view);
            if (findViewById != null) {
                com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eeg().b((ViewGroup) findViewById, null);
            }
        } else if (this.activity_stage == 0) {
            this.oLy = 0;
        }
    }

    private void efj() {
        if (this.oLz == 0 && this.activity_stage == 3) {
            this.oLz = 1;
            View findViewById = (this.mTbPageContext == null || this.mTbPageContext.getPageActivity() == null) ? null : this.mTbPageContext.getPageActivity().findViewById(a.f.ala_liveroom_view);
            if (findViewById != null) {
                if ("a".equals(this.osO)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eeg().c((ViewGroup) findViewById, null);
                } else if (com.baidu.pass.biometrics.face.liveness.d.b.f4046a.equals(this.osO)) {
                    com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eeg().d((ViewGroup) findViewById, null);
                }
            }
        } else if (this.activity_stage == 0 || this.activity_stage == 1 || this.activity_stage == 2) {
            this.oLz = 0;
        }
    }

    private void efk() {
        if (this.oLr != null) {
            this.oLr.setVisibility(8);
            this.oLr.pauseAnimation();
        }
        if (this.oLs != null) {
            this.oLs.setVisibility(8);
            this.oLs.pauseAnimation();
        }
        if (this.oLt != null) {
            this.oLt.setVisibility(8);
            this.oLt.pauseAnimation();
        }
        if (this.oLu != null) {
            this.oLu.setVisibility(8);
            this.oLu.pauseAnimation();
        }
    }
}
