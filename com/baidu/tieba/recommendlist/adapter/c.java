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
    private w bpz;
    private int cardWidth;

    public c(Context context, BdUniqueId bdUniqueId, int i) {
        super(context, bdUniqueId);
        this.cardWidth = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: cM */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(a.h.ala_recommend_live_item_layout, viewGroup, false), this.mContext, this.cardWidth);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.recommendlist.data.c cVar, a aVar) {
        aVar.a(cVar, i, this.bpz);
        return view;
    }

    public void setAlaLiveShowData(w wVar) {
        this.bpz = wVar;
    }

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        private w bpz;
        private AlphaAnimation ggs;
        private Context mContext;
        private int mPosition;
        private String mvI;
        private RelativeLayout[] mvN;
        private TbImageView[] mvO;
        private TextView[] mvP;
        private TextView[] mvQ;
        private LinearLayout[] mvR;
        private TextView[] mvS;
        private com.baidu.tieba.recommendlist.data.c mvT;

        private a(View view, Context context, int i) {
            super(view);
            this.mvI = "";
            this.mContext = context;
            this.mvN = new RelativeLayout[2];
            this.mvO = new TbImageView[2];
            this.mvP = new TextView[2];
            this.mvQ = new TextView[2];
            this.mvR = new LinearLayout[2];
            this.mvS = new TextView[2];
            this.mvN[0] = (RelativeLayout) view.findViewById(a.g.left_content_layout);
            this.mvN[1] = (RelativeLayout) view.findViewById(a.g.right_content_layout);
            this.mvO[0] = (TbImageView) view.findViewById(a.g.left_cover_imageView);
            this.mvO[1] = (TbImageView) view.findViewById(a.g.right_cover_imageView);
            this.mvP[0] = (TextView) view.findViewById(a.g.left_count_textView);
            this.mvP[1] = (TextView) view.findViewById(a.g.right_count_textView);
            this.mvQ[0] = (TextView) view.findViewById(a.g.left_name_textView);
            this.mvQ[1] = (TextView) view.findViewById(a.g.right_name_textView);
            this.mvR[0] = (LinearLayout) view.findViewById(a.g.left_location_layout);
            this.mvR[1] = (LinearLayout) view.findViewById(a.g.right_location_layout);
            this.mvS[0] = (TextView) view.findViewById(a.g.left_location_textView);
            this.mvS[1] = (TextView) view.findViewById(a.g.right_location_textView);
            this.mvO[0].getLayoutParams().width = i;
            this.mvO[0].getLayoutParams().height = i;
            this.mvO[1].getLayoutParams().width = i;
            this.mvO[1].getLayoutParams().height = i;
            this.mvO[0].setDefaultBgResource(a.f.sdk_shape_transparent);
            this.mvO[1].setDefaultBgResource(a.f.sdk_shape_transparent);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && i > 0) {
                this.mvI = "@resize{w:" + i + ",h:" + i + "}";
            }
            this.mvN[0].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.c.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.mvT != null) {
                        if (a.this.mvT.mwd != null) {
                            a.this.b(a.this.mvT.mwd, 0, a.this.mvT.type);
                        } else if (a.this.mvT.mwe != null) {
                            a.this.b(a.this.mvT.mwe, 0, a.this.mvT.type);
                        }
                    }
                }
            });
            this.mvN[1].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.c.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.mvT != null && a.this.mvT.mwe != null) {
                        a.this.b(a.this.mvT.mwe, 1, a.this.mvT.type);
                    }
                }
            });
            this.ggs = new AlphaAnimation(0.0f, 1.0f);
            this.ggs.setDuration(150L);
        }

        public void a(com.baidu.tieba.recommendlist.data.c cVar, int i, w wVar) {
            boolean z;
            int i2;
            if (cVar != null) {
                this.mvT = cVar;
                this.mPosition = i;
                this.bpz = wVar;
                if (cVar.mwd != null) {
                    a(cVar.mwd, 0, this.mvT.type);
                }
                if (cVar.mwe != null) {
                    if (cVar.mwd == null) {
                        i2 = 0;
                        z = false;
                    } else {
                        i2 = 1;
                        z = true;
                    }
                    a(cVar.mwe, i2, this.mvT.type);
                } else {
                    z = false;
                }
                if (z) {
                    this.mvN[1].setVisibility(0);
                } else {
                    this.mvN[1].setVisibility(8);
                }
            }
        }

        private void a(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            final TbImageView tbImageView = this.mvO[i];
            tbImageView.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.recommendlist.adapter.c.a.3
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str, boolean z) {
                    Object tag = tbImageView.getTag(tbImageView.getId());
                    if ((tag == null || (tag instanceof String)) && !str.equals(tag)) {
                        tbImageView.setTag(tbImageView.getId(), str);
                        a.this.ggs.cancel();
                        a.this.ggs.reset();
                        tbImageView.startAnimation(a.this.ggs);
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.ggs.cancel();
            tbImageView.stopLoad();
            tbImageView.startLoad(alaRecommendLiveData.cover + this.mvI, 10, false);
            this.mvQ[i].setText(alaRecommendLiveData.getNameShow());
            this.mvP[i].setText(String.format(this.mContext.getResources().getString(a.i.recommend_live_audience_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
            if (!TextUtils.isEmpty(alaRecommendLiveData.distance) && !TextUtils.equals(alaRecommendLiveData.distance, "0")) {
                this.mvS[i].setText(alaRecommendLiveData.distance);
                this.mvR[i].setVisibility(0);
            } else {
                this.mvR[i].setVisibility(8);
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
                if (this.bpz != null) {
                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                    if (this.bpz.aIe != null) {
                        alaLastLiveroomInfo.setLastAnchorPortrait(this.bpz.aIe.portrait);
                        alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.bpz.aIe.userId));
                        alaLastLiveroomInfo.setLastAnchorUname(this.bpz.aIe.nickName);
                    }
                    if (this.bpz.mLiveInfo != null) {
                        alaLastLiveroomInfo.setLastLiveId(this.bpz.mLiveInfo.live_id);
                        alaLastLiveroomInfo.setLastRoomId(this.bpz.mLiveInfo.room_id);
                        alaLastLiveroomInfo.setLastCover(this.bpz.mLiveInfo.cover);
                        if (this.bpz.mLiveInfo.session_info != null) {
                            if (!TextUtils.isEmpty(this.bpz.mLiveInfo.session_info.flvUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bpz.mLiveInfo.session_info.flvUrl);
                            } else if (!TextUtils.isEmpty(this.bpz.mLiveInfo.session_info.hlsUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bpz.mLiveInfo.session_info.hlsUrl);
                            } else if (!TextUtils.isEmpty(this.bpz.mLiveInfo.session_info.rtmpUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bpz.mLiveInfo.session_info.rtmpUrl);
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
