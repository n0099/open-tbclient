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
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.PendantData;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {
    private InterfaceC0416a jpg;
    private List<PendantData> mList;
    private e mPageContext;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0416a {
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
            view = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.layout_pendant_item, (ViewGroup) null);
            bVar = new b();
            bVar.jpi = (TextView) view.findViewById(R.id.cover_text);
            bVar.jpj = (TbImageView) view.findViewById(R.id.pendant_image);
            bVar.jpk = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
            bVar.jpj.setDefaultBgResource(R.color.transparent);
            bVar.jpj.setDefaultErrorResource(R.color.cp_btn_a);
            bVar.jpj.setDefaultResource(R.color.cp_btn_a);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.jpg != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.jpj.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.jpj.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.jpg.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
                            }
                        }
                    }
                }
            });
            view.setBackgroundColor(al.getColor(R.color.cp_bg_line_d));
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        PendantData pendantData = this.mList.get(i);
        if (pendantData != null) {
            bVar.jpj.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.jpi.setVisibility(0);
                    bVar.jpj.setVisibility(8);
                    bVar.jpk.setVisibility(8);
                    bVar.jpi.setTextColor(al.getColor(R.color.cp_cont_e));
                    bVar.jpi.setText("No");
                    bVar.jpi.setBackgroundDrawable(al.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                case 1:
                    bVar.jpi.setVisibility(0);
                    bVar.jpj.setVisibility(8);
                    bVar.jpk.setVisibility(8);
                    bVar.jpi.setTextColor(al.getColor(R.color.cp_cont_g));
                    bVar.jpi.setText("T");
                    bVar.jpi.setBackgroundColor(al.getColor(R.color.cp_link_tip_a));
                    break;
                case 2:
                    bVar.jpi.setVisibility(0);
                    bVar.jpj.setVisibility(8);
                    bVar.jpk.setVisibility(8);
                    bVar.jpi.setTextColor(al.getColor(R.color.cp_cont_g));
                    bVar.jpi.setText("T");
                    bVar.jpi.setBackgroundColor(al.getColor(R.color.cp_cont_d));
                    break;
                case 3:
                    bVar.jpi.setVisibility(0);
                    bVar.jpj.setVisibility(8);
                    bVar.jpk.setVisibility(8);
                    bVar.jpi.setTextColor(al.getColor(R.color.cp_cont_d));
                    bVar.jpi.setText("T");
                    bVar.jpi.setBackgroundDrawable(al.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                default:
                    bVar.jpi.setVisibility(8);
                    bVar.jpj.setVisibility(0);
                    bVar.jpk.setVisibility(8);
                    bVar.jpj.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0416a interfaceC0416a) {
        this.jpg = interfaceC0416a;
    }

    /* loaded from: classes5.dex */
    public class b {
        public TextView jpi;
        public TbImageView jpj;
        public ProgressBar jpk;

        public b() {
        }
    }
}
