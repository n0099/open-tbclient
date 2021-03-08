package com.baidu.tieba.yuyinala.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.data.ab;
import com.baidu.live.data.dj;
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.message.ShowRoomCard;
import com.baidu.live.message.YuyinShowRoomDialogMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tieba.view.BarImageView;
import com.baidu.tieba.yuyinala.AlaRankListActivity;
import com.baidu.tieba.yuyinala.data.c;
import com.baidu.tieba.yuyinala.data.i;
/* loaded from: classes10.dex */
public class AlaRankListHeaderView extends LinearLayout {
    private FrameLayout ikN;
    private RelativeLayout ikO;
    private TextView ikR;
    private TextView ikS;
    private RelativeLayout ikT;
    private HeadImageView ikU;
    private TextView ikW;
    private TextView ikX;
    private LottieAnimationView ikY;
    private boolean ikZ;
    private String mRoomId;
    private View mRootView;
    private AlaRankListActivity oQq;
    private BarImageView oQr;
    private com.baidu.tieba.yuyinala.data.c oQs;
    private LinearLayout oQt;

    public AlaRankListHeaderView(AlaRankListActivity alaRankListActivity, String str) {
        super(alaRankListActivity);
        this.ikZ = true;
        this.mRoomId = str;
        this.oQq = alaRankListActivity;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ikZ = true;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ikZ = true;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.g.yuyin_ala_rank_list_header_layout, this);
        this.ikN = (FrameLayout) this.mRootView.findViewById(a.f.hour_head_info);
        this.ikO = (RelativeLayout) this.mRootView.findViewById(a.f.rl_room_area);
        this.oQr = (BarImageView) this.mRootView.findViewById(a.f.room_name);
        this.oQr.setShowOval(true);
        this.oQr.setAutoChangeStyle(false);
        this.mRootView.setVisibility(0);
        this.ikN.setVisibility(0);
        this.ikO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.AlaRankListHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.oQs != null) {
                    Intent intent = AlaRankListHeaderView.this.oQq.getIntent();
                    boolean iN = com.baidu.live.ao.a.Ym().iN(intent.getStringExtra("uk"));
                    long longExtra = intent.getLongExtra("live_id", 0L);
                    try {
                        if (!String.valueOf(longExtra).equals(AlaRankListHeaderView.this.oQs.liveId)) {
                            if (AlaRankListHeaderView.this.oQs.eSY == 2) {
                                if (iN) {
                                    ab abVar = new ab();
                                    abVar.aKu = new dj();
                                    abVar.aKu.live_id = AlaRankListHeaderView.this.oQs.liveId;
                                    abVar.aKu.aVk = AlaRankListHeaderView.this.oQs.aVk;
                                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(abVar)));
                                } else {
                                    if (com.baidu.live.ao.a.Ym().isApplying()) {
                                        com.baidu.live.ao.a.Ym().Yw();
                                    }
                                    String stringExtra = intent.getStringExtra("room_id");
                                    String stringExtra2 = intent.getStringExtra("portrait");
                                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
                                    alaLastLiveroomInfo.setLastLiveId(longExtra);
                                    alaLastLiveroomInfo.setLastRoomId(Long.valueOf(stringExtra).longValue());
                                    alaLastLiveroomInfo.setIsAudio(1);
                                    alaLastLiveroomInfo.setLastAnchorPortrait(stringExtra2);
                                    YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(AlaRankListHeaderView.this.oQq);
                                    yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(AlaRankListHeaderView.this.oQs.liveId).longValue(), AlaRankListHeaderView.this.oQs.aVk, "live_sdk");
                                    yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                                }
                            } else {
                                ab abVar2 = new ab();
                                abVar2.aKu = new dj();
                                abVar2.aKu.live_id = AlaRankListHeaderView.this.oQs.liveId;
                                abVar2.aKu.aVk = AlaRankListHeaderView.this.oQs.aVk;
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(abVar2)));
                            }
                            AlaRankListHeaderView.this.oQq.finish();
                        }
                    } catch (Throwable th) {
                    }
                }
            }
        });
        this.ikR = (TextView) this.mRootView.findViewById(a.f.tv_room_name);
        this.ikS = (TextView) this.mRootView.findViewById(a.f.tv_point_room);
        this.ikU = (HeadImageView) this.mRootView.findViewById(a.f.charm_first);
        this.ikT = (RelativeLayout) this.mRootView.findViewById(a.f.rl_chram_first);
        this.ikU.setIsRound(true);
        this.ikU.setAutoChangeStyle(false);
        this.ikT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a aVar;
                if (AlaRankListHeaderView.this.oQs != null && AlaRankListHeaderView.this.oQs.gUE != null && AlaRankListHeaderView.this.oQs.gUE.size() > 0 && (aVar = AlaRankListHeaderView.this.oQs.gUE.get(0)) != null) {
                    try {
                        AlaRankListHeaderView.this.K(ExtraParamsManager.getDecryptUserId(aVar.uk), aVar.userName, aVar.portrait, aVar.getNameShow());
                    } catch (Exception e) {
                    }
                }
            }
        });
        this.ikW = (TextView) this.mRootView.findViewById(a.f.name_charm_1);
        this.ikX = (TextView) this.mRootView.findViewById(a.f.point_charm_1);
        this.ikY = (LottieAnimationView) this.mRootView.findViewById(a.f.anchor_live_anim);
        this.oQt = (LinearLayout) this.mRootView.findViewById(a.f.ll_living);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(String str, String str2, String str3, String str4) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.oQq.getPageContext().getPageActivity(), str, str2, str3, 0, 0, null, null, 0L, 0L, 0L, 0, "", Long.toString(this.oQq.getIntent().getLongExtra("live_id", 0L)), false, "", null, str4, "")));
        this.oQq.finish();
    }

    public void b(i iVar) {
        c.a aVar;
        com.baidu.tieba.yuyinala.data.c cVar = iVar.getList().get(0);
        if (cVar != null) {
            this.oQs = cVar;
            this.oQr.startLoad(cVar.cover, 12, false);
            this.ikR.setText(cVar.getNameShow());
            this.ikS.setText(String.format(this.oQq.getString(a.h.head_hour_rank_anchor), StringHelper.formatYuyinValue(cVar.aIe)));
            if (cVar.eSY == 2) {
                this.oQt.setVisibility(0);
                this.ikY.loop(true);
                this.ikY.setAnimation("alavl_room_living.json");
                this.ikY.playAnimation();
            } else {
                this.oQt.setVisibility(8);
            }
            if (cVar.gUE != null && (aVar = cVar.gUE.get(0)) != null) {
                this.ikU.startLoad(aVar.portrait, 12, false);
                this.ikW.setText(aVar.userNickName);
                this.ikX.setText(String.format(this.oQq.getString(a.h.head_hour_rank_gold), StringHelper.formatYuyinValue(aVar.aXc)));
            }
        }
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.ikN != null) {
            this.ikN.setVisibility(i);
        }
    }
}
