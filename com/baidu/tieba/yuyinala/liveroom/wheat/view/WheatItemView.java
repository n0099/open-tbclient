package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLivePhoneMarkData;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.live.tieba.view.AlaEmoticonView;
import com.baidu.live.tieba.view.fresco.SimpleDraweeView;
import com.baidu.tieba.yuyinala.liveroom.publishlover.PublishLoverHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.publishlover.b;
import com.baidu.tieba.yuyinala.liveroom.wheat.e.e;
import com.baidu.tieba.yuyinala.liveroom.wheat.e.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.PublishLoverView;
/* loaded from: classes11.dex */
public class WheatItemView extends BaseWheatItemView {
    private TextView gDt;
    private TextView gOq;
    private HeadImageView oHG;
    private SimpleDraweeView oKV;
    private PublishLoverView oLY;
    private View oLZ;
    private SimpleDraweeView oLf;
    private TBLottieAnimationView oLg;
    private RelativeLayout oLh;
    private ImageView oLi;
    private ImageView oLj;
    private AlaEmoticonView oLk;
    private ImageView oMa;
    private a oMb;
    private RelativeLayout oMc;
    private RelativeLayout oMd;
    private TextView oMe;
    private TextView oMf;
    private LinearLayout oMg;
    private String oMh;

    /* loaded from: classes11.dex */
    public interface a {
        void WH(String str);
    }

    public WheatItemView(@NonNull Context context) {
        this(context, null);
    }

    public WheatItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WheatItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatItemView
    protected void initView() {
        this.oHG = (HeadImageView) findViewById(a.f.user_avatar);
        this.oLh = (RelativeLayout) findViewById(a.f.user_avatar_container);
        this.oLk = (AlaEmoticonView) findViewById(a.f.ala_emoticon_view);
        this.oLf = (SimpleDraweeView) findViewById(a.f.hat_emoticon_iv);
        this.oKV = (SimpleDraweeView) findViewById(a.f.frame_emoticon_iv);
        this.gDt = (TextView) findViewById(a.f.anchor_name);
        this.oLi = (ImageView) findViewById(a.f.iv_user_gender);
        this.oMa = (ImageView) findViewById(a.f.iv_charm_icon);
        this.gOq = (TextView) findViewById(a.f.tv_charm_value);
        this.oMc = (RelativeLayout) findViewById(a.f.anchor_name_container);
        this.oMd = (RelativeLayout) findViewById(a.f.user_label);
        this.oMe = (TextView) findViewById(a.f.tv_host_label);
        this.oMf = (TextView) findViewById(a.f.tv_anchor_label);
        this.oMg = (LinearLayout) findViewById(a.f.charm_container);
        this.oLj = (ImageView) findViewById(a.f.iv_mute);
        this.oLg = (TBLottieAnimationView) findViewById(a.f.speeding_lottieAnimationView);
        this.oLY = (PublishLoverView) findViewById(a.f.view_pubish_lover);
        this.oLZ = findViewById(a.f.view_choose_lover);
        this.oLZ.setVisibility(8);
        this.oLY.setVisibility(4);
        this.oLY.setOnPublishClickListener(new PublishLoverView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.PublishLoverView.a
            public void onClick() {
                b bVar = new b(WheatItemView.this.getContext());
                bVar.m(g.Yp(), WheatItemView.this.oKh.uk, g.av(WheatItemView.this.bxN), g.au(WheatItemView.this.bxN));
                bVar.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.1.1
                    @Override // com.baidu.tieba.yuyinala.liveroom.publishlover.b.a
                    public void a(PublishLoverHttpResponseMessage publishLoverHttpResponseMessage) {
                        BdUtilHelper.showToast(WheatItemView.this.getContext(), "操作成功");
                        WheatItemView.this.oLY.efb();
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.publishlover.b.a
                    public void onFail(int i, String str) {
                        BdUtilHelper.showToast(WheatItemView.this.getContext(), "操作失败，请重试");
                    }
                });
            }
        });
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatItemView
    protected int getLayoutViewId() {
        return a.g.yuyinala_liveroom_wheat_item_layout;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatItemView
    public void setData(final AlaWheatInfoData alaWheatInfoData, int i, final boolean z, ab abVar) {
        String str;
        this.gDt.setText("");
        this.gOq.setText("");
        this.oKh = alaWheatInfoData;
        this.bxN = abVar;
        a(z, abVar);
        if (this.oKh == null) {
            this.oMd.setVisibility(8);
            if (this.oLg.getVisibility() == 0) {
                this.oLg.cancelAnimation();
                this.oLg.setVisibility(8);
            }
            this.oLi.setSelected(false);
            this.oLi.setVisibility(8);
            this.oHG.setIsRound(false);
            this.oHG.setDrawBorder(false);
            this.oHG.setAutoChangeStyle(false);
            this.oHG.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.oHG.setImageResource(a.e.yuyin_sdk_wheat_empty_wheat);
            if (efu()) {
                this.oHG.setBackgroundResource(a.e.yuyin_sdk_wheat_dating_bg_2);
            } else {
                this.oHG.setBackgroundResource(a.e.yuyin_sdk_connection_wheat_empty);
            }
            if (z) {
                this.gDt.setText(getContext().getResources().getString(a.h.yuyin_ala_connection_wheat_host_wheat_text));
            } else if (isResultsStage()) {
                AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) ListUtils.getItem(this.bxN.aIY.getAnchorWheatBackupLists(), i);
                if (alaWheatInfoData2 != null && alaWheatInfoData2.status == 1) {
                    this.oHG.setImageResource(a.e.yuyin_sdk_unconnect_wheat);
                }
                this.gDt.setText((i + 1) + getContext().getResources().getString(a.h.yuyin_ala_connection_wheat_num_text));
            } else if (isSweetStage()) {
                AlaWheatInfoData alaWheatInfoData3 = (AlaWheatInfoData) ListUtils.getItem(this.bxN.aIY.getAnchorWheatBackupLists(), i);
                if (alaWheatInfoData3 != null && alaWheatInfoData3.status == 1) {
                    this.oHG.setImageResource(a.e.yuyin_sdk_unconnect_wheat);
                }
                if (alaWheatInfoData3 != null) {
                    this.gDt.setText(alaWheatInfoData3.phone_order + getContext().getResources().getString(a.h.yuyin_ala_connection_wheat_num_text));
                } else {
                    this.gDt.setText((i + 1) + getContext().getResources().getString(a.h.yuyin_ala_connection_wheat_num_text));
                }
            } else {
                this.gDt.setText((i + 1) + getContext().getResources().getString(a.h.yuyin_ala_connection_wheat_num_text));
            }
            this.gDt.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha70));
            this.oMg.setVisibility(8);
            this.oLh.setTag(Integer.valueOf(i));
            this.oLj.setVisibility(8);
            this.oLf.setVisibility(8);
            this.oKV.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.oMc.getLayoutParams();
            layoutParams.topMargin = e.d(12.0f, getContext());
            this.oMc.setLayoutParams(layoutParams);
        } else {
            this.oMd.setVisibility(0);
            this.gDt.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
            this.oLi.setVisibility(0);
            this.oLi.setSelected(alaWheatInfoData.isFemale());
            this.oMa.setImageResource(alaWheatInfoData.isFemale() ? a.e.yuyin_sdk_wheat_heartbeat_female_value : a.e.yuyin_sdk_wheat_heartbeat_male_value);
            this.oHG.setScaleType(ImageView.ScaleType.FIT_XY);
            this.oHG.setImageResource(0);
            this.oHG.setBackgroundResource(0);
            this.oHG.setIsRound(true);
            this.oHG.setDrawBorder(false);
            this.oHG.setAutoChangeStyle(false);
            this.oHG.setDefaultResource(a.e.sdk_icon_default_avatar100);
            if (efu()) {
                this.oHG.setDefaultBgResource(a.e.yuyin_sdk_wheat_dating_bg_2);
            } else {
                this.oHG.setDefaultBgResource(a.e.yuyin_sdk_connection_wheat_empty);
            }
            this.oHG.setUrl(alaWheatInfoData.bigPortrait);
            this.oHG.startLoad(alaWheatInfoData.bigPortrait, 12, false, false);
            if (alaWheatInfoData.isOpenMike()) {
                this.oLj.setVisibility(8);
            } else {
                if (this.oLg.getVisibility() == 0) {
                    this.oLg.cancelAnimation();
                    this.oLg.setVisibility(8);
                }
                this.oLj.setVisibility(0);
            }
            this.oMg.setVisibility(0);
            this.gOq.setText(alaWheatInfoData.charmCount);
            if (z) {
                this.oMe.setVisibility(0);
                this.oMf.setVisibility(8);
                this.gDt.setText(alaWheatInfoData.userName);
            } else {
                this.oMe.setVisibility(8);
                this.oMf.setVisibility(0);
                if (isSweetStage()) {
                    this.oMf.setText(Integer.toString(alaWheatInfoData.phone_order));
                } else {
                    this.oMf.setText(Integer.toString(i + 1));
                }
                this.gDt.setText(alaWheatInfoData.userName);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.oMc.getLayoutParams();
            layoutParams2.topMargin = e.d(12.5f, getContext());
            this.oMc.setLayoutParams(layoutParams2);
            String str2 = "";
            if (!TextUtils.isEmpty(alaWheatInfoData.hatLevelIcon)) {
                String str3 = alaWheatInfoData.hatLevelIcon;
                str2 = alaWheatInfoData.hatLevelIcon;
                str = str3;
            } else if (TextUtils.isEmpty(alaWheatInfoData.hatLowIcon)) {
                str = "";
            } else {
                str2 = alaWheatInfoData.hatLowIcon;
                str = "isHatLowIcon";
            }
            if (TextUtils.isEmpty(str2)) {
                this.oLf.setVisibility(8);
            } else {
                String str4 = (String) this.oLf.getTag();
                if (this.oLf.getVisibility() != 0 || !str.equals(str4)) {
                    this.oLf.setVisibility(0);
                    a(this.oLf, str2);
                    this.oLf.setTag(str);
                }
            }
            AlaLivePhoneMarkData alaLivePhoneMarkData = alaWheatInfoData.getAlaLivePhoneMarkData(1);
            if (alaLivePhoneMarkData == null || TextUtils.isEmpty(alaLivePhoneMarkData.icon)) {
                this.oKV.setVisibility(8);
            } else {
                String str5 = (String) this.oKV.getTag();
                if (this.oKV.getVisibility() != 0 || !alaLivePhoneMarkData.icon.equals(str5)) {
                    this.oKV.setVisibility(0);
                    a(this.oKV, alaLivePhoneMarkData.icon);
                    this.oKV.setTag(alaLivePhoneMarkData.icon);
                }
            }
            this.oLh.setTag(Integer.valueOf(i));
        }
        this.oLh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (WheatItemView.this.oKi != null) {
                    if (WheatItemView.this.bxN != null && WheatItemView.this.bxN.aJo) {
                        WheatItemView.this.oKi.a(alaWheatInfoData, z, intValue);
                    } else {
                        BdUtilHelper.showToast(WheatItemView.this.getContext(), "正在获取数据，请稍等");
                    }
                }
            }
        });
        if (!TextUtils.isEmpty(this.oMh) && !this.oMh.equals(abVar.aIU.live_id)) {
            this.oLk.setVisibility(8);
        }
        this.oLk.setEmoticonListener(new AlaEmoticonView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.3
            @Override // com.baidu.live.tieba.view.AlaEmoticonView.a
            public void Ue() {
                int i2;
                if (!(WheatItemView.this.oLk.getTag() instanceof String) || StringUtils.isNull((String) WheatItemView.this.oLk.getTag(), true)) {
                    i2 = 0;
                } else {
                    i2 = 1000;
                }
                WheatItemView.this.oLk.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WheatItemView.this.oLk.setVisibility(8);
                        WheatItemView.this.oLk.setTag(null);
                    }
                }, i2);
            }
        });
        this.oMh = abVar.aIU.live_id;
    }

    private boolean efu() {
        return (this.bxN == null || this.bxN.aIY == null || this.bxN.aIY.getRoomMode() != 1) ? false : true;
    }

    private boolean isResultsStage() {
        return (this.bxN == null || this.bxN.aIY == null || !this.bxN.aIY.isResultsStage()) ? false : true;
    }

    private boolean isSweetStage() {
        return (this.bxN == null || this.bxN.aIY == null || !this.bxN.aIY.isSweetStage()) ? false : true;
    }

    private void a(boolean z, ab abVar) {
        this.oLY.setVisibility(4);
        if (this.oKh != null && this.bxN != null) {
            int as = g.as(abVar);
            int at = g.at(abVar);
            boolean eeG = g.eeG();
            if (!z && as == 1) {
                switch (at) {
                    case 2:
                        if (eeG) {
                            if (this.oKh.select != 0) {
                                d(this.oKh.sex != 2, "选" + this.oKh.select, false);
                                this.oLY.setVisibility(0);
                                return;
                            }
                            return;
                        } else if (isSelf()) {
                            if (this.oKh.select == 0) {
                                if (this.bxN != null && !TextUtils.isEmpty(this.bxN.aJm)) {
                                    if (this.oMb != null) {
                                        this.oMb.WH(this.bxN.aJm);
                                    }
                                    this.bxN.aJm = "";
                                    return;
                                }
                                return;
                            }
                            d(this.oKh.sex != 2, "选" + this.oKh.select, false);
                            this.oLY.setVisibility(0);
                            return;
                        } else if (this.oKh.select != 0) {
                            Ap(this.oKh.sex != 2);
                            this.oLY.setVisibility(0);
                            return;
                        } else {
                            return;
                        }
                    case 3:
                        if (this.oKh.select == 0) {
                            this.oLY.setVisibility(0);
                            eeZ();
                            return;
                        } else if (eeG) {
                            this.oLY.setVisibility(0);
                            d(this.oKh.sex != 2, "选" + this.oKh.select, this.oKh.publish == 0);
                            return;
                        } else if (isSelf()) {
                            d(this.oKh.sex != 2, "选" + this.oKh.select, false);
                            this.oLY.setVisibility(0);
                            return;
                        } else if (this.oKh.publish == 1) {
                            d(this.oKh.sex != 2, "选" + this.oKh.select, false);
                            this.oLY.setVisibility(0);
                            return;
                        } else if (this.oKh.publish == 0) {
                            Ap(this.oKh.sex != 2);
                            this.oLY.setVisibility(0);
                            return;
                        } else {
                            return;
                        }
                    case 4:
                        if (this.oKh.select == 0) {
                            this.oLY.setVisibility(0);
                            eeZ();
                            return;
                        } else if (this.oKh.publish == 0) {
                            efa();
                            this.oLY.setVisibility(0);
                            return;
                        } else if (this.oKh.publish == 1) {
                            int[] iArr = this.oKh.together;
                            if (iArr == null || iArr[0] < 0 || iArr[1] < 0) {
                                d(this.oKh.sex != 2, "选" + this.oKh.select, false);
                                this.oLY.setVisibility(0);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    private boolean isSelf() {
        return this.oKh.uk.equals(g.Yp());
    }

    public void Ap(boolean z) {
        if (this.oLY != null) {
            this.oLY.setVisibility(0);
            this.oLY.Ap(z);
        }
    }

    public void d(boolean z, String str, boolean z2) {
        if (this.oLY != null) {
            this.oLY.setVisibility(0);
            this.oLY.d(z, str, z2);
        }
    }

    public void eeZ() {
        if (this.oLY != null) {
            this.oLY.setVisibility(0);
            this.oLY.eeZ();
        }
    }

    public void efa() {
        if (this.oLY != null) {
            this.oLY.setVisibility(0);
            this.oLY.efa();
        }
    }

    public AlaWheatInfoData getAlaWheatInfoData() {
        return this.oKh;
    }

    public void setChooseLoverBgView(boolean z) {
        if (this.oLZ != null) {
            this.oLZ.setVisibility(z ? 0 : 8);
        }
    }

    public void efv() {
        if (this.oLY != null) {
            this.oLY.et(this.oLY);
            d(this.oKh.sex != 2, "选" + this.oKh.select, false);
            this.oLY.setVisibility(0);
        }
    }

    public void setDialogLister(a aVar) {
        this.oMb = aVar;
    }
}
