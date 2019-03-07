package com.baidu.tieba.write.write;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends BaseAdapter {
    private c jsk;
    private List<String> mDataList;

    /* loaded from: classes3.dex */
    public static class a {
        public TbImageView jdg;
        public TbImageView jdh;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.T(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public String getItem(int i) {
        return (String) v.c(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.pic_sticker_item, (ViewGroup) null);
            aVar = new a();
            aVar.jdg = (TbImageView) view.findViewById(d.g.top_sticker);
            aVar.jdh = (TbImageView) view.findViewById(d.g.bottom_sticker);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.jdg.setGifIconSupport(false);
        aVar.jdh.setGifIconSupport(false);
        aVar.jdg.startLoad(this.mDataList.get(i * 2), 10, true);
        aVar.jdg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TbImageView tbImageView = (TbImageView) view2;
                if (d.this.jsk != null && tbImageView != null && tbImageView.getBdImage() != null && tbImageView.getBdImage().oy() != null) {
                    d.this.jsk.d(tbImageView.getBdImage().oy(), false);
                }
            }
        });
        aVar.jdh.startLoad(this.mDataList.get((i * 2) + 1), 10, true);
        aVar.jdh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TbImageView tbImageView = (TbImageView) view2;
                if (d.this.jsk != null && tbImageView != null && tbImageView.getBdImage() != null && tbImageView.getBdImage().oy() != null) {
                    d.this.jsk.d(tbImageView.getBdImage().oy(), true);
                }
            }
        });
        return view;
    }

    public void b(c cVar) {
        this.jsk = cVar;
    }

    public void setData(List<String> list) {
        if (!v.T(list)) {
            this.mDataList = list;
        }
    }
}
