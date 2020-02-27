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
    private List<EmotionImageData> gaD;
    private a iRo;
    private EmotionView.a iRp;

    /* loaded from: classes9.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.gaD)) {
            return 0;
        }
        return this.gaD.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.gaD = list;
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
            c0578b2.iwe = (EmotionView) view.findViewById(R.id.emotion_view);
            c0578b2.iwe.bzP();
            c0578b2.iwe.setController(this.iRp);
            c0578b2.iwe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.iRo != null && (view2 instanceof EmotionView)) {
                        b.this.iRo.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0578b2);
            c0578b = c0578b2;
        } else {
            c0578b = (C0578b) view.getTag();
        }
        if (this.gaD != null && i >= 0 && i < this.gaD.size()) {
            c0578b.iwe.a(this.gaD.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.iRo = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.iRp = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    static class C0578b {
        EmotionView iwe;

        C0578b() {
        }
    }
}
