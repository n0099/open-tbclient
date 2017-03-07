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
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private com.baidu.tbadk.img.b avJ;
    private String fLH;
    private int fLI;
    private AlbumActivity fLm;
    private List<d> mList;
    private int mWidth;

    public l(AlbumActivity albumActivity) {
        this.fLm = albumActivity;
        this.avJ = albumActivity.ahu();
        this.mWidth = (int) this.fLm.getResources().getDimension(w.f.ds120);
        this.fLI = com.baidu.adp.lib.util.k.ag(this.fLm.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<d> list, String str) {
        this.mList = list;
        this.fLH = str;
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
    /* renamed from: sR */
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
            view = LayoutInflater.from(this.fLm.getPageContext().getPageActivity()).inflate(w.j.album_list_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.fLK = (HeadImageView) view.findViewById(w.h.item_head);
            aVar2.fLL = (TextView) view.findViewById(w.h.item_name);
            aVar2.fLM = (ImageView) view.findViewById(w.h.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.fLK.setTag(null);
        aVar.fLK.setDefaultResource(w.g.pic_image_h_not);
        aVar.fLK.c(null, 12, false);
        aVar.fLK.invalidate();
        d item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.fLL.setText(String.valueOf(com.baidu.adp.lib.util.k.a(aVar.fLL.getPaint(), item.getName(), this.fLI)) + "(" + item.bmK() + ")");
            } else {
                aVar.fLL.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.fLH)) {
                aVar.fLM.setVisibility(0);
            } else {
                aVar.fLM.setVisibility(8);
            }
            ImageFileInfo bmL = item.bmL();
            if (bmL != null) {
                bmL.clearPageActions();
                bmL.addPageAction(com.baidu.tbadk.img.effect.d.M(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a2 = this.avJ.a(bmL, false);
                aVar.fLK.setTag(bmL.toCachedKey(false));
                if (a2 != null) {
                    aVar.fLK.invalidate();
                } else {
                    this.avJ.a(bmL, new m(this, viewGroup), false, this.fLm.isScroll());
                }
            }
        } else {
            aVar.fLL.setText("");
        }
        this.fLm.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.fLm.getLayoutMode().t(view);
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        HeadImageView fLK;
        TextView fLL;
        ImageView fLM;

        private a() {
        }

        /* synthetic */ a(l lVar, a aVar) {
            this();
        }
    }
}
