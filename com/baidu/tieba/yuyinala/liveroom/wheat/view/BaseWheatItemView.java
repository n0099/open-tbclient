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
/* loaded from: classes10.dex */
public abstract class BaseWheatItemView extends SafeFrameLayout {
    public ab bzn;
    public AlaWheatInfoData oMM;
    public BaseWheatLayout.a oMN;

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
        this.oMN = aVar;
    }

    public void a(SimpleDraweeView simpleDraweeView, String str) {
        simpleDraweeView.setController(c.etF().bq(ImageRequest.ZR(str)).Bk(true).c(simpleDraweeView.getController()).euw());
    }
}
