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
    private InterfaceC0752a lWn;
    private List<PendantData> mList;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0752a {
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
            bVar.lWp = (TextView) view.findViewById(R.id.cover_text);
            bVar.lWq = (TbImageView) view.findViewById(R.id.pendant_image);
            bVar.lWr = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
            bVar.lWq.setDefaultBgResource(R.color.transparent);
            bVar.lWq.setDefaultErrorResource(R.color.cp_cont_a);
            bVar.lWq.setDefaultResource(R.color.cp_cont_a);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.lWn != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.lWq.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.lWq.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.lWn.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
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
            bVar.lWq.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.lWp.setVisibility(0);
                    bVar.lWq.setVisibility(8);
                    bVar.lWr.setVisibility(8);
                    bVar.lWp.setTextColor(an.getColor(R.color.cp_cont_e));
                    bVar.lWp.setText("No");
                    bVar.lWp.setBackgroundDrawable(an.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                case 1:
                    bVar.lWp.setVisibility(0);
                    bVar.lWq.setVisibility(8);
                    bVar.lWr.setVisibility(8);
                    bVar.lWp.setTextColor(an.getColor(R.color.cp_cont_g));
                    bVar.lWp.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.lWp.setBackgroundColor(an.getColor(R.color.cp_link_tip_a));
                    break;
                case 2:
                    bVar.lWp.setVisibility(0);
                    bVar.lWq.setVisibility(8);
                    bVar.lWr.setVisibility(8);
                    bVar.lWp.setTextColor(an.getColor(R.color.cp_cont_g));
                    bVar.lWp.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.lWp.setBackgroundColor(an.getColor(R.color.cp_cont_d));
                    break;
                case 3:
                    bVar.lWp.setVisibility(0);
                    bVar.lWq.setVisibility(8);
                    bVar.lWr.setVisibility(8);
                    bVar.lWp.setTextColor(an.getColor(R.color.cp_cont_d));
                    bVar.lWp.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.lWp.setBackgroundDrawable(an.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                default:
                    bVar.lWp.setVisibility(8);
                    bVar.lWq.setVisibility(0);
                    bVar.lWr.setVisibility(8);
                    bVar.lWq.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0752a interfaceC0752a) {
        this.lWn = interfaceC0752a;
    }

    /* loaded from: classes10.dex */
    public class b {
        public TextView lWp;
        public TbImageView lWq;
        public ProgressBar lWr;

        public b() {
        }
    }
}
