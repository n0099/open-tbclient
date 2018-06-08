package com.baidu.tieba.video.record;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes2.dex */
public class k extends BaseAdapter {
    private VideoEffectLayout.a hfe;
    private List<StickerItem> mDataList;

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.z(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uM */
    public StickerItem getItem(int i) {
        return (StickerItem) w.c(this.mDataList, i);
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
            aVar.hfi = (TbImageView) view.findViewById(d.g.top_sticker);
            aVar.hfj = (TbImageView) view.findViewById(d.g.bottom_sticker);
            aVar.hfg = (RelativeLayout) view.findViewById(d.g.top_container);
            aVar.hfm = (ImageView) view.findViewById(d.g.no_sticker);
            aVar.hfh = (RelativeLayout) view.findViewById(d.g.bottom_container);
            aVar.hfk = (ProgressBar) view.findViewById(d.g.top_progressbar);
            aVar.hfl = (ProgressBar) view.findViewById(d.g.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.hfi.setAutoChangeStyle(false);
        aVar.hfj.setAutoChangeStyle(false);
        aVar.hfi.setGifIconSupport(false);
        aVar.hfj.setGifIconSupport(false);
        if (w.c(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.hfg.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.hfm.setVisibility(0);
                aVar.hfi.setVisibility(8);
                aVar.hfm.setImageResource(d.f.icon_video_sticker_no);
            } else {
                aVar.hfm.setVisibility(8);
                aVar.hfi.setVisibility(0);
                aVar.hfi.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.hfg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.hfe != null) {
                        k.this.hfe.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.hfk.setVisibility(0);
            } else {
                aVar.hfk.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                al.i(aVar.hfg, d.f.bg_select_sticker);
            } else {
                aVar.hfg.setBackgroundResource(d.C0141d.transparent);
            }
        } else {
            aVar.hfg.setVisibility(8);
        }
        if (w.c(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.hfh.setVisibility(0);
            aVar.hfj.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.hfh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.hfe != null) {
                        k.this.hfe.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.hfl.setVisibility(0);
            } else {
                aVar.hfl.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                al.i(aVar.hfh, d.f.bg_select_sticker);
            } else {
                aVar.hfh.setBackgroundResource(d.C0141d.transparent);
            }
        } else {
            aVar.hfh.setVisibility(8);
        }
        return view;
    }

    public void t(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.hfe = aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public RelativeLayout hfg;
        public RelativeLayout hfh;
        public TbImageView hfi;
        public TbImageView hfj;
        public ProgressBar hfk;
        public ProgressBar hfl;
        public ImageView hfm;

        public a() {
        }
    }
}
