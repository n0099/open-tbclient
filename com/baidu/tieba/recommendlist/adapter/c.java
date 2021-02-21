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
        private AlphaAnimation gDo;
        private RelativeLayout[] igi;
        private TbImageView[] igj;
        private TextView[] igk;
        private TextView[] igl;
        private LinearLayout[] igm;
        private TextView[] ign;
        private String igs;
        private Context mContext;
        private int mPosition;
        private com.baidu.tieba.recommendlist.data.d naR;

        private a(View view, Context context, int i) {
            super(view);
            this.igs = "";
            this.mContext = context;
            this.igi = new RelativeLayout[2];
            this.igj = new TbImageView[2];
            this.igk = new TextView[2];
            this.igl = new TextView[2];
            this.igm = new LinearLayout[2];
            this.ign = new TextView[2];
            this.igi[0] = (RelativeLayout) view.findViewById(a.f.left_content_layout);
            this.igi[1] = (RelativeLayout) view.findViewById(a.f.right_content_layout);
            this.igj[0] = (TbImageView) view.findViewById(a.f.left_cover_imageView);
            this.igj[1] = (TbImageView) view.findViewById(a.f.right_cover_imageView);
            this.igk[0] = (TextView) view.findViewById(a.f.left_count_textView);
            this.igk[1] = (TextView) view.findViewById(a.f.right_count_textView);
            this.igl[0] = (TextView) view.findViewById(a.f.left_name_textView);
            this.igl[1] = (TextView) view.findViewById(a.f.right_name_textView);
            this.igm[0] = (LinearLayout) view.findViewById(a.f.left_location_layout);
            this.igm[1] = (LinearLayout) view.findViewById(a.f.right_location_layout);
            this.ign[0] = (TextView) view.findViewById(a.f.left_location_textView);
            this.ign[1] = (TextView) view.findViewById(a.f.right_location_textView);
            this.igj[0].getLayoutParams().width = i;
            this.igj[0].getLayoutParams().height = i;
            this.igj[1].getLayoutParams().width = i;
            this.igj[1].getLayoutParams().height = i;
            this.igj[0].setDefaultBgResource(a.e.sdk_shape_transparent);
            this.igj[1].setDefaultBgResource(a.e.sdk_shape_transparent);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && i > 0) {
                this.igs = "@resize{w:" + i + ",h:" + i + "}";
            }
            this.igi[0].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.naR != null) {
                        if (a.this.naR.nbm != null) {
                            a.this.b(a.this.naR.nbm, 0, a.this.naR.type);
                        } else if (a.this.naR.nbn != null) {
                            a.this.b(a.this.naR.nbn, 0, a.this.naR.type);
                        }
                    }
                }
            });
            this.igi[1].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.c.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.naR != null && a.this.naR.nbn != null) {
                        a.this.b(a.this.naR.nbn, 1, a.this.naR.type);
                    }
                }
            });
            this.gDo = new AlphaAnimation(0.0f, 1.0f);
            this.gDo.setDuration(150L);
        }

        public void a(com.baidu.tieba.recommendlist.data.d dVar, int i, ab abVar) {
            boolean z;
            int i2;
            if (dVar != null) {
                this.naR = dVar;
                this.mPosition = i;
                this.bxN = abVar;
                if (dVar.nbm != null) {
                    a(dVar.nbm, 0, this.naR.type);
                }
                if (dVar.nbn != null) {
                    if (dVar.nbm == null) {
                        i2 = 0;
                        z = false;
                    } else {
                        i2 = 1;
                        z = true;
                    }
                    a(dVar.nbn, i2, this.naR.type);
                } else {
                    z = false;
                }
                if (z) {
                    this.igi[1].setVisibility(0);
                } else {
                    this.igi[1].setVisibility(8);
                }
            }
        }

        private void a(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            final TbImageView tbImageView = this.igj[i];
            tbImageView.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.recommendlist.adapter.c.a.3
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str, boolean z) {
                    Object tag = tbImageView.getTag(tbImageView.getId());
                    if ((tag == null || (tag instanceof String)) && !str.equals(tag)) {
                        tbImageView.setTag(tbImageView.getId(), str);
                        a.this.gDo.cancel();
                        a.this.gDo.reset();
                        tbImageView.startAnimation(a.this.gDo);
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.gDo.cancel();
            tbImageView.stopLoad();
            tbImageView.startLoad(alaRecommendLiveData.cover + this.igs, 10, false);
            this.igl[i].setText(alaRecommendLiveData.getNameShow());
            this.igk[i].setText(String.format(this.mContext.getResources().getString(a.h.recommend_live_audience_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
            if (!TextUtils.isEmpty(alaRecommendLiveData.distance) && !TextUtils.equals(alaRecommendLiveData.distance, "0")) {
                this.ign[i].setText(alaRecommendLiveData.distance);
                this.igm[i].setVisibility(0);
            } else {
                this.igm[i].setVisibility(8);
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
