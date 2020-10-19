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
    private VideoEffectLayout.a nbU;

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Kq */
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
            aVar.nbY = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.nbZ = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.nbW = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.ncb = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.nbX = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.nca = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.lwE = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.nbY.setAutoChangeStyle(false);
        aVar.nbZ.setAutoChangeStyle(false);
        aVar.nbY.setGifIconSupport(false);
        aVar.nbZ.setGifIconSupport(false);
        if (y.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.nbW.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.ncb.setVisibility(0);
                aVar.nbY.setVisibility(8);
                aVar.ncb.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.ncb.setVisibility(8);
                aVar.nbY.setVisibility(0);
                aVar.nbY.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.nbW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.nbU != null) {
                        k.this.nbU.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.nca.setVisibility(0);
            } else {
                aVar.nca.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                ap.setBackgroundResource(aVar.nbW, R.drawable.bg_select_sticker);
            } else {
                aVar.nbW.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.nbW.setVisibility(8);
        }
        if (y.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.nbX.setVisibility(0);
            aVar.nbZ.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.nbX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.nbU != null) {
                        k.this.nbU.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.lwE.setVisibility(0);
            } else {
                aVar.lwE.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                ap.setBackgroundResource(aVar.nbX, R.drawable.bg_select_sticker);
            } else {
                aVar.nbX.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.nbX.setVisibility(8);
        }
        return view;
    }

    public void aR(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.nbU = aVar;
    }

    /* loaded from: classes23.dex */
    public class a {
        public ProgressBar lwE;
        public RelativeLayout nbW;
        public RelativeLayout nbX;
        public TbImageView nbY;
        public TbImageView nbZ;
        public ProgressBar nca;
        public ImageView ncb;

        public a() {
        }
    }
}
