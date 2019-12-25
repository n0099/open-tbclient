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
import com.baidu.tieba.R;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class p extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tbadk.img.b dtq = new com.baidu.tbadk.img.b();
    private LinkedList<ImageFileInfo> iBc = null;
    private a iBd;
    private Context mContext;
    private int mScreenWidth;
    private int mWidth;

    /* loaded from: classes6.dex */
    protected interface a {
        void yx(int i);

        void yy(int i);
    }

    public p(Context context) {
        this.mContext = null;
        this.mContext = context;
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
        this.mWidth = ((this.mScreenWidth - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10) * 2)) / 3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iBc == null) {
            return 0;
        }
        return this.iBc.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iBc == null) {
            return null;
        }
        if (this.iBc.size() - 1 >= i) {
            return this.iBc.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void p(LinkedList<ImageFileInfo> linkedList) {
        this.iBc = linkedList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_editor_imgs_item, (ViewGroup) null);
            bVar.cZk = (TbImageView) view.findViewById(R.id.iv_photo_live);
            bVar.iBf = (LinearLayout) view.findViewById(R.id.layout_del);
            bVar.iBg = (ImageView) view.findViewById(R.id.delete_photo_live);
            bVar.cZk.setOnClickListener(this);
            bVar.cZk.setTagTextSize(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30));
            bVar.cZk.setDrawBorder(true);
            bVar.cZk.setDrawCorner(false);
            bVar.cZk.setRadius(0);
            bVar.iBf.setOnClickListener(this);
            bVar.cZk.setGifIconSupport(true);
            bVar.cZk.setLongIconSupport(true);
            com.baidu.tbadk.core.util.am.setBackgroundResource(bVar.iBg, R.drawable.icon_delete_img);
            ViewGroup.LayoutParams layoutParams = bVar.cZk.getLayoutParams();
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mWidth;
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (this.iBc != null && this.iBc.size() - 1 >= i) {
            a(this.iBc.get(i), bVar, viewGroup);
            bVar.cZk.setTag(bVar.cZk.getId(), Integer.valueOf(i));
            bVar.iBf.setTag(Integer.valueOf(i));
        }
        return view;
    }

    private void a(ImageFileInfo imageFileInfo, b bVar, final ViewGroup viewGroup) {
        if (imageFileInfo != null) {
            ImageOperation aF = com.baidu.tbadk.img.effect.d.aF(this.mWidth, this.mWidth);
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(aF);
            if (imageFileInfo.getImageType() == 0) {
                com.baidu.adp.widget.ImageView.a a2 = this.dtq.a(imageFileInfo, true);
                bVar.cZk.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    bVar.cZk.invalidate();
                } else {
                    this.dtq.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.pb.pb.main.p.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true);
                }
                bVar.cZk.setTagStr(this.mContext.getString(R.string.edit));
            } else if (imageFileInfo.getImageType() == 1) {
                String filePath = imageFileInfo.getFilePath();
                if (!com.baidu.tbadk.core.util.aq.isEmpty(filePath) && filePath.startsWith("#(")) {
                    final String genCacheKey = com.baidu.adp.lib.e.c.gs().genCacheKey(filePath, 20);
                    bVar.cZk.setTag(genCacheKey);
                    com.baidu.adp.lib.e.c.gs().a(filePath, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.p.2
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(genCacheKey);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, 0, 0, null, null, filePath, false, null);
                }
                bVar.cZk.setTagStr("");
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.layout_del && (view.getTag() instanceof Integer)) {
            if (this.iBd != null) {
                this.iBd.yx(((Integer) view.getTag()).intValue());
            }
        } else if (id == R.id.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && this.iBd != null) {
            this.iBd.yy(((Integer) view.getTag(view.getId())).intValue());
        }
    }

    public void a(a aVar) {
        this.iBd = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class b {
        public TbImageView cZk;
        public LinearLayout iBf;
        private ImageView iBg;

        b() {
        }
    }
}
