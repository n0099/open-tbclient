package com.baidu.tieba.yuyinala.liveroom.audiencelist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StringHelper;
/* loaded from: classes10.dex */
public class b {
    private long count;
    private ImageView hDq;
    private TextView hpq;
    private Context mContext;
    private com.baidu.tieba.yuyinala.liveroom.operation.b ojH;
    private View mView = null;
    private boolean gJe = true;

    public b(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mView = View.inflate(this.mContext, a.g.yuyin_ala_liveroom_audience_count_layout, null);
        this.mView.setMinimumWidth(this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds90));
        this.mView.setId(a.f.ala_liveroom_audience_count_layout);
        this.hpq = (TextView) this.mView.findViewById(a.f.ala_live_room_audience_count);
        this.hDq = (ImageView) this.mView.findViewById(a.f.close_imageView);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hDq.setVisibility(0);
            this.hDq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.audiencelist.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.ojH != null) {
                        b.this.ojH.a(view, 8, null);
                    }
                }
            });
        } else {
            this.hDq.setVisibility(8);
        }
        this.hpq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.audiencelist.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.ojH != null) {
                    b.this.ojH.a(view, 14, null);
                }
            }
        });
    }

    public void a(ViewGroup viewGroup, int i, long j) {
        if (this.mView.getParent() != null) {
            ((ViewGroup) this.mView.getParent()).removeView(this.mView);
        }
        eZ(j);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds90));
        layoutParams.addRule(11);
        layoutParams.rightMargin = BdUtilHelper.getDimens(this.mContext, a.d.sdk_ds8);
        layoutParams.topMargin = BdUtilHelper.getDimens(this.mContext, a.d.sdk_ds5);
        this.hpq.setVisibility(0);
        if (this.hpq != null) {
            this.hpq.setText("");
        }
        this.hDq.setVisibility(0);
        viewGroup.addView(this.mView, layoutParams);
    }

    public void setVisible(int i) {
        if (this.gJe) {
            this.mView.setVisibility(i);
        } else {
            this.mView.setVisibility(8);
        }
    }

    public void eZ(long j) {
        if (j < 0) {
            j = 0;
        }
        this.count = j;
        this.hpq.setText(StringHelper.formatYuyinValue(j));
    }

    public void a(com.baidu.tieba.yuyinala.liveroom.operation.b bVar) {
        this.ojH = bVar;
    }
}
