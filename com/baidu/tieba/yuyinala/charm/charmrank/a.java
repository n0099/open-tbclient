package com.baidu.tieba.yuyinala.charm.charmrank;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.tieba.yuyinala.charm.charmrank.YuyinCharmRankTotalActivity;
import com.baidu.tieba.yuyinala.charm.charmrank.c;
import com.bytedance.sdk.openadsdk.preload.falconx.statistic.StatisticData;
/* loaded from: classes11.dex */
public class a {
    private View contentView;
    private TextView icj;
    private TextView iin;
    private HeadImageView iio;
    private TextView iip;
    private TextView iiq;
    private TextView iir;
    private String mRoomId;
    private View mRootView;
    private YuyinCharmRankTotalActivity okP;
    private c.a okQ;
    private boolean okR;

    public a(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, String str) {
        this.okP = yuyinCharmRankTotalActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.okP).inflate(a.g.yuyin_ala_rank_list_charm_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.content_view);
        this.iin = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.iio = (HeadImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
        this.icj = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.iip = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
        this.iiq = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info_extra);
        this.iir = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
        this.iir.setOnTouchListener(new g());
        this.iir.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.okQ != null) {
                    a.this.okP.finish();
                    a.this.okR = true;
                }
            }
        });
        if (this.iio != null) {
            this.iio.setIsRound(true);
            this.iio.setAutoChangeStyle(false);
        }
        if (this.okP != null) {
            this.okP.a(new YuyinCharmRankTotalActivity.a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.a.2
                @Override // com.baidu.tieba.yuyinala.charm.charmrank.YuyinCharmRankTotalActivity.a
                public void crp() {
                    if (a.this.okR && a.this.okQ != null) {
                        a.this.okR = false;
                        a.this.okQ.ep(a.this.iir);
                    }
                }
            });
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(c.a aVar) {
        this.okQ = aVar;
    }

    public void a(j.a aVar) {
        if (aVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (aVar.aJz <= 0) {
                spannableStringBuilder.append((CharSequence) this.okP.getString(a.h.yuyin_bottom_rank_list_no_money));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                this.iin.setText("未上榜");
                this.iir.setText("去上榜");
                this.iin.setTextSize(10.0f);
                this.iiq.setVisibility(0);
                this.iiq.setText(spannableStringBuilder);
            } else {
                int i = aVar.aJy;
                this.iin.setText(i + "");
                this.iin.setTextSize(18.0f);
                if (i == 1) {
                    if (aVar.aJC) {
                        this.iiq.setVisibility(8);
                        this.iir.setText("去守榜");
                    } else {
                        String format = String.format(this.okP.getString(a.h.yuyin_bottom_rank_list_1), StringHelper.formatForHourRankValue(aVar.aJz - aVar.aJB) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                        this.iir.setText("去守榜");
                        this.iiq.setVisibility(0);
                        this.iiq.setText(spannableStringBuilder);
                    }
                } else if (aVar.aJy >= 2 && aVar.aJy <= 100) {
                    String str = StringHelper.formatForHourRankValue((aVar.aJA - aVar.aJz) + 1) + "";
                    spannableStringBuilder.append((CharSequence) String.format(this.okP.getString(a.h.yuyin_bottom_rank_list__in), str));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    this.iir.setText("去冲榜");
                    this.iiq.setVisibility(0);
                    this.iiq.setText(spannableStringBuilder);
                } else if (aVar.aJy > 100) {
                    String format2 = String.format(this.okP.getString(a.h.yuyin_bottom_rank_list_out), StatisticData.ERROR_CODE_NOT_FOUND, StringHelper.formatForHourRankValue((aVar.aJD - aVar.aJz) + 1) + "");
                    spannableStringBuilder.append((CharSequence) format2);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), StatisticData.ERROR_CODE_NOT_FOUND.length() + 6, format2.length(), 34);
                    this.iir.setText("去冲榜");
                    this.iiq.setVisibility(0);
                    this.iiq.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(aVar.bd_portrait)) {
                this.iio.startLoad(aVar.bd_portrait, 12, false);
            }
            if (!StringUtils.isNull(aVar.user_nickname)) {
                this.icj.setText(aVar.user_nickname);
            } else {
                this.icj.setText(aVar.user_name);
            }
            this.iir.setVisibility(0);
        }
    }
}
