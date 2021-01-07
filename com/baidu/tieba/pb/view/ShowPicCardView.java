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
    private com.baidu.tieba.tbadkCore.data.a mkA;
    private TbImageView mkB;
    private TextView mkC;

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
        return this.mkA;
    }

    public void setSupportNoImage() {
        this.fYF = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.pic_show_cardview_layout, (ViewGroup) this, true);
        this.mkB = (TbImageView) findViewById(R.id.pic_img);
        this.iXr = (LinearLayout) findViewById(R.id.bottom_ll);
        this.mTitle = (TextView) findViewById(R.id.title_ll);
        this.mkC = (TextView) findViewById(R.id.desc_ll);
        this.dxS = (ImageView) findViewById(R.id.show_pic_icon);
    }

    public void setIconResId(int i) {
        ao.setImageResource(this.dxS, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.mkA != aVar) {
            this.mkA = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.mkC.setVisibility(0);
                this.mkC.setText(aVar.getDescription());
            } else {
                this.mkC.setVisibility(8);
            }
            if (this.fYF) {
                this.mkB.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.mkB.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.mkB.setOnClickListener(this);
                this.mkB.setInterceptOnClick(true);
                this.mkB.setDefaultResource(R.drawable.icon_click);
                this.mkB.startLoad(aVar.dOE(), 18, false);
                int equipmentWidth = l.getEquipmentWidth(this.mContext) - (l.getDimens(this.mContext, R.dimen.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (equipmentWidth * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (equipmentWidth * 0.75f);
                } else {
                    i = (int) (f * equipmentWidth);
                }
                this.mkB.setLayoutParams(new FrameLayout.LayoutParams(equipmentWidth, i));
                removeView(this.mkB);
                addView(this.mkB);
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
        if (this.mkA != null) {
            com.baidu.tbadk.browser.a.startWebActivity(this.mContext, this.mkA.dOF());
        }
    }

    public ImageView getIcon() {
        return this.dxS;
    }
}
