package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tieba.view.AlaEmoticonView;
import com.baidu.live.tieba.view.fresco.SimpleDraweeView;
import com.baidu.live.view.SafeFrameLayout;
import com.baidu.tieba.yuyinala.liveroom.publishlover.PublishLoverHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.publishlover.b;
import com.baidu.tieba.yuyinala.liveroom.wheat.e.e;
import com.baidu.tieba.yuyinala.liveroom.wheat.e.g;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.PublishLoverView;
import com.facebook.drawee.a.a.c;
import com.facebook.imagepipeline.request.ImageRequest;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes4.dex */
public class WheatItemView extends SafeFrameLayout {
    private w bur;
    private PublishLoverView oyT;
    private AlaWheatInfoData oyU;
    private View oyV;
    private a oyW;
    private BaseWheatLayout.a oyc;

    /* loaded from: classes4.dex */
    public interface a {
        void Xe(String str);
    }

    public WheatItemView(@NonNull Context context) {
        this(context, null);
    }

    public WheatItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WheatItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(getContext()).inflate(a.g.yuyinala_liveroom_wheat_item_layout, this);
        this.oyT = (PublishLoverView) findViewById(a.f.view_pubish_lover);
        this.oyV = findViewById(a.f.view_choose_lover);
        this.oyV.setVisibility(8);
        this.oyT.setVisibility(4);
        this.oyT.setOnPublishClickListener(new PublishLoverView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.PublishLoverView.a
            public void onClick() {
                b bVar = new b(WheatItemView.this.getContext());
                bVar.h(g.Zc(), WheatItemView.this.oyU.uk, g.ar(WheatItemView.this.bur), g.aq(WheatItemView.this.bur));
                bVar.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.1.1
                    @Override // com.baidu.tieba.yuyinala.liveroom.publishlover.b.a
                    public void a(PublishLoverHttpResponseMessage publishLoverHttpResponseMessage) {
                        BdUtilHelper.showToast(WheatItemView.this.getContext(), "操作成功");
                        WheatItemView.this.oyT.ege();
                    }

                    @Override // com.baidu.tieba.yuyinala.liveroom.publishlover.b.a
                    public void onFail(int i2, String str) {
                        BdUtilHelper.showToast(WheatItemView.this.getContext(), "操作失败，请重试");
                    }
                });
            }
        });
    }

    public void setData(final AlaWheatInfoData alaWheatInfoData, int i, final boolean z, w wVar) {
        String str;
        String str2;
        HeadImageView headImageView = (HeadImageView) findViewById(a.f.user_avatar);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(a.f.user_avatar_container);
        final AlaEmoticonView alaEmoticonView = (AlaEmoticonView) findViewById(a.f.ala_emoticon_view);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(a.f.hat_emoticon_iv);
        TextView textView = (TextView) findViewById(a.f.anchor_name);
        ImageView imageView = (ImageView) findViewById(a.f.iv_user_gender);
        TextView textView2 = (TextView) findViewById(a.f.tv_charm_value);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(a.f.anchor_name_container);
        RelativeLayout relativeLayout3 = (RelativeLayout) findViewById(a.f.user_label);
        TextView textView3 = (TextView) findViewById(a.f.tv_host_label);
        TextView textView4 = (TextView) findViewById(a.f.tv_anchor_label);
        LinearLayout linearLayout = (LinearLayout) findViewById(a.f.charm_container);
        ImageView imageView2 = (ImageView) findViewById(a.f.iv_mute);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(a.f.speeding_lottieAnimationView);
        textView.setText("");
        textView2.setText("");
        this.oyU = alaWheatInfoData;
        this.bur = wVar;
        a(z, wVar);
        if (this.oyU == null) {
            relativeLayout3.setVisibility(8);
            if (lottieAnimationView.getVisibility() == 0) {
                lottieAnimationView.cancelAnimation();
                lottieAnimationView.setVisibility(8);
            }
            imageView.setSelected(false);
            imageView.setVisibility(8);
            headImageView.setIsRound(false);
            headImageView.setDrawBorder(false);
            headImageView.setAutoChangeStyle(false);
            headImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            headImageView.setImageResource(a.e.yuyin_sdk_wheat_empty_wheat);
            if (ego()) {
                headImageView.setBackgroundResource(a.e.yuyin_sdk_wheat_dating_bg_2);
            } else {
                headImageView.setBackgroundResource(a.e.yuyin_sdk_connection_wheat_empty);
            }
            if (z) {
                textView.setText(getContext().getResources().getString(a.h.yuyin_ala_connection_wheat_host_wheat_text));
            } else if (isResultsStage()) {
                AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) ListUtils.getItem(this.bur.aKQ.getAnchorWheatBackupLists(), i);
                if (alaWheatInfoData2 != null && alaWheatInfoData2.status == 1) {
                    headImageView.setImageResource(a.e.yuyin_sdk_unconnect_wheat);
                }
                textView.setText((i + 1) + getContext().getResources().getString(a.h.yuyin_ala_connection_wheat_num_text));
            } else if (isSweetStage()) {
                AlaWheatInfoData alaWheatInfoData3 = (AlaWheatInfoData) ListUtils.getItem(this.bur.aKQ.getAnchorWheatBackupLists(), i);
                if (alaWheatInfoData3 != null && alaWheatInfoData3.status == 1) {
                    headImageView.setImageResource(a.e.yuyin_sdk_unconnect_wheat);
                }
                if (alaWheatInfoData3 != null) {
                    textView.setText(alaWheatInfoData3.phone_order + getContext().getResources().getString(a.h.yuyin_ala_connection_wheat_num_text));
                } else {
                    textView.setText((i + 1) + getContext().getResources().getString(a.h.yuyin_ala_connection_wheat_num_text));
                }
            } else {
                textView.setText((i + 1) + getContext().getResources().getString(a.h.yuyin_ala_connection_wheat_num_text));
            }
            textView.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha70));
            linearLayout.setVisibility(8);
            relativeLayout.setTag(Integer.valueOf(i));
            imageView2.setVisibility(8);
            simpleDraweeView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout2.getLayoutParams();
            layoutParams.topMargin = e.c(6.0f, getContext());
            relativeLayout2.setLayoutParams(layoutParams);
        } else {
            relativeLayout3.setVisibility(0);
            textView.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
            imageView.setVisibility(0);
            imageView.setSelected(alaWheatInfoData.isFemale());
            headImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            headImageView.setImageResource(0);
            headImageView.setBackgroundResource(0);
            headImageView.setIsRound(true);
            headImageView.setDrawBorder(false);
            headImageView.setAutoChangeStyle(false);
            headImageView.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
            if (ego()) {
                headImageView.setDefaultBgResource(a.e.yuyin_sdk_wheat_dating_bg_2);
            } else {
                headImageView.setDefaultBgResource(a.e.yuyin_sdk_connection_wheat_empty);
            }
            headImageView.setUrl(alaWheatInfoData.portrait);
            headImageView.startLoad(alaWheatInfoData.portrait, 12, false, false);
            if (alaWheatInfoData.isOpenMike()) {
                imageView2.setVisibility(8);
            } else {
                if (lottieAnimationView.getVisibility() == 0) {
                    lottieAnimationView.cancelAnimation();
                    lottieAnimationView.setVisibility(8);
                }
                imageView2.setVisibility(0);
            }
            linearLayout.setVisibility(0);
            textView2.setText(alaWheatInfoData.charmCount);
            if (z) {
                textView3.setVisibility(0);
                textView4.setVisibility(8);
                textView.setText(alaWheatInfoData.userName);
            } else {
                textView3.setVisibility(8);
                textView4.setVisibility(0);
                if (isSweetStage()) {
                    textView4.setText(Integer.toString(alaWheatInfoData.phone_order));
                } else {
                    textView4.setText(Integer.toString(i + 1));
                }
                textView.setText(alaWheatInfoData.userName);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout2.getLayoutParams();
            layoutParams2.topMargin = e.c(12.5f, getContext());
            relativeLayout2.setLayoutParams(layoutParams2);
            if (!TextUtils.isEmpty(alaWheatInfoData.hatLevelIcon)) {
                String str3 = alaWheatInfoData.hatLevelIcon;
                str = alaWheatInfoData.hatLevelIcon;
                str2 = str3;
            } else if (TextUtils.isEmpty(alaWheatInfoData.hatLowIcon)) {
                str = "";
                str2 = "";
            } else {
                str = alaWheatInfoData.hatLowIcon;
                str2 = "isHatLowIcon";
            }
            if (TextUtils.isEmpty(str)) {
                simpleDraweeView.setVisibility(8);
            } else {
                String str4 = (String) simpleDraweeView.getTag();
                if (simpleDraweeView.getVisibility() != 0 || !str2.equals(str4)) {
                    simpleDraweeView.setVisibility(0);
                    a(simpleDraweeView, str);
                    simpleDraweeView.setTag(str2);
                }
            }
            relativeLayout.setTag(Integer.valueOf(i));
        }
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (WheatItemView.this.oyc != null) {
                    if (WheatItemView.this.bur != null && WheatItemView.this.bur.aLd) {
                        WheatItemView.this.oyc.a(alaWheatInfoData, z, intValue);
                    } else {
                        BdUtilHelper.showToast(WheatItemView.this.getContext(), "正在获取数据，请稍等");
                    }
                }
            }
        });
        alaEmoticonView.setEmoticonListener(new AlaEmoticonView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.3
            @Override // com.baidu.live.tieba.view.AlaEmoticonView.a
            public void Vm() {
                int i2;
                if (!(alaEmoticonView.getTag() instanceof String) || StringUtils.isNull((String) alaEmoticonView.getTag(), true)) {
                    i2 = 0;
                } else {
                    i2 = 1000;
                }
                alaEmoticonView.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        alaEmoticonView.setVisibility(8);
                        alaEmoticonView.setTag(null);
                    }
                }, i2);
            }
        });
        requestLayout();
        postInvalidate();
    }

    private boolean ego() {
        return (this.bur == null || this.bur.aKQ == null || this.bur.aKQ.getRoomMode() != 1) ? false : true;
    }

    private boolean isResultsStage() {
        return (this.bur == null || this.bur.aKQ == null || !this.bur.aKQ.isResultsStage()) ? false : true;
    }

    private boolean isSweetStage() {
        return (this.bur == null || this.bur.aKQ == null || !this.bur.aKQ.isSweetStage()) ? false : true;
    }

    private void a(boolean z, w wVar) {
        this.oyT.setVisibility(4);
        if (this.oyU != null && this.bur != null) {
            int ao = g.ao(wVar);
            int ap = g.ap(wVar);
            boolean efY = g.efY();
            if (!z && ao == 1) {
                switch (ap) {
                    case 2:
                        if (efY) {
                            if (this.oyU.select != 0) {
                                c(this.oyU.sex != 2, "选" + this.oyU.select, false);
                                this.oyT.setVisibility(0);
                                return;
                            }
                            return;
                        } else if (isSelf()) {
                            if (this.oyU.select == 0) {
                                if (this.bur != null && !TextUtils.isEmpty(this.bur.aLb)) {
                                    if (this.oyW != null) {
                                        this.oyW.Xe(this.bur.aLb);
                                    }
                                    this.bur.aLb = "";
                                    return;
                                }
                                return;
                            }
                            c(this.oyU.sex != 2, "选" + this.oyU.select, false);
                            this.oyT.setVisibility(0);
                            return;
                        } else if (this.oyU.select != 0) {
                            zY(this.oyU.sex != 2);
                            this.oyT.setVisibility(0);
                            return;
                        } else {
                            return;
                        }
                    case 3:
                        if (this.oyU.select == 0) {
                            this.oyT.setVisibility(0);
                            egd();
                            return;
                        } else if (efY) {
                            this.oyT.setVisibility(0);
                            c(this.oyU.sex != 2, "选" + this.oyU.select, this.oyU.publish == 0);
                            return;
                        } else if (isSelf()) {
                            c(this.oyU.sex != 2, "选" + this.oyU.select, false);
                            this.oyT.setVisibility(0);
                            return;
                        } else if (this.oyU.publish == 1) {
                            c(this.oyU.sex != 2, "选" + this.oyU.select, false);
                            this.oyT.setVisibility(0);
                            return;
                        } else if (this.oyU.publish == 0) {
                            zY(this.oyU.sex != 2);
                            this.oyT.setVisibility(0);
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
        return this.oyU.uk.equals(g.Zc());
    }

    public void a(SimpleDraweeView simpleDraweeView, String str) {
        simpleDraweeView.setController(c.eqF().bo(ImageRequest.Zv(str)).AP(true).c(simpleDraweeView.getController()).erw());
    }

    public void zY(boolean z) {
        if (this.oyT != null) {
            this.oyT.setVisibility(0);
            this.oyT.zY(z);
        }
    }

    public void c(boolean z, String str, boolean z2) {
        if (this.oyT != null) {
            this.oyT.setVisibility(0);
            this.oyT.c(z, str, z2);
        }
    }

    public void egd() {
        if (this.oyT != null) {
            this.oyT.setVisibility(0);
            this.oyT.egd();
        }
    }

    public AlaWheatInfoData getAlaWheatInfoData() {
        return this.oyU;
    }

    public void setOnItemClickListener(BaseWheatLayout.a aVar) {
        this.oyc = aVar;
    }

    public void setChooseLoverBgView(boolean z) {
        if (this.oyV != null) {
            this.oyV.setVisibility(z ? 0 : 8);
        }
    }

    public void egp() {
        if (this.oyT != null) {
            this.oyT.ek(this.oyT);
            c(this.oyU.sex != 2, "选" + this.oyU.select, false);
            this.oyT.setVisibility(0);
        }
    }

    public void setDialogLister(a aVar) {
        this.oyW = aVar;
    }
}
