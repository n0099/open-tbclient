package com.baidu.tieba.write.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.f.e;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class TitleTipView extends RelativeLayout {
    private TextView abj;
    private int btl;
    private Runnable btw;
    private boolean isShowing;
    private int jvY;
    private ImageView kZh;
    private View mBgView;
    private View.OnClickListener mOnClickListener;
    private ImageView nEH;
    private View nEI;

    public TitleTipView(Context context) {
        super(context);
        this.jvY = 3;
        this.btl = 5000;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.TitleTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TitleTipView.this.dismiss();
            }
        };
        this.btw = new Runnable() { // from class: com.baidu.tieba.write.view.TitleTipView.2
            @Override // java.lang.Runnable
            public void run() {
                TitleTipView.this.dismiss();
            }
        };
        init();
    }

    public TitleTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jvY = 3;
        this.btl = 5000;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.TitleTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TitleTipView.this.dismiss();
            }
        };
        this.btw = new Runnable() { // from class: com.baidu.tieba.write.view.TitleTipView.2
            @Override // java.lang.Runnable
            public void run() {
                TitleTipView.this.dismiss();
            }
        };
        init();
    }

    public TitleTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jvY = 3;
        this.btl = 5000;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.TitleTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TitleTipView.this.dismiss();
            }
        };
        this.btw = new Runnable() { // from class: com.baidu.tieba.write.view.TitleTipView.2
            @Override // java.lang.Runnable
            public void run() {
                TitleTipView.this.dismiss();
            }
        };
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.title_tip_layout, this);
        this.mBgView = findViewById(R.id.tip_bg);
        this.nEH = (ImageView) findViewById(R.id.img_icon);
        this.kZh = (ImageView) findViewById(R.id.img_close);
        this.abj = (TextView) findViewById(R.id.tv_tip);
        this.nEI = findViewById(R.id.tv_line);
        this.abj.setText(R.string.add_title_tip);
        this.kZh.setOnClickListener(this.mOnClickListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dSe() {
        setVisibility(0);
        this.isShowing = true;
        e.mY().postDelayed(this.btw, this.btl);
    }

    public void dismiss() {
        setVisibility(8);
        e.mY().removeCallbacks(this.btw);
        this.isShowing = false;
    }

    public void onChangeSkinType(int i) {
        if (this.jvY != i) {
            ap.setBackgroundResource(this.mBgView, R.drawable.pic_post_tip_white_up_left);
            ap.setBackgroundColor(this.nEI, R.color.cp_bg_line_b);
            ap.setViewTextColor(this.abj, R.color.cp_cont_j);
            SvgManager.boN().a(this.kZh, R.drawable.icon_pure_close_administration24_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            if (this.nEH != null) {
                this.nEH.setImageDrawable(WebPManager.a(R.drawable.icon_pure_post_fatiemijue, ap.getColor(R.color.cp_link_tip_a), null));
            }
        }
        this.jvY = i;
    }
}
