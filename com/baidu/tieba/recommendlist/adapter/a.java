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
public class a extends AbsDelegateAdapter<com.baidu.tieba.recommendlist.data.a, C0857a> {
    private w bur;
    private int type;

    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.type = 102;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: cL */
    public C0857a onCreateViewHolder(ViewGroup viewGroup) {
        return this.type == 102 ? new C0857a(LayoutInflater.from(this.mContext).inflate(a.g.ala_follow_live_small_item_layout, viewGroup, false), this.mContext) : new C0857a(LayoutInflater.from(this.mContext).inflate(a.g.ala_follow_live_big_item_layout, viewGroup, false), this.mContext);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.recommendlist.data.a aVar, C0857a c0857a) {
        c0857a.a(aVar.mQy, i, this.type, this.bur);
        return view;
    }

    public void setAlaLiveShowData(w wVar) {
        this.bur = wVar;
    }

    /* renamed from: com.baidu.tieba.recommendlist.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0857a extends TypeAdapter.ViewHolder {
        private w bur;
        private String hTR;
        private Context mContext;
        private int mPosition;
        private HeadImageView mQj;
        private TextView mQk;
        private TBLottieAnimationView mQl;
        private TextView mQm;
        private AlaRecommendLiveData mQn;
        private View rootView;

        private C0857a(View view, Context context) {
            super(view);
            this.hTR = "";
            this.mContext = context;
            this.rootView = view;
            this.mQj = (HeadImageView) view.findViewById(a.f.ala_headImage);
            this.mQk = (TextView) view.findViewById(a.f.ala_liveroom_name);
            this.mQl = (TBLottieAnimationView) view.findViewById(a.f.ala_headImage_lottieView);
            this.mQm = (TextView) view.findViewById(a.f.ala_audience_count);
            if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.hTR = "@resize{w:" + this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds100) + ",h:" + this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds100) + "}";
            } else {
                this.hTR = "";
            }
            this.mQl.setImageAssetsFolder("images/");
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.mQl.setAnimation("headNightJson.json");
            } else {
                this.mQl.setAnimation("headDayJson.json");
            }
        }

        public void a(final AlaRecommendLiveData alaRecommendLiveData, int i, int i2, w wVar) {
            if (alaRecommendLiveData != null) {
                this.bur = wVar;
                this.mQn = alaRecommendLiveData;
                this.mPosition = i;
                this.mQj.setIsRound(true);
                this.mQj.setDrawBorder(false);
                this.mQj.setDefaultBgResource(a.c.sdk_transparent);
                this.mQj.startLoad(alaRecommendLiveData.cover + this.hTR, 10, false);
                this.mQk.setText(alaRecommendLiveData.getNameShow());
                if (i2 == 101 && this.mQm != null) {
                    this.mQm.setText(alaRecommendLiveData.audience_count + "观看");
                }
                this.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recommendlist.adapter.a.a.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C0857a.this.a(alaRecommendLiveData);
                    }
                });
                this.mQl.playAnimation();
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
                if (this.bur != null) {
                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                    if (this.bur.aJV != null) {
                        alaLastLiveroomInfo.setLastAnchorPortrait(this.bur.aJV.portrait);
                        alaLastLiveroomInfo.setLastAnchorUid(String.valueOf(this.bur.aJV.userId));
                        alaLastLiveroomInfo.setLastAnchorUname(this.bur.aJV.nickName);
                    }
                    if (this.bur.mLiveInfo != null) {
                        alaLastLiveroomInfo.setLastLiveId(this.bur.mLiveInfo.live_id);
                        alaLastLiveroomInfo.setLastRoomId(this.bur.mLiveInfo.room_id);
                        alaLastLiveroomInfo.setLastCover(this.bur.mLiveInfo.cover);
                        if (this.bur.mLiveInfo.session_info != null) {
                            if (!TextUtils.isEmpty(this.bur.mLiveInfo.session_info.flvUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bur.mLiveInfo.session_info.flvUrl);
                            } else if (!TextUtils.isEmpty(this.bur.mLiveInfo.session_info.hlsUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bur.mLiveInfo.session_info.hlsUrl);
                            } else if (!TextUtils.isEmpty(this.bur.mLiveInfo.session_info.rtmpUrl)) {
                                alaLastLiveroomInfo.setLastVideoUrl(this.bur.mLiveInfo.session_info.rtmpUrl);
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

    public void JH(int i) {
        this.type = i;
    }
}
