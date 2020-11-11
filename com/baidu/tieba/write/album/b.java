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
    private String bEu;
    private int bEv;
    private BaseFragmentActivity ilu;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.ilu = baseFragmentActivity;
        this.mLayoutInflater = LayoutInflater.from(this.ilu.getPageContext().getPageActivity());
        this.bEv = l.getEquipmentWidth(this.ilu.getPageContext().getPageActivity()) / 2;
    }

    public void c(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.bEu = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return y.getCount(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: yj */
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
            aVar.nFp = (TbImageView) view.findViewById(R.id.item_head);
            aVar.bEx = (TextView) view.findViewById(R.id.item_name);
            aVar.bEy = (ImageView) view.findViewById(R.id.item_arrow);
            aVar.nFp.setGifIconSupport(false);
            aVar.nFp.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.bEx.setText(l.getTextOmit(aVar.bEx.getPaint(), item.getName(), this.bEv) + "(" + item.getCount() + ")");
            } else {
                aVar.bEx.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.bEu)) {
                ap.setImageResource(aVar.bEy, R.drawable.icon_list_select_ok_n);
                aVar.bEy.setVisibility(0);
            } else {
                aVar.bEy.setVisibility(8);
            }
            MediaFileInfo bio = item.bio();
            if (bio instanceof VideoFileInfo) {
                aVar.nFp.startLoad(((VideoFileInfo) bio).videoPath, 37, false);
            } else if (bio instanceof ImageFileInfo) {
                aVar.nFp.startLoad(((ImageFileInfo) bio).getFilePath(), 35, false);
            }
            ap.setViewTextColor(aVar.bEx, R.color.cp_cont_b);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView bEx;
        ImageView bEy;
        TbImageView nFp;

        private a() {
        }
    }
}
