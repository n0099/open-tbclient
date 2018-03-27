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
    private List<EmotionImageData> drE;
    private a fWS;
    private EmotionView.a fWT;

    /* loaded from: classes2.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.E(this.drE)) {
            return 0;
        }
        return this.drE.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.drE = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0212b c0212b;
        if (view == null) {
            C0212b c0212b2 = new C0212b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_sug_emotion, (ViewGroup) null);
            c0212b2.fCg = (EmotionView) view.findViewById(d.g.emotion_view);
            c0212b2.fCg.arl();
            c0212b2.fCg.setController(this.fWT);
            c0212b2.fCg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fWS != null && (view2 instanceof EmotionView)) {
                        b.this.fWS.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0212b2);
            c0212b = c0212b2;
        } else {
            c0212b = (C0212b) view.getTag();
        }
        if (this.drE != null && i >= 0 && i < this.drE.size()) {
            c0212b.fCg.a(this.drE.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.fWS = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.fWT = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0212b {
        EmotionView fCg;

        C0212b() {
        }
    }
}
