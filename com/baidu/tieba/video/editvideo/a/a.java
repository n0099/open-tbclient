package com.baidu.tieba.video.editvideo.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.editvideo.data.PendantData;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private InterfaceC0397a iWi;
    private List<PendantData> mList;
    private e mPageContext;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0397a {
        void a(View view, int i, PendantData pendantData);
    }

    public a(e eVar) {
        this.mPageContext = eVar;
    }

    public void setData(List<PendantData> list) {
        if (list != null) {
            this.mList = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mList == null) {
            return 0;
        }
        return this.mList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.layout_pendant_item, (ViewGroup) null);
            bVar = new b();
            bVar.iWk = (TextView) view.findViewById(d.g.cover_text);
            bVar.iWl = (TbImageView) view.findViewById(d.g.pendant_image);
            bVar.iWm = (ProgressBar) view.findViewById(d.g.pendant_progressbar);
            bVar.iWl.setDefaultBgResource(d.C0277d.transparent);
            bVar.iWl.setDefaultErrorResource(d.C0277d.cp_btn_a);
            bVar.iWl.setDefaultResource(d.C0277d.cp_btn_a);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.iWi != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.iWl.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.iWl.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.iWi.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
                            }
                        }
                    }
                }
            });
            view.setBackgroundColor(al.getColor(d.C0277d.cp_bg_line_d));
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        PendantData pendantData = this.mList.get(i);
        if (pendantData != null) {
            bVar.iWl.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.iWk.setVisibility(0);
                    bVar.iWl.setVisibility(8);
                    bVar.iWm.setVisibility(8);
                    bVar.iWk.setTextColor(al.getColor(d.C0277d.cp_cont_e));
                    bVar.iWk.setText("No");
                    bVar.iWk.setBackgroundDrawable(al.getDrawable(d.f.bg_cover_text_border));
                    break;
                case 1:
                    bVar.iWk.setVisibility(0);
                    bVar.iWl.setVisibility(8);
                    bVar.iWm.setVisibility(8);
                    bVar.iWk.setTextColor(al.getColor(d.C0277d.cp_cont_g));
                    bVar.iWk.setText("T");
                    bVar.iWk.setBackgroundColor(al.getColor(d.C0277d.cp_link_tip_a));
                    break;
                case 2:
                    bVar.iWk.setVisibility(0);
                    bVar.iWl.setVisibility(8);
                    bVar.iWm.setVisibility(8);
                    bVar.iWk.setTextColor(al.getColor(d.C0277d.cp_cont_g));
                    bVar.iWk.setText("T");
                    bVar.iWk.setBackgroundColor(al.getColor(d.C0277d.cp_cont_d));
                    break;
                case 3:
                    bVar.iWk.setVisibility(0);
                    bVar.iWl.setVisibility(8);
                    bVar.iWm.setVisibility(8);
                    bVar.iWk.setTextColor(al.getColor(d.C0277d.cp_cont_d));
                    bVar.iWk.setText("T");
                    bVar.iWk.setBackgroundDrawable(al.getDrawable(d.f.bg_cover_text_border));
                    break;
                default:
                    bVar.iWk.setVisibility(8);
                    bVar.iWl.setVisibility(0);
                    bVar.iWm.setVisibility(8);
                    bVar.iWl.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0397a interfaceC0397a) {
        this.iWi = interfaceC0397a;
    }

    /* loaded from: classes5.dex */
    public class b {
        public TextView iWk;
        public TbImageView iWl;
        public ProgressBar iWm;

        public b() {
        }
    }
}
