package com.baidu.tieba.write.album;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class ab extends BaseAdapter {
    private com.baidu.tbadk.img.b aqL;
    private boolean fNu;
    private AlbumActivity gco;
    private o gdi;
    private boolean gdj;
    private z gdk;
    private x gdl;
    private aa gdm;
    private List<ImageFileInfo> mList;
    private int mWidth;

    public ab(AlbumActivity albumActivity, o oVar) {
        this.gco = albumActivity;
        this.aqL = albumActivity.akF();
        this.gdi = oVar;
        this.mWidth = (int) this.gco.getResources().getDimension(r.e.ds220);
    }

    public void setData(List<ImageFileInfo> list, boolean z) {
        this.mList = list;
        this.gdj = z;
        notifyDataSetChanged();
    }

    public int j(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null || imageFileInfo.getFilePath() == null) {
            return -1;
        }
        if (this.mList == null || this.mList.size() == 0) {
            return -1;
        }
        int size = this.mList.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo2 = (ImageFileInfo) com.baidu.tbadk.core.util.y.c(this.mList, i);
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
    /* renamed from: tk */
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
        if (this.gdj && i == 0) {
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
                view = LayoutInflater.from(this.gco.getPageContext().getPageActivity()).inflate(r.h.album_image_item_view, viewGroup, false);
                bVar.gdt = (HeadImageView) view.findViewById(r.g.pic);
                bVar.fzR = (ImageView) view.findViewById(r.g.select_icon);
                bVar.fzS = (RelativeLayout) view.findViewById(r.g.lay_select);
                view.setTag(bVar);
            } else if (itemViewType == 1) {
                view = LayoutInflater.from(this.gco.getPageContext().getPageActivity()).inflate(r.h.album_image_item_view_camera, viewGroup, false);
                bVar.gdu = (ViewGroup) view.findViewById(r.g.item_camera);
                view.setTag(bVar);
            } else if (itemViewType == 2) {
                view = new View(this.gco.getActivity());
                view.setLayoutParams(new AbsListView.LayoutParams(com.baidu.adp.lib.util.k.e(this.gco.getActivity(), r.e.ds220), com.baidu.adp.lib.util.k.e(this.gco.getActivity(), r.e.ds180)));
            }
        } else {
            bVar = (b) view.getTag();
        }
        ImageFileInfo item = getItem(i);
        if (itemViewType == 0) {
            bVar.gdt.setTag(null);
            bVar.gdt.setRadius(1);
            bVar.gdt.setDefaultResource(r.f.img_default_100);
            bVar.gdt.c(null, 12, false);
            int i2 = i + 1;
            if (this.gdj) {
                i2 = i;
            }
            bVar.gdt.setContentDescription(String.valueOf(view.getResources().getString(r.j.log_msg_pic)) + i2 + " " + item.getModifyTime());
            bVar.gdt.invalidate();
            a aVar = new a(this, null);
            aVar.gds = true;
            if (item != null) {
                item.clearPageActions();
                item.addPageAction(com.baidu.tbadk.img.effect.d.F(this.mWidth, this.mWidth));
                bVar.gdt.setTag(item.toCachedKey(false));
                if (this.aqL.a(item, false) != null) {
                    bVar.gdt.invalidate();
                } else {
                    this.aqL.a(item, new ac(this, viewGroup, aVar), false, this.fNu);
                }
            } else {
                aVar.gds = false;
            }
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            if (this.gdi != null) {
                if (this.gdi.isAdded(item)) {
                    bVar.fzR.setContentDescription(this.gco.getResources().getString(r.j.check_box_checked));
                    av.k(bVar.fzR, r.f.chx_camera_pic_s);
                } else {
                    bVar.fzR.setContentDescription(this.gco.getResources().getString(r.j.check_box_not_checked));
                    av.k(bVar.fzR, r.f.chx_camera_pic_n);
                }
                a(bVar, aVar, i, item, skinType, this.gdi);
            }
            bVar.gdt.setOnClickListener(new ad(this, aVar, i, item));
        } else if (itemViewType == 1) {
            av.k(bVar.gdu, r.f.icon_camera_pic);
            bVar.gdu.setOnClickListener(new ae(this, i, item));
        }
        u(view);
        return view;
    }

    public boolean isScroll() {
        return this.fNu;
    }

    public void lp(boolean z) {
        this.fNu = z;
    }

    private void u(View view) {
        this.gco.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.gco.getLayoutMode().x(view);
    }

    public void a(z zVar) {
        this.gdk = zVar;
    }

    public void a(aa aaVar) {
        this.gdm = aaVar;
    }

    public void a(x xVar) {
        this.gdl = xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        ImageView fzR;
        RelativeLayout fzS;
        HeadImageView gdt;
        ViewGroup gdu;

        private b() {
        }

        /* synthetic */ b(ab abVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        boolean gds;

        private a() {
        }

        /* synthetic */ a(ab abVar, a aVar) {
            this();
        }
    }

    private void a(b bVar, a aVar, int i, ImageFileInfo imageFileInfo, int i2, o oVar) {
        bVar.fzS.setOnClickListener(new af(this, aVar, oVar, imageFileInfo, i, bVar));
    }
}
