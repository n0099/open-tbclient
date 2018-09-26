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
import com.baidu.tieba.e;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes2.dex */
public class k extends BaseAdapter {
    private VideoEffectLayout.a hsp;
    private List<StickerItem> mDataList;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.z(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vt */
    public StickerItem getItem(int i) {
        return (StickerItem) v.d(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.list_item_sticker, (ViewGroup) null);
            aVar = new a();
            aVar.hst = (TbImageView) view.findViewById(e.g.top_sticker);
            aVar.hsu = (TbImageView) view.findViewById(e.g.bottom_sticker);
            aVar.hsr = (RelativeLayout) view.findViewById(e.g.top_container);
            aVar.hsx = (ImageView) view.findViewById(e.g.no_sticker);
            aVar.hss = (RelativeLayout) view.findViewById(e.g.bottom_container);
            aVar.hsv = (ProgressBar) view.findViewById(e.g.top_progressbar);
            aVar.hsw = (ProgressBar) view.findViewById(e.g.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.hst.setAutoChangeStyle(false);
        aVar.hsu.setAutoChangeStyle(false);
        aVar.hst.setGifIconSupport(false);
        aVar.hsu.setGifIconSupport(false);
        if (v.d(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.hsr.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.hsx.setVisibility(0);
                aVar.hst.setVisibility(8);
                aVar.hsx.setImageResource(e.f.icon_video_sticker_no);
            } else {
                aVar.hsx.setVisibility(8);
                aVar.hst.setVisibility(0);
                aVar.hst.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.hsr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.hsp != null) {
                        k.this.hsp.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.hsv.setVisibility(0);
            } else {
                aVar.hsv.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                al.i(aVar.hsr, e.f.bg_select_sticker);
            } else {
                aVar.hsr.setBackgroundResource(e.d.transparent);
            }
        } else {
            aVar.hsr.setVisibility(8);
        }
        if (v.d(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.hss.setVisibility(0);
            aVar.hsu.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.hss.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.hsp != null) {
                        k.this.hsp.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.hsw.setVisibility(0);
            } else {
                aVar.hsw.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                al.i(aVar.hss, e.f.bg_select_sticker);
            } else {
                aVar.hss.setBackgroundResource(e.d.transparent);
            }
        } else {
            aVar.hss.setVisibility(8);
        }
        return view;
    }

    public void t(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.hsp = aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public RelativeLayout hsr;
        public RelativeLayout hss;
        public TbImageView hst;
        public TbImageView hsu;
        public ProgressBar hsv;
        public ProgressBar hsw;
        public ImageView hsx;

        public a() {
        }
    }
}
