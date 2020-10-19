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
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private String bvV;
    private int bvW;
    private BaseFragmentActivity hSW;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.hSW = baseFragmentActivity;
        this.mLayoutInflater = LayoutInflater.from(this.hSW.getPageContext().getPageActivity());
        this.bvW = l.getEquipmentWidth(this.hSW.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.bvV = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return y.getCount(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xD */
    public com.baidu.tbadk.album.a getItem(int i) {
        return (com.baidu.tbadk.album.a) y.getItem(this.mList, i);
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
            aVar.nmU = (TbImageView) view.findViewById(R.id.item_head);
            aVar.bvY = (TextView) view.findViewById(R.id.item_name);
            aVar.bvZ = (ImageView) view.findViewById(R.id.item_arrow);
            aVar.nmU.setGifIconSupport(false);
            aVar.nmU.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.bvY.setText(l.getTextOmit(aVar.bvY.getPaint(), item.getName(), this.bvW) + "(" + item.getCount() + ")");
            } else {
                aVar.bvY.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.bvV)) {
                ap.setImageResource(aVar.bvZ, R.drawable.icon_list_select_ok_n);
                aVar.bvZ.setVisibility(0);
            } else {
                aVar.bvZ.setVisibility(8);
            }
            MediaFileInfo bdV = item.bdV();
            if (bdV instanceof VideoFileInfo) {
                aVar.nmU.startLoad(((VideoFileInfo) bdV).videoPath, 37, false);
            } else if (bdV instanceof ImageFileInfo) {
                aVar.nmU.startLoad(((ImageFileInfo) bdV).getFilePath(), 35, false);
            }
            ap.setViewTextColor(aVar.bvY, R.color.cp_cont_b);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView bvY;
        ImageView bvZ;
        TbImageView nmU;

        private a() {
        }
    }
}
