package com.baidu.tieba.togetherhi;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class PbTogetherhiAvatarList extends LinearLayout {
    private int fDW;
    private int fDX;
    private int fDY;
    private List<String> portraitList;

    public PbTogetherhiAvatarList(Context context) {
        super(context);
        this.portraitList = new ArrayList();
    }

    public PbTogetherhiAvatarList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.portraitList = new ArrayList();
        setOrientation(0);
        this.fDW = getResources().getDimensionPixelSize(t.e.ds60);
        this.fDX = getResources().getDimensionPixelSize(t.e.ds12);
        this.fDY = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth() - getResources().getDimensionPixelSize(t.e.ds162);
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
                if (i2 <= this.fDY) {
                    HeadImageView headImageView = new HeadImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.fDW, this.fDW);
                    layoutParams.setMargins(0, 0, this.fDX, 0);
                    headImageView.setIsRound(true);
                    headImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    addView(headImageView, layoutParams);
                    String dk = q.dk(str);
                    headImageView.setUrl(dk);
                    headImageView.c(dk, 12, false);
                    i2 = this.fDX + this.fDW + i2;
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
