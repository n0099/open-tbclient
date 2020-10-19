package com.baidu.tieba.recommendlist.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.widget.listview.AbsDelegateAdapter;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.data.AlaLiveStreamSessionInfo;
import com.baidu.live.data.u;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.recommendlist.data.AlaRecommendLiveData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends AbsDelegateAdapter<com.baidu.tieba.recommendlist.data.a, C0810a> {
    private u bnM;
    private int type;

    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.type = 102;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: cJ */
    public C0810a onCreateViewHolder(ViewGroup viewGroup) {
        return this.type == 102 ? new C0810a(LayoutInflater.from(this.mContext).inflate(a.h.ala_follow_live_small_item_layout, viewGroup, false), this.mContext) : new C0810a(LayoutInflater.from(this.mContext).inflate(a.h.ala_follow_live_big_item_layout, viewGroup, false), this.mContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.recommendlist.data.a aVar, C0810a c0810a) {
        c0810a.a(aVar.mjz, i, this.type, this.bnM);
        return view;
    }

    public void g(u uVar) {
        this.bnM = uVar;
    }

    /* renamed from: com.baidu.tieba.recommendlist.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0810a extends TypeAdapter.ViewHolder {
        private u bnM;
        private Context mContext;
        private int mPosition;
        private HeadImageView mjf;
        private TextView mjg;
        private TBLottieAnimationView mjh;
        private TextView mji;
        private AlaRecommendLiveData mjj;
        private String mjk;
        private View rootView;

        private C0810a(View view, Context context) {
            super(view);
            this.mjk = "";
            this.mContext = context;
            this.rootView = view;
            this.mjf = (HeadImageView) view.findViewById(a.g.ala_headImage);
            this.mjg = (TextView) view.findViewById(a.g.ala_liveroom_name);
            this.mjh = (TBLottieAnimationView) view.findViewById(a.g.ala_headImage_lottieView);
            this.mji = (TextView) view.findViewById(a.g.ala_audience_count);
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.mjk = "@resize{w:" + this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds100) + ",h:" + this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds100) + "}";
            } else {
                this.mjk = "";
            }
            this.mjh.setImageAssetsFolder("images/");
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.mjh.setAnimation("headNightJson.json");
            } else {
                this.mjh.setAnimation("headDayJson.json");
            }
        }

        public void a(final AlaRecommendLiveData alaRecommendLiveData, int i, int i2, u uVar) {
            if (alaRecommendLiveData != null) {
                this.bnM = uVar;
                this.mjj = alaRecommendLiveData;
                this.mPosition = i;
                this.mjf.setIsRound(true);
                this.mjf.setDrawBorder(false);
                this.mjf.setDefaultBgResource(a.d.sdk_transparent);
                this.mjf.startLoad(alaRecommendLiveData.cover + this.mjk, 10, false);
                this.mjg.setText(alaRecommendLiveData.getNameShow());
                if (i2 == 101 && this.mji != null) {
                    this.mji.setText(alaRecommendLiveData.audience_count + "观看");
                }
                this.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C0810a.this.a(alaRecommendLiveData);
                    }
                });
                this.mjh.playAnimation();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(AlaRecommendLiveData alaRecommendLiveData) {
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
                if (this.bnM != null) {
                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                    if (this.bnM.aHD != null) {
                        alaLastLiveroomInfo.setLastAnchorPortrait(this.bnM.aHD.portrait);
                        alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.bnM.aHD.userId));
                        alaLastLiveroomInfo.setLastAnchorUname(this.bnM.aHD.nickName);
                    }
                    if (this.bnM.mLiveInfo != null) {
                        alaLastLiveroomInfo.setLastLiveId(this.bnM.mLiveInfo.live_id);
                        alaLastLiveroomInfo.setLastRoomId(this.bnM.mLiveInfo.room_id);
                        alaLastLiveroomInfo.setLastCover(this.bnM.mLiveInfo.cover);
                        if (this.bnM.mLiveInfo.session_info != null) {
                            if (!TextUtils.isEmpty(this.bnM.mLiveInfo.session_info.flvUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bnM.mLiveInfo.session_info.flvUrl);
                            } else if (!TextUtils.isEmpty(this.bnM.mLiveInfo.session_info.hlsUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bnM.mLiveInfo.session_info.hlsUrl);
                            } else if (!TextUtils.isEmpty(this.bnM.mLiveInfo.session_info.rtmpUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bnM.mLiveInfo.session_info.rtmpUrl);
                            }
                        }
                    }
                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_RECOMMEND);
                    alaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
            }
        }
    }

    public void HJ(int i) {
        this.type = i;
    }
}
