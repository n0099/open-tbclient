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
/* loaded from: classes2.dex */
public class h extends FrameLayout implements View.OnClickListener {
    private boolean bIC;
    private LinearLayout dvh;
    private com.baidu.tieba.tbadkCore.data.a gbf;
    private TbImageView gbg;
    private TextView gbh;
    private ImageView jt;
    private Context mContext;
    private View mRootView;
    private TextView mTitle;

    public h(Context context) {
        this(context, null, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bIC = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.gbf;
    }

    public void QC() {
        this.bIC = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.pic_show_cardview_layout, (ViewGroup) this, true);
        this.gbg = (TbImageView) findViewById(d.g.pic_img);
        this.dvh = (LinearLayout) findViewById(d.g.bottom_ll);
        this.mTitle = (TextView) findViewById(d.g.title_ll);
        this.gbh = (TextView) findViewById(d.g.desc_ll);
        this.jt = (ImageView) findViewById(d.g.show_pic_icon);
    }

    public void setIconResId(int i) {
        aj.c(this.jt, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.gbf != aVar) {
            this.gbf = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.gbh.setVisibility(0);
                this.gbh.setText(aVar.getDescription());
            } else {
                this.gbh.setVisibility(8);
            }
            if (this.bIC) {
                this.gbg.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.gbg.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.gbg.setOnClickListener(this);
                this.gbg.setInterceptOnClick(true);
                this.gbg.setDefaultResource(d.f.icon_click);
                this.gbg.startLoad(aVar.bve(), 18, false);
                int ao = l.ao(this.mContext) - (l.s(this.mContext, d.e.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (ao * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (ao * 0.75f);
                } else {
                    i = (int) (f * ao);
                }
                this.gbg.setLayoutParams(new FrameLayout.LayoutParams(ao, i));
                removeView(this.gbg);
                addView(this.gbg);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dvh.getLayoutParams();
                layoutParams.width = ao;
                layoutParams.height = l.s(this.mContext, d.e.ds110);
                removeView(this.dvh);
                addView(this.dvh, layoutParams);
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().aN(i == 1);
        tbPageContext.getLayoutMode().aM(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gbf != null) {
            com.baidu.tbadk.browser.a.P(this.mContext, this.gbf.bvf());
        }
    }

    public ImageView getIcon() {
        return this.jt;
    }
}
