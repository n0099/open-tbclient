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
import com.baidu.live.data.ab;
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
/* loaded from: classes10.dex */
public class a extends AbsDelegateAdapter<com.baidu.tieba.recommendlist.data.a, C0867a> {
    private ab bzn;
    private int type;

    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.type = 102;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: cX */
    public C0867a onCreateViewHolder(ViewGroup viewGroup) {
        return this.type == 102 ? new C0867a(LayoutInflater.from(this.mContext).inflate(a.g.ala_follow_live_small_item_layout, viewGroup, false), this.mContext) : new C0867a(LayoutInflater.from(this.mContext).inflate(a.g.ala_follow_live_big_item_layout, viewGroup, false), this.mContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.recommendlist.data.a aVar, C0867a c0867a) {
        c0867a.a(aVar.ndm, i, this.type, this.bzn);
        return view;
    }

    public void setAlaLiveShowData(ab abVar) {
        this.bzn = abVar;
    }

    /* renamed from: com.baidu.tieba.recommendlist.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0867a extends TypeAdapter.ViewHolder {
        private ab bzn;
        private String iib;
        private Context mContext;
        private int mPosition;
        private HeadImageView ncM;
        private TextView ncN;
        private TBLottieAnimationView ncO;
        private TextView ncP;
        private AlaRecommendLiveData ncQ;
        private View rootView;

        private C0867a(View view, Context context) {
            super(view);
            this.iib = "";
            this.mContext = context;
            this.rootView = view;
            this.ncM = (HeadImageView) view.findViewById(a.f.ala_headImage);
            this.ncN = (TextView) view.findViewById(a.f.ala_liveroom_name);
            this.ncO = (TBLottieAnimationView) view.findViewById(a.f.ala_headImage_lottieView);
            this.ncP = (TextView) view.findViewById(a.f.ala_audience_count);
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.iib = "@resize{w:" + this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds100) + ",h:" + this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds100) + "}";
            } else {
                this.iib = "";
            }
            this.ncO.setImageAssetsFolder("images/");
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.ncO.setAnimation("headNightJson.json");
            } else {
                this.ncO.setAnimation("headDayJson.json");
            }
        }

        public void a(final AlaRecommendLiveData alaRecommendLiveData, int i, int i2, ab abVar) {
            if (alaRecommendLiveData != null) {
                this.bzn = abVar;
                this.ncQ = alaRecommendLiveData;
                this.mPosition = i;
                this.ncM.setIsRound(true);
                this.ncM.setDrawBorder(false);
                this.ncM.setDefaultBgResource(a.c.sdk_transparent);
                this.ncM.startLoad(alaRecommendLiveData.getLivePortrait() + this.iib, 12, false);
                this.ncN.setText(alaRecommendLiveData.getNameShow());
                if (i2 == 101 && this.ncP != null) {
                    this.ncP.setText(alaRecommendLiveData.audience_count + "观看");
                }
                this.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C0867a.this.a(alaRecommendLiveData);
                    }
                });
                this.ncO.playAnimation();
                a.a(UbcStatisticLiveKey.KEY_ID_1392, "show", alaRecommendLiveData, this.mPosition);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(AlaRecommendLiveData alaRecommendLiveData) {
            if (alaRecommendLiveData != null) {
                com.baidu.live.liveroom.a.Mu().a(com.baidu.live.liveroom.a.Mu().Mv().hq(String.valueOf(alaRecommendLiveData.live_id)));
                if (TextUtils.isEmpty(alaRecommendLiveData.scheme) || alaRecommendLiveData.mixType == 1) {
                    BdLog.e("openInner: scheme: " + alaRecommendLiveData.scheme);
                    b(alaRecommendLiveData);
                } else {
                    BdLog.e("openByScheme: " + alaRecommendLiveData.scheme);
                    if (!Sn(alaRecommendLiveData.scheme)) {
                        BdLog.e("openInner: scheme: " + alaRecommendLiveData.scheme);
                        b(alaRecommendLiveData);
                    }
                }
                a.a(UbcStatisticLiveKey.KEY_ID_1393, UbcStatConstant.ContentType.COVER_CLICK, alaRecommendLiveData, this.mPosition);
            }
        }

        private boolean Sn(String str) {
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
        }
    }

    public void Is(int i) {
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
