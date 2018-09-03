package com.baidu.tieba.write.write;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends BaseAdapter {
    private c hyC;
    private List<String> mDataList;

    /* loaded from: classes3.dex */
    public static class a {
        public TbImageView hkE;
        public TbImageView hkF;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.z(this.mDataList)) {
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(f.h.pic_sticker_item, (ViewGroup) null);
            aVar = new a();
            aVar.hkE = (TbImageView) view.findViewById(f.g.top_sticker);
            aVar.hkF = (TbImageView) view.findViewById(f.g.bottom_sticker);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.hkE.setGifIconSupport(false);
        aVar.hkF.setGifIconSupport(false);
        aVar.hkE.startLoad(this.mDataList.get(i * 2), 10, true);
        aVar.hkE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TbImageView tbImageView = (TbImageView) view2;
                if (d.this.hyC != null && tbImageView != null && tbImageView.getBdImage() != null && tbImageView.getBdImage().nb() != null) {
                    d.this.hyC.d(tbImageView.getBdImage().nb(), false);
                }
            }
        });
        aVar.hkF.startLoad(this.mDataList.get((i * 2) + 1), 10, true);
        aVar.hkF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TbImageView tbImageView = (TbImageView) view2;
                if (d.this.hyC != null && tbImageView != null && tbImageView.getBdImage() != null && tbImageView.getBdImage().nb() != null) {
                    d.this.hyC.d(tbImageView.getBdImage().nb(), true);
                }
            }
        });
        return view;
    }

    public void b(c cVar) {
        this.hyC = cVar;
    }

    public void setData(List<String> list) {
        if (!w.z(list)) {
            this.mDataList = list;
        }
    }
}
