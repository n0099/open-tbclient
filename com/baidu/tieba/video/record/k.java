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
    private VideoEffectLayout.a hIz;
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
    /* renamed from: wG */
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
            aVar.hID = (TbImageView) view.findViewById(e.g.top_sticker);
            aVar.hIE = (TbImageView) view.findViewById(e.g.bottom_sticker);
            aVar.hIB = (RelativeLayout) view.findViewById(e.g.top_container);
            aVar.hIH = (ImageView) view.findViewById(e.g.no_sticker);
            aVar.hIC = (RelativeLayout) view.findViewById(e.g.bottom_container);
            aVar.hIF = (ProgressBar) view.findViewById(e.g.top_progressbar);
            aVar.hIG = (ProgressBar) view.findViewById(e.g.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.hID.setAutoChangeStyle(false);
        aVar.hIE.setAutoChangeStyle(false);
        aVar.hID.setGifIconSupport(false);
        aVar.hIE.setGifIconSupport(false);
        if (v.d(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.hIB.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.hIH.setVisibility(0);
                aVar.hID.setVisibility(8);
                aVar.hIH.setImageResource(e.f.icon_video_sticker_no);
            } else {
                aVar.hIH.setVisibility(8);
                aVar.hID.setVisibility(0);
                aVar.hID.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.hIB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.hIz != null) {
                        k.this.hIz.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.hIF.setVisibility(0);
            } else {
                aVar.hIF.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                al.i(aVar.hIB, e.f.bg_select_sticker);
            } else {
                aVar.hIB.setBackgroundResource(e.d.transparent);
            }
        } else {
            aVar.hIB.setVisibility(8);
        }
        if (v.d(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.hIC.setVisibility(0);
            aVar.hIE.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.hIC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.hIz != null) {
                        k.this.hIz.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.hIG.setVisibility(0);
            } else {
                aVar.hIG.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                al.i(aVar.hIC, e.f.bg_select_sticker);
            } else {
                aVar.hIC.setBackgroundResource(e.d.transparent);
            }
        } else {
            aVar.hIC.setVisibility(8);
        }
        return view;
    }

    public void C(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.hIz = aVar;
    }

    /* loaded from: classes5.dex */
    public class a {
        public RelativeLayout hIB;
        public RelativeLayout hIC;
        public TbImageView hID;
        public TbImageView hIE;
        public ProgressBar hIF;
        public ProgressBar hIG;
        public ImageView hIH;

        public a() {
        }
    }
}
