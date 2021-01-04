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
/* loaded from: classes11.dex */
public class AlaRankListHeaderView extends LinearLayout {
    private FrameLayout iiD;
    private RelativeLayout iiE;
    private TextView iiH;
    private TextView iiI;
    private RelativeLayout iiJ;
    private HeadImageView iiK;
    private TextView iiM;
    private TextView iiN;
    private LottieAnimationView iiO;
    private boolean iiP;
    private String mRoomId;
    private View mRootView;
    private AlaRankListActivity oIg;
    private BarImageView oIh;
    private com.baidu.tieba.yuyinala.data.c oIi;
    private LinearLayout oIj;

    public AlaRankListHeaderView(AlaRankListActivity alaRankListActivity, String str) {
        super(alaRankListActivity);
        this.iiP = true;
        this.mRoomId = str;
        this.oIg = alaRankListActivity;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iiP = true;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iiP = true;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.g.yuyin_ala_rank_list_header_layout, this);
        this.iiD = (FrameLayout) this.mRootView.findViewById(a.f.hour_head_info);
        this.iiE = (RelativeLayout) this.mRootView.findViewById(a.f.rl_room_area);
        this.oIh = (BarImageView) this.mRootView.findViewById(a.f.room_name);
        this.oIh.setShowOval(true);
        this.oIh.setAutoChangeStyle(false);
        this.mRootView.setVisibility(0);
        this.iiD.setVisibility(0);
        this.iiE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.AlaRankListHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.oIi != null) {
                    Intent intent = AlaRankListHeaderView.this.oIg.getIntent();
                    boolean jm = com.baidu.live.aq.a.aam().jm(intent.getStringExtra("uk"));
                    long longExtra = intent.getLongExtra("live_id", 0L);
                    try {
                        if (!String.valueOf(longExtra).equals(AlaRankListHeaderView.this.oIi.liveId)) {
                            if (AlaRankListHeaderView.this.oIi.eTW == 2) {
                                if (jm) {
                                    x xVar = new x();
                                    xVar.aLl = new dd();
                                    xVar.aLl.live_id = AlaRankListHeaderView.this.oIi.liveId;
                                    xVar.aLl.aVu = AlaRankListHeaderView.this.oIi.aVu;
                                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(xVar)));
                                } else {
                                    if (com.baidu.live.aq.a.aam().isApplying()) {
                                        com.baidu.live.aq.a.aam().aav();
                                    }
                                    String stringExtra = intent.getStringExtra("room_id");
                                    String stringExtra2 = intent.getStringExtra("portrait");
                                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
                                    alaLastLiveroomInfo.setLastLiveId(longExtra);
                                    alaLastLiveroomInfo.setLastRoomId(Long.valueOf(stringExtra).longValue());
                                    alaLastLiveroomInfo.setIsAudio(1);
                                    alaLastLiveroomInfo.setLastAnchorPortrait(stringExtra2);
                                    YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(AlaRankListHeaderView.this.oIg);
                                    yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(AlaRankListHeaderView.this.oIi.liveId).longValue(), AlaRankListHeaderView.this.oIi.aVu, "live_sdk");
                                    yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                                }
                            } else {
                                x xVar2 = new x();
                                xVar2.aLl = new dd();
                                xVar2.aLl.live_id = AlaRankListHeaderView.this.oIi.liveId;
                                xVar2.aLl.aVu = AlaRankListHeaderView.this.oIi.aVu;
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(xVar2)));
                            }
                            AlaRankListHeaderView.this.oIg.finish();
                        }
                    } catch (Throwable th) {
                    }
                }
            }
        });
        this.iiH = (TextView) this.mRootView.findViewById(a.f.tv_room_name);
        this.iiI = (TextView) this.mRootView.findViewById(a.f.tv_point_room);
        this.iiK = (HeadImageView) this.mRootView.findViewById(a.f.charm_first);
        this.iiJ = (RelativeLayout) this.mRootView.findViewById(a.f.rl_chram_first);
        this.iiK.setIsRound(true);
        this.iiK.setAutoChangeStyle(false);
        this.iiJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a aVar;
                if (AlaRankListHeaderView.this.oIi != null && AlaRankListHeaderView.this.oIi.gUD != null && AlaRankListHeaderView.this.oIi.gUD.size() > 0 && (aVar = AlaRankListHeaderView.this.oIi.gUD.get(0)) != null) {
                    try {
                        AlaRankListHeaderView.this.M(ExtraParamsManager.getDecryptUserId(aVar.uk), aVar.userName, aVar.portrait, aVar.getNameShow());
                    } catch (Exception e) {
                    }
                }
            }
        });
        this.iiM = (TextView) this.mRootView.findViewById(a.f.name_charm_1);
        this.iiN = (TextView) this.mRootView.findViewById(a.f.point_charm_1);
        this.iiO = (LottieAnimationView) this.mRootView.findViewById(a.f.anchor_live_anim);
        this.oIj = (LinearLayout) this.mRootView.findViewById(a.f.ll_living);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(String str, String str2, String str3, String str4) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.oIg.getPageContext().getPageActivity(), str, str2, str3, 0, 0, null, null, 0L, 0L, 0L, 0, "", Long.toString(this.oIg.getIntent().getLongExtra("live_id", 0L)), false, "", null, str4, "")));
        this.oIg.finish();
    }

    public void b(i iVar) {
        c.a aVar;
        com.baidu.tieba.yuyinala.data.c cVar = iVar.getList().get(0);
        if (cVar != null) {
            this.oIi = cVar;
            this.oIh.startLoad(cVar.cover, 12, false);
            this.iiH.setText(cVar.getNameShow());
            this.iiI.setText(String.format(this.oIg.getString(a.h.head_hour_rank_anchor), StringHelper.formatYuyinValue(cVar.aJE)));
            if (cVar.eTW == 2) {
                this.oIj.setVisibility(0);
                this.iiO.loop(true);
                this.iiO.setAnimation("alavl_room_living.json");
                this.iiO.playAnimation();
            } else {
                this.oIj.setVisibility(8);
            }
            if (cVar.gUD != null && (aVar = cVar.gUD.get(0)) != null) {
                this.iiK.startLoad(aVar.portrait, 12, false);
                this.iiM.setText(aVar.userNickName);
                this.iiN.setText(String.format(this.oIg.getString(a.h.head_hour_rank_gold), StringHelper.formatYuyinValue(aVar.boa)));
            }
        }
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.iiD != null) {
            this.iiD.setVisibility(i);
        }
    }
}
