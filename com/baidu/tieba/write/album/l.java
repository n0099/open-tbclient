package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private com.baidu.tbadk.img.b arF;
    private String fPB;
    private int fUQ;
    private AlbumActivity gjT;
    private List<d> mList;
    private int mWidth;

    public l(AlbumActivity albumActivity) {
        this.gjT = albumActivity;
        this.arF = albumActivity.amA();
        this.mWidth = (int) this.gjT.getResources().getDimension(r.e.ds120);
        this.fUQ = com.baidu.adp.lib.util.k.K(this.gjT.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<d> list, String str) {
        this.mList = list;
        this.fPB = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mList != null) {
            return this.mList.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tI */
    public d getItem(int i) {
        if (this.mList == null || i < 0 || i >= this.mList.size()) {
            return null;
        }
        return this.mList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            view = LayoutInflater.from(this.gjT.getPageContext().getPageActivity()).inflate(r.h.album_list_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.gkl = (HeadImageView) view.findViewById(r.g.item_head);
            aVar2.gkm = (TextView) view.findViewById(r.g.item_name);
            aVar2.gkn = (ImageView) view.findViewById(r.g.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.gkl.setTag(null);
        aVar.gkl.setDefaultResource(r.f.pic_image_h_not);
        aVar.gkl.c(null, 12, false);
        aVar.gkl.invalidate();
        d item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.gkm.setText(String.valueOf(com.baidu.adp.lib.util.k.a(aVar.gkm.getPaint(), item.getName(), this.fUQ)) + "(" + item.buI() + ")");
            } else {
                aVar.gkm.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.fPB)) {
                aVar.gkn.setVisibility(0);
            } else {
                aVar.gkn.setVisibility(8);
            }
            ImageFileInfo buJ = item.buJ();
            if (buJ != null) {
                buJ.clearPageActions();
                buJ.addPageAction(com.baidu.tbadk.img.effect.d.F(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a2 = this.arF.a(buJ, false);
                aVar.gkl.setTag(buJ.toCachedKey(false));
                if (a2 != null) {
                    aVar.gkl.invalidate();
                } else {
                    this.arF.a(buJ, new m(this, viewGroup), false, this.gjT.isScroll());
                }
            }
        } else {
            aVar.gkm.setText("");
        }
        this.gjT.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.gjT.getLayoutMode().x(view);
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        HeadImageView gkl;
        TextView gkm;
        ImageView gkn;

        private a() {
        }

        /* synthetic */ a(l lVar, a aVar) {
            this();
        }
    }
}
