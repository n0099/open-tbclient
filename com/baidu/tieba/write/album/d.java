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
    private String dtO;
    private int dtP;
    private AlbumActivity hCT;
    private LayoutInflater kh;
    private List<com.baidu.tbadk.album.a> mList;

    public d(AlbumActivity albumActivity) {
        this.hCT = albumActivity;
        this.kh = LayoutInflater.from(this.hCT.getPageContext().getPageActivity());
        this.dtP = com.baidu.adp.lib.util.l.ao(this.hCT.getPageContext().getPageActivity()) / 2;
    }

    public void e(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.dtO = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.D(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mE */
    public com.baidu.tbadk.album.a getItem(int i) {
        return (com.baidu.tbadk.album.a) v.f(this.mList, i);
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
            view = this.kh.inflate(d.h.album_list_item, viewGroup, false);
            aVar = new a();
            aVar.hDe = (TbImageView) view.findViewById(d.g.item_head);
            aVar.dtS = (TextView) view.findViewById(d.g.item_name);
            aVar.dtT = (ImageView) view.findViewById(d.g.item_arrow);
            aVar.hDe.setGifIconSupport(false);
            aVar.hDe.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.dtS.setText(com.baidu.adp.lib.util.l.a(aVar.dtS.getPaint(), item.getName(), this.dtP) + "(" + item.getCount() + ")");
            } else {
                aVar.dtS.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.dtO)) {
                aj.c(aVar.dtT, d.f.icon_list_select_ok_n);
                aVar.dtT.setVisibility(0);
            } else {
                aVar.dtT.setVisibility(8);
            }
            MediaFileInfo vb = item.vb();
            if (vb instanceof VideoFileInfo) {
                aVar.hDe.startLoad(((VideoFileInfo) vb).videoPath, 37, false);
            } else if (vb instanceof ImageFileInfo) {
                aVar.hDe.startLoad(((ImageFileInfo) vb).getFilePath(), 35, false);
            }
            aj.r(aVar.dtS, d.C0107d.cp_cont_b);
            aj.s(view, d.f.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes2.dex */
    private class a {
        TextView dtS;
        ImageView dtT;
        TbImageView hDe;

        private a() {
        }
    }
}
