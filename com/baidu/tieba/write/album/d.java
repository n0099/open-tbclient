package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends BaseAdapter {
    private int cAA;
    private String cAz;
    private LayoutInflater hcE;
    private AlbumActivity hcu;
    private List<com.baidu.tbadk.album.a> mList;

    public d(AlbumActivity albumActivity) {
        this.hcu = albumActivity;
        this.hcE = LayoutInflater.from(this.hcu.getPageContext().getPageActivity());
        this.cAA = com.baidu.adp.lib.util.l.ac(this.hcu.getPageContext().getPageActivity()) / 2;
    }

    public void d(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.cAz = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.v(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jA */
    public com.baidu.tbadk.album.a getItem(int i) {
        return (com.baidu.tbadk.album.a) v.c(this.mList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view != null && (view.getTag() instanceof a)) {
            aVar = (a) view.getTag();
        } else {
            view = this.hcE.inflate(d.h.album_list_item, viewGroup, false);
            aVar = new a();
            aVar.hcG = (TbImageView) view.findViewById(d.g.item_head);
            aVar.cAD = (TextView) view.findViewById(d.g.item_name);
            aVar.cAE = (ImageView) view.findViewById(d.g.item_arrow);
            aVar.hcG.setGifIconSupport(false);
            aVar.hcG.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.cAD.setText(com.baidu.adp.lib.util.l.a(aVar.cAD.getPaint(), item.getName(), this.cAA) + "(" + item.nz() + ")");
            } else {
                aVar.cAD.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.cAz)) {
                aj.c(aVar.cAE, d.f.icon_list_select_ok_n);
                aVar.cAE.setVisibility(0);
            } else {
                aVar.cAE.setVisibility(8);
            }
            MediaFileInfo nB = item.nB();
            if (nB instanceof VideoFileInfo) {
                aVar.hcG.startLoad(((VideoFileInfo) nB).videoPath, 37, false);
            } else if (nB instanceof ImageFileInfo) {
                aVar.hcG.startLoad(((ImageFileInfo) nB).getFilePath(), 35, false);
            }
            aj.i(aVar.cAD, d.C0082d.cp_cont_b);
            aj.j(view, d.f.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes2.dex */
    private class a {
        TextView cAD;
        ImageView cAE;
        TbImageView hcG;

        private a() {
        }
    }
}
