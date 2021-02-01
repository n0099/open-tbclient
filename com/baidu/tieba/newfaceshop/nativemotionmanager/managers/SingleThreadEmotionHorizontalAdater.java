package com.baidu.tieba.newfaceshop.nativemotionmanager.managers;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.newfaceshop.nativemotionmanager.view.SingleThreadEmotionHorizontalView;
import java.util.List;
/* loaded from: classes9.dex */
public class SingleThreadEmotionHorizontalAdater extends BaseAdapter {
    private List<EmotionPackageData> caS;
    private TbPageContext mPageContext;

    public SingleThreadEmotionHorizontalAdater(List<EmotionPackageData> list, TbPageContext tbPageContext) {
        this.caS = list;
        this.mPageContext = tbPageContext;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.caS.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.caS.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        EmotionGridViewHolder emotionGridViewHolder = null;
        if (view == null) {
            view = new SingleThreadEmotionHorizontalView(this.mPageContext);
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            emotionGridViewHolder = new EmotionGridViewHolder(view);
            view.setTag(emotionGridViewHolder);
        }
        (emotionGridViewHolder == null ? (EmotionGridViewHolder) view.getTag() : emotionGridViewHolder).setData(this.caS.get(i));
        return view;
    }

    /* loaded from: classes9.dex */
    public static class EmotionGridViewHolder extends TypeAdapter.ViewHolder {
        private SingleThreadEmotionHorizontalView lDi;

        public EmotionGridViewHolder(View view) {
            super(view);
            this.lDi = (SingleThreadEmotionHorizontalView) view;
        }

        public void setData(EmotionPackageData emotionPackageData) {
            if (this.lDi != null && emotionPackageData != null) {
                this.lDi.setData(emotionPackageData);
            }
        }
    }
}
