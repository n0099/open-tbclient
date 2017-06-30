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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ab extends FrameLayout implements View.OnClickListener {
    private boolean aPF;
    private com.baidu.tieba.tbadkCore.data.a eML;
    private TbImageView eMM;
    private LinearLayout eMN;
    private ImageView eMO;
    private TextView eMP;
    private Context mContext;
    private View mRootView;
    private TextView mTitle;

    public ab(Context context) {
        this(context, null, 0);
    }

    public ab(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aPF = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.eML;
    }

    public void IJ() {
        this.aPF = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(w.j.pic_show_cardview_layout, (ViewGroup) this, true);
        this.eMM = (TbImageView) findViewById(w.h.pic_img);
        this.eMN = (LinearLayout) findViewById(w.h.bottom_ll);
        this.mTitle = (TextView) findViewById(w.h.title_ll);
        this.eMP = (TextView) findViewById(w.h.desc_ll);
        this.eMO = (ImageView) findViewById(w.h.show_pic_icon);
    }

    public void setIconResId(int i) {
        as.c(this.eMO, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.eML != aVar) {
            this.eML = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.eMP.setVisibility(0);
                this.eMP.setText(aVar.getDescription());
            } else {
                this.eMP.setVisibility(8);
            }
            if (this.aPF) {
                this.eMM.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.eMM.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.eMM.setOnClickListener(this);
                this.eMM.setInterceptOnClick(true);
                this.eMM.setDefaultResource(w.g.icon_click);
                this.eMM.c(aVar.blP(), 18, false);
                int af = com.baidu.adp.lib.util.k.af(this.mContext) - (com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (af * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (af * 0.75f);
                } else {
                    i = (int) (f * af);
                }
                this.eMM.setLayoutParams(new FrameLayout.LayoutParams(af, i));
                removeView(this.eMM);
                addView(this.eMM);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eMN.getLayoutParams();
                layoutParams.width = af;
                layoutParams.height = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds110);
                removeView(this.eMN);
                addView(this.eMN, layoutParams);
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ah(i == 1);
        tbPageContext.getLayoutMode().t(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eML != null) {
            com.baidu.tbadk.browser.g.T(this.mContext, this.eML.blQ());
        }
    }

    public ImageView getIcon() {
        return this.eMO;
    }
}
