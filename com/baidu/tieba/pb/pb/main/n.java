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
/* loaded from: classes2.dex */
public class n extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tbadk.img.b aQB = new com.baidu.tbadk.img.b();
    private LinkedList<ImageFileInfo> fGC = null;
    private a fGD;
    private Context mContext;
    private int mScreenWidth;
    private int mWidth;

    /* loaded from: classes2.dex */
    protected interface a {
        void ra(int i);

        void rb(int i);
    }

    public n(Context context) {
        this.mContext = null;
        this.mContext = context;
        this.mScreenWidth = com.baidu.adp.lib.util.l.aO(this.mContext);
        this.mWidth = ((this.mScreenWidth - com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.ds68)) - (com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.ds16) * 3)) / 4;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fGC == null) {
            return 0;
        }
        return this.fGC.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fGC == null) {
            return null;
        }
        if (this.fGC.size() - 1 >= i) {
            return this.fGC.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void s(LinkedList<ImageFileInfo> linkedList) {
        this.fGC = linkedList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, final ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.pb_editor_imgs_item, (ViewGroup) null);
            bVar.aof = (TbImageView) view.findViewById(e.g.iv_photo_live);
            bVar.fGF = (LinearLayout) view.findViewById(e.g.layout_del);
            bVar.fGG = (ImageView) view.findViewById(e.g.delete_photo_live);
            bVar.aof.setOnClickListener(this);
            bVar.fGF.setOnClickListener(this);
            bVar.aof.setGifIconSupport(true);
            bVar.aof.setLongIconSupport(true);
            com.baidu.tbadk.core.util.al.i(bVar.fGG, e.f.icon_delete_img);
            bVar.aof.setTagPaddingDis(com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.ds16), com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.ds10));
            ViewGroup.LayoutParams layoutParams = bVar.aof.getLayoutParams();
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mWidth;
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (this.fGC != null && this.fGC.size() - 1 >= i) {
            ImageFileInfo imageFileInfo = this.fGC.get(i);
            if (imageFileInfo != null) {
                ImageOperation K = com.baidu.tbadk.img.effect.d.K(this.mWidth, this.mWidth);
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(K);
                com.baidu.adp.widget.ImageView.a a2 = this.aQB.a(imageFileInfo, true);
                bVar.aof.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    bVar.aof.invalidate();
                } else {
                    this.aQB.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.pb.pb.main.n.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true);
                }
                bVar.aof.setTagStr(this.mContext.getString(e.j.edit));
            }
            bVar.aof.setTag(bVar.aof.getId(), Integer.valueOf(i));
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds8);
            bVar.aof.setTagPaddingDis(dimensionPixelSize, dimensionPixelSize);
            bVar.fGF.setTag(Integer.valueOf(i));
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == e.g.layout_del && (view.getTag() instanceof Integer)) {
            if (this.fGD != null) {
                this.fGD.ra(((Integer) view.getTag()).intValue());
            }
        } else if (id == e.g.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && this.fGD != null) {
            this.fGD.rb(((Integer) view.getTag(view.getId())).intValue());
        }
    }

    public void a(a aVar) {
        this.fGD = aVar;
    }

    /* loaded from: classes2.dex */
    static class b {
        public TbImageView aof;
        public LinearLayout fGF;
        private ImageView fGG;

        b() {
        }
    }
}
