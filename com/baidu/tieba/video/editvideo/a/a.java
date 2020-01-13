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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private e cRA;
    private InterfaceC0611a kvt;
    private List<PendantData> mList;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0611a {
        void a(View view, int i, PendantData pendantData);
    }

    public a(e eVar) {
        this.cRA = eVar;
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
            view = LayoutInflater.from(this.cRA.getPageActivity()).inflate(R.layout.layout_pendant_item, (ViewGroup) null);
            bVar = new b();
            bVar.kvv = (TextView) view.findViewById(R.id.cover_text);
            bVar.kvw = (TbImageView) view.findViewById(R.id.pendant_image);
            bVar.kvx = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
            bVar.kvw.setDefaultBgResource(R.color.transparent);
            bVar.kvw.setDefaultErrorResource(R.color.cp_cont_a);
            bVar.kvw.setDefaultResource(R.color.cp_cont_a);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.kvt != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.kvw.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.kvw.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.kvt.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
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
            bVar.kvw.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.kvv.setVisibility(0);
                    bVar.kvw.setVisibility(8);
                    bVar.kvx.setVisibility(8);
                    bVar.kvv.setTextColor(am.getColor(R.color.cp_cont_e));
                    bVar.kvv.setText("No");
                    bVar.kvv.setBackgroundDrawable(am.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                case 1:
                    bVar.kvv.setVisibility(0);
                    bVar.kvw.setVisibility(8);
                    bVar.kvx.setVisibility(8);
                    bVar.kvv.setTextColor(am.getColor(R.color.cp_cont_g));
                    bVar.kvv.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.kvv.setBackgroundColor(am.getColor(R.color.cp_link_tip_a));
                    break;
                case 2:
                    bVar.kvv.setVisibility(0);
                    bVar.kvw.setVisibility(8);
                    bVar.kvx.setVisibility(8);
                    bVar.kvv.setTextColor(am.getColor(R.color.cp_cont_g));
                    bVar.kvv.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.kvv.setBackgroundColor(am.getColor(R.color.cp_cont_d));
                    break;
                case 3:
                    bVar.kvv.setVisibility(0);
                    bVar.kvw.setVisibility(8);
                    bVar.kvx.setVisibility(8);
                    bVar.kvv.setTextColor(am.getColor(R.color.cp_cont_d));
                    bVar.kvv.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.kvv.setBackgroundDrawable(am.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                default:
                    bVar.kvv.setVisibility(8);
                    bVar.kvw.setVisibility(0);
                    bVar.kvx.setVisibility(8);
                    bVar.kvw.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0611a interfaceC0611a) {
        this.kvt = interfaceC0611a;
    }

    /* loaded from: classes8.dex */
    public class b {
        public TextView kvv;
        public TbImageView kvw;
        public ProgressBar kvx;

        public b() {
        }
    }
}
