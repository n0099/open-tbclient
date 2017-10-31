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
public class k extends BaseAdapter {
    private VideoEffectLayout.a gKg;
    private List<StickerItem> mDataList;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.v(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uW */
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
            aVar.gKk = (TbImageView) view.findViewById(d.g.top_sticker);
            aVar.gKl = (TbImageView) view.findViewById(d.g.bottom_sticker);
            aVar.gKi = (RelativeLayout) view.findViewById(d.g.top_container);
            aVar.gKo = (ImageView) view.findViewById(d.g.no_sticker);
            aVar.gKj = (RelativeLayout) view.findViewById(d.g.bottom_container);
            aVar.gKm = (ProgressBar) view.findViewById(d.g.top_progressbar);
            aVar.gKn = (ProgressBar) view.findViewById(d.g.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.gKk.setAutoChangeStyle(false);
        aVar.gKl.setAutoChangeStyle(false);
        aVar.gKk.setGifIconSupport(false);
        aVar.gKl.setGifIconSupport(false);
        if (v.c(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.gKi.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.gKo.setVisibility(0);
                aVar.gKk.setVisibility(8);
                aVar.gKo.setImageResource(d.f.icon_video_sticker_no);
            } else {
                aVar.gKo.setVisibility(8);
                aVar.gKk.setVisibility(0);
                aVar.gKk.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.gKi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.gKg != null) {
                        k.this.gKg.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.gKm.setVisibility(0);
            } else {
                aVar.gKm.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                aj.j(aVar.gKi, d.f.bg_select_sticker);
            } else {
                aVar.gKi.setBackgroundResource(d.C0080d.transparent);
            }
        } else {
            aVar.gKi.setVisibility(8);
        }
        if (v.c(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.gKj.setVisibility(0);
            aVar.gKl.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.gKj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.gKg != null) {
                        k.this.gKg.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.gKn.setVisibility(0);
            } else {
                aVar.gKn.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                aj.j(aVar.gKj, d.f.bg_select_sticker);
            } else {
                aVar.gKj.setBackgroundResource(d.C0080d.transparent);
            }
        } else {
            aVar.gKj.setVisibility(8);
        }
        return view;
    }

    public void q(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.gKg = aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public RelativeLayout gKi;
        public RelativeLayout gKj;
        public TbImageView gKk;
        public TbImageView gKl;
        public ProgressBar gKm;
        public ProgressBar gKn;
        public ImageView gKo;

        public a() {
        }
    }
}
