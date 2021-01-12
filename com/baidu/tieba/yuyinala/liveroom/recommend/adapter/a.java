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
import com.baidu.live.data.x;
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
public class a extends AbsDelegateAdapter<com.baidu.tieba.yuyinala.liveroom.recommend.data.a, C0929a> {
    private x buq;
    private int cardWidth;
    private int ooc;
    private TbPageContext ood;

    public a(Context context, BdUniqueId bdUniqueId, int i, TbPageContext tbPageContext) {
        super(context, bdUniqueId);
        this.cardWidth = i;
        this.ood = tbPageContext;
    }

    public void LM(int i) {
        this.ooc = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: df */
    public C0929a onCreateViewHolder(ViewGroup viewGroup) {
        return new C0929a(LayoutInflater.from(this.mContext).inflate(a.g.ala_recommend_live_item_layout, viewGroup, false), this.mContext, this.cardWidth, this.ood);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar, C0929a c0929a) {
        c0929a.a(aVar, i, this.ooc, this.buq);
        return view;
    }

    public void setAlaLiveShowData(x xVar) {
        this.buq = xVar;
    }

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0929a extends TypeAdapter.ViewHolder {
        private x buq;
        private LinearLayout[] ibA;
        private TextView[] ibB;
        private String ibG;
        private RelativeLayout[] ibw;
        private TbImageView[] ibx;
        private TextView[] iby;
        private TextView[] ibz;
        private Context mContext;
        private TbPageContext mPageContext;
        private int mPosition;
        private int ooc;
        private TextView[] ooe;
        private com.baidu.tieba.yuyinala.liveroom.recommend.data.a oof;

        private C0929a(View view, Context context, int i, TbPageContext tbPageContext) {
            super(view);
            this.ibG = "";
            this.mContext = context;
            this.mPageContext = tbPageContext;
            this.ibw = new RelativeLayout[2];
            this.ibx = new TbImageView[2];
            this.iby = new TextView[2];
            this.ibz = new TextView[2];
            this.ibA = new LinearLayout[2];
            this.ibB = new TextView[2];
            this.ooe = new TextView[2];
            this.ibw[0] = (RelativeLayout) view.findViewById(a.f.left_content_layout);
            this.ibw[1] = (RelativeLayout) view.findViewById(a.f.right_content_layout);
            this.ibx[0] = (TbImageView) view.findViewById(a.f.left_cover_imageView);
            this.ibx[1] = (TbImageView) view.findViewById(a.f.right_cover_imageView);
            this.iby[0] = (TextView) view.findViewById(a.f.left_count_textView);
            this.iby[1] = (TextView) view.findViewById(a.f.right_count_textView);
            this.ibz[0] = (TextView) view.findViewById(a.f.left_name_textView);
            this.ibz[1] = (TextView) view.findViewById(a.f.right_name_textView);
            this.ibA[0] = (LinearLayout) view.findViewById(a.f.left_location_layout);
            this.ibA[1] = (LinearLayout) view.findViewById(a.f.right_location_layout);
            this.ibB[0] = (TextView) view.findViewById(a.f.left_location_textView);
            this.ibB[1] = (TextView) view.findViewById(a.f.right_location_textView);
            this.ooe[0] = (TextView) view.findViewById(a.f.left_live_label);
            this.ooe[1] = (TextView) view.findViewById(a.f.right_live_label);
            this.ibx[0].getLayoutParams().width = i;
            this.ibx[0].getLayoutParams().height = i;
            this.ibx[1].getLayoutParams().width = i;
            this.ibx[1].getLayoutParams().height = i;
            this.ibx[0].setDefaultBgResource(a.e.sdk_shape_transparent);
            this.ibx[1].setDefaultBgResource(a.e.sdk_shape_transparent);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && i > 0) {
                this.ibG = "@resize{w:" + i + ",h:" + i + "}";
            }
            this.ibw[0].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0929a.this.oof != null) {
                        if (C0929a.this.oof.ooj != null) {
                            C0929a.this.b(C0929a.this.oof.ooj, 0, C0929a.this.oof.type);
                        } else if (C0929a.this.oof.ook != null) {
                            C0929a.this.b(C0929a.this.oof.ook, 0, C0929a.this.oof.type);
                        }
                    }
                }
            });
            this.ibw[1].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0929a.this.oof != null && C0929a.this.oof.ook != null) {
                        C0929a.this.b(C0929a.this.oof.ook, 1, C0929a.this.oof.type);
                    }
                }
            });
        }

        public void a(com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar, int i, int i2, x xVar) {
            boolean z;
            int i3;
            if (aVar != null) {
                this.oof = aVar;
                this.mPosition = i;
                this.ooc = i2;
                this.buq = xVar;
                if (aVar.ooj != null) {
                    a(aVar.ooj, 0, this.oof.type);
                }
                if (aVar.ook != null) {
                    if (aVar.ooj == null) {
                        i3 = 0;
                        z = false;
                    } else {
                        i3 = 1;
                        z = true;
                    }
                    a(aVar.ook, i3, this.oof.type);
                } else {
                    z = false;
                }
                if (z) {
                    this.ibw[1].setVisibility(0);
                } else {
                    this.ibw[1].setVisibility(8);
                }
            }
        }

        private void a(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            this.ibx[i].startLoad(alaRecommendLiveData.cover + this.ibG, 10, false);
            this.ibz[i].setText(alaRecommendLiveData.room_name);
            this.iby[i].setText(String.format(this.mContext.getResources().getString(a.h.recommend_live_audience_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
            if (!TextUtils.isEmpty(alaRecommendLiveData.distance) && !TextUtils.equals(alaRecommendLiveData.distance, "0")) {
                this.ibB[i].setText(alaRecommendLiveData.distance);
                this.ibA[i].setVisibility(0);
            } else {
                this.ibA[i].setVisibility(8);
            }
            if (alaRecommendLiveData.corner_tag == 2) {
                this.ooe[i].setVisibility(0);
                this.ooe[i].setText(this.ooe[i].getContext().getResources().getString(a.h.yuyin_dating));
                this.ooe[i].setBackgroundResource(a.e.shape_yuyin_dating_bg);
            } else {
                this.ooe[i].setVisibility(8);
            }
            a(UbcStatisticLiveKey.KEY_ID_1392, "show", alaRecommendLiveData, i2, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(final AlaRecommendLiveData alaRecommendLiveData, final int i, final int i2) {
            boolean ib = com.baidu.live.aq.a.Wu().ib(ExtraParamsManager.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
            boolean isApplying = com.baidu.live.aq.a.Wu().isApplying();
            if (ib) {
                g gVar = new g(this.mPageContext);
                gVar.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a.a.3
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        C0929a.this.c(alaRecommendLiveData, i, i2);
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
                        C0929a.this.c(alaRecommendLiveData, i, i2);
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
                if (this.buq != null) {
                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                    if (this.buq.aGy != null) {
                        alaLastLiveroomInfo.setLastAnchorPortrait(this.buq.aGy.cover);
                        alaLastLiveroomInfo.setLastAnchorUname(this.buq.aGy.room_name);
                    }
                    if (this.buq.mLiveInfo != null) {
                        alaLastLiveroomInfo.setLastLiveId(this.buq.mLiveInfo.live_id);
                        alaLastLiveroomInfo.setLastRoomId(this.buq.mLiveInfo.room_id);
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
                        } else if (this.ooc > 0) {
                            i3 = ((((this.mPosition - 1) - 1) - ((int) ((this.ooc / 2) + 0.9f))) * 2) + i2 + 1;
                        } else {
                            i3 = ((this.mPosition - 1) * 2) + i2 + 1;
                        }
                        jSONObject.put("live_id", alaRecommendLiveData.live_id).put("vid", alaRecommendLiveData.feed_id).put("model", i == 0 ? "yourfollower" : "hotlive").put("pos", i3).put("nearby", (i != 1 || TextUtils.isEmpty(alaRecommendLiveData.distance)) ? "0" : "1");
                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                        jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.buq.aGy.croom_id);
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
