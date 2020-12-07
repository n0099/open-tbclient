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
    private LinearLayout iLe;
    private Context mContext;
    private ImageView mIcon;
    private View mRootView;
    private TextView mTitle;
    private com.baidu.tieba.tbadkCore.data.a mfm;
    private TbImageView mfn;
    private TextView mfo;

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
        return this.mfm;
    }

    public void setSupportNoImage() {
        this.fPc = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.pic_show_cardview_layout, (ViewGroup) this, true);
        this.mfn = (TbImageView) findViewById(R.id.pic_img);
        this.iLe = (LinearLayout) findViewById(R.id.bottom_ll);
        this.mTitle = (TextView) findViewById(R.id.title_ll);
        this.mfo = (TextView) findViewById(R.id.desc_ll);
        this.mIcon = (ImageView) findViewById(R.id.show_pic_icon);
    }

    public void setIconResId(int i) {
        ap.setImageResource(this.mIcon, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.mfm != aVar) {
            this.mfm = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.mfo.setVisibility(0);
                this.mfo.setText(aVar.getDescription());
            } else {
                this.mfo.setVisibility(8);
            }
            if (this.fPc) {
                this.mfn.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.mfn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.mfn.setOnClickListener(this);
                this.mfn.setInterceptOnClick(true);
                this.mfn.setDefaultResource(R.drawable.icon_click);
                this.mfn.startLoad(aVar.dOK(), 18, false);
                int equipmentWidth = l.getEquipmentWidth(this.mContext) - (l.getDimens(this.mContext, R.dimen.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (equipmentWidth * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (equipmentWidth * 0.75f);
                } else {
                    i = (int) (f * equipmentWidth);
                }
                this.mfn.setLayoutParams(new FrameLayout.LayoutParams(equipmentWidth, i));
                removeView(this.mfn);
                addView(this.mfn);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iLe.getLayoutParams();
                layoutParams.width = equipmentWidth;
                layoutParams.height = l.getDimens(this.mContext, R.dimen.ds110);
                removeView(this.iLe);
                addView(this.iLe, layoutParams);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mfm != null) {
            com.baidu.tbadk.browser.a.startWebActivity(this.mContext, this.mfm.dOL());
        }
    }

    public ImageView getIcon() {
        return this.mIcon;
    }
}
