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
    private e cVR;
    private InterfaceC0620a kyo;
    private List<PendantData> mList;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0620a {
        void a(View view, int i, PendantData pendantData);
    }

    public a(e eVar) {
        this.cVR = eVar;
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
            view = LayoutInflater.from(this.cVR.getPageActivity()).inflate(R.layout.layout_pendant_item, (ViewGroup) null);
            bVar = new b();
            bVar.kyq = (TextView) view.findViewById(R.id.cover_text);
            bVar.kyr = (TbImageView) view.findViewById(R.id.pendant_image);
            bVar.kys = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
            bVar.kyr.setDefaultBgResource(R.color.transparent);
            bVar.kyr.setDefaultErrorResource(R.color.cp_cont_a);
            bVar.kyr.setDefaultResource(R.color.cp_cont_a);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.kyo != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.kyr.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.kyr.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.kyo.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
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
            bVar.kyr.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.kyq.setVisibility(0);
                    bVar.kyr.setVisibility(8);
                    bVar.kys.setVisibility(8);
                    bVar.kyq.setTextColor(am.getColor(R.color.cp_cont_e));
                    bVar.kyq.setText("No");
                    bVar.kyq.setBackgroundDrawable(am.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                case 1:
                    bVar.kyq.setVisibility(0);
                    bVar.kyr.setVisibility(8);
                    bVar.kys.setVisibility(8);
                    bVar.kyq.setTextColor(am.getColor(R.color.cp_cont_g));
                    bVar.kyq.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.kyq.setBackgroundColor(am.getColor(R.color.cp_link_tip_a));
                    break;
                case 2:
                    bVar.kyq.setVisibility(0);
                    bVar.kyr.setVisibility(8);
                    bVar.kys.setVisibility(8);
                    bVar.kyq.setTextColor(am.getColor(R.color.cp_cont_g));
                    bVar.kyq.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.kyq.setBackgroundColor(am.getColor(R.color.cp_cont_d));
                    break;
                case 3:
                    bVar.kyq.setVisibility(0);
                    bVar.kyr.setVisibility(8);
                    bVar.kys.setVisibility(8);
                    bVar.kyq.setTextColor(am.getColor(R.color.cp_cont_d));
                    bVar.kyq.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.kyq.setBackgroundDrawable(am.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                default:
                    bVar.kyq.setVisibility(8);
                    bVar.kyr.setVisibility(0);
                    bVar.kys.setVisibility(8);
                    bVar.kyr.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0620a interfaceC0620a) {
        this.kyo = interfaceC0620a;
    }

    /* loaded from: classes10.dex */
    public class b {
        public TextView kyq;
        public TbImageView kyr;
        public ProgressBar kys;

        public b() {
        }
    }
}
