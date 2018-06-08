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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private String cZP;
    private int cZQ;
    private AlbumActivity how;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(AlbumActivity albumActivity) {
        this.how = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.how.getPageContext().getPageActivity());
        this.cZQ = l.ah(this.how.getPageContext().getPageActivity()) / 2;
    }

    public void f(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.cZP = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return w.y(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jO */
    public com.baidu.tbadk.album.a getItem(int i) {
        return (com.baidu.tbadk.album.a) w.c(this.mList, i);
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
            view = this.mLayoutInflater.inflate(d.i.album_list_item, viewGroup, false);
            aVar = new a();
            aVar.hoH = (TbImageView) view.findViewById(d.g.item_head);
            aVar.cZT = (TextView) view.findViewById(d.g.item_name);
            aVar.cZU = (ImageView) view.findViewById(d.g.item_arrow);
            aVar.hoH.setGifIconSupport(false);
            aVar.hoH.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.cZT.setText(l.a(aVar.cZT.getPaint(), item.getName(), this.cZQ) + "(" + item.getCount() + ")");
            } else {
                aVar.cZT.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.cZP)) {
                al.c(aVar.cZU, d.f.icon_list_select_ok_n);
                aVar.cZU.setVisibility(0);
            } else {
                aVar.cZU.setVisibility(8);
            }
            MediaFileInfo rP = item.rP();
            if (rP instanceof VideoFileInfo) {
                aVar.hoH.startLoad(((VideoFileInfo) rP).videoPath, 37, false);
            } else if (rP instanceof ImageFileInfo) {
                aVar.hoH.startLoad(((ImageFileInfo) rP).getFilePath(), 35, false);
            }
            al.h(aVar.cZT, d.C0141d.cp_cont_b);
            al.i(view, d.f.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView cZT;
        ImageView cZU;
        TbImageView hoH;

        private a() {
        }
    }
}
