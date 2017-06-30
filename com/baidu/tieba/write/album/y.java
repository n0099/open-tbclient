package com.baidu.tieba.write.album;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class y extends BaseAdapter {
    private com.baidu.tbadk.img.b awS;
    private int bVr;
    private AlbumActivity gex;
    private p gfm;
    private boolean gfn;
    private w gfo;
    private x gfp;
    int gfq;
    int gfr;
    private View.OnClickListener gfs;
    private List<ay> mDataList = new ArrayList();
    private int mWidth;

    public y(AlbumActivity albumActivity, p pVar) {
        this.gex = albumActivity;
        this.awS = albumActivity.akX();
        this.gfm = pVar;
        this.mWidth = (int) this.gex.getResources().getDimension(w.f.ds220);
        this.gfq = com.baidu.adp.lib.util.k.g(this.gex.getPageContext().getPageActivity(), w.f.ds8) / 3;
        this.gfr = (this.gfq * 2) + 1;
    }

    public void setData(List<ay> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void tG(int i) {
        this.bVr = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDataList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tD */
    public ImageFileInfo getItem(int i) {
        if (this.mDataList.get(i) != null) {
            return this.mDataList.get(i).akx();
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.mDataList.get(i) != null) {
            return this.mDataList.get(i).getType();
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        ay ayVar = this.mDataList.get(i);
        if (ayVar == null) {
            view.setVisibility(4);
        } else {
            if (ayVar.getType() == 0 || ayVar.getType() == 1) {
                if (view == null || view.findViewById(w.h.filling_item) == null) {
                    view = LayoutInflater.from(this.gex.getPageContext().getPageActivity()).inflate(w.j.album_filling_item, (ViewGroup) null);
                    bVar = null;
                } else {
                    bVar = null;
                }
            } else if (view == null || !(view.getTag() instanceof b)) {
                b bVar2 = new b(this, null);
                view = LayoutInflater.from(this.gex.getPageContext().getPageActivity()).inflate(w.j.album_image_item_view, viewGroup, false);
                bVar2.rootView = view;
                bVar2.gfA = (HeadImageView) view.findViewById(w.h.pic);
                bVar2.bVw = (ImageView) view.findViewById(w.h.select_icon);
                bVar2.fRo = (RelativeLayout) view.findViewById(w.h.lay_select);
                bVar2.gfB = view.findViewById(w.h.gif_icon);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (ayVar.getType() == 0) {
                View findViewById = view.findViewById(w.h.item_main_view);
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                layoutParams.height = (int) (0.28f * com.baidu.adp.lib.util.k.ag(this.gex.getPageContext().getPageActivity()));
                findViewById.setLayoutParams(layoutParams);
                view.setBackgroundColor(this.gex.getResources().getColor(w.e.white_alpha0));
                view.setOnClickListener(this.gfs);
            } else if (ayVar.getType() == 1) {
                View findViewById2 = view.findViewById(w.h.item_main_view);
                ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
                if (this.mDataList.size() - i <= 3) {
                    layoutParams2.height = com.baidu.adp.lib.util.k.g(this.gex.getPageContext().getContext(), w.f.ds140);
                } else {
                    layoutParams2.height = this.bVr;
                }
                findViewById2.setLayoutParams(layoutParams2);
                com.baidu.tbadk.core.util.as.k(view, w.e.cp_bg_line_d);
                view.setOnClickListener(null);
            } else {
                com.baidu.tbadk.core.util.as.k(view, w.e.cp_bg_line_d);
                int paddingTop = bVar.rootView.getPaddingTop();
                int i2 = i % 3;
                if (i2 == 0) {
                    bVar.rootView.setPadding(0, paddingTop, this.gfr, 0);
                } else if (i2 == 1) {
                    bVar.rootView.setPadding(this.gfq, paddingTop, this.gfq, 0);
                } else {
                    bVar.rootView.setPadding(this.gfr, paddingTop, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams3 = bVar.gfA.getLayoutParams();
                layoutParams3.height = this.bVr;
                bVar.gfA.setLayoutParams(layoutParams3);
                bVar.gfA.setTag(null);
                bVar.gfA.setRadius(1);
                bVar.gfA.setDefaultResource(w.g.img_default_100);
                bVar.gfA.c(null, 12, false);
                bVar.gfA.invalidate();
                a aVar = new a(this, null);
                aVar.gfz = true;
                ImageFileInfo akx = ayVar.akx();
                if (akx != null) {
                    if (akx.isGif()) {
                        bVar.gfB.setVisibility(0);
                        com.baidu.tbadk.core.util.as.j(bVar.gfB, w.g.ic_image_gif);
                    } else {
                        bVar.gfB.setVisibility(8);
                    }
                    akx.clearPageActions();
                    akx.addPageAction(com.baidu.tbadk.img.effect.d.L(this.mWidth, this.mWidth));
                    bVar.gfA.setTag(akx.toCachedKey(false));
                    if (this.awS.a(akx, false) != null) {
                        bVar.gfA.invalidate();
                    } else {
                        this.awS.a(akx, new z(this, viewGroup, aVar), false, this.gfn);
                    }
                } else {
                    aVar.gfz = false;
                }
                int skinType = TbadkCoreApplication.m9getInst().getSkinType();
                if (this.gfm != null) {
                    if (this.gfm.isAdded(akx)) {
                        bVar.bVw.setContentDescription(this.gex.getResources().getString(w.l.check_box_checked));
                        com.baidu.tbadk.core.util.as.j(bVar.bVw, w.g.ic_post_image_selected_s);
                    } else {
                        bVar.bVw.setContentDescription(this.gex.getResources().getString(w.l.check_box_not_checked));
                        com.baidu.tbadk.core.util.as.j(bVar.bVw, w.g.ic_post_image_selected_n);
                    }
                    a(bVar, aVar, i, akx, skinType, this.gfm);
                }
                bVar.gfA.setOnClickListener(new aa(this, aVar, i, akx));
            }
        }
        return view;
    }

    public boolean isScroll() {
        return this.gfn;
    }

    public void mx(boolean z) {
        this.gfn = z;
    }

    public void a(w wVar) {
        this.gfo = wVar;
    }

    public void a(x xVar) {
        this.gfp = xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        ImageView bVw;
        RelativeLayout fRo;
        HeadImageView gfA;
        View gfB;
        View rootView;

        private b() {
        }

        /* synthetic */ b(y yVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        boolean gfz;

        private a() {
        }

        /* synthetic */ a(y yVar, a aVar) {
            this();
        }
    }

    private void a(b bVar, a aVar, int i, ImageFileInfo imageFileInfo, int i2, p pVar) {
        bVar.fRo.setOnClickListener(new ab(this, aVar, pVar, imageFileInfo, i, bVar));
    }

    public int g(ImageFileInfo imageFileInfo) {
        ImageFileInfo akx;
        if (imageFileInfo == null || imageFileInfo.getFilePath() == null) {
            return -1;
        }
        if (this.mDataList == null || this.mDataList.size() == 0) {
            return -1;
        }
        int size = this.mDataList.size();
        for (int i = 0; i < size; i++) {
            ay ayVar = this.mDataList.get(i);
            if (ayVar != null && (akx = ayVar.akx()) != null && akx.getFilePath() != null && akx.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return -1;
    }

    public void m(View.OnClickListener onClickListener) {
        this.gfs = onClickListener;
    }
}
