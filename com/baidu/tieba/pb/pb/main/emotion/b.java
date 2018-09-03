package com.baidu.tieba.pb.pb.main.emotion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> cVq;
    private a fHC;
    private EmotionView.a fHD;

    /* loaded from: classes2.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.z(this.cVq)) {
            return 0;
        }
        return this.cVq.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.cVq = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0210b c0210b;
        if (view == null) {
            C0210b c0210b2 = new C0210b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(f.h.list_sug_emotion, (ViewGroup) null);
            c0210b2.fnq = (EmotionView) view.findViewById(f.g.emotion_view);
            c0210b2.fnq.apC();
            c0210b2.fnq.setController(this.fHD);
            c0210b2.fnq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fHC != null && (view2 instanceof EmotionView)) {
                        b.this.fHC.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0210b2);
            c0210b = c0210b2;
        } else {
            c0210b = (C0210b) view.getTag();
        }
        if (this.cVq != null && i >= 0 && i < this.cVq.size()) {
            c0210b.fnq.a(this.cVq.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.fHC = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.fHD = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0210b {
        EmotionView fnq;

        C0210b() {
        }
    }
}
