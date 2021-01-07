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
/* loaded from: classes11.dex */
public class a extends AbsDelegateAdapter<com.baidu.tieba.yuyinala.liveroom.recommend.data.a, C0946a> {
    private x bzc;
    private int cardWidth;
    private int osJ;
    private TbPageContext osK;

    public a(Context context, BdUniqueId bdUniqueId, int i, TbPageContext tbPageContext) {
        super(context, bdUniqueId);
        this.cardWidth = i;
        this.osK = tbPageContext;
    }

    public void Nt(int i) {
        this.osJ = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: df */
    public C0946a onCreateViewHolder(ViewGroup viewGroup) {
        return new C0946a(LayoutInflater.from(this.mContext).inflate(a.g.ala_recommend_live_item_layout, viewGroup, false), this.mContext, this.cardWidth, this.osK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.adp.widget.listview.AbsDelegateAdapter
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar, C0946a c0946a) {
        c0946a.a(aVar, i, this.osJ, this.bzc);
        return view;
    }

    public void setAlaLiveShowData(x xVar) {
        this.bzc = xVar;
    }

    /* renamed from: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0946a extends TypeAdapter.ViewHolder {
        private x bzc;
        private RelativeLayout[] igh;
        private TbImageView[] igi;
        private TextView[] igj;
        private TextView[] igk;
        private LinearLayout[] igl;
        private TextView[] igm;
        private String igr;
        private Context mContext;
        private TbPageContext mPageContext;
        private int mPosition;
        private int osJ;
        private TextView[] osL;
        private com.baidu.tieba.yuyinala.liveroom.recommend.data.a osM;

        private C0946a(View view, Context context, int i, TbPageContext tbPageContext) {
            super(view);
            this.igr = "";
            this.mContext = context;
            this.mPageContext = tbPageContext;
            this.igh = new RelativeLayout[2];
            this.igi = new TbImageView[2];
            this.igj = new TextView[2];
            this.igk = new TextView[2];
            this.igl = new LinearLayout[2];
            this.igm = new TextView[2];
            this.osL = new TextView[2];
            this.igh[0] = (RelativeLayout) view.findViewById(a.f.left_content_layout);
            this.igh[1] = (RelativeLayout) view.findViewById(a.f.right_content_layout);
            this.igi[0] = (TbImageView) view.findViewById(a.f.left_cover_imageView);
            this.igi[1] = (TbImageView) view.findViewById(a.f.right_cover_imageView);
            this.igj[0] = (TextView) view.findViewById(a.f.left_count_textView);
            this.igj[1] = (TextView) view.findViewById(a.f.right_count_textView);
            this.igk[0] = (TextView) view.findViewById(a.f.left_name_textView);
            this.igk[1] = (TextView) view.findViewById(a.f.right_name_textView);
            this.igl[0] = (LinearLayout) view.findViewById(a.f.left_location_layout);
            this.igl[1] = (LinearLayout) view.findViewById(a.f.right_location_layout);
            this.igm[0] = (TextView) view.findViewById(a.f.left_location_textView);
            this.igm[1] = (TextView) view.findViewById(a.f.right_location_textView);
            this.osL[0] = (TextView) view.findViewById(a.f.left_live_label);
            this.osL[1] = (TextView) view.findViewById(a.f.right_live_label);
            this.igi[0].getLayoutParams().width = i;
            this.igi[0].getLayoutParams().height = i;
            this.igi[1].getLayoutParams().width = i;
            this.igi[1].getLayoutParams().height = i;
            this.igi[0].setDefaultBgResource(a.e.sdk_shape_transparent);
            this.igi[1].setDefaultBgResource(a.e.sdk_shape_transparent);
            if (!TbadkCoreApplication.getInst().isMobileBaidu() && i > 0) {
                this.igr = "@resize{w:" + i + ",h:" + i + "}";
            }
            this.igh[0].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0946a.this.osM != null) {
                        if (C0946a.this.osM.osQ != null) {
                            C0946a.this.b(C0946a.this.osM.osQ, 0, C0946a.this.osM.type);
                        } else if (C0946a.this.osM.osR != null) {
                            C0946a.this.b(C0946a.this.osM.osR, 0, C0946a.this.osM.type);
                        }
                    }
                }
            });
            this.igh[1].setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (C0946a.this.osM != null && C0946a.this.osM.osR != null) {
                        C0946a.this.b(C0946a.this.osM.osR, 1, C0946a.this.osM.type);
                    }
                }
            });
        }

        public void a(com.baidu.tieba.yuyinala.liveroom.recommend.data.a aVar, int i, int i2, x xVar) {
            boolean z;
            int i3;
            if (aVar != null) {
                this.osM = aVar;
                this.mPosition = i;
                this.osJ = i2;
                this.bzc = xVar;
                if (aVar.osQ != null) {
                    a(aVar.osQ, 0, this.osM.type);
                }
                if (aVar.osR != null) {
                    if (aVar.osQ == null) {
                        i3 = 0;
                        z = false;
                    } else {
                        i3 = 1;
                        z = true;
                    }
                    a(aVar.osR, i3, this.osM.type);
                } else {
                    z = false;
                }
                if (z) {
                    this.igh[1].setVisibility(0);
                } else {
                    this.igh[1].setVisibility(8);
                }
            }
        }

        private void a(AlaRecommendLiveData alaRecommendLiveData, int i, int i2) {
            this.igi[i].startLoad(alaRecommendLiveData.cover + this.igr, 10, false);
            this.igk[i].setText(alaRecommendLiveData.room_name);
            this.igj[i].setText(String.format(this.mContext.getResources().getString(a.h.recommend_live_audience_count), StringHelper.formatValue(alaRecommendLiveData.audience_count)));
            if (!TextUtils.isEmpty(alaRecommendLiveData.distance) && !TextUtils.equals(alaRecommendLiveData.distance, "0")) {
                this.igm[i].setText(alaRecommendLiveData.distance);
                this.igl[i].setVisibility(0);
            } else {
                this.igl[i].setVisibility(8);
            }
            if (alaRecommendLiveData.corner_tag == 2) {
                this.osL[i].setVisibility(0);
                this.osL[i].setText(this.osL[i].getContext().getResources().getString(a.h.yuyin_dating));
                this.osL[i].setBackgroundResource(a.e.shape_yuyin_dating_bg);
            } else {
                this.osL[i].setVisibility(8);
            }
            a(UbcStatisticLiveKey.KEY_ID_1392, "show", alaRecommendLiveData, i2, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(final AlaRecommendLiveData alaRecommendLiveData, final int i, final int i2) {
            boolean jm = com.baidu.live.aq.a.aan().jm(ExtraParamsManager.getEncryptionUserId(String.valueOf(TbadkCoreApplication.getCurrentAccountId())));
            boolean isApplying = com.baidu.live.aq.a.aan().isApplying();
            if (jm) {
                g gVar = new g(this.mPageContext);
                gVar.a(new g.a() { // from class: com.baidu.tieba.yuyinala.liveroom.recommend.adapter.a.a.3
                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onCancel() {
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.dialog.g.a
                    public void onConfirm() {
                        C0946a.this.c(alaRecommendLiveData, i, i2);
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
                        C0946a.this.c(alaRecommendLiveData, i, i2);
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
                if (this.bzc != null) {
                    AlaLastLiveroomInfo alaLastLiveroomInfo = new AlaLastLiveroomInfo();
                    if (this.bzc.aLl != null) {
                        alaLastLiveroomInfo.setLastAnchorPortrait(this.bzc.aLl.cover);
                        alaLastLiveroomInfo.setLastAnchorUname(this.bzc.aLl.room_name);
                    }
                    if (this.bzc.mLiveInfo != null) {
                        alaLastLiveroomInfo.setLastLiveId(this.bzc.mLiveInfo.live_id);
                        alaLastLiveroomInfo.setLastRoomId(this.bzc.mLiveInfo.room_id);
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
                        } else if (this.osJ > 0) {
                            i3 = ((((this.mPosition - 1) - 1) - ((int) ((this.osJ / 2) + 0.9f))) * 2) + i2 + 1;
                        } else {
                            i3 = ((this.mPosition - 1) * 2) + i2 + 1;
                        }
                        jSONObject.put("live_id", alaRecommendLiveData.live_id).put("vid", alaRecommendLiveData.feed_id).put("model", i == 0 ? "yourfollower" : "hotlive").put("pos", i3).put("nearby", (i != 1 || TextUtils.isEmpty(alaRecommendLiveData.distance)) ? "0" : "1");
                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                        jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.bzc.aLl.croom_id);
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
