package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PageIndex extends LinearLayout {
    public PageIndex(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PageIndex(Context context) {
        super(context);
    }

    public void a(int i, int i2) {
        int dimension = (int) getContext().getResources().getDimension(R.dimen.index_width);
        boolean z = TiebaApplication.f().au() == 1;
        if (i2 > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            layoutParams.width = dimension * i2;
            setLayoutParams(layoutParams);
            setBackgroundResource(z ? R.drawable.pg_blue_down_1 : R.drawable.pg_blue_down);
            if (i > 0 && i <= i2) {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(new LinearLayout.LayoutParams(dimension * i, -2));
                imageView.setBackgroundResource(z ? R.drawable.pg_blue_on_1 : R.drawable.pg_blue_on);
                addView(imageView);
                return;
            }
            return;
        }
        setVisibility(8);
    }
}
