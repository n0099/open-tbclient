package com.baidu.tieba.newfaceshop.facemake;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.FaceData;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends BaseAdapter {
    private a lDo;
    private List<FaceData> mList;
    private Context mContext = BdBaseApplication.getInst().getApp();
    private com.baidu.tbadk.img.b fAe = new com.baidu.tbadk.img.b();
    private int mScreenWidth = l.getEquipmentWidth(this.mContext);
    private int mWidth = (this.mScreenWidth - (l.getDimens(this.mContext, R.dimen.ds30) * 3)) / 4;

    /* loaded from: classes8.dex */
    public interface a {
        void a(FaceData faceData);

        void onAdd();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mList != null) {
            return this.mList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mList == null || i >= this.mList.size()) {
            return null;
        }
        return this.mList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public void a(a aVar) {
        this.lDo = aVar;
    }

    public d(List<FaceData> list) {
        this.mList = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            b bVar2 = new b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_make_face, (ViewGroup) null);
            bVar2.am(view);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        FaceData faceData = this.mList.get(i);
        if (faceData != null) {
            if (faceData.type == 4) {
                ap.setImageResource(bVar.fgj, R.drawable.emotion_icon_add_pic);
                bVar.lDr.setVisibility(8);
            } else if (faceData.type == 1) {
                bVar.fgj.setImageDrawable(null);
                a(faceData.emotionImageData, viewGroup, bVar);
            } else if (faceData.type == 2) {
                bVar.fgj.setImageDrawable(null);
                a(faceData.emotionImageData, bVar);
            } else {
                bVar.fgj.setImageDrawable(null);
                a(faceData.imageFileInfo, viewGroup, bVar);
            }
            bVar.fgj.setTag(bVar.fgj.getId(), faceData);
        }
        bVar.lDr.setTag(faceData);
        return view;
    }

    private void a(EmotionImageData emotionImageData, b bVar) {
        if (emotionImageData != null) {
            bVar.fgj.setTag(emotionImageData.getThumbUrl());
            bVar.fgj.startLoad(emotionImageData.getThumbUrl(), 10, false);
            bVar.lDr.setVisibility(0);
        }
    }

    private void a(EmotionImageData emotionImageData, final ViewGroup viewGroup, final b bVar) {
        if (emotionImageData != null) {
            Object a2 = com.baidu.adp.lib.e.d.mw().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.newfaceshop.facemake.d.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.c
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    View findViewWithTag;
                    if (aVar != null && (findViewWithTag = viewGroup.findViewWithTag(str)) != null && (findViewWithTag instanceof TbImageView) && str != null) {
                        aVar.drawImageTo(bVar.fgj);
                    }
                }
            }, 0, 0, null, null, emotionImageData.getThumbUrl(), false, null);
            com.baidu.adp.widget.ImageView.a aVar = (a2 == null || !(a2 instanceof com.baidu.adp.widget.ImageView.a)) ? null : (com.baidu.adp.widget.ImageView.a) a2;
            if (aVar != null) {
                aVar.drawImageTo(bVar.fgj);
                bVar.fgj.setTag(null);
            }
            bVar.lDr.setVisibility(0);
        }
    }

    private void a(ImageFileInfo imageFileInfo, final ViewGroup viewGroup, b bVar) {
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.bd(this.mWidth, this.mWidth));
            com.baidu.adp.widget.ImageView.a a2 = this.fAe.a(imageFileInfo, false);
            bVar.fgj.setTag(imageFileInfo.toCachedKey(false));
            if (a2 != null) {
                a2.drawImageTo(bVar.fgj);
                bVar.fgj.setTag(null);
            } else {
                this.fAe.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.newfaceshop.facemake.d.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                        if (tbImageView != null && aVar != null) {
                            aVar.drawImageTo(tbImageView);
                        }
                    }
                }, false, false);
            }
            bVar.lDr.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class b {
        public TbImageView fgj;
        public ImageView lDr;

        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void am(View view) {
            this.fgj = (TbImageView) view.findViewById(R.id.image);
            this.lDr = (ImageView) view.findViewById(R.id.delete_icon);
            ViewGroup.LayoutParams layoutParams = this.fgj.getLayoutParams();
            layoutParams.width = d.this.mWidth;
            layoutParams.height = d.this.mWidth;
            ap.setImageResource(this.lDr, R.drawable.icon_live_close_n);
            this.fgj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newfaceshop.facemake.d.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.lDo != null && view2.getTag(view2.getId()) != null && (view2.getTag(view2.getId()) instanceof FaceData) && ((FaceData) view2.getTag(view2.getId())).type == 4) {
                        d.this.lDo.onAdd();
                    }
                }
            });
            this.lDr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newfaceshop.facemake.d.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.lDo != null && view2.getTag() != null && (view2.getTag() instanceof FaceData)) {
                        d.this.lDo.a((FaceData) view2.getTag());
                    }
                }
            });
        }
    }
}
