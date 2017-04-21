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
    private com.baidu.tbadk.img.b awb;
    private String fPM;
    private int fPN;
    private AlbumActivity fPr;
    private List<d> mList;
    private int mWidth;

    public l(AlbumActivity albumActivity) {
        this.fPr = albumActivity;
        this.awb = albumActivity.aip();
        this.mWidth = (int) this.fPr.getResources().getDimension(w.f.ds120);
        this.fPN = com.baidu.adp.lib.util.k.af(this.fPr.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<d> list, String str) {
        this.mList = list;
        this.fPM = str;
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
    /* renamed from: sV */
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
            view = LayoutInflater.from(this.fPr.getPageContext().getPageActivity()).inflate(w.j.album_list_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.fPP = (HeadImageView) view.findViewById(w.h.item_head);
            aVar2.fPQ = (TextView) view.findViewById(w.h.item_name);
            aVar2.fPR = (ImageView) view.findViewById(w.h.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.fPP.setTag(null);
        aVar.fPP.setDefaultResource(w.g.pic_image_h_not);
        aVar.fPP.c(null, 12, false);
        aVar.fPP.invalidate();
        d item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.fPQ.setText(String.valueOf(com.baidu.adp.lib.util.k.a(aVar.fPQ.getPaint(), item.getName(), this.fPN)) + "(" + item.bov() + ")");
            } else {
                aVar.fPQ.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.fPM)) {
                aVar.fPR.setVisibility(0);
            } else {
                aVar.fPR.setVisibility(8);
            }
            ImageFileInfo bow = item.bow();
            if (bow != null) {
                bow.clearPageActions();
                bow.addPageAction(com.baidu.tbadk.img.effect.d.M(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a2 = this.awb.a(bow, false);
                aVar.fPP.setTag(bow.toCachedKey(false));
                if (a2 != null) {
                    aVar.fPP.invalidate();
                } else {
                    this.awb.a(bow, new m(this, viewGroup), false, this.fPr.isScroll());
                }
            }
        } else {
            aVar.fPQ.setText("");
        }
        this.fPr.getLayoutMode().aj(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.fPr.getLayoutMode().t(view);
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        HeadImageView fPP;
        TextView fPQ;
        ImageView fPR;

        private a() {
        }

        /* synthetic */ a(l lVar, a aVar) {
            this();
        }
    }
}
