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
public class a extends AbsDelegateAdapter<com.baidu.tieba.yuyinala.liveroom.recommend.data.a, C0897a> {
    private w bpz;
    private int cardWidth;
    private int nRB;
    private TbPageContext nRC;

    public a(Context context, BdUniqueId bdUniqueId, int i, TbPageContext tbPageContext) {
        super(context, bdUniqueId);
        this.cardWidth = i;
        this.nRC = tbPageContext;
    }

    public void LU(int i) {
        this.nRB = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: cQ */
    public C0897a onCreateViewHolder(ViewGroup viewGroup) {
        return new C0897a(LayoutInflater.from(this.mContext).inflate(a.h.ala_recommend_live_item_layout, viewGroup, false), this.mContext, this.cardWidth, this.nRC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar, C0897a c0897a) {
        c0897a.a(aVar, i, this.nRB, this.bpz);
        return view;
    }

    public void setAlaLiveShowData(w wVar) {
        this.bpz = wVar;
    }

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0897a extends TypeAdapter.ViewHolder {
        private w bpz;
        private Context mContext;
        private TbPageContext mPageContext;
        private int mPosition;
        private String mvI;
        private RelativeLayout[] mvN;
        private TbImageView[] mvO;
        private TextView[] mvP;
        private TextView[] mvQ;
        private LinearLayout[] mvR;
        private TextView[] mvS;
        private int nRB;
        private com.baidu.tieba.yuyinala.liveroom.recommend.data.a nRD;

        private C0897a(View view, Context context, int i, TbPageContext tbPageContext) {
            super(view);
            this.mvI = "";
            this.mContext = context;
            this.mPageContext = tbPageContext;
            this.mvN = new RelativeLayout[2];
            this.mvO = new TbImageView[2];
            this.mvP = new TextView[2];
            this.mvQ = new TextView[2];
            this.mvR = new LinearLayout[2];
            this.mvS = new TextView[2];
            this.mvN[0] = (RelativeLayout) view.findViewById(a.g.left_content_layout);
            this.mvN[1] = (RelativeLayout) view.findViewById(a.g.right_content_layout);
            this.mvO[0] = (TbImageView) view.findViewById(a.g.left_cover_imageView);
            this.mvO[1] = (TbImageView) view.findViewById(a.g.right_cover_imageView);
            this.mvP[0] = (TextView) view.findViewById(a.g.left_count_textView);
            this.mvP[1] = (TextView) view.findViewById(a.g.right_count_textView);
            this.mvQ[0] = (TextView) view.findViewById(a.g.left_name_textView);
            this.mvQ[1] = (TextView) view.findViewById(a.g.right_name_textView);
            this.mvR[0] = (LinearLayout) view.findViewById(a.g.left_location_layout);
            this.mvR[1] = (LinearLayout) view.findViewById(a.g.right_location_layout);
            this.mvS[0] = (TextView) view.findViewById(a.g.left_location_textView);
            this.mvS[1] = (TextView) view.findViewById(a.g.right_location_textView);
            this.mvO[0].getLayoutParams().width = i;
            this.mvO[0].getLayoutParams().height = i;
            this.mvO[1].getLayoutParams().width = i;
            this.mvO[1].getLayoutParams().height = i;
            this.mvO[0].setDefaultBgResource(a.f.sdk_shape_transparent);
            this.mvO[1].setDefaultBgResource(a.f.sdk_shape_transparent);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && i > 0) {
                this.mvI = "@resize{w:" + i + ",h:" + i + "}";
            }
            this.mvN[0].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0897a.this.nRD != null) {
                        if (C0897a.this.nRD.nRH != null) {
                            C0897a.this.b(C0897a.this.nRD.nRH, 0, C0897a.this.nRD.type);
                        } else if (C0897a.this.nRD.nRI != null) {
                            C0897a.this.b(C0897a.this.nRD.nRI, 0, C0897a.this.nRD.type);
                        }
                    }
                }
            });
            this.mvN[1].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0897a.this.nRD != null && C0897a.this.nRD.nRI != null) {
                        C0897a.this.b(C0897a.this.nRD.nRI, 1, C0897a.this.nRD.type);
                    }
                }
            });
        }

        public void a(com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar, int i, int i2, w wVar) {
            boolean z;
            int i3;
            if (aVar != null) {
                this.nRD = aVar;
                this.mPosition = i;
                this.nRB = i2;
                this.bpz = wVar;
                if (aVar.nRH != null) {
                    a(aVar.nRH, 0, this.nRD.type);
                }
                if (aVar.nRI != null) {
                    if (aVar.nRH == null) {
                        i3 = 0;
                        z = false;
                    } else {
                        i3 = 1;
                        z = true;
                    }
                    a(aVar.nRI, i3, this.nRD.type);
                } else {
                    z = false;
                }
                if (z) {
                    this.mvN[1].setVisibility(0);
                } else {
                    this.mvN[1].setVisibility(8);
                }
            }
        }

        private void a(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            this.mvO[i].startLoad(alaRecommendLiveData.cover + this.mvI, 10, false);
            this.mvQ[i].setText(alaRecommendLiveData.room_name);
            this.mvP[i].setText(String.format(this.mContext.getResources().getString(a.i.recommend_live_audience_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
            if (!TextUtils.isEmpty(alaRecommendLiveData.distance) && !TextUtils.equals(alaRecommendLiveData.distance, "0")) {
                this.mvS[i].setText(alaRecommendLiveData.distance);
                this.mvR[i].setVisibility(0);
            } else {
                this.mvR[i].setVisibility(8);
            }
            a(UbcStatisticLiveKey.KEY_ID_1392, "show", alaRecommendLiveData, i2, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(final AlaRecommendLiveData alaRecommendLiveData, final int i, final int i2) {
            boolean iI = com.baidu.live.aj.b.UH().iI(ExtraParamsManager.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
            boolean UI = com.baidu.live.aj.b.UH().UI();
            if (iI) {
                g gVar = new g(this.mPageContext);
                gVar.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a.a.3
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        C0897a.this.c(alaRecommendLiveData, i, i2);
                    }
                });
                gVar.show();
                gVar.setText("你当前正在麦上，离开本房间将断开本次连麦哦");
            } else if (UI) {
                g gVar2 = new g(this.mPageContext);
                gVar2.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a.a.4
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        C0897a.this.c(alaRecommendLiveData, i, i2);
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
                if (this.bpz != null) {
                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                    if (this.bpz.aIS != null) {
                        alaLastLiveroomInfo.setLastAnchorPortrait(this.bpz.aIS.cover);
                        alaLastLiveroomInfo.setLastAnchorUname(this.bpz.aIS.room_name);
                    }
                    if (this.bpz.mLiveInfo != null) {
                        alaLastLiveroomInfo.setLastLiveId(this.bpz.mLiveInfo.live_id);
                        alaLastLiveroomInfo.setLastRoomId(this.bpz.mLiveInfo.room_id);
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
                        } else if (this.nRB > 0) {
                            i3 = ((((this.mPosition - 1) - 1) - ((int) ((this.nRB / 2) + 0.9f))) * 2) + i2 + 1;
                        } else {
                            i3 = ((this.mPosition - 1) * 2) + i2 + 1;
                        }
                        jSONObject.put("live_id", alaRecommendLiveData.live_id).put("vid", alaRecommendLiveData.feed_id).put("model", i == 0 ? "yourfollower" : "hotlive").put("pos", i3).put("nearby", (i != 1 || TextUtils.isEmpty(alaRecommendLiveData.distance)) ? "0" : "1");
                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                        jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.bpz.aIS.croom_id);
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
