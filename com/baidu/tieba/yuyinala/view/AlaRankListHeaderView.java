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
import com.baidu.live.data.cz;
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
    private FrameLayout hWb;
    private RelativeLayout hWc;
    private TextView hWf;
    private TextView hWg;
    private RelativeLayout hWh;
    private HeadImageView hWi;
    private TextView hWk;
    private TextView hWl;
    private LottieAnimationView hWm;
    private boolean hWn;
    private String mRoomId;
    private View mRootView;
    private AlaRankListActivity oAq;
    private BarImageView oAr;
    private com.baidu.tieba.yuyinala.data.c oAs;
    private LinearLayout oAt;

    public AlaRankListHeaderView(AlaRankListActivity alaRankListActivity, String str) {
        super(alaRankListActivity);
        this.hWn = true;
        this.mRoomId = str;
        this.oAq = alaRankListActivity;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hWn = true;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hWn = true;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.g.yuyin_ala_rank_list_header_layout, this);
        this.hWb = (FrameLayout) this.mRootView.findViewById(a.f.hour_head_info);
        this.hWc = (RelativeLayout) this.mRootView.findViewById(a.f.rl_room_area);
        this.oAr = (BarImageView) this.mRootView.findViewById(a.f.room_name);
        this.oAr.setShowOval(true);
        this.oAr.setAutoChangeStyle(false);
        this.mRootView.setVisibility(0);
        this.hWb.setVisibility(0);
        this.hWc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.AlaRankListHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.oAs != null) {
                    Intent intent = AlaRankListHeaderView.this.oAq.getIntent();
                    boolean jt = com.baidu.live.ap.b.YX().jt(intent.getStringExtra("uk"));
                    long longExtra = intent.getLongExtra("live_id", 0L);
                    try {
                        if (!String.valueOf(longExtra).equals(AlaRankListHeaderView.this.oAs.liveId)) {
                            if (AlaRankListHeaderView.this.oAs.eKc == 2) {
                                if (jt) {
                                    w wVar = new w();
                                    wVar.aKL = new cz();
                                    wVar.aKL.live_id = AlaRankListHeaderView.this.oAs.liveId;
                                    wVar.aKL.aUg = AlaRankListHeaderView.this.oAs.aUg;
                                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(wVar)));
                                } else {
                                    if (com.baidu.live.ap.b.YX().isApplying()) {
                                        com.baidu.live.ap.b.YX().Zg();
                                    }
                                    String stringExtra = intent.getStringExtra("room_id");
                                    String stringExtra2 = intent.getStringExtra("portrait");
                                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
                                    alaLastLiveroomInfo.setLastLiveId(longExtra);
                                    alaLastLiveroomInfo.setLastRoomId(Long.valueOf(stringExtra).longValue());
                                    alaLastLiveroomInfo.setIsAudio(1);
                                    alaLastLiveroomInfo.setLastAnchorPortrait(stringExtra2);
                                    YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(AlaRankListHeaderView.this.oAq);
                                    yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(AlaRankListHeaderView.this.oAs.liveId).longValue(), AlaRankListHeaderView.this.oAs.aUg, "live_sdk");
                                    yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                                }
                            } else {
                                w wVar2 = new w();
                                wVar2.aKL = new cz();
                                wVar2.aKL.live_id = AlaRankListHeaderView.this.oAs.liveId;
                                wVar2.aKL.aUg = AlaRankListHeaderView.this.oAs.aUg;
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(wVar2)));
                            }
                            AlaRankListHeaderView.this.oAq.finish();
                        }
                    } catch (Throwable th) {
                    }
                }
            }
        });
        this.hWf = (TextView) this.mRootView.findViewById(a.f.tv_room_name);
        this.hWg = (TextView) this.mRootView.findViewById(a.f.tv_point_room);
        this.hWi = (HeadImageView) this.mRootView.findViewById(a.f.charm_first);
        this.hWh = (RelativeLayout) this.mRootView.findViewById(a.f.rl_chram_first);
        this.hWi.setIsRound(true);
        this.hWi.setAutoChangeStyle(false);
        this.hWh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a aVar;
                if (AlaRankListHeaderView.this.oAs != null && AlaRankListHeaderView.this.oAs.gIP != null && AlaRankListHeaderView.this.oAs.gIP.size() > 0 && (aVar = AlaRankListHeaderView.this.oAs.gIP.get(0)) != null) {
                    try {
                        AlaRankListHeaderView.this.N(ExtraParamsManager.getDecryptUserId(aVar.uk), aVar.userName, aVar.portrait, aVar.getNameShow());
                    } catch (Exception e) {
                    }
                }
            }
        });
        this.hWk = (TextView) this.mRootView.findViewById(a.f.name_charm_1);
        this.hWl = (TextView) this.mRootView.findViewById(a.f.point_charm_1);
        this.hWm = (LottieAnimationView) this.mRootView.findViewById(a.f.anchor_live_anim);
        this.oAt = (LinearLayout) this.mRootView.findViewById(a.f.ll_living);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(String str, String str2, String str3, String str4) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.oAq.getPageContext().getPageActivity(), str, str2, str3, 0, 0, null, null, 0L, 0L, 0L, 0, "", Long.toString(this.oAq.getIntent().getLongExtra("live_id", 0L)), false, "", null, str4, "")));
        this.oAq.finish();
    }

    public void b(i iVar) {
        c.a aVar;
        com.baidu.tieba.yuyinala.data.c cVar = iVar.getList().get(0);
        if (cVar != null) {
            this.oAs = cVar;
            this.oAr.startLoad(cVar.cover, 12, false);
            this.hWf.setText(cVar.getNameShow());
            this.hWg.setText(String.format(this.oAq.getString(a.h.head_hour_rank_anchor), StringHelper.formatYuyinValue(cVar.aJg)));
            if (cVar.eKc == 2) {
                this.oAt.setVisibility(0);
                this.hWm.loop(true);
                this.hWm.setAnimation("alavl_room_living.json");
                this.hWm.playAnimation();
            } else {
                this.oAt.setVisibility(8);
            }
            if (cVar.gIP != null && (aVar = cVar.gIP.get(0)) != null) {
                this.hWi.startLoad(aVar.portrait, 12, false);
                this.hWk.setText(aVar.userNickName);
                this.hWl.setText(String.format(this.oAq.getString(a.h.head_hour_rank_gold), StringHelper.formatYuyinValue(aVar.bmv)));
            }
        }
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.hWb != null) {
            this.hWb.setVisibility(i);
        }
    }
}
