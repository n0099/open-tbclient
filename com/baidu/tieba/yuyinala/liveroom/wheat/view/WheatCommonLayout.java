package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.tieba.yuyinala.liveroom.wheat.e.e;
import java.util.List;
/* loaded from: classes4.dex */
public class WheatCommonLayout extends BaseWheatLayout {
    int Xs;
    private View mView;
    private RelativeLayout ojB;

    public WheatCommonLayout(@NonNull Context context) {
        this(context, null);
    }

    public WheatCommonLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WheatCommonLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Xs = e.c(100.0f, getContext());
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.yuyinala_liveroom_wheat_common_layout, this);
        this.ojB = (RelativeLayout) this.mView.findViewById(a.f.wheat_view_container);
        this.del = this.mView.findViewById(a.f.mask);
    }

    public synchronized void a(final List<AlaWheatInfoData> list, final List<AlaWheatInfoData> list2, final w wVar) {
        this.mView.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatCommonLayout.1
            @Override // java.lang.Runnable
            public void run() {
                WheatCommonLayout.this.oif = list;
                WheatCommonLayout.this.oig = list2;
                if (ListUtils.getCount(WheatCommonLayout.this.ojc) == 0 || ListUtils.getCount(WheatCommonLayout.this.ojc) != ListUtils.getCount(list) || ListUtils.getCount(WheatCommonLayout.this.ojd) == 0 || ListUtils.getCount(WheatCommonLayout.this.ojd) != ListUtils.getCount(list2)) {
                    WheatCommonLayout.this.eau();
                    WheatCommonLayout.this.ojB.removeAllViews();
                    WheatCommonLayout.this.ojc.clear();
                    WheatCommonLayout.this.ojd.clear();
                    if (!ListUtils.isEmpty(list)) {
                        for (int i = 0; i < list.size(); i++) {
                            WheatCommonLayout.this.a(WheatCommonLayout.this.ap(0, true), true);
                        }
                    }
                    if (!ListUtils.isEmpty(list2)) {
                        for (int i2 = 0; i2 < ListUtils.getCount(list2); i2++) {
                            WheatCommonLayout.this.a(WheatCommonLayout.this.ap(i2, false), false);
                        }
                    }
                }
                if (!ListUtils.isEmpty(WheatCommonLayout.this.ojc)) {
                    for (int i3 = 0; i3 < WheatCommonLayout.this.ojc.size(); i3++) {
                        WheatCommonLayout.this.ojc.get(i3).setData(WheatCommonLayout.this.ao(i3, true), i3, true, wVar);
                    }
                }
                if (!ListUtils.isEmpty(WheatCommonLayout.this.ojd)) {
                    for (int i4 = 0; i4 < WheatCommonLayout.this.ojd.size(); i4++) {
                        WheatCommonLayout.this.ojd.get(i4).setData(WheatCommonLayout.this.ao(i4, false), i4, false, wVar);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] ap(int i, boolean z) {
        int[] iArr = new int[2];
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (z) {
            iArr[0] = (screenFullSize[0] / 2) - (this.ojf / 2);
            iArr[1] = this.Xs;
        } else if (i == 0) {
            iArr[0] = ((screenFullSize[0] / 2) - this.ojf) - this.ojf;
            iArr[1] = this.Xs + this.ojg + e.c(20.0f, getContext());
        } else if (i == 1) {
            iArr[0] = (screenFullSize[0] / 2) - this.ojf;
            iArr[1] = this.Xs + this.ojg + e.c(20.0f, getContext());
        } else if (i == 2) {
            iArr[0] = screenFullSize[0] / 2;
            iArr[1] = this.Xs + this.ojg + e.c(20.0f, getContext());
        } else if (i == 3) {
            iArr[0] = (screenFullSize[0] / 2) + this.ojf;
            iArr[1] = this.Xs + this.ojg + e.c(20.0f, getContext());
        } else if (i == 4) {
            iArr[0] = ((screenFullSize[0] / 2) - this.ojf) - this.ojf;
            iArr[1] = this.Xs + this.ojg + e.c(20.0f, getContext()) + this.ojg + e.c(10.0f, getContext());
        } else if (i == 5) {
            iArr[0] = (screenFullSize[0] / 2) - this.ojf;
            iArr[1] = this.Xs + this.ojg + e.c(20.0f, getContext()) + this.ojg + e.c(10.0f, getContext());
        } else if (i == 6) {
            iArr[0] = screenFullSize[0] / 2;
            iArr[1] = this.Xs + this.ojg + e.c(20.0f, getContext()) + this.ojg + e.c(10.0f, getContext());
        } else if (i == 7) {
            iArr[0] = (screenFullSize[0] / 2) + this.ojf;
            iArr[1] = this.Xs + this.ojg + e.c(20.0f, getContext()) + this.ojg + e.c(10.0f, getContext());
        } else {
            iArr[1] = 0;
            iArr[0] = 0;
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int[] iArr, boolean z) {
        WheatItemView wheatItemView = new WheatItemView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.ojf, this.ojg);
        layoutParams.leftMargin = iArr[0];
        layoutParams.topMargin = iArr[1];
        wheatItemView.setLayoutParams(layoutParams);
        this.ojB.addView(wheatItemView);
        wheatItemView.setOnItemClickListener(this.ojb);
        if (z) {
            this.ojc.add(wheatItemView);
        } else {
            this.ojd.add(wheatItemView);
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

    public int getWheatHeight() {
        return this.Xs + this.ojg + e.c(20.0f, getContext()) + this.ojg + e.c(10.0f, getContext()) + this.ojg;
    }
}
