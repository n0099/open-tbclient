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
    private TextView idX;
    private TextView ikA;
    private TextView ikB;
    private TextView ikx;
    private TextView ikz;
    private LottieAnimationView ily;
    private String mRoomId;
    private View mRootView;
    private BarImageView oQm;
    private b.a oQn;
    private FrameLayout oQo;
    private AlaRankListActivity orD;

    public a(AlaRankListActivity alaRankListActivity, String str) {
        this.orD = alaRankListActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.orD).inflate(a.g.yuyin_ala_rank_list_hot_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.content_view);
        this.ikx = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.oQm = (BarImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
        this.idX = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.ikz = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
        this.ikA = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info_extra);
        this.ikB = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
        this.ily = (LottieAnimationView) this.mRootView.findViewById(a.f.rank_live_anim);
        this.oQo = (FrameLayout) this.mRootView.findViewById(a.f.ll_living);
        this.ikB.setOnTouchListener(new d());
        this.ikB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.oQn != null) {
                    a.this.orD.finish();
                    a.this.oQn.en(view);
                }
            }
        });
        if (this.oQm != null) {
            this.oQm.setShowOval(true);
            this.oQm.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(b.a aVar) {
        this.oQn = aVar;
    }

    public void a(g gVar) {
        int i = 10;
        if (gVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            this.oQo.setVisibility(8);
            if (gVar.aHZ <= 0) {
                spannableStringBuilder.append((CharSequence) this.orD.getString(a.h.yuyin_bottom_rank_list_bottom_no_money));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                this.ikx.setText("未上榜");
                this.ikx.setTextSize(10.0f);
                this.ikA.setVisibility(0);
                this.ikA.setText(spannableStringBuilder);
            } else {
                int i2 = gVar.aHY;
                this.ikx.setText(i2 + "");
                this.ikx.setTextSize(18.0f);
                if (i2 == 1) {
                    if (gVar.aIc) {
                        this.ikA.setVisibility(8);
                    } else {
                        String format = String.format(this.orD.getString(a.h.yuyin_bottom_rank_list_bottom_1), StringHelper.formatYuyinValue(gVar.aHZ - gVar.aIb) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                        this.ikA.setVisibility(0);
                        this.ikA.setText(spannableStringBuilder);
                    }
                } else if (gVar.aHY >= 2 && gVar.aHY <= 10) {
                    String str = StringHelper.formatYuyinValue((gVar.aIa - gVar.aHZ) + 1) + "";
                    spannableStringBuilder.append((CharSequence) String.format(this.orD.getString(a.h.yuyin_bottom_rank_list_bottom__in), str));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    this.ikA.setVisibility(0);
                    this.ikA.setText(spannableStringBuilder);
                } else if (gVar.aHY > 10) {
                    String format2 = String.format(this.orD.getString(a.h.yuyin_bottom_rank_list_bottom_out), Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, StringHelper.formatYuyinValue((gVar.aId - gVar.aHZ) + 1) + "");
                    spannableStringBuilder.append((CharSequence) format2);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), Constants.VIA_REPORT_TYPE_SHARE_TO_QQ.length() + 4, format2.length(), 34);
                    this.ikA.setVisibility(0);
                    this.ikA.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(gVar.cover)) {
                this.oQm.startLoad(gVar.cover, 12, false);
            }
            if (!StringUtils.isNull(gVar.getNameShow())) {
                String nameShow = gVar.getNameShow();
                int textLengthWithEmoji = TextHelper.getTextLengthWithEmoji(gVar.getNameShow());
                i = (this.ikz == null || StringUtils.isNull(this.ikz.getText().toString().trim())) ? 16 : 16;
                if (textLengthWithEmoji > i) {
                    nameShow = String.format(this.orD.getString(a.h.yuyin_ala_rank_list_bottom_user_name_limit), TextHelper.subStringWithEmoji(gVar.getNameShow(), i));
                }
                this.idX.setText(nameShow);
            }
            this.ikB.setVisibility(0);
        }
    }
}
