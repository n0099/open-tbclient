package com.baidu.tieba.video.record;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes10.dex */
public class k extends BaseAdapter {
    private VideoEffectLayout.a kDm;
    private List<StickerItem> mDataList;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: DL */
    public StickerItem getItem(int i) {
        return (StickerItem) v.getItem(this.mDataList, i);
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
            aVar.kDq = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.kDr = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.kDo = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.kDt = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.kDp = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.kDs = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.jbn = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.kDq.setAutoChangeStyle(false);
        aVar.kDr.setAutoChangeStyle(false);
        aVar.kDq.setGifIconSupport(false);
        aVar.kDr.setGifIconSupport(false);
        if (v.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.kDo.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.kDt.setVisibility(0);
                aVar.kDq.setVisibility(8);
                aVar.kDt.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.kDt.setVisibility(8);
                aVar.kDq.setVisibility(0);
                aVar.kDq.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.kDo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.kDm != null) {
                        k.this.kDm.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.kDs.setVisibility(0);
            } else {
                aVar.kDs.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                am.setBackgroundResource(aVar.kDo, R.drawable.bg_select_sticker);
            } else {
                aVar.kDo.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.kDo.setVisibility(8);
        }
        if (v.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.kDp.setVisibility(0);
            aVar.kDr.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.kDp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.kDm != null) {
                        k.this.kDm.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.jbn.setVisibility(0);
            } else {
                aVar.jbn.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                am.setBackgroundResource(aVar.kDp, R.drawable.bg_select_sticker);
            } else {
                aVar.kDp.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.kDp.setVisibility(8);
        }
        return view;
    }

    public void av(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.kDm = aVar;
    }

    /* loaded from: classes10.dex */
    public class a {
        public ProgressBar jbn;
        public RelativeLayout kDo;
        public RelativeLayout kDp;
        public TbImageView kDq;
        public TbImageView kDr;
        public ProgressBar kDs;
        public ImageView kDt;

        public a() {
        }
    }
}
