package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private com.baidu.tbadk.img.b amz;
    private String eFl;
    private int eKE;
    private AlbumActivity eXM;
    private List<d> mList;
    private int mWidth;

    public l(AlbumActivity albumActivity) {
        this.eXM = albumActivity;
        this.amz = albumActivity.YI();
        this.mWidth = (int) this.eXM.getResources().getDimension(t.e.album_image_height);
        this.eKE = com.baidu.adp.lib.util.k.B(this.eXM.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<d> list, String str) {
        this.mList = list;
        this.eFl = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mList != null) {
            return this.mList.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qN */
    public d getItem(int i) {
        if (this.mList == null || i < 0 || i >= this.mList.size()) {
            return null;
        }
        return this.mList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            view = LayoutInflater.from(this.eXM.getPageContext().getPageActivity()).inflate(t.h.album_list_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.eYc = (HeadImageView) view.findViewById(t.g.item_head);
            aVar2.eYd = (TextView) view.findViewById(t.g.item_name);
            aVar2.eYe = (ImageView) view.findViewById(t.g.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.eYc.setTag(null);
        aVar.eYc.setDefaultResource(t.f.pic_image_h_not);
        aVar.eYc.c(null, 12, false);
        aVar.eYc.invalidate();
        d item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.eYd.setText(String.valueOf(com.baidu.adp.lib.util.k.a(aVar.eYd.getPaint(), item.getName(), this.eKE)) + "(" + item.bbs() + ")");
            } else {
                aVar.eYd.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.eFl)) {
                aVar.eYe.setVisibility(0);
            } else {
                aVar.eYe.setVisibility(8);
            }
            ImageFileInfo bbt = item.bbt();
            if (bbt != null) {
                bbt.clearPageActions();
                bbt.addPageAction(com.baidu.tbadk.img.effect.d.D(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a2 = this.amz.a(bbt, false);
                aVar.eYc.setTag(bbt.toCachedKey(false));
                if (a2 != null) {
                    aVar.eYc.invalidate();
                } else {
                    this.amz.a(bbt, new m(this, viewGroup), false, this.eXM.isScroll());
                }
            }
        } else {
            aVar.eYd.setText("");
        }
        this.eXM.getLayoutMode().ae(TbadkCoreApplication.m11getInst().getSkinType() == 1);
        this.eXM.getLayoutMode().x(view);
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        HeadImageView eYc;
        TextView eYd;
        ImageView eYe;

        private a() {
        }

        /* synthetic */ a(l lVar, a aVar) {
            this();
        }
    }
}
