package com.baidu.tieba.video.editvideo.a;

import android.support.media.ExifInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.PendantData;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private e dPR;
    private InterfaceC0751a lWk;
    private List<PendantData> mList;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0751a {
        void a(View view, int i, PendantData pendantData);
    }

    public a(e eVar) {
        this.dPR = eVar;
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
            view = LayoutInflater.from(this.dPR.getPageActivity()).inflate(R.layout.layout_pendant_item, (ViewGroup) null);
            bVar = new b();
            bVar.lWm = (TextView) view.findViewById(R.id.cover_text);
            bVar.lWn = (TbImageView) view.findViewById(R.id.pendant_image);
            bVar.lWo = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
            bVar.lWn.setDefaultBgResource(R.color.transparent);
            bVar.lWn.setDefaultErrorResource(R.color.cp_cont_a);
            bVar.lWn.setDefaultResource(R.color.cp_cont_a);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.lWk != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.lWn.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.lWn.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.lWk.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
                            }
                        }
                    }
                }
            });
            view.setBackgroundColor(an.getColor(R.color.cp_bg_line_d));
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        PendantData pendantData = this.mList.get(i);
        if (pendantData != null) {
            bVar.lWn.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.lWm.setVisibility(0);
                    bVar.lWn.setVisibility(8);
                    bVar.lWo.setVisibility(8);
                    bVar.lWm.setTextColor(an.getColor(R.color.cp_cont_e));
                    bVar.lWm.setText("No");
                    bVar.lWm.setBackgroundDrawable(an.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                case 1:
                    bVar.lWm.setVisibility(0);
                    bVar.lWn.setVisibility(8);
                    bVar.lWo.setVisibility(8);
                    bVar.lWm.setTextColor(an.getColor(R.color.cp_cont_g));
                    bVar.lWm.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.lWm.setBackgroundColor(an.getColor(R.color.cp_link_tip_a));
                    break;
                case 2:
                    bVar.lWm.setVisibility(0);
                    bVar.lWn.setVisibility(8);
                    bVar.lWo.setVisibility(8);
                    bVar.lWm.setTextColor(an.getColor(R.color.cp_cont_g));
                    bVar.lWm.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.lWm.setBackgroundColor(an.getColor(R.color.cp_cont_d));
                    break;
                case 3:
                    bVar.lWm.setVisibility(0);
                    bVar.lWn.setVisibility(8);
                    bVar.lWo.setVisibility(8);
                    bVar.lWm.setTextColor(an.getColor(R.color.cp_cont_d));
                    bVar.lWm.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.lWm.setBackgroundDrawable(an.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                default:
                    bVar.lWm.setVisibility(8);
                    bVar.lWn.setVisibility(0);
                    bVar.lWo.setVisibility(8);
                    bVar.lWn.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0751a interfaceC0751a) {
        this.lWk = interfaceC0751a;
    }

    /* loaded from: classes10.dex */
    public class b {
        public TextView lWm;
        public TbImageView lWn;
        public ProgressBar lWo;

        public b() {
        }
    }
}
