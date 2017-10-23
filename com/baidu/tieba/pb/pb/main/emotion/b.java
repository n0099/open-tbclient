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
    private List<EmotionImageData> ceO;
    private a eLY;
    private EmotionView.a eLZ;

    /* loaded from: classes.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.u(this.ceO)) {
            return 0;
        }
        return this.ceO.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.ceO = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0114b c0114b;
        if (view == null) {
            C0114b c0114b2 = new C0114b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.j.list_sug_emotion, (ViewGroup) null);
            c0114b2.eum = (EmotionView) view.findViewById(d.h.emotion_view);
            c0114b2.eum.adA();
            c0114b2.eum.setController(this.eLZ);
            c0114b2.eum.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.eLY != null && (view2 instanceof EmotionView)) {
                        b.this.eLY.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0114b2);
            c0114b = c0114b2;
        } else {
            c0114b = (C0114b) view.getTag();
        }
        if (this.ceO != null && i >= 0 && i < this.ceO.size()) {
            c0114b.eum.a(this.ceO.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.eLY = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.eLZ = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0114b {
        EmotionView eum;

        C0114b() {
        }
    }
}
