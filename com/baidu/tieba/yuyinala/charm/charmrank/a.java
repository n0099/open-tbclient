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
    private TextView idX;
    private TextView ikA;
    private TextView ikB;
    private TextView ikx;
    private HeadImageView iky;
    private TextView ikz;
    private String mRoomId;
    private View mRootView;
    private YuyinCharmRankTotalActivity osK;
    private c.a osL;
    private boolean osM;

    public a(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, String str) {
        this.osK = yuyinCharmRankTotalActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.osK).inflate(a.g.yuyin_ala_rank_list_charm_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.content_view);
        this.ikx = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.iky = (HeadImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
        this.idX = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.ikz = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
        this.ikA = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info_extra);
        this.ikB = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
        this.ikB.setOnTouchListener(new g());
        this.ikB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.osL != null) {
                    a.this.osK.finish();
                    a.this.osM = true;
                }
            }
        });
        if (this.iky != null) {
            this.iky.setIsRound(true);
            this.iky.setAutoChangeStyle(false);
        }
        if (this.osK != null) {
            this.osK.a(new YuyinCharmRankTotalActivity.a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.a.2
                @Override // com.baidu.tieba.yuyinala.charm.charmrank.YuyinCharmRankTotalActivity.a
                public void coI() {
                    if (a.this.osM && a.this.osL != null) {
                        a.this.osM = false;
                        a.this.osL.en(a.this.ikB);
                    }
                }
            });
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(c.a aVar) {
        this.osL = aVar;
    }

    public void a(j.a aVar) {
        if (aVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (aVar.aHZ <= 0) {
                spannableStringBuilder.append((CharSequence) this.osK.getString(a.h.yuyin_bottom_rank_list_no_money));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                this.ikx.setText("未上榜");
                this.ikB.setText("去上榜");
                this.ikx.setTextSize(10.0f);
                this.ikA.setVisibility(0);
                this.ikA.setText(spannableStringBuilder);
            } else {
                int i = aVar.aHY;
                this.ikx.setText(i + "");
                this.ikx.setTextSize(18.0f);
                if (i == 1) {
                    if (aVar.aIc) {
                        this.ikA.setVisibility(8);
                        this.ikB.setText("去守榜");
                    } else {
                        String format = String.format(this.osK.getString(a.h.yuyin_bottom_rank_list_1), StringHelper.formatForHourRankValue(aVar.aHZ - aVar.aIb) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                        this.ikB.setText("去守榜");
                        this.ikA.setVisibility(0);
                        this.ikA.setText(spannableStringBuilder);
                    }
                } else if (aVar.aHY >= 2 && aVar.aHY <= 100) {
                    String str = StringHelper.formatForHourRankValue((aVar.aIa - aVar.aHZ) + 1) + "";
                    spannableStringBuilder.append((CharSequence) String.format(this.osK.getString(a.h.yuyin_bottom_rank_list__in), str));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    this.ikB.setText("去冲榜");
                    this.ikA.setVisibility(0);
                    this.ikA.setText(spannableStringBuilder);
                } else if (aVar.aHY > 100) {
                    String format2 = String.format(this.osK.getString(a.h.yuyin_bottom_rank_list_out), StatisticData.ERROR_CODE_NOT_FOUND, StringHelper.formatForHourRankValue((aVar.aId - aVar.aHZ) + 1) + "");
                    spannableStringBuilder.append((CharSequence) format2);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), StatisticData.ERROR_CODE_NOT_FOUND.length() + 6, format2.length(), 34);
                    this.ikB.setText("去冲榜");
                    this.ikA.setVisibility(0);
                    this.ikA.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(aVar.bd_portrait)) {
                this.iky.startLoad(aVar.bd_portrait, 12, false);
            }
            if (!StringUtils.isNull(aVar.user_nickname)) {
                this.idX.setText(aVar.user_nickname);
            } else {
                this.idX.setText(aVar.user_name);
            }
            this.ikB.setVisibility(0);
        }
    }
}
