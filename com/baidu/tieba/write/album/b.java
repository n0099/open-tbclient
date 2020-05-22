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
    private String bdJ;
    private int bdK;
    private AlbumActivity lRt;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(AlbumActivity albumActivity) {
        this.lRt = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.lRt.getPageContext().getPageActivity());
        this.bdK = l.getEquipmentWidth(this.lRt.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.bdJ = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.getCount(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: to */
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
            aVar.lRz = (TbImageView) view.findViewById(R.id.item_head);
            aVar.bdM = (TextView) view.findViewById(R.id.item_name);
            aVar.bdN = (ImageView) view.findViewById(R.id.item_arrow);
            aVar.lRz.setGifIconSupport(false);
            aVar.lRz.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.bdM.setText(l.getTextOmit(aVar.bdM.getPaint(), item.getName(), this.bdK) + "(" + item.getCount() + ")");
            } else {
                aVar.bdM.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.bdJ)) {
                am.setImageResource(aVar.bdN, R.drawable.icon_list_select_ok_n);
                aVar.bdN.setVisibility(0);
            } else {
                aVar.bdN.setVisibility(8);
            }
            MediaFileInfo aME = item.aME();
            if (aME instanceof VideoFileInfo) {
                aVar.lRz.startLoad(((VideoFileInfo) aME).videoPath, 37, false);
            } else if (aME instanceof ImageFileInfo) {
                aVar.lRz.startLoad(((ImageFileInfo) aME).getFilePath(), 35, false);
            }
            am.setViewTextColor(aVar.bdM, (int) R.color.cp_cont_b);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes2.dex */
    private class a {
        TextView bdM;
        ImageView bdN;
        TbImageView lRz;

        private a() {
        }
    }
}
