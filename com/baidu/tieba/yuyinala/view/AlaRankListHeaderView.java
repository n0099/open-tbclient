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
import com.baidu.live.data.dd;
import com.baidu.live.data.x;
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
    private FrameLayout idW;
    private RelativeLayout idX;
    private TextView iea;
    private TextView ieb;
    private RelativeLayout iec;
    private HeadImageView ied;
    private TextView ief;
    private TextView ieg;
    private LottieAnimationView ieh;
    private boolean iei;
    private String mRoomId;
    private View mRootView;
    private AlaRankListActivity oDC;
    private BarImageView oDD;
    private com.baidu.tieba.yuyinala.data.c oDE;
    private LinearLayout oDF;

    public AlaRankListHeaderView(AlaRankListActivity alaRankListActivity, String str) {
        super(alaRankListActivity);
        this.iei = true;
        this.mRoomId = str;
        this.oDC = alaRankListActivity;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iei = true;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iei = true;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.g.yuyin_ala_rank_list_header_layout, this);
        this.idW = (FrameLayout) this.mRootView.findViewById(a.f.hour_head_info);
        this.idX = (RelativeLayout) this.mRootView.findViewById(a.f.rl_room_area);
        this.oDD = (BarImageView) this.mRootView.findViewById(a.f.room_name);
        this.oDD.setShowOval(true);
        this.oDD.setAutoChangeStyle(false);
        this.mRootView.setVisibility(0);
        this.idW.setVisibility(0);
        this.idX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.AlaRankListHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.oDE != null) {
                    Intent intent = AlaRankListHeaderView.this.oDC.getIntent();
                    boolean ib = com.baidu.live.aq.a.Wu().ib(intent.getStringExtra("uk"));
                    long longExtra = intent.getLongExtra("live_id", 0L);
                    try {
                        if (!String.valueOf(longExtra).equals(AlaRankListHeaderView.this.oDE.liveId)) {
                            if (AlaRankListHeaderView.this.oDE.ePl == 2) {
                                if (ib) {
                                    x xVar = new x();
                                    xVar.aGy = new dd();
                                    xVar.aGy.live_id = AlaRankListHeaderView.this.oDE.liveId;
                                    xVar.aGy.aQH = AlaRankListHeaderView.this.oDE.aQH;
                                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(xVar)));
                                } else {
                                    if (com.baidu.live.aq.a.Wu().isApplying()) {
                                        com.baidu.live.aq.a.Wu().WD();
                                    }
                                    String stringExtra = intent.getStringExtra("room_id");
                                    String stringExtra2 = intent.getStringExtra("portrait");
                                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
                                    alaLastLiveroomInfo.setLastLiveId(longExtra);
                                    alaLastLiveroomInfo.setLastRoomId(Long.valueOf(stringExtra).longValue());
                                    alaLastLiveroomInfo.setIsAudio(1);
                                    alaLastLiveroomInfo.setLastAnchorPortrait(stringExtra2);
                                    YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(AlaRankListHeaderView.this.oDC);
                                    yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(AlaRankListHeaderView.this.oDE.liveId).longValue(), AlaRankListHeaderView.this.oDE.aQH, "live_sdk");
                                    yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                                }
                            } else {
                                x xVar2 = new x();
                                xVar2.aGy = new dd();
                                xVar2.aGy.live_id = AlaRankListHeaderView.this.oDE.liveId;
                                xVar2.aGy.aQH = AlaRankListHeaderView.this.oDE.aQH;
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(xVar2)));
                            }
                            AlaRankListHeaderView.this.oDC.finish();
                        }
                    } catch (Throwable th) {
                    }
                }
            }
        });
        this.iea = (TextView) this.mRootView.findViewById(a.f.tv_room_name);
        this.ieb = (TextView) this.mRootView.findViewById(a.f.tv_point_room);
        this.ied = (HeadImageView) this.mRootView.findViewById(a.f.charm_first);
        this.iec = (RelativeLayout) this.mRootView.findViewById(a.f.rl_chram_first);
        this.ied.setIsRound(true);
        this.ied.setAutoChangeStyle(false);
        this.iec.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a aVar;
                if (AlaRankListHeaderView.this.oDE != null && AlaRankListHeaderView.this.oDE.gPX != null && AlaRankListHeaderView.this.oDE.gPX.size() > 0 && (aVar = AlaRankListHeaderView.this.oDE.gPX.get(0)) != null) {
                    try {
                        AlaRankListHeaderView.this.M(ExtraParamsManager.getDecryptUserId(aVar.uk), aVar.userName, aVar.portrait, aVar.getNameShow());
                    } catch (Exception e) {
                    }
                }
            }
        });
        this.ief = (TextView) this.mRootView.findViewById(a.f.name_charm_1);
        this.ieg = (TextView) this.mRootView.findViewById(a.f.point_charm_1);
        this.ieh = (LottieAnimationView) this.mRootView.findViewById(a.f.anchor_live_anim);
        this.oDF = (LinearLayout) this.mRootView.findViewById(a.f.ll_living);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(String str, String str2, String str3, String str4) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.oDC.getPageContext().getPageActivity(), str, str2, str3, 0, 0, null, null, 0L, 0L, 0L, 0, "", Long.toString(this.oDC.getIntent().getLongExtra("live_id", 0L)), false, "", null, str4, "")));
        this.oDC.finish();
    }

    public void b(i iVar) {
        c.a aVar;
        com.baidu.tieba.yuyinala.data.c cVar = iVar.getList().get(0);
        if (cVar != null) {
            this.oDE = cVar;
            this.oDD.startLoad(cVar.cover, 12, false);
            this.iea.setText(cVar.getNameShow());
            this.ieb.setText(String.format(this.oDC.getString(a.h.head_hour_rank_anchor), StringHelper.formatYuyinValue(cVar.aER)));
            if (cVar.ePl == 2) {
                this.oDF.setVisibility(0);
                this.ieh.loop(true);
                this.ieh.setAnimation("alavl_room_living.json");
                this.ieh.playAnimation();
            } else {
                this.oDF.setVisibility(8);
            }
            if (cVar.gPX != null && (aVar = cVar.gPX.get(0)) != null) {
                this.ied.startLoad(aVar.portrait, 12, false);
                this.ief.setText(aVar.userNickName);
                this.ieg.setText(String.format(this.oDC.getString(a.h.head_hour_rank_gold), StringHelper.formatYuyinValue(aVar.bjn)));
            }
        }
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.idW != null) {
            this.idW.setVisibility(i);
        }
    }
}
