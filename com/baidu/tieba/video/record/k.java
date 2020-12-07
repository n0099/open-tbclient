package com.baidu.tieba.video.record;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes23.dex */
public class k extends BaseAdapter {
    private List<StickerItem> mDataList;
    private VideoEffectLayout.a nJz;

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Mq */
    public StickerItem getItem(int i) {
        return (StickerItem) y.getItem(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_sticker, (ViewGroup) null);
            aVar = new a();
            aVar.nJD = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.nJE = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.nJB = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.nJG = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.nJC = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.nJF = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.mds = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.nJD.setAutoChangeStyle(false);
        aVar.nJE.setAutoChangeStyle(false);
        aVar.nJD.setGifIconSupport(false);
        aVar.nJE.setGifIconSupport(false);
        if (y.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.nJB.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.nJG.setVisibility(0);
                aVar.nJD.setVisibility(8);
                aVar.nJG.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.nJG.setVisibility(8);
                aVar.nJD.setVisibility(0);
                aVar.nJD.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.nJB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.nJz != null) {
                        k.this.nJz.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.nJF.setVisibility(0);
            } else {
                aVar.nJF.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                ap.setBackgroundResource(aVar.nJB, R.drawable.bg_select_sticker);
            } else {
                aVar.nJB.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.nJB.setVisibility(8);
        }
        if (y.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.nJC.setVisibility(0);
            aVar.nJE.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.nJC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.nJz != null) {
                        k.this.nJz.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.mds.setVisibility(0);
            } else {
                aVar.mds.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                ap.setBackgroundResource(aVar.nJC, R.drawable.bg_select_sticker);
            } else {
                aVar.nJC.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.nJC.setVisibility(8);
        }
        return view;
    }

    public void bl(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.nJz = aVar;
    }

    /* loaded from: classes23.dex */
    public class a {
        public ProgressBar mds;
        public RelativeLayout nJB;
        public RelativeLayout nJC;
        public TbImageView nJD;
        public TbImageView nJE;
        public ProgressBar nJF;
        public ImageView nJG;

        public a() {
        }
    }
}
