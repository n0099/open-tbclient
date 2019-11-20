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
    private e ceS;
    private InterfaceC0527a jxV;
    private List<PendantData> mList;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0527a {
        void a(View view, int i, PendantData pendantData);
    }

    public a(e eVar) {
        this.ceS = eVar;
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
            view = LayoutInflater.from(this.ceS.getPageActivity()).inflate(R.layout.layout_pendant_item, (ViewGroup) null);
            bVar = new b();
            bVar.jxX = (TextView) view.findViewById(R.id.cover_text);
            bVar.jxY = (TbImageView) view.findViewById(R.id.pendant_image);
            bVar.jxZ = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
            bVar.jxY.setDefaultBgResource(R.color.transparent);
            bVar.jxY.setDefaultErrorResource(R.color.cp_cont_a);
            bVar.jxY.setDefaultResource(R.color.cp_cont_a);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.jxV != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.jxY.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.jxY.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.jxV.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
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
            bVar.jxY.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.jxX.setVisibility(0);
                    bVar.jxY.setVisibility(8);
                    bVar.jxZ.setVisibility(8);
                    bVar.jxX.setTextColor(am.getColor(R.color.cp_cont_e));
                    bVar.jxX.setText("No");
                    bVar.jxX.setBackgroundDrawable(am.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                case 1:
                    bVar.jxX.setVisibility(0);
                    bVar.jxY.setVisibility(8);
                    bVar.jxZ.setVisibility(8);
                    bVar.jxX.setTextColor(am.getColor(R.color.cp_cont_g));
                    bVar.jxX.setText("T");
                    bVar.jxX.setBackgroundColor(am.getColor(R.color.cp_link_tip_a));
                    break;
                case 2:
                    bVar.jxX.setVisibility(0);
                    bVar.jxY.setVisibility(8);
                    bVar.jxZ.setVisibility(8);
                    bVar.jxX.setTextColor(am.getColor(R.color.cp_cont_g));
                    bVar.jxX.setText("T");
                    bVar.jxX.setBackgroundColor(am.getColor(R.color.cp_cont_d));
                    break;
                case 3:
                    bVar.jxX.setVisibility(0);
                    bVar.jxY.setVisibility(8);
                    bVar.jxZ.setVisibility(8);
                    bVar.jxX.setTextColor(am.getColor(R.color.cp_cont_d));
                    bVar.jxX.setText("T");
                    bVar.jxX.setBackgroundDrawable(am.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                default:
                    bVar.jxX.setVisibility(8);
                    bVar.jxY.setVisibility(0);
                    bVar.jxZ.setVisibility(8);
                    bVar.jxY.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0527a interfaceC0527a) {
        this.jxV = interfaceC0527a;
    }

    /* loaded from: classes5.dex */
    public class b {
        public TextView jxX;
        public TbImageView jxY;
        public ProgressBar jxZ;

        public b() {
        }
    }
}
