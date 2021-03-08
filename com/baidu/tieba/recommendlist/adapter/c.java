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
/* loaded from: classes10.dex */
public class c extends AbsDelegateAdapter<com.baidu.tieba.recommendlist.data.d, a> {
    private ab bzn;
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
        aVar.a(dVar, i, this.bzn);
        return view;
    }

    public void setAlaLiveShowData(ab abVar) {
        this.bzn = abVar;
    }

    /* loaded from: classes10.dex */
    public static class a extends TypeAdapter.ViewHolder {
        private ab bzn;
        private AlphaAnimation gEX;
        private RelativeLayout[] ihR;
        private TbImageView[] ihS;
        private TextView[] ihT;
        private TextView[] ihU;
        private LinearLayout[] ihV;
        private TextView[] ihW;
        private String iib;
        private Context mContext;
        private int mPosition;
        private com.baidu.tieba.recommendlist.data.d ncV;

        private a(View view, Context context, int i) {
            super(view);
            this.iib = "";
            this.mContext = context;
            this.ihR = new RelativeLayout[2];
            this.ihS = new TbImageView[2];
            this.ihT = new TextView[2];
            this.ihU = new TextView[2];
            this.ihV = new LinearLayout[2];
            this.ihW = new TextView[2];
            this.ihR[0] = (RelativeLayout) view.findViewById(a.f.left_content_layout);
            this.ihR[1] = (RelativeLayout) view.findViewById(a.f.right_content_layout);
            this.ihS[0] = (TbImageView) view.findViewById(a.f.left_cover_imageView);
            this.ihS[1] = (TbImageView) view.findViewById(a.f.right_cover_imageView);
            this.ihT[0] = (TextView) view.findViewById(a.f.left_count_textView);
            this.ihT[1] = (TextView) view.findViewById(a.f.right_count_textView);
            this.ihU[0] = (TextView) view.findViewById(a.f.left_name_textView);
            this.ihU[1] = (TextView) view.findViewById(a.f.right_name_textView);
            this.ihV[0] = (LinearLayout) view.findViewById(a.f.left_location_layout);
            this.ihV[1] = (LinearLayout) view.findViewById(a.f.right_location_layout);
            this.ihW[0] = (TextView) view.findViewById(a.f.left_location_textView);
            this.ihW[1] = (TextView) view.findViewById(a.f.right_location_textView);
            this.ihS[0].getLayoutParams().width = i;
            this.ihS[0].getLayoutParams().height = i;
            this.ihS[1].getLayoutParams().width = i;
            this.ihS[1].getLayoutParams().height = i;
            this.ihS[0].setDefaultBgResource(a.e.sdk_shape_transparent);
            this.ihS[1].setDefaultBgResource(a.e.sdk_shape_transparent);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && i > 0) {
                this.iib = "@resize{w:" + i + ",h:" + i + "}";
            }
            this.ihR[0].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.ncV != null) {
                        if (a.this.ncV.ndq != null) {
                            a.this.b(a.this.ncV.ndq, 0, a.this.ncV.type);
                        } else if (a.this.ncV.ndr != null) {
                            a.this.b(a.this.ncV.ndr, 0, a.this.ncV.type);
                        }
                    }
                }
            });
            this.ihR[1].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.c.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.ncV != null && a.this.ncV.ndr != null) {
                        a.this.b(a.this.ncV.ndr, 1, a.this.ncV.type);
                    }
                }
            });
            this.gEX = new AlphaAnimation(0.0f, 1.0f);
            this.gEX.setDuration(150L);
        }

        public void a(com.baidu.tieba.recommendlist.data.d dVar, int i, ab abVar) {
            boolean z;
            int i2;
            if (dVar != null) {
                this.ncV = dVar;
                this.mPosition = i;
                this.bzn = abVar;
                if (dVar.ndq != null) {
                    a(dVar.ndq, 0, this.ncV.type);
                }
                if (dVar.ndr != null) {
                    if (dVar.ndq == null) {
                        i2 = 0;
                        z = false;
                    } else {
                        i2 = 1;
                        z = true;
                    }
                    a(dVar.ndr, i2, this.ncV.type);
                } else {
                    z = false;
                }
                if (z) {
                    this.ihR[1].setVisibility(0);
                } else {
                    this.ihR[1].setVisibility(8);
                }
            }
        }

        private void a(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            final TbImageView tbImageView = this.ihS[i];
            tbImageView.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.recommendlist.adapter.c.a.3
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str, boolean z) {
                    Object tag = tbImageView.getTag(tbImageView.getId());
                    if ((tag == null || (tag instanceof String)) && !str.equals(tag)) {
                        tbImageView.setTag(tbImageView.getId(), str);
                        a.this.gEX.cancel();
                        a.this.gEX.reset();
                        tbImageView.startAnimation(a.this.gEX);
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.gEX.cancel();
            tbImageView.stopLoad();
            tbImageView.startLoad(alaRecommendLiveData.cover + this.iib, 10, false);
            this.ihU[i].setText(alaRecommendLiveData.getNameShow());
            this.ihT[i].setText(String.format(this.mContext.getResources().getString(a.h.recommend_live_audience_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
            if (!TextUtils.isEmpty(alaRecommendLiveData.distance) && !TextUtils.equals(alaRecommendLiveData.distance, "0")) {
                this.ihW[i].setText(alaRecommendLiveData.distance);
                this.ihV[i].setVisibility(0);
            } else {
                this.ihV[i].setVisibility(8);
            }
            a(UbcStatisticLiveKey.KEY_ID_1392, "show", alaRecommendLiveData, i2, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            if (alaRecommendLiveData != null) {
                com.baidu.live.liveroom.a.Mu().a(com.baidu.live.liveroom.a.Mu().Mv().hq(String.valueOf(alaRecommendLiveData.live_id)));
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
                if (this.bzn != null) {
                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                    if (this.bzn.aJD != null) {
                        alaLastLiveroomInfo.setLastAnchorPortrait(this.bzn.aJD.portrait);
                        alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.bzn.aJD.userId));
                        alaLastLiveroomInfo.setLastAnchorUname(this.bzn.aJD.nickName);
                    }
                    if (this.bzn.mLiveInfo != null) {
                        alaLastLiveroomInfo.setLastLiveId(this.bzn.mLiveInfo.live_id);
                        alaLastLiveroomInfo.setLastRoomId(this.bzn.mLiveInfo.room_id);
                        alaLastLiveroomInfo.setLastCover(this.bzn.mLiveInfo.cover);
                        if (this.bzn.mLiveInfo.session_info != null) {
                            if (!TextUtils.isEmpty(this.bzn.mLiveInfo.session_info.flvUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bzn.mLiveInfo.session_info.flvUrl);
                            } else if (!TextUtils.isEmpty(this.bzn.mLiveInfo.session_info.hlsUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bzn.mLiveInfo.session_info.hlsUrl);
                            } else if (!TextUtils.isEmpty(this.bzn.mLiveInfo.session_info.rtmpUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bzn.mLiveInfo.session_info.rtmpUrl);
                            }
                        }
                    }
                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_RECOMMEND);
                    alaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                }
                com.baidu.live.liveroom.a.Mu().a(alaLiveRoomActivityConfig);
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
