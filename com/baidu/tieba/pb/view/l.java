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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class l extends FrameLayout implements View.OnClickListener {
    private boolean aJC;
    private TextView aNY;
    private com.baidu.tieba.tbadkCore.data.a ekC;
    private TbImageView ekD;
    private LinearLayout ekE;
    private ImageView ekF;
    private TextView ekG;
    private Context mContext;
    private View mRootView;

    public l(Context context) {
        this(context, null, 0);
    }

    public l(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aJC = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.ekC;
    }

    public void Im() {
        this.aJC = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(r.h.pic_show_cardview_layout, (ViewGroup) this, true);
        this.ekD = (TbImageView) findViewById(r.g.pic_img);
        this.ekE = (LinearLayout) findViewById(r.g.bottom_ll);
        this.aNY = (TextView) findViewById(r.g.title_ll);
        this.ekG = (TextView) findViewById(r.g.desc_ll);
        this.ekF = (ImageView) findViewById(r.g.show_pic_icon);
    }

    public void setIconResId(int i) {
        ar.c(this.ekF, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.ekC != aVar) {
            this.ekC = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.aNY.setVisibility(0);
                this.aNY.setText(aVar.getTitle());
            } else {
                this.aNY.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.ekG.setVisibility(0);
                this.ekG.setText(aVar.getDescription());
            } else {
                this.ekG.setVisibility(8);
            }
            if (this.aJC) {
                this.ekD.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.ekD.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.ekD.setOnClickListener(this);
                this.ekD.setInterceptOnClick(true);
                this.ekD.setDefaultResource(r.f.icon_click);
                this.ekD.c(aVar.bfs(), 18, false);
                int I = com.baidu.adp.lib.util.k.I(this.mContext) - (com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (I * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (I * 0.75f);
                } else {
                    i = (int) (f * I);
                }
                this.ekD.setLayoutParams(new FrameLayout.LayoutParams(I, i));
                removeView(this.ekD);
                addView(this.ekD);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ekE.getLayoutParams();
                layoutParams.width = I;
                layoutParams.height = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds110);
                removeView(this.ekE);
                addView(this.ekE, layoutParams);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ai(i == 1);
        tbPageContext.getLayoutMode().x(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ekC != null) {
            com.baidu.tbadk.browser.f.u(this.mContext, this.ekC.bft());
        }
    }

    public ImageView getIcon() {
        return this.ekF;
    }
}
