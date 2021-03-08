package com.baidu.tieba.yuyinala.view;

import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
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
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tieba.view.BarImageView;
import com.baidu.tieba.yuyinala.AlaRankListActivity;
/* loaded from: classes10.dex */
public class c {
    private TextView hZP;
    private TextView ilv;
    private TextView ilw;
    private LottieAnimationView ily;
    private View mRootView;
    private BarImageView oQB;
    private com.baidu.tieba.yuyinala.data.c oQC;
    private FrameLayout oQo;
    private AlaRankListActivity orD;

    public c(AlaRankListActivity alaRankListActivity, View view) {
        this.orD = alaRankListActivity;
        this.mRootView = view;
        this.hZP = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.ilw = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.ilv = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_rank_info);
        this.oQB = (BarImageView) this.mRootView.findViewById(a.f.ala_rank_list_header);
        this.oQB.setShowOval(true);
        this.oQB.setAutoChangeStyle(false);
        this.ily = (LottieAnimationView) this.mRootView.findViewById(a.f.rank_live_anim);
        this.oQo = (FrameLayout) this.mRootView.findViewById(a.f.ll_living);
    }

    public void a(com.baidu.tieba.yuyinala.data.c cVar, int i) {
        if (cVar != null) {
            this.oQC = cVar;
            this.hZP.setText(this.oQC.getNameShow());
            this.oQB.startLoad(this.oQC.cover, 12, false);
            if (this.oQC.eSY == 2) {
                this.ily.setAnimation("alavl_room_living.json");
                this.ily.loop(true);
                this.ily.playAnimation();
                this.oQo.setVisibility(0);
            } else {
                this.oQo.setVisibility(8);
            }
            int i2 = this.oQC.rank;
            this.ilw.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
            if (i2 >= 100) {
                this.ilw.setTextSize(0, this.orD.getResources().getDimension(a.d.sdk_fontsize28));
            } else {
                this.ilw.setTextSize(0, this.orD.getResources().getDimension(a.d.sdk_fontsize32));
            }
            this.ilw.setText(String.valueOf(i2));
            this.ilw.setBackgroundResource(a.c.sdk_transparent);
            this.ilv.setText(String.format(this.orD.getString(a.h.ala_rank_list_charm_hour), StringHelper.formatYuyinValue(this.oQC.aIe)));
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = c.this.orD.getIntent();
                    boolean iN = com.baidu.live.ao.a.Ym().iN(intent.getStringExtra("uk"));
                    long longExtra = intent.getLongExtra("live_id", 0L);
                    try {
                        if (!String.valueOf(longExtra).equals(c.this.oQC.liveId)) {
                            if (c.this.oQC.eSY == 2) {
                                if (iN) {
                                    ab abVar = new ab();
                                    abVar.aKu = new dj();
                                    abVar.aKu.live_id = c.this.oQC.liveId;
                                    abVar.aKu.aVk = c.this.oQC.aVk;
                                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(abVar)));
                                } else {
                                    if (com.baidu.live.ao.a.Ym().isApplying()) {
                                        com.baidu.live.ao.a.Ym().Yw();
                                    }
                                    YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(c.this.orD);
                                    String stringExtra = intent.getStringExtra("room_id");
                                    String stringExtra2 = intent.getStringExtra("portrait");
                                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
                                    alaLastLiveroomInfo.setLastLiveId(longExtra);
                                    alaLastLiveroomInfo.setLastRoomId(Long.valueOf(stringExtra).longValue());
                                    alaLastLiveroomInfo.setIsAudio(1);
                                    alaLastLiveroomInfo.setLastAnchorPortrait(stringExtra2);
                                    yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(c.this.oQC.liveId).longValue(), c.this.oQC.aVk, "live_sdk");
                                    yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                                }
                            } else {
                                ab abVar2 = new ab();
                                abVar2.aKu = new dj();
                                abVar2.aKu.live_id = c.this.oQC.liveId;
                                abVar2.aKu.aVk = c.this.oQC.aVk;
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(abVar2)));
                            }
                            c.this.orD.finish();
                        }
                    } catch (Throwable th) {
                    }
                }
            });
        }
    }
}
