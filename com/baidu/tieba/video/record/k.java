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
    private VideoEffectLayout.a jvY;
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
            aVar.jwc = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.jwd = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.jwa = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.jwg = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.jwb = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.jwe = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.jwf = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.jwc.setAutoChangeStyle(false);
        aVar.jwd.setAutoChangeStyle(false);
        aVar.jwc.setGifIconSupport(false);
        aVar.jwd.setGifIconSupport(false);
        if (v.c(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.jwa.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.jwg.setVisibility(0);
                aVar.jwc.setVisibility(8);
                aVar.jwg.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.jwg.setVisibility(8);
                aVar.jwc.setVisibility(0);
                aVar.jwc.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.jwa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.jvY != null) {
                        k.this.jvY.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.jwe.setVisibility(0);
            } else {
                aVar.jwe.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                al.k(aVar.jwa, R.drawable.bg_select_sticker);
            } else {
                aVar.jwa.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.jwa.setVisibility(8);
        }
        if (v.c(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.jwb.setVisibility(0);
            aVar.jwd.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.jwb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.jvY != null) {
                        k.this.jvY.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.jwf.setVisibility(0);
            } else {
                aVar.jwf.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                al.k(aVar.jwb, R.drawable.bg_select_sticker);
            } else {
                aVar.jwb.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.jwb.setVisibility(8);
        }
        return view;
    }

    public void T(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.jvY = aVar;
    }

    /* loaded from: classes5.dex */
    public class a {
        public RelativeLayout jwa;
        public RelativeLayout jwb;
        public TbImageView jwc;
        public TbImageView jwd;
        public ProgressBar jwe;
        public ProgressBar jwf;
        public ImageView jwg;

        public a() {
        }
    }
}
