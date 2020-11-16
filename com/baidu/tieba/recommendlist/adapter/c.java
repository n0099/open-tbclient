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
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.data.w;
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
    private w bph;
    private int cardWidth;

    public c(Context context, BdUniqueId bdUniqueId, int i) {
        super(context, bdUniqueId);
        this.cardWidth = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: cK */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(a.g.ala_recommend_live_item_layout, viewGroup, false), this.mContext, this.cardWidth);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.recommendlist.data.c cVar, a aVar) {
        aVar.a(cVar, i, this.bph);
        return view;
    }

    public void setAlaLiveShowData(w wVar) {
        this.bph = wVar;
    }

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        private w bph;
        private AlphaAnimation glN;
        private String mCc;
        private RelativeLayout[] mCh;
        private TbImageView[] mCi;
        private TextView[] mCj;
        private TextView[] mCk;
        private LinearLayout[] mCl;
        private TextView[] mCm;
        private com.baidu.tieba.recommendlist.data.c mCn;
        private Context mContext;
        private int mPosition;

        private a(View view, Context context, int i) {
            super(view);
            this.mCc = "";
            this.mContext = context;
            this.mCh = new RelativeLayout[2];
            this.mCi = new TbImageView[2];
            this.mCj = new TextView[2];
            this.mCk = new TextView[2];
            this.mCl = new LinearLayout[2];
            this.mCm = new TextView[2];
            this.mCh[0] = (RelativeLayout) view.findViewById(a.f.left_content_layout);
            this.mCh[1] = (RelativeLayout) view.findViewById(a.f.right_content_layout);
            this.mCi[0] = (TbImageView) view.findViewById(a.f.left_cover_imageView);
            this.mCi[1] = (TbImageView) view.findViewById(a.f.right_cover_imageView);
            this.mCj[0] = (TextView) view.findViewById(a.f.left_count_textView);
            this.mCj[1] = (TextView) view.findViewById(a.f.right_count_textView);
            this.mCk[0] = (TextView) view.findViewById(a.f.left_name_textView);
            this.mCk[1] = (TextView) view.findViewById(a.f.right_name_textView);
            this.mCl[0] = (LinearLayout) view.findViewById(a.f.left_location_layout);
            this.mCl[1] = (LinearLayout) view.findViewById(a.f.right_location_layout);
            this.mCm[0] = (TextView) view.findViewById(a.f.left_location_textView);
            this.mCm[1] = (TextView) view.findViewById(a.f.right_location_textView);
            this.mCi[0].getLayoutParams().width = i;
            this.mCi[0].getLayoutParams().height = i;
            this.mCi[1].getLayoutParams().width = i;
            this.mCi[1].getLayoutParams().height = i;
            this.mCi[0].setDefaultBgResource(a.e.sdk_shape_transparent);
            this.mCi[1].setDefaultBgResource(a.e.sdk_shape_transparent);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && i > 0) {
                this.mCc = "@resize{w:" + i + ",h:" + i + "}";
            }
            this.mCh[0].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.mCn != null) {
                        if (a.this.mCn.mCy != null) {
                            a.this.b(a.this.mCn.mCy, 0, a.this.mCn.type);
                        } else if (a.this.mCn.mCz != null) {
                            a.this.b(a.this.mCn.mCz, 0, a.this.mCn.type);
                        }
                    }
                }
            });
            this.mCh[1].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.c.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.mCn != null && a.this.mCn.mCz != null) {
                        a.this.b(a.this.mCn.mCz, 1, a.this.mCn.type);
                    }
                }
            });
            this.glN = new AlphaAnimation(0.0f, 1.0f);
            this.glN.setDuration(150L);
        }

        public void a(com.baidu.tieba.recommendlist.data.c cVar, int i, w wVar) {
            boolean z;
            int i2;
            if (cVar != null) {
                this.mCn = cVar;
                this.mPosition = i;
                this.bph = wVar;
                if (cVar.mCy != null) {
                    a(cVar.mCy, 0, this.mCn.type);
                }
                if (cVar.mCz != null) {
                    if (cVar.mCy == null) {
                        i2 = 0;
                        z = false;
                    } else {
                        i2 = 1;
                        z = true;
                    }
                    a(cVar.mCz, i2, this.mCn.type);
                } else {
                    z = false;
                }
                if (z) {
                    this.mCh[1].setVisibility(0);
                } else {
                    this.mCh[1].setVisibility(8);
                }
            }
        }

        private void a(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            final TbImageView tbImageView = this.mCi[i];
            tbImageView.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.recommendlist.adapter.c.a.3
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str, boolean z) {
                    Object tag = tbImageView.getTag(tbImageView.getId());
                    if ((tag == null || (tag instanceof String)) && !str.equals(tag)) {
                        tbImageView.setTag(tbImageView.getId(), str);
                        a.this.glN.cancel();
                        a.this.glN.reset();
                        tbImageView.startAnimation(a.this.glN);
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.glN.cancel();
            tbImageView.stopLoad();
            tbImageView.startLoad(alaRecommendLiveData.cover + this.mCc, 10, false);
            this.mCk[i].setText(alaRecommendLiveData.getNameShow());
            this.mCj[i].setText(String.format(this.mContext.getResources().getString(a.h.recommend_live_audience_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
            if (!TextUtils.isEmpty(alaRecommendLiveData.distance) && !TextUtils.equals(alaRecommendLiveData.distance, "0")) {
                this.mCm[i].setText(alaRecommendLiveData.distance);
                this.mCl[i].setVisibility(0);
            } else {
                this.mCl[i].setVisibility(8);
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
                if (this.bph != null) {
                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                    if (this.bph.aHk != null) {
                        alaLastLiveroomInfo.setLastAnchorPortrait(this.bph.aHk.portrait);
                        alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.bph.aHk.userId));
                        alaLastLiveroomInfo.setLastAnchorUname(this.bph.aHk.nickName);
                    }
                    if (this.bph.mLiveInfo != null) {
                        alaLastLiveroomInfo.setLastLiveId(this.bph.mLiveInfo.live_id);
                        alaLastLiveroomInfo.setLastRoomId(this.bph.mLiveInfo.room_id);
                        alaLastLiveroomInfo.setLastCover(this.bph.mLiveInfo.cover);
                        if (this.bph.mLiveInfo.session_info != null) {
                            if (!TextUtils.isEmpty(this.bph.mLiveInfo.session_info.flvUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bph.mLiveInfo.session_info.flvUrl);
                            } else if (!TextUtils.isEmpty(this.bph.mLiveInfo.session_info.hlsUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bph.mLiveInfo.session_info.hlsUrl);
                            } else if (!TextUtils.isEmpty(this.bph.mLiveInfo.session_info.rtmpUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bph.mLiveInfo.session_info.rtmpUrl);
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
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(str, str2, UbcStatConstant.Page.LIVE_RECOMMEND, "").setContentExt(jSONObject));
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
        }
    }
}
