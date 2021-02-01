package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
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
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.live.tieba.view.AlaEmoticonView;
import com.baidu.live.tieba.view.fresco.SimpleDraweeView;
import com.baidu.tieba.yuyinala.liveroom.wheat.c.q;
/* loaded from: classes11.dex */
public class SingleWheatItemView extends BaseWheatItemView {
    private TextView gDt;
    private HeadImageView oHG;
    private SimpleDraweeView oKV;
    private SimpleDraweeView oLf;
    private TBLottieAnimationView oLg;
    private RelativeLayout oLh;
    private ImageView oLi;
    private ImageView oLj;
    private AlaEmoticonView oLk;

    public SingleWheatItemView(@NonNull Context context) {
        this(context, null);
    }

    public SingleWheatItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SingleWheatItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatItemView
    protected void initView() {
        this.oLg = (TBLottieAnimationView) findViewById(a.f.speeding_lottieAnimationView);
        this.oLh = (RelativeLayout) findViewById(a.f.user_avatar_container);
        this.oHG = (HeadImageView) findViewById(a.f.user_avatar);
        this.oLi = (ImageView) findViewById(a.f.iv_user_gender);
        this.oLj = (ImageView) findViewById(a.f.iv_mute);
        this.oLf = (SimpleDraweeView) findViewById(a.f.hat_emoticon_iv);
        this.oKV = (SimpleDraweeView) findViewById(a.f.frame_emoticon_iv);
        this.gDt = (TextView) findViewById(a.f.anchor_name);
        this.oLk = (AlaEmoticonView) findViewById(a.f.ala_emoticon_view);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatItemView
    protected int getLayoutViewId() {
        return a.g.yuyinala_liveroom_single_wheat_item_layout;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatItemView
    public void setData(final AlaWheatInfoData alaWheatInfoData, int i, final boolean z, ab abVar) {
        String str;
        this.gDt.setText("");
        this.oKh = alaWheatInfoData;
        this.bxN = abVar;
        if (this.oKh == null) {
            if (this.oLg.getVisibility() == 0) {
                this.oLg.cancelAnimation();
                this.oLg.setVisibility(8);
            }
            this.oLi.setSelected(false);
            this.oLi.setVisibility(8);
            this.oHG.setIsRound(false);
            this.oHG.setDrawBorder(false);
            this.oHG.setAutoChangeStyle(false);
            this.oHG.setScaleType(ImageView.ScaleType.FIT_XY);
            this.oHG.setImageResource(0);
            this.oHG.setBackgroundResource(0);
            if (q.edE().Yk()) {
                this.oHG.setImageResource(a.e.yuyin_sdk_connection_single_wheat_empty_host);
                this.gDt.setText(getContext().getResources().getString(a.h.yuyin_ala_connection_single_wheat_host_wheat_text));
            } else {
                this.oHG.setImageResource(a.e.yuyin_sdk_connection_single_wheat_empty_anchor);
                this.gDt.setText(getContext().getResources().getString(a.h.yuyin_ala_connection_single_wheat_anchor_wheat_text));
            }
            this.gDt.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha70));
            this.oLh.setTag(Integer.valueOf(i));
            this.oLj.setVisibility(8);
            this.oLf.setVisibility(8);
            this.oKV.setVisibility(8);
        } else {
            this.gDt.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
            this.oLi.setVisibility(0);
            this.oLi.setSelected(alaWheatInfoData.isFemale());
            this.oHG.setScaleType(ImageView.ScaleType.FIT_XY);
            this.oHG.setImageResource(0);
            this.oHG.setBackgroundResource(0);
            this.oHG.setIsRound(true);
            this.oHG.setDrawBorder(false);
            this.oHG.setAutoChangeStyle(false);
            this.oHG.setDefaultResource(a.e.sdk_icon_default_avatar100);
            this.oHG.setUrl(alaWheatInfoData.bigPortrait);
            if (this.oHG.getBdImage() != null && this.oHG.getBdImage().getImage() != null && !this.oHG.getBdImage().getImage().isRecycled()) {
                this.oHG.setImageBitmap(this.oHG.getBdImage().getImage());
            }
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
            this.gDt.setText(alaWheatInfoData.userName);
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
        this.oLh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.SingleWheatItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (SingleWheatItemView.this.oKi != null) {
                    if (SingleWheatItemView.this.bxN != null && SingleWheatItemView.this.bxN.aJo) {
                        SingleWheatItemView.this.oKi.a(alaWheatInfoData, z, intValue);
                    } else {
                        BdUtilHelper.showToast(SingleWheatItemView.this.getContext(), "正在获取数据，请稍等");
                    }
                }
            }
        });
        this.oLk.setEmoticonListener(new AlaEmoticonView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.SingleWheatItemView.2
            @Override // com.baidu.live.tieba.view.AlaEmoticonView.a
            public void Ue() {
                int i2;
                if (!(SingleWheatItemView.this.oLk.getTag() instanceof String) || StringUtils.isNull((String) SingleWheatItemView.this.oLk.getTag(), true)) {
                    i2 = 0;
                } else {
                    i2 = 1000;
                }
                SingleWheatItemView.this.oLk.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.SingleWheatItemView.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SingleWheatItemView.this.oLk.setVisibility(8);
                        SingleWheatItemView.this.oLk.setTag(null);
                    }
                }, i2);
            }
        });
    }
}
