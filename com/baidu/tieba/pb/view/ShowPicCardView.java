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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class ShowPicCardView extends FrameLayout implements View.OnClickListener {
    private boolean beQ;
    private LinearLayout dbE;
    private com.baidu.tieba.tbadkCore.data.a fPg;
    private TbImageView fPh;
    private TextView fPi;
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
        this.beQ = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.fPg;
    }

    public void setSupportNoImage() {
        this.beQ = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(f.h.pic_show_cardview_layout, (ViewGroup) this, true);
        this.fPh = (TbImageView) findViewById(f.g.pic_img);
        this.dbE = (LinearLayout) findViewById(f.g.bottom_ll);
        this.mTitle = (TextView) findViewById(f.g.title_ll);
        this.fPi = (TextView) findViewById(f.g.desc_ll);
        this.mIcon = (ImageView) findViewById(f.g.show_pic_icon);
    }

    public void setIconResId(int i) {
        am.c(this.mIcon, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.fPg != aVar) {
            this.fPg = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.fPi.setVisibility(0);
                this.fPi.setText(aVar.getDescription());
            } else {
                this.fPi.setVisibility(8);
            }
            if (this.beQ) {
                this.fPh.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.fPh.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.fPh.setOnClickListener(this);
                this.fPh.setInterceptOnClick(true);
                this.fPh.setDefaultResource(f.C0146f.icon_click);
                this.fPh.startLoad(aVar.bvE(), 18, false);
                int ah = l.ah(this.mContext) - (l.f(this.mContext, f.e.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (ah * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (ah * 0.75f);
                } else {
                    i = (int) (f * ah);
                }
                this.fPh.setLayoutParams(new FrameLayout.LayoutParams(ah, i));
                removeView(this.fPh);
                addView(this.fPh);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dbE.getLayoutParams();
                layoutParams.width = ah;
                layoutParams.height = l.f(this.mContext, f.e.ds110);
                removeView(this.dbE);
                addView(this.dbE, layoutParams);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fPg != null) {
            com.baidu.tbadk.browser.a.Q(this.mContext, this.fPg.bvF());
        }
    }

    public ImageView getIcon() {
        return this.mIcon;
    }
}
