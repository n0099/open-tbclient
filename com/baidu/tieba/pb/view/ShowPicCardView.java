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
/* loaded from: classes6.dex */
public class ShowPicCardView extends FrameLayout implements View.OnClickListener {
    private boolean bqD;
    private LinearLayout dzU;
    private com.baidu.tieba.tbadkCore.data.a gpc;
    private TbImageView gpd;
    private TextView gpe;
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
        this.bqD = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.gpc;
    }

    public void setSupportNoImage() {
        this.bqD = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.pic_show_cardview_layout, (ViewGroup) this, true);
        this.gpd = (TbImageView) findViewById(e.g.pic_img);
        this.dzU = (LinearLayout) findViewById(e.g.bottom_ll);
        this.mTitle = (TextView) findViewById(e.g.title_ll);
        this.gpe = (TextView) findViewById(e.g.desc_ll);
        this.mIcon = (ImageView) findViewById(e.g.show_pic_icon);
    }

    public void setIconResId(int i) {
        al.c(this.mIcon, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.gpc != aVar) {
            this.gpc = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.gpe.setVisibility(0);
                this.gpe.setText(aVar.getDescription());
            } else {
                this.gpe.setVisibility(8);
            }
            if (this.bqD) {
                this.gpd.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.gpd.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.gpd.setOnClickListener(this);
                this.gpd.setInterceptOnClick(true);
                this.gpd.setDefaultResource(e.f.icon_click);
                this.gpd.startLoad(aVar.bDH(), 18, false);
                int aO = l.aO(this.mContext) - (l.h(this.mContext, e.C0210e.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (aO * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (aO * 0.75f);
                } else {
                    i = (int) (f * aO);
                }
                this.gpd.setLayoutParams(new FrameLayout.LayoutParams(aO, i));
                removeView(this.gpd);
                addView(this.gpd);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dzU.getLayoutParams();
                layoutParams.width = aO;
                layoutParams.height = l.h(this.mContext, e.C0210e.ds110);
                removeView(this.dzU);
                addView(this.dzU, layoutParams);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gpc != null) {
            com.baidu.tbadk.browser.a.ad(this.mContext, this.gpc.bDI());
        }
    }

    public ImageView getIcon() {
        return this.mIcon;
    }
}
