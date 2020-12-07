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
    private int opq;
    private TbPageContext opr;

    public a(Context context, BdUniqueId bdUniqueId, int i, TbPageContext tbPageContext) {
        super(context, bdUniqueId);
        this.cardWidth = i;
        this.opr = tbPageContext;
    }

    public void NG(int i) {
        this.opq = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: cS */
    public C0933a onCreateViewHolder(ViewGroup viewGroup) {
        return new C0933a(LayoutInflater.from(this.mContext).inflate(a.g.ala_recommend_live_item_layout, viewGroup, false), this.mContext, this.cardWidth, this.opr);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar, C0933a c0933a) {
        c0933a.a(aVar, i, this.opq, this.bur);
        return view;
    }

    public void setAlaLiveShowData(w wVar) {
        this.bur = wVar;
    }

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0933a extends TypeAdapter.ViewHolder {
        private w bur;
        private RelativeLayout[] hTF;
        private TbImageView[] hTG;
        private TextView[] hTH;
        private TextView[] hTI;
        private LinearLayout[] hTJ;
        private TextView[] hTK;
        private String hTP;
        private Context mContext;
        private TbPageContext mPageContext;
        private int mPosition;
        private int opq;
        private TextView[] ops;
        private com.baidu.tieba.yuyinala.liveroom.recommend.data.a opu;

        private C0933a(View view, Context context, int i, TbPageContext tbPageContext) {
            super(view);
            this.hTP = "";
            this.mContext = context;
            this.mPageContext = tbPageContext;
            this.hTF = new RelativeLayout[2];
            this.hTG = new TbImageView[2];
            this.hTH = new TextView[2];
            this.hTI = new TextView[2];
            this.hTJ = new LinearLayout[2];
            this.hTK = new TextView[2];
            this.ops = new TextView[2];
            this.hTF[0] = (RelativeLayout) view.findViewById(a.f.left_content_layout);
            this.hTF[1] = (RelativeLayout) view.findViewById(a.f.right_content_layout);
            this.hTG[0] = (TbImageView) view.findViewById(a.f.left_cover_imageView);
            this.hTG[1] = (TbImageView) view.findViewById(a.f.right_cover_imageView);
            this.hTH[0] = (TextView) view.findViewById(a.f.left_count_textView);
            this.hTH[1] = (TextView) view.findViewById(a.f.right_count_textView);
            this.hTI[0] = (TextView) view.findViewById(a.f.left_name_textView);
            this.hTI[1] = (TextView) view.findViewById(a.f.right_name_textView);
            this.hTJ[0] = (LinearLayout) view.findViewById(a.f.left_location_layout);
            this.hTJ[1] = (LinearLayout) view.findViewById(a.f.right_location_layout);
            this.hTK[0] = (TextView) view.findViewById(a.f.left_location_textView);
            this.hTK[1] = (TextView) view.findViewById(a.f.right_location_textView);
            this.ops[0] = (TextView) view.findViewById(a.f.left_live_label);
            this.ops[1] = (TextView) view.findViewById(a.f.right_live_label);
            this.hTG[0].getLayoutParams().width = i;
            this.hTG[0].getLayoutParams().height = i;
            this.hTG[1].getLayoutParams().width = i;
            this.hTG[1].getLayoutParams().height = i;
            this.hTG[0].setDefaultBgResource(a.e.sdk_shape_transparent);
            this.hTG[1].setDefaultBgResource(a.e.sdk_shape_transparent);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && i > 0) {
                this.hTP = "@resize{w:" + i + ",h:" + i + "}";
            }
            this.hTF[0].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0933a.this.opu != null) {
                        if (C0933a.this.opu.opy != null) {
                            C0933a.this.b(C0933a.this.opu.opy, 0, C0933a.this.opu.type);
                        } else if (C0933a.this.opu.opz != null) {
                            C0933a.this.b(C0933a.this.opu.opz, 0, C0933a.this.opu.type);
                        }
                    }
                }
            });
            this.hTF[1].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0933a.this.opu != null && C0933a.this.opu.opz != null) {
                        C0933a.this.b(C0933a.this.opu.opz, 1, C0933a.this.opu.type);
                    }
                }
            });
        }

        public void a(com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar, int i, int i2, w wVar) {
            boolean z;
            int i3;
            if (aVar != null) {
                this.opu = aVar;
                this.mPosition = i;
                this.opq = i2;
                this.bur = wVar;
                if (aVar.opy != null) {
                    a(aVar.opy, 0, this.opu.type);
                }
                if (aVar.opz != null) {
                    if (aVar.opy == null) {
                        i3 = 0;
                        z = false;
                    } else {
                        i3 = 1;
                        z = true;
                    }
                    a(aVar.opz, i3, this.opu.type);
                } else {
                    z = false;
                }
                if (z) {
                    this.hTF[1].setVisibility(0);
                } else {
                    this.hTF[1].setVisibility(8);
                }
            }
        }

        private void a(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            this.hTG[i].startLoad(alaRecommendLiveData.cover + this.hTP, 10, false);
            this.hTI[i].setText(alaRecommendLiveData.room_name);
            this.hTH[i].setText(String.format(this.mContext.getResources().getString(a.h.recommend_live_audience_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
            if (!TextUtils.isEmpty(alaRecommendLiveData.distance) && !TextUtils.equals(alaRecommendLiveData.distance, "0")) {
                this.hTK[i].setText(alaRecommendLiveData.distance);
                this.hTJ[i].setVisibility(0);
            } else {
                this.hTJ[i].setVisibility(8);
            }
            if (alaRecommendLiveData.corner_tag == 2) {
                this.ops[i].setVisibility(0);
                this.ops[i].setText(this.ops[i].getContext().getResources().getString(a.h.yuyin_dating));
                this.ops[i].setBackgroundResource(a.e.shape_yuyin_dating_bg);
            } else {
                this.ops[i].setVisibility(8);
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
                        } else if (this.opq > 0) {
                            i3 = ((((this.mPosition - 1) - 1) - ((int) ((this.opq / 2) + 0.9f))) * 2) + i2 + 1;
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
