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
    private InterfaceC0240a hpH;
    private List<PendantData> mList;
    private e mPageContext;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0240a {
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
            bVar.hpJ = (TextView) view.findViewById(d.g.cover_text);
            bVar.hpK = (TbImageView) view.findViewById(d.g.pendant_image);
            bVar.hpL = (ProgressBar) view.findViewById(d.g.pendant_progressbar);
            bVar.hpK.setDefaultBgResource(d.C0140d.transparent);
            bVar.hpK.setDefaultErrorResource(d.C0140d.cp_cont_i);
            bVar.hpK.setDefaultResource(d.C0140d.cp_cont_i);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.hpH != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.hpK.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.hpK.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.hpH.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
                            }
                        }
                    }
                }
            });
            view.setBackgroundColor(aj.getColor(d.C0140d.cp_bg_line_d));
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        PendantData pendantData = this.mList.get(i);
        if (pendantData != null) {
            bVar.hpK.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.hpJ.setVisibility(0);
                    bVar.hpK.setVisibility(8);
                    bVar.hpL.setVisibility(8);
                    bVar.hpJ.setTextColor(aj.getColor(d.C0140d.cp_cont_e));
                    bVar.hpJ.setText("No");
                    bVar.hpJ.setBackgroundDrawable(aj.getDrawable(d.f.bg_cover_text_border));
                    break;
                case 1:
                    bVar.hpJ.setVisibility(0);
                    bVar.hpK.setVisibility(8);
                    bVar.hpL.setVisibility(8);
                    bVar.hpJ.setTextColor(aj.getColor(d.C0140d.cp_cont_g));
                    bVar.hpJ.setText("T");
                    bVar.hpJ.setBackgroundColor(aj.getColor(d.C0140d.cp_link_tip_a));
                    break;
                case 2:
                    bVar.hpJ.setVisibility(0);
                    bVar.hpK.setVisibility(8);
                    bVar.hpL.setVisibility(8);
                    bVar.hpJ.setTextColor(aj.getColor(d.C0140d.cp_cont_g));
                    bVar.hpJ.setText("T");
                    bVar.hpJ.setBackgroundColor(aj.getColor(d.C0140d.cp_cont_d));
                    break;
                case 3:
                    bVar.hpJ.setVisibility(0);
                    bVar.hpK.setVisibility(8);
                    bVar.hpL.setVisibility(8);
                    bVar.hpJ.setTextColor(aj.getColor(d.C0140d.cp_cont_d));
                    bVar.hpJ.setText("T");
                    bVar.hpJ.setBackgroundDrawable(aj.getDrawable(d.f.bg_cover_text_border));
                    break;
                default:
                    bVar.hpJ.setVisibility(8);
                    bVar.hpK.setVisibility(0);
                    bVar.hpL.setVisibility(8);
                    bVar.hpK.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0240a interfaceC0240a) {
        this.hpH = interfaceC0240a;
    }

    /* loaded from: classes2.dex */
    public class b {
        public TextView hpJ;
        public TbImageView hpK;
        public ProgressBar hpL;

        public b() {
        }
    }
}
