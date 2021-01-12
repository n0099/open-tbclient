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
import com.baidu.tieba.video.f;
/* loaded from: classes.dex */
public class OperableVideoNetworkStateTipView extends LinearLayout implements View.OnClickListener {
    private String amM;
    private TBSpecificationBtn mBi;
    private TBSpecificationBtn mBj;
    protected View.OnClickListener mBk;

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
        this.mBi = (TBSpecificationBtn) findViewById(R.id.play);
        this.mBj = (TBSpecificationBtn) findViewById(R.id.free_flow);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.buE();
        cVar.a(R.drawable.ic_icon_pure_video_play12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        cVar.setIconSize(l.getDimens(getContext(), R.dimen.tbds32));
        this.mBi.setText(getResources().getString(R.string.video_flow_play));
        this.mBi.setTextSize(R.dimen.tbds36);
        this.mBi.setConfig(cVar);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.mBj.setText(getResources().getString(R.string.video_open_free_data));
        this.mBj.setTextSize(R.dimen.tbds36);
        this.mBj.setConfig(aVar);
        this.mBi.setOnClickListener(this);
        this.mBj.setOnClickListener(this);
        setOnClickListener(this);
    }

    public void setVideoLength(long j) {
        if (j > 0) {
            this.mBi.setText(String.format(getResources().getString(R.string.video_data), at.getFormatSize(j)));
        }
    }

    public void setVideoDuration(int i) {
    }

    public void setTid(String str) {
        this.amM = str;
    }

    public boolean dth() {
        return (hasAgreeToPlay() || f.dPM().dPN() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !j.isMobileNet()) ? false : true;
    }

    public void setHasAgreeToPlay(boolean z) {
        TbSingleton.getInstance().setHasAgreeToPlay(z);
    }

    public boolean hasAgreeToPlay() {
        return TbSingleton.getInstance().hasAgreeToPlay();
    }

    public void setPlayViewOnClickListener(View.OnClickListener onClickListener) {
        this.mBk = onClickListener;
    }

    public void au(boolean z, boolean z2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBj.getLayoutParams();
        if (z && !z2) {
            setOrientation(1);
            layoutParams.leftMargin = 0;
            layoutParams.topMargin = (int) getResources().getDimension(R.dimen.tbds62);
        } else {
            setOrientation(0);
            layoutParams.leftMargin = (int) getResources().getDimension(R.dimen.tbds52);
            layoutParams.topMargin = 0;
        }
        this.mBj.setLayoutParams(layoutParams);
    }

    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.free_flow) {
                com.baidu.tbadk.browser.a.startWebActivity(true, getContext(), getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
            } else if (view.getId() == R.id.play) {
                setHasAgreeToPlay(true);
                if (this.mBk != null) {
                    this.mBk.onClick(view);
                }
                TiebaStatic.log(new aq("c13257").an("obj_locate", 2).dW("tid", this.amM));
            }
        }
    }
}
