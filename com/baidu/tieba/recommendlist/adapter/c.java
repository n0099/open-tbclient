package com.baidu.tieba.recommendlist.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.data.u;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.recommendlist.data.AlaRecommendLiveData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends AbsDelegateAdapter<com.baidu.tieba.recommendlist.data.c, a> {
    private u bnM;
    private int cardWidth;

    public c(Context context, BdUniqueId bdUniqueId, int i) {
        super(context, bdUniqueId);
        this.cardWidth = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: cL */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(a.h.ala_recommend_live_item_layout, viewGroup, false), this.mContext, this.cardWidth);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.recommendlist.data.c cVar, a aVar) {
        aVar.a(cVar, i, this.bnM);
        return view;
    }

    public void g(u uVar) {
        this.bnM = uVar;
    }

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        private u bnM;
        private Context mContext;
        private int mPosition;
        private String mjk;
        private RelativeLayout[] mjo;
        private TbImageView[] mjp;
        private TextView[] mjq;
        private TextView[] mjr;
        private LinearLayout[] mjs;
        private TextView[] mjt;
        private com.baidu.tieba.recommendlist.data.c mju;

        private a(View view, Context context, int i) {
            super(view);
            this.mjk = "";
            this.mContext = context;
            this.mjo = new RelativeLayout[2];
            this.mjp = new TbImageView[2];
            this.mjq = new TextView[2];
            this.mjr = new TextView[2];
            this.mjs = new LinearLayout[2];
            this.mjt = new TextView[2];
            this.mjo[0] = (RelativeLayout) view.findViewById(a.g.left_content_layout);
            this.mjo[1] = (RelativeLayout) view.findViewById(a.g.right_content_layout);
            this.mjp[0] = (TbImageView) view.findViewById(a.g.left_cover_imageView);
            this.mjp[1] = (TbImageView) view.findViewById(a.g.right_cover_imageView);
            this.mjq[0] = (TextView) view.findViewById(a.g.left_count_textView);
            this.mjq[1] = (TextView) view.findViewById(a.g.right_count_textView);
            this.mjr[0] = (TextView) view.findViewById(a.g.left_name_textView);
            this.mjr[1] = (TextView) view.findViewById(a.g.right_name_textView);
            this.mjs[0] = (LinearLayout) view.findViewById(a.g.left_location_layout);
            this.mjs[1] = (LinearLayout) view.findViewById(a.g.right_location_layout);
            this.mjt[0] = (TextView) view.findViewById(a.g.left_location_textView);
            this.mjt[1] = (TextView) view.findViewById(a.g.right_location_textView);
            this.mjp[0].getLayoutParams().width = i;
            this.mjp[0].getLayoutParams().height = i;
            this.mjp[1].getLayoutParams().width = i;
            this.mjp[1].getLayoutParams().height = i;
            this.mjp[0].setDefaultBgResource(a.f.sdk_shape_transparent);
            this.mjp[1].setDefaultBgResource(a.f.sdk_shape_transparent);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && i > 0) {
                this.mjk = "@resize{w:" + i + ",h:" + i + "}";
            }
            this.mjo[0].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.mju != null) {
                        if (a.this.mju.mjD != null) {
                            a.this.b(a.this.mju.mjD, 0, a.this.mju.type);
                        } else if (a.this.mju.mjE != null) {
                            a.this.b(a.this.mju.mjE, 0, a.this.mju.type);
                        }
                    }
                }
            });
            this.mjo[1].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.c.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.mju != null && a.this.mju.mjE != null) {
                        a.this.b(a.this.mju.mjE, 1, a.this.mju.type);
                    }
                }
            });
        }

        public void a(com.baidu.tieba.recommendlist.data.c cVar, int i, u uVar) {
            boolean z;
            int i2;
            if (cVar != null) {
                this.mju = cVar;
                this.mPosition = i;
                this.bnM = uVar;
                if (cVar.mjD != null) {
                    a(cVar.mjD, 0, this.mju.type);
                }
                if (cVar.mjE != null) {
                    if (cVar.mjD == null) {
                        i2 = 0;
                        z = false;
                    } else {
                        i2 = 1;
                        z = true;
                    }
                    a(cVar.mjE, i2, this.mju.type);
                } else {
                    z = false;
                }
                if (z) {
                    this.mjo[1].setVisibility(0);
                } else {
                    this.mjo[1].setVisibility(8);
                }
            }
        }

        private void a(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            this.mjp[i].startLoad(alaRecommendLiveData.cover + this.mjk, 10, false);
            this.mjr[i].setText(alaRecommendLiveData.getNameShow());
            this.mjq[i].setText(String.format(this.mContext.getResources().getString(a.i.recommend_live_audience_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
            if (!TextUtils.isEmpty(alaRecommendLiveData.distance) && !TextUtils.equals(alaRecommendLiveData.distance, "0")) {
                this.mjt[i].setText(alaRecommendLiveData.distance);
                this.mjs[i].setVisibility(0);
            } else {
                this.mjs[i].setVisibility(8);
            }
            a(UbcStatisticLiveKey.KEY_ID_1392, "show", alaRecommendLiveData, i2, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            if (alaRecommendLiveData != null) {
                String str = "";
                AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext);
                alaLiveRoomActivityConfig.addExtraByLiveId(alaRecommendLiveData.live_id, String.valueOf(alaRecommendLiveData.room_id), "recommend_live");
                try {
                    String flvUrl = alaRecommendLiveData.session_info != null ? alaRecommendLiveData.session_info.getFlvUrl(AlaLiveStreamSessionInfo.STREAM_LEVEL_DEFAULT) : "";
                    String str2 = alaRecommendLiveData.cover;
                    String valueOf = String.valueOf(alaRecommendLiveData.room_id);
                    String valueOf2 = String.valueOf(alaRecommendLiveData.live_id);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("live_url", flvUrl);
                    jSONObject.put("cover", str2);
                    jSONObject.put("enterRoomId", valueOf);
                    jSONObject.put("enterLiveId", valueOf2);
                    str = jSONObject.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                alaLiveRoomActivityConfig.addExtraByParams(str);
                if (this.bnM != null) {
                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                    if (this.bnM.aHD != null) {
                        alaLastLiveroomInfo.setLastAnchorPortrait(this.bnM.aHD.portrait);
                        alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.bnM.aHD.userId));
                        alaLastLiveroomInfo.setLastAnchorUname(this.bnM.aHD.nickName);
                    }
                    if (this.bnM.mLiveInfo != null) {
                        alaLastLiveroomInfo.setLastLiveId(this.bnM.mLiveInfo.live_id);
                        alaLastLiveroomInfo.setLastRoomId(this.bnM.mLiveInfo.room_id);
                        alaLastLiveroomInfo.setLastCover(this.bnM.mLiveInfo.cover);
                        if (this.bnM.mLiveInfo.session_info != null) {
                            if (!TextUtils.isEmpty(this.bnM.mLiveInfo.session_info.flvUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bnM.mLiveInfo.session_info.flvUrl);
                            } else if (!TextUtils.isEmpty(this.bnM.mLiveInfo.session_info.hlsUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bnM.mLiveInfo.session_info.hlsUrl);
                            } else if (!TextUtils.isEmpty(this.bnM.mLiveInfo.session_info.rtmpUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bnM.mLiveInfo.session_info.rtmpUrl);
                            }
                        }
                    }
                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_RECOMMEND);
                    alaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                a(UbcStatisticLiveKey.KEY_ID_1393, UbcStatConstant.ContentType.COVER_CLICK, alaRecommendLiveData, i2, i);
            }
        }

        private void a(String str, String str2, AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            int i3;
            if (alaRecommendLiveData != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (i == 0) {
                            i3 = ((this.mPosition - 1) * 2) + i2 + 1;
                        } else {
                            i3 = ((this.mPosition - 1) * 2) + i2 + 1;
                        }
                        jSONObject.put("live_id", alaRecommendLiveData.live_id).put("vid", alaRecommendLiveData.feed_id).put("model", i == 0 ? "yourfollower" : "hotlive").put("pos", i3).put("nearby", (i != 1 || TextUtils.isEmpty(alaRecommendLiveData.distance)) ? "0" : "1");
                    } catch (JSONException e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(str, str2, "your_recommend", "").setContentExt(jSONObject));
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
        }
    }
}
