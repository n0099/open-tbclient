package com.baidu.tieba.video.editvideo.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.base.f;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.PendantData;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private f eVB;
    private List<PendantData> mList;
    private InterfaceC0887a nMz;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0887a {
        void a(View view, int i, PendantData pendantData);
    }

    public a(f fVar) {
        this.eVB = fVar;
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
            view = LayoutInflater.from(this.eVB.getPageActivity()).inflate(R.layout.layout_pendant_item, (ViewGroup) null);
            bVar = new b();
            bVar.nMB = (TextView) view.findViewById(R.id.cover_text);
            bVar.nMC = (TbImageView) view.findViewById(R.id.pendant_image);
            bVar.nMD = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
            bVar.nMC.setDefaultBgResource(R.color.transparent);
            bVar.nMC.setDefaultResource(R.color.CAM_X0101);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.nMz != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.nMC.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.nMC.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.nMz.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
                            }
                        }
                    }
                }
            });
            view.setBackgroundColor(ap.getColor(R.color.CAM_X0201));
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        PendantData pendantData = this.mList.get(i);
        if (pendantData != null) {
            bVar.nMC.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.nMB.setVisibility(0);
                    bVar.nMC.setVisibility(8);
                    bVar.nMD.setVisibility(8);
                    bVar.nMB.setTextColor(ap.getColor(R.color.CAM_X0110));
                    bVar.nMB.setText("No");
                    bVar.nMB.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                case 1:
                    bVar.nMB.setVisibility(0);
                    bVar.nMC.setVisibility(8);
                    bVar.nMD.setVisibility(8);
                    bVar.nMB.setTextColor(ap.getColor(R.color.CAM_X0111));
                    bVar.nMB.setText("T");
                    bVar.nMB.setBackgroundColor(ap.getColor(R.color.CAM_X0302));
                    break;
                case 2:
                    bVar.nMB.setVisibility(0);
                    bVar.nMC.setVisibility(8);
                    bVar.nMD.setVisibility(8);
                    bVar.nMB.setTextColor(ap.getColor(R.color.CAM_X0111));
                    bVar.nMB.setText("T");
                    bVar.nMB.setBackgroundColor(ap.getColor(R.color.CAM_X0109));
                    break;
                case 3:
                    bVar.nMB.setVisibility(0);
                    bVar.nMC.setVisibility(8);
                    bVar.nMD.setVisibility(8);
                    bVar.nMB.setTextColor(ap.getColor(R.color.CAM_X0109));
                    bVar.nMB.setText("T");
                    bVar.nMB.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                default:
                    bVar.nMB.setVisibility(8);
                    bVar.nMC.setVisibility(0);
                    bVar.nMD.setVisibility(8);
                    bVar.nMC.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0887a interfaceC0887a) {
        this.nMz = interfaceC0887a;
    }

    /* loaded from: classes8.dex */
    public class b {
        public TextView nMB;
        public TbImageView nMC;
        public ProgressBar nMD;

        public b() {
        }
    }
}
