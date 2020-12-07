package com.baidu.tieba.yuyinala.person.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.personmanager.f;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.view.RatioTbImageView;
/* loaded from: classes4.dex */
public class PlayBackItemView extends RelativeLayout {
    private RatioTbImageView hMv;
    private LinearLayout hMw;
    private TextView hMx;
    private TextView hMy;
    private TextView mTitleView;

    public PlayBackItemView(Context context) {
        super(context);
        init();
    }

    public PlayBackItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PlayBackItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.ala_person_palyback_item, this);
        this.hMw = (LinearLayout) findViewById(a.f.playback_info_layout);
        this.hMv = (RatioTbImageView) findViewById(a.f.playback_cover);
        this.hMx = (TextView) findViewById(a.f.playback_audience_count);
        this.hMy = (TextView) findViewById(a.f.playback_time);
        this.mTitleView = (TextView) findViewById(a.f.playback_title);
    }

    public void setData(String str, long j, long j2, String str2) {
        this.hMv.startLoad(str, 10, false);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.hMw.setVisibility(8);
        } else {
            this.hMw.setVisibility(0);
            String format = String.format(getContext().getString(a.h.ala_person_audience), f.bc(j));
            String timeInterval = StringHelper.getTimeInterval(j2);
            this.hMx.setText(format);
            this.hMy.setText(timeInterval);
        }
        if (StringUtils.isNull(str2)) {
            this.mTitleView.setText(StringHelper.STRING_MORE);
        } else {
            this.mTitleView.setText(str2);
        }
    }
}
