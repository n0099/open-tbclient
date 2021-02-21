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
    private TextView ick;
    private TextView iiO;
    private TextView iiQ;
    private TextView iiR;
    private TextView iiS;
    private LottieAnimationView ijP;
    private String mRoomId;
    private View mRootView;
    private BarImageView oOh;
    private b.a oOi;
    private FrameLayout oOj;
    private AlaRankListActivity opx;

    public a(AlaRankListActivity alaRankListActivity, String str) {
        this.opx = alaRankListActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.opx).inflate(a.g.yuyin_ala_rank_list_hot_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.content_view);
        this.iiO = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.oOh = (BarImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
        this.ick = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.iiQ = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
        this.iiR = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info_extra);
        this.iiS = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
        this.ijP = (LottieAnimationView) this.mRootView.findViewById(a.f.rank_live_anim);
        this.oOj = (FrameLayout) this.mRootView.findViewById(a.f.ll_living);
        this.iiS.setOnTouchListener(new d());
        this.iiS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.oOi != null) {
                    a.this.opx.finish();
                    a.this.oOi.en(view);
                }
            }
        });
        if (this.oOh != null) {
            this.oOh.setShowOval(true);
            this.oOh.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(b.a aVar) {
        this.oOi = aVar;
    }

    public void a(g gVar) {
        int i = 10;
        if (gVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            this.oOj.setVisibility(8);
            if (gVar.aGz <= 0) {
                spannableStringBuilder.append((CharSequence) this.opx.getString(a.h.yuyin_bottom_rank_list_bottom_no_money));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                this.iiO.setText("未上榜");
                this.iiO.setTextSize(10.0f);
                this.iiR.setVisibility(0);
                this.iiR.setText(spannableStringBuilder);
            } else {
                int i2 = gVar.aGy;
                this.iiO.setText(i2 + "");
                this.iiO.setTextSize(18.0f);
                if (i2 == 1) {
                    if (gVar.aGC) {
                        this.iiR.setVisibility(8);
                    } else {
                        String format = String.format(this.opx.getString(a.h.yuyin_bottom_rank_list_bottom_1), StringHelper.formatYuyinValue(gVar.aGz - gVar.aGB) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                        this.iiR.setVisibility(0);
                        this.iiR.setText(spannableStringBuilder);
                    }
                } else if (gVar.aGy >= 2 && gVar.aGy <= 10) {
                    String str = StringHelper.formatYuyinValue((gVar.aGA - gVar.aGz) + 1) + "";
                    spannableStringBuilder.append((CharSequence) String.format(this.opx.getString(a.h.yuyin_bottom_rank_list_bottom__in), str));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    this.iiR.setVisibility(0);
                    this.iiR.setText(spannableStringBuilder);
                } else if (gVar.aGy > 10) {
                    String format2 = String.format(this.opx.getString(a.h.yuyin_bottom_rank_list_bottom_out), Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, StringHelper.formatYuyinValue((gVar.aGD - gVar.aGz) + 1) + "");
                    spannableStringBuilder.append((CharSequence) format2);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), Constants.VIA_REPORT_TYPE_SHARE_TO_QQ.length() + 4, format2.length(), 34);
                    this.iiR.setVisibility(0);
                    this.iiR.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(gVar.cover)) {
                this.oOh.startLoad(gVar.cover, 12, false);
            }
            if (!StringUtils.isNull(gVar.getNameShow())) {
                String nameShow = gVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(gVar.getNameShow());
                i = (this.iiQ == null || StringUtils.isNull(this.iiQ.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.opx.getString(a.h.yuyin_ala_rank_list_bottom_user_name_limit), TextHelper.subStringWithEmoji(gVar.getNameShow(), i));
                }
                this.ick.setText(nameShow);
            }
            this.iiS.setVisibility(0);
        }
    }
}
