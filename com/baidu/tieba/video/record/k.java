package com.baidu.tieba.video.record;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes5.dex */
public class k extends BaseAdapter {
    private VideoEffectLayout.a jwb;
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
    /* renamed from: BM */
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
            aVar.jwf = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.jwg = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.jwd = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.jwj = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.jwe = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.jwh = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.jwi = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.jwf.setAutoChangeStyle(false);
        aVar.jwg.setAutoChangeStyle(false);
        aVar.jwf.setGifIconSupport(false);
        aVar.jwg.setGifIconSupport(false);
        if (v.c(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.jwd.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.jwj.setVisibility(0);
                aVar.jwf.setVisibility(8);
                aVar.jwj.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.jwj.setVisibility(8);
                aVar.jwf.setVisibility(0);
                aVar.jwf.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.jwd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.jwb != null) {
                        k.this.jwb.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.jwh.setVisibility(0);
            } else {
                aVar.jwh.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                al.k(aVar.jwd, R.drawable.bg_select_sticker);
            } else {
                aVar.jwd.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.jwd.setVisibility(8);
        }
        if (v.c(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.jwe.setVisibility(0);
            aVar.jwg.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.jwe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.jwb != null) {
                        k.this.jwb.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.jwi.setVisibility(0);
            } else {
                aVar.jwi.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                al.k(aVar.jwe, R.drawable.bg_select_sticker);
            } else {
                aVar.jwe.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.jwe.setVisibility(8);
        }
        return view;
    }

    public void T(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.jwb = aVar;
    }

    /* loaded from: classes5.dex */
    public class a {
        public RelativeLayout jwd;
        public RelativeLayout jwe;
        public TbImageView jwf;
        public TbImageView jwg;
        public ProgressBar jwh;
        public ProgressBar jwi;
        public ImageView jwj;

        public a() {
        }
    }
}
