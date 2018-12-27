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
    private List<EmotionImageData> dtO;
    private a ghR;
    private EmotionView.a ghS;

    /* loaded from: classes6.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.I(this.dtO)) {
            return 0;
        }
        return this.dtO.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.dtO = list;
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
            c0287b2.fNw = (EmotionView) view.findViewById(e.g.emotion_view);
            c0287b2.fNw.awL();
            c0287b2.fNw.setController(this.ghS);
            c0287b2.fNw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.ghR != null && (view2 instanceof EmotionView)) {
                        b.this.ghR.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0287b2);
            c0287b = c0287b2;
        } else {
            c0287b = (C0287b) view.getTag();
        }
        if (this.dtO != null && i >= 0 && i < this.dtO.size()) {
            c0287b.fNw.a(this.dtO.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.ghR = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.ghS = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class C0287b {
        EmotionView fNw;

        C0287b() {
        }
    }
}
