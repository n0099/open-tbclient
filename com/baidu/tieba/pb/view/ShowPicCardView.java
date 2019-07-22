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
    private boolean cLI;
    private LinearLayout fiS;
    private TbImageView ieA;
    private TextView ieB;
    private com.baidu.tieba.tbadkCore.data.a iez;
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
        this.cLI = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.iez;
    }

    public void setSupportNoImage() {
        this.cLI = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.pic_show_cardview_layout, (ViewGroup) this, true);
        this.ieA = (TbImageView) findViewById(R.id.pic_img);
        this.fiS = (LinearLayout) findViewById(R.id.bottom_ll);
        this.mTitle = (TextView) findViewById(R.id.title_ll);
        this.ieB = (TextView) findViewById(R.id.desc_ll);
        this.mIcon = (ImageView) findViewById(R.id.show_pic_icon);
    }

    public void setIconResId(int i) {
        am.c(this.mIcon, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.iez != aVar) {
            this.iez = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.ieB.setVisibility(0);
                this.ieB.setText(aVar.getDescription());
            } else {
                this.ieB.setVisibility(8);
            }
            if (this.cLI) {
                this.ieA.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.ieA.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.ieA.setOnClickListener(this);
                this.ieA.setInterceptOnClick(true);
                this.ieA.setDefaultResource(R.drawable.icon_click);
                this.ieA.startLoad(aVar.coN(), 18, false);
                int af = l.af(this.mContext) - (l.g(this.mContext, R.dimen.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (af * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (af * 0.75f);
                } else {
                    i = (int) (f * af);
                }
                this.ieA.setLayoutParams(new FrameLayout.LayoutParams(af, i));
                removeView(this.ieA);
                addView(this.ieA);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fiS.getLayoutParams();
                layoutParams.width = af;
                layoutParams.height = l.g(this.mContext, R.dimen.ds110);
                removeView(this.fiS);
                addView(this.fiS, layoutParams);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iez != null) {
            com.baidu.tbadk.browser.a.ae(this.mContext, this.iez.coO());
        }
    }

    public ImageView getIcon() {
        return this.mIcon;
    }
}
