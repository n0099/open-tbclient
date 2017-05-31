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
    private com.baidu.tbadk.img.b avP;
    private int cju;
    private AlbumActivity fTN;
    private p fUC;
    private boolean fUD;
    private w fUE;
    private x fUF;
    int fUG;
    int fUH;
    private View.OnClickListener fUI;
    private List<ay> mDataList = new ArrayList();
    private int mWidth;

    public y(AlbumActivity albumActivity, p pVar) {
        this.fTN = albumActivity;
        this.avP = albumActivity.ahn();
        this.fUC = pVar;
        this.mWidth = (int) this.fTN.getResources().getDimension(w.f.ds220);
        this.fUG = com.baidu.adp.lib.util.k.g(this.fTN.getPageContext().getPageActivity(), w.f.ds8) / 3;
        this.fUH = (this.fUG * 2) + 1;
    }

    public void setData(List<ay> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void tl(int i) {
        this.cju = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDataList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ti */
    public ImageFileInfo getItem(int i) {
        if (this.mDataList.get(i) != null) {
            return this.mDataList.get(i).agN();
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
                    view = LayoutInflater.from(this.fTN.getPageContext().getPageActivity()).inflate(w.j.album_filling_item, (ViewGroup) null);
                    bVar = null;
                } else {
                    bVar = null;
                }
            } else if (view == null || !(view.getTag() instanceof b)) {
                b bVar2 = new b(this, null);
                view = LayoutInflater.from(this.fTN.getPageContext().getPageActivity()).inflate(w.j.album_image_item_view, viewGroup, false);
                bVar2.rootView = view;
                bVar2.fUQ = (HeadImageView) view.findViewById(w.h.pic);
                bVar2.fHy = (ImageView) view.findViewById(w.h.select_icon);
                bVar2.fHz = (RelativeLayout) view.findViewById(w.h.lay_select);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (ayVar.getType() == 0) {
                View findViewById = view.findViewById(w.h.item_main_view);
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                layoutParams.height = (int) (0.28f * com.baidu.adp.lib.util.k.ag(this.fTN.getPageContext().getPageActivity()));
                findViewById.setLayoutParams(layoutParams);
                view.setBackgroundColor(this.fTN.getResources().getColor(w.e.white_alpha0));
                view.setOnClickListener(this.fUI);
            } else if (ayVar.getType() == 1) {
                View findViewById2 = view.findViewById(w.h.item_main_view);
                ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
                layoutParams2.height = this.cju;
                findViewById2.setLayoutParams(layoutParams2);
                com.baidu.tbadk.core.util.aq.k(view, w.e.cp_bg_line_d);
                view.setOnClickListener(null);
            } else {
                com.baidu.tbadk.core.util.aq.k(view, w.e.cp_bg_line_d);
                int paddingTop = bVar.rootView.getPaddingTop();
                int i2 = i % 3;
                if (i2 == 0) {
                    bVar.rootView.setPadding(0, paddingTop, this.fUH, 0);
                } else if (i2 == 1) {
                    bVar.rootView.setPadding(this.fUG, paddingTop, this.fUG, 0);
                } else {
                    bVar.rootView.setPadding(this.fUH, paddingTop, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams3 = bVar.fUQ.getLayoutParams();
                layoutParams3.height = this.cju;
                bVar.fUQ.setLayoutParams(layoutParams3);
                bVar.fUQ.setTag(null);
                bVar.fUQ.setRadius(1);
                bVar.fUQ.setDefaultResource(w.g.img_default_100);
                bVar.fUQ.c(null, 12, false);
                bVar.fUQ.invalidate();
                a aVar = new a(this, null);
                aVar.fUP = true;
                ImageFileInfo agN = ayVar.agN();
                if (agN != null) {
                    agN.clearPageActions();
                    agN.addPageAction(com.baidu.tbadk.img.effect.d.L(this.mWidth, this.mWidth));
                    bVar.fUQ.setTag(agN.toCachedKey(false));
                    if (this.avP.a(agN, false) != null) {
                        bVar.fUQ.invalidate();
                    } else {
                        this.avP.a(agN, new z(this, viewGroup, aVar), false, this.fUD);
                    }
                } else {
                    aVar.fUP = false;
                }
                int skinType = TbadkCoreApplication.m9getInst().getSkinType();
                if (this.fUC != null) {
                    if (this.fUC.isAdded(agN)) {
                        bVar.fHy.setContentDescription(this.fTN.getResources().getString(w.l.check_box_checked));
                        com.baidu.tbadk.core.util.aq.j(bVar.fHy, w.g.ic_post_image_selected_s);
                    } else {
                        bVar.fHy.setContentDescription(this.fTN.getResources().getString(w.l.check_box_not_checked));
                        com.baidu.tbadk.core.util.aq.j(bVar.fHy, w.g.ic_post_image_selected_n);
                    }
                    a(bVar, aVar, i, agN, skinType, this.fUC);
                }
                bVar.fUQ.setOnClickListener(new aa(this, aVar, i, agN));
            }
        }
        return view;
    }

    public boolean isScroll() {
        return this.fUD;
    }

    public void lW(boolean z) {
        this.fUD = z;
    }

    public void a(w wVar) {
        this.fUE = wVar;
    }

    public void a(x xVar) {
        this.fUF = xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        ImageView fHy;
        RelativeLayout fHz;
        HeadImageView fUQ;
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
        boolean fUP;

        private a() {
        }

        /* synthetic */ a(y yVar, a aVar) {
            this();
        }
    }

    private void a(b bVar, a aVar, int i, ImageFileInfo imageFileInfo, int i2, p pVar) {
        bVar.fHz.setOnClickListener(new ab(this, aVar, pVar, imageFileInfo, i, bVar));
    }

    public int g(ImageFileInfo imageFileInfo) {
        ImageFileInfo agN;
        if (imageFileInfo == null || imageFileInfo.getFilePath() == null) {
            return -1;
        }
        if (this.mDataList == null || this.mDataList.size() == 0) {
            return -1;
        }
        int size = this.mDataList.size();
        for (int i = 0; i < size; i++) {
            ay ayVar = this.mDataList.get(i);
            if (ayVar != null && (agN = ayVar.agN()) != null && agN.getFilePath() != null && agN.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return -1;
    }

    public void m(View.OnClickListener onClickListener) {
        this.fUI = onClickListener;
    }
}
