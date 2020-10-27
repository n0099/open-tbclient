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
import com.baidu.live.data.ct;
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
    private FrameLayout hFD;
    private RelativeLayout hFE;
    private TextView hFH;
    private TextView hFI;
    private RelativeLayout hFJ;
    private HeadImageView hFK;
    private TextView hFM;
    private TextView hFN;
    private LottieAnimationView hFO;
    private boolean hFP;
    private String mRoomId;
    private View mRootView;
    private AlaRankListActivity oaH;
    private BarImageView oaI;
    private com.baidu.tieba.yuyinala.data.c oaJ;
    private LinearLayout oaK;

    public AlaRankListHeaderView(AlaRankListActivity alaRankListActivity, String str) {
        super(alaRankListActivity);
        this.hFP = true;
        this.mRoomId = str;
        this.oaH = alaRankListActivity;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hFP = true;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hFP = true;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.h.yuyin_ala_rank_list_header_layout, this);
        this.hFD = (FrameLayout) this.mRootView.findViewById(a.g.hour_head_info);
        this.hFE = (RelativeLayout) this.mRootView.findViewById(a.g.rl_room_area);
        this.oaI = (BarImageView) this.mRootView.findViewById(a.g.room_name);
        this.oaI.setShowOval(true);
        this.oaI.setAutoChangeStyle(false);
        this.mRootView.setVisibility(0);
        this.hFD.setVisibility(0);
        this.hFE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.AlaRankListHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.oaJ != null) {
                    Intent intent = AlaRankListHeaderView.this.oaH.getIntent();
                    boolean iI = com.baidu.live.aj.b.UH().iI(intent.getStringExtra("uk"));
                    long longExtra = intent.getLongExtra("live_id", 0L);
                    try {
                        if (!String.valueOf(longExtra).equals(AlaRankListHeaderView.this.oaJ.liveId)) {
                            if (AlaRankListHeaderView.this.oaJ.eyT == 2) {
                                if (iI) {
                                    w wVar = new w();
                                    wVar.aIS = new ct();
                                    wVar.aIS.live_id = AlaRankListHeaderView.this.oaJ.liveId;
                                    wVar.aIS.aRy = AlaRankListHeaderView.this.oaJ.aRy;
                                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(wVar)));
                                } else {
                                    if (com.baidu.live.aj.b.UH().UI()) {
                                        com.baidu.live.aj.b.UH().UR();
                                    }
                                    String stringExtra = intent.getStringExtra("room_id");
                                    String stringExtra2 = intent.getStringExtra("portrait");
                                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
                                    alaLastLiveroomInfo.setLastLiveId(longExtra);
                                    alaLastLiveroomInfo.setLastRoomId(Long.valueOf(stringExtra).longValue());
                                    alaLastLiveroomInfo.setIsAudio(1);
                                    alaLastLiveroomInfo.setLastAnchorPortrait(stringExtra2);
                                    YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(AlaRankListHeaderView.this.oaH);
                                    yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(AlaRankListHeaderView.this.oaJ.liveId).longValue(), AlaRankListHeaderView.this.oaJ.aRy, "live_sdk");
                                    yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                                }
                            } else {
                                w wVar2 = new w();
                                wVar2.aIS = new ct();
                                wVar2.aIS.live_id = AlaRankListHeaderView.this.oaJ.liveId;
                                wVar2.aIS.aRy = AlaRankListHeaderView.this.oaJ.aRy;
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(wVar2)));
                            }
                            AlaRankListHeaderView.this.oaH.finish();
                        }
                    } catch (Throwable th) {
                    }
                }
            }
        });
        this.hFH = (TextView) this.mRootView.findViewById(a.g.tv_room_name);
        this.hFI = (TextView) this.mRootView.findViewById(a.g.tv_point_room);
        this.hFK = (HeadImageView) this.mRootView.findViewById(a.g.charm_first);
        this.hFJ = (RelativeLayout) this.mRootView.findViewById(a.g.rl_chram_first);
        this.hFK.setIsRound(true);
        this.hFK.setAutoChangeStyle(false);
        this.hFJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a aVar;
                if (AlaRankListHeaderView.this.oaJ != null && AlaRankListHeaderView.this.oaJ.gux != null && AlaRankListHeaderView.this.oaJ.gux.size() > 0 && (aVar = AlaRankListHeaderView.this.oaJ.gux.get(0)) != null) {
                    try {
                        AlaRankListHeaderView.this.N(ExtraParamsManager.getDecryptUserId(aVar.uk), aVar.userName, aVar.portrait, aVar.getNameShow());
                    } catch (Exception e) {
                    }
                }
            }
        });
        this.hFM = (TextView) this.mRootView.findViewById(a.g.name_charm_1);
        this.hFN = (TextView) this.mRootView.findViewById(a.g.point_charm_1);
        this.hFO = (LottieAnimationView) this.mRootView.findViewById(a.g.anchor_live_anim);
        this.oaK = (LinearLayout) this.mRootView.findViewById(a.g.ll_living);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(String str, String str2, String str3, String str4) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.oaH.getPageContext().getPageActivity(), str, str2, str3, 0, 0, null, null, 0L, 0L, 0L, 0, "", Long.toString(this.oaH.getIntent().getLongExtra("live_id", 0L)), false, "", null, str4, "")));
        this.oaH.finish();
    }

    public void b(i iVar) {
        c.a aVar;
        com.baidu.tieba.yuyinala.data.c cVar = iVar.getList().get(0);
        if (cVar != null) {
            this.oaJ = cVar;
            this.oaI.startLoad(cVar.cover, 12, false);
            this.hFH.setText(cVar.getNameShow());
            this.hFI.setText(String.format(this.oaH.getString(a.i.head_hour_rank_anchor), StringHelper.formatYuyinValue(cVar.point)));
            if (cVar.eyT == 2) {
                this.oaK.setVisibility(0);
                this.hFO.loop(true);
                this.hFO.setAnimation("alavl_room_living.json");
                this.hFO.playAnimation();
            } else {
                this.oaK.setVisibility(8);
            }
            if (cVar.gux != null && (aVar = cVar.gux.get(0)) != null) {
                this.hFK.startLoad(aVar.portrait, 12, false);
                this.hFM.setText(aVar.userNickName);
                this.hFN.setText(String.format(this.oaH.getString(a.i.head_hour_rank_gold), StringHelper.formatYuyinValue(aVar.biA)));
            }
        }
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.hFD != null) {
            this.hFD.setVisibility(i);
        }
    }
}
