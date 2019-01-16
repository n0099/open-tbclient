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
    private com.baidu.tbadk.img.b bac = new com.baidu.tbadk.img.b();
    private LinkedList<ImageFileInfo> gai = null;
    private a gaj;
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
        if (this.gai == null) {
            return 0;
        }
        return this.gai.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.gai == null) {
            return null;
        }
        if (this.gai.size() - 1 >= i) {
            return this.gai.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void s(LinkedList<ImageFileInfo> linkedList) {
        this.gai = linkedList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, final ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.pb_editor_imgs_item, (ViewGroup) null);
            bVar.axN = (TbImageView) view.findViewById(e.g.iv_photo_live);
            bVar.gal = (LinearLayout) view.findViewById(e.g.layout_del);
            bVar.gam = (ImageView) view.findViewById(e.g.delete_photo_live);
            bVar.axN.setOnClickListener(this);
            bVar.gal.setOnClickListener(this);
            bVar.axN.setGifIconSupport(true);
            bVar.axN.setLongIconSupport(true);
            com.baidu.tbadk.core.util.al.i(bVar.gam, e.f.icon_delete_img);
            bVar.axN.setTagPaddingDis(com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds16), com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds10));
            ViewGroup.LayoutParams layoutParams = bVar.axN.getLayoutParams();
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mWidth;
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (this.gai != null && this.gai.size() - 1 >= i) {
            ImageFileInfo imageFileInfo = this.gai.get(i);
            if (imageFileInfo != null) {
                ImageOperation L = com.baidu.tbadk.img.effect.d.L(this.mWidth, this.mWidth);
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(L);
                com.baidu.adp.widget.ImageView.a a2 = this.bac.a(imageFileInfo, true);
                bVar.axN.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    bVar.axN.invalidate();
                } else {
                    this.bac.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.pb.pb.main.n.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true);
                }
                bVar.axN.setTagStr(this.mContext.getString(e.j.edit));
            }
            bVar.axN.setTag(bVar.axN.getId(), Integer.valueOf(i));
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds8);
            bVar.axN.setTagPaddingDis(dimensionPixelSize, dimensionPixelSize);
            bVar.gal.setTag(Integer.valueOf(i));
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == e.g.layout_del && (view.getTag() instanceof Integer)) {
            if (this.gaj != null) {
                this.gaj.sB(((Integer) view.getTag()).intValue());
            }
        } else if (id == e.g.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && this.gaj != null) {
            this.gaj.sC(((Integer) view.getTag(view.getId())).intValue());
        }
    }

    public void a(a aVar) {
        this.gaj = aVar;
    }

    /* loaded from: classes6.dex */
    static class b {
        public TbImageView axN;
        public LinearLayout gal;
        private ImageView gam;

        b() {
        }
    }
}
