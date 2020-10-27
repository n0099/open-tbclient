package com.baidu.tieba.pb.pb.main.emotion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import java.util.List;
/* loaded from: classes22.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> inE;
    private a lyQ;
    private EmotionView.a lyR;

    /* loaded from: classes22.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.inE)) {
            return 0;
        }
        return this.inE.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.inE = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0801b c0801b;
        if (view == null) {
            C0801b c0801b2 = new C0801b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
            c0801b2.kZP = (EmotionView) view.findViewById(R.id.emotion_view);
            c0801b2.kZP.crA();
            c0801b2.kZP.setController(this.lyR);
            c0801b2.kZP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.lyQ != null && (view2 instanceof EmotionView)) {
                        b.this.lyQ.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0801b2);
            c0801b = c0801b2;
        } else {
            c0801b = (C0801b) view.getTag();
        }
        if (this.inE != null && i >= 0 && i < this.inE.size()) {
            c0801b.kZP.a(this.inE.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.lyQ = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.lyR = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    static class C0801b {
        EmotionView kZP;

        C0801b() {
        }
    }
}
