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
/* loaded from: classes2.dex */
public class p extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tbadk.img.b brq = new com.baidu.tbadk.img.b();
    private LinkedList<ImageFileInfo> fLo = null;
    private a fLp;
    private Context mContext;
    private int mScreenWidth;
    private int mWidth;

    /* loaded from: classes2.dex */
    protected interface a {
        void sL(int i);

        void sM(int i);
    }

    public p(Context context) {
        this.mContext = null;
        this.mContext = context;
        this.mScreenWidth = com.baidu.adp.lib.util.l.ao(this.mContext);
        this.mWidth = ((this.mScreenWidth - com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds68)) - (com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds16) * 3)) / 4;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fLo == null) {
            return 0;
        }
        return this.fLo.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fLo == null) {
            return null;
        }
        if (this.fLo.size() - 1 >= i) {
            return this.fLo.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void r(LinkedList<ImageFileInfo> linkedList) {
        this.fLo = linkedList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, final ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.pb_editor_imgs_item, (ViewGroup) null);
            bVar.fbm = (TbImageView) view.findViewById(d.g.iv_photo_live);
            bVar.fLr = (LinearLayout) view.findViewById(d.g.layout_del);
            bVar.fLs = (ImageView) view.findViewById(d.g.delete_photo_live);
            bVar.fbm.setOnClickListener(this);
            bVar.fLr.setOnClickListener(this);
            bVar.fbm.setGifIconSupport(true);
            bVar.fbm.setLongIconSupport(true);
            com.baidu.tbadk.core.util.aj.s(bVar.fLs, d.f.icon_delete_img);
            bVar.fbm.setTagPaddingDis(com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds16), com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds10));
            ViewGroup.LayoutParams layoutParams = bVar.fbm.getLayoutParams();
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mWidth;
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (this.fLo != null && this.fLo.size() - 1 >= i) {
            ImageFileInfo imageFileInfo = this.fLo.get(i);
            if (imageFileInfo != null) {
                ImageOperation aI = com.baidu.tbadk.img.effect.d.aI(this.mWidth, this.mWidth);
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(aI);
                com.baidu.adp.widget.a.a a2 = this.brq.a(imageFileInfo, true);
                bVar.fbm.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    bVar.fbm.invalidate();
                } else {
                    this.brq.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.pb.pb.main.p.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true);
                }
                bVar.fbm.setTagStr(this.mContext.getString(d.j.edit));
            }
            bVar.fbm.setTag(bVar.fbm.getId(), Integer.valueOf(i));
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds8);
            bVar.fbm.setTagPaddingDis(dimensionPixelSize, dimensionPixelSize);
            bVar.fLr.setTag(Integer.valueOf(i));
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d.g.layout_del && (view.getTag() instanceof Integer)) {
            if (this.fLp != null) {
                this.fLp.sL(((Integer) view.getTag()).intValue());
            }
        } else if (id == d.g.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && this.fLp != null) {
            this.fLp.sM(((Integer) view.getTag(view.getId())).intValue());
        }
    }

    public void a(a aVar) {
        this.fLp = aVar;
    }

    /* loaded from: classes2.dex */
    class b {
        public LinearLayout fLr;
        private ImageView fLs;
        public TbImageView fbm;

        b() {
        }
    }
}
