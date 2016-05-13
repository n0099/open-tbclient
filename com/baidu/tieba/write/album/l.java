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
    private String eFk;
    private int eKD;
    private AlbumActivity eXL;
    private List<d> mList;
    private int mWidth;

    public l(AlbumActivity albumActivity) {
        this.eXL = albumActivity;
        this.amz = albumActivity.YK();
        this.mWidth = (int) this.eXL.getResources().getDimension(t.e.album_image_height);
        this.eKD = com.baidu.adp.lib.util.k.B(this.eXL.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<d> list, String str) {
        this.mList = list;
        this.eFk = str;
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
    /* renamed from: qM */
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
            view = LayoutInflater.from(this.eXL.getPageContext().getPageActivity()).inflate(t.h.album_list_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.eYb = (HeadImageView) view.findViewById(t.g.item_head);
            aVar2.eYc = (TextView) view.findViewById(t.g.item_name);
            aVar2.eYd = (ImageView) view.findViewById(t.g.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.eYb.setTag(null);
        aVar.eYb.setDefaultResource(t.f.pic_image_h_not);
        aVar.eYb.c(null, 12, false);
        aVar.eYb.invalidate();
        d item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.eYc.setText(String.valueOf(com.baidu.adp.lib.util.k.a(aVar.eYc.getPaint(), item.getName(), this.eKD)) + "(" + item.bbz() + ")");
            } else {
                aVar.eYc.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.eFk)) {
                aVar.eYd.setVisibility(0);
            } else {
                aVar.eYd.setVisibility(8);
            }
            ImageFileInfo bbA = item.bbA();
            if (bbA != null) {
                bbA.clearPageActions();
                bbA.addPageAction(com.baidu.tbadk.img.effect.d.D(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a2 = this.amz.a(bbA, false);
                aVar.eYb.setTag(bbA.toCachedKey(false));
                if (a2 != null) {
                    aVar.eYb.invalidate();
                } else {
                    this.amz.a(bbA, new m(this, viewGroup), false, this.eXL.isScroll());
                }
            }
        } else {
            aVar.eYc.setText("");
        }
        this.eXL.getLayoutMode().ae(TbadkCoreApplication.m11getInst().getSkinType() == 1);
        this.eXL.getLayoutMode().x(view);
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        HeadImageView eYb;
        TextView eYc;
        ImageView eYd;

        private a() {
        }

        /* synthetic */ a(l lVar, a aVar) {
            this();
        }
    }
}
