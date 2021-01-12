package com.baidu.tieba.pb.pb.main.emotion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> iMO;
    private a lTF;
    private EmotionView.a lTG;

    /* loaded from: classes2.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (x.isEmpty(this.iMO)) {
            return 0;
        }
        return this.iMO.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.iMO = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0834b c0834b;
        if (view == null) {
            C0834b c0834b2 = new C0834b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
            c0834b2.lui = (EmotionView) view.findViewById(R.id.emotion_view);
            c0834b2.lui.cwW();
            c0834b2.lui.setController(this.lTG);
            c0834b2.lui.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.lTF != null && (view2 instanceof EmotionView)) {
                        b.this.lTF.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0834b2);
            c0834b = c0834b2;
        } else {
            c0834b = (C0834b) view.getTag();
        }
        if (this.iMO != null && i >= 0 && i < this.iMO.size()) {
            c0834b.lui.a(this.iMO.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.lTF = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.lTG = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0834b {
        EmotionView lui;

        C0834b() {
        }
    }
}
