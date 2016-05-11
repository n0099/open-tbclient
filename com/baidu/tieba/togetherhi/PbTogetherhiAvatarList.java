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
    private List<String> eDE;
    private int eDF;
    private int eDG;
    private int eDH;

    public PbTogetherhiAvatarList(Context context) {
        super(context);
        this.eDE = new ArrayList();
    }

    public PbTogetherhiAvatarList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eDE = new ArrayList();
        setOrientation(0);
        this.eDF = getResources().getDimensionPixelSize(t.e.ds60);
        this.eDG = getResources().getDimensionPixelSize(t.e.ds12);
        this.eDH = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth() - getResources().getDimensionPixelSize(t.e.ds162);
    }

    public void setPortraitList(List<String> list) {
        boolean z;
        if (list == null || list.size() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (list.size() == this.eDE.size()) {
            int i = 0;
            while (true) {
                if (i >= list.size()) {
                    z = false;
                    break;
                } else if (!this.eDE.get(i).equals(list.get(i))) {
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
        this.eDE = list;
        int i2 = 0;
        for (int i3 = 0; i3 < this.eDE.size(); i3++) {
            String str = this.eDE.get(i3);
            if (!TextUtils.isEmpty(str)) {
                if (i2 <= this.eDH) {
                    HeadImageView headImageView = new HeadImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.eDF, this.eDF);
                    layoutParams.setMargins(0, 0, this.eDG, 0);
                    headImageView.setIsRound(true);
                    headImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    addView(headImageView, layoutParams);
                    String dk = q.dk(str);
                    headImageView.setUrl(dk);
                    headImageView.c(dk, 12, false);
                    i2 = this.eDG + this.eDF + i2;
                } else {
                    return;
                }
            }
        }
    }

    public void reset() {
        if (this.eDE != null) {
            this.eDE.clear();
            this.eDE = null;
        }
        removeAllViews();
    }
}
