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
    int Yp;
    private View mView;
    private RelativeLayout oyC;

    public WheatCommonLayout(@NonNull Context context) {
        this(context, null);
    }

    public WheatCommonLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WheatCommonLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Yp = e.c(100.0f, getContext());
        initView();
    }

    private void initView() {
        this.mView = LayoutInflater.from(getContext()).inflate(a.g.yuyinala_liveroom_wheat_common_layout, this);
        this.oyC = (RelativeLayout) this.mView.findViewById(a.f.wheat_view_container);
        this.dlk = this.mView.findViewById(a.f.mask);
    }

    public synchronized void a(final List<AlaWheatInfoData> list, final List<AlaWheatInfoData> list2, final w wVar) {
        this.mView.post(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.view.WheatCommonLayout.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WheatCommonLayout.this.oxf = list;
                    WheatCommonLayout.this.oxg = list2;
                    if (ListUtils.getCount(WheatCommonLayout.this.oyd) == 0 || ListUtils.getCount(WheatCommonLayout.this.oyd) != ListUtils.getCount(list) || ListUtils.getCount(WheatCommonLayout.this.oye) == 0 || ListUtils.getCount(WheatCommonLayout.this.oye) != ListUtils.getCount(list2)) {
                        WheatCommonLayout.this.efZ();
                        WheatCommonLayout.this.oyC.removeAllViews();
                        WheatCommonLayout.this.oyd.clear();
                        WheatCommonLayout.this.oye.clear();
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
                    if (!ListUtils.isEmpty(WheatCommonLayout.this.oyd)) {
                        for (int i3 = 0; i3 < WheatCommonLayout.this.oyd.size(); i3++) {
                            WheatCommonLayout.this.oyd.get(i3).setData(WheatCommonLayout.this.ao(i3, true), i3, true, wVar);
                        }
                    }
                    if (!ListUtils.isEmpty(WheatCommonLayout.this.oye)) {
                        for (int i4 = 0; i4 < WheatCommonLayout.this.oye.size(); i4++) {
                            WheatCommonLayout.this.oye.get(i4).setData(WheatCommonLayout.this.ao(i4, false), i4, false, wVar);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] ap(int i, boolean z) {
        int[] iArr = new int[2];
        int[] screenFullSize = ViewCommonUtil.getScreenFullSize(this.mTbPageContext.getPageActivity());
        if (z) {
            iArr[0] = (screenFullSize[0] / 2) - (this.oyg / 2);
            iArr[1] = this.Yp;
        } else if (i == 0) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oyg) - this.oyg;
            iArr[1] = this.Yp + this.oyh;
        } else if (i == 1) {
            iArr[0] = (screenFullSize[0] / 2) - this.oyg;
            iArr[1] = this.Yp + this.oyh;
        } else if (i == 2) {
            iArr[0] = screenFullSize[0] / 2;
            iArr[1] = this.Yp + this.oyh;
        } else if (i == 3) {
            iArr[0] = (screenFullSize[0] / 2) + this.oyg;
            iArr[1] = this.Yp + this.oyh;
        } else if (i == 4) {
            iArr[0] = ((screenFullSize[0] / 2) - this.oyg) - this.oyg;
            iArr[1] = this.Yp + this.oyh + this.oyh;
        } else if (i == 5) {
            iArr[0] = (screenFullSize[0] / 2) - this.oyg;
            iArr[1] = this.Yp + this.oyh + this.oyh;
        } else if (i == 6) {
            iArr[0] = screenFullSize[0] / 2;
            iArr[1] = this.Yp + this.oyh + this.oyh;
        } else if (i == 7) {
            iArr[0] = (screenFullSize[0] / 2) + this.oyg;
            iArr[1] = this.Yp + this.oyh + this.oyh;
        } else {
            iArr[1] = 0;
            iArr[0] = 0;
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int[] iArr, boolean z) {
        WheatItemView wheatItemView = new WheatItemView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.oyg, this.oyh);
        layoutParams.leftMargin = iArr[0];
        layoutParams.topMargin = iArr[1];
        wheatItemView.setLayoutParams(layoutParams);
        this.oyC.addView(wheatItemView);
        wheatItemView.setOnItemClickListener(this.oyc);
        if (z) {
            this.oyd.add(wheatItemView);
        } else {
            this.oye.add(wheatItemView);
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
        return this.Yp + this.oyh + this.oyh + this.oyh;
    }
}
