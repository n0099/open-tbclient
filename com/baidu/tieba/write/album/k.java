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
    private com.baidu.tbadk.img.b ayl;
    int eAV;
    int eAW;
    private boolean eAX;
    private AlbumActivity gBF;
    private e gCh;
    private i gCi;
    private j gCj;
    private View.OnClickListener gCk;
    private List<m> mDataList = new ArrayList();
    private int mItemHeight;
    private int mWidth;

    public k(AlbumActivity albumActivity, e eVar) {
        this.gBF = albumActivity;
        this.ayl = albumActivity.apd();
        this.gCh = eVar;
        this.mWidth = (int) this.gBF.getResources().getDimension(d.f.ds220);
        this.eAV = com.baidu.adp.lib.util.k.f(this.gBF.getPageContext().getPageActivity(), d.f.ds8) / 3;
        this.eAW = (this.eAV * 2) + 1;
    }

    public void setData(List<m> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void uu(int i) {
        this.mItemHeight = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDataList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oX */
    public ImageFileInfo getItem(int i) {
        if (this.mDataList.get(i) != null) {
            return this.mDataList.get(i).aoD();
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
                    view = LayoutInflater.from(this.gBF.getPageContext().getPageActivity()).inflate(d.j.album_filling_item, (ViewGroup) null);
                    bVar = null;
                } else {
                    bVar = null;
                }
            } else if (view == null || !(view.getTag() instanceof b)) {
                b bVar2 = new b();
                view = LayoutInflater.from(this.gBF.getPageContext().getPageActivity()).inflate(d.j.album_image_item_view, viewGroup, false);
                bVar2.rootView = view;
                bVar2.gCr = (HeadImageView) view.findViewById(d.h.pic);
                bVar2.cfJ = (ImageView) view.findViewById(d.h.select_icon);
                bVar2.goi = (RelativeLayout) view.findViewById(d.h.lay_select);
                bVar2.gCs = view.findViewById(d.h.gif_icon);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (mVar.getType() == 0) {
                View findViewById = view.findViewById(d.h.item_main_view);
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                layoutParams.height = (int) (0.28f * com.baidu.adp.lib.util.k.af(this.gBF.getPageContext().getPageActivity()));
                findViewById.setLayoutParams(layoutParams);
                view.setBackgroundColor(this.gBF.getResources().getColor(d.e.white_alpha0));
                view.setOnClickListener(this.gCk);
            } else if (mVar.getType() == 1) {
                View findViewById2 = view.findViewById(d.h.item_main_view);
                ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
                if (this.mDataList.size() - i <= 3) {
                    layoutParams2.height = com.baidu.adp.lib.util.k.f(this.gBF.getPageContext().getContext(), d.f.ds140);
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
                    bVar.rootView.setPadding(0, paddingTop, this.eAW, 0);
                } else if (i2 == 1) {
                    bVar.rootView.setPadding(this.eAV, paddingTop, this.eAV, 0);
                } else {
                    bVar.rootView.setPadding(this.eAW, paddingTop, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams3 = bVar.gCr.getLayoutParams();
                layoutParams3.height = this.mItemHeight;
                bVar.gCr.setLayoutParams(layoutParams3);
                bVar.gCr.setTag(null);
                bVar.gCr.setRadius(1);
                bVar.gCr.setDefaultResource(d.g.img_default_100);
                bVar.gCr.c(null, 12, false);
                bVar.gCr.invalidate();
                final a aVar = new a();
                aVar.gCq = true;
                final ImageFileInfo aoD = mVar.aoD();
                if (aoD != null) {
                    if (aoD.isGif()) {
                        bVar.gCs.setVisibility(0);
                        aj.j(bVar.gCs, d.g.ic_image_gif);
                    } else {
                        bVar.gCs.setVisibility(8);
                    }
                    aoD.clearPageActions();
                    aoD.addPageAction(com.baidu.tbadk.img.effect.d.J(this.mWidth, this.mWidth));
                    bVar.gCr.setTag(aoD.toCachedKey(false));
                    if (this.ayl.a(aoD, false) != null) {
                        bVar.gCr.invalidate();
                    } else {
                        this.ayl.a(aoD, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.album.k.1
                            @Override // com.baidu.tbadk.imageManager.b
                            public void a(com.baidu.adp.widget.a.a aVar2, String str, boolean z) {
                                HeadImageView headImageView = (HeadImageView) viewGroup.findViewWithTag(str);
                                if (headImageView != null && aVar2 != null) {
                                    headImageView.invalidate();
                                } else {
                                    aVar.gCq = false;
                                }
                            }
                        }, false, this.eAX);
                    }
                } else {
                    aVar.gCq = false;
                }
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (this.gCh != null) {
                    if (this.gCh.isAdded(aoD)) {
                        bVar.cfJ.setContentDescription(this.gBF.getResources().getString(d.l.check_box_checked));
                        aj.j(bVar.cfJ, d.g.ic_post_image_selected_s);
                    } else {
                        bVar.cfJ.setContentDescription(this.gBF.getResources().getString(d.l.check_box_not_checked));
                        aj.j(bVar.cfJ, d.g.ic_post_image_selected_n);
                    }
                    a(bVar, aVar, i, aoD, skinType, this.gCh);
                }
                bVar.gCr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.k.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (k.this.gCi != null && aVar.gCq) {
                            k.this.gCi.a(i - 3, aoD);
                        }
                    }
                });
            }
        }
        return view;
    }

    public boolean isScroll() {
        return this.eAX;
    }

    public void iH(boolean z) {
        this.eAX = z;
    }

    public void a(i iVar) {
        this.gCi = iVar;
    }

    public void a(j jVar) {
        this.gCj = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b {
        ImageView cfJ;
        HeadImageView gCr;
        View gCs;
        RelativeLayout goi;
        View rootView;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        boolean gCq;

        private a() {
        }
    }

    private void a(final b bVar, final a aVar, final int i, final ImageFileInfo imageFileInfo, int i2, final e eVar) {
        bVar.goi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.album.k.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (k.this.gCj != null && aVar.gCq) {
                    boolean isAdded = eVar.isAdded(imageFileInfo);
                    if (k.this.gCj.a(i, imageFileInfo, !isAdded)) {
                        if (!isAdded) {
                            aj.j(bVar.cfJ, d.g.ic_post_image_selected_s);
                            bVar.cfJ.setContentDescription(k.this.gBF.getResources().getString(d.l.check_box_checked));
                            return;
                        }
                        aj.j(bVar.cfJ, d.g.ic_post_image_selected_n);
                        bVar.cfJ.setContentDescription(k.this.gBF.getResources().getString(d.l.check_box_not_checked));
                    }
                }
            }
        });
    }

    public int h(ImageFileInfo imageFileInfo) {
        ImageFileInfo aoD;
        if (imageFileInfo == null || imageFileInfo.getFilePath() == null) {
            return -1;
        }
        if (this.mDataList == null || this.mDataList.size() == 0) {
            return -1;
        }
        int size = this.mDataList.size();
        for (int i = 0; i < size; i++) {
            m mVar = this.mDataList.get(i);
            if (mVar != null && (aoD = mVar.aoD()) != null && aoD.getFilePath() != null && aoD.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return -1;
    }

    public void h(View.OnClickListener onClickListener) {
        this.gCk = onClickListener;
    }
}
