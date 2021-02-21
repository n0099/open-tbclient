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
/* loaded from: classes11.dex */
public class SingleWheatLayout extends BaseWheatLayout {
    public SingleWheatLayout(@NonNull Context context) {
        this(context, null);
    }

    public SingleWheatLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SingleWheatLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oKM = e.d(135.0f, getContext());
        this.oKN = e.d(148.0f, getContext());
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout
    public synchronized void a(final List<AlaWheatInfoData> list, final List<AlaWheatInfoData> list2, final ab abVar) {
        this.mView.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.SingleWheatLayout.1
            @Override // java.lang.Runnable
            public void run() {
                int i = 0;
                try {
                    SingleWheatLayout.this.oJF = list;
                    SingleWheatLayout.this.oJG = list2;
                    if (ListUtils.getCount(SingleWheatLayout.this.oKJ) == 0 || ListUtils.getCount(SingleWheatLayout.this.oKJ) != ListUtils.getCount(list)) {
                        SingleWheatLayout.this.eeT();
                        SingleWheatLayout.this.oKO.removeAllViews();
                        SingleWheatLayout.this.oKJ.clear();
                        SingleWheatLayout.this.oKK.clear();
                        if (!ListUtils.isEmpty(list)) {
                            for (int i2 = 0; i2 < list.size(); i2++) {
                                SingleWheatLayout.this.a(SingleWheatLayout.this.an(0, true), true);
                            }
                        }
                    }
                    if (ListUtils.isEmpty(SingleWheatLayout.this.oKJ)) {
                        return;
                    }
                    while (true) {
                        int i3 = i;
                        if (i3 < SingleWheatLayout.this.oKJ.size()) {
                            SingleWheatLayout.this.oKJ.get(i3).setData(SingleWheatLayout.this.am(i3, true), i3, true, abVar);
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
            iArr[0] = (screenFullSize[0] / 2) - (this.oKM / 2);
            iArr[1] = this.Yh + e.d(60.0f, getContext());
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int[] iArr, boolean z) {
        BaseWheatItemView singleWheatItemView = new SingleWheatItemView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.oKM, this.oKN);
        layoutParams.leftMargin = iArr[0];
        layoutParams.topMargin = iArr[1];
        singleWheatItemView.setLayoutParams(layoutParams);
        this.oKO.addView(singleWheatItemView);
        singleWheatItemView.setOnItemClickListener(this.oKI);
        if (z) {
            this.oKJ.add(singleWheatItemView);
        } else {
            this.oKK.add(singleWheatItemView);
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
        return this.Yh + e.d(60.0f, getContext()) + this.oKN;
    }
}
