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
public class a extends AbsDelegateAdapter<com.baidu.tieba.yuyinala.liveroom.recommend.data.a, C0916a> {
    private w bph;
    private int cardWidth;
    private int oaq;
    private TbPageContext oar;

    public a(Context context, BdUniqueId bdUniqueId, int i, TbPageContext tbPageContext) {
        super(context, bdUniqueId);
        this.cardWidth = i;
        this.oar = tbPageContext;
    }

    public void MO(int i) {
        this.oaq = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: cP */
    public C0916a onCreateViewHolder(ViewGroup viewGroup) {
        return new C0916a(LayoutInflater.from(this.mContext).inflate(a.g.ala_recommend_live_item_layout, viewGroup, false), this.mContext, this.cardWidth, this.oar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar, C0916a c0916a) {
        c0916a.a(aVar, i, this.oaq, this.bph);
        return view;
    }

    public void setAlaLiveShowData(w wVar) {
        this.bph = wVar;
    }

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0916a extends TypeAdapter.ViewHolder {
        private w bph;
        private String mCc;
        private RelativeLayout[] mCh;
        private TbImageView[] mCi;
        private TextView[] mCj;
        private TextView[] mCk;
        private LinearLayout[] mCl;
        private TextView[] mCm;
        private Context mContext;
        private TbPageContext mPageContext;
        private int mPosition;
        private int oaq;
        private TextView[] oas;
        private com.baidu.tieba.yuyinala.liveroom.recommend.data.a oat;

        private C0916a(View view, Context context, int i, TbPageContext tbPageContext) {
            super(view);
            this.mCc = "";
            this.mContext = context;
            this.mPageContext = tbPageContext;
            this.mCh = new RelativeLayout[2];
            this.mCi = new TbImageView[2];
            this.mCj = new TextView[2];
            this.mCk = new TextView[2];
            this.mCl = new LinearLayout[2];
            this.mCm = new TextView[2];
            this.oas = new TextView[2];
            this.mCh[0] = (RelativeLayout) view.findViewById(a.f.left_content_layout);
            this.mCh[1] = (RelativeLayout) view.findViewById(a.f.right_content_layout);
            this.mCi[0] = (TbImageView) view.findViewById(a.f.left_cover_imageView);
            this.mCi[1] = (TbImageView) view.findViewById(a.f.right_cover_imageView);
            this.mCj[0] = (TextView) view.findViewById(a.f.left_count_textView);
            this.mCj[1] = (TextView) view.findViewById(a.f.right_count_textView);
            this.mCk[0] = (TextView) view.findViewById(a.f.left_name_textView);
            this.mCk[1] = (TextView) view.findViewById(a.f.right_name_textView);
            this.mCl[0] = (LinearLayout) view.findViewById(a.f.left_location_layout);
            this.mCl[1] = (LinearLayout) view.findViewById(a.f.right_location_layout);
            this.mCm[0] = (TextView) view.findViewById(a.f.left_location_textView);
            this.mCm[1] = (TextView) view.findViewById(a.f.right_location_textView);
            this.oas[0] = (TextView) view.findViewById(a.f.left_live_label);
            this.oas[1] = (TextView) view.findViewById(a.f.right_live_label);
            this.mCi[0].getLayoutParams().width = i;
            this.mCi[0].getLayoutParams().height = i;
            this.mCi[1].getLayoutParams().width = i;
            this.mCi[1].getLayoutParams().height = i;
            this.mCi[0].setDefaultBgResource(a.e.sdk_shape_transparent);
            this.mCi[1].setDefaultBgResource(a.e.sdk_shape_transparent);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && i > 0) {
                this.mCc = "@resize{w:" + i + ",h:" + i + "}";
            }
            this.mCh[0].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0916a.this.oat != null) {
                        if (C0916a.this.oat.oax != null) {
                            C0916a.this.b(C0916a.this.oat.oax, 0, C0916a.this.oat.type);
                        } else if (C0916a.this.oat.oay != null) {
                            C0916a.this.b(C0916a.this.oat.oay, 0, C0916a.this.oat.type);
                        }
                    }
                }
            });
            this.mCh[1].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0916a.this.oat != null && C0916a.this.oat.oay != null) {
                        C0916a.this.b(C0916a.this.oat.oay, 1, C0916a.this.oat.type);
                    }
                }
            });
        }

        public void a(com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar, int i, int i2, w wVar) {
            boolean z;
            int i3;
            if (aVar != null) {
                this.oat = aVar;
                this.mPosition = i;
                this.oaq = i2;
                this.bph = wVar;
                if (aVar.oax != null) {
                    a(aVar.oax, 0, this.oat.type);
                }
                if (aVar.oay != null) {
                    if (aVar.oax == null) {
                        i3 = 0;
                        z = false;
                    } else {
                        i3 = 1;
                        z = true;
                    }
                    a(aVar.oay, i3, this.oat.type);
                } else {
                    z = false;
                }
                if (z) {
                    this.mCh[1].setVisibility(0);
                } else {
                    this.mCh[1].setVisibility(8);
                }
            }
        }

        private void a(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            this.mCi[i].startLoad(alaRecommendLiveData.cover + this.mCc, 10, false);
            this.mCk[i].setText(alaRecommendLiveData.room_name);
            this.mCj[i].setText(String.format(this.mContext.getResources().getString(a.h.recommend_live_audience_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
            if (!TextUtils.isEmpty(alaRecommendLiveData.distance) && !TextUtils.equals(alaRecommendLiveData.distance, "0")) {
                this.mCm[i].setText(alaRecommendLiveData.distance);
                this.mCl[i].setVisibility(0);
            } else {
                this.mCl[i].setVisibility(8);
            }
            if (alaRecommendLiveData.corner_tag == 2) {
                this.oas[i].setVisibility(0);
                this.oas[i].setText(this.oas[i].getContext().getResources().getString(a.h.yuyin_dating));
                this.oas[i].setBackgroundResource(a.e.shape_yuyin_dating_bg);
            } else {
                this.oas[i].setVisibility(8);
            }
            a(UbcStatisticLiveKey.KEY_ID_1392, "show", alaRecommendLiveData, i2, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(final AlaRecommendLiveData alaRecommendLiveData, final int i, final int i2) {
            boolean iP = com.baidu.live.al.b.Wy().iP(ExtraParamsManager.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
            boolean isApplying = com.baidu.live.al.b.Wy().isApplying();
            if (iP) {
                g gVar = new g(this.mPageContext);
                gVar.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a.a.3
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        C0916a.this.c(alaRecommendLiveData, i, i2);
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
                        C0916a.this.c(alaRecommendLiveData, i, i2);
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
                if (this.bph != null) {
                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                    if (this.bph.aHZ != null) {
                        alaLastLiveroomInfo.setLastAnchorPortrait(this.bph.aHZ.cover);
                        alaLastLiveroomInfo.setLastAnchorUname(this.bph.aHZ.room_name);
                    }
                    if (this.bph.mLiveInfo != null) {
                        alaLastLiveroomInfo.setLastLiveId(this.bph.mLiveInfo.live_id);
                        alaLastLiveroomInfo.setLastRoomId(this.bph.mLiveInfo.room_id);
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
                        } else if (this.oaq > 0) {
                            i3 = ((((this.mPosition - 1) - 1) - ((int) ((this.oaq / 2) + 0.9f))) * 2) + i2 + 1;
                        } else {
                            i3 = ((this.mPosition - 1) * 2) + i2 + 1;
                        }
                        jSONObject.put("live_id", alaRecommendLiveData.live_id).put("vid", alaRecommendLiveData.feed_id).put("model", i == 0 ? "yourfollower" : "hotlive").put("pos", i3).put("nearby", (i != 1 || TextUtils.isEmpty(alaRecommendLiveData.distance)) ? "0" : "1");
                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                        jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.bph.aHZ.croom_id);
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
