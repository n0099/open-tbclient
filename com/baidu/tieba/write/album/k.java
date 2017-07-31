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
    private com.baidu.tbadk.img.b azb;
    private int cbj;
    int erj;
    int erk;
    private boolean erl;
    private e gAJ;
    private i gAK;
    private j gAL;
    private View.OnClickListener gAM;
    private AlbumActivity gAh;
    private List<m> mDataList = new ArrayList();
    private int mWidth;

    public k(AlbumActivity albumActivity, e eVar) {
        this.gAh = albumActivity;
        this.azb = albumActivity.amK();
        this.gAJ = eVar;
        this.mWidth = (int) this.gAh.getResources().getDimension(d.f.ds220);
        this.erj = com.baidu.adp.lib.util.k.g(this.gAh.getPageContext().getPageActivity(), d.f.ds8) / 3;
        this.erk = (this.erj * 2) + 1;
    }

    public void setData(List<m> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void uh(int i) {
        this.cbj = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDataList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: os */
    public ImageFileInfo getItem(int i) {
        if (this.mDataList.get(i) != null) {
            return this.mDataList.get(i).amk();
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
                    view = LayoutInflater.from(this.gAh.getPageContext().getPageActivity()).inflate(d.j.album_filling_item, (ViewGroup) null);
                    bVar = null;
                } else {
                    bVar = null;
                }
            } else if (view == null || !(view.getTag() instanceof b)) {
                b bVar2 = new b();
                view = LayoutInflater.from(this.gAh.getPageContext().getPageActivity()).inflate(d.j.album_image_item_view, viewGroup, false);
                bVar2.rootView = view;
                bVar2.gAT = (HeadImageView) view.findViewById(d.h.pic);
                bVar2.cbo = (ImageView) view.findViewById(d.h.select_icon);
                bVar2.gmW = (RelativeLayout) view.findViewById(d.h.lay_select);
                bVar2.gAU = view.findViewById(d.h.gif_icon);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (mVar.getType() == 0) {
                View findViewById = view.findViewById(d.h.item_main_view);
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                layoutParams.height = (int) (0.28f * com.baidu.adp.lib.util.k.ah(this.gAh.getPageContext().getPageActivity()));
                findViewById.setLayoutParams(layoutParams);
                view.setBackgroundColor(this.gAh.getResources().getColor(d.e.white_alpha0));
                view.setOnClickListener(this.gAM);
            } else if (mVar.getType() == 1) {
                View findViewById2 = view.findViewById(d.h.item_main_view);
                ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
                if (this.mDataList.size() - i <= 3) {
                    layoutParams2.height = com.baidu.adp.lib.util.k.g(this.gAh.getPageContext().getContext(), d.f.ds140);
                } else {
                    layoutParams2.height = this.cbj;
                }
                findViewById2.setLayoutParams(layoutParams2);
                ai.k(view, d.e.cp_bg_line_d);
                view.setOnClickListener(null);
            } else {
                ai.k(view, d.e.cp_bg_line_d);
                int paddingTop = bVar.rootView.getPaddingTop();
                int i2 = i % 3;
                if (i2 == 0) {
                    bVar.rootView.setPadding(0, paddingTop, this.erk, 0);
                } else if (i2 == 1) {
                    bVar.rootView.setPadding(this.erj, paddingTop, this.erj, 0);
                } else {
                    bVar.rootView.setPadding(this.erk, paddingTop, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams3 = bVar.gAT.getLayoutParams();
                layoutParams3.height = this.cbj;
                bVar.gAT.setLayoutParams(layoutParams3);
                bVar.gAT.setTag(null);
                bVar.gAT.setRadius(1);
                bVar.gAT.setDefaultResource(d.g.img_default_100);
                bVar.gAT.c(null, 12, false);
                bVar.gAT.invalidate();
                final a aVar = new a();
                aVar.gAS = true;
                final ImageFileInfo amk = mVar.amk();
                if (amk != null) {
                    if (amk.isGif()) {
                        bVar.gAU.setVisibility(0);
                        ai.j(bVar.gAU, d.g.ic_image_gif);
                    } else {
                        bVar.gAU.setVisibility(8);
                    }
                    amk.clearPageActions();
                    amk.addPageAction(com.baidu.tbadk.img.effect.d.M(this.mWidth, this.mWidth));
                    bVar.gAT.setTag(amk.toCachedKey(false));
                    if (this.azb.a(amk, false) != null) {
                        bVar.gAT.invalidate();
                    } else {
                        this.azb.a(amk, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.album.k.1
                            @Override // com.baidu.tbadk.imageManager.b
                            public void a(com.baidu.adp.widget.a.a aVar2, String str, boolean z) {
                                HeadImageView headImageView = (HeadImageView) viewGroup.findViewWithTag(str);
                                if (headImageView != null && aVar2 != null) {
                                    headImageView.invalidate();
                                } else {
                                    aVar.gAS = false;
                                }
                            }
                        }, false, this.erl);
                    }
                } else {
                    aVar.gAS = false;
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (this.gAJ != null) {
                    if (this.gAJ.isAdded(amk)) {
                        bVar.cbo.setContentDescription(this.gAh.getResources().getString(d.l.check_box_checked));
                        ai.j(bVar.cbo, d.g.ic_post_image_selected_s);
                    } else {
                        bVar.cbo.setContentDescription(this.gAh.getResources().getString(d.l.check_box_not_checked));
                        ai.j(bVar.cbo, d.g.ic_post_image_selected_n);
                    }
                    a(bVar, aVar, i, amk, skinType, this.gAJ);
                }
                bVar.gAT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.k.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (k.this.gAK != null && aVar.gAS) {
                            k.this.gAK.a(i - 3, amk);
                        }
                    }
                });
            }
        }
        return view;
    }

    public boolean isScroll() {
        return this.erl;
    }

    public void iv(boolean z) {
        this.erl = z;
    }

    public void a(i iVar) {
        this.gAK = iVar;
    }

    public void a(j jVar) {
        this.gAL = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        ImageView cbo;
        HeadImageView gAT;
        View gAU;
        RelativeLayout gmW;
        View rootView;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        boolean gAS;

        private a() {
        }
    }

    private void a(final b bVar, final a aVar, final int i, final ImageFileInfo imageFileInfo, int i2, final e eVar) {
        bVar.gmW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.gAL != null && aVar.gAS) {
                    boolean isAdded = eVar.isAdded(imageFileInfo);
                    if (k.this.gAL.a(i, imageFileInfo, !isAdded)) {
                        if (!isAdded) {
                            ai.j(bVar.cbo, d.g.ic_post_image_selected_s);
                            bVar.cbo.setContentDescription(k.this.gAh.getResources().getString(d.l.check_box_checked));
                            return;
                        }
                        ai.j(bVar.cbo, d.g.ic_post_image_selected_n);
                        bVar.cbo.setContentDescription(k.this.gAh.getResources().getString(d.l.check_box_not_checked));
                    }
                }
            }
        });
    }

    public int h(ImageFileInfo imageFileInfo) {
        ImageFileInfo amk;
        if (imageFileInfo == null || imageFileInfo.getFilePath() == null) {
            return -1;
        }
        if (this.mDataList == null || this.mDataList.size() == 0) {
            return -1;
        }
        int size = this.mDataList.size();
        for (int i = 0; i < size; i++) {
            m mVar = this.mDataList.get(i);
            if (mVar != null && (amk = mVar.amk()) != null && amk.getFilePath() != null && amk.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return -1;
    }

    public void l(View.OnClickListener onClickListener) {
        this.gAM = onClickListener;
    }
}
