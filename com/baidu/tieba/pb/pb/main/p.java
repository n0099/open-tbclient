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
/* loaded from: classes.dex */
public class p extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tbadk.img.b aCV = new com.baidu.tbadk.img.b();
    private LinkedList<ImageFileInfo> eVB = null;
    private a eVC;
    private Context mContext;
    private int mScreenWidth;
    private int mWidth;

    /* loaded from: classes.dex */
    protected interface a {
        void pR(int i);

        void pS(int i);
    }

    public p(Context context) {
        this.mContext = null;
        this.mContext = context;
        this.mScreenWidth = com.baidu.adp.lib.util.l.ac(this.mContext);
        this.mWidth = ((this.mScreenWidth - com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds68)) - (com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds16) * 3)) / 4;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eVB == null) {
            return 0;
        }
        return this.eVB.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eVB == null) {
            return null;
        }
        if (this.eVB.size() - 1 >= i) {
            return this.eVB.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void p(LinkedList<ImageFileInfo> linkedList) {
        this.eVB = linkedList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, final ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.pb_editor_imgs_item, (ViewGroup) null);
            bVar.emc = (TbImageView) view.findViewById(d.g.iv_photo_live);
            bVar.eVE = (LinearLayout) view.findViewById(d.g.layout_del);
            bVar.eVF = (ImageView) view.findViewById(d.g.delete_photo_live);
            bVar.emc.setOnClickListener(this);
            bVar.eVE.setOnClickListener(this);
            bVar.emc.setGifIconSupport(true);
            bVar.emc.setLongIconSupport(true);
            com.baidu.tbadk.core.util.aj.j(bVar.eVF, d.f.icon_delete_img);
            bVar.emc.setTagPaddingDis(com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds16), com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds10));
            ViewGroup.LayoutParams layoutParams = bVar.emc.getLayoutParams();
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mWidth;
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (this.eVB != null && this.eVB.size() - 1 >= i) {
            ImageFileInfo imageFileInfo = this.eVB.get(i);
            if (imageFileInfo != null) {
                ImageOperation I = com.baidu.tbadk.img.effect.d.I(this.mWidth, this.mWidth);
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(I);
                com.baidu.adp.widget.a.a a2 = this.aCV.a(imageFileInfo, true);
                bVar.emc.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    bVar.emc.invalidate();
                } else {
                    this.aCV.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.pb.pb.main.p.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true);
                }
                bVar.emc.setTagStr(this.mContext.getString(d.j.edit));
            }
            bVar.emc.setTag(bVar.emc.getId(), Integer.valueOf(i));
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds8);
            bVar.emc.setTagPaddingDis(dimensionPixelSize, dimensionPixelSize);
            bVar.eVE.setTag(Integer.valueOf(i));
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d.g.layout_del && (view.getTag() instanceof Integer)) {
            if (this.eVC != null) {
                this.eVC.pR(((Integer) view.getTag()).intValue());
            }
        } else if (id == d.g.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && this.eVC != null) {
            this.eVC.pS(((Integer) view.getTag(view.getId())).intValue());
        }
    }

    public void a(a aVar) {
        this.eVC = aVar;
    }

    /* loaded from: classes.dex */
    class b {
        public LinearLayout eVE;
        private ImageView eVF;
        public TbImageView emc;

        b() {
        }
    }
}
