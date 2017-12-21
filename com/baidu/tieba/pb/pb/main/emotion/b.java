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
    private List<EmotionImageData> cvC;
    private a feN;
    private EmotionView.a feO;

    /* loaded from: classes.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.w(this.cvC)) {
            return 0;
        }
        return this.cvC.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.cvC = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0131b c0131b;
        if (view == null) {
            C0131b c0131b2 = new C0131b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_sug_emotion, (ViewGroup) null);
            c0131b2.eKl = (EmotionView) view.findViewById(d.g.emotion_view);
            c0131b2.eKl.ahN();
            c0131b2.eKl.setController(this.feO);
            c0131b2.eKl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.feN != null && (view2 instanceof EmotionView)) {
                        b.this.feN.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0131b2);
            c0131b = c0131b2;
        } else {
            c0131b = (C0131b) view.getTag();
        }
        if (this.cvC != null && i >= 0 && i < this.cvC.size()) {
            c0131b.eKl.a(this.cvC.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.feN = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.feO = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0131b {
        EmotionView eKl;

        C0131b() {
        }
    }
}
