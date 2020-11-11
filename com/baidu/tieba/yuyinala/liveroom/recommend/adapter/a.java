package com.baidu.tieba.yuyinala.liveroom.recommend.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.yuyinala.liveroom.recommend.data.AlaRecommendLiveData;
import com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends AbsDelegateAdapter<com.baidu.tieba.yuyinala.liveroom.recommend.data.a, C0913a> {
    private w bqS;
    private int cardWidth;
    private int nYN;
    private TbPageContext nYO;

    public a(Context context, BdUniqueId bdUniqueId, int i, TbPageContext tbPageContext) {
        super(context, bdUniqueId);
        this.cardWidth = i;
        this.nYO = tbPageContext;
    }

    public void Ml(int i) {
        this.nYN = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: cT */
    public C0913a onCreateViewHolder(ViewGroup viewGroup) {
        return new C0913a(LayoutInflater.from(this.mContext).inflate(a.g.ala_recommend_live_item_layout, viewGroup, false), this.mContext, this.cardWidth, this.nYO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar, C0913a c0913a) {
        c0913a.a(aVar, i, this.nYN, this.bqS);
        return view;
    }

    public void setAlaLiveShowData(w wVar) {
        this.bqS = wVar;
    }

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0913a extends TypeAdapter.ViewHolder {
        private w bqS;
        private String mBF;
        private RelativeLayout[] mBK;
        private TbImageView[] mBL;
        private TextView[] mBM;
        private TextView[] mBN;
        private LinearLayout[] mBO;
        private TextView[] mBP;
        private Context mContext;
        private TbPageContext mPageContext;
        private int mPosition;
        private int nYN;
        private TextView[] nYP;
        private com.baidu.tieba.yuyinala.liveroom.recommend.data.a nYQ;

        private C0913a(View view, Context context, int i, TbPageContext tbPageContext) {
            super(view);
            this.mBF = "";
            this.mContext = context;
            this.mPageContext = tbPageContext;
            this.mBK = new RelativeLayout[2];
            this.mBL = new TbImageView[2];
            this.mBM = new TextView[2];
            this.mBN = new TextView[2];
            this.mBO = new LinearLayout[2];
            this.mBP = new TextView[2];
            this.nYP = new TextView[2];
            this.mBK[0] = (RelativeLayout) view.findViewById(a.f.left_content_layout);
            this.mBK[1] = (RelativeLayout) view.findViewById(a.f.right_content_layout);
            this.mBL[0] = (TbImageView) view.findViewById(a.f.left_cover_imageView);
            this.mBL[1] = (TbImageView) view.findViewById(a.f.right_cover_imageView);
            this.mBM[0] = (TextView) view.findViewById(a.f.left_count_textView);
            this.mBM[1] = (TextView) view.findViewById(a.f.right_count_textView);
            this.mBN[0] = (TextView) view.findViewById(a.f.left_name_textView);
            this.mBN[1] = (TextView) view.findViewById(a.f.right_name_textView);
            this.mBO[0] = (LinearLayout) view.findViewById(a.f.left_location_layout);
            this.mBO[1] = (LinearLayout) view.findViewById(a.f.right_location_layout);
            this.mBP[0] = (TextView) view.findViewById(a.f.left_location_textView);
            this.mBP[1] = (TextView) view.findViewById(a.f.right_location_textView);
            this.nYP[0] = (TextView) view.findViewById(a.f.left_live_label);
            this.nYP[1] = (TextView) view.findViewById(a.f.right_live_label);
            this.mBL[0].getLayoutParams().width = i;
            this.mBL[0].getLayoutParams().height = i;
            this.mBL[1].getLayoutParams().width = i;
            this.mBL[1].getLayoutParams().height = i;
            this.mBL[0].setDefaultBgResource(a.e.sdk_shape_transparent);
            this.mBL[1].setDefaultBgResource(a.e.sdk_shape_transparent);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && i > 0) {
                this.mBF = "@resize{w:" + i + ",h:" + i + "}";
            }
            this.mBK[0].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0913a.this.nYQ != null) {
                        if (C0913a.this.nYQ.nYU != null) {
                            C0913a.this.b(C0913a.this.nYQ.nYU, 0, C0913a.this.nYQ.type);
                        } else if (C0913a.this.nYQ.nYV != null) {
                            C0913a.this.b(C0913a.this.nYQ.nYV, 0, C0913a.this.nYQ.type);
                        }
                    }
                }
            });
            this.mBK[1].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0913a.this.nYQ != null && C0913a.this.nYQ.nYV != null) {
                        C0913a.this.b(C0913a.this.nYQ.nYV, 1, C0913a.this.nYQ.type);
                    }
                }
            });
        }

        public void a(com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar, int i, int i2, w wVar) {
            boolean z;
            int i3;
            if (aVar != null) {
                this.nYQ = aVar;
                this.mPosition = i;
                this.nYN = i2;
                this.bqS = wVar;
                if (aVar.nYU != null) {
                    a(aVar.nYU, 0, this.nYQ.type);
                }
                if (aVar.nYV != null) {
                    if (aVar.nYU == null) {
                        i3 = 0;
                        z = false;
                    } else {
                        i3 = 1;
                        z = true;
                    }
                    a(aVar.nYV, i3, this.nYQ.type);
                } else {
                    z = false;
                }
                if (z) {
                    this.mBK[1].setVisibility(0);
                } else {
                    this.mBK[1].setVisibility(8);
                }
            }
        }

        private void a(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            this.mBL[i].startLoad(alaRecommendLiveData.cover + this.mBF, 10, false);
            this.mBN[i].setText(alaRecommendLiveData.room_name);
            this.mBM[i].setText(String.format(this.mContext.getResources().getString(a.h.recommend_live_audience_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
            if (!TextUtils.isEmpty(alaRecommendLiveData.distance) && !TextUtils.equals(alaRecommendLiveData.distance, "0")) {
                this.mBP[i].setText(alaRecommendLiveData.distance);
                this.mBO[i].setVisibility(0);
            } else {
                this.mBO[i].setVisibility(8);
            }
            if (alaRecommendLiveData.corner_tag == 2) {
                this.nYP[i].setVisibility(0);
                this.nYP[i].setText(this.nYP[i].getContext().getResources().getString(a.h.yuyin_dating));
                this.nYP[i].setBackgroundResource(a.e.shape_yuyin_dating_bg);
            } else {
                this.nYP[i].setVisibility(8);
            }
            a(UbcStatisticLiveKey.KEY_ID_1392, "show", alaRecommendLiveData, i2, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(final AlaRecommendLiveData alaRecommendLiveData, final int i, final int i2) {
            boolean iV = com.baidu.live.al.b.Xh().iV(ExtraParamsManager.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
            boolean isApplying = com.baidu.live.al.b.Xh().isApplying();
            if (iV) {
                g gVar = new g(this.mPageContext);
                gVar.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a.a.3
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        C0913a.this.c(alaRecommendLiveData, i, i2);
                    }
                });
                gVar.show();
                gVar.setText("你当前正在麦上，离开本房间将断开本次连麦哦");
            } else if (isApplying) {
                g gVar2 = new g(this.mPageContext);
                gVar2.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a.a.4
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        C0913a.this.c(alaRecommendLiveData, i, i2);
                    }
                });
                gVar2.show();
                gVar2.setText("你当前正在申请上麦，离开本房间将取消本次申请哦");
            } else {
                c(alaRecommendLiveData, i, i2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            if (alaRecommendLiveData != null) {
                String str = "";
                YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(this.mContext);
                yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(alaRecommendLiveData.live_id, String.valueOf(alaRecommendLiveData.room_id), "recommend_live");
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
                yuyinAlaLiveRoomActivityConfig.addExtraByParams(str);
                if (this.bqS != null) {
                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                    if (this.bqS.aJK != null) {
                        alaLastLiveroomInfo.setLastAnchorPortrait(this.bqS.aJK.cover);
                        alaLastLiveroomInfo.setLastAnchorUname(this.bqS.aJK.room_name);
                    }
                    if (this.bqS.mLiveInfo != null) {
                        alaLastLiveroomInfo.setLastLiveId(this.bqS.mLiveInfo.live_id);
                        alaLastLiveroomInfo.setLastRoomId(this.bqS.mLiveInfo.room_id);
                    }
                    alaLastLiveroomInfo.setIsAudio(1);
                    alaLastLiveroomInfo.setFrom(AlaLastLiveroomInfo.TYPE_FROM_RECOMMEND);
                    yuyinAlaLiveRoomActivityConfig.addLastLiveInfoParams(alaLastLiveroomInfo);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
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
                        } else if (this.nYN > 0) {
                            i3 = ((((this.mPosition - 1) - 1) - ((int) ((this.nYN / 2) + 0.9f))) * 2) + i2 + 1;
                        } else {
                            i3 = ((this.mPosition - 1) * 2) + i2 + 1;
                        }
                        jSONObject.put("live_id", alaRecommendLiveData.live_id).put("vid", alaRecommendLiveData.feed_id).put("model", i == 0 ? "yourfollower" : "hotlive").put("pos", i3).put("nearby", (i != 1 || TextUtils.isEmpty(alaRecommendLiveData.distance)) ? "0" : "1");
                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                        jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.bqS.aJK.croom_id);
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(str, str2, "more_room", null).setContentExt(jSONObject));
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
        }
    }
}
