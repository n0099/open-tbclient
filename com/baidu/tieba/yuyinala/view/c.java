package com.baidu.tieba.yuyinala.view;

import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.data.ct;
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
    private TextView hGl;
    private TextView hGm;
    private LottieAnimationView hGo;
    private TextView hws;
    private View mRootView;
    private AlaRankListActivity nLE;
    private FrameLayout oaF;
    private BarImageView oaR;
    private com.baidu.tieba.yuyinala.data.c oaS;

    public c(AlaRankListActivity alaRankListActivity, View view) {
        this.nLE = alaRankListActivity;
        this.mRootView = view;
        this.hws = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
        this.hGm = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
        this.hGl = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_rank_info);
        this.oaR = (BarImageView) this.mRootView.findViewById(a.g.ala_rank_list_header);
        this.oaR.setShowOval(true);
        this.oaR.setAutoChangeStyle(false);
        this.hGo = (LottieAnimationView) this.mRootView.findViewById(a.g.rank_live_anim);
        this.oaF = (FrameLayout) this.mRootView.findViewById(a.g.ll_living);
    }

    public void a(com.baidu.tieba.yuyinala.data.c cVar, int i) {
        if (cVar != null) {
            this.oaS = cVar;
            this.hws.setText(this.oaS.getNameShow());
            this.oaR.startLoad(this.oaS.cover, 12, false);
            if (this.oaS.eyT == 2) {
                this.hGo.setAnimation("alavl_room_living.json");
                this.hGo.loop(true);
                this.hGo.playAnimation();
                this.oaF.setVisibility(0);
            } else {
                this.oaF.setVisibility(8);
            }
            int i2 = this.oaS.rank;
            this.hGm.setTextColor(this.mRootView.getContext().getResources().getColor(a.d.sdk_cp_cont_d));
            if (i2 >= 100) {
                this.hGm.setTextSize(0, this.nLE.getResources().getDimension(a.e.sdk_fontsize28));
            } else {
                this.hGm.setTextSize(0, this.nLE.getResources().getDimension(a.e.sdk_fontsize32));
            }
            this.hGm.setText(String.valueOf(i2));
            this.hGm.setBackgroundResource(a.d.sdk_transparent);
            this.hGl.setText(String.format(this.nLE.getString(a.i.ala_rank_list_charm_hour), StringHelper.formatYuyinValue(this.oaS.point)));
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = c.this.nLE.getIntent();
                    boolean iI = com.baidu.live.aj.b.UH().iI(intent.getStringExtra("uk"));
                    long longExtra = intent.getLongExtra("live_id", 0L);
                    try {
                        if (!String.valueOf(longExtra).equals(c.this.oaS.liveId)) {
                            if (c.this.oaS.eyT == 2) {
                                if (iI) {
                                    w wVar = new w();
                                    wVar.aIS = new ct();
                                    wVar.aIS.live_id = c.this.oaS.liveId;
                                    wVar.aIS.aRy = c.this.oaS.aRy;
                                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(wVar)));
                                } else {
                                    if (com.baidu.live.aj.b.UH().UI()) {
                                        com.baidu.live.aj.b.UH().UR();
                                    }
                                    YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(c.this.nLE);
                                    String stringExtra = intent.getStringExtra("room_id");
                                    String stringExtra2 = intent.getStringExtra("portrait");
                                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
                                    alaLastLiveroomInfo.setLastLiveId(longExtra);
                                    alaLastLiveroomInfo.setLastRoomId(Long.valueOf(stringExtra).longValue());
                                    alaLastLiveroomInfo.setIsAudio(1);
                                    alaLastLiveroomInfo.setLastAnchorPortrait(stringExtra2);
                                    yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(c.this.oaS.liveId).longValue(), c.this.oaS.aRy, "live_sdk");
                                    yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                                }
                            } else {
                                w wVar2 = new w();
                                wVar2.aIS = new ct();
                                wVar2.aIS.live_id = c.this.oaS.liveId;
                                wVar2.aIS.aRy = c.this.oaS.aRy;
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(wVar2)));
                            }
                            c.this.nLE.finish();
                        }
                    } catch (Throwable th) {
                    }
                }
            });
        }
    }
}
