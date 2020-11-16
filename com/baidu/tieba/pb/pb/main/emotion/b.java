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
/* loaded from: classes21.dex */
public class b extends BaseAdapter {
    private List<EmotionImageData> iup;
    private a lFd;
    private EmotionView.a lFe;

    /* loaded from: classes21.dex */
    public interface a {
        void d(EmotionImageData emotionImageData);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.iup)) {
            return 0;
        }
        return this.iup.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    public void setData(List<EmotionImageData> list) {
        this.iup = list;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0818b c0818b;
        if (view == null) {
            C0818b c0818b2 = new C0818b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_sug_emotion, (ViewGroup) null);
            c0818b2.lge = (EmotionView) view.findViewById(R.id.emotion_view);
            c0818b2.lge.ctE();
            c0818b2.lge.setController(this.lFe);
            c0818b2.lge.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.emotion.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (b.this.lFd != null && (view2 instanceof EmotionView)) {
                        b.this.lFd.d(((EmotionView) view2).getData());
                    }
                }
            });
            view.setTag(c0818b2);
            c0818b = c0818b2;
        } else {
            c0818b = (C0818b) view.getTag();
        }
        if (this.iup != null && i >= 0 && i < this.iup.size()) {
            c0818b.lge.a(this.iup.get(i));
        }
        return view;
    }

    public void a(a aVar) {
        this.lFd = aVar;
    }

    public void a(EmotionView.a aVar) {
        this.lFe = aVar;
    }

    /* renamed from: com.baidu.tieba.pb.pb.main.emotion.b$b  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    static class C0818b {
        EmotionView lge;

        C0818b() {
        }
    }
}
