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
    private com.baidu.tbadk.img.b aqL;
    private String fHZ;
    private int fNp;
    private AlbumActivity gco;
    private List<d> mList;
    private int mWidth;

    public l(AlbumActivity albumActivity) {
        this.gco = albumActivity;
        this.aqL = albumActivity.akF();
        this.mWidth = (int) this.gco.getResources().getDimension(r.e.ds120);
        this.fNp = com.baidu.adp.lib.util.k.K(this.gco.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<d> list, String str) {
        this.mList = list;
        this.fHZ = str;
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
    /* renamed from: tm */
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
            view = LayoutInflater.from(this.gco.getPageContext().getPageActivity()).inflate(r.h.album_list_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.gcG = (HeadImageView) view.findViewById(r.g.item_head);
            aVar2.gcH = (TextView) view.findViewById(r.g.item_name);
            aVar2.gcI = (ImageView) view.findViewById(r.g.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.gcG.setTag(null);
        aVar.gcG.setDefaultResource(r.f.pic_image_h_not);
        aVar.gcG.c(null, 12, false);
        aVar.gcG.invalidate();
        d item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.gcH.setText(String.valueOf(com.baidu.adp.lib.util.k.a(aVar.gcH.getPaint(), item.getName(), this.fNp)) + "(" + item.bsn() + ")");
            } else {
                aVar.gcH.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.fHZ)) {
                aVar.gcI.setVisibility(0);
            } else {
                aVar.gcI.setVisibility(8);
            }
            ImageFileInfo bso = item.bso();
            if (bso != null) {
                bso.clearPageActions();
                bso.addPageAction(com.baidu.tbadk.img.effect.d.F(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a2 = this.aqL.a(bso, false);
                aVar.gcG.setTag(bso.toCachedKey(false));
                if (a2 != null) {
                    aVar.gcG.invalidate();
                } else {
                    this.aqL.a(bso, new m(this, viewGroup), false, this.gco.isScroll());
                }
            }
        } else {
            aVar.gcH.setText("");
        }
        this.gco.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.gco.getLayoutMode().x(view);
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        HeadImageView gcG;
        TextView gcH;
        ImageView gcI;

        private a() {
        }

        /* synthetic */ a(l lVar, a aVar) {
            this();
        }
    }
}
