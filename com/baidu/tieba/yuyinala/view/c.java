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
    private TextView hCp;
    private TextView hMi;
    private TextView hMj;
    private LottieAnimationView hMl;
    private View mRootView;
    private AlaRankListActivity nRy;
    private FrameLayout ojL;
    private BarImageView ojX;
    private com.baidu.tieba.yuyinala.data.c ojY;

    public c(AlaRankListActivity alaRankListActivity, View view) {
        this.nRy = alaRankListActivity;
        this.mRootView = view;
        this.hCp = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.hMj = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.hMi = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_rank_info);
        this.ojX = (BarImageView) this.mRootView.findViewById(a.f.ala_rank_list_header);
        this.ojX.setShowOval(true);
        this.ojX.setAutoChangeStyle(false);
        this.hMl = (LottieAnimationView) this.mRootView.findViewById(a.f.rank_live_anim);
        this.ojL = (FrameLayout) this.mRootView.findViewById(a.f.ll_living);
    }

    public void a(com.baidu.tieba.yuyinala.data.c cVar, int i) {
        if (cVar != null) {
            this.ojY = cVar;
            this.hCp.setText(this.ojY.getNameShow());
            this.ojX.startLoad(this.ojY.cover, 12, false);
            if (this.ojY.eEI == 2) {
                this.hMl.setAnimation("alavl_room_living.json");
                this.hMl.loop(true);
                this.hMl.playAnimation();
                this.ojL.setVisibility(0);
            } else {
                this.ojL.setVisibility(8);
            }
            int i2 = this.ojY.rank;
            this.hMj.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
            if (i2 >= 100) {
                this.hMj.setTextSize(0, this.nRy.getResources().getDimension(a.d.sdk_fontsize28));
            } else {
                this.hMj.setTextSize(0, this.nRy.getResources().getDimension(a.d.sdk_fontsize32));
            }
            this.hMj.setText(String.valueOf(i2));
            this.hMj.setBackgroundResource(a.c.sdk_transparent);
            this.hMi.setText(String.format(this.nRy.getString(a.h.ala_rank_list_charm_hour), StringHelper.formatYuyinValue(this.ojY.point)));
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = c.this.nRy.getIntent();
                    boolean iV = com.baidu.live.al.b.Xh().iV(intent.getStringExtra("uk"));
                    long longExtra = intent.getLongExtra("live_id", 0L);
                    try {
                        if (!String.valueOf(longExtra).equals(c.this.ojY.liveId)) {
                            if (c.this.ojY.eEI == 2) {
                                if (iV) {
                                    w wVar = new w();
                                    wVar.aJK = new cx();
                                    wVar.aJK.live_id = c.this.ojY.liveId;
                                    wVar.aJK.aSP = c.this.ojY.aSP;
                                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(wVar)));
                                } else {
                                    if (com.baidu.live.al.b.Xh().isApplying()) {
                                        com.baidu.live.al.b.Xh().Xq();
                                    }
                                    YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(c.this.nRy);
                                    String stringExtra = intent.getStringExtra("room_id");
                                    String stringExtra2 = intent.getStringExtra("portrait");
                                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
                                    alaLastLiveroomInfo.setLastLiveId(longExtra);
                                    alaLastLiveroomInfo.setLastRoomId(Long.valueOf(stringExtra).longValue());
                                    alaLastLiveroomInfo.setIsAudio(1);
                                    alaLastLiveroomInfo.setLastAnchorPortrait(stringExtra2);
                                    yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(c.this.ojY.liveId).longValue(), c.this.ojY.aSP, "live_sdk");
                                    yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                                }
                            } else {
                                w wVar2 = new w();
                                wVar2.aJK = new cx();
                                wVar2.aJK.live_id = c.this.ojY.liveId;
                                wVar2.aJK.aSP = c.this.ojY.aSP;
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(wVar2)));
                            }
                            c.this.nRy.finish();
                        }
                    } catch (Throwable th) {
                    }
                }
            });
        }
    }
}
