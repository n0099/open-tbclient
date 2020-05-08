package com.baidu.tieba.video.editvideo.a;

import android.support.media.ExifInterface;
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
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private e dvg;
    private InterfaceC0682a liH;
    private List<PendantData> mList;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0682a {
        void a(View view, int i, PendantData pendantData);
    }

    public a(e eVar) {
        this.dvg = eVar;
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
            view = LayoutInflater.from(this.dvg.getPageActivity()).inflate(R.layout.layout_pendant_item, (ViewGroup) null);
            bVar = new b();
            bVar.liJ = (TextView) view.findViewById(R.id.cover_text);
            bVar.liK = (TbImageView) view.findViewById(R.id.pendant_image);
            bVar.liL = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
            bVar.liK.setDefaultBgResource(R.color.transparent);
            bVar.liK.setDefaultErrorResource(R.color.cp_cont_a);
            bVar.liK.setDefaultResource(R.color.cp_cont_a);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.liH != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.liK.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.liK.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.liH.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
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
            bVar.liK.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.liJ.setVisibility(0);
                    bVar.liK.setVisibility(8);
                    bVar.liL.setVisibility(8);
                    bVar.liJ.setTextColor(am.getColor(R.color.cp_cont_e));
                    bVar.liJ.setText("No");
                    bVar.liJ.setBackgroundDrawable(am.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                case 1:
                    bVar.liJ.setVisibility(0);
                    bVar.liK.setVisibility(8);
                    bVar.liL.setVisibility(8);
                    bVar.liJ.setTextColor(am.getColor(R.color.cp_cont_g));
                    bVar.liJ.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.liJ.setBackgroundColor(am.getColor(R.color.cp_link_tip_a));
                    break;
                case 2:
                    bVar.liJ.setVisibility(0);
                    bVar.liK.setVisibility(8);
                    bVar.liL.setVisibility(8);
                    bVar.liJ.setTextColor(am.getColor(R.color.cp_cont_g));
                    bVar.liJ.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.liJ.setBackgroundColor(am.getColor(R.color.cp_cont_d));
                    break;
                case 3:
                    bVar.liJ.setVisibility(0);
                    bVar.liK.setVisibility(8);
                    bVar.liL.setVisibility(8);
                    bVar.liJ.setTextColor(am.getColor(R.color.cp_cont_d));
                    bVar.liJ.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.liJ.setBackgroundDrawable(am.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                default:
                    bVar.liJ.setVisibility(8);
                    bVar.liK.setVisibility(0);
                    bVar.liL.setVisibility(8);
                    bVar.liK.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0682a interfaceC0682a) {
        this.liH = interfaceC0682a;
    }

    /* loaded from: classes10.dex */
    public class b {
        public TextView liJ;
        public TbImageView liK;
        public ProgressBar liL;

        public b() {
        }
    }
}
