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
    private InterfaceC0133a gFe;
    private List<PendantData> mList;
    private e mPageContext;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0133a {
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
            bVar.gFg = (TextView) view.findViewById(d.g.cover_text);
            bVar.gFh = (TbImageView) view.findViewById(d.g.pendant_image);
            bVar.gFi = (ProgressBar) view.findViewById(d.g.pendant_progressbar);
            bVar.gFh.setDefaultBgResource(d.C0080d.transparent);
            bVar.gFh.setDefaultErrorResource(d.C0080d.cp_cont_i);
            bVar.gFh.setDefaultResource(d.C0080d.cp_cont_i);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.gFe != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.gFh.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.gFh.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.gFe.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
                            }
                        }
                    }
                }
            });
            view.setBackgroundColor(aj.getColor(d.C0080d.cp_bg_line_d));
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        PendantData pendantData = this.mList.get(i);
        if (pendantData != null) {
            bVar.gFh.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.gFg.setVisibility(0);
                    bVar.gFh.setVisibility(8);
                    bVar.gFi.setVisibility(8);
                    bVar.gFg.setTextColor(aj.getColor(d.C0080d.cp_cont_e));
                    bVar.gFg.setText("No");
                    bVar.gFg.setBackgroundDrawable(aj.getDrawable(d.f.bg_cover_text_border));
                    break;
                case 1:
                    bVar.gFg.setVisibility(0);
                    bVar.gFh.setVisibility(8);
                    bVar.gFi.setVisibility(8);
                    bVar.gFg.setTextColor(aj.getColor(d.C0080d.cp_cont_g));
                    bVar.gFg.setText("T");
                    bVar.gFg.setBackgroundColor(aj.getColor(d.C0080d.cp_link_tip_a));
                    break;
                case 2:
                    bVar.gFg.setVisibility(0);
                    bVar.gFh.setVisibility(8);
                    bVar.gFi.setVisibility(8);
                    bVar.gFg.setTextColor(aj.getColor(d.C0080d.cp_cont_g));
                    bVar.gFg.setText("T");
                    bVar.gFg.setBackgroundColor(aj.getColor(d.C0080d.cp_cont_d));
                    break;
                case 3:
                    bVar.gFg.setVisibility(0);
                    bVar.gFh.setVisibility(8);
                    bVar.gFi.setVisibility(8);
                    bVar.gFg.setTextColor(aj.getColor(d.C0080d.cp_cont_d));
                    bVar.gFg.setText("T");
                    bVar.gFg.setBackgroundDrawable(aj.getDrawable(d.f.bg_cover_text_border));
                    break;
                default:
                    bVar.gFg.setVisibility(8);
                    bVar.gFh.setVisibility(0);
                    bVar.gFi.setVisibility(8);
                    bVar.gFh.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0133a interfaceC0133a) {
        this.gFe = interfaceC0133a;
    }

    /* loaded from: classes2.dex */
    public class b {
        public TextView gFg;
        public TbImageView gFh;
        public ProgressBar gFi;

        public b() {
        }
    }
}
