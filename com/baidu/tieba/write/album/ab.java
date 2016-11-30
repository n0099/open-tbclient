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
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class ab extends BaseAdapter {
    private com.baidu.tbadk.img.b arF;
    private boolean fUV;
    private AlbumActivity gjT;
    private o gkN;
    private boolean gkO;
    private z gkP;
    private x gkQ;
    private aa gkR;
    private List<ImageFileInfo> mList;
    private int mWidth;

    public ab(AlbumActivity albumActivity, o oVar) {
        this.gjT = albumActivity;
        this.arF = albumActivity.amA();
        this.gkN = oVar;
        this.mWidth = (int) this.gjT.getResources().getDimension(r.e.ds220);
    }

    public void setData(List<ImageFileInfo> list, boolean z) {
        this.mList = list;
        this.gkO = z;
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
    /* renamed from: tG */
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
        if (this.gkO && i == 0) {
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
                view = LayoutInflater.from(this.gjT.getPageContext().getPageActivity()).inflate(r.h.album_image_item_view, viewGroup, false);
                bVar.gkY = (HeadImageView) view.findViewById(r.g.pic);
                bVar.fHt = (ImageView) view.findViewById(r.g.select_icon);
                bVar.fHu = (RelativeLayout) view.findViewById(r.g.lay_select);
                view.setTag(bVar);
            } else if (itemViewType == 1) {
                view = LayoutInflater.from(this.gjT.getPageContext().getPageActivity()).inflate(r.h.album_image_item_view_camera, viewGroup, false);
                bVar.gkZ = (ViewGroup) view.findViewById(r.g.item_camera);
                view.setTag(bVar);
            } else if (itemViewType == 2) {
                view = new View(this.gjT.getActivity());
                view.setLayoutParams(new AbsListView.LayoutParams(com.baidu.adp.lib.util.k.e(this.gjT.getActivity(), r.e.ds220), com.baidu.adp.lib.util.k.e(this.gjT.getActivity(), r.e.ds180)));
            }
        } else {
            bVar = (b) view.getTag();
        }
        ImageFileInfo item = getItem(i);
        if (itemViewType == 0) {
            bVar.gkY.setTag(null);
            bVar.gkY.setRadius(1);
            bVar.gkY.setDefaultResource(r.f.img_default_100);
            bVar.gkY.c(null, 12, false);
            int i2 = i + 1;
            if (this.gkO) {
                i2 = i;
            }
            bVar.gkY.setContentDescription(String.valueOf(view.getResources().getString(r.j.log_msg_pic)) + i2 + " " + item.getModifyTime());
            bVar.gkY.invalidate();
            a aVar = new a(this, null);
            aVar.gkX = true;
            if (item != null) {
                item.clearPageActions();
                item.addPageAction(com.baidu.tbadk.img.effect.d.F(this.mWidth, this.mWidth));
                bVar.gkY.setTag(item.toCachedKey(false));
                if (this.arF.a(item, false) != null) {
                    bVar.gkY.invalidate();
                } else {
                    this.arF.a(item, new ac(this, viewGroup, aVar), false, this.fUV);
                }
            } else {
                aVar.gkX = false;
            }
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            if (this.gkN != null) {
                if (this.gkN.isAdded(item)) {
                    bVar.fHt.setContentDescription(this.gjT.getResources().getString(r.j.check_box_checked));
                    at.k(bVar.fHt, r.f.chx_camera_pic_s);
                } else {
                    bVar.fHt.setContentDescription(this.gjT.getResources().getString(r.j.check_box_not_checked));
                    at.k(bVar.fHt, r.f.chx_camera_pic_n);
                }
                a(bVar, aVar, i, item, skinType, this.gkN);
            }
            bVar.gkY.setOnClickListener(new ad(this, aVar, i, item));
        } else if (itemViewType == 1) {
            at.k(bVar.gkZ, r.f.icon_camera_pic);
            bVar.gkZ.setOnClickListener(new ae(this, i, item));
        }
        u(view);
        return view;
    }

    public boolean isScroll() {
        return this.fUV;
    }

    public void lO(boolean z) {
        this.fUV = z;
    }

    private void u(View view) {
        this.gjT.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.gjT.getLayoutMode().x(view);
    }

    public void a(z zVar) {
        this.gkP = zVar;
    }

    public void a(aa aaVar) {
        this.gkR = aaVar;
    }

    public void a(x xVar) {
        this.gkQ = xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        ImageView fHt;
        RelativeLayout fHu;
        HeadImageView gkY;
        ViewGroup gkZ;

        private b() {
        }

        /* synthetic */ b(ab abVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        boolean gkX;

        private a() {
        }

        /* synthetic */ a(ab abVar, a aVar) {
            this();
        }
    }

    private void a(b bVar, a aVar, int i, ImageFileInfo imageFileInfo, int i2, o oVar) {
        bVar.fHu.setOnClickListener(new af(this, aVar, oVar, imageFileInfo, i, bVar));
    }
}
