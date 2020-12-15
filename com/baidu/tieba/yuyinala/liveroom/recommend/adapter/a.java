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
public class a extends AbsDelegateAdapter<com.baidu.tieba.yuyinala.liveroom.recommend.data.a, C0933a> {
    private w bur;
    private int cardWidth;
    private int ops;
    private TbPageContext opu;

    public a(Context context, BdUniqueId bdUniqueId, int i, TbPageContext tbPageContext) {
        super(context, bdUniqueId);
        this.cardWidth = i;
        this.opu = tbPageContext;
    }

    public void NG(int i) {
        this.ops = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: cS */
    public C0933a onCreateViewHolder(ViewGroup viewGroup) {
        return new C0933a(LayoutInflater.from(this.mContext).inflate(a.g.ala_recommend_live_item_layout, viewGroup, false), this.mContext, this.cardWidth, this.opu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar, C0933a c0933a) {
        c0933a.a(aVar, i, this.ops, this.bur);
        return view;
    }

    public void setAlaLiveShowData(w wVar) {
        this.bur = wVar;
    }

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0933a extends TypeAdapter.ViewHolder {
        private w bur;
        private RelativeLayout[] hTH;
        private TbImageView[] hTI;
        private TextView[] hTJ;
        private TextView[] hTK;
        private LinearLayout[] hTL;
        private TextView[] hTM;
        private String hTR;
        private Context mContext;
        private TbPageContext mPageContext;
        private int mPosition;
        private int ops;
        private TextView[] opv;
        private com.baidu.tieba.yuyinala.liveroom.recommend.data.a opw;

        private C0933a(View view, Context context, int i, TbPageContext tbPageContext) {
            super(view);
            this.hTR = "";
            this.mContext = context;
            this.mPageContext = tbPageContext;
            this.hTH = new RelativeLayout[2];
            this.hTI = new TbImageView[2];
            this.hTJ = new TextView[2];
            this.hTK = new TextView[2];
            this.hTL = new LinearLayout[2];
            this.hTM = new TextView[2];
            this.opv = new TextView[2];
            this.hTH[0] = (RelativeLayout) view.findViewById(a.f.left_content_layout);
            this.hTH[1] = (RelativeLayout) view.findViewById(a.f.right_content_layout);
            this.hTI[0] = (TbImageView) view.findViewById(a.f.left_cover_imageView);
            this.hTI[1] = (TbImageView) view.findViewById(a.f.right_cover_imageView);
            this.hTJ[0] = (TextView) view.findViewById(a.f.left_count_textView);
            this.hTJ[1] = (TextView) view.findViewById(a.f.right_count_textView);
            this.hTK[0] = (TextView) view.findViewById(a.f.left_name_textView);
            this.hTK[1] = (TextView) view.findViewById(a.f.right_name_textView);
            this.hTL[0] = (LinearLayout) view.findViewById(a.f.left_location_layout);
            this.hTL[1] = (LinearLayout) view.findViewById(a.f.right_location_layout);
            this.hTM[0] = (TextView) view.findViewById(a.f.left_location_textView);
            this.hTM[1] = (TextView) view.findViewById(a.f.right_location_textView);
            this.opv[0] = (TextView) view.findViewById(a.f.left_live_label);
            this.opv[1] = (TextView) view.findViewById(a.f.right_live_label);
            this.hTI[0].getLayoutParams().width = i;
            this.hTI[0].getLayoutParams().height = i;
            this.hTI[1].getLayoutParams().width = i;
            this.hTI[1].getLayoutParams().height = i;
            this.hTI[0].setDefaultBgResource(a.e.sdk_shape_transparent);
            this.hTI[1].setDefaultBgResource(a.e.sdk_shape_transparent);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && i > 0) {
                this.hTR = "@resize{w:" + i + ",h:" + i + "}";
            }
            this.hTH[0].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0933a.this.opw != null) {
                        if (C0933a.this.opw.opA != null) {
                            C0933a.this.b(C0933a.this.opw.opA, 0, C0933a.this.opw.type);
                        } else if (C0933a.this.opw.opB != null) {
                            C0933a.this.b(C0933a.this.opw.opB, 0, C0933a.this.opw.type);
                        }
                    }
                }
            });
            this.hTH[1].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0933a.this.opw != null && C0933a.this.opw.opB != null) {
                        C0933a.this.b(C0933a.this.opw.opB, 1, C0933a.this.opw.type);
                    }
                }
            });
        }

        public void a(com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar, int i, int i2, w wVar) {
            boolean z;
            int i3;
            if (aVar != null) {
                this.opw = aVar;
                this.mPosition = i;
                this.ops = i2;
                this.bur = wVar;
                if (aVar.opA != null) {
                    a(aVar.opA, 0, this.opw.type);
                }
                if (aVar.opB != null) {
                    if (aVar.opA == null) {
                        i3 = 0;
                        z = false;
                    } else {
                        i3 = 1;
                        z = true;
                    }
                    a(aVar.opB, i3, this.opw.type);
                } else {
                    z = false;
                }
                if (z) {
                    this.hTH[1].setVisibility(0);
                } else {
                    this.hTH[1].setVisibility(8);
                }
            }
        }

        private void a(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            this.hTI[i].startLoad(alaRecommendLiveData.cover + this.hTR, 10, false);
            this.hTK[i].setText(alaRecommendLiveData.room_name);
            this.hTJ[i].setText(String.format(this.mContext.getResources().getString(a.h.recommend_live_audience_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
            if (!TextUtils.isEmpty(alaRecommendLiveData.distance) && !TextUtils.equals(alaRecommendLiveData.distance, "0")) {
                this.hTM[i].setText(alaRecommendLiveData.distance);
                this.hTL[i].setVisibility(0);
            } else {
                this.hTL[i].setVisibility(8);
            }
            if (alaRecommendLiveData.corner_tag == 2) {
                this.opv[i].setVisibility(0);
                this.opv[i].setText(this.opv[i].getContext().getResources().getString(a.h.yuyin_dating));
                this.opv[i].setBackgroundResource(a.e.shape_yuyin_dating_bg);
            } else {
                this.opv[i].setVisibility(8);
            }
            a(UbcStatisticLiveKey.KEY_ID_1392, "show", alaRecommendLiveData, i2, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(final AlaRecommendLiveData alaRecommendLiveData, final int i, final int i2) {
            boolean jt = com.baidu.live.ap.b.YX().jt(ExtraParamsManager.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
            boolean isApplying = com.baidu.live.ap.b.YX().isApplying();
            if (jt) {
                g gVar = new g(this.mPageContext);
                gVar.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a.a.3
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        C0933a.this.c(alaRecommendLiveData, i, i2);
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
                        C0933a.this.c(alaRecommendLiveData, i, i2);
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
                if (this.bur != null) {
                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                    if (this.bur.aKL != null) {
                        alaLastLiveroomInfo.setLastAnchorPortrait(this.bur.aKL.cover);
                        alaLastLiveroomInfo.setLastAnchorUname(this.bur.aKL.room_name);
                    }
                    if (this.bur.mLiveInfo != null) {
                        alaLastLiveroomInfo.setLastLiveId(this.bur.mLiveInfo.live_id);
                        alaLastLiveroomInfo.setLastRoomId(this.bur.mLiveInfo.room_id);
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
                        } else if (this.ops > 0) {
                            i3 = ((((this.mPosition - 1) - 1) - ((int) ((this.ops / 2) + 0.9f))) * 2) + i2 + 1;
                        } else {
                            i3 = ((this.mPosition - 1) * 2) + i2 + 1;
                        }
                        jSONObject.put("live_id", alaRecommendLiveData.live_id).put("vid", alaRecommendLiveData.feed_id).put("model", i == 0 ? "yourfollower" : "hotlive").put("pos", i3).put("nearby", (i != 1 || TextUtils.isEmpty(alaRecommendLiveData.distance)) ? "0" : "1");
                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                        jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.bur.aKL.croom_id);
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
