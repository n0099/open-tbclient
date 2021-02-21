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
    private TextView ick;
    private TextView iiO;
    private HeadImageView iiP;
    private TextView iiQ;
    private TextView iiR;
    private TextView iiS;
    private String mRoomId;
    private View mRootView;
    private YuyinCharmRankTotalActivity oqE;
    private c.a oqF;
    private boolean oqG;

    public a(YuyinCharmRankTotalActivity yuyinCharmRankTotalActivity, String str) {
        this.oqE = yuyinCharmRankTotalActivity;
        this.mRoomId = str;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.oqE).inflate(a.g.yuyin_ala_rank_list_charm_bottom_layout, (ViewGroup) null);
        this.contentView = this.mRootView.findViewById(a.f.content_view);
        this.iiO = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_rank);
        this.iiP = (HeadImageView) this.mRootView.findViewById(a.f.ala_rank_list_user_header);
        this.ick = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_user_name);
        this.iiQ = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info);
        this.iiR = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_info_extra);
        this.iiS = (TextView) this.mRootView.findViewById(a.f.ala_rank_list_support);
        this.iiS.setOnTouchListener(new g());
        this.iiS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.oqF != null) {
                    a.this.oqE.finish();
                    a.this.oqG = true;
                }
            }
        });
        if (this.iiP != null) {
            this.iiP.setIsRound(true);
            this.iiP.setAutoChangeStyle(false);
        }
        if (this.oqE != null) {
            this.oqE.a(new YuyinCharmRankTotalActivity.a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.a.2
                @Override // com.baidu.tieba.yuyinala.charm.charmrank.YuyinCharmRankTotalActivity.a
                public void coC() {
                    if (a.this.oqG && a.this.oqF != null) {
                        a.this.oqG = false;
                        a.this.oqF.en(a.this.iiS);
                    }
                }
            });
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(c.a aVar) {
        this.oqF = aVar;
    }

    public void a(j.a aVar) {
        if (aVar != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (aVar.aGz <= 0) {
                spannableStringBuilder.append((CharSequence) this.oqE.getString(a.h.yuyin_bottom_rank_list_no_money));
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, 5, 34);
                this.iiO.setText("未上榜");
                this.iiS.setText("去上榜");
                this.iiO.setTextSize(10.0f);
                this.iiR.setVisibility(0);
                this.iiR.setText(spannableStringBuilder);
            } else {
                int i = aVar.aGy;
                this.iiO.setText(i + "");
                this.iiO.setTextSize(18.0f);
                if (i == 1) {
                    if (aVar.aGC) {
                        this.iiR.setVisibility(8);
                        this.iiS.setText("去守榜");
                    } else {
                        String format = String.format(this.oqE.getString(a.h.yuyin_bottom_rank_list_1), StringHelper.formatForHourRankValue(aVar.aGz - aVar.aGB) + "");
                        spannableStringBuilder.append((CharSequence) format);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 6, format.length(), 34);
                        this.iiS.setText("去守榜");
                        this.iiR.setVisibility(0);
                        this.iiR.setText(spannableStringBuilder);
                    }
                } else if (aVar.aGy >= 2 && aVar.aGy <= 100) {
                    String str = StringHelper.formatForHourRankValue((aVar.aGA - aVar.aGz) + 1) + "";
                    spannableStringBuilder.append((CharSequence) String.format(this.oqE.getString(a.h.yuyin_bottom_rank_list__in), str));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), 2, str.length() + 4, 34);
                    this.iiS.setText("去冲榜");
                    this.iiR.setVisibility(0);
                    this.iiR.setText(spannableStringBuilder);
                } else if (aVar.aGy > 100) {
                    String format2 = String.format(this.oqE.getString(a.h.yuyin_bottom_rank_list_out), StatisticData.ERROR_CODE_NOT_FOUND, StringHelper.formatForHourRankValue((aVar.aGD - aVar.aGz) + 1) + "");
                    spannableStringBuilder.append((CharSequence) format2);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FD1E65")), StatisticData.ERROR_CODE_NOT_FOUND.length() + 6, format2.length(), 34);
                    this.iiS.setText("去冲榜");
                    this.iiR.setVisibility(0);
                    this.iiR.setText(spannableStringBuilder);
                }
            }
            if (!StringUtils.isNull(aVar.bd_portrait)) {
                this.iiP.startLoad(aVar.bd_portrait, 12, false);
            }
            if (!StringUtils.isNull(aVar.user_nickname)) {
                this.ick.setText(aVar.user_nickname);
            } else {
                this.ick.setText(aVar.user_name);
            }
            this.iiS.setVisibility(0);
        }
    }
}
