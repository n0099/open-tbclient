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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class h extends FrameLayout implements View.OnClickListener {
    private boolean bIu;
    private LinearLayout duM;
    private com.baidu.tieba.tbadkCore.data.a gaK;
    private TbImageView gaL;
    private TextView gaM;
    private ImageView jt;
    private Context mContext;
    private View mRootView;
    private TextView mTitle;

    public h(Context context) {
        this(context, null, 0);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bIu = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.gaK;
    }

    public void QA() {
        this.bIu = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.pic_show_cardview_layout, (ViewGroup) this, true);
        this.gaL = (TbImageView) findViewById(d.g.pic_img);
        this.duM = (LinearLayout) findViewById(d.g.bottom_ll);
        this.mTitle = (TextView) findViewById(d.g.title_ll);
        this.gaM = (TextView) findViewById(d.g.desc_ll);
        this.jt = (ImageView) findViewById(d.g.show_pic_icon);
    }

    public void setIconResId(int i) {
        aj.c(this.jt, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.gaK != aVar) {
            this.gaK = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.mTitle.setVisibility(0);
                this.mTitle.setText(aVar.getTitle());
            } else {
                this.mTitle.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.gaM.setVisibility(0);
                this.gaM.setText(aVar.getDescription());
            } else {
                this.gaM.setVisibility(8);
            }
            if (this.bIu) {
                this.gaL.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.gaL.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.gaL.setOnClickListener(this);
                this.gaL.setInterceptOnClick(true);
                this.gaL.setDefaultResource(d.f.icon_click);
                this.gaL.startLoad(aVar.bvc(), 18, false);
                int ao = l.ao(this.mContext) - (l.s(this.mContext, d.e.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (ao * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (ao * 0.75f);
                } else {
                    i = (int) (f * ao);
                }
                this.gaL.setLayoutParams(new FrameLayout.LayoutParams(ao, i));
                removeView(this.gaL);
                addView(this.gaL);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.duM.getLayoutParams();
                layoutParams.width = ao;
                layoutParams.height = l.s(this.mContext, d.e.ds110);
                removeView(this.duM);
                addView(this.duM, layoutParams);
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().aM(i == 1);
        tbPageContext.getLayoutMode().aM(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gaK != null) {
            com.baidu.tbadk.browser.a.Q(this.mContext, this.gaK.bvd());
        }
    }

    public ImageView getIcon() {
        return this.jt;
    }
}
