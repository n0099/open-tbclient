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
/* loaded from: classes10.dex */
public class WheatItemView extends BaseWheatItemView {
    private TextView gFq;
    private TextView gQn;
    private HeadImageView oKl;
    private SimpleDraweeView oNA;
    private SimpleDraweeView oNK;
    private TBLottieAnimationView oNL;
    private RelativeLayout oNM;
    private ImageView oNN;
    private ImageView oNO;
    private AlaEmoticonView oNP;
    private PublishLoverView oOD;
    private View oOE;
    private ImageView oOF;
    private a oOG;
    private RelativeLayout oOH;
    private RelativeLayout oOI;
    private TextView oOJ;
    private TextView oOK;
    private LinearLayout oOL;
    private String oOM;

    /* loaded from: classes10.dex */
    public interface a {
        void Xa(String str);
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
        this.oKl = (HeadImageView) findViewById(a.f.user_avatar);
        this.oNM = (RelativeLayout) findViewById(a.f.user_avatar_container);
        this.oNP = (AlaEmoticonView) findViewById(a.f.ala_emoticon_view);
        this.oNK = (SimpleDraweeView) findViewById(a.f.hat_emoticon_iv);
        this.oNA = (SimpleDraweeView) findViewById(a.f.frame_emoticon_iv);
        this.gFq = (TextView) findViewById(a.f.anchor_name);
        this.oNN = (ImageView) findViewById(a.f.iv_user_gender);
        this.oOF = (ImageView) findViewById(a.f.iv_charm_icon);
        this.gQn = (TextView) findViewById(a.f.tv_charm_value);
        this.oOH = (RelativeLayout) findViewById(a.f.anchor_name_container);
        this.oOI = (RelativeLayout) findViewById(a.f.user_label);
        this.oOJ = (TextView) findViewById(a.f.tv_host_label);
        this.oOK = (TextView) findViewById(a.f.tv_anchor_label);
        this.oOL = (LinearLayout) findViewById(a.f.charm_container);
        this.oNO = (ImageView) findViewById(a.f.iv_mute);
        this.oNL = (TBLottieAnimationView) findViewById(a.f.speeding_lottieAnimationView);
        this.oOD = (PublishLoverView) findViewById(a.f.view_pubish_lover);
        this.oOE = findViewById(a.f.view_choose_lover);
        this.oOE.setVisibility(8);
        this.oOD.setVisibility(4);
        this.oOD.setOnPublishClickListener(new PublishLoverView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.PublishLoverView.a
            public void onClick() {
                b bVar = new b(WheatItemView.this.getContext());
                bVar.m(g.Ys(), WheatItemView.this.oMM.uk, g.av(WheatItemView.this.bzn), g.au(WheatItemView.this.bzn));
                bVar.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.1.1
                    @Override // com.baidu.tieba.yuyinala.liveroom.publishlover.b.a
                    public void a(PublishLoverHttpResponseMessage publishLoverHttpResponseMessage) {
                        BdUtilHelper.showToast(WheatItemView.this.getContext(), "操作成功");
                        WheatItemView.this.oOD.efr();
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
        this.gFq.setText("");
        this.gQn.setText("");
        this.oMM = alaWheatInfoData;
        this.bzn = abVar;
        a(z, abVar);
        if (this.oMM == null) {
            this.oOI.setVisibility(8);
            if (this.oNL.getVisibility() == 0) {
                this.oNL.cancelAnimation();
                this.oNL.setVisibility(8);
            }
            this.oNN.setSelected(false);
            this.oNN.setVisibility(8);
            this.oKl.setIsRound(false);
            this.oKl.setDrawBorder(false);
            this.oKl.setAutoChangeStyle(false);
            this.oKl.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.oKl.setImageResource(a.e.yuyin_sdk_wheat_empty_wheat);
            if (efK()) {
                this.oKl.setBackgroundResource(a.e.yuyin_sdk_wheat_dating_bg_2);
            } else {
                this.oKl.setBackgroundResource(a.e.yuyin_sdk_connection_wheat_empty);
            }
            if (z) {
                this.gFq.setText(getContext().getResources().getString(a.h.yuyin_ala_connection_wheat_host_wheat_text));
            } else if (isResultsStage()) {
                AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) ListUtils.getItem(this.bzn.aKy.getAnchorWheatBackupLists(), i);
                if (alaWheatInfoData2 != null && alaWheatInfoData2.status == 1) {
                    this.oKl.setImageResource(a.e.yuyin_sdk_unconnect_wheat);
                }
                this.gFq.setText((i + 1) + getContext().getResources().getString(a.h.yuyin_ala_connection_wheat_num_text));
            } else if (isSweetStage()) {
                AlaWheatInfoData alaWheatInfoData3 = (AlaWheatInfoData) ListUtils.getItem(this.bzn.aKy.getAnchorWheatBackupLists(), i);
                if (alaWheatInfoData3 != null && alaWheatInfoData3.status == 1) {
                    this.oKl.setImageResource(a.e.yuyin_sdk_unconnect_wheat);
                }
                if (alaWheatInfoData3 != null) {
                    this.gFq.setText(alaWheatInfoData3.phone_order + getContext().getResources().getString(a.h.yuyin_ala_connection_wheat_num_text));
                } else {
                    this.gFq.setText((i + 1) + getContext().getResources().getString(a.h.yuyin_ala_connection_wheat_num_text));
                }
            } else {
                this.gFq.setText((i + 1) + getContext().getResources().getString(a.h.yuyin_ala_connection_wheat_num_text));
            }
            this.gFq.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha70));
            this.oOL.setVisibility(8);
            this.oNM.setTag(Integer.valueOf(i));
            this.oNO.setVisibility(8);
            this.oNK.setVisibility(8);
            this.oNA.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.oOH.getLayoutParams();
            layoutParams.topMargin = e.d(12.0f, getContext());
            this.oOH.setLayoutParams(layoutParams);
        } else {
            this.oOI.setVisibility(0);
            this.gFq.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
            this.oNN.setVisibility(0);
            this.oNN.setSelected(alaWheatInfoData.isFemale());
            this.oOF.setImageResource(alaWheatInfoData.isFemale() ? a.e.yuyin_sdk_wheat_heartbeat_female_value : a.e.yuyin_sdk_wheat_heartbeat_male_value);
            this.oKl.setScaleType(ImageView.ScaleType.FIT_XY);
            this.oKl.setImageResource(0);
            this.oKl.setBackgroundResource(0);
            this.oKl.setIsRound(true);
            this.oKl.setDrawBorder(false);
            this.oKl.setAutoChangeStyle(false);
            this.oKl.setDefaultResource(a.e.sdk_icon_default_avatar100);
            if (efK()) {
                this.oKl.setDefaultBgResource(a.e.yuyin_sdk_wheat_dating_bg_2);
            } else {
                this.oKl.setDefaultBgResource(a.e.yuyin_sdk_connection_wheat_empty);
            }
            this.oKl.setUrl(alaWheatInfoData.bigPortrait);
            this.oKl.startLoad(alaWheatInfoData.bigPortrait, 12, false, false);
            if (alaWheatInfoData.isOpenMike()) {
                this.oNO.setVisibility(8);
            } else {
                if (this.oNL.getVisibility() == 0) {
                    this.oNL.cancelAnimation();
                    this.oNL.setVisibility(8);
                }
                this.oNO.setVisibility(0);
            }
            this.oOL.setVisibility(0);
            this.gQn.setText(alaWheatInfoData.charmCount);
            if (z) {
                this.oOJ.setVisibility(0);
                this.oOK.setVisibility(8);
                this.gFq.setText(alaWheatInfoData.userName);
            } else {
                this.oOJ.setVisibility(8);
                this.oOK.setVisibility(0);
                if (isSweetStage()) {
                    this.oOK.setText(Integer.toString(alaWheatInfoData.phone_order));
                } else {
                    this.oOK.setText(Integer.toString(i + 1));
                }
                this.gFq.setText(alaWheatInfoData.userName);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.oOH.getLayoutParams();
            layoutParams2.topMargin = e.d(12.5f, getContext());
            this.oOH.setLayoutParams(layoutParams2);
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
                this.oNK.setVisibility(8);
            } else {
                String str4 = (String) this.oNK.getTag();
                if (this.oNK.getVisibility() != 0 || !str.equals(str4)) {
                    this.oNK.setVisibility(0);
                    a(this.oNK, str2);
                    this.oNK.setTag(str);
                }
            }
            AlaLivePhoneMarkData alaLivePhoneMarkData = alaWheatInfoData.getAlaLivePhoneMarkData(1);
            if (alaLivePhoneMarkData == null || TextUtils.isEmpty(alaLivePhoneMarkData.icon)) {
                this.oNA.setVisibility(8);
            } else {
                String str5 = (String) this.oNA.getTag();
                if (this.oNA.getVisibility() != 0 || !alaLivePhoneMarkData.icon.equals(str5)) {
                    this.oNA.setVisibility(0);
                    a(this.oNA, alaLivePhoneMarkData.icon);
                    this.oNA.setTag(alaLivePhoneMarkData.icon);
                }
            }
            this.oNM.setTag(Integer.valueOf(i));
        }
        this.oNM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (WheatItemView.this.oMN != null) {
                    if (WheatItemView.this.bzn != null && WheatItemView.this.bzn.aKO) {
                        WheatItemView.this.oMN.a(alaWheatInfoData, z, intValue);
                    } else {
                        BdUtilHelper.showToast(WheatItemView.this.getContext(), "正在获取数据，请稍等");
                    }
                }
            }
        });
        if (!TextUtils.isEmpty(this.oOM) && !this.oOM.equals(abVar.aKu.live_id)) {
            this.oNP.setVisibility(8);
        }
        this.oNP.setEmoticonListener(new AlaEmoticonView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.3
            @Override // com.baidu.live.tieba.view.AlaEmoticonView.a
            public void Uh() {
                int i2;
                if (!(WheatItemView.this.oNP.getTag() instanceof String) || StringUtils.isNull((String) WheatItemView.this.oNP.getTag(), true)) {
                    i2 = 0;
                } else {
                    i2 = 1000;
                }
                WheatItemView.this.oNP.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WheatItemView.this.oNP.setVisibility(8);
                        WheatItemView.this.oNP.setTag(null);
                    }
                }, i2);
            }
        });
        this.oOM = abVar.aKu.live_id;
    }

    private boolean efK() {
        return (this.bzn == null || this.bzn.aKy == null || this.bzn.aKy.getRoomMode() != 1) ? false : true;
    }

    private boolean isResultsStage() {
        return (this.bzn == null || this.bzn.aKy == null || !this.bzn.aKy.isResultsStage()) ? false : true;
    }

    private boolean isSweetStage() {
        return (this.bzn == null || this.bzn.aKy == null || !this.bzn.aKy.isSweetStage()) ? false : true;
    }

    private void a(boolean z, ab abVar) {
        this.oOD.setVisibility(4);
        if (this.oMM != null && this.bzn != null) {
            int as = g.as(abVar);
            int at = g.at(abVar);
            boolean eeW = g.eeW();
            if (!z && as == 1) {
                switch (at) {
                    case 2:
                        if (eeW) {
                            if (this.oMM.select != 0) {
                                d(this.oMM.sex != 2, "选" + this.oMM.select, false);
                                this.oOD.setVisibility(0);
                                return;
                            }
                            return;
                        } else if (isSelf()) {
                            if (this.oMM.select == 0) {
                                if (this.bzn != null && !TextUtils.isEmpty(this.bzn.aKM)) {
                                    if (this.oOG != null) {
                                        this.oOG.Xa(this.bzn.aKM);
                                    }
                                    this.bzn.aKM = "";
                                    return;
                                }
                                return;
                            }
                            d(this.oMM.sex != 2, "选" + this.oMM.select, false);
                            this.oOD.setVisibility(0);
                            return;
                        } else if (this.oMM.select != 0) {
                            Ao(this.oMM.sex != 2);
                            this.oOD.setVisibility(0);
                            return;
                        } else {
                            return;
                        }
                    case 3:
                        if (this.oMM.select == 0) {
                            this.oOD.setVisibility(0);
                            efp();
                            return;
                        } else if (eeW) {
                            this.oOD.setVisibility(0);
                            d(this.oMM.sex != 2, "选" + this.oMM.select, this.oMM.publish == 0);
                            return;
                        } else if (isSelf()) {
                            d(this.oMM.sex != 2, "选" + this.oMM.select, false);
                            this.oOD.setVisibility(0);
                            return;
                        } else if (this.oMM.publish == 1) {
                            d(this.oMM.sex != 2, "选" + this.oMM.select, false);
                            this.oOD.setVisibility(0);
                            return;
                        } else if (this.oMM.publish == 0) {
                            Ao(this.oMM.sex != 2);
                            this.oOD.setVisibility(0);
                            return;
                        } else {
                            return;
                        }
                    case 4:
                        if (this.oMM.select == 0) {
                            this.oOD.setVisibility(0);
                            efp();
                            return;
                        } else if (this.oMM.publish == 0) {
                            efq();
                            this.oOD.setVisibility(0);
                            return;
                        } else if (this.oMM.publish == 1) {
                            int[] iArr = this.oMM.together;
                            if (iArr == null || iArr[0] < 0 || iArr[1] < 0) {
                                d(this.oMM.sex != 2, "选" + this.oMM.select, false);
                                this.oOD.setVisibility(0);
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
        return this.oMM.uk.equals(g.Ys());
    }

    public void Ao(boolean z) {
        if (this.oOD != null) {
            this.oOD.setVisibility(0);
            this.oOD.Ao(z);
        }
    }

    public void d(boolean z, String str, boolean z2) {
        if (this.oOD != null) {
            this.oOD.setVisibility(0);
            this.oOD.d(z, str, z2);
        }
    }

    public void efp() {
        if (this.oOD != null) {
            this.oOD.setVisibility(0);
            this.oOD.efp();
        }
    }

    public void efq() {
        if (this.oOD != null) {
            this.oOD.setVisibility(0);
            this.oOD.efq();
        }
    }

    public AlaWheatInfoData getAlaWheatInfoData() {
        return this.oMM;
    }

    public void setChooseLoverBgView(boolean z) {
        if (this.oOE != null) {
            this.oOE.setVisibility(z ? 0 : 8);
        }
    }

    public void efL() {
        if (this.oOD != null) {
            this.oOD.et(this.oOD);
            d(this.oMM.sex != 2, "选" + this.oMM.select, false);
            this.oOD.setVisibility(0);
        }
    }

    public void setDialogLister(a aVar) {
        this.oOG = aVar;
    }
}
