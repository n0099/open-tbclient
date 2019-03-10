package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class n extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tbadk.img.b cjC = new com.baidu.tbadk.img.b();
    private LinkedList<ImageFileInfo> hqF = null;
    private a hqG;
    private Context mContext;
    private int mScreenWidth;
    private int mWidth;

    /* loaded from: classes4.dex */
    protected interface a {
        void wk(int i);

        void wl(int i);
    }

    public n(Context context) {
        this.mContext = null;
        this.mContext = context;
        this.mScreenWidth = com.baidu.adp.lib.util.l.aO(this.mContext);
        this.mWidth = ((this.mScreenWidth - (com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds44) * 2)) - (com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds10) * 2)) / 3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hqF == null) {
            return 0;
        }
        return this.hqF.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.hqF == null) {
            return null;
        }
        if (this.hqF.size() - 1 >= i) {
            return this.hqF.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void t(LinkedList<ImageFileInfo> linkedList) {
        this.hqF = linkedList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.pb_editor_imgs_item, (ViewGroup) null);
            bVar.bNT = (TbImageView) view.findViewById(d.g.iv_photo_live);
            bVar.hqJ = (LinearLayout) view.findViewById(d.g.layout_del);
            bVar.hqK = (ImageView) view.findViewById(d.g.delete_photo_live);
            bVar.bNT.setOnClickListener(this);
            bVar.bNT.setTagTextSize(com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds30));
            bVar.bNT.setDrawBorder(true);
            bVar.bNT.setDrawCorner(false);
            bVar.bNT.setRadius(0);
            bVar.hqJ.setOnClickListener(this);
            bVar.bNT.setGifIconSupport(true);
            bVar.bNT.setLongIconSupport(true);
            com.baidu.tbadk.core.util.al.k(bVar.hqK, d.f.icon_delete_img);
            ViewGroup.LayoutParams layoutParams = bVar.bNT.getLayoutParams();
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mWidth;
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (this.hqF != null && this.hqF.size() - 1 >= i) {
            a(this.hqF.get(i), bVar, viewGroup);
            bVar.bNT.setTag(bVar.bNT.getId(), Integer.valueOf(i));
            bVar.hqJ.setTag(Integer.valueOf(i));
        }
        return view;
    }

    private void a(ImageFileInfo imageFileInfo, b bVar, final ViewGroup viewGroup) {
        if (imageFileInfo != null) {
            ImageOperation ai = com.baidu.tbadk.img.effect.d.ai(this.mWidth, this.mWidth);
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(ai);
            if (imageFileInfo.getImageType() == 0) {
                com.baidu.adp.widget.ImageView.a a2 = this.cjC.a(imageFileInfo, true);
                bVar.bNT.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    bVar.bNT.invalidate();
                } else {
                    this.cjC.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.pb.pb.main.n.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true);
                }
                bVar.bNT.setTagStr(this.mContext.getString(d.j.edit));
            } else if (imageFileInfo.getImageType() == 1) {
                String filePath = imageFileInfo.getFilePath();
                if (!com.baidu.tbadk.core.util.ap.isEmpty(filePath) && filePath.startsWith("#(")) {
                    final String k = com.baidu.adp.lib.f.c.jB().k(filePath, 20);
                    bVar.bNT.setTag(k);
                    com.baidu.adp.lib.f.c.jB().a(filePath, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.n.2
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(k);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, 0, 0, null, null, filePath, false, null);
                }
                bVar.bNT.setTagStr("");
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d.g.layout_del && (view.getTag() instanceof Integer)) {
            if (this.hqG != null) {
                this.hqG.wk(((Integer) view.getTag()).intValue());
            }
        } else if (id == d.g.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && this.hqG != null) {
            this.hqG.wl(((Integer) view.getTag(view.getId())).intValue());
        }
    }

    public void a(a aVar) {
        this.hqG = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class b {
        public TbImageView bNT;
        public LinearLayout hqJ;
        private ImageView hqK;

        b() {
        }
    }
}
