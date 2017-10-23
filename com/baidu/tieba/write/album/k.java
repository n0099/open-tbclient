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
    private com.baidu.tbadk.img.b axk;
    int etW;
    int etX;
    private boolean etY;
    private e gGV;
    private i gGW;
    private j gGX;
    private View.OnClickListener gGY;
    private AlbumActivity gGx;
    private List<m> mDataList = new ArrayList();
    private int mItemHeight;
    private int mWidth;

    public k(AlbumActivity albumActivity, e eVar) {
        this.gGx = albumActivity;
        this.axk = albumActivity.aLP();
        this.gGV = eVar;
        this.mWidth = (int) this.gGx.getResources().getDimension(d.f.ds220);
        this.etW = com.baidu.adp.lib.util.l.f(this.gGx.getPageContext().getPageActivity(), d.f.ds8) / 3;
        this.etX = (this.etW * 2) + 1;
    }

    public void setData(List<m> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void uP(int i) {
        this.mItemHeight = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDataList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oO */
    public ImageFileInfo getItem(int i) {
        if (this.mDataList.get(i) != null) {
            return this.mDataList.get(i).bzG();
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
            ImageFileInfo bzG = mVar.bzG();
            if (mVar.getType() == 0 || mVar.getType() == 1) {
                if (view == null || view.findViewById(d.h.filling_item) == null) {
                    view = LayoutInflater.from(this.gGx.getPageContext().getPageActivity()).inflate(d.j.album_filling_item, (ViewGroup) null);
                    bVar = null;
                } else {
                    bVar = null;
                }
            } else if (view == null || !(view.getTag() instanceof b)) {
                b bVar2 = new b();
                view = LayoutInflater.from(this.gGx.getPageContext().getPageActivity()).inflate(d.j.album_image_item_view, viewGroup, false);
                bVar2.rootView = view;
                bVar2.gHb = (HeadImageView) view.findViewById(d.h.pic);
                bVar2.gHb.setGifIconSupport(true);
                bVar2.gHb.setLongIconSupport(true);
                bVar2.cfs = (ImageView) view.findViewById(d.h.select_icon);
                bVar2.glG = (RelativeLayout) view.findViewById(d.h.lay_select);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (mVar.getType() == 0) {
                View findViewById = view.findViewById(d.h.item_main_view);
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                layoutParams.height = (int) (0.28f * com.baidu.adp.lib.util.l.af(this.gGx.getPageContext().getPageActivity()));
                findViewById.setLayoutParams(layoutParams);
                view.setBackgroundColor(this.gGx.getResources().getColor(d.e.white_alpha0));
                view.setOnClickListener(this.gGY);
            } else if (mVar.getType() == 1) {
                View findViewById2 = view.findViewById(d.h.item_main_view);
                ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
                if (this.mDataList.size() - i <= 3) {
                    layoutParams2.height = com.baidu.adp.lib.util.l.f(this.gGx.getPageContext().getContext(), d.f.ds140);
                } else {
                    layoutParams2.height = this.mItemHeight;
                }
                findViewById2.setLayoutParams(layoutParams2);
                aj.k(view, d.e.cp_bg_line_k);
                view.setOnClickListener(null);
            } else {
                aj.k(view, d.e.cp_bg_line_k);
                int paddingTop = bVar.rootView.getPaddingTop();
                int i2 = i % 3;
                if (i2 == 0) {
                    bVar.rootView.setPadding(0, paddingTop, this.etX, 0);
                } else if (i2 == 1) {
                    bVar.rootView.setPadding(this.etW, paddingTop, this.etW, 0);
                } else {
                    bVar.rootView.setPadding(this.etX, paddingTop, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams3 = bVar.gHb.getLayoutParams();
                layoutParams3.height = this.mItemHeight;
                bVar.gHb.setLayoutParams(layoutParams3);
                bVar.gHb.setTag(null);
                bVar.gHb.setRadius(1);
                bVar.gHb.setDefaultResource(d.g.img_default_100);
                bVar.gHb.c(null, 12, false);
                bVar.gHb.invalidate();
                a(bVar, bzG, viewGroup);
                a(bVar, bzG);
                a aVar = new a(bVar, bzG, i);
                bVar.gHb.setOnClickListener(aVar);
                bVar.glG.setOnClickListener(aVar);
            }
        }
        return view;
    }

    private void a(b bVar, ImageFileInfo imageFileInfo) {
        if (this.gGV != null && imageFileInfo != null) {
            if (this.gGV.isAdded(imageFileInfo)) {
                bVar.cfs.setContentDescription(this.gGx.getResources().getString(d.l.check_box_checked));
                aj.j(bVar.cfs, d.g.ic_post_image_selected_s);
                return;
            }
            bVar.cfs.setContentDescription(this.gGx.getResources().getString(d.l.check_box_not_checked));
            aj.j(bVar.cfs, d.g.ic_post_image_selected_n);
        }
    }

    /* loaded from: classes2.dex */
    private class a implements View.OnClickListener {
        private b gHa;
        private ImageFileInfo imageFileInfo;
        private int position;

        public a(b bVar, ImageFileInfo imageFileInfo, int i) {
            this.gHa = bVar;
            this.imageFileInfo = imageFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.gHa != null) {
                if (view == this.gHa.gHb) {
                    if (k.this.gGW != null && this.imageFileInfo != null) {
                        k.this.gGW.a(this.position - 3, this.imageFileInfo);
                    }
                } else if (view == this.gHa.glG && k.this.gGV != null && k.this.gGX != null && this.imageFileInfo != null) {
                    boolean isAdded = k.this.gGV.isAdded(this.imageFileInfo);
                    if (k.this.gGX.a(this.position, this.imageFileInfo, !isAdded)) {
                        if (!isAdded) {
                            aj.j(this.gHa.cfs, d.g.ic_post_image_selected_s);
                            this.gHa.cfs.setContentDescription(k.this.gGx.getResources().getString(d.l.check_box_checked));
                            return;
                        }
                        aj.j(this.gHa.cfs, d.g.ic_post_image_selected_n);
                        this.gHa.cfs.setContentDescription(k.this.gGx.getResources().getString(d.l.check_box_not_checked));
                    }
                }
            }
        }
    }

    private void a(b bVar, ImageFileInfo imageFileInfo, final ViewGroup viewGroup) {
        if (imageFileInfo != null && bVar != null && bVar.gHb != null) {
            bVar.gHb.setIsLongPic(imageFileInfo.isLong());
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.K(this.mWidth, this.mWidth));
            bVar.gHb.setTag(imageFileInfo.toCachedKey(false));
            if (this.axk.a(imageFileInfo, false) != null) {
                bVar.gHb.invalidate();
            } else {
                this.axk.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.album.k.1
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        HeadImageView headImageView;
                        if (viewGroup != null && (headImageView = (HeadImageView) viewGroup.findViewWithTag(str)) != null && aVar != null) {
                            headImageView.invalidate();
                        }
                    }
                }, false, this.etY);
            }
        }
    }

    public boolean isScroll() {
        return this.etY;
    }

    public void iq(boolean z) {
        this.etY = z;
    }

    public void a(i iVar) {
        this.gGW = iVar;
    }

    public void a(j jVar) {
        this.gGX = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b {
        ImageView cfs;
        HeadImageView gHb;
        RelativeLayout glG;
        View rootView;

        private b() {
        }
    }

    public int g(ImageFileInfo imageFileInfo) {
        ImageFileInfo bzG;
        if (imageFileInfo == null || imageFileInfo.getFilePath() == null) {
            return -1;
        }
        if (this.mDataList == null || this.mDataList.size() == 0) {
            return -1;
        }
        int size = this.mDataList.size();
        for (int i = 0; i < size; i++) {
            m mVar = this.mDataList.get(i);
            if (mVar != null && (bzG = mVar.bzG()) != null && bzG.getFilePath() != null && bzG.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return -1;
    }

    public void h(View.OnClickListener onClickListener) {
        this.gGY = onClickListener;
    }
}
