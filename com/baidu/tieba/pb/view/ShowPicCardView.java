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
    private LinearLayout cQA;
    private com.baidu.tieba.tbadkCore.data.a fyB;
    private TbImageView fyC;
    private TextView fyD;
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
        return this.fyB;
    }

    public void setSupportNoImage() {
        this.aVm = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.pic_show_cardview_layout, (ViewGroup) this, true);
        this.fyC = (TbImageView) findViewById(d.g.pic_img);
        this.cQA = (LinearLayout) findViewById(d.g.bottom_ll);
        this.mTitle = (TextView) findViewById(d.g.title_ll);
        this.fyD = (TextView) findViewById(d.g.desc_ll);
        this.mIcon = (ImageView) findViewById(d.g.show_pic_icon);
    }

    public void setIconResId(int i) {
        ak.c(this.mIcon, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.fyB != aVar) {
            this.fyB = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.fyD.setVisibility(0);
                this.fyD.setText(aVar.getDescription());
            } else {
                this.fyD.setVisibility(8);
            }
            if (this.aVm) {
                this.fyC.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.fyC.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.fyC.setOnClickListener(this);
                this.fyC.setInterceptOnClick(true);
                this.fyC.setDefaultResource(d.f.icon_click);
                this.fyC.startLoad(aVar.brz(), 18, false);
                int af = l.af(this.mContext) - (l.e(this.mContext, d.e.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (af * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (af * 0.75f);
                } else {
                    i = (int) (f * af);
                }
                this.fyC.setLayoutParams(new FrameLayout.LayoutParams(af, i));
                removeView(this.fyC);
                addView(this.fyC);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.cQA.getLayoutParams();
                layoutParams.width = af;
                layoutParams.height = l.e(this.mContext, d.e.ds110);
                removeView(this.cQA);
                addView(this.cQA, layoutParams);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.fyB != null) {
            com.baidu.tbadk.browser.a.M(this.mContext, this.fyB.brA());
        }
    }

    public ImageView getIcon() {
        return this.mIcon;
    }
}
