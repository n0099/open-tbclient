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
    private TextView hPL;
    private TextView hVL;
    private TextView hVN;
    private TextView hVO;
    private TextView hVP;
    private LottieAnimationView hWM;
    private String mRoomId;
    private View mRootView;
    private BarImageView oAm;
    private b.a oAn;
    private FrameLayout oAo;
    private AlaRankListActivity ohZ;

    public a(AlaRankListActivity alaRankListActivity, String str) {
        this.ohZ = alaRankListActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.ohZ).inflate(a.g.yuyin_ala_rank_list_hot_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.content_view);
        this.hVL = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.oAm = (BarImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
        this.hPL = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.hVN = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
        this.hVO = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info_extra);
        this.hVP = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
        this.hWM = (LottieAnimationView) this.mRootView.findViewById(a.f.rank_live_anim);
        this.oAo = (FrameLayout) this.mRootView.findViewById(a.f.ll_living);
        this.hVP.setOnTouchListener(new d());
        this.hVP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.oAn != null) {
                    a.this.ohZ.finish();
                    a.this.oAn.ef(view);
                }
            }
        });
        if (this.oAm != null) {
            this.oAm.setShowOval(true);
            this.oAm.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(b.a aVar) {
        this.oAn = aVar;
    }

    public void a(g gVar) {
        int i = 10;
        if (gVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            this.oAo.setVisibility(8);
            if (gVar.aJb <= 0) {
                spannableStringBuilder.append((CharSequence) this.ohZ.getString(a.h.yuyin_bottom_rank_list_bottom_no_money));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                this.hVL.setText("未上榜");
                this.hVL.setTextSize(10.0f);
                this.hVO.setVisibility(0);
                this.hVO.setText(spannableStringBuilder);
            } else {
                int i2 = gVar.aJa;
                this.hVL.setText(i2 + "");
                this.hVL.setTextSize(18.0f);
                if (i2 == 1) {
                    if (gVar.aJe) {
                        this.hVO.setVisibility(8);
                    } else {
                        String format = String.format(this.ohZ.getString(a.h.yuyin_bottom_rank_list_bottom_1), StringHelper.formatYuyinValue(gVar.aJb - gVar.aJd) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                        this.hVO.setVisibility(0);
                        this.hVO.setText(spannableStringBuilder);
                    }
                } else if (gVar.aJa >= 2 && gVar.aJa <= 10) {
                    String str = StringHelper.formatYuyinValue((gVar.aJc - gVar.aJb) + 1) + "";
                    spannableStringBuilder.append((CharSequence) String.format(this.ohZ.getString(a.h.yuyin_bottom_rank_list_bottom__in), str));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    this.hVO.setVisibility(0);
                    this.hVO.setText(spannableStringBuilder);
                } else if (gVar.aJa > 10) {
                    String format2 = String.format(this.ohZ.getString(a.h.yuyin_bottom_rank_list_bottom_out), "10", StringHelper.formatYuyinValue((gVar.aJf - gVar.aJb) + 1) + "");
                    spannableStringBuilder.append((CharSequence) format2);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "10".length() + 4, format2.length(), 34);
                    this.hVO.setVisibility(0);
                    this.hVO.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(gVar.cover)) {
                this.oAm.startLoad(gVar.cover, 12, false);
            }
            if (!StringUtils.isNull(gVar.getNameShow())) {
                String nameShow = gVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(gVar.getNameShow());
                i = (this.hVN == null || StringUtils.isNull(this.hVN.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.ohZ.getString(a.h.yuyin_ala_rank_list_bottom_user_name_limit), TextHelper.subStringWithEmoji(gVar.getNameShow(), i));
                }
                this.hPL.setText(nameShow);
            }
            this.hVP.setVisibility(0);
        }
    }
}
