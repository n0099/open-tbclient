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
/* loaded from: classes4.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> fgP;
    private a hXq;
    private EmotionView.a hXr;

    /* loaded from: classes4.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.fgP)) {
            return 0;
        }
        return this.fgP.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.fgP = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0482b c0482b;
        if (view == null) {
            C0482b c0482b2 = new C0482b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
            c0482b2.hCC = (EmotionView) view.findViewById(R.id.emotion_view);
            c0482b2.hCC.bfQ();
            c0482b2.hCC.setController(this.hXr);
            c0482b2.hCC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.hXq != null && (view2 instanceof EmotionView)) {
                        b.this.hXq.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0482b2);
            c0482b = c0482b2;
        } else {
            c0482b = (C0482b) view.getTag();
        }
        if (this.fgP != null && i >= 0 && i < this.fgP.size()) {
            c0482b.hCC.a(this.fgP.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.hXq = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.hXr = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class C0482b {
        EmotionView hCC;

        C0482b() {
        }
    }
}
