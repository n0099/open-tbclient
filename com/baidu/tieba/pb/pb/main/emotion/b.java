package com.baidu.tieba.pb.pb.main.emotion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import java.util.List;
/* loaded from: classes9.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> gaF;
    private a iRq;
    private EmotionView.a iRr;

    /* loaded from: classes9.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.gaF)) {
            return 0;
        }
        return this.gaF.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.gaF = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0578b c0578b;
        if (view == null) {
            C0578b c0578b2 = new C0578b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
            c0578b2.iwg = (EmotionView) view.findViewById(R.id.emotion_view);
            c0578b2.iwg.bzR();
            c0578b2.iwg.setController(this.iRr);
            c0578b2.iwg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.iRq != null && (view2 instanceof EmotionView)) {
                        b.this.iRq.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0578b2);
            c0578b = c0578b2;
        } else {
            c0578b = (C0578b) view.getTag();
        }
        if (this.gaF != null && i >= 0 && i < this.gaF.size()) {
            c0578b.iwg.a(this.gaF.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.iRq = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.iRr = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    static class C0578b {
        EmotionView iwg;

        C0578b() {
        }
    }
}
