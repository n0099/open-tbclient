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
    private com.baidu.tbadk.img.b avJ;
    private AlbumActivity fLm;
    private o fMm;
    private boolean fMn;
    private boolean fMo;
    private z fMp;
    private x fMq;
    private aa fMr;
    private List<ImageFileInfo> mList;
    private int mWidth;

    public ab(AlbumActivity albumActivity, o oVar) {
        this.fLm = albumActivity;
        this.avJ = albumActivity.ahu();
        this.fMm = oVar;
        this.mWidth = (int) this.fLm.getResources().getDimension(w.f.ds220);
    }

    public void setData(List<ImageFileInfo> list, boolean z) {
        this.mList = list;
        this.fMn = z;
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
    /* renamed from: sP */
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
        if (this.fMn && i == 0) {
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
                view = LayoutInflater.from(this.fLm.getPageContext().getPageActivity()).inflate(w.j.album_image_item_view, viewGroup, false);
                bVar.fMy = (HeadImageView) view.findViewById(w.h.pic);
                bVar.fzc = (ImageView) view.findViewById(w.h.select_icon);
                bVar.fzd = (RelativeLayout) view.findViewById(w.h.lay_select);
                view.setTag(bVar);
            } else if (itemViewType == 1) {
                view = LayoutInflater.from(this.fLm.getPageContext().getPageActivity()).inflate(w.j.album_image_item_view_camera, viewGroup, false);
                bVar.fMz = (ViewGroup) view.findViewById(w.h.item_camera);
                view.setTag(bVar);
            } else if (itemViewType == 2) {
                view = new View(this.fLm.getActivity());
                view.setLayoutParams(new AbsListView.LayoutParams(com.baidu.adp.lib.util.k.g(this.fLm.getActivity(), w.f.ds220), com.baidu.adp.lib.util.k.g(this.fLm.getActivity(), w.f.ds180)));
            }
        } else {
            bVar = (b) view.getTag();
        }
        ImageFileInfo item = getItem(i);
        if (itemViewType == 0) {
            bVar.fMy.setTag(null);
            bVar.fMy.setRadius(1);
            bVar.fMy.setDefaultResource(w.g.img_default_100);
            bVar.fMy.c(null, 12, false);
            int i2 = i + 1;
            if (this.fMn) {
                i2 = i;
            }
            bVar.fMy.setContentDescription(String.valueOf(view.getResources().getString(w.l.log_msg_pic)) + i2 + " " + item.getModifyTime());
            bVar.fMy.invalidate();
            a aVar = new a(this, null);
            aVar.fMx = true;
            if (item != null) {
                item.clearPageActions();
                item.addPageAction(com.baidu.tbadk.img.effect.d.M(this.mWidth, this.mWidth));
                bVar.fMy.setTag(item.toCachedKey(false));
                if (this.avJ.a(item, false) != null) {
                    bVar.fMy.invalidate();
                } else {
                    this.avJ.a(item, new ac(this, viewGroup, aVar), false, this.fMo);
                }
            } else {
                aVar.fMx = false;
            }
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            if (this.fMm != null) {
                if (this.fMm.isAdded(item)) {
                    bVar.fzc.setContentDescription(this.fLm.getResources().getString(w.l.check_box_checked));
                    aq.j(bVar.fzc, w.g.chx_camera_pic_s);
                } else {
                    bVar.fzc.setContentDescription(this.fLm.getResources().getString(w.l.check_box_not_checked));
                    aq.j(bVar.fzc, w.g.chx_camera_pic_n);
                }
                a(bVar, aVar, i, item, skinType, this.fMm);
            }
            bVar.fMy.setOnClickListener(new ad(this, aVar, i, item));
        } else if (itemViewType == 1) {
            aq.j(bVar.fMz, w.g.icon_camera_pic);
            bVar.fMz.setOnClickListener(new ae(this, i, item));
        }
        am(view);
        return view;
    }

    public boolean isScroll() {
        return this.fMo;
    }

    public void lJ(boolean z) {
        this.fMo = z;
    }

    private void am(View view) {
        this.fLm.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.fLm.getLayoutMode().t(view);
    }

    public void a(z zVar) {
        this.fMp = zVar;
    }

    public void a(aa aaVar) {
        this.fMr = aaVar;
    }

    public void a(x xVar) {
        this.fMq = xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        HeadImageView fMy;
        ViewGroup fMz;
        ImageView fzc;
        RelativeLayout fzd;

        private b() {
        }

        /* synthetic */ b(ab abVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        boolean fMx;

        private a() {
        }

        /* synthetic */ a(ab abVar, a aVar) {
            this();
        }
    }

    private void a(b bVar, a aVar, int i, ImageFileInfo imageFileInfo, int i2, o oVar) {
        bVar.fzd.setOnClickListener(new af(this, aVar, oVar, imageFileInfo, i, bVar));
    }
}
