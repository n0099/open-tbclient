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
/* loaded from: classes17.dex */
public class a extends BaseAdapter {
    private e efO;
    private List<PendantData> mList;
    private InterfaceC0814a mvI;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public interface InterfaceC0814a {
        void a(View view, int i, PendantData pendantData);
    }

    public a(e eVar) {
        this.efO = eVar;
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
            view = LayoutInflater.from(this.efO.getPageActivity()).inflate(R.layout.layout_pendant_item, (ViewGroup) null);
            bVar = new b();
            bVar.mvK = (TextView) view.findViewById(R.id.cover_text);
            bVar.mvL = (TbImageView) view.findViewById(R.id.pendant_image);
            bVar.mvM = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
            bVar.mvL.setDefaultBgResource(R.color.transparent);
            bVar.mvL.setDefaultErrorResource(R.color.cp_cont_a);
            bVar.mvL.setDefaultResource(R.color.cp_cont_a);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.mvI != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.mvL.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.mvL.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.mvI.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
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
            bVar.mvL.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.mvK.setVisibility(0);
                    bVar.mvL.setVisibility(8);
                    bVar.mvM.setVisibility(8);
                    bVar.mvK.setTextColor(ap.getColor(R.color.cp_cont_e));
                    bVar.mvK.setText("No");
                    bVar.mvK.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                case 1:
                    bVar.mvK.setVisibility(0);
                    bVar.mvL.setVisibility(8);
                    bVar.mvM.setVisibility(8);
                    bVar.mvK.setTextColor(ap.getColor(R.color.cp_cont_g));
                    bVar.mvK.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.mvK.setBackgroundColor(ap.getColor(R.color.cp_link_tip_a));
                    break;
                case 2:
                    bVar.mvK.setVisibility(0);
                    bVar.mvL.setVisibility(8);
                    bVar.mvM.setVisibility(8);
                    bVar.mvK.setTextColor(ap.getColor(R.color.cp_cont_g));
                    bVar.mvK.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.mvK.setBackgroundColor(ap.getColor(R.color.cp_cont_d));
                    break;
                case 3:
                    bVar.mvK.setVisibility(0);
                    bVar.mvL.setVisibility(8);
                    bVar.mvM.setVisibility(8);
                    bVar.mvK.setTextColor(ap.getColor(R.color.cp_cont_d));
                    bVar.mvK.setText(ExifInterface.GPS_DIRECTION_TRUE);
                    bVar.mvK.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                default:
                    bVar.mvK.setVisibility(8);
                    bVar.mvL.setVisibility(0);
                    bVar.mvM.setVisibility(8);
                    bVar.mvL.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0814a interfaceC0814a) {
        this.mvI = interfaceC0814a;
    }

    /* loaded from: classes17.dex */
    public class b {
        public TextView mvK;
        public TbImageView mvL;
        public ProgressBar mvM;

        public b() {
        }
    }
}
