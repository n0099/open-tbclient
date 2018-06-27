package com.baidu.tieba.video.record;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes2.dex */
public class k extends BaseAdapter {
    private VideoEffectLayout.a hjl;
    private List<StickerItem> mDataList;

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.A(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uU */
    public StickerItem getItem(int i) {
        return (StickerItem) w.d(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.list_item_sticker, (ViewGroup) null);
            aVar = new a();
            aVar.hjp = (TbImageView) view.findViewById(d.g.top_sticker);
            aVar.hjq = (TbImageView) view.findViewById(d.g.bottom_sticker);
            aVar.hjn = (RelativeLayout) view.findViewById(d.g.top_container);
            aVar.hjt = (ImageView) view.findViewById(d.g.no_sticker);
            aVar.hjo = (RelativeLayout) view.findViewById(d.g.bottom_container);
            aVar.hjr = (ProgressBar) view.findViewById(d.g.top_progressbar);
            aVar.hjs = (ProgressBar) view.findViewById(d.g.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.hjp.setAutoChangeStyle(false);
        aVar.hjq.setAutoChangeStyle(false);
        aVar.hjp.setGifIconSupport(false);
        aVar.hjq.setGifIconSupport(false);
        if (w.d(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.hjn.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.hjt.setVisibility(0);
                aVar.hjp.setVisibility(8);
                aVar.hjt.setImageResource(d.f.icon_video_sticker_no);
            } else {
                aVar.hjt.setVisibility(8);
                aVar.hjp.setVisibility(0);
                aVar.hjp.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.hjn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.hjl != null) {
                        k.this.hjl.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.hjr.setVisibility(0);
            } else {
                aVar.hjr.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                am.i(aVar.hjn, d.f.bg_select_sticker);
            } else {
                aVar.hjn.setBackgroundResource(d.C0142d.transparent);
            }
        } else {
            aVar.hjn.setVisibility(8);
        }
        if (w.d(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.hjo.setVisibility(0);
            aVar.hjq.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.hjo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.hjl != null) {
                        k.this.hjl.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.hjs.setVisibility(0);
            } else {
                aVar.hjs.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                am.i(aVar.hjo, d.f.bg_select_sticker);
            } else {
                aVar.hjo.setBackgroundResource(d.C0142d.transparent);
            }
        } else {
            aVar.hjo.setVisibility(8);
        }
        return view;
    }

    public void u(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.hjl = aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public RelativeLayout hjn;
        public RelativeLayout hjo;
        public TbImageView hjp;
        public TbImageView hjq;
        public ProgressBar hjr;
        public ProgressBar hjs;
        public ImageView hjt;

        public a() {
        }
    }
}
