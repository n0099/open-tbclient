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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class ShowPicCardView extends FrameLayout implements View.OnClickListener {
    private boolean cVX;
    private LinearLayout fnN;
    private com.baidu.tieba.tbadkCore.data.a igk;
    private TbImageView igl;
    private TextView igm;
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
        this.cVX = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.igk;
    }

    public void setSupportNoImage() {
        this.cVX = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.pic_show_cardview_layout, (ViewGroup) this, true);
        this.igl = (TbImageView) findViewById(R.id.pic_img);
        this.fnN = (LinearLayout) findViewById(R.id.bottom_ll);
        this.mTitle = (TextView) findViewById(R.id.title_ll);
        this.igm = (TextView) findViewById(R.id.desc_ll);
        this.mIcon = (ImageView) findViewById(R.id.show_pic_icon);
    }

    public void setIconResId(int i) {
        am.setImageResource(this.mIcon, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.igk != aVar) {
            this.igk = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.igm.setVisibility(0);
                this.igm.setText(aVar.getDescription());
            } else {
                this.igm.setVisibility(8);
            }
            if (this.cVX) {
                this.igl.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.igl.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.igl.setOnClickListener(this);
                this.igl.setInterceptOnClick(true);
                this.igl.setDefaultResource(R.drawable.icon_click);
                this.igl.startLoad(aVar.cnO(), 18, false);
                int equipmentWidth = l.getEquipmentWidth(this.mContext) - (l.getDimens(this.mContext, R.dimen.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (equipmentWidth * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (equipmentWidth * 0.75f);
                } else {
                    i = (int) (f * equipmentWidth);
                }
                this.igl.setLayoutParams(new FrameLayout.LayoutParams(equipmentWidth, i));
                removeView(this.igl);
                addView(this.igl);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fnN.getLayoutParams();
                layoutParams.width = equipmentWidth;
                layoutParams.height = l.getDimens(this.mContext, R.dimen.ds110);
                removeView(this.fnN);
                addView(this.fnN, layoutParams);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.igk != null) {
            com.baidu.tbadk.browser.a.startWebActivity(this.mContext, this.igk.cnP());
        }
    }

    public ImageView getIcon() {
        return this.mIcon;
    }
}
