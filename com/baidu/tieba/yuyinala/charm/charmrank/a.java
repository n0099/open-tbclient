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
    private TextView hGx;
    private TextView hLk;
    private HeadImageView hLl;
    private TextView hLm;
    private TextView hLn;
    private TextView hLo;
    private String mRoomId;
    private View mRootView;
    private YuyinCharmRankTotalActivity nSD;
    private c.a nSE;

    public a(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, String str) {
        this.nSD = yuyinCharmRankTotalActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.nSD).inflate(a.g.yuyin_ala_rank_list_charm_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.content_view);
        this.hLk = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.hLl = (HeadImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
        this.hGx = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.hLm = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
        this.hLn = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info_extra);
        this.hLo = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
        this.hLo.setOnTouchListener(new g());
        this.hLo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.nSE != null) {
                    a.this.nSD.finish();
                    a.this.nSE.dN(view);
                }
            }
        });
        if (this.hLl != null) {
            this.hLl.setIsRound(true);
            this.hLl.setAutoChangeStyle(false);
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(c.a aVar) {
        this.nSE = aVar;
    }

    public void a(i.a aVar) {
        if (aVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (aVar.aId <= 0) {
                spannableStringBuilder.append((CharSequence) this.nSD.getString(a.h.yuyin_bottom_rank_list_no_money));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                this.hLk.setText("未上榜");
                this.hLo.setText("去上榜");
                this.hLk.setTextSize(10.0f);
                this.hLn.setVisibility(0);
                this.hLn.setText(spannableStringBuilder);
            } else {
                int i = aVar.aIc;
                this.hLk.setText(i + "");
                this.hLk.setTextSize(18.0f);
                if (i == 1) {
                    if (aVar.aIg) {
                        this.hLn.setVisibility(8);
                        this.hLo.setText("去守榜");
                    } else {
                        String format = String.format(this.nSD.getString(a.h.yuyin_bottom_rank_list_1), StringHelper.formatForHourRankValue(aVar.aId - aVar.aIf) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                        this.hLo.setText("去守榜");
                        this.hLn.setVisibility(0);
                        this.hLn.setText(spannableStringBuilder);
                    }
                } else if (aVar.aIc >= 2 && aVar.aIc <= 100) {
                    String str = StringHelper.formatForHourRankValue((aVar.aIe - aVar.aId) + 1) + "";
                    spannableStringBuilder.append((CharSequence) String.format(this.nSD.getString(a.h.yuyin_bottom_rank_list__in), str));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    this.hLo.setText("去冲榜");
                    this.hLn.setVisibility(0);
                    this.hLn.setText(spannableStringBuilder);
                } else if (aVar.aIc > 100) {
                    String format2 = String.format(this.nSD.getString(a.h.yuyin_bottom_rank_list_out), "100", StringHelper.formatForHourRankValue((aVar.aIh - aVar.aId) + 1) + "");
                    spannableStringBuilder.append((CharSequence) format2);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), "100".length() + 6, format2.length(), 34);
                    this.hLo.setText("去冲榜");
                    this.hLn.setVisibility(0);
                    this.hLn.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(aVar.bd_portrait)) {
                this.hLl.startLoad(aVar.bd_portrait, 12, false);
            }
            if (!StringUtils.isNull(aVar.user_nickname)) {
                this.hGx.setText(aVar.user_nickname);
            } else {
                this.hGx.setText(aVar.user_name);
            }
            this.hLo.setVisibility(0);
        }
    }
}
