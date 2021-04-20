package com.baidu.tieba.newfaceshop.nativemotionmanager.managers;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.newfaceshop.nativemotionmanager.view.SingleThreadEmotionHorizontalView;
import java.util.List;
/* loaded from: classes3.dex */
public class SingleThreadEmotionHorizontalAdater extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<EmotionPackageData> f18970e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f18971f;

    /* loaded from: classes3.dex */
    public static class EmotionGridViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public SingleThreadEmotionHorizontalView f18972a;

        public EmotionGridViewHolder(View view) {
            super(view);
            this.f18972a = (SingleThreadEmotionHorizontalView) view;
        }

        public void b(EmotionPackageData emotionPackageData) {
            SingleThreadEmotionHorizontalView singleThreadEmotionHorizontalView = this.f18972a;
            if (singleThreadEmotionHorizontalView == null || emotionPackageData == null) {
                return;
            }
            singleThreadEmotionHorizontalView.setData(emotionPackageData);
        }
    }

    public SingleThreadEmotionHorizontalAdater(List<EmotionPackageData> list, TbPageContext tbPageContext) {
        this.f18970e = list;
        this.f18971f = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f18970e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f18970e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        EmotionGridViewHolder emotionGridViewHolder;
        if (view == null) {
            view = new SingleThreadEmotionHorizontalView(this.f18971f);
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            emotionGridViewHolder = new EmotionGridViewHolder(view);
            view.setTag(emotionGridViewHolder);
        } else {
            emotionGridViewHolder = null;
        }
        if (emotionGridViewHolder == null) {
            emotionGridViewHolder = (EmotionGridViewHolder) view.getTag();
        }
        emotionGridViewHolder.b(this.f18970e.get(i));
        return view;
    }
}
