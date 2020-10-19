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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class ShowPicCardView extends FrameLayout implements View.OnClickListener {
    private boolean ftC;
    private LinearLayout ihc;
    private TextView lyA;
    private com.baidu.tieba.tbadkCore.data.a lyy;
    private TbImageView lyz;
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
        this.ftC = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.lyy;
    }

    public void setSupportNoImage() {
        this.ftC = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.pic_show_cardview_layout, (ViewGroup) this, true);
        this.lyz = (TbImageView) findViewById(R.id.pic_img);
        this.ihc = (LinearLayout) findViewById(R.id.bottom_ll);
        this.mTitle = (TextView) findViewById(R.id.title_ll);
        this.lyA = (TextView) findViewById(R.id.desc_ll);
        this.mIcon = (ImageView) findViewById(R.id.show_pic_icon);
    }

    public void setIconResId(int i) {
        ap.setImageResource(this.mIcon, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.lyy != aVar) {
            this.lyy = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.lyA.setVisibility(0);
                this.lyA.setText(aVar.getDescription());
            } else {
                this.lyA.setVisibility(8);
            }
            if (this.ftC) {
                this.lyz.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.lyz.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.lyz.setOnClickListener(this);
                this.lyz.setInterceptOnClick(true);
                this.lyz.setDefaultResource(R.drawable.icon_click);
                this.lyz.startLoad(aVar.dDS(), 18, false);
                int equipmentWidth = l.getEquipmentWidth(this.mContext) - (l.getDimens(this.mContext, R.dimen.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (equipmentWidth * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (equipmentWidth * 0.75f);
                } else {
                    i = (int) (f * equipmentWidth);
                }
                this.lyz.setLayoutParams(new FrameLayout.LayoutParams(equipmentWidth, i));
                removeView(this.lyz);
                addView(this.lyz);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ihc.getLayoutParams();
                layoutParams.width = equipmentWidth;
                layoutParams.height = l.getDimens(this.mContext, R.dimen.ds110);
                removeView(this.ihc);
                addView(this.ihc, layoutParams);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lyy != null) {
            com.baidu.tbadk.browser.a.startWebActivity(this.mContext, this.lyy.dDT());
        }
    }

    public ImageView getIcon() {
        return this.mIcon;
    }
}
