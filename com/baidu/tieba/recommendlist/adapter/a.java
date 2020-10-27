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
public class a extends AbsDelegateAdapter<com.baidu.tieba.recommendlist.data.a, C0825a> {
    private w bpz;
    private int type;

    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.type = 102;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: cK */
    public C0825a onCreateViewHolder(ViewGroup viewGroup) {
        return this.type == 102 ? new C0825a(LayoutInflater.from(this.mContext).inflate(a.h.ala_follow_live_small_item_layout, viewGroup, false), this.mContext) : new C0825a(LayoutInflater.from(this.mContext).inflate(a.h.ala_follow_live_big_item_layout, viewGroup, false), this.mContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.recommendlist.data.a aVar, C0825a c0825a) {
        c0825a.a(aVar.mvZ, i, this.type, this.bpz);
        return view;
    }

    public void setAlaLiveShowData(w wVar) {
        this.bpz = wVar;
    }

    /* renamed from: com.baidu.tieba.recommendlist.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0825a extends TypeAdapter.ViewHolder {
        private w bpz;
        private Context mContext;
        private int mPosition;
        private HeadImageView mvD;
        private TextView mvE;
        private TBLottieAnimationView mvF;
        private TextView mvG;
        private AlaRecommendLiveData mvH;
        private String mvI;
        private View rootView;

        private C0825a(View view, Context context) {
            super(view);
            this.mvI = "";
            this.mContext = context;
            this.rootView = view;
            this.mvD = (HeadImageView) view.findViewById(a.g.ala_headImage);
            this.mvE = (TextView) view.findViewById(a.g.ala_liveroom_name);
            this.mvF = (TBLottieAnimationView) view.findViewById(a.g.ala_headImage_lottieView);
            this.mvG = (TextView) view.findViewById(a.g.ala_audience_count);
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.mvI = "@resize{w:" + this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds100) + ",h:" + this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds100) + "}";
            } else {
                this.mvI = "";
            }
            this.mvF.setImageAssetsFolder("images/");
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.mvF.setAnimation("headNightJson.json");
            } else {
                this.mvF.setAnimation("headDayJson.json");
            }
        }

        public void a(final AlaRecommendLiveData alaRecommendLiveData, int i, int i2, w wVar) {
            if (alaRecommendLiveData != null) {
                this.bpz = wVar;
                this.mvH = alaRecommendLiveData;
                this.mPosition = i;
                this.mvD.setIsRound(true);
                this.mvD.setDrawBorder(false);
                this.mvD.setDefaultBgResource(a.d.sdk_transparent);
                this.mvD.startLoad(alaRecommendLiveData.cover + this.mvI, 10, false);
                this.mvE.setText(alaRecommendLiveData.getNameShow());
                if (i2 == 101 && this.mvG != null) {
                    this.mvG.setText(alaRecommendLiveData.audience_count + "观看");
                }
                this.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C0825a.this.a(alaRecommendLiveData);
                    }
                });
                this.mvF.playAnimation();
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
            }
        }
    }

    public void Ic(int i) {
        this.type = i;
    }
}
