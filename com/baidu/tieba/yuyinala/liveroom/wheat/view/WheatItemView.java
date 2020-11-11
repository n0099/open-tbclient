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
    private w bqS;
    private BaseWheatLayout.a ohy;
    private PublishLoverView oiq;
    private AlaWheatInfoData oir;
    private View ois;
    private a oit;

    /* loaded from: classes4.dex */
    public interface a {
        void We(String str);
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
        this.oiq = (PublishLoverView) findViewById(a.f.view_pubish_lover);
        this.ois = findViewById(a.f.view_choose_lover);
        this.ois.setVisibility(8);
        this.oiq.setVisibility(4);
        this.oiq.setOnPublishClickListener(new PublishLoverView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.1
            @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.PublishLoverView.a
            public void onClick() {
                b bVar = new b(WheatItemView.this.getContext());
                bVar.h(g.Xm(), WheatItemView.this.oir.uk, g.am(WheatItemView.this.bqS), g.al(WheatItemView.this.bqS));
                bVar.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.1.1
                    @Override // com.baidu.tieba.yuyinala.liveroom.publishlover.b.a
                    public void a(PublishLoverHttpResponseMessage publishLoverHttpResponseMessage) {
                        BdUtilHelper.showToast(WheatItemView.this.getContext(), "操作成功");
                        WheatItemView.this.oiq.eaA();
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
        this.oir = alaWheatInfoData;
        this.bqS = wVar;
        a(z, wVar);
        if (this.oir == null) {
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
            if (eaK()) {
                headImageView.setBackgroundResource(a.e.yuyin_sdk_wheat_dating_bg_2);
            } else {
                headImageView.setBackgroundResource(a.e.yuyin_sdk_connection_wheat_empty);
            }
            if (z) {
                textView.setText(getContext().getResources().getString(a.h.yuyin_ala_connection_wheat_host_wheat_text));
            } else if (isResultsStage()) {
                AlaWheatInfoData alaWheatInfoData2 = (AlaWheatInfoData) ListUtils.getItem(this.bqS.aJP.getAnchorWheatBackupLists(), i);
                if (alaWheatInfoData2 != null && alaWheatInfoData2.status == 1) {
                    headImageView.setImageResource(a.e.yuyin_sdk_unconnect_wheat);
                }
                textView.setText((i + 1) + getContext().getResources().getString(a.h.yuyin_ala_connection_wheat_num_text));
            } else if (isSweetStage()) {
                AlaWheatInfoData alaWheatInfoData3 = (AlaWheatInfoData) ListUtils.getItem(this.bqS.aJP.getAnchorWheatBackupLists(), i);
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
            headImageView.setDefaultResource(a.e.yuyin_sdk_wheat_empty_wheat);
            if (eaK()) {
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
                if (WheatItemView.this.ohy != null) {
                    if (WheatItemView.this.bqS != null && WheatItemView.this.bqS.aKc) {
                        WheatItemView.this.ohy.a(alaWheatInfoData, z, intValue);
                    } else {
                        BdUtilHelper.showToast(WheatItemView.this.getContext(), "正在获取数据，请稍等");
                    }
                }
            }
        });
        alaEmoticonView.setEmoticonListener(new AlaEmoticonView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatItemView.3
            @Override // com.baidu.live.tieba.view.AlaEmoticonView.a
            public void Tv() {
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

    private boolean eaK() {
        return (this.bqS == null || this.bqS.aJP == null || this.bqS.aJP.getRoomMode() != 1) ? false : true;
    }

    private boolean isResultsStage() {
        return (this.bqS == null || this.bqS.aJP == null || !this.bqS.aJP.isResultsStage()) ? false : true;
    }

    private boolean isSweetStage() {
        return (this.bqS == null || this.bqS.aJP == null || !this.bqS.aJP.isSweetStage()) ? false : true;
    }

    private void a(boolean z, w wVar) {
        this.oiq.setVisibility(4);
        if (this.oir != null && this.bqS != null) {
            int aj = g.aj(wVar);
            int ak = g.ak(wVar);
            boolean eau = g.eau();
            if (!z && aj == 1) {
                switch (ak) {
                    case 2:
                        if (eau) {
                            if (this.oir.select != 0) {
                                c(this.oir.sex != 2, "选" + this.oir.select, false);
                                this.oiq.setVisibility(0);
                                return;
                            }
                            return;
                        } else if (isSelf()) {
                            if (this.oir.select == 0) {
                                if (this.bqS != null && !TextUtils.isEmpty(this.bqS.aKa)) {
                                    if (this.oit != null) {
                                        this.oit.We(this.bqS.aKa);
                                    }
                                    this.bqS.aKa = "";
                                    return;
                                }
                                return;
                            }
                            c(this.oir.sex != 2, "选" + this.oir.select, false);
                            this.oiq.setVisibility(0);
                            return;
                        } else if (this.oir.select != 0) {
                            zn(this.oir.sex != 2);
                            this.oiq.setVisibility(0);
                            return;
                        } else {
                            return;
                        }
                    case 3:
                        if (this.oir.select == 0) {
                            this.oiq.setVisibility(0);
                            eaz();
                            return;
                        } else if (eau) {
                            this.oiq.setVisibility(0);
                            c(this.oir.sex != 2, "选" + this.oir.select, this.oir.publish == 0);
                            return;
                        } else if (isSelf()) {
                            c(this.oir.sex != 2, "选" + this.oir.select, false);
                            this.oiq.setVisibility(0);
                            return;
                        } else if (this.oir.publish == 1) {
                            c(this.oir.sex != 2, "选" + this.oir.select, false);
                            this.oiq.setVisibility(0);
                            return;
                        } else if (this.oir.publish == 0) {
                            zn(this.oir.sex != 2);
                            this.oiq.setVisibility(0);
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
        return this.oir.uk.equals(g.Xm());
    }

    public void a(SimpleDraweeView simpleDraweeView, String str) {
        simpleDraweeView.setController(c.ekS().bn(ImageRequest.Yr(str)).Af(true).c(simpleDraweeView.getController()).elJ());
    }

    public void zn(boolean z) {
        if (this.oiq != null) {
            this.oiq.setVisibility(0);
            this.oiq.zn(z);
        }
    }

    public void c(boolean z, String str, boolean z2) {
        if (this.oiq != null) {
            this.oiq.setVisibility(0);
            this.oiq.c(z, str, z2);
        }
    }

    public void eaz() {
        if (this.oiq != null) {
            this.oiq.setVisibility(0);
            this.oiq.eaz();
        }
    }

    public AlaWheatInfoData getAlaWheatInfoData() {
        return this.oir;
    }

    public void setOnItemClickListener(BaseWheatLayout.a aVar) {
        this.ohy = aVar;
    }

    public void setChooseLoverBgView(boolean z) {
        if (this.ois != null) {
            this.ois.setVisibility(z ? 0 : 8);
        }
    }

    public void eaL() {
        if (this.oiq != null) {
            this.oiq.dS(this.oiq);
            c(this.oir.sex != 2, "选" + this.oir.select, false);
            this.oiq.setVisibility(0);
        }
    }

    public void setDialogLister(a aVar) {
        this.oit = aVar;
    }
}
