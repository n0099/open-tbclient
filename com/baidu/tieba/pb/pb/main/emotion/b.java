package com.baidu.tieba.pb.pb.main.emotion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> dbj;
    private a fPi;
    private EmotionView.a fPj;

    /* loaded from: classes2.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.z(this.dbj)) {
            return 0;
        }
        return this.dbj.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.dbj = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0215b c0215b;
        if (view == null) {
            C0215b c0215b2 = new C0215b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.list_sug_emotion, (ViewGroup) null);
            c0215b2.fuN = (EmotionView) view.findViewById(e.g.emotion_view);
            c0215b2.fuN.arq();
            c0215b2.fuN.setController(this.fPj);
            c0215b2.fuN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fPi != null && (view2 instanceof EmotionView)) {
                        b.this.fPi.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0215b2);
            c0215b = c0215b2;
        } else {
            c0215b = (C0215b) view.getTag();
        }
        if (this.dbj != null && i >= 0 && i < this.dbj.size()) {
            c0215b.fuN.a(this.dbj.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.fPi = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.fPj = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0215b {
        EmotionView fuN;

        C0215b() {
        }
    }
}
