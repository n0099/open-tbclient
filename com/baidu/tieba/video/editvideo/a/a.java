package com.baidu.tieba.video.editvideo.a;

import android.support.media.ExifInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.PendantData;
import java.util.List;
/* loaded from: classes17.dex */
public class a extends BaseAdapter {
    private e dWk;
    private List<PendantData> mList;
    private InterfaceC0762a mdD;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public interface InterfaceC0762a {
        void a(View view, int i, PendantData pendantData);
    }

    public a(e eVar) {
        this.dWk = eVar;
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
            view = LayoutInflater.from(this.dWk.getPageActivity()).inflate(R.layout.layout_pendant_item, (ViewGroup) null);
            bVar = new b();
            bVar.mdF = (TextView) view.findViewById(R.id.cover_text);
            bVar.mdG = (TbImageView) view.findViewById(R.id.pendant_image);
            bVar.mdH = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
            bVar.mdG.setDefaultBgResource(R.color.transparent);
            bVar.mdG.setDefaultErrorResource(R.color.cp_cont_a);
            bVar.mdG.setDefaultResource(R.color.cp_cont_a);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.mdD != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.mdG.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.mdG.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.mdD.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
                            }
                        }
                    }
                }
            });
            view.setBackgroundColor(ao.getColor(R.color.cp_bg_line_d));
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        PendantData pendantData = this.mList.get(i);
        if (pendantData != null) {
            bVar.mdG.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.mdF.setVisibility(0);
                    bVar.mdG.setVisibility(8);
                    bVar.mdH.setVisibility(8);
                    bVar.mdF.setTextColor(ao.getColor(R.color.cp_cont_e));
                    bVar.mdF.setText("No");
                    bVar.mdF.setBackgroundDrawable(ao.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                case 1:
                    bVar.mdF.setVisibility(0);
                    bVar.mdG.setVisibility(8);
                    bVar.mdH.setVisibility(8);
                    bVar.mdF.setTextColor(ao.getColor(R.color.cp_cont_g));
                    bVar.mdF.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.mdF.setBackgroundColor(ao.getColor(R.color.cp_link_tip_a));
                    break;
                case 2:
                    bVar.mdF.setVisibility(0);
                    bVar.mdG.setVisibility(8);
                    bVar.mdH.setVisibility(8);
                    bVar.mdF.setTextColor(ao.getColor(R.color.cp_cont_g));
                    bVar.mdF.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.mdF.setBackgroundColor(ao.getColor(R.color.cp_cont_d));
                    break;
                case 3:
                    bVar.mdF.setVisibility(0);
                    bVar.mdG.setVisibility(8);
                    bVar.mdH.setVisibility(8);
                    bVar.mdF.setTextColor(ao.getColor(R.color.cp_cont_d));
                    bVar.mdF.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.mdF.setBackgroundDrawable(ao.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                default:
                    bVar.mdF.setVisibility(8);
                    bVar.mdG.setVisibility(0);
                    bVar.mdH.setVisibility(8);
                    bVar.mdG.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0762a interfaceC0762a) {
        this.mdD = interfaceC0762a;
    }

    /* loaded from: classes17.dex */
    public class b {
        public TextView mdF;
        public TbImageView mdG;
        public ProgressBar mdH;

        public b() {
        }
    }
}
