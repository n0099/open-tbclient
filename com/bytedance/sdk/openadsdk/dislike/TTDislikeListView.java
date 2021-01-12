package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.d.l;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class TTDislikeListView extends ListView {

    /* renamed from: a  reason: collision with root package name */
    private l f7028a;

    /* renamed from: b  reason: collision with root package name */
    private AdapterView.OnItemClickListener f7029b;
    private AdapterView.OnItemClickListener c;

    public TTDislikeListView(Context context) {
        super(context);
        this.c = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (TTDislikeListView.this.getAdapter() != null && TTDislikeListView.this.getAdapter().getItem(i) != null && (TTDislikeListView.this.getAdapter().getItem(i) instanceof FilterWord)) {
                    FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i);
                    if (!filterWord.hasSecondOptions()) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(filterWord);
                        if (TTDislikeListView.this.f7028a != null) {
                            com.bytedance.sdk.openadsdk.c.d.a(TTDislikeListView.this.f7028a, arrayList);
                        }
                        if (TTDislikeListView.this.f7029b != null) {
                            TTDislikeListView.this.f7029b.onItemClick(adapterView, view, i, j);
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
            }
        };
        a();
    }

    public TTDislikeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (TTDislikeListView.this.getAdapter() != null && TTDislikeListView.this.getAdapter().getItem(i) != null && (TTDislikeListView.this.getAdapter().getItem(i) instanceof FilterWord)) {
                    FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i);
                    if (!filterWord.hasSecondOptions()) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(filterWord);
                        if (TTDislikeListView.this.f7028a != null) {
                            com.bytedance.sdk.openadsdk.c.d.a(TTDislikeListView.this.f7028a, arrayList);
                        }
                        if (TTDislikeListView.this.f7029b != null) {
                            TTDislikeListView.this.f7029b.onItemClick(adapterView, view, i, j);
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
            }
        };
        a();
    }

    public TTDislikeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                if (TTDislikeListView.this.getAdapter() != null && TTDislikeListView.this.getAdapter().getItem(i2) != null && (TTDislikeListView.this.getAdapter().getItem(i2) instanceof FilterWord)) {
                    FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i2);
                    if (!filterWord.hasSecondOptions()) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(filterWord);
                        if (TTDislikeListView.this.f7028a != null) {
                            com.bytedance.sdk.openadsdk.c.d.a(TTDislikeListView.this.f7028a, arrayList);
                        }
                        if (TTDislikeListView.this.f7029b != null) {
                            TTDislikeListView.this.f7029b.onItemClick(adapterView, view, i2, j);
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
            }
        };
        a();
    }

    public void setMaterialMeta(l lVar) {
        this.f7028a = lVar;
    }

    private void a() {
        super.setOnItemClickListener(this.c);
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(@Nullable AdapterView.OnItemClickListener onItemClickListener) {
        this.f7029b = onItemClickListener;
    }
}
