package com.baidu.tieba.pb.pb.main.emotion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> doz;
    private a fTg;
    private EmotionView.a fTh;

    /* loaded from: classes2.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.E(this.doz)) {
            return 0;
        }
        return this.doz.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.doz = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0142b c0142b;
        if (view == null) {
            C0142b c0142b2 = new C0142b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_sug_emotion, (ViewGroup) null);
            c0142b2.fyh = (EmotionView) view.findViewById(d.g.emotion_view);
            c0142b2.fyh.aqq();
            c0142b2.fyh.setController(this.fTh);
            c0142b2.fyh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fTg != null && (view2 instanceof EmotionView)) {
                        b.this.fTg.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0142b2);
            c0142b = c0142b2;
        } else {
            c0142b = (C0142b) view.getTag();
        }
        if (this.doz != null && i >= 0 && i < this.doz.size()) {
            c0142b.fyh.a(this.doz.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.fTg = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.fTh = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0142b {
        EmotionView fyh;

        C0142b() {
        }
    }
}
