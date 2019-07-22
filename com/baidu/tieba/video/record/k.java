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
/* loaded from: classes5.dex */
public class k extends BaseAdapter {
    private VideoEffectLayout.a jCk;
    private List<StickerItem> mDataList;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.aa(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ct */
    public StickerItem getItem(int i) {
        return (StickerItem) v.c(this.mDataList, i);
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
            aVar.jCo = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.jCp = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.jCm = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.jCs = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.jCn = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.jCq = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.jCr = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.jCo.setAutoChangeStyle(false);
        aVar.jCp.setAutoChangeStyle(false);
        aVar.jCo.setGifIconSupport(false);
        aVar.jCp.setGifIconSupport(false);
        if (v.c(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.jCm.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.jCs.setVisibility(0);
                aVar.jCo.setVisibility(8);
                aVar.jCs.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.jCs.setVisibility(8);
                aVar.jCo.setVisibility(0);
                aVar.jCo.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.jCm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.jCk != null) {
                        k.this.jCk.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.jCq.setVisibility(0);
            } else {
                aVar.jCq.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                am.k(aVar.jCm, R.drawable.bg_select_sticker);
            } else {
                aVar.jCm.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.jCm.setVisibility(8);
        }
        if (v.c(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.jCn.setVisibility(0);
            aVar.jCp.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.jCn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.jCk != null) {
                        k.this.jCk.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.jCr.setVisibility(0);
            } else {
                aVar.jCr.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                am.k(aVar.jCn, R.drawable.bg_select_sticker);
            } else {
                aVar.jCn.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.jCn.setVisibility(8);
        }
        return view;
    }

    public void T(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.jCk = aVar;
    }

    /* loaded from: classes5.dex */
    public class a {
        public RelativeLayout jCm;
        public RelativeLayout jCn;
        public TbImageView jCo;
        public TbImageView jCp;
        public ProgressBar jCq;
        public ProgressBar jCr;
        public ImageView jCs;

        public a() {
        }
    }
}
