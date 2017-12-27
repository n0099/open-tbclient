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
    private InterfaceC0159a hyv;
    private List<PendantData> mList;
    private e mPageContext;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0159a {
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
            bVar.hyx = (TextView) view.findViewById(d.g.cover_text);
            bVar.hyy = (TbImageView) view.findViewById(d.g.pendant_image);
            bVar.hyz = (ProgressBar) view.findViewById(d.g.pendant_progressbar);
            bVar.hyy.setDefaultBgResource(d.C0108d.transparent);
            bVar.hyy.setDefaultErrorResource(d.C0108d.cp_cont_i);
            bVar.hyy.setDefaultResource(d.C0108d.cp_cont_i);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.hyv != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.hyy.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.hyy.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.hyv.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
                            }
                        }
                    }
                }
            });
            view.setBackgroundColor(aj.getColor(d.C0108d.cp_bg_line_d));
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        PendantData pendantData = this.mList.get(i);
        if (pendantData != null) {
            bVar.hyy.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.hyx.setVisibility(0);
                    bVar.hyy.setVisibility(8);
                    bVar.hyz.setVisibility(8);
                    bVar.hyx.setTextColor(aj.getColor(d.C0108d.cp_cont_e));
                    bVar.hyx.setText("No");
                    bVar.hyx.setBackgroundDrawable(aj.getDrawable(d.f.bg_cover_text_border));
                    break;
                case 1:
                    bVar.hyx.setVisibility(0);
                    bVar.hyy.setVisibility(8);
                    bVar.hyz.setVisibility(8);
                    bVar.hyx.setTextColor(aj.getColor(d.C0108d.cp_cont_g));
                    bVar.hyx.setText("T");
                    bVar.hyx.setBackgroundColor(aj.getColor(d.C0108d.cp_link_tip_a));
                    break;
                case 2:
                    bVar.hyx.setVisibility(0);
                    bVar.hyy.setVisibility(8);
                    bVar.hyz.setVisibility(8);
                    bVar.hyx.setTextColor(aj.getColor(d.C0108d.cp_cont_g));
                    bVar.hyx.setText("T");
                    bVar.hyx.setBackgroundColor(aj.getColor(d.C0108d.cp_cont_d));
                    break;
                case 3:
                    bVar.hyx.setVisibility(0);
                    bVar.hyy.setVisibility(8);
                    bVar.hyz.setVisibility(8);
                    bVar.hyx.setTextColor(aj.getColor(d.C0108d.cp_cont_d));
                    bVar.hyx.setText("T");
                    bVar.hyx.setBackgroundDrawable(aj.getDrawable(d.f.bg_cover_text_border));
                    break;
                default:
                    bVar.hyx.setVisibility(8);
                    bVar.hyy.setVisibility(0);
                    bVar.hyz.setVisibility(8);
                    bVar.hyy.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0159a interfaceC0159a) {
        this.hyv = interfaceC0159a;
    }

    /* loaded from: classes2.dex */
    public class b {
        public TextView hyx;
        public TbImageView hyy;
        public ProgressBar hyz;

        public b() {
        }
    }
}
