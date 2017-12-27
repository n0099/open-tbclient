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
    private VideoEffectLayout.a hFY;
    private List<StickerItem> mDataList;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.G(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: yw */
    public StickerItem getItem(int i) {
        return (StickerItem) v.f(this.mDataList, i);
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
            aVar.hGc = (TbImageView) view.findViewById(d.g.top_sticker);
            aVar.hGd = (TbImageView) view.findViewById(d.g.bottom_sticker);
            aVar.hGa = (RelativeLayout) view.findViewById(d.g.top_container);
            aVar.hGg = (ImageView) view.findViewById(d.g.no_sticker);
            aVar.hGb = (RelativeLayout) view.findViewById(d.g.bottom_container);
            aVar.hGe = (ProgressBar) view.findViewById(d.g.top_progressbar);
            aVar.hGf = (ProgressBar) view.findViewById(d.g.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.hGc.setAutoChangeStyle(false);
        aVar.hGd.setAutoChangeStyle(false);
        aVar.hGc.setGifIconSupport(false);
        aVar.hGd.setGifIconSupport(false);
        if (v.f(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.hGa.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.hGg.setVisibility(0);
                aVar.hGc.setVisibility(8);
                aVar.hGg.setImageResource(d.f.icon_video_sticker_no);
            } else {
                aVar.hGg.setVisibility(8);
                aVar.hGc.setVisibility(0);
                aVar.hGc.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.hGa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.l.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) l.this.mDataList.get(i * 2)).isSelect && l.this.hFY != null) {
                        l.this.hFY.a((StickerItem) l.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.hGe.setVisibility(0);
            } else {
                aVar.hGe.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                aj.s(aVar.hGa, d.f.bg_select_sticker);
            } else {
                aVar.hGa.setBackgroundResource(d.C0108d.transparent);
            }
        } else {
            aVar.hGa.setVisibility(8);
        }
        if (v.f(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.hGb.setVisibility(0);
            aVar.hGd.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.hGb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.l.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) l.this.mDataList.get((i * 2) + 1)).isSelect && l.this.hFY != null) {
                        l.this.hFY.a((StickerItem) l.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.hGf.setVisibility(0);
            } else {
                aVar.hGf.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                aj.s(aVar.hGb, d.f.bg_select_sticker);
            } else {
                aVar.hGb.setBackgroundResource(d.C0108d.transparent);
            }
        } else {
            aVar.hGb.setVisibility(8);
        }
        return view;
    }

    public void B(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.hFY = aVar;
    }

    public void bJU() {
        if (this.mDataList != null) {
            for (StickerItem stickerItem : this.mDataList) {
                if (stickerItem.id == -1) {
                    stickerItem.isSelect = true;
                } else {
                    stickerItem.isSelect = false;
                    stickerItem.isDownLoading = false;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public RelativeLayout hGa;
        public RelativeLayout hGb;
        public TbImageView hGc;
        public TbImageView hGd;
        public ProgressBar hGe;
        public ProgressBar hGf;
        public ImageView hGg;

        public a() {
        }
    }
}
