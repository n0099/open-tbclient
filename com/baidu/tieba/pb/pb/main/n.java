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
    private com.baidu.tbadk.img.b crO = new com.baidu.tbadk.img.b();
    private LinkedList<ImageFileInfo> hHS = null;
    private a hHT;
    private Context mContext;
    private int mScreenWidth;
    private int mWidth;

    /* loaded from: classes4.dex */
    protected interface a {
        void xm(int i);

        void xn(int i);
    }

    public n(Context context) {
        this.mContext = null;
        this.mContext = context;
        this.mScreenWidth = com.baidu.adp.lib.util.l.af(this.mContext);
        this.mWidth = ((this.mScreenWidth - (com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds10) * 2)) / 3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hHS == null) {
            return 0;
        }
        return this.hHS.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.hHS == null) {
            return null;
        }
        if (this.hHS.size() - 1 >= i) {
            return this.hHS.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void t(LinkedList<ImageFileInfo> linkedList) {
        this.hHS = linkedList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_editor_imgs_item, (ViewGroup) null);
            bVar.bVJ = (TbImageView) view.findViewById(R.id.iv_photo_live);
            bVar.hHW = (LinearLayout) view.findViewById(R.id.layout_del);
            bVar.hHX = (ImageView) view.findViewById(R.id.delete_photo_live);
            bVar.bVJ.setOnClickListener(this);
            bVar.bVJ.setTagTextSize(com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds30));
            bVar.bVJ.setDrawBorder(true);
            bVar.bVJ.setDrawCorner(false);
            bVar.bVJ.setRadius(0);
            bVar.hHW.setOnClickListener(this);
            bVar.bVJ.setGifIconSupport(true);
            bVar.bVJ.setLongIconSupport(true);
            com.baidu.tbadk.core.util.al.k(bVar.hHX, R.drawable.icon_delete_img);
            ViewGroup.LayoutParams layoutParams = bVar.bVJ.getLayoutParams();
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mWidth;
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (this.hHS != null && this.hHS.size() - 1 >= i) {
            a(this.hHS.get(i), bVar, viewGroup);
            bVar.bVJ.setTag(bVar.bVJ.getId(), Integer.valueOf(i));
            bVar.hHW.setTag(Integer.valueOf(i));
        }
        return view;
    }

    private void a(ImageFileInfo imageFileInfo, b bVar, final ViewGroup viewGroup) {
        if (imageFileInfo != null) {
            ImageOperation ai = com.baidu.tbadk.img.effect.d.ai(this.mWidth, this.mWidth);
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(ai);
            if (imageFileInfo.getImageType() == 0) {
                com.baidu.adp.widget.ImageView.a a2 = this.crO.a(imageFileInfo, true);
                bVar.bVJ.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    bVar.bVJ.invalidate();
                } else {
                    this.crO.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.pb.pb.main.n.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true);
                }
                bVar.bVJ.setTagStr(this.mContext.getString(R.string.edit));
            } else if (imageFileInfo.getImageType() == 1) {
                String filePath = imageFileInfo.getFilePath();
                if (!com.baidu.tbadk.core.util.ap.isEmpty(filePath) && filePath.startsWith("#(")) {
                    final String e = com.baidu.adp.lib.f.c.iv().e(filePath, 20);
                    bVar.bVJ.setTag(e);
                    com.baidu.adp.lib.f.c.iv().a(filePath, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.n.2
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
                bVar.bVJ.setTagStr("");
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.layout_del && (view.getTag() instanceof Integer)) {
            if (this.hHT != null) {
                this.hHT.xm(((Integer) view.getTag()).intValue());
            }
        } else if (id == R.id.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && this.hHT != null) {
            this.hHT.xn(((Integer) view.getTag(view.getId())).intValue());
        }
    }

    public void a(a aVar) {
        this.hHT = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class b {
        public TbImageView bVJ;
        public LinearLayout hHW;
        private ImageView hHX;

        b() {
        }
    }
}
