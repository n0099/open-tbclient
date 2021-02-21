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
/* loaded from: classes11.dex */
public class a extends AbsDelegateAdapter<com.baidu.tieba.yuyinala.liveroom.recommend.data.a, C0935a> {
    private ab bxN;
    private int cardWidth;
    private int oyt;
    private TbPageContext oyu;

    public a(Context context, BdUniqueId bdUniqueId, int i, TbPageContext tbPageContext) {
        super(context, bdUniqueId);
        this.cardWidth = i;
        this.oyu = tbPageContext;
    }

    public void Mi(int i) {
        this.oyt = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: df */
    public C0935a onCreateViewHolder(ViewGroup viewGroup) {
        return new C0935a(LayoutInflater.from(this.mContext).inflate(a.g.ala_yuyin_recommend_live_item_layout, viewGroup, false), this.mContext, this.cardWidth, this.oyu);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar, C0935a c0935a) {
        c0935a.a(aVar, i, this.oyt, this.bxN);
        return view;
    }

    public void setAlaLiveShowData(ab abVar) {
        this.bxN = abVar;
    }

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0935a extends TypeAdapter.ViewHolder {
        private ab bxN;
        private RelativeLayout[] igi;
        private TbImageView[] igj;
        private TextView[] igk;
        private TextView[] igl;
        private LinearLayout[] igm;
        private TextView[] ign;
        private String igs;
        private Context mContext;
        private TbPageContext mPageContext;
        private int mPosition;
        private int oyt;
        private TextView[] oyv;
        private com.baidu.tieba.yuyinala.liveroom.recommend.data.a oyw;

        private C0935a(View view, Context context, int i, TbPageContext tbPageContext) {
            super(view);
            this.igs = "";
            this.mContext = context;
            this.mPageContext = tbPageContext;
            this.igi = new RelativeLayout[2];
            this.igj = new TbImageView[2];
            this.igk = new TextView[2];
            this.igl = new TextView[2];
            this.igm = new LinearLayout[2];
            this.ign = new TextView[2];
            this.oyv = new TextView[2];
            this.igi[0] = (RelativeLayout) view.findViewById(a.f.left_content_layout);
            this.igi[1] = (RelativeLayout) view.findViewById(a.f.right_content_layout);
            this.igj[0] = (TbImageView) view.findViewById(a.f.left_cover_imageView);
            this.igj[1] = (TbImageView) view.findViewById(a.f.right_cover_imageView);
            this.igk[0] = (TextView) view.findViewById(a.f.left_count_textView);
            this.igk[1] = (TextView) view.findViewById(a.f.right_count_textView);
            this.igl[0] = (TextView) view.findViewById(a.f.left_name_textView);
            this.igl[1] = (TextView) view.findViewById(a.f.right_name_textView);
            this.igm[0] = (LinearLayout) view.findViewById(a.f.left_location_layout);
            this.igm[1] = (LinearLayout) view.findViewById(a.f.right_location_layout);
            this.ign[0] = (TextView) view.findViewById(a.f.left_location_textView);
            this.ign[1] = (TextView) view.findViewById(a.f.right_location_textView);
            this.oyv[0] = (TextView) view.findViewById(a.f.left_live_label);
            this.oyv[1] = (TextView) view.findViewById(a.f.right_live_label);
            this.igj[0].getLayoutParams().width = i;
            this.igj[0].getLayoutParams().height = i;
            this.igj[1].getLayoutParams().width = i;
            this.igj[1].getLayoutParams().height = i;
            this.igj[0].setDefaultBgResource(a.e.sdk_shape_transparent);
            this.igj[1].setDefaultBgResource(a.e.sdk_shape_transparent);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && i > 0) {
                this.igs = "@resize{w:" + i + ",h:" + i + "}";
            }
            this.igi[0].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0935a.this.oyw != null) {
                        if (C0935a.this.oyw.oyA != null) {
                            C0935a.this.b(C0935a.this.oyw.oyA, 0, C0935a.this.oyw.type);
                        } else if (C0935a.this.oyw.oyB != null) {
                            C0935a.this.b(C0935a.this.oyw.oyB, 0, C0935a.this.oyw.type);
                        }
                    }
                }
            });
            this.igi[1].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0935a.this.oyw != null && C0935a.this.oyw.oyB != null) {
                        C0935a.this.b(C0935a.this.oyw.oyB, 1, C0935a.this.oyw.type);
                    }
                }
            });
        }

        public void a(com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar, int i, int i2, ab abVar) {
            boolean z;
            int i3;
            if (aVar != null) {
                this.oyw = aVar;
                this.mPosition = i;
                this.oyt = i2;
                this.bxN = abVar;
                if (aVar.oyA != null) {
                    a(aVar.oyA, 0, this.oyw.type);
                }
                if (aVar.oyB != null) {
                    if (aVar.oyA == null) {
                        i3 = 0;
                        z = false;
                    } else {
                        i3 = 1;
                        z = true;
                    }
                    a(aVar.oyB, i3, this.oyw.type);
                } else {
                    z = false;
                }
                if (z) {
                    this.igi[1].setVisibility(0);
                } else {
                    this.igi[1].setVisibility(8);
                }
            }
        }

        private void a(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            this.igj[i].startLoad(alaRecommendLiveData.cover + this.igs, 10, false);
            this.igl[i].setText(alaRecommendLiveData.room_name);
            if (alaRecommendLiveData.audience_count > 0) {
                this.igk[i].setText(String.format(this.mContext.getResources().getString(a.h.recommend_live_audience_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
            }
            if (!TextUtils.isEmpty(alaRecommendLiveData.distance) && !TextUtils.equals(alaRecommendLiveData.distance, "0")) {
                this.ign[i].setText(alaRecommendLiveData.distance);
                this.igm[i].setVisibility(0);
            } else {
                this.igm[i].setVisibility(8);
            }
            if (alaRecommendLiveData.corner_tag == 2) {
                this.oyv[i].setVisibility(0);
                this.oyv[i].setText(this.oyv[i].getContext().getResources().getString(a.h.yuyin_dating));
                this.oyv[i].setBackgroundResource(a.e.shape_yuyin_dating_bg);
            } else {
                this.oyv[i].setVisibility(8);
            }
            a(UbcStatisticLiveKey.KEY_ID_1392, "show", alaRecommendLiveData, i2, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(final AlaRecommendLiveData alaRecommendLiveData, final int i, final int i2) {
            boolean iH = com.baidu.live.ao.a.Yj().iH(ExtraParamsManager.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
            boolean isApplying = com.baidu.live.ao.a.Yj().isApplying();
            if (iH) {
                g gVar = new g(this.mPageContext);
                gVar.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a.a.3
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        C0935a.this.c(alaRecommendLiveData, i, i2);
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
                        C0935a.this.c(alaRecommendLiveData, i, i2);
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
                if (this.bxN != null) {
                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                    if (this.bxN.aIU != null) {
                        alaLastLiveroomInfo.setLastAnchorPortrait(this.bxN.aIU.cover);
                        alaLastLiveroomInfo.setLastAnchorUname(this.bxN.aIU.room_name);
                    }
                    if (this.bxN.mLiveInfo != null) {
                        alaLastLiveroomInfo.setLastLiveId(this.bxN.mLiveInfo.live_id);
                        alaLastLiveroomInfo.setLastRoomId(this.bxN.mLiveInfo.room_id);
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
                        } else if (this.oyt > 0) {
                            i3 = ((((this.mPosition - 1) - 1) - ((int) ((this.oyt / 2) + 0.9f))) * 2) + i2 + 1;
                        } else {
                            i3 = ((this.mPosition - 1) * 2) + i2 + 1;
                        }
                        jSONObject.put("live_id", alaRecommendLiveData.live_id).put("vid", alaRecommendLiveData.feed_id).put("model", i == 0 ? "yourfollower" : "hotlive").put("pos", i3).put("nearby", (i != 1 || TextUtils.isEmpty(alaRecommendLiveData.distance)) ? "0" : "1");
                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                        jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.bxN.aIU.croom_id);
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
