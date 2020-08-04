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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private String bjq;
    private int bjr;
    private BaseFragmentActivity hjZ;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.hjZ = baseFragmentActivity;
        this.mLayoutInflater = LayoutInflater.from(this.hjZ.getPageContext().getPageActivity());
        this.bjr = l.getEquipmentWidth(this.hjZ.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.bjq = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return x.getCount(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uj */
    public com.baidu.tbadk.album.a getItem(int i) {
        return (com.baidu.tbadk.album.a) x.getItem(this.mList, i);
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
            aVar.muT = (TbImageView) view.findViewById(R.id.item_head);
            aVar.bjt = (TextView) view.findViewById(R.id.item_name);
            aVar.bju = (ImageView) view.findViewById(R.id.item_arrow);
            aVar.muT.setGifIconSupport(false);
            aVar.muT.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.bjt.setText(l.getTextOmit(aVar.bjt.getPaint(), item.getName(), this.bjr) + "(" + item.getCount() + ")");
            } else {
                aVar.bjt.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.bjq)) {
                ao.setImageResource(aVar.bju, R.drawable.icon_list_select_ok_n);
                aVar.bju.setVisibility(0);
            } else {
                aVar.bju.setVisibility(8);
            }
            MediaFileInfo aSc = item.aSc();
            if (aSc instanceof VideoFileInfo) {
                aVar.muT.startLoad(((VideoFileInfo) aSc).videoPath, 37, false);
            } else if (aSc instanceof ImageFileInfo) {
                aVar.muT.startLoad(((ImageFileInfo) aSc).getFilePath(), 35, false);
            }
            ao.setViewTextColor(aVar.bjt, R.color.cp_cont_b);
            ao.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView bjt;
        ImageView bju;
        TbImageView muT;

        private a() {
        }
    }
}
