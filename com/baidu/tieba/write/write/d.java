package com.baidu.tieba.write.write;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends BaseAdapter {
    private c hxt;
    private List<String> mDataList;

    /* loaded from: classes3.dex */
    public static class a {
        public TbImageView hjp;
        public TbImageView hjq;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.A(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public String getItem(int i) {
        return (String) w.d(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.pic_sticker_item, (ViewGroup) null);
            aVar = new a();
            aVar.hjp = (TbImageView) view.findViewById(d.g.top_sticker);
            aVar.hjq = (TbImageView) view.findViewById(d.g.bottom_sticker);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.hjp.setGifIconSupport(false);
        aVar.hjq.setGifIconSupport(false);
        aVar.hjp.startLoad(this.mDataList.get(i * 2), 10, true);
        aVar.hjp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TbImageView tbImageView = (TbImageView) view2;
                if (d.this.hxt != null && tbImageView != null && tbImageView.getBdImage() != null && tbImageView.getBdImage().mZ() != null) {
                    d.this.hxt.d(tbImageView.getBdImage().mZ(), false);
                }
            }
        });
        aVar.hjq.startLoad(this.mDataList.get((i * 2) + 1), 10, true);
        aVar.hjq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TbImageView tbImageView = (TbImageView) view2;
                if (d.this.hxt != null && tbImageView != null && tbImageView.getBdImage() != null && tbImageView.getBdImage().mZ() != null) {
                    d.this.hxt.d(tbImageView.getBdImage().mZ(), true);
                }
            }
        });
        return view;
    }

    public void b(c cVar) {
        this.hxt = cVar;
    }

    public void setData(List<String> list) {
        if (!w.A(list)) {
            this.mDataList = list;
        }
    }
}
