package com.baidu.tieba.video.editvideo.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.editvideo.data.PendantData;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private InterfaceC0222a gLz;
    private List<PendantData> mList;
    private e mPageContext;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0222a {
        void a(View view2, int i, PendantData pendantData);
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
    public View getView(int i, View view2, ViewGroup viewGroup) {
        b bVar;
        if (view2 == null) {
            view2 = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.i.layout_pendant_item, (ViewGroup) null);
            bVar = new b();
            bVar.gLB = (TextView) view2.findViewById(d.g.cover_text);
            bVar.gLC = (TbImageView) view2.findViewById(d.g.pendant_image);
            bVar.gLD = (ProgressBar) view2.findViewById(d.g.pendant_progressbar);
            bVar.gLC.setDefaultBgResource(d.C0126d.transparent);
            bVar.gLC.setDefaultErrorResource(d.C0126d.cp_cont_i);
            bVar.gLC.setDefaultResource(d.C0126d.cp_cont_i);
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (a.this.gLz != null) {
                        b bVar2 = (b) view3.getTag();
                        if (bVar2.gLC.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.gLC.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.gLz.a(view3, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
                            }
                        }
                    }
                }
            });
            view2.setBackgroundColor(ak.getColor(d.C0126d.cp_bg_line_d));
            view2.setTag(bVar);
        } else {
            bVar = (b) view2.getTag();
        }
        PendantData pendantData = this.mList.get(i);
        if (pendantData != null) {
            bVar.gLC.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.gLB.setVisibility(0);
                    bVar.gLC.setVisibility(8);
                    bVar.gLD.setVisibility(8);
                    bVar.gLB.setTextColor(ak.getColor(d.C0126d.cp_cont_e));
                    bVar.gLB.setText("No");
                    bVar.gLB.setBackgroundDrawable(ak.getDrawable(d.f.bg_cover_text_border));
                    break;
                case 1:
                    bVar.gLB.setVisibility(0);
                    bVar.gLC.setVisibility(8);
                    bVar.gLD.setVisibility(8);
                    bVar.gLB.setTextColor(ak.getColor(d.C0126d.cp_cont_g));
                    bVar.gLB.setText("T");
                    bVar.gLB.setBackgroundColor(ak.getColor(d.C0126d.cp_link_tip_a));
                    break;
                case 2:
                    bVar.gLB.setVisibility(0);
                    bVar.gLC.setVisibility(8);
                    bVar.gLD.setVisibility(8);
                    bVar.gLB.setTextColor(ak.getColor(d.C0126d.cp_cont_g));
                    bVar.gLB.setText("T");
                    bVar.gLB.setBackgroundColor(ak.getColor(d.C0126d.cp_cont_d));
                    break;
                case 3:
                    bVar.gLB.setVisibility(0);
                    bVar.gLC.setVisibility(8);
                    bVar.gLD.setVisibility(8);
                    bVar.gLB.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
                    bVar.gLB.setText("T");
                    bVar.gLB.setBackgroundDrawable(ak.getDrawable(d.f.bg_cover_text_border));
                    break;
                default:
                    bVar.gLB.setVisibility(8);
                    bVar.gLC.setVisibility(0);
                    bVar.gLD.setVisibility(8);
                    bVar.gLC.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view2;
    }

    public void a(InterfaceC0222a interfaceC0222a) {
        this.gLz = interfaceC0222a;
    }

    /* loaded from: classes2.dex */
    public class b {
        public TextView gLB;
        public TbImageView gLC;
        public ProgressBar gLD;

        public b() {
        }
    }
}
