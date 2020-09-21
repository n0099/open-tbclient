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
    private VideoEffectLayout.a mMo;

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: JK */
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
            aVar.mMs = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.mMt = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.mMq = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.mMv = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.mMr = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.mMu = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.lhn = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.mMs.setAutoChangeStyle(false);
        aVar.mMt.setAutoChangeStyle(false);
        aVar.mMs.setGifIconSupport(false);
        aVar.mMt.setGifIconSupport(false);
        if (y.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.mMq.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.mMv.setVisibility(0);
                aVar.mMs.setVisibility(8);
                aVar.mMv.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.mMv.setVisibility(8);
                aVar.mMs.setVisibility(0);
                aVar.mMs.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.mMq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.mMo != null) {
                        k.this.mMo.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.mMu.setVisibility(0);
            } else {
                aVar.mMu.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                ap.setBackgroundResource(aVar.mMq, R.drawable.bg_select_sticker);
            } else {
                aVar.mMq.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.mMq.setVisibility(8);
        }
        if (y.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.mMr.setVisibility(0);
            aVar.mMt.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.mMr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.mMo != null) {
                        k.this.mMo.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.lhn.setVisibility(0);
            } else {
                aVar.lhn.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                ap.setBackgroundResource(aVar.mMr, R.drawable.bg_select_sticker);
            } else {
                aVar.mMr.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.mMr.setVisibility(8);
        }
        return view;
    }

    public void aO(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.mMo = aVar;
    }

    /* loaded from: classes22.dex */
    public class a {
        public ProgressBar lhn;
        public RelativeLayout mMq;
        public RelativeLayout mMr;
        public TbImageView mMs;
        public TbImageView mMt;
        public ProgressBar mMu;
        public ImageView mMv;

        public a() {
        }
    }
}
