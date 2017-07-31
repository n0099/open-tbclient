package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class i extends FrameLayout implements View.OnClickListener {
    private boolean aSa;
    private LinearLayout faA;
    private ImageView faB;
    private TextView faC;
    private com.baidu.tieba.tbadkCore.data.a fay;
    private TbImageView faz;
    private Context mContext;
    private View mRootView;
    private TextView mTitle;

    public i(Context context) {
        this(context, null, 0);
    }

    public i(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aSa = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.fay;
    }

    public void Jc() {
        this.aSa = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.pic_show_cardview_layout, (ViewGroup) this, true);
        this.faz = (TbImageView) findViewById(d.h.pic_img);
        this.faA = (LinearLayout) findViewById(d.h.bottom_ll);
        this.mTitle = (TextView) findViewById(d.h.title_ll);
        this.faC = (TextView) findViewById(d.h.desc_ll);
        this.faB = (ImageView) findViewById(d.h.show_pic_icon);
    }

    public void setIconResId(int i) {
        ai.c(this.faB, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.fay != aVar) {
            this.fay = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.faC.setVisibility(0);
                this.faC.setText(aVar.getDescription());
            } else {
                this.faC.setVisibility(8);
            }
            if (this.aSa) {
                this.faz.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.faz.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.faz.setOnClickListener(this);
                this.faz.setInterceptOnClick(true);
                this.faz.setDefaultResource(d.g.icon_click);
                this.faz.c(aVar.brT(), 18, false);
                int ag = k.ag(this.mContext) - (k.g(this.mContext, d.f.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (ag * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (ag * 0.75f);
                } else {
                    i = (int) (f * ag);
                }
                this.faz.setLayoutParams(new FrameLayout.LayoutParams(ag, i));
                removeView(this.faz);
                addView(this.faz);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.faA.getLayoutParams();
                layoutParams.width = ag;
                layoutParams.height = k.g(this.mContext, d.f.ds110);
                removeView(this.faA);
                addView(this.faA, layoutParams);
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ah(i == 1);
        tbPageContext.getLayoutMode().t(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fay != null) {
            com.baidu.tbadk.browser.a.T(this.mContext, this.fay.brU());
        }
    }

    public ImageView getIcon() {
        return this.faB;
    }
}
