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
    private Runnable bzI;
    private int bzy;
    private boolean isShowing;
    private int jBV;
    private ImageView lff;
    private View mBgView;
    private View.OnClickListener mOnClickListener;
    private ImageView nKB;
    private View nKC;

    public TitleTipView(Context context) {
        super(context);
        this.jBV = 3;
        this.bzy = 5000;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.TitleTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TitleTipView.this.dismiss();
            }
        };
        this.bzI = new Runnable() { // from class: com.baidu.tieba.write.view.TitleTipView.2
            @Override // java.lang.Runnable
            public void run() {
                TitleTipView.this.dismiss();
            }
        };
        init();
    }

    public TitleTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jBV = 3;
        this.bzy = 5000;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.TitleTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TitleTipView.this.dismiss();
            }
        };
        this.bzI = new Runnable() { // from class: com.baidu.tieba.write.view.TitleTipView.2
            @Override // java.lang.Runnable
            public void run() {
                TitleTipView.this.dismiss();
            }
        };
        init();
    }

    public TitleTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jBV = 3;
        this.bzy = 5000;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.TitleTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TitleTipView.this.dismiss();
            }
        };
        this.bzI = new Runnable() { // from class: com.baidu.tieba.write.view.TitleTipView.2
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
        this.nKB = (ImageView) findViewById(R.id.img_icon);
        this.lff = (ImageView) findViewById(R.id.img_close);
        this.abj = (TextView) findViewById(R.id.tv_tip);
        this.nKC = findViewById(R.id.tv_line);
        this.abj.setText(R.string.add_title_tip);
        this.lff.setOnClickListener(this.mOnClickListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dUE() {
        setVisibility(0);
        this.isShowing = true;
        e.mY().postDelayed(this.bzI, this.bzy);
    }

    public void dismiss() {
        setVisibility(8);
        e.mY().removeCallbacks(this.bzI);
        this.isShowing = false;
    }

    public void onChangeSkinType(int i) {
        if (this.jBV != i) {
            ap.setBackgroundResource(this.mBgView, R.drawable.pic_post_tip_white_up_left);
            ap.setBackgroundColor(this.nKC, R.color.cp_bg_line_b);
            ap.setViewTextColor(this.abj, R.color.cp_cont_j);
            SvgManager.brn().a(this.lff, R.drawable.icon_pure_close_administration24_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            if (this.nKB != null) {
                this.nKB.setImageDrawable(WebPManager.a(R.drawable.icon_pure_post_fatiemijue, ap.getColor(R.color.cp_link_tip_a), null));
            }
        }
        this.jBV = i;
    }
}
