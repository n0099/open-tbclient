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
    private TextView aaR;
    private Runnable bnD;
    private int bnt;
    private int iUD;
    private boolean isShowing;
    private ImageView kxy;
    private View mBgView;
    private View.OnClickListener mOnClickListener;
    private ImageView ncJ;
    private View ncK;

    public TitleTipView(Context context) {
        super(context);
        this.iUD = 3;
        this.bnt = 5000;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.TitleTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TitleTipView.this.dismiss();
            }
        };
        this.bnD = new Runnable() { // from class: com.baidu.tieba.write.view.TitleTipView.2
            @Override // java.lang.Runnable
            public void run() {
                TitleTipView.this.dismiss();
            }
        };
        init();
    }

    public TitleTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iUD = 3;
        this.bnt = 5000;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.TitleTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TitleTipView.this.dismiss();
            }
        };
        this.bnD = new Runnable() { // from class: com.baidu.tieba.write.view.TitleTipView.2
            @Override // java.lang.Runnable
            public void run() {
                TitleTipView.this.dismiss();
            }
        };
        init();
    }

    public TitleTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iUD = 3;
        this.bnt = 5000;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.view.TitleTipView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TitleTipView.this.dismiss();
            }
        };
        this.bnD = new Runnable() { // from class: com.baidu.tieba.write.view.TitleTipView.2
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
        this.ncJ = (ImageView) findViewById(R.id.img_icon);
        this.kxy = (ImageView) findViewById(R.id.img_close);
        this.aaR = (TextView) findViewById(R.id.tv_tip);
        this.ncK = findViewById(R.id.tv_line);
        this.aaR.setText(R.string.add_title_tip);
        this.kxy.setOnClickListener(this.mOnClickListener);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void dLk() {
        setVisibility(0);
        this.isShowing = true;
        e.mX().postDelayed(this.bnD, this.bnt);
    }

    public void dismiss() {
        setVisibility(8);
        e.mX().removeCallbacks(this.bnD);
        this.isShowing = false;
    }

    public void onChangeSkinType(int i) {
        if (this.iUD != i) {
            ap.setBackgroundResource(this.mBgView, R.drawable.pic_post_tip_white_up_left);
            ap.setBackgroundColor(this.ncK, R.color.cp_bg_line_b);
            ap.setViewTextColor(this.aaR, R.color.cp_cont_j);
            SvgManager.bkl().a(this.kxy, R.drawable.icon_pure_close_administration24_svg, R.color.cp_cont_d, (SvgManager.SvgResourceStateType) null);
            if (this.ncJ != null) {
                this.ncJ.setImageDrawable(WebPManager.a(R.drawable.icon_pure_post_fatiemijue, ap.getColor(R.color.cp_link_tip_a), null));
            }
        }
        this.iUD = i;
    }
}
