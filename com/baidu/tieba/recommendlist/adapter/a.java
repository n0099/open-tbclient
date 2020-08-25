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
import com.baidu.live.data.r;
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
/* loaded from: classes7.dex */
public class a extends AbsDelegateAdapter<com.baidu.tieba.recommendlist.data.a, C0795a> {
    private r bgX;
    private int cardWidth;
    private int lKC;

    public a(Context context, BdUniqueId bdUniqueId, int i) {
        super(context, bdUniqueId);
        this.cardWidth = i;
    }

    public void GC(int i) {
        this.lKC = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: cG */
    public C0795a onCreateViewHolder(ViewGroup viewGroup) {
        return new C0795a(LayoutInflater.from(this.mContext).inflate(a.h.ala_recommend_live_item_layout, viewGroup, false), this.mContext, this.cardWidth);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.recommendlist.data.a aVar, C0795a c0795a) {
        c0795a.a(aVar, i, this.lKC, this.bgX);
        return view;
    }

    public void e(r rVar) {
        this.bgX = rVar;
    }

    /* renamed from: com.baidu.tieba.recommendlist.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0795a extends TypeAdapter.ViewHolder {
        private r bgX;
        private int lKC;
        private RelativeLayout[] lKD;
        private TbImageView[] lKE;
        private TextView[] lKF;
        private TextView[] lKG;
        private LinearLayout[] lKH;
        private TextView[] lKI;
        private com.baidu.tieba.recommendlist.data.a lKJ;
        private String lKK;
        private Context mContext;
        private int mPosition;

        private C0795a(View view, Context context, int i) {
            super(view);
            this.lKK = "";
            this.mContext = context;
            this.lKD = new RelativeLayout[2];
            this.lKE = new TbImageView[2];
            this.lKF = new TextView[2];
            this.lKG = new TextView[2];
            this.lKH = new LinearLayout[2];
            this.lKI = new TextView[2];
            this.lKD[0] = (RelativeLayout) view.findViewById(a.g.left_content_layout);
            this.lKD[1] = (RelativeLayout) view.findViewById(a.g.right_content_layout);
            this.lKE[0] = (TbImageView) view.findViewById(a.g.left_cover_imageView);
            this.lKE[1] = (TbImageView) view.findViewById(a.g.right_cover_imageView);
            this.lKF[0] = (TextView) view.findViewById(a.g.left_count_textView);
            this.lKF[1] = (TextView) view.findViewById(a.g.right_count_textView);
            this.lKG[0] = (TextView) view.findViewById(a.g.left_name_textView);
            this.lKG[1] = (TextView) view.findViewById(a.g.right_name_textView);
            this.lKH[0] = (LinearLayout) view.findViewById(a.g.left_location_layout);
            this.lKH[1] = (LinearLayout) view.findViewById(a.g.right_location_layout);
            this.lKI[0] = (TextView) view.findViewById(a.g.left_location_textView);
            this.lKI[1] = (TextView) view.findViewById(a.g.right_location_textView);
            this.lKE[0].getLayoutParams().width = i;
            this.lKE[0].getLayoutParams().height = i;
            this.lKE[1].getLayoutParams().width = i;
            this.lKE[1].getLayoutParams().height = i;
            this.lKE[0].setDefaultBgResource(a.f.sdk_shape_transparent);
            this.lKE[1].setDefaultBgResource(a.f.sdk_shape_transparent);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && i > 0) {
                this.lKK = "@resize{w:" + i + ",h:" + i + "}";
            }
            this.lKD[0].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0795a.this.lKJ != null) {
                        if (C0795a.this.lKJ.lKP != null) {
                            C0795a.this.b(C0795a.this.lKJ.lKP, 0, C0795a.this.lKJ.type);
                        } else if (C0795a.this.lKJ.lKQ != null) {
                            C0795a.this.b(C0795a.this.lKJ.lKQ, 0, C0795a.this.lKJ.type);
                        }
                    }
                }
            });
            this.lKD[1].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0795a.this.lKJ != null && C0795a.this.lKJ.lKQ != null) {
                        C0795a.this.b(C0795a.this.lKJ.lKQ, 1, C0795a.this.lKJ.type);
                    }
                }
            });
        }

        public void a(com.baidu.tieba.recommendlist.data.a aVar, int i, int i2, r rVar) {
            boolean z;
            int i3;
            if (aVar != null) {
                this.lKJ = aVar;
                this.mPosition = i;
                this.lKC = i2;
                this.bgX = rVar;
                if (aVar.lKP != null) {
                    a(aVar.lKP, 0, this.lKJ.type);
                }
                if (aVar.lKQ != null) {
                    if (aVar.lKP == null) {
                        i3 = 0;
                        z = false;
                    } else {
                        i3 = 1;
                        z = true;
                    }
                    a(aVar.lKQ, i3, this.lKJ.type);
                } else {
                    z = false;
                }
                if (z) {
                    this.lKD[1].setVisibility(0);
                } else {
                    this.lKD[1].setVisibility(8);
                }
            }
        }

        private void a(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            this.lKE[i].startLoad(alaRecommendLiveData.cover + this.lKK, 10, false);
            this.lKG[i].setText(alaRecommendLiveData.getNameShow());
            this.lKF[i].setText(String.format(this.mContext.getResources().getString(a.i.recommend_live_audience_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
            if (!TextUtils.isEmpty(alaRecommendLiveData.distance) && !TextUtils.equals(alaRecommendLiveData.distance, "0")) {
                this.lKI[i].setText(alaRecommendLiveData.distance);
                this.lKH[i].setVisibility(0);
            } else {
                this.lKH[i].setVisibility(8);
            }
            a(UbcStatisticLiveKey.KEY_ID_1392, "show", alaRecommendLiveData, i2, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            if (alaRecommendLiveData != null) {
                String str = "";
                AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext);
                alaLiveRoomActivityConfig.addExtraByLiveId(alaRecommendLiveData.live_id, String.valueOf(alaRecommendLiveData.room_id), AlaLiveRoomActivityConfig.FROM_TYPE_RECOMMEND_LIVE);
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
                if (this.bgX != null) {
                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                    if (this.bgX.aDE != null) {
                        alaLastLiveroomInfo.setLastAnchorPortrait(this.bgX.aDE.portrait);
                        alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.bgX.aDE.userId));
                        alaLastLiveroomInfo.setLastAnchorUname(this.bgX.aDE.nickName);
                    }
                    if (this.bgX.mLiveInfo != null) {
                        alaLastLiveroomInfo.setLastLiveId(this.bgX.mLiveInfo.live_id);
                        alaLastLiveroomInfo.setLastRoomId(this.bgX.mLiveInfo.room_id);
                        alaLastLiveroomInfo.setLastCover(this.bgX.mLiveInfo.cover);
                        if (this.bgX.mLiveInfo.session_info != null) {
                            if (!TextUtils.isEmpty(this.bgX.mLiveInfo.session_info.flvUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bgX.mLiveInfo.session_info.flvUrl);
                            } else if (!TextUtils.isEmpty(this.bgX.mLiveInfo.session_info.hlsUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bgX.mLiveInfo.session_info.hlsUrl);
                            } else if (!TextUtils.isEmpty(this.bgX.mLiveInfo.session_info.rtmpUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bgX.mLiveInfo.session_info.rtmpUrl);
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
                        } else if (this.lKC > 0) {
                            i3 = ((((this.mPosition - 1) - 1) - ((int) ((this.lKC / 2) + 0.9f))) * 2) + i2 + 1;
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
