package com.baidu.tieba.write.write;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends BaseAdapter {
    private c hhO;
    private List<String> mDataList;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.w(this.mDataList)) {
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
            aVar.gWi = (TbImageView) view.findViewById(d.g.top_sticker);
            aVar.gWj = (TbImageView) view.findViewById(d.g.bottom_sticker);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.gWi.setAutoChangeStyle(false);
        aVar.gWj.setAutoChangeStyle(false);
        aVar.gWi.setGifIconSupport(false);
        aVar.gWj.setGifIconSupport(false);
        aVar.gWi.startLoad(this.mDataList.get(i * 2), 10, true);
        aVar.gWi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TbImageView tbImageView = (TbImageView) view2;
                if (d.this.hhO != null && tbImageView != null && tbImageView.getBdImage() != null && tbImageView.getBdImage().kK() != null) {
                    d.this.hhO.d(tbImageView.getBdImage().kK(), false);
                }
            }
        });
        aVar.gWj.startLoad(this.mDataList.get((i * 2) + 1), 10, true);
        aVar.gWj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TbImageView tbImageView = (TbImageView) view2;
                if (d.this.hhO != null && tbImageView != null && tbImageView.getBdImage() != null && tbImageView.getBdImage().kK() != null) {
                    d.this.hhO.d(tbImageView.getBdImage().kK(), true);
                }
            }
        });
        return view;
    }

    public void b(c cVar) {
        this.hhO = cVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public TbImageView gWi;
        public TbImageView gWj;

        public a() {
        }
    }

    public void setData(List<String> list) {
        if (!v.w(list)) {
            this.mDataList = list;
        }
    }
}
