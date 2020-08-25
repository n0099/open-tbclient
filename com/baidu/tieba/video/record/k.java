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
/* loaded from: classes17.dex */
public class k extends BaseAdapter {
    private VideoEffectLayout.a mCh;
    private List<StickerItem> mDataList;

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Jg */
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
            aVar.mCl = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.mCm = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.mCj = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.mCo = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.mCk = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.mCn = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.kYA = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.mCl.setAutoChangeStyle(false);
        aVar.mCm.setAutoChangeStyle(false);
        aVar.mCl.setGifIconSupport(false);
        aVar.mCm.setGifIconSupport(false);
        if (y.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.mCj.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.mCo.setVisibility(0);
                aVar.mCl.setVisibility(8);
                aVar.mCo.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.mCo.setVisibility(8);
                aVar.mCl.setVisibility(0);
                aVar.mCl.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.mCj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.mCh != null) {
                        k.this.mCh.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.mCn.setVisibility(0);
            } else {
                aVar.mCn.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                ap.setBackgroundResource(aVar.mCj, R.drawable.bg_select_sticker);
            } else {
                aVar.mCj.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.mCj.setVisibility(8);
        }
        if (y.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.mCk.setVisibility(0);
            aVar.mCm.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.mCk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.mCh != null) {
                        k.this.mCh.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.kYA.setVisibility(0);
            } else {
                aVar.kYA.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                ap.setBackgroundResource(aVar.mCk, R.drawable.bg_select_sticker);
            } else {
                aVar.mCk.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.mCk.setVisibility(8);
        }
        return view;
    }

    public void aK(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.mCh = aVar;
    }

    /* loaded from: classes17.dex */
    public class a {
        public ProgressBar kYA;
        public RelativeLayout mCj;
        public RelativeLayout mCk;
        public TbImageView mCl;
        public TbImageView mCm;
        public ProgressBar mCn;
        public ImageView mCo;

        public a() {
        }
    }
}
