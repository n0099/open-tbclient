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
    private TextView ibW;
    private TextView iiA;
    private HeadImageView iiB;
    private TextView iiC;
    private TextView iiD;
    private TextView iiE;
    private String mRoomId;
    private View mRootView;
    private YuyinCharmRankTotalActivity oqe;
    private c.a oqf;
    private boolean oqg;

    public a(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, String str) {
        this.oqe = yuyinCharmRankTotalActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.oqe).inflate(a.g.yuyin_ala_rank_list_charm_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.content_view);
        this.iiA = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.iiB = (HeadImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
        this.ibW = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.iiC = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
        this.iiD = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info_extra);
        this.iiE = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
        this.iiE.setOnTouchListener(new g());
        this.iiE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.oqf != null) {
                    a.this.oqe.finish();
                    a.this.oqg = true;
                }
            }
        });
        if (this.iiB != null) {
            this.iiB.setIsRound(true);
            this.iiB.setAutoChangeStyle(false);
        }
        if (this.oqe != null) {
            this.oqe.a(new YuyinCharmRankTotalActivity.a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.a.2
                @Override // com.baidu.tieba.yuyinala.charm.charmrank.YuyinCharmRankTotalActivity.a
                public void cov() {
                    if (a.this.oqg && a.this.oqf != null) {
                        a.this.oqg = false;
                        a.this.oqf.en(a.this.iiE);
                    }
                }
            });
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(c.a aVar) {
        this.oqf = aVar;
    }

    public void a(j.a aVar) {
        if (aVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (aVar.aGz <= 0) {
                spannableStringBuilder.append((CharSequence) this.oqe.getString(a.h.yuyin_bottom_rank_list_no_money));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                this.iiA.setText("未上榜");
                this.iiE.setText("去上榜");
                this.iiA.setTextSize(10.0f);
                this.iiD.setVisibility(0);
                this.iiD.setText(spannableStringBuilder);
            } else {
                int i = aVar.aGy;
                this.iiA.setText(i + "");
                this.iiA.setTextSize(18.0f);
                if (i == 1) {
                    if (aVar.aGC) {
                        this.iiD.setVisibility(8);
                        this.iiE.setText("去守榜");
                    } else {
                        String format = String.format(this.oqe.getString(a.h.yuyin_bottom_rank_list_1), StringHelper.formatForHourRankValue(aVar.aGz - aVar.aGB) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                        this.iiE.setText("去守榜");
                        this.iiD.setVisibility(0);
                        this.iiD.setText(spannableStringBuilder);
                    }
                } else if (aVar.aGy >= 2 && aVar.aGy <= 100) {
                    String str = StringHelper.formatForHourRankValue((aVar.aGA - aVar.aGz) + 1) + "";
                    spannableStringBuilder.append((CharSequence) String.format(this.oqe.getString(a.h.yuyin_bottom_rank_list__in), str));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    this.iiE.setText("去冲榜");
                    this.iiD.setVisibility(0);
                    this.iiD.setText(spannableStringBuilder);
                } else if (aVar.aGy > 100) {
                    String format2 = String.format(this.oqe.getString(a.h.yuyin_bottom_rank_list_out), StatisticData.ERROR_CODE_NOT_FOUND, StringHelper.formatForHourRankValue((aVar.aGD - aVar.aGz) + 1) + "");
                    spannableStringBuilder.append((CharSequence) format2);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), StatisticData.ERROR_CODE_NOT_FOUND.length() + 6, format2.length(), 34);
                    this.iiE.setText("去冲榜");
                    this.iiD.setVisibility(0);
                    this.iiD.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(aVar.bd_portrait)) {
                this.iiB.startLoad(aVar.bd_portrait, 12, false);
            }
            if (!StringUtils.isNull(aVar.user_nickname)) {
                this.ibW.setText(aVar.user_nickname);
            } else {
                this.ibW.setText(aVar.user_name);
            }
            this.iiE.setVisibility(0);
        }
    }
}
