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
    private e cVC;
    private InterfaceC0619a kwv;
    private List<PendantData> mList;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0619a {
        void a(View view, int i, PendantData pendantData);
    }

    public a(e eVar) {
        this.cVC = eVar;
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
            view = LayoutInflater.from(this.cVC.getPageActivity()).inflate(R.layout.layout_pendant_item, (ViewGroup) null);
            bVar = new b();
            bVar.kwx = (TextView) view.findViewById(R.id.cover_text);
            bVar.kwy = (TbImageView) view.findViewById(R.id.pendant_image);
            bVar.kwz = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
            bVar.kwy.setDefaultBgResource(R.color.transparent);
            bVar.kwy.setDefaultErrorResource(R.color.cp_cont_a);
            bVar.kwy.setDefaultResource(R.color.cp_cont_a);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.kwv != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.kwy.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.kwy.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.kwv.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
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
            bVar.kwy.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.kwx.setVisibility(0);
                    bVar.kwy.setVisibility(8);
                    bVar.kwz.setVisibility(8);
                    bVar.kwx.setTextColor(am.getColor(R.color.cp_cont_e));
                    bVar.kwx.setText("No");
                    bVar.kwx.setBackgroundDrawable(am.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                case 1:
                    bVar.kwx.setVisibility(0);
                    bVar.kwy.setVisibility(8);
                    bVar.kwz.setVisibility(8);
                    bVar.kwx.setTextColor(am.getColor(R.color.cp_cont_g));
                    bVar.kwx.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.kwx.setBackgroundColor(am.getColor(R.color.cp_link_tip_a));
                    break;
                case 2:
                    bVar.kwx.setVisibility(0);
                    bVar.kwy.setVisibility(8);
                    bVar.kwz.setVisibility(8);
                    bVar.kwx.setTextColor(am.getColor(R.color.cp_cont_g));
                    bVar.kwx.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.kwx.setBackgroundColor(am.getColor(R.color.cp_cont_d));
                    break;
                case 3:
                    bVar.kwx.setVisibility(0);
                    bVar.kwy.setVisibility(8);
                    bVar.kwz.setVisibility(8);
                    bVar.kwx.setTextColor(am.getColor(R.color.cp_cont_d));
                    bVar.kwx.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.kwx.setBackgroundDrawable(am.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                default:
                    bVar.kwx.setVisibility(8);
                    bVar.kwy.setVisibility(0);
                    bVar.kwz.setVisibility(8);
                    bVar.kwy.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0619a interfaceC0619a) {
        this.kwv = interfaceC0619a;
    }

    /* loaded from: classes10.dex */
    public class b {
        public TextView kwx;
        public TbImageView kwy;
        public ProgressBar kwz;

        public b() {
        }
    }
}
