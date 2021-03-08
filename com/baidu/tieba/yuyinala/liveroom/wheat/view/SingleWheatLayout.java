package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.tieba.yuyinala.liveroom.wheat.e.e;
import java.util.List;
/* loaded from: classes10.dex */
public class SingleWheatLayout extends BaseWheatLayout {
    public SingleWheatLayout(@NonNull Context context) {
        this(context, null);
    }

    public SingleWheatLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SingleWheatLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oMR = e.d(135.0f, getContext());
        this.oMS = e.d(148.0f, getContext());
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout
    public synchronized void a(final List<AlaWheatInfoData> list, final List<AlaWheatInfoData> list2, final ab abVar) {
        this.mView.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.SingleWheatLayout.1
            @Override // java.lang.Runnable
            public void run() {
                int i = 0;
                try {
                    SingleWheatLayout.this.oLK = list;
                    SingleWheatLayout.this.oLL = list2;
                    if (ListUtils.getCount(SingleWheatLayout.this.oMO) == 0 || ListUtils.getCount(SingleWheatLayout.this.oMO) != ListUtils.getCount(list)) {
                        SingleWheatLayout.this.efb();
                        SingleWheatLayout.this.oMT.removeAllViews();
                        SingleWheatLayout.this.oMO.clear();
                        SingleWheatLayout.this.oMP.clear();
                        if (!ListUtils.isEmpty(list)) {
                            for (int i2 = 0; i2 < list.size(); i2++) {
                                SingleWheatLayout.this.a(SingleWheatLayout.this.an(0, true), true);
                            }
                        }
                    }
                    if (ListUtils.isEmpty(SingleWheatLayout.this.oMO)) {
                        return;
                    }
                    while (true) {
                        int i3 = i;
                        if (i3 < SingleWheatLayout.this.oMO.size()) {
                            SingleWheatLayout.this.oMO.get(i3).setData(SingleWheatLayout.this.am(i3, true), i3, true, abVar);
                            i = i3 + 1;
                        } else {
                            return;
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
            iArr[0] = (screenFullSize[0] / 2) - (this.oMR / 2);
            iArr[1] = this.ZA + e.d(60.0f, getContext());
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int[] iArr, boolean z) {
        BaseWheatItemView singleWheatItemView = new SingleWheatItemView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.oMR, this.oMS);
        layoutParams.leftMargin = iArr[0];
        layoutParams.topMargin = iArr[1];
        singleWheatItemView.setLayoutParams(layoutParams);
        this.oMT.addView(singleWheatItemView);
        singleWheatItemView.setOnItemClickListener(this.oMN);
        if (z) {
            this.oMO.add(singleWheatItemView);
        } else {
            this.oMP.add(singleWheatItemView);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout
    public int getWheatHeight() {
        return this.ZA + e.d(60.0f, getContext()) + this.oMS;
    }
}
