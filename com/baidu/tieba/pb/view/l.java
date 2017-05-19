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
    private boolean aOr;
    private com.baidu.tieba.tbadkCore.data.a eua;
    private TbImageView eub;
    private LinearLayout euc;
    private ImageView eud;
    private TextView eue;
    private Context mContext;
    private View mRootView;
    private TextView mTitle;

    public l(Context context) {
        this(context, null, 0);
    }

    public l(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOr = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.eua;
    }

    public void Iq() {
        this.aOr = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(w.j.pic_show_cardview_layout, (ViewGroup) this, true);
        this.eub = (TbImageView) findViewById(w.h.pic_img);
        this.euc = (LinearLayout) findViewById(w.h.bottom_ll);
        this.mTitle = (TextView) findViewById(w.h.title_ll);
        this.eue = (TextView) findViewById(w.h.desc_ll);
        this.eud = (ImageView) findViewById(w.h.show_pic_icon);
    }

    public void setIconResId(int i) {
        aq.c(this.eud, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.eua != aVar) {
            this.eua = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.eue.setVisibility(0);
                this.eue.setText(aVar.getDescription());
            } else {
                this.eue.setVisibility(8);
            }
            if (this.aOr) {
                this.eub.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.eub.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.eub.setOnClickListener(this);
                this.eub.setInterceptOnClick(true);
                this.eub.setDefaultResource(w.g.icon_click);
                this.eub.c(aVar.bge(), 18, false);
                int af = com.baidu.adp.lib.util.k.af(this.mContext) - (com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (af * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (af * 0.75f);
                } else {
                    i = (int) (f * af);
                }
                this.eub.setLayoutParams(new FrameLayout.LayoutParams(af, i));
                removeView(this.eub);
                addView(this.eub);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.euc.getLayoutParams();
                layoutParams.width = af;
                layoutParams.height = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds110);
                removeView(this.euc);
                addView(this.euc, layoutParams);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ai(i == 1);
        tbPageContext.getLayoutMode().t(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eua != null) {
            com.baidu.tbadk.browser.f.S(this.mContext, this.eua.bgf());
        }
    }

    public ImageView getIcon() {
        return this.eud;
    }
}
