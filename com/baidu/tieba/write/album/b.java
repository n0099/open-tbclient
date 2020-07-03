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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private String biW;
    private int biX;
    private BaseFragmentActivity hep;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.hep = baseFragmentActivity;
        this.mLayoutInflater = LayoutInflater.from(this.hep.getPageContext().getPageActivity());
        this.biX = l.getEquipmentWidth(this.hep.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.biW = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return w.getCount(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tR */
    public com.baidu.tbadk.album.a getItem(int i) {
        return (com.baidu.tbadk.album.a) w.getItem(this.mList, i);
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
            aVar.mmO = (TbImageView) view.findViewById(R.id.item_head);
            aVar.biZ = (TextView) view.findViewById(R.id.item_name);
            aVar.bja = (ImageView) view.findViewById(R.id.item_arrow);
            aVar.mmO.setGifIconSupport(false);
            aVar.mmO.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.biZ.setText(l.getTextOmit(aVar.biZ.getPaint(), item.getName(), this.biX) + "(" + item.getCount() + ")");
            } else {
                aVar.biZ.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.biW)) {
                an.setImageResource(aVar.bja, R.drawable.icon_list_select_ok_n);
                aVar.bja.setVisibility(0);
            } else {
                aVar.bja.setVisibility(8);
            }
            MediaFileInfo aOh = item.aOh();
            if (aOh instanceof VideoFileInfo) {
                aVar.mmO.startLoad(((VideoFileInfo) aOh).videoPath, 37, false);
            } else if (aOh instanceof ImageFileInfo) {
                aVar.mmO.startLoad(((ImageFileInfo) aOh).getFilePath(), 35, false);
            }
            an.setViewTextColor(aVar.biZ, (int) R.color.cp_cont_b);
            an.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes2.dex */
    private class a {
        TextView biZ;
        ImageView bja;
        TbImageView mmO;

        private a() {
        }
    }
}
