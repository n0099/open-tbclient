package com.baidu.tieba.yuyinala.view;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tieba.view.BarImageView;
import com.baidu.tieba.yuyinala.AlaRankListActivity;
import com.baidu.tieba.yuyinala.data.g;
import com.baidu.tieba.yuyinala.view.b;
import com.tencent.connect.common.Constants;
/* loaded from: classes11.dex */
public class a {
    private View contentView;
    private TextView ibW;
    private TextView iiA;
    private TextView iiC;
    private TextView iiD;
    private TextView iiE;
    private LottieAnimationView ijB;
    private String mRoomId;
    private View mRootView;
    private BarImageView oNH;
    private b.a oNI;
    private FrameLayout oNJ;
    private AlaRankListActivity ooW;

    public a(AlaRankListActivity alaRankListActivity, String str) {
        this.ooW = alaRankListActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.ooW).inflate(a.g.yuyin_ala_rank_list_hot_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.content_view);
        this.iiA = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.oNH = (BarImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
        this.ibW = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.iiC = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
        this.iiD = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info_extra);
        this.iiE = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
        this.ijB = (LottieAnimationView) this.mRootView.findViewById(a.f.rank_live_anim);
        this.oNJ = (FrameLayout) this.mRootView.findViewById(a.f.ll_living);
        this.iiE.setOnTouchListener(new d());
        this.iiE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.oNI != null) {
                    a.this.ooW.finish();
                    a.this.oNI.en(view);
                }
            }
        });
        if (this.oNH != null) {
            this.oNH.setShowOval(true);
            this.oNH.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(b.a aVar) {
        this.oNI = aVar;
    }

    public void a(g gVar) {
        int i = 10;
        if (gVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            this.oNJ.setVisibility(8);
            if (gVar.aGz <= 0) {
                spannableStringBuilder.append((CharSequence) this.ooW.getString(a.h.yuyin_bottom_rank_list_bottom_no_money));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                this.iiA.setText("未上榜");
                this.iiA.setTextSize(10.0f);
                this.iiD.setVisibility(0);
                this.iiD.setText(spannableStringBuilder);
            } else {
                int i2 = gVar.aGy;
                this.iiA.setText(i2 + "");
                this.iiA.setTextSize(18.0f);
                if (i2 == 1) {
                    if (gVar.aGC) {
                        this.iiD.setVisibility(8);
                    } else {
                        String format = String.format(this.ooW.getString(a.h.yuyin_bottom_rank_list_bottom_1), StringHelper.formatYuyinValue(gVar.aGz - gVar.aGB) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                        this.iiD.setVisibility(0);
                        this.iiD.setText(spannableStringBuilder);
                    }
                } else if (gVar.aGy >= 2 && gVar.aGy <= 10) {
                    String str = StringHelper.formatYuyinValue((gVar.aGA - gVar.aGz) + 1) + "";
                    spannableStringBuilder.append((CharSequence) String.format(this.ooW.getString(a.h.yuyin_bottom_rank_list_bottom__in), str));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    this.iiD.setVisibility(0);
                    this.iiD.setText(spannableStringBuilder);
                } else if (gVar.aGy > 10) {
                    String format2 = String.format(this.ooW.getString(a.h.yuyin_bottom_rank_list_bottom_out), Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, StringHelper.formatYuyinValue((gVar.aGD - gVar.aGz) + 1) + "");
                    spannableStringBuilder.append((CharSequence) format2);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), Constants.VIA_REPORT_TYPE_SHARE_TO_QQ.length() + 4, format2.length(), 34);
                    this.iiD.setVisibility(0);
                    this.iiD.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(gVar.cover)) {
                this.oNH.startLoad(gVar.cover, 12, false);
            }
            if (!StringUtils.isNull(gVar.getNameShow())) {
                String nameShow = gVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(gVar.getNameShow());
                i = (this.iiC == null || StringUtils.isNull(this.iiC.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.ooW.getString(a.h.yuyin_ala_rank_list_bottom_user_name_limit), TextHelper.subStringWithEmoji(gVar.getNameShow(), i));
                }
                this.ibW.setText(nameShow);
            }
            this.iiE.setVisibility(0);
        }
    }
}
