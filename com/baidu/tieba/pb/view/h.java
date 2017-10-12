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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class h extends FrameLayout implements View.OnClickListener {
    private boolean aSK;
    private LinearLayout clg;
    private com.baidu.tieba.tbadkCore.data.a eVP;
    private TbImageView eVQ;
    private ImageView eVR;
    private TextView eVS;
    private Context mContext;
    private View mRootView;
    private TextView mTitle;

    public h(Context context) {
        this(context, null, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aSK = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.eVP;
    }

    public void Jt() {
        this.aSK = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.pic_show_cardview_layout, (ViewGroup) this, true);
        this.eVQ = (TbImageView) findViewById(d.h.pic_img);
        this.clg = (LinearLayout) findViewById(d.h.bottom_ll);
        this.mTitle = (TextView) findViewById(d.h.title_ll);
        this.eVS = (TextView) findViewById(d.h.desc_ll);
        this.eVR = (ImageView) findViewById(d.h.show_pic_icon);
    }

    public void setIconResId(int i) {
        aj.c(this.eVR, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.eVP != aVar) {
            this.eVP = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.eVS.setVisibility(0);
                this.eVS.setText(aVar.getDescription());
            } else {
                this.eVS.setVisibility(8);
            }
            if (this.aSK) {
                this.eVQ.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.eVQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.eVQ.setOnClickListener(this);
                this.eVQ.setInterceptOnClick(true);
                this.eVQ.setDefaultResource(d.g.icon_click);
                this.eVQ.c(aVar.bqR(), 18, false);
                int ad = l.ad(this.mContext) - (l.f(this.mContext, d.f.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (ad * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (ad * 0.75f);
                } else {
                    i = (int) (f * ad);
                }
                this.eVQ.setLayoutParams(new FrameLayout.LayoutParams(ad, i));
                removeView(this.eVQ);
                addView(this.eVQ);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.clg.getLayoutParams();
                layoutParams.width = ad;
                layoutParams.height = l.f(this.mContext, d.f.ds110);
                removeView(this.clg);
                addView(this.clg, layoutParams);
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ai(i == 1);
        tbPageContext.getLayoutMode().t(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eVP != null) {
            com.baidu.tbadk.browser.a.T(this.mContext, this.eVP.bqS());
        }
    }

    public ImageView getIcon() {
        return this.eVR;
    }
}
