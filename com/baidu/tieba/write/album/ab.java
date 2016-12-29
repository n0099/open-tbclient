package com.baidu.tieba.write.album;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class ab extends BaseAdapter {
    private com.baidu.tbadk.img.b ari;
    private AlbumActivity fyo;
    private o fzp;
    private boolean fzq;
    private boolean fzr;
    private z fzs;
    private x fzt;
    private aa fzu;
    private List<ImageFileInfo> mList;
    private int mWidth;

    public ab(AlbumActivity albumActivity, o oVar) {
        this.fyo = albumActivity;
        this.ari = albumActivity.ahb();
        this.fzp = oVar;
        this.mWidth = (int) this.fyo.getResources().getDimension(r.e.ds220);
    }

    public void setData(List<ImageFileInfo> list, boolean z) {
        this.mList = list;
        this.fzq = z;
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
    /* renamed from: sf */
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
        if (this.fzq && i == 0) {
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
                view = LayoutInflater.from(this.fyo.getPageContext().getPageActivity()).inflate(r.h.album_image_item_view, viewGroup, false);
                bVar.fzB = (HeadImageView) view.findViewById(r.g.pic);
                bVar.flx = (ImageView) view.findViewById(r.g.select_icon);
                bVar.fly = (RelativeLayout) view.findViewById(r.g.lay_select);
                view.setTag(bVar);
            } else if (itemViewType == 1) {
                view = LayoutInflater.from(this.fyo.getPageContext().getPageActivity()).inflate(r.h.album_image_item_view_camera, viewGroup, false);
                bVar.fzC = (ViewGroup) view.findViewById(r.g.item_camera);
                view.setTag(bVar);
            } else if (itemViewType == 2) {
                view = new View(this.fyo.getActivity());
                view.setLayoutParams(new AbsListView.LayoutParams(com.baidu.adp.lib.util.k.e(this.fyo.getActivity(), r.e.ds220), com.baidu.adp.lib.util.k.e(this.fyo.getActivity(), r.e.ds180)));
            }
        } else {
            bVar = (b) view.getTag();
        }
        ImageFileInfo item = getItem(i);
        if (itemViewType == 0) {
            bVar.fzB.setTag(null);
            bVar.fzB.setRadius(1);
            bVar.fzB.setDefaultResource(r.f.img_default_100);
            bVar.fzB.c(null, 12, false);
            int i2 = i + 1;
            if (this.fzq) {
                i2 = i;
            }
            bVar.fzB.setContentDescription(String.valueOf(view.getResources().getString(r.j.log_msg_pic)) + i2 + " " + item.getModifyTime());
            bVar.fzB.invalidate();
            a aVar = new a(this, null);
            aVar.fzA = true;
            if (item != null) {
                item.clearPageActions();
                item.addPageAction(com.baidu.tbadk.img.effect.d.F(this.mWidth, this.mWidth));
                bVar.fzB.setTag(item.toCachedKey(false));
                if (this.ari.a(item, false) != null) {
                    bVar.fzB.invalidate();
                } else {
                    this.ari.a(item, new ac(this, viewGroup, aVar), false, this.fzr);
                }
            } else {
                aVar.fzA = false;
            }
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            if (this.fzp != null) {
                if (this.fzp.isAdded(item)) {
                    bVar.flx.setContentDescription(this.fyo.getResources().getString(r.j.check_box_checked));
                    ar.k(bVar.flx, r.f.chx_camera_pic_s);
                } else {
                    bVar.flx.setContentDescription(this.fyo.getResources().getString(r.j.check_box_not_checked));
                    ar.k(bVar.flx, r.f.chx_camera_pic_n);
                }
                a(bVar, aVar, i, item, skinType, this.fzp);
            }
            bVar.fzB.setOnClickListener(new ad(this, aVar, i, item));
        } else if (itemViewType == 1) {
            ar.k(bVar.fzC, r.f.icon_camera_pic);
            bVar.fzC.setOnClickListener(new ae(this, i, item));
        }
        u(view);
        return view;
    }

    public boolean isScroll() {
        return this.fzr;
    }

    public void lA(boolean z) {
        this.fzr = z;
    }

    private void u(View view) {
        this.fyo.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.fyo.getLayoutMode().x(view);
    }

    public void a(z zVar) {
        this.fzs = zVar;
    }

    public void a(aa aaVar) {
        this.fzu = aaVar;
    }

    public void a(x xVar) {
        this.fzt = xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        ImageView flx;
        RelativeLayout fly;
        HeadImageView fzB;
        ViewGroup fzC;

        private b() {
        }

        /* synthetic */ b(ab abVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        boolean fzA;

        private a() {
        }

        /* synthetic */ a(ab abVar, a aVar) {
            this();
        }
    }

    private void a(b bVar, a aVar, int i, ImageFileInfo imageFileInfo, int i2, o oVar) {
        bVar.fly.setOnClickListener(new af(this, aVar, oVar, imageFileInfo, i, bVar));
    }
}
