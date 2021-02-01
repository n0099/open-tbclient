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
    private InterfaceC0885a nLZ;

    /* renamed from: com.baidu.tieba.video.editvideo.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0885a {
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
            bVar.nMb = (TextView) view.findViewById(R.id.cover_text);
            bVar.nMc = (TbImageView) view.findViewById(R.id.pendant_image);
            bVar.nMd = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
            bVar.nMc.setDefaultBgResource(R.color.transparent);
            bVar.nMc.setDefaultResource(R.color.CAM_X0101);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.editvideo.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.nLZ != null) {
                        b bVar2 = (b) view2.getTag();
                        if (bVar2.nMc.getTag() instanceof Integer) {
                            Integer num = (Integer) bVar2.nMc.getTag();
                            if (a.this.mList.size() > num.intValue()) {
                                a.this.nLZ.a(view2, num.intValue(), (PendantData) a.this.mList.get(num.intValue()));
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
            bVar.nMc.setTag(Integer.valueOf(i));
            switch (pendantData.pendantType) {
                case 0:
                    bVar.nMb.setVisibility(0);
                    bVar.nMc.setVisibility(8);
                    bVar.nMd.setVisibility(8);
                    bVar.nMb.setTextColor(ap.getColor(R.color.CAM_X0110));
                    bVar.nMb.setText("No");
                    bVar.nMb.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                case 1:
                    bVar.nMb.setVisibility(0);
                    bVar.nMc.setVisibility(8);
                    bVar.nMd.setVisibility(8);
                    bVar.nMb.setTextColor(ap.getColor(R.color.CAM_X0111));
                    bVar.nMb.setText("T");
                    bVar.nMb.setBackgroundColor(ap.getColor(R.color.CAM_X0302));
                    break;
                case 2:
                    bVar.nMb.setVisibility(0);
                    bVar.nMc.setVisibility(8);
                    bVar.nMd.setVisibility(8);
                    bVar.nMb.setTextColor(ap.getColor(R.color.CAM_X0111));
                    bVar.nMb.setText("T");
                    bVar.nMb.setBackgroundColor(ap.getColor(R.color.CAM_X0109));
                    break;
                case 3:
                    bVar.nMb.setVisibility(0);
                    bVar.nMc.setVisibility(8);
                    bVar.nMd.setVisibility(8);
                    bVar.nMb.setTextColor(ap.getColor(R.color.CAM_X0109));
                    bVar.nMb.setText("T");
                    bVar.nMb.setBackgroundDrawable(ap.getDrawable(R.drawable.bg_cover_text_border));
                    break;
                default:
                    bVar.nMb.setVisibility(8);
                    bVar.nMc.setVisibility(0);
                    bVar.nMd.setVisibility(8);
                    bVar.nMc.startLoad(pendantData.img, 10, false);
                    break;
            }
        }
        return view;
    }

    public void a(InterfaceC0885a interfaceC0885a) {
        this.nLZ = interfaceC0885a;
    }

    /* loaded from: classes8.dex */
    public class b {
        public TextView nMb;
        public TbImageView nMc;
        public ProgressBar nMd;

        public b() {
        }
    }
}
