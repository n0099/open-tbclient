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
public class j extends BaseAdapter {
    private VideoEffectLayout.a gAt;
    private List<StickerItem> mDataList;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.u(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uE */
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.j.list_item_sticker, (ViewGroup) null);
            aVar = new a();
            aVar.gAx = (TbImageView) view.findViewById(d.h.top_sticker);
            aVar.gAy = (TbImageView) view.findViewById(d.h.bottom_sticker);
            aVar.gAv = (RelativeLayout) view.findViewById(d.h.top_container);
            aVar.gAB = (ImageView) view.findViewById(d.h.no_sticker);
            aVar.gAw = (RelativeLayout) view.findViewById(d.h.bottom_container);
            aVar.gAz = (ProgressBar) view.findViewById(d.h.top_progressbar);
            aVar.gAA = (ProgressBar) view.findViewById(d.h.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.gAx.setAutoChangeStyle(false);
        aVar.gAy.setAutoChangeStyle(false);
        aVar.gAx.setGifIconSupport(false);
        aVar.gAy.setGifIconSupport(false);
        if (v.c(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.gAv.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.gAB.setVisibility(0);
                aVar.gAx.setVisibility(8);
                aVar.gAB.setImageResource(d.g.icon_video_sticker_no);
            } else {
                aVar.gAB.setVisibility(8);
                aVar.gAx.setVisibility(0);
                aVar.gAx.c(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.gAv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.j.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) j.this.mDataList.get(i * 2)).isSelect && j.this.gAt != null) {
                        j.this.gAt.a((StickerItem) j.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.gAz.setVisibility(0);
            } else {
                aVar.gAz.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                aj.j(aVar.gAv, d.g.bg_select_sticker);
            } else {
                aVar.gAv.setBackgroundResource(d.e.transparent);
            }
        } else {
            aVar.gAv.setVisibility(8);
        }
        if (v.c(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.gAw.setVisibility(0);
            aVar.gAy.c(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.gAw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) j.this.mDataList.get((i * 2) + 1)).isSelect && j.this.gAt != null) {
                        j.this.gAt.a((StickerItem) j.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.gAA.setVisibility(0);
            } else {
                aVar.gAA.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                aj.j(aVar.gAw, d.g.bg_select_sticker);
            } else {
                aVar.gAw.setBackgroundResource(d.e.transparent);
            }
        } else {
            aVar.gAw.setVisibility(8);
        }
        return view;
    }

    public void p(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.gAt = aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public ProgressBar gAA;
        public ImageView gAB;
        public RelativeLayout gAv;
        public RelativeLayout gAw;
        public TbImageView gAx;
        public TbImageView gAy;
        public ProgressBar gAz;

        public a() {
        }
    }
}
