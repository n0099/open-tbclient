package com.baidu.tieba.write.album;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class ab extends BaseAdapter {
    private com.baidu.tbadk.img.b amz;
    private boolean eKI;
    private AlbumActivity eXL;
    private o eYD;
    private boolean eYE;
    private z eYF;
    private x eYG;
    private aa eYH;
    private List<ImageFileInfo> mList;
    private int mWidth;

    public ab(AlbumActivity albumActivity, o oVar) {
        this.eXL = albumActivity;
        this.amz = albumActivity.YK();
        this.eYD = oVar;
        this.mWidth = (int) this.eXL.getResources().getDimension(t.e.album_gridview_item_height);
    }

    public void setData(List<ImageFileInfo> list, boolean z) {
        this.mList = list;
        this.eYE = z;
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
    /* renamed from: qK */
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
        if (this.eYE && i == 0) {
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
                view = LayoutInflater.from(this.eXL.getPageContext().getPageActivity()).inflate(t.h.album_image_item_view, viewGroup, false);
                bVar.eYO = (HeadImageView) view.findViewById(t.g.pic);
                bVar.exF = (ImageView) view.findViewById(t.g.select_icon);
                bVar.exG = (RelativeLayout) view.findViewById(t.g.lay_select);
                view.setTag(bVar);
            } else if (itemViewType == 1) {
                view = LayoutInflater.from(this.eXL.getPageContext().getPageActivity()).inflate(t.h.album_image_item_view_camera, viewGroup, false);
                bVar.eYP = (ViewGroup) view.findViewById(t.g.item_camera);
                view.setTag(bVar);
            } else if (itemViewType == 2) {
                view = new View(this.eXL.getActivity());
                view.setLayoutParams(new AbsListView.LayoutParams(com.baidu.adp.lib.util.k.c(this.eXL.getActivity(), t.e.ds220), com.baidu.adp.lib.util.k.c(this.eXL.getActivity(), t.e.ds180)));
            }
        } else {
            bVar = (b) view.getTag();
        }
        ImageFileInfo item = getItem(i);
        if (itemViewType == 0) {
            bVar.eYO.setTag(null);
            bVar.eYO.setRadius(1);
            bVar.eYO.setDefaultResource(t.f.img_default_100);
            bVar.eYO.c(null, 12, false);
            int i2 = i + 1;
            if (this.eYE) {
                i2 = i;
            }
            bVar.eYO.setContentDescription(String.valueOf(view.getResources().getString(t.j.log_msg_pic)) + i2 + " " + item.getModifyTime());
            bVar.eYO.invalidate();
            a aVar = new a(this, null);
            aVar.eYN = true;
            if (item != null) {
                item.clearPageActions();
                item.addPageAction(com.baidu.tbadk.img.effect.d.D(this.mWidth, this.mWidth));
                bVar.eYO.setTag(item.toCachedKey(false));
                if (this.amz.a(item, false) != null) {
                    bVar.eYO.invalidate();
                } else {
                    this.amz.a(item, new ac(this, viewGroup, aVar), false, this.eKI);
                }
            } else {
                aVar.eYN = false;
            }
            int skinType = TbadkCoreApplication.m11getInst().getSkinType();
            if (this.eYD != null) {
                if (this.eYD.isAdded(item)) {
                    bVar.exF.setContentDescription(this.eXL.getResources().getString(t.j.check_box_checked));
                    at.k(bVar.exF, t.f.chx_camera_pic_s);
                } else {
                    bVar.exF.setContentDescription(this.eXL.getResources().getString(t.j.check_box_not_checked));
                    at.k(bVar.exF, t.f.chx_camera_pic_n);
                }
                a(bVar, aVar, i, item, skinType, this.eYD);
            }
            bVar.eYO.setOnClickListener(new ad(this, aVar, i, item));
        } else if (itemViewType == 1) {
            at.k(bVar.eYP, t.f.icon_camera_pic);
            bVar.eYP.setOnClickListener(new ae(this, i, item));
        }
        u(view);
        return view;
    }

    public boolean isScroll() {
        return this.eKI;
    }

    public void kc(boolean z) {
        this.eKI = z;
    }

    private void u(View view) {
        this.eXL.getLayoutMode().ae(TbadkCoreApplication.m11getInst().getSkinType() == 1);
        this.eXL.getLayoutMode().x(view);
    }

    public void a(z zVar) {
        this.eYF = zVar;
    }

    public void a(aa aaVar) {
        this.eYH = aaVar;
    }

    public void a(x xVar) {
        this.eYG = xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        HeadImageView eYO;
        ViewGroup eYP;
        ImageView exF;
        RelativeLayout exG;

        private b() {
        }

        /* synthetic */ b(ab abVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        boolean eYN;

        private a() {
        }

        /* synthetic */ a(ab abVar, a aVar) {
            this();
        }
    }

    private void a(b bVar, a aVar, int i, ImageFileInfo imageFileInfo, int i2, o oVar) {
        bVar.exG.setOnClickListener(new af(this, aVar, oVar, imageFileInfo, i, bVar));
    }
}
