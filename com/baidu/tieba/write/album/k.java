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
    private com.baidu.tbadk.img.b axK;
    private int cad;
    int epS;
    int epT;
    private boolean epU;
    private AlbumActivity gyW;
    private j gzA;
    private View.OnClickListener gzB;
    private e gzy;
    private i gzz;
    private List<m> mDataList = new ArrayList();
    private int mWidth;

    public k(AlbumActivity albumActivity, e eVar) {
        this.gyW = albumActivity;
        this.axK = albumActivity.amx();
        this.gzy = eVar;
        this.mWidth = (int) this.gyW.getResources().getDimension(d.f.ds220);
        this.epS = com.baidu.adp.lib.util.k.g(this.gyW.getPageContext().getPageActivity(), d.f.ds8) / 3;
        this.epT = (this.epS * 2) + 1;
    }

    public void setData(List<m> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void uh(int i) {
        this.cad = i;
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
            return this.mDataList.get(i).alX();
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
                    view = LayoutInflater.from(this.gyW.getPageContext().getPageActivity()).inflate(d.j.album_filling_item, (ViewGroup) null);
                    bVar = null;
                } else {
                    bVar = null;
                }
            } else if (view == null || !(view.getTag() instanceof b)) {
                b bVar2 = new b();
                view = LayoutInflater.from(this.gyW.getPageContext().getPageActivity()).inflate(d.j.album_image_item_view, viewGroup, false);
                bVar2.rootView = view;
                bVar2.gzI = (HeadImageView) view.findViewById(d.h.pic);
                bVar2.cai = (ImageView) view.findViewById(d.h.select_icon);
                bVar2.glL = (RelativeLayout) view.findViewById(d.h.lay_select);
                bVar2.gzJ = view.findViewById(d.h.gif_icon);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (mVar.getType() == 0) {
                View findViewById = view.findViewById(d.h.item_main_view);
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                layoutParams.height = (int) (0.28f * com.baidu.adp.lib.util.k.ag(this.gyW.getPageContext().getPageActivity()));
                findViewById.setLayoutParams(layoutParams);
                view.setBackgroundColor(this.gyW.getResources().getColor(d.e.white_alpha0));
                view.setOnClickListener(this.gzB);
            } else if (mVar.getType() == 1) {
                View findViewById2 = view.findViewById(d.h.item_main_view);
                ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
                if (this.mDataList.size() - i <= 3) {
                    layoutParams2.height = com.baidu.adp.lib.util.k.g(this.gyW.getPageContext().getContext(), d.f.ds140);
                } else {
                    layoutParams2.height = this.cad;
                }
                findViewById2.setLayoutParams(layoutParams2);
                ai.k(view, d.e.cp_bg_line_d);
                view.setOnClickListener(null);
            } else {
                ai.k(view, d.e.cp_bg_line_d);
                int paddingTop = bVar.rootView.getPaddingTop();
                int i2 = i % 3;
                if (i2 == 0) {
                    bVar.rootView.setPadding(0, paddingTop, this.epT, 0);
                } else if (i2 == 1) {
                    bVar.rootView.setPadding(this.epS, paddingTop, this.epS, 0);
                } else {
                    bVar.rootView.setPadding(this.epT, paddingTop, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams3 = bVar.gzI.getLayoutParams();
                layoutParams3.height = this.cad;
                bVar.gzI.setLayoutParams(layoutParams3);
                bVar.gzI.setTag(null);
                bVar.gzI.setRadius(1);
                bVar.gzI.setDefaultResource(d.g.img_default_100);
                bVar.gzI.c(null, 12, false);
                bVar.gzI.invalidate();
                final a aVar = new a();
                aVar.gzH = true;
                final ImageFileInfo alX = mVar.alX();
                if (alX != null) {
                    if (alX.isGif()) {
                        bVar.gzJ.setVisibility(0);
                        ai.j(bVar.gzJ, d.g.ic_image_gif);
                    } else {
                        bVar.gzJ.setVisibility(8);
                    }
                    alX.clearPageActions();
                    alX.addPageAction(com.baidu.tbadk.img.effect.d.L(this.mWidth, this.mWidth));
                    bVar.gzI.setTag(alX.toCachedKey(false));
                    if (this.axK.a(alX, false) != null) {
                        bVar.gzI.invalidate();
                    } else {
                        this.axK.a(alX, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.album.k.1
                            @Override // com.baidu.tbadk.imageManager.b
                            public void a(com.baidu.adp.widget.a.a aVar2, String str, boolean z) {
                                HeadImageView headImageView = (HeadImageView) viewGroup.findViewWithTag(str);
                                if (headImageView != null && aVar2 != null) {
                                    headImageView.invalidate();
                                } else {
                                    aVar.gzH = false;
                                }
                            }
                        }, false, this.epU);
                    }
                } else {
                    aVar.gzH = false;
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (this.gzy != null) {
                    if (this.gzy.isAdded(alX)) {
                        bVar.cai.setContentDescription(this.gyW.getResources().getString(d.l.check_box_checked));
                        ai.j(bVar.cai, d.g.ic_post_image_selected_s);
                    } else {
                        bVar.cai.setContentDescription(this.gyW.getResources().getString(d.l.check_box_not_checked));
                        ai.j(bVar.cai, d.g.ic_post_image_selected_n);
                    }
                    a(bVar, aVar, i, alX, skinType, this.gzy);
                }
                bVar.gzI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.k.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (k.this.gzz != null && aVar.gzH) {
                            k.this.gzz.a(i - 3, alX);
                        }
                    }
                });
            }
        }
        return view;
    }

    public boolean isScroll() {
        return this.epU;
    }

    public void iv(boolean z) {
        this.epU = z;
    }

    public void a(i iVar) {
        this.gzz = iVar;
    }

    public void a(j jVar) {
        this.gzA = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        ImageView cai;
        RelativeLayout glL;
        HeadImageView gzI;
        View gzJ;
        View rootView;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        boolean gzH;

        private a() {
        }
    }

    private void a(final b bVar, final a aVar, final int i, final ImageFileInfo imageFileInfo, int i2, final e eVar) {
        bVar.glL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.gzA != null && aVar.gzH) {
                    boolean isAdded = eVar.isAdded(imageFileInfo);
                    if (k.this.gzA.a(i, imageFileInfo, !isAdded)) {
                        if (!isAdded) {
                            ai.j(bVar.cai, d.g.ic_post_image_selected_s);
                            bVar.cai.setContentDescription(k.this.gyW.getResources().getString(d.l.check_box_checked));
                            return;
                        }
                        ai.j(bVar.cai, d.g.ic_post_image_selected_n);
                        bVar.cai.setContentDescription(k.this.gyW.getResources().getString(d.l.check_box_not_checked));
                    }
                }
            }
        });
    }

    public int h(ImageFileInfo imageFileInfo) {
        ImageFileInfo alX;
        if (imageFileInfo == null || imageFileInfo.getFilePath() == null) {
            return -1;
        }
        if (this.mDataList == null || this.mDataList.size() == 0) {
            return -1;
        }
        int size = this.mDataList.size();
        for (int i = 0; i < size; i++) {
            m mVar = this.mDataList.get(i);
            if (mVar != null && (alX = mVar.alX()) != null && alX.getFilePath() != null && alX.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return -1;
    }

    public void l(View.OnClickListener onClickListener) {
        this.gzB = onClickListener;
    }
}
