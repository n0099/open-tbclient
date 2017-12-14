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
    private String cAH;
    private int cAI;
    private AlbumActivity hfk;
    private LayoutInflater hfu;
    private List<com.baidu.tbadk.album.a> mList;

    public d(AlbumActivity albumActivity) {
        this.hfk = albumActivity;
        this.hfu = LayoutInflater.from(this.hfk.getPageContext().getPageActivity());
        this.cAI = com.baidu.adp.lib.util.l.ac(this.hfk.getPageContext().getPageActivity()) / 2;
    }

    public void d(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.cAH = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.v(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jC */
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
            view = this.hfu.inflate(d.h.album_list_item, viewGroup, false);
            aVar = new a();
            aVar.hfw = (TbImageView) view.findViewById(d.g.item_head);
            aVar.cAL = (TextView) view.findViewById(d.g.item_name);
            aVar.cAM = (ImageView) view.findViewById(d.g.item_arrow);
            aVar.hfw.setGifIconSupport(false);
            aVar.hfw.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.cAL.setText(com.baidu.adp.lib.util.l.a(aVar.cAL.getPaint(), item.getName(), this.cAI) + "(" + item.getCount() + ")");
            } else {
                aVar.cAL.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.cAH)) {
                aj.c(aVar.cAM, d.f.icon_list_select_ok_n);
                aVar.cAM.setVisibility(0);
            } else {
                aVar.cAM.setVisibility(8);
            }
            MediaFileInfo ny = item.ny();
            if (ny instanceof VideoFileInfo) {
                aVar.hfw.startLoad(((VideoFileInfo) ny).videoPath, 37, false);
            } else if (ny instanceof ImageFileInfo) {
                aVar.hfw.startLoad(((ImageFileInfo) ny).getFilePath(), 35, false);
            }
            aj.i(aVar.cAL, d.C0096d.cp_cont_b);
            aj.j(view, d.f.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes2.dex */
    private class a {
        TextView cAL;
        ImageView cAM;
        TbImageView hfw;

        private a() {
        }
    }
}
