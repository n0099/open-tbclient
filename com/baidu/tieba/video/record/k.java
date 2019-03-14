package com.baidu.tieba.video.record;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes5.dex */
public class k extends BaseAdapter {
    private VideoEffectLayout.a jdo;
    private List<StickerItem> mDataList;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.T(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: AI */
    public StickerItem getItem(int i) {
        return (StickerItem) v.c(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_item_sticker, (ViewGroup) null);
            aVar = new a();
            aVar.jds = (TbImageView) view.findViewById(d.g.top_sticker);
            aVar.jdt = (TbImageView) view.findViewById(d.g.bottom_sticker);
            aVar.jdq = (RelativeLayout) view.findViewById(d.g.top_container);
            aVar.jdw = (ImageView) view.findViewById(d.g.no_sticker);
            aVar.jdr = (RelativeLayout) view.findViewById(d.g.bottom_container);
            aVar.jdu = (ProgressBar) view.findViewById(d.g.top_progressbar);
            aVar.jdv = (ProgressBar) view.findViewById(d.g.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.jds.setAutoChangeStyle(false);
        aVar.jdt.setAutoChangeStyle(false);
        aVar.jds.setGifIconSupport(false);
        aVar.jdt.setGifIconSupport(false);
        if (v.c(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.jdq.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.jdw.setVisibility(0);
                aVar.jds.setVisibility(8);
                aVar.jdw.setImageResource(d.f.icon_video_sticker_no);
            } else {
                aVar.jdw.setVisibility(8);
                aVar.jds.setVisibility(0);
                aVar.jds.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.jdq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.jdo != null) {
                        k.this.jdo.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.jdu.setVisibility(0);
            } else {
                aVar.jdu.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                al.k(aVar.jdq, d.f.bg_select_sticker);
            } else {
                aVar.jdq.setBackgroundResource(d.C0277d.transparent);
            }
        } else {
            aVar.jdq.setVisibility(8);
        }
        if (v.c(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.jdr.setVisibility(0);
            aVar.jdt.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.jdr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.jdo != null) {
                        k.this.jdo.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.jdv.setVisibility(0);
            } else {
                aVar.jdv.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                al.k(aVar.jdr, d.f.bg_select_sticker);
            } else {
                aVar.jdr.setBackgroundResource(d.C0277d.transparent);
            }
        } else {
            aVar.jdr.setVisibility(8);
        }
        return view;
    }

    public void M(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.jdo = aVar;
    }

    /* loaded from: classes5.dex */
    public class a {
        public RelativeLayout jdq;
        public RelativeLayout jdr;
        public TbImageView jds;
        public TbImageView jdt;
        public ProgressBar jdu;
        public ProgressBar jdv;
        public ImageView jdw;

        public a() {
        }
    }
}
