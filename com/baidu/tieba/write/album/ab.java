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
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class ab extends BaseAdapter {
    private com.baidu.tbadk.img.b anf;
    private AlbumActivity fCP;
    private o fDH;
    private boolean fDI;
    private z fDJ;
    private x fDK;
    private aa fDL;
    private boolean fpD;
    private List<ImageFileInfo> mList;
    private int mWidth;

    public ab(AlbumActivity albumActivity, o oVar) {
        this.fCP = albumActivity;
        this.anf = albumActivity.afd();
        this.fDH = oVar;
        this.mWidth = (int) this.fCP.getResources().getDimension(u.e.ds220);
    }

    public void setData(List<ImageFileInfo> list, boolean z) {
        this.mList = list;
        this.fDI = z;
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
    /* renamed from: sb */
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
        if (this.fDI && i == 0) {
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
                view = LayoutInflater.from(this.fCP.getPageContext().getPageActivity()).inflate(u.h.album_image_item_view, viewGroup, false);
                bVar.fDS = (HeadImageView) view.findViewById(u.g.pic);
                bVar.fcq = (ImageView) view.findViewById(u.g.select_icon);
                bVar.fcr = (RelativeLayout) view.findViewById(u.g.lay_select);
                view.setTag(bVar);
            } else if (itemViewType == 1) {
                view = LayoutInflater.from(this.fCP.getPageContext().getPageActivity()).inflate(u.h.album_image_item_view_camera, viewGroup, false);
                bVar.fDT = (ViewGroup) view.findViewById(u.g.item_camera);
                view.setTag(bVar);
            } else if (itemViewType == 2) {
                view = new View(this.fCP.getActivity());
                view.setLayoutParams(new AbsListView.LayoutParams(com.baidu.adp.lib.util.k.c(this.fCP.getActivity(), u.e.ds220), com.baidu.adp.lib.util.k.c(this.fCP.getActivity(), u.e.ds180)));
            }
        } else {
            bVar = (b) view.getTag();
        }
        ImageFileInfo item = getItem(i);
        if (itemViewType == 0) {
            bVar.fDS.setTag(null);
            bVar.fDS.setRadius(1);
            bVar.fDS.setDefaultResource(u.f.img_default_100);
            bVar.fDS.c(null, 12, false);
            int i2 = i + 1;
            if (this.fDI) {
                i2 = i;
            }
            bVar.fDS.setContentDescription(String.valueOf(view.getResources().getString(u.j.log_msg_pic)) + i2 + " " + item.getModifyTime());
            bVar.fDS.invalidate();
            a aVar = new a(this, null);
            aVar.fDR = true;
            if (item != null) {
                item.clearPageActions();
                item.addPageAction(com.baidu.tbadk.img.effect.d.D(this.mWidth, this.mWidth));
                bVar.fDS.setTag(item.toCachedKey(false));
                if (this.anf.a(item, false) != null) {
                    bVar.fDS.invalidate();
                } else {
                    this.anf.a(item, new ac(this, viewGroup, aVar), false, this.fpD);
                }
            } else {
                aVar.fDR = false;
            }
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            if (this.fDH != null) {
                if (this.fDH.isAdded(item)) {
                    bVar.fcq.setContentDescription(this.fCP.getResources().getString(u.j.check_box_checked));
                    av.k(bVar.fcq, u.f.chx_camera_pic_s);
                } else {
                    bVar.fcq.setContentDescription(this.fCP.getResources().getString(u.j.check_box_not_checked));
                    av.k(bVar.fcq, u.f.chx_camera_pic_n);
                }
                a(bVar, aVar, i, item, skinType, this.fDH);
            }
            bVar.fDS.setOnClickListener(new ad(this, aVar, i, item));
        } else if (itemViewType == 1) {
            av.k(bVar.fDT, u.f.icon_camera_pic);
            bVar.fDT.setOnClickListener(new ae(this, i, item));
        }
        u(view);
        return view;
    }

    public boolean isScroll() {
        return this.fpD;
    }

    public void kM(boolean z) {
        this.fpD = z;
    }

    private void u(View view) {
        this.fCP.getLayoutMode().ad(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.fCP.getLayoutMode().w(view);
    }

    public void a(z zVar) {
        this.fDJ = zVar;
    }

    public void a(aa aaVar) {
        this.fDL = aaVar;
    }

    public void a(x xVar) {
        this.fDK = xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        HeadImageView fDS;
        ViewGroup fDT;
        ImageView fcq;
        RelativeLayout fcr;

        private b() {
        }

        /* synthetic */ b(ab abVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        boolean fDR;

        private a() {
        }

        /* synthetic */ a(ab abVar, a aVar) {
            this();
        }
    }

    private void a(b bVar, a aVar, int i, ImageFileInfo imageFileInfo, int i2, o oVar) {
        bVar.fcr.setOnClickListener(new af(this, aVar, oVar, imageFileInfo, i, bVar));
    }
}
