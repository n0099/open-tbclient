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
/* loaded from: classes4.dex */
public class b {
    private long count;
    private TextView gSG;
    private ImageView hgS;
    private Context mContext;
    private com.baidu.tieba.yuyinala.liveroom.operation.b nOT;
    private View mView = null;
    private boolean gnY = true;

    public b(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mView = View.inflate(this.mContext, a.h.yuyin_ala_liveroom_audience_count_layout, null);
        this.mView.setMinimumWidth(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds90));
        this.mView.setId(a.g.ala_liveroom_audience_count_layout);
        this.gSG = (TextView) this.mView.findViewById(a.g.ala_live_room_audience_count);
        this.hgS = (ImageView) this.mView.findViewById(a.g.close_imageView);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hgS.setVisibility(0);
            this.hgS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.audiencelist.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (b.this.nOT != null) {
                        b.this.nOT.b(view, 8, null);
                    }
                }
            });
        } else {
            this.hgS.setVisibility(8);
        }
        this.gSG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.audiencelist.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.nOT != null) {
                    b.this.nOT.b(view, 14, null);
                }
            }
        });
    }

    public void a(ViewGroup viewGroup, int i, long j) {
        if (this.mView.getParent() != null) {
            ((ViewGroup) this.mView.getParent()).removeView(this.mView);
        }
        ea(j);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds90));
        layoutParams.addRule(11);
        layoutParams.rightMargin = BdUtilHelper.getDimens(this.mContext, a.e.sdk_ds8);
        layoutParams.topMargin = BdUtilHelper.getDimens(this.mContext, a.e.sdk_ds5);
        this.gSG.setVisibility(0);
        if (this.gSG != null) {
            this.gSG.setText("");
        }
        this.hgS.setVisibility(0);
        viewGroup.addView(this.mView, layoutParams);
    }

    public void setVisible(int i) {
        if (this.gnY) {
            this.mView.setVisibility(i);
        } else {
            this.mView.setVisibility(8);
        }
    }

    public void ea(long j) {
        if (j < 0) {
            j = 0;
        }
        this.count = j;
        this.gSG.setText(StringHelper.formatYuyinValue(j));
    }

    public long getCount() {
        return this.count;
    }

    public void a(com.baidu.tieba.yuyinala.liveroom.operation.b bVar) {
        this.nOT = bVar;
    }
}
