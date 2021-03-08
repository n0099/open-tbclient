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
/* loaded from: classes7.dex */
public class k extends BaseAdapter {
    private List<StickerItem> mDataList;
    private VideoEffectLayout.a nUD;

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: KV */
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
            aVar.nUH = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.nUI = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.nUF = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.nUK = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.nUG = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.nUJ = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.mpv = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.nUH.setAutoChangeStyle(false);
        aVar.nUI.setAutoChangeStyle(false);
        aVar.nUH.setGifIconSupport(false);
        aVar.nUI.setGifIconSupport(false);
        if (y.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.nUF.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.nUK.setVisibility(0);
                aVar.nUH.setVisibility(8);
                aVar.nUK.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.nUK.setVisibility(8);
                aVar.nUH.setVisibility(0);
                aVar.nUH.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.nUF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.nUD != null) {
                        k.this.nUD.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.nUJ.setVisibility(0);
            } else {
                aVar.nUJ.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                ap.setBackgroundResource(aVar.nUF, R.drawable.bg_select_sticker);
            } else {
                aVar.nUF.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.nUF.setVisibility(8);
        }
        if (y.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.nUG.setVisibility(0);
            aVar.nUI.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.nUG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.nUD != null) {
                        k.this.nUD.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.mpv.setVisibility(0);
            } else {
                aVar.mpv.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                ap.setBackgroundResource(aVar.nUG, R.drawable.bg_select_sticker);
            } else {
                aVar.nUG.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.nUG.setVisibility(8);
        }
        return view;
    }

    public void bn(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.nUD = aVar;
    }

    /* loaded from: classes7.dex */
    public class a {
        public ProgressBar mpv;
        public RelativeLayout nUF;
        public RelativeLayout nUG;
        public TbImageView nUH;
        public TbImageView nUI;
        public ProgressBar nUJ;
        public ImageView nUK;

        public a() {
        }
    }
}
