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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ShowPicCardView extends FrameLayout implements View.OnClickListener {
    private boolean aVm;
    private LinearLayout cQD;
    private com.baidu.tieba.tbadkCore.data.a fyE;
    private TbImageView fyF;
    private TextView fyG;
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
        this.aVm = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.fyE;
    }

    public void setSupportNoImage() {
        this.aVm = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.pic_show_cardview_layout, (ViewGroup) this, true);
        this.fyF = (TbImageView) findViewById(d.g.pic_img);
        this.cQD = (LinearLayout) findViewById(d.g.bottom_ll);
        this.mTitle = (TextView) findViewById(d.g.title_ll);
        this.fyG = (TextView) findViewById(d.g.desc_ll);
        this.mIcon = (ImageView) findViewById(d.g.show_pic_icon);
    }

    public void setIconResId(int i) {
        ak.c(this.mIcon, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.fyE != aVar) {
            this.fyE = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.fyG.setVisibility(0);
                this.fyG.setText(aVar.getDescription());
            } else {
                this.fyG.setVisibility(8);
            }
            if (this.aVm) {
                this.fyF.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.fyF.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.fyF.setOnClickListener(this);
                this.fyF.setInterceptOnClick(true);
                this.fyF.setDefaultResource(d.f.icon_click);
                this.fyF.startLoad(aVar.brz(), 18, false);
                int af = l.af(this.mContext) - (l.e(this.mContext, d.e.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (af * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (af * 0.75f);
                } else {
                    i = (int) (f * af);
                }
                this.fyF.setLayoutParams(new FrameLayout.LayoutParams(af, i));
                removeView(this.fyF);
                addView(this.fyF);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cQD.getLayoutParams();
                layoutParams.width = af;
                layoutParams.height = l.e(this.mContext, d.e.ds110);
                removeView(this.cQD);
                addView(this.cQD, layoutParams);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.fyE != null) {
            com.baidu.tbadk.browser.a.M(this.mContext, this.fyE.brA());
        }
    }

    public ImageView getIcon() {
        return this.mIcon;
    }
}
