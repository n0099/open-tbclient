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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ShowPicCardView extends FrameLayout implements View.OnClickListener {
    private ImageView dxS;
    private boolean fYF;
    private LinearLayout iXr;
    private Context mContext;
    private View mRootView;
    private TextView mTitle;
    private com.baidu.tieba.tbadkCore.data.a mkB;
    private TbImageView mkC;
    private TextView mkD;

    public ShowPicCardView(Context context) {
        this(context, null, 0);
    }

    public ShowPicCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShowPicCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fYF = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.mkB;
    }

    public void setSupportNoImage() {
        this.fYF = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.pic_show_cardview_layout, (ViewGroup) this, true);
        this.mkC = (TbImageView) findViewById(R.id.pic_img);
        this.iXr = (LinearLayout) findViewById(R.id.bottom_ll);
        this.mTitle = (TextView) findViewById(R.id.title_ll);
        this.mkD = (TextView) findViewById(R.id.desc_ll);
        this.dxS = (ImageView) findViewById(R.id.show_pic_icon);
    }

    public void setIconResId(int i) {
        ao.setImageResource(this.dxS, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.mkB != aVar) {
            this.mkB = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.mkD.setVisibility(0);
                this.mkD.setText(aVar.getDescription());
            } else {
                this.mkD.setVisibility(8);
            }
            if (this.fYF) {
                this.mkC.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.mkC.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.mkC.setOnClickListener(this);
                this.mkC.setInterceptOnClick(true);
                this.mkC.setDefaultResource(R.drawable.icon_click);
                this.mkC.startLoad(aVar.dOD(), 18, false);
                int equipmentWidth = l.getEquipmentWidth(this.mContext) - (l.getDimens(this.mContext, R.dimen.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (equipmentWidth * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (equipmentWidth * 0.75f);
                } else {
                    i = (int) (f * equipmentWidth);
                }
                this.mkC.setLayoutParams(new FrameLayout.LayoutParams(equipmentWidth, i));
                removeView(this.mkC);
                addView(this.mkC);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iXr.getLayoutParams();
                layoutParams.width = equipmentWidth;
                layoutParams.height = l.getDimens(this.mContext, R.dimen.ds110);
                removeView(this.iXr);
                addView(this.iXr, layoutParams);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mkB != null) {
            com.baidu.tbadk.browser.a.startWebActivity(this.mContext, this.mkB.dOE());
        }
    }

    public ImageView getIcon() {
        return this.dxS;
    }
}
