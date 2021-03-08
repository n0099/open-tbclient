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
/* loaded from: classes10.dex */
public class SingleWheatItemView extends BaseWheatItemView {
    private TextView gFq;
    private HeadImageView oKl;
    private SimpleDraweeView oNA;
    private SimpleDraweeView oNK;
    private TBLottieAnimationView oNL;
    private RelativeLayout oNM;
    private ImageView oNN;
    private ImageView oNO;
    private AlaEmoticonView oNP;

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
        this.oNL = (TBLottieAnimationView) findViewById(a.f.speeding_lottieAnimationView);
        this.oNM = (RelativeLayout) findViewById(a.f.user_avatar_container);
        this.oKl = (HeadImageView) findViewById(a.f.user_avatar);
        this.oNN = (ImageView) findViewById(a.f.iv_user_gender);
        this.oNO = (ImageView) findViewById(a.f.iv_mute);
        this.oNK = (SimpleDraweeView) findViewById(a.f.hat_emoticon_iv);
        this.oNA = (SimpleDraweeView) findViewById(a.f.frame_emoticon_iv);
        this.gFq = (TextView) findViewById(a.f.anchor_name);
        this.oNP = (AlaEmoticonView) findViewById(a.f.ala_emoticon_view);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatItemView
    protected int getLayoutViewId() {
        return a.g.yuyinala_liveroom_single_wheat_item_layout;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatItemView
    public void setData(final AlaWheatInfoData alaWheatInfoData, int i, final boolean z, ab abVar) {
        String str;
        this.gFq.setText("");
        this.oMM = alaWheatInfoData;
        this.bzn = abVar;
        if (this.oMM == null) {
            if (this.oNL.getVisibility() == 0) {
                this.oNL.cancelAnimation();
                this.oNL.setVisibility(8);
            }
            this.oNN.setSelected(false);
            this.oNN.setVisibility(8);
            this.oKl.setIsRound(false);
            this.oKl.setDrawBorder(false);
            this.oKl.setAutoChangeStyle(false);
            this.oKl.setScaleType(ImageView.ScaleType.FIT_XY);
            this.oKl.setImageResource(0);
            this.oKl.setBackgroundResource(0);
            if (q.edU().Yn()) {
                this.oKl.setImageResource(a.e.yuyin_sdk_connection_single_wheat_empty_host);
                this.gFq.setText(getContext().getResources().getString(a.h.yuyin_ala_connection_single_wheat_host_wheat_text));
            } else {
                this.oKl.setImageResource(a.e.yuyin_sdk_connection_single_wheat_empty_anchor);
                this.gFq.setText(getContext().getResources().getString(a.h.yuyin_ala_connection_single_wheat_anchor_wheat_text));
            }
            this.gFq.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha70));
            this.oNM.setTag(Integer.valueOf(i));
            this.oNO.setVisibility(8);
            this.oNK.setVisibility(8);
            this.oNA.setVisibility(8);
        } else {
            this.gFq.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
            this.oNN.setVisibility(0);
            this.oNN.setSelected(alaWheatInfoData.isFemale());
            this.oKl.setScaleType(ImageView.ScaleType.FIT_XY);
            this.oKl.setImageResource(0);
            this.oKl.setBackgroundResource(0);
            this.oKl.setIsRound(true);
            this.oKl.setDrawBorder(false);
            this.oKl.setAutoChangeStyle(false);
            this.oKl.setDefaultResource(a.e.sdk_icon_default_avatar100);
            this.oKl.setUrl(alaWheatInfoData.bigPortrait);
            if (this.oKl.getBdImage() != null && this.oKl.getBdImage().getImage() != null && !this.oKl.getBdImage().getImage().isRecycled()) {
                this.oKl.setImageBitmap(this.oKl.getBdImage().getImage());
            }
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
            this.gFq.setText(alaWheatInfoData.userName);
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
        this.oNM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.SingleWheatItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (SingleWheatItemView.this.oMN != null) {
                    if (SingleWheatItemView.this.bzn != null && SingleWheatItemView.this.bzn.aKO) {
                        SingleWheatItemView.this.oMN.a(alaWheatInfoData, z, intValue);
                    } else {
                        BdUtilHelper.showToast(SingleWheatItemView.this.getContext(), "正在获取数据，请稍等");
                    }
                }
            }
        });
        this.oNP.setEmoticonListener(new AlaEmoticonView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.SingleWheatItemView.2
            @Override // com.baidu.live.tieba.view.AlaEmoticonView.a
            public void Uh() {
                int i2;
                if (!(SingleWheatItemView.this.oNP.getTag() instanceof String) || StringUtils.isNull((String) SingleWheatItemView.this.oNP.getTag(), true)) {
                    i2 = 0;
                } else {
                    i2 = 1000;
                }
                SingleWheatItemView.this.oNP.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.SingleWheatItemView.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SingleWheatItemView.this.oNP.setVisibility(8);
                        SingleWheatItemView.this.oNP.setTag(null);
                    }
                }, i2);
            }
        });
    }
}
