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
/* loaded from: classes11.dex */
public class AlaRankListHeaderView extends LinearLayout {
    private FrameLayout iiQ;
    private RelativeLayout iiR;
    private TextView iiU;
    private TextView iiV;
    private RelativeLayout iiW;
    private HeadImageView iiX;
    private TextView iiZ;
    private TextView ija;
    private LottieAnimationView ijb;
    private boolean ijc;
    private String mRoomId;
    private View mRootView;
    private AlaRankListActivity oNL;
    private BarImageView oNM;
    private com.baidu.tieba.yuyinala.data.c oNN;
    private LinearLayout oNO;

    public AlaRankListHeaderView(AlaRankListActivity alaRankListActivity, String str) {
        super(alaRankListActivity);
        this.ijc = true;
        this.mRoomId = str;
        this.oNL = alaRankListActivity;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ijc = true;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ijc = true;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.g.yuyin_ala_rank_list_header_layout, this);
        this.iiQ = (FrameLayout) this.mRootView.findViewById(a.f.hour_head_info);
        this.iiR = (RelativeLayout) this.mRootView.findViewById(a.f.rl_room_area);
        this.oNM = (BarImageView) this.mRootView.findViewById(a.f.room_name);
        this.oNM.setShowOval(true);
        this.oNM.setAutoChangeStyle(false);
        this.mRootView.setVisibility(0);
        this.iiQ.setVisibility(0);
        this.iiR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.AlaRankListHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.oNN != null) {
                    Intent intent = AlaRankListHeaderView.this.oNL.getIntent();
                    boolean iH = com.baidu.live.ao.a.Yj().iH(intent.getStringExtra("uk"));
                    long longExtra = intent.getLongExtra("live_id", 0L);
                    try {
                        if (!String.valueOf(longExtra).equals(AlaRankListHeaderView.this.oNN.liveId)) {
                            if (AlaRankListHeaderView.this.oNN.eRx == 2) {
                                if (iH) {
                                    ab abVar = new ab();
                                    abVar.aIU = new dj();
                                    abVar.aIU.live_id = AlaRankListHeaderView.this.oNN.liveId;
                                    abVar.aIU.aTK = AlaRankListHeaderView.this.oNN.aTK;
                                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(abVar)));
                                } else {
                                    if (com.baidu.live.ao.a.Yj().isApplying()) {
                                        com.baidu.live.ao.a.Yj().Yt();
                                    }
                                    String stringExtra = intent.getStringExtra("room_id");
                                    String stringExtra2 = intent.getStringExtra("portrait");
                                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
                                    alaLastLiveroomInfo.setLastLiveId(longExtra);
                                    alaLastLiveroomInfo.setLastRoomId(Long.valueOf(stringExtra).longValue());
                                    alaLastLiveroomInfo.setIsAudio(1);
                                    alaLastLiveroomInfo.setLastAnchorPortrait(stringExtra2);
                                    YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(AlaRankListHeaderView.this.oNL);
                                    yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(AlaRankListHeaderView.this.oNN.liveId).longValue(), AlaRankListHeaderView.this.oNN.aTK, "live_sdk");
                                    yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                                }
                            } else {
                                ab abVar2 = new ab();
                                abVar2.aIU = new dj();
                                abVar2.aIU.live_id = AlaRankListHeaderView.this.oNN.liveId;
                                abVar2.aIU.aTK = AlaRankListHeaderView.this.oNN.aTK;
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(abVar2)));
                            }
                            AlaRankListHeaderView.this.oNL.finish();
                        }
                    } catch (Throwable th) {
                    }
                }
            }
        });
        this.iiU = (TextView) this.mRootView.findViewById(a.f.tv_room_name);
        this.iiV = (TextView) this.mRootView.findViewById(a.f.tv_point_room);
        this.iiX = (HeadImageView) this.mRootView.findViewById(a.f.charm_first);
        this.iiW = (RelativeLayout) this.mRootView.findViewById(a.f.rl_chram_first);
        this.iiX.setIsRound(true);
        this.iiX.setAutoChangeStyle(false);
        this.iiW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a aVar;
                if (AlaRankListHeaderView.this.oNN != null && AlaRankListHeaderView.this.oNN.gSH != null && AlaRankListHeaderView.this.oNN.gSH.size() > 0 && (aVar = AlaRankListHeaderView.this.oNN.gSH.get(0)) != null) {
                    try {
                        AlaRankListHeaderView.this.K(ExtraParamsManager.getDecryptUserId(aVar.uk), aVar.userName, aVar.portrait, aVar.getNameShow());
                    } catch (Exception e) {
                    }
                }
            }
        });
        this.iiZ = (TextView) this.mRootView.findViewById(a.f.name_charm_1);
        this.ija = (TextView) this.mRootView.findViewById(a.f.point_charm_1);
        this.ijb = (LottieAnimationView) this.mRootView.findViewById(a.f.anchor_live_anim);
        this.oNO = (LinearLayout) this.mRootView.findViewById(a.f.ll_living);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(String str, String str2, String str3, String str4) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.oNL.getPageContext().getPageActivity(), str, str2, str3, 0, 0, null, null, 0L, 0L, 0L, 0, "", Long.toString(this.oNL.getIntent().getLongExtra("live_id", 0L)), false, "", null, str4, "")));
        this.oNL.finish();
    }

    public void b(i iVar) {
        c.a aVar;
        com.baidu.tieba.yuyinala.data.c cVar = iVar.getList().get(0);
        if (cVar != null) {
            this.oNN = cVar;
            this.oNM.startLoad(cVar.cover, 12, false);
            this.iiU.setText(cVar.getNameShow());
            this.iiV.setText(String.format(this.oNL.getString(a.h.head_hour_rank_anchor), StringHelper.formatYuyinValue(cVar.aGE)));
            if (cVar.eRx == 2) {
                this.oNO.setVisibility(0);
                this.ijb.loop(true);
                this.ijb.setAnimation("alavl_room_living.json");
                this.ijb.playAnimation();
            } else {
                this.oNO.setVisibility(8);
            }
            if (cVar.gSH != null && (aVar = cVar.gSH.get(0)) != null) {
                this.iiX.startLoad(aVar.portrait, 12, false);
                this.iiZ.setText(aVar.userNickName);
                this.ija.setText(String.format(this.oNL.getString(a.h.head_hour_rank_gold), StringHelper.formatYuyinValue(aVar.aVC)));
            }
        }
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.iiQ != null) {
            this.iiQ.setVisibility(i);
        }
    }
}
