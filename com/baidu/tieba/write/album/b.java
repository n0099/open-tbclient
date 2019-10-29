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
    private String apU;
    private int apV;
    private AlbumActivity jOC;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(AlbumActivity albumActivity) {
        this.jOC = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.jOC.getPageContext().getPageActivity());
        this.apV = l.getEquipmentWidth(this.jOC.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.apU = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.getCount(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pU */
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
            aVar.jOH = (TbImageView) view.findViewById(R.id.item_head);
            aVar.apX = (TextView) view.findViewById(R.id.item_name);
            aVar.apY = (ImageView) view.findViewById(R.id.item_arrow);
            aVar.jOH.setGifIconSupport(false);
            aVar.jOH.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.apX.setText(l.getTextOmit(aVar.apX.getPaint(), item.getName(), this.apV) + "(" + item.getCount() + ")");
            } else {
                aVar.apX.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.apU)) {
                am.setImageResource(aVar.apY, R.drawable.icon_list_select_ok_n);
                aVar.apY.setVisibility(0);
            } else {
                aVar.apY.setVisibility(8);
            }
            MediaFileInfo aff = item.aff();
            if (aff instanceof VideoFileInfo) {
                aVar.jOH.startLoad(((VideoFileInfo) aff).videoPath, 37, false);
            } else if (aff instanceof ImageFileInfo) {
                aVar.jOH.startLoad(((ImageFileInfo) aff).getFilePath(), 35, false);
            }
            am.setViewTextColor(aVar.apX, (int) R.color.cp_cont_b);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView apX;
        ImageView apY;
        TbImageView jOH;

        private a() {
        }
    }
}
