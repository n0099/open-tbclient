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
    private VideoEffectLayout.a hxj;
    private List<StickerItem> mDataList;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.E(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wX */
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
            aVar.hxn = (TbImageView) view.findViewById(d.g.top_sticker);
            aVar.hxo = (TbImageView) view.findViewById(d.g.bottom_sticker);
            aVar.hxl = (RelativeLayout) view.findViewById(d.g.top_container);
            aVar.hxr = (ImageView) view.findViewById(d.g.no_sticker);
            aVar.hxm = (RelativeLayout) view.findViewById(d.g.bottom_container);
            aVar.hxp = (ProgressBar) view.findViewById(d.g.top_progressbar);
            aVar.hxq = (ProgressBar) view.findViewById(d.g.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.hxn.setAutoChangeStyle(false);
        aVar.hxo.setAutoChangeStyle(false);
        aVar.hxn.setGifIconSupport(false);
        aVar.hxo.setGifIconSupport(false);
        if (v.f(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.hxl.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.hxr.setVisibility(0);
                aVar.hxn.setVisibility(8);
                aVar.hxr.setImageResource(d.f.icon_video_sticker_no);
            } else {
                aVar.hxr.setVisibility(8);
                aVar.hxn.setVisibility(0);
                aVar.hxn.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.hxl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.l.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) l.this.mDataList.get(i * 2)).isSelect && l.this.hxj != null) {
                        l.this.hxj.a((StickerItem) l.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.hxp.setVisibility(0);
            } else {
                aVar.hxp.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                aj.s(aVar.hxl, d.f.bg_select_sticker);
            } else {
                aVar.hxl.setBackgroundResource(d.C0140d.transparent);
            }
        } else {
            aVar.hxl.setVisibility(8);
        }
        if (v.f(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.hxm.setVisibility(0);
            aVar.hxo.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.hxm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.l.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) l.this.mDataList.get((i * 2) + 1)).isSelect && l.this.hxj != null) {
                        l.this.hxj.a((StickerItem) l.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.hxq.setVisibility(0);
            } else {
                aVar.hxq.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                aj.s(aVar.hxm, d.f.bg_select_sticker);
            } else {
                aVar.hxm.setBackgroundResource(d.C0140d.transparent);
            }
        } else {
            aVar.hxm.setVisibility(8);
        }
        return view;
    }

    public void A(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.hxj = aVar;
    }

    public void bEb() {
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
        public RelativeLayout hxl;
        public RelativeLayout hxm;
        public TbImageView hxn;
        public TbImageView hxo;
        public ProgressBar hxp;
        public ProgressBar hxq;
        public ImageView hxr;

        public a() {
        }
    }
}
