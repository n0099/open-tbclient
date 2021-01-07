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
    private TextView icj;
    private TextView iin;
    private TextView iip;
    private TextView iiq;
    private TextView iir;
    private LottieAnimationView ijo;
    private String mRoomId;
    private View mRootView;
    private BarImageView oIc;
    private b.a oId;
    private FrameLayout oIe;
    private AlaRankListActivity ojI;

    public a(AlaRankListActivity alaRankListActivity, String str) {
        this.ojI = alaRankListActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.ojI).inflate(a.g.yuyin_ala_rank_list_hot_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.content_view);
        this.iin = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.oIc = (BarImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
        this.icj = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.iip = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
        this.iiq = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info_extra);
        this.iir = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
        this.ijo = (LottieAnimationView) this.mRootView.findViewById(a.f.rank_live_anim);
        this.oIe = (FrameLayout) this.mRootView.findViewById(a.f.ll_living);
        this.iir.setOnTouchListener(new d());
        this.iir.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.oId != null) {
                    a.this.ojI.finish();
                    a.this.oId.ep(view);
                }
            }
        });
        if (this.oIc != null) {
            this.oIc.setShowOval(true);
            this.oIc.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(b.a aVar) {
        this.oId = aVar;
    }

    public void a(g gVar) {
        int i = 10;
        if (gVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            this.oIe.setVisibility(8);
            if (gVar.aJz <= 0) {
                spannableStringBuilder.append((CharSequence) this.ojI.getString(a.h.yuyin_bottom_rank_list_bottom_no_money));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                this.iin.setText("未上榜");
                this.iin.setTextSize(10.0f);
                this.iiq.setVisibility(0);
                this.iiq.setText(spannableStringBuilder);
            } else {
                int i2 = gVar.aJy;
                this.iin.setText(i2 + "");
                this.iin.setTextSize(18.0f);
                if (i2 == 1) {
                    if (gVar.aJC) {
                        this.iiq.setVisibility(8);
                    } else {
                        String format = String.format(this.ojI.getString(a.h.yuyin_bottom_rank_list_bottom_1), StringHelper.formatYuyinValue(gVar.aJz - gVar.aJB) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                        this.iiq.setVisibility(0);
                        this.iiq.setText(spannableStringBuilder);
                    }
                } else if (gVar.aJy >= 2 && gVar.aJy <= 10) {
                    String str = StringHelper.formatYuyinValue((gVar.aJA - gVar.aJz) + 1) + "";
                    spannableStringBuilder.append((CharSequence) String.format(this.ojI.getString(a.h.yuyin_bottom_rank_list_bottom__in), str));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    this.iiq.setVisibility(0);
                    this.iiq.setText(spannableStringBuilder);
                } else if (gVar.aJy > 10) {
                    String format2 = String.format(this.ojI.getString(a.h.yuyin_bottom_rank_list_bottom_out), Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, StringHelper.formatYuyinValue((gVar.aJD - gVar.aJz) + 1) + "");
                    spannableStringBuilder.append((CharSequence) format2);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), Constants.VIA_REPORT_TYPE_SHARE_TO_QQ.length() + 4, format2.length(), 34);
                    this.iiq.setVisibility(0);
                    this.iiq.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(gVar.cover)) {
                this.oIc.startLoad(gVar.cover, 12, false);
            }
            if (!StringUtils.isNull(gVar.getNameShow())) {
                String nameShow = gVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(gVar.getNameShow());
                i = (this.iip == null || StringUtils.isNull(this.iip.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.ojI.getString(a.h.yuyin_ala_rank_list_bottom_user_name_limit), TextHelper.subStringWithEmoji(gVar.getNameShow(), i));
                }
                this.icj.setText(nameShow);
            }
            this.iir.setVisibility(0);
        }
    }
}
