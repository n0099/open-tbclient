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
import com.baidu.live.data.x;
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
/* loaded from: classes10.dex */
public class c extends AbsDelegateAdapter<com.baidu.tieba.recommendlist.data.d, a> {
    private x buq;
    private int cardWidth;

    public c(Context context, BdUniqueId bdUniqueId, int i) {
        super(context, bdUniqueId);
        this.cardWidth = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: cZ */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(a.g.ala_recommend_live_item_layout, viewGroup, false), this.mContext, this.cardWidth);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.recommendlist.data.d dVar, a aVar) {
        aVar.a(dVar, i, this.buq);
        return view;
    }

    public void setAlaLiveShowData(x xVar) {
        this.buq = xVar;
    }

    /* loaded from: classes10.dex */
    public static class a extends TypeAdapter.ViewHolder {
        private x buq;
        private AlphaAnimation gAq;
        private LinearLayout[] ibA;
        private TextView[] ibB;
        private String ibG;
        private RelativeLayout[] ibw;
        private TbImageView[] ibx;
        private TextView[] iby;
        private TextView[] ibz;
        private Context mContext;
        private int mPosition;
        private com.baidu.tieba.recommendlist.data.d mQU;

        private a(View view, Context context, int i) {
            super(view);
            this.ibG = "";
            this.mContext = context;
            this.ibw = new RelativeLayout[2];
            this.ibx = new TbImageView[2];
            this.iby = new TextView[2];
            this.ibz = new TextView[2];
            this.ibA = new LinearLayout[2];
            this.ibB = new TextView[2];
            this.ibw[0] = (RelativeLayout) view.findViewById(a.f.left_content_layout);
            this.ibw[1] = (RelativeLayout) view.findViewById(a.f.right_content_layout);
            this.ibx[0] = (TbImageView) view.findViewById(a.f.left_cover_imageView);
            this.ibx[1] = (TbImageView) view.findViewById(a.f.right_cover_imageView);
            this.iby[0] = (TextView) view.findViewById(a.f.left_count_textView);
            this.iby[1] = (TextView) view.findViewById(a.f.right_count_textView);
            this.ibz[0] = (TextView) view.findViewById(a.f.left_name_textView);
            this.ibz[1] = (TextView) view.findViewById(a.f.right_name_textView);
            this.ibA[0] = (LinearLayout) view.findViewById(a.f.left_location_layout);
            this.ibA[1] = (LinearLayout) view.findViewById(a.f.right_location_layout);
            this.ibB[0] = (TextView) view.findViewById(a.f.left_location_textView);
            this.ibB[1] = (TextView) view.findViewById(a.f.right_location_textView);
            this.ibx[0].getLayoutParams().width = i;
            this.ibx[0].getLayoutParams().height = i;
            this.ibx[1].getLayoutParams().width = i;
            this.ibx[1].getLayoutParams().height = i;
            this.ibx[0].setDefaultBgResource(a.e.sdk_shape_transparent);
            this.ibx[1].setDefaultBgResource(a.e.sdk_shape_transparent);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && i > 0) {
                this.ibG = "@resize{w:" + i + ",h:" + i + "}";
            }
            this.ibw[0].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.mQU != null) {
                        if (a.this.mQU.mRp != null) {
                            a.this.b(a.this.mQU.mRp, 0, a.this.mQU.type);
                        } else if (a.this.mQU.mRq != null) {
                            a.this.b(a.this.mQU.mRq, 0, a.this.mQU.type);
                        }
                    }
                }
            });
            this.ibw[1].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.c.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.mQU != null && a.this.mQU.mRq != null) {
                        a.this.b(a.this.mQU.mRq, 1, a.this.mQU.type);
                    }
                }
            });
            this.gAq = new AlphaAnimation(0.0f, 1.0f);
            this.gAq.setDuration(150L);
        }

        public void a(com.baidu.tieba.recommendlist.data.d dVar, int i, x xVar) {
            boolean z;
            int i2;
            if (dVar != null) {
                this.mQU = dVar;
                this.mPosition = i;
                this.buq = xVar;
                if (dVar.mRp != null) {
                    a(dVar.mRp, 0, this.mQU.type);
                }
                if (dVar.mRq != null) {
                    if (dVar.mRp == null) {
                        i2 = 0;
                        z = false;
                    } else {
                        i2 = 1;
                        z = true;
                    }
                    a(dVar.mRq, i2, this.mQU.type);
                } else {
                    z = false;
                }
                if (z) {
                    this.ibw[1].setVisibility(0);
                } else {
                    this.ibw[1].setVisibility(8);
                }
            }
        }

        private void a(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            final TbImageView tbImageView = this.ibx[i];
            tbImageView.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.recommendlist.adapter.c.a.3
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str, boolean z) {
                    Object tag = tbImageView.getTag(tbImageView.getId());
                    if ((tag == null || (tag instanceof String)) && !str.equals(tag)) {
                        tbImageView.setTag(tbImageView.getId(), str);
                        a.this.gAq.cancel();
                        a.this.gAq.reset();
                        tbImageView.startAnimation(a.this.gAq);
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.gAq.cancel();
            tbImageView.stopLoad();
            tbImageView.startLoad(alaRecommendLiveData.cover + this.ibG, 10, false);
            this.ibz[i].setText(alaRecommendLiveData.getNameShow());
            this.iby[i].setText(String.format(this.mContext.getResources().getString(a.h.recommend_live_audience_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
            if (!TextUtils.isEmpty(alaRecommendLiveData.distance) && !TextUtils.equals(alaRecommendLiveData.distance, "0")) {
                this.ibB[i].setText(alaRecommendLiveData.distance);
                this.ibA[i].setVisibility(0);
            } else {
                this.ibA[i].setVisibility(8);
            }
            a(UbcStatisticLiveKey.KEY_ID_1392, "show", alaRecommendLiveData, i2, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            if (alaRecommendLiveData != null) {
                com.baidu.live.liveroom.a.KT().a(com.baidu.live.liveroom.a.KT().KU().gL(String.valueOf(alaRecommendLiveData.live_id)));
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
                if (this.buq != null) {
                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                    if (this.buq.aFH != null) {
                        alaLastLiveroomInfo.setLastAnchorPortrait(this.buq.aFH.portrait);
                        alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.buq.aFH.userId));
                        alaLastLiveroomInfo.setLastAnchorUname(this.buq.aFH.nickName);
                    }
                    if (this.buq.mLiveInfo != null) {
                        alaLastLiveroomInfo.setLastLiveId(this.buq.mLiveInfo.live_id);
                        alaLastLiveroomInfo.setLastRoomId(this.buq.mLiveInfo.room_id);
                        alaLastLiveroomInfo.setLastCover(this.buq.mLiveInfo.cover);
                        if (this.buq.mLiveInfo.session_info != null) {
                            if (!TextUtils.isEmpty(this.buq.mLiveInfo.session_info.flvUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.buq.mLiveInfo.session_info.flvUrl);
                            } else if (!TextUtils.isEmpty(this.buq.mLiveInfo.session_info.hlsUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.buq.mLiveInfo.session_info.hlsUrl);
                            } else if (!TextUtils.isEmpty(this.buq.mLiveInfo.session_info.rtmpUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.buq.mLiveInfo.session_info.rtmpUrl);
                            }
                        }
                    }
                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_RECOMMEND);
                    alaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                }
                com.baidu.live.liveroom.a.KT().a(alaLiveRoomActivityConfig);
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
