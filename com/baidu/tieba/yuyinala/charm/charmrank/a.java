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
    private TextView hPL;
    private TextView hVL;
    private HeadImageView hVM;
    private TextView hVN;
    private TextView hVO;
    private TextView hVP;
    private String mRoomId;
    private View mRootView;
    private YuyinCharmRankTotalActivity oje;
    private c.a ojf;

    public a(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, String str) {
        this.oje = yuyinCharmRankTotalActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.oje).inflate(a.g.yuyin_ala_rank_list_charm_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.content_view);
        this.hVL = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.hVM = (HeadImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
        this.hPL = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.hVN = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
        this.hVO = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info_extra);
        this.hVP = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
        this.hVP.setOnTouchListener(new g());
        this.hVP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ojf != null) {
                    a.this.oje.finish();
                    a.this.ojf.ef(view);
                }
            }
        });
        if (this.hVM != null) {
            this.hVM.setIsRound(true);
            this.hVM.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(c.a aVar) {
        this.ojf = aVar;
    }

    public void a(i.a aVar) {
        if (aVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (aVar.aJb <= 0) {
                spannableStringBuilder.append((CharSequence) this.oje.getString(a.h.yuyin_bottom_rank_list_no_money));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                this.hVL.setText("未上榜");
                this.hVP.setText("去上榜");
                this.hVL.setTextSize(10.0f);
                this.hVO.setVisibility(0);
                this.hVO.setText(spannableStringBuilder);
            } else {
                int i = aVar.aJa;
                this.hVL.setText(i + "");
                this.hVL.setTextSize(18.0f);
                if (i == 1) {
                    if (aVar.aJe) {
                        this.hVO.setVisibility(8);
                        this.hVP.setText("去守榜");
                    } else {
                        String format = String.format(this.oje.getString(a.h.yuyin_bottom_rank_list_1), StringHelper.formatForHourRankValue(aVar.aJb - aVar.aJd) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                        this.hVP.setText("去守榜");
                        this.hVO.setVisibility(0);
                        this.hVO.setText(spannableStringBuilder);
                    }
                } else if (aVar.aJa >= 2 && aVar.aJa <= 100) {
                    String str = StringHelper.formatForHourRankValue((aVar.aJc - aVar.aJb) + 1) + "";
                    spannableStringBuilder.append((CharSequence) String.format(this.oje.getString(a.h.yuyin_bottom_rank_list__in), str));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    this.hVP.setText("去冲榜");
                    this.hVO.setVisibility(0);
                    this.hVO.setText(spannableStringBuilder);
                } else if (aVar.aJa > 100) {
                    String format2 = String.format(this.oje.getString(a.h.yuyin_bottom_rank_list_out), "100", StringHelper.formatForHourRankValue((aVar.aJf - aVar.aJb) + 1) + "");
                    spannableStringBuilder.append((CharSequence) format2);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "100".length() + 6, format2.length(), 34);
                    this.hVP.setText("去冲榜");
                    this.hVO.setVisibility(0);
                    this.hVO.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(aVar.bd_portrait)) {
                this.hVM.startLoad(aVar.bd_portrait, 12, false);
            }
            if (!StringUtils.isNull(aVar.user_nickname)) {
                this.hPL.setText(aVar.user_nickname);
            } else {
                this.hPL.setText(aVar.user_name);
            }
            this.hVP.setVisibility(0);
        }
    }
}
