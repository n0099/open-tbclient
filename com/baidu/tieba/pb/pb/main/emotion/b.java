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
    private List<EmotionImageData> cKs;
    private a fqU;
    private EmotionView.a fqV;

    /* loaded from: classes2.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.w(this.cKs)) {
            return 0;
        }
        return this.cKs.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.cKs = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        C0193b c0193b;
        if (view2 == null) {
            C0193b c0193b2 = new C0193b();
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.list_sug_emotion, (ViewGroup) null);
            c0193b2.eWN = (EmotionView) view2.findViewById(d.g.emotion_view);
            c0193b2.eWN.alB();
            c0193b2.eWN.setController(this.fqV);
            c0193b2.eWN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (b.this.fqU != null && (view3 instanceof EmotionView)) {
                        b.this.fqU.d(((EmotionView) view3).getData());
                    }
                }
            });
            view2.setTag(c0193b2);
            c0193b = c0193b2;
        } else {
            c0193b = (C0193b) view2.getTag();
        }
        if (this.cKs != null && i >= 0 && i < this.cKs.size()) {
            c0193b.eWN.a(this.cKs.get(i));
        }
        return view2;
    }

    public void a(a aVar) {
        this.fqU = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.fqV = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0193b {
        EmotionView eWN;

        C0193b() {
        }
    }
}
