package com.baidu.tieba.write.write;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends BaseAdapter {
    private c hXg;
    private List<String> mDataList;

    /* loaded from: classes3.dex */
    public static class a {
        public TbImageView hID;
        public TbImageView hIE;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.I(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public String getItem(int i) {
        return (String) v.d(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.pic_sticker_item, (ViewGroup) null);
            aVar = new a();
            aVar.hID = (TbImageView) view.findViewById(e.g.top_sticker);
            aVar.hIE = (TbImageView) view.findViewById(e.g.bottom_sticker);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.hID.setGifIconSupport(false);
        aVar.hIE.setGifIconSupport(false);
        aVar.hID.startLoad(this.mDataList.get(i * 2), 10, true);
        aVar.hID.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TbImageView tbImageView = (TbImageView) view2;
                if (d.this.hXg != null && tbImageView != null && tbImageView.getBdImage() != null && tbImageView.getBdImage().op() != null) {
                    d.this.hXg.d(tbImageView.getBdImage().op(), false);
                }
            }
        });
        aVar.hIE.startLoad(this.mDataList.get((i * 2) + 1), 10, true);
        aVar.hIE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TbImageView tbImageView = (TbImageView) view2;
                if (d.this.hXg != null && tbImageView != null && tbImageView.getBdImage() != null && tbImageView.getBdImage().op() != null) {
                    d.this.hXg.d(tbImageView.getBdImage().op(), true);
                }
            }
        });
        return view;
    }

    public void b(c cVar) {
        this.hXg = cVar;
    }

    public void setData(List<String> list) {
        if (!v.I(list)) {
            this.mDataList = list;
        }
    }
}
