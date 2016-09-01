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
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class ab extends BaseAdapter {
    private com.baidu.tbadk.img.b arb;
    private boolean fKY;
    private o gaZ;
    private AlbumActivity gaf;
    private boolean gba;
    private z gbb;
    private x gbc;
    private aa gbd;
    private List<ImageFileInfo> mList;
    private int mWidth;

    public ab(AlbumActivity albumActivity, o oVar) {
        this.gaf = albumActivity;
        this.arb = albumActivity.akr();
        this.gaZ = oVar;
        this.mWidth = (int) this.gaf.getResources().getDimension(t.e.ds220);
    }

    public void setData(List<ImageFileInfo> list, boolean z) {
        this.mList = list;
        this.gba = z;
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
    /* renamed from: sW */
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
        if (this.gba && i == 0) {
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
                view = LayoutInflater.from(this.gaf.getPageContext().getPageActivity()).inflate(t.h.album_image_item_view, viewGroup, false);
                bVar.gbk = (HeadImageView) view.findViewById(t.g.pic);
                bVar.fxp = (ImageView) view.findViewById(t.g.select_icon);
                bVar.fxq = (RelativeLayout) view.findViewById(t.g.lay_select);
                view.setTag(bVar);
            } else if (itemViewType == 1) {
                view = LayoutInflater.from(this.gaf.getPageContext().getPageActivity()).inflate(t.h.album_image_item_view_camera, viewGroup, false);
                bVar.gbl = (ViewGroup) view.findViewById(t.g.item_camera);
                view.setTag(bVar);
            } else if (itemViewType == 2) {
                view = new View(this.gaf.getActivity());
                view.setLayoutParams(new AbsListView.LayoutParams(com.baidu.adp.lib.util.k.e(this.gaf.getActivity(), t.e.ds220), com.baidu.adp.lib.util.k.e(this.gaf.getActivity(), t.e.ds180)));
            }
        } else {
            bVar = (b) view.getTag();
        }
        ImageFileInfo item = getItem(i);
        if (itemViewType == 0) {
            bVar.gbk.setTag(null);
            bVar.gbk.setRadius(1);
            bVar.gbk.setDefaultResource(t.f.img_default_100);
            bVar.gbk.c(null, 12, false);
            int i2 = i + 1;
            if (this.gba) {
                i2 = i;
            }
            bVar.gbk.setContentDescription(String.valueOf(view.getResources().getString(t.j.log_msg_pic)) + i2 + " " + item.getModifyTime());
            bVar.gbk.invalidate();
            a aVar = new a(this, null);
            aVar.gbj = true;
            if (item != null) {
                item.clearPageActions();
                item.addPageAction(com.baidu.tbadk.img.effect.d.F(this.mWidth, this.mWidth));
                bVar.gbk.setTag(item.toCachedKey(false));
                if (this.arb.a(item, false) != null) {
                    bVar.gbk.invalidate();
                } else {
                    this.arb.a(item, new ac(this, viewGroup, aVar), false, this.fKY);
                }
            } else {
                aVar.gbj = false;
            }
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            if (this.gaZ != null) {
                if (this.gaZ.isAdded(item)) {
                    bVar.fxp.setContentDescription(this.gaf.getResources().getString(t.j.check_box_checked));
                    av.k(bVar.fxp, t.f.chx_camera_pic_s);
                } else {
                    bVar.fxp.setContentDescription(this.gaf.getResources().getString(t.j.check_box_not_checked));
                    av.k(bVar.fxp, t.f.chx_camera_pic_n);
                }
                a(bVar, aVar, i, item, skinType, this.gaZ);
            }
            bVar.gbk.setOnClickListener(new ad(this, aVar, i, item));
        } else if (itemViewType == 1) {
            av.k(bVar.gbl, t.f.icon_camera_pic);
            bVar.gbl.setOnClickListener(new ae(this, i, item));
        }
        u(view);
        return view;
    }

    public boolean isScroll() {
        return this.fKY;
    }

    public void lm(boolean z) {
        this.fKY = z;
    }

    private void u(View view) {
        this.gaf.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.gaf.getLayoutMode().x(view);
    }

    public void a(z zVar) {
        this.gbb = zVar;
    }

    public void a(aa aaVar) {
        this.gbd = aaVar;
    }

    public void a(x xVar) {
        this.gbc = xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        ImageView fxp;
        RelativeLayout fxq;
        HeadImageView gbk;
        ViewGroup gbl;

        private b() {
        }

        /* synthetic */ b(ab abVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        boolean gbj;

        private a() {
        }

        /* synthetic */ a(ab abVar, a aVar) {
            this();
        }
    }

    private void a(b bVar, a aVar, int i, ImageFileInfo imageFileInfo, int i2, o oVar) {
        bVar.fxq.setOnClickListener(new af(this, aVar, oVar, imageFileInfo, i, bVar));
    }
}
