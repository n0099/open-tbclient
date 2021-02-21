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
    private TextView gDH;
    private TextView gOE;
    private HeadImageView oIg;
    private SimpleDraweeView oLF;
    private TBLottieAnimationView oLG;
    private RelativeLayout oLH;
    private ImageView oLI;
    private ImageView oLJ;
    private AlaEmoticonView oLK;
    private SimpleDraweeView oLv;
    private ImageView oMA;
    private a oMB;
    private RelativeLayout oMC;
    private RelativeLayout oMD;
    private TextView oME;
    private TextView oMF;
    private LinearLayout oMG;
    private String oMH;
    private PublishLoverView oMy;
    private View oMz;

    /* loaded from: classes11.dex */
    public interface a {
        void WT(String str);
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
        this.oIg = (HeadImageView) findViewById(a.f.user_avatar);
        this.oLH = (RelativeLayout) findViewById(a.f.user_avatar_container);
        this.oLK = (AlaEmoticonView) findViewById(a.f.ala_emoticon_view);
        this.oLF = (SimpleDraweeView) findViewById(a.f.hat_emoticon_iv);
        this.oLv = (SimpleDraweeView) findViewById(a.f.frame_emoticon_iv);
        this.gDH = (TextView) findViewById(a.f.anchor_name);
        this.oLI = (ImageView) findViewById(a.f.iv_user_gender);
        this.oMA = (ImageView) findViewById(a.f.iv_charm_icon);
        this.gOE = (TextView) findViewById(a.f.tv_charm_value);
        this.oMC = (RelativeLayout) findViewById(a.f.anchor_name_container);
        this.oMD = (RelativeLayout) findViewById(a.f.user_label);
        this.oME = (TextView) findViewById(a.f.tv_host_label);
        this.oMF = (TextView) findViewById(a.f.tv_anchor_label);
        this.oMG = (LinearLayout) findViewById(a.f.charm_container);
        this.oLJ = (ImageView) findViewById(a.f.iv_mute);
        this.oLG = (TBLottieAnimationView) findViewById(a.f.speeding_lottieAnimationView);
        this.oMy = (PublishLoverView) findViewById(a.f.view_pubish_lover);
        this.oMz = findViewById(a.f.view_choose_lover);
        this.oMz.setVisibility(8);
        this.oMy.setVisibility(4);
        this.oMy.setOnPublishClickListener(new PublishLoverView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.PublishLoverView.a
            public void onClick() {
                b bVar = new b(WheatItemView.this.getContext());
                bVar.m(g.Yp(), WheatItemView.this.oKH.uk, g.av(WheatItemView.this.bxN), g.au(WheatItemView.this.bxN));
                bVar.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.1.1
                    @Override // com.baidu.tieba.yuyinala.liveroom.publishlover.b.a
                    public void a(PublishLoverHttpResponseMessage publishLoverHttpResponseMessage) {
                        BdUtilHelper.showToast(WheatItemView.this.getContext(), "操作成功");
                        WheatItemView.this.oMy.efj();
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
        this.gDH.setText("");
        this.gOE.setText("");
        this.oKH = alaWheatInfoData;
        this.bxN = abVar;
        a(z, abVar);
        if (this.oKH == null) {
            this.oMD.setVisibility(8);
            if (this.oLG.getVisibility() == 0) {
                this.oLG.cancelAnimation();
                this.oLG.setVisibility(8);
            }
            this.oLI.setSelected(false);
            this.oLI.setVisibility(8);
            this.oIg.setIsRound(false);
            this.oIg.setDrawBorder(false);
            this.oIg.setAutoChangeStyle(false);
            this.oIg.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.oIg.setImageResource(a.e.yuyin_sdk_wheat_empty_wheat);
            if (efC()) {
                this.oIg.setBackgroundResource(a.e.yuyin_sdk_wheat_dating_bg_2);
            } else {
                this.oIg.setBackgroundResource(a.e.yuyin_sdk_connection_wheat_empty);
            }
            if (z) {
                this.gDH.setText(getContext().getResources().getString(a.h.yuyin_ala_connection_wheat_host_wheat_text));
            } else if (isResultsStage()) {
                AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) ListUtils.getItem(this.bxN.aIY.getAnchorWheatBackupLists(), i);
                if (alaWheatInfoData2 != null && alaWheatInfoData2.status == 1) {
                    this.oIg.setImageResource(a.e.yuyin_sdk_unconnect_wheat);
                }
                this.gDH.setText((i + 1) + getContext().getResources().getString(a.h.yuyin_ala_connection_wheat_num_text));
            } else if (isSweetStage()) {
                AlaWheatInfoData alaWheatInfoData3 = (AlaWheatInfoData) ListUtils.getItem(this.bxN.aIY.getAnchorWheatBackupLists(), i);
                if (alaWheatInfoData3 != null && alaWheatInfoData3.status == 1) {
                    this.oIg.setImageResource(a.e.yuyin_sdk_unconnect_wheat);
                }
                if (alaWheatInfoData3 != null) {
                    this.gDH.setText(alaWheatInfoData3.phone_order + getContext().getResources().getString(a.h.yuyin_ala_connection_wheat_num_text));
                } else {
                    this.gDH.setText((i + 1) + getContext().getResources().getString(a.h.yuyin_ala_connection_wheat_num_text));
                }
            } else {
                this.gDH.setText((i + 1) + getContext().getResources().getString(a.h.yuyin_ala_connection_wheat_num_text));
            }
            this.gDH.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha70));
            this.oMG.setVisibility(8);
            this.oLH.setTag(Integer.valueOf(i));
            this.oLJ.setVisibility(8);
            this.oLF.setVisibility(8);
            this.oLv.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.oMC.getLayoutParams();
            layoutParams.topMargin = e.d(12.0f, getContext());
            this.oMC.setLayoutParams(layoutParams);
        } else {
            this.oMD.setVisibility(0);
            this.gDH.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
            this.oLI.setVisibility(0);
            this.oLI.setSelected(alaWheatInfoData.isFemale());
            this.oMA.setImageResource(alaWheatInfoData.isFemale() ? a.e.yuyin_sdk_wheat_heartbeat_female_value : a.e.yuyin_sdk_wheat_heartbeat_male_value);
            this.oIg.setScaleType(ImageView.ScaleType.FIT_XY);
            this.oIg.setImageResource(0);
            this.oIg.setBackgroundResource(0);
            this.oIg.setIsRound(true);
            this.oIg.setDrawBorder(false);
            this.oIg.setAutoChangeStyle(false);
            this.oIg.setDefaultResource(a.e.sdk_icon_default_avatar100);
            if (efC()) {
                this.oIg.setDefaultBgResource(a.e.yuyin_sdk_wheat_dating_bg_2);
            } else {
                this.oIg.setDefaultBgResource(a.e.yuyin_sdk_connection_wheat_empty);
            }
            this.oIg.setUrl(alaWheatInfoData.bigPortrait);
            this.oIg.startLoad(alaWheatInfoData.bigPortrait, 12, false, false);
            if (alaWheatInfoData.isOpenMike()) {
                this.oLJ.setVisibility(8);
            } else {
                if (this.oLG.getVisibility() == 0) {
                    this.oLG.cancelAnimation();
                    this.oLG.setVisibility(8);
                }
                this.oLJ.setVisibility(0);
            }
            this.oMG.setVisibility(0);
            this.gOE.setText(alaWheatInfoData.charmCount);
            if (z) {
                this.oME.setVisibility(0);
                this.oMF.setVisibility(8);
                this.gDH.setText(alaWheatInfoData.userName);
            } else {
                this.oME.setVisibility(8);
                this.oMF.setVisibility(0);
                if (isSweetStage()) {
                    this.oMF.setText(Integer.toString(alaWheatInfoData.phone_order));
                } else {
                    this.oMF.setText(Integer.toString(i + 1));
                }
                this.gDH.setText(alaWheatInfoData.userName);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.oMC.getLayoutParams();
            layoutParams2.topMargin = e.d(12.5f, getContext());
            this.oMC.setLayoutParams(layoutParams2);
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
                this.oLF.setVisibility(8);
            } else {
                String str4 = (String) this.oLF.getTag();
                if (this.oLF.getVisibility() != 0 || !str.equals(str4)) {
                    this.oLF.setVisibility(0);
                    a(this.oLF, str2);
                    this.oLF.setTag(str);
                }
            }
            AlaLivePhoneMarkData alaLivePhoneMarkData = alaWheatInfoData.getAlaLivePhoneMarkData(1);
            if (alaLivePhoneMarkData == null || TextUtils.isEmpty(alaLivePhoneMarkData.icon)) {
                this.oLv.setVisibility(8);
            } else {
                String str5 = (String) this.oLv.getTag();
                if (this.oLv.getVisibility() != 0 || !alaLivePhoneMarkData.icon.equals(str5)) {
                    this.oLv.setVisibility(0);
                    a(this.oLv, alaLivePhoneMarkData.icon);
                    this.oLv.setTag(alaLivePhoneMarkData.icon);
                }
            }
            this.oLH.setTag(Integer.valueOf(i));
        }
        this.oLH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (WheatItemView.this.oKI != null) {
                    if (WheatItemView.this.bxN != null && WheatItemView.this.bxN.aJo) {
                        WheatItemView.this.oKI.a(alaWheatInfoData, z, intValue);
                    } else {
                        BdUtilHelper.showToast(WheatItemView.this.getContext(), "正在获取数据，请稍等");
                    }
                }
            }
        });
        if (!TextUtils.isEmpty(this.oMH) && !this.oMH.equals(abVar.aIU.live_id)) {
            this.oLK.setVisibility(8);
        }
        this.oLK.setEmoticonListener(new AlaEmoticonView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.3
            @Override // com.baidu.live.tieba.view.AlaEmoticonView.a
            public void Ue() {
                int i2;
                if (!(WheatItemView.this.oLK.getTag() instanceof String) || StringUtils.isNull((String) WheatItemView.this.oLK.getTag(), true)) {
                    i2 = 0;
                } else {
                    i2 = 1000;
                }
                WheatItemView.this.oLK.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WheatItemView.this.oLK.setVisibility(8);
                        WheatItemView.this.oLK.setTag(null);
                    }
                }, i2);
            }
        });
        this.oMH = abVar.aIU.live_id;
    }

    private boolean efC() {
        return (this.bxN == null || this.bxN.aIY == null || this.bxN.aIY.getRoomMode() != 1) ? false : true;
    }

    private boolean isResultsStage() {
        return (this.bxN == null || this.bxN.aIY == null || !this.bxN.aIY.isResultsStage()) ? false : true;
    }

    private boolean isSweetStage() {
        return (this.bxN == null || this.bxN.aIY == null || !this.bxN.aIY.isSweetStage()) ? false : true;
    }

    private void a(boolean z, ab abVar) {
        this.oMy.setVisibility(4);
        if (this.oKH != null && this.bxN != null) {
            int as = g.as(abVar);
            int at = g.at(abVar);
            boolean eeO = g.eeO();
            if (!z && as == 1) {
                switch (at) {
                    case 2:
                        if (eeO) {
                            if (this.oKH.select != 0) {
                                d(this.oKH.sex != 2, "选" + this.oKH.select, false);
                                this.oMy.setVisibility(0);
                                return;
                            }
                            return;
                        } else if (isSelf()) {
                            if (this.oKH.select == 0) {
                                if (this.bxN != null && !TextUtils.isEmpty(this.bxN.aJm)) {
                                    if (this.oMB != null) {
                                        this.oMB.WT(this.bxN.aJm);
                                    }
                                    this.bxN.aJm = "";
                                    return;
                                }
                                return;
                            }
                            d(this.oKH.sex != 2, "选" + this.oKH.select, false);
                            this.oMy.setVisibility(0);
                            return;
                        } else if (this.oKH.select != 0) {
                            Ap(this.oKH.sex != 2);
                            this.oMy.setVisibility(0);
                            return;
                        } else {
                            return;
                        }
                    case 3:
                        if (this.oKH.select == 0) {
                            this.oMy.setVisibility(0);
                            efh();
                            return;
                        } else if (eeO) {
                            this.oMy.setVisibility(0);
                            d(this.oKH.sex != 2, "选" + this.oKH.select, this.oKH.publish == 0);
                            return;
                        } else if (isSelf()) {
                            d(this.oKH.sex != 2, "选" + this.oKH.select, false);
                            this.oMy.setVisibility(0);
                            return;
                        } else if (this.oKH.publish == 1) {
                            d(this.oKH.sex != 2, "选" + this.oKH.select, false);
                            this.oMy.setVisibility(0);
                            return;
                        } else if (this.oKH.publish == 0) {
                            Ap(this.oKH.sex != 2);
                            this.oMy.setVisibility(0);
                            return;
                        } else {
                            return;
                        }
                    case 4:
                        if (this.oKH.select == 0) {
                            this.oMy.setVisibility(0);
                            efh();
                            return;
                        } else if (this.oKH.publish == 0) {
                            efi();
                            this.oMy.setVisibility(0);
                            return;
                        } else if (this.oKH.publish == 1) {
                            int[] iArr = this.oKH.together;
                            if (iArr == null || iArr[0] < 0 || iArr[1] < 0) {
                                d(this.oKH.sex != 2, "选" + this.oKH.select, false);
                                this.oMy.setVisibility(0);
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
        return this.oKH.uk.equals(g.Yp());
    }

    public void Ap(boolean z) {
        if (this.oMy != null) {
            this.oMy.setVisibility(0);
            this.oMy.Ap(z);
        }
    }

    public void d(boolean z, String str, boolean z2) {
        if (this.oMy != null) {
            this.oMy.setVisibility(0);
            this.oMy.d(z, str, z2);
        }
    }

    public void efh() {
        if (this.oMy != null) {
            this.oMy.setVisibility(0);
            this.oMy.efh();
        }
    }

    public void efi() {
        if (this.oMy != null) {
            this.oMy.setVisibility(0);
            this.oMy.efi();
        }
    }

    public AlaWheatInfoData getAlaWheatInfoData() {
        return this.oKH;
    }

    public void setChooseLoverBgView(boolean z) {
        if (this.oMz != null) {
            this.oMz.setVisibility(z ? 0 : 8);
        }
    }

    public void efD() {
        if (this.oMy != null) {
            this.oMy.et(this.oMy);
            d(this.oKH.sex != 2, "选" + this.oKH.select, false);
            this.oMy.setVisibility(0);
        }
    }

    public void setDialogLister(a aVar) {
        this.oMB = aVar;
    }
}
