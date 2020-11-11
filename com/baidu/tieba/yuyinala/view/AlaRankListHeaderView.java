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
import com.baidu.live.data.cx;
import com.baidu.live.data.w;
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
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes4.dex */
public class AlaRankListHeaderView extends LinearLayout {
    private FrameLayout hLA;
    private RelativeLayout hLB;
    private TextView hLE;
    private TextView hLF;
    private RelativeLayout hLG;
    private HeadImageView hLH;
    private TextView hLJ;
    private TextView hLK;
    private LottieAnimationView hLL;
    private boolean hLM;
    private String mRoomId;
    private View mRootView;
    private AlaRankListActivity ojN;
    private BarImageView ojO;
    private com.baidu.tieba.yuyinala.data.c ojP;
    private LinearLayout ojQ;

    public AlaRankListHeaderView(AlaRankListActivity alaRankListActivity, String str) {
        super(alaRankListActivity);
        this.hLM = true;
        this.mRoomId = str;
        this.ojN = alaRankListActivity;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hLM = true;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hLM = true;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.g.yuyin_ala_rank_list_header_layout, this);
        this.hLA = (FrameLayout) this.mRootView.findViewById(a.f.hour_head_info);
        this.hLB = (RelativeLayout) this.mRootView.findViewById(a.f.rl_room_area);
        this.ojO = (BarImageView) this.mRootView.findViewById(a.f.room_name);
        this.ojO.setShowOval(true);
        this.ojO.setAutoChangeStyle(false);
        this.mRootView.setVisibility(0);
        this.hLA.setVisibility(0);
        this.hLB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.AlaRankListHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.ojP != null) {
                    Intent intent = AlaRankListHeaderView.this.ojN.getIntent();
                    boolean iV = com.baidu.live.al.b.Xh().iV(intent.getStringExtra("uk"));
                    long longExtra = intent.getLongExtra("live_id", 0L);
                    try {
                        if (!String.valueOf(longExtra).equals(AlaRankListHeaderView.this.ojP.liveId)) {
                            if (AlaRankListHeaderView.this.ojP.eEI == 2) {
                                if (iV) {
                                    w wVar = new w();
                                    wVar.aJK = new cx();
                                    wVar.aJK.live_id = AlaRankListHeaderView.this.ojP.liveId;
                                    wVar.aJK.aSP = AlaRankListHeaderView.this.ojP.aSP;
                                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(wVar)));
                                } else {
                                    if (com.baidu.live.al.b.Xh().isApplying()) {
                                        com.baidu.live.al.b.Xh().Xq();
                                    }
                                    String stringExtra = intent.getStringExtra("room_id");
                                    String stringExtra2 = intent.getStringExtra("portrait");
                                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
                                    alaLastLiveroomInfo.setLastLiveId(longExtra);
                                    alaLastLiveroomInfo.setLastRoomId(Long.valueOf(stringExtra).longValue());
                                    alaLastLiveroomInfo.setIsAudio(1);
                                    alaLastLiveroomInfo.setLastAnchorPortrait(stringExtra2);
                                    YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(AlaRankListHeaderView.this.ojN);
                                    yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(AlaRankListHeaderView.this.ojP.liveId).longValue(), AlaRankListHeaderView.this.ojP.aSP, "live_sdk");
                                    yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                                }
                            } else {
                                w wVar2 = new w();
                                wVar2.aJK = new cx();
                                wVar2.aJK.live_id = AlaRankListHeaderView.this.ojP.liveId;
                                wVar2.aJK.aSP = AlaRankListHeaderView.this.ojP.aSP;
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(wVar2)));
                            }
                            AlaRankListHeaderView.this.ojN.finish();
                        }
                    } catch (Throwable th) {
                    }
                }
            }
        });
        this.hLE = (TextView) this.mRootView.findViewById(a.f.tv_room_name);
        this.hLF = (TextView) this.mRootView.findViewById(a.f.tv_point_room);
        this.hLH = (HeadImageView) this.mRootView.findViewById(a.f.charm_first);
        this.hLG = (RelativeLayout) this.mRootView.findViewById(a.f.rl_chram_first);
        this.hLH.setIsRound(true);
        this.hLH.setAutoChangeStyle(false);
        this.hLG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a aVar;
                if (AlaRankListHeaderView.this.ojP != null && AlaRankListHeaderView.this.ojP.gAl != null && AlaRankListHeaderView.this.ojP.gAl.size() > 0 && (aVar = AlaRankListHeaderView.this.ojP.gAl.get(0)) != null) {
                    try {
                        AlaRankListHeaderView.this.N(ExtraParamsManager.getDecryptUserId(aVar.uk), aVar.userName, aVar.portrait, aVar.getNameShow());
                    } catch (Exception e) {
                    }
                }
            }
        });
        this.hLJ = (TextView) this.mRootView.findViewById(a.f.name_charm_1);
        this.hLK = (TextView) this.mRootView.findViewById(a.f.point_charm_1);
        this.hLL = (LottieAnimationView) this.mRootView.findViewById(a.f.anchor_live_anim);
        this.ojQ = (LinearLayout) this.mRootView.findViewById(a.f.ll_living);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(String str, String str2, String str3, String str4) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.ojN.getPageContext().getPageActivity(), str, str2, str3, 0, 0, null, null, 0L, 0L, 0L, 0, "", Long.toString(this.ojN.getIntent().getLongExtra("live_id", 0L)), false, "", null, str4, "")));
        this.ojN.finish();
    }

    public void b(i iVar) {
        c.a aVar;
        com.baidu.tieba.yuyinala.data.c cVar = iVar.getList().get(0);
        if (cVar != null) {
            this.ojP = cVar;
            this.ojO.startLoad(cVar.cover, 12, false);
            this.hLE.setText(cVar.getNameShow());
            this.hLF.setText(String.format(this.ojN.getString(a.h.head_hour_rank_anchor), StringHelper.formatYuyinValue(cVar.point)));
            if (cVar.eEI == 2) {
                this.ojQ.setVisibility(0);
                this.hLL.loop(true);
                this.hLL.setAnimation("alavl_room_living.json");
                this.hLL.playAnimation();
            } else {
                this.ojQ.setVisibility(8);
            }
            if (cVar.gAl != null && (aVar = cVar.gAl.get(0)) != null) {
                this.hLH.startLoad(aVar.portrait, 12, false);
                this.hLJ.setText(aVar.userNickName);
                this.hLK.setText(String.format(this.ojN.getString(a.h.head_hour_rank_gold), StringHelper.formatYuyinValue(aVar.bjT)));
            }
        }
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.hLA != null) {
            this.hLA.setVisibility(i);
        }
    }
}
