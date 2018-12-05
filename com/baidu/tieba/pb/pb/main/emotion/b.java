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
/* loaded from: classes6.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> dra;
    private a geZ;
    private EmotionView.a gfa;

    /* loaded from: classes6.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.I(this.dra)) {
            return 0;
        }
        return this.dra.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.dra = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0287b c0287b;
        if (view == null) {
            C0287b c0287b2 = new C0287b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.list_sug_emotion, (ViewGroup) null);
            c0287b2.fKE = (EmotionView) view.findViewById(e.g.emotion_view);
            c0287b2.fKE.avW();
            c0287b2.fKE.setController(this.gfa);
            c0287b2.fKE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.geZ != null && (view2 instanceof EmotionView)) {
                        b.this.geZ.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0287b2);
            c0287b = c0287b2;
        } else {
            c0287b = (C0287b) view.getTag();
        }
        if (this.dra != null && i >= 0 && i < this.dra.size()) {
            c0287b.fKE.a(this.dra.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.geZ = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.gfa = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class C0287b {
        EmotionView fKE;

        C0287b() {
        }
    }
}
