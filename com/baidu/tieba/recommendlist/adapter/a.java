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
import com.baidu.live.data.w;
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
public class a extends AbsDelegateAdapter<com.baidu.tieba.recommendlist.data.a, C0842a> {
    private w bph;
    private int type;

    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.type = 102;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: cI */
    public C0842a onCreateViewHolder(ViewGroup viewGroup) {
        return this.type == 102 ? new C0842a(LayoutInflater.from(this.mContext).inflate(a.g.ala_follow_live_small_item_layout, viewGroup, false), this.mContext) : new C0842a(LayoutInflater.from(this.mContext).inflate(a.g.ala_follow_live_big_item_layout, viewGroup, false), this.mContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.recommendlist.data.a aVar, C0842a c0842a) {
        c0842a.a(aVar.mCt, i, this.type, this.bph);
        return view;
    }

    public void setAlaLiveShowData(w wVar) {
        this.bph = wVar;
    }

    /* renamed from: com.baidu.tieba.recommendlist.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0842a extends TypeAdapter.ViewHolder {
        private w bph;
        private HeadImageView mBX;
        private TextView mBY;
        private TBLottieAnimationView mBZ;
        private TextView mCa;
        private AlaRecommendLiveData mCb;
        private String mCc;
        private Context mContext;
        private int mPosition;
        private View rootView;

        private C0842a(View view, Context context) {
            super(view);
            this.mCc = "";
            this.mContext = context;
            this.rootView = view;
            this.mBX = (HeadImageView) view.findViewById(a.f.ala_headImage);
            this.mBY = (TextView) view.findViewById(a.f.ala_liveroom_name);
            this.mBZ = (TBLottieAnimationView) view.findViewById(a.f.ala_headImage_lottieView);
            this.mCa = (TextView) view.findViewById(a.f.ala_audience_count);
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.mCc = "@resize{w:" + this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds100) + ",h:" + this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds100) + "}";
            } else {
                this.mCc = "";
            }
            this.mBZ.setImageAssetsFolder("images/");
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.mBZ.setAnimation("headNightJson.json");
            } else {
                this.mBZ.setAnimation("headDayJson.json");
            }
        }

        public void a(final AlaRecommendLiveData alaRecommendLiveData, int i, int i2, w wVar) {
            if (alaRecommendLiveData != null) {
                this.bph = wVar;
                this.mCb = alaRecommendLiveData;
                this.mPosition = i;
                this.mBX.setIsRound(true);
                this.mBX.setDrawBorder(false);
                this.mBX.setDefaultBgResource(a.c.sdk_transparent);
                this.mBX.startLoad(alaRecommendLiveData.cover + this.mCc, 10, false);
                this.mBY.setText(alaRecommendLiveData.getNameShow());
                if (i2 == 101 && this.mCa != null) {
                    this.mCa.setText(alaRecommendLiveData.audience_count + "观看");
                }
                this.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C0842a.this.a(alaRecommendLiveData);
                    }
                });
                this.mBZ.playAnimation();
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
            }
        }
    }

    public void IQ(int i) {
        this.type = i;
    }
}
