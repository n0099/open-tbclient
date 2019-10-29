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
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.PendantData;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private e cfJ;
    private InterfaceC0527a jyM;
    private List<PendantData> mList;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0527a {
        void a(View view, int i, PendantData pendantData);
    }

    public a(e eVar) {
        this.cfJ = eVar;
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
            view = LayoutInflater.from(this.cfJ.getPageActivity()).inflate(R.layout.layout_pendant_item, (ViewGroup) null);
            bVar = new b();
            bVar.jyO = (TextView) view.findViewById(R.id.cover_text);
            bVar.jyP = (TbImageView) view.findViewById(R.id.pendant_image);
            bVar.jyQ = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
            bVar.jyP.setDefaultBgResource(R.color.transparent);
            bVar.jyP.setDefaultErrorResource(R.color.cp_cont_a);
            bVar.jyP.setDefaultResource(R.color.cp_cont_a);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.jyM != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.jyP.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.jyP.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.jyM.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
                            }
                        }
                    }
                }
            });
            view.setBackgroundColor(am.getColor(R.color.cp_bg_line_d));
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        PendantData pendantData = this.mList.get(i);
        if (pendantData != null) {
            bVar.jyP.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.jyO.setVisibility(0);
                    bVar.jyP.setVisibility(8);
                    bVar.jyQ.setVisibility(8);
                    bVar.jyO.setTextColor(am.getColor(R.color.cp_cont_e));
                    bVar.jyO.setText("No");
                    bVar.jyO.setBackgroundDrawable(am.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                case 1:
                    bVar.jyO.setVisibility(0);
                    bVar.jyP.setVisibility(8);
                    bVar.jyQ.setVisibility(8);
                    bVar.jyO.setTextColor(am.getColor(R.color.cp_cont_g));
                    bVar.jyO.setText("T");
                    bVar.jyO.setBackgroundColor(am.getColor(R.color.cp_link_tip_a));
                    break;
                case 2:
                    bVar.jyO.setVisibility(0);
                    bVar.jyP.setVisibility(8);
                    bVar.jyQ.setVisibility(8);
                    bVar.jyO.setTextColor(am.getColor(R.color.cp_cont_g));
                    bVar.jyO.setText("T");
                    bVar.jyO.setBackgroundColor(am.getColor(R.color.cp_cont_d));
                    break;
                case 3:
                    bVar.jyO.setVisibility(0);
                    bVar.jyP.setVisibility(8);
                    bVar.jyQ.setVisibility(8);
                    bVar.jyO.setTextColor(am.getColor(R.color.cp_cont_d));
                    bVar.jyO.setText("T");
                    bVar.jyO.setBackgroundDrawable(am.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                default:
                    bVar.jyO.setVisibility(8);
                    bVar.jyP.setVisibility(0);
                    bVar.jyQ.setVisibility(8);
                    bVar.jyP.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0527a interfaceC0527a) {
        this.jyM = interfaceC0527a;
    }

    /* loaded from: classes5.dex */
    public class b {
        public TextView jyO;
        public TbImageView jyP;
        public ProgressBar jyQ;

        public b() {
        }
    }
}
