package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private String eNb;
    private int eNc;
    private AlbumActivity jmM;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(AlbumActivity albumActivity) {
        this.jmM = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.jmM.getPageContext().getPageActivity());
        this.eNc = l.aO(this.jmM.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.eNb = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.S(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pz */
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
            view = this.mLayoutInflater.inflate(d.h.album_list_item, viewGroup, false);
            aVar = new a();
            aVar.jmX = (TbImageView) view.findViewById(d.g.item_head);
            aVar.eNf = (TextView) view.findViewById(d.g.item_name);
            aVar.eNg = (ImageView) view.findViewById(d.g.item_arrow);
            aVar.jmX.setGifIconSupport(false);
            aVar.jmX.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.eNf.setText(l.a(aVar.eNf.getPaint(), item.getName(), this.eNc) + "(" + item.getCount() + ")");
            } else {
                aVar.eNf.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.eNb)) {
                al.c(aVar.eNg, d.f.icon_list_select_ok_n);
                aVar.eNg.setVisibility(0);
            } else {
                aVar.eNg.setVisibility(8);
            }
            MediaFileInfo UO = item.UO();
            if (UO instanceof VideoFileInfo) {
                aVar.jmX.startLoad(((VideoFileInfo) UO).videoPath, 37, false);
            } else if (UO instanceof ImageFileInfo) {
                aVar.jmX.startLoad(((ImageFileInfo) UO).getFilePath(), 35, false);
            }
            al.j(aVar.eNf, d.C0236d.cp_cont_b);
            al.k(view, d.f.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView eNf;
        ImageView eNg;
        TbImageView jmX;

        private a() {
        }
    }
}
