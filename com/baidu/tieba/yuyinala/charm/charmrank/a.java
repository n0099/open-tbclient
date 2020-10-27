package com.baidu.tieba.yuyinala.charm.charmrank;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.i;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.tieba.yuyinala.charm.charmrank.c;
/* loaded from: classes4.dex */
public class a {
    private View contentView;
    private TextView hAA;
    private TextView hFn;
    private HeadImageView hFo;
    private TextView hFp;
    private TextView hFq;
    private TextView hFr;
    private String mRoomId;
    private View mRootView;
    private YuyinCharmRankTotalActivity nMJ;
    private c.a nMK;

    public a(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, String str) {
        this.nMJ = yuyinCharmRankTotalActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.nMJ).inflate(a.h.yuyin_ala_rank_list_charm_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.g.content_view);
        this.hFn = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_rank);
        this.hFo = (HeadImageView) this.mRootView.findViewById(a.g.ala_rank_list_user_header);
        this.hAA = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_user_name);
        this.hFp = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info);
        this.hFq = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_info_extra);
        this.hFr = (TextView) this.mRootView.findViewById(a.g.ala_rank_list_support);
        this.hFr.setOnTouchListener(new g());
        this.hFr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.nMK != null) {
                    a.this.nMJ.finish();
                    a.this.nMK.dI(view);
                }
            }
        });
        if (this.hFo != null) {
            this.hFo.setIsRound(true);
            this.hFo.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(c.a aVar) {
        this.nMK = aVar;
    }

    public void a(i.a aVar) {
        if (aVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (aVar.aHm <= 0) {
                spannableStringBuilder.append((CharSequence) this.nMJ.getString(a.i.yuyin_bottom_rank_list_no_money));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                this.hFn.setText("未上榜");
                this.hFr.setText("去上榜");
                this.hFn.setTextSize(10.0f);
                this.hFq.setVisibility(0);
                this.hFq.setText(spannableStringBuilder);
            } else {
                int i = aVar.aHl;
                this.hFn.setText(i + "");
                this.hFn.setTextSize(18.0f);
                if (i == 1) {
                    if (aVar.aHp) {
                        this.hFq.setVisibility(8);
                        this.hFr.setText("去守榜");
                    } else {
                        String format = String.format(this.nMJ.getString(a.i.yuyin_bottom_rank_list_1), StringHelper.formatForHourRankValue(aVar.aHm - aVar.aHo) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                        this.hFr.setText("去守榜");
                        this.hFq.setVisibility(0);
                        this.hFq.setText(spannableStringBuilder);
                    }
                } else if (aVar.aHl >= 2 && aVar.aHl <= 100) {
                    String str = StringHelper.formatForHourRankValue((aVar.aHn - aVar.aHm) + 1) + "";
                    spannableStringBuilder.append((CharSequence) String.format(this.nMJ.getString(a.i.yuyin_bottom_rank_list__in), str));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    this.hFr.setText("去冲榜");
                    this.hFq.setVisibility(0);
                    this.hFq.setText(spannableStringBuilder);
                } else if (aVar.aHl > 100) {
                    String format2 = String.format(this.nMJ.getString(a.i.yuyin_bottom_rank_list_out), "100", StringHelper.formatForHourRankValue((aVar.aHq - aVar.aHm) + 1) + "");
                    spannableStringBuilder.append((CharSequence) format2);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "100".length() + 6, format2.length(), 34);
                    this.hFr.setText("去冲榜");
                    this.hFq.setVisibility(0);
                    this.hFq.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(aVar.bd_portrait)) {
                this.hFo.startLoad(aVar.bd_portrait, 12, false);
            }
            if (!StringUtils.isNull(aVar.user_nickname)) {
                this.hAA.setText(aVar.user_nickname);
            } else {
                this.hAA.setText(aVar.user_name);
            }
            this.hFr.setVisibility(0);
        }
    }
}
