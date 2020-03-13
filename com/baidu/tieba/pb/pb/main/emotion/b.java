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
    private List<EmotionImageData> gaS;
    private a iRC;
    private EmotionView.a iRD;

    /* loaded from: classes9.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.gaS)) {
            return 0;
        }
        return this.gaS.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.gaS = list;
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
            c0578b2.iws = (EmotionView) view.findViewById(R.id.emotion_view);
            c0578b2.iws.bzS();
            c0578b2.iws.setController(this.iRD);
            c0578b2.iws.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.iRC != null && (view2 instanceof EmotionView)) {
                        b.this.iRC.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0578b2);
            c0578b = c0578b2;
        } else {
            c0578b = (C0578b) view.getTag();
        }
        if (this.gaS != null && i >= 0 && i < this.gaS.size()) {
            c0578b.iws.a(this.gaS.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.iRC = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.iRD = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    static class C0578b {
        EmotionView iws;

        C0578b() {
        }
    }
}
