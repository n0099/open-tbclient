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
    private c hho;
    private List<String> mDataList;

    /* loaded from: classes3.dex */
    public static class a {
        public TbImageView gTH;
        public TbImageView gTI;
    }

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
    public View getView(int i, View view2, ViewGroup viewGroup) {
        a aVar;
        if (view2 == null) {
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.pic_sticker_item, (ViewGroup) null);
            aVar = new a();
            aVar.gTH = (TbImageView) view2.findViewById(d.g.top_sticker);
            aVar.gTI = (TbImageView) view2.findViewById(d.g.bottom_sticker);
            view2.setTag(aVar);
        } else {
            aVar = (a) view2.getTag();
        }
        aVar.gTH.setGifIconSupport(false);
        aVar.gTI.setGifIconSupport(false);
        aVar.gTH.startLoad(this.mDataList.get(i * 2), 10, true);
        aVar.gTH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                TbImageView tbImageView = (TbImageView) view3;
                if (d.this.hho != null && tbImageView != null && tbImageView.getBdImage() != null && tbImageView.getBdImage().kl() != null) {
                    d.this.hho.d(tbImageView.getBdImage().kl(), false);
                }
            }
        });
        aVar.gTI.startLoad(this.mDataList.get((i * 2) + 1), 10, true);
        aVar.gTI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                TbImageView tbImageView = (TbImageView) view3;
                if (d.this.hho != null && tbImageView != null && tbImageView.getBdImage() != null && tbImageView.getBdImage().kl() != null) {
                    d.this.hho.d(tbImageView.getBdImage().kl(), true);
                }
            }
        });
        return view2;
    }

    public void b(c cVar) {
        this.hho = cVar;
    }

    public void setData(List<String> list) {
        if (!v.w(list)) {
            this.mDataList = list;
        }
    }
}
