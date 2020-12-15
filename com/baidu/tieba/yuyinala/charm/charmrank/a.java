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
    private TextView hPN;
    private TextView hVN;
    private HeadImageView hVO;
    private TextView hVP;
    private TextView hVQ;
    private TextView hVR;
    private String mRoomId;
    private View mRootView;
    private YuyinCharmRankTotalActivity ojg;
    private c.a ojh;

    public a(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, String str) {
        this.ojg = yuyinCharmRankTotalActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.ojg).inflate(a.g.yuyin_ala_rank_list_charm_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.content_view);
        this.hVN = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.hVO = (HeadImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
        this.hPN = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.hVP = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
        this.hVQ = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info_extra);
        this.hVR = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
        this.hVR.setOnTouchListener(new g());
        this.hVR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ojh != null) {
                    a.this.ojg.finish();
                    a.this.ojh.ef(view);
                }
            }
        });
        if (this.hVO != null) {
            this.hVO.setIsRound(true);
            this.hVO.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(c.a aVar) {
        this.ojh = aVar;
    }

    public void a(i.a aVar) {
        if (aVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (aVar.aJb <= 0) {
                spannableStringBuilder.append((CharSequence) this.ojg.getString(a.h.yuyin_bottom_rank_list_no_money));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                this.hVN.setText("未上榜");
                this.hVR.setText("去上榜");
                this.hVN.setTextSize(10.0f);
                this.hVQ.setVisibility(0);
                this.hVQ.setText(spannableStringBuilder);
            } else {
                int i = aVar.aJa;
                this.hVN.setText(i + "");
                this.hVN.setTextSize(18.0f);
                if (i == 1) {
                    if (aVar.aJe) {
                        this.hVQ.setVisibility(8);
                        this.hVR.setText("去守榜");
                    } else {
                        String format = String.format(this.ojg.getString(a.h.yuyin_bottom_rank_list_1), StringHelper.formatForHourRankValue(aVar.aJb - aVar.aJd) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                        this.hVR.setText("去守榜");
                        this.hVQ.setVisibility(0);
                        this.hVQ.setText(spannableStringBuilder);
                    }
                } else if (aVar.aJa >= 2 && aVar.aJa <= 100) {
                    String str = StringHelper.formatForHourRankValue((aVar.aJc - aVar.aJb) + 1) + "";
                    spannableStringBuilder.append((CharSequence) String.format(this.ojg.getString(a.h.yuyin_bottom_rank_list__in), str));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    this.hVR.setText("去冲榜");
                    this.hVQ.setVisibility(0);
                    this.hVQ.setText(spannableStringBuilder);
                } else if (aVar.aJa > 100) {
                    String format2 = String.format(this.ojg.getString(a.h.yuyin_bottom_rank_list_out), "100", StringHelper.formatForHourRankValue((aVar.aJf - aVar.aJb) + 1) + "");
                    spannableStringBuilder.append((CharSequence) format2);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "100".length() + 6, format2.length(), 34);
                    this.hVR.setText("去冲榜");
                    this.hVQ.setVisibility(0);
                    this.hVQ.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(aVar.bd_portrait)) {
                this.hVO.startLoad(aVar.bd_portrait, 12, false);
            }
            if (!StringUtils.isNull(aVar.user_nickname)) {
                this.hPN.setText(aVar.user_nickname);
            } else {
                this.hPN.setText(aVar.user_name);
            }
            this.hVR.setVisibility(0);
        }
    }
}
