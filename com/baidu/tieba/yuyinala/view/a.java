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
    private TextView hGx;
    private TextView hLk;
    private TextView hLm;
    private TextView hLn;
    private TextView hLo;
    private LottieAnimationView hMl;
    private String mRoomId;
    private View mRootView;
    private AlaRankListActivity nRy;
    private BarImageView ojJ;
    private b.a ojK;
    private FrameLayout ojL;

    public a(AlaRankListActivity alaRankListActivity, String str) {
        this.nRy = alaRankListActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.nRy).inflate(a.g.yuyin_ala_rank_list_hot_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.content_view);
        this.hLk = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.ojJ = (BarImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
        this.hGx = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.hLm = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
        this.hLn = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info_extra);
        this.hLo = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
        this.hMl = (LottieAnimationView) this.mRootView.findViewById(a.f.rank_live_anim);
        this.ojL = (FrameLayout) this.mRootView.findViewById(a.f.ll_living);
        this.hLo.setOnTouchListener(new d());
        this.hLo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ojK != null) {
                    a.this.nRy.finish();
                    a.this.ojK.dN(view);
                }
            }
        });
        if (this.ojJ != null) {
            this.ojJ.setShowOval(true);
            this.ojJ.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(b.a aVar) {
        this.ojK = aVar;
    }

    public void a(g gVar) {
        int i = 10;
        if (gVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            this.ojL.setVisibility(8);
            if (gVar.aId <= 0) {
                spannableStringBuilder.append((CharSequence) this.nRy.getString(a.h.yuyin_bottom_rank_list_bottom_no_money));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                this.hLk.setText("未上榜");
                this.hLk.setTextSize(10.0f);
                this.hLn.setVisibility(0);
                this.hLn.setText(spannableStringBuilder);
            } else {
                int i2 = gVar.aIc;
                this.hLk.setText(i2 + "");
                this.hLk.setTextSize(18.0f);
                if (i2 == 1) {
                    if (gVar.aIg) {
                        this.hLn.setVisibility(8);
                    } else {
                        String format = String.format(this.nRy.getString(a.h.yuyin_bottom_rank_list_bottom_1), StringHelper.formatYuyinValue(gVar.aId - gVar.aIf) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                        this.hLn.setVisibility(0);
                        this.hLn.setText(spannableStringBuilder);
                    }
                } else if (gVar.aIc >= 2 && gVar.aIc <= 10) {
                    String str = StringHelper.formatYuyinValue((gVar.aIe - gVar.aId) + 1) + "";
                    spannableStringBuilder.append((CharSequence) String.format(this.nRy.getString(a.h.yuyin_bottom_rank_list_bottom__in), str));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    this.hLn.setVisibility(0);
                    this.hLn.setText(spannableStringBuilder);
                } else if (gVar.aIc > 10) {
                    String format2 = String.format(this.nRy.getString(a.h.yuyin_bottom_rank_list_bottom_out), "10", StringHelper.formatYuyinValue((gVar.aIh - gVar.aId) + 1) + "");
                    spannableStringBuilder.append((CharSequence) format2);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "10".length() + 4, format2.length(), 34);
                    this.hLn.setVisibility(0);
                    this.hLn.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(gVar.cover)) {
                this.ojJ.startLoad(gVar.cover, 12, false);
            }
            if (!StringUtils.isNull(gVar.getNameShow())) {
                String nameShow = gVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(gVar.getNameShow());
                i = (this.hLm == null || StringUtils.isNull(this.hLm.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.nRy.getString(a.h.yuyin_ala_rank_list_bottom_user_name_limit), TextHelper.subStringWithEmoji(gVar.getNameShow(), i));
                }
                this.hGx.setText(nameShow);
            }
            this.hLo.setVisibility(0);
        }
    }
}
