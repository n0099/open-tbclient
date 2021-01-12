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
/* loaded from: classes10.dex */
public class PlayBackItemView extends RelativeLayout {
    private RatioTbImageView hUn;
    private LinearLayout hUo;
    private TextView hUp;
    private TextView hUq;
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
        this.hUo = (LinearLayout) findViewById(a.f.playback_info_layout);
        this.hUn = (RatioTbImageView) findViewById(a.f.playback_cover);
        this.hUp = (TextView) findViewById(a.f.playback_audience_count);
        this.hUq = (TextView) findViewById(a.f.playback_time);
        this.mTitleView = (TextView) findViewById(a.f.playback_title);
    }

    public void setData(String str, long j, long j2, String str2) {
        this.hUn.startLoad(str, 10, false);
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            this.hUo.setVisibility(8);
        } else {
            this.hUo.setVisibility(0);
            String format = String.format(getContext().getString(a.h.ala_person_audience), f.bc(j));
            String timeInterval = StringHelper.getTimeInterval(j2);
            this.hUp.setText(format);
            this.hUq.setText(timeInterval);
        }
        if (StringUtils.isNull(str2)) {
            this.mTitleView.setText(StringHelper.STRING_MORE);
        } else {
            this.mTitleView.setText(str2);
        }
    }
}
