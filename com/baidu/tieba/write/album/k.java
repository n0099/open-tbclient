package com.baidu.tieba.write.album;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k extends BaseAdapter {
    private com.baidu.tbadk.img.b azc;
    private int cbV;
    int ete;
    int etf;
    private boolean etg;
    private AlbumActivity gBZ;
    private e gCB;
    private i gCC;
    private j gCD;
    private View.OnClickListener gCE;
    private List<m> mDataList = new ArrayList();
    private int mWidth;

    public k(AlbumActivity albumActivity, e eVar) {
        this.gBZ = albumActivity;
        this.azc = albumActivity.anq();
        this.gCB = eVar;
        this.mWidth = (int) this.gBZ.getResources().getDimension(d.f.ds220);
        this.ete = com.baidu.adp.lib.util.k.g(this.gBZ.getPageContext().getPageActivity(), d.f.ds8) / 3;
        this.etf = (this.ete * 2) + 1;
    }

    public void setData(List<m> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void uq(int i) {
        this.cbV = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDataList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oC */
    public ImageFileInfo getItem(int i) {
        if (this.mDataList.get(i) != null) {
            return this.mDataList.get(i).amQ();
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
    public View getView(final int i, View view, final ViewGroup viewGroup) {
        b bVar;
        m mVar = this.mDataList.get(i);
        if (mVar == null) {
            view.setVisibility(4);
        } else {
            if (mVar.getType() == 0 || mVar.getType() == 1) {
                if (view == null || view.findViewById(d.h.filling_item) == null) {
                    view = LayoutInflater.from(this.gBZ.getPageContext().getPageActivity()).inflate(d.j.album_filling_item, (ViewGroup) null);
                    bVar = null;
                } else {
                    bVar = null;
                }
            } else if (view == null || !(view.getTag() instanceof b)) {
                b bVar2 = new b();
                view = LayoutInflater.from(this.gBZ.getPageContext().getPageActivity()).inflate(d.j.album_image_item_view, viewGroup, false);
                bVar2.rootView = view;
                bVar2.gCL = (HeadImageView) view.findViewById(d.h.pic);
                bVar2.cca = (ImageView) view.findViewById(d.h.select_icon);
                bVar2.goP = (RelativeLayout) view.findViewById(d.h.lay_select);
                bVar2.gCM = view.findViewById(d.h.gif_icon);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (mVar.getType() == 0) {
                View findViewById = view.findViewById(d.h.item_main_view);
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                layoutParams.height = (int) (0.28f * com.baidu.adp.lib.util.k.ah(this.gBZ.getPageContext().getPageActivity()));
                findViewById.setLayoutParams(layoutParams);
                view.setBackgroundColor(this.gBZ.getResources().getColor(d.e.white_alpha0));
                view.setOnClickListener(this.gCE);
            } else if (mVar.getType() == 1) {
                View findViewById2 = view.findViewById(d.h.item_main_view);
                ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
                if (this.mDataList.size() - i <= 3) {
                    layoutParams2.height = com.baidu.adp.lib.util.k.g(this.gBZ.getPageContext().getContext(), d.f.ds140);
                } else {
                    layoutParams2.height = this.cbV;
                }
                findViewById2.setLayoutParams(layoutParams2);
                ai.k(view, d.e.cp_bg_line_d);
                view.setOnClickListener(null);
            } else {
                ai.k(view, d.e.cp_bg_line_d);
                int paddingTop = bVar.rootView.getPaddingTop();
                int i2 = i % 3;
                if (i2 == 0) {
                    bVar.rootView.setPadding(0, paddingTop, this.etf, 0);
                } else if (i2 == 1) {
                    bVar.rootView.setPadding(this.ete, paddingTop, this.ete, 0);
                } else {
                    bVar.rootView.setPadding(this.etf, paddingTop, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams3 = bVar.gCL.getLayoutParams();
                layoutParams3.height = this.cbV;
                bVar.gCL.setLayoutParams(layoutParams3);
                bVar.gCL.setTag(null);
                bVar.gCL.setRadius(1);
                bVar.gCL.setDefaultResource(d.g.img_default_100);
                bVar.gCL.c(null, 12, false);
                bVar.gCL.invalidate();
                final a aVar = new a();
                aVar.gCK = true;
                final ImageFileInfo amQ = mVar.amQ();
                if (amQ != null) {
                    if (amQ.isGif()) {
                        bVar.gCM.setVisibility(0);
                        ai.j(bVar.gCM, d.g.ic_image_gif);
                    } else {
                        bVar.gCM.setVisibility(8);
                    }
                    amQ.clearPageActions();
                    amQ.addPageAction(com.baidu.tbadk.img.effect.d.M(this.mWidth, this.mWidth));
                    bVar.gCL.setTag(amQ.toCachedKey(false));
                    if (this.azc.a(amQ, false) != null) {
                        bVar.gCL.invalidate();
                    } else {
                        this.azc.a(amQ, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.album.k.1
                            @Override // com.baidu.tbadk.imageManager.b
                            public void a(com.baidu.adp.widget.a.a aVar2, String str, boolean z) {
                                HeadImageView headImageView = (HeadImageView) viewGroup.findViewWithTag(str);
                                if (headImageView != null && aVar2 != null) {
                                    headImageView.invalidate();
                                } else {
                                    aVar.gCK = false;
                                }
                            }
                        }, false, this.etg);
                    }
                } else {
                    aVar.gCK = false;
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (this.gCB != null) {
                    if (this.gCB.isAdded(amQ)) {
                        bVar.cca.setContentDescription(this.gBZ.getResources().getString(d.l.check_box_checked));
                        ai.j(bVar.cca, d.g.ic_post_image_selected_s);
                    } else {
                        bVar.cca.setContentDescription(this.gBZ.getResources().getString(d.l.check_box_not_checked));
                        ai.j(bVar.cca, d.g.ic_post_image_selected_n);
                    }
                    a(bVar, aVar, i, amQ, skinType, this.gCB);
                }
                bVar.gCL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.k.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (k.this.gCC != null && aVar.gCK) {
                            k.this.gCC.a(i - 3, amQ);
                        }
                    }
                });
            }
        }
        return view;
    }

    public boolean isScroll() {
        return this.etg;
    }

    public void iy(boolean z) {
        this.etg = z;
    }

    public void a(i iVar) {
        this.gCC = iVar;
    }

    public void a(j jVar) {
        this.gCD = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        ImageView cca;
        HeadImageView gCL;
        View gCM;
        RelativeLayout goP;
        View rootView;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        boolean gCK;

        private a() {
        }
    }

    private void a(final b bVar, final a aVar, final int i, final ImageFileInfo imageFileInfo, int i2, final e eVar) {
        bVar.goP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.gCD != null && aVar.gCK) {
                    boolean isAdded = eVar.isAdded(imageFileInfo);
                    if (k.this.gCD.a(i, imageFileInfo, !isAdded)) {
                        if (!isAdded) {
                            ai.j(bVar.cca, d.g.ic_post_image_selected_s);
                            bVar.cca.setContentDescription(k.this.gBZ.getResources().getString(d.l.check_box_checked));
                            return;
                        }
                        ai.j(bVar.cca, d.g.ic_post_image_selected_n);
                        bVar.cca.setContentDescription(k.this.gBZ.getResources().getString(d.l.check_box_not_checked));
                    }
                }
            }
        });
    }

    public int h(ImageFileInfo imageFileInfo) {
        ImageFileInfo amQ;
        if (imageFileInfo == null || imageFileInfo.getFilePath() == null) {
            return -1;
        }
        if (this.mDataList == null || this.mDataList.size() == 0) {
            return -1;
        }
        int size = this.mDataList.size();
        for (int i = 0; i < size; i++) {
            m mVar = this.mDataList.get(i);
            if (mVar != null && (amQ = mVar.amQ()) != null && amQ.getFilePath() != null && amQ.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return -1;
    }

    public void l(View.OnClickListener onClickListener) {
        this.gCE = onClickListener;
    }
}
