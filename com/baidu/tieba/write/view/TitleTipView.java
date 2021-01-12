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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class TitleTipView extends RelativeLayout {
    private TextView acW;
    private int bCV;
    private Runnable bDf;
    private boolean isShowing;
    private int jZf;
    private LinearLayout kRh;
    private ImageView ltA;
    private View.OnClickListener mOnClickListener;
    private ImageView nXQ;
    private View nXR;

    public TitleTipView(Context context) {
        super(context);
        this.jZf = 3;
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
        this.jZf = 3;
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
        this.jZf = 3;
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
        this.kRh = (LinearLayout) findViewById(R.id.tip_bg);
        this.nXQ = (ImageView) findViewById(R.id.img_icon);
        this.ltA = (ImageView) findViewById(R.id.img_close);
        this.acW = (TextView) findViewById(R.id.tv_tip);
        this.nXR = findViewById(R.id.tv_line);
        this.acW.setText(R.string.add_title_tip);
        this.ltA.setOnClickListener(this.mOnClickListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dVq() {
        setVisibility(0);
        this.isShowing = true;
        e.mB().postDelayed(this.bDf, this.bCV);
    }

    public void dismiss() {
        setVisibility(8);
        e.mB().removeCallbacks(this.bDf);
        this.isShowing = false;
    }

    public void onChangeSkinType(int i) {
        if (this.jZf != i) {
            c.bv(this.kRh).od(R.string.J_X05).og(R.dimen.L_X01).of(R.color.CAM_X0602).setBackGroundColor(R.color.CAM_X0206);
            c.bv(this.nXR).setBackGroundColor(R.color.CAM_X0203);
            c.bv(this.acW).nV(R.color.CAM_X0107);
            this.ltA.setImageDrawable(WebPManager.a(R.drawable.icon_pure_home_delete16, ao.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null));
            if (this.nXQ != null) {
                this.nXQ.setImageDrawable(WebPManager.a(R.drawable.pic_post_fatiemijue, ao.getColor(R.color.CAM_X0302), (WebPManager.ResourceStateType) null));
            }
        }
        this.jZf = i;
    }
}
