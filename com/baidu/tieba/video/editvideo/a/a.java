package com.baidu.tieba.video.editvideo.a;

import android.support.media.ExifInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.PendantData;
import java.util.List;
/* loaded from: classes23.dex */
public class a extends BaseAdapter {
    private e eIz;
    private List<PendantData> mList;
    private InterfaceC0859a nnD;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public interface InterfaceC0859a {
        void a(View view, int i, PendantData pendantData);
    }

    public a(e eVar) {
        this.eIz = eVar;
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
            view = LayoutInflater.from(this.eIz.getPageActivity()).inflate(R.layout.layout_pendant_item, (ViewGroup) null);
            bVar = new b();
            bVar.nnF = (TextView) view.findViewById(R.id.cover_text);
            bVar.nnG = (TbImageView) view.findViewById(R.id.pendant_image);
            bVar.nnH = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
            bVar.nnG.setDefaultBgResource(R.color.transparent);
            bVar.nnG.setDefaultErrorResource(R.color.cp_cont_a);
            bVar.nnG.setDefaultResource(R.color.cp_cont_a);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.nnD != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.nnG.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.nnG.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.nnD.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
                            }
                        }
                    }
                }
            });
            view.setBackgroundColor(ap.getColor(R.color.cp_bg_line_d));
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        PendantData pendantData = this.mList.get(i);
        if (pendantData != null) {
            bVar.nnG.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.nnF.setVisibility(0);
                    bVar.nnG.setVisibility(8);
                    bVar.nnH.setVisibility(8);
                    bVar.nnF.setTextColor(ap.getColor(R.color.cp_cont_e));
                    bVar.nnF.setText("No");
                    bVar.nnF.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                case 1:
                    bVar.nnF.setVisibility(0);
                    bVar.nnG.setVisibility(8);
                    bVar.nnH.setVisibility(8);
                    bVar.nnF.setTextColor(ap.getColor(R.color.cp_cont_g));
                    bVar.nnF.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.nnF.setBackgroundColor(ap.getColor(R.color.cp_link_tip_a));
                    break;
                case 2:
                    bVar.nnF.setVisibility(0);
                    bVar.nnG.setVisibility(8);
                    bVar.nnH.setVisibility(8);
                    bVar.nnF.setTextColor(ap.getColor(R.color.cp_cont_g));
                    bVar.nnF.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.nnF.setBackgroundColor(ap.getColor(R.color.cp_cont_d));
                    break;
                case 3:
                    bVar.nnF.setVisibility(0);
                    bVar.nnG.setVisibility(8);
                    bVar.nnH.setVisibility(8);
                    bVar.nnF.setTextColor(ap.getColor(R.color.cp_cont_d));
                    bVar.nnF.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.nnF.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                default:
                    bVar.nnF.setVisibility(8);
                    bVar.nnG.setVisibility(0);
                    bVar.nnH.setVisibility(8);
                    bVar.nnG.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0859a interfaceC0859a) {
        this.nnD = interfaceC0859a;
    }

    /* loaded from: classes23.dex */
    public class b {
        public TextView nnF;
        public TbImageView nnG;
        public ProgressBar nnH;

        public b() {
        }
    }
}
