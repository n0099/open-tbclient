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
public class f extends FrameLayout implements View.OnClickListener {
    private boolean aEc;
    private TextView aUB;
    private com.baidu.tieba.tbadkCore.data.a cIC;
    private TbImageView cID;
    private LinearLayout cIE;
    private ImageView cIF;
    private TextView cIG;
    private Context mContext;
    private View mRootView;

    public f(Context context) {
        this(context, null, 0);
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEc = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.cIC;
    }

    public void Go() {
        this.aEc = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(n.g.pic_show_cardview_layout, (ViewGroup) this, true);
        this.cID = (TbImageView) findViewById(n.f.pic_img);
        this.cIE = (LinearLayout) findViewById(n.f.bottom_ll);
        this.aUB = (TextView) findViewById(n.f.title_ll);
        this.cIG = (TextView) findViewById(n.f.desc_ll);
        this.cIF = (ImageView) findViewById(n.f.show_pic_icon);
    }

    public void setIconResId(int i) {
        as.c(this.cIF, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.cIC != aVar) {
            this.cIC = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.aUB.setVisibility(0);
                this.aUB.setText(aVar.getTitle());
            } else {
                this.aUB.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.cIG.setVisibility(0);
                this.cIG.setText(aVar.getDescription());
            } else {
                this.cIG.setVisibility(8);
            }
            if (this.aEc) {
                this.cID.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.cID.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.cID.setOnClickListener(this);
                this.cID.setInterceptOnClick(true);
                this.cID.setDefaultResource(n.e.icon_click);
                this.cID.d(aVar.aCC(), 18, false);
                int K = k.K(this.mContext) - (k.d(this.mContext, n.d.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (K * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (K * 0.75f);
                } else {
                    i = (int) (f * K);
                }
                this.cID.setLayoutParams(new FrameLayout.LayoutParams(K, i));
                removeView(this.cID);
                addView(this.cID);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cIE.getLayoutParams();
                layoutParams.width = K;
                layoutParams.height = k.d(this.mContext, n.d.ds110);
                removeView(this.cIE);
                addView(this.cIE, layoutParams);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().af(i == 1);
        tbPageContext.getLayoutMode().k(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cIC != null) {
            com.baidu.tbadk.browser.f.B(this.mContext, this.cIC.aCD());
        }
    }

    public ImageView getIcon() {
        return this.cIF;
    }
}
