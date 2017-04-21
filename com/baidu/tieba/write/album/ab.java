package com.baidu.tieba.write.album;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class ab extends BaseAdapter {
    private com.baidu.tbadk.img.b awb;
    private AlbumActivity fPr;
    private o fQr;
    private boolean fQs;
    private boolean fQt;
    private z fQu;
    private x fQv;
    private aa fQw;
    private List<ImageFileInfo> mList;
    private int mWidth;

    public ab(AlbumActivity albumActivity, o oVar) {
        this.fPr = albumActivity;
        this.awb = albumActivity.aip();
        this.fQr = oVar;
        this.mWidth = (int) this.fPr.getResources().getDimension(w.f.ds220);
    }

    public void setData(List<ImageFileInfo> list, boolean z) {
        this.mList = list;
        this.fQs = z;
        notifyDataSetChanged();
    }

    public int i(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null || imageFileInfo.getFilePath() == null) {
            return -1;
        }
        if (this.mList == null || this.mList.size() == 0) {
            return -1;
        }
        int size = this.mList.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo2 = (ImageFileInfo) com.baidu.tbadk.core.util.x.c(this.mList, i);
            if (imageFileInfo2 != null && imageFileInfo2.getFilePath() != null && imageFileInfo2.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mList != null) {
            return this.mList.size() + 3;
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sT */
    public ImageFileInfo getItem(int i) {
        if (this.mList == null || i < 0 || i >= this.mList.size()) {
            return null;
        }
        return this.mList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.fQs && i == 0) {
            return 1;
        }
        if (i < this.mList.size()) {
            return 0;
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            bVar = new b(this, null);
            if (itemViewType == 0) {
                view = LayoutInflater.from(this.fPr.getPageContext().getPageActivity()).inflate(w.j.album_image_item_view, viewGroup, false);
                bVar.fQD = (HeadImageView) view.findViewById(w.h.pic);
                bVar.fDb = (ImageView) view.findViewById(w.h.select_icon);
                bVar.fDc = (RelativeLayout) view.findViewById(w.h.lay_select);
                view.setTag(bVar);
            } else if (itemViewType == 1) {
                view = LayoutInflater.from(this.fPr.getPageContext().getPageActivity()).inflate(w.j.album_image_item_view_camera, viewGroup, false);
                bVar.fQE = (ViewGroup) view.findViewById(w.h.item_camera);
                view.setTag(bVar);
            } else if (itemViewType == 2) {
                view = new View(this.fPr.getActivity());
                view.setLayoutParams(new AbsListView.LayoutParams(com.baidu.adp.lib.util.k.g(this.fPr.getActivity(), w.f.ds220), com.baidu.adp.lib.util.k.g(this.fPr.getActivity(), w.f.ds180)));
            }
        } else {
            bVar = (b) view.getTag();
        }
        ImageFileInfo item = getItem(i);
        if (itemViewType == 0) {
            bVar.fQD.setTag(null);
            bVar.fQD.setRadius(1);
            bVar.fQD.setDefaultResource(w.g.img_default_100);
            bVar.fQD.c(null, 12, false);
            int i2 = i + 1;
            if (this.fQs) {
                i2 = i;
            }
            bVar.fQD.setContentDescription(String.valueOf(view.getResources().getString(w.l.editor_image)) + i2 + " " + item.getModifyTime());
            bVar.fQD.invalidate();
            a aVar = new a(this, null);
            aVar.fQC = true;
            if (item != null) {
                item.clearPageActions();
                item.addPageAction(com.baidu.tbadk.img.effect.d.M(this.mWidth, this.mWidth));
                bVar.fQD.setTag(item.toCachedKey(false));
                if (this.awb.a(item, false) != null) {
                    bVar.fQD.invalidate();
                } else {
                    this.awb.a(item, new ac(this, viewGroup, aVar), false, this.fQt);
                }
            } else {
                aVar.fQC = false;
            }
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            if (this.fQr != null) {
                if (this.fQr.isAdded(item)) {
                    bVar.fDb.setContentDescription(this.fPr.getResources().getString(w.l.check_box_checked));
                    aq.j(bVar.fDb, w.g.chx_camera_pic_s);
                } else {
                    bVar.fDb.setContentDescription(this.fPr.getResources().getString(w.l.check_box_not_checked));
                    aq.j(bVar.fDb, w.g.chx_camera_pic_n);
                }
                a(bVar, aVar, i, item, skinType, this.fQr);
            }
            bVar.fQD.setOnClickListener(new ad(this, aVar, i, item));
        } else if (itemViewType == 1) {
            aq.j(bVar.fQE, w.g.icon_camera_pic);
            bVar.fQE.setOnClickListener(new ae(this, i, item));
        }
        ak(view);
        return view;
    }

    public boolean isScroll() {
        return this.fQt;
    }

    public void lW(boolean z) {
        this.fQt = z;
    }

    private void ak(View view) {
        this.fPr.getLayoutMode().aj(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.fPr.getLayoutMode().t(view);
    }

    public void a(z zVar) {
        this.fQu = zVar;
    }

    public void a(aa aaVar) {
        this.fQw = aaVar;
    }

    public void a(x xVar) {
        this.fQv = xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        ImageView fDb;
        RelativeLayout fDc;
        HeadImageView fQD;
        ViewGroup fQE;

        private b() {
        }

        /* synthetic */ b(ab abVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        boolean fQC;

        private a() {
        }

        /* synthetic */ a(ab abVar, a aVar) {
            this();
        }
    }

    private void a(b bVar, a aVar, int i, ImageFileInfo imageFileInfo, int i2, o oVar) {
        bVar.fDc.setOnClickListener(new af(this, aVar, oVar, imageFileInfo, i, bVar));
    }
}
