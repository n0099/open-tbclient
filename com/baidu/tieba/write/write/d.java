package com.baidu.tieba.write.write;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends BaseAdapter {
    private c jLo;
    private List<String> mDataList;

    /* loaded from: classes3.dex */
    public static class a {
        public TbImageView jwb;
        public TbImageView jwc;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.aa(this.mDataList)) {
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pic_sticker_item, (ViewGroup) null);
            aVar = new a();
            aVar.jwb = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.jwc = (TbImageView) view.findViewById(R.id.bottom_sticker);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.jwb.setGifIconSupport(false);
        aVar.jwc.setGifIconSupport(false);
        aVar.jwb.startLoad(this.mDataList.get(i * 2), 10, true);
        aVar.jwb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TbImageView tbImageView = (TbImageView) view2;
                if (d.this.jLo != null && tbImageView != null && tbImageView.getBdImage() != null && tbImageView.getBdImage().ns() != null) {
                    d.this.jLo.e(tbImageView.getBdImage().ns(), false);
                }
            }
        });
        aVar.jwc.startLoad(this.mDataList.get((i * 2) + 1), 10, true);
        aVar.jwc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TbImageView tbImageView = (TbImageView) view2;
                if (d.this.jLo != null && tbImageView != null && tbImageView.getBdImage() != null && tbImageView.getBdImage().ns() != null) {
                    d.this.jLo.e(tbImageView.getBdImage().ns(), true);
                }
            }
        });
        return view;
    }

    public void b(c cVar) {
        this.jLo = cVar;
    }

    public void setData(List<String> list) {
        if (!v.aa(list)) {
            this.mDataList = list;
        }
    }
}
