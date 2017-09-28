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
    private com.baidu.tbadk.img.b axw;
    int euk;
    int eul;
    private boolean eum;
    private AlbumActivity gGN;
    private e gHl;
    private i gHm;
    private j gHn;
    private View.OnClickListener gHo;
    private List<m> mDataList = new ArrayList();
    private int mItemHeight;
    private int mWidth;

    public k(AlbumActivity albumActivity, e eVar) {
        this.gGN = albumActivity;
        this.axw = albumActivity.aLU();
        this.gHl = eVar;
        this.mWidth = (int) this.gGN.getResources().getDimension(d.f.ds220);
        this.euk = com.baidu.adp.lib.util.l.f(this.gGN.getPageContext().getPageActivity(), d.f.ds8) / 3;
        this.eul = (this.euk * 2) + 1;
    }

    public void setData(List<m> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void uQ(int i) {
        this.mItemHeight = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDataList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oP */
    public ImageFileInfo getItem(int i) {
        if (this.mDataList.get(i) != null) {
            return this.mDataList.get(i).bzN();
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
            ImageFileInfo bzN = mVar.bzN();
            if (mVar.getType() == 0 || mVar.getType() == 1) {
                if (view == null || view.findViewById(d.h.filling_item) == null) {
                    view = LayoutInflater.from(this.gGN.getPageContext().getPageActivity()).inflate(d.j.album_filling_item, (ViewGroup) null);
                    bVar = null;
                } else {
                    bVar = null;
                }
            } else if (view == null || !(view.getTag() instanceof b)) {
                b bVar2 = new b();
                view = LayoutInflater.from(this.gGN.getPageContext().getPageActivity()).inflate(d.j.album_image_item_view, viewGroup, false);
                bVar2.rootView = view;
                bVar2.gHr = (HeadImageView) view.findViewById(d.h.pic);
                bVar2.gHr.setGifIconSupport(true);
                bVar2.gHr.setLongIconSupport(true);
                bVar2.cfE = (ImageView) view.findViewById(d.h.select_icon);
                bVar2.glV = (RelativeLayout) view.findViewById(d.h.lay_select);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (mVar.getType() == 0) {
                View findViewById = view.findViewById(d.h.item_main_view);
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                layoutParams.height = (int) (0.28f * com.baidu.adp.lib.util.l.af(this.gGN.getPageContext().getPageActivity()));
                findViewById.setLayoutParams(layoutParams);
                view.setBackgroundColor(this.gGN.getResources().getColor(d.e.white_alpha0));
                view.setOnClickListener(this.gHo);
            } else if (mVar.getType() == 1) {
                View findViewById2 = view.findViewById(d.h.item_main_view);
                ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
                if (this.mDataList.size() - i <= 3) {
                    layoutParams2.height = com.baidu.adp.lib.util.l.f(this.gGN.getPageContext().getContext(), d.f.ds140);
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
                    bVar.rootView.setPadding(0, paddingTop, this.eul, 0);
                } else if (i2 == 1) {
                    bVar.rootView.setPadding(this.euk, paddingTop, this.euk, 0);
                } else {
                    bVar.rootView.setPadding(this.eul, paddingTop, 0, 0);
                }
                ViewGroup.LayoutParams layoutParams3 = bVar.gHr.getLayoutParams();
                layoutParams3.height = this.mItemHeight;
                bVar.gHr.setLayoutParams(layoutParams3);
                bVar.gHr.setTag(null);
                bVar.gHr.setRadius(1);
                bVar.gHr.setDefaultResource(d.g.img_default_100);
                bVar.gHr.c(null, 12, false);
                bVar.gHr.invalidate();
                a(bVar, bzN, viewGroup);
                a(bVar, bzN);
                a aVar = new a(bVar, bzN, i);
                bVar.gHr.setOnClickListener(aVar);
                bVar.glV.setOnClickListener(aVar);
            }
        }
        return view;
    }

    private void a(b bVar, ImageFileInfo imageFileInfo) {
        if (this.gHl != null && imageFileInfo != null) {
            if (this.gHl.isAdded(imageFileInfo)) {
                bVar.cfE.setContentDescription(this.gGN.getResources().getString(d.l.check_box_checked));
                aj.j(bVar.cfE, d.g.ic_post_image_selected_s);
                return;
            }
            bVar.cfE.setContentDescription(this.gGN.getResources().getString(d.l.check_box_not_checked));
            aj.j(bVar.cfE, d.g.ic_post_image_selected_n);
        }
    }

    /* loaded from: classes2.dex */
    private class a implements View.OnClickListener {
        private b gHq;
        private ImageFileInfo imageFileInfo;
        private int position;

        public a(b bVar, ImageFileInfo imageFileInfo, int i) {
            this.gHq = bVar;
            this.imageFileInfo = imageFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.gHq != null) {
                if (view == this.gHq.gHr) {
                    if (k.this.gHm != null && this.imageFileInfo != null) {
                        k.this.gHm.a(this.position - 3, this.imageFileInfo);
                    }
                } else if (view == this.gHq.glV && k.this.gHl != null && k.this.gHn != null && this.imageFileInfo != null) {
                    boolean isAdded = k.this.gHl.isAdded(this.imageFileInfo);
                    if (k.this.gHn.a(this.position, this.imageFileInfo, !isAdded)) {
                        if (!isAdded) {
                            aj.j(this.gHq.cfE, d.g.ic_post_image_selected_s);
                            this.gHq.cfE.setContentDescription(k.this.gGN.getResources().getString(d.l.check_box_checked));
                            return;
                        }
                        aj.j(this.gHq.cfE, d.g.ic_post_image_selected_n);
                        this.gHq.cfE.setContentDescription(k.this.gGN.getResources().getString(d.l.check_box_not_checked));
                    }
                }
            }
        }
    }

    private void a(b bVar, ImageFileInfo imageFileInfo, final ViewGroup viewGroup) {
        if (imageFileInfo != null && bVar != null && bVar.gHr != null) {
            bVar.gHr.setIsLongPic(imageFileInfo.isLong());
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.K(this.mWidth, this.mWidth));
            bVar.gHr.setTag(imageFileInfo.toCachedKey(false));
            if (this.axw.a(imageFileInfo, false) != null) {
                bVar.gHr.invalidate();
            } else {
                this.axw.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.album.k.1
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        HeadImageView headImageView;
                        if (viewGroup != null && (headImageView = (HeadImageView) viewGroup.findViewWithTag(str)) != null && aVar != null) {
                            headImageView.invalidate();
                        }
                    }
                }, false, this.eum);
            }
        }
    }

    public boolean isScroll() {
        return this.eum;
    }

    public void ir(boolean z) {
        this.eum = z;
    }

    public void a(i iVar) {
        this.gHm = iVar;
    }

    public void a(j jVar) {
        this.gHn = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b {
        ImageView cfE;
        HeadImageView gHr;
        RelativeLayout glV;
        View rootView;

        private b() {
        }
    }

    public int g(ImageFileInfo imageFileInfo) {
        ImageFileInfo bzN;
        if (imageFileInfo == null || imageFileInfo.getFilePath() == null) {
            return -1;
        }
        if (this.mDataList == null || this.mDataList.size() == 0) {
            return -1;
        }
        int size = this.mDataList.size();
        for (int i = 0; i < size; i++) {
            m mVar = this.mDataList.get(i);
            if (mVar != null && (bzN = mVar.bzN()) != null && bzN.getFilePath() != null && bzN.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return -1;
    }

    public void h(View.OnClickListener onClickListener) {
        this.gHo = onClickListener;
    }
}
