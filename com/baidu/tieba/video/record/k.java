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
    private VideoEffectLayout.a gLo;
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
    /* renamed from: va */
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
            aVar.gLs = (TbImageView) view.findViewById(d.g.top_sticker);
            aVar.gLt = (TbImageView) view.findViewById(d.g.bottom_sticker);
            aVar.gLq = (RelativeLayout) view.findViewById(d.g.top_container);
            aVar.gLw = (ImageView) view.findViewById(d.g.no_sticker);
            aVar.gLr = (RelativeLayout) view.findViewById(d.g.bottom_container);
            aVar.gLu = (ProgressBar) view.findViewById(d.g.top_progressbar);
            aVar.gLv = (ProgressBar) view.findViewById(d.g.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.gLs.setAutoChangeStyle(false);
        aVar.gLt.setAutoChangeStyle(false);
        aVar.gLs.setGifIconSupport(false);
        aVar.gLt.setGifIconSupport(false);
        if (v.c(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.gLq.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.gLw.setVisibility(0);
                aVar.gLs.setVisibility(8);
                aVar.gLw.setImageResource(d.f.icon_video_sticker_no);
            } else {
                aVar.gLw.setVisibility(8);
                aVar.gLs.setVisibility(0);
                aVar.gLs.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.gLq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.gLo != null) {
                        k.this.gLo.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.gLu.setVisibility(0);
            } else {
                aVar.gLu.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                aj.j(aVar.gLq, d.f.bg_select_sticker);
            } else {
                aVar.gLq.setBackgroundResource(d.C0080d.transparent);
            }
        } else {
            aVar.gLq.setVisibility(8);
        }
        if (v.c(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.gLr.setVisibility(0);
            aVar.gLt.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.gLr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.gLo != null) {
                        k.this.gLo.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.gLv.setVisibility(0);
            } else {
                aVar.gLv.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                aj.j(aVar.gLr, d.f.bg_select_sticker);
            } else {
                aVar.gLr.setBackgroundResource(d.C0080d.transparent);
            }
        } else {
            aVar.gLr.setVisibility(8);
        }
        return view;
    }

    public void q(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.gLo = aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public RelativeLayout gLq;
        public RelativeLayout gLr;
        public TbImageView gLs;
        public TbImageView gLt;
        public ProgressBar gLu;
        public ProgressBar gLv;
        public ImageView gLw;

        public a() {
        }
    }
}
