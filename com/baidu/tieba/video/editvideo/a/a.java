package com.baidu.tieba.video.editvideo.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.editvideo.data.PendantData;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private InterfaceC0241a hcj;
    private List<PendantData> mList;
    private e mPageContext;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0241a {
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
            bVar.hcl = (TextView) view.findViewById(d.g.cover_text);
            bVar.hcm = (TbImageView) view.findViewById(d.g.pendant_image);
            bVar.hcn = (ProgressBar) view.findViewById(d.g.pendant_progressbar);
            bVar.hcm.setDefaultBgResource(d.C0142d.transparent);
            bVar.hcm.setDefaultErrorResource(d.C0142d.cp_cont_i);
            bVar.hcm.setDefaultResource(d.C0142d.cp_cont_i);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.hcj != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.hcm.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.hcm.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.hcj.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
                            }
                        }
                    }
                }
            });
            view.setBackgroundColor(am.getColor(d.C0142d.cp_bg_line_d));
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        PendantData pendantData = this.mList.get(i);
        if (pendantData != null) {
            bVar.hcm.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.hcl.setVisibility(0);
                    bVar.hcm.setVisibility(8);
                    bVar.hcn.setVisibility(8);
                    bVar.hcl.setTextColor(am.getColor(d.C0142d.cp_cont_e));
                    bVar.hcl.setText("No");
                    bVar.hcl.setBackgroundDrawable(am.getDrawable(d.f.bg_cover_text_border));
                    break;
                case 1:
                    bVar.hcl.setVisibility(0);
                    bVar.hcm.setVisibility(8);
                    bVar.hcn.setVisibility(8);
                    bVar.hcl.setTextColor(am.getColor(d.C0142d.cp_cont_g));
                    bVar.hcl.setText("T");
                    bVar.hcl.setBackgroundColor(am.getColor(d.C0142d.cp_link_tip_a));
                    break;
                case 2:
                    bVar.hcl.setVisibility(0);
                    bVar.hcm.setVisibility(8);
                    bVar.hcn.setVisibility(8);
                    bVar.hcl.setTextColor(am.getColor(d.C0142d.cp_cont_g));
                    bVar.hcl.setText("T");
                    bVar.hcl.setBackgroundColor(am.getColor(d.C0142d.cp_cont_d));
                    break;
                case 3:
                    bVar.hcl.setVisibility(0);
                    bVar.hcm.setVisibility(8);
                    bVar.hcn.setVisibility(8);
                    bVar.hcl.setTextColor(am.getColor(d.C0142d.cp_cont_d));
                    bVar.hcl.setText("T");
                    bVar.hcl.setBackgroundDrawable(am.getDrawable(d.f.bg_cover_text_border));
                    break;
                default:
                    bVar.hcl.setVisibility(8);
                    bVar.hcm.setVisibility(0);
                    bVar.hcn.setVisibility(8);
                    bVar.hcm.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0241a interfaceC0241a) {
        this.hcj = interfaceC0241a;
    }

    /* loaded from: classes2.dex */
    public class b {
        public TextView hcl;
        public TbImageView hcm;
        public ProgressBar hcn;

        public b() {
        }
    }
}
