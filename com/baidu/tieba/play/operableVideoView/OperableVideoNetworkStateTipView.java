package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.video.g;
/* loaded from: classes2.dex */
public class OperableVideoNetworkStateTipView extends LinearLayout implements View.OnClickListener {
    private String akY;
    private TBSpecificationBtn lvo;
    private TBSpecificationBtn lvp;
    protected View.OnClickListener lvq;

    public OperableVideoNetworkStateTipView(Context context) {
        super(context);
        init();
    }

    public OperableVideoNetworkStateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public OperableVideoNetworkStateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public int getLayoutR() {
        return R.layout.operable_video_network_state_tip;
    }

    private void init() {
        inflate(getContext(), getLayoutR(), this);
        this.lvo = (TBSpecificationBtn) findViewById(R.id.play);
        this.lvp = (TBSpecificationBtn) findViewById(R.id.free_flow);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.blp();
        cVar.a(R.drawable.ic_icon_pure_video_play12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        cVar.oX(l.getDimens(getContext(), R.dimen.tbds32));
        this.lvo.setText(getResources().getString(R.string.video_flow_play));
        this.lvo.setTextSize(R.dimen.tbds36);
        this.lvo.setConfig(cVar);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.lvp.setText(getResources().getString(R.string.video_open_free_data));
        this.lvp.setTextSize(R.dimen.tbds36);
        this.lvp.setConfig(aVar);
        this.lvo.setOnClickListener(this);
        this.lvp.setOnClickListener(this);
        setOnClickListener(this);
    }

    public void setVideoLength(long j) {
        if (j > 0) {
            this.lvo.setText(String.format(getResources().getString(R.string.video_data), at.getFormatSize(j)));
        }
    }

    public void setVideoDuration(int i) {
    }

    public void setTid(String str) {
        this.akY = str;
    }

    public boolean dfs() {
        return (hasAgreeToPlay() || g.dAV().dAW() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !j.isMobileNet()) ? false : true;
    }

    public void setHasAgreeToPlay(boolean z) {
        TbSingleton.getInstance().setHasAgreeToPlay(z);
    }

    public boolean hasAgreeToPlay() {
        return TbSingleton.getInstance().hasAgreeToPlay();
    }

    public void setPlayViewOnClickListener(View.OnClickListener onClickListener) {
        this.lvq = onClickListener;
    }

    public void ar(boolean z, boolean z2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lvp.getLayoutParams();
        if (z && !z2) {
            setOrientation(1);
            layoutParams.leftMargin = 0;
            layoutParams.topMargin = (int) getResources().getDimension(R.dimen.tbds62);
        } else {
            setOrientation(0);
            layoutParams.leftMargin = (int) getResources().getDimension(R.dimen.tbds52);
            layoutParams.topMargin = 0;
        }
        this.lvp.setLayoutParams(layoutParams);
    }

    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.free_flow) {
                com.baidu.tbadk.browser.a.startWebActivity(true, getContext(), getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
            } else if (view.getId() == R.id.play) {
                setHasAgreeToPlay(true);
                if (this.lvq != null) {
                    this.lvq.onClick(view);
                }
                TiebaStatic.log(new aq("c13257").ai("obj_locate", 2).dD("tid", this.akY));
            }
        }
    }
}
