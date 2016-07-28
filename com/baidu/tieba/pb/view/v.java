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
    private boolean aGH;
    private TextView aSZ;
    private com.baidu.tieba.tbadkCore.data.a elQ;
    private TbImageView elR;
    private LinearLayout elS;
    private ImageView elT;
    private TextView elU;
    private Context mContext;
    private View mRootView;

    public v(Context context) {
        this(context, null, 0);
    }

    public v(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGH = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.elQ;
    }

    public void Hp() {
        this.aGH = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(u.h.pic_show_cardview_layout, (ViewGroup) this, true);
        this.elR = (TbImageView) findViewById(u.g.pic_img);
        this.elS = (LinearLayout) findViewById(u.g.bottom_ll);
        this.aSZ = (TextView) findViewById(u.g.title_ll);
        this.elU = (TextView) findViewById(u.g.desc_ll);
        this.elT = (ImageView) findViewById(u.g.show_pic_icon);
    }

    public void setIconResId(int i) {
        av.c(this.elT, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.elQ != aVar) {
            this.elQ = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.aSZ.setVisibility(0);
                this.aSZ.setText(aVar.getTitle());
            } else {
                this.aSZ.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.elU.setVisibility(0);
                this.elU.setText(aVar.getDescription());
            } else {
                this.elU.setVisibility(8);
            }
            if (this.aGH) {
                this.elR.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.elR.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.elR.setOnClickListener(this);
                this.elR.setInterceptOnClick(true);
                this.elR.setDefaultResource(u.f.icon_click);
                this.elR.c(aVar.beS(), 18, false);
                int A = k.A(this.mContext) - (k.c(this.mContext, u.e.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (A * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (A * 0.75f);
                } else {
                    i = (int) (f * A);
                }
                this.elR.setLayoutParams(new FrameLayout.LayoutParams(A, i));
                removeView(this.elR);
                addView(this.elR);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.elS.getLayoutParams();
                layoutParams.width = A;
                layoutParams.height = k.c(this.mContext, u.e.ds110);
                removeView(this.elS);
                addView(this.elS, layoutParams);
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().af(i == 1);
        tbPageContext.getLayoutMode().w(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.elQ != null) {
            f.u(this.mContext, this.elQ.beT());
        }
    }

    public ImageView getIcon() {
        return this.elT;
    }
}
