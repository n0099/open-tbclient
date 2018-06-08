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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ShowPicCardView extends FrameLayout implements View.OnClickListener {
    private boolean bdr;
    private LinearLayout daO;
    private com.baidu.tieba.tbadkCore.data.a fLc;
    private TbImageView fLd;
    private TextView fLe;
    private Context mContext;
    private ImageView mIcon;
    private View mRootView;
    private TextView mTitle;

    public ShowPicCardView(Context context) {
        this(context, null, 0);
    }

    public ShowPicCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShowPicCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bdr = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.fLc;
    }

    public void setSupportNoImage() {
        this.bdr = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.pic_show_cardview_layout, (ViewGroup) this, true);
        this.fLd = (TbImageView) findViewById(d.g.pic_img);
        this.daO = (LinearLayout) findViewById(d.g.bottom_ll);
        this.mTitle = (TextView) findViewById(d.g.title_ll);
        this.fLe = (TextView) findViewById(d.g.desc_ll);
        this.mIcon = (ImageView) findViewById(d.g.show_pic_icon);
    }

    public void setIconResId(int i) {
        al.c(this.mIcon, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.fLc != aVar) {
            this.fLc = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.fLe.setVisibility(0);
                this.fLe.setText(aVar.getDescription());
            } else {
                this.fLe.setVisibility(8);
            }
            if (this.bdr) {
                this.fLd.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.fLd.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.fLd.setOnClickListener(this);
                this.fLd.setInterceptOnClick(true);
                this.fLd.setDefaultResource(d.f.icon_click);
                this.fLd.startLoad(aVar.bwz(), 18, false);
                int ah = l.ah(this.mContext) - (l.e(this.mContext, d.e.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (ah * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (ah * 0.75f);
                } else {
                    i = (int) (f * ah);
                }
                this.fLd.setLayoutParams(new FrameLayout.LayoutParams(ah, i));
                removeView(this.fLd);
                addView(this.fLd);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.daO.getLayoutParams();
                layoutParams.width = ah;
                layoutParams.height = l.e(this.mContext, d.e.ds110);
                removeView(this.daO);
                addView(this.daO, layoutParams);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fLc != null) {
            com.baidu.tbadk.browser.a.O(this.mContext, this.fLc.bwA());
        }
    }

    public ImageView getIcon() {
        return this.mIcon;
    }
}
