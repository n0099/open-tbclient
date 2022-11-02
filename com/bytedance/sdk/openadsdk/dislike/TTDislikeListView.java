package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTDislikeController;
/* loaded from: classes7.dex */
public class TTDislikeListView extends ListView {
    public TTDislikeController mDislikeController;
    public AdapterView.OnItemClickListener mOnItemClickListener;
    public AdapterView.OnItemClickListener mOnItemClickListenerInner;

    public TTDislikeListView(Context context) {
        super(context);
        this.mOnItemClickListenerInner = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                if (TTDislikeListView.this.getAdapter() != null && TTDislikeListView.this.getAdapter().getItem(i) != null && (TTDislikeListView.this.getAdapter().getItem(i) instanceof FilterWord)) {
                    FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i);
                    if (!filterWord.hasSecondOptions()) {
                        if (TTDislikeListView.this.mDislikeController != null) {
                            TTDislikeListView.this.mDislikeController.onDislikeSelected(filterWord);
                        }
                        if (TTDislikeListView.this.mOnItemClickListener != null) {
                            TTDislikeListView.this.mOnItemClickListener.onItemClick(adapterView, view2, i, j);
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
            }
        };
        init();
    }

    public void setDislikeInfo(TTDislikeController tTDislikeController) {
        this.mDislikeController = tTDislikeController;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public TTDislikeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnItemClickListenerInner = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                if (TTDislikeListView.this.getAdapter() != null && TTDislikeListView.this.getAdapter().getItem(i) != null && (TTDislikeListView.this.getAdapter().getItem(i) instanceof FilterWord)) {
                    FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i);
                    if (!filterWord.hasSecondOptions()) {
                        if (TTDislikeListView.this.mDislikeController != null) {
                            TTDislikeListView.this.mDislikeController.onDislikeSelected(filterWord);
                        }
                        if (TTDislikeListView.this.mOnItemClickListener != null) {
                            TTDislikeListView.this.mOnItemClickListener.onItemClick(adapterView, view2, i, j);
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
            }
        };
        init();
    }

    public TTDislikeListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOnItemClickListenerInner = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i2, long j) {
                if (TTDislikeListView.this.getAdapter() != null && TTDislikeListView.this.getAdapter().getItem(i2) != null && (TTDislikeListView.this.getAdapter().getItem(i2) instanceof FilterWord)) {
                    FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i2);
                    if (!filterWord.hasSecondOptions()) {
                        if (TTDislikeListView.this.mDislikeController != null) {
                            TTDislikeListView.this.mDislikeController.onDislikeSelected(filterWord);
                        }
                        if (TTDislikeListView.this.mOnItemClickListener != null) {
                            TTDislikeListView.this.mOnItemClickListener.onItemClick(adapterView, view2, i2, j);
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
            }
        };
        init();
    }

    private void init() {
        super.setOnItemClickListener(this.mOnItemClickListenerInner);
    }
}
