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
    private ImageView dtf;
    private boolean fTY;
    private LinearLayout iSK;
    private Context mContext;
    private View mRootView;
    private TextView mTitle;
    private com.baidu.tieba.tbadkCore.data.a mfU;
    private TbImageView mfV;
    private TextView mfW;

    public ShowPicCardView(Context context) {
        this(context, null, 0);
    }

    public ShowPicCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShowPicCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fTY = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.mfU;
    }

    public void setSupportNoImage() {
        this.fTY = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.pic_show_cardview_layout, (ViewGroup) this, true);
        this.mfV = (TbImageView) findViewById(R.id.pic_img);
        this.iSK = (LinearLayout) findViewById(R.id.bottom_ll);
        this.mTitle = (TextView) findViewById(R.id.title_ll);
        this.mfW = (TextView) findViewById(R.id.desc_ll);
        this.dtf = (ImageView) findViewById(R.id.show_pic_icon);
    }

    public void setIconResId(int i) {
        ao.setImageResource(this.dtf, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.mfU != aVar) {
            this.mfU = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.mfW.setVisibility(0);
                this.mfW.setText(aVar.getDescription());
            } else {
                this.mfW.setVisibility(8);
            }
            if (this.fTY) {
                this.mfV.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.mfV.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.mfV.setOnClickListener(this);
                this.mfV.setInterceptOnClick(true);
                this.mfV.setDefaultResource(R.drawable.icon_click);
                this.mfV.startLoad(aVar.dKM(), 18, false);
                int equipmentWidth = l.getEquipmentWidth(this.mContext) - (l.getDimens(this.mContext, R.dimen.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (equipmentWidth * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (equipmentWidth * 0.75f);
                } else {
                    i = (int) (f * equipmentWidth);
                }
                this.mfV.setLayoutParams(new FrameLayout.LayoutParams(equipmentWidth, i));
                removeView(this.mfV);
                addView(this.mfV);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iSK.getLayoutParams();
                layoutParams.width = equipmentWidth;
                layoutParams.height = l.getDimens(this.mContext, R.dimen.ds110);
                removeView(this.iSK);
                addView(this.iSK, layoutParams);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mfU != null) {
            com.baidu.tbadk.browser.a.startWebActivity(this.mContext, this.mfU.dKN());
        }
    }

    public ImageView getIcon() {
        return this.dtf;
    }
}
