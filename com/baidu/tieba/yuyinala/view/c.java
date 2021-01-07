package com.baidu.tieba.yuyinala.view;

import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
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
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tieba.view.BarImageView;
import com.baidu.tieba.yuyinala.AlaRankListActivity;
/* loaded from: classes11.dex */
public class c {
    private TextView hYe;
    private TextView ijl;
    private TextView ijm;
    private LottieAnimationView ijo;
    private View mRootView;
    private FrameLayout oIe;
    private BarImageView oIr;
    private com.baidu.tieba.yuyinala.data.c oIs;
    private AlaRankListActivity ojI;

    public c(AlaRankListActivity alaRankListActivity, View view) {
        this.ojI = alaRankListActivity;
        this.mRootView = view;
        this.hYe = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.ijm = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.ijl = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_rank_info);
        this.oIr = (BarImageView) this.mRootView.findViewById(a.f.ala_rank_list_header);
        this.oIr.setShowOval(true);
        this.oIr.setAutoChangeStyle(false);
        this.ijo = (LottieAnimationView) this.mRootView.findViewById(a.f.rank_live_anim);
        this.oIe = (FrameLayout) this.mRootView.findViewById(a.f.ll_living);
    }

    public void a(com.baidu.tieba.yuyinala.data.c cVar, int i) {
        if (cVar != null) {
            this.oIs = cVar;
            this.hYe.setText(this.oIs.getNameShow());
            this.oIr.startLoad(this.oIs.cover, 12, false);
            if (this.oIs.eTW == 2) {
                this.ijo.setAnimation("alavl_room_living.json");
                this.ijo.loop(true);
                this.ijo.playAnimation();
                this.oIe.setVisibility(0);
            } else {
                this.oIe.setVisibility(8);
            }
            int i2 = this.oIs.rank;
            this.ijm.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
            if (i2 >= 100) {
                this.ijm.setTextSize(0, this.ojI.getResources().getDimension(a.d.sdk_fontsize28));
            } else {
                this.ijm.setTextSize(0, this.ojI.getResources().getDimension(a.d.sdk_fontsize32));
            }
            this.ijm.setText(String.valueOf(i2));
            this.ijm.setBackgroundResource(a.c.sdk_transparent);
            this.ijl.setText(String.format(this.ojI.getString(a.h.ala_rank_list_charm_hour), StringHelper.formatYuyinValue(this.oIs.aJE)));
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = c.this.ojI.getIntent();
                    boolean jm = com.baidu.live.aq.a.aan().jm(intent.getStringExtra("uk"));
                    long longExtra = intent.getLongExtra("live_id", 0L);
                    try {
                        if (!String.valueOf(longExtra).equals(c.this.oIs.liveId)) {
                            if (c.this.oIs.eTW == 2) {
                                if (jm) {
                                    x xVar = new x();
                                    xVar.aLl = new dd();
                                    xVar.aLl.live_id = c.this.oIs.liveId;
                                    xVar.aLl.aVu = c.this.oIs.aVu;
                                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(xVar)));
                                } else {
                                    if (com.baidu.live.aq.a.aan().isApplying()) {
                                        com.baidu.live.aq.a.aan().aaw();
                                    }
                                    YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(c.this.ojI);
                                    String stringExtra = intent.getStringExtra("room_id");
                                    String stringExtra2 = intent.getStringExtra("portrait");
                                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
                                    alaLastLiveroomInfo.setLastLiveId(longExtra);
                                    alaLastLiveroomInfo.setLastRoomId(Long.valueOf(stringExtra).longValue());
                                    alaLastLiveroomInfo.setIsAudio(1);
                                    alaLastLiveroomInfo.setLastAnchorPortrait(stringExtra2);
                                    yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(c.this.oIs.liveId).longValue(), c.this.oIs.aVu, "live_sdk");
                                    yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                                }
                            } else {
                                x xVar2 = new x();
                                xVar2.aLl = new dd();
                                xVar2.aLl.live_id = c.this.oIs.liveId;
                                xVar2.aLl.aVu = c.this.oIs.aVu;
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(xVar2)));
                            }
                            c.this.ojI.finish();
                        }
                    } catch (Throwable th) {
                    }
                }
            });
        }
    }
}
