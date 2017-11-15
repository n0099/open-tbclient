package com.baidu.tieba.write.album;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class k extends BaseAdapter {
    private com.baidu.tbadk.img.b ayc;
    int eCA;
    private boolean eCB;
    int eCz;
    private AlbumActivity gRD;
    private e gSb;
    private i gSc;
    private j gSd;
    private View.OnClickListener gSe;
    private List<m> mDataList = new ArrayList();
    private int mItemHeight;
    private int mWidth;

    public k(AlbumActivity albumActivity, e eVar) {
        this.gRD = albumActivity;
        this.ayc = albumActivity.aOP();
        this.gSb = eVar;
        this.mWidth = (int) this.gRD.getResources().getDimension(d.e.ds220);
        this.eCz = com.baidu.adp.lib.util.l.f(this.gRD.getPageContext().getPageActivity(), d.e.ds8) / 3;
        this.eCA = (this.eCz * 2) + 1;
    }

    public void setData(List<m> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void vn(int i) {
        this.mItemHeight = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDataList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pj */
    public ImageFileInfo getItem(int i) {
        if (this.mDataList.get(i) != null) {
            return this.mDataList.get(i).bDq();
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
        m mVar = this.mDataList.get(i);
        if (mVar == null) {
            view.setVisibility(4);
        } else {
            ImageFileInfo bDq = mVar.bDq();
            if (mVar.getType() == 0 || mVar.getType() == 1) {
                if (view == null || view.findViewById(d.g.filling_item) == null) {
                    view = LayoutInflater.from(this.gRD.getPageContext().getPageActivity()).inflate(d.h.album_filling_item, (ViewGroup) null);
                    bVar = null;
                } else {
                    bVar = null;
                }
            } else if (view == null || !(view.getTag() instanceof b)) {
                b bVar2 = new b();
                view = LayoutInflater.from(this.gRD.getPageContext().getPageActivity()).inflate(d.h.album_image_item_view, viewGroup, false);
                bVar2.rootView = view;
                bVar2.gSh = (HeadImageView) view.findViewById(d.g.pic);
                bVar2.gSh.setGifIconSupport(true);
                bVar2.gSh.setLongIconSupport(true);
                bVar2.cnf = (ImageView) view.findViewById(d.g.select_icon);
                bVar2.gvB = (RelativeLayout) view.findViewById(d.g.lay_select);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (mVar.getType() == 0) {
                View findViewById = view.findViewById(d.g.item_main_view);
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                layoutParams.height = (int) (0.28f * com.baidu.adp.lib.util.l.ae(this.gRD.getPageContext().getPageActivity()));
                findViewById.setLayoutParams(layoutParams);
                view.setBackgroundColor(this.gRD.getResources().getColor(d.C0080d.white_alpha0));
                view.setOnClickListener(this.gSe);
            } else if (mVar.getType() == 1) {
                View findViewById2 = view.findViewById(d.g.item_main_view);
                ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
                if (this.mDataList.size() - i <= 3) {
                    layoutParams2.height = com.baidu.adp.lib.util.l.f(this.gRD.getPageContext().getContext(), d.e.ds140);
                } else {
                    layoutParams2.height = this.mItemHeight;
                }
                findViewById2.setLayoutParams(layoutParams2);
                aj.k(view, d.C0080d.cp_bg_line_k);
                view.setOnClickListener(null);
            } else {
                aj.k(view, d.C0080d.cp_bg_line_k);
                int paddingTop = bVar.rootView.getPaddingTop();
                int i2 = i % 3;
                if (i2 == 0) {
                    bVar.rootView.setPadding(0, paddingTop, this.eCA, 0);
                } else if (i2 == 1) {
                    bVar.rootView.setPadding(this.eCz, paddingTop, this.eCz, 0);
                } else {
                    bVar.rootView.setPadding(this.eCA, paddingTop, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams3 = bVar.gSh.getLayoutParams();
                layoutParams3.height = this.mItemHeight;
                bVar.gSh.setLayoutParams(layoutParams3);
                bVar.gSh.setTag(null);
                bVar.gSh.setRadius(1);
                bVar.gSh.setDefaultResource(d.f.img_default_100);
                bVar.gSh.startLoad(null, 12, false);
                bVar.gSh.invalidate();
                a(bVar, bDq, viewGroup);
                a(bVar, bDq);
                a aVar = new a(bVar, bDq, i);
                bVar.gSh.setOnClickListener(aVar);
                bVar.gvB.setOnClickListener(aVar);
            }
        }
        return view;
    }

    private void a(b bVar, ImageFileInfo imageFileInfo) {
        if (this.gSb != null && imageFileInfo != null) {
            if (this.gSb.isAdded(imageFileInfo)) {
                bVar.cnf.setContentDescription(this.gRD.getResources().getString(d.j.check_box_checked));
                aj.j(bVar.cnf, d.f.ic_post_image_selected_s);
                return;
            }
            bVar.cnf.setContentDescription(this.gRD.getResources().getString(d.j.check_box_not_checked));
            aj.j(bVar.cnf, d.f.ic_post_image_selected_n);
        }
    }

    /* loaded from: classes2.dex */
    private class a implements View.OnClickListener {
        private b gSg;
        private ImageFileInfo imageFileInfo;
        private int position;

        public a(b bVar, ImageFileInfo imageFileInfo, int i) {
            this.gSg = bVar;
            this.imageFileInfo = imageFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.gSg != null) {
                if (view == this.gSg.gSh) {
                    if (k.this.gSc != null && this.imageFileInfo != null) {
                        k.this.gSc.a(this.position - 3, this.imageFileInfo);
                    }
                } else if (view == this.gSg.gvB && k.this.gSb != null && k.this.gSd != null && this.imageFileInfo != null) {
                    boolean isAdded = k.this.gSb.isAdded(this.imageFileInfo);
                    if (k.this.gSd.a(this.position, this.imageFileInfo, !isAdded)) {
                        if (!isAdded) {
                            aj.j(this.gSg.cnf, d.f.ic_post_image_selected_s);
                            this.gSg.cnf.setContentDescription(k.this.gRD.getResources().getString(d.j.check_box_checked));
                            return;
                        }
                        aj.j(this.gSg.cnf, d.f.ic_post_image_selected_n);
                        this.gSg.cnf.setContentDescription(k.this.gRD.getResources().getString(d.j.check_box_not_checked));
                    }
                }
            }
        }
    }

    private void a(b bVar, ImageFileInfo imageFileInfo, final ViewGroup viewGroup) {
        if (imageFileInfo != null && bVar != null && bVar.gSh != null) {
            bVar.gSh.setIsLongPic(imageFileInfo.isLong());
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.K(this.mWidth, this.mWidth));
            bVar.gSh.setTag(imageFileInfo.toCachedKey(false));
            if (this.ayc.a(imageFileInfo, false) != null) {
                bVar.gSh.invalidate();
            } else {
                this.ayc.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.album.k.1
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                        HeadImageView headImageView;
                        if (viewGroup != null && (headImageView = (HeadImageView) viewGroup.findViewWithTag(str)) != null && aVar != null) {
                            headImageView.invalidate();
                        }
                    }
                }, false, this.eCB);
            }
        }
    }

    public boolean isScroll() {
        return this.eCB;
    }

    public void is(boolean z) {
        this.eCB = z;
    }

    public void a(i iVar) {
        this.gSc = iVar;
    }

    public void a(j jVar) {
        this.gSd = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b {
        ImageView cnf;
        HeadImageView gSh;
        RelativeLayout gvB;
        View rootView;

        private b() {
        }
    }

    public int g(ImageFileInfo imageFileInfo) {
        ImageFileInfo bDq;
        if (imageFileInfo == null || imageFileInfo.getFilePath() == null) {
            return -1;
        }
        if (this.mDataList == null || this.mDataList.size() == 0) {
            return -1;
        }
        int size = this.mDataList.size();
        for (int i = 0; i < size; i++) {
            m mVar = this.mDataList.get(i);
            if (mVar != null && (bDq = mVar.bDq()) != null && bDq.getFilePath() != null && bDq.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return -1;
    }

    public void U(View.OnClickListener onClickListener) {
        this.gSe = onClickListener;
    }
}
