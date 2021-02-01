package com.baidu.tieba.recommendlist.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.recommendlist.data.AlaRecommendLiveData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends AbsDelegateAdapter<com.baidu.tieba.recommendlist.data.d, a> {
    private ab bxN;
    private int cardWidth;

    public c(Context context, BdUniqueId bdUniqueId, int i) {
        super(context, bdUniqueId);
        this.cardWidth = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: da */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(a.g.ala_recommend_live_item_layout, viewGroup, false), this.mContext, this.cardWidth);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.recommendlist.data.d dVar, a aVar) {
        aVar.a(dVar, i, this.bxN);
        return view;
    }

    public void setAlaLiveShowData(ab abVar) {
        this.bxN = abVar;
    }

    /* loaded from: classes11.dex */
    public static class a extends TypeAdapter.ViewHolder {
        private ab bxN;
        private AlphaAnimation gDa;
        private RelativeLayout[] ifU;
        private TbImageView[] ifV;
        private TextView[] ifW;
        private TextView[] ifX;
        private LinearLayout[] ifY;
        private TextView[] ifZ;
        private String ige;
        private Context mContext;
        private int mPosition;
        private com.baidu.tieba.recommendlist.data.d naq;

        private a(View view, Context context, int i) {
            super(view);
            this.ige = "";
            this.mContext = context;
            this.ifU = new RelativeLayout[2];
            this.ifV = new TbImageView[2];
            this.ifW = new TextView[2];
            this.ifX = new TextView[2];
            this.ifY = new LinearLayout[2];
            this.ifZ = new TextView[2];
            this.ifU[0] = (RelativeLayout) view.findViewById(a.f.left_content_layout);
            this.ifU[1] = (RelativeLayout) view.findViewById(a.f.right_content_layout);
            this.ifV[0] = (TbImageView) view.findViewById(a.f.left_cover_imageView);
            this.ifV[1] = (TbImageView) view.findViewById(a.f.right_cover_imageView);
            this.ifW[0] = (TextView) view.findViewById(a.f.left_count_textView);
            this.ifW[1] = (TextView) view.findViewById(a.f.right_count_textView);
            this.ifX[0] = (TextView) view.findViewById(a.f.left_name_textView);
            this.ifX[1] = (TextView) view.findViewById(a.f.right_name_textView);
            this.ifY[0] = (LinearLayout) view.findViewById(a.f.left_location_layout);
            this.ifY[1] = (LinearLayout) view.findViewById(a.f.right_location_layout);
            this.ifZ[0] = (TextView) view.findViewById(a.f.left_location_textView);
            this.ifZ[1] = (TextView) view.findViewById(a.f.right_location_textView);
            this.ifV[0].getLayoutParams().width = i;
            this.ifV[0].getLayoutParams().height = i;
            this.ifV[1].getLayoutParams().width = i;
            this.ifV[1].getLayoutParams().height = i;
            this.ifV[0].setDefaultBgResource(a.e.sdk_shape_transparent);
            this.ifV[1].setDefaultBgResource(a.e.sdk_shape_transparent);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && i > 0) {
                this.ige = "@resize{w:" + i + ",h:" + i + "}";
            }
            this.ifU[0].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.naq != null) {
                        if (a.this.naq.naM != null) {
                            a.this.b(a.this.naq.naM, 0, a.this.naq.type);
                        } else if (a.this.naq.naN != null) {
                            a.this.b(a.this.naq.naN, 0, a.this.naq.type);
                        }
                    }
                }
            });
            this.ifU[1].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.c.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.naq != null && a.this.naq.naN != null) {
                        a.this.b(a.this.naq.naN, 1, a.this.naq.type);
                    }
                }
            });
            this.gDa = new AlphaAnimation(0.0f, 1.0f);
            this.gDa.setDuration(150L);
        }

        public void a(com.baidu.tieba.recommendlist.data.d dVar, int i, ab abVar) {
            boolean z;
            int i2;
            if (dVar != null) {
                this.naq = dVar;
                this.mPosition = i;
                this.bxN = abVar;
                if (dVar.naM != null) {
                    a(dVar.naM, 0, this.naq.type);
                }
                if (dVar.naN != null) {
                    if (dVar.naM == null) {
                        i2 = 0;
                        z = false;
                    } else {
                        i2 = 1;
                        z = true;
                    }
                    a(dVar.naN, i2, this.naq.type);
                } else {
                    z = false;
                }
                if (z) {
                    this.ifU[1].setVisibility(0);
                } else {
                    this.ifU[1].setVisibility(8);
                }
            }
        }

        private void a(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            final TbImageView tbImageView = this.ifV[i];
            tbImageView.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.recommendlist.adapter.c.a.3
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str, boolean z) {
                    Object tag = tbImageView.getTag(tbImageView.getId());
                    if ((tag == null || (tag instanceof String)) && !str.equals(tag)) {
                        tbImageView.setTag(tbImageView.getId(), str);
                        a.this.gDa.cancel();
                        a.this.gDa.reset();
                        tbImageView.startAnimation(a.this.gDa);
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.gDa.cancel();
            tbImageView.stopLoad();
            tbImageView.startLoad(alaRecommendLiveData.cover + this.ige, 10, false);
            this.ifX[i].setText(alaRecommendLiveData.getNameShow());
            this.ifW[i].setText(String.format(this.mContext.getResources().getString(a.h.recommend_live_audience_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
            if (!TextUtils.isEmpty(alaRecommendLiveData.distance) && !TextUtils.equals(alaRecommendLiveData.distance, "0")) {
                this.ifZ[i].setText(alaRecommendLiveData.distance);
                this.ifY[i].setVisibility(0);
            } else {
                this.ifY[i].setVisibility(8);
            }
            a(UbcStatisticLiveKey.KEY_ID_1392, "show", alaRecommendLiveData, i2, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            if (alaRecommendLiveData != null) {
                com.baidu.live.liveroom.a.Mr().a(com.baidu.live.liveroom.a.Mr().Ms().hk(String.valueOf(alaRecommendLiveData.live_id)));
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
                if (this.bxN != null) {
                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                    if (this.bxN.aId != null) {
                        alaLastLiveroomInfo.setLastAnchorPortrait(this.bxN.aId.portrait);
                        alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.bxN.aId.userId));
                        alaLastLiveroomInfo.setLastAnchorUname(this.bxN.aId.nickName);
                    }
                    if (this.bxN.mLiveInfo != null) {
                        alaLastLiveroomInfo.setLastLiveId(this.bxN.mLiveInfo.live_id);
                        alaLastLiveroomInfo.setLastRoomId(this.bxN.mLiveInfo.room_id);
                        alaLastLiveroomInfo.setLastCover(this.bxN.mLiveInfo.cover);
                        if (this.bxN.mLiveInfo.session_info != null) {
                            if (!TextUtils.isEmpty(this.bxN.mLiveInfo.session_info.flvUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bxN.mLiveInfo.session_info.flvUrl);
                            } else if (!TextUtils.isEmpty(this.bxN.mLiveInfo.session_info.hlsUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bxN.mLiveInfo.session_info.hlsUrl);
                            } else if (!TextUtils.isEmpty(this.bxN.mLiveInfo.session_info.rtmpUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bxN.mLiveInfo.session_info.rtmpUrl);
                            }
                        }
                    }
                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_RECOMMEND);
                    alaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                }
                com.baidu.live.liveroom.a.Mr().a(alaLiveRoomActivityConfig);
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
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(str, str2, UbcStatConstant.Page.LIVE_RECOMMEND, "").setContentExt(jSONObject));
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
        }
    }
}
