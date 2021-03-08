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
import com.baidu.live.data.ab;
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
/* loaded from: classes10.dex */
public class a extends AbsDelegateAdapter<com.baidu.tieba.yuyinala.liveroom.recommend.data.a, C0941a> {
    private ab bzn;
    private int cardWidth;
    private int oAy;
    private TbPageContext oAz;

    public a(Context context, BdUniqueId bdUniqueId, int i, TbPageContext tbPageContext) {
        super(context, bdUniqueId);
        this.cardWidth = i;
        this.oAz = tbPageContext;
    }

    public void Mm(int i) {
        this.oAy = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: de */
    public C0941a onCreateViewHolder(ViewGroup viewGroup) {
        return new C0941a(LayoutInflater.from(this.mContext).inflate(a.g.ala_yuyin_recommend_live_item_layout, viewGroup, false), this.mContext, this.cardWidth, this.oAz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar, C0941a c0941a) {
        c0941a.a(aVar, i, this.oAy, this.bzn);
        return view;
    }

    public void setAlaLiveShowData(ab abVar) {
        this.bzn = abVar;
    }

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0941a extends TypeAdapter.ViewHolder {
        private ab bzn;
        private RelativeLayout[] ihR;
        private TbImageView[] ihS;
        private TextView[] ihT;
        private TextView[] ihU;
        private LinearLayout[] ihV;
        private TextView[] ihW;
        private String iib;
        private Context mContext;
        private TbPageContext mPageContext;
        private int mPosition;
        private TextView[] oAA;
        private com.baidu.tieba.yuyinala.liveroom.recommend.data.a oAB;
        private int oAy;

        private C0941a(View view, Context context, int i, TbPageContext tbPageContext) {
            super(view);
            this.iib = "";
            this.mContext = context;
            this.mPageContext = tbPageContext;
            this.ihR = new RelativeLayout[2];
            this.ihS = new TbImageView[2];
            this.ihT = new TextView[2];
            this.ihU = new TextView[2];
            this.ihV = new LinearLayout[2];
            this.ihW = new TextView[2];
            this.oAA = new TextView[2];
            this.ihR[0] = (RelativeLayout) view.findViewById(a.f.left_content_layout);
            this.ihR[1] = (RelativeLayout) view.findViewById(a.f.right_content_layout);
            this.ihS[0] = (TbImageView) view.findViewById(a.f.left_cover_imageView);
            this.ihS[1] = (TbImageView) view.findViewById(a.f.right_cover_imageView);
            this.ihT[0] = (TextView) view.findViewById(a.f.left_count_textView);
            this.ihT[1] = (TextView) view.findViewById(a.f.right_count_textView);
            this.ihU[0] = (TextView) view.findViewById(a.f.left_name_textView);
            this.ihU[1] = (TextView) view.findViewById(a.f.right_name_textView);
            this.ihV[0] = (LinearLayout) view.findViewById(a.f.left_location_layout);
            this.ihV[1] = (LinearLayout) view.findViewById(a.f.right_location_layout);
            this.ihW[0] = (TextView) view.findViewById(a.f.left_location_textView);
            this.ihW[1] = (TextView) view.findViewById(a.f.right_location_textView);
            this.oAA[0] = (TextView) view.findViewById(a.f.left_live_label);
            this.oAA[1] = (TextView) view.findViewById(a.f.right_live_label);
            this.ihS[0].getLayoutParams().width = i;
            this.ihS[0].getLayoutParams().height = i;
            this.ihS[1].getLayoutParams().width = i;
            this.ihS[1].getLayoutParams().height = i;
            this.ihS[0].setDefaultBgResource(a.e.sdk_shape_transparent);
            this.ihS[1].setDefaultBgResource(a.e.sdk_shape_transparent);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && i > 0) {
                this.iib = "@resize{w:" + i + ",h:" + i + "}";
            }
            this.ihR[0].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0941a.this.oAB != null) {
                        if (C0941a.this.oAB.oAF != null) {
                            C0941a.this.b(C0941a.this.oAB.oAF, 0, C0941a.this.oAB.type);
                        } else if (C0941a.this.oAB.oAG != null) {
                            C0941a.this.b(C0941a.this.oAB.oAG, 0, C0941a.this.oAB.type);
                        }
                    }
                }
            });
            this.ihR[1].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0941a.this.oAB != null && C0941a.this.oAB.oAG != null) {
                        C0941a.this.b(C0941a.this.oAB.oAG, 1, C0941a.this.oAB.type);
                    }
                }
            });
        }

        public void a(com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar, int i, int i2, ab abVar) {
            boolean z;
            int i3;
            if (aVar != null) {
                this.oAB = aVar;
                this.mPosition = i;
                this.oAy = i2;
                this.bzn = abVar;
                if (aVar.oAF != null) {
                    a(aVar.oAF, 0, this.oAB.type);
                }
                if (aVar.oAG != null) {
                    if (aVar.oAF == null) {
                        i3 = 0;
                        z = false;
                    } else {
                        i3 = 1;
                        z = true;
                    }
                    a(aVar.oAG, i3, this.oAB.type);
                } else {
                    z = false;
                }
                if (z) {
                    this.ihR[1].setVisibility(0);
                } else {
                    this.ihR[1].setVisibility(8);
                }
            }
        }

        private void a(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            this.ihS[i].startLoad(alaRecommendLiveData.cover + this.iib, 10, false);
            this.ihU[i].setText(alaRecommendLiveData.room_name);
            if (alaRecommendLiveData.audience_count > 0) {
                this.ihT[i].setText(String.format(this.mContext.getResources().getString(a.h.recommend_live_audience_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
            }
            if (!TextUtils.isEmpty(alaRecommendLiveData.distance) && !TextUtils.equals(alaRecommendLiveData.distance, "0")) {
                this.ihW[i].setText(alaRecommendLiveData.distance);
                this.ihV[i].setVisibility(0);
            } else {
                this.ihV[i].setVisibility(8);
            }
            if (alaRecommendLiveData.corner_tag == 2) {
                this.oAA[i].setVisibility(0);
                this.oAA[i].setText(this.oAA[i].getContext().getResources().getString(a.h.yuyin_dating));
                this.oAA[i].setBackgroundResource(a.e.shape_yuyin_dating_bg);
            } else {
                this.oAA[i].setVisibility(8);
            }
            a(UbcStatisticLiveKey.KEY_ID_1392, "show", alaRecommendLiveData, i2, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(final AlaRecommendLiveData alaRecommendLiveData, final int i, final int i2) {
            boolean iN = com.baidu.live.ao.a.Ym().iN(ExtraParamsManager.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
            boolean isApplying = com.baidu.live.ao.a.Ym().isApplying();
            if (iN) {
                g gVar = new g(this.mPageContext);
                gVar.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a.a.3
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        C0941a.this.c(alaRecommendLiveData, i, i2);
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
                        C0941a.this.c(alaRecommendLiveData, i, i2);
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
                if (this.bzn != null) {
                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                    if (this.bzn.aKu != null) {
                        alaLastLiveroomInfo.setLastAnchorPortrait(this.bzn.aKu.cover);
                        alaLastLiveroomInfo.setLastAnchorUname(this.bzn.aKu.room_name);
                    }
                    if (this.bzn.mLiveInfo != null) {
                        alaLastLiveroomInfo.setLastLiveId(this.bzn.mLiveInfo.live_id);
                        alaLastLiveroomInfo.setLastRoomId(this.bzn.mLiveInfo.room_id);
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
                        } else if (this.oAy > 0) {
                            i3 = ((((this.mPosition - 1) - 1) - ((int) ((this.oAy / 2) + 0.9f))) * 2) + i2 + 1;
                        } else {
                            i3 = ((this.mPosition - 1) * 2) + i2 + 1;
                        }
                        jSONObject.put("live_id", alaRecommendLiveData.live_id).put("vid", alaRecommendLiveData.feed_id).put("model", i == 0 ? "yourfollower" : "hotlive").put("pos", i3).put("nearby", (i != 1 || TextUtils.isEmpty(alaRecommendLiveData.distance)) ? "0" : "1");
                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                        jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.bzn.aKu.croom_id);
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
