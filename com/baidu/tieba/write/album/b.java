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
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private String aWt;
    private int aWu;
    private AlbumActivity lye;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(AlbumActivity albumActivity) {
        this.lye = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.lye.getPageContext().getPageActivity());
        this.aWu = l.getEquipmentWidth(this.lye.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.aWt = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.getCount(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sJ */
    public com.baidu.tbadk.album.a getItem(int i) {
        return (com.baidu.tbadk.album.a) v.getItem(this.mList, i);
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
            aVar.lyj = (TbImageView) view.findViewById(R.id.item_head);
            aVar.aWw = (TextView) view.findViewById(R.id.item_name);
            aVar.aWx = (ImageView) view.findViewById(R.id.item_arrow);
            aVar.lyj.setGifIconSupport(false);
            aVar.lyj.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.aWw.setText(l.getTextOmit(aVar.aWw.getPaint(), item.getName(), this.aWu) + "(" + item.getCount() + ")");
            } else {
                aVar.aWw.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.aWt)) {
                am.setImageResource(aVar.aWx, R.drawable.icon_list_select_ok_n);
                aVar.aWx.setVisibility(0);
            } else {
                aVar.aWx.setVisibility(8);
            }
            MediaFileInfo aGQ = item.aGQ();
            if (aGQ instanceof VideoFileInfo) {
                aVar.lyj.startLoad(((VideoFileInfo) aGQ).videoPath, 37, false);
            } else if (aGQ instanceof ImageFileInfo) {
                aVar.lyj.startLoad(((ImageFileInfo) aGQ).getFilePath(), 35, false);
            }
            am.setViewTextColor(aVar.aWw, (int) R.color.cp_cont_b);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes2.dex */
    private class a {
        TextView aWw;
        ImageView aWx;
        TbImageView lyj;

        private a() {
        }
    }
}
