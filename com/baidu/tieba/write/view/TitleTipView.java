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
    private TextView abi;
    private int brg;
    private Runnable brq;
    private boolean isShowing;
    private int jjB;
    private ImageView kMK;
    private View mBgView;
    private View.OnClickListener mOnClickListener;
    private ImageView nsi;
    private View nsj;

    public TitleTipView(Context context) {
        super(context);
        this.jjB = 3;
        this.brg = 5000;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.TitleTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TitleTipView.this.dismiss();
            }
        };
        this.brq = new Runnable() { // from class: com.baidu.tieba.write.view.TitleTipView.2
            @Override // java.lang.Runnable
            public void run() {
                TitleTipView.this.dismiss();
            }
        };
        init();
    }

    public TitleTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jjB = 3;
        this.brg = 5000;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.TitleTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TitleTipView.this.dismiss();
            }
        };
        this.brq = new Runnable() { // from class: com.baidu.tieba.write.view.TitleTipView.2
            @Override // java.lang.Runnable
            public void run() {
                TitleTipView.this.dismiss();
            }
        };
        init();
    }

    public TitleTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jjB = 3;
        this.brg = 5000;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.TitleTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TitleTipView.this.dismiss();
            }
        };
        this.brq = new Runnable() { // from class: com.baidu.tieba.write.view.TitleTipView.2
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
        this.nsi = (ImageView) findViewById(R.id.img_icon);
        this.kMK = (ImageView) findViewById(R.id.img_close);
        this.abi = (TextView) findViewById(R.id.tv_tip);
        this.nsj = findViewById(R.id.tv_line);
        this.abi.setText(R.string.add_title_tip);
        this.kMK.setOnClickListener(this.mOnClickListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dOW() {
        setVisibility(0);
        this.isShowing = true;
        e.mY().postDelayed(this.brq, this.brg);
    }

    public void dismiss() {
        setVisibility(8);
        e.mY().removeCallbacks(this.brq);
        this.isShowing = false;
    }

    public void onChangeSkinType(int i) {
        if (this.jjB != i) {
            ap.setBackgroundResource(this.mBgView, R.drawable.pic_post_tip_white_up_left);
            ap.setBackgroundColor(this.nsj, R.color.cp_bg_line_b);
            ap.setViewTextColor(this.abi, R.color.cp_cont_j);
            SvgManager.bmU().a(this.kMK, R.drawable.icon_pure_close_administration24_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            if (this.nsi != null) {
                this.nsi.setImageDrawable(WebPManager.a(R.drawable.icon_pure_post_fatiemijue, ap.getColor(R.color.cp_link_tip_a), null));
            }
        }
        this.jjB = i;
    }
}
