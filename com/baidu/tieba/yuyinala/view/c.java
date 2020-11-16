package com.baidu.tieba.yuyinala.view;

import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
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
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tieba.view.BarImageView;
import com.baidu.tieba.yuyinala.AlaRankListActivity;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes4.dex */
public class c {
    private TextView hBW;
    private TextView hLP;
    private TextView hLQ;
    private LottieAnimationView hLS;
    private View mRootView;
    private AlaRankListActivity nTb;
    private BarImageView olA;
    private com.baidu.tieba.yuyinala.data.c olB;
    private FrameLayout olo;

    public c(AlaRankListActivity alaRankListActivity, View view) {
        this.nTb = alaRankListActivity;
        this.mRootView = view;
        this.hBW = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.hLQ = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.hLP = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_rank_info);
        this.olA = (BarImageView) this.mRootView.findViewById(a.f.ala_rank_list_header);
        this.olA.setShowOval(true);
        this.olA.setAutoChangeStyle(false);
        this.hLS = (LottieAnimationView) this.mRootView.findViewById(a.f.rank_live_anim);
        this.olo = (FrameLayout) this.mRootView.findViewById(a.f.ll_living);
    }

    public void a(com.baidu.tieba.yuyinala.data.c cVar, int i) {
        if (cVar != null) {
            this.olB = cVar;
            this.hBW.setText(this.olB.getNameShow());
            this.olA.startLoad(this.olB.cover, 12, false);
            if (this.olB.eDa == 2) {
                this.hLS.setAnimation("alavl_room_living.json");
                this.hLS.loop(true);
                this.hLS.playAnimation();
                this.olo.setVisibility(0);
            } else {
                this.olo.setVisibility(8);
            }
            int i2 = this.olB.rank;
            this.hLQ.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
            if (i2 >= 100) {
                this.hLQ.setTextSize(0, this.nTb.getResources().getDimension(a.d.sdk_fontsize28));
            } else {
                this.hLQ.setTextSize(0, this.nTb.getResources().getDimension(a.d.sdk_fontsize32));
            }
            this.hLQ.setText(String.valueOf(i2));
            this.hLQ.setBackgroundResource(a.c.sdk_transparent);
            this.hLP.setText(String.format(this.nTb.getString(a.h.ala_rank_list_charm_hour), StringHelper.formatYuyinValue(this.olB.point)));
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = c.this.nTb.getIntent();
                    boolean iP = com.baidu.live.al.b.Wy().iP(intent.getStringExtra("uk"));
                    long longExtra = intent.getLongExtra("live_id", 0L);
                    try {
                        if (!String.valueOf(longExtra).equals(c.this.olB.liveId)) {
                            if (c.this.olB.eDa == 2) {
                                if (iP) {
                                    w wVar = new w();
                                    wVar.aHZ = new cx();
                                    wVar.aHZ.live_id = c.this.olB.liveId;
                                    wVar.aHZ.aRe = c.this.olB.aRe;
                                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(wVar)));
                                } else {
                                    if (com.baidu.live.al.b.Wy().isApplying()) {
                                        com.baidu.live.al.b.Wy().WH();
                                    }
                                    YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(c.this.nTb);
                                    String stringExtra = intent.getStringExtra("room_id");
                                    String stringExtra2 = intent.getStringExtra("portrait");
                                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
                                    alaLastLiveroomInfo.setLastLiveId(longExtra);
                                    alaLastLiveroomInfo.setLastRoomId(Long.valueOf(stringExtra).longValue());
                                    alaLastLiveroomInfo.setIsAudio(1);
                                    alaLastLiveroomInfo.setLastAnchorPortrait(stringExtra2);
                                    yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(c.this.olB.liveId).longValue(), c.this.olB.aRe, "live_sdk");
                                    yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                                }
                            } else {
                                w wVar2 = new w();
                                wVar2.aHZ = new cx();
                                wVar2.aHZ.live_id = c.this.olB.liveId;
                                wVar2.aHZ.aRe = c.this.olB.aRe;
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(wVar2)));
                            }
                            c.this.nTb.finish();
                        }
                    } catch (Throwable th) {
                    }
                }
            });
        }
    }
}
