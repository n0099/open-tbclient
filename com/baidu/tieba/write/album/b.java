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
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    private String bMF;
    private int bMG;
    private BaseFragmentActivity iJr;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.iJr = baseFragmentActivity;
        this.mLayoutInflater = LayoutInflater.from(this.iJr.getPageContext().getPageActivity());
        this.bMG = l.getEquipmentWidth(this.iJr.getPageContext().getPageActivity()) / 2;
    }

    public void c(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.bMF = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return x.getCount(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: zz */
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
            aVar.nYs = (TbImageView) view.findViewById(R.id.item_head);
            aVar.bMI = (TextView) view.findViewById(R.id.item_name);
            aVar.bMJ = (ImageView) view.findViewById(R.id.item_arrow);
            aVar.nYs.setGifIconSupport(false);
            aVar.nYs.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.bMI.setText(l.getTextOmit(aVar.bMI.getPaint(), item.getName(), this.bMG) + "(" + item.getCount() + ")");
            } else {
                aVar.bMI.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.bMF)) {
                aVar.bMJ.setImageDrawable(WebPManager.a(R.drawable.icon_pure_strok324_select, ao.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                aVar.bMJ.setVisibility(0);
            } else {
                aVar.bMJ.setVisibility(8);
            }
            MediaFileInfo bnr = item.bnr();
            if (bnr instanceof VideoFileInfo) {
                aVar.nYs.startLoad(((VideoFileInfo) bnr).videoPath, 37, false);
            } else if (bnr instanceof ImageFileInfo) {
                aVar.nYs.startLoad(((ImageFileInfo) bnr).getFilePath(), 35, false);
            }
            ao.setViewTextColor(aVar.bMI, R.color.CAM_X0105);
            ao.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes8.dex */
    private class a {
        TextView bMI;
        ImageView bMJ;
        TbImageView nYs;

        private a() {
        }
    }
}
