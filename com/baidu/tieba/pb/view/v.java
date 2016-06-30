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
import com.baidu.tbadk.browser.f;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class v extends FrameLayout implements View.OnClickListener {
    private boolean aFQ;
    private TextView aSd;
    private com.baidu.tieba.tbadkCore.data.a dZo;
    private TbImageView dZp;
    private LinearLayout dZq;
    private ImageView dZr;
    private TextView dZs;
    private Context mContext;
    private View mRootView;

    public v(Context context) {
        this(context, null, 0);
    }

    public v(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aFQ = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.dZo;
    }

    public void Hr() {
        this.aFQ = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(u.h.pic_show_cardview_layout, (ViewGroup) this, true);
        this.dZp = (TbImageView) findViewById(u.g.pic_img);
        this.dZq = (LinearLayout) findViewById(u.g.bottom_ll);
        this.aSd = (TextView) findViewById(u.g.title_ll);
        this.dZs = (TextView) findViewById(u.g.desc_ll);
        this.dZr = (ImageView) findViewById(u.g.show_pic_icon);
    }

    public void setIconResId(int i) {
        av.c(this.dZr, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.dZo != aVar) {
            this.dZo = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.aSd.setVisibility(0);
                this.aSd.setText(aVar.getTitle());
            } else {
                this.aSd.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.dZs.setVisibility(0);
                this.dZs.setText(aVar.getDescription());
            } else {
                this.dZs.setVisibility(8);
            }
            if (this.aFQ) {
                this.dZp.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.dZp.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.dZp.setOnClickListener(this);
                this.dZp.setInterceptOnClick(true);
                this.dZp.setDefaultResource(u.f.icon_click);
                this.dZp.c(aVar.bbD(), 18, false);
                int A = k.A(this.mContext) - (k.c(this.mContext, u.e.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (A * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (A * 0.75f);
                } else {
                    i = (int) (f * A);
                }
                this.dZp.setLayoutParams(new FrameLayout.LayoutParams(A, i));
                removeView(this.dZp);
                addView(this.dZp);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dZq.getLayoutParams();
                layoutParams.width = A;
                layoutParams.height = k.c(this.mContext, u.e.ds110);
                removeView(this.dZq);
                addView(this.dZq, layoutParams);
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ad(i == 1);
        tbPageContext.getLayoutMode().w(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dZo != null) {
            f.u(this.mContext, this.dZo.bbE());
        }
    }

    public ImageView getIcon() {
        return this.dZr;
    }
}
