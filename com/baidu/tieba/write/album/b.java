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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private String fki;
    private int fkj;
    private AlbumActivity jQx;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(AlbumActivity albumActivity) {
        this.jQx = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.jQx.getPageContext().getPageActivity());
        this.fkj = l.af(this.jQx.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.fki = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.Z(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qY */
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
            view = this.mLayoutInflater.inflate(R.layout.album_list_item, viewGroup, false);
            aVar = new a();
            aVar.jQI = (TbImageView) view.findViewById(R.id.item_head);
            aVar.fkm = (TextView) view.findViewById(R.id.item_name);
            aVar.fkn = (ImageView) view.findViewById(R.id.item_arrow);
            aVar.jQI.setGifIconSupport(false);
            aVar.jQI.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.fkm.setText(l.a(aVar.fkm.getPaint(), item.getName(), this.fkj) + "(" + item.getCount() + ")");
            } else {
                aVar.fkm.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.fki)) {
                am.c(aVar.fkn, (int) R.drawable.icon_list_select_ok_n);
                aVar.fkn.setVisibility(0);
            } else {
                aVar.fkn.setVisibility(8);
            }
            MediaFileInfo aas = item.aas();
            if (aas instanceof VideoFileInfo) {
                aVar.jQI.startLoad(((VideoFileInfo) aas).videoPath, 37, false);
            } else if (aas instanceof ImageFileInfo) {
                aVar.jQI.startLoad(((ImageFileInfo) aas).getFilePath(), 35, false);
            }
            am.j(aVar.fkm, R.color.cp_cont_b);
            am.k(view, R.drawable.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView fkm;
        ImageView fkn;
        TbImageView jQI;

        private a() {
        }
    }
}
