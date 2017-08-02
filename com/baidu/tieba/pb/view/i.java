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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class i extends FrameLayout implements View.OnClickListener {
    private boolean aQO;
    private com.baidu.tieba.tbadkCore.data.a eZm;
    private TbImageView eZn;
    private LinearLayout eZo;
    private ImageView eZp;
    private TextView eZq;
    private Context mContext;
    private View mRootView;
    private TextView mTitle;

    public i(Context context) {
        this(context, null, 0);
    }

    public i(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aQO = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.eZm;
    }

    public void IV() {
        this.aQO = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.j.pic_show_cardview_layout, (ViewGroup) this, true);
        this.eZn = (TbImageView) findViewById(d.h.pic_img);
        this.eZo = (LinearLayout) findViewById(d.h.bottom_ll);
        this.mTitle = (TextView) findViewById(d.h.title_ll);
        this.eZq = (TextView) findViewById(d.h.desc_ll);
        this.eZp = (ImageView) findViewById(d.h.show_pic_icon);
    }

    public void setIconResId(int i) {
        ai.c(this.eZp, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.eZm != aVar) {
            this.eZm = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.eZq.setVisibility(0);
                this.eZq.setText(aVar.getDescription());
            } else {
                this.eZq.setVisibility(8);
            }
            if (this.aQO) {
                this.eZn.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.eZn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.eZn.setOnClickListener(this);
                this.eZn.setInterceptOnClick(true);
                this.eZn.setDefaultResource(d.g.icon_click);
                this.eZn.c(aVar.brM(), 18, false);
                int af = k.af(this.mContext) - (k.g(this.mContext, d.f.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (af * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (af * 0.75f);
                } else {
                    i = (int) (f * af);
                }
                this.eZn.setLayoutParams(new FrameLayout.LayoutParams(af, i));
                removeView(this.eZn);
                addView(this.eZn);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eZo.getLayoutParams();
                layoutParams.width = af;
                layoutParams.height = k.g(this.mContext, d.f.ds110);
                removeView(this.eZo);
                addView(this.eZo, layoutParams);
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ah(i == 1);
        tbPageContext.getLayoutMode().t(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eZm != null) {
            com.baidu.tbadk.browser.a.T(this.mContext, this.eZm.brN());
        }
    }

    public ImageView getIcon() {
        return this.eZp;
    }
}
