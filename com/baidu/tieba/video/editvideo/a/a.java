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
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private InterfaceC0239a gYe;
    private List<PendantData> mList;
    private e mPageContext;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0239a {
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
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.i.layout_pendant_item, (ViewGroup) null);
            bVar = new b();
            bVar.gYg = (TextView) view.findViewById(d.g.cover_text);
            bVar.gYh = (TbImageView) view.findViewById(d.g.pendant_image);
            bVar.gYi = (ProgressBar) view.findViewById(d.g.pendant_progressbar);
            bVar.gYh.setDefaultBgResource(d.C0141d.transparent);
            bVar.gYh.setDefaultErrorResource(d.C0141d.cp_cont_i);
            bVar.gYh.setDefaultResource(d.C0141d.cp_cont_i);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.gYe != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.gYh.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.gYh.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.gYe.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
                            }
                        }
                    }
                }
            });
            view.setBackgroundColor(al.getColor(d.C0141d.cp_bg_line_d));
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        PendantData pendantData = this.mList.get(i);
        if (pendantData != null) {
            bVar.gYh.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.gYg.setVisibility(0);
                    bVar.gYh.setVisibility(8);
                    bVar.gYi.setVisibility(8);
                    bVar.gYg.setTextColor(al.getColor(d.C0141d.cp_cont_e));
                    bVar.gYg.setText("No");
                    bVar.gYg.setBackgroundDrawable(al.getDrawable(d.f.bg_cover_text_border));
                    break;
                case 1:
                    bVar.gYg.setVisibility(0);
                    bVar.gYh.setVisibility(8);
                    bVar.gYi.setVisibility(8);
                    bVar.gYg.setTextColor(al.getColor(d.C0141d.cp_cont_g));
                    bVar.gYg.setText("T");
                    bVar.gYg.setBackgroundColor(al.getColor(d.C0141d.cp_link_tip_a));
                    break;
                case 2:
                    bVar.gYg.setVisibility(0);
                    bVar.gYh.setVisibility(8);
                    bVar.gYi.setVisibility(8);
                    bVar.gYg.setTextColor(al.getColor(d.C0141d.cp_cont_g));
                    bVar.gYg.setText("T");
                    bVar.gYg.setBackgroundColor(al.getColor(d.C0141d.cp_cont_d));
                    break;
                case 3:
                    bVar.gYg.setVisibility(0);
                    bVar.gYh.setVisibility(8);
                    bVar.gYi.setVisibility(8);
                    bVar.gYg.setTextColor(al.getColor(d.C0141d.cp_cont_d));
                    bVar.gYg.setText("T");
                    bVar.gYg.setBackgroundDrawable(al.getDrawable(d.f.bg_cover_text_border));
                    break;
                default:
                    bVar.gYg.setVisibility(8);
                    bVar.gYh.setVisibility(0);
                    bVar.gYi.setVisibility(8);
                    bVar.gYh.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0239a interfaceC0239a) {
        this.gYe = interfaceC0239a;
    }

    /* loaded from: classes2.dex */
    public class b {
        public TextView gYg;
        public TbImageView gYh;
        public ProgressBar gYi;

        public b() {
        }
    }
}
