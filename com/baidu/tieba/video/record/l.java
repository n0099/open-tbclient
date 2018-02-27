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
    private VideoEffectLayout.a hwW;
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
            aVar.hxa = (TbImageView) view.findViewById(d.g.top_sticker);
            aVar.hxb = (TbImageView) view.findViewById(d.g.bottom_sticker);
            aVar.hwY = (RelativeLayout) view.findViewById(d.g.top_container);
            aVar.hxe = (ImageView) view.findViewById(d.g.no_sticker);
            aVar.hwZ = (RelativeLayout) view.findViewById(d.g.bottom_container);
            aVar.hxc = (ProgressBar) view.findViewById(d.g.top_progressbar);
            aVar.hxd = (ProgressBar) view.findViewById(d.g.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.hxa.setAutoChangeStyle(false);
        aVar.hxb.setAutoChangeStyle(false);
        aVar.hxa.setGifIconSupport(false);
        aVar.hxb.setGifIconSupport(false);
        if (v.f(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.hwY.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.hxe.setVisibility(0);
                aVar.hxa.setVisibility(8);
                aVar.hxe.setImageResource(d.f.icon_video_sticker_no);
            } else {
                aVar.hxe.setVisibility(8);
                aVar.hxa.setVisibility(0);
                aVar.hxa.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.hwY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.l.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) l.this.mDataList.get(i * 2)).isSelect && l.this.hwW != null) {
                        l.this.hwW.a((StickerItem) l.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.hxc.setVisibility(0);
            } else {
                aVar.hxc.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                aj.s(aVar.hwY, d.f.bg_select_sticker);
            } else {
                aVar.hwY.setBackgroundResource(d.C0141d.transparent);
            }
        } else {
            aVar.hwY.setVisibility(8);
        }
        if (v.f(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.hwZ.setVisibility(0);
            aVar.hxb.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.hwZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.l.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) l.this.mDataList.get((i * 2) + 1)).isSelect && l.this.hwW != null) {
                        l.this.hwW.a((StickerItem) l.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.hxd.setVisibility(0);
            } else {
                aVar.hxd.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                aj.s(aVar.hwZ, d.f.bg_select_sticker);
            } else {
                aVar.hwZ.setBackgroundResource(d.C0141d.transparent);
            }
        } else {
            aVar.hwZ.setVisibility(8);
        }
        return view;
    }

    public void A(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.hwW = aVar;
    }

    public void bEa() {
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
        public RelativeLayout hwY;
        public RelativeLayout hwZ;
        public TbImageView hxa;
        public TbImageView hxb;
        public ProgressBar hxc;
        public ProgressBar hxd;
        public ImageView hxe;

        public a() {
        }
    }
}
