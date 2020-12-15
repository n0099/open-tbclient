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
    private FrameLayout hWd;
    private RelativeLayout hWe;
    private TextView hWh;
    private TextView hWi;
    private RelativeLayout hWj;
    private HeadImageView hWk;
    private TextView hWm;
    private TextView hWn;
    private LottieAnimationView hWo;
    private boolean hWp;
    private String mRoomId;
    private View mRootView;
    private AlaRankListActivity oAs;
    private BarImageView oAt;
    private com.baidu.tieba.yuyinala.data.c oAu;
    private LinearLayout oAv;

    public AlaRankListHeaderView(AlaRankListActivity alaRankListActivity, String str) {
        super(alaRankListActivity);
        this.hWp = true;
        this.mRoomId = str;
        this.oAs = alaRankListActivity;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hWp = true;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hWp = true;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.g.yuyin_ala_rank_list_header_layout, this);
        this.hWd = (FrameLayout) this.mRootView.findViewById(a.f.hour_head_info);
        this.hWe = (RelativeLayout) this.mRootView.findViewById(a.f.rl_room_area);
        this.oAt = (BarImageView) this.mRootView.findViewById(a.f.room_name);
        this.oAt.setShowOval(true);
        this.oAt.setAutoChangeStyle(false);
        this.mRootView.setVisibility(0);
        this.hWd.setVisibility(0);
        this.hWe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.AlaRankListHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.oAu != null) {
                    Intent intent = AlaRankListHeaderView.this.oAs.getIntent();
                    boolean jt = com.baidu.live.ap.b.YX().jt(intent.getStringExtra("uk"));
                    long longExtra = intent.getLongExtra("live_id", 0L);
                    try {
                        if (!String.valueOf(longExtra).equals(AlaRankListHeaderView.this.oAu.liveId)) {
                            if (AlaRankListHeaderView.this.oAu.eKc == 2) {
                                if (jt) {
                                    w wVar = new w();
                                    wVar.aKL = new cz();
                                    wVar.aKL.live_id = AlaRankListHeaderView.this.oAu.liveId;
                                    wVar.aKL.aUg = AlaRankListHeaderView.this.oAu.aUg;
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
                                    YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(AlaRankListHeaderView.this.oAs);
                                    yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(AlaRankListHeaderView.this.oAu.liveId).longValue(), AlaRankListHeaderView.this.oAu.aUg, "live_sdk");
                                    yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                                }
                            } else {
                                w wVar2 = new w();
                                wVar2.aKL = new cz();
                                wVar2.aKL.live_id = AlaRankListHeaderView.this.oAu.liveId;
                                wVar2.aKL.aUg = AlaRankListHeaderView.this.oAu.aUg;
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(wVar2)));
                            }
                            AlaRankListHeaderView.this.oAs.finish();
                        }
                    } catch (Throwable th) {
                    }
                }
            }
        });
        this.hWh = (TextView) this.mRootView.findViewById(a.f.tv_room_name);
        this.hWi = (TextView) this.mRootView.findViewById(a.f.tv_point_room);
        this.hWk = (HeadImageView) this.mRootView.findViewById(a.f.charm_first);
        this.hWj = (RelativeLayout) this.mRootView.findViewById(a.f.rl_chram_first);
        this.hWk.setIsRound(true);
        this.hWk.setAutoChangeStyle(false);
        this.hWj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a aVar;
                if (AlaRankListHeaderView.this.oAu != null && AlaRankListHeaderView.this.oAu.gIR != null && AlaRankListHeaderView.this.oAu.gIR.size() > 0 && (aVar = AlaRankListHeaderView.this.oAu.gIR.get(0)) != null) {
                    try {
                        AlaRankListHeaderView.this.N(ExtraParamsManager.getDecryptUserId(aVar.uk), aVar.userName, aVar.portrait, aVar.getNameShow());
                    } catch (Exception e) {
                    }
                }
            }
        });
        this.hWm = (TextView) this.mRootView.findViewById(a.f.name_charm_1);
        this.hWn = (TextView) this.mRootView.findViewById(a.f.point_charm_1);
        this.hWo = (LottieAnimationView) this.mRootView.findViewById(a.f.anchor_live_anim);
        this.oAv = (LinearLayout) this.mRootView.findViewById(a.f.ll_living);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(String str, String str2, String str3, String str4) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.oAs.getPageContext().getPageActivity(), str, str2, str3, 0, 0, null, null, 0L, 0L, 0L, 0, "", Long.toString(this.oAs.getIntent().getLongExtra("live_id", 0L)), false, "", null, str4, "")));
        this.oAs.finish();
    }

    public void b(i iVar) {
        c.a aVar;
        com.baidu.tieba.yuyinala.data.c cVar = iVar.getList().get(0);
        if (cVar != null) {
            this.oAu = cVar;
            this.oAt.startLoad(cVar.cover, 12, false);
            this.hWh.setText(cVar.getNameShow());
            this.hWi.setText(String.format(this.oAs.getString(a.h.head_hour_rank_anchor), StringHelper.formatYuyinValue(cVar.aJg)));
            if (cVar.eKc == 2) {
                this.oAv.setVisibility(0);
                this.hWo.loop(true);
                this.hWo.setAnimation("alavl_room_living.json");
                this.hWo.playAnimation();
            } else {
                this.oAv.setVisibility(8);
            }
            if (cVar.gIR != null && (aVar = cVar.gIR.get(0)) != null) {
                this.hWk.startLoad(aVar.portrait, 12, false);
                this.hWm.setText(aVar.userNickName);
                this.hWn.setText(String.format(this.oAs.getString(a.h.head_hour_rank_gold), StringHelper.formatYuyinValue(aVar.bmv)));
            }
        }
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.hWd != null) {
            this.hWd.setVisibility(i);
        }
    }
}
