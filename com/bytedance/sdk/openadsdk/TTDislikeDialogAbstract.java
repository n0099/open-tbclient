package com.bytedance.sdk.openadsdk;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeWebViewActivity;
import com.bytedance.sdk.openadsdk.utils.b;
/* loaded from: classes5.dex */
public abstract class TTDislikeDialogAbstract extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public View f27317a;

    /* renamed from: b  reason: collision with root package name */
    public l f27318b;

    public TTDislikeDialogAbstract(@NonNull Context context) {
        super(context);
    }

    private void b() {
        int[] personalizationPromptIds;
        l lVar = this.f27318b;
        if (lVar == null || this.f27317a == null || lVar.as() == null || (personalizationPromptIds = getPersonalizationPromptIds()) == null || personalizationPromptIds.length == 0) {
            return;
        }
        for (int i : personalizationPromptIds) {
            View findViewById = this.f27317a.findViewById(i);
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName(TTDislikeDialogAbstract.this.getContext(), TTDislikeWebViewActivity.class));
                        intent.putExtra("title", TTDislikeDialogAbstract.this.f27318b.as().getName());
                        intent.putExtra("url", TTDislikeDialogAbstract.this.f27318b.as().getUrl());
                        b.a(TTDislikeDialogAbstract.this.getContext(), intent, null);
                    }
                });
            }
        }
    }

    public abstract int getLayoutId();

    public abstract ViewGroup.LayoutParams getLayoutParams();

    public abstract int[] getPersonalizationPromptIds();

    public abstract int[] getTTDislikeListViewIds();

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) null);
        this.f27317a = inflate;
        if (inflate != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            View view = this.f27317a;
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            setContentView(view, layoutParams);
            a();
            b();
            return;
        }
        throw new IllegalArgumentException("getLayoutId布局文件id可能异常，请检查");
    }

    public void setMaterialMeta(l lVar) {
        this.f27318b = lVar;
        a();
        b();
    }

    public TTDislikeDialogAbstract(@NonNull Context context, int i) {
        super(context, i);
    }

    private void a() {
        if (this.f27318b == null || this.f27317a == null) {
            return;
        }
        int[] tTDislikeListViewIds = getTTDislikeListViewIds();
        if (tTDislikeListViewIds != null && tTDislikeListViewIds.length > 0) {
            for (int i : tTDislikeListViewIds) {
                View findViewById = this.f27317a.findViewById(i);
                if (findViewById != null) {
                    if (findViewById instanceof TTDislikeListView) {
                        ((TTDislikeListView) findViewById).setMaterialMeta(this.f27318b);
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
}
