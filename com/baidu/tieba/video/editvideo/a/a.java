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
    private InterfaceC0241a hdv;
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
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(d.h.layout_pendant_item, (ViewGroup) null);
            bVar = new b();
            bVar.hdx = (TextView) view.findViewById(d.g.cover_text);
            bVar.hdy = (TbImageView) view.findViewById(d.g.pendant_image);
            bVar.hdz = (ProgressBar) view.findViewById(d.g.pendant_progressbar);
            bVar.hdy.setDefaultBgResource(d.C0140d.transparent);
            bVar.hdy.setDefaultErrorResource(d.C0140d.cp_cont_i);
            bVar.hdy.setDefaultResource(d.C0140d.cp_cont_i);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.hdv != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.hdy.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.hdy.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.hdv.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
                            }
                        }
                    }
                }
            });
            view.setBackgroundColor(am.getColor(d.C0140d.cp_bg_line_d));
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        PendantData pendantData = this.mList.get(i);
        if (pendantData != null) {
            bVar.hdy.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.hdx.setVisibility(0);
                    bVar.hdy.setVisibility(8);
                    bVar.hdz.setVisibility(8);
                    bVar.hdx.setTextColor(am.getColor(d.C0140d.cp_cont_e));
                    bVar.hdx.setText("No");
                    bVar.hdx.setBackgroundDrawable(am.getDrawable(d.f.bg_cover_text_border));
                    break;
                case 1:
                    bVar.hdx.setVisibility(0);
                    bVar.hdy.setVisibility(8);
                    bVar.hdz.setVisibility(8);
                    bVar.hdx.setTextColor(am.getColor(d.C0140d.cp_cont_g));
                    bVar.hdx.setText("T");
                    bVar.hdx.setBackgroundColor(am.getColor(d.C0140d.cp_link_tip_a));
                    break;
                case 2:
                    bVar.hdx.setVisibility(0);
                    bVar.hdy.setVisibility(8);
                    bVar.hdz.setVisibility(8);
                    bVar.hdx.setTextColor(am.getColor(d.C0140d.cp_cont_g));
                    bVar.hdx.setText("T");
                    bVar.hdx.setBackgroundColor(am.getColor(d.C0140d.cp_cont_d));
                    break;
                case 3:
                    bVar.hdx.setVisibility(0);
                    bVar.hdy.setVisibility(8);
                    bVar.hdz.setVisibility(8);
                    bVar.hdx.setTextColor(am.getColor(d.C0140d.cp_cont_d));
                    bVar.hdx.setText("T");
                    bVar.hdx.setBackgroundDrawable(am.getDrawable(d.f.bg_cover_text_border));
                    break;
                default:
                    bVar.hdx.setVisibility(8);
                    bVar.hdy.setVisibility(0);
                    bVar.hdz.setVisibility(8);
                    bVar.hdy.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0241a interfaceC0241a) {
        this.hdv = interfaceC0241a;
    }

    /* loaded from: classes2.dex */
    public class b {
        public TextView hdx;
        public TbImageView hdy;
        public ProgressBar hdz;

        public b() {
        }
    }
}
