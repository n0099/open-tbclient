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
    private List<EmotionImageData> cvp;
    private a fdH;
    private EmotionView.a fdI;

    /* loaded from: classes.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.w(this.cvp)) {
            return 0;
        }
        return this.cvp.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.cvp = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0117b c0117b;
        if (view == null) {
            C0117b c0117b2 = new C0117b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_sug_emotion, (ViewGroup) null);
            c0117b2.eJd = (EmotionView) view.findViewById(d.g.emotion_view);
            c0117b2.eJd.ahG();
            c0117b2.eJd.setController(this.fdI);
            c0117b2.eJd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.fdH != null && (view2 instanceof EmotionView)) {
                        b.this.fdH.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0117b2);
            c0117b = c0117b2;
        } else {
            c0117b = (C0117b) view.getTag();
        }
        if (this.cvp != null && i >= 0 && i < this.cvp.size()) {
            c0117b.eJd.a(this.cvp.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.fdH = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.fdI = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0117b {
        EmotionView eJd;

        C0117b() {
        }
    }
}
