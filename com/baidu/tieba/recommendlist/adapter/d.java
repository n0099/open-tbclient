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
import com.baidu.tieba.recommendlist.data.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends AbsDelegateAdapter<f, a> {
    private ab bxN;
    private int cardWidth;

    public d(Context context, BdUniqueId bdUniqueId, int i) {
        super(context, bdUniqueId);
        this.cardWidth = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: db */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(a.g.ala_recommend_live_mix_item_layout, viewGroup, false), this.mContext, this.cardWidth);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, f fVar, a aVar) {
        aVar.a(fVar, i, this.bxN);
        return view;
    }

    public void setAlaLiveShowData(ab abVar) {
        this.bxN = abVar;
    }

    /* loaded from: classes11.dex */
    public static class a extends TypeAdapter.ViewHolder {
        private ab bxN;
        private AlphaAnimation gDa;
        private TbImageView[] ifV;
        private TextView[] ifW;
        private TextView[] ifX;
        private String ige;
        private Context mContext;
        private int mPosition;
        private TextView[] naA;
        private TbImageView[] naB;
        private f naC;
        private String naD;
        private LinearLayout[] nau;
        private ViewGroup[] nav;
        private ViewGroup[] naw;
        private LinearLayout[] nax;
        private ImageView[] nay;
        private TextView[] naz;

        private a(View view, Context context, int i) {
            super(view);
            this.ige = "";
            this.naD = "";
            this.mContext = context;
            this.nau = new LinearLayout[2];
            this.nav = new ViewGroup[2];
            this.naw = new ViewGroup[2];
            this.ifV = new TbImageView[2];
            this.ifW = new TextView[2];
            this.ifX = new TextView[2];
            this.nax = new LinearLayout[2];
            this.nay = new ImageView[2];
            this.naz = new TextView[2];
            this.naA = new TextView[2];
            this.naB = new TbImageView[2];
            this.nau[0] = (LinearLayout) view.findViewById(a.f.left_content_layout);
            this.nau[1] = (LinearLayout) view.findViewById(a.f.right_content_layout);
            this.nav[0] = (ViewGroup) view.findViewById(a.f.left_container_cover);
            this.nav[1] = (ViewGroup) view.findViewById(a.f.right_container_cover);
            this.naw[0] = (ViewGroup) view.findViewById(a.f.left_playback_shadow);
            this.naw[1] = (ViewGroup) view.findViewById(a.f.right_playback_shadow);
            this.ifV[0] = (TbImageView) view.findViewById(a.f.left_cover_imageView);
            this.ifV[1] = (TbImageView) view.findViewById(a.f.right_cover_imageView);
            this.ifW[0] = (TextView) view.findViewById(a.f.left_count_textView);
            this.ifW[1] = (TextView) view.findViewById(a.f.right_count_textView);
            this.ifX[0] = (TextView) view.findViewById(a.f.left_name_textView);
            this.ifX[1] = (TextView) view.findViewById(a.f.right_name_textView);
            this.nax[0] = (LinearLayout) view.findViewById(a.f.left_tag_layout);
            this.nax[1] = (LinearLayout) view.findViewById(a.f.right_tag_layout);
            this.nay[0] = (ImageView) view.findViewById(a.f.left_tag_icon_imageView);
            this.nay[1] = (ImageView) view.findViewById(a.f.right_tag_icon_imageView);
            this.naz[0] = (TextView) view.findViewById(a.f.left_tag_des_textView);
            this.naz[1] = (TextView) view.findViewById(a.f.right_tag_des_textView);
            this.naA[0] = (TextView) view.findViewById(a.f.left_des_textView);
            this.naA[1] = (TextView) view.findViewById(a.f.right_des_textView);
            this.naB[0] = (TbImageView) view.findViewById(a.f.left_portrait_imageView);
            this.naB[1] = (TbImageView) view.findViewById(a.f.right_portrait_imageView);
            int dimensionPixelOffset = (context.getResources().getDimensionPixelOffset(a.d.sdk_tbds146) * i) / context.getResources().getDimensionPixelOffset(a.d.sdk_tbds260);
            this.nav[0].getLayoutParams().width = i;
            this.nav[0].getLayoutParams().height = dimensionPixelOffset;
            this.nav[1].getLayoutParams().width = i;
            this.nav[1].getLayoutParams().height = dimensionPixelOffset;
            this.naB[0].setDefaultBgResource(a.e.sdk_shape_transparent);
            this.naB[1].setDefaultBgResource(a.e.sdk_shape_transparent);
            this.ifV[0].setDefaultBgResource(a.e.sdk_shape_transparent);
            this.ifV[1].setDefaultBgResource(a.e.sdk_shape_transparent);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && i > 0) {
                this.ige = "@resize{w:" + i + ",h:" + dimensionPixelOffset + "}";
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(a.d.sdk_ds28);
                this.naD = "@resize{w:" + dimensionPixelOffset2 + ",h:" + dimensionPixelOffset2 + "}";
            }
            this.nau[0].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.naC != null) {
                        if (a.this.naC.naM != null) {
                            a.this.b(a.this.naC.naM, 0);
                        } else if (a.this.naC.naN != null) {
                            a.this.b(a.this.naC.naN, 0);
                        }
                    }
                }
            });
            this.nau[1].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.d.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.naC != null && a.this.naC.naN != null) {
                        a.this.b(a.this.naC.naN, 1);
                    }
                }
            });
            this.gDa = new AlphaAnimation(0.0f, 1.0f);
            this.gDa.setDuration(150L);
        }

        public void a(f fVar, int i, ab abVar) {
            boolean z;
            int i2;
            if (fVar != null) {
                this.naC = fVar;
                this.mPosition = i;
                this.bxN = abVar;
                if (fVar.naM != null) {
                    a(fVar.naM, 0);
                }
                if (fVar.naN != null) {
                    if (fVar.naM == null) {
                        i2 = 0;
                        z = false;
                    } else {
                        i2 = 1;
                        z = true;
                    }
                    a(fVar.naN, i2);
                } else {
                    z = false;
                }
                if (z) {
                    this.nau[1].setVisibility(0);
                } else {
                    this.nau[1].setVisibility(8);
                }
            }
        }

        private void a(AlaRecommendLiveData alaRecommendLiveData, int i) {
            final TbImageView tbImageView = this.ifV[i];
            tbImageView.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.recommendlist.adapter.d.a.3
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
            this.naw[i].setVisibility(8);
            if (alaRecommendLiveData.mixType == 0) {
                if (alaRecommendLiveData.live_status == 3) {
                    this.nax[i].setVisibility(8);
                    this.ifW[i].setText(alaRecommendLiveData.duration);
                    this.naw[i].setVisibility(0);
                } else {
                    this.ifW[i].setText(String.format(this.mContext.getResources().getString(a.h.recommend_live_watch_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
                    com.baidu.tieba.recommendlist.data.c cVar = alaRecommendLiveData.interactTag;
                    if (cVar != null && !TextUtils.isEmpty(cVar.type)) {
                        int a2 = d.a(cVar);
                        if (a2 == 0) {
                            this.nax[i].setVisibility(8);
                        } else {
                            this.nay[i].setImageResource(a2);
                            this.naz[i].setText(cVar.msg);
                            this.nax[i].setVisibility(0);
                        }
                    } else {
                        this.nax[i].setVisibility(8);
                    }
                }
            } else {
                this.ifW[i].setText(String.format(this.mContext.getResources().getString(a.h.recommend_live_watch_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
                if (!TextUtils.isEmpty(alaRecommendLiveData.distance) && !TextUtils.equals(alaRecommendLiveData.distance, "0")) {
                    this.nay[i].setImageResource(a.e.icon_recommend_location);
                    this.naz[i].setText(alaRecommendLiveData.distance);
                    this.nax[i].setVisibility(0);
                } else {
                    this.nax[i].setVisibility(8);
                }
            }
            this.naA[i].setText(alaRecommendLiveData.description);
            this.naB[i].startLoad(alaRecommendLiveData.getLivePortrait() + this.naD, 12, false);
            a(UbcStatisticLiveKey.KEY_ID_1392, "show", alaRecommendLiveData, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(AlaRecommendLiveData alaRecommendLiveData, int i) {
            if (alaRecommendLiveData != null) {
                com.baidu.live.liveroom.a.Mr().a(com.baidu.live.liveroom.a.Mr().Ms().hk(String.valueOf(alaRecommendLiveData.live_id)));
                if (TextUtils.isEmpty(alaRecommendLiveData.scheme) || alaRecommendLiveData.mixType == 1) {
                    BdLog.e("openInner: scheme: " + alaRecommendLiveData.scheme);
                    b(alaRecommendLiveData);
                } else {
                    BdLog.e("openByScheme: " + alaRecommendLiveData.scheme);
                    if (!RV(alaRecommendLiveData.scheme)) {
                        BdLog.e("openInner: scheme: " + alaRecommendLiveData.scheme);
                        b(alaRecommendLiveData);
                    }
                }
                a(UbcStatisticLiveKey.KEY_ID_1393, UbcStatConstant.ContentType.COVER_CLICK, alaRecommendLiveData, i);
            }
        }

        private boolean RV(String str) {
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
