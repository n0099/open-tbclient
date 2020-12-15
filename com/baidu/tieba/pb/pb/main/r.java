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
/* loaded from: classes22.dex */
public class r extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tbadk.img.b fvq = new com.baidu.tbadk.img.b();
    private LinkedList<ImageFileInfo> lGw = null;
    private a lGx;
    private Context mContext;
    private int mScreenWidth;
    private int mWidth;

    /* loaded from: classes22.dex */
    protected interface a {
        void GZ(int i);

        void Ha(int i);
    }

    public r(Context context) {
        this.mContext = null;
        this.mContext = context;
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
        this.mWidth = ((this.mScreenWidth - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10) * 2)) / 3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lGw == null) {
            return 0;
        }
        return this.lGw.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.lGw == null) {
            return null;
        }
        if (this.lGw.size() - 1 >= i) {
            return this.lGw.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void p(LinkedList<ImageFileInfo> linkedList) {
        this.lGw = linkedList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_editor_imgs_item, (ViewGroup) null);
            bVar.eXC = (TbImageView) view.findViewById(R.id.iv_photo_live);
            bVar.lGz = (LinearLayout) view.findViewById(R.id.layout_del);
            bVar.lGA = (ImageView) view.findViewById(R.id.delete_photo_live);
            bVar.eXC.setOnClickListener(this);
            bVar.eXC.setTagTextSize(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30));
            bVar.eXC.setDrawBorder(true);
            bVar.eXC.setDrawCorner(false);
            bVar.eXC.setRadius(0);
            bVar.lGz.setOnClickListener(this);
            bVar.eXC.setGifIconSupport(true);
            bVar.eXC.setLongIconSupport(true);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(bVar.lGA, R.drawable.icon_delete_img);
            ViewGroup.LayoutParams layoutParams = bVar.eXC.getLayoutParams();
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mWidth;
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (this.lGw != null && this.lGw.size() - 1 >= i) {
            a(this.lGw.get(i), bVar, viewGroup);
            bVar.eXC.setTag(bVar.eXC.getId(), Integer.valueOf(i));
            bVar.lGz.setTag(Integer.valueOf(i));
        }
        return view;
    }

    private void a(ImageFileInfo imageFileInfo, b bVar, final ViewGroup viewGroup) {
        if (imageFileInfo != null) {
            ImageOperation bi = com.baidu.tbadk.img.effect.d.bi(this.mWidth, this.mWidth);
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(bi);
            if (imageFileInfo.getImageType() == 0) {
                com.baidu.adp.widget.ImageView.a a2 = this.fvq.a(imageFileInfo, true);
                bVar.eXC.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    bVar.eXC.invalidate();
                } else {
                    this.fvq.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.pb.pb.main.r.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true);
                }
                bVar.eXC.setTagStr(this.mContext.getString(R.string.edit));
            } else if (imageFileInfo.getImageType() == 1) {
                String filePath = imageFileInfo.getFilePath();
                if (!com.baidu.tbadk.core.util.au.isEmpty(filePath) && filePath.startsWith("#(")) {
                    final String genCacheKey = com.baidu.adp.lib.e.c.mS().genCacheKey(filePath, 20);
                    bVar.eXC.setTag(genCacheKey);
                    com.baidu.adp.lib.e.c.mS().a(filePath, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.r.2
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
                bVar.eXC.setTagStr("");
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.layout_del && (view.getTag() instanceof Integer)) {
            if (this.lGx != null) {
                this.lGx.GZ(((Integer) view.getTag()).intValue());
            }
        } else if (id == R.id.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && this.lGx != null) {
            this.lGx.Ha(((Integer) view.getTag(view.getId())).intValue());
        }
    }

    public void a(a aVar) {
        this.lGx = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public static class b {
        public TbImageView eXC;
        private ImageView lGA;
        public LinearLayout lGz;

        b() {
        }
    }
}
