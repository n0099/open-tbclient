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
    private com.baidu.tbadk.img.b avZ;
    private AlbumActivity fMV;
    private o fNV;
    private boolean fNW;
    private boolean fNX;
    private z fNY;
    private x fNZ;
    private aa fOa;
    private List<ImageFileInfo> mList;
    private int mWidth;

    public ab(AlbumActivity albumActivity, o oVar) {
        this.fMV = albumActivity;
        this.avZ = albumActivity.aho();
        this.fNV = oVar;
        this.mWidth = (int) this.fMV.getResources().getDimension(w.f.ds220);
    }

    public void setData(List<ImageFileInfo> list, boolean z) {
        this.mList = list;
        this.fNW = z;
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
    /* renamed from: sN */
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
        if (this.fNW && i == 0) {
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
                view = LayoutInflater.from(this.fMV.getPageContext().getPageActivity()).inflate(w.j.album_image_item_view, viewGroup, false);
                bVar.fOh = (HeadImageView) view.findViewById(w.h.pic);
                bVar.fAL = (ImageView) view.findViewById(w.h.select_icon);
                bVar.fAM = (RelativeLayout) view.findViewById(w.h.lay_select);
                view.setTag(bVar);
            } else if (itemViewType == 1) {
                view = LayoutInflater.from(this.fMV.getPageContext().getPageActivity()).inflate(w.j.album_image_item_view_camera, viewGroup, false);
                bVar.fOi = (ViewGroup) view.findViewById(w.h.item_camera);
                view.setTag(bVar);
            } else if (itemViewType == 2) {
                view = new View(this.fMV.getActivity());
                view.setLayoutParams(new AbsListView.LayoutParams(com.baidu.adp.lib.util.k.g(this.fMV.getActivity(), w.f.ds220), com.baidu.adp.lib.util.k.g(this.fMV.getActivity(), w.f.ds180)));
            }
        } else {
            bVar = (b) view.getTag();
        }
        ImageFileInfo item = getItem(i);
        if (itemViewType == 0) {
            bVar.fOh.setTag(null);
            bVar.fOh.setRadius(1);
            bVar.fOh.setDefaultResource(w.g.img_default_100);
            bVar.fOh.c(null, 12, false);
            int i2 = i + 1;
            if (this.fNW) {
                i2 = i;
            }
            bVar.fOh.setContentDescription(String.valueOf(view.getResources().getString(w.l.editor_image)) + i2 + " " + item.getModifyTime());
            bVar.fOh.invalidate();
            a aVar = new a(this, null);
            aVar.fOg = true;
            if (item != null) {
                item.clearPageActions();
                item.addPageAction(com.baidu.tbadk.img.effect.d.M(this.mWidth, this.mWidth));
                bVar.fOh.setTag(item.toCachedKey(false));
                if (this.avZ.a(item, false) != null) {
                    bVar.fOh.invalidate();
                } else {
                    this.avZ.a(item, new ac(this, viewGroup, aVar), false, this.fNX);
                }
            } else {
                aVar.fOg = false;
            }
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            if (this.fNV != null) {
                if (this.fNV.isAdded(item)) {
                    bVar.fAL.setContentDescription(this.fMV.getResources().getString(w.l.check_box_checked));
                    aq.j(bVar.fAL, w.g.chx_camera_pic_s);
                } else {
                    bVar.fAL.setContentDescription(this.fMV.getResources().getString(w.l.check_box_not_checked));
                    aq.j(bVar.fAL, w.g.chx_camera_pic_n);
                }
                a(bVar, aVar, i, item, skinType, this.fNV);
            }
            bVar.fOh.setOnClickListener(new ad(this, aVar, i, item));
        } else if (itemViewType == 1) {
            aq.j(bVar.fOi, w.g.icon_camera_pic);
            bVar.fOi.setOnClickListener(new ae(this, i, item));
        }
        ak(view);
        return view;
    }

    public boolean isScroll() {
        return this.fNX;
    }

    public void lM(boolean z) {
        this.fNX = z;
    }

    private void ak(View view) {
        this.fMV.getLayoutMode().aj(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.fMV.getLayoutMode().t(view);
    }

    public void a(z zVar) {
        this.fNY = zVar;
    }

    public void a(aa aaVar) {
        this.fOa = aaVar;
    }

    public void a(x xVar) {
        this.fNZ = xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        ImageView fAL;
        RelativeLayout fAM;
        HeadImageView fOh;
        ViewGroup fOi;

        private b() {
        }

        /* synthetic */ b(ab abVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        boolean fOg;

        private a() {
        }

        /* synthetic */ a(ab abVar, a aVar) {
            this();
        }
    }

    private void a(b bVar, a aVar, int i, ImageFileInfo imageFileInfo, int i2, o oVar) {
        bVar.fAM.setOnClickListener(new af(this, aVar, oVar, imageFileInfo, i, bVar));
    }
}
