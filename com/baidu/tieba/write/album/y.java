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
    private List<ay> aSY = new ArrayList();
    private com.baidu.tbadk.img.b awf;
    private int cdg;
    private p fMV;
    private boolean fMW;
    private w fMX;
    private x fMY;
    int fMZ;
    private AlbumActivity fMg;
    int fNa;
    private View.OnClickListener fNb;
    private int mWidth;

    public y(AlbumActivity albumActivity, p pVar) {
        this.fMg = albumActivity;
        this.awf = albumActivity.afY();
        this.fMV = pVar;
        this.mWidth = (int) this.fMg.getResources().getDimension(w.f.ds220);
        this.fMZ = com.baidu.adp.lib.util.k.g(this.fMg.getPageContext().getPageActivity(), w.f.ds8) / 3;
        this.fNa = (this.fMZ * 2) + 1;
    }

    public void setData(List<ay> list) {
        this.aSY.clear();
        this.aSY.addAll(list);
        notifyDataSetChanged();
    }

    public void sQ(int i) {
        this.cdg = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.aSY.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sN */
    public ImageFileInfo getItem(int i) {
        if (this.aSY.get(i) != null) {
            return this.aSY.get(i).afy();
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.aSY.get(i) != null) {
            return this.aSY.get(i).getType();
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
        ay ayVar = this.aSY.get(i);
        if (ayVar == null) {
            view.setVisibility(4);
        } else {
            if (ayVar.getType() == 0 || ayVar.getType() == 1) {
                if (view == null || view.findViewById(w.h.filling_item) == null) {
                    view = LayoutInflater.from(this.fMg.getPageContext().getPageActivity()).inflate(w.j.album_filling_item, (ViewGroup) null);
                    bVar = null;
                } else {
                    bVar = null;
                }
            } else if (view == null || !(view.getTag() instanceof b)) {
                b bVar2 = new b(this, null);
                view = LayoutInflater.from(this.fMg.getPageContext().getPageActivity()).inflate(w.j.album_image_item_view, viewGroup, false);
                bVar2.rootView = view;
                bVar2.fNj = (HeadImageView) view.findViewById(w.h.pic);
                bVar2.fzD = (ImageView) view.findViewById(w.h.select_icon);
                bVar2.fzE = (RelativeLayout) view.findViewById(w.h.lay_select);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (ayVar.getType() == 0) {
                View findViewById = view.findViewById(w.h.item_main_view);
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                layoutParams.height = (int) (0.28f * com.baidu.adp.lib.util.k.ag(this.fMg.getPageContext().getPageActivity()));
                findViewById.setLayoutParams(layoutParams);
                view.setBackgroundColor(this.fMg.getResources().getColor(w.e.white_alpha0));
                view.setOnClickListener(this.fNb);
            } else if (ayVar.getType() == 1) {
                View findViewById2 = view.findViewById(w.h.item_main_view);
                ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
                layoutParams2.height = this.cdg;
                findViewById2.setLayoutParams(layoutParams2);
                view.setBackgroundColor(this.fMg.getResources().getColor(w.e.white_alpha100));
                view.setOnClickListener(null);
            } else {
                int paddingTop = bVar.rootView.getPaddingTop();
                int i2 = i % 3;
                if (i2 == 0) {
                    bVar.rootView.setPadding(0, paddingTop, this.fNa, 0);
                } else if (i2 == 1) {
                    bVar.rootView.setPadding(this.fMZ, paddingTop, this.fMZ, 0);
                } else {
                    bVar.rootView.setPadding(this.fNa, paddingTop, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams3 = bVar.fNj.getLayoutParams();
                layoutParams3.height = this.cdg;
                bVar.fNj.setLayoutParams(layoutParams3);
                bVar.fNj.setTag(null);
                bVar.fNj.setRadius(1);
                bVar.fNj.setDefaultResource(w.g.img_default_100);
                bVar.fNj.c(null, 12, false);
                bVar.fNj.invalidate();
                a aVar = new a(this, null);
                aVar.fNi = true;
                ImageFileInfo afy = ayVar.afy();
                if (afy != null) {
                    afy.clearPageActions();
                    afy.addPageAction(com.baidu.tbadk.img.effect.d.M(this.mWidth, this.mWidth));
                    bVar.fNj.setTag(afy.toCachedKey(false));
                    if (this.awf.a(afy, false) != null) {
                        bVar.fNj.invalidate();
                    } else {
                        this.awf.a(afy, new z(this, viewGroup, aVar), false, this.fMW);
                    }
                } else {
                    aVar.fNi = false;
                }
                int skinType = TbadkCoreApplication.m9getInst().getSkinType();
                if (this.fMV != null) {
                    if (this.fMV.isAdded(afy)) {
                        bVar.fzD.setContentDescription(this.fMg.getResources().getString(w.l.check_box_checked));
                        com.baidu.tbadk.core.util.aq.j(bVar.fzD, w.g.ic_post_image_selected_s);
                    } else {
                        bVar.fzD.setContentDescription(this.fMg.getResources().getString(w.l.check_box_not_checked));
                        com.baidu.tbadk.core.util.aq.j(bVar.fzD, w.g.ic_post_image_selected_n);
                    }
                    a(bVar, aVar, i, afy, skinType, this.fMV);
                }
                bVar.fNj.setOnClickListener(new aa(this, aVar, i, afy));
            }
        }
        return view;
    }

    public boolean isScroll() {
        return this.fMW;
    }

    public void lD(boolean z) {
        this.fMW = z;
    }

    public void a(w wVar) {
        this.fMX = wVar;
    }

    public void a(x xVar) {
        this.fMY = xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        HeadImageView fNj;
        ImageView fzD;
        RelativeLayout fzE;
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
        boolean fNi;

        private a() {
        }

        /* synthetic */ a(y yVar, a aVar) {
            this();
        }
    }

    private void a(b bVar, a aVar, int i, ImageFileInfo imageFileInfo, int i2, p pVar) {
        bVar.fzE.setOnClickListener(new ab(this, aVar, pVar, imageFileInfo, i, bVar));
    }

    public int g(ImageFileInfo imageFileInfo) {
        ImageFileInfo afy;
        if (imageFileInfo == null || imageFileInfo.getFilePath() == null) {
            return -1;
        }
        if (this.aSY == null || this.aSY.size() == 0) {
            return -1;
        }
        int size = this.aSY.size();
        for (int i = 0; i < size; i++) {
            ay ayVar = this.aSY.get(i);
            if (ayVar != null && (afy = ayVar.afy()) != null && afy.getFilePath() != null && afy.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return -1;
    }

    public void n(View.OnClickListener onClickListener) {
        this.fNb = onClickListener;
    }
}
