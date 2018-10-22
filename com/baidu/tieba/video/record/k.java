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
    private VideoEffectLayout.a hzD;
    private List<StickerItem> mDataList;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.J(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vQ */
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
            aVar.hzH = (TbImageView) view.findViewById(e.g.top_sticker);
            aVar.hzI = (TbImageView) view.findViewById(e.g.bottom_sticker);
            aVar.hzF = (RelativeLayout) view.findViewById(e.g.top_container);
            aVar.hzL = (ImageView) view.findViewById(e.g.no_sticker);
            aVar.hzG = (RelativeLayout) view.findViewById(e.g.bottom_container);
            aVar.hzJ = (ProgressBar) view.findViewById(e.g.top_progressbar);
            aVar.hzK = (ProgressBar) view.findViewById(e.g.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.hzH.setAutoChangeStyle(false);
        aVar.hzI.setAutoChangeStyle(false);
        aVar.hzH.setGifIconSupport(false);
        aVar.hzI.setGifIconSupport(false);
        if (v.d(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.hzF.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.hzL.setVisibility(0);
                aVar.hzH.setVisibility(8);
                aVar.hzL.setImageResource(e.f.icon_video_sticker_no);
            } else {
                aVar.hzL.setVisibility(8);
                aVar.hzH.setVisibility(0);
                aVar.hzH.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.hzF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.hzD != null) {
                        k.this.hzD.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.hzJ.setVisibility(0);
            } else {
                aVar.hzJ.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                al.i(aVar.hzF, e.f.bg_select_sticker);
            } else {
                aVar.hzF.setBackgroundResource(e.d.transparent);
            }
        } else {
            aVar.hzF.setVisibility(8);
        }
        if (v.d(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.hzG.setVisibility(0);
            aVar.hzI.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.hzG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.hzD != null) {
                        k.this.hzD.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.hzK.setVisibility(0);
            } else {
                aVar.hzK.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                al.i(aVar.hzG, e.f.bg_select_sticker);
            } else {
                aVar.hzG.setBackgroundResource(e.d.transparent);
            }
        } else {
            aVar.hzG.setVisibility(8);
        }
        return view;
    }

    public void D(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.hzD = aVar;
    }

    /* loaded from: classes5.dex */
    public class a {
        public RelativeLayout hzF;
        public RelativeLayout hzG;
        public TbImageView hzH;
        public TbImageView hzI;
        public ProgressBar hzJ;
        public ProgressBar hzK;
        public ImageView hzL;

        public a() {
        }
    }
}
