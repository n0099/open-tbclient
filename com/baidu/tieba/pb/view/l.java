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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class l extends FrameLayout implements View.OnClickListener {
    private boolean aJn;
    private TextView aSh;
    private com.baidu.tieba.tbadkCore.data.a dqO;
    private TbImageView dqP;
    private LinearLayout dqQ;
    private ImageView dqR;
    private TextView dqS;
    private Context mContext;
    private View mRootView;

    public l(Context context) {
        this(context, null, 0);
    }

    public l(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aJn = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.dqO;
    }

    public void IY() {
        this.aJn = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(t.h.pic_show_cardview_layout, (ViewGroup) this, true);
        this.dqP = (TbImageView) findViewById(t.g.pic_img);
        this.dqQ = (LinearLayout) findViewById(t.g.bottom_ll);
        this.aSh = (TextView) findViewById(t.g.title_ll);
        this.dqS = (TextView) findViewById(t.g.desc_ll);
        this.dqR = (ImageView) findViewById(t.g.show_pic_icon);
    }

    public void setIconResId(int i) {
        at.c(this.dqR, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.dqO != aVar) {
            this.dqO = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.aSh.setVisibility(0);
                this.aSh.setText(aVar.getTitle());
            } else {
                this.aSh.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.dqS.setVisibility(0);
                this.dqS.setText(aVar.getDescription());
            } else {
                this.dqS.setVisibility(8);
            }
            if (this.aJn) {
                this.dqP.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.dqP.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.dqP.setOnClickListener(this);
                this.dqP.setInterceptOnClick(true);
                this.dqP.setDefaultResource(t.f.icon_click);
                this.dqP.c(aVar.aSJ(), 18, false);
                int B = com.baidu.adp.lib.util.k.B(this.mContext) - (com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (B * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (B * 0.75f);
                } else {
                    i = (int) (f * B);
                }
                this.dqP.setLayoutParams(new FrameLayout.LayoutParams(B, i));
                removeView(this.dqP);
                addView(this.dqP);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dqQ.getLayoutParams();
                layoutParams.width = B;
                layoutParams.height = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds110);
                removeView(this.dqQ);
                addView(this.dqQ, layoutParams);
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ab(i == 1);
        tbPageContext.getLayoutMode().x(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dqO != null) {
            com.baidu.tbadk.browser.f.s(this.mContext, this.dqO.aSK());
        }
    }

    public ImageView getIcon() {
        return this.dqR;
    }
}
