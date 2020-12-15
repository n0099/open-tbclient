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
    private TextView hLD;
    private TextView hWL;
    private TextView hWM;
    private LottieAnimationView hWO;
    private View mRootView;
    private BarImageView oAC;
    private com.baidu.tieba.yuyinala.data.c oAD;
    private FrameLayout oAq;
    private AlaRankListActivity oib;

    public c(AlaRankListActivity alaRankListActivity, View view) {
        this.oib = alaRankListActivity;
        this.mRootView = view;
        this.hLD = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.hWM = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.hWL = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_rank_info);
        this.oAC = (BarImageView) this.mRootView.findViewById(a.f.ala_rank_list_header);
        this.oAC.setShowOval(true);
        this.oAC.setAutoChangeStyle(false);
        this.hWO = (LottieAnimationView) this.mRootView.findViewById(a.f.rank_live_anim);
        this.oAq = (FrameLayout) this.mRootView.findViewById(a.f.ll_living);
    }

    public void a(com.baidu.tieba.yuyinala.data.c cVar, int i) {
        if (cVar != null) {
            this.oAD = cVar;
            this.hLD.setText(this.oAD.getNameShow());
            this.oAC.startLoad(this.oAD.cover, 12, false);
            if (this.oAD.eKc == 2) {
                this.hWO.setAnimation("alavl_room_living.json");
                this.hWO.loop(true);
                this.hWO.playAnimation();
                this.oAq.setVisibility(0);
            } else {
                this.oAq.setVisibility(8);
            }
            int i2 = this.oAD.rank;
            this.hWM.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
            if (i2 >= 100) {
                this.hWM.setTextSize(0, this.oib.getResources().getDimension(a.d.sdk_fontsize28));
            } else {
                this.hWM.setTextSize(0, this.oib.getResources().getDimension(a.d.sdk_fontsize32));
            }
            this.hWM.setText(String.valueOf(i2));
            this.hWM.setBackgroundResource(a.c.sdk_transparent);
            this.hWL.setText(String.format(this.oib.getString(a.h.ala_rank_list_charm_hour), StringHelper.formatYuyinValue(this.oAD.aJg)));
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = c.this.oib.getIntent();
                    boolean jt = com.baidu.live.ap.b.YX().jt(intent.getStringExtra("uk"));
                    long longExtra = intent.getLongExtra("live_id", 0L);
                    try {
                        if (!String.valueOf(longExtra).equals(c.this.oAD.liveId)) {
                            if (c.this.oAD.eKc == 2) {
                                if (jt) {
                                    w wVar = new w();
                                    wVar.aKL = new cz();
                                    wVar.aKL.live_id = c.this.oAD.liveId;
                                    wVar.aKL.aUg = c.this.oAD.aUg;
                                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(wVar)));
                                } else {
                                    if (com.baidu.live.ap.b.YX().isApplying()) {
                                        com.baidu.live.ap.b.YX().Zg();
                                    }
                                    YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(c.this.oib);
                                    String stringExtra = intent.getStringExtra("room_id");
                                    String stringExtra2 = intent.getStringExtra("portrait");
                                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
                                    alaLastLiveroomInfo.setLastLiveId(longExtra);
                                    alaLastLiveroomInfo.setLastRoomId(Long.valueOf(stringExtra).longValue());
                                    alaLastLiveroomInfo.setIsAudio(1);
                                    alaLastLiveroomInfo.setLastAnchorPortrait(stringExtra2);
                                    yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(c.this.oAD.liveId).longValue(), c.this.oAD.aUg, "live_sdk");
                                    yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                                }
                            } else {
                                w wVar2 = new w();
                                wVar2.aKL = new cz();
                                wVar2.aKL.live_id = c.this.oAD.liveId;
                                wVar2.aKL.aUg = c.this.oAD.aUg;
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(wVar2)));
                            }
                            c.this.oib.finish();
                        }
                    } catch (Throwable th) {
                    }
                }
            });
        }
    }
}
