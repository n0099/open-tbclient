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
/* loaded from: classes7.dex */
public class p extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tbadk.img.b dtB = new com.baidu.tbadk.img.b();
    private LinkedList<ImageFileInfo> iEG = null;
    private a iEH;
    private Context mContext;
    private int mScreenWidth;
    private int mWidth;

    /* loaded from: classes7.dex */
    protected interface a {
        void yC(int i);

        void yD(int i);
    }

    public p(Context context) {
        this.mContext = null;
        this.mContext = context;
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
        this.mWidth = ((this.mScreenWidth - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10) * 2)) / 3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.iEG == null) {
            return 0;
        }
        return this.iEG.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.iEG == null) {
            return null;
        }
        if (this.iEG.size() - 1 >= i) {
            return this.iEG.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void p(LinkedList<ImageFileInfo> linkedList) {
        this.iEG = linkedList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_editor_imgs_item, (ViewGroup) null);
            bVar.cZu = (TbImageView) view.findViewById(R.id.iv_photo_live);
            bVar.iEJ = (LinearLayout) view.findViewById(R.id.layout_del);
            bVar.iEK = (ImageView) view.findViewById(R.id.delete_photo_live);
            bVar.cZu.setOnClickListener(this);
            bVar.cZu.setTagTextSize(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30));
            bVar.cZu.setDrawBorder(true);
            bVar.cZu.setDrawCorner(false);
            bVar.cZu.setRadius(0);
            bVar.iEJ.setOnClickListener(this);
            bVar.cZu.setGifIconSupport(true);
            bVar.cZu.setLongIconSupport(true);
            com.baidu.tbadk.core.util.am.setBackgroundResource(bVar.iEK, R.drawable.icon_delete_img);
            ViewGroup.LayoutParams layoutParams = bVar.cZu.getLayoutParams();
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mWidth;
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (this.iEG != null && this.iEG.size() - 1 >= i) {
            a(this.iEG.get(i), bVar, viewGroup);
            bVar.cZu.setTag(bVar.cZu.getId(), Integer.valueOf(i));
            bVar.iEJ.setTag(Integer.valueOf(i));
        }
        return view;
    }

    private void a(ImageFileInfo imageFileInfo, b bVar, final ViewGroup viewGroup) {
        if (imageFileInfo != null) {
            ImageOperation aJ = com.baidu.tbadk.img.effect.d.aJ(this.mWidth, this.mWidth);
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(aJ);
            if (imageFileInfo.getImageType() == 0) {
                com.baidu.adp.widget.ImageView.a a2 = this.dtB.a(imageFileInfo, true);
                bVar.cZu.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    bVar.cZu.invalidate();
                } else {
                    this.dtB.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.pb.pb.main.p.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true);
                }
                bVar.cZu.setTagStr(this.mContext.getString(R.string.edit));
            } else if (imageFileInfo.getImageType() == 1) {
                String filePath = imageFileInfo.getFilePath();
                if (!com.baidu.tbadk.core.util.aq.isEmpty(filePath) && filePath.startsWith("#(")) {
                    final String genCacheKey = com.baidu.adp.lib.e.c.gr().genCacheKey(filePath, 20);
                    bVar.cZu.setTag(genCacheKey);
                    com.baidu.adp.lib.e.c.gr().a(filePath, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.p.2
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
                bVar.cZu.setTagStr("");
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.layout_del && (view.getTag() instanceof Integer)) {
            if (this.iEH != null) {
                this.iEH.yC(((Integer) view.getTag()).intValue());
            }
        } else if (id == R.id.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && this.iEH != null) {
            this.iEH.yD(((Integer) view.getTag(view.getId())).intValue());
        }
    }

    public void a(a aVar) {
        this.iEH = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class b {
        public TbImageView cZu;
        public LinearLayout iEJ;
        private ImageView iEK;

        b() {
        }
    }
}
