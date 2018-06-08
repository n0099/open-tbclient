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
    private List<EmotionImageData> cUF;
    private a fDt;
    private EmotionView.a fDu;

    /* loaded from: classes2.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.z(this.cUF)) {
            return 0;
        }
        return this.cUF.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.cUF = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0209b c0209b;
        if (view == null) {
            C0209b c0209b2 = new C0209b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.list_sug_emotion, (ViewGroup) null);
            c0209b2.fjp = (EmotionView) view.findViewById(d.g.emotion_view);
            c0209b2.fjp.apH();
            c0209b2.fjp.setController(this.fDu);
            c0209b2.fjp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fDt != null && (view2 instanceof EmotionView)) {
                        b.this.fDt.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0209b2);
            c0209b = c0209b2;
        } else {
            c0209b = (C0209b) view.getTag();
        }
        if (this.cUF != null && i >= 0 && i < this.cUF.size()) {
            c0209b.fjp.a(this.cUF.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.fDt = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.fDu = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0209b {
        EmotionView fjp;

        C0209b() {
        }
    }
}
