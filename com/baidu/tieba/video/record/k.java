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
    private VideoEffectLayout.a lJm;
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
    /* renamed from: Fk */
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
            aVar.lJq = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.lJr = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.lJo = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.lJt = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.lJp = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.lJs = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.kfV = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.lJq.setAutoChangeStyle(false);
        aVar.lJr.setAutoChangeStyle(false);
        aVar.lJq.setGifIconSupport(false);
        aVar.lJr.setGifIconSupport(false);
        if (v.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.lJo.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.lJt.setVisibility(0);
                aVar.lJq.setVisibility(8);
                aVar.lJt.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.lJt.setVisibility(8);
                aVar.lJq.setVisibility(0);
                aVar.lJq.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.lJo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.lJm != null) {
                        k.this.lJm.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.lJs.setVisibility(0);
            } else {
                aVar.lJs.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                am.setBackgroundResource(aVar.lJo, R.drawable.bg_select_sticker);
            } else {
                aVar.lJo.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.lJo.setVisibility(8);
        }
        if (v.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.lJp.setVisibility(0);
            aVar.lJr.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.lJp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.lJm != null) {
                        k.this.lJm.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.kfV.setVisibility(0);
            } else {
                aVar.kfV.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                am.setBackgroundResource(aVar.lJp, R.drawable.bg_select_sticker);
            } else {
                aVar.lJp.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.lJp.setVisibility(8);
        }
        return view;
    }

    public void az(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.lJm = aVar;
    }

    /* loaded from: classes10.dex */
    public class a {
        public ProgressBar kfV;
        public RelativeLayout lJo;
        public RelativeLayout lJp;
        public TbImageView lJq;
        public TbImageView lJr;
        public ProgressBar lJs;
        public ImageView lJt;

        public a() {
        }
    }
}
