package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.data.AlaWheatInfoData;
import com.baidu.live.data.ab;
import com.baidu.live.tieba.view.fresco.SimpleDraweeView;
import com.baidu.live.view.SafeFrameLayout;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.BaseWheatLayout;
import com.facebook.drawee.a.a.c;
import com.facebook.imagepipeline.request.ImageRequest;
/* loaded from: classes11.dex */
public abstract class BaseWheatItemView extends SafeFrameLayout {
    public ab bxN;
    public AlaWheatInfoData oKh;
    public BaseWheatLayout.a oKi;

    protected abstract int getLayoutViewId();

    protected abstract void initView();

    public BaseWheatItemView(@NonNull Context context) {
        this(context, null);
    }

    public BaseWheatItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseWheatItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(getContext()).inflate(getLayoutViewId(), this);
        initView();
    }

    public void setData(AlaWheatInfoData alaWheatInfoData, int i, boolean z, ab abVar) {
    }

    public void setOnItemClickListener(BaseWheatLayout.a aVar) {
        this.oKi = aVar;
    }

    public void a(SimpleDraweeView simpleDraweeView, String str) {
        simpleDraweeView.setController(c.eto().bo(ImageRequest.Zz(str)).Bm(true).c(simpleDraweeView.getController()).euf());
    }
}
