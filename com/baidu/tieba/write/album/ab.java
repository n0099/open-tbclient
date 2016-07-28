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
    private com.baidu.tbadk.img.b anU;
    private boolean fCD;
    private o fQU;
    private boolean fQV;
    private z fQW;
    private x fQX;
    private aa fQY;
    private AlbumActivity fQb;
    private List<ImageFileInfo> mList;
    private int mWidth;

    public ab(AlbumActivity albumActivity, o oVar) {
        this.fQb = albumActivity;
        this.anU = albumActivity.afG();
        this.fQU = oVar;
        this.mWidth = (int) this.fQb.getResources().getDimension(u.e.ds220);
    }

    public void setData(List<ImageFileInfo> list, boolean z) {
        this.mList = list;
        this.fQV = z;
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
    /* renamed from: sv */
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
        if (this.fQV && i == 0) {
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
                view = LayoutInflater.from(this.fQb.getPageContext().getPageActivity()).inflate(u.h.album_image_item_view, viewGroup, false);
                bVar.fRf = (HeadImageView) view.findViewById(u.g.pic);
                bVar.fpu = (ImageView) view.findViewById(u.g.select_icon);
                bVar.fpv = (RelativeLayout) view.findViewById(u.g.lay_select);
                view.setTag(bVar);
            } else if (itemViewType == 1) {
                view = LayoutInflater.from(this.fQb.getPageContext().getPageActivity()).inflate(u.h.album_image_item_view_camera, viewGroup, false);
                bVar.fRg = (ViewGroup) view.findViewById(u.g.item_camera);
                view.setTag(bVar);
            } else if (itemViewType == 2) {
                view = new View(this.fQb.getActivity());
                view.setLayoutParams(new AbsListView.LayoutParams(com.baidu.adp.lib.util.k.c(this.fQb.getActivity(), u.e.ds220), com.baidu.adp.lib.util.k.c(this.fQb.getActivity(), u.e.ds180)));
            }
        } else {
            bVar = (b) view.getTag();
        }
        ImageFileInfo item = getItem(i);
        if (itemViewType == 0) {
            bVar.fRf.setTag(null);
            bVar.fRf.setRadius(1);
            bVar.fRf.setDefaultResource(u.f.img_default_100);
            bVar.fRf.c(null, 12, false);
            int i2 = i + 1;
            if (this.fQV) {
                i2 = i;
            }
            bVar.fRf.setContentDescription(String.valueOf(view.getResources().getString(u.j.log_msg_pic)) + i2 + " " + item.getModifyTime());
            bVar.fRf.invalidate();
            a aVar = new a(this, null);
            aVar.fRe = true;
            if (item != null) {
                item.clearPageActions();
                item.addPageAction(com.baidu.tbadk.img.effect.d.D(this.mWidth, this.mWidth));
                bVar.fRf.setTag(item.toCachedKey(false));
                if (this.anU.a(item, false) != null) {
                    bVar.fRf.invalidate();
                } else {
                    this.anU.a(item, new ac(this, viewGroup, aVar), false, this.fCD);
                }
            } else {
                aVar.fRe = false;
            }
            int skinType = TbadkCoreApplication.m10getInst().getSkinType();
            if (this.fQU != null) {
                if (this.fQU.isAdded(item)) {
                    bVar.fpu.setContentDescription(this.fQb.getResources().getString(u.j.check_box_checked));
                    av.k(bVar.fpu, u.f.chx_camera_pic_s);
                } else {
                    bVar.fpu.setContentDescription(this.fQb.getResources().getString(u.j.check_box_not_checked));
                    av.k(bVar.fpu, u.f.chx_camera_pic_n);
                }
                a(bVar, aVar, i, item, skinType, this.fQU);
            }
            bVar.fRf.setOnClickListener(new ad(this, aVar, i, item));
        } else if (itemViewType == 1) {
            av.k(bVar.fRg, u.f.icon_camera_pic);
            bVar.fRg.setOnClickListener(new ae(this, i, item));
        }
        u(view);
        return view;
    }

    public boolean isScroll() {
        return this.fCD;
    }

    public void la(boolean z) {
        this.fCD = z;
    }

    private void u(View view) {
        this.fQb.getLayoutMode().af(TbadkCoreApplication.m10getInst().getSkinType() == 1);
        this.fQb.getLayoutMode().w(view);
    }

    public void a(z zVar) {
        this.fQW = zVar;
    }

    public void a(aa aaVar) {
        this.fQY = aaVar;
    }

    public void a(x xVar) {
        this.fQX = xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        HeadImageView fRf;
        ViewGroup fRg;
        ImageView fpu;
        RelativeLayout fpv;

        private b() {
        }

        /* synthetic */ b(ab abVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        boolean fRe;

        private a() {
        }

        /* synthetic */ a(ab abVar, a aVar) {
            this();
        }
    }

    private void a(b bVar, a aVar, int i, ImageFileInfo imageFileInfo, int i2, o oVar) {
        bVar.fpv.setOnClickListener(new af(this, aVar, oVar, imageFileInfo, i, bVar));
    }
}
