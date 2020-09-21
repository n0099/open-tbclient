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
public class a extends AbsDelegateAdapter<com.baidu.tieba.recommendlist.data.a, C0792a> {
    private u bjZ;
    private int cardWidth;
    private int lTJ;

    public a(Context context, BdUniqueId bdUniqueId, int i) {
        super(context, bdUniqueId);
        this.cardWidth = i;
    }

    public void Hd(int i) {
        this.lTJ = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: cH */
    public C0792a onCreateViewHolder(ViewGroup viewGroup) {
        return new C0792a(LayoutInflater.from(this.mContext).inflate(a.h.ala_recommend_live_item_layout, viewGroup, false), this.mContext, this.cardWidth);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.recommendlist.data.a aVar, C0792a c0792a) {
        c0792a.a(aVar, i, this.lTJ, this.bjZ);
        return view;
    }

    public void f(u uVar) {
        this.bjZ = uVar;
    }

    /* renamed from: com.baidu.tieba.recommendlist.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0792a extends TypeAdapter.ViewHolder {
        private u bjZ;
        private int lTJ;
        private RelativeLayout[] lTK;
        private TbImageView[] lTL;
        private TextView[] lTM;
        private TextView[] lTN;
        private LinearLayout[] lTO;
        private TextView[] lTP;
        private com.baidu.tieba.recommendlist.data.a lTQ;
        private String lTR;
        private Context mContext;
        private int mPosition;

        private C0792a(View view, Context context, int i) {
            super(view);
            this.lTR = "";
            this.mContext = context;
            this.lTK = new RelativeLayout[2];
            this.lTL = new TbImageView[2];
            this.lTM = new TextView[2];
            this.lTN = new TextView[2];
            this.lTO = new LinearLayout[2];
            this.lTP = new TextView[2];
            this.lTK[0] = (RelativeLayout) view.findViewById(a.g.left_content_layout);
            this.lTK[1] = (RelativeLayout) view.findViewById(a.g.right_content_layout);
            this.lTL[0] = (TbImageView) view.findViewById(a.g.left_cover_imageView);
            this.lTL[1] = (TbImageView) view.findViewById(a.g.right_cover_imageView);
            this.lTM[0] = (TextView) view.findViewById(a.g.left_count_textView);
            this.lTM[1] = (TextView) view.findViewById(a.g.right_count_textView);
            this.lTN[0] = (TextView) view.findViewById(a.g.left_name_textView);
            this.lTN[1] = (TextView) view.findViewById(a.g.right_name_textView);
            this.lTO[0] = (LinearLayout) view.findViewById(a.g.left_location_layout);
            this.lTO[1] = (LinearLayout) view.findViewById(a.g.right_location_layout);
            this.lTP[0] = (TextView) view.findViewById(a.g.left_location_textView);
            this.lTP[1] = (TextView) view.findViewById(a.g.right_location_textView);
            this.lTL[0].getLayoutParams().width = i;
            this.lTL[0].getLayoutParams().height = i;
            this.lTL[1].getLayoutParams().width = i;
            this.lTL[1].getLayoutParams().height = i;
            this.lTL[0].setDefaultBgResource(a.f.sdk_shape_transparent);
            this.lTL[1].setDefaultBgResource(a.f.sdk_shape_transparent);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && i > 0) {
                this.lTR = "@resize{w:" + i + ",h:" + i + "}";
            }
            this.lTK[0].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0792a.this.lTQ != null) {
                        if (C0792a.this.lTQ.lTW != null) {
                            C0792a.this.b(C0792a.this.lTQ.lTW, 0, C0792a.this.lTQ.type);
                        } else if (C0792a.this.lTQ.lTX != null) {
                            C0792a.this.b(C0792a.this.lTQ.lTX, 0, C0792a.this.lTQ.type);
                        }
                    }
                }
            });
            this.lTK[1].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0792a.this.lTQ != null && C0792a.this.lTQ.lTX != null) {
                        C0792a.this.b(C0792a.this.lTQ.lTX, 1, C0792a.this.lTQ.type);
                    }
                }
            });
        }

        public void a(com.baidu.tieba.recommendlist.data.a aVar, int i, int i2, u uVar) {
            boolean z;
            int i3;
            if (aVar != null) {
                this.lTQ = aVar;
                this.mPosition = i;
                this.lTJ = i2;
                this.bjZ = uVar;
                if (aVar.lTW != null) {
                    a(aVar.lTW, 0, this.lTQ.type);
                }
                if (aVar.lTX != null) {
                    if (aVar.lTW == null) {
                        i3 = 0;
                        z = false;
                    } else {
                        i3 = 1;
                        z = true;
                    }
                    a(aVar.lTX, i3, this.lTQ.type);
                } else {
                    z = false;
                }
                if (z) {
                    this.lTK[1].setVisibility(0);
                } else {
                    this.lTK[1].setVisibility(8);
                }
            }
        }

        private void a(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            this.lTL[i].startLoad(alaRecommendLiveData.cover + this.lTR, 10, false);
            this.lTN[i].setText(alaRecommendLiveData.getNameShow());
            this.lTM[i].setText(String.format(this.mContext.getResources().getString(a.i.recommend_live_audience_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
            if (!TextUtils.isEmpty(alaRecommendLiveData.distance) && !TextUtils.equals(alaRecommendLiveData.distance, "0")) {
                this.lTP[i].setText(alaRecommendLiveData.distance);
                this.lTO[i].setVisibility(0);
            } else {
                this.lTO[i].setVisibility(8);
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
                if (this.bjZ != null) {
                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                    if (this.bjZ.aEz != null) {
                        alaLastLiveroomInfo.setLastAnchorPortrait(this.bjZ.aEz.portrait);
                        alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.bjZ.aEz.userId));
                        alaLastLiveroomInfo.setLastAnchorUname(this.bjZ.aEz.nickName);
                    }
                    if (this.bjZ.mLiveInfo != null) {
                        alaLastLiveroomInfo.setLastLiveId(this.bjZ.mLiveInfo.live_id);
                        alaLastLiveroomInfo.setLastRoomId(this.bjZ.mLiveInfo.room_id);
                        alaLastLiveroomInfo.setLastCover(this.bjZ.mLiveInfo.cover);
                        if (this.bjZ.mLiveInfo.session_info != null) {
                            if (!TextUtils.isEmpty(this.bjZ.mLiveInfo.session_info.flvUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bjZ.mLiveInfo.session_info.flvUrl);
                            } else if (!TextUtils.isEmpty(this.bjZ.mLiveInfo.session_info.hlsUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bjZ.mLiveInfo.session_info.hlsUrl);
                            } else if (!TextUtils.isEmpty(this.bjZ.mLiveInfo.session_info.rtmpUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bjZ.mLiveInfo.session_info.rtmpUrl);
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
                        } else if (this.lTJ > 0) {
                            i3 = ((((this.mPosition - 1) - 1) - ((int) ((this.lTJ / 2) + 0.9f))) * 2) + i2 + 1;
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
