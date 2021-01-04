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
/* loaded from: classes11.dex */
public class c extends AbsDelegateAdapter<com.baidu.tieba.recommendlist.data.d, a> {
    private x bzc;
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
        aVar.a(dVar, i, this.bzc);
        return view;
    }

    public void setAlaLiveShowData(x xVar) {
        this.bzc = xVar;
    }

    /* loaded from: classes11.dex */
    public static class a extends TypeAdapter.ViewHolder {
        private x bzc;
        private AlphaAnimation gEX;
        private RelativeLayout[] igh;
        private TbImageView[] igi;
        private TextView[] igj;
        private TextView[] igk;
        private LinearLayout[] igl;
        private TextView[] igm;
        private String igr;
        private Context mContext;
        private int mPosition;
        private com.baidu.tieba.recommendlist.data.d mVG;

        private a(View view, Context context, int i) {
            super(view);
            this.igr = "";
            this.mContext = context;
            this.igh = new RelativeLayout[2];
            this.igi = new TbImageView[2];
            this.igj = new TextView[2];
            this.igk = new TextView[2];
            this.igl = new LinearLayout[2];
            this.igm = new TextView[2];
            this.igh[0] = (RelativeLayout) view.findViewById(a.f.left_content_layout);
            this.igh[1] = (RelativeLayout) view.findViewById(a.f.right_content_layout);
            this.igi[0] = (TbImageView) view.findViewById(a.f.left_cover_imageView);
            this.igi[1] = (TbImageView) view.findViewById(a.f.right_cover_imageView);
            this.igj[0] = (TextView) view.findViewById(a.f.left_count_textView);
            this.igj[1] = (TextView) view.findViewById(a.f.right_count_textView);
            this.igk[0] = (TextView) view.findViewById(a.f.left_name_textView);
            this.igk[1] = (TextView) view.findViewById(a.f.right_name_textView);
            this.igl[0] = (LinearLayout) view.findViewById(a.f.left_location_layout);
            this.igl[1] = (LinearLayout) view.findViewById(a.f.right_location_layout);
            this.igm[0] = (TextView) view.findViewById(a.f.left_location_textView);
            this.igm[1] = (TextView) view.findViewById(a.f.right_location_textView);
            this.igi[0].getLayoutParams().width = i;
            this.igi[0].getLayoutParams().height = i;
            this.igi[1].getLayoutParams().width = i;
            this.igi[1].getLayoutParams().height = i;
            this.igi[0].setDefaultBgResource(a.e.sdk_shape_transparent);
            this.igi[1].setDefaultBgResource(a.e.sdk_shape_transparent);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && i > 0) {
                this.igr = "@resize{w:" + i + ",h:" + i + "}";
            }
            this.igh[0].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.mVG != null) {
                        if (a.this.mVG.mWb != null) {
                            a.this.b(a.this.mVG.mWb, 0, a.this.mVG.type);
                        } else if (a.this.mVG.mWc != null) {
                            a.this.b(a.this.mVG.mWc, 0, a.this.mVG.type);
                        }
                    }
                }
            });
            this.igh[1].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.c.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.mVG != null && a.this.mVG.mWc != null) {
                        a.this.b(a.this.mVG.mWc, 1, a.this.mVG.type);
                    }
                }
            });
            this.gEX = new AlphaAnimation(0.0f, 1.0f);
            this.gEX.setDuration(150L);
        }

        public void a(com.baidu.tieba.recommendlist.data.d dVar, int i, x xVar) {
            boolean z;
            int i2;
            if (dVar != null) {
                this.mVG = dVar;
                this.mPosition = i;
                this.bzc = xVar;
                if (dVar.mWb != null) {
                    a(dVar.mWb, 0, this.mVG.type);
                }
                if (dVar.mWc != null) {
                    if (dVar.mWb == null) {
                        i2 = 0;
                        z = false;
                    } else {
                        i2 = 1;
                        z = true;
                    }
                    a(dVar.mWc, i2, this.mVG.type);
                } else {
                    z = false;
                }
                if (z) {
                    this.igh[1].setVisibility(0);
                } else {
                    this.igh[1].setVisibility(8);
                }
            }
        }

        private void a(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            final TbImageView tbImageView = this.igi[i];
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
            tbImageView.startLoad(alaRecommendLiveData.cover + this.igr, 10, false);
            this.igk[i].setText(alaRecommendLiveData.getNameShow());
            this.igj[i].setText(String.format(this.mContext.getResources().getString(a.h.recommend_live_audience_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
            if (!TextUtils.isEmpty(alaRecommendLiveData.distance) && !TextUtils.equals(alaRecommendLiveData.distance, "0")) {
                this.igm[i].setText(alaRecommendLiveData.distance);
                this.igl[i].setVisibility(0);
            } else {
                this.igl[i].setVisibility(8);
            }
            a(UbcStatisticLiveKey.KEY_ID_1392, "show", alaRecommendLiveData, i2, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            if (alaRecommendLiveData != null) {
                com.baidu.live.liveroom.a.OO().a(com.baidu.live.liveroom.a.OO().OP().hW(String.valueOf(alaRecommendLiveData.live_id)));
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
                if (this.bzc != null) {
                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                    if (this.bzc.aKu != null) {
                        alaLastLiveroomInfo.setLastAnchorPortrait(this.bzc.aKu.portrait);
                        alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.bzc.aKu.userId));
                        alaLastLiveroomInfo.setLastAnchorUname(this.bzc.aKu.nickName);
                    }
                    if (this.bzc.mLiveInfo != null) {
                        alaLastLiveroomInfo.setLastLiveId(this.bzc.mLiveInfo.live_id);
                        alaLastLiveroomInfo.setLastRoomId(this.bzc.mLiveInfo.room_id);
                        alaLastLiveroomInfo.setLastCover(this.bzc.mLiveInfo.cover);
                        if (this.bzc.mLiveInfo.session_info != null) {
                            if (!TextUtils.isEmpty(this.bzc.mLiveInfo.session_info.flvUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bzc.mLiveInfo.session_info.flvUrl);
                            } else if (!TextUtils.isEmpty(this.bzc.mLiveInfo.session_info.hlsUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bzc.mLiveInfo.session_info.hlsUrl);
                            } else if (!TextUtils.isEmpty(this.bzc.mLiveInfo.session_info.rtmpUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bzc.mLiveInfo.session_info.rtmpUrl);
                            }
                        }
                    }
                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_RECOMMEND);
                    alaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                }
                com.baidu.live.liveroom.a.OO().a(alaLiveRoomActivityConfig);
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
