package com.baidu.tieba.recommendlist.adapter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.recommendlist.data.AlaRecommendLiveData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends AbsDelegateAdapter<com.baidu.tieba.recommendlist.data.a, C0840a> {
    private x bzc;
    private int type;

    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.type = 102;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: cX */
    public C0840a onCreateViewHolder(ViewGroup viewGroup) {
        return this.type == 102 ? new C0840a(LayoutInflater.from(this.mContext).inflate(a.g.ala_follow_live_small_item_layout, viewGroup, false), this.mContext) : new C0840a(LayoutInflater.from(this.mContext).inflate(a.g.ala_follow_live_big_item_layout, viewGroup, false), this.mContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.recommendlist.data.a aVar, C0840a c0840a) {
        c0840a.a(aVar.mVX, i, this.type, this.bzc);
        return view;
    }

    public void setAlaLiveShowData(x xVar) {
        this.bzc = xVar;
    }

    /* renamed from: com.baidu.tieba.recommendlist.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0840a extends TypeAdapter.ViewHolder {
        private x bzc;
        private String igr;
        private Context mContext;
        private int mPosition;
        private TextView mVA;
        private AlaRecommendLiveData mVB;
        private HeadImageView mVx;
        private TextView mVy;
        private TBLottieAnimationView mVz;
        private View rootView;

        private C0840a(View view, Context context) {
            super(view);
            this.igr = "";
            this.mContext = context;
            this.rootView = view;
            this.mVx = (HeadImageView) view.findViewById(a.f.ala_headImage);
            this.mVy = (TextView) view.findViewById(a.f.ala_liveroom_name);
            this.mVz = (TBLottieAnimationView) view.findViewById(a.f.ala_headImage_lottieView);
            this.mVA = (TextView) view.findViewById(a.f.ala_audience_count);
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.igr = "@resize{w:" + this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds100) + ",h:" + this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds100) + "}";
            } else {
                this.igr = "";
            }
            this.mVz.setImageAssetsFolder("images/");
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.mVz.setAnimation("headNightJson.json");
            } else {
                this.mVz.setAnimation("headDayJson.json");
            }
        }

        public void a(final AlaRecommendLiveData alaRecommendLiveData, int i, int i2, x xVar) {
            if (alaRecommendLiveData != null) {
                this.bzc = xVar;
                this.mVB = alaRecommendLiveData;
                this.mPosition = i;
                this.mVx.setIsRound(true);
                this.mVx.setDrawBorder(false);
                this.mVx.setDefaultBgResource(a.c.sdk_transparent);
                this.mVx.startLoad(alaRecommendLiveData.getLivePortrait() + this.igr, 12, false);
                this.mVy.setText(alaRecommendLiveData.getNameShow());
                if (i2 == 101 && this.mVA != null) {
                    this.mVA.setText(alaRecommendLiveData.audience_count + "观看");
                }
                this.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C0840a.this.a(alaRecommendLiveData);
                    }
                });
                this.mVz.playAnimation();
                a.a(UbcStatisticLiveKey.KEY_ID_1392, "show", alaRecommendLiveData, this.mPosition);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(AlaRecommendLiveData alaRecommendLiveData) {
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
                a.a(UbcStatisticLiveKey.KEY_ID_1393, UbcStatConstant.ContentType.COVER_CLICK, alaRecommendLiveData, this.mPosition);
            }
        }

        private boolean Si(String str) {
            return openScheme(TbadkCoreApplication.getInst(), str);
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

        private void b(AlaRecommendLiveData alaRecommendLiveData) {
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

    public void JB(int i) {
        this.type = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, String str2, AlaRecommendLiveData alaRecommendLiveData, int i) {
        if (alaRecommendLiveData != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("live_id", alaRecommendLiveData.live_id).put("vid", alaRecommendLiveData.feed_id).put("model", "yourfollower").put("pos", i).put("nearby", "0");
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
