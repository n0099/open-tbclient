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
    private TextView hXS;
    private LottieAnimationView ijB;
    private TextView ijy;
    private TextView ijz;
    private View mRootView;
    private FrameLayout oNJ;
    private BarImageView oNW;
    private com.baidu.tieba.yuyinala.data.c oNX;
    private AlaRankListActivity ooW;

    public c(AlaRankListActivity alaRankListActivity, View view) {
        this.ooW = alaRankListActivity;
        this.mRootView = view;
        this.hXS = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.ijz = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.ijy = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_rank_info);
        this.oNW = (BarImageView) this.mRootView.findViewById(a.f.ala_rank_list_header);
        this.oNW.setShowOval(true);
        this.oNW.setAutoChangeStyle(false);
        this.ijB = (LottieAnimationView) this.mRootView.findViewById(a.f.rank_live_anim);
        this.oNJ = (FrameLayout) this.mRootView.findViewById(a.f.ll_living);
    }

    public void a(com.baidu.tieba.yuyinala.data.c cVar, int i) {
        if (cVar != null) {
            this.oNX = cVar;
            this.hXS.setText(this.oNX.getNameShow());
            this.oNW.startLoad(this.oNX.cover, 12, false);
            if (this.oNX.eRx == 2) {
                this.ijB.setAnimation("alavl_room_living.json");
                this.ijB.loop(true);
                this.ijB.playAnimation();
                this.oNJ.setVisibility(0);
            } else {
                this.oNJ.setVisibility(8);
            }
            int i2 = this.oNX.rank;
            this.ijz.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
            if (i2 >= 100) {
                this.ijz.setTextSize(0, this.ooW.getResources().getDimension(a.d.sdk_fontsize28));
            } else {
                this.ijz.setTextSize(0, this.ooW.getResources().getDimension(a.d.sdk_fontsize32));
            }
            this.ijz.setText(String.valueOf(i2));
            this.ijz.setBackgroundResource(a.c.sdk_transparent);
            this.ijy.setText(String.format(this.ooW.getString(a.h.ala_rank_list_charm_hour), StringHelper.formatYuyinValue(this.oNX.aGE)));
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = c.this.ooW.getIntent();
                    boolean iH = com.baidu.live.ao.a.Yj().iH(intent.getStringExtra("uk"));
                    long longExtra = intent.getLongExtra("live_id", 0L);
                    try {
                        if (!String.valueOf(longExtra).equals(c.this.oNX.liveId)) {
                            if (c.this.oNX.eRx == 2) {
                                if (iH) {
                                    ab abVar = new ab();
                                    abVar.aIU = new dj();
                                    abVar.aIU.live_id = c.this.oNX.liveId;
                                    abVar.aIU.aTK = c.this.oNX.aTK;
                                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(abVar)));
                                } else {
                                    if (com.baidu.live.ao.a.Yj().isApplying()) {
                                        com.baidu.live.ao.a.Yj().Yt();
                                    }
                                    YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(c.this.ooW);
                                    String stringExtra = intent.getStringExtra("room_id");
                                    String stringExtra2 = intent.getStringExtra("portrait");
                                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
                                    alaLastLiveroomInfo.setLastLiveId(longExtra);
                                    alaLastLiveroomInfo.setLastRoomId(Long.valueOf(stringExtra).longValue());
                                    alaLastLiveroomInfo.setIsAudio(1);
                                    alaLastLiveroomInfo.setLastAnchorPortrait(stringExtra2);
                                    yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(c.this.oNX.liveId).longValue(), c.this.oNX.aTK, "live_sdk");
                                    yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                                }
                            } else {
                                ab abVar2 = new ab();
                                abVar2.aIU = new dj();
                                abVar2.aIU.live_id = c.this.oNX.liveId;
                                abVar2.aIU.aTK = c.this.oNX.aTK;
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(abVar2)));
                            }
                            c.this.ooW.finish();
                        }
                    } catch (Throwable th) {
                    }
                }
            });
        }
    }
}
