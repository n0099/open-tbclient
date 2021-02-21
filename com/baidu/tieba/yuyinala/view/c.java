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
/* loaded from: classes11.dex */
public class c {
    private TextView hYg;
    private TextView ijM;
    private TextView ijN;
    private LottieAnimationView ijP;
    private View mRootView;
    private FrameLayout oOj;
    private BarImageView oOw;
    private com.baidu.tieba.yuyinala.data.c oOx;
    private AlaRankListActivity opx;

    public c(AlaRankListActivity alaRankListActivity, View view) {
        this.opx = alaRankListActivity;
        this.mRootView = view;
        this.hYg = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.ijN = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.ijM = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_rank_info);
        this.oOw = (BarImageView) this.mRootView.findViewById(a.f.ala_rank_list_header);
        this.oOw.setShowOval(true);
        this.oOw.setAutoChangeStyle(false);
        this.ijP = (LottieAnimationView) this.mRootView.findViewById(a.f.rank_live_anim);
        this.oOj = (FrameLayout) this.mRootView.findViewById(a.f.ll_living);
    }

    public void a(com.baidu.tieba.yuyinala.data.c cVar, int i) {
        if (cVar != null) {
            this.oOx = cVar;
            this.hYg.setText(this.oOx.getNameShow());
            this.oOw.startLoad(this.oOx.cover, 12, false);
            if (this.oOx.eRx == 2) {
                this.ijP.setAnimation("alavl_room_living.json");
                this.ijP.loop(true);
                this.ijP.playAnimation();
                this.oOj.setVisibility(0);
            } else {
                this.oOj.setVisibility(8);
            }
            int i2 = this.oOx.rank;
            this.ijN.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
            if (i2 >= 100) {
                this.ijN.setTextSize(0, this.opx.getResources().getDimension(a.d.sdk_fontsize28));
            } else {
                this.ijN.setTextSize(0, this.opx.getResources().getDimension(a.d.sdk_fontsize32));
            }
            this.ijN.setText(String.valueOf(i2));
            this.ijN.setBackgroundResource(a.c.sdk_transparent);
            this.ijM.setText(String.format(this.opx.getString(a.h.ala_rank_list_charm_hour), StringHelper.formatYuyinValue(this.oOx.aGE)));
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = c.this.opx.getIntent();
                    boolean iH = com.baidu.live.ao.a.Yj().iH(intent.getStringExtra("uk"));
                    long longExtra = intent.getLongExtra("live_id", 0L);
                    try {
                        if (!String.valueOf(longExtra).equals(c.this.oOx.liveId)) {
                            if (c.this.oOx.eRx == 2) {
                                if (iH) {
                                    ab abVar = new ab();
                                    abVar.aIU = new dj();
                                    abVar.aIU.live_id = c.this.oOx.liveId;
                                    abVar.aIU.aTK = c.this.oOx.aTK;
                                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(abVar)));
                                } else {
                                    if (com.baidu.live.ao.a.Yj().isApplying()) {
                                        com.baidu.live.ao.a.Yj().Yt();
                                    }
                                    YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(c.this.opx);
                                    String stringExtra = intent.getStringExtra("room_id");
                                    String stringExtra2 = intent.getStringExtra("portrait");
                                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
                                    alaLastLiveroomInfo.setLastLiveId(longExtra);
                                    alaLastLiveroomInfo.setLastRoomId(Long.valueOf(stringExtra).longValue());
                                    alaLastLiveroomInfo.setIsAudio(1);
                                    alaLastLiveroomInfo.setLastAnchorPortrait(stringExtra2);
                                    yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(c.this.oOx.liveId).longValue(), c.this.oOx.aTK, "live_sdk");
                                    yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                                }
                            } else {
                                ab abVar2 = new ab();
                                abVar2.aIU = new dj();
                                abVar2.aIU.live_id = c.this.oOx.liveId;
                                abVar2.aIU.aTK = c.this.oOx.aTK;
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(abVar2)));
                            }
                            c.this.opx.finish();
                        }
                    } catch (Throwable th) {
                    }
                }
            });
        }
    }
}
