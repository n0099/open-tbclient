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
import com.baidu.tieba.f;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private String daF;
    private int daG;
    private AlbumActivity htP;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(AlbumActivity albumActivity) {
        this.htP = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.htP.getPageContext().getPageActivity());
        this.daG = l.ah(this.htP.getPageContext().getPageActivity()) / 2;
    }

    public void f(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.daF = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return w.y(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jX */
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
            view = this.mLayoutInflater.inflate(f.h.album_list_item, viewGroup, false);
            aVar = new a();
            aVar.hua = (TbImageView) view.findViewById(f.g.item_head);
            aVar.daJ = (TextView) view.findViewById(f.g.item_name);
            aVar.daK = (ImageView) view.findViewById(f.g.item_arrow);
            aVar.hua.setGifIconSupport(false);
            aVar.hua.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.daJ.setText(l.a(aVar.daJ.getPaint(), item.getName(), this.daG) + "(" + item.getCount() + ")");
            } else {
                aVar.daJ.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.daF)) {
                am.c(aVar.daK, f.C0146f.icon_list_select_ok_n);
                aVar.daK.setVisibility(0);
            } else {
                aVar.daK.setVisibility(8);
            }
            MediaFileInfo ry = item.ry();
            if (ry instanceof VideoFileInfo) {
                aVar.hua.startLoad(((VideoFileInfo) ry).videoPath, 37, false);
            } else if (ry instanceof ImageFileInfo) {
                aVar.hua.startLoad(((ImageFileInfo) ry).getFilePath(), 35, false);
            }
            am.h(aVar.daJ, f.d.cp_cont_b);
            am.i(view, f.C0146f.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView daJ;
        ImageView daK;
        TbImageView hua;

        private a() {
        }
    }
}
