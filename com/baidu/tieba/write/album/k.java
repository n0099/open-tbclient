package com.baidu.tieba.write.album;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class k extends BaseAdapter {
    private com.baidu.tbadk.img.b ayo;
    int eAb;
    int eAc;
    private boolean eAd;
    private AlbumActivity gAM;
    private e gBo;
    private i gBp;
    private j gBq;
    private View.OnClickListener gBr;
    private List<m> mDataList = new ArrayList();
    private int mItemHeight;
    private int mWidth;

    public k(AlbumActivity albumActivity, e eVar) {
        this.gAM = albumActivity;
        this.ayo = albumActivity.aoS();
        this.gBo = eVar;
        this.mWidth = (int) this.gAM.getResources().getDimension(d.f.ds220);
        this.eAb = com.baidu.adp.lib.util.k.g(this.gAM.getPageContext().getPageActivity(), d.f.ds8) / 3;
        this.eAc = (this.eAb * 2) + 1;
    }

    public void setData(List<m> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void us(int i) {
        this.mItemHeight = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDataList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oV */
    public ImageFileInfo getItem(int i) {
        if (this.mDataList.get(i) != null) {
            return this.mDataList.get(i).aos();
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
                    view = LayoutInflater.from(this.gAM.getPageContext().getPageActivity()).inflate(d.j.album_filling_item, (ViewGroup) null);
                    bVar = null;
                } else {
                    bVar = null;
                }
            } else if (view == null || !(view.getTag() instanceof b)) {
                b bVar2 = new b();
                view = LayoutInflater.from(this.gAM.getPageContext().getPageActivity()).inflate(d.j.album_image_item_view, viewGroup, false);
                bVar2.rootView = view;
                bVar2.gBy = (HeadImageView) view.findViewById(d.h.pic);
                bVar2.ceR = (ImageView) view.findViewById(d.h.select_icon);
                bVar2.gnn = (RelativeLayout) view.findViewById(d.h.lay_select);
                bVar2.gBz = view.findViewById(d.h.gif_icon);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (mVar.getType() == 0) {
                View findViewById = view.findViewById(d.h.item_main_view);
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                layoutParams.height = (int) (0.28f * com.baidu.adp.lib.util.k.ae(this.gAM.getPageContext().getPageActivity()));
                findViewById.setLayoutParams(layoutParams);
                view.setBackgroundColor(this.gAM.getResources().getColor(d.e.white_alpha0));
                view.setOnClickListener(this.gBr);
            } else if (mVar.getType() == 1) {
                View findViewById2 = view.findViewById(d.h.item_main_view);
                ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
                if (this.mDataList.size() - i <= 3) {
                    layoutParams2.height = com.baidu.adp.lib.util.k.g(this.gAM.getPageContext().getContext(), d.f.ds140);
                } else {
                    layoutParams2.height = this.mItemHeight;
                }
                findViewById2.setLayoutParams(layoutParams2);
                aj.k(view, d.e.cp_bg_line_d);
                view.setOnClickListener(null);
            } else {
                aj.k(view, d.e.cp_bg_line_d);
                int paddingTop = bVar.rootView.getPaddingTop();
                int i2 = i % 3;
                if (i2 == 0) {
                    bVar.rootView.setPadding(0, paddingTop, this.eAc, 0);
                } else if (i2 == 1) {
                    bVar.rootView.setPadding(this.eAb, paddingTop, this.eAb, 0);
                } else {
                    bVar.rootView.setPadding(this.eAc, paddingTop, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams3 = bVar.gBy.getLayoutParams();
                layoutParams3.height = this.mItemHeight;
                bVar.gBy.setLayoutParams(layoutParams3);
                bVar.gBy.setTag(null);
                bVar.gBy.setRadius(1);
                bVar.gBy.setDefaultResource(d.g.img_default_100);
                bVar.gBy.c(null, 12, false);
                bVar.gBy.invalidate();
                final a aVar = new a();
                aVar.gBx = true;
                final ImageFileInfo aos = mVar.aos();
                if (aos != null) {
                    if (aos.isGif()) {
                        bVar.gBz.setVisibility(0);
                        aj.j(bVar.gBz, d.g.ic_image_gif);
                    } else {
                        bVar.gBz.setVisibility(8);
                    }
                    aos.clearPageActions();
                    aos.addPageAction(com.baidu.tbadk.img.effect.d.J(this.mWidth, this.mWidth));
                    bVar.gBy.setTag(aos.toCachedKey(false));
                    if (this.ayo.a(aos, false) != null) {
                        bVar.gBy.invalidate();
                    } else {
                        this.ayo.a(aos, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.album.k.1
                            @Override // com.baidu.tbadk.imageManager.b
                            public void a(com.baidu.adp.widget.a.a aVar2, String str, boolean z) {
                                HeadImageView headImageView = (HeadImageView) viewGroup.findViewWithTag(str);
                                if (headImageView != null && aVar2 != null) {
                                    headImageView.invalidate();
                                } else {
                                    aVar.gBx = false;
                                }
                            }
                        }, false, this.eAd);
                    }
                } else {
                    aVar.gBx = false;
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (this.gBo != null) {
                    if (this.gBo.isAdded(aos)) {
                        bVar.ceR.setContentDescription(this.gAM.getResources().getString(d.l.check_box_checked));
                        aj.j(bVar.ceR, d.g.ic_post_image_selected_s);
                    } else {
                        bVar.ceR.setContentDescription(this.gAM.getResources().getString(d.l.check_box_not_checked));
                        aj.j(bVar.ceR, d.g.ic_post_image_selected_n);
                    }
                    a(bVar, aVar, i, aos, skinType, this.gBo);
                }
                bVar.gBy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.k.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (k.this.gBp != null && aVar.gBx) {
                            k.this.gBp.a(i - 3, aos);
                        }
                    }
                });
            }
        }
        return view;
    }

    public boolean isScroll() {
        return this.eAd;
    }

    public void iG(boolean z) {
        this.eAd = z;
    }

    public void a(i iVar) {
        this.gBp = iVar;
    }

    public void a(j jVar) {
        this.gBq = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b {
        ImageView ceR;
        HeadImageView gBy;
        View gBz;
        RelativeLayout gnn;
        View rootView;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        boolean gBx;

        private a() {
        }
    }

    private void a(final b bVar, final a aVar, final int i, final ImageFileInfo imageFileInfo, int i2, final e eVar) {
        bVar.gnn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.gBq != null && aVar.gBx) {
                    boolean isAdded = eVar.isAdded(imageFileInfo);
                    if (k.this.gBq.a(i, imageFileInfo, !isAdded)) {
                        if (!isAdded) {
                            aj.j(bVar.ceR, d.g.ic_post_image_selected_s);
                            bVar.ceR.setContentDescription(k.this.gAM.getResources().getString(d.l.check_box_checked));
                            return;
                        }
                        aj.j(bVar.ceR, d.g.ic_post_image_selected_n);
                        bVar.ceR.setContentDescription(k.this.gAM.getResources().getString(d.l.check_box_not_checked));
                    }
                }
            }
        });
    }

    public int h(ImageFileInfo imageFileInfo) {
        ImageFileInfo aos;
        if (imageFileInfo == null || imageFileInfo.getFilePath() == null) {
            return -1;
        }
        if (this.mDataList == null || this.mDataList.size() == 0) {
            return -1;
        }
        int size = this.mDataList.size();
        for (int i = 0; i < size; i++) {
            m mVar = this.mDataList.get(i);
            if (mVar != null && (aos = mVar.aos()) != null && aos.getFilePath() != null && aos.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return -1;
    }

    public void h(View.OnClickListener onClickListener) {
        this.gBr = onClickListener;
    }
}
