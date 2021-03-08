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
/* loaded from: classes7.dex */
public class TitleTipView extends RelativeLayout {
    private TextView aek;
    private int bIf;
    private Runnable bIp;
    private boolean isShowing;
    private int kiZ;
    private ImageView lDU;
    private LinearLayout lbA;
    private View.OnClickListener mOnClickListener;
    private ImageView okC;
    private View okD;

    public TitleTipView(Context context) {
        super(context);
        this.kiZ = 3;
        this.bIf = 5000;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.TitleTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TitleTipView.this.dismiss();
            }
        };
        this.bIp = new Runnable() { // from class: com.baidu.tieba.write.view.TitleTipView.2
            @Override // java.lang.Runnable
            public void run() {
                TitleTipView.this.dismiss();
            }
        };
        init();
    }

    public TitleTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kiZ = 3;
        this.bIf = 5000;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.TitleTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TitleTipView.this.dismiss();
            }
        };
        this.bIp = new Runnable() { // from class: com.baidu.tieba.write.view.TitleTipView.2
            @Override // java.lang.Runnable
            public void run() {
                TitleTipView.this.dismiss();
            }
        };
        init();
    }

    public TitleTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kiZ = 3;
        this.bIf = 5000;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.TitleTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TitleTipView.this.dismiss();
            }
        };
        this.bIp = new Runnable() { // from class: com.baidu.tieba.write.view.TitleTipView.2
            @Override // java.lang.Runnable
            public void run() {
                TitleTipView.this.dismiss();
            }
        };
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.title_tip_layout, this);
        this.lbA = (LinearLayout) findViewById(R.id.tip_bg);
        this.okC = (ImageView) findViewById(R.id.img_icon);
        this.lDU = (ImageView) findViewById(R.id.img_close);
        this.aek = (TextView) findViewById(R.id.tv_tip);
        this.okD = findViewById(R.id.tv_line);
        this.aek.setText(R.string.add_title_tip);
        this.lDU.setOnClickListener(this.mOnClickListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dXU() {
        setVisibility(0);
        this.isShowing = true;
        e.mA().postDelayed(this.bIp, this.bIf);
    }

    public void dismiss() {
        setVisibility(8);
        e.mA().removeCallbacks(this.bIp);
        this.isShowing = false;
    }

    public void onChangeSkinType(int i) {
        if (this.kiZ != i) {
            c.br(this.lbA).oh(R.string.J_X05).ol(R.dimen.L_X01).ok(R.color.CAM_X0602).setBackGroundColor(R.color.CAM_X0206);
            c.br(this.okD).setBackGroundColor(R.color.CAM_X0203);
            c.br(this.aek).nZ(R.color.CAM_X0107);
            this.lDU.setImageDrawable(WebPManager.a(R.drawable.icon_pure_home_delete16, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null));
            if (this.okC != null) {
                this.okC.setImageDrawable(WebPManager.a(R.drawable.pic_post_fatiemijue, ap.getColor(R.color.CAM_X0302), (WebPManager.ResourceStateType) null));
            }
        }
        this.kiZ = i;
    }
}
