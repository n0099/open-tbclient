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
    private FrameLayout hLh;
    private RelativeLayout hLi;
    private TextView hLl;
    private TextView hLm;
    private RelativeLayout hLn;
    private HeadImageView hLo;
    private TextView hLq;
    private TextView hLr;
    private LottieAnimationView hLs;
    private boolean hLt;
    private String mRoomId;
    private View mRootView;
    private AlaRankListActivity olq;
    private BarImageView olr;
    private com.baidu.tieba.yuyinala.data.c ols;
    private LinearLayout olt;

    public AlaRankListHeaderView(AlaRankListActivity alaRankListActivity, String str) {
        super(alaRankListActivity);
        this.hLt = true;
        this.mRoomId = str;
        this.olq = alaRankListActivity;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hLt = true;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hLt = true;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.g.yuyin_ala_rank_list_header_layout, this);
        this.hLh = (FrameLayout) this.mRootView.findViewById(a.f.hour_head_info);
        this.hLi = (RelativeLayout) this.mRootView.findViewById(a.f.rl_room_area);
        this.olr = (BarImageView) this.mRootView.findViewById(a.f.room_name);
        this.olr.setShowOval(true);
        this.olr.setAutoChangeStyle(false);
        this.mRootView.setVisibility(0);
        this.hLh.setVisibility(0);
        this.hLi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.AlaRankListHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.ols != null) {
                    Intent intent = AlaRankListHeaderView.this.olq.getIntent();
                    boolean iP = com.baidu.live.al.b.Wy().iP(intent.getStringExtra("uk"));
                    long longExtra = intent.getLongExtra("live_id", 0L);
                    try {
                        if (!String.valueOf(longExtra).equals(AlaRankListHeaderView.this.ols.liveId)) {
                            if (AlaRankListHeaderView.this.ols.eDa == 2) {
                                if (iP) {
                                    w wVar = new w();
                                    wVar.aHZ = new cx();
                                    wVar.aHZ.live_id = AlaRankListHeaderView.this.ols.liveId;
                                    wVar.aHZ.aRe = AlaRankListHeaderView.this.ols.aRe;
                                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(wVar)));
                                } else {
                                    if (com.baidu.live.al.b.Wy().isApplying()) {
                                        com.baidu.live.al.b.Wy().WH();
                                    }
                                    String stringExtra = intent.getStringExtra("room_id");
                                    String stringExtra2 = intent.getStringExtra("portrait");
                                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
                                    alaLastLiveroomInfo.setLastLiveId(longExtra);
                                    alaLastLiveroomInfo.setLastRoomId(Long.valueOf(stringExtra).longValue());
                                    alaLastLiveroomInfo.setIsAudio(1);
                                    alaLastLiveroomInfo.setLastAnchorPortrait(stringExtra2);
                                    YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(AlaRankListHeaderView.this.olq);
                                    yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(AlaRankListHeaderView.this.ols.liveId).longValue(), AlaRankListHeaderView.this.ols.aRe, "live_sdk");
                                    yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                                }
                            } else {
                                w wVar2 = new w();
                                wVar2.aHZ = new cx();
                                wVar2.aHZ.live_id = AlaRankListHeaderView.this.ols.liveId;
                                wVar2.aHZ.aRe = AlaRankListHeaderView.this.ols.aRe;
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(wVar2)));
                            }
                            AlaRankListHeaderView.this.olq.finish();
                        }
                    } catch (Throwable th) {
                    }
                }
            }
        });
        this.hLl = (TextView) this.mRootView.findViewById(a.f.tv_room_name);
        this.hLm = (TextView) this.mRootView.findViewById(a.f.tv_point_room);
        this.hLo = (HeadImageView) this.mRootView.findViewById(a.f.charm_first);
        this.hLn = (RelativeLayout) this.mRootView.findViewById(a.f.rl_chram_first);
        this.hLo.setIsRound(true);
        this.hLo.setAutoChangeStyle(false);
        this.hLn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a aVar;
                if (AlaRankListHeaderView.this.ols != null && AlaRankListHeaderView.this.ols.gzS != null && AlaRankListHeaderView.this.ols.gzS.size() > 0 && (aVar = AlaRankListHeaderView.this.ols.gzS.get(0)) != null) {
                    try {
                        AlaRankListHeaderView.this.N(ExtraParamsManager.getDecryptUserId(aVar.uk), aVar.userName, aVar.portrait, aVar.getNameShow());
                    } catch (Exception e) {
                    }
                }
            }
        });
        this.hLq = (TextView) this.mRootView.findViewById(a.f.name_charm_1);
        this.hLr = (TextView) this.mRootView.findViewById(a.f.point_charm_1);
        this.hLs = (LottieAnimationView) this.mRootView.findViewById(a.f.anchor_live_anim);
        this.olt = (LinearLayout) this.mRootView.findViewById(a.f.ll_living);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(String str, String str2, String str3, String str4) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.olq.getPageContext().getPageActivity(), str, str2, str3, 0, 0, null, null, 0L, 0L, 0L, 0, "", Long.toString(this.olq.getIntent().getLongExtra("live_id", 0L)), false, "", null, str4, "")));
        this.olq.finish();
    }

    public void b(i iVar) {
        c.a aVar;
        com.baidu.tieba.yuyinala.data.c cVar = iVar.getList().get(0);
        if (cVar != null) {
            this.ols = cVar;
            this.olr.startLoad(cVar.cover, 12, false);
            this.hLl.setText(cVar.getNameShow());
            this.hLm.setText(String.format(this.olq.getString(a.h.head_hour_rank_anchor), StringHelper.formatYuyinValue(cVar.point)));
            if (cVar.eDa == 2) {
                this.olt.setVisibility(0);
                this.hLs.loop(true);
                this.hLs.setAnimation("alavl_room_living.json");
                this.hLs.playAnimation();
            } else {
                this.olt.setVisibility(8);
            }
            if (cVar.gzS != null && (aVar = cVar.gzS.get(0)) != null) {
                this.hLo.startLoad(aVar.portrait, 12, false);
                this.hLq.setText(aVar.userNickName);
                this.hLr.setText(String.format(this.olq.getString(a.h.head_hour_rank_gold), StringHelper.formatYuyinValue(aVar.bih)));
            }
        }
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.hLh != null) {
            this.hLh.setVisibility(i);
        }
    }
}
