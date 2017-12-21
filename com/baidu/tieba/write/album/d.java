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
    private String cAL;
    private int cAM;
    private AlbumActivity hfp;
    private LayoutInflater hfz;
    private List<com.baidu.tbadk.album.a> mList;

    public d(AlbumActivity albumActivity) {
        this.hfp = albumActivity;
        this.hfz = LayoutInflater.from(this.hfp.getPageContext().getPageActivity());
        this.cAM = com.baidu.adp.lib.util.l.ac(this.hfp.getPageContext().getPageActivity()) / 2;
    }

    public void d(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.cAL = str;
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
            view = this.hfz.inflate(d.h.album_list_item, viewGroup, false);
            aVar = new a();
            aVar.hfB = (TbImageView) view.findViewById(d.g.item_head);
            aVar.cAP = (TextView) view.findViewById(d.g.item_name);
            aVar.cAQ = (ImageView) view.findViewById(d.g.item_arrow);
            aVar.hfB.setGifIconSupport(false);
            aVar.hfB.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.cAP.setText(com.baidu.adp.lib.util.l.a(aVar.cAP.getPaint(), item.getName(), this.cAM) + "(" + item.getCount() + ")");
            } else {
                aVar.cAP.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.cAL)) {
                aj.c(aVar.cAQ, d.f.icon_list_select_ok_n);
                aVar.cAQ.setVisibility(0);
            } else {
                aVar.cAQ.setVisibility(8);
            }
            MediaFileInfo ny = item.ny();
            if (ny instanceof VideoFileInfo) {
                aVar.hfB.startLoad(((VideoFileInfo) ny).videoPath, 37, false);
            } else if (ny instanceof ImageFileInfo) {
                aVar.hfB.startLoad(((ImageFileInfo) ny).getFilePath(), 35, false);
            }
            aj.i(aVar.cAP, d.C0095d.cp_cont_b);
            aj.j(view, d.f.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes2.dex */
    private class a {
        TextView cAP;
        ImageView cAQ;
        TbImageView hfB;

        private a() {
        }
    }
}
