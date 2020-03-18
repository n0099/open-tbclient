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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.video.g;
/* loaded from: classes.dex */
public class OperableVideoNetworkStateTipView extends LinearLayout implements View.OnClickListener {
    private String Pk;
    private TBSpecificationBtn jAk;
    private TBSpecificationBtn jAl;
    protected View.OnClickListener jAm;

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
        this.jAk = (TBSpecificationBtn) findViewById(R.id.play);
        this.jAl = (TBSpecificationBtn) findViewById(R.id.free_flow);
        com.baidu.tbadk.core.view.commonBtn.d dVar = new com.baidu.tbadk.core.view.commonBtn.d();
        dVar.aIz();
        dVar.k(R.drawable.ic_icon_pure_video_play12_svg, 0, true);
        dVar.lr(l.getDimens(getContext(), R.dimen.tbds32));
        this.jAk.setText(getResources().getString(R.string.video_flow_play));
        this.jAk.setTextSize(R.dimen.tbds36);
        this.jAk.setConfig(dVar);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.jAl.setText(getResources().getString(R.string.video_open_free_data));
        this.jAl.setTextSize(R.dimen.tbds36);
        this.jAl.setConfig(bVar);
        this.jAk.setOnClickListener(this);
        this.jAl.setOnClickListener(this);
        setOnClickListener(this);
    }

    public void setVideoLength(long j) {
        if (j > 0) {
            this.jAk.setText(String.format(getResources().getString(R.string.video_data), aq.getFormatSize(j)));
        }
    }

    public void setVideoDuration(int i) {
    }

    public void setTid(String str) {
        this.Pk = str;
    }

    public boolean cuv() {
        return (hasAgreeToPlay() || g.cPC().cPD() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !j.isMobileNet()) ? false : true;
    }

    public void setHasAgreeToPlay(boolean z) {
        TbSingleton.getInstance().setHasAgreeToPlay(z);
    }

    public boolean hasAgreeToPlay() {
        return TbSingleton.getInstance().hasAgreeToPlay();
    }

    public void setPlayViewOnClickListener(View.OnClickListener onClickListener) {
        this.jAm = onClickListener;
    }

    public void ah(boolean z, boolean z2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jAl.getLayoutParams();
        if (z && !z2) {
            setOrientation(1);
            layoutParams.leftMargin = 0;
            layoutParams.topMargin = (int) getResources().getDimension(R.dimen.tbds62);
        } else {
            setOrientation(0);
            layoutParams.leftMargin = (int) getResources().getDimension(R.dimen.tbds52);
            layoutParams.topMargin = 0;
        }
        this.jAl.setLayoutParams(layoutParams);
    }

    public void onClick(View view) {
        if (view != null) {
            if (view.getId() == R.id.free_flow) {
                com.baidu.tbadk.browser.a.startWebActivity(true, getContext(), getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
            } else if (view.getId() == R.id.play) {
                setHasAgreeToPlay(true);
                if (this.jAm != null) {
                    this.jAm.onClick(view);
                }
                TiebaStatic.log(new an("c13257").X("obj_locate", 2).cx("tid", this.Pk));
            }
        }
    }
}
