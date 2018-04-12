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
public class n extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tbadk.img.b aDT = new com.baidu.tbadk.img.b();
    private LinkedList<ImageFileInfo> fiu = null;
    private a fiv;
    private Context mContext;
    private int mScreenWidth;
    private int mWidth;

    /* loaded from: classes2.dex */
    protected interface a {
        void qm(int i);

        void qn(int i);
    }

    public n(Context context) {
        this.mContext = null;
        this.mContext = context;
        this.mScreenWidth = com.baidu.adp.lib.util.l.af(this.mContext);
        this.mWidth = ((this.mScreenWidth - com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds68)) - (com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds16) * 3)) / 4;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fiu == null) {
            return 0;
        }
        return this.fiu.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fiu == null) {
            return null;
        }
        if (this.fiu.size() - 1 >= i) {
            return this.fiu.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void u(LinkedList<ImageFileInfo> linkedList) {
        this.fiu = linkedList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, final ViewGroup viewGroup) {
        b bVar;
        if (view2 == null) {
            bVar = new b();
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.pb_editor_imgs_item, (ViewGroup) null);
            bVar.aru = (TbImageView) view2.findViewById(d.g.iv_photo_live);
            bVar.fiy = (LinearLayout) view2.findViewById(d.g.layout_del);
            bVar.fiz = (ImageView) view2.findViewById(d.g.delete_photo_live);
            bVar.aru.setOnClickListener(this);
            bVar.fiy.setOnClickListener(this);
            bVar.aru.setGifIconSupport(true);
            bVar.aru.setLongIconSupport(true);
            com.baidu.tbadk.core.util.ak.i(bVar.fiz, d.f.icon_delete_img);
            bVar.aru.setTagPaddingDis(com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds16), com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds10));
            ViewGroup.LayoutParams layoutParams = bVar.aru.getLayoutParams();
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mWidth;
            view2.setTag(bVar);
        } else {
            bVar = (b) view2.getTag();
        }
        if (this.fiu != null && this.fiu.size() - 1 >= i) {
            ImageFileInfo imageFileInfo = this.fiu.get(i);
            if (imageFileInfo != null) {
                ImageOperation G = com.baidu.tbadk.img.effect.d.G(this.mWidth, this.mWidth);
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(G);
                com.baidu.adp.widget.ImageView.a a2 = this.aDT.a(imageFileInfo, true);
                bVar.aru.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    bVar.aru.invalidate();
                } else {
                    this.aDT.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.pb.pb.main.n.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true);
                }
                bVar.aru.setTagStr(this.mContext.getString(d.k.edit));
            }
            bVar.aru.setTag(bVar.aru.getId(), Integer.valueOf(i));
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds8);
            bVar.aru.setTagPaddingDis(dimensionPixelSize, dimensionPixelSize);
            bVar.fiy.setTag(Integer.valueOf(i));
        }
        return view2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int id = view2.getId();
        if (id == d.g.layout_del && (view2.getTag() instanceof Integer)) {
            if (this.fiv != null) {
                this.fiv.qm(((Integer) view2.getTag()).intValue());
            }
        } else if (id == d.g.iv_photo_live && (view2.getTag(view2.getId()) instanceof Integer) && this.fiv != null) {
            this.fiv.qn(((Integer) view2.getTag(view2.getId())).intValue());
        }
    }

    public void a(a aVar) {
        this.fiv = aVar;
    }

    /* loaded from: classes2.dex */
    class b {
        public TbImageView aru;
        public LinearLayout fiy;
        private ImageView fiz;

        b() {
        }
    }
}
