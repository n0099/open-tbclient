package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.ab;
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
    public synchronized void a(final List<AlaWheatInfoData> list, final List<AlaWheatInfoData> list2, final ab abVar) {
        super.a(list, list2, abVar);
        this.mView.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatCommonLayout.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WheatCommonLayout.this.oJf = list;
                    WheatCommonLayout.this.oJg = list2;
                    if (ListUtils.getCount(WheatCommonLayout.this.oKj) == 0 || ListUtils.getCount(WheatCommonLayout.this.oKj) != ListUtils.getCount(list) || ListUtils.getCount(WheatCommonLayout.this.oKk) == 0 || ListUtils.getCount(WheatCommonLayout.this.oKk) != ListUtils.getCount(list2)) {
                        WheatCommonLayout.this.eeL();
                        WheatCommonLayout.this.oKo.removeAllViews();
                        WheatCommonLayout.this.oKj.clear();
                        WheatCommonLayout.this.oKk.clear();
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
                        WheatCommonLayout.this.oKo.invalidate();
                        WheatCommonLayout.this.oKo.requestLayout();
                    }
                    if (!ListUtils.isEmpty(WheatCommonLayout.this.oKj)) {
                        for (int i3 = 0; i3 < WheatCommonLayout.this.oKj.size(); i3++) {
                            WheatCommonLayout.this.oKj.get(i3).setData(WheatCommonLayout.this.am(i3, true), i3, true, abVar);
                        }
                    }
                    if (!ListUtils.isEmpty(WheatCommonLayout.this.oKk)) {
                        for (int i4 = 0; i4 < WheatCommonLayout.this.oKk.size(); i4++) {
                            WheatCommonLayout.this.oKk.get(i4).setData(WheatCommonLayout.this.am(i4, false), i4, false, abVar);
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
            iArr[0] = (screenFullSize[0] / 2) - (this.oKm / 2);
            iArr[1] = this.Yh;
        } else if (i == 0) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oKm) - this.oKm;
            iArr[1] = this.Yh + this.oKn;
        } else if (i == 1) {
            iArr[0] = (screenFullSize[0] / 2) - this.oKm;
            iArr[1] = this.Yh + this.oKn;
        } else if (i == 2) {
            iArr[0] = screenFullSize[0] / 2;
            iArr[1] = this.Yh + this.oKn;
        } else if (i == 3) {
            iArr[0] = (screenFullSize[0] / 2) + this.oKm;
            iArr[1] = this.Yh + this.oKn;
        } else if (i == 4) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oKm) - this.oKm;
            iArr[1] = this.Yh + this.oKn + this.oKn;
        } else if (i == 5) {
            iArr[0] = (screenFullSize[0] / 2) - this.oKm;
            iArr[1] = this.Yh + this.oKn + this.oKn;
        } else if (i == 6) {
            iArr[0] = screenFullSize[0] / 2;
            iArr[1] = this.Yh + this.oKn + this.oKn;
        } else if (i == 7) {
            iArr[0] = (screenFullSize[0] / 2) + this.oKm;
            iArr[1] = this.Yh + this.oKn + this.oKn;
        } else {
            iArr[1] = 0;
            iArr[0] = 0;
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int[] iArr, boolean z) {
        BaseWheatItemView wheatItemView = new WheatItemView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.oKm, this.oKn);
        layoutParams.leftMargin = iArr[0];
        layoutParams.topMargin = iArr[1];
        wheatItemView.setLayoutParams(layoutParams);
        this.oKo.addView(wheatItemView);
        wheatItemView.setOnItemClickListener(this.oKi);
        if (z) {
            this.oKj.add(wheatItemView);
        } else {
            this.oKk.add(wheatItemView);
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
        return this.Yh + this.oKn + this.oKn + this.oKn;
    }
}
