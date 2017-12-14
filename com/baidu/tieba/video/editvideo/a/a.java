package com.baidu.tieba.video.editvideo.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.editvideo.data.PendantData;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private InterfaceC0147a gRo;
    private List<PendantData> mList;
    private e mPageContext;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0147a {
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
            bVar.gRq = (TextView) view.findViewById(d.g.cover_text);
            bVar.gRr = (TbImageView) view.findViewById(d.g.pendant_image);
            bVar.gRs = (ProgressBar) view.findViewById(d.g.pendant_progressbar);
            bVar.gRr.setDefaultBgResource(d.C0096d.transparent);
            bVar.gRr.setDefaultErrorResource(d.C0096d.cp_cont_i);
            bVar.gRr.setDefaultResource(d.C0096d.cp_cont_i);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.gRo != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.gRr.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.gRr.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.gRo.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
                            }
                        }
                    }
                }
            });
            view.setBackgroundColor(aj.getColor(d.C0096d.cp_bg_line_d));
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        PendantData pendantData = this.mList.get(i);
        if (pendantData != null) {
            bVar.gRr.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.gRq.setVisibility(0);
                    bVar.gRr.setVisibility(8);
                    bVar.gRs.setVisibility(8);
                    bVar.gRq.setTextColor(aj.getColor(d.C0096d.cp_cont_e));
                    bVar.gRq.setText("No");
                    bVar.gRq.setBackgroundDrawable(aj.getDrawable(d.f.bg_cover_text_border));
                    break;
                case 1:
                    bVar.gRq.setVisibility(0);
                    bVar.gRr.setVisibility(8);
                    bVar.gRs.setVisibility(8);
                    bVar.gRq.setTextColor(aj.getColor(d.C0096d.cp_cont_g));
                    bVar.gRq.setText("T");
                    bVar.gRq.setBackgroundColor(aj.getColor(d.C0096d.cp_link_tip_a));
                    break;
                case 2:
                    bVar.gRq.setVisibility(0);
                    bVar.gRr.setVisibility(8);
                    bVar.gRs.setVisibility(8);
                    bVar.gRq.setTextColor(aj.getColor(d.C0096d.cp_cont_g));
                    bVar.gRq.setText("T");
                    bVar.gRq.setBackgroundColor(aj.getColor(d.C0096d.cp_cont_d));
                    break;
                case 3:
                    bVar.gRq.setVisibility(0);
                    bVar.gRr.setVisibility(8);
                    bVar.gRs.setVisibility(8);
                    bVar.gRq.setTextColor(aj.getColor(d.C0096d.cp_cont_d));
                    bVar.gRq.setText("T");
                    bVar.gRq.setBackgroundDrawable(aj.getDrawable(d.f.bg_cover_text_border));
                    break;
                default:
                    bVar.gRq.setVisibility(8);
                    bVar.gRr.setVisibility(0);
                    bVar.gRs.setVisibility(8);
                    bVar.gRr.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0147a interfaceC0147a) {
        this.gRo = interfaceC0147a;
    }

    /* loaded from: classes2.dex */
    public class b {
        public TextView gRq;
        public TbImageView gRr;
        public ProgressBar gRs;

        public b() {
        }
    }
}
