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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class l extends FrameLayout implements View.OnClickListener {
    private boolean aNG;
    private TextView aSO;
    private com.baidu.tieba.tbadkCore.data.a exU;
    private TbImageView exV;
    private LinearLayout exW;
    private ImageView exX;
    private TextView exY;
    private Context mContext;
    private View mRootView;

    public l(Context context) {
        this(context, null, 0);
    }

    public l(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aNG = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.exU;
    }

    public void ID() {
        this.aNG = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(w.j.pic_show_cardview_layout, (ViewGroup) this, true);
        this.exV = (TbImageView) findViewById(w.h.pic_img);
        this.exW = (LinearLayout) findViewById(w.h.bottom_ll);
        this.aSO = (TextView) findViewById(w.h.title_ll);
        this.exY = (TextView) findViewById(w.h.desc_ll);
        this.exX = (ImageView) findViewById(w.h.show_pic_icon);
    }

    public void setIconResId(int i) {
        aq.c(this.exX, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.exU != aVar) {
            this.exU = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.aSO.setVisibility(0);
                this.aSO.setText(aVar.getTitle());
            } else {
                this.aSO.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.exY.setVisibility(0);
                this.exY.setText(aVar.getDescription());
            } else {
                this.exY.setVisibility(8);
            }
            if (this.aNG) {
                this.exV.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.exV.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.exV.setOnClickListener(this);
                this.exV.setInterceptOnClick(true);
                this.exV.setDefaultResource(w.g.icon_click);
                this.exV.c(aVar.bgV(), 18, false);
                int ag = com.baidu.adp.lib.util.k.ag(this.mContext) - (com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (ag * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (ag * 0.75f);
                } else {
                    i = (int) (f * ag);
                }
                this.exV.setLayoutParams(new FrameLayout.LayoutParams(ag, i));
                removeView(this.exV);
                addView(this.exV);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.exW.getLayoutParams();
                layoutParams.width = ag;
                layoutParams.height = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds110);
                removeView(this.exW);
                addView(this.exW, layoutParams);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ah(i == 1);
        tbPageContext.getLayoutMode().t(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.exU != null) {
            com.baidu.tbadk.browser.f.O(this.mContext, this.exU.bgW());
        }
    }

    public ImageView getIcon() {
        return this.exX;
    }
}
