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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private String daJ;
    private int daK;
    private AlbumActivity htN;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(AlbumActivity albumActivity) {
        this.htN = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.htN.getPageContext().getPageActivity());
        this.daK = l.ah(this.htN.getPageContext().getPageActivity()) / 2;
    }

    public void f(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.daJ = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return w.y(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jY */
    public com.baidu.tbadk.album.a getItem(int i) {
        return (com.baidu.tbadk.album.a) w.d(this.mList, i);
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
            aVar.htY = (TbImageView) view.findViewById(d.g.item_head);
            aVar.daN = (TextView) view.findViewById(d.g.item_name);
            aVar.daO = (ImageView) view.findViewById(d.g.item_arrow);
            aVar.htY.setGifIconSupport(false);
            aVar.htY.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.daN.setText(l.a(aVar.daN.getPaint(), item.getName(), this.daK) + "(" + item.getCount() + ")");
            } else {
                aVar.daN.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.daJ)) {
                am.c(aVar.daO, d.f.icon_list_select_ok_n);
                aVar.daO.setVisibility(0);
            } else {
                aVar.daO.setVisibility(8);
            }
            MediaFileInfo rA = item.rA();
            if (rA instanceof VideoFileInfo) {
                aVar.htY.startLoad(((VideoFileInfo) rA).videoPath, 37, false);
            } else if (rA instanceof ImageFileInfo) {
                aVar.htY.startLoad(((ImageFileInfo) rA).getFilePath(), 35, false);
            }
            am.h(aVar.daN, d.C0140d.cp_cont_b);
            am.i(view, d.f.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView daN;
        ImageView daO;
        TbImageView htY;

        private a() {
        }
    }
}
