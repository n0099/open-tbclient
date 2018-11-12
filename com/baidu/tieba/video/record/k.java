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
/* loaded from: classes5.dex */
public class k extends BaseAdapter {
    private VideoEffectLayout.a hBn;
    private List<StickerItem> mDataList;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.I(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wj */
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
            aVar.hBr = (TbImageView) view.findViewById(e.g.top_sticker);
            aVar.hBs = (TbImageView) view.findViewById(e.g.bottom_sticker);
            aVar.hBp = (RelativeLayout) view.findViewById(e.g.top_container);
            aVar.hBv = (ImageView) view.findViewById(e.g.no_sticker);
            aVar.hBq = (RelativeLayout) view.findViewById(e.g.bottom_container);
            aVar.hBt = (ProgressBar) view.findViewById(e.g.top_progressbar);
            aVar.hBu = (ProgressBar) view.findViewById(e.g.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.hBr.setAutoChangeStyle(false);
        aVar.hBs.setAutoChangeStyle(false);
        aVar.hBr.setGifIconSupport(false);
        aVar.hBs.setGifIconSupport(false);
        if (v.d(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.hBp.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.hBv.setVisibility(0);
                aVar.hBr.setVisibility(8);
                aVar.hBv.setImageResource(e.f.icon_video_sticker_no);
            } else {
                aVar.hBv.setVisibility(8);
                aVar.hBr.setVisibility(0);
                aVar.hBr.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.hBp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.hBn != null) {
                        k.this.hBn.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.hBt.setVisibility(0);
            } else {
                aVar.hBt.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                al.i(aVar.hBp, e.f.bg_select_sticker);
            } else {
                aVar.hBp.setBackgroundResource(e.d.transparent);
            }
        } else {
            aVar.hBp.setVisibility(8);
        }
        if (v.d(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.hBq.setVisibility(0);
            aVar.hBs.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.hBq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.hBn != null) {
                        k.this.hBn.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.hBu.setVisibility(0);
            } else {
                aVar.hBu.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                al.i(aVar.hBq, e.f.bg_select_sticker);
            } else {
                aVar.hBq.setBackgroundResource(e.d.transparent);
            }
        } else {
            aVar.hBq.setVisibility(8);
        }
        return view;
    }

    public void C(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.hBn = aVar;
    }

    /* loaded from: classes5.dex */
    public class a {
        public RelativeLayout hBp;
        public RelativeLayout hBq;
        public TbImageView hBr;
        public TbImageView hBs;
        public ProgressBar hBt;
        public ProgressBar hBu;
        public ImageView hBv;

        public a() {
        }
    }
}
