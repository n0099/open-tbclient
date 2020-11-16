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
/* loaded from: classes22.dex */
public class k extends BaseAdapter {
    private List<StickerItem> mDataList;
    private VideoEffectLayout.a nvy;

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ly */
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
            aVar.nvC = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.nvD = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.nvA = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.nvF = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.nvB = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.nvE = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.lPo = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.nvC.setAutoChangeStyle(false);
        aVar.nvD.setAutoChangeStyle(false);
        aVar.nvC.setGifIconSupport(false);
        aVar.nvD.setGifIconSupport(false);
        if (y.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.nvA.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.nvF.setVisibility(0);
                aVar.nvC.setVisibility(8);
                aVar.nvF.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.nvF.setVisibility(8);
                aVar.nvC.setVisibility(0);
                aVar.nvC.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.nvA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.nvy != null) {
                        k.this.nvy.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.nvE.setVisibility(0);
            } else {
                aVar.nvE.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                ap.setBackgroundResource(aVar.nvA, R.drawable.bg_select_sticker);
            } else {
                aVar.nvA.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.nvA.setVisibility(8);
        }
        if (y.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.nvB.setVisibility(0);
            aVar.nvD.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.nvB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.nvy != null) {
                        k.this.nvy.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.lPo.setVisibility(0);
            } else {
                aVar.lPo.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                ap.setBackgroundResource(aVar.nvB, R.drawable.bg_select_sticker);
            } else {
                aVar.nvB.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.nvB.setVisibility(8);
        }
        return view;
    }

    public void bi(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.nvy = aVar;
    }

    /* loaded from: classes22.dex */
    public class a {
        public ProgressBar lPo;
        public RelativeLayout nvA;
        public RelativeLayout nvB;
        public TbImageView nvC;
        public TbImageView nvD;
        public ProgressBar nvE;
        public ImageView nvF;

        public a() {
        }
    }
}
