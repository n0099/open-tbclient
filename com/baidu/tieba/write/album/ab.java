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
    private boolean eKJ;
    private AlbumActivity eXM;
    private o eYE;
    private boolean eYF;
    private z eYG;
    private x eYH;
    private aa eYI;
    private List<ImageFileInfo> mList;
    private int mWidth;

    public ab(AlbumActivity albumActivity, o oVar) {
        this.eXM = albumActivity;
        this.amz = albumActivity.YI();
        this.eYE = oVar;
        this.mWidth = (int) this.eXM.getResources().getDimension(t.e.album_gridview_item_height);
    }

    public void setData(List<ImageFileInfo> list, boolean z) {
        this.mList = list;
        this.eYF = z;
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
    /* renamed from: qL */
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
        if (this.eYF && i == 0) {
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
                view = LayoutInflater.from(this.eXM.getPageContext().getPageActivity()).inflate(t.h.album_image_item_view, viewGroup, false);
                bVar.eYP = (HeadImageView) view.findViewById(t.g.pic);
                bVar.exG = (ImageView) view.findViewById(t.g.select_icon);
                bVar.exH = (RelativeLayout) view.findViewById(t.g.lay_select);
                view.setTag(bVar);
            } else if (itemViewType == 1) {
                view = LayoutInflater.from(this.eXM.getPageContext().getPageActivity()).inflate(t.h.album_image_item_view_camera, viewGroup, false);
                bVar.eYQ = (ViewGroup) view.findViewById(t.g.item_camera);
                view.setTag(bVar);
            } else if (itemViewType == 2) {
                view = new View(this.eXM.getActivity());
                view.setLayoutParams(new AbsListView.LayoutParams(com.baidu.adp.lib.util.k.c(this.eXM.getActivity(), t.e.ds220), com.baidu.adp.lib.util.k.c(this.eXM.getActivity(), t.e.ds180)));
            }
        } else {
            bVar = (b) view.getTag();
        }
        ImageFileInfo item = getItem(i);
        if (itemViewType == 0) {
            bVar.eYP.setTag(null);
            bVar.eYP.setRadius(1);
            bVar.eYP.setDefaultResource(t.f.img_default_100);
            bVar.eYP.c(null, 12, false);
            int i2 = i + 1;
            if (this.eYF) {
                i2 = i;
            }
            bVar.eYP.setContentDescription(String.valueOf(view.getResources().getString(t.j.log_msg_pic)) + i2 + " " + item.getModifyTime());
            bVar.eYP.invalidate();
            a aVar = new a(this, null);
            aVar.eYO = true;
            if (item != null) {
                item.clearPageActions();
                item.addPageAction(com.baidu.tbadk.img.effect.d.D(this.mWidth, this.mWidth));
                bVar.eYP.setTag(item.toCachedKey(false));
                if (this.amz.a(item, false) != null) {
                    bVar.eYP.invalidate();
                } else {
                    this.amz.a(item, new ac(this, viewGroup, aVar), false, this.eKJ);
                }
            } else {
                aVar.eYO = false;
            }
            int skinType = TbadkCoreApplication.m11getInst().getSkinType();
            if (this.eYE != null) {
                if (this.eYE.isAdded(item)) {
                    bVar.exG.setContentDescription(this.eXM.getResources().getString(t.j.check_box_checked));
                    at.k(bVar.exG, t.f.chx_camera_pic_s);
                } else {
                    bVar.exG.setContentDescription(this.eXM.getResources().getString(t.j.check_box_not_checked));
                    at.k(bVar.exG, t.f.chx_camera_pic_n);
                }
                a(bVar, aVar, i, item, skinType, this.eYE);
            }
            bVar.eYP.setOnClickListener(new ad(this, aVar, i, item));
        } else if (itemViewType == 1) {
            at.k(bVar.eYQ, t.f.icon_camera_pic);
            bVar.eYQ.setOnClickListener(new ae(this, i, item));
        }
        u(view);
        return view;
    }

    public boolean isScroll() {
        return this.eKJ;
    }

    public void kc(boolean z) {
        this.eKJ = z;
    }

    private void u(View view) {
        this.eXM.getLayoutMode().ae(TbadkCoreApplication.m11getInst().getSkinType() == 1);
        this.eXM.getLayoutMode().x(view);
    }

    public void a(z zVar) {
        this.eYG = zVar;
    }

    public void a(aa aaVar) {
        this.eYI = aaVar;
    }

    public void a(x xVar) {
        this.eYH = xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        HeadImageView eYP;
        ViewGroup eYQ;
        ImageView exG;
        RelativeLayout exH;

        private b() {
        }

        /* synthetic */ b(ab abVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        boolean eYO;

        private a() {
        }

        /* synthetic */ a(ab abVar, a aVar) {
            this();
        }
    }

    private void a(b bVar, a aVar, int i, ImageFileInfo imageFileInfo, int i2, o oVar) {
        bVar.exH.setOnClickListener(new af(this, aVar, oVar, imageFileInfo, i, bVar));
    }
}
