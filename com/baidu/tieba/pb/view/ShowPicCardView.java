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
/* loaded from: classes2.dex */
public class ShowPicCardView extends FrameLayout implements View.OnClickListener {
    private ImageView dvq;
    private boolean fWn;
    private LinearLayout iYF;
    private Context mContext;
    private View mRootView;
    private TextView mTitle;
    private com.baidu.tieba.tbadkCore.data.a mpm;
    private TbImageView mpn;
    private TextView mpo;

    public ShowPicCardView(Context context) {
        this(context, null, 0);
    }

    public ShowPicCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShowPicCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fWn = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.mpm;
    }

    public void setSupportNoImage() {
        this.fWn = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.pic_show_cardview_layout, (ViewGroup) this, true);
        this.mpn = (TbImageView) findViewById(R.id.pic_img);
        this.iYF = (LinearLayout) findViewById(R.id.bottom_ll);
        this.mTitle = (TextView) findViewById(R.id.title_ll);
        this.mpo = (TextView) findViewById(R.id.desc_ll);
        this.dvq = (ImageView) findViewById(R.id.show_pic_icon);
    }

    public void setIconResId(int i) {
        ap.setImageResource(this.dvq, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.mpm != aVar) {
            this.mpm = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.mpo.setVisibility(0);
                this.mpo.setText(aVar.getDescription());
            } else {
                this.mpo.setVisibility(8);
            }
            if (this.fWn) {
                this.mpn.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.mpn.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.mpn.setOnClickListener(this);
                this.mpn.setInterceptOnClick(true);
                this.mpn.setDefaultResource(R.drawable.icon_click);
                this.mpn.startLoad(aVar.dNf(), 18, false);
                int equipmentWidth = l.getEquipmentWidth(this.mContext) - (l.getDimens(this.mContext, R.dimen.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (equipmentWidth * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (equipmentWidth * 0.75f);
                } else {
                    i = (int) (f * equipmentWidth);
                }
                this.mpn.setLayoutParams(new FrameLayout.LayoutParams(equipmentWidth, i));
                removeView(this.mpn);
                addView(this.mpn);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.iYF.getLayoutParams();
                layoutParams.width = equipmentWidth;
                layoutParams.height = l.getDimens(this.mContext, R.dimen.ds110);
                removeView(this.iYF);
                addView(this.iYF, layoutParams);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mpm != null) {
            com.baidu.tbadk.browser.a.startWebActivity(this.mContext, this.mpm.dNg());
        }
    }

    public ImageView getIcon() {
        return this.dvq;
    }
}
