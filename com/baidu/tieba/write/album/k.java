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
    private AlbumActivity gGM;
    private e gHk;
    private i gHl;
    private j gHm;
    private View.OnClickListener gHn;
    private List<m> mDataList = new ArrayList();
    private int mItemHeight;
    private int mWidth;

    public k(AlbumActivity albumActivity, e eVar) {
        this.gGM = albumActivity;
        this.axw = albumActivity.aLU();
        this.gHk = eVar;
        this.mWidth = (int) this.gGM.getResources().getDimension(d.f.ds220);
        this.euk = com.baidu.adp.lib.util.l.f(this.gGM.getPageContext().getPageActivity(), d.f.ds8) / 3;
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
            return this.mDataList.get(i).bzM();
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
            ImageFileInfo bzM = mVar.bzM();
            if (mVar.getType() == 0 || mVar.getType() == 1) {
                if (view == null || view.findViewById(d.h.filling_item) == null) {
                    view = LayoutInflater.from(this.gGM.getPageContext().getPageActivity()).inflate(d.j.album_filling_item, (ViewGroup) null);
                    bVar = null;
                } else {
                    bVar = null;
                }
            } else if (view == null || !(view.getTag() instanceof b)) {
                b bVar2 = new b();
                view = LayoutInflater.from(this.gGM.getPageContext().getPageActivity()).inflate(d.j.album_image_item_view, viewGroup, false);
                bVar2.rootView = view;
                bVar2.gHq = (HeadImageView) view.findViewById(d.h.pic);
                bVar2.gHq.setGifIconSupport(true);
                bVar2.gHq.setLongIconSupport(true);
                bVar2.cfE = (ImageView) view.findViewById(d.h.select_icon);
                bVar2.glU = (RelativeLayout) view.findViewById(d.h.lay_select);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (mVar.getType() == 0) {
                View findViewById = view.findViewById(d.h.item_main_view);
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                layoutParams.height = (int) (0.28f * com.baidu.adp.lib.util.l.af(this.gGM.getPageContext().getPageActivity()));
                findViewById.setLayoutParams(layoutParams);
                view.setBackgroundColor(this.gGM.getResources().getColor(d.e.white_alpha0));
                view.setOnClickListener(this.gHn);
            } else if (mVar.getType() == 1) {
                View findViewById2 = view.findViewById(d.h.item_main_view);
                ViewGroup.LayoutParams layoutParams2 = findViewById2.getLayoutParams();
                if (this.mDataList.size() - i <= 3) {
                    layoutParams2.height = com.baidu.adp.lib.util.l.f(this.gGM.getPageContext().getContext(), d.f.ds140);
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
                ViewGroup.LayoutParams layoutParams3 = bVar.gHq.getLayoutParams();
                layoutParams3.height = this.mItemHeight;
                bVar.gHq.setLayoutParams(layoutParams3);
                bVar.gHq.setTag(null);
                bVar.gHq.setRadius(1);
                bVar.gHq.setDefaultResource(d.g.img_default_100);
                bVar.gHq.c(null, 12, false);
                bVar.gHq.invalidate();
                a(bVar, bzM, viewGroup);
                a(bVar, bzM);
                a aVar = new a(bVar, bzM, i);
                bVar.gHq.setOnClickListener(aVar);
                bVar.glU.setOnClickListener(aVar);
            }
        }
        return view;
    }

    private void a(b bVar, ImageFileInfo imageFileInfo) {
        if (this.gHk != null && imageFileInfo != null) {
            if (this.gHk.isAdded(imageFileInfo)) {
                bVar.cfE.setContentDescription(this.gGM.getResources().getString(d.l.check_box_checked));
                aj.j(bVar.cfE, d.g.ic_post_image_selected_s);
                return;
            }
            bVar.cfE.setContentDescription(this.gGM.getResources().getString(d.l.check_box_not_checked));
            aj.j(bVar.cfE, d.g.ic_post_image_selected_n);
        }
    }

    /* loaded from: classes2.dex */
    private class a implements View.OnClickListener {
        private b gHp;
        private ImageFileInfo imageFileInfo;
        private int position;

        public a(b bVar, ImageFileInfo imageFileInfo, int i) {
            this.gHp = bVar;
            this.imageFileInfo = imageFileInfo;
            this.position = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.gHp != null) {
                if (view == this.gHp.gHq) {
                    if (k.this.gHl != null && this.imageFileInfo != null) {
                        k.this.gHl.a(this.position - 3, this.imageFileInfo);
                    }
                } else if (view == this.gHp.glU && k.this.gHk != null && k.this.gHm != null && this.imageFileInfo != null) {
                    boolean isAdded = k.this.gHk.isAdded(this.imageFileInfo);
                    if (k.this.gHm.a(this.position, this.imageFileInfo, !isAdded)) {
                        if (!isAdded) {
                            aj.j(this.gHp.cfE, d.g.ic_post_image_selected_s);
                            this.gHp.cfE.setContentDescription(k.this.gGM.getResources().getString(d.l.check_box_checked));
                            return;
                        }
                        aj.j(this.gHp.cfE, d.g.ic_post_image_selected_n);
                        this.gHp.cfE.setContentDescription(k.this.gGM.getResources().getString(d.l.check_box_not_checked));
                    }
                }
            }
        }
    }

    private void a(b bVar, ImageFileInfo imageFileInfo, final ViewGroup viewGroup) {
        if (imageFileInfo != null && bVar != null && bVar.gHq != null) {
            bVar.gHq.setIsLongPic(imageFileInfo.isLong());
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.K(this.mWidth, this.mWidth));
            bVar.gHq.setTag(imageFileInfo.toCachedKey(false));
            if (this.axw.a(imageFileInfo, false) != null) {
                bVar.gHq.invalidate();
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
        this.gHl = iVar;
    }

    public void a(j jVar) {
        this.gHm = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b {
        ImageView cfE;
        HeadImageView gHq;
        RelativeLayout glU;
        View rootView;

        private b() {
        }
    }

    public int g(ImageFileInfo imageFileInfo) {
        ImageFileInfo bzM;
        if (imageFileInfo == null || imageFileInfo.getFilePath() == null) {
            return -1;
        }
        if (this.mDataList == null || this.mDataList.size() == 0) {
            return -1;
        }
        int size = this.mDataList.size();
        for (int i = 0; i < size; i++) {
            m mVar = this.mDataList.get(i);
            if (mVar != null && (bzM = mVar.bzM()) != null && bzM.getFilePath() != null && bzM.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return -1;
    }

    public void h(View.OnClickListener onClickListener) {
        this.gHn = onClickListener;
    }
}
