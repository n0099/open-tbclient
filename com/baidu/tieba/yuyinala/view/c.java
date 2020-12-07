package com.baidu.tieba.yuyinala.view;

import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
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
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tieba.view.BarImageView;
import com.baidu.tieba.yuyinala.AlaRankListActivity;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes4.dex */
public class c {
    private TextView hLB;
    private TextView hWJ;
    private TextView hWK;
    private LottieAnimationView hWM;
    private View mRootView;
    private BarImageView oAA;
    private com.baidu.tieba.yuyinala.data.c oAB;
    private FrameLayout oAo;
    private AlaRankListActivity ohZ;

    public c(AlaRankListActivity alaRankListActivity, View view) {
        this.ohZ = alaRankListActivity;
        this.mRootView = view;
        this.hLB = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.hWK = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.hWJ = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_rank_info);
        this.oAA = (BarImageView) this.mRootView.findViewById(a.f.ala_rank_list_header);
        this.oAA.setShowOval(true);
        this.oAA.setAutoChangeStyle(false);
        this.hWM = (LottieAnimationView) this.mRootView.findViewById(a.f.rank_live_anim);
        this.oAo = (FrameLayout) this.mRootView.findViewById(a.f.ll_living);
    }

    public void a(com.baidu.tieba.yuyinala.data.c cVar, int i) {
        if (cVar != null) {
            this.oAB = cVar;
            this.hLB.setText(this.oAB.getNameShow());
            this.oAA.startLoad(this.oAB.cover, 12, false);
            if (this.oAB.eKc == 2) {
                this.hWM.setAnimation("alavl_room_living.json");
                this.hWM.loop(true);
                this.hWM.playAnimation();
                this.oAo.setVisibility(0);
            } else {
                this.oAo.setVisibility(8);
            }
            int i2 = this.oAB.rank;
            this.hWK.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
            if (i2 >= 100) {
                this.hWK.setTextSize(0, this.ohZ.getResources().getDimension(a.d.sdk_fontsize28));
            } else {
                this.hWK.setTextSize(0, this.ohZ.getResources().getDimension(a.d.sdk_fontsize32));
            }
            this.hWK.setText(String.valueOf(i2));
            this.hWK.setBackgroundResource(a.c.sdk_transparent);
            this.hWJ.setText(String.format(this.ohZ.getString(a.h.ala_rank_list_charm_hour), StringHelper.formatYuyinValue(this.oAB.aJg)));
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = c.this.ohZ.getIntent();
                    boolean jt = com.baidu.live.ap.b.YX().jt(intent.getStringExtra("uk"));
                    long longExtra = intent.getLongExtra("live_id", 0L);
                    try {
                        if (!String.valueOf(longExtra).equals(c.this.oAB.liveId)) {
                            if (c.this.oAB.eKc == 2) {
                                if (jt) {
                                    w wVar = new w();
                                    wVar.aKL = new cz();
                                    wVar.aKL.live_id = c.this.oAB.liveId;
                                    wVar.aKL.aUg = c.this.oAB.aUg;
                                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(wVar)));
                                } else {
                                    if (com.baidu.live.ap.b.YX().isApplying()) {
                                        com.baidu.live.ap.b.YX().Zg();
                                    }
                                    YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(c.this.ohZ);
                                    String stringExtra = intent.getStringExtra("room_id");
                                    String stringExtra2 = intent.getStringExtra("portrait");
                                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
                                    alaLastLiveroomInfo.setLastLiveId(longExtra);
                                    alaLastLiveroomInfo.setLastRoomId(Long.valueOf(stringExtra).longValue());
                                    alaLastLiveroomInfo.setIsAudio(1);
                                    alaLastLiveroomInfo.setLastAnchorPortrait(stringExtra2);
                                    yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(c.this.oAB.liveId).longValue(), c.this.oAB.aUg, "live_sdk");
                                    yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                                }
                            } else {
                                w wVar2 = new w();
                                wVar2.aKL = new cz();
                                wVar2.aKL.live_id = c.this.oAB.liveId;
                                wVar2.aKL.aUg = c.this.oAB.aUg;
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(wVar2)));
                            }
                            c.this.ohZ.finish();
                        }
                    } catch (Throwable th) {
                    }
                }
            });
        }
    }
}
