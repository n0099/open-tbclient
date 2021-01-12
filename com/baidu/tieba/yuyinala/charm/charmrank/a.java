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
/* loaded from: classes10.dex */
public class a {
    private View contentView;
    private TextView hXC;
    private TextView idG;
    private HeadImageView idH;
    private TextView idI;
    private TextView idJ;
    private TextView idK;
    private String mRoomId;
    private View mRootView;
    private YuyinCharmRankTotalActivity ogk;
    private c.a ogl;
    private boolean ogm;

    public a(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, String str) {
        this.ogk = yuyinCharmRankTotalActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.ogk).inflate(a.g.yuyin_ala_rank_list_charm_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.content_view);
        this.idG = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.idH = (HeadImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
        this.hXC = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.idI = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
        this.idJ = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info_extra);
        this.idK = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
        this.idK.setOnTouchListener(new g());
        this.idK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ogl != null) {
                    a.this.ogk.finish();
                    a.this.ogm = true;
                }
            }
        });
        if (this.idH != null) {
            this.idH.setIsRound(true);
            this.idH.setAutoChangeStyle(false);
        }
        if (this.ogk != null) {
            this.ogk.a(new YuyinCharmRankTotalActivity.a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.a.2
                @Override // com.baidu.tieba.yuyinala.charm.charmrank.YuyinCharmRankTotalActivity.a
                public void cnx() {
                    if (a.this.ogm && a.this.ogl != null) {
                        a.this.ogm = false;
                        a.this.ogl.ep(a.this.idK);
                    }
                }
            });
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(c.a aVar) {
        this.ogl = aVar;
    }

    public void a(j.a aVar) {
        if (aVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (aVar.aEM <= 0) {
                spannableStringBuilder.append((CharSequence) this.ogk.getString(a.h.yuyin_bottom_rank_list_no_money));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                this.idG.setText("未上榜");
                this.idK.setText("去上榜");
                this.idG.setTextSize(10.0f);
                this.idJ.setVisibility(0);
                this.idJ.setText(spannableStringBuilder);
            } else {
                int i = aVar.aEL;
                this.idG.setText(i + "");
                this.idG.setTextSize(18.0f);
                if (i == 1) {
                    if (aVar.aEP) {
                        this.idJ.setVisibility(8);
                        this.idK.setText("去守榜");
                    } else {
                        String format = String.format(this.ogk.getString(a.h.yuyin_bottom_rank_list_1), StringHelper.formatForHourRankValue(aVar.aEM - aVar.aEO) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                        this.idK.setText("去守榜");
                        this.idJ.setVisibility(0);
                        this.idJ.setText(spannableStringBuilder);
                    }
                } else if (aVar.aEL >= 2 && aVar.aEL <= 100) {
                    String str = StringHelper.formatForHourRankValue((aVar.aEN - aVar.aEM) + 1) + "";
                    spannableStringBuilder.append((CharSequence) String.format(this.ogk.getString(a.h.yuyin_bottom_rank_list__in), str));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    this.idK.setText("去冲榜");
                    this.idJ.setVisibility(0);
                    this.idJ.setText(spannableStringBuilder);
                } else if (aVar.aEL > 100) {
                    String format2 = String.format(this.ogk.getString(a.h.yuyin_bottom_rank_list_out), StatisticData.ERROR_CODE_NOT_FOUND, StringHelper.formatForHourRankValue((aVar.aEQ - aVar.aEM) + 1) + "");
                    spannableStringBuilder.append((CharSequence) format2);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), StatisticData.ERROR_CODE_NOT_FOUND.length() + 6, format2.length(), 34);
                    this.idK.setText("去冲榜");
                    this.idJ.setVisibility(0);
                    this.idJ.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(aVar.bd_portrait)) {
                this.idH.startLoad(aVar.bd_portrait, 12, false);
            }
            if (!StringUtils.isNull(aVar.user_nickname)) {
                this.hXC.setText(aVar.user_nickname);
            } else {
                this.hXC.setText(aVar.user_name);
            }
            this.idK.setVisibility(0);
        }
    }
}
