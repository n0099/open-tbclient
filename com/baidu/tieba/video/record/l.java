package com.baidu.tieba.video.record;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes2.dex */
public class l extends BaseAdapter {
    private VideoEffectLayout.a gWe;
    private List<StickerItem> mDataList;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.w(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vu */
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
            aVar.gWi = (TbImageView) view.findViewById(d.g.top_sticker);
            aVar.gWj = (TbImageView) view.findViewById(d.g.bottom_sticker);
            aVar.gWg = (RelativeLayout) view.findViewById(d.g.top_container);
            aVar.gWm = (ImageView) view.findViewById(d.g.no_sticker);
            aVar.gWh = (RelativeLayout) view.findViewById(d.g.bottom_container);
            aVar.gWk = (ProgressBar) view.findViewById(d.g.top_progressbar);
            aVar.gWl = (ProgressBar) view.findViewById(d.g.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.gWi.setAutoChangeStyle(false);
        aVar.gWj.setAutoChangeStyle(false);
        aVar.gWi.setGifIconSupport(false);
        aVar.gWj.setGifIconSupport(false);
        if (v.c(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.gWg.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.gWm.setVisibility(0);
                aVar.gWi.setVisibility(8);
                aVar.gWm.setImageResource(d.f.icon_video_sticker_no);
            } else {
                aVar.gWm.setVisibility(8);
                aVar.gWi.setVisibility(0);
                aVar.gWi.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.gWg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.l.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) l.this.mDataList.get(i * 2)).isSelect && l.this.gWe != null) {
                        l.this.gWe.a((StickerItem) l.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.gWk.setVisibility(0);
            } else {
                aVar.gWk.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                aj.j(aVar.gWg, d.f.bg_select_sticker);
            } else {
                aVar.gWg.setBackgroundResource(d.C0082d.transparent);
            }
        } else {
            aVar.gWg.setVisibility(8);
        }
        if (v.c(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.gWh.setVisibility(0);
            aVar.gWj.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.gWh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.l.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) l.this.mDataList.get((i * 2) + 1)).isSelect && l.this.gWe != null) {
                        l.this.gWe.a((StickerItem) l.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.gWl.setVisibility(0);
            } else {
                aVar.gWl.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                aj.j(aVar.gWh, d.f.bg_select_sticker);
            } else {
                aVar.gWh.setBackgroundResource(d.C0082d.transparent);
            }
        } else {
            aVar.gWh.setVisibility(8);
        }
        return view;
    }

    public void r(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.gWe = aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public RelativeLayout gWg;
        public RelativeLayout gWh;
        public TbImageView gWi;
        public TbImageView gWj;
        public ProgressBar gWk;
        public ProgressBar gWl;
        public ImageView gWm;

        public a() {
        }
    }
}
