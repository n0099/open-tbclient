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
    private TextView abo;
    private int bxN;
    private Runnable bxX;
    private boolean isShowing;
    private int jCS;
    private LinearLayout kCN;
    private ImageView lfw;
    private View.OnClickListener mOnClickListener;
    private ImageView nMc;
    private View nMd;

    public TitleTipView(Context context) {
        super(context);
        this.jCS = 3;
        this.bxN = 5000;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.TitleTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TitleTipView.this.dismiss();
            }
        };
        this.bxX = new Runnable() { // from class: com.baidu.tieba.write.view.TitleTipView.2
            @Override // java.lang.Runnable
            public void run() {
                TitleTipView.this.dismiss();
            }
        };
        init();
    }

    public TitleTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jCS = 3;
        this.bxN = 5000;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.TitleTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TitleTipView.this.dismiss();
            }
        };
        this.bxX = new Runnable() { // from class: com.baidu.tieba.write.view.TitleTipView.2
            @Override // java.lang.Runnable
            public void run() {
                TitleTipView.this.dismiss();
            }
        };
        init();
    }

    public TitleTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jCS = 3;
        this.bxN = 5000;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.TitleTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TitleTipView.this.dismiss();
            }
        };
        this.bxX = new Runnable() { // from class: com.baidu.tieba.write.view.TitleTipView.2
            @Override // java.lang.Runnable
            public void run() {
                TitleTipView.this.dismiss();
            }
        };
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.title_tip_layout, this);
        this.kCN = (LinearLayout) findViewById(R.id.tip_bg);
        this.nMc = (ImageView) findViewById(R.id.img_icon);
        this.lfw = (ImageView) findViewById(R.id.img_close);
        this.abo = (TextView) findViewById(R.id.tv_tip);
        this.nMd = findViewById(R.id.tv_line);
        this.abo.setText(R.string.add_title_tip);
        this.lfw.setOnClickListener(this.mOnClickListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dUD() {
        setVisibility(0);
        this.isShowing = true;
        e.mY().postDelayed(this.bxX, this.bxN);
    }

    public void dismiss() {
        setVisibility(8);
        e.mY().removeCallbacks(this.bxX);
        this.isShowing = false;
    }

    public void onChangeSkinType(int i) {
        if (this.jCS != i) {
            c.bj(this.kCN).pb(R.string.J_X05).pd(R.dimen.L_X01).pc(R.color.CAM_X0602).setBackGroundColor(R.color.CAM_X0206);
            c.bj(this.nMd).setBackGroundColor(R.color.CAM_X0203);
            c.bj(this.abo).oT(R.color.CAM_X0107);
            this.lfw.setImageDrawable(WebPManager.a(R.drawable.icon_pure_home_delete16, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null));
            if (this.nMc != null) {
                this.nMc.setImageDrawable(WebPManager.a(R.drawable.pic_post_fatiemijue, ap.getColor(R.color.CAM_X0302), (WebPManager.ResourceStateType) null));
            }
        }
        this.jCS = i;
    }
}
