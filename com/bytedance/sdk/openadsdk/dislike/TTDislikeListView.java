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
/* loaded from: classes5.dex */
public class TTDislikeListView extends ListView {

    /* renamed from: a  reason: collision with root package name */
    public l f29699a;

    /* renamed from: b  reason: collision with root package name */
    public AdapterView.OnItemClickListener f29700b;

    /* renamed from: c  reason: collision with root package name */
    public AdapterView.OnItemClickListener f29701c;

    public TTDislikeListView(Context context) {
        super(context);
        this.f29701c = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                if (TTDislikeListView.this.getAdapter() != null && TTDislikeListView.this.getAdapter().getItem(i2) != null && (TTDislikeListView.this.getAdapter().getItem(i2) instanceof FilterWord)) {
                    FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i2);
                    if (filterWord.hasSecondOptions()) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(filterWord);
                    if (TTDislikeListView.this.f29699a != null) {
                        com.bytedance.sdk.openadsdk.c.d.a(TTDislikeListView.this.f29699a, arrayList);
                    }
                    if (TTDislikeListView.this.f29700b != null) {
                        TTDislikeListView.this.f29700b.onItemClick(adapterView, view, i2, j);
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
        this.f29699a = lVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(@Nullable AdapterView.OnItemClickListener onItemClickListener) {
        this.f29700b = onItemClickListener;
    }

    private void a() {
        super.setOnItemClickListener(this.f29701c);
    }

    public TTDislikeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f29701c = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                if (TTDislikeListView.this.getAdapter() != null && TTDislikeListView.this.getAdapter().getItem(i2) != null && (TTDislikeListView.this.getAdapter().getItem(i2) instanceof FilterWord)) {
                    FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i2);
                    if (filterWord.hasSecondOptions()) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(filterWord);
                    if (TTDislikeListView.this.f29699a != null) {
                        com.bytedance.sdk.openadsdk.c.d.a(TTDislikeListView.this.f29699a, arrayList);
                    }
                    if (TTDislikeListView.this.f29700b != null) {
                        TTDislikeListView.this.f29700b.onItemClick(adapterView, view, i2, j);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
            }
        };
        a();
    }

    public TTDislikeListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f29701c = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i22, long j) {
                if (TTDislikeListView.this.getAdapter() != null && TTDislikeListView.this.getAdapter().getItem(i22) != null && (TTDislikeListView.this.getAdapter().getItem(i22) instanceof FilterWord)) {
                    FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i22);
                    if (filterWord.hasSecondOptions()) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(filterWord);
                    if (TTDislikeListView.this.f29699a != null) {
                        com.bytedance.sdk.openadsdk.c.d.a(TTDislikeListView.this.f29699a, arrayList);
                    }
                    if (TTDislikeListView.this.f29700b != null) {
                        TTDislikeListView.this.f29700b.onItemClick(adapterView, view, i22, j);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
            }
        };
        a();
    }
}
