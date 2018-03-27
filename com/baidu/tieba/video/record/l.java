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
    private VideoEffectLayout.a hxu;
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
    /* renamed from: wY */
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
            aVar.hxy = (TbImageView) view.findViewById(d.g.top_sticker);
            aVar.hxz = (TbImageView) view.findViewById(d.g.bottom_sticker);
            aVar.hxw = (RelativeLayout) view.findViewById(d.g.top_container);
            aVar.hxC = (ImageView) view.findViewById(d.g.no_sticker);
            aVar.hxx = (RelativeLayout) view.findViewById(d.g.bottom_container);
            aVar.hxA = (ProgressBar) view.findViewById(d.g.top_progressbar);
            aVar.hxB = (ProgressBar) view.findViewById(d.g.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.hxy.setAutoChangeStyle(false);
        aVar.hxz.setAutoChangeStyle(false);
        aVar.hxy.setGifIconSupport(false);
        aVar.hxz.setGifIconSupport(false);
        if (v.f(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.hxw.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.hxC.setVisibility(0);
                aVar.hxy.setVisibility(8);
                aVar.hxC.setImageResource(d.f.icon_video_sticker_no);
            } else {
                aVar.hxC.setVisibility(8);
                aVar.hxy.setVisibility(0);
                aVar.hxy.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.hxw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.l.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) l.this.mDataList.get(i * 2)).isSelect && l.this.hxu != null) {
                        l.this.hxu.a((StickerItem) l.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.hxA.setVisibility(0);
            } else {
                aVar.hxA.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                aj.s(aVar.hxw, d.f.bg_select_sticker);
            } else {
                aVar.hxw.setBackgroundResource(d.C0141d.transparent);
            }
        } else {
            aVar.hxw.setVisibility(8);
        }
        if (v.f(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.hxx.setVisibility(0);
            aVar.hxz.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.hxx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.l.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) l.this.mDataList.get((i * 2) + 1)).isSelect && l.this.hxu != null) {
                        l.this.hxu.a((StickerItem) l.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.hxB.setVisibility(0);
            } else {
                aVar.hxB.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                aj.s(aVar.hxx, d.f.bg_select_sticker);
            } else {
                aVar.hxx.setBackgroundResource(d.C0141d.transparent);
            }
        } else {
            aVar.hxx.setVisibility(8);
        }
        return view;
    }

    public void A(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.hxu = aVar;
    }

    public void bEf() {
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
        public ProgressBar hxA;
        public ProgressBar hxB;
        public ImageView hxC;
        public RelativeLayout hxw;
        public RelativeLayout hxx;
        public TbImageView hxy;
        public TbImageView hxz;

        public a() {
        }
    }
}
