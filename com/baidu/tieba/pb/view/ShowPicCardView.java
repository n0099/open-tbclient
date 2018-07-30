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
    private boolean beP;
    private LinearLayout dbG;
    private com.baidu.tieba.tbadkCore.data.a fPo;
    private TbImageView fPp;
    private TextView fPq;
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
        this.beP = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.fPo;
    }

    public void setSupportNoImage() {
        this.beP = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.pic_show_cardview_layout, (ViewGroup) this, true);
        this.fPp = (TbImageView) findViewById(d.g.pic_img);
        this.dbG = (LinearLayout) findViewById(d.g.bottom_ll);
        this.mTitle = (TextView) findViewById(d.g.title_ll);
        this.fPq = (TextView) findViewById(d.g.desc_ll);
        this.mIcon = (ImageView) findViewById(d.g.show_pic_icon);
    }

    public void setIconResId(int i) {
        am.c(this.mIcon, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.fPo != aVar) {
            this.fPo = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.fPq.setVisibility(0);
                this.fPq.setText(aVar.getDescription());
            } else {
                this.fPq.setVisibility(8);
            }
            if (this.beP) {
                this.fPp.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.fPp.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.fPp.setOnClickListener(this);
                this.fPp.setInterceptOnClick(true);
                this.fPp.setDefaultResource(d.f.icon_click);
                this.fPp.startLoad(aVar.bvD(), 18, false);
                int ah = l.ah(this.mContext) - (l.f(this.mContext, d.e.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (ah * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (ah * 0.75f);
                } else {
                    i = (int) (f * ah);
                }
                this.fPp.setLayoutParams(new FrameLayout.LayoutParams(ah, i));
                removeView(this.fPp);
                addView(this.fPp);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dbG.getLayoutParams();
                layoutParams.width = ah;
                layoutParams.height = l.f(this.mContext, d.e.ds110);
                removeView(this.dbG);
                addView(this.dbG, layoutParams);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fPo != null) {
            com.baidu.tbadk.browser.a.Q(this.mContext, this.fPo.bvE());
        }
    }

    public ImageView getIcon() {
        return this.mIcon;
    }
}
