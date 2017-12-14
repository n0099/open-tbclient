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
/* loaded from: classes.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> cvy;
    private a feI;
    private EmotionView.a feJ;

    /* loaded from: classes.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.w(this.cvy)) {
            return 0;
        }
        return this.cvy.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.cvy = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0132b c0132b;
        if (view == null) {
            C0132b c0132b2 = new C0132b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_sug_emotion, (ViewGroup) null);
            c0132b2.eKh = (EmotionView) view.findViewById(d.g.emotion_view);
            c0132b2.eKh.ahO();
            c0132b2.eKh.setController(this.feJ);
            c0132b2.eKh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.feI != null && (view2 instanceof EmotionView)) {
                        b.this.feI.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0132b2);
            c0132b = c0132b2;
        } else {
            c0132b = (C0132b) view.getTag();
        }
        if (this.cvy != null && i >= 0 && i < this.cvy.size()) {
            c0132b.eKh.a(this.cvy.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.feI = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.feJ = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0132b {
        EmotionView eKh;

        C0132b() {
        }
    }
}
