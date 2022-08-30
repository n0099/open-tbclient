package com.bytedance.sdk.openadsdk;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;
/* loaded from: classes7.dex */
public abstract class TTDislikeDialogAbstract extends Dialog {
    public View a;
    public TTDislikeController b;

    public TTDislikeDialogAbstract(Context context) {
        super(context);
    }

    public void a() {
        if (this.b == null || this.a == null) {
            return;
        }
        int[] tTDislikeListViewIds = getTTDislikeListViewIds();
        if (tTDislikeListViewIds != null && tTDislikeListViewIds.length > 0) {
            for (int i : tTDislikeListViewIds) {
                View findViewById = this.a.findViewById(i);
                if (findViewById != null) {
                    if (findViewById instanceof TTDislikeListView) {
                        ((TTDislikeListView) findViewById).setDislikeInfo(this.b);
                    } else {
                        throw new IllegalArgumentException("getTTDislikeListViewIds找到的view类型异常，请检查");
                    }
                } else {
                    throw new IllegalArgumentException("getTTDislikeListViewIds提供的id找不到view，请检查");
                }
            }
            return;
        }
        throw new IllegalArgumentException("dislike选项列表为空，请设置TTDislikeListView");
    }

    public void b() {
        TTDislikeController tTDislikeController = this.b;
        if (tTDislikeController != null) {
            tTDislikeController.onDislikeEvent(getContext(), true);
        }
    }

    public abstract int getLayoutId();

    public abstract ViewGroup.LayoutParams getLayoutParams();

    public abstract int[] getTTDislikeListViewIds();

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) null);
        this.a = inflate;
        if (inflate != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            View view2 = this.a;
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            setContentView(view2, layoutParams);
            a();
            return;
        }
        throw new IllegalArgumentException("getLayoutId布局文件id可能异常，请检查");
    }

    public void setDislikeModel(TTDislikeController tTDislikeController) {
        this.b = tTDislikeController;
        a();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        b();
    }

    public void startPersonalizePromptActivity() {
        TTDislikeController tTDislikeController = this.b;
        if (tTDislikeController != null) {
            tTDislikeController.openWebPage(getContext(), true);
            this.b.onDislikeEvent(getContext(), false);
        }
    }

    public TTDislikeDialogAbstract(Context context, int i) {
        super(context, i);
    }
}
