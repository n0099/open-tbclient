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
    private InterfaceC0397a iWt;
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
            bVar.iWv = (TextView) view.findViewById(d.g.cover_text);
            bVar.iWw = (TbImageView) view.findViewById(d.g.pendant_image);
            bVar.iWx = (ProgressBar) view.findViewById(d.g.pendant_progressbar);
            bVar.iWw.setDefaultBgResource(d.C0277d.transparent);
            bVar.iWw.setDefaultErrorResource(d.C0277d.cp_btn_a);
            bVar.iWw.setDefaultResource(d.C0277d.cp_btn_a);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.iWt != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.iWw.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.iWw.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.iWt.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
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
            bVar.iWw.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.iWv.setVisibility(0);
                    bVar.iWw.setVisibility(8);
                    bVar.iWx.setVisibility(8);
                    bVar.iWv.setTextColor(al.getColor(d.C0277d.cp_cont_e));
                    bVar.iWv.setText("No");
                    bVar.iWv.setBackgroundDrawable(al.getDrawable(d.f.bg_cover_text_border));
                    break;
                case 1:
                    bVar.iWv.setVisibility(0);
                    bVar.iWw.setVisibility(8);
                    bVar.iWx.setVisibility(8);
                    bVar.iWv.setTextColor(al.getColor(d.C0277d.cp_cont_g));
                    bVar.iWv.setText("T");
                    bVar.iWv.setBackgroundColor(al.getColor(d.C0277d.cp_link_tip_a));
                    break;
                case 2:
                    bVar.iWv.setVisibility(0);
                    bVar.iWw.setVisibility(8);
                    bVar.iWx.setVisibility(8);
                    bVar.iWv.setTextColor(al.getColor(d.C0277d.cp_cont_g));
                    bVar.iWv.setText("T");
                    bVar.iWv.setBackgroundColor(al.getColor(d.C0277d.cp_cont_d));
                    break;
                case 3:
                    bVar.iWv.setVisibility(0);
                    bVar.iWw.setVisibility(8);
                    bVar.iWx.setVisibility(8);
                    bVar.iWv.setTextColor(al.getColor(d.C0277d.cp_cont_d));
                    bVar.iWv.setText("T");
                    bVar.iWv.setBackgroundDrawable(al.getDrawable(d.f.bg_cover_text_border));
                    break;
                default:
                    bVar.iWv.setVisibility(8);
                    bVar.iWw.setVisibility(0);
                    bVar.iWx.setVisibility(8);
                    bVar.iWw.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0397a interfaceC0397a) {
        this.iWt = interfaceC0397a;
    }

    /* loaded from: classes5.dex */
    public class b {
        public TextView iWv;
        public TbImageView iWw;
        public ProgressBar iWx;

        public b() {
        }
    }
}
