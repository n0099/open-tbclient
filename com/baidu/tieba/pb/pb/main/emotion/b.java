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
    private List<EmotionImageData> iFh;
    private a lSW;
    private EmotionView.a lSX;

    /* loaded from: classes22.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.iFh)) {
            return 0;
        }
        return this.iFh.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.iFh = list;
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
            c0834b2.ltE = (EmotionView) view.findViewById(R.id.emotion_view);
            c0834b2.ltE.cxT();
            c0834b2.ltE.setController(this.lSX);
            c0834b2.ltE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.lSW != null && (view2 instanceof EmotionView)) {
                        b.this.lSW.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0834b2);
            c0834b = c0834b2;
        } else {
            c0834b = (C0834b) view.getTag();
        }
        if (this.iFh != null && i >= 0 && i < this.iFh.size()) {
            c0834b.ltE.a(this.iFh.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.lSW = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.lSX = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    static class C0834b {
        EmotionView ltE;

        C0834b() {
        }
    }
}
