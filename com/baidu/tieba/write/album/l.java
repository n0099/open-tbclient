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
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private com.baidu.tbadk.img.b anf;
    private AlbumActivity fCP;
    private String fke;
    private int fpy;
    private List<d> mList;
    private int mWidth;

    public l(AlbumActivity albumActivity) {
        this.fCP = albumActivity;
        this.anf = albumActivity.afd();
        this.mWidth = (int) this.fCP.getResources().getDimension(u.e.ds120);
        this.fpy = com.baidu.adp.lib.util.k.A(this.fCP.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<d> list, String str) {
        this.mList = list;
        this.fke = str;
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
    /* renamed from: sd */
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
            view = LayoutInflater.from(this.fCP.getPageContext().getPageActivity()).inflate(u.h.album_list_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.fDf = (HeadImageView) view.findViewById(u.g.item_head);
            aVar2.fDg = (TextView) view.findViewById(u.g.item_name);
            aVar2.fDh = (ImageView) view.findViewById(u.g.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.fDf.setTag(null);
        aVar.fDf.setDefaultResource(u.f.pic_image_h_not);
        aVar.fDf.c(null, 12, false);
        aVar.fDf.invalidate();
        d item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.fDg.setText(String.valueOf(com.baidu.adp.lib.util.k.a(aVar.fDg.getPaint(), item.getName(), this.fpy)) + "(" + item.bjV() + ")");
            } else {
                aVar.fDg.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.fke)) {
                aVar.fDh.setVisibility(0);
            } else {
                aVar.fDh.setVisibility(8);
            }
            ImageFileInfo bjW = item.bjW();
            if (bjW != null) {
                bjW.clearPageActions();
                bjW.addPageAction(com.baidu.tbadk.img.effect.d.D(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a2 = this.anf.a(bjW, false);
                aVar.fDf.setTag(bjW.toCachedKey(false));
                if (a2 != null) {
                    aVar.fDf.invalidate();
                } else {
                    this.anf.a(bjW, new m(this, viewGroup), false, this.fCP.isScroll());
                }
            }
        } else {
            aVar.fDg.setText("");
        }
        this.fCP.getLayoutMode().ad(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.fCP.getLayoutMode().w(view);
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        HeadImageView fDf;
        TextView fDg;
        ImageView fDh;

        private a() {
        }

        /* synthetic */ a(l lVar, a aVar) {
            this();
        }
    }
}
