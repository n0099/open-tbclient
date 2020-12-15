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
    private TextView hPN;
    private TextView hVN;
    private TextView hVP;
    private TextView hVQ;
    private TextView hVR;
    private LottieAnimationView hWO;
    private String mRoomId;
    private View mRootView;
    private BarImageView oAo;
    private b.a oAp;
    private FrameLayout oAq;
    private AlaRankListActivity oib;

    public a(AlaRankListActivity alaRankListActivity, String str) {
        this.oib = alaRankListActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.oib).inflate(a.g.yuyin_ala_rank_list_hot_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.content_view);
        this.hVN = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.oAo = (BarImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
        this.hPN = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.hVP = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
        this.hVQ = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info_extra);
        this.hVR = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
        this.hWO = (LottieAnimationView) this.mRootView.findViewById(a.f.rank_live_anim);
        this.oAq = (FrameLayout) this.mRootView.findViewById(a.f.ll_living);
        this.hVR.setOnTouchListener(new d());
        this.hVR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.oAp != null) {
                    a.this.oib.finish();
                    a.this.oAp.ef(view);
                }
            }
        });
        if (this.oAo != null) {
            this.oAo.setShowOval(true);
            this.oAo.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(b.a aVar) {
        this.oAp = aVar;
    }

    public void a(g gVar) {
        int i = 10;
        if (gVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            this.oAq.setVisibility(8);
            if (gVar.aJb <= 0) {
                spannableStringBuilder.append((CharSequence) this.oib.getString(a.h.yuyin_bottom_rank_list_bottom_no_money));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                this.hVN.setText("未上榜");
                this.hVN.setTextSize(10.0f);
                this.hVQ.setVisibility(0);
                this.hVQ.setText(spannableStringBuilder);
            } else {
                int i2 = gVar.aJa;
                this.hVN.setText(i2 + "");
                this.hVN.setTextSize(18.0f);
                if (i2 == 1) {
                    if (gVar.aJe) {
                        this.hVQ.setVisibility(8);
                    } else {
                        String format = String.format(this.oib.getString(a.h.yuyin_bottom_rank_list_bottom_1), StringHelper.formatYuyinValue(gVar.aJb - gVar.aJd) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                        this.hVQ.setVisibility(0);
                        this.hVQ.setText(spannableStringBuilder);
                    }
                } else if (gVar.aJa >= 2 && gVar.aJa <= 10) {
                    String str = StringHelper.formatYuyinValue((gVar.aJc - gVar.aJb) + 1) + "";
                    spannableStringBuilder.append((CharSequence) String.format(this.oib.getString(a.h.yuyin_bottom_rank_list_bottom__in), str));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    this.hVQ.setVisibility(0);
                    this.hVQ.setText(spannableStringBuilder);
                } else if (gVar.aJa > 10) {
                    String format2 = String.format(this.oib.getString(a.h.yuyin_bottom_rank_list_bottom_out), "10", StringHelper.formatYuyinValue((gVar.aJf - gVar.aJb) + 1) + "");
                    spannableStringBuilder.append((CharSequence) format2);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "10".length() + 4, format2.length(), 34);
                    this.hVQ.setVisibility(0);
                    this.hVQ.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(gVar.cover)) {
                this.oAo.startLoad(gVar.cover, 12, false);
            }
            if (!StringUtils.isNull(gVar.getNameShow())) {
                String nameShow = gVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(gVar.getNameShow());
                i = (this.hVP == null || StringUtils.isNull(this.hVP.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.oib.getString(a.h.yuyin_ala_rank_list_bottom_user_name_limit), TextHelper.subStringWithEmoji(gVar.getNameShow(), i));
                }
                this.hPN.setText(nameShow);
            }
            this.hVR.setVisibility(0);
        }
    }
}
