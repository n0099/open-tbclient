package com.baidu.tieba.play.operableVideoView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.video.g;
/* loaded from: classes.dex */
public class OperableVideoNetworkStateTipView extends LinearLayout {
    private String bVM;
    private LinearLayout isE;
    private TextView isF;
    private TextView isG;
    private View.OnClickListener isH;
    private View.OnClickListener mOnClickListener;

    public OperableVideoNetworkStateTipView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == R.id.free_flow) {
                        com.baidu.tbadk.browser.a.a(true, OperableVideoNetworkStateTipView.this.getContext(), OperableVideoNetworkStateTipView.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    } else if (view.getId() == R.id.play) {
                        OperableVideoNetworkStateTipView.this.setHasAgreeToPlay(true);
                        if (OperableVideoNetworkStateTipView.this.isH != null) {
                            OperableVideoNetworkStateTipView.this.isH.onClick(view);
                        }
                        TiebaStatic.log(new am("c13257").P("obj_locate", 2).bT("tid", OperableVideoNetworkStateTipView.this.bVM));
                    }
                }
            }
        };
        init();
    }

    public OperableVideoNetworkStateTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == R.id.free_flow) {
                        com.baidu.tbadk.browser.a.a(true, OperableVideoNetworkStateTipView.this.getContext(), OperableVideoNetworkStateTipView.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    } else if (view.getId() == R.id.play) {
                        OperableVideoNetworkStateTipView.this.setHasAgreeToPlay(true);
                        if (OperableVideoNetworkStateTipView.this.isH != null) {
                            OperableVideoNetworkStateTipView.this.isH.onClick(view);
                        }
                        TiebaStatic.log(new am("c13257").P("obj_locate", 2).bT("tid", OperableVideoNetworkStateTipView.this.bVM));
                    }
                }
            }
        };
        init();
    }

    public OperableVideoNetworkStateTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == R.id.free_flow) {
                        com.baidu.tbadk.browser.a.a(true, OperableVideoNetworkStateTipView.this.getContext(), OperableVideoNetworkStateTipView.this.getResources().getString(R.string.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    } else if (view.getId() == R.id.play) {
                        OperableVideoNetworkStateTipView.this.setHasAgreeToPlay(true);
                        if (OperableVideoNetworkStateTipView.this.isH != null) {
                            OperableVideoNetworkStateTipView.this.isH.onClick(view);
                        }
                        TiebaStatic.log(new am("c13257").P("obj_locate", 2).bT("tid", OperableVideoNetworkStateTipView.this.bVM));
                    }
                }
            }
        };
        init();
    }

    public int getLayoutR() {
        return R.layout.operable_video_network_state_tip;
    }

    private void init() {
        inflate(getContext(), getLayoutR(), this);
        this.isE = (LinearLayout) findViewById(R.id.play);
        this.isF = (TextView) findViewById(R.id.play_txt);
        this.isG = (TextView) findViewById(R.id.free_flow);
        this.isG.setOnClickListener(this.mOnClickListener);
        this.isE.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
    }

    public void setVideoLength(long j) {
        if (j > 0) {
            this.isF.setText(String.format(getResources().getString(R.string.video_data), ap.aT(j)));
        }
    }

    public void setTid(String str) {
        this.bVM = str;
    }

    public boolean ccp() {
        return (hasAgreeToPlay() || g.cqT().cqU() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !j.jU()) ? false : true;
    }

    public void setHasAgreeToPlay(boolean z) {
        TbSingleton.getInstance().setHasAgreeToPlay(z);
    }

    public boolean hasAgreeToPlay() {
        return TbSingleton.getInstance().hasAgreeToPlay();
    }

    public void setPlayViewOnClickListener(View.OnClickListener onClickListener) {
        this.isH = onClickListener;
    }

    public void ae(boolean z, boolean z2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.isG.getLayoutParams();
        if (z && !z2) {
            setOrientation(1);
            layoutParams.leftMargin = 0;
            layoutParams.topMargin = (int) getResources().getDimension(R.dimen.tbds40);
            setGravity(17);
            setPadding(0, 0, 0, 0);
        } else {
            if (!z2) {
                setGravity(21);
                setPadding(0, 0, (int) getResources().getDimension(R.dimen.tbds195), 0);
            } else {
                setGravity(17);
                setPadding(0, 0, 0, 0);
            }
            setOrientation(0);
            layoutParams.leftMargin = (int) getResources().getDimension(R.dimen.tbds104);
            layoutParams.topMargin = 0;
        }
        this.isG.setLayoutParams(layoutParams);
    }
}
