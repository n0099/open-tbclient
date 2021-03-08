package com.bytedance.sdk.openadsdk;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;
/* loaded from: classes6.dex */
public abstract class TTDislikeDialogAbstract extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private View f4078a;
    private l b;

    public abstract int getLayoutId();

    public abstract ViewGroup.LayoutParams getLayoutParams();

    public abstract int[] getTTDislikeListViewIds();

    public TTDislikeDialogAbstract(@NonNull Context context) {
        super(context);
    }

    public TTDislikeDialogAbstract(@NonNull Context context, int i) {
        super(context, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4078a = LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) null);
        if (this.f4078a == null) {
            throw new IllegalArgumentException("getLayoutId布局文件id可能异常，请检查");
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        View view = this.f4078a;
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        setContentView(view, layoutParams);
        a();
    }

    private void a() {
        if (this.b != null && this.f4078a != null) {
            int[] tTDislikeListViewIds = getTTDislikeListViewIds();
            if (tTDislikeListViewIds == null || tTDislikeListViewIds.length <= 0) {
                throw new IllegalArgumentException("dislike选项列表为空，请设置TTDislikeListView");
            }
            for (int i : tTDislikeListViewIds) {
                View findViewById = this.f4078a.findViewById(i);
                if (findViewById == null) {
                    throw new IllegalArgumentException("getTTDislikeListViewIds提供的id找不到view，请检查");
                }
                if (!(findViewById instanceof TTDislikeListView)) {
                    throw new IllegalArgumentException("getTTDislikeListViewIds找到的view类型异常，请检查");
                }
                ((TTDislikeListView) findViewById).setMaterialMeta(this.b);
            }
        }
    }

    public void setMaterialMeta(l lVar) {
        this.b = lVar;
        a();
    }
}
