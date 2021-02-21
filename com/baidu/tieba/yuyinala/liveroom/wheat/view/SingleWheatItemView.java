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
    private TextView gDH;
    private HeadImageView oIg;
    private SimpleDraweeView oLF;
    private TBLottieAnimationView oLG;
    private RelativeLayout oLH;
    private ImageView oLI;
    private ImageView oLJ;
    private AlaEmoticonView oLK;
    private SimpleDraweeView oLv;

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
        this.oLG = (TBLottieAnimationView) findViewById(a.f.speeding_lottieAnimationView);
        this.oLH = (RelativeLayout) findViewById(a.f.user_avatar_container);
        this.oIg = (HeadImageView) findViewById(a.f.user_avatar);
        this.oLI = (ImageView) findViewById(a.f.iv_user_gender);
        this.oLJ = (ImageView) findViewById(a.f.iv_mute);
        this.oLF = (SimpleDraweeView) findViewById(a.f.hat_emoticon_iv);
        this.oLv = (SimpleDraweeView) findViewById(a.f.frame_emoticon_iv);
        this.gDH = (TextView) findViewById(a.f.anchor_name);
        this.oLK = (AlaEmoticonView) findViewById(a.f.ala_emoticon_view);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatItemView
    protected int getLayoutViewId() {
        return a.g.yuyinala_liveroom_single_wheat_item_layout;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatItemView
    public void setData(final AlaWheatInfoData alaWheatInfoData, int i, final boolean z, ab abVar) {
        String str;
        this.gDH.setText("");
        this.oKH = alaWheatInfoData;
        this.bxN = abVar;
        if (this.oKH == null) {
            if (this.oLG.getVisibility() == 0) {
                this.oLG.cancelAnimation();
                this.oLG.setVisibility(8);
            }
            this.oLI.setSelected(false);
            this.oLI.setVisibility(8);
            this.oIg.setIsRound(false);
            this.oIg.setDrawBorder(false);
            this.oIg.setAutoChangeStyle(false);
            this.oIg.setScaleType(ImageView.ScaleType.FIT_XY);
            this.oIg.setImageResource(0);
            this.oIg.setBackgroundResource(0);
            if (q.edM().Yk()) {
                this.oIg.setImageResource(a.e.yuyin_sdk_connection_single_wheat_empty_host);
                this.gDH.setText(getContext().getResources().getString(a.h.yuyin_ala_connection_single_wheat_host_wheat_text));
            } else {
                this.oIg.setImageResource(a.e.yuyin_sdk_connection_single_wheat_empty_anchor);
                this.gDH.setText(getContext().getResources().getString(a.h.yuyin_ala_connection_single_wheat_anchor_wheat_text));
            }
            this.gDH.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha70));
            this.oLH.setTag(Integer.valueOf(i));
            this.oLJ.setVisibility(8);
            this.oLF.setVisibility(8);
            this.oLv.setVisibility(8);
        } else {
            this.gDH.setTextColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
            this.oLI.setVisibility(0);
            this.oLI.setSelected(alaWheatInfoData.isFemale());
            this.oIg.setScaleType(ImageView.ScaleType.FIT_XY);
            this.oIg.setImageResource(0);
            this.oIg.setBackgroundResource(0);
            this.oIg.setIsRound(true);
            this.oIg.setDrawBorder(false);
            this.oIg.setAutoChangeStyle(false);
            this.oIg.setDefaultResource(a.e.sdk_icon_default_avatar100);
            this.oIg.setUrl(alaWheatInfoData.bigPortrait);
            if (this.oIg.getBdImage() != null && this.oIg.getBdImage().getImage() != null && !this.oIg.getBdImage().getImage().isRecycled()) {
                this.oIg.setImageBitmap(this.oIg.getBdImage().getImage());
            }
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
            this.gDH.setText(alaWheatInfoData.userName);
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
        this.oLH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.SingleWheatItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (SingleWheatItemView.this.oKI != null) {
                    if (SingleWheatItemView.this.bxN != null && SingleWheatItemView.this.bxN.aJo) {
                        SingleWheatItemView.this.oKI.a(alaWheatInfoData, z, intValue);
                    } else {
                        BdUtilHelper.showToast(SingleWheatItemView.this.getContext(), "正在获取数据，请稍等");
                    }
                }
            }
        });
        this.oLK.setEmoticonListener(new AlaEmoticonView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.SingleWheatItemView.2
            @Override // com.baidu.live.tieba.view.AlaEmoticonView.a
            public void Ue() {
                int i2;
                if (!(SingleWheatItemView.this.oLK.getTag() instanceof String) || StringUtils.isNull((String) SingleWheatItemView.this.oLK.getTag(), true)) {
                    i2 = 0;
                } else {
                    i2 = 1000;
                }
                SingleWheatItemView.this.oLK.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.SingleWheatItemView.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SingleWheatItemView.this.oLK.setVisibility(8);
                        SingleWheatItemView.this.oLK.setTag(null);
                    }
                }, i2);
            }
        });
    }
}
