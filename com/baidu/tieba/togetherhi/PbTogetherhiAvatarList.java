package com.baidu.tieba.togetherhi;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class PbTogetherhiAvatarList extends LinearLayout {
    private int fiA;
    private int fiy;
    private int fiz;
    private List<String> portraitList;

    public PbTogetherhiAvatarList(Context context) {
        super(context);
        this.portraitList = new ArrayList();
    }

    public PbTogetherhiAvatarList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.portraitList = new ArrayList();
        setOrientation(0);
        this.fiy = getResources().getDimensionPixelSize(u.e.ds60);
        this.fiz = getResources().getDimensionPixelSize(u.e.ds12);
        this.fiA = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth() - getResources().getDimensionPixelSize(u.e.ds162);
    }

    public void setPortraitList(List<String> list) {
        boolean z;
        if (list == null || list.size() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (list.size() == this.portraitList.size()) {
            int i = 0;
            while (true) {
                if (i >= list.size()) {
                    z = false;
                    break;
                } else if (!this.portraitList.get(i).equals(list.get(i))) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                return;
            }
        }
        removeAllViews();
        this.portraitList = list;
        int i2 = 0;
        for (int i3 = 0; i3 < this.portraitList.size(); i3++) {
            String str = this.portraitList.get(i3);
            if (!TextUtils.isEmpty(str)) {
                if (i2 <= this.fiA) {
                    HeadImageView headImageView = new HeadImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.fiy, this.fiy);
                    layoutParams.setMargins(0, 0, this.fiz, 0);
                    headImageView.setIsRound(true);
                    headImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    addView(headImageView, layoutParams);
                    String di = q.di(str);
                    headImageView.setUrl(di);
                    headImageView.c(di, 12, false);
                    i2 = this.fiz + this.fiy + i2;
                } else {
                    return;
                }
            }
        }
    }

    public void reset() {
        if (this.portraitList != null) {
            this.portraitList.clear();
            this.portraitList = null;
        }
        removeAllViews();
    }
}
