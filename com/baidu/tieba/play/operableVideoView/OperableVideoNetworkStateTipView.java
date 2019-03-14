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
import com.baidu.tieba.d;
import com.baidu.tieba.video.g;
/* loaded from: classes.dex */
public class OperableVideoNetworkStateTipView extends LinearLayout {
    private String ctu;
    private LinearLayout iah;
    private TextView iai;
    private TextView iaj;
    private View.OnClickListener iak;
    private View.OnClickListener mOnClickListener;

    public OperableVideoNetworkStateTipView(Context context) {
        super(context);
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null) {
                    if (view.getId() == d.g.free_flow) {
                        com.baidu.tbadk.browser.a.a(true, OperableVideoNetworkStateTipView.this.getContext(), OperableVideoNetworkStateTipView.this.getResources().getString(d.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    } else if (view.getId() == d.g.play) {
                        OperableVideoNetworkStateTipView.this.setHasAgreeToPlay(true);
                        if (OperableVideoNetworkStateTipView.this.iak != null) {
                            OperableVideoNetworkStateTipView.this.iak.onClick(view);
                        }
                        TiebaStatic.log(new am("c13257").T("obj_locate", 2).bJ("tid", OperableVideoNetworkStateTipView.this.ctu));
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
                    if (view.getId() == d.g.free_flow) {
                        com.baidu.tbadk.browser.a.a(true, OperableVideoNetworkStateTipView.this.getContext(), OperableVideoNetworkStateTipView.this.getResources().getString(d.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    } else if (view.getId() == d.g.play) {
                        OperableVideoNetworkStateTipView.this.setHasAgreeToPlay(true);
                        if (OperableVideoNetworkStateTipView.this.iak != null) {
                            OperableVideoNetworkStateTipView.this.iak.onClick(view);
                        }
                        TiebaStatic.log(new am("c13257").T("obj_locate", 2).bJ("tid", OperableVideoNetworkStateTipView.this.ctu));
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
                    if (view.getId() == d.g.free_flow) {
                        com.baidu.tbadk.browser.a.a(true, OperableVideoNetworkStateTipView.this.getContext(), OperableVideoNetworkStateTipView.this.getResources().getString(d.j.free_data_privilege), TbConfig.URL_BAIDU_SINGKIL);
                    } else if (view.getId() == d.g.play) {
                        OperableVideoNetworkStateTipView.this.setHasAgreeToPlay(true);
                        if (OperableVideoNetworkStateTipView.this.iak != null) {
                            OperableVideoNetworkStateTipView.this.iak.onClick(view);
                        }
                        TiebaStatic.log(new am("c13257").T("obj_locate", 2).bJ("tid", OperableVideoNetworkStateTipView.this.ctu));
                    }
                }
            }
        };
        init();
    }

    public int getLayoutR() {
        return d.h.operable_video_network_state_tip;
    }

    private void init() {
        inflate(getContext(), getLayoutR(), this);
        this.iah = (LinearLayout) findViewById(d.g.play);
        this.iai = (TextView) findViewById(d.g.play_txt);
        this.iaj = (TextView) findViewById(d.g.free_flow);
        this.iaj.setOnClickListener(this.mOnClickListener);
        this.iah.setOnClickListener(this.mOnClickListener);
        setOnClickListener(this.mOnClickListener);
    }

    public void setVideoLength(long j) {
        if (j > 0) {
            this.iai.setText(String.format(getResources().getString(d.j.video_data), ap.aE(j)));
        }
    }

    public void setTid(String str) {
        this.ctu = str;
    }

    public boolean bUo() {
        return (hasAgreeToPlay() || g.ciP().ciQ() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !j.la()) ? false : true;
    }

    public void setHasAgreeToPlay(boolean z) {
        TbSingleton.getInstance().setHasAgreeToPlay(z);
    }

    public boolean hasAgreeToPlay() {
        return TbSingleton.getInstance().hasAgreeToPlay();
    }

    public void setPlayViewOnClickListener(View.OnClickListener onClickListener) {
        this.iak = onClickListener;
    }

    public void af(boolean z, boolean z2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iaj.getLayoutParams();
        if (z && !z2) {
            setOrientation(1);
            layoutParams.leftMargin = 0;
            layoutParams.topMargin = (int) getResources().getDimension(d.e.tbds40);
            setGravity(17);
            setPadding(0, 0, 0, 0);
        } else {
            if (!z2) {
                setGravity(21);
                setPadding(0, 0, (int) getResources().getDimension(d.e.tbds195), 0);
            } else {
                setGravity(17);
                setPadding(0, 0, 0, 0);
            }
            setOrientation(0);
            layoutParams.leftMargin = (int) getResources().getDimension(d.e.tbds104);
            layoutParams.topMargin = 0;
        }
        this.iaj.setLayoutParams(layoutParams);
    }
}
