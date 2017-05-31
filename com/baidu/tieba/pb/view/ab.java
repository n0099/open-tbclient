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
public class ab extends FrameLayout implements View.OnClickListener {
    private boolean aOp;
    private com.baidu.tieba.tbadkCore.data.a eDd;
    private TbImageView eDe;
    private LinearLayout eDf;
    private ImageView eDg;
    private TextView eDh;
    private Context mContext;
    private View mRootView;
    private TextView mTitle;

    public ab(Context context) {
        this(context, null, 0);
    }

    public ab(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOp = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.eDd;
    }

    public void Il() {
        this.aOp = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(w.j.pic_show_cardview_layout, (ViewGroup) this, true);
        this.eDe = (TbImageView) findViewById(w.h.pic_img);
        this.eDf = (LinearLayout) findViewById(w.h.bottom_ll);
        this.mTitle = (TextView) findViewById(w.h.title_ll);
        this.eDh = (TextView) findViewById(w.h.desc_ll);
        this.eDg = (ImageView) findViewById(w.h.show_pic_icon);
    }

    public void setIconResId(int i) {
        aq.c(this.eDg, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.eDd != aVar) {
            this.eDd = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.eDh.setVisibility(0);
                this.eDh.setText(aVar.getDescription());
            } else {
                this.eDh.setVisibility(8);
            }
            if (this.aOp) {
                this.eDe.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.eDe.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.eDe.setOnClickListener(this);
                this.eDe.setInterceptOnClick(true);
                this.eDe.setDefaultResource(w.g.icon_click);
                this.eDe.c(aVar.bhB(), 18, false);
                int af = com.baidu.adp.lib.util.k.af(this.mContext) - (com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (af * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (af * 0.75f);
                } else {
                    i = (int) (f * af);
                }
                this.eDe.setLayoutParams(new FrameLayout.LayoutParams(af, i));
                removeView(this.eDe);
                addView(this.eDe);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eDf.getLayoutParams();
                layoutParams.width = af;
                layoutParams.height = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds110);
                removeView(this.eDf);
                addView(this.eDf, layoutParams);
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ah(i == 1);
        tbPageContext.getLayoutMode().t(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eDd != null) {
            com.baidu.tbadk.browser.f.S(this.mContext, this.eDd.bhC());
        }
    }

    public ImageView getIcon() {
        return this.eDg;
    }
}
