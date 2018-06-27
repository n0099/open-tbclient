package com.baidu.tieba.pb.pb.main.emotion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> cSH;
    private a fHu;
    private EmotionView.a fHv;

    /* loaded from: classes2.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.A(this.cSH)) {
            return 0;
        }
        return this.cSH.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.cSH = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0211b c0211b;
        if (view == null) {
            C0211b c0211b2 = new C0211b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.list_sug_emotion, (ViewGroup) null);
            c0211b2.fnl = (EmotionView) view.findViewById(d.g.emotion_view);
            c0211b2.fnl.apb();
            c0211b2.fnl.setController(this.fHv);
            c0211b2.fnl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fHu != null && (view2 instanceof EmotionView)) {
                        b.this.fHu.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0211b2);
            c0211b = c0211b2;
        } else {
            c0211b = (C0211b) view.getTag();
        }
        if (this.cSH != null && i >= 0 && i < this.cSH.size()) {
            c0211b.fnl.a(this.cSH.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.fHu = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.fHv = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0211b {
        EmotionView fnl;

        C0211b() {
        }
    }
}
