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
/* loaded from: classes8.dex */
public class TitleTipView extends RelativeLayout {
    private TextView acY;
    private int bHH;
    private Runnable bHR;
    private boolean isShowing;
    private LinearLayout kVM;
    private int kdK;
    private ImageView lyf;
    private View.OnClickListener mOnClickListener;
    private ImageView ocy;
    private View ocz;

    public TitleTipView(Context context) {
        super(context);
        this.kdK = 3;
        this.bHH = 5000;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.TitleTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TitleTipView.this.dismiss();
            }
        };
        this.bHR = new Runnable() { // from class: com.baidu.tieba.write.view.TitleTipView.2
            @Override // java.lang.Runnable
            public void run() {
                TitleTipView.this.dismiss();
            }
        };
        init();
    }

    public TitleTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kdK = 3;
        this.bHH = 5000;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.TitleTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TitleTipView.this.dismiss();
            }
        };
        this.bHR = new Runnable() { // from class: com.baidu.tieba.write.view.TitleTipView.2
            @Override // java.lang.Runnable
            public void run() {
                TitleTipView.this.dismiss();
            }
        };
        init();
    }

    public TitleTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kdK = 3;
        this.bHH = 5000;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.TitleTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TitleTipView.this.dismiss();
            }
        };
        this.bHR = new Runnable() { // from class: com.baidu.tieba.write.view.TitleTipView.2
            @Override // java.lang.Runnable
            public void run() {
                TitleTipView.this.dismiss();
            }
        };
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.title_tip_layout, this);
        this.kVM = (LinearLayout) findViewById(R.id.tip_bg);
        this.ocy = (ImageView) findViewById(R.id.img_icon);
        this.lyf = (ImageView) findViewById(R.id.img_close);
        this.acY = (TextView) findViewById(R.id.tv_tip);
        this.ocz = findViewById(R.id.tv_line);
        this.acY.setText(R.string.add_title_tip);
        this.lyf.setOnClickListener(this.mOnClickListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dZh() {
        setVisibility(0);
        this.isShowing = true;
        e.mB().postDelayed(this.bHR, this.bHH);
    }

    public void dismiss() {
        setVisibility(8);
        e.mB().removeCallbacks(this.bHR);
        this.isShowing = false;
    }

    public void onChangeSkinType(int i) {
        if (this.kdK != i) {
            c.bv(this.kVM).pK(R.string.J_X05).pN(R.dimen.L_X01).pM(R.color.CAM_X0602).setBackGroundColor(R.color.CAM_X0206);
            c.bv(this.ocz).setBackGroundColor(R.color.CAM_X0203);
            c.bv(this.acY).pC(R.color.CAM_X0107);
            this.lyf.setImageDrawable(WebPManager.a(R.drawable.icon_pure_home_delete16, ao.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null));
            if (this.ocy != null) {
                this.ocy.setImageDrawable(WebPManager.a(R.drawable.pic_post_fatiemijue, ao.getColor(R.color.CAM_X0302), (WebPManager.ResourceStateType) null));
            }
        }
        this.kdK = i;
    }
}
