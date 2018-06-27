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
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ShowPicCardView extends FrameLayout implements View.OnClickListener {
    private boolean beG;
    private LinearLayout cYP;
    private com.baidu.tieba.tbadkCore.data.a fPe;
    private TbImageView fPf;
    private TextView fPg;
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
        this.beG = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.fPe;
    }

    public void setSupportNoImage() {
        this.beG = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.pic_show_cardview_layout, (ViewGroup) this, true);
        this.fPf = (TbImageView) findViewById(d.g.pic_img);
        this.cYP = (LinearLayout) findViewById(d.g.bottom_ll);
        this.mTitle = (TextView) findViewById(d.g.title_ll);
        this.fPg = (TextView) findViewById(d.g.desc_ll);
        this.mIcon = (ImageView) findViewById(d.g.show_pic_icon);
    }

    public void setIconResId(int i) {
        am.c(this.mIcon, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.fPe != aVar) {
            this.fPe = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.fPg.setVisibility(0);
                this.fPg.setText(aVar.getDescription());
            } else {
                this.fPg.setVisibility(8);
            }
            if (this.beG) {
                this.fPf.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.fPf.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.fPf.setOnClickListener(this);
                this.fPf.setInterceptOnClick(true);
                this.fPf.setDefaultResource(d.f.icon_click);
                this.fPf.startLoad(aVar.bxa(), 18, false);
                int ah = l.ah(this.mContext) - (l.e(this.mContext, d.e.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (ah * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (ah * 0.75f);
                } else {
                    i = (int) (f * ah);
                }
                this.fPf.setLayoutParams(new FrameLayout.LayoutParams(ah, i));
                removeView(this.fPf);
                addView(this.fPf);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cYP.getLayoutParams();
                layoutParams.width = ah;
                layoutParams.height = l.e(this.mContext, d.e.ds110);
                removeView(this.cYP);
                addView(this.cYP, layoutParams);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fPe != null) {
            com.baidu.tbadk.browser.a.O(this.mContext, this.fPe.bxb());
        }
    }

    public ImageView getIcon() {
        return this.mIcon;
    }
}
