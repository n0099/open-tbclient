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
    private VideoEffectLayout.a nJB;

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
            aVar.nJF = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.nJG = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.nJD = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.nJI = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.nJE = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.nJH = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.mdu = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.nJF.setAutoChangeStyle(false);
        aVar.nJG.setAutoChangeStyle(false);
        aVar.nJF.setGifIconSupport(false);
        aVar.nJG.setGifIconSupport(false);
        if (y.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.nJD.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.nJI.setVisibility(0);
                aVar.nJF.setVisibility(8);
                aVar.nJI.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.nJI.setVisibility(8);
                aVar.nJF.setVisibility(0);
                aVar.nJF.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.nJD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.nJB != null) {
                        k.this.nJB.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.nJH.setVisibility(0);
            } else {
                aVar.nJH.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                ap.setBackgroundResource(aVar.nJD, R.drawable.bg_select_sticker);
            } else {
                aVar.nJD.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.nJD.setVisibility(8);
        }
        if (y.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.nJE.setVisibility(0);
            aVar.nJG.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.nJE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.nJB != null) {
                        k.this.nJB.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.mdu.setVisibility(0);
            } else {
                aVar.mdu.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                ap.setBackgroundResource(aVar.nJE, R.drawable.bg_select_sticker);
            } else {
                aVar.nJE.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.nJE.setVisibility(8);
        }
        return view;
    }

    public void bl(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.nJB = aVar;
    }

    /* loaded from: classes23.dex */
    public class a {
        public ProgressBar mdu;
        public RelativeLayout nJD;
        public RelativeLayout nJE;
        public TbImageView nJF;
        public TbImageView nJG;
        public ProgressBar nJH;
        public ImageView nJI;

        public a() {
        }
    }
}
