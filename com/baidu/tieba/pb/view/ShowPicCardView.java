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
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class ShowPicCardView extends FrameLayout implements View.OnClickListener {
    private boolean bim;
    private LinearLayout dhz;
    private com.baidu.tieba.tbadkCore.data.a fWw;
    private TbImageView fWx;
    private TextView fWy;
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
        this.bim = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.fWw;
    }

    public void setSupportNoImage() {
        this.bim = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.pic_show_cardview_layout, (ViewGroup) this, true);
        this.fWx = (TbImageView) findViewById(e.g.pic_img);
        this.dhz = (LinearLayout) findViewById(e.g.bottom_ll);
        this.mTitle = (TextView) findViewById(e.g.title_ll);
        this.fWy = (TextView) findViewById(e.g.desc_ll);
        this.mIcon = (ImageView) findViewById(e.g.show_pic_icon);
    }

    public void setIconResId(int i) {
        al.c(this.mIcon, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.fWw != aVar) {
            this.fWw = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.fWy.setVisibility(0);
                this.fWy.setText(aVar.getDescription());
            } else {
                this.fWy.setVisibility(8);
            }
            if (this.bim) {
                this.fWx.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.fWx.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.fWx.setOnClickListener(this);
                this.fWx.setInterceptOnClick(true);
                this.fWx.setDefaultResource(e.f.icon_click);
                this.fWx.startLoad(aVar.byk(), 18, false);
                int aO = l.aO(this.mContext) - (l.h(this.mContext, e.C0141e.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (aO * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (aO * 0.75f);
                } else {
                    i = (int) (f * aO);
                }
                this.fWx.setLayoutParams(new FrameLayout.LayoutParams(aO, i));
                removeView(this.fWx);
                addView(this.fWx);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dhz.getLayoutParams();
                layoutParams.width = aO;
                layoutParams.height = l.h(this.mContext, e.C0141e.ds110);
                removeView(this.dhz);
                addView(this.dhz, layoutParams);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fWw != null) {
            com.baidu.tbadk.browser.a.ae(this.mContext, this.fWw.byl());
        }
    }

    public ImageView getIcon() {
        return this.mIcon;
    }
}
