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
/* loaded from: classes11.dex */
public class d extends AbsDelegateAdapter<f, a> {
    private x bzc;
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
        aVar.a(fVar, i, this.bzc);
        return view;
    }

    public void setAlaLiveShowData(x xVar) {
        this.bzc = xVar;
    }

    /* loaded from: classes11.dex */
    public static class a extends TypeAdapter.ViewHolder {
        private x bzc;
        private AlphaAnimation gEX;
        private TbImageView[] igi;
        private TextView[] igj;
        private TextView[] igk;
        private String igr;
        private Context mContext;
        private int mPosition;
        private LinearLayout[] mVJ;
        private ViewGroup[] mVK;
        private ViewGroup[] mVL;
        private LinearLayout[] mVM;
        private ImageView[] mVN;
        private TextView[] mVO;
        private TextView[] mVP;
        private TbImageView[] mVQ;
        private f mVR;
        private String mVS;

        private a(View view, Context context, int i) {
            super(view);
            this.igr = "";
            this.mVS = "";
            this.mContext = context;
            this.mVJ = new LinearLayout[2];
            this.mVK = new ViewGroup[2];
            this.mVL = new ViewGroup[2];
            this.igi = new TbImageView[2];
            this.igj = new TextView[2];
            this.igk = new TextView[2];
            this.mVM = new LinearLayout[2];
            this.mVN = new ImageView[2];
            this.mVO = new TextView[2];
            this.mVP = new TextView[2];
            this.mVQ = new TbImageView[2];
            this.mVJ[0] = (LinearLayout) view.findViewById(a.f.left_content_layout);
            this.mVJ[1] = (LinearLayout) view.findViewById(a.f.right_content_layout);
            this.mVK[0] = (ViewGroup) view.findViewById(a.f.left_container_cover);
            this.mVK[1] = (ViewGroup) view.findViewById(a.f.right_container_cover);
            this.mVL[0] = (ViewGroup) view.findViewById(a.f.left_playback_shadow);
            this.mVL[1] = (ViewGroup) view.findViewById(a.f.right_playback_shadow);
            this.igi[0] = (TbImageView) view.findViewById(a.f.left_cover_imageView);
            this.igi[1] = (TbImageView) view.findViewById(a.f.right_cover_imageView);
            this.igj[0] = (TextView) view.findViewById(a.f.left_count_textView);
            this.igj[1] = (TextView) view.findViewById(a.f.right_count_textView);
            this.igk[0] = (TextView) view.findViewById(a.f.left_name_textView);
            this.igk[1] = (TextView) view.findViewById(a.f.right_name_textView);
            this.mVM[0] = (LinearLayout) view.findViewById(a.f.left_tag_layout);
            this.mVM[1] = (LinearLayout) view.findViewById(a.f.right_tag_layout);
            this.mVN[0] = (ImageView) view.findViewById(a.f.left_tag_icon_imageView);
            this.mVN[1] = (ImageView) view.findViewById(a.f.right_tag_icon_imageView);
            this.mVO[0] = (TextView) view.findViewById(a.f.left_tag_des_textView);
            this.mVO[1] = (TextView) view.findViewById(a.f.right_tag_des_textView);
            this.mVP[0] = (TextView) view.findViewById(a.f.left_des_textView);
            this.mVP[1] = (TextView) view.findViewById(a.f.right_des_textView);
            this.mVQ[0] = (TbImageView) view.findViewById(a.f.left_portrait_imageView);
            this.mVQ[1] = (TbImageView) view.findViewById(a.f.right_portrait_imageView);
            int dimensionPixelOffset = (context.getResources().getDimensionPixelOffset(a.d.sdk_tbds146) * i) / context.getResources().getDimensionPixelOffset(a.d.sdk_tbds260);
            this.mVK[0].getLayoutParams().width = i;
            this.mVK[0].getLayoutParams().height = dimensionPixelOffset;
            this.mVK[1].getLayoutParams().width = i;
            this.mVK[1].getLayoutParams().height = dimensionPixelOffset;
            this.mVQ[0].setDefaultBgResource(a.e.sdk_shape_transparent);
            this.mVQ[1].setDefaultBgResource(a.e.sdk_shape_transparent);
            this.igi[0].setDefaultBgResource(a.e.sdk_shape_transparent);
            this.igi[1].setDefaultBgResource(a.e.sdk_shape_transparent);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && i > 0) {
                this.igr = "@resize{w:" + i + ",h:" + dimensionPixelOffset + "}";
            }
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(a.d.sdk_ds28);
                this.mVS = "@resize{w:" + dimensionPixelOffset2 + ",h:" + dimensionPixelOffset2 + "}";
            }
            this.mVJ[0].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.d.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.mVR != null) {
                        if (a.this.mVR.mWb != null) {
                            a.this.b(a.this.mVR.mWb, 0);
                        } else if (a.this.mVR.mWc != null) {
                            a.this.b(a.this.mVR.mWc, 0);
                        }
                    }
                }
            });
            this.mVJ[1].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.d.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.mVR != null && a.this.mVR.mWc != null) {
                        a.this.b(a.this.mVR.mWc, 1);
                    }
                }
            });
            this.gEX = new AlphaAnimation(0.0f, 1.0f);
            this.gEX.setDuration(150L);
        }

        public void a(f fVar, int i, x xVar) {
            boolean z;
            int i2;
            if (fVar != null) {
                this.mVR = fVar;
                this.mPosition = i;
                this.bzc = xVar;
                if (fVar.mWb != null) {
                    a(fVar.mWb, 0);
                }
                if (fVar.mWc != null) {
                    if (fVar.mWb == null) {
                        i2 = 0;
                        z = false;
                    } else {
                        i2 = 1;
                        z = true;
                    }
                    a(fVar.mWc, i2);
                } else {
                    z = false;
                }
                if (z) {
                    this.mVJ[1].setVisibility(0);
                } else {
                    this.mVJ[1].setVisibility(8);
                }
            }
        }

        private void a(AlaRecommendLiveData alaRecommendLiveData, int i) {
            final TbImageView tbImageView = this.igi[i];
            tbImageView.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.recommendlist.adapter.d.a.3
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
            this.mVL[i].setVisibility(8);
            if (alaRecommendLiveData.mixType == 0) {
                if (alaRecommendLiveData.live_status == 3) {
                    this.mVM[i].setVisibility(8);
                    this.igj[i].setText(alaRecommendLiveData.duration);
                    this.mVL[i].setVisibility(0);
                } else {
                    this.igj[i].setText(String.format(this.mContext.getResources().getString(a.h.recommend_live_watch_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
                    com.baidu.tieba.recommendlist.data.c cVar = alaRecommendLiveData.interactTag;
                    if (cVar != null && !TextUtils.isEmpty(cVar.type)) {
                        int a2 = d.a(cVar);
                        if (a2 == 0) {
                            this.mVM[i].setVisibility(8);
                        } else {
                            this.mVN[i].setImageResource(a2);
                            this.mVO[i].setText(cVar.msg);
                            this.mVM[i].setVisibility(0);
                        }
                    } else {
                        this.mVM[i].setVisibility(8);
                    }
                }
            } else {
                this.igj[i].setText(String.format(this.mContext.getResources().getString(a.h.recommend_live_watch_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
                if (!TextUtils.isEmpty(alaRecommendLiveData.distance) && !TextUtils.equals(alaRecommendLiveData.distance, "0")) {
                    this.mVN[i].setImageResource(a.e.icon_recommend_location);
                    this.mVO[i].setText(alaRecommendLiveData.distance);
                    this.mVM[i].setVisibility(0);
                } else {
                    this.mVM[i].setVisibility(8);
                }
            }
            this.mVP[i].setText(alaRecommendLiveData.description);
            this.mVQ[i].startLoad(alaRecommendLiveData.getLivePortrait() + this.mVS, 12, false);
            a(UbcStatisticLiveKey.KEY_ID_1392, "show", alaRecommendLiveData, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(AlaRecommendLiveData alaRecommendLiveData, int i) {
            if (alaRecommendLiveData != null) {
                com.baidu.live.liveroom.a.OO().a(com.baidu.live.liveroom.a.OO().OP().hW(String.valueOf(alaRecommendLiveData.live_id)));
                if (TextUtils.isEmpty(alaRecommendLiveData.scheme) || alaRecommendLiveData.mixType == 1) {
                    BdLog.e("openInner: scheme: " + alaRecommendLiveData.scheme);
                    b(alaRecommendLiveData);
                } else {
                    BdLog.e("openByScheme: " + alaRecommendLiveData.scheme);
                    if (!Si(alaRecommendLiveData.scheme)) {
                        BdLog.e("openInner: scheme: " + alaRecommendLiveData.scheme);
                        b(alaRecommendLiveData);
                    }
                }
                a(UbcStatisticLiveKey.KEY_ID_1393, UbcStatConstant.ContentType.COVER_CLICK, alaRecommendLiveData, i);
            }
        }

        private boolean Si(String str) {
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
