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
/* loaded from: classes16.dex */
public class ShowPicCardView extends FrameLayout implements View.OnClickListener {
    private boolean eTI;
    private LinearLayout hxH;
    private com.baidu.tieba.tbadkCore.data.a kKr;
    private TbImageView kKs;
    private TextView kKt;
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
        this.eTI = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.kKr;
    }

    public void setSupportNoImage() {
        this.eTI = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.pic_show_cardview_layout, (ViewGroup) this, true);
        this.kKs = (TbImageView) findViewById(R.id.pic_img);
        this.hxH = (LinearLayout) findViewById(R.id.bottom_ll);
        this.mTitle = (TextView) findViewById(R.id.title_ll);
        this.kKt = (TextView) findViewById(R.id.desc_ll);
        this.mIcon = (ImageView) findViewById(R.id.show_pic_icon);
    }

    public void setIconResId(int i) {
        ao.setImageResource(this.mIcon, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.kKr != aVar) {
            this.kKr = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.kKt.setVisibility(0);
                this.kKt.setText(aVar.getDescription());
            } else {
                this.kKt.setVisibility(8);
            }
            if (this.eTI) {
                this.kKs.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.kKs.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.kKs.setOnClickListener(this);
                this.kKs.setInterceptOnClick(true);
                this.kKs.setDefaultResource(R.drawable.icon_click);
                this.kKs.startLoad(aVar.dkK(), 18, false);
                int equipmentWidth = l.getEquipmentWidth(this.mContext) - (l.getDimens(this.mContext, R.dimen.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (equipmentWidth * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (equipmentWidth * 0.75f);
                } else {
                    i = (int) (f * equipmentWidth);
                }
                this.kKs.setLayoutParams(new FrameLayout.LayoutParams(equipmentWidth, i));
                removeView(this.kKs);
                addView(this.kKs);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hxH.getLayoutParams();
                layoutParams.width = equipmentWidth;
                layoutParams.height = l.getDimens(this.mContext, R.dimen.ds110);
                removeView(this.hxH);
                addView(this.hxH, layoutParams);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kKr != null) {
            com.baidu.tbadk.browser.a.startWebActivity(this.mContext, this.kKr.dkL());
        }
    }

    public ImageView getIcon() {
        return this.mIcon;
    }
}
