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
    private r bha;
    private int cardWidth;
    private int lKP;

    public a(Context context, BdUniqueId bdUniqueId, int i) {
        super(context, bdUniqueId);
        this.cardWidth = i;
    }

    public void GC(int i) {
        this.lKP = i;
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
        c0795a.a(aVar, i, this.lKP, this.bha);
        return view;
    }

    public void e(r rVar) {
        this.bha = rVar;
    }

    /* renamed from: com.baidu.tieba.recommendlist.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0795a extends TypeAdapter.ViewHolder {
        private r bha;
        private int lKP;
        private RelativeLayout[] lKQ;
        private TbImageView[] lKR;
        private TextView[] lKS;
        private TextView[] lKT;
        private LinearLayout[] lKU;
        private TextView[] lKV;
        private com.baidu.tieba.recommendlist.data.a lKW;
        private String lKX;
        private Context mContext;
        private int mPosition;

        private C0795a(View view, Context context, int i) {
            super(view);
            this.lKX = "";
            this.mContext = context;
            this.lKQ = new RelativeLayout[2];
            this.lKR = new TbImageView[2];
            this.lKS = new TextView[2];
            this.lKT = new TextView[2];
            this.lKU = new LinearLayout[2];
            this.lKV = new TextView[2];
            this.lKQ[0] = (RelativeLayout) view.findViewById(a.g.left_content_layout);
            this.lKQ[1] = (RelativeLayout) view.findViewById(a.g.right_content_layout);
            this.lKR[0] = (TbImageView) view.findViewById(a.g.left_cover_imageView);
            this.lKR[1] = (TbImageView) view.findViewById(a.g.right_cover_imageView);
            this.lKS[0] = (TextView) view.findViewById(a.g.left_count_textView);
            this.lKS[1] = (TextView) view.findViewById(a.g.right_count_textView);
            this.lKT[0] = (TextView) view.findViewById(a.g.left_name_textView);
            this.lKT[1] = (TextView) view.findViewById(a.g.right_name_textView);
            this.lKU[0] = (LinearLayout) view.findViewById(a.g.left_location_layout);
            this.lKU[1] = (LinearLayout) view.findViewById(a.g.right_location_layout);
            this.lKV[0] = (TextView) view.findViewById(a.g.left_location_textView);
            this.lKV[1] = (TextView) view.findViewById(a.g.right_location_textView);
            this.lKR[0].getLayoutParams().width = i;
            this.lKR[0].getLayoutParams().height = i;
            this.lKR[1].getLayoutParams().width = i;
            this.lKR[1].getLayoutParams().height = i;
            this.lKR[0].setDefaultBgResource(a.f.sdk_shape_transparent);
            this.lKR[1].setDefaultBgResource(a.f.sdk_shape_transparent);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && i > 0) {
                this.lKX = "@resize{w:" + i + ",h:" + i + "}";
            }
            this.lKQ[0].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0795a.this.lKW != null) {
                        if (C0795a.this.lKW.lLc != null) {
                            C0795a.this.b(C0795a.this.lKW.lLc, 0, C0795a.this.lKW.type);
                        } else if (C0795a.this.lKW.lLd != null) {
                            C0795a.this.b(C0795a.this.lKW.lLd, 0, C0795a.this.lKW.type);
                        }
                    }
                }
            });
            this.lKQ[1].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0795a.this.lKW != null && C0795a.this.lKW.lLd != null) {
                        C0795a.this.b(C0795a.this.lKW.lLd, 1, C0795a.this.lKW.type);
                    }
                }
            });
        }

        public void a(com.baidu.tieba.recommendlist.data.a aVar, int i, int i2, r rVar) {
            boolean z;
            int i3;
            if (aVar != null) {
                this.lKW = aVar;
                this.mPosition = i;
                this.lKP = i2;
                this.bha = rVar;
                if (aVar.lLc != null) {
                    a(aVar.lLc, 0, this.lKW.type);
                }
                if (aVar.lLd != null) {
                    if (aVar.lLc == null) {
                        i3 = 0;
                        z = false;
                    } else {
                        i3 = 1;
                        z = true;
                    }
                    a(aVar.lLd, i3, this.lKW.type);
                } else {
                    z = false;
                }
                if (z) {
                    this.lKQ[1].setVisibility(0);
                } else {
                    this.lKQ[1].setVisibility(8);
                }
            }
        }

        private void a(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            this.lKR[i].startLoad(alaRecommendLiveData.cover + this.lKX, 10, false);
            this.lKT[i].setText(alaRecommendLiveData.getNameShow());
            this.lKS[i].setText(String.format(this.mContext.getResources().getString(a.i.recommend_live_audience_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
            if (!TextUtils.isEmpty(alaRecommendLiveData.distance) && !TextUtils.equals(alaRecommendLiveData.distance, "0")) {
                this.lKV[i].setText(alaRecommendLiveData.distance);
                this.lKU[i].setVisibility(0);
            } else {
                this.lKU[i].setVisibility(8);
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
                if (this.bha != null) {
                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                    if (this.bha.aDG != null) {
                        alaLastLiveroomInfo.setLastAnchorPortrait(this.bha.aDG.portrait);
                        alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.bha.aDG.userId));
                        alaLastLiveroomInfo.setLastAnchorUname(this.bha.aDG.nickName);
                    }
                    if (this.bha.mLiveInfo != null) {
                        alaLastLiveroomInfo.setLastLiveId(this.bha.mLiveInfo.live_id);
                        alaLastLiveroomInfo.setLastRoomId(this.bha.mLiveInfo.room_id);
                        alaLastLiveroomInfo.setLastCover(this.bha.mLiveInfo.cover);
                        if (this.bha.mLiveInfo.session_info != null) {
                            if (!TextUtils.isEmpty(this.bha.mLiveInfo.session_info.flvUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bha.mLiveInfo.session_info.flvUrl);
                            } else if (!TextUtils.isEmpty(this.bha.mLiveInfo.session_info.hlsUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bha.mLiveInfo.session_info.hlsUrl);
                            } else if (!TextUtils.isEmpty(this.bha.mLiveInfo.session_info.rtmpUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bha.mLiveInfo.session_info.rtmpUrl);
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
                        } else if (this.lKP > 0) {
                            i3 = ((((this.mPosition - 1) - 1) - ((int) ((this.lKP / 2) + 0.9f))) * 2) + i2 + 1;
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
