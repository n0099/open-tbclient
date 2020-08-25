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
/* loaded from: classes16.dex */
public class ShowPicCardView extends FrameLayout implements View.OnClickListener {
    private boolean fep;
    private LinearLayout hKW;
    private com.baidu.tieba.tbadkCore.data.a lah;
    private TbImageView lai;
    private TextView laj;
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
        this.fep = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.lah;
    }

    public void setSupportNoImage() {
        this.fep = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.pic_show_cardview_layout, (ViewGroup) this, true);
        this.lai = (TbImageView) findViewById(R.id.pic_img);
        this.hKW = (LinearLayout) findViewById(R.id.bottom_ll);
        this.mTitle = (TextView) findViewById(R.id.title_ll);
        this.laj = (TextView) findViewById(R.id.desc_ll);
        this.mIcon = (ImageView) findViewById(R.id.show_pic_icon);
    }

    public void setIconResId(int i) {
        ap.setImageResource(this.mIcon, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.lah != aVar) {
            this.lah = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.laj.setVisibility(0);
                this.laj.setText(aVar.getDescription());
            } else {
                this.laj.setVisibility(8);
            }
            if (this.fep) {
                this.lai.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.lai.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.lai.setOnClickListener(this);
                this.lai.setInterceptOnClick(true);
                this.lai.setDefaultResource(R.drawable.icon_click);
                this.lai.startLoad(aVar.dwi(), 18, false);
                int equipmentWidth = l.getEquipmentWidth(this.mContext) - (l.getDimens(this.mContext, R.dimen.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (equipmentWidth * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (equipmentWidth * 0.75f);
                } else {
                    i = (int) (f * equipmentWidth);
                }
                this.lai.setLayoutParams(new FrameLayout.LayoutParams(equipmentWidth, i));
                removeView(this.lai);
                addView(this.lai);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hKW.getLayoutParams();
                layoutParams.width = equipmentWidth;
                layoutParams.height = l.getDimens(this.mContext, R.dimen.ds110);
                removeView(this.hKW);
                addView(this.hKW, layoutParams);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lah != null) {
            com.baidu.tbadk.browser.a.startWebActivity(this.mContext, this.lah.dwj());
        }
    }

    public ImageView getIcon() {
        return this.mIcon;
    }
}
