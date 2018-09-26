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
import com.baidu.tieba.e;
import com.baidu.tieba.video.editvideo.data.PendantData;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private InterfaceC0247a hlo;
    private List<PendantData> mList;
    private e mPageContext;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0247a {
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
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(e.h.layout_pendant_item, (ViewGroup) null);
            bVar = new b();
            bVar.hlq = (TextView) view.findViewById(e.g.cover_text);
            bVar.hlr = (TbImageView) view.findViewById(e.g.pendant_image);
            bVar.hls = (ProgressBar) view.findViewById(e.g.pendant_progressbar);
            bVar.hlr.setDefaultBgResource(e.d.transparent);
            bVar.hlr.setDefaultErrorResource(e.d.cp_cont_i);
            bVar.hlr.setDefaultResource(e.d.cp_cont_i);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.hlo != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.hlr.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.hlr.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.hlo.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
                            }
                        }
                    }
                }
            });
            view.setBackgroundColor(al.getColor(e.d.cp_bg_line_d));
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        PendantData pendantData = this.mList.get(i);
        if (pendantData != null) {
            bVar.hlr.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.hlq.setVisibility(0);
                    bVar.hlr.setVisibility(8);
                    bVar.hls.setVisibility(8);
                    bVar.hlq.setTextColor(al.getColor(e.d.cp_cont_e));
                    bVar.hlq.setText("No");
                    bVar.hlq.setBackgroundDrawable(al.getDrawable(e.f.bg_cover_text_border));
                    break;
                case 1:
                    bVar.hlq.setVisibility(0);
                    bVar.hlr.setVisibility(8);
                    bVar.hls.setVisibility(8);
                    bVar.hlq.setTextColor(al.getColor(e.d.cp_cont_g));
                    bVar.hlq.setText("T");
                    bVar.hlq.setBackgroundColor(al.getColor(e.d.cp_link_tip_a));
                    break;
                case 2:
                    bVar.hlq.setVisibility(0);
                    bVar.hlr.setVisibility(8);
                    bVar.hls.setVisibility(8);
                    bVar.hlq.setTextColor(al.getColor(e.d.cp_cont_g));
                    bVar.hlq.setText("T");
                    bVar.hlq.setBackgroundColor(al.getColor(e.d.cp_cont_d));
                    break;
                case 3:
                    bVar.hlq.setVisibility(0);
                    bVar.hlr.setVisibility(8);
                    bVar.hls.setVisibility(8);
                    bVar.hlq.setTextColor(al.getColor(e.d.cp_cont_d));
                    bVar.hlq.setText("T");
                    bVar.hlq.setBackgroundDrawable(al.getDrawable(e.f.bg_cover_text_border));
                    break;
                default:
                    bVar.hlq.setVisibility(8);
                    bVar.hlr.setVisibility(0);
                    bVar.hls.setVisibility(8);
                    bVar.hlr.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0247a interfaceC0247a) {
        this.hlo = interfaceC0247a;
    }

    /* loaded from: classes2.dex */
    public class b {
        public TextView hlq;
        public TbImageView hlr;
        public ProgressBar hls;

        public b() {
        }
    }
}
