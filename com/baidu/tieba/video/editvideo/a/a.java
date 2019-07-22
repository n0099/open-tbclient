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
    private InterfaceC0415a jvr;
    private List<PendantData> mList;
    private e mPageContext;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0415a {
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
            bVar.jvt = (TextView) view.findViewById(R.id.cover_text);
            bVar.jvu = (TbImageView) view.findViewById(R.id.pendant_image);
            bVar.jvv = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
            bVar.jvu.setDefaultBgResource(R.color.transparent);
            bVar.jvu.setDefaultErrorResource(R.color.cp_btn_a);
            bVar.jvu.setDefaultResource(R.color.cp_btn_a);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.jvr != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.jvu.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.jvu.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.jvr.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
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
            bVar.jvu.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.jvt.setVisibility(0);
                    bVar.jvu.setVisibility(8);
                    bVar.jvv.setVisibility(8);
                    bVar.jvt.setTextColor(am.getColor(R.color.cp_cont_e));
                    bVar.jvt.setText("No");
                    bVar.jvt.setBackgroundDrawable(am.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                case 1:
                    bVar.jvt.setVisibility(0);
                    bVar.jvu.setVisibility(8);
                    bVar.jvv.setVisibility(8);
                    bVar.jvt.setTextColor(am.getColor(R.color.cp_cont_g));
                    bVar.jvt.setText("T");
                    bVar.jvt.setBackgroundColor(am.getColor(R.color.cp_link_tip_a));
                    break;
                case 2:
                    bVar.jvt.setVisibility(0);
                    bVar.jvu.setVisibility(8);
                    bVar.jvv.setVisibility(8);
                    bVar.jvt.setTextColor(am.getColor(R.color.cp_cont_g));
                    bVar.jvt.setText("T");
                    bVar.jvt.setBackgroundColor(am.getColor(R.color.cp_cont_d));
                    break;
                case 3:
                    bVar.jvt.setVisibility(0);
                    bVar.jvu.setVisibility(8);
                    bVar.jvv.setVisibility(8);
                    bVar.jvt.setTextColor(am.getColor(R.color.cp_cont_d));
                    bVar.jvt.setText("T");
                    bVar.jvt.setBackgroundDrawable(am.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                default:
                    bVar.jvt.setVisibility(8);
                    bVar.jvu.setVisibility(0);
                    bVar.jvv.setVisibility(8);
                    bVar.jvu.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0415a interfaceC0415a) {
        this.jvr = interfaceC0415a;
    }

    /* loaded from: classes5.dex */
    public class b {
        public TextView jvt;
        public TbImageView jvu;
        public ProgressBar jvv;

        public b() {
        }
    }
}
