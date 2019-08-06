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
/* loaded from: classes4.dex */
public class n extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tbadk.img.b cti = new com.baidu.tbadk.img.b();
    private LinkedList<ImageFileInfo> hOZ = null;
    private a hPa;
    private Context mContext;
    private int mScreenWidth;
    private int mWidth;

    /* loaded from: classes4.dex */
    protected interface a {
        void xS(int i);

        void xT(int i);
    }

    public n(Context context) {
        this.mContext = null;
        this.mContext = context;
        this.mScreenWidth = com.baidu.adp.lib.util.l.af(this.mContext);
        this.mWidth = ((this.mScreenWidth - (com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds10) * 2)) / 3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hOZ == null) {
            return 0;
        }
        return this.hOZ.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.hOZ == null) {
            return null;
        }
        if (this.hOZ.size() - 1 >= i) {
            return this.hOZ.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void t(LinkedList<ImageFileInfo> linkedList) {
        this.hOZ = linkedList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_editor_imgs_item, (ViewGroup) null);
            bVar.bWR = (TbImageView) view.findViewById(R.id.iv_photo_live);
            bVar.hPd = (LinearLayout) view.findViewById(R.id.layout_del);
            bVar.hPe = (ImageView) view.findViewById(R.id.delete_photo_live);
            bVar.bWR.setOnClickListener(this);
            bVar.bWR.setTagTextSize(com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds30));
            bVar.bWR.setDrawBorder(true);
            bVar.bWR.setDrawCorner(false);
            bVar.bWR.setRadius(0);
            bVar.hPd.setOnClickListener(this);
            bVar.bWR.setGifIconSupport(true);
            bVar.bWR.setLongIconSupport(true);
            com.baidu.tbadk.core.util.am.k(bVar.hPe, R.drawable.icon_delete_img);
            ViewGroup.LayoutParams layoutParams = bVar.bWR.getLayoutParams();
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mWidth;
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (this.hOZ != null && this.hOZ.size() - 1 >= i) {
            a(this.hOZ.get(i), bVar, viewGroup);
            bVar.bWR.setTag(bVar.bWR.getId(), Integer.valueOf(i));
            bVar.hPd.setTag(Integer.valueOf(i));
        }
        return view;
    }

    private void a(ImageFileInfo imageFileInfo, b bVar, final ViewGroup viewGroup) {
        if (imageFileInfo != null) {
            ImageOperation al = com.baidu.tbadk.img.effect.d.al(this.mWidth, this.mWidth);
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(al);
            if (imageFileInfo.getImageType() == 0) {
                com.baidu.adp.widget.ImageView.a a2 = this.cti.a(imageFileInfo, true);
                bVar.bWR.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    bVar.bWR.invalidate();
                } else {
                    this.cti.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.pb.pb.main.n.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true);
                }
                bVar.bWR.setTagStr(this.mContext.getString(R.string.edit));
            } else if (imageFileInfo.getImageType() == 1) {
                String filePath = imageFileInfo.getFilePath();
                if (!com.baidu.tbadk.core.util.aq.isEmpty(filePath) && filePath.startsWith("#(")) {
                    final String e = com.baidu.adp.lib.f.c.iE().e(filePath, 20);
                    bVar.bWR.setTag(e);
                    com.baidu.adp.lib.f.c.iE().a(filePath, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.n.2
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(e);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, 0, 0, null, null, filePath, false, null);
                }
                bVar.bWR.setTagStr("");
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.layout_del && (view.getTag() instanceof Integer)) {
            if (this.hPa != null) {
                this.hPa.xS(((Integer) view.getTag()).intValue());
            }
        } else if (id == R.id.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && this.hPa != null) {
            this.hPa.xT(((Integer) view.getTag(view.getId())).intValue());
        }
    }

    public void a(a aVar) {
        this.hPa = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class b {
        public TbImageView bWR;
        public LinearLayout hPd;
        private ImageView hPe;

        b() {
        }
    }
}
