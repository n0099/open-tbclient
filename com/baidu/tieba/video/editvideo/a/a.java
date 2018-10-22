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
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private InterfaceC0282a hsE;
    private List<PendantData> mList;
    private e mPageContext;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0282a {
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
            bVar.hsG = (TextView) view.findViewById(e.g.cover_text);
            bVar.hsH = (TbImageView) view.findViewById(e.g.pendant_image);
            bVar.hsI = (ProgressBar) view.findViewById(e.g.pendant_progressbar);
            bVar.hsH.setDefaultBgResource(e.d.transparent);
            bVar.hsH.setDefaultErrorResource(e.d.cp_cont_i);
            bVar.hsH.setDefaultResource(e.d.cp_cont_i);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.hsE != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.hsH.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.hsH.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.hsE.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
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
            bVar.hsH.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.hsG.setVisibility(0);
                    bVar.hsH.setVisibility(8);
                    bVar.hsI.setVisibility(8);
                    bVar.hsG.setTextColor(al.getColor(e.d.cp_cont_e));
                    bVar.hsG.setText("No");
                    bVar.hsG.setBackgroundDrawable(al.getDrawable(e.f.bg_cover_text_border));
                    break;
                case 1:
                    bVar.hsG.setVisibility(0);
                    bVar.hsH.setVisibility(8);
                    bVar.hsI.setVisibility(8);
                    bVar.hsG.setTextColor(al.getColor(e.d.cp_cont_g));
                    bVar.hsG.setText("T");
                    bVar.hsG.setBackgroundColor(al.getColor(e.d.cp_link_tip_a));
                    break;
                case 2:
                    bVar.hsG.setVisibility(0);
                    bVar.hsH.setVisibility(8);
                    bVar.hsI.setVisibility(8);
                    bVar.hsG.setTextColor(al.getColor(e.d.cp_cont_g));
                    bVar.hsG.setText("T");
                    bVar.hsG.setBackgroundColor(al.getColor(e.d.cp_cont_d));
                    break;
                case 3:
                    bVar.hsG.setVisibility(0);
                    bVar.hsH.setVisibility(8);
                    bVar.hsI.setVisibility(8);
                    bVar.hsG.setTextColor(al.getColor(e.d.cp_cont_d));
                    bVar.hsG.setText("T");
                    bVar.hsG.setBackgroundDrawable(al.getDrawable(e.f.bg_cover_text_border));
                    break;
                default:
                    bVar.hsG.setVisibility(8);
                    bVar.hsH.setVisibility(0);
                    bVar.hsI.setVisibility(8);
                    bVar.hsH.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0282a interfaceC0282a) {
        this.hsE = interfaceC0282a;
    }

    /* loaded from: classes5.dex */
    public class b {
        public TextView hsG;
        public TbImageView hsH;
        public ProgressBar hsI;

        public b() {
        }
    }
}
