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
    private List<EmotionImageData> cVu;
    private a fHJ;
    private EmotionView.a fHK;

    /* loaded from: classes2.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.z(this.cVu)) {
            return 0;
        }
        return this.cVu.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.cVu = list;
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_sug_emotion, (ViewGroup) null);
            c0210b2.fnw = (EmotionView) view.findViewById(d.g.emotion_view);
            c0210b2.fnw.apC();
            c0210b2.fnw.setController(this.fHK);
            c0210b2.fnw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fHJ != null && (view2 instanceof EmotionView)) {
                        b.this.fHJ.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0210b2);
            c0210b = c0210b2;
        } else {
            c0210b = (C0210b) view.getTag();
        }
        if (this.cVu != null && i >= 0 && i < this.cVu.size()) {
            c0210b.fnw.a(this.cVu.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.fHJ = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.fHK = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0210b {
        EmotionView fnw;

        C0210b() {
        }
    }
}
