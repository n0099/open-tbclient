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
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private String doG;
    private int doH;
    private AlbumActivity hIX;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(AlbumActivity albumActivity) {
        this.hIX = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.hIX.getPageContext().getPageActivity());
        this.doH = l.aO(this.hIX.getPageContext().getPageActivity()) / 2;
    }

    public void f(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.doG = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.I(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: kU */
    public com.baidu.tbadk.album.a getItem(int i) {
        return (com.baidu.tbadk.album.a) v.d(this.mList, i);
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
            view = this.mLayoutInflater.inflate(e.h.album_list_item, viewGroup, false);
            aVar = new a();
            aVar.hJi = (TbImageView) view.findViewById(e.g.item_head);
            aVar.doK = (TextView) view.findViewById(e.g.item_name);
            aVar.doL = (ImageView) view.findViewById(e.g.item_arrow);
            aVar.hJi.setGifIconSupport(false);
            aVar.hJi.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.doK.setText(l.a(aVar.doK.getPaint(), item.getName(), this.doH) + "(" + item.getCount() + ")");
            } else {
                aVar.doK.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.doG)) {
                al.c(aVar.doL, e.f.icon_list_select_ok_n);
                aVar.doL.setVisibility(0);
            } else {
                aVar.doL.setVisibility(8);
            }
            MediaFileInfo uP = item.uP();
            if (uP instanceof VideoFileInfo) {
                aVar.hJi.startLoad(((VideoFileInfo) uP).videoPath, 37, false);
            } else if (uP instanceof ImageFileInfo) {
                aVar.hJi.startLoad(((ImageFileInfo) uP).getFilePath(), 35, false);
            }
            al.h(aVar.doK, e.d.cp_cont_b);
            al.i(view, e.f.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView doK;
        ImageView doL;
        TbImageView hJi;

        private a() {
        }
    }
}
