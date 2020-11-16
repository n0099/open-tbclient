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
    private TextView hGe;
    private TextView hKR;
    private HeadImageView hKS;
    private TextView hKT;
    private TextView hKU;
    private TextView hKV;
    private String mRoomId;
    private View mRootView;
    private YuyinCharmRankTotalActivity nUg;
    private c.a nUh;

    public a(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, String str) {
        this.nUg = yuyinCharmRankTotalActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.nUg).inflate(a.g.yuyin_ala_rank_list_charm_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.content_view);
        this.hKR = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.hKS = (HeadImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
        this.hGe = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.hKT = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
        this.hKU = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info_extra);
        this.hKV = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
        this.hKV.setOnTouchListener(new g());
        this.hKV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.nUh != null) {
                    a.this.nUg.finish();
                    a.this.nUh.dU(view);
                }
            }
        });
        if (this.hKS != null) {
            this.hKS.setIsRound(true);
            this.hKS.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(c.a aVar) {
        this.nUh = aVar;
    }

    public void a(i.a aVar) {
        if (aVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (aVar.aGs <= 0) {
                spannableStringBuilder.append((CharSequence) this.nUg.getString(a.h.yuyin_bottom_rank_list_no_money));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                this.hKR.setText("未上榜");
                this.hKV.setText("去上榜");
                this.hKR.setTextSize(10.0f);
                this.hKU.setVisibility(0);
                this.hKU.setText(spannableStringBuilder);
            } else {
                int i = aVar.aGr;
                this.hKR.setText(i + "");
                this.hKR.setTextSize(18.0f);
                if (i == 1) {
                    if (aVar.aGv) {
                        this.hKU.setVisibility(8);
                        this.hKV.setText("去守榜");
                    } else {
                        String format = String.format(this.nUg.getString(a.h.yuyin_bottom_rank_list_1), StringHelper.formatForHourRankValue(aVar.aGs - aVar.aGu) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                        this.hKV.setText("去守榜");
                        this.hKU.setVisibility(0);
                        this.hKU.setText(spannableStringBuilder);
                    }
                } else if (aVar.aGr >= 2 && aVar.aGr <= 100) {
                    String str = StringHelper.formatForHourRankValue((aVar.aGt - aVar.aGs) + 1) + "";
                    spannableStringBuilder.append((CharSequence) String.format(this.nUg.getString(a.h.yuyin_bottom_rank_list__in), str));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    this.hKV.setText("去冲榜");
                    this.hKU.setVisibility(0);
                    this.hKU.setText(spannableStringBuilder);
                } else if (aVar.aGr > 100) {
                    String format2 = String.format(this.nUg.getString(a.h.yuyin_bottom_rank_list_out), "100", StringHelper.formatForHourRankValue((aVar.aGw - aVar.aGs) + 1) + "");
                    spannableStringBuilder.append((CharSequence) format2);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "100".length() + 6, format2.length(), 34);
                    this.hKV.setText("去冲榜");
                    this.hKU.setVisibility(0);
                    this.hKU.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(aVar.bd_portrait)) {
                this.hKS.startLoad(aVar.bd_portrait, 12, false);
            }
            if (!StringUtils.isNull(aVar.user_nickname)) {
                this.hGe.setText(aVar.user_nickname);
            } else {
                this.hGe.setText(aVar.user_name);
            }
            this.hKV.setVisibility(0);
        }
    }
}
