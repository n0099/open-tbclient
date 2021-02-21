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
    private FrameLayout ije;
    private RelativeLayout ijf;
    private TextView iji;
    private TextView ijj;
    private RelativeLayout ijk;
    private HeadImageView ijl;
    private TextView ijn;
    private TextView ijo;
    private LottieAnimationView ijp;
    private boolean ijq;
    private String mRoomId;
    private View mRootView;
    private AlaRankListActivity oOl;
    private BarImageView oOm;
    private com.baidu.tieba.yuyinala.data.c oOn;
    private LinearLayout oOo;

    public AlaRankListHeaderView(AlaRankListActivity alaRankListActivity, String str) {
        super(alaRankListActivity);
        this.ijq = true;
        this.mRoomId = str;
        this.oOl = alaRankListActivity;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ijq = true;
        init();
    }

    public AlaRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ijq = true;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(a.g.yuyin_ala_rank_list_header_layout, this);
        this.ije = (FrameLayout) this.mRootView.findViewById(a.f.hour_head_info);
        this.ijf = (RelativeLayout) this.mRootView.findViewById(a.f.rl_room_area);
        this.oOm = (BarImageView) this.mRootView.findViewById(a.f.room_name);
        this.oOm.setShowOval(true);
        this.oOm.setAutoChangeStyle(false);
        this.mRootView.setVisibility(0);
        this.ije.setVisibility(0);
        this.ijf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.AlaRankListHeaderView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaRankListHeaderView.this.oOn != null) {
                    Intent intent = AlaRankListHeaderView.this.oOl.getIntent();
                    boolean iH = com.baidu.live.ao.a.Yj().iH(intent.getStringExtra("uk"));
                    long longExtra = intent.getLongExtra("live_id", 0L);
                    try {
                        if (!String.valueOf(longExtra).equals(AlaRankListHeaderView.this.oOn.liveId)) {
                            if (AlaRankListHeaderView.this.oOn.eRx == 2) {
                                if (iH) {
                                    ab abVar = new ab();
                                    abVar.aIU = new dj();
                                    abVar.aIU.live_id = AlaRankListHeaderView.this.oOn.liveId;
                                    abVar.aIU.aTK = AlaRankListHeaderView.this.oOn.aTK;
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
                                    YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(AlaRankListHeaderView.this.oOl);
                                    yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(AlaRankListHeaderView.this.oOn.liveId).longValue(), AlaRankListHeaderView.this.oOn.aTK, "live_sdk");
                                    yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                                }
                            } else {
                                ab abVar2 = new ab();
                                abVar2.aIU = new dj();
                                abVar2.aIU.live_id = AlaRankListHeaderView.this.oOn.liveId;
                                abVar2.aIU.aTK = AlaRankListHeaderView.this.oOn.aTK;
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(abVar2)));
                            }
                            AlaRankListHeaderView.this.oOl.finish();
                        }
                    } catch (Throwable th) {
                    }
                }
            }
        });
        this.iji = (TextView) this.mRootView.findViewById(a.f.tv_room_name);
        this.ijj = (TextView) this.mRootView.findViewById(a.f.tv_point_room);
        this.ijl = (HeadImageView) this.mRootView.findViewById(a.f.charm_first);
        this.ijk = (RelativeLayout) this.mRootView.findViewById(a.f.rl_chram_first);
        this.ijl.setIsRound(true);
        this.ijl.setAutoChangeStyle(false);
        this.ijk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.AlaRankListHeaderView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.a aVar;
                if (AlaRankListHeaderView.this.oOn != null && AlaRankListHeaderView.this.oOn.gSV != null && AlaRankListHeaderView.this.oOn.gSV.size() > 0 && (aVar = AlaRankListHeaderView.this.oOn.gSV.get(0)) != null) {
                    try {
                        AlaRankListHeaderView.this.K(ExtraParamsManager.getDecryptUserId(aVar.uk), aVar.userName, aVar.portrait, aVar.getNameShow());
                    } catch (Exception e) {
                    }
                }
            }
        });
        this.ijn = (TextView) this.mRootView.findViewById(a.f.name_charm_1);
        this.ijo = (TextView) this.mRootView.findViewById(a.f.point_charm_1);
        this.ijp = (LottieAnimationView) this.mRootView.findViewById(a.f.anchor_live_anim);
        this.oOo = (LinearLayout) this.mRootView.findViewById(a.f.ll_living);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(String str, String str2, String str3, String str4) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.oOl.getPageContext().getPageActivity(), str, str2, str3, 0, 0, null, null, 0L, 0L, 0L, 0, "", Long.toString(this.oOl.getIntent().getLongExtra("live_id", 0L)), false, "", null, str4, "")));
        this.oOl.finish();
    }

    public void b(i iVar) {
        c.a aVar;
        com.baidu.tieba.yuyinala.data.c cVar = iVar.getList().get(0);
        if (cVar != null) {
            this.oOn = cVar;
            this.oOm.startLoad(cVar.cover, 12, false);
            this.iji.setText(cVar.getNameShow());
            this.ijj.setText(String.format(this.oOl.getString(a.h.head_hour_rank_anchor), StringHelper.formatYuyinValue(cVar.aGE)));
            if (cVar.eRx == 2) {
                this.oOo.setVisibility(0);
                this.ijp.loop(true);
                this.ijp.setAnimation("alavl_room_living.json");
                this.ijp.playAnimation();
            } else {
                this.oOo.setVisibility(8);
            }
            if (cVar.gSV != null && (aVar = cVar.gSV.get(0)) != null) {
                this.ijl.startLoad(aVar.portrait, 12, false);
                this.ijn.setText(aVar.userNickName);
                this.ijo.setText(String.format(this.oOl.getString(a.h.head_hour_rank_gold), StringHelper.formatYuyinValue(aVar.aVC)));
            }
        }
    }

    public void setHourHeaderInfoVisible(int i) {
        if (this.ije != null) {
            this.ije.setVisibility(i);
        }
    }
}
