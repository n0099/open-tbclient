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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tieba.view.BarImageView;
import com.baidu.tieba.yuyinala.AlaRankListActivity;
import com.baidu.tieba.yuyinala.data.g;
import com.baidu.tieba.yuyinala.view.b;
import com.tb.airbnb.lottie.LottieAnimationView;
/* loaded from: classes4.dex */
public class a {
    private View contentView;
    private TextView hAA;
    private TextView hFn;
    private TextView hFp;
    private TextView hFq;
    private TextView hFr;
    private LottieAnimationView hGo;
    private String mRoomId;
    private View mRootView;
    private AlaRankListActivity nLE;
    private BarImageView oaD;
    private b.a oaE;
    private FrameLayout oaF;

    public a(AlaRankListActivity alaRankListActivity, String str) {
        this.nLE = alaRankListActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.nLE).inflate(a.h.yuyin_ala_rank_list_hot_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.g.content_view);
        this.hFn = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
        this.oaD = (BarImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
        this.hAA = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
        this.hFp = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
        this.hFq = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info_extra);
        this.hFr = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
        this.hGo = (LottieAnimationView) this.mRootView.findViewById(a.g.rank_live_anim);
        this.oaF = (FrameLayout) this.mRootView.findViewById(a.g.ll_living);
        this.hFr.setOnTouchListener(new d());
        this.hFr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.oaE != null) {
                    a.this.nLE.finish();
                    a.this.oaE.dI(view);
                }
            }
        });
        if (this.oaD != null) {
            this.oaD.setShowOval(true);
            this.oaD.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(b.a aVar) {
        this.oaE = aVar;
    }

    public void a(g gVar) {
        int i = 10;
        if (gVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            this.oaF.setVisibility(8);
            if (gVar.aHm <= 0) {
                spannableStringBuilder.append((CharSequence) this.nLE.getString(a.i.yuyin_bottom_rank_list_bottom_no_money));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                this.hFn.setText("未上榜");
                this.hFn.setTextSize(10.0f);
            } else {
                int i2 = gVar.aHl;
                this.hFn.setText(i2 + "");
                this.hFn.setTextSize(18.0f);
                if (i2 == 1) {
                    if (gVar.aHp) {
                        this.hFq.setVisibility(8);
                    } else {
                        String format = String.format(this.nLE.getString(a.i.yuyin_bottom_rank_list_bottom_1), StringHelper.formatYuyinValue(gVar.aHm - gVar.aHo) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                        this.hFq.setVisibility(0);
                        this.hFq.setText(spannableStringBuilder);
                    }
                } else if (gVar.aHl >= 2 && gVar.aHl <= 10) {
                    String str = StringHelper.formatYuyinValue((gVar.aHn - gVar.aHm) + 1) + "";
                    spannableStringBuilder.append((CharSequence) String.format(this.nLE.getString(a.i.yuyin_bottom_rank_list_bottom__in), str));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    this.hFq.setVisibility(0);
                    this.hFq.setText(spannableStringBuilder);
                } else if (gVar.aHl > 10) {
                    String format2 = String.format(this.nLE.getString(a.i.yuyin_bottom_rank_list_bottom_out), "10", StringHelper.formatYuyinValue((gVar.aHq - gVar.aHm) + 1) + "");
                    spannableStringBuilder.append((CharSequence) format2);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "10".length() + 4, format2.length(), 34);
                    this.hFq.setVisibility(0);
                    this.hFq.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(gVar.cover)) {
                this.oaD.startLoad(gVar.cover, 12, false);
            }
            if (!StringUtils.isNull(gVar.getNameShow())) {
                String nameShow = gVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(gVar.getNameShow());
                i = (this.hFp == null || StringUtils.isNull(this.hFp.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.nLE.getString(a.i.yuyin_ala_rank_list_bottom_user_name_limit), TextHelper.subStringWithEmoji(gVar.getNameShow(), i));
                }
                this.hAA.setText(nameShow);
            }
            this.hFr.setVisibility(0);
        }
    }
}
