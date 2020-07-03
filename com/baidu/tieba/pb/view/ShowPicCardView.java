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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class ShowPicCardView extends FrameLayout implements View.OnClickListener {
    private boolean eNn;
    private LinearLayout hrV;
    private com.baidu.tieba.tbadkCore.data.a kBp;
    private TbImageView kBq;
    private TextView kBr;
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
        this.eNn = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.kBp;
    }

    public void setSupportNoImage() {
        this.eNn = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.pic_show_cardview_layout, (ViewGroup) this, true);
        this.kBq = (TbImageView) findViewById(R.id.pic_img);
        this.hrV = (LinearLayout) findViewById(R.id.bottom_ll);
        this.mTitle = (TextView) findViewById(R.id.title_ll);
        this.kBr = (TextView) findViewById(R.id.desc_ll);
        this.mIcon = (ImageView) findViewById(R.id.show_pic_icon);
    }

    public void setIconResId(int i) {
        an.setImageResource(this.mIcon, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.kBp != aVar) {
            this.kBp = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.kBr.setVisibility(0);
                this.kBr.setText(aVar.getDescription());
            } else {
                this.kBr.setVisibility(8);
            }
            if (this.eNn) {
                this.kBq.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.kBq.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.kBq.setOnClickListener(this);
                this.kBq.setInterceptOnClick(true);
                this.kBq.setDefaultResource(R.drawable.icon_click);
                this.kBq.startLoad(aVar.dhB(), 18, false);
                int equipmentWidth = l.getEquipmentWidth(this.mContext) - (l.getDimens(this.mContext, R.dimen.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (equipmentWidth * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (equipmentWidth * 0.75f);
                } else {
                    i = (int) (f * equipmentWidth);
                }
                this.kBq.setLayoutParams(new FrameLayout.LayoutParams(equipmentWidth, i));
                removeView(this.kBq);
                addView(this.kBq);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hrV.getLayoutParams();
                layoutParams.width = equipmentWidth;
                layoutParams.height = l.getDimens(this.mContext, R.dimen.ds110);
                removeView(this.hrV);
                addView(this.hrV, layoutParams);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kBp != null) {
            com.baidu.tbadk.browser.a.startWebActivity(this.mContext, this.kBp.dhC());
        }
    }

    public ImageView getIcon() {
        return this.mIcon;
    }
}
