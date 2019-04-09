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
    private VideoEffectLayout.a jdd;
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
    /* renamed from: AE */
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
            aVar.jdh = (TbImageView) view.findViewById(d.g.top_sticker);
            aVar.jdi = (TbImageView) view.findViewById(d.g.bottom_sticker);
            aVar.jdf = (RelativeLayout) view.findViewById(d.g.top_container);
            aVar.jdl = (ImageView) view.findViewById(d.g.no_sticker);
            aVar.jdg = (RelativeLayout) view.findViewById(d.g.bottom_container);
            aVar.jdj = (ProgressBar) view.findViewById(d.g.top_progressbar);
            aVar.jdk = (ProgressBar) view.findViewById(d.g.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.jdh.setAutoChangeStyle(false);
        aVar.jdi.setAutoChangeStyle(false);
        aVar.jdh.setGifIconSupport(false);
        aVar.jdi.setGifIconSupport(false);
        if (v.c(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.jdf.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.jdl.setVisibility(0);
                aVar.jdh.setVisibility(8);
                aVar.jdl.setImageResource(d.f.icon_video_sticker_no);
            } else {
                aVar.jdl.setVisibility(8);
                aVar.jdh.setVisibility(0);
                aVar.jdh.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.jdf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.jdd != null) {
                        k.this.jdd.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.jdj.setVisibility(0);
            } else {
                aVar.jdj.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                al.k(aVar.jdf, d.f.bg_select_sticker);
            } else {
                aVar.jdf.setBackgroundResource(d.C0277d.transparent);
            }
        } else {
            aVar.jdf.setVisibility(8);
        }
        if (v.c(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.jdg.setVisibility(0);
            aVar.jdi.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.jdg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.jdd != null) {
                        k.this.jdd.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.jdk.setVisibility(0);
            } else {
                aVar.jdk.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                al.k(aVar.jdg, d.f.bg_select_sticker);
            } else {
                aVar.jdg.setBackgroundResource(d.C0277d.transparent);
            }
        } else {
            aVar.jdg.setVisibility(8);
        }
        return view;
    }

    public void M(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.jdd = aVar;
    }

    /* loaded from: classes5.dex */
    public class a {
        public RelativeLayout jdf;
        public RelativeLayout jdg;
        public TbImageView jdh;
        public TbImageView jdi;
        public ProgressBar jdj;
        public ProgressBar jdk;
        public ImageView jdl;

        public a() {
        }
    }
}
