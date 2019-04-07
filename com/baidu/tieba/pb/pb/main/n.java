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
    private com.baidu.tbadk.img.b cjE = new com.baidu.tbadk.img.b();
    private LinkedList<ImageFileInfo> hql = null;
    private a hqm;
    private Context mContext;
    private int mScreenWidth;
    private int mWidth;

    /* loaded from: classes4.dex */
    protected interface a {
        void wg(int i);

        void wh(int i);
    }

    public n(Context context) {
        this.mContext = null;
        this.mContext = context;
        this.mScreenWidth = com.baidu.adp.lib.util.l.aO(this.mContext);
        this.mWidth = ((this.mScreenWidth - (com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds44) * 2)) - (com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds10) * 2)) / 3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hql == null) {
            return 0;
        }
        return this.hql.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.hql == null) {
            return null;
        }
        if (this.hql.size() - 1 >= i) {
            return this.hql.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void t(LinkedList<ImageFileInfo> linkedList) {
        this.hql = linkedList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.pb_editor_imgs_item, (ViewGroup) null);
            bVar.bNW = (TbImageView) view.findViewById(d.g.iv_photo_live);
            bVar.hqp = (LinearLayout) view.findViewById(d.g.layout_del);
            bVar.hqq = (ImageView) view.findViewById(d.g.delete_photo_live);
            bVar.bNW.setOnClickListener(this);
            bVar.bNW.setTagTextSize(com.baidu.adp.lib.util.l.h(this.mContext, d.e.tbds30));
            bVar.bNW.setDrawBorder(true);
            bVar.bNW.setDrawCorner(false);
            bVar.bNW.setRadius(0);
            bVar.hqp.setOnClickListener(this);
            bVar.bNW.setGifIconSupport(true);
            bVar.bNW.setLongIconSupport(true);
            com.baidu.tbadk.core.util.al.k(bVar.hqq, d.f.icon_delete_img);
            ViewGroup.LayoutParams layoutParams = bVar.bNW.getLayoutParams();
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mWidth;
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (this.hql != null && this.hql.size() - 1 >= i) {
            a(this.hql.get(i), bVar, viewGroup);
            bVar.bNW.setTag(bVar.bNW.getId(), Integer.valueOf(i));
            bVar.hqp.setTag(Integer.valueOf(i));
        }
        return view;
    }

    private void a(ImageFileInfo imageFileInfo, b bVar, final ViewGroup viewGroup) {
        if (imageFileInfo != null) {
            ImageOperation ai = com.baidu.tbadk.img.effect.d.ai(this.mWidth, this.mWidth);
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(ai);
            if (imageFileInfo.getImageType() == 0) {
                com.baidu.adp.widget.ImageView.a a2 = this.cjE.a(imageFileInfo, true);
                bVar.bNW.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    bVar.bNW.invalidate();
                } else {
                    this.cjE.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.pb.pb.main.n.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true);
                }
                bVar.bNW.setTagStr(this.mContext.getString(d.j.edit));
            } else if (imageFileInfo.getImageType() == 1) {
                String filePath = imageFileInfo.getFilePath();
                if (!com.baidu.tbadk.core.util.ap.isEmpty(filePath) && filePath.startsWith("#(")) {
                    final String k = com.baidu.adp.lib.f.c.jB().k(filePath, 20);
                    bVar.bNW.setTag(k);
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
                bVar.bNW.setTagStr("");
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d.g.layout_del && (view.getTag() instanceof Integer)) {
            if (this.hqm != null) {
                this.hqm.wg(((Integer) view.getTag()).intValue());
            }
        } else if (id == d.g.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && this.hqm != null) {
            this.hqm.wh(((Integer) view.getTag(view.getId())).intValue());
        }
    }

    public void a(a aVar) {
        this.hqm = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class b {
        public TbImageView bNW;
        public LinearLayout hqp;
        private ImageView hqq;

        b() {
        }
    }
}
