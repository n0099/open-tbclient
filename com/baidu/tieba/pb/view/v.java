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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class v extends FrameLayout implements View.OnClickListener {
    private boolean aJT;
    private TextView aYh;
    private com.baidu.tieba.tbadkCore.data.a exW;
    private TbImageView exX;
    private LinearLayout exY;
    private ImageView exZ;
    private TextView eya;
    private Context mContext;
    private View mRootView;

    public v(Context context) {
        this(context, null, 0);
    }

    public v(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aJT = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.exW;
    }

    public void IO() {
        this.aJT = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(t.h.pic_show_cardview_layout, (ViewGroup) this, true);
        this.exX = (TbImageView) findViewById(t.g.pic_img);
        this.exY = (LinearLayout) findViewById(t.g.bottom_ll);
        this.aYh = (TextView) findViewById(t.g.title_ll);
        this.eya = (TextView) findViewById(t.g.desc_ll);
        this.exZ = (ImageView) findViewById(t.g.show_pic_icon);
    }

    public void setIconResId(int i) {
        av.c(this.exZ, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.exW != aVar) {
            this.exW = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.aYh.setVisibility(0);
                this.aYh.setText(aVar.getTitle());
            } else {
                this.aYh.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.eya.setVisibility(0);
                this.eya.setText(aVar.getDescription());
            } else {
                this.eya.setVisibility(8);
            }
            if (this.aJT) {
                this.exX.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.exX.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.exX.setOnClickListener(this);
                this.exX.setInterceptOnClick(true);
                this.exX.setDefaultResource(t.f.icon_click);
                this.exX.c(aVar.bix(), 18, false);
                int K = k.K(this.mContext) - (k.e(this.mContext, t.e.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (K * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (K * 0.75f);
                } else {
                    i = (int) (f * K);
                }
                this.exX.setLayoutParams(new FrameLayout.LayoutParams(K, i));
                removeView(this.exX);
                addView(this.exX);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.exY.getLayoutParams();
                layoutParams.width = K;
                layoutParams.height = k.e(this.mContext, t.e.ds110);
                removeView(this.exY);
                addView(this.exY, layoutParams);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ah(i == 1);
        tbPageContext.getLayoutMode().x(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.exW != null) {
            f.u(this.mContext, this.exW.biy());
        }
    }

    public ImageView getIcon() {
        return this.exZ;
    }
}
