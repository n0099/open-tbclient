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
    private TextView hGe;
    private TextView hKR;
    private TextView hKT;
    private TextView hKU;
    private TextView hKV;
    private LottieAnimationView hLS;
    private String mRoomId;
    private View mRootView;
    private AlaRankListActivity nTb;
    private BarImageView olm;
    private b.a oln;
    private FrameLayout olo;

    public a(AlaRankListActivity alaRankListActivity, String str) {
        this.nTb = alaRankListActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.nTb).inflate(a.g.yuyin_ala_rank_list_hot_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.content_view);
        this.hKR = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.olm = (BarImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
        this.hGe = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.hKT = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
        this.hKU = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info_extra);
        this.hKV = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
        this.hLS = (LottieAnimationView) this.mRootView.findViewById(a.f.rank_live_anim);
        this.olo = (FrameLayout) this.mRootView.findViewById(a.f.ll_living);
        this.hKV.setOnTouchListener(new d());
        this.hKV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.oln != null) {
                    a.this.nTb.finish();
                    a.this.oln.dU(view);
                }
            }
        });
        if (this.olm != null) {
            this.olm.setShowOval(true);
            this.olm.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(b.a aVar) {
        this.oln = aVar;
    }

    public void a(g gVar) {
        int i = 10;
        if (gVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            this.olo.setVisibility(8);
            if (gVar.aGs <= 0) {
                spannableStringBuilder.append((CharSequence) this.nTb.getString(a.h.yuyin_bottom_rank_list_bottom_no_money));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                this.hKR.setText("未上榜");
                this.hKR.setTextSize(10.0f);
                this.hKU.setVisibility(0);
                this.hKU.setText(spannableStringBuilder);
            } else {
                int i2 = gVar.aGr;
                this.hKR.setText(i2 + "");
                this.hKR.setTextSize(18.0f);
                if (i2 == 1) {
                    if (gVar.aGv) {
                        this.hKU.setVisibility(8);
                    } else {
                        String format = String.format(this.nTb.getString(a.h.yuyin_bottom_rank_list_bottom_1), StringHelper.formatYuyinValue(gVar.aGs - gVar.aGu) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                        this.hKU.setVisibility(0);
                        this.hKU.setText(spannableStringBuilder);
                    }
                } else if (gVar.aGr >= 2 && gVar.aGr <= 10) {
                    String str = StringHelper.formatYuyinValue((gVar.aGt - gVar.aGs) + 1) + "";
                    spannableStringBuilder.append((CharSequence) String.format(this.nTb.getString(a.h.yuyin_bottom_rank_list_bottom__in), str));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    this.hKU.setVisibility(0);
                    this.hKU.setText(spannableStringBuilder);
                } else if (gVar.aGr > 10) {
                    String format2 = String.format(this.nTb.getString(a.h.yuyin_bottom_rank_list_bottom_out), "10", StringHelper.formatYuyinValue((gVar.aGw - gVar.aGs) + 1) + "");
                    spannableStringBuilder.append((CharSequence) format2);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "10".length() + 4, format2.length(), 34);
                    this.hKU.setVisibility(0);
                    this.hKU.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(gVar.cover)) {
                this.olm.startLoad(gVar.cover, 12, false);
            }
            if (!StringUtils.isNull(gVar.getNameShow())) {
                String nameShow = gVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(gVar.getNameShow());
                i = (this.hKT == null || StringUtils.isNull(this.hKT.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.nTb.getString(a.h.yuyin_ala_rank_list_bottom_user_name_limit), TextHelper.subStringWithEmoji(gVar.getNameShow(), i));
                }
                this.hGe.setText(nameShow);
            }
            this.hKV.setVisibility(0);
        }
    }
}
