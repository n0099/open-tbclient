package com.baidu.tieba.square;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tieba.square.CarouselRecommendView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class k extends BaseAdapter implements com.baidu.tieba.view.s {
    private CarouselRecommendView aIR;
    private CarouselRecommendView.n mPageAdapter = null;
    private ArrayList<ak> datas = new ArrayList<>();

    public k(Context context) {
        this.aIR = null;
        this.aIR = new CarouselRecommendView(context, false);
    }

    public void setData(ArrayList<ak> arrayList) {
        this.datas = arrayList;
        this.aIR.setData(arrayList);
        this.mPageAdapter = this.aIR.getPagerAdapter();
        notifyDataSetChanged();
    }

    public void startMarqueen() {
        if (this.aIR != null) {
            this.aIR.startMarqueen();
        }
    }

    public void stopMarqueen() {
        if (this.aIR != null) {
            this.aIR.stopMarqueen();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return (this.datas != null ? this.datas.size() + 0 : 0) > 0 ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.aIR;
    }

    @Override // com.baidu.tieba.view.s
    public void adq() {
        if (this.mPageAdapter != null) {
            this.mPageAdapter.adq();
        }
    }

    @Override // com.baidu.tieba.view.s
    public void g(View view, int i, int i2) {
        if (this.mPageAdapter != null) {
            this.mPageAdapter.g(this.aIR, 0, 0);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.aIR != null) {
            this.aIR.onChangeSkinType(i);
        }
    }
}
