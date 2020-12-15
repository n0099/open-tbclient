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
    private boolean fPc;
    private LinearLayout iLg;
    private Context mContext;
    private ImageView mIcon;
    private View mRootView;
    private TextView mTitle;
    private com.baidu.tieba.tbadkCore.data.a mfo;
    private TbImageView mfp;
    private TextView mfq;

    public ShowPicCardView(Context context) {
        this(context, null, 0);
    }

    public ShowPicCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShowPicCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fPc = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.mfo;
    }

    public void setSupportNoImage() {
        this.fPc = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.pic_show_cardview_layout, (ViewGroup) this, true);
        this.mfp = (TbImageView) findViewById(R.id.pic_img);
        this.iLg = (LinearLayout) findViewById(R.id.bottom_ll);
        this.mTitle = (TextView) findViewById(R.id.title_ll);
        this.mfq = (TextView) findViewById(R.id.desc_ll);
        this.mIcon = (ImageView) findViewById(R.id.show_pic_icon);
    }

    public void setIconResId(int i) {
        ap.setImageResource(this.mIcon, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.mfo != aVar) {
            this.mfo = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.mfq.setVisibility(0);
                this.mfq.setText(aVar.getDescription());
            } else {
                this.mfq.setVisibility(8);
            }
            if (this.fPc) {
                this.mfp.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.mfp.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.mfp.setOnClickListener(this);
                this.mfp.setInterceptOnClick(true);
                this.mfp.setDefaultResource(R.drawable.icon_click);
                this.mfp.startLoad(aVar.dOL(), 18, false);
                int equipmentWidth = l.getEquipmentWidth(this.mContext) - (l.getDimens(this.mContext, R.dimen.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (equipmentWidth * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (equipmentWidth * 0.75f);
                } else {
                    i = (int) (f * equipmentWidth);
                }
                this.mfp.setLayoutParams(new FrameLayout.LayoutParams(equipmentWidth, i));
                removeView(this.mfp);
                addView(this.mfp);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iLg.getLayoutParams();
                layoutParams.width = equipmentWidth;
                layoutParams.height = l.getDimens(this.mContext, R.dimen.ds110);
                removeView(this.iLg);
                addView(this.iLg, layoutParams);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mfo != null) {
            com.baidu.tbadk.browser.a.startWebActivity(this.mContext, this.mfo.dOM());
        }
    }

    public ImageView getIcon() {
        return this.mIcon;
    }
}
