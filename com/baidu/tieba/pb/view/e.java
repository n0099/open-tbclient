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
import com.baidu.tbadk.browser.g;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class e extends FrameLayout implements View.OnClickListener {
    private boolean aBq;
    private TextView aPy;
    private com.baidu.tieba.tbadkCore.data.a cpj;
    private TbImageView cpk;
    private LinearLayout cpl;
    private ImageView cpm;
    private TextView cpn;
    private Context mContext;
    private View mRootView;

    public e(Context context) {
        this(context, null, 0);
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aBq = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.cpj;
    }

    public void Fj() {
        this.aBq = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(i.g.pic_show_cardview_layout, (ViewGroup) this, true);
        this.cpk = (TbImageView) findViewById(i.f.pic_img);
        this.cpl = (LinearLayout) findViewById(i.f.bottom_ll);
        this.aPy = (TextView) findViewById(i.f.title_ll);
        this.cpn = (TextView) findViewById(i.f.desc_ll);
        this.cpm = (ImageView) findViewById(i.f.show_pic_icon);
    }

    public void setIconResId(int i) {
        an.c(this.cpm, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.cpj != aVar) {
            this.cpj = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.aPy.setVisibility(0);
                this.aPy.setText(aVar.getTitle());
            } else {
                this.aPy.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.cpn.setVisibility(0);
                this.cpn.setText(aVar.getDescription());
            } else {
                this.cpn.setVisibility(8);
            }
            if (this.aBq) {
                this.cpk.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.cpk.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.cpk.setOnClickListener(this);
                this.cpk.setInterceptOnClick(true);
                this.cpk.setDefaultResource(i.e.icon_click);
                this.cpk.d(aVar.awQ(), 18, false);
                int K = k.K(this.mContext) - (k.d(this.mContext, i.d.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (K * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (K * 0.75f);
                } else {
                    i = (int) (f * K);
                }
                this.cpk.setLayoutParams(new FrameLayout.LayoutParams(K, i));
                removeView(this.cpk);
                addView(this.cpk);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cpl.getLayoutParams();
                layoutParams.width = K;
                layoutParams.height = k.d(this.mContext, i.d.ds110);
                removeView(this.cpl);
                addView(this.cpl, layoutParams);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ad(i == 1);
        tbPageContext.getLayoutMode().k(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cpj != null) {
            g.B(this.mContext, this.cpj.awR());
        }
    }

    public ImageView getIcon() {
        return this.cpm;
    }
}
