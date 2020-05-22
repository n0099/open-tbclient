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
    private VideoEffectLayout.a lIe;
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
    /* renamed from: Fi */
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
            aVar.lIi = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.lIj = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.lIg = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.lIl = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.lIh = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.lIk = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.keP = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.lIi.setAutoChangeStyle(false);
        aVar.lIj.setAutoChangeStyle(false);
        aVar.lIi.setGifIconSupport(false);
        aVar.lIj.setGifIconSupport(false);
        if (v.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.lIg.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.lIl.setVisibility(0);
                aVar.lIi.setVisibility(8);
                aVar.lIl.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.lIl.setVisibility(8);
                aVar.lIi.setVisibility(0);
                aVar.lIi.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.lIg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.lIe != null) {
                        k.this.lIe.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.lIk.setVisibility(0);
            } else {
                aVar.lIk.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                am.setBackgroundResource(aVar.lIg, R.drawable.bg_select_sticker);
            } else {
                aVar.lIg.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.lIg.setVisibility(8);
        }
        if (v.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.lIh.setVisibility(0);
            aVar.lIj.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.lIh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.lIe != null) {
                        k.this.lIe.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.keP.setVisibility(0);
            } else {
                aVar.keP.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                am.setBackgroundResource(aVar.lIh, R.drawable.bg_select_sticker);
            } else {
                aVar.lIh.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.lIh.setVisibility(8);
        }
        return view;
    }

    public void az(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.lIe = aVar;
    }

    /* loaded from: classes10.dex */
    public class a {
        public ProgressBar keP;
        public RelativeLayout lIg;
        public RelativeLayout lIh;
        public TbImageView lIi;
        public TbImageView lIj;
        public ProgressBar lIk;
        public ImageView lIl;

        public a() {
        }
    }
}
