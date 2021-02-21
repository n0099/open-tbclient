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
/* loaded from: classes8.dex */
public class TitleTipView extends RelativeLayout {
    private TextView acQ;
    private int bGF;
    private Runnable bGP;
    private boolean isShowing;
    private LinearLayout kZx;
    private int kgW;
    private ImageView lBS;
    private View.OnClickListener mOnClickListener;
    private ImageView oix;
    private View oiy;

    public TitleTipView(Context context) {
        super(context);
        this.kgW = 3;
        this.bGF = 5000;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.TitleTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TitleTipView.this.dismiss();
            }
        };
        this.bGP = new Runnable() { // from class: com.baidu.tieba.write.view.TitleTipView.2
            @Override // java.lang.Runnable
            public void run() {
                TitleTipView.this.dismiss();
            }
        };
        init();
    }

    public TitleTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kgW = 3;
        this.bGF = 5000;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.TitleTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TitleTipView.this.dismiss();
            }
        };
        this.bGP = new Runnable() { // from class: com.baidu.tieba.write.view.TitleTipView.2
            @Override // java.lang.Runnable
            public void run() {
                TitleTipView.this.dismiss();
            }
        };
        init();
    }

    public TitleTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kgW = 3;
        this.bGF = 5000;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.TitleTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TitleTipView.this.dismiss();
            }
        };
        this.bGP = new Runnable() { // from class: com.baidu.tieba.write.view.TitleTipView.2
            @Override // java.lang.Runnable
            public void run() {
                TitleTipView.this.dismiss();
            }
        };
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.title_tip_layout, this);
        this.kZx = (LinearLayout) findViewById(R.id.tip_bg);
        this.oix = (ImageView) findViewById(R.id.img_icon);
        this.lBS = (ImageView) findViewById(R.id.img_close);
        this.acQ = (TextView) findViewById(R.id.tv_tip);
        this.oiy = findViewById(R.id.tv_line);
        this.acQ.setText(R.string.add_title_tip);
        this.lBS.setOnClickListener(this.mOnClickListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dXM() {
        setVisibility(0);
        this.isShowing = true;
        e.mA().postDelayed(this.bGP, this.bGF);
    }

    public void dismiss() {
        setVisibility(8);
        e.mA().removeCallbacks(this.bGP);
        this.isShowing = false;
    }

    public void onChangeSkinType(int i) {
        if (this.kgW != i) {
            c.br(this.kZx).og(R.string.J_X05).ok(R.dimen.L_X01).oj(R.color.CAM_X0602).setBackGroundColor(R.color.CAM_X0206);
            c.br(this.oiy).setBackGroundColor(R.color.CAM_X0203);
            c.br(this.acQ).nY(R.color.CAM_X0107);
            this.lBS.setImageDrawable(WebPManager.a(R.drawable.icon_pure_home_delete16, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null));
            if (this.oix != null) {
                this.oix.setImageDrawable(WebPManager.a(R.drawable.pic_post_fatiemijue, ap.getColor(R.color.CAM_X0302), (WebPManager.ResourceStateType) null));
            }
        }
        this.kgW = i;
    }
}
