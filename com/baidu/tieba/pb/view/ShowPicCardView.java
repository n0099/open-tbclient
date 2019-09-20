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
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ShowPicCardView extends FrameLayout implements View.OnClickListener {
    private boolean cMF;
    private LinearLayout flf;
    private com.baidu.tieba.tbadkCore.data.a ihA;
    private TbImageView ihB;
    private TextView ihC;
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
        this.cMF = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.ihA;
    }

    public void setSupportNoImage() {
        this.cMF = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.pic_show_cardview_layout, (ViewGroup) this, true);
        this.ihB = (TbImageView) findViewById(R.id.pic_img);
        this.flf = (LinearLayout) findViewById(R.id.bottom_ll);
        this.mTitle = (TextView) findViewById(R.id.title_ll);
        this.ihC = (TextView) findViewById(R.id.desc_ll);
        this.mIcon = (ImageView) findViewById(R.id.show_pic_icon);
    }

    public void setIconResId(int i) {
        am.c(this.mIcon, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.ihA != aVar) {
            this.ihA = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.ihC.setVisibility(0);
                this.ihC.setText(aVar.getDescription());
            } else {
                this.ihC.setVisibility(8);
            }
            if (this.cMF) {
                this.ihB.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.ihB.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.ihB.setOnClickListener(this);
                this.ihB.setInterceptOnClick(true);
                this.ihB.setDefaultResource(R.drawable.icon_click);
                this.ihB.startLoad(aVar.cpX(), 18, false);
                int af = l.af(this.mContext) - (l.g(this.mContext, R.dimen.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (af * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (af * 0.75f);
                } else {
                    i = (int) (f * af);
                }
                this.ihB.setLayoutParams(new FrameLayout.LayoutParams(af, i));
                removeView(this.ihB);
                addView(this.ihB);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.flf.getLayoutParams();
                layoutParams.width = af;
                layoutParams.height = l.g(this.mContext, R.dimen.ds110);
                removeView(this.flf);
                addView(this.flf, layoutParams);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ihA != null) {
            com.baidu.tbadk.browser.a.ae(this.mContext, this.ihA.cpY());
        }
    }

    public ImageView getIcon() {
        return this.mIcon;
    }
}
