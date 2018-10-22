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
    private c hOm;
    private List<String> mDataList;

    /* loaded from: classes3.dex */
    public static class a {
        public TbImageView hzH;
        public TbImageView hzI;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.J(this.mDataList)) {
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
            aVar.hzH = (TbImageView) view.findViewById(e.g.top_sticker);
            aVar.hzI = (TbImageView) view.findViewById(e.g.bottom_sticker);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.hzH.setGifIconSupport(false);
        aVar.hzI.setGifIconSupport(false);
        aVar.hzH.startLoad(this.mDataList.get(i * 2), 10, true);
        aVar.hzH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TbImageView tbImageView = (TbImageView) view2;
                if (d.this.hOm != null && tbImageView != null && tbImageView.getBdImage() != null && tbImageView.getBdImage().os() != null) {
                    d.this.hOm.d(tbImageView.getBdImage().os(), false);
                }
            }
        });
        aVar.hzI.startLoad(this.mDataList.get((i * 2) + 1), 10, true);
        aVar.hzI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TbImageView tbImageView = (TbImageView) view2;
                if (d.this.hOm != null && tbImageView != null && tbImageView.getBdImage() != null && tbImageView.getBdImage().os() != null) {
                    d.this.hOm.d(tbImageView.getBdImage().os(), true);
                }
            }
        });
        return view;
    }

    public void b(c cVar) {
        this.hOm = cVar;
    }

    public void setData(List<String> list) {
        if (!v.J(list)) {
            this.mDataList = list;
        }
    }
}
