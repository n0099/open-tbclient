package com.baidu.tieba.pb.pb.main.emotion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import java.util.List;
/* loaded from: classes7.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> fYD;
    private a iPT;
    private EmotionView.a iPU;

    /* loaded from: classes7.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.fYD)) {
            return 0;
        }
        return this.fYD.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.fYD = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0571b c0571b;
        if (view == null) {
            C0571b c0571b2 = new C0571b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
            c0571b2.iuj = (EmotionView) view.findViewById(R.id.emotion_view);
            c0571b2.iuj.byn();
            c0571b2.iuj.setController(this.iPU);
            c0571b2.iuj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.iPT != null && (view2 instanceof EmotionView)) {
                        b.this.iPT.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0571b2);
            c0571b = c0571b2;
        } else {
            c0571b = (C0571b) view.getTag();
        }
        if (this.fYD != null && i >= 0 && i < this.fYD.size()) {
            c0571b.iuj.a(this.fYD.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.iPT = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.iPU = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    static class C0571b {
        EmotionView iuj;

        C0571b() {
        }
    }
}
