package com.baidu.tieba.write.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.f.e;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class TitleTipView extends RelativeLayout {
    private TextView acm;
    private int bCV;
    private Runnable bDf;
    private boolean isShowing;
    private int jQw;
    private LinearLayout kQh;
    private ImageView lsX;
    private View.OnClickListener mOnClickListener;
    private ImageView oak;
    private View oal;

    public TitleTipView(Context context) {
        super(context);
        this.jQw = 3;
        this.bCV = 5000;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.TitleTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TitleTipView.this.dismiss();
            }
        };
        this.bDf = new Runnable() { // from class: com.baidu.tieba.write.view.TitleTipView.2
            @Override // java.lang.Runnable
            public void run() {
                TitleTipView.this.dismiss();
            }
        };
        init();
    }

    public TitleTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jQw = 3;
        this.bCV = 5000;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.TitleTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TitleTipView.this.dismiss();
            }
        };
        this.bDf = new Runnable() { // from class: com.baidu.tieba.write.view.TitleTipView.2
            @Override // java.lang.Runnable
            public void run() {
                TitleTipView.this.dismiss();
            }
        };
        init();
    }

    public TitleTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jQw = 3;
        this.bCV = 5000;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.TitleTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TitleTipView.this.dismiss();
            }
        };
        this.bDf = new Runnable() { // from class: com.baidu.tieba.write.view.TitleTipView.2
            @Override // java.lang.Runnable
            public void run() {
                TitleTipView.this.dismiss();
            }
        };
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.title_tip_layout, this);
        this.kQh = (LinearLayout) findViewById(R.id.tip_bg);
        this.oak = (ImageView) findViewById(R.id.img_icon);
        this.lsX = (ImageView) findViewById(R.id.img_close);
        this.acm = (TextView) findViewById(R.id.tv_tip);
        this.oal = findViewById(R.id.tv_line);
        this.acm.setText(R.string.add_title_tip);
        this.lsX.setOnClickListener(this.mOnClickListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dZY() {
        setVisibility(0);
        this.isShowing = true;
        e.mY().postDelayed(this.bDf, this.bCV);
    }

    public void dismiss() {
        setVisibility(8);
        e.mY().removeCallbacks(this.bDf);
        this.isShowing = false;
    }

    public void onChangeSkinType(int i) {
        if (this.jQw != i) {
            c.bm(this.kQh).pA(R.string.J_X05).pD(R.dimen.L_X01).pC(R.color.CAM_X0602).setBackGroundColor(R.color.CAM_X0206);
            c.bm(this.oal).setBackGroundColor(R.color.CAM_X0203);
            c.bm(this.acm).ps(R.color.CAM_X0107);
            this.lsX.setImageDrawable(WebPManager.a(R.drawable.icon_pure_home_delete16, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null));
            if (this.oak != null) {
                this.oak.setImageDrawable(WebPManager.a(R.drawable.pic_post_fatiemijue, ap.getColor(R.color.CAM_X0302), (WebPManager.ResourceStateType) null));
            }
        }
        this.jQw = i;
    }
}
