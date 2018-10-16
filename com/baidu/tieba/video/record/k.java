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
    private VideoEffectLayout.a hzC;
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
            aVar.hzG = (TbImageView) view.findViewById(e.g.top_sticker);
            aVar.hzH = (TbImageView) view.findViewById(e.g.bottom_sticker);
            aVar.hzE = (RelativeLayout) view.findViewById(e.g.top_container);
            aVar.hzK = (ImageView) view.findViewById(e.g.no_sticker);
            aVar.hzF = (RelativeLayout) view.findViewById(e.g.bottom_container);
            aVar.hzI = (ProgressBar) view.findViewById(e.g.top_progressbar);
            aVar.hzJ = (ProgressBar) view.findViewById(e.g.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.hzG.setAutoChangeStyle(false);
        aVar.hzH.setAutoChangeStyle(false);
        aVar.hzG.setGifIconSupport(false);
        aVar.hzH.setGifIconSupport(false);
        if (v.d(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.hzE.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.hzK.setVisibility(0);
                aVar.hzG.setVisibility(8);
                aVar.hzK.setImageResource(e.f.icon_video_sticker_no);
            } else {
                aVar.hzK.setVisibility(8);
                aVar.hzG.setVisibility(0);
                aVar.hzG.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.hzE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.hzC != null) {
                        k.this.hzC.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.hzI.setVisibility(0);
            } else {
                aVar.hzI.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                al.i(aVar.hzE, e.f.bg_select_sticker);
            } else {
                aVar.hzE.setBackgroundResource(e.d.transparent);
            }
        } else {
            aVar.hzE.setVisibility(8);
        }
        if (v.d(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.hzF.setVisibility(0);
            aVar.hzH.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.hzF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.hzC != null) {
                        k.this.hzC.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.hzJ.setVisibility(0);
            } else {
                aVar.hzJ.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                al.i(aVar.hzF, e.f.bg_select_sticker);
            } else {
                aVar.hzF.setBackgroundResource(e.d.transparent);
            }
        } else {
            aVar.hzF.setVisibility(8);
        }
        return view;
    }

    public void D(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.hzC = aVar;
    }

    /* loaded from: classes5.dex */
    public class a {
        public RelativeLayout hzE;
        public RelativeLayout hzF;
        public TbImageView hzG;
        public TbImageView hzH;
        public ProgressBar hzI;
        public ProgressBar hzJ;
        public ImageView hzK;

        public a() {
        }
    }
}
