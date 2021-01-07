package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import java.util.List;
/* loaded from: classes11.dex */
public class WheatCommonLayout extends BaseWheatLayout {
    public WheatCommonLayout(@NonNull Context context) {
        super(context, null);
    }

    public WheatCommonLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public WheatCommonLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout
    public synchronized void a(final List<AlaWheatInfoData> list, final List<AlaWheatInfoData> list2, final x xVar) {
        super.a(list, list2, xVar);
        this.mView.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatCommonLayout.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WheatCommonLayout.this.oEb = list;
                    WheatCommonLayout.this.oEc = list2;
                    if (ListUtils.getCount(WheatCommonLayout.this.oFd) == 0 || ListUtils.getCount(WheatCommonLayout.this.oFd) != ListUtils.getCount(list) || ListUtils.getCount(WheatCommonLayout.this.oFe) == 0 || ListUtils.getCount(WheatCommonLayout.this.oFe) != ListUtils.getCount(list2)) {
                        WheatCommonLayout.this.egp();
                        WheatCommonLayout.this.oFi.removeAllViews();
                        WheatCommonLayout.this.oFd.clear();
                        WheatCommonLayout.this.oFe.clear();
                        if (!ListUtils.isEmpty(list)) {
                            for (int i = 0; i < list.size(); i++) {
                                WheatCommonLayout.this.a(WheatCommonLayout.this.an(0, true), true);
                            }
                        }
                        if (!ListUtils.isEmpty(list2)) {
                            for (int i2 = 0; i2 < ListUtils.getCount(list2); i2++) {
                                WheatCommonLayout.this.a(WheatCommonLayout.this.an(i2, false), false);
                            }
                        }
                        WheatCommonLayout.this.oFi.invalidate();
                        WheatCommonLayout.this.oFi.requestLayout();
                    }
                    if (!ListUtils.isEmpty(WheatCommonLayout.this.oFd)) {
                        for (int i3 = 0; i3 < WheatCommonLayout.this.oFd.size(); i3++) {
                            WheatCommonLayout.this.oFd.get(i3).setData(WheatCommonLayout.this.am(i3, true), i3, true, xVar);
                        }
                    }
                    if (!ListUtils.isEmpty(WheatCommonLayout.this.oFe)) {
                        for (int i4 = 0; i4 < WheatCommonLayout.this.oFe.size(); i4++) {
                            WheatCommonLayout.this.oFe.get(i4).setData(WheatCommonLayout.this.am(i4, false), i4, false, xVar);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] an(int i, boolean z) {
        int[] iArr = new int[2];
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (z) {
            iArr[0] = (screenFullSize[0] / 2) - (this.oFg / 2);
            iArr[1] = this.Yn;
        } else if (i == 0) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oFg) - this.oFg;
            iArr[1] = this.Yn + this.oFh;
        } else if (i == 1) {
            iArr[0] = (screenFullSize[0] / 2) - this.oFg;
            iArr[1] = this.Yn + this.oFh;
        } else if (i == 2) {
            iArr[0] = screenFullSize[0] / 2;
            iArr[1] = this.Yn + this.oFh;
        } else if (i == 3) {
            iArr[0] = (screenFullSize[0] / 2) + this.oFg;
            iArr[1] = this.Yn + this.oFh;
        } else if (i == 4) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oFg) - this.oFg;
            iArr[1] = this.Yn + this.oFh + this.oFh;
        } else if (i == 5) {
            iArr[0] = (screenFullSize[0] / 2) - this.oFg;
            iArr[1] = this.Yn + this.oFh + this.oFh;
        } else if (i == 6) {
            iArr[0] = screenFullSize[0] / 2;
            iArr[1] = this.Yn + this.oFh + this.oFh;
        } else if (i == 7) {
            iArr[0] = (screenFullSize[0] / 2) + this.oFg;
            iArr[1] = this.Yn + this.oFh + this.oFh;
        } else {
            iArr[1] = 0;
            iArr[0] = 0;
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int[] iArr, boolean z) {
        WheatItemView wheatItemView = new WheatItemView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.oFg, this.oFh);
        layoutParams.leftMargin = iArr[0];
        layoutParams.topMargin = iArr[1];
        wheatItemView.setLayoutParams(layoutParams);
        this.oFi.addView(wheatItemView);
        wheatItemView.setOnItemClickListener(this.oFc);
        if (z) {
            this.oFd.add(wheatItemView);
        } else {
            this.oFe.add(wheatItemView);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        UtilHelper.getStatusBarHeight();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout
    public int getWheatHeight() {
        return this.Yn + this.oFh + this.oFh + this.oFh;
    }
}
