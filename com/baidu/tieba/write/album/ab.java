package com.baidu.tieba.write.album;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class ab extends BaseAdapter {
    private com.baidu.tbadk.img.b aqo;
    private AlbumActivity fGS;
    private o fHS;
    private boolean fHT;
    private boolean fHU;
    private z fHV;
    private x fHW;
    private aa fHX;
    private List<ImageFileInfo> mList;
    private int mWidth;

    public ab(AlbumActivity albumActivity, o oVar) {
        this.fGS = albumActivity;
        this.aqo = albumActivity.aii();
        this.fHS = oVar;
        this.mWidth = (int) this.fGS.getResources().getDimension(r.f.ds220);
    }

    public void setData(List<ImageFileInfo> list, boolean z) {
        this.mList = list;
        this.fHT = z;
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
            ImageFileInfo imageFileInfo2 = (ImageFileInfo) com.baidu.tbadk.core.util.w.c(this.mList, i);
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
    /* renamed from: sQ */
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
        if (this.fHT && i == 0) {
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
                view = LayoutInflater.from(this.fGS.getPageContext().getPageActivity()).inflate(r.j.album_image_item_view, viewGroup, false);
                bVar.fIe = (HeadImageView) view.findViewById(r.h.pic);
                bVar.fuD = (ImageView) view.findViewById(r.h.select_icon);
                bVar.fuE = (RelativeLayout) view.findViewById(r.h.lay_select);
                view.setTag(bVar);
            } else if (itemViewType == 1) {
                view = LayoutInflater.from(this.fGS.getPageContext().getPageActivity()).inflate(r.j.album_image_item_view_camera, viewGroup, false);
                bVar.fIf = (ViewGroup) view.findViewById(r.h.item_camera);
                view.setTag(bVar);
            } else if (itemViewType == 2) {
                view = new View(this.fGS.getActivity());
                view.setLayoutParams(new AbsListView.LayoutParams(com.baidu.adp.lib.util.k.e(this.fGS.getActivity(), r.f.ds220), com.baidu.adp.lib.util.k.e(this.fGS.getActivity(), r.f.ds180)));
            }
        } else {
            bVar = (b) view.getTag();
        }
        ImageFileInfo item = getItem(i);
        if (itemViewType == 0) {
            bVar.fIe.setTag(null);
            bVar.fIe.setRadius(1);
            bVar.fIe.setDefaultResource(r.g.img_default_100);
            bVar.fIe.c(null, 12, false);
            int i2 = i + 1;
            if (this.fHT) {
                i2 = i;
            }
            bVar.fIe.setContentDescription(String.valueOf(view.getResources().getString(r.l.log_msg_pic)) + i2 + " " + item.getModifyTime());
            bVar.fIe.invalidate();
            a aVar = new a(this, null);
            aVar.fId = true;
            if (item != null) {
                item.clearPageActions();
                item.addPageAction(com.baidu.tbadk.img.effect.d.G(this.mWidth, this.mWidth));
                bVar.fIe.setTag(item.toCachedKey(false));
                if (this.aqo.a(item, false) != null) {
                    bVar.fIe.invalidate();
                } else {
                    this.aqo.a(item, new ac(this, viewGroup, aVar), false, this.fHU);
                }
            } else {
                aVar.fId = false;
            }
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            if (this.fHS != null) {
                if (this.fHS.isAdded(item)) {
                    bVar.fuD.setContentDescription(this.fGS.getResources().getString(r.l.check_box_checked));
                    com.baidu.tbadk.core.util.ap.j(bVar.fuD, r.g.chx_camera_pic_s);
                } else {
                    bVar.fuD.setContentDescription(this.fGS.getResources().getString(r.l.check_box_not_checked));
                    com.baidu.tbadk.core.util.ap.j(bVar.fuD, r.g.chx_camera_pic_n);
                }
                a(bVar, aVar, i, item, skinType, this.fHS);
            }
            bVar.fIe.setOnClickListener(new ad(this, aVar, i, item));
        } else if (itemViewType == 1) {
            com.baidu.tbadk.core.util.ap.j(bVar.fIf, r.g.icon_camera_pic);
            bVar.fIf.setOnClickListener(new ae(this, i, item));
        }
        s(view);
        return view;
    }

    public boolean isScroll() {
        return this.fHU;
    }

    public void lK(boolean z) {
        this.fHU = z;
    }

    private void s(View view) {
        this.fGS.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.fGS.getLayoutMode().v(view);
    }

    public void a(z zVar) {
        this.fHV = zVar;
    }

    public void a(aa aaVar) {
        this.fHX = aaVar;
    }

    public void a(x xVar) {
        this.fHW = xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        HeadImageView fIe;
        ViewGroup fIf;
        ImageView fuD;
        RelativeLayout fuE;

        private b() {
        }

        /* synthetic */ b(ab abVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        boolean fId;

        private a() {
        }

        /* synthetic */ a(ab abVar, a aVar) {
            this();
        }
    }

    private void a(b bVar, a aVar, int i, ImageFileInfo imageFileInfo, int i2, o oVar) {
        bVar.fuE.setOnClickListener(new af(this, aVar, oVar, imageFileInfo, i, bVar));
    }
}
