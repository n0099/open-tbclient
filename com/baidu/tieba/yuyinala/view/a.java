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
/* loaded from: classes10.dex */
public class a {
    private View contentView;
    private TextView hXC;
    private TextView idG;
    private TextView idI;
    private TextView idJ;
    private TextView idK;
    private LottieAnimationView ieH;
    private String mRoomId;
    private View mRootView;
    private FrameLayout oDA;
    private BarImageView oDy;
    private b.a oDz;
    private AlaRankListActivity ofd;

    public a(AlaRankListActivity alaRankListActivity, String str) {
        this.ofd = alaRankListActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.ofd).inflate(a.g.yuyin_ala_rank_list_hot_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.content_view);
        this.idG = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.oDy = (BarImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
        this.hXC = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.idI = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
        this.idJ = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info_extra);
        this.idK = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
        this.ieH = (LottieAnimationView) this.mRootView.findViewById(a.f.rank_live_anim);
        this.oDA = (FrameLayout) this.mRootView.findViewById(a.f.ll_living);
        this.idK.setOnTouchListener(new d());
        this.idK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.oDz != null) {
                    a.this.ofd.finish();
                    a.this.oDz.ep(view);
                }
            }
        });
        if (this.oDy != null) {
            this.oDy.setShowOval(true);
            this.oDy.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(b.a aVar) {
        this.oDz = aVar;
    }

    public void a(g gVar) {
        int i = 10;
        if (gVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            this.oDA.setVisibility(8);
            if (gVar.aEM <= 0) {
                spannableStringBuilder.append((CharSequence) this.ofd.getString(a.h.yuyin_bottom_rank_list_bottom_no_money));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                this.idG.setText("未上榜");
                this.idG.setTextSize(10.0f);
                this.idJ.setVisibility(0);
                this.idJ.setText(spannableStringBuilder);
            } else {
                int i2 = gVar.aEL;
                this.idG.setText(i2 + "");
                this.idG.setTextSize(18.0f);
                if (i2 == 1) {
                    if (gVar.aEP) {
                        this.idJ.setVisibility(8);
                    } else {
                        String format = String.format(this.ofd.getString(a.h.yuyin_bottom_rank_list_bottom_1), StringHelper.formatYuyinValue(gVar.aEM - gVar.aEO) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                        this.idJ.setVisibility(0);
                        this.idJ.setText(spannableStringBuilder);
                    }
                } else if (gVar.aEL >= 2 && gVar.aEL <= 10) {
                    String str = StringHelper.formatYuyinValue((gVar.aEN - gVar.aEM) + 1) + "";
                    spannableStringBuilder.append((CharSequence) String.format(this.ofd.getString(a.h.yuyin_bottom_rank_list_bottom__in), str));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    this.idJ.setVisibility(0);
                    this.idJ.setText(spannableStringBuilder);
                } else if (gVar.aEL > 10) {
                    String format2 = String.format(this.ofd.getString(a.h.yuyin_bottom_rank_list_bottom_out), Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, StringHelper.formatYuyinValue((gVar.aEQ - gVar.aEM) + 1) + "");
                    spannableStringBuilder.append((CharSequence) format2);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), Constants.VIA_REPORT_TYPE_SHARE_TO_QQ.length() + 4, format2.length(), 34);
                    this.idJ.setVisibility(0);
                    this.idJ.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(gVar.cover)) {
                this.oDy.startLoad(gVar.cover, 12, false);
            }
            if (!StringUtils.isNull(gVar.getNameShow())) {
                String nameShow = gVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(gVar.getNameShow());
                i = (this.idI == null || StringUtils.isNull(this.idI.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.ofd.getString(a.h.yuyin_ala_rank_list_bottom_user_name_limit), TextHelper.subStringWithEmoji(gVar.getNameShow(), i));
                }
                this.hXC.setText(nameShow);
            }
            this.idK.setVisibility(0);
        }
    }
}
