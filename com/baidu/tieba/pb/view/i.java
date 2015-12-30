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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class i extends FrameLayout implements View.OnClickListener {
    private boolean aFB;
    private TextView aOn;
    private com.baidu.tieba.tbadkCore.data.a cMS;
    private TbImageView cMT;
    private LinearLayout cMU;
    private ImageView cMV;
    private TextView cMW;
    private Context mContext;
    private View mRootView;

    public i(Context context) {
        this(context, null, 0);
    }

    public i(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aFB = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.cMS;
    }

    public void Gd() {
        this.aFB = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(n.h.pic_show_cardview_layout, (ViewGroup) this, true);
        this.cMT = (TbImageView) findViewById(n.g.pic_img);
        this.cMU = (LinearLayout) findViewById(n.g.bottom_ll);
        this.aOn = (TextView) findViewById(n.g.title_ll);
        this.cMW = (TextView) findViewById(n.g.desc_ll);
        this.cMV = (ImageView) findViewById(n.g.show_pic_icon);
    }

    public void setIconResId(int i) {
        as.c(this.cMV, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.cMS != aVar) {
            this.cMS = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.aOn.setVisibility(0);
                this.aOn.setText(aVar.getTitle());
            } else {
                this.aOn.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.cMW.setVisibility(0);
                this.cMW.setText(aVar.getDescription());
            } else {
                this.cMW.setVisibility(8);
            }
            if (this.aFB) {
                this.cMT.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.cMT.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.cMT.setOnClickListener(this);
                this.cMT.setInterceptOnClick(true);
                this.cMT.setDefaultResource(n.f.icon_click);
                this.cMT.d(aVar.aEJ(), 18, false);
                int K = k.K(this.mContext) - (k.d(this.mContext, n.e.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (K * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (K * 0.75f);
                } else {
                    i = (int) (f * K);
                }
                this.cMT.setLayoutParams(new FrameLayout.LayoutParams(K, i));
                removeView(this.cMT);
                addView(this.cMT);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cMU.getLayoutParams();
                layoutParams.width = K;
                layoutParams.height = k.d(this.mContext, n.e.ds110);
                removeView(this.cMU);
                addView(this.cMU, layoutParams);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ac(i == 1);
        tbPageContext.getLayoutMode().k(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cMS != null) {
            com.baidu.tbadk.browser.f.B(this.mContext, this.cMS.aEK());
        }
    }

    public ImageView getIcon() {
        return this.cMV;
    }
}
