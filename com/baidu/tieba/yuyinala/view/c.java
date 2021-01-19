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
/* loaded from: classes10.dex */
public class c {
    private TextView hTx;
    private TextView ieE;
    private TextView ieF;
    private LottieAnimationView ieH;
    private View mRootView;
    private FrameLayout oDA;
    private BarImageView oDN;
    private com.baidu.tieba.yuyinala.data.c oDO;
    private AlaRankListActivity ofd;

    public c(AlaRankListActivity alaRankListActivity, View view) {
        this.ofd = alaRankListActivity;
        this.mRootView = view;
        this.hTx = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.ieF = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.ieE = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_rank_info);
        this.oDN = (BarImageView) this.mRootView.findViewById(a.f.ala_rank_list_header);
        this.oDN.setShowOval(true);
        this.oDN.setAutoChangeStyle(false);
        this.ieH = (LottieAnimationView) this.mRootView.findViewById(a.f.rank_live_anim);
        this.oDA = (FrameLayout) this.mRootView.findViewById(a.f.ll_living);
    }

    public void a(com.baidu.tieba.yuyinala.data.c cVar, int i) {
        if (cVar != null) {
            this.oDO = cVar;
            this.hTx.setText(this.oDO.getNameShow());
            this.oDN.startLoad(this.oDO.cover, 12, false);
            if (this.oDO.ePl == 2) {
                this.ieH.setAnimation("alavl_room_living.json");
                this.ieH.loop(true);
                this.ieH.playAnimation();
                this.oDA.setVisibility(0);
            } else {
                this.oDA.setVisibility(8);
            }
            int i2 = this.oDO.rank;
            this.ieF.setTextColor(this.mRootView.getContext().getResources().getColor(a.c.sdk_cp_cont_d));
            if (i2 >= 100) {
                this.ieF.setTextSize(0, this.ofd.getResources().getDimension(a.d.sdk_fontsize28));
            } else {
                this.ieF.setTextSize(0, this.ofd.getResources().getDimension(a.d.sdk_fontsize32));
            }
            this.ieF.setText(String.valueOf(i2));
            this.ieF.setBackgroundResource(a.c.sdk_transparent);
            this.ieE.setText(String.format(this.ofd.getString(a.h.ala_rank_list_charm_hour), StringHelper.formatYuyinValue(this.oDO.aER)));
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = c.this.ofd.getIntent();
                    boolean ib = com.baidu.live.aq.a.Wu().ib(intent.getStringExtra("uk"));
                    long longExtra = intent.getLongExtra("live_id", 0L);
                    try {
                        if (!String.valueOf(longExtra).equals(c.this.oDO.liveId)) {
                            if (c.this.oDO.ePl == 2) {
                                if (ib) {
                                    x xVar = new x();
                                    xVar.aGy = new dd();
                                    xVar.aGy.live_id = c.this.oDO.liveId;
                                    xVar.aGy.aQH = c.this.oDO.aQH;
                                    MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(xVar)));
                                } else {
                                    if (com.baidu.live.aq.a.Wu().isApplying()) {
                                        com.baidu.live.aq.a.Wu().WD();
                                    }
                                    YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(c.this.ofd);
                                    String stringExtra = intent.getStringExtra("room_id");
                                    String stringExtra2 = intent.getStringExtra("portrait");
                                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
                                    alaLastLiveroomInfo.setLastLiveId(longExtra);
                                    alaLastLiveroomInfo.setLastRoomId(Long.valueOf(stringExtra).longValue());
                                    alaLastLiveroomInfo.setIsAudio(1);
                                    alaLastLiveroomInfo.setLastAnchorPortrait(stringExtra2);
                                    yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(Long.valueOf(c.this.oDO.liveId).longValue(), c.this.oDO.aQH, "live_sdk");
                                    yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                                }
                            } else {
                                x xVar2 = new x();
                                xVar2.aGy = new dd();
                                xVar2.aGy.live_id = c.this.oDO.liveId;
                                xVar2.aGy.aQH = c.this.oDO.aQH;
                                MessageManager.getInstance().dispatchResponsedMessage(new YuyinShowRoomDialogMessage(new ShowRoomCard(xVar2)));
                            }
                            c.this.ofd.finish();
                        }
                    } catch (Throwable th) {
                    }
                }
            });
        }
    }
}
