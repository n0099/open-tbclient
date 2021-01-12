package com.baidu.tieba.recommendlist.adapter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.baidu.tieba.recommendlist.data.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d extends AbsDelegateAdapter<f, a> {
    private x buq;
    private int cardWidth;

    public d(Context context, BdUniqueId bdUniqueId, int i) {
        super(context, bdUniqueId);
        this.cardWidth = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: da */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(a.g.ala_recommend_live_mix_item_layout, viewGroup, false), this.mContext, this.cardWidth);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        aVar.a(fVar, i, this.buq);
        return view;
    }

    public void setAlaLiveShowData(x xVar) {
        this.buq = xVar;
    }

    /* loaded from: classes10.dex */
    public static class a extends TypeAdapter.ViewHolder {
        private x buq;
        private AlphaAnimation gAq;
        private String ibG;
        private TbImageView[] ibx;
        private TextView[] iby;
        private TextView[] ibz;
        private Context mContext;
        private int mPosition;
        private LinearLayout[] mQX;
        private ViewGroup[] mQY;
        private ViewGroup[] mQZ;
        private LinearLayout[] mRa;
        private ImageView[] mRb;
        private TextView[] mRc;
        private TextView[] mRd;
        private TbImageView[] mRe;
        private f mRf;
        private String mRg;

        private a(View view, Context context, int i) {
            super(view);
            this.ibG = "";
            this.mRg = "";
            this.mContext = context;
            this.mQX = new LinearLayout[2];
            this.mQY = new ViewGroup[2];
            this.mQZ = new ViewGroup[2];
            this.ibx = new TbImageView[2];
            this.iby = new TextView[2];
            this.ibz = new TextView[2];
            this.mRa = new LinearLayout[2];
            this.mRb = new ImageView[2];
            this.mRc = new TextView[2];
            this.mRd = new TextView[2];
            this.mRe = new TbImageView[2];
            this.mQX[0] = (LinearLayout) view.findViewById(a.f.left_content_layout);
            this.mQX[1] = (LinearLayout) view.findViewById(a.f.right_content_layout);
            this.mQY[0] = (ViewGroup) view.findViewById(a.f.left_container_cover);
            this.mQY[1] = (ViewGroup) view.findViewById(a.f.right_container_cover);
            this.mQZ[0] = (ViewGroup) view.findViewById(a.f.left_playback_shadow);
            this.mQZ[1] = (ViewGroup) view.findViewById(a.f.right_playback_shadow);
            this.ibx[0] = (TbImageView) view.findViewById(a.f.left_cover_imageView);
            this.ibx[1] = (TbImageView) view.findViewById(a.f.right_cover_imageView);
            this.iby[0] = (TextView) view.findViewById(a.f.left_count_textView);
            this.iby[1] = (TextView) view.findViewById(a.f.right_count_textView);
            this.ibz[0] = (TextView) view.findViewById(a.f.left_name_textView);
            this.ibz[1] = (TextView) view.findViewById(a.f.right_name_textView);
            this.mRa[0] = (LinearLayout) view.findViewById(a.f.left_tag_layout);
            this.mRa[1] = (LinearLayout) view.findViewById(a.f.right_tag_layout);
            this.mRb[0] = (ImageView) view.findViewById(a.f.left_tag_icon_imageView);
            this.mRb[1] = (ImageView) view.findViewById(a.f.right_tag_icon_imageView);
            this.mRc[0] = (TextView) view.findViewById(a.f.left_tag_des_textView);
            this.mRc[1] = (TextView) view.findViewById(a.f.right_tag_des_textView);
            this.mRd[0] = (TextView) view.findViewById(a.f.left_des_textView);
            this.mRd[1] = (TextView) view.findViewById(a.f.right_des_textView);
            this.mRe[0] = (TbImageView) view.findViewById(a.f.left_portrait_imageView);
            this.mRe[1] = (TbImageView) view.findViewById(a.f.right_portrait_imageView);
            int dimensionPixelOffset = (context.getResources().getDimensionPixelOffset(a.d.sdk_tbds146) * i) / context.getResources().getDimensionPixelOffset(a.d.sdk_tbds260);
            this.mQY[0].getLayoutParams().width = i;
            this.mQY[0].getLayoutParams().height = dimensionPixelOffset;
            this.mQY[1].getLayoutParams().width = i;
            this.mQY[1].getLayoutParams().height = dimensionPixelOffset;
            this.mRe[0].setDefaultBgResource(a.e.sdk_shape_transparent);
            this.mRe[1].setDefaultBgResource(a.e.sdk_shape_transparent);
            this.ibx[0].setDefaultBgResource(a.e.sdk_shape_transparent);
            this.ibx[1].setDefaultBgResource(a.e.sdk_shape_transparent);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && i > 0) {
                this.ibG = "@resize{w:" + i + ",h:" + dimensionPixelOffset + "}";
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(a.d.sdk_ds28);
                this.mRg = "@resize{w:" + dimensionPixelOffset2 + ",h:" + dimensionPixelOffset2 + "}";
            }
            this.mQX[0].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.mRf != null) {
                        if (a.this.mRf.mRp != null) {
                            a.this.b(a.this.mRf.mRp, 0);
                        } else if (a.this.mRf.mRq != null) {
                            a.this.b(a.this.mRf.mRq, 0);
                        }
                    }
                }
            });
            this.mQX[1].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.d.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.mRf != null && a.this.mRf.mRq != null) {
                        a.this.b(a.this.mRf.mRq, 1);
                    }
                }
            });
            this.gAq = new AlphaAnimation(0.0f, 1.0f);
            this.gAq.setDuration(150L);
        }

        public void a(f fVar, int i, x xVar) {
            boolean z;
            int i2;
            if (fVar != null) {
                this.mRf = fVar;
                this.mPosition = i;
                this.buq = xVar;
                if (fVar.mRp != null) {
                    a(fVar.mRp, 0);
                }
                if (fVar.mRq != null) {
                    if (fVar.mRp == null) {
                        i2 = 0;
                        z = false;
                    } else {
                        i2 = 1;
                        z = true;
                    }
                    a(fVar.mRq, i2);
                } else {
                    z = false;
                }
                if (z) {
                    this.mQX[1].setVisibility(0);
                } else {
                    this.mQX[1].setVisibility(8);
                }
            }
        }

        private void a(AlaRecommendLiveData alaRecommendLiveData, int i) {
            final TbImageView tbImageView = this.ibx[i];
            tbImageView.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.recommendlist.adapter.d.a.3
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
            this.mQZ[i].setVisibility(8);
            if (alaRecommendLiveData.mixType == 0) {
                if (alaRecommendLiveData.live_status == 3) {
                    this.mRa[i].setVisibility(8);
                    this.iby[i].setText(alaRecommendLiveData.duration);
                    this.mQZ[i].setVisibility(0);
                } else {
                    this.iby[i].setText(String.format(this.mContext.getResources().getString(a.h.recommend_live_watch_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
                    com.baidu.tieba.recommendlist.data.c cVar = alaRecommendLiveData.interactTag;
                    if (cVar != null && !TextUtils.isEmpty(cVar.type)) {
                        int a2 = d.a(cVar);
                        if (a2 == 0) {
                            this.mRa[i].setVisibility(8);
                        } else {
                            this.mRb[i].setImageResource(a2);
                            this.mRc[i].setText(cVar.msg);
                            this.mRa[i].setVisibility(0);
                        }
                    } else {
                        this.mRa[i].setVisibility(8);
                    }
                }
            } else {
                this.iby[i].setText(String.format(this.mContext.getResources().getString(a.h.recommend_live_watch_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
                if (!TextUtils.isEmpty(alaRecommendLiveData.distance) && !TextUtils.equals(alaRecommendLiveData.distance, "0")) {
                    this.mRb[i].setImageResource(a.e.icon_recommend_location);
                    this.mRc[i].setText(alaRecommendLiveData.distance);
                    this.mRa[i].setVisibility(0);
                } else {
                    this.mRa[i].setVisibility(8);
                }
            }
            this.mRd[i].setText(alaRecommendLiveData.description);
            this.mRe[i].startLoad(alaRecommendLiveData.getLivePortrait() + this.mRg, 12, false);
            a(UbcStatisticLiveKey.KEY_ID_1392, "show", alaRecommendLiveData, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(AlaRecommendLiveData alaRecommendLiveData, int i) {
            if (alaRecommendLiveData != null) {
                com.baidu.live.liveroom.a.KT().a(com.baidu.live.liveroom.a.KT().KU().gL(String.valueOf(alaRecommendLiveData.live_id)));
                if (TextUtils.isEmpty(alaRecommendLiveData.scheme) || alaRecommendLiveData.mixType == 1) {
                    BdLog.e("openInner: scheme: " + alaRecommendLiveData.scheme);
                    b(alaRecommendLiveData);
                } else {
                    BdLog.e("openByScheme: " + alaRecommendLiveData.scheme);
                    if (!QZ(alaRecommendLiveData.scheme)) {
                        BdLog.e("openInner: scheme: " + alaRecommendLiveData.scheme);
                        b(alaRecommendLiveData);
                    }
                }
                a(UbcStatisticLiveKey.KEY_ID_1393, UbcStatConstant.ContentType.COVER_CLICK, alaRecommendLiveData, i);
            }
        }

        private boolean QZ(String str) {
            return openScheme(TbadkCoreApplication.getInst(), str);
        }

        private void b(AlaRecommendLiveData alaRecommendLiveData) {
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
            }
        }

        private boolean openScheme(Context context, String str) {
            if (context == null || TextUtils.isEmpty(str)) {
                return false;
            }
            Intent intent = new Intent();
            intent.setData(Uri.parse(str));
            intent.setFlags(268435456);
            try {
                context.startActivity(intent);
                return true;
            } catch (ActivityNotFoundException e) {
                return false;
            } catch (Exception e2) {
                return false;
            }
        }

        private void a(String str, String str2, AlaRecommendLiveData alaRecommendLiveData, int i) {
            if (alaRecommendLiveData != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("live_id", alaRecommendLiveData.live_id).put("vid", alaRecommendLiveData.feed_id).put("model", "hotlive").put("pos", ((this.mPosition - 1) * 2) + i + 1).put("nearby", !TextUtils.isEmpty(alaRecommendLiveData.distance) ? "1" : "0");
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

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(com.baidu.tieba.recommendlist.data.c cVar) {
        String str = cVar.type;
        char c = 65535;
        switch (str.hashCode()) {
            case -896071454:
                if (str.equals("speech")) {
                    c = 0;
                    break;
                }
                break;
            case 98539350:
                if (str.equals("goods")) {
                    c = 1;
                    break;
                }
                break;
            case 354670409:
                if (str.equals("lottery")) {
                    c = 3;
                    break;
                }
                break;
            case 1093691152:
                if (str.equals("hongbao")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return a.e.icon_recommend_speech;
            case 1:
                return a.e.icon_recommend_goods;
            case 2:
                return a.e.icon_recommend_red_packet;
            case 3:
                return a.e.icon_recommend_lottery;
            default:
                return 0;
        }
    }
}
