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
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class m extends BaseAdapter {
    private com.baidu.tbadk.img.b awf;
    private String fMI;
    private int fMJ;
    private AlbumActivity fMg;
    private List<e> mList;
    private int mWidth;

    public m(AlbumActivity albumActivity) {
        this.fMg = albumActivity;
        this.awf = albumActivity.afY();
        this.mWidth = (int) this.fMg.getResources().getDimension(w.f.ds120);
        this.fMJ = com.baidu.adp.lib.util.k.af(this.fMg.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<e> list, String str) {
        this.mList = list;
        this.fMI = str;
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
    /* renamed from: sP */
    public e getItem(int i) {
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
            view = LayoutInflater.from(this.fMg.getPageContext().getPageActivity()).inflate(w.j.album_list_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.fML = (HeadImageView) view.findViewById(w.h.item_head);
            aVar2.fMM = (TextView) view.findViewById(w.h.item_name);
            aVar2.fMN = (ImageView) view.findViewById(w.h.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.fML.setTag(null);
        aVar.fML.setDefaultResource(w.g.pic_image_h_not);
        aVar.fML.c(null, 12, false);
        aVar.fML.invalidate();
        e item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.fMM.setText(String.valueOf(com.baidu.adp.lib.util.k.a(aVar.fMM.getPaint(), item.getName(), this.fMJ)) + "(" + item.bmi() + ")");
            } else {
                aVar.fMM.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.fMI)) {
                aVar.fMN.setVisibility(0);
            } else {
                aVar.fMN.setVisibility(8);
            }
            ImageFileInfo bmj = item.bmj();
            if (bmj != null) {
                bmj.clearPageActions();
                bmj.addPageAction(com.baidu.tbadk.img.effect.d.M(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a2 = this.awf.a(bmj, false);
                aVar.fML.setTag(bmj.toCachedKey(false));
                if (a2 != null) {
                    aVar.fML.invalidate();
                } else {
                    this.awf.a(bmj, new n(this, viewGroup), false, this.fMg.isScroll());
                }
            }
        } else {
            aVar.fMM.setText("");
        }
        this.fMg.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.fMg.getLayoutMode().t(view);
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        HeadImageView fML;
        TextView fMM;
        ImageView fMN;

        private a() {
        }

        /* synthetic */ a(m mVar, a aVar) {
            this();
        }
    }
}
