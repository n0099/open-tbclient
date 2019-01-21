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
import com.baidu.tieba.e;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class n extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tbadk.img.b bad = new com.baidu.tbadk.img.b();
    private LinkedList<ImageFileInfo> gaj = null;
    private a gak;
    private Context mContext;
    private int mScreenWidth;
    private int mWidth;

    /* loaded from: classes6.dex */
    protected interface a {
        void sB(int i);

        void sC(int i);
    }

    public n(Context context) {
        this.mContext = null;
        this.mContext = context;
        this.mScreenWidth = com.baidu.adp.lib.util.l.aO(this.mContext);
        this.mWidth = ((this.mScreenWidth - com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds68)) - (com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds16) * 3)) / 4;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gaj == null) {
            return 0;
        }
        return this.gaj.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.gaj == null) {
            return null;
        }
        if (this.gaj.size() - 1 >= i) {
            return this.gaj.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void s(LinkedList<ImageFileInfo> linkedList) {
        this.gaj = linkedList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, final ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.pb_editor_imgs_item, (ViewGroup) null);
            bVar.axO = (TbImageView) view.findViewById(e.g.iv_photo_live);
            bVar.gam = (LinearLayout) view.findViewById(e.g.layout_del);
            bVar.gan = (ImageView) view.findViewById(e.g.delete_photo_live);
            bVar.axO.setOnClickListener(this);
            bVar.gam.setOnClickListener(this);
            bVar.axO.setGifIconSupport(true);
            bVar.axO.setLongIconSupport(true);
            com.baidu.tbadk.core.util.al.i(bVar.gan, e.f.icon_delete_img);
            bVar.axO.setTagPaddingDis(com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds16), com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds10));
            ViewGroup.LayoutParams layoutParams = bVar.axO.getLayoutParams();
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mWidth;
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (this.gaj != null && this.gaj.size() - 1 >= i) {
            ImageFileInfo imageFileInfo = this.gaj.get(i);
            if (imageFileInfo != null) {
                ImageOperation L = com.baidu.tbadk.img.effect.d.L(this.mWidth, this.mWidth);
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(L);
                com.baidu.adp.widget.ImageView.a a2 = this.bad.a(imageFileInfo, true);
                bVar.axO.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    bVar.axO.invalidate();
                } else {
                    this.bad.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.pb.pb.main.n.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true);
                }
                bVar.axO.setTagStr(this.mContext.getString(e.j.edit));
            }
            bVar.axO.setTag(bVar.axO.getId(), Integer.valueOf(i));
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds8);
            bVar.axO.setTagPaddingDis(dimensionPixelSize, dimensionPixelSize);
            bVar.gam.setTag(Integer.valueOf(i));
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == e.g.layout_del && (view.getTag() instanceof Integer)) {
            if (this.gak != null) {
                this.gak.sB(((Integer) view.getTag()).intValue());
            }
        } else if (id == e.g.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && this.gak != null) {
            this.gak.sC(((Integer) view.getTag(view.getId())).intValue());
        }
    }

    public void a(a aVar) {
        this.gak = aVar;
    }

    /* loaded from: classes6.dex */
    static class b {
        public TbImageView axO;
        public LinearLayout gam;
        private ImageView gan;

        b() {
        }
    }
}
